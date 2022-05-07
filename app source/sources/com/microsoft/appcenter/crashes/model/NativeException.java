package com.microsoft.appcenter.crashes.model;

public class NativeException extends RuntimeException {
    private static final String CRASH_MESSAGE = "Native exception read from a minidump file";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NativeException() {
        super(CRASH_MESSAGE);
    }
}
