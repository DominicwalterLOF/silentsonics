package org.slf4j.helpers;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.slf4j.IMarkerFactory;
import org.slf4j.Marker;

public class BasicMarkerFactory implements IMarkerFactory {
    private final ConcurrentMap<String, Marker> markerMap;

    public BasicMarkerFactory() {
        ConcurrentMap<String, Marker> concurrentMap;
        new ConcurrentHashMap();
        this.markerMap = concurrentMap;
    }

    public Marker getMarker(String str) {
        Marker marker;
        Throwable th;
        String name = str;
        if (name == null) {
            Throwable th2 = th;
            new IllegalArgumentException("Marker name cannot be null");
            throw th2;
        }
        Marker marker2 = (Marker) this.markerMap.get(name);
        if (marker2 == null) {
            new BasicMarker(name);
            marker2 = marker;
            Marker oldMarker = this.markerMap.putIfAbsent(name, marker2);
            if (oldMarker != null) {
                marker2 = oldMarker;
            }
        }
        return marker2;
    }

    public boolean exists(String str) {
        String name = str;
        if (name == null) {
            return false;
        }
        return this.markerMap.containsKey(name);
    }

    public boolean detachMarker(String str) {
        String name = str;
        if (name == null) {
            return false;
        }
        return this.markerMap.remove(name) != null;
    }

    public Marker getDetachedMarker(String name) {
        Marker marker;
        new BasicMarker(name);
        return marker;
    }
}
