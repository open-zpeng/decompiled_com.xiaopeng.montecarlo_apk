package com.autonavi.gbl.map.adapter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/* loaded from: classes2.dex */
public class NetworkState {
    private NetworkChangeListener mNetworkListener;
    private boolean isNetReceiverRegistered = false;
    private final BroadcastReceiver netChangeReceiver = new BroadcastReceiver() { // from class: com.autonavi.gbl.map.adapter.NetworkState.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (NetworkState.this.mNetworkListener != null) {
                NetworkState.this.mNetworkListener.networkStateChanged(context);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface NetworkChangeListener {
        void networkStateChanged(Context context);
    }

    public void setNetworkListener(NetworkChangeListener networkChangeListener) {
        this.mNetworkListener = networkChangeListener;
    }

    public void registerNetChangeReceiver(Context context, boolean z) {
        if (context != null) {
            if (z) {
                if (!this.isNetReceiverRegistered) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    context.registerReceiver(this.netChangeReceiver, intentFilter);
                }
            } else if (this.isNetReceiverRegistered) {
                context.unregisterReceiver(this.netChangeReceiver);
            }
            this.isNetReceiverRegistered = z;
        }
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        if (context == null) {
            return null;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
                if (allNetworkInfo == null) {
                    return null;
                }
                for (int i = 0; i < allNetworkInfo.length; i++) {
                    if (allNetworkInfo[i] != null && allNetworkInfo[i].isConnected()) {
                        return allNetworkInfo[i];
                    }
                }
                return activeNetworkInfo;
            }
            return activeNetworkInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
