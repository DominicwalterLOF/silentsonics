package com.airbnb.lottie.model;

public class Marker {
    private static String CARRIAGE_RETURN = "\r";
    public final float durationFrames;
    private final String name;
    public final float startFrame;

    public Marker(String name2, float startFrame2, float durationFrames2) {
        this.name = name2;
        this.durationFrames = durationFrames2;
        this.startFrame = startFrame2;
    }

    public boolean matchesName(String str) {
        String name2 = str;
        if (this.name.equalsIgnoreCase(name2)) {
            return true;
        }
        if (!this.name.endsWith(CARRIAGE_RETURN) || !this.name.substring(0, this.name.length() - 1).equalsIgnoreCase(name2)) {
            return false;
        }
        return true;
    }
}
