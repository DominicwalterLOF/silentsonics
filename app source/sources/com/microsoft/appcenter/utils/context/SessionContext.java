package com.microsoft.appcenter.utils.context;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.support.annotation.WorkerThread;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.storage.SharedPreferencesManager;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;

public class SessionContext {
    private static final String STORAGE_KEY = "sessions";
    private static final String STORAGE_KEY_VALUE_SEPARATOR = "/";
    private static final int STORAGE_MAX_SESSIONS = 10;
    private static SessionContext sInstance;
    private final long mAppLaunchTimestamp = System.currentTimeMillis();
    private final NavigableMap<Long, SessionInfo> mSessions;

    @WorkerThread
    private SessionContext() {
        NavigableMap<Long, SessionInfo> navigableMap;
        StringBuilder sb;
        StringBuilder sb2;
        long appLaunchTimestamp;
        Object obj;
        new TreeMap();
        this.mSessions = navigableMap;
        Set<String> storedSessions = SharedPreferencesManager.getStringSet(STORAGE_KEY);
        if (storedSessions != null) {
            for (String session : storedSessions) {
                String[] split = session.split(STORAGE_KEY_VALUE_SEPARATOR, -1);
                try {
                    long time = Long.parseLong(split[0]);
                    String rawSid = split[1];
                    UUID sid = rawSid.isEmpty() ? null : UUID.fromString(rawSid);
                    if (split.length > 2) {
                        appLaunchTimestamp = Long.parseLong(split[2]);
                    } else {
                        appLaunchTimestamp = time;
                    }
                    new SessionInfo(time, sid, appLaunchTimestamp);
                    Object put = this.mSessions.put(Long.valueOf(time), obj);
                } catch (RuntimeException e) {
                    new StringBuilder();
                    AppCenterLog.warn("AppCenter", sb2.append("Ignore invalid session in store: ").append(session).toString(), e);
                }
            }
        }
        new StringBuilder();
        AppCenterLog.debug("AppCenter", sb.append("Loaded stored sessions: ").append(this.mSessions).toString());
        addSession((UUID) null);
    }

    @WorkerThread
    public static synchronized SessionContext getInstance() {
        SessionContext sessionContext;
        SessionContext sessionContext2;
        synchronized (SessionContext.class) {
            if (sInstance == null) {
                new SessionContext();
                sInstance = sessionContext2;
            }
            sessionContext = sInstance;
        }
        return sessionContext;
    }

    @VisibleForTesting
    public static synchronized void unsetInstance() {
        synchronized (SessionContext.class) {
            sInstance = null;
        }
    }

    public synchronized void addSession(UUID uuid) {
        Object obj;
        Set set;
        UUID sessionId = uuid;
        synchronized (this) {
            long now = System.currentTimeMillis();
            new SessionInfo(now, sessionId, this.mAppLaunchTimestamp);
            Object put = this.mSessions.put(Long.valueOf(now), obj);
            if (this.mSessions.size() > 10) {
                Map.Entry<Long, SessionInfo> pollFirstEntry = this.mSessions.pollFirstEntry();
            }
            new LinkedHashSet();
            Set set2 = set;
            for (SessionInfo session : this.mSessions.values()) {
                boolean add = set2.add(session.toString());
            }
            SharedPreferencesManager.putStringSet(STORAGE_KEY, set2);
        }
    }

    public synchronized SessionInfo getSessionAt(long j) {
        SessionInfo sessionInfo;
        long timestamp = j;
        synchronized (this) {
            Map.Entry<Long, SessionInfo> pastEntry = this.mSessions.floorEntry(Long.valueOf(timestamp));
            if (pastEntry != null) {
                sessionInfo = pastEntry.getValue();
            } else {
                sessionInfo = null;
            }
        }
        return sessionInfo;
    }

    public synchronized void clearSessions() {
        synchronized (this) {
            this.mSessions.clear();
            SharedPreferencesManager.remove(STORAGE_KEY);
        }
    }

    public static class SessionInfo {
        private final long mAppLaunchTimestamp;
        private final UUID mSessionId;
        private final long mTimestamp;

        SessionInfo(long timestamp, UUID sessionId, long appLaunchTimestamp) {
            this.mTimestamp = timestamp;
            this.mSessionId = sessionId;
            this.mAppLaunchTimestamp = appLaunchTimestamp;
        }

        /* access modifiers changed from: package-private */
        public long getTimestamp() {
            return this.mTimestamp;
        }

        public UUID getSessionId() {
            return this.mSessionId;
        }

        public long getAppLaunchTimestamp() {
            return this.mAppLaunchTimestamp;
        }

        @NonNull
        public String toString() {
            StringBuilder sb;
            StringBuilder sb2;
            StringBuilder sb3;
            new StringBuilder();
            String rawSession = sb.append(getTimestamp()).append(SessionContext.STORAGE_KEY_VALUE_SEPARATOR).toString();
            if (getSessionId() != null) {
                new StringBuilder();
                rawSession = sb3.append(rawSession).append(getSessionId()).toString();
            }
            new StringBuilder();
            return sb2.append(rawSession).append(SessionContext.STORAGE_KEY_VALUE_SEPARATOR).append(getAppLaunchTimestamp()).toString();
        }
    }
}
