package az.kapital.test.ui.di.modules.builders;

import az.kapital.test.ui.view.dialogs.LoadingDialog;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class DialogBuildersModule {

    @ContributesAndroidInjector
    abstract LoadingDialog contributeLoadingDialog();

}
