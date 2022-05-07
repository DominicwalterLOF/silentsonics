package com.google.appinventor.components.runtime.util;

import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.Form;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BulkPermissionRequest {
    private Component B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T;
    private String EF39AXcqvcVSzkIDlhtBxpJQpYLF2tkAZ1Yh8aWSrM6HvDBggPKm9DsfgSWrxWia;
    private String[] LYVRHQlR5uMq9RmVQLgPQwQp4HVKuBDt7Jnpu0jTztYClgnk53NSpkUmjjPPbYn;

    public abstract void onGranted();

    protected BulkPermissionRequest(Component component, String str, String... strArr) {
        this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = component;
        this.EF39AXcqvcVSzkIDlhtBxpJQpYLF2tkAZ1Yh8aWSrM6HvDBggPKm9DsfgSWrxWia = str;
        this.LYVRHQlR5uMq9RmVQLgPQwQp4HVKuBDt7Jnpu0jTztYClgnk53NSpkUmjjPPbYn = strArr;
    }

    public void onDenied(String[] strArr) {
        String[] strArr2 = strArr;
        Form form = (Form) this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.getDispatchDelegate();
        int length = strArr2.length;
        for (int i = 0; i < length; i++) {
            form.dispatchPermissionDeniedEvent(this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T, this.EF39AXcqvcVSzkIDlhtBxpJQpYLF2tkAZ1Yh8aWSrM6HvDBggPKm9DsfgSWrxWia, strArr2[i]);
        }
    }

    public final List<String> getPermissions() {
        List<String> list;
        new ArrayList(this.LYVRHQlR5uMq9RmVQLgPQwQp4HVKuBDt7Jnpu0jTztYClgnk53NSpkUmjjPPbYn.length);
        List<String> list2 = list;
        List<String> list3 = list2;
        boolean addAll = Collections.addAll(list2, this.LYVRHQlR5uMq9RmVQLgPQwQp4HVKuBDt7Jnpu0jTztYClgnk53NSpkUmjjPPbYn);
        return list3;
    }
}
