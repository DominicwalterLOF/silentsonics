package com.google.appinventor.components.runtime;

import android.util.Log;
import com.google.appinventor.components.annotations.Asset;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.Options;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesLibraries;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.HorizontalAlignment;
import com.google.appinventor.components.common.MapFeature;
import com.google.appinventor.components.common.VerticalAlignment;
import com.google.appinventor.components.runtime.util.ErrorMessages;
import com.google.appinventor.components.runtime.util.GeometryUtil;
import com.google.appinventor.components.runtime.util.MapFactory;
import org.locationtech.jts.geom.Geometry;
import org.osmdroid.api.IGeoPoint;
import org.osmdroid.util.GeoPoint;

@SimpleObject
@DesignerComponent(category = ComponentCategory.MAPS, description = "<p>An icon positioned at a point to indicate information on a map. Markers can be used to provide an info window, custom fill and stroke colors, and custom images to convey information to the user.</p>", version = 4)
@UsesLibraries({"osmdroid.aar", "androidsvg.jar"})
public class Marker extends MapFeatureBaseWithFill implements MapFactory.MapMarker {
    private static final String TAG = Marker.class.getSimpleName();
    private static final MapFactory.MapFeatureVisitor<Double> hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    private static final MapFactory.MapFeatureVisitor<Double> wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou;
    private int PJTNEFub7t830GnsJOreZR2G4QGerhYk5JzZTaNM1rn2OjCmiPf1GPWMoDtnF4UY;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private HorizontalAlignment f224hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = HorizontalAlignment.Center;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private VerticalAlignment f225hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = VerticalAlignment.Bottom;
    private String imagePath = "";
    private int vB3WjEtL56PUGm0spJ96S19MI1O4vPR6yju8tUYcKrC4atk0AV5GbVcHQNB7BlIK;

    /* renamed from: wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou  reason: collision with other field name */
    private GeoPoint f226wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou;

