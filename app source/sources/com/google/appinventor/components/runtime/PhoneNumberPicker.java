package com.google.appinventor.components.runtime;

import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Contacts;
import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.ErrorMessages;
import com.google.appinventor.components.runtime.util.HoneycombMR1Util;
import com.microsoft.appcenter.ingestion.models.CommonProperties;
import java.util.ArrayList;
import java.util.List;

@SimpleObject
@DesignerComponent(category = ComponentCategory.SOCIAL, description = "A button that, when clicked on, displays a list of the contacts' phone numbers to choose among. After the user has made a selection, the following properties will be set to information about the chosen contact: <ul>\n<li> <code>ContactName</code>: the contact's name </li>\n <li> <code>PhoneNumber</code>: the contact's phone number </li>\n <li> <code>EmailAddress</code>: the contact's email address </li> <li> <code>Picture</code>: the name of the file containing the contact's image, which can be used as a <code>Picture</code> property value for the <code>Image</code> or <code>ImageSprite</code> component.</li></ul>\n</p><p>Other properties affect the appearance of the button (<code>TextAlignment</code>, <code>BackgroundColor</code>, etc.) and whether it can be clicked on (<code>Enabled</code>).</p>\n<p>The PhoneNumberPicker component may not work on all Android devices. For example, on Android systems before system 3.0, the returned lists of phone numbers and email addresses will be empty.\n", version = 10)
@UsesPermissions({"android.permission.READ_CONTACTS"})
public class PhoneNumberPicker extends ContactPicker {
    private static String[] B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T;
    private static String[] mBLKdPlRolYfdtud5Z8giGWyhURWoCw9yHsOv08fUnIBAM4MuKAWkHVD8nEhBmIT;

    static {
        String[] strArr = new String[4];
        strArr[0] = CommonProperties.NAME;
        String[] strArr2 = strArr;
        strArr2[1] = "number";
        String[] strArr3 = strArr2;
        strArr3[2] = "person";
        strArr3[3] = "primary_email";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneNumberPicker(ComponentContainer componentContainer) {
        super(componentContainer, Contacts.Phones.CONTENT_URI);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public String PhoneNumber() {
        return ensureNotNull(this.phoneNumber);
    }

    public void resultReturned(int i, int i2, Intent intent) {
        StringBuilder sb;
        int i3 = i2;
        Intent intent2 = intent;
        if (i == this.requestCode && i3 == -1) {
            int i4 = Log.i("PhoneNumberPicker", "received intent is ".concat(String.valueOf(intent2)));
            Uri data = intent2.getData();
            if (checkContactUri(data, "//com.android.contacts/data")) {
                Cursor cursor = null;
                Cursor cursor2 = null;
                try {
                    mBLKdPlRolYfdtud5Z8giGWyhURWoCw9yHsOv08fUnIBAM4MuKAWkHVD8nEhBmIT = HoneycombMR1Util.getNameProjection();
                    cursor = this.activityContext.getContentResolver().query(data, mBLKdPlRolYfdtud5Z8giGWyhURWoCw9yHsOv08fUnIBAM4MuKAWkHVD8nEhBmIT, (String) null, (String[]) null, (String) null);
                    String postHoneycombGetContactNameAndPicture = postHoneycombGetContactNameAndPicture(cursor);
                    B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = HoneycombMR1Util.getDataProjection();
                    cursor2 = HoneycombMR1Util.getDataCursor(postHoneycombGetContactNameAndPicture, this.activityContext, B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T);
                    postHoneycombGetContactEmailsAndPhones(cursor2);
                    new StringBuilder("Contact name = ");
                    int i5 = Log.i("PhoneNumberPicker", sb.append(this.contactName).append(", phone number = ").append(this.phoneNumber).append(", emailAddress = ").append(this.emailAddress).append(", contactPhotoUri = ").append(this.contactPictureUri).toString());
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                } catch (Exception e) {
                    int e2 = Log.e("PhoneNumberPicker", "Exception in resultReturned", e);
                    puntContactSelection(ErrorMessages.ERROR_PHONE_UNSUPPORTED_CONTACT_PICKER);
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th2;
                }
            }
            AfterPicking("The PhoneNumberPicker component have no 'After Picking' return value.");
        }
    }

    public void preHoneycombGetContactInfo(Cursor cursor) {
        Cursor cursor2 = cursor;
        if (cursor2.moveToFirst()) {
            this.contactName = guardCursorGetString(cursor2, 0);
            this.phoneNumber = guardCursorGetString(cursor2, 1);
            this.contactPictureUri = ContentUris.withAppendedId(Contacts.People.CONTENT_URI, (long) cursor2.getInt(2)).toString();
            this.emailAddress = getEmailAddress(guardCursorGetString(cursor2, 3));
        }
    }

    public String postHoneycombGetContactNameAndPicture(Cursor cursor) {
        Cursor cursor2 = cursor;
        String str = "";
        if (cursor2.moveToFirst()) {
            int columnIndex = cursor2.getColumnIndex("contact_id");
            int columnIndex2 = cursor2.getColumnIndex("display_name");
            int columnIndex3 = cursor2.getColumnIndex("photo_thumb_uri");
            this.phoneNumber = guardCursorGetString(cursor2, cursor2.getColumnIndex("data1"));
            str = guardCursorGetString(cursor2, columnIndex);
            this.contactName = guardCursorGetString(cursor2, columnIndex2);
            this.contactPictureUri = guardCursorGetString(cursor2, columnIndex3);
        }
        return str;
    }

    public void postHoneycombGetContactEmailsAndPhones(Cursor cursor) {
        List list;
        List list2;
        StringBuilder sb;
        Cursor cursor2 = cursor;
        new ArrayList();
        List list3 = list;
        new ArrayList();
        List list4 = list2;
        if (cursor2.moveToFirst()) {
            int columnIndex = cursor2.getColumnIndex("data1");
            int columnIndex2 = cursor2.getColumnIndex("data1");
            int columnIndex3 = cursor2.getColumnIndex("mimetype");
            String str = "vnd.android.cursor.item/phone_v2";
            String str2 = "vnd.android.cursor.item/email_v2";
            while (!cursor2.isAfterLast()) {
                String guardCursorGetString = guardCursorGetString(cursor2, columnIndex3);
                String str3 = guardCursorGetString;
                if (guardCursorGetString.contains(str)) {
                    boolean add = list3.add(guardCursorGetString(cursor2, columnIndex));
                } else if (str3.contains(str2)) {
                    boolean add2 = list4.add(guardCursorGetString(cursor2, columnIndex2));
                } else {
                    new StringBuilder("Type mismatch: ");
                    int i = Log.i("ContactPicker", sb.append(str3).append(" not ").append(str).append(" or ").append(str2).toString());
                }
                boolean moveToNext = cursor2.moveToNext();
            }
            this.phoneNumberList = list3;
            this.emailAddressList = list4;
            if (!this.emailAddressList.isEmpty()) {
                this.emailAddress = (String) this.emailAddressList.get(0);
                return;
            }
            this.emailAddress = "";
        }
    }
}
