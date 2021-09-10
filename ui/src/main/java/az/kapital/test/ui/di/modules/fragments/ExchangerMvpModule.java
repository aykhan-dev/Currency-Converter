package az.kapital.test.ui.di.modules.fragments;

import az.kapital.test.ui.contractor.ExchangerContractor;
import az.kapital.test.ui.di.scopes.PerFragment;
import az.kapital.test.ui.presenter.ExchangerPresenter;
import az.kapital.test.ui.view.fragments.exchanger.ExchangerFragment;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class ExchangerMvpModule {

    @PerFragment
    @Binds
    abstract ExchangerContractor.View bindExchangerView(ExchangerFragment fragment);

    @PerFragment
    @Binds
    abstract ExchangerContractor.Presenter bindExchangerPresenter(ExchangerPresenter presenter);

}
