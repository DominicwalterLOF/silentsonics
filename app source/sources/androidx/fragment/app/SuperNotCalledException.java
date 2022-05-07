package androidx.fragment.app;

import android.util.AndroidRuntimeException;

final class SuperNotCalledException extends AndroidRuntimeException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuperNotCalledException(String msg) {
        super(msg);
    }
}
