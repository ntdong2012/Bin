package shop.bin.base;

import android.support.v7.app.AppCompatDelegate;
import android.view.ViewGroup;

import javax.inject.Inject;

import shop.bin.app.BinApps;
import shop.bin.dj.ActivityComponent;
import shop.bin.dj.DaggerActivityComponent;
import shop.bin.dj.module.ActivityModule;
import shop.bin.util.SnackbarUtil;
import shop.bin.util.log.DLog;


/**
 * Created by nguyenthanhdong0109@gmail.com on 5/9/2017.
 */

public abstract class BaseActivity<T extends BasePresenter> extends SimpleActivity implements BaseView {

    @Inject
    protected T mPresenter;

    protected ActivityComponent getActivityComponent(boolean isNeedResfresh) {
        return DaggerActivityComponent.builder()
                .appComponent(BinApps.getAppComponent(isNeedResfresh))
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    @Override
    protected void onViewCreated() {
        super.onViewCreated();
        initInject();
        if (mPresenter != null)
            mPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            DLog.d("onDestroy detachView ");
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    @Override
    public void showErrorMsg(String msg) {
        SnackbarUtil.show(((ViewGroup) findViewById(android.R.id.content)).getChildAt(0), msg);
    }

    @Override
    public void useNightMode(boolean isNight) {
        if (isNight) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO);
        }
        recreate();
    }

    @Override
    public void stateError() {
    }

    @Override
    public void stateLoading() {
    }

    @Override
    public void stateMain() {
    }

    protected abstract void initInject();
}
