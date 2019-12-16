package ae.com.asadabbas.assignement.newyorktime.views;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by Asad Abbas on 15/12/19.
 * Copyrights © 15/12/19 Asad Abbas. All rights reserved
 */

public class BoldTextView extends AppCompatTextView {

    public BoldTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public BoldTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BoldTextView(Context context) {
        super(context);
        init();
    }

    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "montserrat_bold.ttf");
        setTypeface(tf);

    }

}