package com.google.appinventor.components.runtime;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaActionSound;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;

@DesignerComponent(category = ComponentCategory.UTILITIES, description = "", iconName = "images/screenshot.png", nonVisible = true, version = 2)
@SimpleObject
@UsesPermissions({"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"})
public class Screenshot extends AndroidNonvisibleComponent implements Component {
    private boolean IhlDYVsQmgat6F3NXqRok975lHQlAvyJICX3QHDdE383xYIGTapMORiCm1KjyWCi = false;
    private String NR00JNNlW621wVdOuGmKXPtjBpGajdPcd2Ky3026Pmc1Ihub1KfdGuuwHN0dv78V;
    private boolean TVKenNjujur1C1Ft9Gj8dhchvJBwuJV9GDuQOmGg2gZVCkxzGoaa0a88A5IZ9COq = false;
    private int aWkZqinykMPj8SPm5jVT2wNdrJPpyMEjt10g4Ng570XD4n7VSaFhL3td3g0Xab2G;
    private Activity activity;
    private Context context;
    private float dimAmount;
    private String eCKrLERXZY2Z3jwuVt55PeHUkE4lFRkPVtMcgtoMaoQxt1GsNCdNb2NNztke1B7i = "Screenshot.png";
    private MediaActionSound hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    private String nItr2rEUwjLh7peU3NgfalZQrx3V2u3REmTnCv6vRXk7VqyYqrNzZhPvrb2eDYTE;
    private boolean symWhrqAyHWXMObHLoQEIMlJvqdZFvcp7UyC2VmDxP3CgSs0pkdkxz6qiaDBzrEK;
    private String uB4tu69UCQ2bAIAJLxBrazJ0pEJF4D6biU0hi2lcEJLr1A0KTbjBgSa8eZhiikvR = "Share";
    private int vvjaKRMN9H6lYkjQrf39wC72L2per26vSgUw9e5mZIMwW4gwULkxbiBNnCPVkUrj;
    private Bitmap vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R;
    private String wOjOOBWoVyNzDzaWXgy1S9rRvmLqhYagLoPiKuHlw4Kpu5E5zVoSLSrwTs2bXyKG = "Screenshot..";
    private boolean wfbsnc19ruRPyBpriU11i0zXW81wrBgGRVM2BOD65kRILLKDr3mBxnYSQKLd5kkO = true;

