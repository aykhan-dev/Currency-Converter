package az.kapital.test.data.repositories.currencies;

import java.util.Map;

import az.kapital.test.data.dto.CurrencyInfoDTO;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;

public interface CurrenciesRepository {

    Flowable<Map<String, String>> getAllCurrencies();

    @NonNull Flowable<CurrencyInfoDTO> getConversionResult(String from, String to, String amount);

}
