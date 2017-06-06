package shop.bin.dj;

import android.app.Activity;

import dagger.Component;
import shop.bin.dj.module.ActivityModule;
import shop.bin.dj.scope.ActivityScope;


/**
 * Created by nguyenthanhdong0109@gmail.com on 5/20/17.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

}
