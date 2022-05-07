package com.airbnb.lottie;

import android.graphics.ColorFilter;
import android.graphics.PointF;
import com.airbnb.lottie.value.ScaleXY;

public interface LottieProperty {
    public static final Integer COLOR = 1;
    public static final ColorFilter COLOR_FILTER;
    public static final Float CORNER_RADIUS = Float.valueOf(0.0f);
    public static final PointF ELLIPSE_SIZE;
    public static final Integer[] GRADIENT_COLOR = new Integer[0];
    public static final Integer OPACITY = 4;
    public static final Float POLYSTAR_INNER_RADIUS = Float.valueOf(8.0f);
    public static final Float POLYSTAR_INNER_ROUNDEDNESS = Float.valueOf(10.0f);
    public static final Float POLYSTAR_OUTER_RADIUS = Float.valueOf(9.0f);
    public static final Float POLYSTAR_OUTER_ROUNDEDNESS = Float.valueOf(11.0f);
    public static final Float POLYSTAR_POINTS = Float.valueOf(6.0f);
    public static final Float POLYSTAR_ROTATION = Float.valueOf(7.0f);
    public static final PointF POSITION;
    public static final PointF RECTANGLE_SIZE;
    public static final Float REPEATER_COPIES = Float.valueOf(4.0f);
    public static final Float REPEATER_OFFSET = Float.valueOf(5.0f);
    public static final Integer STROKE_COLOR = 2;
    public static final Float STROKE_WIDTH = Float.valueOf(2.0f);
    public static final Float TEXT_TRACKING = Float.valueOf(3.0f);
    public static final Float TIME_REMAP = Float.valueOf(13.0f);
    public static final PointF TRANSFORM_ANCHOR_POINT;
    public static final Float TRANSFORM_END_OPACITY = Float.valueOf(12.0f);
    public static final Integer TRANSFORM_OPACITY = 3;
    public static final PointF TRANSFORM_POSITION;
    public static final Float TRANSFORM_ROTATION = Float.valueOf(1.0f);
    public static final ScaleXY TRANSFORM_SCALE;
    public static final Float TRANSFORM_SKEW = Float.valueOf(0.0f);
    public static final Float TRANSFORM_SKEW_ANGLE = Float.valueOf(0.0f);
    public static final Float TRANSFORM_START_OPACITY = Float.valueOf(12.0f);

    static {
        PointF pointF;
        PointF pointF2;
        PointF pointF3;
        PointF pointF4;
        PointF pointF5;
        ScaleXY scaleXY;
        ColorFilter colorFilter;
        new PointF();
        TRANSFORM_ANCHOR_POINT = pointF;
        new PointF();
        TRANSFORM_POSITION = pointF2;
        new PointF();
        ELLIPSE_SIZE = pointF3;
        new PointF();
        RECTANGLE_SIZE = pointF4;
        new PointF();
        POSITION = pointF5;
        new ScaleXY();
        TRANSFORM_SCALE = scaleXY;
        new ColorFilter();
        COLOR_FILTER = colorFilter;
    }
}
