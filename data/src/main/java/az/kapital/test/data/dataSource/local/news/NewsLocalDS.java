package az.kapital.test.data.dataSource.local.news;

import java.util.List;

import az.kapital.test.data.entities.NewsEntity;
import io.reactivex.rxjava3.core.Flowable;

public interface NewsLocalDS {

    Flowable<List<NewsEntity>> getAllBaseCurrencyNews();

    void insertInitialData();

}
