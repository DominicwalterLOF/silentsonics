package org.slf4j;

import org.slf4j.helpers.BasicMarkerFactory;
import org.slf4j.helpers.Util;
import org.slf4j.impl.StaticMarkerBinder;

public class MarkerFactory {
    static IMarkerFactory MARKER_FACTORY;

    private MarkerFactory() {
    }

    private static IMarkerFactory bwCompatibleGetMarkerFactoryFromBinder() throws NoClassDefFoundError {
        try {
            return StaticMarkerBinder.getSingleton().getMarkerFactory();
        } catch (NoSuchMethodError e) {
            NoSuchMethodError noSuchMethodError = e;
            return StaticMarkerBinder.SINGLETON.getMarkerFactory();
        }
    }

    static {
        IMarkerFactory iMarkerFactory;
        try {
            MARKER_FACTORY = bwCompatibleGetMarkerFactoryFromBinder();
        } catch (NoClassDefFoundError e) {
            NoClassDefFoundError noClassDefFoundError = e;
            new BasicMarkerFactory();
            MARKER_FACTORY = iMarkerFactory;
        } catch (Exception e2) {
            Util.report("Unexpected failure while binding MarkerFactory", e2);
        }
    }

    public static Marker getMarker(String name) {
        return MARKER_FACTORY.getMarker(name);
    }

    public static Marker getDetachedMarker(String name) {
        return MARKER_FACTORY.getDetachedMarker(name);
    }

    public static IMarkerFactory getIMarkerFactory() {
        return MARKER_FACTORY;
    }
}
