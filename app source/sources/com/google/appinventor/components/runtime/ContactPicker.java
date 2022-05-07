package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Contacts;
import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.ErrorMessages;
import com.google.appinventor.components.runtime.util.HoneycombMR1Util;
import com.microsoft.appcenter.ingestion.models.CommonProperties;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SimpleObject
@DesignerComponent(category = ComponentCategory.SOCIAL, description = "A button that, when clicked on, displays a list of the contacts to choose among. After the user has made a selection, the following properties will be set to information about the chosen contact: <ul>\n<li> <code>ContactName</code>: the contact's name </li>\n <li> <code>EmailAddress</code>: the contact's primary email address </li>\n <li> <code>ContactUri</code>: the contact's URI on the device </li>\n<li> <code>EmailAddressList</code>: a list of the contact's email addresses </li>\n <li> <code>PhoneNumber</code>: the contact's primary phone number (on Later Android Verisons)</li>\n <li> <code>PhoneNumberList</code>: a list of the contact's phone numbers (on Later Android Versions)</li>\n <li> <code>Picture</code>: the name of the file containing the contact's image, which can be used as a <code>Picture</code> property value for the <code>Image</code> or <code>ImageSprite</code> component.</li></ul>\n</p><p>Other properties affect the appearance of the button (<code>TextAlignment</code>, <code>BackgroundColor</code>, etc.) and whether it can be clicked on (<code>Enabled</code>).\n</p><p>The ContactPicker component might not work on all phones. For example, on Android systems before system 3.0, it cannot pick phone numbers, and the list of email addresses will contain only one email.", version = 12)
@UsesPermissions({"android.permission.READ_CONTACTS"})
public class ContactPicker extends Picker implements ActivityResultListener {
    private static String[] B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T;
    private static String[] hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    protected final Activity activityContext;
    protected String contactName;
    protected String contactPictureUri;
    protected String contactUri;
    protected String emailAddress;
    protected List emailAddressList;
    /* access modifiers changed from: private */
    public boolean havePermission;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private final Uri f72hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    protected String phoneNumber;
    protected List phoneNumberList;

