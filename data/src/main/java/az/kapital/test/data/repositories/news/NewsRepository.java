package az.kapital.test.data.repositories.news;

import java.util.List;

import az.kapital.test.data.entities.NewsEntity;
import io.reactivex.rxjava3.core.Flowable;

public interface NewsRepository {

    Flowable<List<NewsEntity>> getBaseCurrencyNews();

}
