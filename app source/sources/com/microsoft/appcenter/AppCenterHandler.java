package com.microsoft.appcenter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public interface AppCenterHandler {
    void post(@NonNull Runnable runnable, @Nullable Runnable runnable2);
}
