package androidx.transition;

import android.util.SparseArray;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;

class TransitionValuesMaps {
    final SparseArray<View> mIdValues;
    final LongSparseArray<View> mItemIdValues;
    final ArrayMap<String, View> mNameValues;
    final ArrayMap<View, TransitionValues> mViewValues;

    TransitionValuesMaps() {
        ArrayMap<View, TransitionValues> arrayMap;
        SparseArray<View> sparseArray;
        LongSparseArray<View> longSparseArray;
        ArrayMap<String, View> arrayMap2;
        new ArrayMap<>();
        this.mViewValues = arrayMap;
        new SparseArray<>();
        this.mIdValues = sparseArray;
        new LongSparseArray<>();
        this.mItemIdValues = longSparseArray;
        new ArrayMap<>();
        this.mNameValues = arrayMap2;
    }
}
