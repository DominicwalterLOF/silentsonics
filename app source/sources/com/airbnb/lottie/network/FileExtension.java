package com.airbnb.lottie.network;

import com.airbnb.lottie.utils.Logger;

public enum FileExtension {
    ;
    
    public final String extension;

    private FileExtension(String extension2) {
        String str = r8;
        int i = r9;
        this.extension = extension2;
    }

    public String tempExtension() {
        StringBuilder sb;
        new StringBuilder();
        return sb.append(".temp").append(this.extension).toString();
    }

    public String toString() {
        return this.extension;
    }

    public static FileExtension forFile(String str) {
        StringBuilder sb;
        String filename = str;
        FileExtension[] values = values();
        int length = values.length;
        for (int i = 0; i < length; i++) {
            FileExtension e = values[i];
            if (filename.endsWith(e.extension)) {
                return e;
            }
        }
        new StringBuilder();
        Logger.warning(sb.append("Unable to find correct extension for ").append(filename).toString());
        return JSON;
    }
}