    static /* synthetic */ Bitmap hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(Screenshot screenshot, Bitmap bitmap) {
        Bitmap bitmap2 = bitmap;
        Bitmap bitmap3 = bitmap2;
        screenshot.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R = bitmap3;
        return bitmap2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Screenshot(com.google.appinventor.components.runtime.ComponentContainer r9) {
        /*
            r8 = this;
            r0 = r8
            r1 = r9
            r3 = r0
            r4 = r1
            com.google.appinventor.components.runtime.Form r4 = r4.$form()
            r3.<init>(r4)
            r3 = r0
            java.lang.String r4 = "Screenshot.png"
            r3.eCKrLERXZY2Z3jwuVt55PeHUkE4lFRkPVtMcgtoMaoQxt1GsNCdNb2NNztke1B7i = r4
            r3 = r0
            r4 = 1
            r3.wfbsnc19ruRPyBpriU11i0zXW81wrBgGRVM2BOD65kRILLKDr3mBxnYSQKLd5kkO = r4
            r3 = r0
            r4 = 0
            r3.IhlDYVsQmgat6F3NXqRok975lHQlAvyJICX3QHDdE383xYIGTapMORiCm1KjyWCi = r4
            r3 = r0
            java.lang.String r4 = "Screenshot.."
            r3.wOjOOBWoVyNzDzaWXgy1S9rRvmLqhYagLoPiKuHlw4Kpu5E5zVoSLSrwTs2bXyKG = r4
            r3 = r0
            java.lang.String r4 = "Share"
            r3.uB4tu69UCQ2bAIAJLxBrazJ0pEJF4D6biU0hi2lcEJLr1A0KTbjBgSa8eZhiikvR = r4
            r3 = r0
            r4 = 0
            r3.TVKenNjujur1C1Ft9Gj8dhchvJBwuJV9GDuQOmGg2gZVCkxzGoaa0a88A5IZ9COq = r4
            r3 = r0
            r4 = r1
            android.app.Activity r4 = r4.$context()
            r3.context = r4
            r3 = r0
            r4 = r1
            android.app.Activity r4 = r4.$context()
            r3.activity = r4
            r3 = r0
            r4 = 1
            r3.symWhrqAyHWXMObHLoQEIMlJvqdZFvcp7UyC2VmDxP3CgSs0pkdkxz6qiaDBzrEK = r4
            r3 = r0
            r4 = 1056964608(0x3f000000, float:0.5)
            r3.dimAmount = r4
            r3 = r0
            android.content.Context r3 = r3.context
            android.content.pm.PackageManager r3 = r3.getPackageManager()
            r1 = r3
            r3 = r0
            android.content.Context r3 = r3.context
            java.lang.String r3 = r3.getPackageName()
            r2 = r3
            r3 = r0
            r4 = r1
            java.lang.String r5 = "android.permission.READ_EXTERNAL_STORAGE"
            r6 = r2
            int r4 = r4.checkPermission(r5, r6)
            r3.aWkZqinykMPj8SPm5jVT2wNdrJPpyMEjt10g4Ng570XD4n7VSaFhL3td3g0Xab2G = r4
            r3 = r0
            r4 = r1
            java.lang.String r5 = "android.permission.WRITE_EXTERNAL_STORAGE"
            r6 = r2
            int r4 = r4.checkPermission(r5, r6)
            r3.vvjaKRMN9H6lYkjQrf39wC72L2per26vSgUw9e5mZIMwW4gwULkxbiBNnCPVkUrj = r4
            r3 = r0
            android.media.MediaActionSound r4 = new android.media.MediaActionSound
            r7 = r4
            r4 = r7
            r5 = r7
            r5.<init>()
            r3.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r4
            r3 = r0
            android.media.MediaActionSound r3 = r3.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r4 = 0
            r3.load(r4)
            java.lang.String r3 = "Screenshot"
            java.lang.String r4 = "Screenshot Created"
            int r3 = android.util.Log.d(r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.Screenshot.<init>(com.google.appinventor.components.runtime.ComponentContainer):void");
    }

    @SimpleFunction(description = "Take a screenshot of the current visible screen.")
    public void TakeScreenshot() {
        PermissionResultHandler permissionResultHandler;
        new PermissionResultHandler(this) {
            private /* synthetic */ Screenshot hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

            {
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r5;
            }

            public final void HandlePermissionResponse(String str, boolean z) {
                a aVar;
                String str2 = str;
                if (z) {
                    new a(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, (byte) 0);
                    AsyncTask execute = aVar.execute(new String[]{""});
                    return;
                }
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.form.dispatchPermissionDeniedEvent((Component) this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, "TakeScreenshot", str2);
            }
        };
        this.form.askPermission("android.permission.WRITE_EXTERNAL_STORAGE", permissionResultHandler);
    }

