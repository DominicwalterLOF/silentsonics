package com.microsoft.appcenter.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.microsoft.appcenter.Constants;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.crypto.CryptoUtils;
import com.microsoft.appcenter.utils.storage.DatabaseManager;
import com.microsoft.appcenter.utils.storage.FileManager;
import com.microsoft.appcenter.utils.storage.SQLiteUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;

public class DatabasePersistence extends Persistence {
    private static final String COLUMN_DATA_TYPE = "type";
    @VisibleForTesting
    static final String COLUMN_GROUP = "persistence_group";
    @VisibleForTesting
    static final String COLUMN_LOG = "log";
    @VisibleForTesting
    static final String COLUMN_PRIORITY = "priority";
    @VisibleForTesting
    static final String COLUMN_TARGET_KEY = "target_key";
    @VisibleForTesting
    static final String COLUMN_TARGET_TOKEN = "target_token";
    @VisibleForTesting
    static final String CREATE_LOGS_SQL = "CREATE TABLE IF NOT EXISTS `logs`(`oid` INTEGER PRIMARY KEY AUTOINCREMENT,`target_token` TEXT,`type` TEXT,`priority` INTEGER,`log` TEXT,`persistence_group` TEXT,`target_key` TEXT);";
    private static final String CREATE_PRIORITY_INDEX_LOGS = "CREATE INDEX `ix_logs_priority` ON logs (`priority`)";
    @VisibleForTesting
    static final String DATABASE = "com.microsoft.appcenter.persistence";
    private static final String DROP_LOGS_SQL = "DROP TABLE `logs`";
    private static final String GET_SORT_ORDER = "priority DESC, oid";
    private static final String PAYLOAD_FILE_EXTENSION = ".json";
    private static final String PAYLOAD_LARGE_DIRECTORY = "/appcenter/database_large_payloads";
    private static final int PAYLOAD_MAX_SIZE = 1992294;
    @VisibleForTesting
    static final ContentValues SCHEMA = getContentValues("", "", "", "", "", 0);
    @VisibleForTesting
    static final String TABLE = "logs";
    private static final int VERSION = 6;
    @VisibleForTesting
    static final int VERSION_TIMESTAMP_COLUMN = 5;
    private final Context mContext;
    @VisibleForTesting
    final DatabaseManager mDatabaseManager;
    private final File mLargePayloadDirectory;
    @VisibleForTesting
    final Set<Long> mPendingDbIdentifiers;
    @VisibleForTesting
    final Map<String, List<Long>> mPendingDbIdentifiersGroups;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DatabasePersistence(Context context) {
        this(context, 6, SCHEMA);
    }

