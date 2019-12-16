package ae.com.asadabbas.assignement.newyorktime.base;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import ae.com.asadabbas.assignement.newyorktime.util.MessageBox;


public class BaseActivity extends AppCompatActivity {
    private Dialog dialog;

    public void showWaitDialog() {
        if (dialog != null && dialog.isShowing()) {

        } else {
            dialog = MessageBox.showSplash(this);
        }
    }

    public boolean isDialgShow() {

        return dialog.isShowing();
    }

    public void showWaitDialog(int color) {
        dialog = MessageBox.showSplash(this, color);

    }

    public void hideWaitDialog() {
        if (dialog != null && dialog.isShowing()) {
            try {
                dialog.dismiss();
            } catch (Exception e) {

            }
        }
    }

    public void hideKeyboard(View v) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    public void showKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }
}
