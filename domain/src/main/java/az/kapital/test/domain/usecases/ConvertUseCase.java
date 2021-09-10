package az.kapital.test.domain.usecases;

import javax.inject.Inject;

import az.kapital.test.data.dto.CurrencyInfoDTO;
import az.kapital.test.data.repositories.currencies.CurrenciesRepository;
import az.kapital.test.domain.base.BaseUseCase;
import az.kapital.test.domain.model.ConversionResult;
import io.reactivex.rxjava3.core.Flowable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

public class ConvertUseCase extends BaseUseCase<Flowable<CurrencyInfoDTO>, Flowable<ConversionResult>, ConvertUseCase.Params> {

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
    protected Flowable<CurrencyInfoDTO> process(Params params) {
        return repository.getConversionResult(params.from(), params.to(), params.amount());
    }

    @Override
    protected Flowable<ConversionResult> mapDTO(Flowable<CurrencyInfoDTO> data) {
        return data.map(info -> new ConversionResult(info.rate(), info.rateForAmount()));
    }

}
