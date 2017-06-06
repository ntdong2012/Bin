package shop.bin.ui.view.customview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import shop.bin.app.BinApps;


/**
 * Created by nguyenthanhdong0109@gmail.com on 5/28/17.
 */

public class FontAwesomeTextView extends AppCompatTextView {

    private Context context;

    public FontAwesomeTextView(Context context) {
        super(context);
        this.context = context;
        this.setTypeface(BinApps.getFontAwesomeTf());
    }

    public FontAwesomeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.setTypeface(BinApps.getFontAwesomeTf());
    }

    public FontAwesomeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        this.setTypeface(BinApps.getFontAwesomeTf());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }


    private void onClick(){
        ((Activity) context).onBackPressed();
    }
}
