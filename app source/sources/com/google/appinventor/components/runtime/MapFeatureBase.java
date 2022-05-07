package com.google.appinventor.components.runtime;

import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.runtime.util.GeometryUtil;
import com.google.appinventor.components.runtime.util.MapFactory;
import com.google.appinventor.components.runtime.util.YailList;
import org.locationtech.jts.geom.Geometry;
import org.osmdroid.util.GeoPoint;

@SimpleObject
public abstract class MapFeatureBase implements MapFactory.HasStroke, MapFactory.MapFeature {
    private MapFactory.MapFeatureVisitor<Double> B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T;

    /* renamed from: B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T  reason: collision with other field name */
    private GeoPoint f222B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = null;
    private int SHSZV5sTay8ykRHafXU624sH0bmI6VeYHAe3FtLV8LV4djzabBBIyQGaIvRsAwmk = -16777216;
    private int Ta6bjdQXoFeEb44hWQ7kTTTXw2rT1LHw6UX7lms7WU7H0AkpETH9D9EhELUfywQi = 1;
    private String YP4juQGK8ZTsNMOy2BKg810SeLJ3amlj2BQC8tc7uqP2LdhyRsu8lUHvdJ0v9u = "";
    protected MapFactory.MapFeatureContainer container = null;
    private boolean g16lHC6pRQoq0FWou0AzFVTKqyDojHRb8fcaYD4yg7tKEFm8ChlIf2uMkTa8F6nE = false;
    private String gti6bIqu0aXgALoDtkq1foMnPcdzXO0EAPAgw4lcaEF132GirFLns82VqwKc8x6R = "";
    private final MapFactory.MapFeatureVisitor<Double> hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private Geometry f223hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    protected Map map = null;
    private float tj0MDuMmBVyFcp8vwXpkfd0RnoyqL9aUR0zh2QG1qIbcD4cqzuxOkXiR3Ef5Sjag = 1.0f;
    private boolean visible = true;
    private boolean yTV71ZsokI1cWCTQFF82CwpCeeVC4RDXPNMp7sNxPH2Pf25hYzf1pp0KzV43yJiS = false;

    /* access modifiers changed from: protected */
    public abstract Geometry computeGeometry();

    protected MapFeatureBase(MapFactory.MapFeatureContainer mapFeatureContainer, MapFactory.MapFeatureVisitor<Double> mapFeatureVisitor) {
        MapFactory.MapFeatureVisitor<Double> mapFeatureVisitor2;
        MapFactory.MapFeatureContainer mapFeatureContainer2 = mapFeatureContainer;
        new MapFactory.MapFeatureVisitor<Double>(this) {
            private /* synthetic */ MapFeatureBase hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

            {
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r5;
            }

            public final /* synthetic */ Object visit(MapFactory.MapMarker mapMarker, Object[] objArr) {
                return Double.valueOf(GeometryUtil.distanceBetween(mapMarker, (GeoPoint) objArr[0]));
            }

            public final /* synthetic */ Object visit(MapFactory.MapRectangle mapRectangle, Object[] objArr) {
                MapFactory.MapRectangle mapRectangle2 = mapRectangle;
                Object[] objArr2 = objArr;
                if (((Boolean) objArr2[1]).booleanValue()) {
                    return Double.valueOf(GeometryUtil.distanceBetweenCentroids(mapRectangle2, (GeoPoint) objArr2[0]));
                }
                return Double.valueOf(GeometryUtil.distanceBetweenEdges(mapRectangle2, (GeoPoint) objArr2[0]));
            }

            public final /* synthetic */ Object visit(MapFactory.MapCircle mapCircle, Object[] objArr) {
                MapFactory.MapCircle mapCircle2 = mapCircle;
                Object[] objArr2 = objArr;
                if (((Boolean) objArr2[1]).booleanValue()) {
                    return Double.valueOf(GeometryUtil.distanceBetweenCentroids(mapCircle2, (GeoPoint) objArr2[0]));
                }
                return Double.valueOf(GeometryUtil.distanceBetweenEdges(mapCircle2, (GeoPoint) objArr2[0]));
            }

            public final /* synthetic */ Object visit(MapFactory.MapPolygon mapPolygon, Object[] objArr) {
                MapFactory.MapPolygon mapPolygon2 = mapPolygon;
                Object[] objArr2 = objArr;
                if (((Boolean) objArr2[1]).booleanValue()) {
                    return Double.valueOf(GeometryUtil.distanceBetweenCentroids(mapPolygon2, (GeoPoint) objArr2[0]));
                }
                return Double.valueOf(GeometryUtil.distanceBetweenEdges(mapPolygon2, (GeoPoint) objArr2[0]));
            }

            public final /* synthetic */ Object visit(MapFactory.MapLineString mapLineString, Object[] objArr) {
                MapFactory.MapLineString mapLineString2 = mapLineString;
                Object[] objArr2 = objArr;
                if (((Boolean) objArr2[1]).booleanValue()) {
                    return Double.valueOf(GeometryUtil.distanceBetweenCentroids(mapLineString2, (GeoPoint) objArr2[0]));
                }
                return Double.valueOf(GeometryUtil.distanceBetweenEdges(mapLineString2, (GeoPoint) objArr2[0]));
            }
        };
        this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = mapFeatureVisitor2;
        this.f223hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = null;
        this.container = mapFeatureContainer2;
        this.map = mapFeatureContainer2.getMap();
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = mapFeatureVisitor;
        Description("");
        Draggable(false);
        EnableInfobox(false);
        StrokeColor(-16777216);
        StrokeOpacity(1.0f);
        StrokeWidth(1);
        Title("");
        Visible(true);
    }

