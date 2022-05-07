package com.google.android.material.internal;

import android.graphics.Outline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class CircularBorderDrawableLollipop extends CircularBorderDrawable {
    public CircularBorderDrawableLollipop() {
    }

    public void getOutline(Outline outline) {
        copyBounds(this.rect);
        outline.setOval(this.rect);
    }
}
