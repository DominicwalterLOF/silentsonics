package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import androidx.cardview.widget.C0009RoundRectDrawableWithShadow;

/* renamed from: androidx.cardview.widget.CardViewBaseImpl */
class C0005CardViewBaseImpl implements C0007CardViewImpl {
    final RectF mCornerRect;

    C0005CardViewBaseImpl() {
        RectF rectF;
        new RectF();
        this.mCornerRect = rectF;
    }

    public void initStatic() {
        C0009RoundRectDrawableWithShadow.RoundRectHelper roundRectHelper;
        new C0009RoundRectDrawableWithShadow.RoundRectHelper(this) {
            final /* synthetic */ C0005CardViewBaseImpl this$0;

            {
                this.this$0 = this$0;
            }

            public void drawRoundRect(Canvas canvas, RectF rectF, float f, Paint paint) {
                Canvas canvas2 = canvas;
                RectF bounds = rectF;
                float cornerRadius = f;
                Paint paint2 = paint;
                float twoRadius = cornerRadius * 2.0f;
                float innerWidth = (bounds.width() - twoRadius) - 1.0f;
                float innerHeight = (bounds.height() - twoRadius) - 1.0f;
                if (cornerRadius >= 1.0f) {
                    float roundedCornerRadius = cornerRadius + 0.5f;
                    this.this$0.mCornerRect.set(-roundedCornerRadius, -roundedCornerRadius, roundedCornerRadius, roundedCornerRadius);
                    int saved = canvas2.save();
                    canvas2.translate(bounds.left + roundedCornerRadius, bounds.top + roundedCornerRadius);
                    canvas2.drawArc(this.this$0.mCornerRect, 180.0f, 90.0f, true, paint2);
                    canvas2.translate(innerWidth, 0.0f);
                    canvas2.rotate(90.0f);
                    canvas2.drawArc(this.this$0.mCornerRect, 180.0f, 90.0f, true, paint2);
                    canvas2.translate(innerHeight, 0.0f);
                    canvas2.rotate(90.0f);
                    canvas2.drawArc(this.this$0.mCornerRect, 180.0f, 90.0f, true, paint2);
                    canvas2.translate(innerWidth, 0.0f);
                    canvas2.rotate(90.0f);
                    canvas2.drawArc(this.this$0.mCornerRect, 180.0f, 90.0f, true, paint2);
                    canvas2.restoreToCount(saved);
                    canvas2.drawRect((bounds.left + roundedCornerRadius) - 1.0f, bounds.top, (bounds.right - roundedCornerRadius) + 1.0f, bounds.top + roundedCornerRadius, paint2);
                    canvas2.drawRect((bounds.left + roundedCornerRadius) - 1.0f, bounds.bottom - roundedCornerRadius, (bounds.right - roundedCornerRadius) + 1.0f, bounds.bottom, paint2);
                }
                canvas2.drawRect(bounds.left, bounds.top + cornerRadius, bounds.right, bounds.bottom - cornerRadius, paint2);
            }
        };
        C0009RoundRectDrawableWithShadow.sRoundRectHelper = roundRectHelper;
    }

    public void initialize(C0006CardViewDelegate cardViewDelegate, Context context, ColorStateList backgroundColor, float radius, float elevation, float maxElevation) {
        C0006CardViewDelegate cardView = cardViewDelegate;
        C0009RoundRectDrawableWithShadow background = createBackground(context, backgroundColor, radius, elevation, maxElevation);
        background.setAddPaddingForCorners(cardView.getPreventCornerOverlap());
        cardView.setCardBackground(background);
        updatePadding(cardView);
    }

    private C0009RoundRectDrawableWithShadow createBackground(Context context, ColorStateList backgroundColor, float radius, float elevation, float maxElevation) {
        C0009RoundRectDrawableWithShadow roundRectDrawableWithShadow;
        new C0009RoundRectDrawableWithShadow(context.getResources(), backgroundColor, radius, elevation, maxElevation);
        return roundRectDrawableWithShadow;
    }

    public void updatePadding(C0006CardViewDelegate cardViewDelegate) {
        Rect rect;
        C0006CardViewDelegate cardView = cardViewDelegate;
        new Rect();
        Rect shadowPadding = rect;
        getShadowBackground(cardView).getMaxShadowAndCornerPadding(shadowPadding);
        cardView.setMinWidthHeightInternal((int) Math.ceil((double) getMinWidth(cardView)), (int) Math.ceil((double) getMinHeight(cardView)));
        cardView.setShadowPadding(shadowPadding.left, shadowPadding.top, shadowPadding.right, shadowPadding.bottom);
    }

    public void onCompatPaddingChanged(C0006CardViewDelegate cardView) {
    }

    public void onPreventCornerOverlapChanged(C0006CardViewDelegate cardViewDelegate) {
        C0006CardViewDelegate cardView = cardViewDelegate;
        getShadowBackground(cardView).setAddPaddingForCorners(cardView.getPreventCornerOverlap());
        updatePadding(cardView);
    }

    public void setBackgroundColor(C0006CardViewDelegate cardView, @Nullable ColorStateList color) {
        getShadowBackground(cardView).setColor(color);
    }

    public ColorStateList getBackgroundColor(C0006CardViewDelegate cardView) {
        return getShadowBackground(cardView).getColor();
    }

    public void setRadius(C0006CardViewDelegate cardViewDelegate, float radius) {
        C0006CardViewDelegate cardView = cardViewDelegate;
        getShadowBackground(cardView).setCornerRadius(radius);
        updatePadding(cardView);
    }

    public float getRadius(C0006CardViewDelegate cardView) {
        return getShadowBackground(cardView).getCornerRadius();
    }

    public void setElevation(C0006CardViewDelegate cardView, float elevation) {
        getShadowBackground(cardView).setShadowSize(elevation);
    }

    public float getElevation(C0006CardViewDelegate cardView) {
        return getShadowBackground(cardView).getShadowSize();
    }

    public void setMaxElevation(C0006CardViewDelegate cardViewDelegate, float maxElevation) {
        C0006CardViewDelegate cardView = cardViewDelegate;
        getShadowBackground(cardView).setMaxShadowSize(maxElevation);
        updatePadding(cardView);
    }

    public float getMaxElevation(C0006CardViewDelegate cardView) {
        return getShadowBackground(cardView).getMaxShadowSize();
    }

    public float getMinWidth(C0006CardViewDelegate cardView) {
        return getShadowBackground(cardView).getMinWidth();
    }

    public float getMinHeight(C0006CardViewDelegate cardView) {
        return getShadowBackground(cardView).getMinHeight();
    }

    private C0009RoundRectDrawableWithShadow getShadowBackground(C0006CardViewDelegate cardView) {
        return (C0009RoundRectDrawableWithShadow) cardView.getCardBackground();
    }
}
