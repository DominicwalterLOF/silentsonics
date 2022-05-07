package com.google.appinventor.components.runtime;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.TelephonyManager;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.Options;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.EndedStatus;
import com.google.appinventor.components.common.StartedStatus;
import com.google.appinventor.components.runtime.util.PhoneCallUtil;

@DesignerComponent(category = ComponentCategory.SOCIAL, description = "<p>A non-visible component that makes a phone call to the number specified in the <code>PhoneNumber</code> property, which can be set either in the Designer or Blocks Editor. The component has a <code>MakePhoneCall</code> method, enabling the program to launch a phone call.</p><p>Often, this component is used with the <code>ContactPicker</code> component, which lets the user select a contact from the ones stored on the phone and sets the <code>PhoneNumber</code> property to the contact's phone number.</p><p>To directly specify the phone number (e.g., 650-555-1212), set the <code>PhoneNumber</code> property to a Text with the specified digits (e.g., \"6505551212\").  Dashes, dots, and parentheses may be included (e.g., \"(650)-555-1212\") but will be ignored; spaces may not be included.</p>", iconName = "images/phoneCall.png", nonVisible = true, version = 3)
@SimpleObject
@UsesPermissions({"android.permission.READ_PHONE_STATE"})
public class PhoneCall extends AndroidNonvisibleComponent implements ActivityResultListener, Component, OnDestroyListener {
    private final Context context;
    private boolean havePermission = false;
    private boolean hlRRzlkTvaLJKT7xudtgqrNpSapzuwbeZZHKJdIwcwGUTFYejftgk4y9qZgGh2f0 = false;
    private final a hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    private String phoneNumber;

    static {
        String simpleName = PhoneCall.class.getSimpleName();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PhoneCall(com.google.appinventor.components.runtime.ComponentContainer r8) {
        /*
            r7 = this;
            r0 = r7
            r1 = r8
            r2 = r0
            r3 = r1
            com.google.appinventor.components.runtime.Form r3 = r3.$form()
            r2.<init>(r3)
            r2 = r0
            r3 = 0
            r2.havePermission = r3
            r2 = r0
            r3 = 0
            r2.hlRRzlkTvaLJKT7xudtgqrNpSapzuwbeZZHKJdIwcwGUTFYejftgk4y9qZgGh2f0 = r3
            r2 = r0
            r3 = r1
            android.app.Activity r3 = r3.$context()
            r2.context = r3
            r2 = r0
            com.google.appinventor.components.runtime.Form r2 = r2.form
            r3 = r0
            r2.registerForOnDestroy(r3)
            r2 = r0
            com.google.appinventor.components.runtime.Form r2 = r2.form
            r3 = r0
            r4 = 1346916174(0x50484f4e, float:1.3442562E10)
            r2.registerForActivityResult(r3, r4)
            r2 = r0
            java.lang.String r3 = ""
            r2.PhoneNumber(r3)
            r2 = r0
            com.google.appinventor.components.runtime.PhoneCall$a r3 = new com.google.appinventor.components.runtime.PhoneCall$a
            r6 = r3
            r3 = r6
            r4 = r6
            r5 = r0
            r4.<init>(r5)
            r2.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.PhoneCall.<init>(com.google.appinventor.components.runtime.ComponentContainer):void");
    }

    public void Initialize() {
        PermissionResultHandler permissionResultHandler;
        if (this.form.doesAppDeclarePermission("android.permission.PROCESS_OUTGOING_CALLS")) {
            new PermissionResultHandler(this) {
                private /* synthetic */ PhoneCall hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

                {
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r5;
                }

                public final void HandlePermissionResponse(String str, boolean z) {
                    String str2 = str;
                    if (z) {
                        PhoneCall.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
                    } else {
                        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.form.dispatchPermissionDeniedEvent((Component) this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, "Initialize", "android.permission.PROCESS_OUTGOING_CALLS");
                    }
                }
            };
            this.form.askPermission("android.permission.PROCESS_OUTGOING_CALLS", permissionResultHandler);
        }
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public String PhoneNumber() {
        return this.phoneNumber;
    }

