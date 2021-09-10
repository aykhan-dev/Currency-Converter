package az.kapital.test.data.di;

import az.kapital.test.data.dataSource.local.news.NewsLocalDS;
import az.kapital.test.data.dataSource.local.news.NewsLocalDSI;
import az.kapital.test.data.dataSource.remote.currencies.CurrenciesRemoteDS;
import az.kapital.test.data.dataSource.remote.currencies.CurrenciesRemoteDSI;
import az.kapital.test.data.repositories.currencies.CurrenciesRepository;
import az.kapital.test.data.repositories.currencies.CurrenciesRepositoryImpl;
import az.kapital.test.data.repositories.news.NewsRepository;
import az.kapital.test.data.repositories.news.NewsRepositoryImpl;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class DataModule {

    @Binds
    abstract CurrenciesRemoteDS bindCurrenciesRemoteDS(CurrenciesRemoteDSI remoteDS);

    @Binds
    abstract NewsLocalDS bindNewsLocalDS(NewsLocalDSI localDS);

    @Binds
    abstract NewsRepository bindNewsRepository(NewsRepositoryImpl repository);

    @Binds
    abstract CurrenciesRepository bindCurrenciesRepository(CurrenciesRepositoryImpl repository);

}
