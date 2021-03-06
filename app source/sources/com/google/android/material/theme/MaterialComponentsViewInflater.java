package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatViewInflater;
import androidx.appcompat.widget.AppCompatButton;
import com.google.android.material.button.MaterialButton;

@Keep
public class MaterialComponentsViewInflater extends AppCompatViewInflater {
    public MaterialComponentsViewInflater() {
    }

    /* access modifiers changed from: protected */
    @NonNull
    public AppCompatButton createButton(Context context, AttributeSet attrs) {
        AppCompatButton appCompatButton;
        new MaterialButton(context, attrs);
        return appCompatButton;
    }
}
