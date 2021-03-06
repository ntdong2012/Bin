package shop.bin.util;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import shop.bin.model.http.request.BaseRequest;

/**
 * Created by nguyenthanhdong0109@gmail.com on 5/14/17.
 */

public class Utils {

    public static int getHeightScreen(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        return display.getHeight();
    }

    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public static <T extends BaseRequest> T setupRequestFormat(T t){
        t.setDeviceId("12345");
        t.setDeviceType("Android");
        t.setLanguage("vi");
        t.setMerchantCode("B03149B1EB2027152795");
        t.setSecretKey("VsecYupax@2017");
        return t;
    }

    public static <T> Flowable<T> createData(final T t) {
        return Flowable.create(new FlowableOnSubscribe<T>() {
            @Override
            public void subscribe(FlowableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(t);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        }, BackpressureStrategy.BUFFER);
    }

}
