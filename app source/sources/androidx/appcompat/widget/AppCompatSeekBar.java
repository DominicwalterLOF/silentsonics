package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R;

public class AppCompatSeekBar extends SeekBar {
    private final AppCompatSeekBarHelper mAppCompatSeekBarHelper;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AppCompatSeekBar(Context context) {
        this(context, (AttributeSet) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AppCompatSeekBar(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.seekBarStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppCompatSeekBar(android.content.Context r10, android.util.AttributeSet r11, int r12) {
        /*
            r9 = this;
            r0 = r9
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r0
            r5 = r1
            r6 = r2
            r7 = r3
            r4.<init>(r5, r6, r7)
            r4 = r0
            androidx.appcompat.widget.AppCompatSeekBarHelper r5 = new androidx.appcompat.widget.AppCompatSeekBarHelper
            r8 = r5
            r5 = r8
            r6 = r8
            r7 = r0
            r6.<init>(r7)
            r4.mAppCompatSeekBarHelper = r5
            r4 = r0
            androidx.appcompat.widget.AppCompatSeekBarHelper r4 = r4.mAppCompatSeekBarHelper
            r5 = r2
            r6 = r3
            r4.loadFromAttributes(r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSeekBar.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        synchronized (this) {
            super.onDraw(canvas2);
            this.mAppCompatSeekBarHelper.drawTickMarks(canvas2);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.mAppCompatSeekBarHelper.drawableStateChanged();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.mAppCompatSeekBarHelper.jumpDrawablesToCurrentState();
    }
}
