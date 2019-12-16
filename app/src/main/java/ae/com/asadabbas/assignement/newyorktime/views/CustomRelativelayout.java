package ae.com.asadabbas.assignement.newyorktime.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by Asad Abbad on 15/12/19.
 * Copyrights © 15/12/19 Asad Abbas. All rights reserved
 */

public class CustomRelativelayout extends RelativeLayout {

    public CustomRelativelayout(Context context) {
        super(context);
    }

    public CustomRelativelayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomRelativelayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMeasuredWidth();
        setMeasuredDimension(width, width);
    }
}