    static {
        String[] strArr = {CommonProperties.NAME, "primary_email"};
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ContactPicker(ComponentContainer componentContainer) {
        this(componentContainer, Contacts.People.CONTENT_URI);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected ContactPicker(com.google.appinventor.components.runtime.ComponentContainer r6, android.net.Uri r7) {
        /*
            r5 = this;
            r0 = r5
            r1 = r6
            r2 = r7
            r3 = r0
            r4 = r1
            r3.<init>(r4)
            r3 = r0
            r4 = 0
            r3.havePermission = r4
            r3 = r0
            r4 = r1
            android.app.Activity r4 = r4.$context()
            r3.activityContext = r4
            r3 = r2
            android.net.Uri r4 = android.provider.Contacts.People.CONTENT_URI
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0023
            r3 = r0
            android.net.Uri r4 = android.provider.ContactsContract.Contacts.CONTENT_URI
            r3.f72hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r4
        L_0x0022:
            return
        L_0x0023:
            r3 = r2
            android.net.Uri r4 = android.provider.Contacts.Phones.CONTENT_URI
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0032
            r3 = r0
            android.net.Uri r4 = android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI
            r3.f72hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r4
            goto L_0x0022
        L_0x0032:
            r3 = r0
            r4 = r2
            r3.f72hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r4
            goto L_0x0022
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.ContactPicker.<init>(com.google.appinventor.components.runtime.ComponentContainer, android.net.Uri):void");
    }

    public void click() {
        PermissionResultHandler permissionResultHandler;
        if (!this.havePermission) {
            new PermissionResultHandler(this) {
                private /* synthetic */ ContactPicker hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

                {
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r5;
                }

                public final void HandlePermissionResponse(String str, boolean z) {
                    String str2 = str;
                    if (z) {
                        boolean hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2 = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.havePermission = true;
                        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.click();
                        return;
                    }
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.container.$form().dispatchPermissionDeniedEvent((Component) this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, "Click", "android.permission.READ_CONTACTS");
                }
            };
            this.container.$form().askPermission("android.permission.READ_CONTACTS", permissionResultHandler);
            return;
        }
        super.click();
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public String Picture() {
        return ensureNotNull(this.contactPictureUri);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public String ContactName() {
        return ensureNotNull(this.contactName);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public String EmailAddress() {
        return ensureNotNull(this.emailAddress);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "URI that specifies the location of the contact on the device.")
    public String ContactUri() {
        return ensureNotNull(this.contactUri);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public List EmailAddressList() {
        return ensureNotNull(this.emailAddressList);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public String PhoneNumber() {
        return ensureNotNull(this.phoneNumber);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public List PhoneNumberList() {
        return ensureNotNull(this.phoneNumberList);
    }

    @SimpleFunction(description = "view a contact via its URI")
    public void ViewContact(String str) {
        Intent intent;
        String str2 = str;
        if (this.contactUri != null) {
            new Intent("android.intent.action.VIEW", Uri.parse(str2));
            Intent intent2 = intent;
            Intent intent3 = intent2;
            if (intent2.resolveActivity(this.activityContext.getPackageManager()) != null) {
                this.activityContext.startActivity(intent3);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Intent getIntent() {
        Intent intent;
        new Intent("android.intent.action.PICK", this.f72hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
        return intent;
    }

    public void resultReturned(int i, int i2, Intent intent) {
        StringBuilder sb;
        int i3 = i2;
        Intent intent2 = intent;
        if (i == this.requestCode && i3 == -1) {
            int i4 = Log.i("ContactPicker", "received intent is ".concat(String.valueOf(intent2)));
            Uri data = intent2.getData();
            if (checkContactUri(data, "//com.android.contacts/contact")) {
                Cursor cursor = null;
                Cursor cursor2 = null;
                try {
                    hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = HoneycombMR1Util.getContactProjection();
                    cursor = this.activityContext.getContentResolver().query(data, hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, (String) null, (String[]) null, (String) null);
                    String postHoneycombGetContactNameAndPicture = postHoneycombGetContactNameAndPicture(cursor);
                    B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = HoneycombMR1Util.getDataProjection();
                    cursor2 = HoneycombMR1Util.getDataCursor(postHoneycombGetContactNameAndPicture, this.activityContext, B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T);
                    postHoneycombGetContactEmailAndPhone(cursor2);
                    this.contactUri = data.toString();
                    new StringBuilder("Contact name = ");
                    int i5 = Log.i("ContactPicker", sb.append(this.contactName).append(", email address = ").append(this.emailAddress).append(",contact Uri = ").append(this.contactUri).append(", phone number = ").append(this.phoneNumber).append(", contactPhotoUri = ").append(this.contactPictureUri).toString());
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                } catch (Exception e) {
                    int i6 = Log.i("ContactPicker", "checkContactUri failed: D");
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
            AfterPicking("The ContactPicker component have no 'After Picking' return value.");
        }
    }

    public void preHoneycombGetContactInfo(Cursor cursor, Uri uri) {
        List asList;
        List list;
        Cursor cursor2 = cursor;
        Uri uri2 = uri;
        if (cursor2.moveToFirst()) {
            this.contactName = guardCursorGetString(cursor2, 0);
            this.emailAddress = getEmailAddress(guardCursorGetString(cursor2, 1));
            this.contactUri = uri2.toString();
            this.contactPictureUri = uri2.toString();
            if (this.emailAddress.equals("")) {
                asList = list;
                new ArrayList();
            } else {
                asList = Arrays.asList(new String[]{this.emailAddress});
            }
            this.emailAddressList = asList;
        }
    }

    public String postHoneycombGetContactNameAndPicture(Cursor cursor) {
        StringBuilder sb;
        Cursor cursor2 = cursor;
        String str = "";
        if (cursor2.moveToFirst()) {
            int columnIndex = cursor2.getColumnIndex("_id");
            int columnIndex2 = cursor2.getColumnIndex("display_name");
            int columnIndex3 = cursor2.getColumnIndex("photo_thumb_uri");
            int columnIndex4 = cursor2.getColumnIndex("photo_uri");
            str = guardCursorGetString(cursor2, columnIndex);
            this.contactName = guardCursorGetString(cursor2, columnIndex2);
            this.contactPictureUri = guardCursorGetString(cursor2, columnIndex3);
            new StringBuilder("photo_uri=");
            int i = Log.i("ContactPicker", sb.append(guardCursorGetString(cursor2, columnIndex4)).toString());
        }
        return str;
    }

    public void postHoneycombGetContactEmailAndPhone(Cursor cursor) {
        List list;
        List list2;
        StringBuilder sb;
        Cursor cursor2 = cursor;
        this.phoneNumber = "";
        this.emailAddress = "";
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
        }
        if (!list3.isEmpty()) {
            this.phoneNumber = (String) list3.get(0);
        }
        if (!list4.isEmpty()) {
            this.emailAddress = (String) list4.get(0);
        }
        this.phoneNumberList = list3;
        this.emailAddressList = list4;
    }

    /* access modifiers changed from: protected */
    public boolean checkContactUri(Uri uri, String str) {
        Uri uri2 = uri;
        String str2 = str;
        int i = Log.i("ContactPicker", "contactUri is ".concat(String.valueOf(uri2)));
        if (uri2 == null || !"content".equals(uri2.getScheme())) {
            int i2 = Log.i("ContactPicker", "checkContactUri failed: A");
            puntContactSelection(ErrorMessages.ERROR_PHONE_UNSUPPORTED_CONTACT_PICKER);
            return false;
        } else if (uri2.getSchemeSpecificPart().startsWith(str2)) {
            return true;
        } else {
            int i3 = Log.i("ContactPicker", "checkContactUri failed: C");
            int i4 = Log.i("ContactPicker", uri2.getPath());
            puntContactSelection(ErrorMessages.ERROR_PHONE_UNSUPPORTED_CONTACT_PICKER);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void puntContactSelection(int i) {
        this.contactName = "";
        this.emailAddress = "";
        this.contactPictureUri = "";
        this.container.$form().dispatchErrorOccurredEvent(this, "", i, new Object[0]);
    }

    /* access modifiers changed from: protected */
    public String getEmailAddress(String str) {
        try {
            String str2 = "";
            String[] strArr = {"data"};
            Cursor query = this.activityContext.getContentResolver().query(Contacts.ContactMethods.CONTENT_EMAIL_URI, strArr, "contact_methods._id = ".concat(String.valueOf(Integer.parseInt(str))), (String[]) null, (String) null);
            try {
                if (query.moveToFirst()) {
                    str2 = guardCursorGetString(query, 0);
                }
                query.close();
                return ensureNotNull(str2);
            } catch (Throwable th) {
                Throwable th2 = th;
                query.close();
                throw th2;
            }
        } catch (NumberFormatException e) {
            return "";
        }
    }

    /* access modifiers changed from: protected */
    public String guardCursorGetString(Cursor cursor, int i) {
        String str;
        try {
            str = cursor.getString(i);
        } catch (Exception e) {
            str = "";
        }
        return ensureNotNull(str);
    }

    /* access modifiers changed from: protected */
    public String ensureNotNull(String str) {
        String str2 = str;
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    /* access modifiers changed from: protected */
    public List ensureNotNull(List list) {
        List list2;
        List list3 = list;
        if (list3 != null) {
            return list3;
        }
        new ArrayList();
        return list2;
    }
}
