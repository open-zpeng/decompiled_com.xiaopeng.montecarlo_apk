package com.dingtalk.mars.comm;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.dingtalk.bifrost.BifrostEnvUtils;
import com.dingtalk.mobile.common.transport.utils.BifrostLogCatUtil;
import java.net.InetAddress;
import java.util.List;
/* loaded from: classes2.dex */
public class NetStatusUtil {
    public static final int CMNET = 6;
    public static final int CMWAP = 5;
    public static final int CTNET = 8;
    public static final int CTWAP = 7;
    public static final int LTE = 10;
    public static final int MOBILE = 9;
    public static final int NETTYPE_NOT_WIFI = 0;
    public static final int NETTYPE_WIFI = 1;
    public static final int NET_3G = 4;
    public static final int NON_NETWORK = -1;
    public static final int NO_SIM_OPERATOR = 0;
    public static final int POLICY_NONE = 0;
    public static final int POLICY_REJECT_METERED_BACKGROUND = 1;
    private static final String TAG = "bifrost.NetStatusUtil";
    public static final int TBACKGROUND_DATA_LIMITED = 2;
    public static final int TBACKGROUND_NOT_LIMITED = 0;
    public static final int TBACKGROUND_PROCESS_LIMITED = 1;
    public static final int TBACKGROUND_WIFI_LIMITED = 3;
    public static final int UNINET = 1;
    public static final int UNIWAP = 2;
    public static final int UNKNOW_TYPE = 999;
    public static final int WAP_3G = 3;
    public static final int WIFI = 0;
    private static int nowStrength;

    public static boolean isLimited(int i) {
        return i == 2 || i == 1 || i == 3;
    }

    public static boolean isWap(int i) {
        return i == 2 || i == 5 || i == 7 || i == 3;
    }

    public static boolean isWifi(int i) {
        return i == 0;
    }

    public static void dumpNetStatus(Context context) {
        if (context == null) {
            try {
                context = BifrostEnvUtils.getContext();
            } catch (Throwable th) {
                BifrostLogCatUtil.error(TAG, "dumpNetStatus error", th);
                return;
            }
        }
        BifrostLogCatUtil.info(TAG, ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().toString());
    }

    public static boolean isConnected(Context context) {
        if (context == null) {
            try {
                context = BifrostEnvUtils.getContext();
            } catch (Throwable th) {
                BifrostLogCatUtil.error(TAG, th);
                return false;
            }
        }
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().isConnected();
    }