    DatabasePersistence(Context context, int version, ContentValues schema) {
        Map<String, List<Long>> map;
        Set<Long> set;
        DatabaseManager databaseManager;
        DatabaseManager.Listener listener;
        File file;
        StringBuilder sb;
        Context context2 = context;
        this.mContext = context2;
        new HashMap();
        this.mPendingDbIdentifiersGroups = map;
        new HashSet();
        this.mPendingDbIdentifiers = set;
        new DatabaseManager.Listener(this) {
            final /* synthetic */ DatabasePersistence this$0;

            {
                this.this$0 = this$0;
            }

            public void onCreate(SQLiteDatabase db) {
                db.execSQL(DatabasePersistence.CREATE_PRIORITY_INDEX_LOGS);
            }

            public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
                SQLiteDatabase db = sQLiteDatabase;
                int i3 = i;
                int i4 = i2;
                db.execSQL(DatabasePersistence.DROP_LOGS_SQL);
                db.execSQL(DatabasePersistence.CREATE_LOGS_SQL);
                db.execSQL(DatabasePersistence.CREATE_PRIORITY_INDEX_LOGS);
            }
        };
        new DatabaseManager(context2, DATABASE, TABLE, version, schema, CREATE_LOGS_SQL, listener);
        this.mDatabaseManager = databaseManager;
        new StringBuilder();
        new File(sb.append(Constants.FILES_PATH).append(PAYLOAD_LARGE_DIRECTORY).toString());
        this.mLargePayloadDirectory = file;
        boolean mkdirs = this.mLargePayloadDirectory.mkdirs();
    }

    private static ContentValues getContentValues(@Nullable String group, @Nullable String logJ, String targetToken, String type, String targetKey, int priority) {
        ContentValues contentValues;
        new ContentValues();
        ContentValues values = contentValues;
        values.put(COLUMN_GROUP, group);
        values.put(COLUMN_LOG, logJ);
        values.put(COLUMN_TARGET_TOKEN, targetToken);
        values.put("type", type);
        values.put(COLUMN_TARGET_KEY, targetKey);
        values.put("priority", Integer.valueOf(priority));
        return values;
    }

    public boolean setMaxStorageSize(long maxStorageSizeInBytes) {
        return this.mDatabaseManager.setMaxSize(maxStorageSizeInBytes);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0085, code lost:
        r20 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0086, code lost:
        r7 = r20;
        r20 = r27;
        new com.microsoft.appcenter.persistence.Persistence.PersistenceException("Cannot convert to JSON string.", r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0098, code lost:
        throw r20;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0085 A[ExcHandler: JSONException (r20v4 'e' org.json.JSONException A[CUSTOM_DECLARE]), Splitter:B:1:0x000b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long putLog(@android.support.annotation.NonNull com.microsoft.appcenter.ingestion.models.Log r29, @android.support.annotation.NonNull java.lang.String r30, @android.support.annotation.IntRange(from = 1, to = 2) int r31) throws com.microsoft.appcenter.persistence.Persistence.PersistenceException {
        /*
            r28 = this;
            r3 = r28
            r4 = r29
            r5 = r30
            r6 = r31
            java.lang.String r20 = "AppCenter"
            java.lang.StringBuilder r21 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r27 = r21
            r21 = r27
            r22 = r27
            r22.<init>()     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            java.lang.String r22 = "Storing a log to the Persistence database for log type "
            java.lang.StringBuilder r21 = r21.append(r22)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r22 = r4
            java.lang.String r22 = r22.getType()     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            java.lang.StringBuilder r21 = r21.append(r22)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            java.lang.String r22 = " with flags="
            java.lang.StringBuilder r21 = r21.append(r22)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r22 = r6
            java.lang.StringBuilder r21 = r21.append(r22)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            java.lang.String r21 = r21.toString()     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            com.microsoft.appcenter.utils.AppCenterLog.debug(r20, r21)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r20 = r3
            com.microsoft.appcenter.ingestion.models.json.LogSerializer r20 = r20.getLogSerializer()     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r21 = r4
            java.lang.String r20 = r20.serializeLog(r21)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r7 = r20
            r20 = r7
            java.lang.String r21 = "UTF-8"
            byte[] r20 = r20.getBytes(r21)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r0 = r20
            int r0 = r0.length     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r20 = r0
            r9 = r20
            r20 = r9
            r21 = 1992294(0x1e6666, float:2.791799E-39)
            r0 = r20
            r1 = r21
            if (r0 < r1) goto L_0x0099
            r20 = 1
        L_0x0066:
            r10 = r20
            r20 = r4
            r0 = r20
            boolean r0 = r0 instanceof com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r20 = r0
            if (r20 == 0) goto L_0x0103
            r20 = r10
            if (r20 == 0) goto L_0x009c
            com.microsoft.appcenter.persistence.Persistence$PersistenceException r20 = new com.microsoft.appcenter.persistence.Persistence$PersistenceException     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r27 = r20
            r20 = r27
            r21 = r27
            java.lang.String r22 = "Log is larger than 1992294 bytes, cannot send to OneCollector."
            r21.<init>(r22)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            throw r20     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
        L_0x0085:
            r20 = move-exception
            r7 = r20
            com.microsoft.appcenter.persistence.Persistence$PersistenceException r20 = new com.microsoft.appcenter.persistence.Persistence$PersistenceException
            r27 = r20
            r20 = r27
            r21 = r27
            java.lang.String r22 = "Cannot convert to JSON string."
            r23 = r7
            r21.<init>(r22, r23)
            throw r20
        L_0x0099:
            r20 = 0
            goto L_0x0066
        L_0x009c:
            r20 = r4
            java.util.Set r20 = r20.getTransmissionTargetTokens()     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            java.util.Iterator r20 = r20.iterator()     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            java.lang.Object r20 = r20.next()     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            java.lang.String r20 = (java.lang.String) r20     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r12 = r20
            r20 = r12
            java.lang.String r20 = com.microsoft.appcenter.ingestion.models.one.PartAUtils.getTargetKey(r20)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r11 = r20
            r20 = r3
            r0 = r20
            android.content.Context r0 = r0.mContext     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r20 = r0
            com.microsoft.appcenter.utils.crypto.CryptoUtils r20 = com.microsoft.appcenter.utils.crypto.CryptoUtils.getInstance(r20)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r21 = r12
            java.lang.String r20 = r20.encrypt(r21)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r12 = r20
        L_0x00ca:
            r20 = r3
            r0 = r20
            com.microsoft.appcenter.utils.storage.DatabaseManager r0 = r0.mDatabaseManager     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r20 = r0
            long r20 = r20.getMaxSize()     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r13 = r20
            r20 = r13
            r22 = -1
            int r20 = (r20 > r22 ? 1 : (r20 == r22 ? 0 : -1))
            if (r20 != 0) goto L_0x010c
            com.microsoft.appcenter.persistence.Persistence$PersistenceException r20 = new com.microsoft.appcenter.persistence.Persistence$PersistenceException     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r27 = r20
            r20 = r27
            r21 = r27
            java.lang.String r22 = "Failed to store a log to the Persistence database."
            r21.<init>(r22)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            throw r20     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
        L_0x00ef:
            r20 = move-exception
            r7 = r20
            com.microsoft.appcenter.persistence.Persistence$PersistenceException r20 = new com.microsoft.appcenter.persistence.Persistence$PersistenceException
            r27 = r20
            r20 = r27
            r21 = r27
            java.lang.String r22 = "Cannot save large payload in a file."
            r23 = r7
            r21.<init>(r22, r23)
            throw r20
        L_0x0103:
            r20 = 0
            r11 = r20
            r20 = 0
            r12 = r20
            goto L_0x00ca
        L_0x010c:
            r20 = r10
            if (r20 != 0) goto L_0x0159
            r20 = r13
            r22 = r9
            r0 = r22
            long r0 = (long) r0
            r22 = r0
            int r20 = (r20 > r22 ? 1 : (r20 == r22 ? 0 : -1))
            if (r20 > 0) goto L_0x0159
            com.microsoft.appcenter.persistence.Persistence$PersistenceException r20 = new com.microsoft.appcenter.persistence.Persistence$PersistenceException     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r27 = r20
            r20 = r27
            r21 = r27
            java.lang.StringBuilder r22 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r27 = r22
            r22 = r27
            r23 = r27
            r23.<init>()     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            java.lang.String r23 = "Log is too large ("
            java.lang.StringBuilder r22 = r22.append(r23)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r23 = r9
            java.lang.StringBuilder r22 = r22.append(r23)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            java.lang.String r23 = " bytes) to store in database. Current maximum database size is "
            java.lang.StringBuilder r22 = r22.append(r23)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r23 = r13
            java.lang.StringBuilder r22 = r22.append(r23)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            java.lang.String r23 = " bytes."
            java.lang.StringBuilder r22 = r22.append(r23)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            java.lang.String r22 = r22.toString()     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r21.<init>(r22)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            throw r20     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
        L_0x0159:
            r20 = r5
            r21 = r10
            if (r21 == 0) goto L_0x01c7
            r21 = 0
        L_0x0161:
            r22 = r12
            r23 = r4
            java.lang.String r23 = r23.getType()     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r24 = r11
            r25 = r6
            r26 = 0
            int r25 = com.microsoft.appcenter.Flags.getPersistenceFlag(r25, r26)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            android.content.ContentValues r20 = getContentValues(r20, r21, r22, r23, r24, r25)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r8 = r20
            r20 = r3
            r0 = r20
            com.microsoft.appcenter.utils.storage.DatabaseManager r0 = r0.mDatabaseManager     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r20 = r0
            r21 = r8
            java.lang.String r22 = "priority"
            long r20 = r20.put(r21, r22)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r15 = r20
            r20 = r15
            r22 = -1
            int r20 = (r20 > r22 ? 1 : (r20 == r22 ? 0 : -1))
            if (r20 != 0) goto L_0x01ca
            com.microsoft.appcenter.persistence.Persistence$PersistenceException r20 = new com.microsoft.appcenter.persistence.Persistence$PersistenceException     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r27 = r20
            r20 = r27
            r21 = r27
            java.lang.StringBuilder r22 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r27 = r22
            r22 = r27
            r23 = r27
            r23.<init>()     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            java.lang.String r23 = "Failed to store a log to the Persistence database for log type "
            java.lang.StringBuilder r22 = r22.append(r23)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r23 = r4
            java.lang.String r23 = r23.getType()     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            java.lang.StringBuilder r22 = r22.append(r23)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            java.lang.String r23 = "."
            java.lang.StringBuilder r22 = r22.append(r23)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            java.lang.String r22 = r22.toString()     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r21.<init>(r22)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            throw r20     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
        L_0x01c7:
            r21 = r7
            goto L_0x0161
        L_0x01ca:
            java.lang.String r20 = "AppCenter"
            java.lang.StringBuilder r21 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r27 = r21
            r21 = r27
            r22 = r27
            r22.<init>()     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            java.lang.String r22 = "Stored a log to the Persistence database for log type "
            java.lang.StringBuilder r21 = r21.append(r22)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r22 = r4
            java.lang.String r22 = r22.getType()     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            java.lang.StringBuilder r21 = r21.append(r22)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            java.lang.String r22 = " with databaseId="
            java.lang.StringBuilder r21 = r21.append(r22)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r22 = r15
            java.lang.StringBuilder r21 = r21.append(r22)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            java.lang.String r21 = r21.toString()     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            com.microsoft.appcenter.utils.AppCenterLog.debug(r20, r21)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r20 = r10
            if (r20 == 0) goto L_0x024f
            java.lang.String r20 = "AppCenter"
            java.lang.String r21 = "Payload is larger than what SQLite supports, storing payload in a separate file."
            com.microsoft.appcenter.utils.AppCenterLog.debug(r20, r21)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r20 = r3
            r21 = r5
            java.io.File r20 = r20.getLargePayloadGroupDirectory(r21)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r17 = r20
            r20 = r17
            boolean r20 = r20.mkdir()     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r20 = r3
            r21 = r17
            r22 = r15
            java.io.File r20 = r20.getLargePayloadFile(r21, r22)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r18 = r20
            r20 = r18
            r21 = r7
            com.microsoft.appcenter.utils.storage.FileManager.write((java.io.File) r20, (java.lang.String) r21)     // Catch:{ IOException -> 0x0254, JSONException -> 0x0085 }
            java.lang.String r20 = "AppCenter"
            java.lang.StringBuilder r21 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r27 = r21
            r21 = r27
            r22 = r27
            r22.<init>()     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            java.lang.String r22 = "Payload written to "
            java.lang.StringBuilder r21 = r21.append(r22)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r22 = r18
            java.lang.StringBuilder r21 = r21.append(r22)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            java.lang.String r21 = r21.toString()     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            com.microsoft.appcenter.utils.AppCenterLog.debug(r20, r21)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
        L_0x024f:
            r20 = r15
            r3 = r20
            return r3
        L_0x0254:
            r20 = move-exception
            r19 = r20
            r20 = r3
            r0 = r20
            com.microsoft.appcenter.utils.storage.DatabaseManager r0 = r0.mDatabaseManager     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r20 = r0
            r21 = r15
            r20.delete(r21)     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
            r20 = r19
            throw r20     // Catch:{ JSONException -> 0x0085, IOException -> 0x00ef }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.appcenter.persistence.DatabasePersistence.putLog(com.microsoft.appcenter.ingestion.models.Log, java.lang.String, int):long");
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @NonNull
    public File getLargePayloadGroupDirectory(String group) {
        File file;
        new File(this.mLargePayloadDirectory, group);
        return file;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @NonNull
    public File getLargePayloadFile(File directory, long databaseId) {
        File file;
        StringBuilder sb;
        new StringBuilder();
        new File(directory, sb.append(databaseId).append(".json").toString());
        return file;
    }

    private void deleteLog(File groupLargePayloadDirectory, long j) {
        long id = j;
        boolean delete = getLargePayloadFile(groupLargePayloadDirectory, id).delete();
        this.mDatabaseManager.delete(id);
    }

    public void deleteLogs(@NonNull String str, @NonNull String str2) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        String group = str;
        String id = str2;
        new StringBuilder();
        AppCenterLog.debug("AppCenter", sb.append("Deleting logs from the Persistence database for ").append(group).append(" with ").append(id).toString());
        AppCenterLog.debug("AppCenter", "The IDs for deleting log(s) is/are:");
        Map<String, List<Long>> map = this.mPendingDbIdentifiersGroups;
        new StringBuilder();
        List<Long> dbIdentifiers = map.remove(sb2.append(group).append(id).toString());
        File directory = getLargePayloadGroupDirectory(group);
        if (dbIdentifiers != null) {
            for (Long dbIdentifier : dbIdentifiers) {
                new StringBuilder();
                AppCenterLog.debug("AppCenter", sb3.append("\t").append(dbIdentifier).toString());
                deleteLog(directory, dbIdentifier.longValue());
                boolean remove = this.mPendingDbIdentifiers.remove(dbIdentifier);
            }
        }
    }

    public void deleteLogs(String str) {
        StringBuilder sb;
        StringBuilder sb2;
        String group = str;
        new StringBuilder();
        AppCenterLog.debug("AppCenter", sb.append("Deleting all logs from the Persistence database for ").append(group).toString());
        File directory = getLargePayloadGroupDirectory(group);
        File[] files = directory.listFiles();
        if (files != null) {
            File[] fileArr = files;
            int length = fileArr.length;
            for (int i = 0; i < length; i++) {
                boolean delete = fileArr[i].delete();
            }
        }
        boolean delete2 = directory.delete();
        new StringBuilder();
        AppCenterLog.debug("AppCenter", sb2.append("Deleted ").append(this.mDatabaseManager.delete(COLUMN_GROUP, group)).append(" logs.").toString());
        Iterator<String> iterator = this.mPendingDbIdentifiersGroups.keySet().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().startsWith(group)) {
                iterator.remove();
            }
        }
    }

    public int countLogs(@NonNull String str) {
        Cursor cursor;
        String group = str;
        SQLiteQueryBuilder builder = SQLiteUtils.newSQLiteQueryBuilder();
        builder.appendWhere("persistence_group = ?");
        int count = 0;
        try {
            String[] strArr = new String[1];
            String[] strArr2 = strArr;
            strArr[0] = "COUNT(*)";
            cursor = this.mDatabaseManager.getCursor(builder, strArr2, new String[]{group}, (String) null);
            boolean moveToNext = cursor.moveToNext();
            count = cursor.getInt(0);
            cursor.close();
        } catch (RuntimeException e) {
            AppCenterLog.error("AppCenter", "Failed to get logs count: ", e);
        } catch (Throwable th) {
            Throwable th2 = th;
            cursor.close();
            throw th2;
        }
        return count;
    }

    @Nullable
    public String getLogs(@NonNull String str, @NonNull Collection<String> collection, @IntRange(from = 0) int i, @NonNull List<Log> list) {
        StringBuilder sb;
        List<String> list2;
        Map<Long, Log> map;
        List<Long> list3;
        StringBuilder sb2;
        List<Long> list4;
        StringBuilder sb3;
        StringBuilder sb4;
        String logPayload;
        StringBuilder sb5;
        Throwable th;
        StringBuilder sb6;
        StringBuilder sb7;
        StringBuilder sb8;
        String group = str;
        Collection<String> pausedTargetKeys = collection;
        int limit = i;
        List<Log> outLogs = list;
        new StringBuilder();
        AppCenterLog.debug("AppCenter", sb.append("Trying to get ").append(limit).append(" logs from the Persistence database for ").append(group).toString());
        SQLiteQueryBuilder builder = SQLiteUtils.newSQLiteQueryBuilder();
        builder.appendWhere("persistence_group = ?");
        new ArrayList<>();
        List<String> selectionArgs = list2;
        boolean add = selectionArgs.add(group);
        if (!pausedTargetKeys.isEmpty()) {
            new StringBuilder();
            StringBuilder filter = sb7;
            for (int i2 = 0; i2 < pausedTargetKeys.size(); i2++) {
                StringBuilder append = filter.append("?,");
            }
            StringBuilder deleteCharAt = filter.deleteCharAt(filter.length() - 1);
            builder.appendWhere(" AND ");
            new StringBuilder();
            builder.appendWhere(sb8.append("target_key NOT IN (").append(filter.toString()).append(")").toString());
            boolean addAll = selectionArgs.addAll(pausedTargetKeys);
        }
        int count = 0;
        new LinkedHashMap<>();
        Map<Long, Log> candidates = map;
        new ArrayList<>();
        List<Long> failedDbIdentifiers = list3;
        File largePayloadGroupDirectory = getLargePayloadGroupDirectory(group);
        String[] selectionArgsArray = (String[]) selectionArgs.toArray(new String[0]);
        Cursor cursor = null;
        try {
            cursor = this.mDatabaseManager.getCursor(builder, (String[]) null, selectionArgsArray, GET_SORT_ORDER);
        } catch (RuntimeException e) {
            AppCenterLog.error("AppCenter", "Failed to get logs: ", e);
        }
        while (cursor != null) {
            ContentValues nextValues = this.mDatabaseManager.nextValues(cursor);
            ContentValues values = nextValues;
            if (nextValues == null || count >= limit) {
                break;
            }
            Long dbIdentifier = values.getAsLong(DatabaseManager.PRIMARY_KEY);
            if (dbIdentifier == null) {
                AppCenterLog.error("AppCenter", "Empty database record, probably content was larger than 2MB, need to delete as it's now corrupted.");
                Iterator<Long> it = getLogsIds(builder, selectionArgsArray).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Long corruptedId = it.next();
                    if (!this.mPendingDbIdentifiers.contains(corruptedId) && !candidates.containsKey(corruptedId)) {
                        deleteLog(largePayloadGroupDirectory, corruptedId.longValue());
                        new StringBuilder();
                        AppCenterLog.error("AppCenter", sb6.append("Empty database corrupted empty record deleted, id=").append(corruptedId).toString());
                        break;
                    }
                }
            } else {
                if (!this.mPendingDbIdentifiers.contains(dbIdentifier)) {
                    try {
                        String databasePayload = values.getAsString(COLUMN_LOG);
                        if (databasePayload == null) {
                            File file = getLargePayloadFile(largePayloadGroupDirectory, dbIdentifier.longValue());
                            new StringBuilder();
                            AppCenterLog.debug("AppCenter", sb5.append("Read payload file ").append(file).toString());
                            logPayload = FileManager.read(file);
                            if (logPayload == null) {
                                Throwable th2 = th;
                                new JSONException("Log payload is null and not stored as a file.");
                                throw th2;
                            }
                        } else {
                            logPayload = databasePayload;
                        }
                        Log log = getLogSerializer().deserializeLog(logPayload, values.getAsString("type"));
                        String targetToken = values.getAsString(COLUMN_TARGET_TOKEN);
                        if (targetToken != null) {
                            log.addTransmissionTarget(CryptoUtils.getInstance(this.mContext).decrypt(targetToken).getDecryptedData());
                        }
                        Log put = candidates.put(dbIdentifier, log);
                        count++;
                    } catch (JSONException e2) {
                        AppCenterLog.error("AppCenter", "Cannot deserialize a log in the database", e2);
                        boolean add2 = failedDbIdentifiers.add(dbIdentifier);
                    }
                } else {
                    continue;
                }
            }
        }
        if (cursor != null) {
            try {
                cursor.close();
            } catch (RuntimeException e3) {
                RuntimeException runtimeException = e3;
            }
        }
        if (failedDbIdentifiers.size() > 0) {
            for (Long longValue : failedDbIdentifiers) {
                deleteLog(largePayloadGroupDirectory, longValue.longValue());
            }
            AppCenterLog.warn("AppCenter", "Deleted logs that cannot be deserialized");
        }
        if (candidates.size() <= 0) {
            AppCenterLog.debug("AppCenter", "No logs found in the Persistence database at the moment");
            return null;
        }
        String id = UUID.randomUUID().toString();
        new StringBuilder();
        AppCenterLog.debug("AppCenter", sb2.append("Returning ").append(candidates.size()).append(" log(s) with an ID, ").append(id).toString());
        AppCenterLog.debug("AppCenter", "The SID/ID pairs for returning log(s) is/are:");
        new ArrayList<>();
        List<Long> pendingDbIdentifiersGroup = list4;
        for (Map.Entry<Long, Log> entry : candidates.entrySet()) {
            Long dbIdentifier2 = entry.getKey();
            boolean add3 = this.mPendingDbIdentifiers.add(dbIdentifier2);
            boolean add4 = pendingDbIdentifiersGroup.add(dbIdentifier2);
            boolean add5 = outLogs.add(entry.getValue());
            new StringBuilder();
            AppCenterLog.debug("AppCenter", sb4.append("\t").append(entry.getValue().getSid()).append(" / ").append(dbIdentifier2).toString());
        }
        new StringBuilder();
        List<Long> put2 = this.mPendingDbIdentifiersGroups.put(sb3.append(group).append(id).toString(), pendingDbIdentifiersGroup);
        return id;
    }

    public void clearPendingLogState() {
        this.mPendingDbIdentifiers.clear();
        this.mPendingDbIdentifiersGroups.clear();
        AppCenterLog.debug("AppCenter", "Cleared pending log states");
    }

    public void close() {
        this.mDatabaseManager.close();
    }

    private List<Long> getLogsIds(SQLiteQueryBuilder sQLiteQueryBuilder, String[] strArr) {
        List<Long> list;
        Cursor cursor;
        SQLiteQueryBuilder builder = sQLiteQueryBuilder;
        String[] selectionArgs = strArr;
        new ArrayList();
        List<Long> result = list;
        try {
            cursor = this.mDatabaseManager.getCursor(builder, DatabaseManager.SELECT_PRIMARY_KEY, selectionArgs, (String) null);
            while (cursor.moveToNext()) {
                boolean add = result.add(this.mDatabaseManager.buildValues(cursor).getAsLong(DatabaseManager.PRIMARY_KEY));
            }
            cursor.close();
        } catch (RuntimeException e) {
            AppCenterLog.error("AppCenter", "Failed to get corrupted ids: ", e);
        } catch (Throwable th) {
            Throwable th2 = th;
            cursor.close();
            throw th2;
        }
        return result;
    }
}
