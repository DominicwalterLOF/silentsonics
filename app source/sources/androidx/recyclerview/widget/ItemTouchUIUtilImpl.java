package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.os.Build;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R;

class ItemTouchUIUtilImpl implements ItemTouchUIUtil {
    static final ItemTouchUIUtil INSTANCE;

    ItemTouchUIUtilImpl() {
    }

    static {
        ItemTouchUIUtil itemTouchUIUtil;
        new ItemTouchUIUtilImpl();
        INSTANCE = itemTouchUIUtil;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
        Canvas canvas2 = canvas;
        RecyclerView recyclerView2 = recyclerView;
        View view2 = view;
        float dX = f;
        float dY = f2;
        int i2 = i;
        boolean isCurrentlyActive = z;
        if (Build.VERSION.SDK_INT >= 21 && isCurrentlyActive && view2.getTag(R.id.item_touch_helper_previous_elevation) == null) {
            Object originalElevation = Float.valueOf(ViewCompat.getElevation(view2));
            ViewCompat.setElevation(view2, 1.0f + findMaxElevation(recyclerView2, view2));
            view2.setTag(R.id.item_touch_helper_previous_elevation, originalElevation);
        }
        view2.setTranslationX(dX);
        view2.setTranslationY(dY);
    }

    private static float findMaxElevation(RecyclerView recyclerView, View view) {
        RecyclerView recyclerView2 = recyclerView;
        View itemView = view;
        int childCount = recyclerView2.getChildCount();
        float max = 0.0f;
        for (int i = 0; i < childCount; i++) {
            View child = recyclerView2.getChildAt(i);
            if (child != itemView) {
                float elevation = ViewCompat.getElevation(child);
                if (elevation > max) {
                    max = elevation;
                }
            }
        }
        return max;
    }

    public void onDrawOver(Canvas c, RecyclerView recyclerView, View view, float dX, float dY, int actionState, boolean isCurrentlyActive) {
    }

    public void clearView(View view) {
        View view2 = view;
        if (Build.VERSION.SDK_INT >= 21) {
            Object tag = view2.getTag(R.id.item_touch_helper_previous_elevation);
            if (tag != null && (tag instanceof Float)) {
                ViewCompat.setElevation(view2, ((Float) tag).floatValue());
            }
            view2.setTag(R.id.item_touch_helper_previous_elevation, (Object) null);
        }
        view2.setTranslationX(0.0f);
        view2.setTranslationY(0.0f);
    }

    public void onSelected(View view) {
    }
}