    public static String getNetTypeString(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            try {
                context = BifrostEnvUtils.getContext();
            } catch (Throwable th) {
                BifrostLogCatUtil.error(TAG, "getNetTypeString error", th);
                return "NON_NETWORK";
            }
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) ? "NON_NETWORK" : activeNetworkInfo.getType() == 1 ? "WIFI" : activeNetworkInfo.getExtraInfo() != null ? activeNetworkInfo.getExtraInfo() : "MOBILE";
    }

    public static int getNetWorkType(Context context) {
        if (context == null) {
            try {
                context = BifrostEnvUtils.getContext();
            } catch (Throwable th) {
                BifrostLogCatUtil.error(TAG, "getNetWorkType error", th);
                return -1;
            }
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.getType();
        }
        return -1;
    }

    public static int getNetType(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            try {
                context = BifrostEnvUtils.getContext();
            } catch (Throwable th) {
                BifrostLogCatUtil.error(TAG, "getNetType", th);
                return -1;
            }
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return -1;
        }
        if (activeNetworkInfo.getType() == 1) {
            return 0;
        }
        if (activeNetworkInfo.getExtraInfo() != null) {
            if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("uninet")) {
                return 1;
            }
            if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("uniwap")) {
                return 2;
            }
            if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("3gwap")) {
                return 3;
            }
            if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("3gnet")) {
                return 4;
            }
            if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("cmwap")) {
                return 5;
            }
            if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("cmnet")) {
                return 6;
            }
            if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("ctwap")) {
                return 7;
            }
            if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("ctnet")) {
                return 8;
            }
            return activeNetworkInfo.getExtraInfo().equalsIgnoreCase("LTE") ? 10 : 9;
        }
        return 9;
    }

    public static int getISPCode(Context context) {
        String simOperator;
        if (context == null) {
            try {
                context = BifrostEnvUtils.getContext();
            } catch (Throwable th) {
                BifrostLogCatUtil.error(TAG, "getISPCode error", th);
                return 0;
            }
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null && (simOperator = telephonyManager.getSimOperator()) != null && simOperator.length() >= 5) {
            StringBuilder sb = new StringBuilder();
            int length = simOperator.length();
            if (length > 6) {
                length = 6;
            }
            for (int i = 0; i < length; i++) {
                if (!Character.isDigit(simOperator.charAt(i))) {
                    if (sb.length() > 0) {
                        break;
                    }
                } else {
                    sb.append(simOperator.charAt(i));
                }
            }
            return Integer.valueOf(sb.toString()).intValue();
        }
        return 0;
    }

    public static String getISPName(Context context) {
        if (context == null) {
            try {
                context = BifrostEnvUtils.getContext();
            } catch (Throwable th) {
                BifrostLogCatUtil.error(TAG, "getISPName error", th);
                return "";
            }
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        if (telephonyManager.getSimOperatorName().length() <= 100) {
            return telephonyManager.getSimOperatorName();
        }
        return telephonyManager.getSimOperatorName().substring(0, 100);
    }

    public static int guessNetSpeed(Context context) {
        if (context == null) {
            try {
                context = BifrostEnvUtils.getContext();
            } catch (Throwable th) {
                BifrostLogCatUtil.error(TAG, "guessNetSpeed", th);
            }
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo.getType() == 1) {
            return 102400;
        }
        switch (activeNetworkInfo.getSubtype()) {
            case 1:
                return 4096;
            case 2:
                return 8192;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 102400;
        }
        return 102400;
    }

    public static boolean isMobile(Context context) {
        if (context == null) {
            try {
                context = BifrostEnvUtils.getContext();
            } catch (Throwable th) {
                BifrostLogCatUtil.error(TAG, th);
                return false;
            }
        }
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().getType() != 1;
    }

    public static boolean is2G(Context context) {
        if (context == null) {
            try {
                context = BifrostEnvUtils.getContext();
            } catch (Throwable th) {
                BifrostLogCatUtil.error(TAG, th);
            }
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo.getType() == 1) {
            return false;
        }
        if (activeNetworkInfo.getSubtype() != 2 && activeNetworkInfo.getSubtype() != 1) {
            if (activeNetworkInfo.getSubtype() != 4) {
                return false;
            }
        }
        return true;
    }

    public static boolean is4G(Context context) {
        if (context == null) {
            try {
                context = BifrostEnvUtils.getContext();
            } catch (Throwable th) {
                BifrostLogCatUtil.error(TAG, th);
            }
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo.getType() == 1) {
            return false;
        }
        return activeNetworkInfo.getSubtype() >= 13;
    }

    public static boolean isWap(Context context) {
        return isWap(getNetType(context));
    }

    public static boolean is3G(Context context) {
        if (context == null) {
            try {
                context = BifrostEnvUtils.getContext();
            } catch (Throwable th) {
                BifrostLogCatUtil.error(TAG, th);
            }
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo.getType() != 1 && activeNetworkInfo.getSubtype() >= 5) {
            if (activeNetworkInfo.getSubtype() < 13) {
                return true;
            }
        }
        return false;
    }

    public static boolean isWifi(Context context) {
        return isWifi(getNetType(context));
    }

    public static WifiInfo getWifiInfo(Context context) {
        NetworkInfo activeNetworkInfo;
        WifiManager wifiManager;
        if (context == null) {
            try {
                context = BifrostEnvUtils.getContext();
            } catch (Throwable th) {
                BifrostLogCatUtil.error(TAG, th);
                return null;
            }
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || 1 != activeNetworkInfo.getType() || (wifiManager = (WifiManager) context.getSystemService("wifi")) == null) {
            return null;
        }
        return wifiManager.getConnectionInfo();
    }

    public static int getWifiSleeepPolicy(Context context) {
        if (context == null) {
            context = BifrostEnvUtils.getContext();
        }
        return Settings.System.getInt(context.getContentResolver(), "wifi_sleep_policy", 2);
    }

    public static int getBackgroundLimitType(Context context) {
        int wifiSleeepPolicy;
        if (Build.VERSION.SDK_INT >= 14) {
            try {
                Class<?> cls = Class.forName("android.app.ActivityManagerNative");
                Object invoke = cls.getMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
                if (((Integer) invoke.getClass().getMethod("getProcessLimit", new Class[0]).invoke(invoke, new Object[0])).intValue() == 0) {
                    return 1;
                }
            } catch (Exception e) {
                BifrostLogCatUtil.error(TAG, e);
            }
        }
        try {
            wifiSleeepPolicy = getWifiSleeepPolicy(context);
        } catch (Exception e2) {
            BifrostLogCatUtil.error(TAG, e2);
        }
        if (wifiSleeepPolicy != 2) {
            if (getNetType(context) == 0) {
                return (wifiSleeepPolicy == 1 || wifiSleeepPolicy == 0) ? 3 : 0;
            }
        }
        return 0;
    }

    public static boolean isImmediatelyDestroyActivities(Context context) {
        if (context == null) {
            context = BifrostEnvUtils.getContext();
        }
        return Settings.System.getInt(context.getContentResolver(), "always_finish_activities", 0) != 0;
    }

    public static int getProxyInfo(Context context, StringBuffer stringBuffer) {
        if (context == null) {
            try {
                BifrostEnvUtils.getContext();
            } catch (Exception e) {
                BifrostLogCatUtil.error(TAG, e);
                return 0;
            }
        }
        String defaultHost = Proxy.getDefaultHost();
        int defaultPort = Proxy.getDefaultPort();
        if (defaultHost != null && defaultHost.length() > 0 && defaultPort > 0) {
            stringBuffer.append(defaultHost);
            return defaultPort;
        }
        String property = System.getProperty("http.proxyHost");
        String property2 = System.getProperty("http.proxyPort");
        int i = 80;
        if (property2 != null && property2.length() > 0) {
            i = Integer.parseInt(property2);
        }
        if (property == null || property.length() <= 0) {
            return 0;
        }
        stringBuffer.append(property);
        return i;
    }

    public static boolean isKnownDirectNet(Context context) {
        int netType = getNetType(context);
        return 6 == netType || 1 == netType || 4 == netType || 8 == netType || 10 == netType || netType == 0;
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            try {
                context = BifrostEnvUtils.getContext();
            } catch (Throwable th) {
                BifrostLogCatUtil.error(TAG, "isNetworkConnected error", th);
                return false;
            }
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED;
    }

    /* loaded from: classes2.dex */
    public static class StrengthListener extends PhoneStateListener {
        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            super.onSignalStrengthsChanged(signalStrength);
            if (!signalStrength.isGsm()) {
                int unused = NetStatusUtil.nowStrength = signalStrength.getCdmaDbm();
            } else {
                int unused2 = NetStatusUtil.nowStrength = signalStrength.getGsmSignalStrength();
            }
        }
    }

    public static int getNetTypeForStat(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            try {
                context = BifrostEnvUtils.getContext();
            } catch (Throwable th) {
                BifrostLogCatUtil.error(TAG, th);
                return 999;
            }
        }
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return 999;
        }
        if (activeNetworkInfo.getType() == 1) {
            return 1;
        }
        int subtype = activeNetworkInfo.getSubtype();
        if (subtype == 0) {
            return 999;
        }
        return subtype * 1000;
    }

    public static int getStrength(Context context) {
        Context context2;
        if (context == null) {
            try {
                context2 = BifrostEnvUtils.getContext();
            } catch (Throwable th) {
                BifrostLogCatUtil.error(TAG, th);
                return 0;
            }
        } else {
            context2 = context;
        }
        if (context2 == null) {
            return 0;
        }
        if (getNetTypeForStat(context2) == 1) {
            return Math.abs(((WifiManager) context2.getSystemService("wifi")).getConnectionInfo().getRssi());
        }
        ((TelephonyManager) context.getSystemService("phone")).listen(new StrengthListener(), 256);
        return Math.abs(nowStrength);
    }

    public static String[] getDnsServers(Context context) {
        if (context == null) {
            try {
                context = BifrostEnvUtils.getContext();
            } catch (Throwable th) {
                BifrostLogCatUtil.error(TAG, "[getDnsServers] error", th);
                return null;
            }
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            BifrostLogCatUtil.info(TAG, "[getDnsServers] no connectivityManager");
            return null;
        }
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null) {
            BifrostLogCatUtil.info(TAG, "[getDnsServers] no activeNetwork");
            return null;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(activeNetwork);
        if (networkInfo != null && networkInfo.isConnected()) {
            LinkProperties linkProperties = connectivityManager.getLinkProperties(activeNetwork);
            if (linkProperties == null) {
                BifrostLogCatUtil.info(TAG, "[getDnsServers]no linkProperties");
                return null;
            }
            BifrostLogCatUtil.info(TAG, "iface = " + linkProperties.getInterfaceName());
            BifrostLogCatUtil.info(TAG, "dns = " + linkProperties.getDnsServers());
            List<InetAddress> dnsServers = linkProperties.getDnsServers();
            if (dnsServers.size() <= 0) {
                BifrostLogCatUtil.info(TAG, "[getDnsServers]no targetDnses");
                return null;
            }
            String[] strArr = new String[dnsServers.size()];
            for (int i = 0; i < dnsServers.size(); i++) {
                strArr[i] = dnsServers.get(i).getHostAddress();
            }
            return strArr;
        }
        BifrostLogCatUtil.info(TAG, "[getDnsServers]activeNetwork error");
        return null;
    }
}
