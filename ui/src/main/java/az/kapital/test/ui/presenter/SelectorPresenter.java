package az.kapital.test.ui.presenter;

import java.util.List;

import javax.inject.Inject;

import az.kapital.test.domain.model.Currency;
import az.kapital.test.domain.usecases.GetAllCurrenciesUseCase;
import az.kapital.test.ui.base.BasePresenter;
import az.kapital.test.ui.base.callback.PresenterAsyncCall;
import az.kapital.test.ui.contractor.SelectorContractor;
import io.reactivex.rxjava3.core.Flowable;

public class SelectorPresenter extends BasePresenter<SelectorContractor.View> implements SelectorContractor.Presenter {

    private final GetAllCurrenciesUseCase getAllCurrenciesUseCase;

    @Inject
    public SelectorPresenter(
            SelectorContractor.View view,
            GetAllCurrenciesUseCase getAllCurrenciesUseCase
    ) {
        super.setView(view);
        this.getAllCurrenciesUseCase = getAllCurrenciesUseCase;
    }

    @Override
    public void getAllCurrencies() {
        request(new PresenterAsyncCall<List<Currency>>() {

            @Override
            public Flowable<List<Currency>> async() {
                return getAllCurrenciesUseCase.execute(new GetAllCurrenciesUseCase.Params());
            }

            @Override
            public void onNext(List<Currency> items) {
                getView().showAllCurrencies(items);
            }

        });
    }

    @Override
    public void onDestroy() {
        super.destroyAll();
    }

}
