package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import androidx.annotation.FloatRange;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.MiscUtils;
import java.util.ArrayList;
import java.util.List;

public class ShapeData {
    private boolean closed;
    private final List<CubicCurveData> curves;
    private PointF initialPoint;

    public ShapeData(PointF initialPoint2, boolean closed2, List<CubicCurveData> curves2) {
        List<CubicCurveData> list;
        this.initialPoint = initialPoint2;
        this.closed = closed2;
        new ArrayList(curves2);
        this.curves = list;
    }

    public ShapeData() {
        List<CubicCurveData> list;
        new ArrayList();
        this.curves = list;
    }

    private void setInitialPoint(float f, float f2) {
        PointF pointF;
        float x = f;
        float y = f2;
        if (this.initialPoint == null) {
            new PointF();
            this.initialPoint = pointF;
        }
        this.initialPoint.set(x, y);
    }

    public PointF getInitialPoint() {
        return this.initialPoint;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public List<CubicCurveData> getCurves() {
        return this.curves;
    }

    public void interpolateBetween(ShapeData shapeData, ShapeData shapeData2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        Object obj;
        StringBuilder sb;
        PointF pointF;
        ShapeData shapeData1 = shapeData;
        ShapeData shapeData22 = shapeData2;
        float percentage = f;
        if (this.initialPoint == null) {
            new PointF();
            this.initialPoint = pointF;
        }
        this.closed = shapeData1.isClosed() || shapeData22.isClosed();
        if (shapeData1.getCurves().size() != shapeData22.getCurves().size()) {
            new StringBuilder();
            Logger.warning(sb.append("Curves must have the same number of control points. Shape 1: ").append(shapeData1.getCurves().size()).append("\tShape 2: ").append(shapeData22.getCurves().size()).toString());
        }
        int points = Math.min(shapeData1.getCurves().size(), shapeData22.getCurves().size());
        if (this.curves.size() < points) {
            for (int i = this.curves.size(); i < points; i++) {
                new CubicCurveData();
                boolean add = this.curves.add(obj);
            }
        } else {
            if (this.curves.size() > points) {
                for (int i2 = this.curves.size() - 1; i2 >= points; i2--) {
                    CubicCurveData remove = this.curves.remove(this.curves.size() - 1);
                }
            }
        }
        PointF initialPoint1 = shapeData1.getInitialPoint();
        PointF initialPoint2 = shapeData22.getInitialPoint();
        setInitialPoint(MiscUtils.lerp(initialPoint1.x, initialPoint2.x, percentage), MiscUtils.lerp(initialPoint1.y, initialPoint2.y, percentage));
        for (int i3 = this.curves.size() - 1; i3 >= 0; i3--) {
            CubicCurveData curve1 = shapeData1.getCurves().get(i3);
            CubicCurveData curve2 = shapeData22.getCurves().get(i3);
            PointF cp11 = curve1.getControlPoint1();
            PointF cp21 = curve1.getControlPoint2();
            PointF vertex1 = curve1.getVertex();
            PointF cp12 = curve2.getControlPoint1();
            PointF cp22 = curve2.getControlPoint2();
            PointF vertex2 = curve2.getVertex();
            this.curves.get(i3).setControlPoint1(MiscUtils.lerp(cp11.x, cp12.x, percentage), MiscUtils.lerp(cp11.y, cp12.y, percentage));
            this.curves.get(i3).setControlPoint2(MiscUtils.lerp(cp21.x, cp22.x, percentage), MiscUtils.lerp(cp21.y, cp22.y, percentage));
            this.curves.get(i3).setVertex(MiscUtils.lerp(vertex1.x, vertex2.x, percentage), MiscUtils.lerp(vertex1.y, vertex2.y, percentage));
        }
    }

    public String toString() {
        StringBuilder sb;
        new StringBuilder();
        return sb.append("ShapeData{numCurves=").append(this.curves.size()).append("closed=").append(this.closed).append('}').toString();
    }
}
