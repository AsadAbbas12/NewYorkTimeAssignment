package ae.com.asadabbas.assignement.newyorktime.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.List;

/**
 * Created by Asad Abbas on 15/12/19.
 * Copyrights © 15/12/19 Asad Abbas. All rights reserved
 */

public class ValidationHelper {

    public static boolean isNullOrEmpty(CharSequence s) {
        if (s == null || s.length() < 1 || s.toString().trim().length() < 1) {
            return true;
        }
        return false;
    }

    public static boolean isNullOrEmpty(List<?> list) {
        if (list == null || list.size() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
