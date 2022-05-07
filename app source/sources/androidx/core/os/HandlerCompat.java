package androidx.core.os;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class HandlerCompat {
    public static boolean postDelayed(@NonNull Handler handler, @NonNull Runnable runnable, @Nullable Object obj, long j) {
        Handler handler2 = handler;
        Runnable r = runnable;
        Object token = obj;
        long delayMillis = j;
        if (Build.VERSION.SDK_INT >= 28) {
            return handler2.postDelayed(r, token, delayMillis);
        }
        Message message = Message.obtain(handler2, r);
        message.obj = token;
        return handler2.sendMessageDelayed(message, delayMillis);
    }

    private HandlerCompat() {
    }
}
