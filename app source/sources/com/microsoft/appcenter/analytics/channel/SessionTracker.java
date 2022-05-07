package com.microsoft.appcenter.analytics.channel;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.analytics.ingestion.models.StartSessionLog;
import com.microsoft.appcenter.channel.AbstractChannelListener;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.StartServiceLog;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.context.SessionContext;
import java.util.Date;
import java.util.UUID;

public class SessionTracker extends AbstractChannelListener {
    private static final long SESSION_TIMEOUT = 20000;
    private final Channel mChannel;
    private final String mGroupName;
    private Long mLastPausedTime;
    private long mLastQueuedLogTime;
    private Long mLastResumedTime;
    private UUID mSid;

    public SessionTracker(Channel channel, String groupName) {
        this.mChannel = channel;
        this.mGroupName = groupName;
    }

    public void onPreparingLog(@NonNull Log log, @NonNull String str) {
        Log log2 = log;
        String str2 = str;
        if (!(log2 instanceof StartSessionLog) && !(log2 instanceof StartServiceLog)) {
            Date timestamp = log2.getTimestamp();
            if (timestamp != null) {
                SessionContext.SessionInfo pastSession = SessionContext.getInstance().getSessionAt(timestamp.getTime());
                if (pastSession != null) {
                    log2.setSid(pastSession.getSessionId());
                    return;
                }
                return;
            }
            log2.setSid(this.mSid);
            this.mLastQueuedLogTime = SystemClock.elapsedRealtime();
        }
    }

    @WorkerThread
    private void sendStartSessionIfNeeded() {
        StartSessionLog startSessionLog;
        if (this.mSid == null || hasSessionTimedOut()) {
            this.mSid = UUID.randomUUID();
            SessionContext.getInstance().addSession(this.mSid);
            this.mLastQueuedLogTime = SystemClock.elapsedRealtime();
            new StartSessionLog();
            StartSessionLog startSessionLog2 = startSessionLog;
            startSessionLog2.setSid(this.mSid);
            this.mChannel.enqueue(startSessionLog2, this.mGroupName, 1);
        }
    }

    @WorkerThread
    public void onActivityResumed() {
        AppCenterLog.debug(Analytics.LOG_TAG, "onActivityResumed");
        this.mLastResumedTime = Long.valueOf(SystemClock.elapsedRealtime());
        sendStartSessionIfNeeded();
    }

    @WorkerThread
    public void onActivityPaused() {
        AppCenterLog.debug(Analytics.LOG_TAG, "onActivityPaused");
        Long valueOf = Long.valueOf(SystemClock.elapsedRealtime());
        this.mLastPausedTime = valueOf;
    }

    public void clearSessions() {
        SessionContext.getInstance().clearSessions();
    }

    private boolean hasSessionTimedOut() {
        StringBuilder sb;
        if (this.mLastPausedTime == null) {
            return false;
        }
        boolean noLogSentForLong = SystemClock.elapsedRealtime() - this.mLastQueuedLogTime >= SESSION_TIMEOUT;
        boolean wasBackgroundForLong = this.mLastResumedTime.longValue() - Math.max(this.mLastPausedTime.longValue(), this.mLastQueuedLogTime) >= SESSION_TIMEOUT;
        new StringBuilder();
        AppCenterLog.debug(Analytics.LOG_TAG, sb.append("noLogSentForLong=").append(noLogSentForLong).append(" wasBackgroundForLong=").append(wasBackgroundForLong).toString());
        return noLogSentForLong && wasBackgroundForLong;
    }
}
