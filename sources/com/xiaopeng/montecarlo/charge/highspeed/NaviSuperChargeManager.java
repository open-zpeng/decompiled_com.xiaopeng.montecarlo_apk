package com.xiaopeng.montecarlo.charge.highspeed;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaopeng.lib.framework.ipcmodule.IpcModuleEntry;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import com.xiaopeng.montecarlo.navcore.apirouter.IpcRouterUtil;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.powerdistance.OnUpdateRemainDisListener;
import com.xiaopeng.montecarlo.navcore.powerdistance.route.RoutePowerDisHelper;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.util.Utils;
/* loaded from: classes.dex */
public class NaviSuperChargeManager {
    private static final int IPC_NOTIFY_DELAY = 3000;
    private static final int MSG_CHECK = 0;
    private static final int MSG_NOTIFY = 1;
    private static final int STATE_CLOSE = 0;
    private static final int STATE_OPEN = 1;
    private static final L.Tag TAG = new L.Tag("NaviSuperChargeManager");
    private boolean mDesToXPCharge;
    protected Handler mHandler;
    private int mLastRemain;
    private boolean mNavi;
    private RoutePowerDisHelper mRoutePowerDisHelper;
    private int mWayPointRemain;
    private int mState = 0;
    private final OnUpdateRemainDisListener mOnRemainDisListener = new OnUpdateRemainDisListener() { // from class: com.xiaopeng.montecarlo.charge.highspeed.NaviSuperChargeManager.1
        @Override // com.xiaopeng.montecarlo.navcore.powerdistance.OnUpdateRemainDisListener
        public void onUpdateRemainDis(final long j, final int i, final int i2) {
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.charge.highspeed.NaviSuperChargeManager.1.1
                @Override // java.lang.Runnable
                public void run() {
                    if (L.ENABLE) {
                        L.Tag tag = NaviSuperChargeManager.TAG;
                        L.d(tag, "onUpdateRemainDis, pathId: " + j + "routeRemainDis: " + i + "remainDis: " + i2);
                    }
                    NaviSuperChargeManager.this.mWayPointRemain = i2;
                    NaviSuperChargeManager.this.updateRemainInfo(NaviSuperChargeManager.this.mWayPointRemain);
                }
            });
        }
    };

    public NaviSuperChargeManager() {
        if (Utils.isLandscape()) {
            this.mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.xiaopeng.montecarlo.charge.highspeed.NaviSuperChargeManager.2
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    int i = message.what;
                    if (i == 0) {
                        NaviSuperChargeManager.this.checkState();
                        return false;
                    } else if (i != 1) {
                        return false;
                    } else {
                        NaviSuperChargeManager.this.notifyChargeControlByIpc();
                        return false;
                    }
                }
            });
        } else {
            L.i(TAG, "no support for PORTRAIT device");
        }
    }

    public void updateNaviInfo(boolean z) {
        Handler handler = this.mHandler;
        if (handler != null) {
            this.mNavi = z;
            boolean z2 = false;
            if (this.mNavi) {
                XPPoiInfo endInfo = TBTManager.getInstance().getEndInfo(TBTManager.getInstance().getCurrentRouteRequestId());
                if (endInfo != null && XPPoiCategory.isXPSelfCharge(endInfo.getCategory())) {
                    z2 = true;
                }
                this.mDesToXPCharge = z2;
                updateNaviRemainInfo();
                return;
            }
            handler.obtainMessage(0).sendToTarget();
        }
    }

    public void updateNaviRemainInfo() {
        if (this.mHandler != null) {
            requestLeftDis();
        }
    }

    public void updateRemainInfo(int i) {
        Handler handler = this.mHandler;
        if (handler != null) {
            this.mLastRemain = i;
            handler.obtainMessage(0).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkState() {
        int i = 0;
        if (this.mNavi) {
            if (this.mDesToXPCharge && this.mLastRemain >= 30000) {
                i = 1;
            } else if (this.mDesToXPCharge) {
                int i2 = this.mLastRemain;
            }
        }
        if (i != this.mState) {
            L.i(TAG, "update cur super charge state: " + i + ", old state: " + this.mState);
            this.mState = i;
            Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(1));
        } else if (i == 1) {
            if (L.ENABLE) {
                L.d(TAG, "ignore open cmd, cur super charge state: " + i + ", old state: " + this.mState);
            }
        } else {
            Handler handler2 = this.mHandler;
            handler2.sendMessageDelayed(handler2.obtainMessage(1), 3000L);
        }
        if (L.ENABLE) {
            L.d(TAG, "notify , mNavi: " + this.mNavi + ", mDesToXPCharge: " + this.mDesToXPCharge + ", mRemain: " + this.mLastRemain + ", state: " + i + ", mState: " + this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyChargeControlByIpc() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(IpcConfig.IPCKey.BOOLEAN_VALUE, this.mState == 1);
        if (CarFeatureManager.INSTANCE.isIpcExchange2Apirouter()) {
            IpcRouterUtil.sendData((int) IpcConfig.ChargeConfig.IPC_ID_HIGH_SPEED_CHARGE, bundle, "com.xiaopeng.chargecontrol");
        } else {
            ((IIpcService) Module.get(IpcModuleEntry.class).get(IIpcService.class)).sendData(IpcConfig.ChargeConfig.IPC_ID_HIGH_SPEED_CHARGE, bundle, "com.xiaopeng.chargecontrol");
        }
        L.Tag tag = TAG;
        L.i(tag, "updateHighSpeedChargeState: " + this.mState);
        if (this.mNavi) {
            return;
        }
        this.mState = 0;
        this.mLastRemain = 0;
        this.mDesToXPCharge = false;
        RoutePowerDisHelper routePowerDisHelper = this.mRoutePowerDisHelper;
        if (routePowerDisHelper != null) {
            routePowerDisHelper.close();
            this.mRoutePowerDisHelper = null;
        }
    }

    private void requestLeftDis() {
        int i;
        int i2;
        int i3;
        XPNaviInfo naviInfo = TBTManager.getInstance().getNaviInfo();
        if (naviInfo != null) {
            int i4 = naviInfo.mCurSegIdx;
            int i5 = naviInfo.mCurLinkIdx;
            i3 = (int) naviInfo.mRouteRemainDist;
            i = i4;
            i2 = i5;
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
        }
        if (L.ENABLE) {
            L.d(TAG, hashCode() + " sapa request online distance: , startSeq:" + i + ", startLink:" + i2 + ", dis:" + i3);
        }
        if (i3 == 0 && i2 == 0 && i2 == 0) {
            L.i(TAG, "ignore: , startSeq:" + i + ", startLink:" + i2 + ", dis:" + i3);
            return;
        }
        IVariantPath currentNaviVariantPath = TBTManager.getInstance().getCurrentNaviVariantPath();
        IPathResult currentNaviPathResult = TBTManager.getInstance().getCurrentNaviPathResult();
        if (currentNaviVariantPath == null || currentNaviPathResult == null) {
            L.i(TAG, "requestPathPointRemainDis return (path null)");
            this.mOnRemainDisListener.onUpdateRemainDis(0L, i3, 0);
            return;
        }
        if (this.mRoutePowerDisHelper == null) {
            this.mRoutePowerDisHelper = new RoutePowerDisHelper(this.mOnRemainDisListener);
        }
        this.mRoutePowerDisHelper.updateRemainDis(i, i2, i3, currentNaviVariantPath, currentNaviPathResult);
    }
}
