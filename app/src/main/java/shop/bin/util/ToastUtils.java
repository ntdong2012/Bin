package shop.bin.util;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import shop.bin.R;
import shop.bin.app.BinApps;


/**
 * Created by nguyenthanhdong0109@gmail.com on 5/20/17.
 */

public class ToastUtils {

    static ToastUtils td;
    Context context;
    Toast toast;
    String msg;


    public static void show(int resId) {
        show(BinApps.getInstance().getString(resId));
    }

    public static void show(String msg) {
        if (td == null) {
            td = new ToastUtils(BinApps.getInstance());
        }
        td.setText(msg);
        td.create().show();
    }

    public static void shortShow(String msg) {
        if (td == null) {
            td = new ToastUtils(BinApps.getInstance());
        }
        td.setText(msg);
        td.createShort().show();
    }

    public ToastUtils(Context context) {
        this.context = context;
    }

    public Toast create() {
        View contentView = View.inflate(context, R.layout.dialog_toast, null);
        TextView tvMsg = (TextView) contentView.findViewById(R.id.tv_toast_msg);
        toast = new Toast(context);
        toast.setView(contentView);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        tvMsg.setText(msg);
        return toast;
    }

    public Toast createShort() {
        View contentView = View.inflate(context, R.layout.dialog_toast, null);
        TextView tvMsg = (TextView) contentView.findViewById(R.id.tv_toast_msg);
        toast = new Toast(context);
        toast.setView(contentView);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        tvMsg.setText(msg);
        return toast;
    }

    public void show() {
        if (toast != null) {
            toast.show();
        }
    }

    public void setText(String text) {
        msg = text;
    }

}
