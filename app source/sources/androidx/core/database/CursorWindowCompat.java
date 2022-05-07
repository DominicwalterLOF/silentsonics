package androidx.core.database;

import android.database.CursorWindow;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class CursorWindowCompat {
    private CursorWindowCompat() {
    }

    @NonNull
    public static CursorWindow create(@Nullable String str, long j) {
        CursorWindow cursorWindow;
        CursorWindow cursorWindow2;
        CursorWindow cursorWindow3;
        String name = str;
        long windowSizeBytes = j;
        if (Build.VERSION.SDK_INT >= 28) {
            new CursorWindow(name, windowSizeBytes);
            return cursorWindow3;
        } else if (Build.VERSION.SDK_INT >= 15) {
            new CursorWindow(name);
            return cursorWindow2;
        } else {
            new CursorWindow(false);
            return cursorWindow;
        }
    }
}
