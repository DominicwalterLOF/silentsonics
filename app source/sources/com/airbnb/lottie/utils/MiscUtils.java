package com.airbnb.lottie.utils;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.FloatRange;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeData;
import java.util.List;

public class MiscUtils {
    private static PointF pathFromDataCurrentPoint;

    public MiscUtils() {
    }

    static {
        PointF pointF;
        new PointF();
        pathFromDataCurrentPoint = pointF;
    }

    public static PointF addPoints(PointF pointF, PointF pointF2) {
        PointF p1;
        PointF p12 = pointF;
        PointF p2 = pointF2;
        new PointF(p12.x + p2.x, p12.y + p2.y);
        return p1;
    }

    public static void getPathFromData(ShapeData shapeData, Path path) {
        ShapeData shapeData2 = shapeData;
        Path outPath = path;
        outPath.reset();
        PointF initialPoint = shapeData2.getInitialPoint();
        outPath.moveTo(initialPoint.x, initialPoint.y);
        pathFromDataCurrentPoint.set(initialPoint.x, initialPoint.y);
        for (int i = 0; i < shapeData2.getCurves().size(); i++) {
            CubicCurveData curveData = shapeData2.getCurves().get(i);
            PointF cp1 = curveData.getControlPoint1();
            PointF cp2 = curveData.getControlPoint2();
            PointF vertex = curveData.getVertex();
            if (!cp1.equals(pathFromDataCurrentPoint) || !cp2.equals(vertex)) {
                outPath.cubicTo(cp1.x, cp1.y, cp2.x, cp2.y, vertex.x, vertex.y);
            } else {
                outPath.lineTo(vertex.x, vertex.y);
            }
            pathFromDataCurrentPoint.set(vertex.x, vertex.y);
        }
        if (shapeData2.isClosed()) {
            outPath.close();
        }
    }

    public static float lerp(float f, float b, @FloatRange(from = 0.0d, to = 1.0d) float percentage) {
        float a = f;
        return a + (percentage * (b - a));
    }

    public static double lerp(double d, double b, @FloatRange(from = 0.0d, to = 1.0d) double percentage) {
        double a = d;
        return a + (percentage * (b - a));
    }

    public static int lerp(int i, int b, @FloatRange(from = 0.0d, to = 1.0d) float percentage) {
        int a = i;
        return (int) (((float) a) + (percentage * ((float) (b - a))));
    }

    static int floorMod(float x, float y) {
        return floorMod((int) x, (int) y);
    }

    private static int floorMod(int i, int i2) {
        int x = i;
        int y = i2;
        return x - (y * floorDiv(x, y));
    }

    private static int floorDiv(int i, int i2) {
        int x = i;
        int y = i2;
        int r = x / y;
        int mod = x % y;
        if (!((x ^ y) >= 0) && mod != 0) {
            r--;
        }
        return r;
    }

    public static int clamp(int number, int min, int max) {
        return Math.max(min, Math.min(max, number));
    }

    public static float clamp(float number, float min, float max) {
        return Math.max(min, Math.min(max, number));
    }

    public static boolean contains(float f, float rangeMin, float rangeMax) {
        float number = f;
        return number >= rangeMin && number <= rangeMax;
    }

    public static void resolveKeyPath(KeyPath keyPath, int depth, List<KeyPath> list, KeyPath keyPath2, KeyPathElementContent keyPathElementContent) {
        List<KeyPath> accumulator = list;
        KeyPath currentPartialKeyPath = keyPath2;
        KeyPathElementContent content = keyPathElementContent;
        if (keyPath.fullyResolvesTo(content.getName(), depth)) {
            boolean add = accumulator.add(currentPartialKeyPath.addKey(content.getName()).resolve(content));
        }
    }
}
