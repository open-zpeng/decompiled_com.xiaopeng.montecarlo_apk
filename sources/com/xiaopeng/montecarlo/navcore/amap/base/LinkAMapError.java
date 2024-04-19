package com.xiaopeng.montecarlo.navcore.amap.base;

import com.xiaopeng.montecarlo.root.account.AccountException;
/* loaded from: classes2.dex */
public interface LinkAMapError {
    public static final int ERROR_CODE_CHECK_MAP_SERVER_SID_OPENID = 310;
    public static final int ERROR_CODE_REQUEST_ACCOUNT_CENTER_FAIL = 316;
    public static final int ERROR_CODE_REQUEST_AMAP_ACCOUNT_NULL = 308;
    public static final int ERROR_CODE_REQUEST_AMAP_UID_NULL = 307;
    public static final int ERROR_CODE_REQUEST_CAR_LTD_BIND = 304;
    public static final int ERROR_CODE_REQUEST_CAR_LTD_CHECK_TOKEN = 306;
    public static final int ERROR_CODE_REQUEST_CAR_LTD_QUICK_LOGIN = 303;
    public static final int ERROR_CODE_REQUEST_CAR_LTD_UNBIND = 301;
    public static final int ERROR_CODE_REQUEST_GET_AMAP_CODE_LOGIN = 305;
    public static final int ERROR_CODE_REQUEST_LOGIN_XMAP_SERVER_FAIL = 315;
    public static final int ERROR_CODE_REQUEST_LOGOUT_AMAP_FAIL = 317;
    public static final int ERROR_CODE_REQUEST_LOGOUT_XMAP_SERVER_FAIL = 319;
    public static final int ERROR_CODE_REQUEST_QRCODE_LOGIN_CONFIRM_RESULT_FAIL = 309;
    public static final int ERROR_CODE_REQUEST_SID_EXPIRE_FAIL = 313;
    public static final int ERROR_CODE_REQUEST_SID_INVALID_FAIL = 314;

    static String getMessageByCode(int i) {
        switch (i) {
            case 301:
                return "解绑高德失败";
            case 302:
            case 311:
            case 312:
            case 318:
            default:
                return "LinkAMapError不能识别的错误";
            case 303:
                return "高德的快速登录请求失败";
            case 304:
                return "高德绑定失败";
            case 305:
                return "获取高德二维码失败";
            case 306:
                return "小鹏注册的手机不存在高德帐号";
            case 307:
                return "amap uid is null";
            case 308:
                return "高德账号是null";
            case 309:
                return "请求二维码登录失败";
            case 310:
                return "查询登录地图后台userid和sid为空";
            case 313:
                return "sid过期 需要刷新";
            case 314:
                return "会话失效,需要重新登录";
            case 315:
                return "登录小鹏后台失败";
            case 316:
                return "获取绑定账号信息失败：用户中心返回错误";
            case 317:
                return "退登高德账号失败";
            case 319:
                return "退登小鹏账号失败";
        }
    }

    static AccountException newAccountException(int i) {
        return new AccountException(i, getMessageByCode(i));
    }
}
