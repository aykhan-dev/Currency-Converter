package az.kapital.test.data.repositoryImpls.news;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import az.kapital.test.data.dataSource.local.news.NewsLocalDS;
import az.kapital.test.data.dataSource.local.news.NewsLocalDSI;
import az.kapital.test.data.entities.NewsEntity;
import az.kapital.test.domain.model.News;
import az.kapital.test.domain.repositories.NewsRepository;
import io.reactivex.rxjava3.core.Flowable;

public class NewsRepositoryImpl implements NewsRepository {

    private final NewsLocalDS localDS;

    @Inject
    public NewsRepositoryImpl(NewsLocalDSI localDS) {
        this.localDS = localDS;
    }

    @Override
    public Flowable<List<News>> getBaseCurrencyNews() {
        return localDS
                .getAllBaseCurrencyNews()
                .map(entity -> {
                    List<News> result = new ArrayList<>();
                    for (NewsEntity i : entity)
                        result.add(new News(i.getId(), i.getTitle(), i.getContent(), i.getDate()));
                    return result;
                });
    }

}
