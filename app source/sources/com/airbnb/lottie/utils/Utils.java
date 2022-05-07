package com.airbnb.lottie.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.Nullable;
import com.airbnb.lottie.L;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import java.io.Closeable;

public final class Utils {
    public static final int SECOND_IN_NANOS = 1000000000;
    private static final float SQRT_2 = ((float) Math.sqrt(2.0d));
    private static float dpScale = -1.0f;
    private static final PathMeasure pathMeasure;
    private static final float[] points = new float[4];
    private static final Path tempPath;
    private static final Path tempPath2;

    static {
        PathMeasure pathMeasure2;
        Path path;
        Path path2;
        new PathMeasure();
        pathMeasure = pathMeasure2;
        new Path();
        tempPath = path;
        new Path();
        tempPath2 = path2;
    }

    private Utils() {
    }

    public static Path createPath(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path;
        PointF startPoint = pointF;
        PointF endPoint = pointF2;
        PointF cp1 = pointF3;
        PointF cp2 = pointF4;
        new Path();
        Path path2 = path;
        path2.moveTo(startPoint.x, startPoint.y);
        if (cp1 == null || cp2 == null || (cp1.length() == 0.0f && cp2.length() == 0.0f)) {
            path2.lineTo(endPoint.x, endPoint.y);
        } else {
            path2.cubicTo(startPoint.x + cp1.x, startPoint.y + cp1.y, endPoint.x + cp2.x, endPoint.y + cp2.y, endPoint.x, endPoint.y);
        }
        return path2;
    }

    public static void closeQuietly(Closeable closeable) {
        Closeable closeable2 = closeable;
        if (closeable2 != null) {
            try {
                closeable2.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
                Exception exc = e2;
            }
        }
    }

    public static float getScale(Matrix matrix) {
        points[0] = 0.0f;
        points[1] = 0.0f;
        points[2] = SQRT_2;
        points[3] = SQRT_2;
        matrix.mapPoints(points);
        return ((float) Math.hypot((double) (points[2] - points[0]), (double) (points[3] - points[1]))) / 2.0f;
    }

    public static boolean hasZeroScaleAxis(Matrix matrix) {
        points[0] = 0.0f;
        points[1] = 0.0f;
        points[2] = 37394.73f;
        points[3] = 39575.234f;
        matrix.mapPoints(points);
        if (points[0] == points[2] || points[1] == points[3]) {
            return true;
        }
        return false;
    }

    public static void applyTrimPathIfNeeded(Path path, @Nullable TrimPathContent trimPathContent) {
        Path path2 = path;
        TrimPathContent trimPath = trimPathContent;
        if (trimPath != null && !trimPath.isHidden()) {
            applyTrimPathIfNeeded(path2, ((FloatKeyframeAnimation) trimPath.getStart()).getFloatValue() / 100.0f, ((FloatKeyframeAnimation) trimPath.getEnd()).getFloatValue() / 100.0f, ((FloatKeyframeAnimation) trimPath.getOffset()).getFloatValue() / 360.0f);
        }
    }

