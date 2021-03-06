package androidx.core.content.pm;

import android.content.pm.PackageInfo;
import android.os.Build;
import androidx.annotation.NonNull;

public final class PackageInfoCompat {
    public static long getLongVersionCode(@NonNull PackageInfo packageInfo) {
        PackageInfo info = packageInfo;
        if (Build.VERSION.SDK_INT >= 28) {
            return info.getLongVersionCode();
        }
        return (long) info.versionCode;
    }

    private PackageInfoCompat() {
    }
}
