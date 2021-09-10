package az.kapital.test.ui.presenter;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import az.kapital.test.domain.model.ConversionResult;
import az.kapital.test.domain.model.News;
import az.kapital.test.domain.usecases.ConvertUseCase;
import az.kapital.test.domain.usecases.GetNewsUseCase;
import az.kapital.test.ui.base.BasePresenter;
import az.kapital.test.ui.base.callback.PresenterAsyncCall;
import az.kapital.test.ui.contractor.ExchangerContractor;
import io.reactivex.rxjava3.core.Flowable;

public class ExchangerPresenter extends BasePresenter<ExchangerContractor.View> implements ExchangerContractor.Presenter {

    private final GetNewsUseCase getNewsUseCase;
    private final ConvertUseCase convertUseCase;

    private String from = "AZN";
    private String to = "USD";

    @Inject
    public ExchangerPresenter(
            ExchangerContractor.View view,
            GetNewsUseCase getNewsUseCase,
            ConvertUseCase convertUseCase
    ) {
        super.setView(view);
        this.getNewsUseCase = getNewsUseCase;
        this.convertUseCase = convertUseCase;
    }

    @Override
    public void getBaseCurrencyNews() {

        request(new PresenterAsyncCall<List<News>>() {

            @Override
            public Flowable<List<News>> async() {
                return getNewsUseCase.execute(new GetNewsUseCase.Params());
            }

            @Override
            public void onNext(List<News> items) {
                getView().showBaseCurrencyNews(items);
            }

        });

    }

    @Override
    public void calculateTargetAmount(String value) {

        request(new PresenterAsyncCall<ConversionResult>() {

            @Override
            public Flowable<ConversionResult> async() {
                return convertUseCase.execute(new ConvertUseCase.Params(from, to, value));
            }

            @Override
            public void onNext(ConversionResult item) {
                getView().showTargetAmount(item.getRateForAmount());
            }

        });

    }

    @Override
    public void setBaseCurrency(String code) {
        from = code;
        showCurrencyCodes();
    }

    @Override
    public void setTargetCurrency(String code) {
        to = code;
        showCurrencyCodes();
    }

    @Override
    public void keepCurrenciesUpdatedOnUI() {
        getView().setBaseCurrencyCode(from);
        getView().setTargetCurrencyCode(to);
    }

    private void showCurrencyCodes() {
        Log.i("ExchangerPresenter", from + " to " + to);
    }

    @Override
    public void onDestroy() {
        super.destroyAll();
    }

}