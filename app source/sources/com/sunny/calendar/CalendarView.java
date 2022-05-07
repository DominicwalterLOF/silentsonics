package com.sunny.calendar;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.CalendarView;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.HVArrangement;
import java.util.Calendar;

@SimpleObject(external = true)
@DesignerComponent(category = ComponentCategory.EXTENSION, description = "Simple calendar view extension<br>Developed by Sunny Gupta", iconName = "https://res.cloudinary.com/andromedaviewflyvipul/image/upload/c_scale,h_20,w_20/v1571472765/ktvu4bapylsvnykoyhdm.png", nonVisible = true, version = 1, versionName = "1.2")
@UsesPermissions(permissionNames = "android.permission.NFC")
public class CalendarView extends AndroidNonvisibleComponent {
    public Activity activity;
    public android.widget.CalendarView calendarView;
    public Context context = this.activity;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CalendarView(com.google.appinventor.components.runtime.ComponentContainer r8) {
        /*
            r7 = this;
            r0 = r7
            r1 = r8
            r2 = r0
            r3 = r1
            com.google.appinventor.components.runtime.Form r3 = r3.$form()
            r2.<init>(r3)
            r2 = r0
            r3 = r1
            android.app.Activity r3 = r3.$context()
            r2.activity = r3
            r2 = r0
            r3 = r0
            android.app.Activity r3 = r3.activity
            r2.context = r3
            r2 = r0
            android.widget.CalendarView r3 = new android.widget.CalendarView
            r6 = r3
            r3 = r6
            r4 = r6
            r5 = r0
            android.content.Context r5 = r5.context
            r4.<init>(r5)
            r2.calendarView = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sunny.calendar.CalendarView.<init>(com.google.appinventor.components.runtime.ComponentContainer):void");
    }

    @SimpleEvent
    public void DateChanged(long j) {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "DateChanged", Long.valueOf(j));
    }

    @SimpleFunction
    public void Initialize(HVArrangement hVArrangement) {
        CalendarView.OnDateChangeListener onDateChangeListener;
        new CalendarView.OnDateChangeListener(this) {
            final /* synthetic */ CalendarView this$0;

            {
                this.this$0 = r5;
            }

            public void onSelectedDayChange(android.widget.CalendarView calendarView, int i, int i2, int i3) {
                android.widget.CalendarView calendarView2 = calendarView;
                Calendar instance = Calendar.getInstance();
                instance.set(i, i2, i3);
                this.this$0.DateChanged(instance.getTimeInMillis());
            }
        };
        this.calendarView.setOnDateChangeListener(onDateChangeListener);
        ((ViewGroup) hVArrangement.getView()).addView(this.calendarView);
    }

    @SimpleFunction
    public void Remove() {
        android.widget.CalendarView calendarView2;
        ((ViewGroup) this.calendarView.getParent()).removeView(this.calendarView);
        new android.widget.CalendarView(this.context);
        this.calendarView = calendarView2;
    }

    @SimpleFunction
    public void SetDate(long j, boolean z, boolean z2) {
        this.calendarView.setDate(j, z, z2);
    }
}
