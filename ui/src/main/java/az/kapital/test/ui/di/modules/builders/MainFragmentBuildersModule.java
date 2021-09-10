package az.kapital.test.ui.di.modules.builders;

import az.kapital.test.ui.di.modules.fragments.ExchangerMvpModule;
import az.kapital.test.ui.di.modules.fragments.SelectorMvpModule;
import az.kapital.test.ui.di.scopes.PerFragment;
import az.kapital.test.ui.view.fragments.exchanger.ExchangerFragment;
import az.kapital.test.ui.view.fragments.selector.SelectorFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBuildersModule {

    @PerFragment
    @ContributesAndroidInjector(modules = {ExchangerMvpModule.class})
    abstract ExchangerFragment contributeExchangerFragment();

    @PerFragment
    @ContributesAndroidInjector(modules = {SelectorMvpModule.class})
    abstract SelectorFragment contributeSelectorFragment();

}
