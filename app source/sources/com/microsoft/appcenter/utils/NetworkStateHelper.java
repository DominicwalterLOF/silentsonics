package com.microsoft.appcenter.utils;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.VisibleForTesting;
import java.io.Closeable;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

public class NetworkStateHelper implements Closeable {
    @SuppressLint({"StaticFieldLeak"})
    private static NetworkStateHelper sSharedInstance;
    private final AtomicBoolean mConnected;
    private final ConnectivityManager mConnectivityManager;
    private ConnectivityReceiver mConnectivityReceiver;
    private final Context mContext;
    private final Set<Listener> mListeners;
    private ConnectivityManager.NetworkCallback mNetworkCallback;

    public interface Listener {
        void onNetworkStateUpdated(boolean z);
    }

    @VisibleForTesting
    public NetworkStateHelper(Context context) {
        Set<Listener> set;
        AtomicBoolean atomicBoolean;
        Context context2 = context;
        new CopyOnWriteArraySet();
        this.mListeners = set;
        new AtomicBoolean();
        this.mConnected = atomicBoolean;
        this.mContext = context2.getApplicationContext();
        this.mConnectivityManager = (ConnectivityManager) context2.getSystemService("connectivity");
        reopen();
    }

    public static synchronized void unsetInstance() {
        synchronized (NetworkStateHelper.class) {
            sSharedInstance = null;
        }
    }

    public static synchronized NetworkStateHelper getSharedInstance(Context context) {
        NetworkStateHelper networkStateHelper;
        NetworkStateHelper networkStateHelper2;
        Context context2 = context;
        synchronized (NetworkStateHelper.class) {
            if (sSharedInstance == null) {
                new NetworkStateHelper(context2);
                sSharedInstance = networkStateHelper2;
            }
            networkStateHelper = sSharedInstance;
        }
        return networkStateHelper;
    }

