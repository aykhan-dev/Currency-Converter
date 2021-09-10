package az.kapital.test.domain.usecases;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import az.kapital.test.data.repositories.currencies.CurrenciesRepository;
import az.kapital.test.domain.base.BaseUseCase;
import az.kapital.test.domain.model.Currency;
import io.reactivex.rxjava3.core.Flowable;
import lombok.RequiredArgsConstructor;

public class GetAllCurrenciesUseCase extends BaseUseCase<Flowable<Map<String, String>>, Flowable<List<Currency>>, GetAllCurrenciesUseCase.Params> {

    private final CurrenciesRepository repository;

    @Inject
    public GetAllCurrenciesUseCase(CurrenciesRepository repository) {
        this.repository = repository;
    }

    @Override
    protected Flowable<Map<String, String>> process(Params params) {
        return repository.getAllCurrencies();
    }

    @Override
    protected Flowable<List<Currency>> mapDTO(Flowable<Map<String, String>> data) {
        return data.map(dict -> {
            List<Currency> result = new ArrayList<>();
            for (Map.Entry<String, String> i : dict.entrySet()) {
                result.add(new Currency(i.getKey(), i.getValue()));
            }
            return result;
        });
    }

    @RequiredArgsConstructor
    public static class Params {

    }

}
