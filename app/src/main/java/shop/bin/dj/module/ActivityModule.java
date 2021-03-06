package shop.bin.dj.module;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import shop.bin.dj.scope.ActivityScope;

/**
 * Created by nguyenthanhdong0109@gmail.com on 5/20/17.
 */

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return mActivity;
    }
}
