package com.microsoft.appcenter;

public class CancellationException extends Exception {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CancellationException() {
        super("Request cancelled because Channel is disabled.");
    }
}
