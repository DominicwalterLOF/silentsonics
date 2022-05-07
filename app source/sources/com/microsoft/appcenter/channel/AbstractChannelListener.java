package com.microsoft.appcenter.channel;

import android.support.annotation.NonNull;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.ingestion.models.Log;

public class AbstractChannelListener implements Channel.Listener {
    public AbstractChannelListener() {
    }

    public void onGroupAdded(@NonNull String groupName, Channel.GroupListener groupListener, long batchTimeInterval) {
    }

    public void onGroupRemoved(@NonNull String groupName) {
    }

    public void onPreparingLog(@NonNull Log log, @NonNull String groupName) {
    }

    public void onPreparedLog(@NonNull Log log, @NonNull String groupName, int flags) {
    }

    public boolean shouldFilter(@NonNull Log log) {
        Log log2 = log;
        return false;
    }

    public void onGloballyEnabled(boolean isEnabled) {
    }

    public void onClear(@NonNull String groupName) {
    }

    public void onPaused(@NonNull String groupName, String targetToken) {
    }

    public void onResumed(@NonNull String groupName, String targetToken) {
    }
}
