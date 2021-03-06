package com.google.appinventor.components.runtime;

import androidx.core.internal.view.SupportMenu;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.runtime.util.MapFactory;

@SimpleObject
public abstract class MapFeatureBaseWithFill extends MapFeatureBase implements MapFactory.HasFill {
    private float G9FdWvm6zShqpzDC2UOqX6MiQExLolZTefPBjzVvfkE9Kp2rmQld5rkb2wriBYfL = 1.0f;
    private int YY8QFJ7NsKl2krKlLP4gKRTKnpLlHQvVopkx7p60xy1hzICdxizXFIQJXbKtydSp = Component.COLOR_RED;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MapFeatureBaseWithFill(MapFactory.MapFeatureContainer mapFeatureContainer, MapFactory.MapFeatureVisitor<Double> mapFeatureVisitor) {
        super(mapFeatureContainer, mapFeatureVisitor);
        FillColor(SupportMenu.CATEGORY_MASK);
        FillOpacity(1.0f);
    }

    @DesignerProperty(defaultValue = "&HFFF34336", editorType = "color")
    @SimpleProperty
    public void FillColor(int i) {
        this.YY8QFJ7NsKl2krKlLP4gKRTKnpLlHQvVopkx7p60xy1hzICdxizXFIQJXbKtydSp = i;
        this.map.getController().updateFeatureFill(this);
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "The paint color used to fill in the map feature.")
    public int FillColor() {
        return this.YY8QFJ7NsKl2krKlLP4gKRTKnpLlHQvVopkx7p60xy1hzICdxizXFIQJXbKtydSp;
    }

    @DesignerProperty(defaultValue = "1.0", editorType = "float")
    @SimpleProperty
    public void FillOpacity(float f) {
        float f2 = f;
        this.G9FdWvm6zShqpzDC2UOqX6MiQExLolZTefPBjzVvfkE9Kp2rmQld5rkb2wriBYfL = f2;
        this.YY8QFJ7NsKl2krKlLP4gKRTKnpLlHQvVopkx7p60xy1hzICdxizXFIQJXbKtydSp = (this.YY8QFJ7NsKl2krKlLP4gKRTKnpLlHQvVopkx7p60xy1hzICdxizXFIQJXbKtydSp & 16777215) | (Math.round(255.0f * f2) << 24);
        this.map.getController().updateFeatureFill(this);
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "The opacity of the interior of the map feature.")
    public float FillOpacity() {
        return this.G9FdWvm6zShqpzDC2UOqX6MiQExLolZTefPBjzVvfkE9Kp2rmQld5rkb2wriBYfL;
    }
}