    public void setMap(MapFactory.MapFeatureContainer mapFeatureContainer) {
        Map map2 = mapFeatureContainer.getMap();
        this.map = map2;
    }

    public void removeFromMap() {
        this.map.getController().removeFeature(this);
    }

    @DesignerProperty(defaultValue = "True", editorType = "visibility")
    @SimpleProperty
    public void Visible(boolean z) {
        boolean z2 = z;
        if (this.visible != z2) {
            this.visible = z2;
            if (this.visible) {
                this.map.getController().showFeature(this);
            } else {
                this.map.getController().hideFeature(this);
            }
            this.map.getView().invalidate();
        }
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "Specifies whether the component should be visible on the screen. Value is true if the component is showing and false if hidden.")
    public boolean Visible() {
        return this.visible;
    }

    @DesignerProperty(defaultValue = "&HFF000000", editorType = "color")
    @SimpleProperty
    public void StrokeColor(int i) {
        this.SHSZV5sTay8ykRHafXU624sH0bmI6VeYHAe3FtLV8LV4djzabBBIyQGaIvRsAwmk = i;
        this.map.getController().updateFeatureStroke(this);
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "The paint color used to outline the map feature.")
    public int StrokeColor() {
        return this.SHSZV5sTay8ykRHafXU624sH0bmI6VeYHAe3FtLV8LV4djzabBBIyQGaIvRsAwmk;
    }

    @DesignerProperty(defaultValue = "1.0", editorType = "float")
    @SimpleProperty
    public void StrokeOpacity(float f) {
        float f2 = f;
        this.tj0MDuMmBVyFcp8vwXpkfd0RnoyqL9aUR0zh2QG1qIbcD4cqzuxOkXiR3Ef5Sjag = f2;
        this.SHSZV5sTay8ykRHafXU624sH0bmI6VeYHAe3FtLV8LV4djzabBBIyQGaIvRsAwmk = (this.SHSZV5sTay8ykRHafXU624sH0bmI6VeYHAe3FtLV8LV4djzabBBIyQGaIvRsAwmk & 16777215) | (Math.round(255.0f * f2) << 24);
        this.map.getController().updateFeatureStroke(this);
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "The opacity of the stroke used to outline the map feature.")
    public float StrokeOpacity() {
        return this.tj0MDuMmBVyFcp8vwXpkfd0RnoyqL9aUR0zh2QG1qIbcD4cqzuxOkXiR3Ef5Sjag;
    }

