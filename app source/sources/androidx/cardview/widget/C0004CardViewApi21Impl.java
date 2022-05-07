package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
/* renamed from: androidx.cardview.widget.CardViewApi21Impl */
class C0004CardViewApi21Impl implements C0007CardViewImpl {
    C0004CardViewApi21Impl() {
    }

    public void initialize(C0006CardViewDelegate cardViewDelegate, Context context, ColorStateList backgroundColor, float radius, float elevation, float maxElevation) {
        Drawable drawable;
        C0006CardViewDelegate cardView = cardViewDelegate;
        Context context2 = context;
        new C0008RoundRectDrawable(backgroundColor, radius);
        cardView.setCardBackground(drawable);
        View view = cardView.getCardView();
        view.setClipToOutline(true);
        view.setElevation(elevation);
        setMaxElevation(cardView, maxElevation);
    }

    public void setRadius(C0006CardViewDelegate cardView, float radius) {
        getCardBackground(cardView).setRadius(radius);
    }

    public void initStatic() {
    }

    public void setMaxElevation(C0006CardViewDelegate cardViewDelegate, float maxElevation) {
        C0006CardViewDelegate cardView = cardViewDelegate;
        getCardBackground(cardView).setPadding(maxElevation, cardView.getUseCompatPadding(), cardView.getPreventCornerOverlap());
        updatePadding(cardView);
    }

    public float getMaxElevation(C0006CardViewDelegate cardView) {
        return getCardBackground(cardView).getPadding();
    }

    public float getMinWidth(C0006CardViewDelegate cardView) {
        return getRadius(cardView) * 2.0f;
    }

    public float getMinHeight(C0006CardViewDelegate cardView) {
        return getRadius(cardView) * 2.0f;
    }

    public float getRadius(C0006CardViewDelegate cardView) {
        return getCardBackground(cardView).getRadius();
    }

    public void setElevation(C0006CardViewDelegate cardView, float elevation) {
        cardView.getCardView().setElevation(elevation);
    }

    public float getElevation(C0006CardViewDelegate cardView) {
        return cardView.getCardView().getElevation();
    }

    public void updatePadding(C0006CardViewDelegate cardViewDelegate) {
        C0006CardViewDelegate cardView = cardViewDelegate;
        if (!cardView.getUseCompatPadding()) {
            cardView.setShadowPadding(0, 0, 0, 0);
            return;
        }
        float elevation = getMaxElevation(cardView);
        float radius = getRadius(cardView);
        int hPadding = (int) Math.ceil((double) C0009RoundRectDrawableWithShadow.calculateHorizontalPadding(elevation, radius, cardView.getPreventCornerOverlap()));
        int vPadding = (int) Math.ceil((double) C0009RoundRectDrawableWithShadow.calculateVerticalPadding(elevation, radius, cardView.getPreventCornerOverlap()));
        cardView.setShadowPadding(hPadding, vPadding, hPadding, vPadding);
    }

    public void onCompatPaddingChanged(C0006CardViewDelegate cardViewDelegate) {
        C0006CardViewDelegate cardView = cardViewDelegate;
        setMaxElevation(cardView, getMaxElevation(cardView));
    }

    public void onPreventCornerOverlapChanged(C0006CardViewDelegate cardViewDelegate) {
        C0006CardViewDelegate cardView = cardViewDelegate;
        setMaxElevation(cardView, getMaxElevation(cardView));
    }

    public void setBackgroundColor(C0006CardViewDelegate cardView, @Nullable ColorStateList color) {
        getCardBackground(cardView).setColor(color);
    }

    public ColorStateList getBackgroundColor(C0006CardViewDelegate cardView) {
        return getCardBackground(cardView).getColor();
    }

    private C0008RoundRectDrawable getCardBackground(C0006CardViewDelegate cardView) {
        return (C0008RoundRectDrawable) cardView.getCardBackground();
    }
}
