package com.xiaopeng.montecarlo.navcore.sr;

import com.autonavi.gbl.lane.model.LaneSRRangeFilterParam;
import com.xiaopeng.montecarlo.navcore.bean.sr.XPSRObject;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public class SRNaviCanDataHelper implements CarServiceManager.IXPCarStateListener {
    private static final int INVALID_VALUE = -1;
    private static final L.Tag TAG = new L.Tag("SRNaviCanDataHelper");
    int mEffectEngineId = 3;
    private SRNaviManager mManager;

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuDowLeftWarning(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuDowRightWarning(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuFishEyeCamFail(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuMainCamFail(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuMrrFail(int i) {
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
    public void onScuRctaLeftWarning(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuRctaRightWarning(int i) {
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
    public void onFarLampStateChange(int i) {
        LaneServiceManager.getInstance().updateCarStyleInfo(false);
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onNearLampStateChange(int i) {
        LaneServiceManager.getInstance().updateCarStyleInfo(false);
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onLeftTurnLampActiveChange(int i) {
        onTurnLampActiveChange();
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onRightTurnLampActiveChange(int i) {
        onTurnLampActiveChange();
    }

    private void onTurnLampActiveChange() {
        boolean z = false;
        boolean z2 = 1 == CarServiceManager.getInstance().getLeftTurnLampActiveStatus();
        boolean z3 = 1 == CarServiceManager.getInstance().getRightTurnLampActiveStatus();
        LaneServiceManager.getInstance().updateCarStyleInfo(false);
        LaneServiceManager.getInstance().openLeftTurnLamp(z2 && !z3);
        LaneServiceManager.getInstance().openRightTurnLamp(z3 && !z2);
        LaneServiceManager laneServiceManager = LaneServiceManager.getInstance();
        if (z3 && z2) {
            z = true;
        }
        laneServiceManager.openEmergencyLamp(z);
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onBcmBonnetStateChange(int i) {
        if (i == 0) {
            LaneServiceManager.getInstance().openBonnet(false);
        } else if (1 == i) {
            LaneServiceManager.getInstance().openBonnet(true);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onTrunkStateChange(int i) {
        if (i == 0) {
            LaneServiceManager.getInstance().openTrunk(false);
            LaneServiceManager.getInstance().openStopTr(false);
        } else if (2 == i) {
            LaneServiceManager.getInstance().openTrunk(true);
            LaneServiceManager.getInstance().openStopTr(true);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onLFDoorStateChange(int i) {
        if (i == 0) {
            LaneServiceManager.getInstance().openLFDoor(false);
        } else if (1 == i) {
            LaneServiceManager.getInstance().openLFDoor(true);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onRFDoorStateChange(int i) {
        if (i == 0) {
            LaneServiceManager.getInstance().openRFDoor(false);
        } else if (1 == i) {
            LaneServiceManager.getInstance().openRFDoor(true);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onLBDoorStateChange(int i) {
        if (i == 0) {
            LaneServiceManager.getInstance().openLBDoor(false);
        } else if (1 == i) {
            LaneServiceManager.getInstance().openLBDoor(true);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onRBDoorStateChange(int i) {
        if (i == 0) {
            LaneServiceManager.getInstance().openRBDoor(false);
        } else if (1 == i) {
            LaneServiceManager.getInstance().openRBDoor(true);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onBrakeLightStateChange(int i) {
        LaneServiceManager.getInstance().updateCarStyleInfo(false);
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuMrrAssist(int i, int i2, int i3, int i4) {
        if (1 == i3 || 2 == i3) {
            LaneServiceManager.getInstance().setWarnInfo(this.mEffectEngineId, 3);
        } else if (1 == i4 || 2 == i4) {
            LaneServiceManager.getInstance().setWarnInfo(this.mEffectEngineId, 4);
        } else if (1 == i2 || 2 == i2 || 3 == i2 || 4 == i2) {
            LaneServiceManager.getInstance().setWarnInfo(this.mEffectEngineId, 2);
        } else {
            LaneServiceManager.getInstance().setWarnInfo(this.mEffectEngineId, 1);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuRcwWarning(int i) {
        if (1 == i || 2 == i) {
            LaneServiceManager.getInstance().setWarnInfo(this.mEffectEngineId, 6);
        } else if (i == 0) {
            LaneServiceManager.getInstance().setWarnInfo(this.mEffectEngineId, 5);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onVpmLdwLeftWarning(int i) {
        if (2 == i) {
            LaneServiceManager.getInstance().setLDWWarning(this.mEffectEngineId, 14, true);
        } else if (1 == i || 3 == i) {
            LaneServiceManager.getInstance().setLDWWarning(this.mEffectEngineId, 15, true);
        } else if (i == 0) {
            LaneServiceManager.getInstance().setLDWWarning(this.mEffectEngineId, 13, false);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onVpmLdwRightWarning(int i) {
        if (2 == i) {
            LaneServiceManager.getInstance().setLDWWarning(this.mEffectEngineId, 17, true);
        } else if (1 == i || 3 == i) {
            LaneServiceManager.getInstance().setLDWWarning(this.mEffectEngineId, 18, true);
        } else if (i == 0) {
            LaneServiceManager.getInstance().setLDWWarning(this.mEffectEngineId, 16, false);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuBsdLeftWarning(int i) {
        if (1 == i) {
            LaneServiceManager.getInstance().setWarnInfo(this.mEffectEngineId, 7);
        } else if (2 == i) {
            LaneServiceManager.getInstance().setWarnInfo(this.mEffectEngineId, 9);
        } else if (i == 0) {
            LaneServiceManager.getInstance().setWarnInfo(this.mEffectEngineId, 7);
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuBsdRightWarning(int i) {
        if (1 == i) {
            LaneServiceManager.getInstance().setWarnInfo(this.mEffectEngineId, 10);
        } else if (2 == i) {
            LaneServiceManager.getInstance().setWarnInfo(this.mEffectEngineId, 12);
        } else if (i == 0) {
            LaneServiceManager.getInstance().setWarnInfo(this.mEffectEngineId, 10);
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
    public void onNGPSwitchTranstionChange(int i) {
        LaneSRRangeFilterParam laneSRRangeFilterParam = new LaneSRRangeFilterParam();
        if (1 == i || 4 == i) {
            laneSRRangeFilterParam.exceptTypes.addAll(XPSRObject.getVRUTypeList());
            laneSRRangeFilterParam.exceptTypes.addAll(XPSRObject.getStaticTypeList());
            LaneServiceManager.getInstance().setSRRangeFilterParam(laneSRRangeFilterParam);
        } else if (i == 0 || 2 == i || 3 == i) {
            laneSRRangeFilterParam.exceptTypes.addAll(XPSRObject.getVRUTypeList());
            LaneServiceManager.getInstance().setSRRangeFilterParam(laneSRRangeFilterParam);
        }
    }

    public int getCruiseSpeed() {
        return CarServiceManager.getInstance().getCruiseSpeed();
    }

    public int getScuQuitNgpOddStatus() {
        int scuQuitNgpOddStatus = CarServiceManager.getInstance().getScuQuitNgpOddStatus();
        if (scuQuitNgpOddStatus < 0 || scuQuitNgpOddStatus > 7) {
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
