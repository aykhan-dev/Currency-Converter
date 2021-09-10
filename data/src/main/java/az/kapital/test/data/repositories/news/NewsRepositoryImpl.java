package az.kapital.test.data.repositories.news;

import java.util.List;

import javax.inject.Inject;

import az.kapital.test.data.dataSource.local.news.NewsLocalDS;
import az.kapital.test.data.dataSource.local.news.NewsLocalDSI;
import az.kapital.test.data.entities.NewsEntity;
import io.reactivex.rxjava3.core.Flowable;

public class NewsRepositoryImpl implements NewsRepository {

    private final NewsLocalDS localDS;

    @Inject
    public NewsRepositoryImpl(NewsLocalDSI localDS) {
        this.localDS = localDS;
    }

    @Override
    public Flowable<List<NewsEntity>> getBaseCurrencyNews() {
        return localDS.getAllBaseCurrencyNews();
    }

}