    public static void applyTrimPathIfNeeded(Path path, float f, float f2, float f3) {
        Path path2 = path;
        float startValue = f;
        float endValue = f2;
        float offsetValue = f3;
        L.beginSection("applyTrimPathIfNeeded");
        pathMeasure.setPath(path2, false);
        float length = pathMeasure.getLength();
        if (startValue == 1.0f && endValue == 0.0f) {
            float endSection = L.endSection("applyTrimPathIfNeeded");
        } else if (length < 1.0f || ((double) Math.abs((endValue - startValue) - 1.0f)) < 0.01d) {
            float endSection2 = L.endSection("applyTrimPathIfNeeded");
        } else {
            float start = length * startValue;
            float end = length * endValue;
            float newStart = Math.min(start, end);
            float offset = offsetValue * length;
            float newStart2 = newStart + offset;
            float newEnd = Math.max(start, end) + offset;
            if (newStart2 >= length && newEnd >= length) {
                newStart2 = (float) MiscUtils.floorMod(newStart2, length);
                newEnd = (float) MiscUtils.floorMod(newEnd, length);
            }
            if (newStart2 < 0.0f) {
                newStart2 = (float) MiscUtils.floorMod(newStart2, length);
            }
            if (newEnd < 0.0f) {
                newEnd = (float) MiscUtils.floorMod(newEnd, length);
            }
            if (newStart2 == newEnd) {
                path2.reset();
                float endSection3 = L.endSection("applyTrimPathIfNeeded");
                return;
            }
            if (newStart2 >= newEnd) {
                newStart2 -= length;
            }
            tempPath.reset();
            boolean segment = pathMeasure.getSegment(newStart2, newEnd, tempPath, true);
            if (newEnd > length) {
                tempPath2.reset();
                boolean segment2 = pathMeasure.getSegment(0.0f, newEnd % length, tempPath2, true);
                tempPath.addPath(tempPath2);
            } else if (newStart2 < 0.0f) {
                tempPath2.reset();
                boolean segment3 = pathMeasure.getSegment(length + newStart2, length, tempPath2, true);
                tempPath.addPath(tempPath2);
            }
            path2.set(tempPath);
            float endSection4 = L.endSection("applyTrimPathIfNeeded");
        }
    }

    public static boolean isAtLeastVersion(int i, int i2, int i3, int i4, int i5, int i6) {
        int major = i;
        int minor = i2;
        int patch = i3;
        int minMajor = i4;
        int minMinor = i5;
        int minPatch = i6;
        if (major < minMajor) {
            return false;
        }
        if (major > minMajor) {
            return true;
        }
        if (minor < minMinor) {
            return false;
        }
        if (minor > minMinor) {
            return true;
        }
        return patch >= minPatch;
    }

    public static int hashFor(float f, float f2, float f3, float f4) {
        float a = f;
        float b = f2;
        float c = f3;
        float d = f4;
        int result = 17;
        if (a != 0.0f) {
            result = (int) (((float) (31 * 17)) * a);
        }
        if (b != 0.0f) {
            result = (int) (((float) (31 * result)) * b);
        }
        if (c != 0.0f) {
            result = (int) (((float) (31 * result)) * c);
        }
        if (d != 0.0f) {
            result = (int) (((float) (31 * result)) * d);
        }
        return result;
    }

    public static float dpScale() {
        if (dpScale == -1.0f) {
            dpScale = Resources.getSystem().getDisplayMetrics().density;
        }
        return dpScale;
    }

    public static float getAnimationScale(Context context) {
        Context context2 = context;
        if (Build.VERSION.SDK_INT >= 17) {
            return Settings.Global.getFloat(context2.getContentResolver(), "animator_duration_scale", 1.0f);
        }
        return Settings.System.getFloat(context2.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public static Bitmap resizeBitmapIfNeeded(Bitmap bitmap, int i, int i2) {
        Bitmap bitmap2 = bitmap;
        int width = i;
        int height = i2;
        if (bitmap2.getWidth() == width && bitmap2.getHeight() == height) {
            return bitmap2;
        }
        float width2 = ((float) width) / ((float) bitmap2.getWidth());
        float height2 = ((float) height) / ((float) bitmap2.getHeight());
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap2, width, height, true);
        bitmap2.recycle();
        return resizedBitmap;
    }

    public static Bitmap renderPath(Path path) {
        RectF rectF;
        Canvas canvas;
        Paint paint;
        Path path2 = path;
        new RectF();
        RectF bounds = rectF;
        path2.computeBounds(bounds, false);
        Bitmap bitmap = Bitmap.createBitmap((int) bounds.right, (int) bounds.bottom, Bitmap.Config.ARGB_8888);
        new Canvas(bitmap);
        new LPaint();
        Paint paint2 = paint;
        paint2.setAntiAlias(true);
        paint2.setColor(-16776961);
        canvas.drawPath(path2, paint2);
        return bitmap;
    }
}
