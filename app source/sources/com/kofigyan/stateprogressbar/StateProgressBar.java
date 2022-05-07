package com.kofigyan.stateprogressbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.core.content.ContextCompat;
import com.kofigyan.stateprogressbar.components.StateItem;
import com.kofigyan.stateprogressbar.components.StateItemDescription;
import com.kofigyan.stateprogressbar.components.StateItemNumber;
import com.kofigyan.stateprogressbar.listeners.OnStateErrorListener;
import com.kofigyan.stateprogressbar.listeners.OnStateItemClickListener;
import com.kofigyan.stateprogressbar.utils.FontManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class StateProgressBar extends View {
    private static final String ANIMATE_TO_CURRENT_PROGRESS_STATE_KEY = "mAnimateToCurrentProgressState";
    private static final String ANIM_DURATION_KEY = "mAnimDuration";
    private static final String ANIM_END_X_POS_KEY = "mAnimEndXPos";
    private static final String ANIM_START_DELAY_KEY = "mAnimStartDelay";
    private static final String ANIM_START_X_POS_KEY = "mAnimStartXPos";
    private static final String BACKGROUND_COLOR_KEY = "mBackgroundColor";
    private static final String CHECK_STATE_COMPLETED_KEY = "mCheckStateCompleted";
    private static final String CURRENT_STATE_DESC_COLOR_KEY = "mCurrentStateDescriptionColor";
    private static final String CURRENT_STATE_NUMBER_KEY = "mCurrentStateNumber";
    private static final float DEFAULT_STATE_SIZE = 25.0f;
    private static final float DEFAULT_TEXT_SIZE = 15.0f;
    private static final String DESCRIPTION_LINE_SPACING_KEY = "mDescriptionLinesSpacing";
    private static final String DESC_TOP_SPACE_DECREMENTER_KEY = "mDescTopSpaceDecrementer";
    private static final String DESC_TOP_SPACE_INCREMENTER_KEY = "mDescTopSpaceIncrementer";
    private static final String EMPTY_SPACE_DESCRIPTOR = "";
    private static final String ENABLE_ALL_STATES_COMPLETED_KEY = "mEnableAllStatesCompleted";
    private static final String END_CENTER_X_KEY = "mEndCenterX";
    private static final String FOREGROUND_COLOR_KEY = "mForegroundColor";
    private static final String INSTANCE_STATE = "saved_instance";
    private static final String IS_CURRENT_ANIM_STARTED_KEY = "mIsCurrentAnimStarted";
    private static final String IS_STATE_NUMBER_DESCENDING_KEY = "mIsStateNumberDescending";
    private static final String JUSTIFY_MULTILINE_DESC_KEY = "mJustifyMultilineDescription";
    private static final int MAX_STATE_NUMBER = 5;
    private static final String MAX_STATE_NUMBER_KEY = "mMaxStateNumber";
    private static final int MIN_STATE_NUMBER = 1;
    private static final String START_CENTER_X_KEY = "mStartCenterX";
    private static final String STATE_DESCRIPTION_LINE_SEPARATOR = "\n";
    private static final String STATE_DESCRIPTION_SIZE_KEY = "mStateDescriptionSize";
    private static final String STATE_DESC_COLOR_KEY = "mStateDescriptionColor";
    private static final String STATE_LINE_THICKNESS_KEY = "mStateLineThickness";
    private static final String STATE_NUMBER_BACKGROUND_COLOR_KEY = "mStateNumberBackgroundColor";
    private static final String STATE_NUMBER_FOREGROUND_COLOR_KEY = "mStateNumberForegroundColor";
    private static final String STATE_NUMBER_TEXT_SIZE_KEY = "mStateNumberTextSize";
    private static final String STATE_SIZE_KEY = "mStateSize";
    /* access modifiers changed from: private */
    public int mAnimDuration;
    /* access modifiers changed from: private */
    public float mAnimEndXPos;
    /* access modifiers changed from: private */
    public int mAnimStartDelay;
    private float mAnimStartXPos;
    private boolean mAnimateToCurrentProgressState;
    /* access modifiers changed from: private */
    public Animator mAnimator;
    private int mBackgroundColor;
    private Paint mBackgroundPaint;
    private float mCellHeight;
    private float mCellWidth;
    private Typeface mCheckFont;
    private boolean mCheckStateCompleted;
    private int mCurrentStateDescriptionColor;
    private Paint mCurrentStateDescriptionPaint;
    private int mCurrentStateNumber;
    private Typeface mCustomStateDescriptionTypeface;
    private Typeface mCustomStateNumberTypeface;
    private Typeface mDefaultTypefaceBold;
    private float mDescTopSpaceDecrementer;
    private float mDescTopSpaceIncrementer;
    private float mDescriptionLinesSpacing;
    private boolean mEnableAllStatesCompleted;
    /* access modifiers changed from: private */
    public float mEndCenterX;
    private int mForegroundColor;
    private Paint mForegroundPaint;
    private boolean mIsCurrentAnimStarted;
    private boolean mIsDescriptionMultiline;
    private boolean mIsStateNumberDescending;
    private boolean mJustifyMultilineDescription;
    private int mMaxDescriptionLine;
    private int mMaxStateNumber;
    private float mNextCellWidth;
    private OnStateErrorListener mOnStateErrorListener;
    private OnStateItemClickListener mOnStateItemClickListener;
    private float mSpacing;
    /* access modifiers changed from: private */
    public float mStartCenterX;
    private Paint mStateCheckedForegroundPaint;
    private int mStateDescriptionColor;
    private ArrayList<String> mStateDescriptionData;
    private Paint mStateDescriptionPaint;
    private float mStateDescriptionSize;
    private int mStateItemClickedNumber;
    private float mStateLineThickness;
    private int mStateNumberBackgroundColor;
    private Paint mStateNumberBackgroundPaint;
    private int mStateNumberForegroundColor;
    private Paint mStateNumberForegroundPaint;
    private float mStateNumberTextSize;
    private float mStateRadius;
    private float mStateSize;

    static /* synthetic */ Animator access$002(StateProgressBar x0, Animator x1) {
        Animator animator = x1;
        Animator animator2 = animator;
        x0.mAnimator = animator2;
        return animator;
    }

    static /* synthetic */ float access$402(StateProgressBar x0, float x1) {
        float f = x1;
        float f2 = f;
        x0.mAnimStartXPos = f2;
        return f;
    }

    static /* synthetic */ float access$502(StateProgressBar x0, float x1) {
        float f = x1;
        float f2 = f;
        x0.mAnimEndXPos = f2;
        return f;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StateProgressBar(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StateProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public StateProgressBar(android.content.Context r10, android.util.AttributeSet r11, int r12) {
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
            java.util.ArrayList r5 = new java.util.ArrayList
            r8 = r5
            r5 = r8
            r6 = r8
            r6.<init>()
            r4.mStateDescriptionData = r5
            r4 = r0
            r5 = r1
            r6 = r2
            r7 = r3
            r4.init(r5, r6, r7)
            r4 = r0
            r4.initializePainters()
            r4 = r0
            r5 = r0
            boolean r5 = r5.mEnableAllStatesCompleted
            r4.updateCheckAllStatesValues(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kofigyan.stateprogressbar.StateProgressBar.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        Context context2 = context;
        AttributeSet attrs = attributeSet;
        int defStyle = i;
        initStateProgressBar(context2);
        this.mStateDescriptionSize = convertSpToPixel(this.mStateDescriptionSize);
        this.mStateLineThickness = convertDpToPixel(this.mStateLineThickness);
        this.mSpacing = convertDpToPixel(this.mSpacing);
        this.mCheckFont = Typeface.create(Typeface.DEFAULT, 0);
        this.mDefaultTypefaceBold = Typeface.create(Typeface.DEFAULT, 1);
        if (attrs != null) {
            TypedArray a = context2.obtainStyledAttributes(attrs, R.styleable.StateProgressBar, defStyle, 0);
            this.mBackgroundColor = a.getColor(R.styleable.StateProgressBar_spb_stateBackgroundColor, this.mBackgroundColor);
            this.mForegroundColor = a.getColor(R.styleable.StateProgressBar_spb_stateForegroundColor, this.mForegroundColor);
            this.mStateNumberBackgroundColor = a.getColor(R.styleable.StateProgressBar_spb_stateNumberBackgroundColor, this.mStateNumberBackgroundColor);
            this.mStateNumberForegroundColor = a.getColor(R.styleable.StateProgressBar_spb_stateNumberForegroundColor, this.mStateNumberForegroundColor);
            this.mCurrentStateDescriptionColor = a.getColor(R.styleable.StateProgressBar_spb_currentStateDescriptionColor, this.mCurrentStateDescriptionColor);
            this.mStateDescriptionColor = a.getColor(R.styleable.StateProgressBar_spb_stateDescriptionColor, this.mStateDescriptionColor);
            this.mCurrentStateNumber = a.getInteger(R.styleable.StateProgressBar_spb_currentStateNumber, this.mCurrentStateNumber);
            this.mMaxStateNumber = a.getInteger(R.styleable.StateProgressBar_spb_maxStateNumber, this.mMaxStateNumber);
            this.mStateSize = a.getDimension(R.styleable.StateProgressBar_spb_stateSize, this.mStateSize);
            this.mStateNumberTextSize = a.getDimension(R.styleable.StateProgressBar_spb_stateTextSize, this.mStateNumberTextSize);
            this.mStateDescriptionSize = a.getDimension(R.styleable.StateProgressBar_spb_stateDescriptionSize, this.mStateDescriptionSize);
            this.mStateLineThickness = a.getDimension(R.styleable.StateProgressBar_spb_stateLineThickness, this.mStateLineThickness);
            this.mCheckStateCompleted = a.getBoolean(R.styleable.StateProgressBar_spb_checkStateCompleted, this.mCheckStateCompleted);
            this.mAnimateToCurrentProgressState = a.getBoolean(R.styleable.StateProgressBar_spb_animateToCurrentProgressState, this.mAnimateToCurrentProgressState);
            this.mEnableAllStatesCompleted = a.getBoolean(R.styleable.StateProgressBar_spb_enableAllStatesCompleted, this.mEnableAllStatesCompleted);
            this.mDescTopSpaceDecrementer = a.getDimension(R.styleable.StateProgressBar_spb_descriptionTopSpaceDecrementer, this.mDescTopSpaceDecrementer);
            this.mDescTopSpaceIncrementer = a.getDimension(R.styleable.StateProgressBar_spb_descriptionTopSpaceIncrementer, this.mDescTopSpaceIncrementer);
            this.mAnimDuration = a.getInteger(R.styleable.StateProgressBar_spb_animationDuration, this.mAnimDuration);
            this.mAnimStartDelay = a.getInteger(R.styleable.StateProgressBar_spb_animationStartDelay, this.mAnimStartDelay);
            this.mIsStateNumberDescending = a.getBoolean(R.styleable.StateProgressBar_spb_stateNumberIsDescending, this.mIsStateNumberDescending);
            this.mMaxDescriptionLine = a.getInteger(R.styleable.StateProgressBar_spb_maxDescriptionLines, this.mMaxDescriptionLine);
            this.mDescriptionLinesSpacing = a.getDimension(R.styleable.StateProgressBar_spb_descriptionLinesSpacing, this.mDescriptionLinesSpacing);
            this.mJustifyMultilineDescription = a.getBoolean(R.styleable.StateProgressBar_spb_justifyMultilineDescription, this.mJustifyMultilineDescription);
            if (!this.mAnimateToCurrentProgressState) {
                stopAnimation();
            }
            resolveStateSize();
            validateLineThickness(this.mStateLineThickness);
            validateStateNumber(this.mCurrentStateNumber);
            this.mStateRadius = this.mStateSize / 2.0f;
            a.recycle();
        }
    }

    private void initializePainters() {
        this.mBackgroundPaint = setPaintAttributes(this.mStateLineThickness, this.mBackgroundColor);
        this.mForegroundPaint = setPaintAttributes(this.mStateLineThickness, this.mForegroundColor);
        this.mStateNumberForegroundPaint = setPaintAttributes(this.mStateNumberTextSize, this.mStateNumberForegroundColor, this.mCustomStateNumberTypeface != null ? this.mCustomStateNumberTypeface : this.mDefaultTypefaceBold);
        this.mStateCheckedForegroundPaint = setPaintAttributes(this.mStateNumberTextSize, this.mStateNumberForegroundColor, this.mCheckFont);
        this.mStateNumberBackgroundPaint = setPaintAttributes(this.mStateNumberTextSize, this.mStateNumberBackgroundColor, this.mCustomStateNumberTypeface != null ? this.mCustomStateNumberTypeface : this.mDefaultTypefaceBold);
        this.mCurrentStateDescriptionPaint = setPaintAttributes(this.mStateDescriptionSize, this.mCurrentStateDescriptionColor, this.mCustomStateDescriptionTypeface != null ? this.mCustomStateDescriptionTypeface : this.mDefaultTypefaceBold);
        this.mStateDescriptionPaint = setPaintAttributes(this.mStateDescriptionSize, this.mStateDescriptionColor, this.mCustomStateDescriptionTypeface != null ? this.mCustomStateDescriptionTypeface : this.mDefaultTypefaceBold);
    }

    public Typeface getStateNumberTypeface() {
        return this.mCustomStateNumberTypeface;
    }

    public void setStateNumberTypeface(String pathToFont) {
        this.mCustomStateNumberTypeface = FontManager.getTypeface(getContext(), pathToFont);
        Typeface typeface = this.mStateNumberForegroundPaint.setTypeface(this.mCustomStateNumberTypeface != null ? this.mCustomStateNumberTypeface : this.mDefaultTypefaceBold);
        Typeface typeface2 = this.mStateNumberBackgroundPaint.setTypeface(this.mCustomStateNumberTypeface != null ? this.mCustomStateNumberTypeface : this.mDefaultTypefaceBold);
        invalidate();
    }

    public void setStateDescriptionTypeface(String pathToFont) {
        this.mCustomStateDescriptionTypeface = FontManager.getTypeface(getContext(), pathToFont);
        Typeface typeface = this.mStateDescriptionPaint.setTypeface(this.mCustomStateDescriptionTypeface != null ? this.mCustomStateDescriptionTypeface : this.mDefaultTypefaceBold);
        Typeface typeface2 = this.mCurrentStateDescriptionPaint.setTypeface(this.mCustomStateDescriptionTypeface != null ? this.mCustomStateDescriptionTypeface : this.mDefaultTypefaceBold);
        invalidate();
    }

    public Typeface getStateDescriptionTypeface(String str) {
        String str2 = str;
        return this.mCustomStateDescriptionTypeface;
    }

    private void validateLineThickness(float lineThickness) {
        float halvedStateSize = this.mStateSize / 2.0f;
        if (lineThickness > halvedStateSize) {
            this.mStateLineThickness = halvedStateSize;
        }
    }

    private void validateStateSize() {
        if (this.mStateSize <= this.mStateNumberTextSize) {
            this.mStateSize = this.mStateNumberTextSize + (this.mStateNumberTextSize / 2.0f);
        }
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.mBackgroundColor = backgroundColor;
        this.mBackgroundPaint.setColor(this.mBackgroundColor);
        invalidate();
    }

    public int getForegroundColor() {
        return this.mForegroundColor;
    }

    public void setForegroundColor(int foregroundColor) {
        this.mForegroundColor = foregroundColor;
        this.mForegroundPaint.setColor(this.mForegroundColor);
        invalidate();
    }

    private void resolveStateLineThickness() {
        validateLineThickness(this.mStateLineThickness);
        this.mBackgroundPaint.setStrokeWidth(this.mStateLineThickness);
        this.mForegroundPaint.setStrokeWidth(this.mStateLineThickness);
        invalidate();
    }

    public float getStateLineThickness() {
        return this.mStateLineThickness;
    }

    public void setStateLineThickness(float stateLineThickness) {
        this.mStateLineThickness = convertDpToPixel(stateLineThickness);
        resolveStateLineThickness();
    }

    public int getStateNumberBackgroundColor() {
        return this.mStateNumberBackgroundColor;
    }

    public void setStateNumberBackgroundColor(int stateNumberBackgroundColor) {
        this.mStateNumberBackgroundColor = stateNumberBackgroundColor;
        this.mStateNumberBackgroundPaint.setColor(this.mStateNumberBackgroundColor);
        invalidate();
    }

    public int getStateNumberForegroundColor() {
        return this.mStateNumberForegroundColor;
    }

    public void setStateNumberForegroundColor(int stateNumberForegroundColor) {
        this.mStateNumberForegroundColor = stateNumberForegroundColor;
        this.mStateNumberForegroundPaint.setColor(this.mStateNumberForegroundColor);
        this.mStateCheckedForegroundPaint.setColor(this.mStateNumberForegroundColor);
        invalidate();
    }

    public int getStateDescriptionColor() {
        return this.mStateDescriptionColor;
    }

    public void setStateDescriptionColor(int stateDescriptionColor) {
        this.mStateDescriptionColor = stateDescriptionColor;
        this.mStateDescriptionPaint.setColor(this.mStateDescriptionColor);
        invalidate();
    }

    public int getCurrentStateDescriptionColor() {
        return this.mCurrentStateDescriptionColor;
    }

    public void setCurrentStateDescriptionColor(int currentStateDescriptionColor) {
        this.mCurrentStateDescriptionColor = currentStateDescriptionColor;
        this.mCurrentStateDescriptionPaint.setColor(this.mCurrentStateDescriptionColor);
        invalidate();
    }

    public int getCurrentStateNumber() {
        return this.mCurrentStateNumber;
    }

    public void setCurrentStateNumber(StateNumber stateNumber) {
        StateNumber currentStateNumber = stateNumber;
        validateStateNumber(currentStateNumber.getValue());
        this.mCurrentStateNumber = currentStateNumber.getValue();
        updateCheckAllStatesValues(this.mEnableAllStatesCompleted);
        invalidate();
    }

    private void resolveMaxStateNumber() {
        validateStateNumber(this.mCurrentStateNumber);
        updateCheckAllStatesValues(this.mEnableAllStatesCompleted);
        invalidate();
    }

    public int getMaxStateNumber() {
        return this.mMaxStateNumber;
    }

    public void setMaxStateNumber(StateNumber maximumState) {
        this.mMaxStateNumber = maximumState.getValue();
        resolveMaxStateNumber();
    }

    public float getStateSize() {
        return this.mStateSize;
    }

    public void setStateSize(float stateSize) {
        this.mStateSize = convertDpToPixel(stateSize);
        resetStateSizeValues();
    }

    public void setOnStateItemClickListener(OnStateItemClickListener onStateItemClickListener) {
        OnStateItemClickListener onStateItemClickListener2 = onStateItemClickListener;
        this.mOnStateItemClickListener = onStateItemClickListener2;
    }

    public void setOnErrorListener(OnStateErrorListener onStateErrorListener) {
        OnStateErrorListener onStateErrorListener2 = onStateErrorListener;
        this.mOnStateErrorListener = onStateErrorListener2;
    }

    private void resetStateSizeValues() {
        resolveStateSize();
        this.mStateNumberForegroundPaint.setTextSize(this.mStateNumberTextSize);
        this.mStateNumberBackgroundPaint.setTextSize(this.mStateNumberTextSize);
        this.mStateCheckedForegroundPaint.setTextSize(this.mStateNumberTextSize);
        this.mStateRadius = this.mStateSize / 2.0f;
        validateLineThickness(this.mStateLineThickness);
        this.mBackgroundPaint.setStrokeWidth(this.mStateLineThickness);
        this.mForegroundPaint.setStrokeWidth(this.mStateLineThickness);
        requestLayout();
    }

    private void resolveStateDescriptionSize() {
        this.mCurrentStateDescriptionPaint.setTextSize(this.mStateDescriptionSize);
        this.mStateDescriptionPaint.setTextSize(this.mStateDescriptionSize);
        requestLayout();
    }

    public float getStateDescriptionSize() {
        return this.mStateDescriptionSize;
    }

    public void setStateDescriptionSize(float stateDescriptionSize) {
        this.mStateDescriptionSize = convertSpToPixel(stateDescriptionSize);
        resolveStateDescriptionSize();
    }

    public float getStateNumberTextSize() {
        return this.mStateNumberTextSize;
    }

    public void setStateNumberTextSize(float textSize) {
        this.mStateNumberTextSize = convertSpToPixel(textSize);
        resetStateSizeValues();
    }

    public void checkStateCompleted(boolean checkStateCompleted) {
        this.mCheckStateCompleted = checkStateCompleted;
        invalidate();
    }

    public void setAllStatesCompleted(boolean enableAllStatesCompleted) {
        this.mEnableAllStatesCompleted = enableAllStatesCompleted;
        updateCheckAllStatesValues(this.mEnableAllStatesCompleted);
        invalidate();
    }

    private void updateCheckAllStatesValues(boolean enableAllStatesCompleted) {
        if (enableAllStatesCompleted) {
            this.mCheckStateCompleted = true;
            this.mCurrentStateNumber = this.mMaxStateNumber;
            this.mStateDescriptionPaint.setColor(this.mCurrentStateDescriptionPaint.getColor());
            return;
        }
        this.mStateDescriptionPaint.setColor(this.mStateDescriptionPaint.getColor());
    }

    public void enableAnimationToCurrentState(boolean animateToCurrentProgressState) {
        this.mAnimateToCurrentProgressState = animateToCurrentProgressState;
        if (this.mAnimateToCurrentProgressState && this.mAnimator == null) {
            startAnimator();
        }
        invalidate();
    }

    private void validateStateNumber(int i) {
        StringBuilder sb;
        int stateNumber = i;
        if (stateNumber > this.mMaxStateNumber && this.mOnStateErrorListener != null) {
            new StringBuilder();
            this.mOnStateErrorListener.onStateError(this, sb.append("State number (").append(stateNumber).append(") cannot be greater than total number of states ").append(this.mMaxStateNumber).toString());
        }
    }

    public float getDescriptionTopSpaceDecrementer() {
        return this.mDescTopSpaceDecrementer;
    }

    public void setDescriptionTopSpaceDecrementer(float spaceDecrementer) {
        this.mDescTopSpaceDecrementer = spaceDecrementer;
        requestLayout();
    }

    public float getDescriptionTopSpaceIncrementer() {
        return this.mDescTopSpaceIncrementer;
    }

    public void setDescriptionTopSpaceIncrementer(float spaceIncrementer) {
        this.mDescTopSpaceIncrementer = spaceIncrementer;
        requestLayout();
    }

    public float getDescriptionLinesSpacing() {
        return this.mDescriptionLinesSpacing;
    }

    public void setDescriptionLinesSpacing(float descriptionLinesSpacing) {
        this.mDescriptionLinesSpacing = descriptionLinesSpacing;
        requestLayout();
    }

    public int getAnimationDuration() {
        return this.mAnimDuration;
    }

    public void setAnimationDuration(int animDuration) {
        this.mAnimDuration = animDuration;
        invalidate();
    }

    public int getAnimationStartDelay() {
        return this.mAnimStartDelay;
    }

    public void setAnimationStartDelay(int animStartDelay) {
        this.mAnimStartDelay = animStartDelay;
        invalidate();
    }

    public boolean getStateNumberIsDescending() {
        return this.mIsStateNumberDescending;
    }

    public void setStateNumberIsDescending(boolean stateNumberIsDescending) {
        this.mIsStateNumberDescending = stateNumberIsDescending;
        invalidate();
    }

    public boolean isDescriptionMultiline() {
        return this.mIsDescriptionMultiline;
    }

    private void updateDescriptionMultilineStatus(boolean multiline) {
        boolean z = multiline;
        this.mIsDescriptionMultiline = z;
    }

    public int getMaxDescriptionLine() {
        return this.mMaxDescriptionLine;
    }

    public void setMaxDescriptionLine(int maxDescriptionLine) {
        this.mMaxDescriptionLine = maxDescriptionLine;
        requestLayout();
    }

    public boolean isJustifyMultilineDescription() {
        return this.mJustifyMultilineDescription;
    }

    public void setJustifyMultilineDescription(boolean justifyMultilineDescription) {
        this.mJustifyMultilineDescription = justifyMultilineDescription;
        invalidate();
    }

    private Paint setPaintAttributes(float strokeWidth, int color) {
        Paint paint = setPaintAttributes(color);
        paint.setStrokeWidth(strokeWidth);
        return paint;
    }

    private Paint setPaintAttributes(float textSize, int color, Typeface typeface) {
        Paint paint = setPaintAttributes(color);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(textSize);
        Typeface typeface2 = paint.setTypeface(typeface);
        return paint;
    }

    private Paint setPaintAttributes(int color) {
        Paint paint;
        new Paint(1);
        Paint paint2 = paint;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(color);
        return paint2;
    }

    private void initStateProgressBar(Context context) {
        Context context2 = context;
        this.mBackgroundColor = ContextCompat.getColor(context2, R.color.background_color);
        this.mForegroundColor = ContextCompat.getColor(context2, R.color.foreground_color);
        this.mStateNumberBackgroundColor = ContextCompat.getColor(context2, R.color.background_text_color);
        this.mStateNumberForegroundColor = ContextCompat.getColor(context2, R.color.foreground_text_color);
        this.mCurrentStateDescriptionColor = ContextCompat.getColor(context2, R.color.foreground_color);
        this.mStateDescriptionColor = ContextCompat.getColor(context2, R.color.background_text_color);
        this.mStateSize = 0.0f;
        this.mStateLineThickness = 4.0f;
        this.mStateNumberTextSize = 0.0f;
        this.mStateDescriptionSize = DEFAULT_TEXT_SIZE;
        this.mMaxStateNumber = StateNumber.FIVE.getValue();
        this.mCurrentStateNumber = StateNumber.ONE.getValue();
        this.mSpacing = 4.0f;
        this.mDescTopSpaceDecrementer = 0.0f;
        this.mDescTopSpaceIncrementer = 0.0f;
        this.mDescriptionLinesSpacing = 0.0f;
        this.mCheckStateCompleted = false;
        this.mAnimateToCurrentProgressState = false;
        this.mEnableAllStatesCompleted = false;
        this.mAnimStartDelay = 100;
        this.mAnimDuration = 4000;
        this.mIsStateNumberDescending = false;
        this.mJustifyMultilineDescription = false;
    }

    private void resolveStateSize() {
        resolveStateSize(this.mStateSize != 0.0f, this.mStateNumberTextSize != 0.0f);
    }

    private void resolveStateSize(boolean z, boolean z2) {
        boolean isStateSizeSet = z;
        boolean isStateTextSizeSet = z2;
        if (!isStateSizeSet && !isStateTextSizeSet) {
            this.mStateSize = convertDpToPixel(DEFAULT_STATE_SIZE);
            this.mStateNumberTextSize = convertSpToPixel(DEFAULT_TEXT_SIZE);
        } else if (isStateSizeSet && isStateTextSizeSet) {
            validateStateSize();
        } else if (!isStateSizeSet) {
            this.mStateSize = this.mStateNumberTextSize + (this.mStateNumberTextSize / 2.0f);
        } else {
            this.mStateNumberTextSize = this.mStateSize - (this.mStateSize * 0.375f);
        }
    }

    private void drawCircles(Canvas canvas, Paint paint, int startIndex, int i) {
        Canvas canvas2 = canvas;
        Paint paint2 = paint;
        int endIndex = i;
        for (int i2 = startIndex; i2 < endIndex; i2++) {
            canvas2.drawCircle((this.mCellWidth * ((float) (i2 + 1))) - (this.mCellWidth / 2.0f), this.mCellHeight / 2.0f, this.mStateRadius, paint2);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent event = motionEvent;
        if (this.mOnStateItemClickListener == null) {
            return false;
        }
        if (event.getAction() != 0) {
            return false;
        }
        if (!isPointInCircle((int) event.getX(), (int) event.getY())) {
            return false;
        }
        boolean performClick = performClick();
        return true;
    }

    public boolean performClick() {
        boolean performClick = super.performClick();
        if (this.mOnStateItemClickListener == null) {
            return false;
        }
        this.mOnStateItemClickListener.onStateItemClick(this, getStateItem(this.mStateItemClickedNumber), this.mStateItemClickedNumber, getCurrentStateNumber() == this.mStateItemClickedNumber);
        return true;
    }

    private boolean isPointInCircle(int i, int i2) {
        int clickX = i;
        int clickY = i2;
        boolean isTouched = false;
        for (int i3 = 0; i3 < this.mMaxStateNumber; i3++) {
            isTouched = ((float) clickX) >= ((this.mCellWidth * ((float) (i3 + 1))) - (this.mCellWidth / 2.0f)) - this.mStateRadius && ((float) clickX) <= ((this.mCellWidth * ((float) (i3 + 1))) - (this.mCellWidth / 2.0f)) + this.mStateRadius && ((float) clickY) >= (this.mCellHeight / 2.0f) - this.mStateRadius && ((float) clickY) <= (this.mCellHeight / 2.0f) + this.mStateRadius;
            if (isTouched) {
                this.mStateItemClickedNumber = this.mIsStateNumberDescending ? this.mMaxStateNumber - i3 : i3 + 1;
                return isTouched;
            }
        }
        return isTouched;
    }

    private StateItem getStateItem(int i) {
        int i2;
        int i3;
        int stateItemClickedNumber = i;
        boolean isCurrentState = getCurrentStateNumber() == stateItemClickedNumber;
        boolean isForegroundColor = getCurrentStateNumber() >= stateItemClickedNumber;
        boolean isCompletedState = getCurrentStateNumber() > stateItemClickedNumber;
        float stateSize = getStateSize();
        int stateColor = isForegroundColor ? this.mForegroundColor : this.mBackgroundColor;
        boolean isCheckedState = false;
        StateItemDescription stateItemDescription = null;
        if (isCompletedState) {
            if (this.mCheckStateCompleted) {
                isCheckedState = true;
            }
        }
        int stateNumberColor = isForegroundColor ? this.mStateNumberForegroundColor : this.mStateNumberBackgroundColor;
        float stateNumberSize = getStateNumberTextSize();
        if (isCurrentState) {
            i2 = this.mCurrentStateDescriptionColor;
        } else {
            i2 = this.mStateDescriptionColor;
        }
        int stateDescriptionColor = i2;
        StateItemNumber stateItemNumber = ((StateItemNumber.Builder) ((StateItemNumber.Builder) StateItemNumber.builder().color(stateNumberColor)).size(stateNumberSize)).number(stateItemClickedNumber).build();
        if (!getStateDescriptionData().isEmpty() && stateItemClickedNumber <= getStateDescriptionData().size()) {
            StateItemDescription.Builder builder = (StateItemDescription.Builder) ((StateItemDescription.Builder) StateItemDescription.builder().color(stateDescriptionColor)).size(getStateDescriptionSize());
            List<String> stateDescriptionData = getStateDescriptionData();
            if (this.mIsStateNumberDescending) {
                i3 = getStateDescriptionData().size() >= this.mMaxStateNumber ? (stateItemClickedNumber - 1) + (getStateDescriptionData().size() - this.mMaxStateNumber) : stateItemClickedNumber - 1;
            } else {
                i3 = stateItemClickedNumber - 1;
            }
            stateItemDescription = builder.text(stateDescriptionData.get(i3)).build();
        }
        return ((StateItem.Builder) ((StateItem.Builder) StateItem.builder().color(stateColor)).size(stateSize)).stateItemNumber(stateItemNumber).isCurrentState(isCurrentState).isStateChecked(isCheckedState).stateItemDescription(stateItemDescription).build();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.mCellWidth = (float) (getWidth() / this.mMaxStateNumber);
        this.mNextCellWidth = this.mCellWidth;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        super.onDraw(canvas2);
        drawState(canvas2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int heightMeasureSpec) {
        int widthMeasureSpec = i;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int height = getDesiredHeight();
        setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), height);
        this.mCellHeight = (float) getCellHeight();
    }

    private int getDesiredHeight() {
        if (this.mStateDescriptionData.isEmpty()) {
            return ((int) (2.0f * this.mStateRadius)) + ((int) this.mSpacing);
        }
        if (checkForDescriptionMultiLine(this.mStateDescriptionData)) {
            return (((((int) (2.0f * this.mStateRadius)) + ((int) (((double) selectMaxDescriptionLine(this.mMaxDescriptionLine)) * (1.3d * ((double) this.mStateDescriptionSize))))) + ((int) this.mSpacing)) - ((int) this.mDescTopSpaceDecrementer)) + ((int) this.mDescTopSpaceIncrementer) + ((int) this.mDescriptionLinesSpacing);
        }
        return (((((int) (2.0f * this.mStateRadius)) + ((int) (1.3d * ((double) this.mStateDescriptionSize)))) + ((int) this.mSpacing)) - ((int) this.mDescTopSpaceDecrementer)) + ((int) this.mDescTopSpaceIncrementer);
    }

    private int getCellHeight() {
        return ((int) (2.0f * this.mStateRadius)) + ((int) this.mSpacing);
    }

    private boolean checkForDescriptionMultiLine(ArrayList<String> stateDescriptionData) {
        boolean isMultiLine = false;
        Iterator<String> it = stateDescriptionData.iterator();
        while (it.hasNext()) {
            isMultiLine = it.next().contains(STATE_DESCRIPTION_LINE_SEPARATOR);
            if (isMultiLine) {
                updateDescriptionMultilineStatus(isMultiLine);
                return isMultiLine;
            }
        }
        return isMultiLine;
    }

    private int getMaxDescriptionLine(List<String> stateDescriptionData) {
        int maxLine = 1;
        for (String stateDescription : stateDescriptionData) {
            int lineSize = stateDescription.split(STATE_DESCRIPTION_LINE_SEPARATOR).length;
            maxLine = lineSize > maxLine ? lineSize : maxLine;
        }
        this.mMaxDescriptionLine = maxLine;
        return maxLine;
    }

    private int selectMaxDescriptionLine(int i) {
        int maxLine = i;
        return maxLine > 1 ? maxLine : getMaxDescriptionLine(this.mStateDescriptionData);
    }

    private void drawState(Canvas canvas) {
        Canvas canvas2 = canvas;
        setAnimatorStartEndCenterX();
        drawCurrentStateJoiningLine(canvas2);
        drawBackgroundLines(canvas2);
        drawBackgroundCircles(canvas2);
        drawForegroundCircles(canvas2);
        drawForegroundLines(canvas2);
        drawStateNumberText(canvas2, this.mMaxStateNumber);
        drawStateDescriptionText(canvas2);
    }

    private void drawBackgroundCircles(Canvas canvas) {
        drawCircles(canvas, this.mBackgroundPaint, this.mIsStateNumberDescending ? 0 : this.mCurrentStateNumber, this.mIsStateNumberDescending ? this.mMaxStateNumber - this.mCurrentStateNumber : this.mMaxStateNumber);
    }

    private void drawForegroundCircles(Canvas canvas) {
        drawCircles(canvas, this.mForegroundPaint, this.mIsStateNumberDescending ? this.mMaxStateNumber - this.mCurrentStateNumber : 0, this.mIsStateNumberDescending ? this.mMaxStateNumber : this.mCurrentStateNumber);
    }

    private void drawBackgroundLines(Canvas canvas) {
        drawLines(canvas, this.mBackgroundPaint, this.mIsStateNumberDescending ? 0 : this.mCurrentStateNumber - 1, this.mIsStateNumberDescending ? (this.mMaxStateNumber - this.mCurrentStateNumber) + 1 : this.mMaxStateNumber);
    }

    private void drawForegroundLines(Canvas canvas) {
        drawLines(canvas, this.mForegroundPaint, this.mIsStateNumberDescending ? (this.mMaxStateNumber - this.mCurrentStateNumber) + 1 : 0, this.mIsStateNumberDescending ? this.mMaxStateNumber : this.mCurrentStateNumber - 1);
    }

    private void drawLines(Canvas canvas, Paint paint, int i, int i2) {
        Canvas canvas2 = canvas;
        Paint paint2 = paint;
        int startIndex = i;
        int endIndex = i2;
        if (endIndex > startIndex) {
            float startCenterX = (this.mCellWidth / 2.0f) + (this.mCellWidth * ((float) startIndex));
            float endCenterX = (this.mCellWidth * ((float) endIndex)) - (this.mCellWidth / 2.0f);
            canvas2.drawLine(startCenterX + (this.mStateRadius * 0.75f), this.mCellHeight / 2.0f, endCenterX - (this.mStateRadius * 0.75f), this.mCellHeight / 2.0f, paint2);
        }
    }

    private void setAnimatorStartEndCenterX() {
        if (this.mCurrentStateNumber <= 1 || this.mCurrentStateNumber >= 6) {
            resetStateAnimationData();
            return;
        }
        int count = this.mIsStateNumberDescending ? (this.mMaxStateNumber - this.mCurrentStateNumber) + 1 : this.mCurrentStateNumber - 1;
        for (int i = 0; i < count; i++) {
            if (i == 0) {
                this.mStartCenterX = this.mNextCellWidth - (this.mCellWidth / 2.0f);
            } else {
                this.mStartCenterX = this.mEndCenterX;
            }
            this.mNextCellWidth += this.mCellWidth;
            this.mEndCenterX = this.mNextCellWidth - (this.mCellWidth / 2.0f);
        }
    }

    private void drawCurrentStateJoiningLine(Canvas canvas) {
        Canvas canvas2 = canvas;
        if (!this.mAnimateToCurrentProgressState || this.mCurrentStateNumber <= 1) {
            drawLineToCurrentState(canvas2);
        } else {
            animateToCurrentState(canvas2);
        }
    }

    private void drawLineToCurrentState(Canvas canvas) {
        canvas.drawLine(this.mStartCenterX, this.mCellHeight / 2.0f, this.mEndCenterX, this.mCellHeight / 2.0f, this.mForegroundPaint);
        this.mNextCellWidth = this.mCellWidth;
        stopAnimation();
    }

    private void animateToCurrentState(Canvas canvas) {
        Canvas canvas2 = canvas;
        if (!this.mIsCurrentAnimStarted) {
            this.mAnimStartXPos = this.mStartCenterX;
            this.mAnimEndXPos = this.mAnimStartXPos;
            this.mIsCurrentAnimStarted = true;
        }
        if (this.mAnimEndXPos < this.mStartCenterX || this.mStartCenterX > this.mEndCenterX) {
            stopAnimation();
            enableAnimationToCurrentState(false);
            invalidate();
        } else if (this.mAnimEndXPos <= this.mEndCenterX) {
            if (!this.mIsStateNumberDescending) {
                canvas2.drawLine(this.mStartCenterX, this.mCellHeight / 2.0f, this.mAnimEndXPos, this.mCellHeight / 2.0f, this.mForegroundPaint);
                canvas2.drawLine(this.mAnimEndXPos, this.mCellHeight / 2.0f, this.mEndCenterX, this.mCellHeight / 2.0f, this.mBackgroundPaint);
            } else {
                canvas2.drawLine(this.mEndCenterX, this.mCellHeight / 2.0f, this.mEndCenterX - (this.mAnimEndXPos - this.mStartCenterX), this.mCellHeight / 2.0f, this.mForegroundPaint);
                canvas2.drawLine(this.mEndCenterX - (this.mAnimEndXPos - this.mStartCenterX), this.mCellHeight / 2.0f, this.mStartCenterX, this.mCellHeight / 2.0f, this.mBackgroundPaint);
            }
            this.mAnimStartXPos = this.mAnimEndXPos;
        } else if (!this.mIsStateNumberDescending) {
            canvas2.drawLine(this.mStartCenterX, this.mCellHeight / 2.0f, this.mEndCenterX, this.mCellHeight / 2.0f, this.mForegroundPaint);
        } else {
            canvas2.drawLine(this.mEndCenterX, this.mCellHeight / 2.0f, this.mStartCenterX, this.mCellHeight / 2.0f, this.mForegroundPaint);
        }
        this.mNextCellWidth = this.mCellWidth;
    }

    private void drawStateDescriptionText(Canvas canvas) {
        String str;
        String stateDescription;
        float f;
        float f2;
        Canvas canvas2 = canvas;
        if (!this.mStateDescriptionData.isEmpty()) {
            int i = 0;
            while (true) {
                if (i >= this.mStateDescriptionData.size()) {
                    break;
                }
                if (i < this.mMaxStateNumber) {
                    Paint innerPaintType = selectDescriptionPaint(this.mCurrentStateNumber, i);
                    int xPos = (int) (this.mNextCellWidth - (this.mCellWidth / 2.0f));
                    if (this.mIsDescriptionMultiline) {
                        if (this.mMaxDescriptionLine > 1) {
                            if (this.mIsStateNumberDescending) {
                                stateDescription = this.mStateDescriptionData.get((this.mStateDescriptionData.size() - 1) - i);
                            } else {
                                stateDescription = this.mStateDescriptionData.get(i);
                            }
                            int nextLineCounter = 0;
                            int newXPos = 0;
                            String[] stateDescriptionLines = stateDescription.split(STATE_DESCRIPTION_LINE_SEPARATOR);
                            String[] strArr = stateDescriptionLines;
                            int length = strArr.length;
                            for (int i2 = 0; i2 < length; i2++) {
                                String line = strArr[i2];
                                nextLineCounter++;
                                if (this.mJustifyMultilineDescription && nextLineCounter > 1) {
                                    newXPos = getNewXPosForDescriptionMultilineJustification(stateDescriptionLines[0], line, innerPaintType, xPos);
                                }
                                if (nextLineCounter <= this.mMaxDescriptionLine) {
                                    float f3 = (((this.mCellHeight + (((float) nextLineCounter) * this.mStateDescriptionSize)) - this.mSpacing) - this.mDescTopSpaceDecrementer) + this.mDescTopSpaceIncrementer;
                                    if (nextLineCounter > 1) {
                                        f = this.mDescriptionLinesSpacing * ((float) (nextLineCounter - 1));
                                    } else {
                                        f = 0.0f;
                                    }
                                    int yPos = (int) (f3 + f);
                                    Canvas canvas3 = canvas2;
                                    String str2 = line;
                                    if (newXPos == 0) {
                                        f2 = (float) xPos;
                                    } else {
                                        f2 = (float) newXPos;
                                    }
                                    canvas3.drawText(str2, f2, (float) yPos, innerPaintType);
                                }
                            }
                            this.mNextCellWidth += this.mCellWidth;
                        }
                    }
                    int yPos2 = (int) ((((this.mCellHeight + this.mStateDescriptionSize) - this.mSpacing) - this.mDescTopSpaceDecrementer) + this.mDescTopSpaceIncrementer);
                    Canvas canvas4 = canvas2;
                    if (this.mIsStateNumberDescending) {
                        str = this.mStateDescriptionData.get((this.mStateDescriptionData.size() - 1) - i);
                    } else {
                        str = this.mStateDescriptionData.get(i);
                    }
                    canvas4.drawText(str, (float) xPos, (float) yPos2, innerPaintType);
                    this.mNextCellWidth += this.mCellWidth;
                }
                i++;
            }
        }
        this.mNextCellWidth = this.mCellWidth;
    }

    private int getNewXPosForDescriptionMultilineJustification(String firstLine, String nextLine, Paint paint, int i) {
        float newXPos;
        Paint paint2 = paint;
        int xPos = i;
        float firstLineWidth = paint2.measureText(firstLine);
        float nextLineWidth = paint2.measureText(nextLine);
        if (firstLineWidth > nextLineWidth) {
            newXPos = ((float) xPos) - ((firstLineWidth - nextLineWidth) / 2.0f);
        } else if (firstLineWidth < nextLineWidth) {
            newXPos = ((float) xPos) + ((nextLineWidth - firstLineWidth) / 2.0f);
        } else {
            newXPos = (float) xPos;
        }
        return Math.round(newXPos);
    }

    private Paint selectDescriptionPaint(int i, int statePosition) {
        int currentState = i;
        if (statePosition + 1 == (this.mIsStateNumberDescending ? (this.mMaxStateNumber + 1) - currentState : currentState)) {
            return this.mCurrentStateDescriptionPaint;
        }
        return this.mStateDescriptionPaint;
    }

    private void resolveStateDescriptionDataSize(ArrayList<String> arrayList) {
        ArrayList<String> stateDescriptionData = arrayList;
        int stateDescriptionDataSize = stateDescriptionData.size();
        if (stateDescriptionDataSize < this.mMaxStateNumber) {
            for (int i = 0; i < this.mMaxStateNumber - stateDescriptionDataSize; i++) {
                stateDescriptionData.add(stateDescriptionDataSize + i, "");
            }
        }
    }

    public List<String> getStateDescriptionData() {
        return this.mStateDescriptionData;
    }

    public void setStateDescriptionData(String[] stateDescriptionData) {
        ArrayList<String> arrayList;
        new ArrayList<>(Arrays.asList(stateDescriptionData));
        this.mStateDescriptionData = arrayList;
        resolveStateDescriptionDataSize(this.mStateDescriptionData);
        requestLayout();
    }

    public void setStateDescriptionData(ArrayList<String> stateDescriptionData) {
        this.mStateDescriptionData = stateDescriptionData;
        resolveStateDescriptionDataSize(this.mStateDescriptionData);
        requestLayout();
    }

    private void resetStateAnimationData() {
        if (this.mStartCenterX > 0.0f || this.mStartCenterX < 0.0f) {
            this.mStartCenterX = 0.0f;
        }
        if (this.mEndCenterX > 0.0f || this.mEndCenterX < 0.0f) {
            this.mEndCenterX = 0.0f;
        }
        if (this.mAnimEndXPos > 0.0f || this.mAnimEndXPos < 0.0f) {
            this.mAnimEndXPos = 0.0f;
        }
        if (this.mIsCurrentAnimStarted) {
            this.mIsCurrentAnimStarted = false;
        }
    }

    private void drawStateNumberText(Canvas canvas, int i) {
        Canvas canvas2 = canvas;
        int noOfCircles = i;
        for (int i2 = 0; i2 < noOfCircles; i2++) {
            Paint innerPaintType = selectPaintType(this.mCurrentStateNumber, i2, this.mCheckStateCompleted);
            int xPos = (int) ((this.mCellWidth * ((float) (i2 + 1))) - (this.mCellWidth / 2.0f));
            int yPos = (int) ((this.mCellHeight / 2.0f) - ((innerPaintType.descent() + innerPaintType.ascent()) / 2.0f));
            boolean isChecked = isCheckIconUsed(this.mCurrentStateNumber, i2);
            if (this.mCheckStateCompleted && isChecked) {
                canvas2.drawText(getContext().getString(R.string.check_icon), (float) xPos, (float) yPos, innerPaintType);
            } else if (this.mIsStateNumberDescending) {
                canvas2.drawText(String.valueOf(noOfCircles - i2), (float) xPos, (float) yPos, innerPaintType);
            } else {
                canvas2.drawText(String.valueOf(i2 + 1), (float) xPos, (float) yPos, innerPaintType);
            }
        }
    }

    private Paint selectPaintType(int i, int i2, boolean z) {
        int currentState = i;
        int statePosition = i2;
        boolean checkStateCompleted = z;
        int currentState2 = this.mIsStateNumberDescending ? this.mMaxStateNumber - currentState : currentState;
        Paint foregroundPaint = this.mIsStateNumberDescending ? this.mStateNumberBackgroundPaint : this.mStateNumberForegroundPaint;
        Paint backgroundPaint = this.mIsStateNumberDescending ? this.mStateNumberForegroundPaint : this.mStateNumberBackgroundPaint;
        if (checkStateCompleted) {
            return applyCheckStateCompletedPaintType(currentState2, statePosition, checkStateCompleted);
        }
        if (statePosition + 1 == currentState2 || (statePosition + 1 < currentState2 && !checkStateCompleted)) {
            return foregroundPaint;
        }
        return backgroundPaint;
    }

    private Paint applyCheckStateCompletedPaintType(int i, int i2, boolean checkStateCompleted) {
        int currentState = i;
        int statePosition = i2;
        if (checkStateCompleted(currentState, statePosition, checkStateCompleted)) {
            return this.mStateCheckedForegroundPaint;
        }
        if (statePosition + 1 == (this.mIsStateNumberDescending ? currentState + 1 : currentState)) {
            return this.mStateNumberForegroundPaint;
        }
        return this.mStateNumberBackgroundPaint;
    }

    private boolean checkStateCompleted(int i, int i2, boolean z) {
        int currentState = i;
        int statePosition = i2;
        boolean checkStateCompleted = z;
        if (!this.mIsStateNumberDescending) {
            if ((this.mEnableAllStatesCompleted && checkStateCompleted) || (statePosition + 1 < currentState && checkStateCompleted)) {
                return true;
            }
        } else if ((this.mEnableAllStatesCompleted && checkStateCompleted) || (statePosition + 1 > currentState + 1 && checkStateCompleted)) {
            return true;
        }
        return false;
    }

    private boolean isCheckIconUsed(int i, int i2) {
        int currentState = i;
        int statePosition = i2;
        int currentState2 = this.mIsStateNumberDescending ? (this.mMaxStateNumber + 1) - currentState : currentState;
        if (!this.mIsStateNumberDescending) {
            return this.mEnableAllStatesCompleted || statePosition + 1 < currentState2;
        }
        return this.mEnableAllStatesCompleted || statePosition + 1 > currentState2;
    }

    private void startAnimator() {
        Animator animator;
        new Animator(this);
        this.mAnimator = animator;
        this.mAnimator.start();
    }

    private void stopAnimation() {
        if (this.mAnimator != null) {
            this.mAnimator.stop();
        }
    }

    private float convertDpToPixel(float dp) {
        return dp * getResources().getDisplayMetrics().density;
    }

    private float convertSpToPixel(float sp) {
        return sp * getResources().getDisplayMetrics().scaledDensity;
    }

    public boolean isAllStatesCompletedEnabled() {
        return this.mEnableAllStatesCompleted;
    }

    public boolean isEnableAnimationToCurrentState() {
        return this.mAnimateToCurrentProgressState;
    }

    public void setStateNumberTypefaceFile(Typeface typeface) {
        this.mCustomStateNumberTypeface = typeface;
        Typeface typeface2 = this.mStateNumberForegroundPaint.setTypeface(this.mCustomStateNumberTypeface != null ? this.mCustomStateNumberTypeface : this.mDefaultTypefaceBold);
        Typeface typeface3 = this.mStateNumberBackgroundPaint.setTypeface(this.mCustomStateNumberTypeface != null ? this.mCustomStateNumberTypeface : this.mDefaultTypefaceBold);
        invalidate();
    }

    public void setStateDescriptionTypefaceFile(Typeface typeface) {
        this.mCustomStateDescriptionTypeface = typeface;
        Typeface typeface2 = this.mStateDescriptionPaint.setTypeface(this.mCustomStateDescriptionTypeface != null ? this.mCustomStateDescriptionTypeface : this.mDefaultTypefaceBold);
        Typeface typeface3 = this.mCurrentStateDescriptionPaint.setTypeface(this.mCustomStateDescriptionTypeface != null ? this.mCustomStateDescriptionTypeface : this.mDefaultTypefaceBold);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        startAnimator();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        stopAnimation();
        super.onDetachedFromWindow();
    }

    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        startAnimator();
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle;
        new Bundle();
        Bundle bundle2 = bundle;
        bundle2.putParcelable(INSTANCE_STATE, super.onSaveInstanceState());
        bundle2.putFloat(END_CENTER_X_KEY, this.mEndCenterX);
        bundle2.putFloat(START_CENTER_X_KEY, this.mStartCenterX);
        bundle2.putFloat(ANIM_START_X_POS_KEY, this.mAnimStartXPos);
        bundle2.putFloat(ANIM_END_X_POS_KEY, this.mAnimEndXPos);
        bundle2.putBoolean(IS_CURRENT_ANIM_STARTED_KEY, this.mIsCurrentAnimStarted);
        bundle2.putBoolean(ANIMATE_TO_CURRENT_PROGRESS_STATE_KEY, this.mAnimateToCurrentProgressState);
        bundle2.putBoolean(IS_STATE_NUMBER_DESCENDING_KEY, this.mIsStateNumberDescending);
        bundle2.putFloat(STATE_SIZE_KEY, this.mStateSize);
        bundle2.putFloat(STATE_LINE_THICKNESS_KEY, this.mStateLineThickness);
        bundle2.putFloat(STATE_NUMBER_TEXT_SIZE_KEY, this.mStateNumberTextSize);
        bundle2.putFloat(STATE_DESCRIPTION_SIZE_KEY, this.mStateDescriptionSize);
        bundle2.putInt(MAX_STATE_NUMBER_KEY, this.mMaxStateNumber);
        bundle2.putInt(CURRENT_STATE_NUMBER_KEY, this.mCurrentStateNumber);
        bundle2.putInt(ANIM_START_DELAY_KEY, this.mAnimStartDelay);
        bundle2.putInt(ANIM_DURATION_KEY, this.mAnimDuration);
        bundle2.putFloat(DESC_TOP_SPACE_DECREMENTER_KEY, this.mDescTopSpaceDecrementer);
        bundle2.putFloat(DESC_TOP_SPACE_INCREMENTER_KEY, this.mDescTopSpaceIncrementer);
        bundle2.putFloat(DESCRIPTION_LINE_SPACING_KEY, this.mDescriptionLinesSpacing);
        bundle2.putInt(BACKGROUND_COLOR_KEY, this.mBackgroundColor);
        bundle2.putInt(FOREGROUND_COLOR_KEY, this.mForegroundColor);
        bundle2.putInt(STATE_NUMBER_BACKGROUND_COLOR_KEY, this.mStateNumberBackgroundColor);
        bundle2.putInt(STATE_NUMBER_FOREGROUND_COLOR_KEY, this.mStateNumberForegroundColor);
        bundle2.putInt(CURRENT_STATE_DESC_COLOR_KEY, this.mCurrentStateDescriptionColor);
        bundle2.putInt(STATE_DESC_COLOR_KEY, this.mStateDescriptionColor);
        bundle2.putBoolean(CHECK_STATE_COMPLETED_KEY, this.mCheckStateCompleted);
        bundle2.putBoolean(ENABLE_ALL_STATES_COMPLETED_KEY, this.mEnableAllStatesCompleted);
        bundle2.putBoolean(JUSTIFY_MULTILINE_DESC_KEY, this.mJustifyMultilineDescription);
        return bundle2;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable state = parcelable;
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            this.mEndCenterX = bundle.getFloat(END_CENTER_X_KEY);
            this.mStartCenterX = bundle.getFloat(START_CENTER_X_KEY);
            this.mAnimStartXPos = bundle.getFloat(ANIM_START_X_POS_KEY);
            this.mAnimEndXPos = bundle.getFloat(ANIM_END_X_POS_KEY);
            this.mIsCurrentAnimStarted = bundle.getBoolean(IS_CURRENT_ANIM_STARTED_KEY);
            this.mAnimateToCurrentProgressState = bundle.getBoolean(ANIMATE_TO_CURRENT_PROGRESS_STATE_KEY);
            this.mIsStateNumberDescending = bundle.getBoolean(IS_STATE_NUMBER_DESCENDING_KEY);
            this.mStateNumberTextSize = bundle.getFloat(STATE_NUMBER_TEXT_SIZE_KEY);
            this.mStateSize = bundle.getFloat(STATE_SIZE_KEY);
            resetStateSizeValues();
            this.mStateLineThickness = bundle.getFloat(STATE_LINE_THICKNESS_KEY);
            resolveStateLineThickness();
            this.mStateDescriptionSize = bundle.getFloat(STATE_DESCRIPTION_SIZE_KEY);
            resolveStateDescriptionSize();
            this.mMaxStateNumber = bundle.getInt(MAX_STATE_NUMBER_KEY);
            this.mCurrentStateNumber = bundle.getInt(CURRENT_STATE_NUMBER_KEY);
            resolveMaxStateNumber();
            this.mAnimStartDelay = bundle.getInt(ANIM_START_DELAY_KEY);
            this.mAnimDuration = bundle.getInt(ANIM_DURATION_KEY);
            this.mDescTopSpaceDecrementer = bundle.getFloat(DESC_TOP_SPACE_DECREMENTER_KEY);
            this.mDescTopSpaceIncrementer = bundle.getFloat(DESC_TOP_SPACE_INCREMENTER_KEY);
            this.mDescriptionLinesSpacing = bundle.getFloat(DESCRIPTION_LINE_SPACING_KEY);
            setDescriptionTopSpaceIncrementer(this.mDescTopSpaceIncrementer);
            this.mBackgroundColor = bundle.getInt(BACKGROUND_COLOR_KEY);
            this.mForegroundColor = bundle.getInt(FOREGROUND_COLOR_KEY);
            this.mStateNumberBackgroundColor = bundle.getInt(STATE_NUMBER_BACKGROUND_COLOR_KEY);
            this.mStateNumberForegroundColor = bundle.getInt(STATE_NUMBER_FOREGROUND_COLOR_KEY);
            this.mCurrentStateDescriptionColor = bundle.getInt(CURRENT_STATE_DESC_COLOR_KEY);
            this.mStateDescriptionColor = bundle.getInt(STATE_DESC_COLOR_KEY);
            this.mJustifyMultilineDescription = bundle.getBoolean(JUSTIFY_MULTILINE_DESC_KEY);
            initializePainters();
            checkStateCompleted(bundle.getBoolean(CHECK_STATE_COMPLETED_KEY));
            setAllStatesCompleted(bundle.getBoolean(ENABLE_ALL_STATES_COMPLETED_KEY));
            super.onRestoreInstanceState(bundle.getParcelable(INSTANCE_STATE));
            return;
        }
        super.onRestoreInstanceState(state);
    }

    public enum StateNumber {
        ;
        
        private int value;

        private StateNumber(int value2) {
            String str = r8;
            int i = r9;
            this.value = value2;
        }

        public int getValue() {
            return this.value;
        }
    }

    private class Animator implements Runnable {
        private boolean mRestartAnimation = false;
        private Scroller mScroller;
        final /* synthetic */ StateProgressBar this$0;

        public Animator(StateProgressBar stateProgressBar) {
            Scroller scroller;
            Interpolator interpolator;
            StateProgressBar stateProgressBar2 = stateProgressBar;
            this.this$0 = stateProgressBar2;
            new AccelerateDecelerateInterpolator();
            new Scroller(stateProgressBar2.getContext(), interpolator);
            this.mScroller = scroller;
        }

        public void run() {
            if (this.this$0.mAnimator == this) {
                if (this.mRestartAnimation) {
                    this.mScroller.startScroll(0, (int) this.this$0.mStartCenterX, 0, (int) this.this$0.mEndCenterX, this.this$0.mAnimDuration);
                    this.mRestartAnimation = false;
                }
                boolean scrollRemains = this.mScroller.computeScrollOffset();
                float access$402 = StateProgressBar.access$402(this.this$0, this.this$0.mAnimEndXPos);
                float access$502 = StateProgressBar.access$502(this.this$0, (float) this.mScroller.getCurrY());
                if (scrollRemains) {
                    this.this$0.invalidate();
                    boolean post = this.this$0.post(this);
                    return;
                }
                stop();
                this.this$0.enableAnimationToCurrentState(false);
            }
        }

        public void start() {
            this.mRestartAnimation = true;
            boolean postDelayed = this.this$0.postDelayed(this, (long) this.this$0.mAnimStartDelay);
        }

        public void stop() {
            boolean removeCallbacks = this.this$0.removeCallbacks(this);
            Animator access$002 = StateProgressBar.access$002(this.this$0, (Animator) null);
        }
    }
}
