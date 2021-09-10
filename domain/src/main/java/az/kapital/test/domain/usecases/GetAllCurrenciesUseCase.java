package az.kapital.test.domain.usecases;

import java.util.List;

import javax.inject.Inject;

import az.kapital.test.domain.base.BaseUseCase;
import az.kapital.test.domain.model.Currency;
import az.kapital.test.domain.repositories.CurrenciesRepository;
import io.reactivex.rxjava3.core.Flowable;
import lombok.RequiredArgsConstructor;

public class GetAllCurrenciesUseCase extends BaseUseCase<Flowable<List<Currency>>, GetAllCurrenciesUseCase.Params> {

    private final CurrenciesRepository repository;

    @Inject
    public GetAllCurrenciesUseCase(CurrenciesRepository repository) {
        this.repository = repository;
    }

    @Override
    protected Flowable<List<Currency>> process(Params params) {
        return repository.getAllCurrencies();
    }

    @RequiredArgsConstructor
    public static class Params {

    }

}
