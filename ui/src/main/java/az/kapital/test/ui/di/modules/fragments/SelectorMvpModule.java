package az.kapital.test.ui.di.modules.fragments;

import az.kapital.test.ui.contractor.SelectorContractor;
import az.kapital.test.ui.presenter.SelectorPresenter;
import az.kapital.test.ui.view.fragments.selector.SelectorFragment;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class SelectorMvpModule {

    @Binds
    abstract SelectorContractor.View bindSelectorView(SelectorFragment fragment);

    @Binds
    abstract SelectorContractor.Presenter bindSelectorPresenter(SelectorPresenter presenter);

}
