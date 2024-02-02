package com.xiaopeng.montecarlo;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes2.dex */
class NetworkChangedReceiver extends ConnectivityManager.NetworkCallback {
    private static final L.Tag TAG = new L.Tag("NetworkChangedReceiver");

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        if (L.ENABLE) {
            L.d(TAG, ">>> onAvailable");
        }
        updateSystemNetworkChanged();
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        if (L.ENABLE) {
            L.d(TAG, ">>> onLost");
        }
        updateSystemNetworkChanged();
    }

    private void updateSystemNetworkChanged() {
        if (L.ENABLE) {
            L.d(TAG, ">>> updateSystemNetworkChanged");
        }
        ConnectivityManager connectivityManager = XPNetworkManager.INSTANCE.getConnectivityManager();
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    int type = activeNetworkInfo.getType();
                    if (L.ENABLE) {
                        L.Tag tag = TAG;
                        L.d(tag, ">>> updateSystemNetworkChanged current net type = " + type);
                    }
                    if (type == 0 || 1 == type || 9 == type) {
                        XPNetworkManager.INSTANCE.updateSystemNetworkChanged(type, true);
                        return;
                    }
                    return;
                }
                if (L.ENABLE) {
                    L.d(TAG, ">>> updateSystemNetworkChanged current have not net");
                }
                XPNetworkManager.INSTANCE.updateSystemNetworkChanged(0, false);
                return;
            }
            if (L.ENABLE) {
                L.d(TAG, ">>> updateSystemNetworkChanged current have not net");
            }
            XPNetworkManager.INSTANCE.updateSystemNetworkChanged(0, false);
        }
    }
}
