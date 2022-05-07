package com.google.android.material.animation;

import android.util.Property;
import android.view.ViewGroup;
import com.google.android.material.R;

public class ChildrenAlphaProperty extends Property<ViewGroup, Float> {
    public static final Property<ViewGroup, Float> CHILDREN_ALPHA;

    static {
        Property<ViewGroup, Float> property;
        new ChildrenAlphaProperty("childrenAlpha");
        CHILDREN_ALPHA = property;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ChildrenAlphaProperty(String name) {
        super(Float.class, name);
    }

    public Float get(ViewGroup object) {
        Float alpha = (Float) object.getTag(R.id.mtrl_internal_children_alpha_tag);
        if (alpha != null) {
            return alpha;
        }
        return Float.valueOf(1.0f);
    }

    public void set(ViewGroup viewGroup, Float value) {
        ViewGroup object = viewGroup;
        float alpha = value.floatValue();
        object.setTag(R.id.mtrl_internal_children_alpha_tag, Float.valueOf(alpha));
        int count = object.getChildCount();
        for (int i = 0; i < count; i++) {
            object.getChildAt(i).setAlpha(alpha);
        }
    }
}
