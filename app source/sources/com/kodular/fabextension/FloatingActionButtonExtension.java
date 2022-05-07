package com.kodular.fabextension;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.microsoft.appcenter.crashes.utils.ErrorLogHelper;

public class FloatingActionButtonExtension {
    /* access modifiers changed from: private */
    public final String LOG_TAG = getClass().getSimpleName();
    private int animationDuration = ErrorLogHelper.MAX_PROPERTY_ITEM_LENGTH;
    private AppCompatActivity appCompatActivity;
    private int backgroundColor = Color.parseColor("#616161");
    private boolean callFabClickOnTextClick = false;
    private boolean callFabLongClickOnTextLongClick = false;
    public float cornerRadius = 8.0f;
    /* access modifiers changed from: private */
    public FloatingActionButton floatingActionButton;
    private boolean hideTextOnClick = true;
    private boolean hideTextOnLongClick = true;
    private boolean isTextVisible = false;
    private boolean showTextOnLeftSide = true;
    private String text;
    private int textColor = Color.parseColor("#ffffff");
    /* access modifiers changed from: private */
    public TextView textView;
    private boolean useAnimations = true;

    static /* synthetic */ TextView access$102(FloatingActionButtonExtension x0, TextView x1) {
        TextView textView2 = x1;
        TextView textView3 = textView2;
        x0.textView = textView3;
        return textView2;
    }

    static /* synthetic */ boolean access$302(FloatingActionButtonExtension x0, boolean x1) {
        boolean z = x1;
        boolean z2 = z;
        x0.isTextVisible = z2;
        return z;
    }

    public FloatingActionButtonExtension() {
    }

    public FloatingActionButtonExtension(FloatingActionButton floatingActionButton2) {
        setFloatingActionButton(floatingActionButton2);
    }

    public void setText(String str) {
        String text2 = str;
        this.text = text2;
        if (this.textView != null) {
            this.textView.setText(text2);
            calculateDistanceToFab();
        }
    }

    public String getText() {
        return this.text;
    }

    public void setTextColor(int i) {
        int textColor2 = i;
        this.textColor = textColor2;
        if (this.textView != null) {
            this.textView.setTextColor(textColor2);
        }
    }

    public int getTextColor() {
        return this.textColor;
    }

    public void setBackgroundColor(int i) {
        int backgroundColor2 = i;
        this.backgroundColor = backgroundColor2;
        if (this.textView != null && this.textView.getBackground() != null) {
            this.textView.getBackground().setColorFilter(backgroundColor2, PorterDuff.Mode.SRC);
        }
    }

    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    public void setFloatingActionButton(FloatingActionButton floatingActionButton2) {
        FloatingActionButton floatingActionButton3 = floatingActionButton2;
        this.floatingActionButton = floatingActionButton3;
        this.appCompatActivity = (AppCompatActivity) floatingActionButton3.getContext();
    }

    public FloatingActionButton getFloatingActionButton() {
        return this.floatingActionButton;
    }

    public void setHideTextOnClick(boolean hideTextOnClick2) {
        boolean z = hideTextOnClick2;
        this.hideTextOnClick = z;
    }

    public boolean isHideTextOnClick() {
        return this.hideTextOnClick;
    }

    public void setHideTextOnLongClick(boolean hideTextOnLongClick2) {
        boolean z = hideTextOnLongClick2;
        this.hideTextOnLongClick = z;
    }

    public boolean isHideTextOnLongClick() {
        return this.hideTextOnLongClick;
    }

    public void setCallFabClickOnTextClick(boolean callFabClickOnTextClick2) {
        boolean z = callFabClickOnTextClick2;
        this.callFabClickOnTextClick = z;
    }

    public boolean isCallFabClickOnTextClick() {
        return this.callFabClickOnTextClick;
    }

    public void setCallFabLongClickOnTextLongClick(boolean callFabLongClickOnTextLongClick2) {
        boolean z = callFabLongClickOnTextLongClick2;
        this.callFabLongClickOnTextLongClick = z;
    }

    public boolean isCallFabLongClickOnTextLongClick() {
        return this.callFabLongClickOnTextLongClick;
    }

