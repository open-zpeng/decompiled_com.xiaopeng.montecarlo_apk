package com.dingtalk.mars.comm;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.telephony.TelephonyManager;
import com.dingtalk.bifrost.Bifrost;
import com.dingtalk.bifrost.BifrostEnvUtils;
import com.dingtalk.mobile.common.transport.utils.BifrostLogCatUtil;
/* loaded from: classes2.dex */
public class PlatformComm {
    static final int EMobile = 2;
    static final int ENoNet = -1;
    static final int EOtherNet = 3;
    static final int EWifi = 1;
    private static final boolean IS_PROXY_ON = false;
    static final int NETTYPE_2G = 3;
    static final int NETTYPE_3G = 4;
    static final int NETTYPE_4G = 5;
    static final int NETTYPE_NON = -1;
    static final int NETTYPE_NOT_WIFI = 0;
    static final int NETTYPE_UNKNOWN = 6;
    static final int NETTYPE_WAP = 2;
    static final int NETTYPE_WIFI = 1;
    static final int PROXY_TYPE_HTTP_TUNNEL = 1;
    static final int PROXY_TYPE_NONE = 0;
    static final int PROXY_TYPE_SOCKS5 = 2;
    private static final String TAG = "bifrost.PlatformComm";
    public static Context context;
    public static Handler handler;

    /* loaded from: classes2.dex */
    public static class Assert {
        public static void assertTrue(String str, boolean z) {
        }

        public static void assertTrue(boolean z) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class WifiInfo {
        public String bssid;
        public String ssid;

        WifiInfo() {
        }
    }

    /* loaded from: classes2.dex */
    static class SIMInfo {
        public String ispCode;
        public String ispName;

        SIMInfo() {
        }
    }

    /* loaded from: classes2.dex */
    static class APNInfo {
        public String extraInfo;
        public int netType;
        public int subNetType;

        APNInfo() {
        }
    }

    /* loaded from: classes2.dex */
    static class ProxyInfo {
        public String password;
        public String proxyHost;
        public int proxyPort;
        public int proxyType;
        public String username;

        ProxyInfo() {
        }
    }

    public static void init(Context context2, Handler handler2) {
        context = context2;
        handler = handler2;
        NetworkSignalUtil.InitNetworkSignalUtil(context2);
    }

    /* loaded from: classes2.dex */
    public static class C2Java {
        public static int getProxyInfo(StringBuffer stringBuffer) {
            return -1;
        }

        private static String exception2String(Exception exc) {
            return exc.toString();
        }

        public static int getNetInfo() {
            NetworkInfo activeNetworkInfo;
            try {
                if (PlatformComm.context == null) {
                    PlatformComm.context = BifrostEnvUtils.getContext();
                }
                ConnectivityManager connectivityManager = (ConnectivityManager) PlatformComm.context.getSystemService("connectivity");
                if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                    return -1;
                }
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    if (type == 1) {
                        return 1;
                    }
                    if (type != 2 && type != 3 && type != 4 && type != 5) {
                        return 3;
                    }
                }
                return 2;
            } catch (Throwable th) {
                BifrostLogCatUtil.error(PlatformComm.TAG, th);
                return 3;
            }
        }

        public static ProxyInfo getProxyInfo() {
            ProxyInfo proxyInfo = new ProxyInfo();
            try {
                if (Bifrost.getSwchmng().enableBifrostUseProxy()) {
                    proxyInfo.proxyHost = System.getProperty("bifrost.proxyHost");
                    String property = System.getProperty("bifrost.proxyPort");
                    proxyInfo.username = System.getProperty("bifrost.proxyUsername");
                    proxyInfo.password = System.getProperty("bifrost.proxyPassword");
                    if (proxyInfo.proxyHost == null || proxyInfo.proxyHost.length() <= 0) {
                        proxyInfo.proxyHost = System.getProperty("http.proxyHost");
                        property = System.getProperty("http.proxyPort");
                        proxyInfo.username = null;
                        proxyInfo.password = null;
                    }
                    if (property != null && property.length() > 0) {
                        proxyInfo.proxyPort = Integer.parseInt(property);
                    } else {
                        proxyInfo.proxyPort = -1;
                    }
                    if (proxyInfo.proxyHost == null || proxyInfo.proxyHost.length() <= 0) {
                        return proxyInfo;
                    }
                    proxyInfo.proxyType = 1;
                    return proxyInfo;
                }
                return null;
            } catch (Exception e) {
                BifrostLogCatUtil.error(PlatformComm.TAG, e);
                return null;
            }
        }

