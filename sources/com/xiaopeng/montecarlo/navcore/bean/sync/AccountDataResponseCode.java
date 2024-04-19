package com.xiaopeng.montecarlo.navcore.bean.sync;

import com.xiaopeng.montecarlo.root.account.AccountException;
/* loaded from: classes2.dex */
public class AccountDataResponseCode {
    public static final int ACCOUNT_CENTER_FAIL = 11082103;
    public static final int DUPLICATE_LOGIC_CLEAR = 11082202;
    public static final int LOCAL_SERVER_VERSION_INCONFORM = 11081122;
    public static final int RESULT_OK = 200;
    public static final int SESSION_EXPIRE = 11081120;
    public static final int SESSION_ID_INVALID = 11080004;

    /* loaded from: classes2.dex */
    public static class ErrorType {
        public static final int SYNC_ERR_TYPE_EXIST = 2;
        public static final int SYNC_ERR_TYPE_INVALID_DATA_FMT = 5;
        public static final int SYNC_ERR_TYPE_INVALID_DATA_TYPE = 3;
        public static final int SYNC_ERR_TYPE_INVALID_OP_TYPE = 4;
        public static final int SYNC_ERR_TYPE_NOT_EXIST = 1;
        public static final int SYNC_ERR_TYPE_OTHER = 99;
        public static final int SYNC_ERR_TYPE_SAME_DATA_ID = 6;
    }

    public static String getMessageByCode(int i) {
        if (i != 11080004) {
            if (i != 11081120) {
                if (i != 11082103) {
                    return null;
                }
                return "获取绑定账号信息失败：用户中心返回错误";
            }
            return "sid过期 需要刷新";
        }
        return "会话失效,需要重新登录";
    }

    public static boolean isNeedReLogin(int i) {
        return i == 11080004 || i == 11082103;
    }

    public static boolean isServerSessionError(int i) {
        return i == 11081120 || i == 11080004 || i == 11082103;
    }

    public static AccountException newAccountException(int i) {
        return new AccountException(i, getMessageByCode(i));
    }
}
