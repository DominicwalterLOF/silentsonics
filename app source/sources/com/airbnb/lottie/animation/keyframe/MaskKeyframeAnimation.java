package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.ShapeData;
import java.util.ArrayList;
import java.util.List;

public class MaskKeyframeAnimation {
    private final List<BaseKeyframeAnimation<ShapeData, Path>> maskAnimations;
    private final List<Mask> masks;
    private final List<BaseKeyframeAnimation<Integer, Integer>> opacityAnimations;

    public MaskKeyframeAnimation(List<Mask> list) {
        List<BaseKeyframeAnimation<ShapeData, Path>> list2;
        List<BaseKeyframeAnimation<Integer, Integer>> list3;
        List<Mask> masks2 = list;
        this.masks = masks2;
        new ArrayList(masks2.size());
        this.maskAnimations = list2;
        new ArrayList(masks2.size());
        this.opacityAnimations = list3;
        for (int i = 0; i < masks2.size(); i++) {
            boolean add = this.maskAnimations.add(masks2.get(i).getMaskPath().createAnimation());
            boolean add2 = this.opacityAnimations.add(masks2.get(i).getOpacity().createAnimation());
        }
    }

    public List<Mask> getMasks() {
        return this.masks;
    }

    public List<BaseKeyframeAnimation<ShapeData, Path>> getMaskAnimations() {
        return this.maskAnimations;
    }

    public List<BaseKeyframeAnimation<Integer, Integer>> getOpacityAnimations() {
        return this.opacityAnimations;
    }
}
