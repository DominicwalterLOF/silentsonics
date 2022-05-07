package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.FileProvider;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.util.AnimationUtil;
import com.google.appinventor.components.runtime.util.ErrorMessages;
import com.google.appinventor.components.runtime.util.YailList;
import java.io.File;

@SimpleObject
@DesignerComponent(category = ComponentCategory.CONNECTIVITY, description = "A component that can launch an activity using the <code>StartActivity</code> method. \n<p>Activities that can be launched include:<ul> <li> Starting another App Inventor for Android app. \n To do so, first      find out the <em>class</em> of the other application by      downloading the source code and using a file explorer or unzip      utility to find a file named      \"youngandroidproject/project.properties\".  \n The first line of      the file will start with \"main=\" and be followed by the class      name; for example,      <code>main=com.gmail.Bitdiddle.Ben.HelloPurr.Screen1</code>.       (The first components indicate that it was created by      Ben.Bitdiddle@gmail.com.)  \n To make your      <code>ActivityStarter</code> launch this application, set the      following properties: <ul>\n      <li> <code>ActivityPackage</code> to the class name, dropping the           last component (for example,           <code>com.gmail.Bitdiddle.Ben.HelloPurr</code>)</li>\n      <li> <code>ActivityClass</code> to the entire class name (for           example,           <code>com.gmail.Bitdiddle.Ben.HelloPurr.Screen1</code>)</li>      </ul></li> \n<li> Starting the camera application by setting the following      properties:<ul> \n     <li> <code>Action: android.intent.action.MAIN</code> </li> \n     <li> <code>ActivityPackage: com.android.camera</code> </li> \n     <li> <code>ActivityClass: com.android.camera.Camera</code></li>\n      </ul></li>\n<li> Performing web search.  Assuming the term you want to search      for is \"vampire\" (feel free to substitute your own choice), \n     set the properties to:\n<ul><code>     <li>Action: android.intent.action.WEB_SEARCH</li>      <li>ExtraKey: query</li>      <li>ExtraValue: vampire</li>      <li>ActivityPackage: com.google.android.providers.enhancedgooglesearch</li>     <li>ActivityClass: com.google.android.providers.enhancedgooglesearch.Launcher</li>      </code></ul></li> \n<li> Opening a browser to a specified web page.  Assuming the page you      want to go to is \"www.facebook.com\" (feel free to substitute      your own choice), set the properties to:\n<ul><code>      <li>Action: android.intent.action.VIEW</li>      <li>DataUri: http://www.facebook.com</li> </code> </ul> </li> </ul></p>", designerHelpDescription = "A component that can launch an activity using the <code>StartActivity</code> method.<p>Activities that can be launched include: <ul> \n<li> starting other App Inventor for Android apps </li> \n<li> starting the camera application </li> \n<li> performing web search </li> \n<li> opening a browser to a specified web page</li> \n<li> opening the map application to a specified location</li></ul> \nYou can also launch activities that return text data.  See the documentation on using the Activity Starter for examples.</p>", iconName = "images/activityStarter.png", nonVisible = true, version = 6)
public class ActivityStarter extends AndroidNonvisibleComponent implements ActivityResultListener, Component, Deleteable {
    private String Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB;
    private String KbzcIEn6WDqjdY1QBot1TMrBwhEYy4xAUKG2cbzQ22VNohlOtuBGKUJsEeMNZyEH = "";
    private final ComponentContainer container;
    private String hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO;
    private Intent hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private YailList f40hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    private String l557Ll1q9gLt3cEfyQaLTgWgvIutpQIPuKKLXX2glk42j33zjQ1xoBSDeCkOGk6j;
    private String mBLKdPlRolYfdtud5Z8giGWyhURWoCw9yHsOv08fUnIBAM4MuKAWkHVD8nEhBmIT;
    private String qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE;
    private int requestCode;
    private String sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt;
    private String vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq;
    private String vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ActivityStarter(com.google.appinventor.components.runtime.ComponentContainer r7) {
        /*
            r6 = this;
            r0 = r6
            r1 = r7
            r2 = r0
            r3 = r1
            com.google.appinventor.components.runtime.Form r3 = r3.$form()
            r2.<init>(r3)
            r2 = r0
            r3 = r1
            r2.container = r3
            r2 = r0
            java.lang.String r3 = ""
            r2.KbzcIEn6WDqjdY1QBot1TMrBwhEYy4xAUKG2cbzQ22VNohlOtuBGKUJsEeMNZyEH = r3
            r2 = r0
            java.lang.String r3 = "android.intent.action.MAIN"
            r2.Action(r3)
            r2 = r0
            java.lang.String r3 = ""
            r2.ActivityPackage(r3)
            r2 = r0
            java.lang.String r3 = ""
            r2.ActivityClass(r3)
            r2 = r0
            java.lang.String r3 = ""
            r2.DataUri(r3)
            r2 = r0
            java.lang.String r3 = ""
            r2.DataType(r3)
            r2 = r0
            java.lang.String r3 = ""
            r2.ExtraKey(r3)
            r2 = r0
            java.lang.String r3 = ""
            r2.ExtraValue(r3)
            r2 = r0
            com.google.appinventor.components.runtime.util.YailList r3 = new com.google.appinventor.components.runtime.util.YailList
            r5 = r3
            r3 = r5
            r4 = r5
            r4.<init>()
            r2.Extras(r3)
            r2 = r0
            java.lang.String r3 = ""
            r2.ResultName(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.ActivityStarter.<init>(com.google.appinventor.components.runtime.ComponentContainer):void");
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public String Action() {
        return this.vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq;
    }

    @DesignerProperty(defaultValue = "", editorType = "string")
    @SimpleProperty
    public void Action(String str) {
        String trim = str.trim();
        this.vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq = trim;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Returns the extra key that will be passed to the activity.\nDEPRECATED: New code should use Extras property instead.")
    public String ExtraKey() {
        return this.sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt;
    }

    @DesignerProperty(defaultValue = "", editorType = "string")
    @SimpleProperty
    public void ExtraKey(String str) {
        String trim = str.trim();
        this.sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt = trim;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Returns the extra value that will be passed to the activity.\nDEPRECATED: New code should use Extras property instead.")
    public String ExtraValue() {
        return this.mBLKdPlRolYfdtud5Z8giGWyhURWoCw9yHsOv08fUnIBAM4MuKAWkHVD8nEhBmIT;
    }

    @DesignerProperty(defaultValue = "", editorType = "string")
    @SimpleProperty
    public void ExtraValue(String str) {
        String trim = str.trim();
        this.mBLKdPlRolYfdtud5Z8giGWyhURWoCw9yHsOv08fUnIBAM4MuKAWkHVD8nEhBmIT = trim;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public String ResultName() {
        return this.l557Ll1q9gLt3cEfyQaLTgWgvIutpQIPuKKLXX2glk42j33zjQ1xoBSDeCkOGk6j;
    }

    @DesignerProperty(defaultValue = "", editorType = "string")
    @SimpleProperty
    public void ResultName(String str) {
        String trim = str.trim();
        this.l557Ll1q9gLt3cEfyQaLTgWgvIutpQIPuKKLXX2glk42j33zjQ1xoBSDeCkOGk6j = trim;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public String Result() {
        return this.KbzcIEn6WDqjdY1QBot1TMrBwhEYy4xAUKG2cbzQ22VNohlOtuBGKUJsEeMNZyEH;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public String DataUri() {
        return this.hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO;
    }

    @DesignerProperty(defaultValue = "", editorType = "string")
    @SimpleProperty
    public void DataUri(String str) {
        String trim = str.trim();
        this.hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO = trim;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public String DataType() {
        return this.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R;
    }

    @DesignerProperty(defaultValue = "", editorType = "string")
    @SimpleProperty
    public void DataType(String str) {
        String trim = str.trim();
        this.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R = trim;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public String ActivityPackage() {
        return this.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE;
    }

    @DesignerProperty(defaultValue = "", editorType = "string")
    @SimpleProperty
    public void ActivityPackage(String str) {
        String trim = str.trim();
        this.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE = trim;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public String ActivityClass() {
        return this.Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB;
    }

    @DesignerProperty(defaultValue = "", editorType = "string")
    @SimpleProperty
    public void ActivityClass(String str) {
        String trim = str.trim();
        this.Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB = trim;
    }

    @SimpleEvent(description = "Event raised after this ActivityStarter returns.")
    public void AfterActivity(String str) {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "AfterActivity", str);
    }

    @SimpleEvent(description = "Event raised if this ActivityStarter returns because the activity was canceled.")
    public void ActivityCanceled() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "ActivityCanceled", new Object[0]);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public String ResultType() {
        if (this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME != null) {
            String type = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getType();
            String str = type;
            if (type != null) {
                return str;
            }
        }
        return "";
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public String ResultUri() {
        if (this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME != null) {
            String dataString = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getDataString();
            String str = dataString;
            if (dataString != null) {
                return str;
            }
        }
        return "";
    }

    @SimpleProperty
    public void Extras(YailList yailList) {
        Throwable th;
        YailList yailList2 = yailList;
        Object[] array = yailList2.toArray();
        Object[] objArr = array;
        int length = array.length;
        for (int i = 0; i < length; i++) {
            Object obj = objArr[i];
            Object obj2 = obj;
            boolean z = obj instanceof YailList;
            boolean z2 = z;
            boolean z3 = z ? ((YailList) obj2).size() == 2 : false;
            if (!z2 || !z3) {
                Throwable th2 = th;
                new YailRuntimeError("Argument to Extras should be a list of pairs", "ActivityStarter Error");
                throw th2;
            }
        }
        this.f40hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = yailList2;
    }

    @SimpleProperty
    public YailList Extras() {
        return this.f40hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    }

    @SimpleFunction(description = "Returns the name of the activity that corresponds to this ActivityStarter, or an empty string if no corresponding activity can be found.")
    public String ResolveActivity() {
        ResolveInfo resolveActivity = this.container.$context().getPackageManager().resolveActivity(hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(), 0);
        ResolveInfo resolveInfo = resolveActivity;
        if (resolveActivity == null || resolveInfo.activityInfo == null) {
            return "";
        }
        return resolveInfo.activityInfo.name;
    }

    @SimpleFunction(description = "Start the activity corresponding to this ActivityStarter.")
    public void StartActivity() {
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = null;
        this.KbzcIEn6WDqjdY1QBot1TMrBwhEYy4xAUKG2cbzQ22VNohlOtuBGKUJsEeMNZyEH = "";
        Intent hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2 = hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME();
        if (this.requestCode == 0) {
            this.requestCode = this.form.registerForActivityResult(this);
        }
        if (hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2 == null) {
            this.form.dispatchErrorOccurredEvent(this, "StartActivity", ErrorMessages.ERROR_ACTIVITY_STARTER_NO_ACTION_INFO, new Object[0]);
            return;
        }
        try {
            this.container.$context().startActivityForResult(hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2, this.requestCode);
            AnimationUtil.ApplyOpenScreenAnimation(this.container.$context(), this.container.$form().OpenScreenAnimation());
        } catch (ActivityNotFoundException e) {
            this.form.dispatchErrorOccurredEvent(this, "StartActivity", ErrorMessages.ERROR_ACTIVITY_STARTER_NO_CORRESPONDING_ACTIVITY, new Object[0]);
        }
    }

    private Intent hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME() {
        Intent intent;
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        ComponentName componentName;
        File file;
        StringBuilder sb5;
        Intent intent2;
        Uri parse = this.hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO.length() != 0 ? Uri.parse(this.hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO) : null;
        new Intent(this.vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq);
        Intent intent3 = intent;
        if (parse != null && this.hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO.toLowerCase().startsWith("file://")) {
            int d = Log.d("ActivityStarter", "Usng file://");
            new File(parse.getPath());
            File file2 = file;
            File file3 = file2;
            if (file2.isFile()) {
                int d2 = Log.d("ActivityStarter", "It's a file");
                Activity $context = this.form.$context();
                new StringBuilder();
                parse = FileProvider.getUriForFile($context, sb5.append(this.form.$context().getPackageName()).append(".provider").toString(), file3);
                new Intent(this.vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq);
                Intent intent4 = intent2;
                intent3 = intent4;
                Intent flags = intent4.setFlags(1);
                int d3 = Log.d("ActivityStarter", "added permissions");
            }
        }
        if (TextUtils.isEmpty(Action())) {
            return null;
        }
        if (this.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R.length() == 0) {
            Intent data = intent3.setData(parse);
        } else if (parse != null) {
            Intent dataAndType = intent3.setDataAndType(parse, this.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R);
        } else {
            Intent type = intent3.setType(this.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R);
        }
        if (this.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE.length() != 0 || this.Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB.length() != 0) {
            new ComponentName(this.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE, this.Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB);
            Intent component = intent3.setComponent(componentName);
        } else if (Action().equals("android.intent.action.MAIN")) {
            return null;
        }
        if (!(this.sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt.length() == 0 || this.mBLKdPlRolYfdtud5Z8giGWyhURWoCw9yHsOv08fUnIBAM4MuKAWkHVD8nEhBmIT.length() == 0)) {
            new StringBuilder("Adding extra, key = ");
            int i = Log.i("ActivityStarter", sb4.append(this.sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt).append(" value = ").append(this.mBLKdPlRolYfdtud5Z8giGWyhURWoCw9yHsOv08fUnIBAM4MuKAWkHVD8nEhBmIT).toString());
            Intent putExtra = intent3.putExtra(this.sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt, this.mBLKdPlRolYfdtud5Z8giGWyhURWoCw9yHsOv08fUnIBAM4MuKAWkHVD8nEhBmIT);
        }
        Object[] array = this.f40hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.toArray();
        Object[] objArr = array;
        int length = array.length;
        for (int i2 = 0; i2 < length; i2++) {
            YailList yailList = (YailList) objArr[i2];
            YailList yailList2 = yailList;
            String string = yailList.getString(0);
            Object object = yailList2.getObject(1);
            new StringBuilder("Adding extra, key = ");
            int i3 = Log.i("ActivityStarter", sb.append(string).append(" value = ").append(object).toString());
            if (string.length() != 0) {
                if (object instanceof YailList) {
                    new StringBuilder("Adding extra list, key = ");
                    int i4 = Log.i("ActivityStarter", sb3.append(string).append(" value = ").append(object).toString());
                    Intent putExtra2 = intent3.putExtra(string, ((YailList) object).toStringArray());
                } else {
                    String string2 = yailList2.getString(1);
                    new StringBuilder("Adding extra string, key = ");
                    int i5 = Log.i("ActivityStarter", sb2.append(string).append(" value = ").append(string2).toString());
                    Intent putExtra3 = intent3.putExtra(string, string2);
                }
            }
        }
        return intent3;
    }

    public void resultReturned(int i, int i2, Intent intent) {
        int i3 = i2;
        Intent intent2 = intent;
        if (i == this.requestCode) {
            int i4 = Log.i("ActivityStarter", "resultReturned - resultCode = ".concat(String.valueOf(i3)));
            if (i3 == -1) {
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = intent2;
                if (this.l557Ll1q9gLt3cEfyQaLTgWgvIutpQIPuKKLXX2glk42j33zjQ1xoBSDeCkOGk6j.length() == 0 || this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME == null || !this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.hasExtra(this.l557Ll1q9gLt3cEfyQaLTgWgvIutpQIPuKKLXX2glk42j33zjQ1xoBSDeCkOGk6j)) {
                    this.KbzcIEn6WDqjdY1QBot1TMrBwhEYy4xAUKG2cbzQ22VNohlOtuBGKUJsEeMNZyEH = "";
                } else {
                    this.KbzcIEn6WDqjdY1QBot1TMrBwhEYy4xAUKG2cbzQ22VNohlOtuBGKUJsEeMNZyEH = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getStringExtra(this.l557Ll1q9gLt3cEfyQaLTgWgvIutpQIPuKKLXX2glk42j33zjQ1xoBSDeCkOGk6j);
                }
                AfterActivity(this.KbzcIEn6WDqjdY1QBot1TMrBwhEYy4xAUKG2cbzQ22VNohlOtuBGKUJsEeMNZyEH);
            } else if (i3 == 0) {
                ActivityCanceled();
            }
        }
    }

    @SimpleEvent(description = "The ActivityError event is no longer used. Please use the Screen.ErrorOccurred event instead.", userVisible = false)
    public void ActivityError(String str) {
    }

    public void onDelete() {
        this.form.unregisterForActivityResult(this);
    }
}
