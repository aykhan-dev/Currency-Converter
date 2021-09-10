package az.kapital.test.data.repositoryImpls.currencies;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import az.kapital.test.data.dataSource.remote.currencies.CurrenciesRemoteDS;
import az.kapital.test.data.dto.CurrenciesDTO;
import az.kapital.test.domain.model.ConversionResult;
import az.kapital.test.domain.model.Currency;
import az.kapital.test.domain.repositories.CurrenciesRepository;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;

public class CurrenciesRepositoryImpl implements CurrenciesRepository {

    private final CurrenciesRemoteDS currenciesRemoteDS;

    @Inject
    public CurrenciesRepositoryImpl(CurrenciesRemoteDS remoteDS) {
        this.currenciesRemoteDS = remoteDS;
    }

    @Override
    public Flowable<List<Currency>> getAllCurrencies() {
        return currenciesRemoteDS
                .getAllCurrencies()
                .map(CurrenciesDTO::getCurrencies)
                .map(dto -> {
                    List<Currency> result = new ArrayList<>();
                    for (Map.Entry<String, String> i : dto.entrySet()) {
                        result.add(new Currency(i.getKey(), i.getValue()));
                    }
                    return result;
                });
    }

    @Override
    public @NonNull Flowable<ConversionResult> getConversionResult(String from, String to, String amount) {
        return currenciesRemoteDS
                .getConversionResult(from, to, amount)
                .map(details -> details.rates().get(to))
                .map(dto -> new ConversionResult(dto.rate(), dto.rateForAmount()));
    }

}
