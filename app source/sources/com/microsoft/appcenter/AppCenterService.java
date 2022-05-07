package com.microsoft.appcenter;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.ingestion.models.json.LogFactory;
import com.microsoft.appcenter.utils.ApplicationLifecycleListener;
import java.util.Map;

public interface AppCenterService extends Application.ActivityLifecycleCallbacks, ApplicationLifecycleListener.ApplicationLifecycleCallbacks {
    @Nullable
    Map<String, LogFactory> getLogFactories();

    String getServiceName();

    boolean isAppSecretRequired();

    boolean isInstanceEnabled();

    @WorkerThread
    void onConfigurationUpdated(String str, String str2);

    @WorkerThread
    void onStarted(@NonNull Context context, @NonNull Channel channel, String str, String str2, boolean z);

    void onStarting(@NonNull AppCenterHandler appCenterHandler);

    void setInstanceEnabled(boolean z);
}