        public static int getStatisticsNetType() {
            try {
                if (PlatformComm.context == null) {
                    PlatformComm.context = BifrostEnvUtils.getContext();
                }
                if (PlatformComm.context == null) {
                    Assert.assertTrue(false);
                    return 0;
                }
                int netType = NetStatusUtil.getNetType(PlatformComm.context);
                if (netType == -1) {
                    return -1;
                }
                if (NetStatusUtil.is2G(PlatformComm.context)) {
                    return 3;
                }
                if (NetStatusUtil.is3G(PlatformComm.context)) {
                    return 4;
                }
                if (NetStatusUtil.is4G(PlatformComm.context)) {
                    return 5;
                }
                if (NetStatusUtil.isWifi(netType)) {
                    return 1;
                }
                return NetStatusUtil.isWap(netType) ? 2 : 6;
            } catch (Throwable th) {
                BifrostLogCatUtil.error(PlatformComm.TAG, th);
                return -1;
            }
        }

        public static boolean startAlarm(int i, int i2) {
            try {
                if (PlatformComm.context == null) {
                    PlatformComm.context = BifrostEnvUtils.getContext();
                }
                if (PlatformComm.context == null) {
                    Assert.assertTrue(false);
                    return false;
                }
                return Alarm.start(i, i2, PlatformComm.context);
            } catch (Throwable th) {
                BifrostLogCatUtil.error(PlatformComm.TAG, th);
                return false;
            }
        }

        public static boolean stopAlarm(int i) {
            try {
                if (PlatformComm.context == null) {
                    PlatformComm.context = BifrostEnvUtils.getContext();
                }
                if (PlatformComm.context == null) {
                    Assert.assertTrue(false);
                    return false;
                }
                return Alarm.stop(i, PlatformComm.context);
            } catch (Throwable th) {
                BifrostLogCatUtil.error(PlatformComm.TAG, th);
                return false;
            }
        }

