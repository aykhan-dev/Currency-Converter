package az.kapital.test.data.dataSource.local.news;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import az.kapital.test.data.entities.DaoSession;
import az.kapital.test.data.entities.NewsEntity;
import io.reactivex.rxjava3.core.Flowable;

public class NewsLocalDSI implements NewsLocalDS {

    private final DaoSession daoSession;

    @Inject
    public NewsLocalDSI(DaoSession daoSession) {
        this.daoSession = daoSession;
    }

    @Override
    public Flowable<List<NewsEntity>> getAllBaseCurrencyNews() {
        long rowCounts = daoSession.getNewsEntityDao().count();
        if(rowCounts == 0) insertInitialData();

        List<NewsEntity> data = daoSession.getNewsEntityDao().loadAll();

        return Flowable.just(data);
    }

    @Override
    public void insertInitialData() {
        List<NewsEntity> data = Arrays.asList(
                new NewsEntity(1L, "Currency update", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "10/05/2021"),
                new NewsEntity(2L, "Currency update", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "10/06/2021"),
                new NewsEntity(3L, "Currency update", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "10/07/2021"),
                new NewsEntity(4L, "Currency update", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "10/08/2021"),
                new NewsEntity(5L, "Currency update", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "10/09/2021")
        );
        daoSession.getNewsEntityDao().insertInTx(data);
    }

}