    @SuppressLint({"StaticFieldLeak"})
    class a extends AsyncTask<String, String, String> {
        private View B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T;
        private /* synthetic */ Screenshot hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            Object[] objArr2 = objArr;
            return wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            String str = (String) obj;
            Screenshot.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME).play(0);
            if (Screenshot.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME)) {
                Screenshot.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
            }
            if (Screenshot.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME) && Screenshot.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME) != null) {
                MakeroidNotification.ScreenshotNotification(Screenshot.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME), Screenshot.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME), Screenshot.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME), Screenshot.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME), Uri.parse(Screenshot.vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME)), Screenshot.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME), Screenshot.vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME), Screenshot.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME));
            }
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.GotScreenshot(str);
            String[] strArr = new String[1];
            strArr[0] = str;
            MediaScannerConnection.scanFile(Screenshot.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME), strArr, new String[]{"image/*"}, (MediaScannerConnection.OnScanCompletedListener) null);
        }

        private a(Screenshot screenshot) {
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = screenshot;
            this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = null;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        /* synthetic */ a(Screenshot screenshot, byte b) {
            this(screenshot);
            byte b2 = b;
        }

        /* access modifiers changed from: protected */
        public final void onPreExecute() {
            this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = Screenshot.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME).getWindow().getDecorView().getRootView();
            this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.setDrawingCacheEnabled(true);
            this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.buildDrawingCache(true);
        }

        private String wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou() {
            StringBuilder sb;
            try {
                Bitmap hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2 = Screenshot.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, Bitmap.createBitmap(this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.getDrawingCache()));
                this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.setDrawingCacheEnabled(false);
                return this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.SaveUtil(Screenshot.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME));
            } catch (Exception e) {
                new StringBuilder();
                String sb2 = sb.append(e.getMessage()).toString();
                int e2 = Log.e("Screenshot", sb2);
                Bitmap hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME3 = Screenshot.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, (Bitmap) null);
                this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = null;
                return sb2;
            }
        }
    }

    @SimpleEvent(description = "Event to detect that a screenshot was made by the user. Returns the image path to the taken screenshot.")
    public void GotScreenshot(String str) {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "GotScreenshot", str);
    }

    @DesignerProperty(defaultValue = "Screenshot.png", editorType = "string")
    @SimpleProperty(description = "This will be the name for the taken screenshot image file.")
    public void FileName(String str) {
        String str2 = str;
        this.eCKrLERXZY2Z3jwuVt55PeHUkE4lFRkPVtMcgtoMaoQxt1GsNCdNb2NNztke1B7i = str2;
    }

    @SimpleProperty(description = "Returns the given screenshot filename.")
    public String FileName() {
        return this.eCKrLERXZY2Z3jwuVt55PeHUkE4lFRkPVtMcgtoMaoQxt1GsNCdNb2NNztke1B7i;
    }

    /* JADX WARNING: type inference failed for: r5v20, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String SaveUtil(android.graphics.Bitmap r10) {
        /*
            r9 = this;
            r0 = r9
            r1 = r10
            r4 = 0
            r2 = r4
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ PermissionException -> 0x0091, FileNotFoundException -> 0x00c9, Exception -> 0x00f2 }
            r8 = r4
            r4 = r8
            r5 = r8
            r5.<init>()     // Catch:{ PermissionException -> 0x0091, FileNotFoundException -> 0x00c9, Exception -> 0x00f2 }
            r3 = r4
            r4 = r1
            android.graphics.Bitmap$CompressFormat r5 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ PermissionException -> 0x0091, FileNotFoundException -> 0x00c9, Exception -> 0x00f2 }
            r6 = 0
            r7 = r3
            boolean r4 = r4.compress(r5, r6, r7)     // Catch:{ PermissionException -> 0x0091, FileNotFoundException -> 0x00c9, Exception -> 0x00f2 }
            java.io.File r4 = new java.io.File     // Catch:{ PermissionException -> 0x0091, FileNotFoundException -> 0x00c9, Exception -> 0x00f2 }
            r8 = r4
            r4 = r8
            r5 = r8
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ PermissionException -> 0x0091, FileNotFoundException -> 0x00c9, Exception -> 0x00f2 }
            r8 = r6
            r6 = r8
            r7 = r8
            r7.<init>()     // Catch:{ PermissionException -> 0x0091, FileNotFoundException -> 0x00c9, Exception -> 0x00f2 }
            r7 = r0
            android.content.Context r7 = r7.context     // Catch:{ PermissionException -> 0x0091, FileNotFoundException -> 0x00c9, Exception -> 0x00f2 }
            java.io.File r7 = com.google.appinventor.components.runtime.util.QUtil.getExternalStorageDir(r7)     // Catch:{ PermissionException -> 0x0091, FileNotFoundException -> 0x00c9, Exception -> 0x00f2 }
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ PermissionException -> 0x0091, FileNotFoundException -> 0x00c9, Exception -> 0x00f2 }
            java.lang.String r7 = "/"
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ PermissionException -> 0x0091, FileNotFoundException -> 0x00c9, Exception -> 0x00f2 }
            r7 = r0
            java.lang.String r7 = r7.eCKrLERXZY2Z3jwuVt55PeHUkE4lFRkPVtMcgtoMaoQxt1GsNCdNb2NNztke1B7i     // Catch:{ PermissionException -> 0x0091, FileNotFoundException -> 0x00c9, Exception -> 0x00f2 }
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ PermissionException -> 0x0091, FileNotFoundException -> 0x00c9, Exception -> 0x00f2 }
            java.lang.String r6 = r6.toString()     // Catch:{ PermissionException -> 0x0091, FileNotFoundException -> 0x00c9, Exception -> 0x00f2 }
            r5.<init>(r6)     // Catch:{ PermissionException -> 0x0091, FileNotFoundException -> 0x00c9, Exception -> 0x00f2 }
            r1 = r4
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ PermissionException -> 0x0091, FileNotFoundException -> 0x00c9, Exception -> 0x00f2 }
            r8 = r4
            r4 = r8
            r5 = r8
            r6 = r1
            r5.<init>(r6)     // Catch:{ PermissionException -> 0x0091, FileNotFoundException -> 0x00c9, Exception -> 0x00f2 }
            r8 = r4
            r4 = r8
            r5 = r8
            r2 = r5
            r5 = r3
            byte[] r5 = r5.toByteArray()     // Catch:{ PermissionException -> 0x0091, FileNotFoundException -> 0x00c9, Exception -> 0x00f2 }
            r4.write(r5)     // Catch:{ PermissionException -> 0x0091, FileNotFoundException -> 0x00c9, Exception -> 0x00f2 }
            r4 = r2
            r4.flush()     // Catch:{ PermissionException -> 0x0091, FileNotFoundException -> 0x00c9, Exception -> 0x00f2 }
            r4 = r2
            r4.close()     // Catch:{ PermissionException -> 0x0091, FileNotFoundException -> 0x00c9, Exception -> 0x00f2 }
            r4 = r0
            r5 = r1
            java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ PermissionException -> 0x0091, FileNotFoundException -> 0x00c9, Exception -> 0x00f2 }
            r4.nItr2rEUwjLh7peU3NgfalZQrx3V2u3REmTnCv6vRXk7VqyYqrNzZhPvrb2eDYTE = r5     // Catch:{ PermissionException -> 0x0091, FileNotFoundException -> 0x00c9, Exception -> 0x00f2 }
            r4 = r0
            r5 = r1
            java.lang.String r5 = r5.getName()     // Catch:{ PermissionException -> 0x0091, FileNotFoundException -> 0x00c9, Exception -> 0x00f2 }
            r4.NR00JNNlW621wVdOuGmKXPtjBpGajdPcd2Ky3026Pmc1Ihub1KfdGuuwHN0dv78V = r5     // Catch:{ PermissionException -> 0x0091, FileNotFoundException -> 0x00c9, Exception -> 0x00f2 }
            r4 = r1
            java.lang.String r4 = r4.getAbsolutePath()     // Catch:{ PermissionException -> 0x0091, FileNotFoundException -> 0x00c9, Exception -> 0x00f2 }
            r1 = r4
            r4 = r2
            r4.flush()     // Catch:{ Exception -> 0x0082 }
            r4 = r2
            r4.close()     // Catch:{ Exception -> 0x0082 }
        L_0x007f:
            r4 = r1
            r0 = r4
        L_0x0081:
            return r0
        L_0x0082:
            r4 = move-exception
            r2 = r4
            java.lang.String r4 = "Screenshot"
            r5 = r2
            java.lang.String r5 = java.lang.String.valueOf(r5)
            int r4 = android.util.Log.e(r4, r5)
            goto L_0x007f
        L_0x0091:
            r4 = move-exception
            r3 = r4
            r4 = r0
            com.google.appinventor.components.runtime.Form r4 = r4.form     // Catch:{ all -> 0x011b }
            r5 = r0
            java.lang.String r6 = "TakeScreenshot"
            r7 = r3
            r4.dispatchPermissionDeniedEvent((com.google.appinventor.components.runtime.Component) r5, (java.lang.String) r6, (com.google.appinventor.components.runtime.errors.PermissionException) r7)     // Catch:{ all -> 0x011b }
            r4 = r2
            if (r4 == 0) goto L_0x00a9
            r4 = r2
            r4.flush()     // Catch:{ Exception -> 0x00ba }
            r4 = r2
            r4.close()     // Catch:{ Exception -> 0x00ba }
        L_0x00a9:
            r4 = r0
            java.lang.String r5 = "ERROR"
            r4.nItr2rEUwjLh7peU3NgfalZQrx3V2u3REmTnCv6vRXk7VqyYqrNzZhPvrb2eDYTE = r5
            r4 = r0
            java.lang.String r5 = "ERROR"
            r4.NR00JNNlW621wVdOuGmKXPtjBpGajdPcd2Ky3026Pmc1Ihub1KfdGuuwHN0dv78V = r5
            java.lang.String r4 = "ERROR"
            r0 = r4
            goto L_0x0081
        L_0x00ba:
            r4 = move-exception
            r3 = r4
            java.lang.String r4 = "Screenshot"
            r5 = r3
            java.lang.String r5 = java.lang.String.valueOf(r5)
            int r4 = android.util.Log.e(r4, r5)
            goto L_0x00a9
        L_0x00c9:
            r4 = move-exception
            r3 = r4
            java.lang.String r4 = "Screenshot"
            r5 = r3
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x011b }
            int r4 = android.util.Log.e(r4, r5)     // Catch:{ all -> 0x011b }
            r4 = r2
            if (r4 == 0) goto L_0x00a9
            r4 = r2
            r4.flush()     // Catch:{ Exception -> 0x00e3 }
            r4 = r2
            r4.close()     // Catch:{ Exception -> 0x00e3 }
            goto L_0x00a9
        L_0x00e3:
            r4 = move-exception
            r3 = r4
            java.lang.String r4 = "Screenshot"
            r5 = r3
            java.lang.String r5 = java.lang.String.valueOf(r5)
            int r4 = android.util.Log.e(r4, r5)
            goto L_0x00a9
        L_0x00f2:
            r4 = move-exception
            r3 = r4
            java.lang.String r4 = "Screenshot"
            r5 = r3
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x011b }
            int r4 = android.util.Log.e(r4, r5)     // Catch:{ all -> 0x011b }
            r4 = r2
            if (r4 == 0) goto L_0x00a9
            r4 = r2
            r4.flush()     // Catch:{ Exception -> 0x010c }
            r4 = r2
            r4.close()     // Catch:{ Exception -> 0x010c }
            goto L_0x00a9
        L_0x010c:
            r4 = move-exception
            r3 = r4
            java.lang.String r4 = "Screenshot"
            r5 = r3
            java.lang.String r5 = java.lang.String.valueOf(r5)
            int r4 = android.util.Log.e(r4, r5)
            goto L_0x00a9
        L_0x011b:
            r4 = move-exception
            r1 = r4
            r4 = r2
            if (r4 == 0) goto L_0x0128
            r4 = r2
            r4.flush()     // Catch:{ Exception -> 0x012a }
            r4 = r2
            r4.close()     // Catch:{ Exception -> 0x012a }
        L_0x0128:
            r4 = r1
            throw r4
        L_0x012a:
            r4 = move-exception
            r2 = r4
            java.lang.String r4 = "Screenshot"
            r5 = r2
            java.lang.String r5 = java.lang.String.valueOf(r5)
            int r4 = android.util.Log.e(r4, r5)
            goto L_0x0128
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.Screenshot.SaveUtil(android.graphics.Bitmap):java.lang.String");
    }

    @DesignerProperty(defaultValue = "True", editorType = "boolean")
    @SimpleProperty(description = "If enabled you will see a short preview animation after the screenshot is taken.")
    public void ShowPreview(boolean z) {
        boolean z2 = z;
        this.wfbsnc19ruRPyBpriU11i0zXW81wrBgGRVM2BOD65kRILLKDr3mBxnYSQKLd5kkO = z2;
    }

    @SimpleProperty(description = "Returns true if \"Show Preview\" is enabled.")
    public boolean ShowPreview() {
        return this.wfbsnc19ruRPyBpriU11i0zXW81wrBgGRVM2BOD65kRILLKDr3mBxnYSQKLd5kkO;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty(description = "If enabled you will see a notification in the statusbar after the screenshot is taken.")
    public void ShowNotification(boolean z) {
        boolean z2 = z;
        this.IhlDYVsQmgat6F3NXqRok975lHQlAvyJICX3QHDdE383xYIGTapMORiCm1KjyWCi = z2;
    }

    @SimpleProperty(description = "Returns true if \"Show Notification\" is enabled.")
    public boolean ShowNotification() {
        return this.IhlDYVsQmgat6F3NXqRok975lHQlAvyJICX3QHDdE383xYIGTapMORiCm1KjyWCi;
    }

    @DesignerProperty(defaultValue = "Screenshot..", editorType = "string")
    @SimpleProperty(description = "This will set the notification title if the option \"Show Notification\" is enabled. ")
    public void NotificationTitle(String str) {
        String str2 = str;
        this.wOjOOBWoVyNzDzaWXgy1S9rRvmLqhYagLoPiKuHlw4Kpu5E5zVoSLSrwTs2bXyKG = str2;
    }

    @SimpleProperty(description = "Returns the notification title.")
    public String NotificationTitle() {
        return this.wOjOOBWoVyNzDzaWXgy1S9rRvmLqhYagLoPiKuHlw4Kpu5E5zVoSLSrwTs2bXyKG;
    }

    @DesignerProperty(defaultValue = "Share", editorType = "string")
    @SimpleProperty(description = "This will set the notification share button text if the option \"Show Notification\" is enabled.")
    public void NotificationShareTitle(String str) {
        String str2 = str;
        this.uB4tu69UCQ2bAIAJLxBrazJ0pEJF4D6biU0hi2lcEJLr1A0KTbjBgSa8eZhiikvR = str2;
    }

    @SimpleProperty(description = "Returns the notification share button text.")
    public String NotificationShareTitle() {
        return this.uB4tu69UCQ2bAIAJLxBrazJ0pEJF4D6biU0hi2lcEJLr1A0KTbjBgSa8eZhiikvR;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty(description = "This will display the notification in a big style.")
    public void NotificationBigStyle(boolean z) {
        boolean z2 = z;
        this.TVKenNjujur1C1Ft9Gj8dhchvJBwuJV9GDuQOmGg2gZVCkxzGoaa0a88A5IZ9COq = z2;
    }

    @SimpleProperty(description = "Returns the notification big style option status.")
    public boolean NotificationBigStyle() {
        return this.TVKenNjujur1C1Ft9Gj8dhchvJBwuJV9GDuQOmGg2gZVCkxzGoaa0a88A5IZ9COq;
    }

    @DesignerProperty(defaultValue = "True", editorType = "boolean")
    @SimpleProperty(description = "This feature allows users of your app to make or ban screenshots of their app. If disabled and a person tries to make a screenshot, they will receive then a default system message that this is not possible.")
    public void AllowScreenshots(boolean z) {
        if (z) {
            this.activity.getWindow().clearFlags(8192);
        } else {
            this.activity.getWindow().setFlags(8192, 8192);
        }
    }

    @SimpleProperty(description = "Returns true if the write and read permission is granted, else false.")
    public boolean arePermissionsGranted() {
        return this.aWkZqinykMPj8SPm5jVT2wNdrJPpyMEjt10g4Ng570XD4n7VSaFhL3td3g0Xab2G == 0 && this.vvjaKRMN9H6lYkjQrf39wC72L2per26vSgUw9e5mZIMwW4gwULkxbiBNnCPVkUrj == 0;
    }

    @SimpleProperty(description = "Returns true if the read permission is granted, else false.")
    public boolean isReadPermissionGranted() {
        return this.aWkZqinykMPj8SPm5jVT2wNdrJPpyMEjt10g4Ng570XD4n7VSaFhL3td3g0Xab2G == 0;
    }

    @SimpleProperty(description = "Returns true if the write permission is granted, else false.")
    public boolean isWritePermissionGranted() {
        return this.vvjaKRMN9H6lYkjQrf39wC72L2per26vSgUw9e5mZIMwW4gwULkxbiBNnCPVkUrj == 0;
    }

    @DesignerProperty(defaultValue = "True", editorType = "boolean")
    @SimpleProperty(description = "If enabled you will see a notification with a share button after the screenshot is taken.")
    public void NotificationShareButton(boolean z) {
        boolean z2 = z;
        this.symWhrqAyHWXMObHLoQEIMlJvqdZFvcp7UyC2VmDxP3CgSs0pkdkxz6qiaDBzrEK = z2;
    }

    @SimpleProperty
    public boolean NotificationShareButton() {
        return this.symWhrqAyHWXMObHLoQEIMlJvqdZFvcp7UyC2VmDxP3CgSs0pkdkxz6qiaDBzrEK;
    }

    @DesignerProperty(defaultValue = "0.5", editorType = "non_negative_float")
    @SimpleProperty(description = "Set the amount of dim behind the preview window if ShowPreview(...) is enabled. Use '0.0' for no dim and '1.0' for full dim.")
    public void DimAmount(float f) {
        float f2 = f;
        this.dimAmount = f2;
    }

    @SimpleProperty
    public float DimAmount() {
        return this.dimAmount;
    }
}
