package ae.com.asadabbas.assignement.newyorktime.util;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.pnikosis.materialishprogress.ProgressWheel;

import ae.com.asadabbas.assignement.newyorktime.R;


public class MessageBox {

    public static boolean isDialogShow = false;

    public static Dialog showSplash(Context context) {
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(android.R.color.transparent)));
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(true);
        dialog.show();
        dialog.setContentView(R.layout.dialog_progress);
        return dialog;
    }

    public static Dialog showSplash(Context context, int color) {
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(android.R.color.transparent)));
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(true);
        dialog.show();
        dialog.setContentView(R.layout.dialog_progress);
        com.pnikosis.materialishprogress.ProgressWheel wheel = (ProgressWheel) dialog.findViewById(R.id.progressBar);
        final int version = Build.VERSION.SDK_INT;
        if (version >= 23) {
            wheel.setBarColor(ContextCompat.getColor(context, color));
        } else {
            wheel.setBarColor(context.getResources().getColor(color));
        }

        return dialog;
    }

    private static void showDialog(Dialog dialog, final DialogInterface.OnCancelListener onCancelListener) {
        if (isDialogShow) {
            return;
        }
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                isDialogShow = true;
            }
        });
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                isDialogShow = false;
            }
        });
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                isDialogShow = false;
                if (onCancelListener != null) {
                    onCancelListener.onCancel(dialogInterface);
                }
            }
        });
        Context context = dialog.getContext();
        try {
            if (context instanceof Activity) {
                if (!((Activity) context).isFinishing()) {
                    dialog.show();
                }
            } else {
                dialog.show();
            }
        } catch (Exception e) {

        }
    }
//
//
//

    /**
     * Shows an error alert dialog with the given message.
     *
     * @param activity activity
     * @param message  message to show or {@code null} for none
     */
    public static void showError(Activity activity, String message) {
        showErrorInternal(activity, message);
    }

    private static void showErrorInternal(final Activity activity, final String errorMessage) {
        activity.runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(activity, errorMessage, Toast.LENGTH_LONG).show();
            }
        });
    }

}
