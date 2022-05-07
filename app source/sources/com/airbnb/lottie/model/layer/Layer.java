package com.airbnb.lottie.model.layer;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;
import java.util.Locale;

public class Layer {
    private final LottieComposition composition;
    private final boolean hidden;
    private final List<Keyframe<Float>> inOutKeyframes;
    private final long layerId;
    private final String layerName;
    private final LayerType layerType;
    private final List<Mask> masks;
    private final MatteType matteType;
    private final long parentId;
    private final int preCompHeight;
    private final int preCompWidth;
    @Nullable
    private final String refId;
    private final List<ContentModel> shapes;
    private final int solidColor;
    private final int solidHeight;
    private final int solidWidth;
    private final float startFrame;
    @Nullable
    private final AnimatableTextFrame text;
    @Nullable
    private final AnimatableTextProperties textProperties;
    @Nullable
    private final AnimatableFloatValue timeRemapping;
    private final float timeStretch;
    private final AnimatableTransform transform;

    public enum LayerType {
    }

    public enum MatteType {
    }

    public Layer(List<ContentModel> shapes2, LottieComposition composition2, String layerName2, long layerId2, LayerType layerType2, long parentId2, @Nullable String refId2, List<Mask> masks2, AnimatableTransform transform2, int solidWidth2, int solidHeight2, int solidColor2, float timeStretch2, float startFrame2, int preCompWidth2, int preCompHeight2, @Nullable AnimatableTextFrame text2, @Nullable AnimatableTextProperties textProperties2, List<Keyframe<Float>> inOutKeyframes2, MatteType matteType2, @Nullable AnimatableFloatValue timeRemapping2, boolean hidden2) {
        this.shapes = shapes2;
        this.composition = composition2;
        this.layerName = layerName2;
        this.layerId = layerId2;
        this.layerType = layerType2;
        this.parentId = parentId2;
        this.refId = refId2;
        this.masks = masks2;
        this.transform = transform2;
        this.solidWidth = solidWidth2;
        this.solidHeight = solidHeight2;
        this.solidColor = solidColor2;
        this.timeStretch = timeStretch2;
        this.startFrame = startFrame2;
        this.preCompWidth = preCompWidth2;
        this.preCompHeight = preCompHeight2;
        this.text = text2;
        this.textProperties = textProperties2;
        this.inOutKeyframes = inOutKeyframes2;
        this.matteType = matteType2;
        this.timeRemapping = timeRemapping2;
        this.hidden = hidden2;
    }

    /* access modifiers changed from: package-private */
    public LottieComposition getComposition() {
        return this.composition;
    }

    /* access modifiers changed from: package-private */
    public float getTimeStretch() {
        return this.timeStretch;
    }

    /* access modifiers changed from: package-private */
    public float getStartProgress() {
        return this.startFrame / this.composition.getDurationFrames();
    }

    /* access modifiers changed from: package-private */
    public List<Keyframe<Float>> getInOutKeyframes() {
        return this.inOutKeyframes;
    }

    public long getId() {
        return this.layerId;
    }

    /* access modifiers changed from: package-private */
    public String getName() {
        return this.layerName;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public String getRefId() {
        return this.refId;
    }

    /* access modifiers changed from: package-private */
    public int getPreCompWidth() {
        return this.preCompWidth;
    }

    /* access modifiers changed from: package-private */
    public int getPreCompHeight() {
        return this.preCompHeight;
    }

    /* access modifiers changed from: package-private */
    public List<Mask> getMasks() {
        return this.masks;
    }

    public LayerType getLayerType() {
        return this.layerType;
    }

    /* access modifiers changed from: package-private */
    public MatteType getMatteType() {
        return this.matteType;
    }

    /* access modifiers changed from: package-private */
    public long getParentId() {
        return this.parentId;
    }

    /* access modifiers changed from: package-private */
    public List<ContentModel> getShapes() {
        return this.shapes;
    }

    /* access modifiers changed from: package-private */
    public AnimatableTransform getTransform() {
        return this.transform;
    }

    /* access modifiers changed from: package-private */
    public int getSolidColor() {
        return this.solidColor;
    }

    /* access modifiers changed from: package-private */
    public int getSolidHeight() {
        return this.solidHeight;
    }

    /* access modifiers changed from: package-private */
    public int getSolidWidth() {
        return this.solidWidth;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public AnimatableTextFrame getText() {
        return this.text;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public AnimatableTextProperties getTextProperties() {
        return this.textProperties;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public AnimatableFloatValue getTimeRemapping() {
        return this.timeRemapping;
    }

    public String toString() {
        return toString("");
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public String toString(String str) {
        StringBuilder sb;
        String prefix = str;
        new StringBuilder();
        StringBuilder sb2 = sb;
        StringBuilder append = sb2.append(prefix).append(getName()).append("\n");
        Layer parent = this.composition.layerModelForId(getParentId());
        if (parent != null) {
            StringBuilder append2 = sb2.append("\t\tParents: ").append(parent.getName());
            Layer layerModelForId = this.composition.layerModelForId(parent.getParentId());
            while (true) {
                Layer parent2 = layerModelForId;
                if (parent2 == null) {
                    break;
                }
                StringBuilder append3 = sb2.append("->").append(parent2.getName());
                layerModelForId = this.composition.layerModelForId(parent2.getParentId());
            }
            StringBuilder append4 = sb2.append(prefix).append("\n");
        }
        if (!getMasks().isEmpty()) {
            StringBuilder append5 = sb2.append(prefix).append("\tMasks: ").append(getMasks().size()).append("\n");
        }
        if (!(getSolidWidth() == 0 || getSolidHeight() == 0)) {
            StringBuilder append6 = sb2.append(prefix).append("\tBackground: ");
            Locale locale = Locale.US;
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(getSolidWidth());
            Object[] objArr2 = objArr;
            objArr2[1] = Integer.valueOf(getSolidHeight());
            Object[] objArr3 = objArr2;
            objArr3[2] = Integer.valueOf(getSolidColor());
            StringBuilder append7 = append6.append(String.format(locale, "%dx%d %X\n", objArr3));
        }
        if (!this.shapes.isEmpty()) {
            StringBuilder append8 = sb2.append(prefix).append("\tShapes:\n");
            for (Object shape : this.shapes) {
                StringBuilder append9 = sb2.append(prefix).append("\t\t").append(shape).append("\n");
            }
        }
        return sb2.toString();
    }
}
