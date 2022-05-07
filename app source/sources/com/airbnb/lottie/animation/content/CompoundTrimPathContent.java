package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class CompoundTrimPathContent {
    private List<TrimPathContent> contents;

    public CompoundTrimPathContent() {
        List<TrimPathContent> list;
        new ArrayList();
        this.contents = list;
    }

    /* access modifiers changed from: package-private */
    public void addTrimPath(TrimPathContent trimPath) {
        boolean add = this.contents.add(trimPath);
    }

    public void apply(Path path) {
        Path path2 = path;
        for (int i = this.contents.size() - 1; i >= 0; i--) {
            Utils.applyTrimPathIfNeeded(path2, this.contents.get(i));
        }
    }
}
