package com.microsoft.appcenter.analytics;

import android.provider.Settings;
import android.support.annotation.NonNull;
import com.microsoft.appcenter.channel.AbstractChannelListener;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.one.AppExtension;
import com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog;
import com.microsoft.appcenter.ingestion.models.one.DeviceExtension;
import com.microsoft.appcenter.ingestion.models.one.UserExtension;
import com.microsoft.appcenter.ingestion.models.properties.TypedProperty;
import com.microsoft.appcenter.utils.context.UserIdContext;
import java.util.Date;
import java.util.Map;

public class PropertyConfigurator extends AbstractChannelListener {
    private static final String ANDROID_DEVICE_ID_PREFIX = "a:";
    private String mAppLocale;
    private String mAppName;
    private String mAppVersion;
    private boolean mDeviceIdEnabled;
    private final EventProperties mEventProperties;
    private final AnalyticsTransmissionTarget mTransmissionTarget;
    private String mUserId;

    static /* synthetic */ String access$002(PropertyConfigurator x0, String x1) {
        String str = x1;
        String str2 = str;
        x0.mAppName = str2;
        return str;
    }

    static /* synthetic */ String access$102(PropertyConfigurator x0, String x1) {
        String str = x1;
        String str2 = str;
        x0.mAppVersion = str2;
        return str;
    }

    static /* synthetic */ String access$202(PropertyConfigurator x0, String x1) {
        String str = x1;
        String str2 = str;
        x0.mAppLocale = str2;
        return str;
    }

    static /* synthetic */ String access$302(PropertyConfigurator x0, String x1) {
        String str = x1;
        String str2 = str;
        x0.mUserId = str2;
        return str;
    }

    static /* synthetic */ boolean access$402(PropertyConfigurator x0, boolean x1) {
        boolean z = x1;
        boolean z2 = z;
        x0.mDeviceIdEnabled = z2;
        return z;
    }

    PropertyConfigurator(AnalyticsTransmissionTarget transmissionTarget) {
        EventProperties eventProperties;
        new EventProperties();
        this.mEventProperties = eventProperties;
        this.mTransmissionTarget = transmissionTarget;
    }

    public void onPreparingLog(@NonNull Log log, @NonNull String str) {
        StringBuilder sb;
        Log log2 = log;
        String str2 = str;
        if (shouldOverridePartAProperties(log2)) {
            AppExtension app = ((CommonSchemaLog) log2).getExt().getApp();
            UserExtension user = ((CommonSchemaLog) log2).getExt().getUser();
            DeviceExtension device = ((CommonSchemaLog) log2).getExt().getDevice();
            if (this.mAppName != null) {
                app.setName(this.mAppName);
            } else {
                AnalyticsTransmissionTarget analyticsTransmissionTarget = this.mTransmissionTarget.mParentTarget;
                while (true) {
                    AnalyticsTransmissionTarget target = analyticsTransmissionTarget;
                    if (target == null) {
                        break;
                    }
                    String parentAppName = target.getPropertyConfigurator().getAppName();
                    if (parentAppName != null) {
                        app.setName(parentAppName);
                        break;
                    }
                    analyticsTransmissionTarget = target.mParentTarget;
                }
            }
            if (this.mAppVersion != null) {
                app.setVer(this.mAppVersion);
            } else {
                AnalyticsTransmissionTarget analyticsTransmissionTarget2 = this.mTransmissionTarget.mParentTarget;
                while (true) {
                    AnalyticsTransmissionTarget target2 = analyticsTransmissionTarget2;
                    if (target2 == null) {
                        break;
                    }
                    String parentAppVersion = target2.getPropertyConfigurator().getAppVersion();
                    if (parentAppVersion != null) {
                        app.setVer(parentAppVersion);
                        break;
                    }
                    analyticsTransmissionTarget2 = target2.mParentTarget;
                }
            }
            if (this.mAppLocale != null) {
                app.setLocale(this.mAppLocale);
            } else {
                AnalyticsTransmissionTarget analyticsTransmissionTarget3 = this.mTransmissionTarget.mParentTarget;
                while (true) {
                    AnalyticsTransmissionTarget target3 = analyticsTransmissionTarget3;
                    if (target3 == null) {
                        break;
                    }
                    String parentAppLocale = target3.getPropertyConfigurator().getAppLocale();
                    if (parentAppLocale != null) {
                        app.setLocale(parentAppLocale);
                        break;
                    }
                    analyticsTransmissionTarget3 = target3.mParentTarget;
                }
            }
            if (this.mUserId != null) {
                user.setLocalId(this.mUserId);
            } else {
                AnalyticsTransmissionTarget analyticsTransmissionTarget4 = this.mTransmissionTarget.mParentTarget;
                while (true) {
                    AnalyticsTransmissionTarget target4 = analyticsTransmissionTarget4;
                    if (target4 == null) {
                        break;
                    }
                    String parentUserId = target4.getPropertyConfigurator().getUserId();
                    if (parentUserId != null) {
                        user.setLocalId(parentUserId);
                        break;
                    }
                    analyticsTransmissionTarget4 = target4.mParentTarget;
                }
            }
            if (this.mDeviceIdEnabled) {
                String androidId = Settings.Secure.getString(this.mTransmissionTarget.mContext.getContentResolver(), "android_id");
                new StringBuilder();
                device.setLocalId(sb.append(ANDROID_DEVICE_ID_PREFIX).append(androidId).toString());
            }
        }
    }

