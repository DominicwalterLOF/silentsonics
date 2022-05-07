package com.google.appinventor.components.runtime;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.text.util.Rfc822Token;
import android.view.View;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;
import com.google.appinventor.components.runtime.util.HoneycombMR1Util;
import com.microsoft.appcenter.ingestion.models.CommonProperties;

public class EmailAddressAdapter extends ResourceCursorAdapter {
    private static String DmQGLROFyZ9Eo0RSsJcpZNxJZjgcsPDfYPi3awNwmyyErT71sGU5mvgG4PDW3yL = null;
    public static final int PRE_HONEYCOMB_DATA_INDEX = 2;
    public static final int PRE_HONEYCOMB_NAME_INDEX = 1;
    private static final String[] vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq = HoneycombMR1Util.getEmailAdapterProjection();
    private Context context;
    private ContentResolver hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    static {
        String[] strArr = new String[3];
        strArr[0] = "_id";
        String[] strArr2 = strArr;
        strArr2[1] = CommonProperties.NAME;
        strArr2[2] = "data";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public EmailAddressAdapter(android.content.Context r7) {
        /*
            r6 = this;
            r0 = r6
            r1 = r7
            r2 = r0
            r3 = r1
            r4 = 17367050(0x109000a, float:2.5162954E-38)
            r5 = 0
            r2.<init>(r3, r4, r5)
            r2 = r0
            r3 = r1
            android.content.ContentResolver r3 = r3.getContentResolver()
            r2.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r3
            r2 = r0
            r3 = r1
            r2.context = r3
            java.lang.String r2 = "times_contacted DESC, display_name"
            DmQGLROFyZ9Eo0RSsJcpZNxJZjgcsPDfYPi3awNwmyyErT71sGU5mvgG4PDW3yL = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.EmailAddressAdapter.<init>(android.content.Context):void");
    }

    public final String convertToString(Cursor cursor) {
        Rfc822Token rfc822Token;
        Cursor cursor2 = cursor;
        int columnIndex = cursor2.getColumnIndex("display_name");
        int columnIndex2 = cursor2.getColumnIndex("data1");
        new Rfc822Token(cursor2.getString(columnIndex), cursor2.getString(columnIndex2), (String) null);
        return rfc822Token.toString();
    }

    public final void bindView(View view, Context context2, Cursor cursor) {
        StringBuilder sb;
        Context context3 = context2;
        TextView textView = (TextView) view;
        Cursor cursor2 = cursor;
        Cursor cursor3 = cursor2;
        int columnIndex = cursor2.getColumnIndex("display_name");
        int columnIndex2 = cursor3.getColumnIndex("data1");
        new StringBuilder();
        StringBuilder sb2 = sb;
        boolean z = false;
        String string = cursor3.getString(columnIndex);
        String string2 = cursor3.getString(columnIndex2);
        if (!TextUtils.isEmpty(string)) {
            StringBuilder append = sb2.append(string);
            z = true;
        }
        if (z) {
            StringBuilder append2 = sb2.append(" <");
        }
        StringBuilder append3 = sb2.append(string2);
        if (z) {
            StringBuilder append4 = sb2.append(">");
        }
        textView.setText(sb2.toString());
    }

    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        StringBuilder sb;
        StringBuilder sb2;
        CharSequence charSequence2 = charSequence;
        Uri uri = null;
        new StringBuilder();
        StringBuilder sb3 = sb;
        if (charSequence2 != null) {
            new StringBuilder();
            String sqlEscapeString = DatabaseUtils.sqlEscapeString(sb2.append(charSequence2.toString()).append('%').toString());
            uri = ContactsContract.Data.CONTENT_URI;
            StringBuilder append = sb3.append("(mimetype='vnd.android.cursor.item/email_v2')");
            StringBuilder append2 = sb3.append(" AND ");
            StringBuilder append3 = sb3.append("(display_name LIKE ");
            StringBuilder append4 = sb3.append(sqlEscapeString);
            StringBuilder append5 = sb3.append(")");
        }
        return this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.query(uri, vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq, sb3.toString(), (String[]) null, DmQGLROFyZ9Eo0RSsJcpZNxJZjgcsPDfYPi3awNwmyyErT71sGU5mvgG4PDW3yL);
    }
}
