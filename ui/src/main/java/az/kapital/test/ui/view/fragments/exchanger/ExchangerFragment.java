package az.kapital.test.ui.view.fragments.exchanger;

import android.text.SpannableStringBuilder;

import java.util.List;

import javax.inject.Inject;

import az.kapital.test.domain.model.News;
import az.kapital.test.ui.base.BaseFragment;
import az.kapital.test.ui.base.callback.FragmentBindingCallback;
import az.kapital.test.ui.contractor.ExchangerContractor;
import az.kapital.test.ui.databinding.FragmentExchangerBinding;
import az.kapital.test.ui.view.fragments.exchanger.adapter.NewsListAdapter;

public class ExchangerFragment extends BaseFragment<ExchangerContractor.Presenter, FragmentExchangerBinding> implements ExchangerContractor.View {

    public static final String RC_BASE_CURRENCY = "base";
    public static final String RC_TARGET_CURRENCY = "target";

    public static final String CURRENCY_TAG = "currency code";

    @Inject
    NewsListAdapter newsListAdapter;

    @Override
    protected FragmentBindingCallback<FragmentExchangerBinding> getBindingCallback() {
        return FragmentExchangerBinding::inflate;
    }

    private FragmentExchangerBinding ui;

    @Override
    protected void onReadyUI(FragmentExchangerBinding ui) {
        this.ui = ui;

        getParentFragmentManager().setFragmentResultListener(RC_BASE_CURRENCY, this, (requestKey, result) -> {
            String code = result.getString(CURRENCY_TAG);
            ui.buttonBaseSelector.setText(code);
            presenter.setBaseCurrency(code);
        });

        getParentFragmentManager().setFragmentResultListener(RC_TARGET_CURRENCY, this, (requestKey, result) -> {
            String code = result.getString(CURRENCY_TAG);
            ui.buttonTargetSelector.setText(code);
            presenter.setTargetCurrency(code);
        });

        ui.recyclerViewNews.setAdapter(newsListAdapter);

        ui.buttonBaseSelector.setOnClickListener(view -> {
            getNavController().navigate(ExchangerFragmentDirections.toCurrencySelector(true));
        });

        ui.buttonTargetSelector.setOnClickListener(view -> {
            getNavController().navigate(ExchangerFragmentDirections.toCurrencySelector(false));
        });

        ui.buttonConvert.setOnClickListener(view -> {
            String input = ui.inputLayoutBaseAmount.getEditText().getText().toString();
            if (input.isEmpty()) presenter.calculateTargetAmount("0");
            else presenter.calculateTargetAmount(input);
        });

    }

    @Override
    protected void onCreateState() {
        super.onCreateState();
        presenter.keepCurrenciesUpdatedOnUI();
    }

    @Override
    protected void onStartState() {
        presenter.getBaseCurrencyNews();
    }

    @Override
    public void showBaseCurrencyNews(List<News> items) {
        newsListAdapter.submitList(items);
    }

    @Override
    public void showTargetAmount(String amount) {
        SpannableStringBuilder content = new SpannableStringBuilder(amount);
        getUi().inputLayoutTargetAmount.getEditText().setText(content);
    }

    @Override
    public void setBaseCurrencyCode(String code) {
        getUi().buttonBaseSelector.setText(code);
    }

    @Override
    public void setTargetCurrencyCode(String code) {
        getUi().buttonTargetSelector.setText(code);
    }

    @Override
    public void handleError(Throwable error) {
        super.error(error);
    }

    @Override
    public void handleLoading(boolean isLoading) {
        super.loading(isLoading);
    }

}