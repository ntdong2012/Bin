package shop.bin.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import shop.bin.app.BinApps;
import shop.bin.model.prefs.PreferencesHelper;
import shop.bin.model.prefs.PreferencesHelperImpl;

/**
 * Created by nguyenthanhdong0109@gmail.com on 5/24/2017.
 */

public abstract class SimpleActivity extends AppCompatActivity {

    protected Activity mContext;
    private Unbinder mUnBinder;

    private PreferencesHelper php;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mUnBinder = ButterKnife.bind(this);
        mContext = this;
        php = new PreferencesHelperImpl();
        onViewCreated();
        BinApps.getInstance().addActivity(this);
        initEventAndData();
    }


    protected void setToolBar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    protected void onViewCreated() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BinApps.getInstance().removeActivity(this);
        mUnBinder.unbind();
    }

    protected abstract int getLayout();

    protected abstract void initEventAndData();
}
