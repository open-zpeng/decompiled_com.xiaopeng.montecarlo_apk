package com.xiaopeng.montecarlo.navcore.account;
/* loaded from: classes2.dex */
public interface AuthInfoError {
    public static final int ERROR_CODE_AUTH_DENIED = 10002;
    public static final int ERROR_CODE_AUTH_REQUEST_FAIL = 10005;
    public static final int ERROR_CODE_AUTH_TIMEOUT = 10004;
    public static final int ERROR_CODE_CAR_NOT_STOPPED = 20001;
    public static final int ERROR_CODE_USER_CANCEL = 10001;
    public static final int ERROR_CODE_USER_CLOSE_QRCODE = 20002;
    public static final int ERROR_CODE_USER_LOGOUT = 10003;

    static String getMessageByCode(int i) {
        if (i != 20001) {
            if (i != 20002) {
                switch (i) {
                    case 10001:
                        return "用户取消授权";
                    case 10002:
                        return "用户拒绝授权";
                    case 10003:
                        return com.xiaopeng.lib.framework.moduleinterface.accountmodule.IError.STR_USER_LOGOUT;
                    case 10004:
                        return "用户授权超时";
                    case 10005:
                        return com.xiaopeng.lib.framework.moduleinterface.accountmodule.IError.STR_REQUEST_FAILED;
                    default:
                        return com.xiaopeng.lib.framework.moduleinterface.accountmodule.IError.STR_UNKNOWN_ERR;
                }
            }
            return "操作已取消";
        }
        return "车辆行驶中，暂不能进行该操作";
    }
}
