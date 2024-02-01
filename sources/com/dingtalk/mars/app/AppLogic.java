package com.dingtalk.mars.app;
/* loaded from: classes2.dex */
public class AppLogic {
    public static final String TAG = "bifrost.AppLogic";
    private static ICallBack callBack;

    /* loaded from: classes2.dex */
    public interface ICallBack {
        AccountInfo getAccountInfo();

        String getAppFilePath();

        int getClientVersion();

        String getCurLanguage();

        DeviceInfo getDeviceType();

        String getUtdid();
    }

    /* loaded from: classes2.dex */
    public static class AccountInfo {
        public long uin;
        public String userName;

        public AccountInfo() {
            this.uin = 0L;
            this.userName = "";
        }

        public AccountInfo(long j, String str) {
            this.uin = 0L;
            this.userName = "";
            this.uin = j;
            this.userName = str;
        }
    }

    /* loaded from: classes2.dex */
    public static class DeviceInfo {
        public String devicename;
        public String devicetype;

        public DeviceInfo(String str, String str2) {
            this.devicename = "";
            this.devicetype = "";
            this.devicename = str;
            this.devicetype = str2;
        }
    }

    public static void setCallBack(ICallBack iCallBack) {
        callBack = iCallBack;
    }

    public static String getAppFilePath() {
        ICallBack iCallBack = callBack;
        if (iCallBack == null) {
            return null;
        }
        return iCallBack.getAppFilePath();
    }

    public static String getUtdid() {
        ICallBack iCallBack = callBack;
        if (iCallBack == null) {
            return null;
        }
        return iCallBack.getUtdid();
    }

    public static AccountInfo getAccountInfo() {
        ICallBack iCallBack = callBack;
        if (iCallBack == null) {
            return null;
        }
        return iCallBack.getAccountInfo();
    }

    public static int getClientVersion() {
        ICallBack iCallBack = callBack;
        if (iCallBack == null) {
            return 0;
        }
        return iCallBack.getClientVersion();
    }

    public static DeviceInfo getDeviceType() {
        ICallBack iCallBack = callBack;
        if (iCallBack == null) {
            return null;
        }
        return iCallBack.getDeviceType();
    }

    public static String getCurLanguage() {
        ICallBack iCallBack = callBack;
        if (iCallBack == null) {
            return null;
        }
        return iCallBack.getCurLanguage();
    }
}
