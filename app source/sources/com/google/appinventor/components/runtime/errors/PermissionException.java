package com.google.appinventor.components.runtime.errors;

public class PermissionException extends RuntimeException {
    private final String KaiqfKFioejChPrVk66Zh6PqE4I9OMHHEE3e5CIB0thmpooCrEnpoRacX1mk3Fuv;

    public PermissionException(String str) {
        this.KaiqfKFioejChPrVk66Zh6PqE4I9OMHHEE3e5CIB0thmpooCrEnpoRacX1mk3Fuv = str;
    }

    public String getPermissionNeeded() {
        return this.KaiqfKFioejChPrVk66Zh6PqE4I9OMHHEE3e5CIB0thmpooCrEnpoRacX1mk3Fuv;
    }

    public String getMessage() {
        StringBuilder sb;
        new StringBuilder("Unable to complete the operation because the user denied permission: ");
        return sb.append(this.KaiqfKFioejChPrVk66Zh6PqE4I9OMHHEE3e5CIB0thmpooCrEnpoRacX1mk3Fuv).toString();
    }
}
