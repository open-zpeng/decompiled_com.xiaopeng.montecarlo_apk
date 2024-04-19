package com.xiaopeng.montecarlo.root.network;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public enum XPNetworkManager {
    INSTANCE;
    
    private static final L.Tag TAG = new L.Tag("XPNetworkManager");
    private List<IXPNetworkListener> mListeners = new CopyOnWriteArrayList();
    private XPNetworkType mLastNetworkType = XPNetworkType.NETWORK_INVALID;
    private boolean mLastSystemConnectStatus = false;
    private boolean mLastTboxApnConnectStatus = false;

    /* loaded from: classes3.dex */
    public enum XPNetworkType {
        NETWORK_INVALID,
        NETWORK_NONE,
        NETWORK_WIFI,
        NETWORK_TBOX,
        NETWORK_MOBILE
    }

    XPNetworkManager() {
    }

    public void addNetworkListener(IXPNetworkListener iXPNetworkListener) {
        if (this.mListeners.indexOf(iXPNetworkListener) == -1) {
            this.mListeners.add(iXPNetworkListener);
        }
    }

    public void updateTboxApnConnected(boolean z) {
        if (this.mLastNetworkType == XPNetworkType.NETWORK_INVALID) {
            updateSystemNetWorkStatus();
        }
        if (this.mLastTboxApnConnectStatus != z) {
            this.mLastTboxApnConnectStatus = z;
            if (this.mLastNetworkType == XPNetworkType.NETWORK_TBOX) {
                notifyNetworkstatusChange(this.mLastNetworkType, isNetworkRealConnected());
            }
        }
    }

    public void removeNetworkListener(IXPNetworkListener iXPNetworkListener) {
        this.mListeners.remove(iXPNetworkListener);
    }

    public void updateSystemNetworkChanged(int i, boolean z) {
        XPNetworkType transSystemNetType2XpNetType = transSystemNetType2XpNetType(i);
        if (this.mLastNetworkType == transSystemNetType2XpNetType && this.mLastSystemConnectStatus == z) {
            return;
        }
        this.mLastNetworkType = transSystemNetType2XpNetType;
        this.mLastSystemConnectStatus = z;
        boolean isNetworkRealConnected = isNetworkRealConnected();
        L.Tag tag = TAG;
        L.i(tag, "update sys network type:" + i + " type:" + transSystemNetType2XpNetType + " sys connect:->" + z + "real connected:" + isNetworkRealConnected);
        notifyNetworkstatusChange(this.mLastNetworkType, isNetworkRealConnected);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaopeng.montecarlo.root.network.XPNetworkManager$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$xiaopeng$montecarlo$root$network$XPNetworkManager$XPNetworkType = new int[XPNetworkType.values().length];

        static {
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$network$XPNetworkManager$XPNetworkType[XPNetworkType.NETWORK_TBOX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$network$XPNetworkManager$XPNetworkType[XPNetworkType.NETWORK_WIFI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$network$XPNetworkManager$XPNetworkType[XPNetworkType.NETWORK_MOBILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$network$XPNetworkManager$XPNetworkType[XPNetworkType.NETWORK_NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private boolean isNetworkRealConnected() {
        int i = AnonymousClass1.$SwitchMap$com$xiaopeng$montecarlo$root$network$XPNetworkManager$XPNetworkType[this.mLastNetworkType.ordinal()];
        if (i == 1) {
            return this.mLastSystemConnectStatus && this.mLastTboxApnConnectStatus;
        } else if (i != 2) {
            if (i != 3) {
                return false;
            }
            return this.mLastSystemConnectStatus;
        } else {
            return this.mLastSystemConnectStatus;
        }
    }

    private void notifyNetworkstatusChange(XPNetworkType xPNetworkType, boolean z) {
        for (IXPNetworkListener iXPNetworkListener : this.mListeners) {
            if (iXPNetworkListener != null) {
                iXPNetworkListener.onNetworkChanged(xPNetworkType, z);
            }
        }
    }

    public boolean isNetworkConnected() {
        if (this.mLastNetworkType == XPNetworkType.NETWORK_INVALID) {
            updateSystemNetWorkStatus();
        }
        return isNetworkRealConnected();
    }

    public XPNetworkType getNetworkType() {
        if (XPNetworkType.NETWORK_INVALID == this.mLastNetworkType) {
            updateSystemNetWorkStatus();
        }
        return this.mLastNetworkType;
    }

    public ConnectivityManager getConnectivityManager() {
        return (ConnectivityManager) ContextUtils.getContext().getSystemService("connectivity");
    }

    private TelephonyManager getTelephonyManager() {
        return (TelephonyManager) ContextUtils.getContext().getSystemService("phone");
    }

    private XPNetworkType transSystemNetType2XpNetType(int i) {
        XPNetworkType xPNetworkType = XPNetworkType.NETWORK_NONE;
        if (i != 0) {
            if (i != 1) {
                if (i == 9) {
                    return XPNetworkType.NETWORK_TBOX;
                }
                return XPNetworkType.NETWORK_NONE;
            }
            return XPNetworkType.NETWORK_WIFI;
        }
        return XPNetworkType.NETWORK_MOBILE;
    }

    private void updateSystemNetWorkStatus() {
        ConnectivityManager connectivityManager = getConnectivityManager();
        boolean z = false;
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                this.mLastNetworkType = transSystemNetType2XpNetType(activeNetworkInfo.getType());
                if (activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
                    z = true;
                }
                this.mLastSystemConnectStatus = z;
            } else {
                L.w(TAG, "networkInfo = null");
                this.mLastNetworkType = XPNetworkType.NETWORK_NONE;
                this.mLastSystemConnectStatus = false;
            }
        } else {
            L.w(TAG, "connectivityManager = null");
            this.mLastNetworkType = XPNetworkType.NETWORK_NONE;
            this.mLastSystemConnectStatus = false;
        }
        L.Tag tag = TAG;
        L.i(tag, "update Network status type:" + this.mLastNetworkType + " connect:" + this.mLastSystemConnectStatus);
    }
}
