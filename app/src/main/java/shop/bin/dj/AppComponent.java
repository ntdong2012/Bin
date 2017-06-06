package shop.bin.dj;

import javax.inject.Singleton;

import dagger.Component;
import shop.bin.app.BinApps;
import shop.bin.dj.module.AppModule;
import shop.bin.dj.module.HttpModule;
import shop.bin.model.DataManager;
import shop.bin.model.http.RetrofitHelper;

/**
 * Created by nguyenthanhdong0109@gmail.com on 5/20/17.
 */


@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    BinApps getContext();

    RetrofitHelper retrofitHelper();

    DataManager getDataManager();


}


