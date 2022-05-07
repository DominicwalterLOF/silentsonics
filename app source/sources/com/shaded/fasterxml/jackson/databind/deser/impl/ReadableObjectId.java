package com.shaded.fasterxml.jackson.databind.deser.impl;

import java.io.IOException;

public class ReadableObjectId {
    public final Object id;
    public Object item;

    public ReadableObjectId(Object obj) {
        this.id = obj;
    }

    public void bindItem(Object obj) throws IOException {
        Throwable th;
        StringBuilder sb;
        Object obj2 = obj;
        if (this.item != null) {
            Throwable th2 = th;
            new StringBuilder();
            new IllegalStateException(sb.append("Already had POJO for id (").append(this.id.getClass().getName()).append(") [").append(this.id).append("]").toString());
            throw th2;
        }
        this.item = obj2;
    }
}
