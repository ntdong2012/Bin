package shop.bin.dj.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import shop.bin.app.BinApps;
import shop.bin.model.DataManager;
import shop.bin.model.http.HttpHelper;
import shop.bin.model.http.RetrofitHelper;
import shop.bin.model.prefs.PreferencesHelper;
import shop.bin.model.prefs.PreferencesHelperImpl;

/**
 * Created by nguyenthanhdong0109@gmail.com on 5/20/17.
 */

@Module
public class AppModule {

    private final BinApps application;

    public AppModule(BinApps application) {
        this.application = application;
    }

    @Provides
    @Singleton
    BinApps provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(RetrofitHelper retrofitHelper) {
        return retrofitHelper;
    }

    //    @Provides
//    @Singleton
//    DBHelper provideDBHelper(RealmHelper realmHelper) {
//        return realmHelper;
//    }
//
    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(PreferencesHelperImpl implPreferencesHelper) {
        return implPreferencesHelper;
    }
//
    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper/*, DBHelper DBHelper,*/ , PreferencesHelper preferencesHelper) {
        return new DataManager(httpHelper, /*DBHelper,*/ preferencesHelper);
    }
}

