package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import androidx.annotation.Nullable;

/* renamed from: androidx.cardview.widget.CardViewImpl */
interface C0007CardViewImpl {
    ColorStateList getBackgroundColor(C0006CardViewDelegate cardViewDelegate);

    float getElevation(C0006CardViewDelegate cardViewDelegate);

    float getMaxElevation(C0006CardViewDelegate cardViewDelegate);

    float getMinHeight(C0006CardViewDelegate cardViewDelegate);

    float getMinWidth(C0006CardViewDelegate cardViewDelegate);

    float getRadius(C0006CardViewDelegate cardViewDelegate);

    void initStatic();

    void initialize(C0006CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f, float f2, float f3);

    void onCompatPaddingChanged(C0006CardViewDelegate cardViewDelegate);

    void onPreventCornerOverlapChanged(C0006CardViewDelegate cardViewDelegate);

    void setBackgroundColor(C0006CardViewDelegate cardViewDelegate, @Nullable ColorStateList colorStateList);

    void setElevation(C0006CardViewDelegate cardViewDelegate, float f);

    void setMaxElevation(C0006CardViewDelegate cardViewDelegate, float f);

    void setRadius(C0006CardViewDelegate cardViewDelegate, float f);

    void updatePadding(C0006CardViewDelegate cardViewDelegate);
}