    public void reopen() {
        ConnectivityReceiver connectivityReceiver;
        NetworkRequest.Builder builder;
        ConnectivityManager.NetworkCallback networkCallback;
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                new NetworkRequest.Builder();
                NetworkRequest.Builder request = builder;
                NetworkRequest.Builder addCapability = request.addCapability(12);
                new ConnectivityManager.NetworkCallback(this) {
                    final /* synthetic */ NetworkStateHelper this$0;

                    {
                        this.this$0 = this$0;
                    }

                    public void onAvailable(Network network) {
                        this.this$0.onNetworkAvailable(network);
                    }

                    public void onLost(Network network) {
                        this.this$0.onNetworkLost(network);
                    }
                };
                this.mNetworkCallback = networkCallback;
                this.mConnectivityManager.registerNetworkCallback(request.build(), this.mNetworkCallback);
                return;
            }
            new ConnectivityReceiver(this, (AnonymousClass1) null);
            this.mConnectivityReceiver = connectivityReceiver;
            Intent registerReceiver = this.mContext.registerReceiver(this.mConnectivityReceiver, getOldIntentFilter());
            handleNetworkStateUpdate();
        } catch (RuntimeException e) {
            AppCenterLog.error("AppCenter", "Cannot access network state information.", e);
            this.mConnected.set(true);
        }
    }

    @NonNull
    private IntentFilter getOldIntentFilter() {
        IntentFilter intentFilter;
        new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        return intentFilter;
    }

    public boolean isNetworkConnected() {
        return this.mConnected.get() || isAnyNetworkConnected();
    }

    private boolean isAnyNetworkConnected() {
        if (Build.VERSION.SDK_INT >= 21) {
            Network[] networks = this.mConnectivityManager.getAllNetworks();
            if (networks == null) {
                return false;
            }
            Network[] networkArr = networks;
            int length = networkArr.length;
            for (int i = 0; i < length; i++) {
                NetworkInfo info = this.mConnectivityManager.getNetworkInfo(networkArr[i]);
                if (info != null && info.isConnected()) {
                    return true;
                }
            }
        } else {
            NetworkInfo[] networks2 = this.mConnectivityManager.getAllNetworkInfo();
            if (networks2 == null) {
                return false;
            }
            NetworkInfo[] networkInfoArr = networks2;
            int length2 = networkInfoArr.length;
            for (int i2 = 0; i2 < length2; i2++) {
                NetworkInfo info2 = networkInfoArr[i2];
                if (info2 != null && info2.isConnected()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    @RequiresApi(api = 21)
    public void onNetworkAvailable(Network network) {
        StringBuilder sb;
        new StringBuilder();
        AppCenterLog.debug("AppCenter", sb.append("Network ").append(network).append(" is available.").toString());
        if (this.mConnected.compareAndSet(false, true)) {
            notifyNetworkStateUpdated(true);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    @android.support.annotation.RequiresApi(api = 21)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onNetworkLost(android.net.Network r11) {
        /*
            r10 = this;
            r0 = r10
            r1 = r11
            java.lang.String r4 = "AppCenter"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r9 = r5
            r5 = r9
            r6 = r9
            r6.<init>()
            java.lang.String r6 = "Network "
            java.lang.StringBuilder r5 = r5.append(r6)
            r6 = r1
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r6 = " is lost."
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.microsoft.appcenter.utils.AppCenterLog.debug(r4, r5)
            r4 = r0
            android.net.ConnectivityManager r4 = r4.mConnectivityManager
            android.net.Network[] r4 = r4.getAllNetworks()
            r2 = r4
            r4 = r2
            if (r4 == 0) goto L_0x0047
            r4 = r2
            int r4 = r4.length
            if (r4 == 0) goto L_0x0047
            r4 = r2
            r5 = 1
            android.net.Network[] r5 = new android.net.Network[r5]
            r9 = r5
            r5 = r9
            r6 = r9
            r7 = 0
            r8 = r1
            r6[r7] = r8
            boolean r4 = java.util.Arrays.equals(r4, r5)
            if (r4 == 0) goto L_0x005d
        L_0x0047:
            r4 = 1
        L_0x0048:
            r3 = r4
            r4 = r3
            if (r4 == 0) goto L_0x005c
            r4 = r0
            java.util.concurrent.atomic.AtomicBoolean r4 = r4.mConnected
            r5 = 1
            r6 = 0
            boolean r4 = r4.compareAndSet(r5, r6)
            if (r4 == 0) goto L_0x005c
            r4 = r0
            r5 = 0
            r4.notifyNetworkStateUpdated(r5)
        L_0x005c:
            return
        L_0x005d:
            r4 = 0
            goto L_0x0048
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.appcenter.utils.NetworkStateHelper.onNetworkLost(android.net.Network):void");
    }

    /* access modifiers changed from: private */
    public void handleNetworkStateUpdate() {
        boolean connected = isAnyNetworkConnected();
        if (this.mConnected.compareAndSet(!connected, connected)) {
            notifyNetworkStateUpdated(connected);
        }
    }

    private void notifyNetworkStateUpdated(boolean z) {
        StringBuilder sb;
        boolean connected = z;
        new StringBuilder();
        AppCenterLog.debug("AppCenter", sb.append("Network has been ").append(connected ? "connected." : "disconnected.").toString());
        for (Listener listener : this.mListeners) {
            listener.onNetworkStateUpdated(connected);
        }
    }

    public void close() {
        this.mConnected.set(false);
        if (Build.VERSION.SDK_INT >= 21) {
            this.mConnectivityManager.unregisterNetworkCallback(this.mNetworkCallback);
        } else {
            this.mContext.unregisterReceiver(this.mConnectivityReceiver);
        }
    }

    public void addListener(Listener listener) {
        boolean add = this.mListeners.add(listener);
    }

    public void removeListener(Listener listener) {
        boolean remove = this.mListeners.remove(listener);
    }

    private class ConnectivityReceiver extends BroadcastReceiver {
        final /* synthetic */ NetworkStateHelper this$0;

        private ConnectivityReceiver(NetworkStateHelper networkStateHelper) {
            this.this$0 = networkStateHelper;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        /* synthetic */ ConnectivityReceiver(NetworkStateHelper x0, AnonymousClass1 r7) {
            this(x0);
            AnonymousClass1 r2 = r7;
        }

        public void onReceive(Context context, Intent intent) {
            Context context2 = context;
            Intent intent2 = intent;
            this.this$0.handleNetworkStateUpdate();
        }
    }
}
