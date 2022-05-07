package com.microsoft.appcenter.channel;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import com.microsoft.appcenter.ingestion.Ingestion;
import com.microsoft.appcenter.ingestion.models.Log;

public interface Channel {

    public interface GroupListener {
        void onBeforeSending(Log log);

        void onFailure(Log log, Exception exc);

        void onSuccess(Log log);
    }

    public interface Listener {
        void onClear(@NonNull String str);

        void onGloballyEnabled(boolean z);

        void onGroupAdded(@NonNull String str, GroupListener groupListener, long j);

        void onGroupRemoved(@NonNull String str);

        void onPaused(@NonNull String str, String str2);

        void onPreparedLog(@NonNull Log log, @NonNull String str, int i);

        void onPreparingLog(@NonNull Log log, @NonNull String str);

        void onResumed(@NonNull String str, String str2);

        boolean shouldFilter(@NonNull Log log);
    }

    void addGroup(String str, int i, long j, int i2, Ingestion ingestion, GroupListener groupListener);

    void addListener(Listener listener);

    void clear(String str);

    void enqueue(@NonNull Log log, @NonNull String str, @IntRange(from = 1, to = 2) int i);

    void invalidateDeviceCache();

    boolean isEnabled();

    void pauseGroup(String str, String str2);

    void removeGroup(String str);

    void removeListener(Listener listener);

    void resumeGroup(String str, String str2);

    void setAppSecret(@NonNull String str);

    void setEnabled(boolean z);

    void setLogUrl(String str);

    boolean setMaxStorageSize(long j);

    void shutdown();
}