        public static WifiInfo getCurWifiInfo() {
            ConnectivityManager connectivityManager;
            NetworkInfo activeNetworkInfo;
            WifiManager wifiManager;
            android.net.wifi.WifiInfo connectionInfo;
            try {
                if (PlatformComm.context == null) {
                    PlatformComm.context = BifrostEnvUtils.getContext();
                }
                if (PlatformComm.context == null || (connectivityManager = (ConnectivityManager) PlatformComm.context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || 1 != activeNetworkInfo.getType() || (wifiManager = (WifiManager) PlatformComm.context.getSystemService("wifi")) == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
                    return null;
                }
                WifiInfo wifiInfo = new WifiInfo();
                wifiInfo.ssid = connectionInfo.getSSID();
                wifiInfo.bssid = connectionInfo.getBSSID();
                return wifiInfo;
            } catch (Throwable th) {
                BifrostLogCatUtil.error(PlatformComm.TAG, th);
                return null;
            }
        }

        public static SIMInfo getCurSIMInfo() {
            int iSPCode;
            try {
                if (PlatformComm.context == null) {
                    PlatformComm.context = BifrostEnvUtils.getContext();
                }
                if (PlatformComm.context == null || (iSPCode = NetStatusUtil.getISPCode(PlatformComm.context)) == 0) {
                    return null;
                }
                SIMInfo sIMInfo = new SIMInfo();
                sIMInfo.ispCode = "" + iSPCode;
                sIMInfo.ispName = NetStatusUtil.getISPName(PlatformComm.context);
                return sIMInfo;
            } catch (Throwable th) {
                BifrostLogCatUtil.error(PlatformComm.TAG, th);
                return null;
            }
        }

        public static APNInfo getAPNInfo() {
            try {
                if (PlatformComm.context == null) {
                    PlatformComm.context = BifrostEnvUtils.getContext();
                }
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) PlatformComm.context.getSystemService("connectivity")).getActiveNetworkInfo();
                APNInfo aPNInfo = new APNInfo();
                if (activeNetworkInfo != null) {
                    aPNInfo.netType = activeNetworkInfo.getType();
                    aPNInfo.subNetType = activeNetworkInfo.getSubtype();
                    if (1 != activeNetworkInfo.getType()) {
                        aPNInfo.extraInfo = activeNetworkInfo.getExtraInfo() == null ? "" : activeNetworkInfo.getExtraInfo();
                    } else {
                        aPNInfo.extraInfo = getCurWifiInfo().ssid;
                    }
                    return aPNInfo;
                }
                return null;
            } catch (Throwable th) {
                BifrostLogCatUtil.error(PlatformComm.TAG, th);
                return null;
            }
        }

        public static int getCurRadioAccessNetworkInfo() {
            try {
                if (PlatformComm.context == null) {
                    PlatformComm.context = BifrostEnvUtils.getContext();
                }
                if (PlatformComm.context == null) {
                    Assert.assertTrue(false);
                    return 0;
                }
                return ((TelephonyManager) PlatformComm.context.getSystemService("phone")).getNetworkType();
            } catch (Throwable th) {
                BifrostLogCatUtil.error(PlatformComm.TAG, th);
                return 0;
            }
        }

        public static long getSignal(boolean z) {
            try {
                if (PlatformComm.context == null) {
                    PlatformComm.context = BifrostEnvUtils.getContext();
                }
                if (PlatformComm.context == null) {
                    Assert.assertTrue(false);
                    return 0L;
                } else if (z) {
                    return NetworkSignalUtil.getWifiSignalStrength();
                } else {
                    return NetworkSignalUtil.getGSMSignalStrength();
                }
            } catch (Throwable th) {
                BifrostLogCatUtil.error(PlatformComm.TAG, th);
                return 0L;
            }
        }

        public static boolean isNetworkConnected() {
            try {
                if (PlatformComm.context == null) {
                    PlatformComm.context = BifrostEnvUtils.getContext();
                }
                if (PlatformComm.context == null) {
                    Assert.assertTrue(false);
                    return false;
                }
                return NetStatusUtil.isNetworkConnected(PlatformComm.context);
            } catch (Throwable th) {
                BifrostLogCatUtil.error(PlatformComm.TAG, th);
                return false;
            }
        }

        public static WakerLock wakeupLock_new() {
            try {
                if (PlatformComm.context == null) {
                    PlatformComm.context = BifrostEnvUtils.getContext();
                }
                if (PlatformComm.context == null) {
                    Assert.assertTrue(false);
                    return null;
                }
                return new WakerLock(PlatformComm.context);
            } catch (Throwable th) {
                BifrostLogCatUtil.error(PlatformComm.TAG, th);
                return null;
            }
        }

        public static String[] getDnsServers() {
            try {
                if (PlatformComm.context == null) {
                    PlatformComm.context = BifrostEnvUtils.getContext();
                }
                if (PlatformComm.context == null) {
                    Assert.assertTrue(false);
                    return null;
                }
                return NetStatusUtil.getDnsServers(PlatformComm.context);
            } catch (Throwable th) {
                BifrostLogCatUtil.error(PlatformComm.TAG, th);
                return null;
            }
        }
    }
}
