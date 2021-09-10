package az.kapital.test.data.dataSource.remote.currencies;

import javax.inject.Inject;

import az.kapital.test.data.api.CurrencyApi;
import az.kapital.test.data.dto.CurrenciesDTO;
import az.kapital.test.data.dto.CurrencyConversionDTO;
import io.reactivex.rxjava3.core.Flowable;

public class CurrenciesRemoteDSI implements CurrenciesRemoteDS {

    private final CurrencyApi api;

    @Inject
    public CurrenciesRemoteDSI(CurrencyApi api) {
        this.api = api;
    }

    @Override
    public Flowable<CurrenciesDTO> getAllCurrencies() {
        return api.getAllCurrencies();
    }

    @Override
    public Flowable<CurrencyConversionDTO> getConversionResult(String from, String to, String amount) {
        return api.getConversionResult("json", from, to, amount);
    }

}
