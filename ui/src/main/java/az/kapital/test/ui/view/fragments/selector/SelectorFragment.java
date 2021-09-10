package az.kapital.test.ui.view.fragments.selector;

import android.os.Bundle;

import java.util.List;

import javax.inject.Inject;

import az.kapital.test.domain.model.Currency;
import az.kapital.test.ui.base.BaseFragment;
import az.kapital.test.ui.base.callback.FragmentBindingCallback;
import az.kapital.test.ui.contractor.SelectorContractor;
import az.kapital.test.ui.databinding.FragmentSelectorBinding;
import az.kapital.test.ui.view.fragments.exchanger.ExchangerFragment;
import az.kapital.test.ui.view.fragments.selector.adapter.CurrenciesListAdapter;

public class SelectorFragment extends BaseFragment<SelectorContractor.Presenter, FragmentSelectorBinding> implements SelectorContractor.View {

    @Inject
    CurrenciesListAdapter currenciesListAdapter;

    @Override
    protected FragmentBindingCallback<FragmentSelectorBinding> getBindingCallback() {
        return FragmentSelectorBinding::inflate;
    }

    @Override
    protected void onCreateState() {
        presenter.getAllCurrencies();
    }

    @Override
    protected void onReadyUI(FragmentSelectorBinding ui) {

        currenciesListAdapter.setListener(currency -> {
            Bundle bundle = new Bundle();
            bundle.putString(ExchangerFragment.CURRENCY_TAG, currency.key());
            if (getArguments().getBoolean("isBaseSelection")) {
                getParentFragmentManager().setFragmentResult(ExchangerFragment.RC_BASE_CURRENCY, bundle);
            } else {
                getParentFragmentManager().setFragmentResult(ExchangerFragment.RC_TARGET_CURRENCY, bundle);
            }
            getNavController().popBackStack();
        });
        ui.recyclerViewCurrencies.setAdapter(currenciesListAdapter);

    }

    @Override
    public void showAllCurrencies(List<Currency> items) {
        currenciesListAdapter.submitList(items);
    }

    @Override
    public void handleLoading(boolean isLoading) {
        super.loading(isLoading);
    }

    @Override
    public void handleError(Throwable error) {
        super.error(error);
    }

}