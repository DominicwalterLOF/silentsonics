package com.google.appinventor.components.runtime;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.safetynet.SafetyNetStatusCodes;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesLibraries;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.AsynchUtil;
import com.google.appinventor.components.runtime.util.YailList;
import java.util.Map;

@DesignerComponent(category = ComponentCategory.GOOGLE, helpUrl = "https://docs.kodular.io/components/google/recaptcha/", iconName = "images/recaptcha.png", nonVisible = true, version = 1)
@UsesLibraries(libraries = "play-services-safetynet.aar, play-services-safetynet.jar, play-services-base.aar, play-services-base.jar, play-services-basement.aar, play-services-basement.jar, play-services-tasks.aar, play-services-tasks.jar")
@SimpleObject
@UsesPermissions(permissionNames = "android.permission.INTERNET")
public class KodularRecaptcha extends AndroidNonvisibleComponent {
    private final Form form;
    private String tOvM9eIUWszKzvISo4zKh7g8MyRaLHuNLQ5NdigAhriBDKCBmghUBEUlM2ZIvV1J = "";
    private final Map<String, String> vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R;

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0128, code lost:
        r2 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0157, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0158, code lost:
        r1 = false;
        r2 = "";
        r3 = "";
        new java.util.ArrayList();
        r15 = r15;
        r7 = r15.add(r7.getMessage());
        r4 = com.google.appinventor.components.runtime.util.YailList.makeList(r15);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0157 A[ExcHandler: IOException | JSONException (r7v1 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:1:0x0008] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(com.google.appinventor.components.runtime.KodularRecaptcha r16, java.lang.String r17, java.lang.String r18) {
        /*
            r0 = r16
            r1 = r17
            r2 = r18
            r7 = r0
            r0 = r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            r15 = r7
            r7 = r15
            r8 = r15
            java.lang.String r9 = "secret="
            r8.<init>(r9)     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            r8 = r2
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            java.lang.String r8 = "&response="
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            r8 = r1
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            r5 = r7
            java.lang.String r7 = "https://www.google.com/recaptcha/api/siteverify"
            r6 = r7
            java.net.URL r7 = new java.net.URL     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            r15 = r7
            r7 = r15
            r8 = r15
            r9 = r6
            r8.<init>(r9)     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            java.net.URLConnection r7 = r7.openConnection()     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            r15 = r7
            r7 = r15
            r8 = r15
            r1 = r8
            r8 = 1
            r7.setDoOutput(r8)     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            r7 = r1
            java.lang.String r8 = "POST"
            r7.setRequestMethod(r8)     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            r7 = r1
            java.lang.String r8 = "Content-Type"
            java.lang.String r9 = "application/x-www-form-urlencoded; charset=UTF-8"
            r7.setRequestProperty(r8, r9)     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            r7 = r1
            java.io.OutputStream r7 = r7.getOutputStream()     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            r15 = r7
            r7 = r15
            r8 = r15
            r2 = r8
            r8 = r5
            java.nio.charset.Charset r9 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            byte[] r8 = r8.getBytes(r9)     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            r7.write(r8)     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            r7 = r2
            r7.flush()     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            r7 = r2
            r7.close()     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            r7 = r1
            java.io.InputStream r7 = r7.getInputStream()     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            r1 = r7
            java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            r15 = r7
            r7 = r15
            r8 = r15
            java.io.InputStreamReader r9 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            r15 = r9
            r9 = r15
            r10 = r15
            r11 = r1
            java.nio.charset.Charset r12 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            r10.<init>(r11, r12)     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            r8.<init>(r9)     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            r2 = r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            r15 = r7
            r7 = r15
            r8 = r15
            r8.<init>()     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            r3 = r7
        L_0x0093:
            r7 = r2
            int r7 = r7.read()     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            r15 = r7
            r7 = r15
            r8 = r15
            r4 = r8
            r8 = -1
            if (r7 == r8) goto L_0x00a7
            r7 = r3
            r8 = r4
            char r8 = (char) r8     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            goto L_0x0093
        L_0x00a7:
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            r15 = r7
            r7 = r15
            r8 = r15
            r9 = r3
            java.lang.String r9 = r9.toString()     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            r8.<init>(r9)     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            r4 = r7
            r7 = r2
            r7.close()     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            r7 = r1
            r7.close()     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            r7 = r4
            java.lang.String r8 = "success"
            boolean r7 = r7.getBoolean(r8)     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            r1 = r7
            r7 = r4
            java.lang.String r8 = "challenge_ts"
            java.lang.String r7 = r7.getString(r8)     // Catch:{ JSONException -> 0x0127, IOException -> 0x0157 }
            r15 = r7
            r7 = r15
            r8 = r15
            r2 = r8
            if (r7 != 0) goto L_0x00d8
            java.lang.String r7 = ""
            r2 = r7
        L_0x00d8:
            r7 = r4
            java.lang.String r8 = "apk_package_name"
            java.lang.String r7 = r7.getString(r8)     // Catch:{ JSONException -> 0x012d, IOException -> 0x0157 }
            r15 = r7
            r7 = r15
            r8 = r15
            r3 = r8
            if (r7 != 0) goto L_0x00ea
            java.lang.String r7 = ""
            r3 = r7
        L_0x00ea:
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            r15 = r7
            r7 = r15
            r8 = r15
            r8.<init>()     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            r5 = r7
            r7 = r4
            java.lang.String r8 = "error-codes"
            org.json.JSONArray r7 = r7.getJSONArray(r8)     // Catch:{ JSONException -> 0x0155, IOException -> 0x0157 }
            r15 = r7
            r7 = r15
            r8 = r15
            r4 = r8
            if (r7 == 0) goto L_0x0133
            r7 = r4
            int r7 = r7.length()     // Catch:{ JSONException -> 0x0155, IOException -> 0x0157 }
            if (r7 <= 0) goto L_0x0133
            r7 = 0
            r6 = r7
        L_0x010a:
            r7 = r6
            r8 = r4
            int r8 = r8.length()     // Catch:{ JSONException -> 0x0155, IOException -> 0x0157 }
            if (r7 >= r8) goto L_0x0133
            r7 = r5
            r8 = r0
            java.util.Map<java.lang.String, java.lang.String> r8 = r8.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R     // Catch:{ JSONException -> 0x0155, IOException -> 0x0157 }
            r9 = r4
            r10 = r6
            java.lang.String r9 = r9.getString(r10)     // Catch:{ JSONException -> 0x0155, IOException -> 0x0157 }
            java.lang.Object r8 = r8.get(r9)     // Catch:{ JSONException -> 0x0155, IOException -> 0x0157 }
            boolean r7 = r7.add(r8)     // Catch:{ JSONException -> 0x0155, IOException -> 0x0157 }
            int r6 = r6 + 1
            goto L_0x010a
        L_0x0127:
            r7 = move-exception
            java.lang.String r7 = ""
            r2 = r7
            goto L_0x00d8
        L_0x012d:
            r7 = move-exception
            java.lang.String r7 = ""
            r3 = r7
            goto L_0x00ea
        L_0x0133:
            r7 = r5
            com.google.appinventor.components.runtime.util.YailList r7 = com.google.appinventor.components.runtime.util.YailList.makeList((java.util.List) r7)     // Catch:{ IOException -> 0x0157, JSONException -> 0x017f }
            r4 = r7
        L_0x0139:
            r7 = r1
            r5 = r7
            r7 = r2
            r6 = r7
            r7 = r3
            r1 = r7
            r7 = r4
            r2 = r7
            r7 = r0
            com.google.appinventor.components.runtime.Form r7 = r7.form
            com.google.appinventor.components.runtime.KodularRecaptcha$5 r8 = new com.google.appinventor.components.runtime.KodularRecaptcha$5
            r15 = r8
            r8 = r15
            r9 = r15
            r10 = r0
            r11 = r5
            r12 = r6
            r13 = r1
            r14 = r2
            r9.<init>(r10, r11, r12, r13, r14)
            r7.runOnUiThread(r8)
            return
        L_0x0155:
            r7 = move-exception
            goto L_0x0133
        L_0x0157:
            r7 = move-exception
        L_0x0158:
            r5 = r7
            r7 = 0
            r1 = r7
            java.lang.String r7 = ""
            r2 = r7
            java.lang.String r7 = ""
            r3 = r7
            java.util.ArrayList r7 = new java.util.ArrayList
            r15 = r7
            r7 = r15
            r8 = r15
            r8.<init>()
            r15 = r7
            r7 = r15
            r8 = r15
            r6 = r8
            r8 = r5
            java.lang.String r8 = r8.getMessage()
            boolean r7 = r7.add(r8)
            r7 = r6
            com.google.appinventor.components.runtime.util.YailList r7 = com.google.appinventor.components.runtime.util.YailList.makeList((java.util.List) r7)
            r4 = r7
            goto L_0x0139
        L_0x017f:
            r7 = move-exception
            goto L_0x0158
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.KodularRecaptcha.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(com.google.appinventor.components.runtime.KodularRecaptcha, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public KodularRecaptcha(com.google.appinventor.components.runtime.ComponentContainer r8) {
        /*
            r7 = this;
            r0 = r7
            r1 = r8
            r2 = r0
            r3 = r1
            com.google.appinventor.components.runtime.Form r3 = r3.$form()
            r2.<init>(r3)
            r2 = r0
            java.lang.String r3 = ""
            r2.tOvM9eIUWszKzvISo4zKh7g8MyRaLHuNLQ5NdigAhriBDKCBmghUBEUlM2ZIvV1J = r3
            r2 = r0
            com.google.appinventor.components.runtime.KodularRecaptcha$1 r3 = new com.google.appinventor.components.runtime.KodularRecaptcha$1
            r6 = r3
            r3 = r6
            r4 = r6
            r5 = r0
            r4.<init>(r5)
            r2.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R = r3
            r2 = r0
            r3 = r1
            com.google.appinventor.components.runtime.Form r3 = r3.$form()
            r2.form = r3
            java.lang.String r2 = "ReCaptcha"
            java.lang.String r3 = "Kodular reCaptcha component created"
            int r2 = android.util.Log.d(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.KodularRecaptcha.<init>(com.google.appinventor.components.runtime.ComponentContainer):void");
    }

    @DesignerProperty(editorType = "string")
    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Sets the Google reCaptcha API Site Key. It is mandatory to use reCaptcha, as it will identify user's request with the challenge prompt.")
    public void SiteKey(String str) {
        String str2 = str;
        this.tOvM9eIUWszKzvISo4zKh7g8MyRaLHuNLQ5NdigAhriBDKCBmghUBEUlM2ZIvV1J = str2;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Returns the Google reCaptcha API Site Key.")
    public String SiteKey() {
        return this.tOvM9eIUWszKzvISo4zKh7g8MyRaLHuNLQ5NdigAhriBDKCBmghUBEUlM2ZIvV1J;
    }

    @SimpleFunction(description = "Prompt the user with a Google reCaptcha challenge. Needs a reCaptcha API Site Key to work.")
    public void Prompt() {
        OnSuccessListener onSuccessListener;
        OnFailureListener onFailureListener;
        new OnSuccessListener<SafetyNetApi.RecaptchaTokenResponse>(this) {
            private /* synthetic */ KodularRecaptcha hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

            {
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r5;
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                String tokenResult = ((SafetyNetApi.RecaptchaTokenResponse) obj).getTokenResult();
                String str = tokenResult;
                if (tokenResult == null || str.isEmpty()) {
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.PromptErrored(-2, "No UserResponse");
                } else {
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.PromptSucceeded(str);
                }
            }
        };
        new OnFailureListener(this) {
            private /* synthetic */ KodularRecaptcha hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

            {
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r5;
            }

            public final void onFailure(@NonNull Exception exc) {
                Exception exc2 = exc;
                if (exc2 instanceof ApiException) {
                    int statusCode = ((ApiException) exc2).getStatusCode();
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.PromptErrored(statusCode, SafetyNetStatusCodes.getStatusCodeString(statusCode));
                    return;
                }
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.PromptErrored(-1, "Unknown ApiException");
            }
        };
        Task addOnFailureListener = SafetyNet.getClient(this.form).verifyWithRecaptcha(this.tOvM9eIUWszKzvISo4zKh7g8MyRaLHuNLQ5NdigAhriBDKCBmghUBEUlM2ZIvV1J).addOnSuccessListener(onSuccessListener).addOnFailureListener(onFailureListener);
    }

