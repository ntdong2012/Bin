package shop.bin.util;

import android.text.TextUtils;

import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.HttpException;
import shop.bin.base.BaseView;
import shop.bin.model.http.exception.ApiException;
import shop.bin.util.log.DLog;

/**
 * Created by nguyenthanhdong0109@gmail.com on 5/27/17.
 */

public abstract class CommonSubscriber<T> extends ResourceSubscriber<T> {


    private BaseView mView;
    private String mErrorMsg;
    private boolean isShowErrorState = true;

    protected CommonSubscriber(BaseView view) {
        this.mView = view;
    }

    protected CommonSubscriber(BaseView view, String errorMsg) {
        this.mView = view;
        this.mErrorMsg = errorMsg;
    }

    protected CommonSubscriber(BaseView view, boolean isShowErrorState) {
        this.mView = view;
        this.isShowErrorState = isShowErrorState;
    }

    protected CommonSubscriber(BaseView view, String errorMsg, boolean isShowErrorState) {
        this.mView = view;
        this.mErrorMsg = errorMsg;
        this.isShowErrorState = isShowErrorState;
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (mView == null) {
            return;
        }
        if (mErrorMsg != null && !TextUtils.isEmpty(mErrorMsg)) {
            mView.showErrorMsg(mErrorMsg);
        } else if (e instanceof ApiException) {
            mView.showErrorMsg(e.toString());
        } else if (e instanceof HttpException) {
            mView.showErrorMsg("Data loading failure");
        } else {
            mView.showErrorMsg("Unknown error");
            DLog.d(e.toString());
        }
        if (isShowErrorState) {
            mView.stateError();
        }
    }
}
