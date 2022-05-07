package com.google.appinventor.components.runtime.util;

import android.app.Activity;
import android.database.Cursor;
import android.provider.ContactsContract;

public class HoneycombMR1Util {
    private HoneycombMR1Util() {
    }

    public static String[] getContactProjection() {
        String[] strArr = new String[4];
        strArr[0] = "_id";
        String[] strArr2 = strArr;
        strArr2[1] = "display_name";
        String[] strArr3 = strArr2;
        strArr3[2] = "photo_thumb_uri";
        String[] strArr4 = strArr3;
        String[] strArr5 = strArr4;
        strArr4[3] = "photo_uri";
        return strArr5;
    }

    public static String[] getNameProjection() {
        String[] strArr = new String[4];
        strArr[0] = "contact_id";
        String[] strArr2 = strArr;
        strArr2[1] = "display_name";
        String[] strArr3 = strArr2;
        strArr3[2] = "photo_thumb_uri";
        String[] strArr4 = strArr3;
        String[] strArr5 = strArr4;
        strArr4[3] = "data1";
        return strArr5;
    }

    public static String[] getDataProjection() {
        String[] strArr = new String[5];
        strArr[0] = "mimetype";
        String[] strArr2 = strArr;
        strArr2[1] = "data1";
        String[] strArr3 = strArr2;
        strArr3[2] = "data2";
        String[] strArr4 = strArr3;
        strArr4[3] = "data1";
        String[] strArr5 = strArr4;
        String[] strArr6 = strArr5;
        strArr5[4] = "data2";
        return strArr6;
    }

    public static String[] getEmailAdapterProjection() {
        String[] strArr = new String[4];
        strArr[0] = "_id";
        String[] strArr2 = strArr;
        strArr2[1] = "display_name";
        String[] strArr3 = strArr2;
        strArr3[2] = "data1";
        String[] strArr4 = strArr3;
        String[] strArr5 = strArr4;
        strArr4[3] = "mimetype";
        return strArr5;
    }

    public static Cursor getDataCursor(String str, Activity activity, String[] strArr) {
        String[] strArr2 = new String[3];
        strArr2[0] = str;
        String[] strArr3 = strArr2;
        strArr3[1] = "vnd.android.cursor.item/phone_v2";
        String[] strArr4 = strArr3;
        strArr4[2] = "vnd.android.cursor.item/email_v2";
        return activity.getContentResolver().query(ContactsContract.Data.CONTENT_URI, strArr, "contact_id=? AND (mimetype=? OR mimetype=?)", strArr4, (String) null);
    }
}
