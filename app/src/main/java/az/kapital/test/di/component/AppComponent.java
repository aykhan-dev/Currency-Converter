package az.kapital.test.di.component;

import android.app.Application;

import javax.inject.Named;
import javax.inject.Singleton;

import az.kapital.test.App;
import az.kapital.test.data.di.DataModule;
import az.kapital.test.data.di.NetworkModule;
import az.kapital.test.data.di.SqlLiteModule;
import az.kapital.test.di.module.AppModule;
import az.kapital.test.ui.di.modules.builders.ActivityBuildersModule;
import az.kapital.test.ui.di.modules.builders.DialogBuildersModule;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(
        modules = {
                AppModule.class,
                ActivityBuildersModule.class,
                DialogBuildersModule.class,
                DataModule.class,
                NetworkModule.class,
                SqlLiteModule.class,
                AndroidSupportInjectionModule.class,
        }
)
public interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();

    }

}
