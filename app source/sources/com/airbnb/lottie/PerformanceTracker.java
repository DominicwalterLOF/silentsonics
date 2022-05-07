package com.airbnb.lottie;

import android.util.Log;
import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import com.airbnb.lottie.utils.MeanCalculator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PerformanceTracker {
    private boolean enabled = false;
    private final Comparator<Pair<String, Float>> floatComparator;
    private final Set<FrameListener> frameListeners;
    private final Map<String, MeanCalculator> layerRenderTimes;

    public interface FrameListener {
        void onFrameRendered(float f);
    }

    public PerformanceTracker() {
        Set<FrameListener> set;
        Map<String, MeanCalculator> map;
        Comparator<Pair<String, Float>> comparator;
        new ArraySet();
        this.frameListeners = set;
        new HashMap();
        this.layerRenderTimes = map;
        new Comparator<Pair<String, Float>>(this) {
            final /* synthetic */ PerformanceTracker this$0;

            {
                this.this$0 = this$0;
            }

            public int compare(Pair<String, Float> o1, Pair<String, Float> o2) {
                float r1 = ((Float) o1.second).floatValue();
                float r2 = ((Float) o2.second).floatValue();
                if (r2 > r1) {
                    return 1;
                }
                if (r1 > r2) {
                    return -1;
                }
                return 0;
            }
        };
        this.floatComparator = comparator;
    }

    /* access modifiers changed from: package-private */
    public void setEnabled(boolean enabled2) {
        boolean z = enabled2;
        this.enabled = z;
    }

    public void recordRenderTime(String str, float f) {
        MeanCalculator meanCalculator;
        String layerName = str;
        float millis = f;
        if (this.enabled) {
            MeanCalculator meanCalculator2 = this.layerRenderTimes.get(layerName);
            if (meanCalculator2 == null) {
                new MeanCalculator();
                meanCalculator2 = meanCalculator;
                MeanCalculator put = this.layerRenderTimes.put(layerName, meanCalculator2);
            }
            meanCalculator2.add(millis);
            if (layerName.equals("__container")) {
                for (FrameListener listener : this.frameListeners) {
                    listener.onFrameRendered(millis);
                }
            }
        }
    }

    public void addFrameListener(FrameListener frameListener) {
        boolean add = this.frameListeners.add(frameListener);
    }

    public void removeFrameListener(FrameListener frameListener) {
        boolean add = this.frameListeners.add(frameListener);
    }

    public void clearRenderTimes() {
        this.layerRenderTimes.clear();
    }

    public void logRenderTimes() {
        if (this.enabled) {
            List<Pair<String, Float>> sortedRenderTimes = getSortedRenderTimes();
            int d = Log.d(L.TAG, "Render times:");
            for (int i = 0; i < sortedRenderTimes.size(); i++) {
                Pair<String, Float> layer = sortedRenderTimes.get(i);
                Object[] objArr = new Object[2];
                objArr[0] = layer.first;
                Object[] objArr2 = objArr;
                objArr2[1] = layer.second;
                int d2 = Log.d(L.TAG, String.format("\t\t%30s:%.2f", objArr2));
            }
        }
    }

    public List<Pair<String, Float>> getSortedRenderTimes() {
        List<Pair<String, Float>> list;
        Object obj;
        if (!this.enabled) {
            return Collections.emptyList();
        }
        new ArrayList(this.layerRenderTimes.size());
        List<Pair<String, Float>> sortedRenderTimes = list;
        for (Map.Entry<String, MeanCalculator> e : this.layerRenderTimes.entrySet()) {
            new Pair(e.getKey(), Float.valueOf(e.getValue().getMean()));
            boolean add = sortedRenderTimes.add(obj);
        }
        Collections.sort(sortedRenderTimes, this.floatComparator);
        return sortedRenderTimes;
    }
}