    private boolean shouldOverridePartAProperties(@NonNull Log log) {
        Log log2 = log;
        return (log2 instanceof CommonSchemaLog) && log2.getTag() == this.mTransmissionTarget && this.mTransmissionTarget.isEnabled();
    }

    private String getAppName() {
        return this.mAppName;
    }

    public void setAppName(String appName) {
        Runnable runnable;
        final String str = appName;
        new Runnable(this) {
            final /* synthetic */ PropertyConfigurator this$0;

            {
                this.this$0 = this$0;
            }

            public void run() {
                String access$002 = PropertyConfigurator.access$002(this.this$0, str);
            }
        };
        Analytics.getInstance().postCommandEvenIfDisabled(runnable);
    }

    private String getAppVersion() {
        return this.mAppVersion;
    }

    public void setAppVersion(String appVersion) {
        Runnable runnable;
        final String str = appVersion;
        new Runnable(this) {
            final /* synthetic */ PropertyConfigurator this$0;

            {
                this.this$0 = this$0;
            }

            public void run() {
                String access$102 = PropertyConfigurator.access$102(this.this$0, str);
            }
        };
        Analytics.getInstance().postCommandEvenIfDisabled(runnable);
    }

    private String getAppLocale() {
        return this.mAppLocale;
    }

    public void setAppLocale(String appLocale) {
        Runnable runnable;
        final String str = appLocale;
        new Runnable(this) {
            final /* synthetic */ PropertyConfigurator this$0;

            {
                this.this$0 = this$0;
            }

            public void run() {
                String access$202 = PropertyConfigurator.access$202(this.this$0, str);
            }
        };
        Analytics.getInstance().postCommandEvenIfDisabled(runnable);
    }

    private String getUserId() {
        return this.mUserId;
    }

    public void setUserId(String str) {
        Runnable runnable;
        String userId = str;
        if (UserIdContext.checkUserIdValidForOneCollector(userId)) {
            final String str2 = userId;
            new Runnable(this) {
                final /* synthetic */ PropertyConfigurator this$0;

                {
                    this.this$0 = this$0;
                }

                public void run() {
                    String access$302 = PropertyConfigurator.access$302(this.this$0, UserIdContext.getPrefixedUserId(str2));
                }
            };
            Analytics.getInstance().postCommandEvenIfDisabled(runnable);
        }
    }

    public synchronized void setEventProperty(String str, boolean z) {
        String key = str;
        boolean value = z;
        synchronized (this) {
            EventProperties eventProperties = this.mEventProperties.set(key, value);
        }
    }

    public synchronized void setEventProperty(String str, Date date) {
        String key = str;
        Date value = date;
        synchronized (this) {
            EventProperties eventProperties = this.mEventProperties.set(key, value);
        }
    }

    public synchronized void setEventProperty(String str, double d) {
        String key = str;
        double value = d;
        synchronized (this) {
            EventProperties eventProperties = this.mEventProperties.set(key, value);
        }
    }

    public synchronized void setEventProperty(String str, long j) {
        String key = str;
        long value = j;
        synchronized (this) {
            EventProperties eventProperties = this.mEventProperties.set(key, value);
        }
    }

    public synchronized void setEventProperty(String str, String str2) {
        String key = str;
        String value = str2;
        synchronized (this) {
            EventProperties eventProperties = this.mEventProperties.set(key, value);
        }
    }

    public synchronized void removeEventProperty(String str) {
        String key = str;
        synchronized (this) {
            TypedProperty remove = this.mEventProperties.getProperties().remove(key);
        }
    }

    public void collectDeviceId() {
        Runnable runnable;
        new Runnable(this) {
            final /* synthetic */ PropertyConfigurator this$0;

            {
                this.this$0 = this$0;
            }

            public void run() {
                boolean access$402 = PropertyConfigurator.access$402(this.this$0, true);
            }
        };
        Analytics.getInstance().postCommandEvenIfDisabled(runnable);
    }

    /* access modifiers changed from: package-private */
    public synchronized void mergeEventProperties(EventProperties eventProperties) {
        EventProperties mergedProperties = eventProperties;
        synchronized (this) {
            for (Map.Entry<String, TypedProperty> property : this.mEventProperties.getProperties().entrySet()) {
                String key = property.getKey();
                if (!mergedProperties.getProperties().containsKey(key)) {
                    TypedProperty put = mergedProperties.getProperties().put(key, property.getValue());
                }
            }
        }
    }
}
