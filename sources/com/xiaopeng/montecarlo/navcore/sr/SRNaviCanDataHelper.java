package com.xiaopeng.montecarlo.navcore.sr;

import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes2.dex */
public class SRNaviCanDataHelper implements CarServiceManager.IXPCarStateListener {
    private static final int INVALID_VALUE = -1;
    private static final L.Tag TAG = new L.Tag("SRNaviCanDataHelper");
    private SRNaviManager mManager;

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuFishEyeCamFail(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuMainCamFail(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuNarrowCamFail(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuNgpLcTips1(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuQuitNgpOdd(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuSideCamFail(int i, int i2, int i3, int i4, int i5) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onSrrFLFail(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onSrrFRFail(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onSrrRLFail(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onSrrRRFail(int i) {
    }

    public SRNaviCanDataHelper(SRNaviManager sRNaviManager) {
        this.mManager = sRNaviManager;
    }

    public void start() {
        CarServiceManager.getInstance().addCarStateListener(this);
    }

    public void stop() {
        CarServiceManager.getInstance().removeCarStateListener(this);
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onVpmLdwLeftWarning(int i) {
        SRNaviManager sRNaviManager = this.mManager;
        if (sRNaviManager != null) {
            sRNaviManager.sendCanWarningInfo(0, i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onVpmLdwRightWarning(int i) {
        SRNaviManager sRNaviManager = this.mManager;
        if (sRNaviManager != null) {
            sRNaviManager.sendCanWarningInfo(1, i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuMrrAssist(int i, int i2, int i3, int i4) {
        SRNaviManager sRNaviManager = this.mManager;
        if (sRNaviManager != null) {
            sRNaviManager.sendCanWarningInfo(2, i2);
            this.mManager.sendCanWarningInfo(3, i3);
            this.mManager.sendCanWarningInfo(4, i4);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuMrrFail(int i) {
        SRNaviManager sRNaviManager = this.mManager;
        if (sRNaviManager != null) {
            sRNaviManager.sendCanWarningInfo(5, i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuBsdLeftWarning(int i) {
        SRNaviManager sRNaviManager = this.mManager;
        if (sRNaviManager != null) {
            sRNaviManager.sendCanWarningInfo(6, i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuBsdRightWarning(int i) {
        SRNaviManager sRNaviManager = this.mManager;
        if (sRNaviManager != null) {
            sRNaviManager.sendCanWarningInfo(7, i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuDowRightWarning(int i) {
        SRNaviManager sRNaviManager = this.mManager;
        if (sRNaviManager != null) {
            sRNaviManager.sendCanWarningInfo(8, i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuDowLeftWarning(int i) {
        SRNaviManager sRNaviManager = this.mManager;
        if (sRNaviManager != null) {
            sRNaviManager.sendCanWarningInfo(9, i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuRctaLeftWarning(int i) {
        SRNaviManager sRNaviManager = this.mManager;
        if (sRNaviManager != null) {
            sRNaviManager.sendCanWarningInfo(10, i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuRctaRightWarning(int i) {
        SRNaviManager sRNaviManager = this.mManager;
        if (sRNaviManager != null) {
            sRNaviManager.sendCanWarningInfo(11, i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuRcwWarning(int i) {
        SRNaviManager sRNaviManager = this.mManager;
        if (sRNaviManager != null) {
            sRNaviManager.sendCanWarningInfo(12, i);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuCruiseSpeedByCan(int i) {
        this.mManager.onCruiseSpeed(i);
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuNgpOpeButtonByCan(int i) {
        this.mManager.onScuNgpOpeButton(i);
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuNgpInfoTips1ByCan(int i) {
        this.mManager.onScuNgpInfoTips1(i);
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuNgpTipsWindowByCan(int i) {
        this.mManager.onScuNgpTipsWindow(i);
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onFarLampStateChange(int i) {
        this.mManager.onFarLampStateChange(i);
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onNearLampStateChange(int i) {
        this.mManager.onNearLampStateChange(i);
    }

    public int getCruiseSpeed() {
        return CarServiceManager.getInstance().getCruiseSpeed();
    }

    public int getScuQuitNgpOddStatus() {
        int scuQuitNgpOddStatus = CarServiceManager.getInstance().getScuQuitNgpOddStatus();
        if (scuQuitNgpOddStatus < 0 || scuQuitNgpOddStatus > 6) {
            return -1;
        }
        return scuQuitNgpOddStatus;
    }

    public int getScuNgpOpeButtonStatus() {
        int scuNgpOpeButtonStatus = CarServiceManager.getInstance().getScuNgpOpeButtonStatus();
        if (scuNgpOpeButtonStatus < 0 || scuNgpOpeButtonStatus > 7) {
            return -1;
        }
        return scuNgpOpeButtonStatus;
    }

    public void setScuNgpOpeButtonStatus(int i) {
        if (i >= 0 && i <= 7) {
            CarServiceManager.getInstance().setScuNgpOpeButtonStatus(i);
            return;
        }
        L.Tag tag = TAG;
        L.e(tag, "setScuNgpOpeButtonStatus error:" + i);
    }

    public int getScuNgpLcTips1Status() {
        int scuNgpLcTips1Status = CarServiceManager.getInstance().getScuNgpLcTips1Status();
        if (scuNgpLcTips1Status < 0 || scuNgpLcTips1Status > 57) {
            return -1;
        }
        return scuNgpLcTips1Status;
    }

    public int getScuNgpInfoTips1Status() {
        int scuNgpInfoTips1Status = CarServiceManager.getInstance().getScuNgpInfoTips1Status();
        if (scuNgpInfoTips1Status < 0 || scuNgpInfoTips1Status > 15) {
            return -1;
        }
        return scuNgpInfoTips1Status;
    }

    public int getScuNgpTipsWindowStatus() {
        int scuNgpTipsWindowStatus = CarServiceManager.getInstance().getScuNgpTipsWindowStatus();
        if (scuNgpTipsWindowStatus < 0 || scuNgpTipsWindowStatus > 1) {
            return -1;
        }
        return scuNgpTipsWindowStatus;
    }

    public void setScuNgpTipsWindowStatus(int i) {
        if (i >= 0 && i <= 1) {
            CarServiceManager.getInstance().setScuNgpTipsWindowStatus(i);
            return;
        }
        L.Tag tag = TAG;
        L.e(tag, "setScuNgpTipsWindowStatus error:" + i);
    }
}