    @DesignerProperty(defaultValue = "", editorType = "string")
    @SimpleProperty
    public void PhoneNumber(String str) {
        String str2 = str;
        this.phoneNumber = str2;
    }

    @SimpleFunction
    public void MakePhoneCall() {
        Intent intent;
        new Intent("android.intent.action.DIAL", Uri.fromParts("tel", this.phoneNumber, (String) null));
        Intent intent2 = intent;
        Intent intent3 = intent2;
        if (intent2.resolveActivity(this.form.getPackageManager()) != null) {
            this.form.startActivityForResult(intent3, 1346916174);
        }
    }

    @UsesPermissions({"android.permission.CALL_PHONE"})
    @SimpleFunction
    public void MakePhoneCallDirect() {
        PermissionResultHandler permissionResultHandler;
        if (!this.havePermission) {
            new PermissionResultHandler(this) {
                private /* synthetic */ PhoneCall hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

                {
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r5;
                }

                public final void HandlePermissionResponse(String str, boolean z) {
                    String str2 = str;
                    if (z) {
                        boolean hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2 = PhoneCall.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
                        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.MakePhoneCall();
                        return;
                    }
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.form.dispatchPermissionDeniedEvent((Component) this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, "MakePhoneCall", "android.permission.CALL_PHONE");
                }
            };
            this.form.askPermission("android.permission.CALL_PHONE", permissionResultHandler);
            return;
        }
        PhoneCallUtil.makePhoneCall(this.context, this.phoneNumber);
    }

    @SimpleEvent(description = "Event indicating that a phonecall has started. If status is 1, incoming call is ringing; if status is 2, outgoing call is dialled. phoneNumber is the incoming/outgoing phone number.")
    @UsesPermissions({"android.permission.PROCESS_OUTGOING_CALLS"})
    public void PhoneCallStarted(@Options(StartedStatus.class) int i, String str) {
        String str2 = str;
        StartedStatus fromUnderlyingValue = StartedStatus.fromUnderlyingValue(Integer.valueOf(i));
        StartedStatus startedStatus = fromUnderlyingValue;
        if (fromUnderlyingValue != null) {
            PhoneCallStartedAbstract(startedStatus, str2);
        }
    }

