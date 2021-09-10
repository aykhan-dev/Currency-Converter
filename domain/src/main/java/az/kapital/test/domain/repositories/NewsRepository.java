package az.kapital.test.domain.repositories;

import java.util.List;

import az.kapital.test.domain.model.News;
import io.reactivex.rxjava3.core.Flowable;

public interface NewsRepository {

    Flowable<List<News>> getBaseCurrencyNews();

}
