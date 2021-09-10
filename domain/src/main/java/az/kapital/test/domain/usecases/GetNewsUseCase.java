package az.kapital.test.domain.usecases;

import java.util.List;

import javax.inject.Inject;

import az.kapital.test.domain.base.BaseUseCase;
import az.kapital.test.domain.model.News;
import az.kapital.test.domain.repositories.NewsRepository;
import io.reactivex.rxjava3.core.Flowable;
import lombok.RequiredArgsConstructor;

public class GetNewsUseCase extends BaseUseCase<Flowable<List<News>>, GetNewsUseCase.Params> {

    private final NewsRepository repository;

    @Inject
    public GetNewsUseCase(NewsRepository repository) {
        this.repository = repository;
    }

    @RequiredArgsConstructor
    public static class Params {

    }

    @Override
    protected Flowable<List<News>> process(Params params) {
        return repository.getBaseCurrencyNews();
    }

}