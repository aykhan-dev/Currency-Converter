package az.kapital.test.data.dataSource.remote.currencies;

import az.kapital.test.data.dto.CurrenciesDTO;
import az.kapital.test.data.dto.CurrencyConversionDTO;
import io.reactivex.rxjava3.core.Flowable;

public interface CurrenciesRemoteDS {

    Flowable<CurrenciesDTO> getAllCurrencies();

    Flowable<CurrencyConversionDTO> getConversionResult(String from, String to, String amount);

}
