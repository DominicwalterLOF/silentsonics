package com.microsoft.appcenter.channel;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.support.annotation.WorkerThread;
import com.microsoft.appcenter.CancellationException;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.http.HttpResponse;
import com.microsoft.appcenter.http.HttpUtils;
import com.microsoft.appcenter.http.ServiceCall;
import com.microsoft.appcenter.http.ServiceCallback;
import com.microsoft.appcenter.ingestion.Ingestion;
import com.microsoft.appcenter.ingestion.models.Device;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.LogContainer;
import com.microsoft.appcenter.ingestion.models.json.LogSerializer;
import com.microsoft.appcenter.ingestion.models.one.PartAUtils;
import com.microsoft.appcenter.persistence.DatabasePersistence;
import com.microsoft.appcenter.persistence.Persistence;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.DeviceInfoHelper;
import com.microsoft.appcenter.utils.IdHelper;
import com.microsoft.appcenter.utils.storage.SharedPreferencesManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class DefaultChannel implements Channel {
    @VisibleForTesting
    static final int CLEAR_BATCH_SIZE = 100;
    private static final long MINIMUM_TRANSMISSION_INTERVAL = 3000;
    @VisibleForTesting
    static final String START_TIMER_PREFIX = "startTimerPrefix.";
    /* access modifiers changed from: private */
    public final Handler mAppCenterHandler;
    private String mAppSecret;
    private final Context mContext;
    private int mCurrentState;
    private Device mDevice;
    private boolean mDiscardLogs;
    private boolean mEnabled;
    private final Map<String, GroupState> mGroupStates;
    private final Ingestion mIngestion;
    private final Set<Ingestion> mIngestions;
    private final UUID mInstallId;
    private final Collection<Channel.Listener> mListeners;
    private final Persistence mPersistence;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DefaultChannel(@android.support.annotation.NonNull android.content.Context r16, java.lang.String r17, @android.support.annotation.NonNull com.microsoft.appcenter.ingestion.models.json.LogSerializer r18, @android.support.annotation.NonNull com.microsoft.appcenter.http.HttpClient r19, @android.support.annotation.NonNull android.os.Handler r20) {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r0
            r7 = r1
            r8 = r2
            r9 = r1
            r10 = r3
            com.microsoft.appcenter.persistence.Persistence r9 = buildDefaultPersistence(r9, r10)
            com.microsoft.appcenter.ingestion.AppCenterIngestion r10 = new com.microsoft.appcenter.ingestion.AppCenterIngestion
            r14 = r10
            r10 = r14
            r11 = r14
            r12 = r4
            r13 = r3
            r11.<init>(r12, r13)
            r11 = r5
            r6.<init>((android.content.Context) r7, (java.lang.String) r8, (com.microsoft.appcenter.persistence.Persistence) r9, (com.microsoft.appcenter.ingestion.Ingestion) r10, (android.os.Handler) r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.appcenter.channel.DefaultChannel.<init>(android.content.Context, java.lang.String, com.microsoft.appcenter.ingestion.models.json.LogSerializer, com.microsoft.appcenter.http.HttpClient, android.os.Handler):void");
    }

    @VisibleForTesting
    DefaultChannel(@NonNull Context context, String appSecret, @NonNull Persistence persistence, @NonNull Ingestion ingestion, @NonNull Handler appCenterHandler) {
        Map<String, GroupState> map;
        Collection<Channel.Listener> collection;
        Set<Ingestion> set;
        this.mContext = context;
        this.mAppSecret = appSecret;
        this.mInstallId = IdHelper.getInstallId();
        new HashMap();
        this.mGroupStates = map;
        new LinkedHashSet();
        this.mListeners = collection;
        this.mPersistence = persistence;
        this.mIngestion = ingestion;
        new HashSet();
        this.mIngestions = set;
        boolean add = this.mIngestions.add(this.mIngestion);
        this.mAppCenterHandler = appCenterHandler;
        this.mEnabled = true;
    }

    private static Persistence buildDefaultPersistence(@NonNull Context context, @NonNull LogSerializer logSerializer) {
        Persistence persistence;
        new DatabasePersistence(context);
        Persistence persistence2 = persistence;
        persistence2.setLogSerializer(logSerializer);
        return persistence2;
    }

    @WorkerThread
    public boolean setMaxStorageSize(long maxStorageSizeInBytes) {
        return this.mPersistence.setMaxStorageSize(maxStorageSizeInBytes);
    }

    private boolean checkStateDidNotChange(GroupState groupState, int stateSnapshot) {
        GroupState groupState2 = groupState;
        return stateSnapshot == this.mCurrentState && groupState2 == this.mGroupStates.get(groupState2.mName);
    }

    @WorkerThread
    public void setAppSecret(@NonNull String appSecret) {
        this.mAppSecret = appSecret;
        if (this.mEnabled) {
            for (GroupState groupState : this.mGroupStates.values()) {
                if (groupState.mIngestion == this.mIngestion) {
                    checkPendingLogs(groupState);
                }
            }
        }
    }

    public void addGroup(String str, int i, long j, int i2, Ingestion ingestion, Channel.GroupListener groupListener) {
        StringBuilder sb;
        GroupState groupState;
        String groupName = str;
        int maxLogsPerBatch = i;
        long batchTimeInterval = j;
        int maxParallelBatches = i2;
        Ingestion ingestion2 = ingestion;
        Channel.GroupListener groupListener2 = groupListener;
        new StringBuilder();
        AppCenterLog.debug("AppCenter", sb.append("addGroup(").append(groupName).append(")").toString());
        Ingestion ingestion3 = ingestion2 == null ? this.mIngestion : ingestion2;
        boolean add = this.mIngestions.add(ingestion3);
        new GroupState(this, groupName, maxLogsPerBatch, batchTimeInterval, maxParallelBatches, ingestion3, groupListener2);
        GroupState groupState2 = groupState;
        GroupState put = this.mGroupStates.put(groupName, groupState2);
        groupState2.mPendingLogCount = this.mPersistence.countLogs(groupName);
        if (!(this.mAppSecret == null && this.mIngestion == ingestion3)) {
            checkPendingLogs(groupState2);
        }
        for (Channel.Listener listener : this.mListeners) {
            listener.onGroupAdded(groupName, groupListener2, batchTimeInterval);
        }
    }

    public void removeGroup(String str) {
        StringBuilder sb;
        String groupName = str;
        new StringBuilder();
        AppCenterLog.debug("AppCenter", sb.append("removeGroup(").append(groupName).append(")").toString());
        GroupState groupState = this.mGroupStates.remove(groupName);
        if (groupState != null) {
            cancelTimer(groupState);
        }
        for (Channel.Listener listener : this.mListeners) {
            listener.onGroupRemoved(groupName);
        }
    }

    public void pauseGroup(String str, String str2) {
        StringBuilder sb;
        StringBuilder sb2;
        String groupName = str;
        String targetToken = str2;
        GroupState groupState = this.mGroupStates.get(groupName);
        if (groupState != null) {
            if (targetToken != null) {
                String targetKey = PartAUtils.getTargetKey(targetToken);
                if (groupState.mPausedTargetKeys.add(targetKey)) {
                    new StringBuilder();
                    AppCenterLog.debug("AppCenter", sb2.append("pauseGroup(").append(groupName).append(", ").append(targetKey).append(")").toString());
                }
            } else if (!groupState.mPaused) {
                new StringBuilder();
                AppCenterLog.debug("AppCenter", sb.append("pauseGroup(").append(groupName).append(")").toString());
                groupState.mPaused = true;
                cancelTimer(groupState);
            }
            for (Channel.Listener listener : this.mListeners) {
                listener.onPaused(groupName, targetToken);
            }
        }
    }

    public void resumeGroup(String str, String str2) {
        StringBuilder sb;
        StringBuilder sb2;
        String groupName = str;
        String targetToken = str2;
        GroupState groupState = this.mGroupStates.get(groupName);
        if (groupState != null) {
            if (targetToken != null) {
                String targetKey = PartAUtils.getTargetKey(targetToken);
                if (groupState.mPausedTargetKeys.remove(targetKey)) {
                    new StringBuilder();
                    AppCenterLog.debug("AppCenter", sb2.append("resumeGroup(").append(groupName).append(", ").append(targetKey).append(")").toString());
                    groupState.mPendingLogCount = this.mPersistence.countLogs(groupName);
                    checkPendingLogs(groupState);
                }
            } else if (groupState.mPaused) {
                new StringBuilder();
                AppCenterLog.debug("AppCenter", sb.append("resumeGroup(").append(groupName).append(")").toString());
                groupState.mPaused = false;
                checkPendingLogs(groupState);
            }
            for (Channel.Listener listener : this.mListeners) {
                listener.onResumed(groupName, targetToken);
            }
        }
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public void setEnabled(boolean z) {
        Exception exc;
        boolean enabled = z;
        if (this.mEnabled != enabled) {
            if (enabled) {
                this.mEnabled = true;
                this.mDiscardLogs = false;
                this.mCurrentState++;
                for (Ingestion ingestion : this.mIngestions) {
                    ingestion.reopen();
                }
                for (GroupState groupState : this.mGroupStates.values()) {
                    checkPendingLogs(groupState);
                }
            } else {
                new CancellationException();
                suspend(true, exc);
            }
            for (Channel.Listener listener : this.mListeners) {
                listener.onGloballyEnabled(enabled);
            }
        }
    }

    public void setLogUrl(String logUrl) {
        this.mIngestion.setLogUrl(logUrl);
    }

    public void clear(String str) {
        StringBuilder sb;
        String groupName = str;
        if (this.mGroupStates.containsKey(groupName)) {
            new StringBuilder();
            AppCenterLog.debug("AppCenter", sb.append("clear(").append(groupName).append(")").toString());
            this.mPersistence.deleteLogs(groupName);
            for (Channel.Listener listener : this.mListeners) {
                listener.onClear(groupName);
            }
        }
    }

    public void invalidateDeviceCache() {
        this.mDevice = null;
    }

    private void suspend(boolean z, Exception exc) {
        StringBuilder sb;
        Channel.GroupListener groupListener;
        boolean deleteLogs = z;
        Exception exception = exc;
        this.mEnabled = false;
        this.mDiscardLogs = deleteLogs;
        this.mCurrentState++;
        for (GroupState groupState : this.mGroupStates.values()) {
            cancelTimer(groupState);
            Iterator<Map.Entry<String, List<Log>>> iterator = groupState.mSendingBatches.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry next = iterator.next();
                iterator.remove();
                if (deleteLogs && (groupListener = groupState.mListener) != null) {
                    for (Log log : (List) next.getValue()) {
                        groupListener.onFailure(log, exception);
                    }
                }
            }
        }
        for (Ingestion ingestion : this.mIngestions) {
            try {
                ingestion.close();
            } catch (IOException e) {
                new StringBuilder();
                AppCenterLog.error("AppCenter", sb.append("Failed to close ingestion: ").append(ingestion).toString(), e);
            }
        }
        if (deleteLogs) {
            for (GroupState groupState2 : this.mGroupStates.values()) {
                deleteLogsOnSuspended(groupState2);
            }
            return;
        }
        this.mPersistence.clearPendingLogState();
    }

    private void deleteLogsOnSuspended(GroupState groupState) {
        List<Log> list;
        Exception exc;
        GroupState groupState2 = groupState;
        new ArrayList<>();
        List<Log> logs = list;
        String logs2 = this.mPersistence.getLogs(groupState2.mName, Collections.emptyList(), 100, logs);
        if (logs.size() > 0 && groupState2.mListener != null) {
            for (Log log : logs) {
                groupState2.mListener.onBeforeSending(log);
                new CancellationException();
                groupState2.mListener.onFailure(log, exc);
            }
        }
        if (logs.size() < 100 || groupState2.mListener == null) {
            this.mPersistence.deleteLogs(groupState2.mName);
        } else {
            deleteLogsOnSuspended(groupState2);
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void cancelTimer(GroupState groupState) {
        StringBuilder sb;
        GroupState groupState2 = groupState;
        if (groupState2.mScheduled) {
            groupState2.mScheduled = false;
            this.mAppCenterHandler.removeCallbacks(groupState2.mRunnable);
            new StringBuilder();
            SharedPreferencesManager.remove(sb.append(START_TIMER_PREFIX).append(groupState2.mName).toString());
        }
    }

    /* access modifiers changed from: private */
    public void triggerIngestion(@NonNull GroupState groupState) {
        StringBuilder sb;
        List<Log> list;
        StringBuilder sb2;
        StringBuilder sb3;
        GroupState groupState2 = groupState;
        if (this.mEnabled) {
            int pendingLogCount = groupState2.mPendingLogCount;
            int maxFetch = Math.min(pendingLogCount, groupState2.mMaxLogsPerBatch);
            new StringBuilder();
            AppCenterLog.debug("AppCenter", sb.append("triggerIngestion(").append(groupState2.mName).append(") pendingLogCount=").append(pendingLogCount).toString());
            cancelTimer(groupState2);
            if (groupState2.mSendingBatches.size() == groupState2.mMaxParallelBatches) {
                new StringBuilder();
                AppCenterLog.debug("AppCenter", sb3.append("Already sending ").append(groupState2.mMaxParallelBatches).append(" batches of analytics data to the server.").toString());
                return;
            }
            new ArrayList<>(maxFetch);
            List<Log> batch = list;
            String batchId = this.mPersistence.getLogs(groupState2.mName, groupState2.mPausedTargetKeys, maxFetch, batch);
            groupState2.mPendingLogCount -= maxFetch;
            if (batchId != null) {
                new StringBuilder();
                AppCenterLog.debug("AppCenter", sb2.append("ingestLogs(").append(groupState2.mName).append(",").append(batchId).append(") pendingLogCount=").append(groupState2.mPendingLogCount).toString());
                if (groupState2.mListener != null) {
                    for (Log log : batch) {
                        groupState2.mListener.onBeforeSending(log);
                    }
                }
                List<Log> put = groupState2.mSendingBatches.put(batchId, batch);
                sendLogs(groupState2, this.mCurrentState, batch, batchId);
            }
        }
    }

    @MainThread
    private void sendLogs(GroupState groupState, int currentState, List<Log> batch, String batchId) {
        LogContainer logContainer;
        ServiceCallback serviceCallback;
        Runnable runnable;
        GroupState groupState2 = groupState;
        new LogContainer();
        LogContainer logContainer2 = logContainer;
        logContainer2.setLogs(batch);
        final GroupState groupState3 = groupState2;
        final String str = batchId;
        new ServiceCallback(this) {
            final /* synthetic */ DefaultChannel this$0;

            {
                this.this$0 = this$0;
            }

            public void onCallSucceeded(HttpResponse httpResponse) {
                Runnable runnable;
                HttpResponse httpResponse2 = httpResponse;
                new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 this$1;

                    {
                        this.this$1 = this$1;
                    }

                    public void run() {
                        this.this$1.this$0.handleSendingSuccess(groupState3, str);
                    }
                };
                boolean post = this.this$0.mAppCenterHandler.post(runnable);
            }

            public void onCallFailed(Exception e) {
                Runnable runnable;
                final Exception exc = e;
                new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 this$1;

                    {
                        this.this$1 = this$1;
                    }

                    public void run() {
                        this.this$1.this$0.handleSendingFailure(groupState3, str, exc);
                    }
                };
                boolean post = this.this$0.mAppCenterHandler.post(runnable);
            }
        };
        ServiceCall sendAsync = groupState2.mIngestion.sendAsync(this.mAppSecret, this.mInstallId, logContainer2, serviceCallback);
        final GroupState groupState4 = groupState2;
        final int i = currentState;
        new Runnable(this) {
            final /* synthetic */ DefaultChannel this$0;

            {
                this.this$0 = this$0;
            }

            public void run() {
                this.this$0.checkPendingLogsAfterPost(groupState4, i);
            }
        };
        boolean post = this.mAppCenterHandler.post(runnable);
    }

    /* access modifiers changed from: private */
    public void checkPendingLogsAfterPost(@NonNull GroupState groupState, int currentState) {
        GroupState groupState2 = groupState;
        if (checkStateDidNotChange(groupState2, currentState)) {
            checkPendingLogs(groupState2);
        }
    }

    /* access modifiers changed from: private */
    public void handleSendingSuccess(@NonNull GroupState groupState, @NonNull String str) {
        GroupState groupState2 = groupState;
        String batchId = str;
        List<Log> removedLogsForBatchId = groupState2.mSendingBatches.remove(batchId);
        if (removedLogsForBatchId != null) {
            this.mPersistence.deleteLogs(groupState2.mName, batchId);
            Channel.GroupListener groupListener = groupState2.mListener;
            if (groupListener != null) {
                for (Log log : removedLogsForBatchId) {
                    groupListener.onSuccess(log);
                }
            }
            checkPendingLogs(groupState2);
        }
    }

    /* access modifiers changed from: private */
    public void handleSendingFailure(@NonNull GroupState groupState, @NonNull String str, @NonNull Exception exc) {
        StringBuilder sb;
        GroupState groupState2 = groupState;
        String batchId = str;
        Exception e = exc;
        String groupName = groupState2.mName;
        List<Log> removedLogsForBatchId = groupState2.mSendingBatches.remove(batchId);
        if (removedLogsForBatchId != null) {
            new StringBuilder();
            AppCenterLog.error("AppCenter", sb.append("Sending logs groupName=").append(groupName).append(" id=").append(batchId).append(" failed").toString(), e);
            boolean recoverableError = HttpUtils.isRecoverableError(e);
            if (recoverableError) {
                groupState2.mPendingLogCount += removedLogsForBatchId.size();
            } else {
                Channel.GroupListener groupListener = groupState2.mListener;
                if (groupListener != null) {
                    for (Log log : removedLogsForBatchId) {
                        groupListener.onFailure(log, e);
                    }
                }
            }
            suspend(!recoverableError, e);
        }
    }

    public void enqueue(@NonNull Log log, @NonNull String str, int i) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        Date date;
        Exception exc;
        StringBuilder sb5;
        Log log2 = log;
        String groupName = str;
        int flags = i;
        GroupState groupState = this.mGroupStates.get(groupName);
        if (groupState == null) {
            new StringBuilder();
            AppCenterLog.error("AppCenter", sb5.append("Invalid group name:").append(groupName).toString());
        } else if (this.mDiscardLogs) {
            AppCenterLog.warn("AppCenter", "Channel is disabled, the log is discarded.");
            if (groupState.mListener != null) {
                groupState.mListener.onBeforeSending(log2);
                new CancellationException();
                groupState.mListener.onFailure(log2, exc);
            }
        } else {
            for (Channel.Listener listener : this.mListeners) {
                listener.onPreparingLog(log2, groupName);
            }
            if (log2.getDevice() == null) {
                if (this.mDevice == null) {
                    try {
                        this.mDevice = DeviceInfoHelper.getDeviceInfo(this.mContext);
                    } catch (DeviceInfoHelper.DeviceInfoException e) {
                        AppCenterLog.error("AppCenter", "Device log cannot be generated", e);
                        return;
                    }
                }
                log2.setDevice(this.mDevice);
            }
            if (log2.getTimestamp() == null) {
                new Date();
                log2.setTimestamp(date);
            }
            for (Channel.Listener listener2 : this.mListeners) {
                listener2.onPreparedLog(log2, groupName, flags);
            }
            boolean filteredOut = false;
            for (Channel.Listener listener3 : this.mListeners) {
                filteredOut = filteredOut || listener3.shouldFilter(log2);
            }
            if (filteredOut) {
                new StringBuilder();
                AppCenterLog.debug("AppCenter", sb4.append("Log of type '").append(log2.getType()).append("' was filtered out by listener(s)").toString());
            } else if (this.mAppSecret == null && groupState.mIngestion == this.mIngestion) {
                new StringBuilder();
                AppCenterLog.debug("AppCenter", sb3.append("Log of type '").append(log2.getType()).append("' was not filtered out by listener(s) but no app secret was provided. Not persisting/sending the log.").toString());
            } else {
                try {
                    long putLog = this.mPersistence.putLog(log2, groupName, flags);
                    Iterator<String> targetKeys = log2.getTransmissionTargetTokens().iterator();
                    String targetKey = targetKeys.hasNext() ? PartAUtils.getTargetKey(targetKeys.next()) : null;
                    if (groupState.mPausedTargetKeys.contains(targetKey)) {
                        new StringBuilder();
                        AppCenterLog.debug("AppCenter", sb2.append("Transmission target ikey=").append(targetKey).append(" is paused.").toString());
                        return;
                    }
                    groupState.mPendingLogCount++;
                    new StringBuilder();
                    AppCenterLog.debug("AppCenter", sb.append("enqueue(").append(groupState.mName).append(") pendingLogCount=").append(groupState.mPendingLogCount).toString());
                    if (this.mEnabled) {
                        checkPendingLogs(groupState);
                    } else {
                        AppCenterLog.debug("AppCenter", "Channel is temporarily disabled, log was saved to disk.");
                    }
                } catch (Persistence.PersistenceException e2) {
                    Persistence.PersistenceException e3 = e2;
                    AppCenterLog.error("AppCenter", "Error persisting log", e3);
                    if (groupState.mListener != null) {
                        groupState.mListener.onBeforeSending(log2);
                        groupState.mListener.onFailure(log2, e3);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void checkPendingLogs(@NonNull GroupState groupState) {
        GroupState groupState2 = groupState;
        Object[] objArr = new Object[3];
        objArr[0] = groupState2.mName;
        Object[] objArr2 = objArr;
        objArr2[1] = Integer.valueOf(groupState2.mPendingLogCount);
        Object[] objArr3 = objArr2;
        objArr3[2] = Long.valueOf(groupState2.mBatchTimeInterval);
        AppCenterLog.debug("AppCenter", String.format("checkPendingLogs(%s) pendingLogCount=%s batchTimeInterval=%s", objArr3));
        Long batchTimeInterval = resolveTriggerInterval(groupState2);
        if (batchTimeInterval != null && !groupState2.mPaused) {
            if (batchTimeInterval.longValue() == 0) {
                triggerIngestion(groupState2);
            } else if (!groupState2.mScheduled) {
                groupState2.mScheduled = true;
                boolean postDelayed = this.mAppCenterHandler.postDelayed(groupState2.mRunnable, batchTimeInterval.longValue());
            }
        }
    }

    @WorkerThread
    private Long resolveTriggerInterval(@NonNull GroupState groupState) {
        GroupState groupState2 = groupState;
        if (groupState2.mBatchTimeInterval > MINIMUM_TRANSMISSION_INTERVAL) {
            return resolveCustomTriggerInterval(groupState2);
        }
        return resolveDefaultTriggerInterval(groupState2);
    }

    @WorkerThread
    private Long resolveCustomTriggerInterval(@NonNull GroupState groupState) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        GroupState groupState2 = groupState;
        long now = System.currentTimeMillis();
        new StringBuilder();
        long startTimer = SharedPreferencesManager.getLong(sb.append(START_TIMER_PREFIX).append(groupState2.mName).toString());
        if (groupState2.mPendingLogCount <= 0) {
            if (startTimer + groupState2.mBatchTimeInterval < now) {
                new StringBuilder();
                SharedPreferencesManager.remove(sb2.append(START_TIMER_PREFIX).append(groupState2.mName).toString());
                new StringBuilder();
                AppCenterLog.debug("AppCenter", sb3.append("The timer for ").append(groupState2.mName).append(" channel finished.").toString());
            }
            return null;
        } else if (startTimer != 0 && startTimer <= now) {
            return Long.valueOf(Math.max(groupState2.mBatchTimeInterval - (now - startTimer), 0));
        } else {
            new StringBuilder();
            SharedPreferencesManager.putLong(sb4.append(START_TIMER_PREFIX).append(groupState2.mName).toString(), now);
            new StringBuilder();
            AppCenterLog.debug("AppCenter", sb5.append("The timer value for ").append(groupState2.mName).append(" has been saved.").toString());
            return Long.valueOf(groupState2.mBatchTimeInterval);
        }
    }

    private Long resolveDefaultTriggerInterval(@NonNull GroupState groupState) {
        GroupState groupState2 = groupState;
        if (groupState2.mPendingLogCount >= groupState2.mMaxLogsPerBatch) {
            return null;
        }
        return groupState2.mPendingLogCount > 0 ? Long.valueOf(groupState2.mBatchTimeInterval) : null;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public GroupState getGroupState(String groupName) {
        return this.mGroupStates.get(groupName);
    }

    public void addListener(Channel.Listener listener) {
        boolean add = this.mListeners.add(listener);
    }

    public void removeListener(Channel.Listener listener) {
        boolean remove = this.mListeners.remove(listener);
    }

    public void shutdown() {
        Exception exc;
        new CancellationException();
        suspend(false, exc);
    }

    @VisibleForTesting
    class GroupState {
        final long mBatchTimeInterval;
        final Ingestion mIngestion;
        final Channel.GroupListener mListener;
        final int mMaxLogsPerBatch;
        final int mMaxParallelBatches;
        final String mName;
        boolean mPaused;
        final Collection<String> mPausedTargetKeys;
        int mPendingLogCount;
        final Runnable mRunnable;
        boolean mScheduled;
        final Map<String, List<Log>> mSendingBatches;
        final /* synthetic */ DefaultChannel this$0;

        GroupState(DefaultChannel this$02, String name, int maxLogsPerBatch, long batchTimeInterval, int maxParallelBatches, Ingestion ingestion, Channel.GroupListener listener) {
            Map<String, List<Log>> map;
            Collection<String> collection;
            Runnable runnable;
            this.this$0 = this$02;
            new HashMap();
            this.mSendingBatches = map;
            new HashSet();
            this.mPausedTargetKeys = collection;
            new Runnable(this) {
                final /* synthetic */ GroupState this$1;

                {
                    this.this$1 = this$1;
                }

                public void run() {
                    this.this$1.mScheduled = false;
                    this.this$1.this$0.triggerIngestion(this.this$1);
                }
            };
            this.mRunnable = runnable;
            this.mName = name;
            this.mMaxLogsPerBatch = maxLogsPerBatch;
            this.mBatchTimeInterval = batchTimeInterval;
            this.mMaxParallelBatches = maxParallelBatches;
            this.mIngestion = ingestion;
            this.mListener = listener;
        }
    }
}
