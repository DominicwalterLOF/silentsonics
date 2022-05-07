package com.google.appinventor.components.runtime.util;

import androidx.core.view.GravityCompat;
import com.google.appinventor.components.common.HorizontalAlignment;
import com.google.appinventor.components.common.VerticalAlignment;
import com.google.appinventor.components.runtime.LinearLayout;

public class AlignmentUtil {
    private LinearLayout viewLayout;

    public AlignmentUtil(LinearLayout linearLayout) {
        this.viewLayout = linearLayout;
    }

    public void setHorizontalAlignment(int i) throws IllegalArgumentException {
        Throwable th;
        int i2 = i;
        switch (i2) {
            case 1:
                this.viewLayout.setHorizontalGravity(GravityCompat.START);
                return;
            case 2:
                this.viewLayout.setHorizontalGravity(GravityCompat.END);
                return;
            case 3:
                this.viewLayout.setHorizontalGravity(1);
                return;
            default:
                Throwable th2 = th;
                new IllegalArgumentException("Bad value to setHorizontalAlignment: ".concat(String.valueOf(i2)));
                throw th2;
        }
    }

    public void setHorizontalAlignment(HorizontalAlignment horizontalAlignment) {
        Throwable th;
        HorizontalAlignment horizontalAlignment2 = horizontalAlignment;
        switch (horizontalAlignment2) {
            case Left:
                this.viewLayout.setHorizontalGravity(3);
                return;
            case Center:
                this.viewLayout.setHorizontalGravity(1);
                return;
            case Right:
                this.viewLayout.setHorizontalGravity(5);
                return;
            default:
                Throwable th2 = th;
                new IllegalArgumentException("Bad value to setHorizontalAlignment: ".concat(String.valueOf(horizontalAlignment2)));
                throw th2;
        }
    }

    public void setVerticalAlignment(int i) throws IllegalArgumentException {
        Throwable th;
        int i2 = i;
        switch (i2) {
            case 1:
                this.viewLayout.setVerticalGravity(48);
                return;
            case 2:
                this.viewLayout.setVerticalGravity(16);
                return;
            case 3:
                this.viewLayout.setVerticalGravity(80);
                return;
            default:
                Throwable th2 = th;
                new IllegalArgumentException("Bad value to setVerticalAlignment: ".concat(String.valueOf(i2)));
                throw th2;
        }
    }

    public void setVerticalAlignment(VerticalAlignment verticalAlignment) {
        Throwable th;
        VerticalAlignment verticalAlignment2 = verticalAlignment;
        switch (verticalAlignment2) {
            case Top:
                this.viewLayout.setVerticalGravity(48);
                return;
            case Center:
                this.viewLayout.setVerticalGravity(16);
                return;
            case Bottom:
                this.viewLayout.setVerticalGravity(80);
                return;
            default:
                Throwable th2 = th;
                new IllegalArgumentException("Bad value to setVerticalAlignment: ".concat(String.valueOf(verticalAlignment2)));
                throw th2;
        }
    }
}