    static {
        MapFactory.MapFeatureVisitor<Double> mapFeatureVisitor;
        MapFactory.MapFeatureVisitor<Double> mapFeatureVisitor2;
        new MapFactory.MapFeatureVisitor<Double>() {
            public final /* synthetic */ Object visit(MapFactory.MapRectangle mapRectangle, Object[] objArr) {
                MapFactory.MapRectangle mapRectangle2 = mapRectangle;
                Object[] objArr2 = objArr;
                if (((Boolean) objArr2[1]).booleanValue()) {
                    return Double.valueOf(GeometryUtil.distanceBetweenCentroids((MapFactory.MapMarker) (Marker) objArr2[0], mapRectangle2));
                }
                return Double.valueOf(GeometryUtil.distanceBetweenEdges((MapFactory.MapMarker) (Marker) objArr2[0], mapRectangle2));
            }

            public final /* synthetic */ Object visit(MapFactory.MapCircle mapCircle, Object[] objArr) {
                MapFactory.MapCircle mapCircle2 = mapCircle;
                Object[] objArr2 = objArr;
                if (((Boolean) objArr2[1]).booleanValue()) {
                    return Double.valueOf(GeometryUtil.distanceBetweenCentroids((MapFactory.MapMarker) (Marker) objArr2[0], mapCircle2));
                }
                return Double.valueOf(GeometryUtil.distanceBetweenEdges((MapFactory.MapMarker) (Marker) objArr2[0], mapCircle2));
            }

            public final /* synthetic */ Object visit(MapFactory.MapPolygon mapPolygon, Object[] objArr) {
                MapFactory.MapPolygon mapPolygon2 = mapPolygon;
                Object[] objArr2 = objArr;
                if (((Boolean) objArr2[1]).booleanValue()) {
                    return Double.valueOf(GeometryUtil.distanceBetweenCentroids((MapFactory.MapMarker) (Marker) objArr2[0], mapPolygon2));
                }
                return Double.valueOf(GeometryUtil.distanceBetweenEdges((MapFactory.MapMarker) (Marker) objArr2[0], mapPolygon2));
            }

            public final /* synthetic */ Object visit(MapFactory.MapLineString mapLineString, Object[] objArr) {
                MapFactory.MapLineString mapLineString2 = mapLineString;
                Object[] objArr2 = objArr;
                if (((Boolean) objArr2[1]).booleanValue()) {
                    return Double.valueOf(GeometryUtil.distanceBetweenCentroids((MapFactory.MapMarker) (Marker) objArr2[0], mapLineString2));
                }
                return Double.valueOf(GeometryUtil.distanceBetweenEdges((MapFactory.MapMarker) (Marker) objArr2[0], mapLineString2));
            }

            public final /* synthetic */ Object visit(MapFactory.MapMarker mapMarker, Object[] objArr) {
                return Double.valueOf(GeometryUtil.distanceBetween((MapFactory.MapMarker) (Marker) objArr[0], mapMarker));
            }
        };
        hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = mapFeatureVisitor;
        new MapFactory.MapFeatureVisitor<Double>() {
            public final /* synthetic */ Object visit(MapFactory.MapRectangle mapRectangle, Object[] objArr) {
                MapFactory.MapRectangle mapRectangle2 = mapRectangle;
                Object[] objArr2 = objArr;
                if (((Boolean) objArr2[1]).booleanValue()) {
                    return Double.valueOf(GeometryUtil.bearingToCentroid((MapFactory.MapMarker) objArr2[0], mapRectangle2));
                }
                return Double.valueOf(GeometryUtil.bearingToEdge((MapFactory.MapMarker) objArr2[0], mapRectangle2));
            }

            public final /* synthetic */ Object visit(MapFactory.MapCircle mapCircle, Object[] objArr) {
                MapFactory.MapCircle mapCircle2 = mapCircle;
                Object[] objArr2 = objArr;
                if (((Boolean) objArr2[1]).booleanValue()) {
                    return Double.valueOf(GeometryUtil.bearingToCentroid((MapFactory.MapMarker) objArr2[0], mapCircle2));
                }
                return Double.valueOf(GeometryUtil.bearingToEdge((MapFactory.MapMarker) objArr2[0], mapCircle2));
            }

            public final /* synthetic */ Object visit(MapFactory.MapPolygon mapPolygon, Object[] objArr) {
                MapFactory.MapPolygon mapPolygon2 = mapPolygon;
                Object[] objArr2 = objArr;
                if (((Boolean) objArr2[1]).booleanValue()) {
                    return Double.valueOf(GeometryUtil.bearingToCentroid((MapFactory.MapMarker) objArr2[0], mapPolygon2));
                }
                return Double.valueOf(GeometryUtil.bearingToEdge((MapFactory.MapMarker) objArr2[0], mapPolygon2));
            }

            public final /* synthetic */ Object visit(MapFactory.MapLineString mapLineString, Object[] objArr) {
                MapFactory.MapLineString mapLineString2 = mapLineString;
                Object[] objArr2 = objArr;
                if (((Boolean) objArr2[1]).booleanValue()) {
                    return Double.valueOf(GeometryUtil.bearingToCentroid((MapFactory.MapMarker) objArr2[0], mapLineString2));
                }
                return Double.valueOf(GeometryUtil.bearingToEdge((MapFactory.MapMarker) objArr2[0], mapLineString2));
            }

            public final /* synthetic */ Object visit(MapFactory.MapMarker mapMarker, Object[] objArr) {
                return Double.valueOf(GeometryUtil.bearingTo((Marker) objArr[0], mapMarker));
            }
        };
        wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou = mapFeatureVisitor2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Marker(com.google.appinventor.components.runtime.util.MapFactory.MapFeatureContainer r12) {
        /*
            r11 = this;
            r1 = r11
            r2 = r12
            r3 = r1
            r4 = r2
            com.google.appinventor.components.runtime.util.MapFactory$MapFeatureVisitor<java.lang.Double> r5 = hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r3.<init>(r4, r5)
            r3 = r1
            java.lang.String r4 = ""
            r3.imagePath = r4
            r3 = r1
            com.google.appinventor.components.common.HorizontalAlignment r4 = com.google.appinventor.components.common.HorizontalAlignment.Center
            r3.f224hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r4
            r3 = r1
            com.google.appinventor.components.common.VerticalAlignment r4 = com.google.appinventor.components.common.VerticalAlignment.Bottom
            r3.f225hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r4
            r3 = r1
            org.osmdroid.util.GeoPoint r4 = new org.osmdroid.util.GeoPoint
            r10 = r4
            r4 = r10
            r5 = r10
            r6 = 0
            r8 = 0
            r5.<init>(r6, r8)
            r3.f226wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou = r4
            r3 = r1
            r4 = -1
            r3.vB3WjEtL56PUGm0spJ96S19MI1O4vPR6yju8tUYcKrC4atk0AV5GbVcHQNB7BlIK = r4
            r3 = r1
            r4 = -1
            r3.PJTNEFub7t830GnsJOreZR2G4QGerhYk5JzZTaNM1rn2OjCmiPf1GPWMoDtnF4UY = r4
            r3 = r2
            r4 = r1
            r3.addFeature(r4)
            r3 = r1
            r4 = 0
            r3.ShowShadow(r4)
            r3 = r1
            r4 = 3
            r3.AnchorHorizontal(r4)
            r3 = r1
            r4 = 3
            r3.AnchorVertical(r4)
            r3 = r1
            java.lang.String r4 = ""
            r3.ImageAsset(r4)
            r3 = r1
            r4 = -1
            r3.Width(r4)
            r3 = r1
            r4 = -1
            r3.Height(r4)
            r3 = r1
            r4 = 0
            r3.Latitude(r4)
            r3 = r1
            r4 = 0
            r3.Longitude(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.Marker.<init>(com.google.appinventor.components.runtime.util.MapFactory$MapFeatureContainer):void");
    }

    @Options(MapFeature.class)
    @SimpleProperty(description = "Returns the type of the feature. For Markers, this returns MapFeature.Marker (\"Marker\").")
    public String Type() {
        return TypeAbstract().toUnderlyingValue();
    }

    public MapFeature TypeAbstract() {
        return MapFeature.Marker;
    }

    @DesignerProperty(defaultValue = "0", editorType = "latitude")
    @SimpleProperty
    public void Latitude(double d) {
        double d2 = d;
        int d3 = Log.d(TAG, "Latitude");
        if (d2 < -90.0d || d2 > 90.0d) {
            this.container.$form().dispatchErrorOccurredEvent(this, "Latitude", ErrorMessages.ERROR_INVALID_LATITUDE, Double.valueOf(d2));
            return;
        }
        this.f226wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou.setLatitude(d2);
        clearGeometry();
        this.map.getController().updateFeaturePosition((MapFactory.MapMarker) this);
    }

    @SimpleProperty
    public double Latitude() {
        return this.f226wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou.getLatitude();
    }

    @DesignerProperty(defaultValue = "0", editorType = "longitude")
    @SimpleProperty
    public void Longitude(double d) {
        double d2 = d;
        int d3 = Log.d(TAG, "Longitude");
        if (d2 < -180.0d || d2 > 180.0d) {
            this.container.$form().dispatchErrorOccurredEvent(this, "Longitude", ErrorMessages.ERROR_INVALID_LONGITUDE, Double.valueOf(d2));
            return;
        }
        this.f226wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou.setLongitude(d2);
        clearGeometry();
        this.map.getController().updateFeaturePosition((MapFactory.MapMarker) this);
    }

    @SimpleProperty
    public double Longitude() {
        return this.f226wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou.getLongitude();
    }

    @DesignerProperty(editorType = "image_asset")
    @SimpleProperty
    public void ImageAsset(@Asset String str) {
        int d = Log.d(TAG, "ImageAsset");
        this.imagePath = str;
        this.map.getController().updateFeatureImage(this);
    }

    @SimpleProperty(description = "The ImageAsset property is used to provide an alternative image for the Marker.")
    public String ImageAsset() {
        return this.imagePath;
    }

    @SimpleProperty
    public void StrokeColor(int i) {
        super.StrokeColor(i);
        this.map.getController().updateFeatureStroke(this);
    }

    @DesignerProperty(defaultValue = "3", editorType = "horizontal_alignment")
    @SimpleProperty
    public void AnchorHorizontal(@Options(HorizontalAlignment.class) int i) {
        int i2 = i;
        HorizontalAlignment fromUnderlyingValue = HorizontalAlignment.fromUnderlyingValue(Integer.valueOf(i2));
        HorizontalAlignment horizontalAlignment = fromUnderlyingValue;
        if (fromUnderlyingValue == null) {
            this.container.$form().dispatchErrorOccurredEvent(this, "AnchorHorizontal", ErrorMessages.ERROR_INVALID_ANCHOR_HORIZONTAL, Integer.valueOf(i2));
            return;
        }
        AnchorHorizontalAbstract(horizontalAlignment);
    }

    @Options(HorizontalAlignment.class)
    @SimpleProperty(description = "The horizontal alignment property controls where the Marker's anchor is located relative to its width. The choices are: 1 = left aligned, 3 = horizontally centered, 2 = right aligned.")
    public int AnchorHorizontal() {
        return AnchorHorizontalAbstract().toUnderlyingValue().intValue();
    }

    public HorizontalAlignment AnchorHorizontalAbstract() {
        return this.f224hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    }

    public void AnchorHorizontalAbstract(HorizontalAlignment horizontalAlignment) {
        HorizontalAlignment horizontalAlignment2 = horizontalAlignment;
        if (horizontalAlignment2 != this.f224hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME) {
            this.f224hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = horizontalAlignment2;
            this.map.getController().updateFeaturePosition((MapFactory.MapMarker) this);
        }
    }

    @DesignerProperty(defaultValue = "3", editorType = "vertical_alignment")
    @SimpleProperty
    public void AnchorVertical(@Options(VerticalAlignment.class) int i) {
        int i2 = i;
        VerticalAlignment fromUnderlyingValue = VerticalAlignment.fromUnderlyingValue(Integer.valueOf(i2));
        VerticalAlignment verticalAlignment = fromUnderlyingValue;
        if (fromUnderlyingValue == null) {
            this.container.$form().dispatchErrorOccurredEvent(this, "AnchorVertical", ErrorMessages.ERROR_INVALID_ANCHOR_VERTICAL, Integer.valueOf(i2));
            return;
        }
        AnchorVerticalAbstract(verticalAlignment);
    }

    @Options(VerticalAlignment.class)
    @SimpleProperty(description = "The vertical alignment property controls where the Marker's anchor is located relative to its height. The choices are: 1 = aligned at the top, 2 = vertically centered, 3 = aligned at the bottom.")
    public int AnchorVertical() {
        return AnchorVerticalAbstract().toUnderlyingValue().intValue();
    }

    public VerticalAlignment AnchorVerticalAbstract() {
        return this.f225hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    }

    public void AnchorVerticalAbstract(VerticalAlignment verticalAlignment) {
        VerticalAlignment verticalAlignment2 = verticalAlignment;
        if (verticalAlignment2 != null) {
            this.f225hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = verticalAlignment2;
            this.map.getController().updateFeaturePosition((MapFactory.MapMarker) this);
        }
    }

    @SimpleProperty(userVisible = false)
    public void ShowShadow(boolean z) {
    }

    @SimpleProperty(description = "Gets whether or not the shadow of the Marker is shown.")
    public boolean ShowShadow() {
        return false;
    }

    @SimpleProperty
    public void Width(int i) {
        this.vB3WjEtL56PUGm0spJ96S19MI1O4vPR6yju8tUYcKrC4atk0AV5GbVcHQNB7BlIK = i;
        this.map.getController().updateFeatureSize(this);
    }

    @SimpleProperty
    public int Width() {
        if (this.vB3WjEtL56PUGm0spJ96S19MI1O4vPR6yju8tUYcKrC4atk0AV5GbVcHQNB7BlIK == -2) {
            return this.map.getView().getWidth();
        }
        if (this.vB3WjEtL56PUGm0spJ96S19MI1O4vPR6yju8tUYcKrC4atk0AV5GbVcHQNB7BlIK < -1000) {
            return (int) (((((double) (-this.vB3WjEtL56PUGm0spJ96S19MI1O4vPR6yju8tUYcKrC4atk0AV5GbVcHQNB7BlIK)) - 0.00408935546875d) / 100.0d) * ((double) this.map.getView().getWidth()));
        }
        return this.vB3WjEtL56PUGm0spJ96S19MI1O4vPR6yju8tUYcKrC4atk0AV5GbVcHQNB7BlIK;
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE)
    public void WidthPercent(int i) {
        this.vB3WjEtL56PUGm0spJ96S19MI1O4vPR6yju8tUYcKrC4atk0AV5GbVcHQNB7BlIK = -1000 - i;
        this.map.getController().updateFeatureSize(this);
    }

    @SimpleProperty
    public void Height(int i) {
        this.PJTNEFub7t830GnsJOreZR2G4QGerhYk5JzZTaNM1rn2OjCmiPf1GPWMoDtnF4UY = i;
        this.map.getController().updateFeatureSize(this);
    }

    @SimpleProperty
    public int Height() {
        if (this.PJTNEFub7t830GnsJOreZR2G4QGerhYk5JzZTaNM1rn2OjCmiPf1GPWMoDtnF4UY == -2) {
            return this.map.getView().getHeight();
        }
        if (this.PJTNEFub7t830GnsJOreZR2G4QGerhYk5JzZTaNM1rn2OjCmiPf1GPWMoDtnF4UY < -1000) {
            return (int) (((((double) (-this.PJTNEFub7t830GnsJOreZR2G4QGerhYk5JzZTaNM1rn2OjCmiPf1GPWMoDtnF4UY)) - 0.00408935546875d) / 100.0d) * ((double) this.map.getView().getHeight()));
        }
        return this.PJTNEFub7t830GnsJOreZR2G4QGerhYk5JzZTaNM1rn2OjCmiPf1GPWMoDtnF4UY;
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE)
    public void HeightPercent(int i) {
        this.PJTNEFub7t830GnsJOreZR2G4QGerhYk5JzZTaNM1rn2OjCmiPf1GPWMoDtnF4UY = -1000 - i;
        this.map.getController().updateFeatureSize(this);
    }

    @SimpleFunction(description = "Set the location of the marker.")
    public void SetLocation(double d, double d2) {
        int d3 = Log.d(TAG, "SetLocation");
        this.f226wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou.setCoords(d, d2);
        clearGeometry();
        this.map.getController().updateFeaturePosition((MapFactory.MapMarker) this);
    }

    public double DistanceToPoint(double d, double d2, boolean z) {
        boolean z2 = z;
        return DistanceToPoint(d, d2);
    }

    @SimpleFunction(description = "Compute the distance, in meters, between a map feature and a latitude, longitude point.")
    public double DistanceToPoint(double d, double d2) {
        GeoPoint geoPoint;
        new GeoPoint(d, d2);
        return GeometryUtil.distanceBetween((MapFactory.MapMarker) this, geoPoint);
    }

    @SimpleFunction(description = "Returns the bearing from the Marker to the given latitude and longitude, in degrees from due north.")
    public double BearingToPoint(double d, double d2) {
        IGeoPoint iGeoPoint;
        new GeoPoint(d, d2);
        return this.f226wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou.bearingTo(iGeoPoint);
    }

    @SimpleFunction(description = "Returns the bearing from the Marker to the given map feature, in degrees from due north. If the centroids parameter is true, the bearing will be to the center of the map feature. Otherwise, the bearing will be computed to the point in the feature nearest the Marker.")
    public double BearingToFeature(MapFactory.MapFeature mapFeature, boolean z) {
        MapFactory.MapFeature mapFeature2 = mapFeature;
        boolean z2 = z;
        if (mapFeature2 == null) {
            return -1.0d;
        }
        MapFactory.MapFeatureVisitor mapFeatureVisitor = wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou;
        Object[] objArr = new Object[2];
        objArr[0] = this;
        Object[] objArr2 = objArr;
        objArr2[1] = Boolean.valueOf(z2);
        return ((Double) mapFeature2.accept(mapFeatureVisitor, objArr2)).doubleValue();
    }

    public IGeoPoint getLocation() {
        return this.f226wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou;
    }

    public void updateLocation(double d, double d2) {
        GeoPoint geoPoint;
        new GeoPoint(d, d2);
        this.f226wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou = geoPoint;
        clearGeometry();
    }

    public <T> T accept(MapFactory.MapFeatureVisitor<T> mapFeatureVisitor, Object... objArr) {
        return mapFeatureVisitor.visit((MapFactory.MapMarker) this, objArr);
    }

    /* access modifiers changed from: protected */
    public Geometry computeGeometry() {
        return GeometryUtil.createGeometry(this.f226wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou);
    }
}