    public void setShowTextOnLeftSide(boolean showTextOnLeftSide2) {
        this.showTextOnLeftSide = showTextOnLeftSide2;
        if (this.textView != null) {
            calculateDistanceToFab();
        }
    }

    public boolean isShowTextOnLeftSide() {
        return this.showTextOnLeftSide;
    }

    public boolean isTextVisible() {
        return this.isTextVisible;
    }

    public void showText(String text2, int textColor2, float cornerRadius2, int backgroundColor2, boolean showTextOnLeftSide2, boolean hideTextOnClick2, boolean hideTextOnLongClick2, boolean callFabClickOnTextClick2, boolean callFabLongClickOnTextLongClick2) {
        setText(text2);
        setTextColor(textColor2);
        this.cornerRadius = cornerRadius2;
        setBackgroundColor(backgroundColor2);
        setShowTextOnLeftSide(showTextOnLeftSide2);
        setHideTextOnClick(hideTextOnClick2);
        setHideTextOnLongClick(hideTextOnLongClick2);
        setCallFabClickOnTextClick(callFabClickOnTextClick2);
        setCallFabLongClickOnTextLongClick(callFabLongClickOnTextLongClick2);
        showText();
    }

    public void showText() {
        TextView textView2;
        ViewGroup.LayoutParams layoutParams;
        GradientDrawable gradientDrawable;
        View.OnClickListener onClickListener;
        View.OnLongClickListener onLongClickListener;
        Runnable runnable;
        Throwable th;
        if (this.floatingActionButton == null) {
            Throwable th2 = th;
            new IllegalArgumentException("Have you setup a floating action button?");
            throw th2;
        } else if (this.textView == null) {
            new TextView(this.appCompatActivity);
            this.textView = textView2;
            new LinearLayout.LayoutParams(-2, -2);
            ViewGroup.LayoutParams layoutParams2 = layoutParams;
            this.textView.setText(getText());
            this.textView.setTextColor(getTextColor());
            this.textView.setPadding(dpUnit(23), dpUnit(6), dpUnit(23), dpUnit(6));
            new GradientDrawable();
            GradientDrawable gradientDrawable2 = gradientDrawable;
            gradientDrawable2.setCornerRadius((float) dpUnit((double) this.cornerRadius));
            gradientDrawable2.setColor(getBackgroundColor());
            new View.OnClickListener(this) {
                final /* synthetic */ FloatingActionButtonExtension this$0;

                {
                    this.this$0 = this$0;
                }

                public void onClick(View view) {
                    View view2 = view;
                    if (this.this$0.isHideTextOnClick()) {
                        this.this$0.hideText();
                    }
                    if (this.this$0.isCallFabClickOnTextClick() && this.this$0.floatingActionButton != null) {
                        boolean performClick = this.this$0.floatingActionButton.performClick();
                    }
                }
            };
            this.textView.setOnClickListener(onClickListener);
            new View.OnLongClickListener(this) {
                final /* synthetic */ FloatingActionButtonExtension this$0;

                {
                    this.this$0 = this$0;
                }

                public boolean onLongClick(View view) {
                    View view2 = view;
                    if (this.this$0.isHideTextOnLongClick()) {
                        this.this$0.hideText();
                    }
                    if (this.this$0.isCallFabLongClickOnTextLongClick() && this.this$0.floatingActionButton != null) {
                        boolean performLongClick = this.this$0.floatingActionButton.performLongClick();
                    }
                    return this.this$0.isHideTextOnLongClick();
                }
            };
            this.textView.setOnLongClickListener(onLongClickListener);
            this.textView.setBackground(gradientDrawable2);
            if (Build.VERSION.SDK_INT >= 21) {
                this.textView.setElevation((float) dpUnit(2));
            }
            this.appCompatActivity.addContentView(this.textView, layoutParams2);
            calculateDistanceToFab();
            new Runnable(this) {
                final /* synthetic */ FloatingActionButtonExtension this$0;

                {
                    this.this$0 = this$0;
                }

                public void run() {
                    Runnable runnable;
                    new Runnable(this) {
                        final /* synthetic */ AnonymousClass3 this$1;

                        {
                            this.this$1 = this$1;
                        }

                        public void run() {
                            this.this$1.this$0.textView.setY((float) (((double) (this.this$1.this$0.floatingActionButton.getY() + ((float) (((double) this.this$1.this$0.floatingActionButton.getHeight()) * 0.5d)))) - (((double) ((float) this.this$1.this$0.textView.getHeight())) * 0.5d)));
                        }
                    };
                    boolean post = this.this$0.floatingActionButton.post(runnable);
                }
            };
            boolean post = this.textView.post(runnable);
            this.isTextVisible = true;
            if (this.useAnimations) {
                startShowAnimation();
            }
        }
    }

