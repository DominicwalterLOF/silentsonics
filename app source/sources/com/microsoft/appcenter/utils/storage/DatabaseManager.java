package com.microsoft.appcenter.utils.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.microsoft.appcenter.utils.AppCenterLog;
import java.io.Closeable;
import java.util.Arrays;

public class DatabaseManager implements Closeable {
    public static final String PRIMARY_KEY = "oid";
    public static final String[] SELECT_PRIMARY_KEY = {PRIMARY_KEY};
    private final Context mContext;
    private final String mDatabase;
    private final String mDefaultTable;
    /* access modifiers changed from: private */
    public final Listener mListener;
    private SQLiteOpenHelper mSQLiteOpenHelper;
    private final ContentValues mSchema;

    public interface Listener {
        void onCreate(SQLiteDatabase sQLiteDatabase);

        void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2);
    }

    public DatabaseManager(Context context, String str, String defaultTable, int version, ContentValues schema, String sqlCreateCommand, @NonNull Listener listener) {
        SQLiteOpenHelper sQLiteOpenHelper;
        Context context2 = context;
        String database = str;
        this.mContext = context2;
        this.mDatabase = database;
        this.mDefaultTable = defaultTable;
        this.mSchema = schema;
        this.mListener = listener;
        final String str2 = sqlCreateCommand;
        new SQLiteOpenHelper(this, context2, database, (SQLiteDatabase.CursorFactory) null, version) {
            final /* synthetic */ DatabaseManager this$0;

            {
                this.this$0 = this$0;
            }

            public void onCreate(SQLiteDatabase sQLiteDatabase) {
                SQLiteDatabase db = sQLiteDatabase;
                db.execSQL(str2);
                this.this$0.mListener.onCreate(db);
            }

            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                this.this$0.mListener.onUpgrade(db, oldVersion, newVersion);
            }
        };
        this.mSQLiteOpenHelper = sQLiteOpenHelper;
    }

    private static ContentValues buildValues(Cursor cursor, ContentValues contentValues) {
        ContentValues contentValues2;
        Cursor cursor2 = cursor;
        ContentValues schema = contentValues;
        new ContentValues();
        ContentValues values = contentValues2;
        for (int i = 0; i < cursor2.getColumnCount(); i++) {
            if (!cursor2.isNull(i)) {
                String key = cursor2.getColumnName(i);
                if (key.equals(PRIMARY_KEY)) {
                    values.put(key, Long.valueOf(cursor2.getLong(i)));
                } else {
                    Object specimen = schema.get(key);
                    if (specimen instanceof byte[]) {
                        values.put(key, cursor2.getBlob(i));
                    } else if (specimen instanceof Double) {
                        values.put(key, Double.valueOf(cursor2.getDouble(i)));
                    } else if (specimen instanceof Float) {
                        values.put(key, Float.valueOf(cursor2.getFloat(i)));
                    } else if (specimen instanceof Integer) {
                        values.put(key, Integer.valueOf(cursor2.getInt(i)));
                    } else if (specimen instanceof Long) {
                        values.put(key, Long.valueOf(cursor2.getLong(i)));
                    } else if (specimen instanceof Short) {
                        values.put(key, Short.valueOf(cursor2.getShort(i)));
                    } else if (specimen instanceof Boolean) {
                        values.put(key, Boolean.valueOf(cursor2.getInt(i) == 1));
                    } else {
                        values.put(key, cursor2.getString(i));
                    }
                }
            }
        }
        return values;
    }

    public ContentValues buildValues(Cursor cursor) {
        return buildValues(cursor, this.mSchema);
    }

    @Nullable
    public ContentValues nextValues(Cursor cursor) {
        Cursor cursor2 = cursor;
        try {
            if (cursor2.moveToNext()) {
                return buildValues(cursor2);
            }
        } catch (RuntimeException e) {
            AppCenterLog.error("AppCenter", "Failed to get next cursor value: ", e);
        }
        return null;
    }

    public long put(@NonNull ContentValues contentValues, @NonNull String str) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        ContentValues values = contentValues;
        String priorityColumn = str;
        Long id = null;
        Cursor cursor = null;
        while (id == null) {
            try {
                id = Long.valueOf(getDatabase().insertOrThrow(this.mDefaultTable, (String) null, values));
            } catch (SQLiteFullException e) {
                SQLiteFullException e2 = e;
                AppCenterLog.debug("AppCenter", "Storage is full, trying to delete the oldest log that has the lowest priority which is lower or equal priority than the new log");
                if (cursor == null) {
                    String priority = values.getAsString(priorityColumn);
                    SQLiteQueryBuilder queryBuilder = SQLiteUtils.newSQLiteQueryBuilder();
                    new StringBuilder();
                    queryBuilder.appendWhere(sb2.append(priorityColumn).append(" <= ?").toString());
                    new StringBuilder();
                    cursor = getCursor(queryBuilder, SELECT_PRIMARY_KEY, new String[]{priority}, sb3.append(priorityColumn).append(" , ").append(PRIMARY_KEY).toString());
                }
                if (cursor.moveToNext()) {
                    long deletedId = cursor.getLong(0);
                    delete(deletedId);
                    new StringBuilder();
                    AppCenterLog.debug("AppCenter", sb.append("Deleted log id=").append(deletedId).toString());
                } else {
                    throw e2;
                }
            } catch (RuntimeException e3) {
                id = -1L;
                Object[] objArr = new Object[2];
                objArr[0] = values.toString();
                Object[] objArr2 = objArr;
                objArr2[1] = this.mDatabase;
                AppCenterLog.error("AppCenter", String.format("Failed to insert values (%s) to database %s.", objArr2), e3);
            }
        }
        if (cursor != null) {
            try {
                cursor.close();
            } catch (RuntimeException e4) {
                RuntimeException runtimeException = e4;
            }
        }
        return id.longValue();
    }

    public void delete(@IntRange(from = 0) long id) {
        int delete = delete(this.mDefaultTable, PRIMARY_KEY, Long.valueOf(id));
    }

    public int delete(@NonNull String key, @Nullable Object value) {
        return delete(this.mDefaultTable, key, value);
    }

    private int delete(@NonNull String str, @NonNull String str2, @Nullable Object value) {
        StringBuilder sb;
        StringBuilder sb2;
        String table = str;
        String key = str2;
        String[] whereArgs = {String.valueOf(value)};
        try {
            new StringBuilder();
            return getDatabase().delete(table, sb2.append(key).append(" = ?").toString(), whereArgs);
        } catch (RuntimeException e) {
            Object[] objArr = new Object[3];
            new StringBuilder();
            objArr[0] = sb.append(key).append(" = ?").toString();
            Object[] objArr2 = objArr;
            objArr2[1] = Arrays.toString(whereArgs);
            Object[] objArr3 = objArr2;
            objArr3[2] = this.mDatabase;
            AppCenterLog.error("AppCenter", String.format("Failed to delete values that match condition=\"%s\" and values=\"%s\" from database %s.", objArr3), e);
            return 0;
        }
    }

    public void clear() {
        try {
            int delete = getDatabase().delete(this.mDefaultTable, (String) null, (String[]) null);
        } catch (RuntimeException e) {
            AppCenterLog.error("AppCenter", "Failed to clear the table.", e);
        }
    }

    public void close() {
        try {
            this.mSQLiteOpenHelper.close();
        } catch (RuntimeException e) {
            AppCenterLog.error("AppCenter", "Failed to close the database.", e);
        }
    }

    public final long getRowCount() {
        try {
            return DatabaseUtils.queryNumEntries(getDatabase(), this.mDefaultTable);
        } catch (RuntimeException e) {
            AppCenterLog.error("AppCenter", "Failed to get row count of database.", e);
            return -1;
        }
    }

    public Cursor getCursor(@Nullable SQLiteQueryBuilder queryBuilder, String[] columns, @Nullable String[] selectionArgs, @Nullable String sortOrder) throws RuntimeException {
        return getCursor(this.mDefaultTable, queryBuilder, columns, selectionArgs, sortOrder);
    }

    /* access modifiers changed from: package-private */
    public Cursor getCursor(@NonNull String str, @Nullable SQLiteQueryBuilder sQLiteQueryBuilder, String[] strArr, @Nullable String[] strArr2, @Nullable String str2) throws RuntimeException {
        String table = str;
        SQLiteQueryBuilder queryBuilder = sQLiteQueryBuilder;
        String[] columns = strArr;
        String[] selectionArgs = strArr2;
        String sortOrder = str2;
        if (queryBuilder == null) {
            queryBuilder = SQLiteUtils.newSQLiteQueryBuilder();
        }
        queryBuilder.setTables(table);
        return queryBuilder.query(getDatabase(), columns, (String) null, selectionArgs, (String) null, (String) null, sortOrder);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public SQLiteDatabase getDatabase() {
        try {
            return this.mSQLiteOpenHelper.getWritableDatabase();
        } catch (RuntimeException e) {
            AppCenterLog.warn("AppCenter", "Failed to open database. Trying to delete database (may be corrupted).", e);
            if (this.mContext.deleteDatabase(this.mDatabase)) {
                AppCenterLog.info("AppCenter", "The database was successfully deleted.");
            } else {
                AppCenterLog.warn("AppCenter", "Failed to delete database.");
            }
            return this.mSQLiteOpenHelper.getWritableDatabase();
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void setSQLiteOpenHelper(@NonNull SQLiteOpenHelper helper) {
        this.mSQLiteOpenHelper.close();
        this.mSQLiteOpenHelper = helper;
    }

    public boolean setMaxSize(long j) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        long maxStorageSizeInBytes = j;
        try {
            SQLiteDatabase db = getDatabase();
            long newMaxSize = db.setMaximumSize(maxStorageSizeInBytes);
            long pageSize = db.getPageSize();
            long expectedMultipleMaxSize = maxStorageSizeInBytes / pageSize;
            if (maxStorageSizeInBytes % pageSize != 0) {
                expectedMultipleMaxSize++;
            }
            if (newMaxSize != expectedMultipleMaxSize * pageSize) {
                new StringBuilder();
                AppCenterLog.error("AppCenter", sb3.append("Could not change maximum database size to ").append(maxStorageSizeInBytes).append(" bytes, current maximum size is ").append(newMaxSize).append(" bytes.").toString());
                return false;
            }
            if (maxStorageSizeInBytes == newMaxSize) {
                new StringBuilder();
                AppCenterLog.info("AppCenter", sb2.append("Changed maximum database size to ").append(newMaxSize).append(" bytes.").toString());
            } else {
                new StringBuilder();
                AppCenterLog.info("AppCenter", sb.append("Changed maximum database size to ").append(newMaxSize).append(" bytes (next multiple of page size).").toString());
            }
            return true;
        } catch (RuntimeException e) {
            AppCenterLog.error("AppCenter", "Could not change maximum database size.", e);
            return false;
        }
    }

    public long getMaxSize() {
        try {
            return getDatabase().getMaximumSize();
        } catch (RuntimeException e) {
            AppCenterLog.error("AppCenter", "Could not get maximum database size.", e);
            return -1;
        }
    }
}