    public void PhoneCallStartedAbstract(StartedStatus startedStatus, String str) {
        Object[] objArr = new Object[2];
        objArr[0] = startedStatus.toUnderlyingValue();
        Object[] objArr2 = objArr;
        objArr2[1] = str;
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "PhoneCallStarted", objArr2);
    }

    @SimpleEvent(description = "Event indicating that a phone call has ended. If status is 1, incoming call is missed or rejected; if status is 2, incoming call is answered before hanging up; if status is 3, outgoing call is hung up. phoneNumber is the ended call phone number.")
    @UsesPermissions({"android.permission.PROCESS_OUTGOING_CALLS"})
    public void PhoneCallEnded(@Options(EndedStatus.class) int i, String str) {
        String str2 = str;
        EndedStatus fromUnderlyingValue = EndedStatus.fromUnderlyingValue(Integer.valueOf(i));
        EndedStatus endedStatus = fromUnderlyingValue;
        if (fromUnderlyingValue != null) {
            PhoneCallEndedAbstract(endedStatus, str2);
        }
    }

    public void PhoneCallEndedAbstract(EndedStatus endedStatus, String str) {
        Object[] objArr = new Object[2];
        objArr[0] = endedStatus.toUnderlyingValue();
        Object[] objArr2 = objArr;
        objArr2[1] = str;
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "PhoneCallEnded", objArr2);
    }

    @SimpleEvent(description = "Event indicating that an incoming phone call is answered. phoneNumber is the incoming call phone number.")
    @UsesPermissions({"android.permission.PROCESS_OUTGOING_CALLS"})
    public void IncomingCallAnswered(String str) {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "IncomingCallAnswered", str);
    }

    public void resultReturned(int i, int i2, Intent intent) {
        int i3 = i2;
        Intent intent2 = intent;
        if (i == 1346916174) {
            PhoneCallStartedAbstract(StartedStatus.Outgoing, "");
        }
    }

    enum b {
        ;
        
        public static final int K7dcZ0wsgklhxIEZ56TEizrYoocHIkvglPQDsEhhjdemR7bSblNU8EAyc3To8SV0 = 0;
        public static final int ZX8R20flhr3CVS4Kl4ZKKDInmXhpC5acCzOjP50MC4PLZvr5DSKJA1uCSNI4PeI = 0;
        public static final int hYIBeJsINiSNmMMYMsE9k7k9FKwSRXABLbxSyf9mDVDqNrjjNU51ZRtstLVyAr2s = 0;

        static {
            ZX8R20flhr3CVS4Kl4ZKKDInmXhpC5acCzOjP50MC4PLZvr5DSKJA1uCSNI4PeI = 1;
            K7dcZ0wsgklhxIEZ56TEizrYoocHIkvglPQDsEhhjdemR7bSblNU8EAyc3To8SV0 = 2;
            hYIBeJsINiSNmMMYMsE9k7k9FKwSRXABLbxSyf9mDVDqNrjjNU51ZRtstLVyAr2s = 3;
            int[] iArr = new int[3];
            iArr[0] = 1;
            int[] iArr2 = iArr;
            iArr2[1] = 2;
            iArr2[2] = 3;
        }
    }

    class a extends BroadcastReceiver {
        private int gmm7XQFeiJoCy8yWhIBdyNlesqTvuP4UyGLNuJ8TYBJTJ249gDjP9OHTkIprzI7 = 0;
        private /* synthetic */ PhoneCall hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
        private String ik13O8j78hPb27XeipAJHUcJmdHxYMJFw4gYbTGvLKIOs7SX1F7x61gocQ17TlNc = "";

        public a(PhoneCall phoneCall) {
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = phoneCall;
        }

        public final void onReceive(Context context, Intent intent) {
            Context context2 = context;
            Intent intent2 = intent;
            String action = intent2.getAction();
            if ("android.intent.action.PHONE_STATE".equals(action)) {
                String stringExtra = intent2.getStringExtra("state");
                if (TelephonyManager.EXTRA_STATE_RINGING.equals(stringExtra)) {
                    this.gmm7XQFeiJoCy8yWhIBdyNlesqTvuP4UyGLNuJ8TYBJTJ249gDjP9OHTkIprzI7 = b.ZX8R20flhr3CVS4Kl4ZKKDInmXhpC5acCzOjP50MC4PLZvr5DSKJA1uCSNI4PeI;
                    this.ik13O8j78hPb27XeipAJHUcJmdHxYMJFw4gYbTGvLKIOs7SX1F7x61gocQ17TlNc = intent2.getStringExtra("incoming_number");
                    if (this.ik13O8j78hPb27XeipAJHUcJmdHxYMJFw4gYbTGvLKIOs7SX1F7x61gocQ17TlNc != null) {
                        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.PhoneCallStartedAbstract(StartedStatus.Incoming, this.ik13O8j78hPb27XeipAJHUcJmdHxYMJFw4gYbTGvLKIOs7SX1F7x61gocQ17TlNc);
                    }
                } else if (TelephonyManager.EXTRA_STATE_OFFHOOK.equals(stringExtra)) {
                    if (this.gmm7XQFeiJoCy8yWhIBdyNlesqTvuP4UyGLNuJ8TYBJTJ249gDjP9OHTkIprzI7 == b.ZX8R20flhr3CVS4Kl4ZKKDInmXhpC5acCzOjP50MC4PLZvr5DSKJA1uCSNI4PeI) {
                        this.gmm7XQFeiJoCy8yWhIBdyNlesqTvuP4UyGLNuJ8TYBJTJ249gDjP9OHTkIprzI7 = b.K7dcZ0wsgklhxIEZ56TEizrYoocHIkvglPQDsEhhjdemR7bSblNU8EAyc3To8SV0;
                        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.IncomingCallAnswered(this.ik13O8j78hPb27XeipAJHUcJmdHxYMJFw4gYbTGvLKIOs7SX1F7x61gocQ17TlNc);
                    }
                } else if (TelephonyManager.EXTRA_STATE_IDLE.equals(stringExtra)) {
                    if (this.gmm7XQFeiJoCy8yWhIBdyNlesqTvuP4UyGLNuJ8TYBJTJ249gDjP9OHTkIprzI7 == b.ZX8R20flhr3CVS4Kl4ZKKDInmXhpC5acCzOjP50MC4PLZvr5DSKJA1uCSNI4PeI) {
                        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.PhoneCallEndedAbstract(EndedStatus.IncomingRejected, this.ik13O8j78hPb27XeipAJHUcJmdHxYMJFw4gYbTGvLKIOs7SX1F7x61gocQ17TlNc);
                    } else if (this.gmm7XQFeiJoCy8yWhIBdyNlesqTvuP4UyGLNuJ8TYBJTJ249gDjP9OHTkIprzI7 == b.K7dcZ0wsgklhxIEZ56TEizrYoocHIkvglPQDsEhhjdemR7bSblNU8EAyc3To8SV0) {
                        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.PhoneCallEndedAbstract(EndedStatus.IncomingEnded, this.ik13O8j78hPb27XeipAJHUcJmdHxYMJFw4gYbTGvLKIOs7SX1F7x61gocQ17TlNc);
                    } else if (this.gmm7XQFeiJoCy8yWhIBdyNlesqTvuP4UyGLNuJ8TYBJTJ249gDjP9OHTkIprzI7 == b.hYIBeJsINiSNmMMYMsE9k7k9FKwSRXABLbxSyf9mDVDqNrjjNU51ZRtstLVyAr2s) {
                        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.PhoneCallEndedAbstract(EndedStatus.OutgoingEnded, this.ik13O8j78hPb27XeipAJHUcJmdHxYMJFw4gYbTGvLKIOs7SX1F7x61gocQ17TlNc);
                    }
                    this.gmm7XQFeiJoCy8yWhIBdyNlesqTvuP4UyGLNuJ8TYBJTJ249gDjP9OHTkIprzI7 = 0;
                    this.ik13O8j78hPb27XeipAJHUcJmdHxYMJFw4gYbTGvLKIOs7SX1F7x61gocQ17TlNc = "";
                }
            } else if ("android.intent.action.NEW_OUTGOING_CALL".equals(action)) {
                this.gmm7XQFeiJoCy8yWhIBdyNlesqTvuP4UyGLNuJ8TYBJTJ249gDjP9OHTkIprzI7 = b.hYIBeJsINiSNmMMYMsE9k7k9FKwSRXABLbxSyf9mDVDqNrjjNU51ZRtstLVyAr2s;
                this.ik13O8j78hPb27XeipAJHUcJmdHxYMJFw4gYbTGvLKIOs7SX1F7x61gocQ17TlNc = intent2.getStringExtra("android.intent.extra.PHONE_NUMBER");
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.PhoneCallStartedAbstract(StartedStatus.Outgoing, this.ik13O8j78hPb27XeipAJHUcJmdHxYMJFw4gYbTGvLKIOs7SX1F7x61gocQ17TlNc);
            }
        }
    }

    public void onDestroy() {
        if (this.hlRRzlkTvaLJKT7xudtgqrNpSapzuwbeZZHKJdIwcwGUTFYejftgk4y9qZgGh2f0) {
            this.context.unregisterReceiver(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
            this.hlRRzlkTvaLJKT7xudtgqrNpSapzuwbeZZHKJdIwcwGUTFYejftgk4y9qZgGh2f0 = false;
        }
    }
}
