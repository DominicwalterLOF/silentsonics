package org.slf4j.event;

public enum Level {
    ;
    
    private int levelInt;
    private String levelStr;

    private Level(int i, String s) {
        String str = r9;
        int i2 = r10;
        this.levelInt = i;
        this.levelStr = s;
    }

    public int toInt() {
        return this.levelInt;
    }

    public String toString() {
        return this.levelStr;
    }
}
