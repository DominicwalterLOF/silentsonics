package com.microsoft.appcenter.channel;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.ingestion.Ingestion;
import com.microsoft.appcenter.ingestion.OneCollectorIngestion;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.json.LogSerializer;
import com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog;
import com.microsoft.appcenter.ingestion.models.one.SdkExtension;
import com.microsoft.appcenter.utils.AppCenterLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class OneCollectorChannelListener extends AbstractChannelListener {
    @VisibleForTesting
    static final String ONE_COLLECTOR_GROUP_NAME_SUFFIX = "/one";
    @VisibleForTesting
    static final int ONE_COLLECTOR_TRIGGER_COUNT = 50;
    @VisibleForTesting
    static final int ONE_COLLECTOR_TRIGGER_MAX_PARALLEL_REQUESTS = 2;
    private final Channel mChannel;
    private final Map<String, EpochAndSeq> mEpochsAndSeqsByIKey;
    private final Ingestion mIngestion;
    private final UUID mInstallId;
    private final LogSerializer mLogSerializer;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public OneCollectorChannelListener(@android.support.annotation.NonNull com.microsoft.appcenter.channel.Channel r12, @android.support.annotation.NonNull com.microsoft.appcenter.ingestion.models.json.LogSerializer r13, @android.support.annotation.NonNull com.microsoft.appcenter.http.HttpClient r14, @android.support.annotation.NonNull java.util.UUID r15) {
        /*
            r11 = this;
            r0 = r11
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r0
            com.microsoft.appcenter.ingestion.OneCollectorIngestion r6 = new com.microsoft.appcenter.ingestion.OneCollectorIngestion
            r10 = r6
            r6 = r10
            r7 = r10
            r8 = r3
            r9 = r2
            r7.<init>(r8, r9)
            r7 = r1
            r8 = r2
            r9 = r4
            r5.<init>((com.microsoft.appcenter.ingestion.OneCollectorIngestion) r6, (com.microsoft.appcenter.channel.Channel) r7, (com.microsoft.appcenter.ingestion.models.json.LogSerializer) r8, (java.util.UUID) r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.appcenter.channel.OneCollectorChannelListener.<init>(com.microsoft.appcenter.channel.Channel, com.microsoft.appcenter.ingestion.models.json.LogSerializer, com.microsoft.appcenter.http.HttpClient, java.util.UUID):void");
    }

    @VisibleForTesting
    OneCollectorChannelListener(@NonNull OneCollectorIngestion ingestion, @NonNull Channel channel, @NonNull LogSerializer logSerializer, @NonNull UUID installId) {
        Map<String, EpochAndSeq> map;
        new HashMap();
        this.mEpochsAndSeqsByIKey = map;
        this.mChannel = channel;
        this.mLogSerializer = logSerializer;
        this.mInstallId = installId;
        this.mIngestion = ingestion;
    }

    public void setLogUrl(@NonNull String logUrl) {
        this.mIngestion.setLogUrl(logUrl);
    }

    public void onGroupAdded(@NonNull String str, Channel.GroupListener groupListener, long j) {
        String groupName = str;
        Channel.GroupListener groupListener2 = groupListener;
        long batchTimeInterval = j;
        if (!isOneCollectorGroup(groupName)) {
            this.mChannel.addGroup(getOneCollectorGroupName(groupName), 50, batchTimeInterval, 2, this.mIngestion, groupListener2);
        }
    }

    public void onGroupRemoved(@NonNull String str) {
        String groupName = str;
        if (!isOneCollectorGroup(groupName)) {
            this.mChannel.removeGroup(getOneCollectorGroupName(groupName));
        }
    }

    public void onPreparedLog(@NonNull Log log, @NonNull String str, int i) {
        StringBuilder sb;
        EpochAndSeq epochAndSeq;
        Log log2 = log;
        String groupName = str;
        int flags = i;
        if (isOneCollectorCompatible(log2)) {
            try {
                Collection<CommonSchemaLog> commonSchemaLogs = this.mLogSerializer.toCommonSchemaLog(log2);
                for (CommonSchemaLog commonSchemaLog : commonSchemaLogs) {
                    commonSchemaLog.setFlags(Long.valueOf((long) flags));
                    EpochAndSeq epochAndSeq2 = this.mEpochsAndSeqsByIKey.get(commonSchemaLog.getIKey());
                    if (epochAndSeq2 == null) {
                        new EpochAndSeq(UUID.randomUUID().toString());
                        epochAndSeq2 = epochAndSeq;
                        EpochAndSeq put = this.mEpochsAndSeqsByIKey.put(commonSchemaLog.getIKey(), epochAndSeq2);
                    }
                    SdkExtension sdk = commonSchemaLog.getExt().getSdk();
                    sdk.setEpoch(epochAndSeq2.epoch);
                    EpochAndSeq epochAndSeq3 = epochAndSeq2;
                    long j = epochAndSeq3.seq + 1;
                    long j2 = j;
                    epochAndSeq3.seq = j2;
                    sdk.setSeq(Long.valueOf(j));
                    sdk.setInstallId(this.mInstallId);
                }
                String oneCollectorGroupName = getOneCollectorGroupName(groupName);
                for (CommonSchemaLog commonSchemaLog2 : commonSchemaLogs) {
                    this.mChannel.enqueue(commonSchemaLog2, oneCollectorGroupName, flags);
                }
            } catch (IllegalArgumentException e) {
                new StringBuilder();
                AppCenterLog.error("AppCenter", sb.append("Cannot send a log to one collector: ").append(e.getMessage()).toString());
            }
        }
    }

    public boolean shouldFilter(@NonNull Log log) {
        return isOneCollectorCompatible(log);
    }

    private static String getOneCollectorGroupName(@NonNull String groupName) {
        StringBuilder sb;
        new StringBuilder();
        return sb.append(groupName).append(ONE_COLLECTOR_GROUP_NAME_SUFFIX).toString();
    }

    public void onClear(@NonNull String str) {
        String groupName = str;
        if (!isOneCollectorGroup(groupName)) {
            this.mChannel.clear(getOneCollectorGroupName(groupName));
        }
    }

    public void onPaused(@NonNull String str, String str2) {
        String groupName = str;
        String targetToken = str2;
        if (!isOneCollectorGroup(groupName)) {
            this.mChannel.pauseGroup(getOneCollectorGroupName(groupName), targetToken);
        }
    }

    public void onResumed(@NonNull String str, String str2) {
        String groupName = str;
        String targetToken = str2;
        if (!isOneCollectorGroup(groupName)) {
            this.mChannel.resumeGroup(getOneCollectorGroupName(groupName), targetToken);
        }
    }

    private static boolean isOneCollectorGroup(@NonNull String groupName) {
        return groupName.endsWith(ONE_COLLECTOR_GROUP_NAME_SUFFIX);
    }

    private static boolean isOneCollectorCompatible(@NonNull Log log) {
        Log log2 = log;
        return !(log2 instanceof CommonSchemaLog) && !log2.getTransmissionTargetTokens().isEmpty();
    }

    public void onGloballyEnabled(boolean isEnabled) {
        if (!isEnabled) {
            this.mEpochsAndSeqsByIKey.clear();
        }
    }

    private static class EpochAndSeq {
        final String epoch;
        long seq;

        EpochAndSeq(String epoch2) {
            this.epoch = epoch2;
        }
    }
}
