package com.xiaopeng.montecarlo.root.util;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
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
    private com.xiaopeng.aftersales.manager.AfterSalesManager mAfterSalesManagerV2 = null;

    private AfterSalesUtil() {
    }

    public static AfterSalesUtil getInstance() {
        return sAfterSalesUtil;
    }

    public void init() {
        if (Build.VERSION.SDK_INT == 28) {
            this.mAfterSalesManager = (AfterSalesManager) ContextUtils.getContext().getSystemService(AfterSalesManager.SERVICE_NAME);
            L.i(TAG, "AfterSalesManager getSystemService inited");
            return;
        }
        this.mAfterSalesManagerV2 = com.xiaopeng.aftersales.manager.AfterSalesManager.createAfterSalesManager(ContextUtils.getContext(), new ServiceConnection() { // from class: com.xiaopeng.montecarlo.root.util.AfterSalesUtil.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                L.i(AfterSalesUtil.TAG, "AfterSalesManagerV2 onServiceConnected");
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                L.i(AfterSalesUtil.TAG, "AfterSalesManagerV2 onServiceDisconnected");
            }
        }, new Handler(WorkThreadUtil.getInstance().getLocationThreadLooper()));
        com.xiaopeng.aftersales.manager.AfterSalesManager afterSalesManager = this.mAfterSalesManagerV2;
        if (afterSalesManager != null) {
            afterSalesManager.connect();
        }
        L.i(TAG, "AfterSalesManagerV2 createAfterSalesManager inited");
    }

    public void recordDiagnosisError(int i, String str) {
        AfterSalesManager afterSalesManager = this.mAfterSalesManager;
        if (afterSalesManager != null) {
            afterSalesManager.recordDiagnosisError(9, i, System.currentTimeMillis(), str, true);
            return;
        }
        com.xiaopeng.aftersales.manager.AfterSalesManager afterSalesManager2 = this.mAfterSalesManagerV2;
        if (afterSalesManager2 != null && afterSalesManager2.isConnected()) {
            this.mAfterSalesManagerV2.recordDiagnosisError(9, i, System.currentTimeMillis(), str, true);
        } else {
            L.w(TAG, "AfterSalesManager both are unvalid");
        }
    }
}
