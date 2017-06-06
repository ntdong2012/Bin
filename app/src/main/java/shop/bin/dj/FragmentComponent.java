package shop.bin.dj;

import android.app.Activity;

import dagger.Component;
import shop.bin.dj.module.FragmentModule;
import shop.bin.dj.scope.FragmentScope;

/**
 * Created by nguyenthanhdong0109@gmail.com on 5/21/17.
 */


@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

}
