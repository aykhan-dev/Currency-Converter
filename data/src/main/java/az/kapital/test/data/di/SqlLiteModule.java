package az.kapital.test.data.di;

import android.app.Application;

import org.greenrobot.greendao.database.Database;

import javax.inject.Singleton;

import az.kapital.test.data.entities.DaoMaster;
import az.kapital.test.data.entities.DaoSession;
import dagger.Module;
import dagger.Provides;

@Module
public class SqlLiteModule {

    @Singleton
    @Provides
    DaoSession provideDaoSession(Application application) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(application, "currency-db");
        Database db = helper.getWritableDb();
        return new DaoMaster(db).newSession();
    }

}
