package az.kapital.test.domain.repositories;

import java.util.List;
import java.util.Map;

import az.kapital.test.domain.model.ConversionResult;
import az.kapital.test.domain.model.Currency;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;

public interface CurrenciesRepository {

    Flowable<List<Currency>> getAllCurrencies();

    @NonNull Flowable<ConversionResult> getConversionResult(String from, String to, String amount);

}
