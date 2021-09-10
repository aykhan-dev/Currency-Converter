package az.kapital.test.domain.usecases;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import az.kapital.test.data.entities.NewsEntity;
import az.kapital.test.data.repositories.news.NewsRepository;
import az.kapital.test.domain.base.BaseUseCase;
import az.kapital.test.domain.model.News;
import io.reactivex.rxjava3.core.Flowable;
import lombok.RequiredArgsConstructor;

public class GetNewsUseCase extends BaseUseCase<Flowable<List<NewsEntity>>, Flowable<List<News>>, GetNewsUseCase.Params> {

    private final NewsRepository repository;

    @Inject
    public GetNewsUseCase(NewsRepository repository) {
        this.repository = repository;
    }

    @RequiredArgsConstructor
    public static class Params {

    }

    @Override
    protected Flowable<List<NewsEntity>> process(Params params) {
        return repository.getBaseCurrencyNews();
    }

    @Override
    protected Flowable<List<News>> mapDTO(Flowable<List<NewsEntity>> data) {
        return data.map(newsDTOS -> {
            List<News> result = new ArrayList<>();
            for (NewsEntity i : newsDTOS)
                result.add(new News(i.getId(), i.getTitle(), i.getContent(), i.getDate()));
            return result;
        });
    }

}