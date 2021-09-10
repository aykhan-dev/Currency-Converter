package az.kapital.test.ui.di.modules.builders;

import az.kapital.test.ui.di.scopes.PerActivity;
import az.kapital.test.ui.view.activities.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @PerActivity
    @ContributesAndroidInjector(modules = {
            MainFragmentBuildersModule.class,
    })
    abstract MainActivity contributeMainActivity();

}
