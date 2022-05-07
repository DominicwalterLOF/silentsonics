package androidx.core.content.pm;

import android.annotation.SuppressLint;
import android.content.pm.PermissionInfo;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class PermissionInfoCompat {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Protection {
    }

    @SuppressLint({"UniqueConstants"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ProtectionFlags {
    }

    private PermissionInfoCompat() {
    }

    @SuppressLint({"WrongConstant"})
    public static int getProtection(@NonNull PermissionInfo permissionInfo) {
        PermissionInfo permissionInfo2 = permissionInfo;
        if (Build.VERSION.SDK_INT >= 28) {
            return permissionInfo2.getProtection();
        }
        return permissionInfo2.protectionLevel & 15;
    }

    @SuppressLint({"WrongConstant"})
    public static int getProtectionFlags(@NonNull PermissionInfo permissionInfo) {
        PermissionInfo permissionInfo2 = permissionInfo;
        if (Build.VERSION.SDK_INT >= 28) {
            return permissionInfo2.getProtectionFlags();
        }
        return permissionInfo2.protectionLevel & -16;
    }
}
