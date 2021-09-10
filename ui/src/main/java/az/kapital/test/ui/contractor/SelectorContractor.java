package az.kapital.test.ui.contractor;

import java.util.List;

import az.kapital.test.domain.model.Currency;
import az.kapital.test.ui.base.BasePresenterInterface;
import az.kapital.test.ui.base.BaseViewInterface;

public interface SelectorContractor {

    interface View extends BaseViewInterface {

        void showAllCurrencies(List<Currency> items);

    }

    interface Presenter extends BasePresenterInterface {

        void getAllCurrencies();

    }

}
