package com.airbnb.lottie.animation;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.os.LocaleList;
import androidx.annotation.NonNull;

public class LPaint extends Paint {
    public LPaint() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LPaint(int flags) {
        super(flags);
    }

    public LPaint(PorterDuff.Mode porterDuffMode) {
        Xfermode xfermode;
        new PorterDuffXfermode(porterDuffMode);
        Xfermode xfermode2 = setXfermode(xfermode);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LPaint(int flags, PorterDuff.Mode porterDuffMode) {
        super(flags);
        Xfermode xfermode;
        new PorterDuffXfermode(porterDuffMode);
        Xfermode xfermode2 = setXfermode(xfermode);
    }

    public void setTextLocales(@NonNull LocaleList locales) {
    }
}
