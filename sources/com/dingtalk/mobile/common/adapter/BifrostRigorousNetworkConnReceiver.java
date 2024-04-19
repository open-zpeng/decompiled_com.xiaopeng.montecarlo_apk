package com.dingtalk.mobile.common.adapter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.dingtalk.mobile.common.transport.utils.BifrostLogCatUtil;
/* loaded from: classes2.dex */
public abstract class BifrostRigorousNetworkConnReceiver extends BroadcastReceiver {
    private static final int NETWORK_CHANGE = 1;
    private static final int NETWORK_NO_CHANGE = 2;
    private static final int NON_NETWORK = 0;
    private static final String TAG = "BifrostRigorousNetworkConnReceiver";
    private Boolean lastConnected;
    private Context mContext;
    private int netSubType;
    private int netType;

    protected abstract void onReceivee(Context context, Intent intent);

    public BifrostRigorousNetworkConnReceiver(Context context) {
        this.netType = -1;
        this.netSubType = -1;
        this.lastConnected = null;
        this.mContext = context;
        this.lastConnected = null;
        this.netType = -1;
        this.netSubType = -1;
    }

    public void register() {
        try {
            this.mContext.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } catch (Exception e) {
            BifrostLogCatUtil.warn(TAG, e);
        }
    }

    public void unregister() {
        try {
            this.mContext.unregisterReceiver(this);
        } catch (Exception e) {
            BifrostLogCatUtil.warn(TAG, e);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            BifrostLogCatUtil.info("monitor", "onReceive at: " + getClass().getName() + ", Intent: " + intent);
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                int networkState = getNetworkState(context);
                if (networkState == 0) {
                    BifrostLogCatUtil.debug(TAG, "NetworkConnectivityReceiver#onReceive 网络不可用");
                    onReceivee(context, intent);
                } else if (networkState == 1) {
                    BifrostLogCatUtil.debug(TAG, "NetworkConnectivityReceiver#onReceive 网络变化");
                    onReceivee(context, intent);
                }
            }
        } catch (Throwable th) {
            BifrostLogCatUtil.error(TAG, "onReceive exception:", th);
        }
    }

    private int getNetworkState(Context context) {
        NetworkInfo networkInfo;
        Boolean bool;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th) {
            BifrostLogCatUtil.warn(TAG, "getActiveNetworkInfo exception. " + th.toString());
            networkInfo = null;
        }
        if (networkInfo == null) {
            BifrostLogCatUtil.info(TAG, "当前无网络!");
            this.lastConnected = false;
            return 0;
        }
        boolean isAvailable = networkInfo.isAvailable();
        boolean isConnected = networkInfo.isConnected();
        int type = networkInfo.getType();
        int subtype = networkInfo.getSubtype();
        String extraInfo = networkInfo.getExtraInfo();
        if (this.netType == -1 || this.netSubType == -1 || (bool = this.lastConnected) == null) {
            BifrostLogCatUtil.info(TAG, " New contivity broadcast！");
        } else if (bool.booleanValue() == isConnected && this.netType == type && this.netSubType == subtype) {
            BifrostLogCatUtil.info(TAG, " Old contivity broadcast！");
            return 2;
        }
        this.lastConnected = Boolean.valueOf(isConnected);
        this.netType = type;
        this.netSubType = subtype;
        BifrostLogCatUtil.debug(TAG, " type=[" + type + "] subType=[" + subtype + "]  available=[" + isAvailable + "] connected=[" + isConnected + "] detailedState=[" + networkInfo.getDetailedState() + "] extraInfo=[" + extraInfo + "]");
        StringBuilder sb = new StringBuilder();
        sb.append(" activeNetworkInfo hashcode=");
        sb.append(networkInfo.hashCode());
        sb.append("  activeNetworkInfo = [");
        sb.append(networkInfo.toString());
        sb.append("]\n\n\n");
        BifrostLogCatUtil.debug(TAG, sb.toString());
        return !this.lastConnected.booleanValue() ? 0 : 1;
    }
}
