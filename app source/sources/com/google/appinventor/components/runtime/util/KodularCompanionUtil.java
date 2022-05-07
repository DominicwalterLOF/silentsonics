package com.google.appinventor.components.runtime.util;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

public class KodularCompanionUtil {
    private static String LOG_TAG = "KodularCompanionUtil";

    private KodularCompanionUtil() {
    }

    public static void drawerLayoutFix(DrawerLayout drawerLayout, boolean z, boolean z2) {
        StringBuilder sb;
        DrawerLayout drawerLayout2 = drawerLayout;
        boolean z3 = z2;
        if (z && z3) {
            try {
                drawerLayout2.removeViewAt(1);
            } catch (Exception e) {
                Exception exc = e;
                String str = LOG_TAG;
                new StringBuilder("Trying to remove drawerLayout for makeroid companion failed. Reason: ");
                int e2 = Log.e(str, sb.append(exc.getMessage()).toString());
            }
        }
    }

    public static void statusBarColor(Activity activity, boolean z, int i) {
        StringBuilder sb;
        Activity activity2 = activity;
        int i2 = i;
        if (z) {
            try {
                int i3 = Log.i(LOG_TAG, "Trying to re-add statusbar color.");
                KodularHelper.setStatusBarColor(activity2, i2);
            } catch (Exception e) {
                Exception exc = e;
                String str = LOG_TAG;
                new StringBuilder("Trying to re-add statusbar color failed. Reason: ");
                int e2 = Log.e(str, sb.append(exc.getMessage()).toString());
            }
        }
    }

    public static void toolbarColor(Toolbar toolbar, boolean z, int i) {
        StringBuilder sb;
        Drawable drawable;
        Toolbar toolbar2 = toolbar;
        int i2 = i;
        if (z) {
            try {
                int i3 = Log.i(LOG_TAG, "Trying to re-add titlebar color.");
                new ColorDrawable(i2);
                toolbar2.setBackground(drawable);
            } catch (Exception e) {
                Exception exc = e;
                String str = LOG_TAG;
                new StringBuilder("Trying to re-add titlebar color failed. Reason: ");
                int e2 = Log.e(str, sb.append(exc.getMessage()).toString());
            }
        }
    }
}
