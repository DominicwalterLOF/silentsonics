package androidx.core.os;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;

public class UserManagerCompat {
    private UserManagerCompat() {
    }

    public static boolean isUserUnlocked(Context context) {
        Context context2 = context;
        if (Build.VERSION.SDK_INT >= 24) {
            return ((UserManager) context2.getSystemService(UserManager.class)).isUserUnlocked();
        }
        return true;
    }
}
