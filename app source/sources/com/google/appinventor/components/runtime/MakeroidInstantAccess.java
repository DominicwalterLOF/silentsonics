package com.google.appinventor.components.runtime;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.JsonUtil;
import com.google.appinventor.components.runtime.util.KodularUtil;

@DesignerComponent(category = ComponentCategory.INTERNAL, description = "", iconName = "images/instantAccess.png", nonVisible = true, version = 1)
@SimpleObject
@UsesPermissions({"android.permission.INTERNET"})
public class MakeroidInstantAccess extends AndroidNonvisibleComponent implements Component {
    /* access modifiers changed from: private */
    public int ATBpAON767TQmZZYK3lMfxQA5S6eF21JqXY9TAJY6l4cbZGeVMlZehfHdCrTaqio = 1;
    private final String I1fbWPe6RJ2coGGe88dnbV3SwCWOYXWySlRHSiEJVMw7CeEp0YdmKizbxY7zqrk2 = "Please check your user property. Maybe it is empty?";
    private String I88voynnB6lCbi2eFsNA2DcXYsTa46aEiMaovSB2sEx9V3gZP1qdgaJzEiYc8qjH = "";
    private final String Mn7MCs8byCcphc6u6vZkI1pXuzw5IvVJJPq0YTQ0xCW64cXQ1HYdJPP7QsOPqGr1 = "Error - no data";
    private final String P89mqD3TKqF18ygPOurbjck3EPcqxgmZ649A3XXayOkNUpvgMJ4Q1cnkfpD040KQ = "Please check your Client ID property. Maybe it is empty?";
    private final String TcZoKXUijRhvOFm1gZ0ppEfXWxECqlUNNvncSPIfT3ZrTDcozo05OAb21mkMXciT = "Error - no message";
    private String boZncMwfbKhn9wEZVXOlCQaCALViR3x19GsnEC1EZxndIE2ufazY5HxCE0U58Zvt = "";
    private Context context;
    private final String hlRRzlkTvaLJKT7xudtgqrNpSapzuwbeZZHKJdIwcwGUTFYejftgk4y9qZgGh2f0 = "Please check your Client Secret property. Maybe it is empty?";

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MakeroidInstantAccess(com.google.appinventor.components.runtime.ComponentContainer r5) {
        /*
            r4 = this;
            r0 = r4
            r1 = r5
            r2 = r0
            r3 = r1
            com.google.appinventor.components.runtime.Form r3 = r3.$form()
            r2.<init>(r3)
            r2 = r0
            java.lang.String r3 = ""
            r2.I88voynnB6lCbi2eFsNA2DcXYsTa46aEiMaovSB2sEx9V3gZP1qdgaJzEiYc8qjH = r3
            r2 = r0
            java.lang.String r3 = ""
            r2.boZncMwfbKhn9wEZVXOlCQaCALViR3x19GsnEC1EZxndIE2ufazY5HxCE0U58Zvt = r3
            r2 = r0
            r3 = 1
            r2.ATBpAON767TQmZZYK3lMfxQA5S6eF21JqXY9TAJY6l4cbZGeVMlZehfHdCrTaqio = r3
            r2 = r0
            java.lang.String r3 = "Please check your Client ID property. Maybe it is empty?"
            r2.P89mqD3TKqF18ygPOurbjck3EPcqxgmZ649A3XXayOkNUpvgMJ4Q1cnkfpD040KQ = r3
            r2 = r0
            java.lang.String r3 = "Please check your Client Secret property. Maybe it is empty?"
            r2.hlRRzlkTvaLJKT7xudtgqrNpSapzuwbeZZHKJdIwcwGUTFYejftgk4y9qZgGh2f0 = r3
            r2 = r0
            java.lang.String r3 = "Please check your user property. Maybe it is empty?"
            r2.I1fbWPe6RJ2coGGe88dnbV3SwCWOYXWySlRHSiEJVMw7CeEp0YdmKizbxY7zqrk2 = r3
            r2 = r0
            java.lang.String r3 = "Error - no data"
            r2.Mn7MCs8byCcphc6u6vZkI1pXuzw5IvVJJPq0YTQ0xCW64cXQ1HYdJPP7QsOPqGr1 = r3
            r2 = r0
            java.lang.String r3 = "Error - no message"
            r2.TcZoKXUijRhvOFm1gZ0ppEfXWxECqlUNNvncSPIfT3ZrTDcozo05OAb21mkMXciT = r3
            r2 = r0
            r3 = r1
            android.app.Activity r3 = r3.$context()
            r2.context = r3
            java.lang.String r2 = "Instant Access"
            java.lang.String r3 = "Instant Access Created"
            int r2 = android.util.Log.d(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.MakeroidInstantAccess.<init>(com.google.appinventor.components.runtime.ComponentContainer):void");
    }

    @SimpleFunction(description = "Start a request to user with the instant access login service.")
    public void Request(String str) {
        StringBuilder sb;
        a aVar;
        String str2 = str;
        new StringBuilder("https://dashboard.instantaccess.io/api/partner/authorize?client_id=");
        String sb2 = sb.append(this.I88voynnB6lCbi2eFsNA2DcXYsTa46aEiMaovSB2sEx9V3gZP1qdgaJzEiYc8qjH).append("&client_secret=").append(this.boZncMwfbKhn9wEZVXOlCQaCALViR3x19GsnEC1EZxndIE2ufazY5HxCE0U58Zvt).append("&user_identifier=").append(str2).toString();
        if (this.I88voynnB6lCbi2eFsNA2DcXYsTa46aEiMaovSB2sEx9V3gZP1qdgaJzEiYc8qjH == null || this.I88voynnB6lCbi2eFsNA2DcXYsTa46aEiMaovSB2sEx9V3gZP1qdgaJzEiYc8qjH.isEmpty()) {
            OnRequestSent(false, "Error - no data", "Please check your Client ID property. Maybe it is empty?");
            int e = Log.e("Instant Access", "Client ID is null or empty.");
        } else if (this.boZncMwfbKhn9wEZVXOlCQaCALViR3x19GsnEC1EZxndIE2ufazY5HxCE0U58Zvt == null || this.boZncMwfbKhn9wEZVXOlCQaCALViR3x19GsnEC1EZxndIE2ufazY5HxCE0U58Zvt.isEmpty()) {
            OnRequestSent(false, "Error - no data", "Please check your Client Secret property. Maybe it is empty?");
            int e2 = Log.e("Instant Access", "Client Secret is null or empty.");
        } else if (str2 == null || str2.isEmpty()) {
            OnRequestSent(false, "Error - no data", "Please check your user property. Maybe it is empty?");
            int e3 = Log.e("Instant Access", "User is null or empty.");
        } else {
            this.ATBpAON767TQmZZYK3lMfxQA5S6eF21JqXY9TAJY6l4cbZGeVMlZehfHdCrTaqio = 1;
            new a(this, (byte) 0);
            AsyncTask execute = aVar.execute(new String[]{sb2});
        }
    }

    @SimpleEvent(description = "A event to detect that the login request was sent.")
    public void OnRequestSent(boolean z, String str, String str2) {
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(z);
        Object[] objArr2 = objArr;
        objArr2[1] = str;
        Object[] objArr3 = objArr2;
        objArr3[2] = str2;
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "OnRequestSent", objArr3);
    }

    @SimpleFunction(description = "Check the current status with a given username.")
    public void CheckStatus(String str) {
        StringBuilder sb;
        a aVar;
        String str2 = str;
        new StringBuilder("https://dashboard.instantaccess.io/api/partner/status?client_id=");
        String sb2 = sb.append(this.I88voynnB6lCbi2eFsNA2DcXYsTa46aEiMaovSB2sEx9V3gZP1qdgaJzEiYc8qjH).append("&client_secret=").append(this.boZncMwfbKhn9wEZVXOlCQaCALViR3x19GsnEC1EZxndIE2ufazY5HxCE0U58Zvt).append("&user_identifier=").append(str2).toString();
        if (this.I88voynnB6lCbi2eFsNA2DcXYsTa46aEiMaovSB2sEx9V3gZP1qdgaJzEiYc8qjH == null || this.I88voynnB6lCbi2eFsNA2DcXYsTa46aEiMaovSB2sEx9V3gZP1qdgaJzEiYc8qjH.isEmpty()) {
            OnStatusReceived(false, "Error - no data", "Please check your Client ID property. Maybe it is empty?");
            int e = Log.e("Instant Access", "Client ID is null or empty.");
        } else if (this.boZncMwfbKhn9wEZVXOlCQaCALViR3x19GsnEC1EZxndIE2ufazY5HxCE0U58Zvt == null || this.boZncMwfbKhn9wEZVXOlCQaCALViR3x19GsnEC1EZxndIE2ufazY5HxCE0U58Zvt.isEmpty()) {
            OnStatusReceived(false, "Error - no data", "Please check your Client Secret property. Maybe it is empty?");
            int e2 = Log.e("Instant Access", "Client Secret is null or empty.");
        } else if (str2 == null || str2.isEmpty()) {
            OnStatusReceived(false, "Error - no data", "Please check your user property. Maybe it is empty?");
            int e3 = Log.e("Instant Access", "User is null or empty.");
        } else {
            this.ATBpAON767TQmZZYK3lMfxQA5S6eF21JqXY9TAJY6l4cbZGeVMlZehfHdCrTaqio = 2;
            new a(this, (byte) 0);
            AsyncTask execute = aVar.execute(new String[]{sb2});
        }
    }

    @SimpleEvent(description = "A event to detect that the status was received.")
    public void OnStatusReceived(boolean z, String str, String str2) {
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(z);
        Object[] objArr2 = objArr;
        objArr2[1] = str;
        Object[] objArr3 = objArr2;
        objArr3[2] = str2;
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "OnStatusReceived", objArr3);
    }

    @DesignerProperty(defaultValue = "", editorType = "string")
    @SimpleProperty(userVisible = false)
    public void ClientID(String str) {
        String str2 = str;
        this.I88voynnB6lCbi2eFsNA2DcXYsTa46aEiMaovSB2sEx9V3gZP1qdgaJzEiYc8qjH = str2;
    }

    @SimpleFunction(description = "Returns the client id.")
    public String ClientID() {
        return this.I88voynnB6lCbi2eFsNA2DcXYsTa46aEiMaovSB2sEx9V3gZP1qdgaJzEiYc8qjH;
    }

    @DesignerProperty(defaultValue = "", editorType = "string")
    @SimpleProperty(userVisible = false)
    public void ClientSecret(String str) {
        String str2 = str;
        this.boZncMwfbKhn9wEZVXOlCQaCALViR3x19GsnEC1EZxndIE2ufazY5HxCE0U58Zvt = str2;
    }

    @SimpleFunction(description = "Returns the client secret.")
    public String ClientSecret() {
        return this.boZncMwfbKhn9wEZVXOlCQaCALViR3x19GsnEC1EZxndIE2ufazY5HxCE0U58Zvt;
    }

    class a extends AsyncTask<String, Void, String> {
        private String KbzcIEn6WDqjdY1QBot1TMrBwhEYy4xAUKG2cbzQ22VNohlOtuBGKUJsEeMNZyEH;
        private /* synthetic */ MakeroidInstantAccess hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

        private a(MakeroidInstantAccess makeroidInstantAccess) {
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = makeroidInstantAccess;
            this.KbzcIEn6WDqjdY1QBot1TMrBwhEYy4xAUKG2cbzQ22VNohlOtuBGKUJsEeMNZyEH = null;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        /* synthetic */ a(MakeroidInstantAccess makeroidInstantAccess, byte b) {
            this(makeroidInstantAccess);
            byte b2 = b;
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            this.KbzcIEn6WDqjdY1QBot1TMrBwhEYy4xAUKG2cbzQ22VNohlOtuBGKUJsEeMNZyEH = KodularUtil.GET_REQUEST(((String[]) objArr)[0]);
            if (!KodularUtil.REQUEST_SUCCESS) {
                if (this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.ATBpAON767TQmZZYK3lMfxQA5S6eF21JqXY9TAJY6l4cbZGeVMlZehfHdCrTaqio == 1) {
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.OnRequestSent(false, "Error - no data", KodularUtil.REQUEST_ERROR_MESSAGE);
                } else if (this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.ATBpAON767TQmZZYK3lMfxQA5S6eF21JqXY9TAJY6l4cbZGeVMlZehfHdCrTaqio == 2) {
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.OnStatusReceived(false, "Error - no data", KodularUtil.REQUEST_ERROR_MESSAGE);
                }
            }
            return this.KbzcIEn6WDqjdY1QBot1TMrBwhEYy4xAUKG2cbzQ22VNohlOtuBGKUJsEeMNZyEH;
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            String str = (String) obj;
            String GetJsonAsString = JsonUtil.GetJsonAsString(str, "data", "Error - no data");
            String GetJsonAsString2 = JsonUtil.GetJsonAsString(str, "message", "Error - no message");
            boolean GetJsonAsBoolean = JsonUtil.GetJsonAsBoolean(str, "success");
            if (this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.ATBpAON767TQmZZYK3lMfxQA5S6eF21JqXY9TAJY6l4cbZGeVMlZehfHdCrTaqio == 1) {
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.OnRequestSent(GetJsonAsBoolean, GetJsonAsString, GetJsonAsString2);
            } else if (this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.ATBpAON767TQmZZYK3lMfxQA5S6eF21JqXY9TAJY6l4cbZGeVMlZehfHdCrTaqio == 2) {
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.OnStatusReceived(GetJsonAsBoolean, GetJsonAsString, GetJsonAsString2);
            }
        }
    }
}
