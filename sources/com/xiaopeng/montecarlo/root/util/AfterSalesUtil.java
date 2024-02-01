package com.xiaopeng.montecarlo.root.util;

import com.xiaopeng.aftersales.AfterSalesManager;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public class AfterSalesUtil {
    public static final int ERROR_CODE_ACTIVATE_FAIL = 9002;
    public static final int ERROR_CODE_AMAP_POS_ENGINE_STOP = 9005;
    public static final int ERROR_CODE_AUTOPILOT_IMU = 9001;
    public static final int ERROR_CODE_GNSS_OUTAGE = 9000;
    public static final int ERROR_CODE_GNSS_OUTAGE_WARNING_OPEN_TBOX_LOG = 9003;
    public static final int ERROR_CODE_REMOTE_LOG_OPEN = 9006;
    public static final int ERROR_CODE_VMAP_NO_ENOUGH_SPACE = 9004;
    private static final L.Tag TAG = new L.Tag("AfterSalesUtil");
    private static AfterSalesUtil sAfterSalesUtil = new AfterSalesUtil();
    private AfterSalesManager mAfterSalesManager = null;

    private AfterSalesUtil() {
    }

    public static AfterSalesUtil getInstance() {
        return sAfterSalesUtil;
    }

    public void init() {
        this.mAfterSalesManager = (AfterSalesManager) ContextUtils.getContext().getSystemService(AfterSalesManager.SERVICE_NAME);
    }

    public void recordDiagnosisError(int i, String str) {
        AfterSalesManager afterSalesManager = this.mAfterSalesManager;
        if (afterSalesManager != null) {
            afterSalesManager.recordDiagnosisError(9, i, System.currentTimeMillis(), str, true);
        } else {
            L.w(TAG, "mAfterSalesManager is null");
        }
    }
}
