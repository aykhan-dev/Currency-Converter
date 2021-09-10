package az.kapital.test.domain.usecases;

import javax.inject.Inject;

import az.kapital.test.domain.base.BaseUseCase;
import az.kapital.test.domain.model.ConversionResult;
import az.kapital.test.domain.repositories.CurrenciesRepository;
import io.reactivex.rxjava3.core.Flowable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

public class ConvertUseCase extends BaseUseCase<Flowable<ConversionResult>, ConvertUseCase.Params> {

    private CurrenciesRepository repository;

    @Inject
    public ConvertUseCase(CurrenciesRepository repository) {
        this.repository = repository;
    }

    @AllArgsConstructor
    @Accessors(fluent = true)
    @Getter
    public static class Params {
        private String from, to, amount;
    }

    @Override
    protected Flowable<ConversionResult> process(Params params) {
        return repository.getConversionResult(params.from(), params.to(), params.amount());
    }

}