    private void calculateDistanceToFab() {
        Runnable runnable;
        if (this.textView != null && this.floatingActionButton != null) {
            new Runnable(this) {
                final /* synthetic */ FloatingActionButtonExtension this$0;

                {
                    this.this$0 = this$0;
                }

                public void run() {
                    Runnable runnable;
                    new Runnable(this) {
                        final /* synthetic */ AnonymousClass4 this$1;

                        {
                            this.this$1 = this$1;
                        }

                        public void run() {
                            if (this.this$1.this$0.isShowTextOnLeftSide()) {
                                this.this$1.this$0.textView.setX((this.this$1.this$0.floatingActionButton.getX() - ((float) this.this$1.this$0.textView.getWidth())) - ((float) this.this$1.this$0.dpUnit(16)));
                            } else {
                                this.this$1.this$0.textView.setX(this.this$1.this$0.floatingActionButton.getX() + ((float) this.this$1.this$0.floatingActionButton.getWidth()) + ((float) this.this$1.this$0.dpUnit(16)));
                            }
                        }
                    };
                    boolean post = this.this$0.floatingActionButton.post(runnable);
                }
            };
            boolean post = this.textView.post(runnable);
        }
    }

    public void hideText() {
        Handler handler;
        Runnable runnable;
        if (this.textView != null) {
            startHideAnimation();
            new Handler();
            new Runnable(this) {
                final /* synthetic */ FloatingActionButtonExtension this$0;

                {
                    this.this$0 = this$0;
                }

                public void run() {
                    StringBuilder sb;
                    try {
                        ViewGroup viewGroup = (ViewGroup) this.this$0.textView.getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(this.this$0.textView);
                        }
                        boolean access$302 = FloatingActionButtonExtension.access$302(this.this$0, false);
                        TextView access$102 = FloatingActionButtonExtension.access$102(this.this$0, (TextView) null);
                    } catch (Exception e) {
                        Exception e2 = e;
                        String access$400 = this.this$0.LOG_TAG;
                        new StringBuilder();
                        int e3 = Log.e(access$400, sb.append("").append(e2).toString());
                    }
                }
            };
            boolean postDelayed = handler.postDelayed(runnable, (long) this.animationDuration);
        }
    }

    public void invalidateOnOrientationChange() {
        StringBuilder sb;
        if (this.textView != null) {
            try {
                ViewGroup parent = (ViewGroup) this.textView.getParent();
                if (parent != null) {
                    parent.removeView(this.textView);
                }
                if (this.textView != null) {
                    this.textView = null;
                    this.isTextVisible = false;
                    this.useAnimations = true;
                    showText();
                }
            } catch (Exception e) {
                Exception e2 = e;
                String str = this.LOG_TAG;
                new StringBuilder();
                int e3 = Log.e(str, sb.append("").append(e2).toString());
            }
        }
    }

    private void startShowAnimation() {
        if (this.textView != null) {
            this.textView.setVisibility(0);
            this.textView.setAlpha(0.0f);
            ViewPropertyAnimator duration = this.textView.animate().alpha(1.0f).setDuration((long) this.animationDuration);
        }
    }

    private void startHideAnimation() {
        if (this.textView != null) {
            this.textView.setAlpha(1.0f);
            ViewPropertyAnimator duration = this.textView.animate().alpha(0.0f).setDuration((long) this.animationDuration);
        }
    }

    /* access modifiers changed from: private */
    public int dpUnit(int dp) {
        return (int) TypedValue.applyDimension(1, (float) dp, this.appCompatActivity.getResources().getDisplayMetrics());
    }

    private int dpUnit(double dp) {
        return (int) TypedValue.applyDimension(1, (float) dp, this.appCompatActivity.getResources().getDisplayMetrics());
    }
}
