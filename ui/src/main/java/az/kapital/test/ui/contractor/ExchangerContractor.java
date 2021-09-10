package az.kapital.test.ui.contractor;

import java.util.List;

import az.kapital.test.domain.model.News;
import az.kapital.test.ui.base.BasePresenterInterface;
import az.kapital.test.ui.base.BaseViewInterface;

public interface ExchangerContractor {

    interface View extends BaseViewInterface {

        void showBaseCurrencyNews(List<News> items);

        void showTargetAmount(String amount);

        void setBaseCurrencyCode(String code);

        void setTargetCurrencyCode(String code);

    }

    interface Presenter extends BasePresenterInterface {

        void getBaseCurrencyNews();

        void calculateTargetAmount(String value);

        void setBaseCurrency(String code);

        void setTargetCurrency(String code);

        void keepCurrenciesUpdatedOnUI();

    }

}
