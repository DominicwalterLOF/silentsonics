package com.google.appinventor.components.runtime;

import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@DesignerComponent(category = ComponentCategory.SENSORS, description = "Non-visible component providing location information, including longitude, latitude, altitude (if supported by the device), speed (if supported by the device), and address.  This can also perform \"geocoding\", converting a given address (not necessarily the current one) to a latitude (with the <code>LatitudeFromAddress</code> method) and a longitude (with the <code>LongitudeFromAddress</code> method).</p>\n<p>In order to function, the component must have its <code>Enabled</code> property set to True, and the device must have location sensing enabled through wireless networks or GPS satellites (if outdoors).</p>\nLocation information might not be immediately available when an app starts.  You'll have to wait a short time for a location provider to be found and used, or wait for the OnLocationChanged event", iconName = "images/locationSensor.png", nonVisible = true, version = 3)
@SimpleObject
@UsesPermissions({"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_MOCK_LOCATION", "android.permission.ACCESS_LOCATION_EXTRA_COMMANDS"})
public class LocationSensor extends AndroidNonvisibleComponent implements Component, Deleteable, OnResumeListener, OnStopListener {
    /* access modifiers changed from: private */
    public static final String LOG_TAG = LocationSensor.class.getSimpleName();
    public static final int UNKNOWN_VALUE = 0;
    private int ATk09PTFIUWb1DqQXgMu0NmsbfZK89sTID9U9fCgIZdoNsjPWnKT9boGyGQNlMd;
    private double B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T;
    private List<String> F0SK4gPRNmAI2jCyU6DpJpRxlfo5Y8j9ZujjeLuDeDzReJBeSNN2RZtCnkXv1dho;
    private boolean HSgmARz5w7nma58XTyePpkN53AMPZCg0W3RVNCiWbSBR7PJtyMriHlkRP1TBmIZy;
    private double LYVRHQlR5uMq9RmVQLgPQwQp4HVKuBDt7Jnpu0jTztYClgnk53NSpkUmjjPPbYn;
    private final Handler androidUIHandler;
    /* access modifiers changed from: private */
    public boolean enabled;
    private int f9MsIiC6MxciaFVJmtpdDaPCPu1tdZDTYoHbgfSwKXBhLXF2LgZTKbRmVlZ1kb0Z;
    private Form form;
    private final Handler handler;
    private boolean havePermission;
    private double hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private final Criteria f183hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private Geocoder f184hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private Location f185hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private final LocationManager f186hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private LocationProvider f187hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private a f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    private boolean initialized;
    private boolean oDikMCstR6tlR2dTNi9SmHhjXnOW8gvVc7RVCpamOJDxjRqCmBMqmRVoMYhtpjS;
    private float speed;
    private boolean tOvM9eIUWszKzvISo4zKh7g8MyRaLHuNLQ5NdigAhriBDKCBmghUBEUlM2ZIvV1J;
    private final Set<LocationSensorListener> wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou;
    private boolean x3f9w7ebWg4JdbY2pEu0Z0lXjvABueY447WcywG8LgLVE2M0xoLkgBxoCJuK6Oc;
    private String z89WSVwZ7PB2CmtTjCz6wAa186XxEwXZ6USChsRUkmrmINCnliZwpzt9cagYiYvX;

    public interface LocationSensorListener extends LocationListener {
        void onDistanceIntervalChanged(int i);

        void onTimeIntervalChanged(int i);

        void setSource(LocationSensor locationSensor);
    }

    static /* synthetic */ double B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(LocationSensor locationSensor, double d) {
        double d2 = d;
        double d3 = d2;
        locationSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = d3;
        return d2;
    }

    static /* synthetic */ double hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(LocationSensor locationSensor, double d) {
        double d2 = d;
        double d3 = d2;
        locationSensor.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = d3;
        return d2;
    }

    static /* synthetic */ float hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(LocationSensor locationSensor, float f) {
        float f2 = f;
        float f3 = f2;
        locationSensor.speed = f3;
        return f2;
    }

    static /* synthetic */ Location hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(LocationSensor locationSensor, Location location) {
        Location location2 = location;
        Location location3 = location2;
        locationSensor.f185hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = location3;
        return location2;
    }