    @DesignerProperty(defaultValue = "1", editorType = "integer")
    @SimpleProperty
    public void StrokeWidth(int i) {
        this.Ta6bjdQXoFeEb44hWQ7kTTTXw2rT1LHw6UX7lms7WU7H0AkpETH9D9EhELUfywQi = i;
        this.map.getController().updateFeatureStroke(this);
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "The width of the stroke used to outline the map feature.")
    public int StrokeWidth() {
        return this.Ta6bjdQXoFeEb44hWQ7kTTTXw2rT1LHw6UX7lms7WU7H0AkpETH9D9EhELUfywQi;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty
    public void Draggable(boolean z) {
        this.yTV71ZsokI1cWCTQFF82CwpCeeVC4RDXPNMp7sNxPH2Pf25hYzf1pp0KzV43yJiS = z;
        this.map.getController().updateFeatureDraggable(this);
    }

    @SimpleProperty(description = "The Draggable property is used to set whether or not the user can drag the Marker by long-pressing and then dragging the marker to a new location.")
    public boolean Draggable() {
        return this.yTV71ZsokI1cWCTQFF82CwpCeeVC4RDXPNMp7sNxPH2Pf25hYzf1pp0KzV43yJiS;
    }

    @DesignerProperty
    @SimpleProperty
    public void Title(String str) {
        this.YP4juQGK8ZTsNMOy2BKg810SeLJ3amlj2BQC8tc7uqP2LdhyRsu8lUHvdJ0v9u = str;
        this.map.getController().updateFeatureText(this);
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "The title displayed in the info window that appears when the user clicks on the map feature.")
    public String Title() {
        return this.YP4juQGK8ZTsNMOy2BKg810SeLJ3amlj2BQC8tc7uqP2LdhyRsu8lUHvdJ0v9u;
    }

    @DesignerProperty
    @SimpleProperty
    public void Description(String str) {
        this.gti6bIqu0aXgALoDtkq1foMnPcdzXO0EAPAgw4lcaEF132GirFLns82VqwKc8x6R = str;
        this.map.getController().updateFeatureText(this);
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "The description displayed in the info window that appears when the user clicks on the map feature.")
    public String Description() {
        return this.gti6bIqu0aXgALoDtkq1foMnPcdzXO0EAPAgw4lcaEF132GirFLns82VqwKc8x6R;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty
    public void EnableInfobox(boolean z) {
        this.g16lHC6pRQoq0FWou0AzFVTKqyDojHRb8fcaYD4yg7tKEFm8ChlIf2uMkTa8F6nE = z;
        this.map.getController().updateFeatureText(this);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Enable or disable the infobox window display when the user taps the feature.")
    public boolean EnableInfobox() {
        return this.g16lHC6pRQoq0FWou0AzFVTKqyDojHRb8fcaYD4yg7tKEFm8ChlIf2uMkTa8F6nE;
    }

    @SimpleFunction(description = "Show the infobox for the feature. This will show the infobox even if {@link #EnableInfobox} is set to false.")
    public void ShowInfobox() {
        this.map.getController().showInfobox(this);
    }

    @SimpleFunction(description = "Hide the infobox if it is shown. If the infobox is not visible this function has no effect.")
    public void HideInfobox() {
        this.map.getController().hideInfobox(this);
    }

    public YailList Centroid() {
        return GeometryUtil.asYailList(getCentroid());
    }

    @SimpleFunction(description = "Compute the distance, in meters, between a map feature and a latitude, longitude point.")
    public double DistanceToPoint(double d, double d2, boolean z) {
        Object obj;
        MapFactory.MapFeatureVisitor mapFeatureVisitor = this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T;
        Object[] objArr = new Object[2];
        new GeoPoint(d, d2);
        objArr[0] = obj;
        Object[] objArr2 = objArr;
        objArr2[1] = Boolean.valueOf(z);
        return ((Double) accept(mapFeatureVisitor, objArr2)).doubleValue();
    }

    @SimpleFunction(description = "Compute the distance, in meters, between two map features.")
    public double DistanceToFeature(MapFactory.MapFeature mapFeature, boolean z) {
        MapFactory.MapFeature mapFeature2 = mapFeature;
        boolean z2 = z;
        if (mapFeature2 == null) {
            return -1.0d;
        }
        MapFactory.MapFeatureVisitor mapFeatureVisitor = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
        Object[] objArr = new Object[2];
        objArr[0] = this;
        Object[] objArr2 = objArr;
        objArr2[1] = Boolean.valueOf(z2);
        return ((Double) mapFeature2.accept(mapFeatureVisitor, objArr2)).doubleValue();
    }

    @SimpleEvent(description = "The user clicked on the feature.")
    public void Click() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "Click", new Object[0]);
        this.container.FeatureClick(this);
    }

    @SimpleEvent(description = "The user long-pressed on the feature. This event will only trigger if Draggable is false.")
    public void LongClick() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "LongClick", new Object[0]);
        this.container.FeatureLongClick(this);
    }

    @SimpleEvent(description = "The user started a drag operation.")
    public void StartDrag() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "StartDrag", new Object[0]);
        this.container.FeatureStartDrag(this);
    }

    @SimpleEvent(description = "The user dragged the map feature.")
    public void Drag() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "Drag", new Object[0]);
        this.container.FeatureDrag(this);
    }

    @SimpleEvent(description = "The user stopped a drag operation.")
    public void StopDrag() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "StopDrag", new Object[0]);
        this.container.FeatureStopDrag(this);
    }

    public HandlesEventDispatching getDispatchDelegate() {
        return this.map.getDispatchDelegate();
    }

    public final synchronized GeoPoint getCentroid() {
        GeoPoint geoPoint;
        synchronized (this) {
            if (this.f222B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T == null) {
                this.f222B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = GeometryUtil.jtsPointToGeoPoint(getGeometry().getCentroid());
            }
            geoPoint = this.f222B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T;
        }
        return geoPoint;
    }

    public final synchronized Geometry getGeometry() {
        Geometry geometry;
        synchronized (this) {
            if (this.f223hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME == null) {
                this.f223hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = computeGeometry();
            }
            geometry = this.f223hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
        }
        return geometry;
    }

    /* access modifiers changed from: protected */
    public final synchronized void clearGeometry() {
        synchronized (this) {
            this.f222B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = null;
            this.f223hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = null;
        }
    }
}
