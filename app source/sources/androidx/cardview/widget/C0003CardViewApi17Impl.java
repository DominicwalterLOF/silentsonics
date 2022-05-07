package androidx.cardview.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.C0009RoundRectDrawableWithShadow;

@RequiresApi(17)
/* renamed from: androidx.cardview.widget.CardViewApi17Impl */
class C0003CardViewApi17Impl extends C0005CardViewBaseImpl {
    C0003CardViewApi17Impl() {
    }

    public void initStatic() {
        C0009RoundRectDrawableWithShadow.RoundRectHelper roundRectHelper;
        new C0009RoundRectDrawableWithShadow.RoundRectHelper(this) {
            final /* synthetic */ C0003CardViewApi17Impl this$0;

            {
                this.this$0 = this$0;
            }

            public void drawRoundRect(Canvas canvas, RectF bounds, float f, Paint paint) {
                float cornerRadius = f;
                canvas.drawRoundRect(bounds, cornerRadius, cornerRadius, paint);
            }
        };
        C0009RoundRectDrawableWithShadow.sRoundRectHelper = roundRectHelper;
    }
}
