package com.dingtalk.mars.comm;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.dingtalk.bifrost.Bifrost;
import com.dingtalk.bifrost.BifrostEnvUtils;
import com.dingtalk.mobile.common.transport.utils.BifrostLogCatUtil;
/* loaded from: classes2.dex */
public class NetworkSignalUtil {
    public static final String TAG = "bifrost.NetworkSignalUtil";
    private static Context context = null;
    private static HandlerThread handlerThread = null;
    private static long strength = 10000;

    public static long getNetworkSignalStrength(boolean z) {
        return 0L;
    }

    public static void InitNetworkSignalUtil(Context context2) {
        if (context2 == null) {
            try {
                context2 = BifrostEnvUtils.getContext();
                if (context2 == null) {
                    return;
                }
            } catch (Throwable th) {
                BifrostLogCatUtil.error("MNET", "NetworkSignalUtil: ", th);
                handlerThread = null;
                return;
            }
        }
        context = context2;
        if (!Bifrost.getSwchmng().enableListenNetworkSignalStrength()) {
            BifrostLogCatUtil.warn(TAG, "do not listen network signal strength");
            return;
        }
        final TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        synchronized (NetworkSignalUtil.class) {
            if (handlerThread != null) {
                return;
            }
            handlerThread = new HandlerThread("BifrostSignalThread");
            handlerThread.start();
            new Handler(handlerThread.getLooper()).post(new Runnable() { // from class: com.dingtalk.mars.comm.NetworkSignalUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    telephonyManager.listen(new PhoneStateListener() { // from class: com.dingtalk.mars.comm.NetworkSignalUtil.1.1
                        @Override // android.telephony.PhoneStateListener
                        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
                            super.onSignalStrengthsChanged(signalStrength);
                            NetworkSignalUtil.calSignalStrength(signalStrength);
                        }
                    }, 256);
                }
            });
        }
    }

    public static long getGSMSignalStrength() {
        return strength;
    }

    public static long getWifiSignalStrength() {
        try {
            if (context == null) {
                context = BifrostEnvUtils.getContext();
            }
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo == null || connectionInfo.getBSSID() == null) {
                return 0L;
            }
            int calculateSignalLevel = WifiManager.calculateSignalLevel(connectionInfo.getRssi(), 10);
            if (calculateSignalLevel > 10) {
                calculateSignalLevel = 10;
            }
            if (calculateSignalLevel < 0) {
                calculateSignalLevel = 0;
            }
            return calculateSignalLevel * 10;
        } catch (Throwable th) {
            BifrostLogCatUtil.error("bifrost", "getWifiSignalStrength:", th);
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void calSignalStrength(SignalStrength signalStrength) {
        int cdmaDbm;
        try {
            if (signalStrength.isGsm()) {
                cdmaDbm = signalStrength.getGsmSignalStrength();
            } else {
                cdmaDbm = (signalStrength.getCdmaDbm() + 113) / 2;
            }
            long j = 0;
            if (signalStrength.isGsm() && cdmaDbm == 99) {
                strength = 0L;
                return;
            }
            strength = cdmaDbm * 3.2258065f;
            long j2 = 100;
            if (strength <= 100) {
                j2 = strength;
            }
            strength = j2;
            if (strength >= 0) {
                j = strength;
            }
            strength = j;
        } catch (Throwable th) {
            BifrostLogCatUtil.error("bifrost", "calSignalStrength:", th);
        }
    }
}
