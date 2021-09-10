package az.kapital.test.data.repositories.currencies;

import java.util.Map;

import javax.inject.Inject;

import az.kapital.test.data.dataSource.remote.currencies.CurrenciesRemoteDS;
import az.kapital.test.data.dto.CurrenciesDTO;
import az.kapital.test.data.dto.CurrencyInfoDTO;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;

public class CurrenciesRepositoryImpl implements CurrenciesRepository {

    private final CurrenciesRemoteDS currenciesRemoteDS;

    @Inject
    public CurrenciesRepositoryImpl(CurrenciesRemoteDS remoteDS) {
        this.currenciesRemoteDS = remoteDS;
    }

    @Override
    public Flowable<Map<String, String>> getAllCurrencies() {
        return currenciesRemoteDS.getAllCurrencies().map(CurrenciesDTO::getCurrencies);
    }

    @Override
    public @NonNull Flowable<CurrencyInfoDTO> getConversionResult(String from, String to, String amount) {
        return currenciesRemoteDS
                .getConversionResult(from, to, amount)
                .map(details -> details.rates().get(to));
    }

}
