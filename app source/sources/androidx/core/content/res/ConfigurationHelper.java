package androidx.core.content.res;

import android.content.res.Resources;
import android.os.Build;
import androidx.annotation.NonNull;

public final class ConfigurationHelper {
    private ConfigurationHelper() {
    }

    public static int getDensityDpi(@NonNull Resources resources) {
        Resources resources2 = resources;
        if (Build.VERSION.SDK_INT >= 17) {
            return resources2.getConfiguration().densityDpi;
        }
        return resources2.getDisplayMetrics().densityDpi;
    }
}