    @SimpleEvent(description = "Event will be invoked Google reCaptcha returns a success status code, returning the user response token which should be verified later.")
    public void PromptSucceeded(String str) {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "PromptSucceeded", str);
    }

    @SimpleEvent(description = "Event will be invoked when Google reCaptcha prompt returns an error status code.")
    public void PromptErrored(int i, String str) {
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        Object[] objArr2 = objArr;
        objArr2[1] = str;
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "PromptErrored", objArr2);
    }

    @SimpleFunction(description = "Validate the received userResponseToken with your API Secret Key, for increased security. It is recommended to use the 'Obfuscated Text' block with the API Secret Key.")
    public void Validate(String str, String str2) {
        Runnable runnable;
        final String str3 = str;
        final String str4 = str2;
        new Runnable(this) {
            private /* synthetic */ KodularRecaptcha hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

            {
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r7;
            }

            public final void run() {
                KodularRecaptcha.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, str3, str4);
            }
        };
        AsynchUtil.runAsynchronously(runnable);
    }

    @SimpleEvent(description = "Event will be triggered after the Validate method gets a response. 'success' will return true when the prompt was completed successfully, 'challenge Timestamp' is the date the challenge was completed in ISO format, 'app Package Name' will return the package name of the app where the challenge was completed, and 'error Messages' is a list of all errors that occurred during the validation.")
    public void ValidateResponse(boolean z, String str, String str2, YailList yailList) {
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(z);
        Object[] objArr2 = objArr;
        objArr2[1] = str;
        Object[] objArr3 = objArr2;
        objArr3[2] = str2;
        Object[] objArr4 = objArr3;
        objArr4[3] = yailList;
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "ValidateResponse", objArr4);
    }
}