    static /* synthetic */ double wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou(LocationSensor locationSensor, double d) {
        double d2 = d;
        double d3 = d2;
        locationSensor.LYVRHQlR5uMq9RmVQLgPQwQp4HVKuBDt7Jnpu0jTztYClgnk53NSpkUmjjPPbYn = d3;
        return d2;
    }

    class a implements LocationListener {
        final /* synthetic */ LocationSensor hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

        private a(LocationSensor locationSensor) {
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = locationSensor;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        /* synthetic */ a(LocationSensor locationSensor, byte b) {
            this(locationSensor);
            byte b2 = b;
        }

        public final void onLocationChanged(Location location) {
            Runnable runnable;
            Location location2 = location;
            Location hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2 = LocationSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, location2);
            double hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME3 = LocationSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, location2.getLongitude());
            double B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = LocationSensor.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, location2.getLatitude());
            float hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME4 = LocationSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, location2.getSpeed());
            if (location2.hasAltitude()) {
                boolean hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME5 = LocationSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
                double wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou = LocationSensor.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, location2.getAltitude());
            }
            if (LocationSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME) != 0.0d || LocationSensor.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME) != 0.0d) {
                boolean B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T2 = LocationSensor.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
                double B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T3 = LocationSensor.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
                double hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME6 = LocationSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
                double wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou2 = LocationSensor.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
                final double d = B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T3;
                final double d2 = hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME6;
                final double d3 = wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou2;
                final float hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME7 = LocationSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
                final Location location3 = location2;
                new Runnable(this) {

                    /* renamed from: B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T  reason: collision with other field name */
                    private /* synthetic */ a f189B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T;

                    {
                        this.f189B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = r15;
                    }

                    public final void run() {
                        this.f189B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.LocationChanged(d, d2, d3, hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME7);
                        for (LocationSensorListener onLocationChanged : LocationSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.f189B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME)) {
                            onLocationChanged.onLocationChanged(location3);
                        }
                    }
                };
                boolean post = LocationSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME).post(runnable);
            }
        }

        public final void onProviderDisabled(String str) {
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.StatusChanged(str, "Disabled");
            LocationSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
            if (LocationSensor.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME)) {
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.RefreshProvider("onProviderDisabled");
            }
        }

        public final void onProviderEnabled(String str) {
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.StatusChanged(str, "Enabled");
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.RefreshProvider("onProviderEnabled");
        }

        public final void onStatusChanged(String str, int i, Bundle bundle) {
            String str2 = str;
            Bundle bundle2 = bundle;
            switch (i) {
                case 0:
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.StatusChanged(str2, "OUT_OF_SERVICE");
                    if (str2.equals(LocationSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME))) {
                        LocationSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
                        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.RefreshProvider("onStatusChanged");
                        return;
                    }
                    return;
                case 1:
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.StatusChanged(str2, "TEMPORARILY_UNAVAILABLE");
                    return;
                case 2:
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.StatusChanged(str2, "AVAILABLE");
                    if (!str2.equals(LocationSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME)) && !LocationSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME).contains(str2)) {
                        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.RefreshProvider("onStatusChanged");
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LocationSensor(ComponentContainer componentContainer) {
        this(componentContainer, true);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LocationSensor(com.google.appinventor.components.runtime.ComponentContainer r10, boolean r11) {
        /*
            r9 = this;
            r0 = r9
            r1 = r10
            r2 = r11
            r3 = r0
            r4 = r1
            com.google.appinventor.components.runtime.Form r4 = r4.$form()
            r3.<init>(r4)
            r3 = r0
            java.util.HashSet r4 = new java.util.HashSet
            r8 = r4
            r4 = r8
            r5 = r8
            r5.<init>()
            r3.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou = r4
            r3 = r0
            r4 = 0
            r3.tOvM9eIUWszKzvISo4zKh7g8MyRaLHuNLQ5NdigAhriBDKCBmghUBEUlM2ZIvV1J = r4
            r3 = r0
            r4 = 0
            r3.initialized = r4
            r3 = r0
            r4 = 0
            r3.oDikMCstR6tlR2dTNi9SmHhjXnOW8gvVc7RVCpamOJDxjRqCmBMqmRVoMYhtpjS = r4
            r3 = r0
            r4 = 0
            r3.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = r4
            r3 = r0
            r4 = 0
            r3.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r4
            r3 = r0
            r4 = 0
            r3.LYVRHQlR5uMq9RmVQLgPQwQp4HVKuBDt7Jnpu0jTztYClgnk53NSpkUmjjPPbYn = r4
            r3 = r0
            r4 = 0
            r3.speed = r4
            r3 = r0
            r4 = 0
            r3.HSgmARz5w7nma58XTyePpkN53AMPZCg0W3RVNCiWbSBR7PJtyMriHlkRP1TBmIZy = r4
            r3 = r0
            r4 = 0
            r3.x3f9w7ebWg4JdbY2pEu0Z0lXjvABueY447WcywG8LgLVE2M0xoLkgBxoCJuK6Oc = r4
            r3 = r0
            android.os.Handler r4 = new android.os.Handler
            r8 = r4
            r4 = r8
            r5 = r8
            r5.<init>()
            r3.androidUIHandler = r4
            r3 = r0
            r4 = 1
            r3.enabled = r4
            r3 = r0
            r4 = 0
            r3.havePermission = r4
            r3 = r0
            r4 = r1
            com.google.appinventor.components.runtime.Form r4 = r4.$form()
            r3.form = r4
            r3 = r0
            r4 = r2
            r3.enabled = r4
            r3 = r0
            android.os.Handler r4 = new android.os.Handler
            r8 = r4
            r4 = r8
            r5 = r8
            r5.<init>()
            r3.handler = r4
            r3 = r0
            com.google.appinventor.components.runtime.Form r3 = r3.form
            r4 = r0
            r3.registerForOnResume(r4)
            r3 = r0
            com.google.appinventor.components.runtime.Form r3 = r3.form
            r4 = r0
            r3.registerForOnStop(r4)
            r3 = r0
            r4 = 60000(0xea60, float:8.4078E-41)
            r3.ATk09PTFIUWb1DqQXgMu0NmsbfZK89sTID9U9fCgIZdoNsjPWnKT9boGyGQNlMd = r4
            r3 = r0
            r4 = 5
            r3.f9MsIiC6MxciaFVJmtpdDaPCPu1tdZDTYoHbgfSwKXBhLXF2LgZTKbRmVlZ1kb0Z = r4
            r3 = r1
            android.app.Activity r3 = r3.$context()
            r1 = r3
            r3 = r0
            android.location.Geocoder r4 = new android.location.Geocoder
            r8 = r4
            r4 = r8
            r5 = r8
            r6 = r1
            r5.<init>(r6)
            r3.f184hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r4
            r3 = r0
            r4 = r1
            java.lang.String r5 = "location"
            java.lang.Object r4 = r4.getSystemService(r5)
            android.location.LocationManager r4 = (android.location.LocationManager) r4
            r3.f186hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r4
            r3 = r0
            android.location.Criteria r4 = new android.location.Criteria
            r8 = r4
            r4 = r8
            r5 = r8
            r5.<init>()
            r3.f183hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r4
            r3 = r0
            com.google.appinventor.components.runtime.LocationSensor$a r4 = new com.google.appinventor.components.runtime.LocationSensor$a
            r8 = r4
            r4 = r8
            r5 = r8
            r6 = r0
            r7 = 0
            r5.<init>(r6, r7)
            r3.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r4
            r3 = r0
            java.util.ArrayList r4 = new java.util.ArrayList
            r8 = r4
            r4 = r8
            r5 = r8
            r5.<init>()
            r3.F0SK4gPRNmAI2jCyU6DpJpRxlfo5Y8j9ZujjeLuDeDzReJBeSNN2RZtCnkXv1dho = r4
            r3 = r0
            r4 = r2
            r3.Enabled(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.LocationSensor.<init>(com.google.appinventor.components.runtime.ComponentContainer, boolean):void");
    }

    public void Initialize() {
        this.initialized = true;
        Enabled(this.enabled);
    }

    @SimpleEvent
    public void LocationChanged(double d, double d2, double d3, float f) {
        Object[] objArr = new Object[4];
        objArr[0] = Double.valueOf(d);
        Object[] objArr2 = objArr;
        objArr2[1] = Double.valueOf(d2);
        Object[] objArr3 = objArr2;
        objArr3[2] = Double.valueOf(d3);
        Object[] objArr4 = objArr3;
        objArr4[3] = Float.valueOf(f);
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "LocationChanged", objArr4);
    }

    @SimpleEvent
    public void StatusChanged(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        if (this.enabled) {
            Object[] objArr = new Object[2];
            objArr[0] = str3;
            Object[] objArr2 = objArr;
            objArr2[1] = str4;
            boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "StatusChanged", objArr2);
        }
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public String ProviderName() {
        if (this.z89WSVwZ7PB2CmtTjCz6wAa186XxEwXZ6USChsRUkmrmINCnliZwpzt9cagYiYvX == null) {
            return "NO PROVIDER";
        }
        return this.z89WSVwZ7PB2CmtTjCz6wAa186XxEwXZ6USChsRUkmrmINCnliZwpzt9cagYiYvX;
    }

    @SimpleProperty
    public void ProviderName(String str) {
        String str2 = str;
        this.z89WSVwZ7PB2CmtTjCz6wAa186XxEwXZ6USChsRUkmrmINCnliZwpzt9cagYiYvX = str2;
        if (B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(str2) || !hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(str2)) {
            RefreshProvider("ProviderName");
        }
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public boolean ProviderLocked() {
        return this.tOvM9eIUWszKzvISo4zKh7g8MyRaLHuNLQ5NdigAhriBDKCBmghUBEUlM2ZIvV1J;
    }

    @SimpleProperty
    public void ProviderLocked(boolean z) {
        boolean z2 = z;
        this.tOvM9eIUWszKzvISo4zKh7g8MyRaLHuNLQ5NdigAhriBDKCBmghUBEUlM2ZIvV1J = z2;
    }

    @DesignerProperty(defaultValue = "60000", editorType = "sensor_time_interval")
    @SimpleProperty
    public void TimeInterval(int i) {
        int i2 = i;
        if (i2 >= 0 && i2 <= 1000000) {
            this.ATk09PTFIUWb1DqQXgMu0NmsbfZK89sTID9U9fCgIZdoNsjPWnKT9boGyGQNlMd = i2;
            if (this.enabled) {
                RefreshProvider("TimeInterval");
            }
            for (LocationSensorListener onTimeIntervalChanged : this.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou) {
                onTimeIntervalChanged.onTimeIntervalChanged(this.ATk09PTFIUWb1DqQXgMu0NmsbfZK89sTID9U9fCgIZdoNsjPWnKT9boGyGQNlMd);
            }
        }
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Determines the minimum time interval, in milliseconds, that the sensor will try to use for sending out location updates. However, location updates will only be received when the location of the phone actually changes, and use of the specified time interval is not guaranteed. For example, if 1000 is used as the time interval, location updates will never be fired sooner than 1000ms, but they may be fired anytime after.")
    public int TimeInterval() {
        return this.ATk09PTFIUWb1DqQXgMu0NmsbfZK89sTID9U9fCgIZdoNsjPWnKT9boGyGQNlMd;
    }

    @DesignerProperty(defaultValue = "5", editorType = "sensor_dist_interval")
    @SimpleProperty
    public void DistanceInterval(int i) {
        int i2 = i;
        if (i2 >= 0 && i2 <= 1000) {
            this.f9MsIiC6MxciaFVJmtpdDaPCPu1tdZDTYoHbgfSwKXBhLXF2LgZTKbRmVlZ1kb0Z = i2;
            if (this.enabled) {
                RefreshProvider("DistanceInterval");
            }
            for (LocationSensorListener onDistanceIntervalChanged : this.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou) {
                onDistanceIntervalChanged.onDistanceIntervalChanged(this.f9MsIiC6MxciaFVJmtpdDaPCPu1tdZDTYoHbgfSwKXBhLXF2LgZTKbRmVlZ1kb0Z);
            }
        }
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Determines the minimum distance interval, in meters, that the sensor will try to use for sending out location updates. For example, if this is set to 5, then the sensor will fire a LocationChanged event only after 5 meters have been traversed. However, the sensor does not guarantee that an update will be received at exactly the distance interval. It may take more than 5 meters to fire an event, for instance.")
    public int DistanceInterval() {
        return this.f9MsIiC6MxciaFVJmtpdDaPCPu1tdZDTYoHbgfSwKXBhLXF2LgZTKbRmVlZ1kb0Z;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public boolean HasLongitudeLatitude() {
        return this.HSgmARz5w7nma58XTyePpkN53AMPZCg0W3RVNCiWbSBR7PJtyMriHlkRP1TBmIZy && this.enabled;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public boolean HasAltitude() {
        return this.x3f9w7ebWg4JdbY2pEu0Z0lXjvABueY447WcywG8LgLVE2M0xoLkgBxoCJuK6Oc && this.enabled;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public boolean HasAccuracy() {
        return Accuracy() != 0.0d && this.enabled;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public double Longitude() {
        return this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public double Latitude() {
        return this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public double Altitude() {
        return this.LYVRHQlR5uMq9RmVQLgPQwQp4HVKuBDt7Jnpu0jTztYClgnk53NSpkUmjjPPbYn;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public double Accuracy() {
        if (this.f185hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME != null && this.f185hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.hasAccuracy()) {
            return (double) this.f185hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getAccuracy();
        }
        if (this.f187hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME != null) {
            return (double) this.f187hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getAccuracy();
        }
        return 0.0d;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public boolean Enabled() {
        return this.enabled;
    }

    @DesignerProperty(defaultValue = "True", editorType = "boolean")
    @SimpleProperty
    public void Enabled(boolean z) {
        Runnable runnable;
        boolean z2 = z;
        if (!this.havePermission) {
            final boolean z3 = z2;
            new Runnable(this) {
                final /* synthetic */ LocationSensor hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

                {
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r6;
                }

                public final void run() {
                    PermissionResultHandler permissionResultHandler;
                    new PermissionResultHandler(this) {
                        private /* synthetic */ AnonymousClass1 hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

                        {
                            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r5;
                        }

                        public final void HandlePermissionResponse(String str, boolean z) {
                            String str2 = str;
                            boolean z2 = z;
                            if (z2) {
                                boolean hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2 = LocationSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, true);
                                LocationSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, z3);
                                int d = Log.d(LocationSensor.LOG_TAG, "Permission Granted");
                                return;
                            }
                            boolean hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME3 = LocationSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, false);
                            LocationSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, z2);
                            LocationSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME).dispatchPermissionDeniedEvent((Component) this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, "Enabled", "android.permission.ACCESS_FINE_LOCATION");
                        }
                    };
                    LocationSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME).askPermission("android.permission.ACCESS_FINE_LOCATION", permissionResultHandler);
                }
            };
            boolean post = this.androidUIHandler.post(runnable);
            return;
        }
        wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou(z2);
    }

    private void wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou(boolean z) {
        boolean z2 = z;
        this.enabled = z2;
        if (this.initialized) {
            if (!z2) {
                stopListening();
            } else {
                RefreshProvider("Enabled");
            }
        }
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public String CurrentAddress() {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        if ((this.HSgmARz5w7nma58XTyePpkN53AMPZCg0W3RVNCiWbSBR7PJtyMriHlkRP1TBmIZy && this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME <= 90.0d && this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME >= -90.0d && this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T <= 180.0d) || this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T >= -180.0d) {
            try {
                List<Address> fromLocation = this.f184hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getFromLocation(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T, 1);
                List<Address> list = fromLocation;
                if (fromLocation != null && list.size() == 1) {
                    Address address = list.get(0);
                    Address address2 = address;
                    if (address != null) {
                        new StringBuilder();
                        StringBuilder sb4 = sb3;
                        for (int i = 0; i <= address2.getMaxAddressLineIndex(); i++) {
                            StringBuilder append = sb4.append(address2.getAddressLine(i));
                            StringBuilder append2 = sb4.append("\n");
                        }
                        return sb4.toString();
                    }
                }
            } catch (Exception e) {
                Exception exc = e;
                Exception exc2 = exc;
                if ((exc instanceof IllegalArgumentException) || (exc2 instanceof IOException) || (exc2 instanceof IndexOutOfBoundsException)) {
                    String str = LOG_TAG;
                    new StringBuilder("Exception thrown by getting current address ");
                    int e2 = Log.e(str, sb.append(exc2.getMessage()).toString());
                } else {
                    String str2 = LOG_TAG;
                    new StringBuilder("Unexpected exception thrown by getting current address ");
                    int e3 = Log.e(str2, sb2.append(exc2.getMessage()).toString());
                }
            }
        }
        return "No address available";
    }

    @SimpleFunction(description = "Derives latitude of given address")
    public double LatitudeFromAddress(String str) {
        StringBuilder sb;
        Throwable th;
        String str2 = str;
        try {
            List<Address> fromLocationName = this.f184hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getFromLocationName(str2, 1);
            String str3 = LOG_TAG;
            new StringBuilder("latitude addressObjs size is ");
            int i = Log.i(str3, sb.append(fromLocationName.size()).append(" for ").append(str2).toString());
            if (fromLocationName != null && fromLocationName.size() != 0) {
                return fromLocationName.get(0).getLatitude();
            }
            Throwable th2 = th;
            new IOException("");
            throw th2;
        } catch (Exception e) {
            this.form.dispatchErrorOccurredEvent(this, "LatitudeFromAddress", 101, str2);
            return 0.0d;
        }
    }

    @SimpleFunction(description = "Derives longitude of given address")
    public double LongitudeFromAddress(String str) {
        StringBuilder sb;
        Throwable th;
        String str2 = str;
        try {
            List<Address> fromLocationName = this.f184hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getFromLocationName(str2, 1);
            String str3 = LOG_TAG;
            new StringBuilder("longitude addressObjs size is ");
            int i = Log.i(str3, sb.append(fromLocationName.size()).append(" for ").append(str2).toString());
            if (fromLocationName != null && fromLocationName.size() != 0) {
                return fromLocationName.get(0).getLongitude();
            }
            Throwable th2 = th;
            new IOException("");
            throw th2;
        } catch (Exception e) {
            this.form.dispatchErrorOccurredEvent(this, "LongitudeFromAddress", 102, str2);
            return 0.0d;
        }
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public List<String> AvailableProviders() {
        return this.F0SK4gPRNmAI2jCyU6DpJpRxlfo5Y8j9ZujjeLuDeDzReJBeSNN2RZtCnkXv1dho;
    }

    public void RefreshProvider(String str) {
        Runnable runnable;
        String str2 = str;
        if (this.initialized) {
            stopListening();
            if (!this.havePermission) {
                final String str3 = str2;
                new Runnable(this) {
                    private /* synthetic */ LocationSensor hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

                    {
                        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r7;
                    }

                    public final void run() {
                        PermissionResultHandler permissionResultHandler;
                        new PermissionResultHandler(this) {
                            private /* synthetic */ AnonymousClass2 hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

                            {
                                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r5;
                            }

                            public final void HandlePermissionResponse(String str, boolean z) {
                                String str2 = str;
                                if (z) {
                                    boolean hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2 = LocationSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this, true);
                                    this.RefreshProvider(str3);
                                    int d = Log.d(LocationSensor.LOG_TAG, "Permission Granted");
                                    return;
                                }
                                boolean hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME3 = LocationSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this, false);
                                boolean vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq = this.enabled = false;
                                LocationSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this).dispatchPermissionDeniedEvent((Component) this, str3, "android.permission.ACCESS_FINE_LOCATION");
                            }
                        };
                        LocationSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this).askPermission("android.permission.ACCESS_FINE_LOCATION", permissionResultHandler);
                    }
                };
                boolean post = this.androidUIHandler.post(runnable);
            }
            if (!this.tOvM9eIUWszKzvISo4zKh7g8MyRaLHuNLQ5NdigAhriBDKCBmghUBEUlM2ZIvV1J || B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(this.z89WSVwZ7PB2CmtTjCz6wAa186XxEwXZ6USChsRUkmrmINCnliZwpzt9cagYiYvX)) {
                this.F0SK4gPRNmAI2jCyU6DpJpRxlfo5Y8j9ZujjeLuDeDzReJBeSNN2RZtCnkXv1dho = this.f186hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getProviders(true);
                String bestProvider = this.f186hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getBestProvider(this.f183hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, true);
                String str4 = bestProvider;
                if (bestProvider != null && !str4.equals(this.F0SK4gPRNmAI2jCyU6DpJpRxlfo5Y8j9ZujjeLuDeDzReJBeSNN2RZtCnkXv1dho.get(0))) {
                    this.F0SK4gPRNmAI2jCyU6DpJpRxlfo5Y8j9ZujjeLuDeDzReJBeSNN2RZtCnkXv1dho.add(0, str4);
                }
                for (String next : this.F0SK4gPRNmAI2jCyU6DpJpRxlfo5Y8j9ZujjeLuDeDzReJBeSNN2RZtCnkXv1dho) {
                    this.oDikMCstR6tlR2dTNi9SmHhjXnOW8gvVc7RVCpamOJDxjRqCmBMqmRVoMYhtpjS = hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(next);
                    if (this.oDikMCstR6tlR2dTNi9SmHhjXnOW8gvVc7RVCpamOJDxjRqCmBMqmRVoMYhtpjS) {
                        if (!this.tOvM9eIUWszKzvISo4zKh7g8MyRaLHuNLQ5NdigAhriBDKCBmghUBEUlM2ZIvV1J) {
                            this.z89WSVwZ7PB2CmtTjCz6wAa186XxEwXZ6USChsRUkmrmINCnliZwpzt9cagYiYvX = next;
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            this.oDikMCstR6tlR2dTNi9SmHhjXnOW8gvVc7RVCpamOJDxjRqCmBMqmRVoMYhtpjS = hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.z89WSVwZ7PB2CmtTjCz6wAa186XxEwXZ6USChsRUkmrmINCnliZwpzt9cagYiYvX);
        }
    }

    private boolean hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(String str) {
        StringBuilder sb;
        String str2 = str;
        this.z89WSVwZ7PB2CmtTjCz6wAa186XxEwXZ6USChsRUkmrmINCnliZwpzt9cagYiYvX = str2;
        LocationProvider provider = this.f186hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getProvider(str2);
        LocationProvider locationProvider = provider;
        if (provider == null) {
            String str3 = LOG_TAG;
            new StringBuilder("getProvider(");
            int d = Log.d(str3, sb.append(str2).append(") returned null").toString());
            return false;
        }
        stopListening();
        this.f187hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = locationProvider;
        this.f186hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.requestLocationUpdates(str2, (long) this.ATk09PTFIUWb1DqQXgMu0NmsbfZK89sTID9U9fCgIZdoNsjPWnKT9boGyGQNlMd, (float) this.f9MsIiC6MxciaFVJmtpdDaPCPu1tdZDTYoHbgfSwKXBhLXF2LgZTKbRmVlZ1kb0Z, this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
        this.oDikMCstR6tlR2dTNi9SmHhjXnOW8gvVc7RVCpamOJDxjRqCmBMqmRVoMYhtpjS = true;
        return true;
    }

    private void stopListening() {
        if (this.oDikMCstR6tlR2dTNi9SmHhjXnOW8gvVc7RVCpamOJDxjRqCmBMqmRVoMYhtpjS) {
            this.f186hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.removeUpdates(this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
            this.f187hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = null;
            this.oDikMCstR6tlR2dTNi9SmHhjXnOW8gvVc7RVCpamOJDxjRqCmBMqmRVoMYhtpjS = false;
        }
    }

    public void onResume() {
        if (this.enabled) {
            RefreshProvider("onResume");
        }
    }

    public void onStop() {
        stopListening();
    }

    public void onDelete() {
        stopListening();
    }

    public void addListener(LocationSensorListener locationSensorListener) {
        LocationSensorListener locationSensorListener2 = locationSensorListener;
        locationSensorListener2.setSource(this);
        boolean add = this.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou.add(locationSensorListener2);
    }

    public void removeListener(LocationSensorListener locationSensorListener) {
        LocationSensorListener locationSensorListener2 = locationSensorListener;
        boolean remove = this.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou.remove(locationSensorListener2);
        locationSensorListener2.setSource((LocationSensor) null);
    }

    private static boolean B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(String str) {
        String str2 = str;
        return str2 == null || str2.length() == 0;
    }
}
