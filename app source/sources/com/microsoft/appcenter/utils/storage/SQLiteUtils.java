package com.microsoft.appcenter.utils.storage;

import android.database.sqlite.SQLiteQueryBuilder;
import android.support.annotation.NonNull;

public class SQLiteUtils {
    public SQLiteUtils() {
    }

    @NonNull
    public static SQLiteQueryBuilder newSQLiteQueryBuilder() {
        SQLiteQueryBuilder sQLiteQueryBuilder;
        SQLiteQueryBuilder sQLiteQueryBuilder2 = sQLiteQueryBuilder;
        new SQLiteQueryBuilder();
        return sQLiteQueryBuilder2;
    }
}
