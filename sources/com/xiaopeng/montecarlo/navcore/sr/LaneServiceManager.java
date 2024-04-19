package com.xiaopeng.montecarlo.navcore.sr;

import androidx.annotation.NonNull;
import com.autonavi.gbl.lane.model.Decision;
import com.autonavi.gbl.lane.model.LaneDtoModelConstants;
import com.autonavi.gbl.lane.model.LaneMapViewParam;
import com.autonavi.gbl.lane.model.LaneSRRangeFilterParam;
import com.autonavi.gbl.lane.model.SRObject;
import com.autonavi.gbl.lane.model.SRObjects;
import com.autonavi.gbl.lane.model.WarnInfos;
import com.autonavi.gbl.lane.model.WarningPartsAnimation;
import com.autonavi.gbl.lane.model.WarningPartsAnimationFade;
import com.autonavi.gbl.lane.model.WarningPartsStyle;
import com.autonavi.gbl.map.model.MapModelConstants;
import com.xiaopeng.montecarlo.navcore.bean.sr.XPSRObject;
import com.xiaopeng.montecarlo.navcore.sr.LaneServicePlayRecordWrapper;
import com.xiaopeng.montecarlo.navcore.sr.data.HappyEnding;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class LaneServiceManager {
    public static final int ACTION_SR_LIGHT_BOTH_OFF = 4;
    public static final int ACTION_SR_LIGHT_BOTH_ON = 3;
    public static final int ACTION_SR_LIGHT_LEFT_ON = 1;
    public static final int ACTION_SR_LIGHT_NONE = 0;
    public static final int ACTION_SR_LIGHT_RIGHT_ON = 2;
    private static final float DEFAULT_HIGH_SPEED_LEVEL_D55_MAIN_SCREEN = 19.6f;
    private static final float DEFAULT_HIGH_SPEED_LEVEL_D55_SUB_SCREEN = 19.9f;
    private static final float DEFAULT_HIGH_SPEED_LEVEL_E28_MAIN_SCREEN = 19.3f;
    private static final float DEFAULT_LOW_SPEED_LEVEL_D55_MAIN_SCREEN = 19.8f;
    private static final float DEFAULT_LOW_SPEED_LEVEL_D55_SUB_SCREEN = 20.0f;
    private static final float DEFAULT_LOW_SPEED_LEVEL_E28_MAIN_SCREEN = 19.6f;
    public static final int WARNING_TYPE_AEB = 4;
    public static final int WARNING_TYPE_BACK_NONE = 5;
    public static final int WARNING_TYPE_BSD_LEFT_LEVEL1 = 8;
    public static final int WARNING_TYPE_BSD_LEFT_LEVEL2 = 9;
    public static final int WARNING_TYPE_BSD_LEFT_NONE = 7;
    public static final int WARNING_TYPE_BSD_RIGHT_LEVEL1 = 11;
    public static final int WARNING_TYPE_BSD_RIGHT_LEVEL2 = 12;
    public static final int WARNING_TYPE_BSD_RIGHT_NONE = 10;
    public static final int WARNING_TYPE_EBA = 3;
    public static final int WARNING_TYPE_FCW = 2;
    public static final int WARNING_TYPE_FRONT_NONE = 1;
    public static final int WARNING_TYPE_LDW_LEFT = 14;
    public static final int WARNING_TYPE_LDW_LEFT_NONE = 13;
    public static final int WARNING_TYPE_LDW_RIGHT = 17;
    public static final int WARNING_TYPE_LDW_RIGHT_NONE = 16;
    public static final int WARNING_TYPE_LKA_LEFT = 15;
    public static final int WARNING_TYPE_LKA_RIGHT = 18;
    public static final int WARNING_TYPE_RCW = 6;
    private float mCurrentAnchorInLevel;
    private float mCurrentAnchorOutLevel;
    private float mCurrentHighSpeedLevel;
    private float mCurrentLowSpeedLevel;
    private HappyEndingManager mHappyEndingManager;
    private LaneNaviServiceWrapper mLaneNaviServiceWrapper;
    private LaneResourceManager mLaneResourceManager;
    private LaneServicePlayRecordWrapper mLaneServicePlayRecordWrapper;
    private LaneServiceWrapper mLaneServiceWrapper;
    private static final L.Tag TAG = new L.Tag("LaneServiceManager");
    private static final LaneServiceManager sInstance = new LaneServiceManager();
    private HashMap<Integer, LaneRenderServiceWrapper> mLaneRenderServiceWrapperHashMap = new HashMap<>();
    private boolean mIsDay = true;
    private boolean mIsPlayAMapLaneData = false;

    public static LaneServiceManager getInstance() {
        return sInstance;
    }

    public void init() {
        if (CarServiceManager.getInstance().hasXpuForNgp()) {
            this.mLaneResourceManager = new LaneResourceManager();
            this.mLaneServiceWrapper = new LaneServiceWrapper(this.mLaneResourceManager.getILaneResourceProxy());
            this.mLaneNaviServiceWrapper = new LaneNaviServiceWrapper(this.mLaneServiceWrapper.createLaneRenderService());
            this.mLaneServicePlayRecordWrapper = new LaneServicePlayRecordWrapper(this.mLaneServiceWrapper.createLaneServicePlayer(), this.mLaneServiceWrapper.createLaneServiceRecorder());
            this.mLaneNaviServiceWrapper.openLaneWork(true);
            this.mLaneNaviServiceWrapper.openNaviLine(SRNaviManager.getInstance().isLaneEnabled());
            this.mLaneNaviServiceWrapper.enterLane(true);
            if (CarFeatureManager.INSTANCE.isHappyEndingEnable()) {
                this.mHappyEndingManager = new HappyEndingManager();
            }
        }
    }

    public void unInit() {
        for (LaneRenderServiceWrapper laneRenderServiceWrapper : this.mLaneRenderServiceWrapperHashMap.values()) {
            this.mLaneServiceWrapper.unInit(laneRenderServiceWrapper.unInit());
        }
        LaneNaviServiceWrapper laneNaviServiceWrapper = this.mLaneNaviServiceWrapper;
        if (laneNaviServiceWrapper != null) {
            laneNaviServiceWrapper.unInit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getModelResId(int i) {
        LaneResourceManager laneResourceManager = this.mLaneResourceManager;
        if (laneResourceManager == null) {
            return -1;
        }
        return laneResourceManager.getModelResId(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fillPartsStyle(int i, int i2, int i3, SRObject sRObject) {
        LaneResourceManager laneResourceManager = this.mLaneResourceManager;
        if (laneResourceManager == null) {
            return;
        }
        laneResourceManager.fillPartsStyle(i, i2, i3, sRObject, this.mIsDay);
    }

    public void setAutopilotData(@NonNull byte[] bArr) {
        LaneServiceWrapper laneServiceWrapper = this.mLaneServiceWrapper;
        if (laneServiceWrapper != null) {
            laneServiceWrapper.setAutopilotData(bArr);
        }
    }

    public void setEHPVersion(String str) {
        LaneServiceWrapper laneServiceWrapper = this.mLaneServiceWrapper;
        if (laneServiceWrapper != null) {
            laneServiceWrapper.setEHPVersion(str);
        }
    }

    public void setDriveMode(int i) {
        boolean isNgpDriveMode = SRDataUtil.isNgpDriveMode(i);
        L.Tag tag = TAG;
        L.i(tag, "setDriveMode mode:" + i + ", isNgp:" + isNgpDriveMode);
        LaneServiceWrapper laneServiceWrapper = this.mLaneServiceWrapper;
        if (laneServiceWrapper != null) {
            laneServiceWrapper.setDriveMode(isNgpDriveMode ? 1 : 2);
        }
        HappyEndingManager happyEndingManager = this.mHappyEndingManager;
        if (happyEndingManager != null) {
            happyEndingManager.setInCityNGP(SRDataUtil.isCNGPDriveMode(i));
        }
    }

    public void enterLane(int i, boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "enterLane engineId:" + i + ", enter:" + z);
        LaneRenderServiceWrapper laneRenderServiceWrapper = this.mLaneRenderServiceWrapperHashMap.get(Integer.valueOf(i));
        if (laneRenderServiceWrapper != null) {
            laneRenderServiceWrapper.enterLane(z);
            laneRenderServiceWrapper.openFollowMode(z);
            laneRenderServiceWrapper.updateDynamicViewAngle(z);
            laneRenderServiceWrapper.openNaviLine(z && !SRDataUtil.isNgpDriveMode(SRNaviManager.getInstance().getDriveMode()) && SRNaviManager.getInstance().isLaneEnabled());
        }
    }

    public void attachToMapView(long j) {
        L.Tag tag = TAG;
        L.i(tag, "attachToMapView engineId:" + j);
        int i = (int) j;
        LaneRenderServiceWrapper laneRenderServiceWrapper = this.mLaneRenderServiceWrapperHashMap.get(Integer.valueOf(i));
        if (laneRenderServiceWrapper == null) {
            laneRenderServiceWrapper = new LaneRenderServiceWrapper(i, this.mLaneServiceWrapper.createLaneRenderService(this.mLaneResourceManager.getILaneResourceProxy(), i));
            this.mLaneRenderServiceWrapperHashMap.put(Integer.valueOf(i), laneRenderServiceWrapper);
        }
        attachToMapView(i);
        laneRenderServiceWrapper.updateStyle(this.mIsDay);
        laneRenderServiceWrapper.initSelfCarAnimation();
        initSRLevel(i);
        laneRenderServiceWrapper.updateDynamicViewAngle(false);
        laneRenderServiceWrapper.openFollowMode(false);
        laneRenderServiceWrapper.setLaneDynamicLevelSpeedThreshold(80.0f);
        laneRenderServiceWrapper.openNaviLineFishbone(true);
        laneRenderServiceWrapper.openNaviLineOutline(true);
        laneRenderServiceWrapper.setNaviLineLength(2000.0f);
        laneRenderServiceWrapper.setLaneLayerVisible(0, true);
        laneRenderServiceWrapper.setLaneLayerVisible(1, true);
        laneRenderServiceWrapper.openNaviLine(false);
        laneRenderServiceWrapper.openStaticObjectStay(false);
        LaneSRRangeFilterParam laneSRRangeFilterParam = new LaneSRRangeFilterParam();
        laneSRRangeFilterParam.exceptTypes.addAll(XPSRObject.getVRUTypeList());
        laneRenderServiceWrapper.setSRRangeFilterParam(laneSRRangeFilterParam);
        if (1 == i) {
            setDynamicViewMode(i, false);
        } else if (3 == i) {
            setDynamicViewMode(i, true);
            if (SRNaviManager.getInstance().canShowSRScene()) {
                enterLane(i, true);
            }
            laneRenderServiceWrapper.openShowRoadPolygon(false);
        }
    }

    public boolean updateCarStyleInfo(boolean z) {
        LaneResourceManager laneResourceManager = this.mLaneResourceManager;
        if (laneResourceManager != null) {
            if (z) {
                laneResourceManager.updateResOffset();
            }
            for (LaneRenderServiceWrapper laneRenderServiceWrapper : this.mLaneRenderServiceWrapperHashMap.values()) {
                if (laneRenderServiceWrapper != null) {
                    laneRenderServiceWrapper.setCarStyleInfo(this.mLaneResourceManager.getOffset(), this.mIsDay);
                }
            }
            return true;
        }
        return true;
    }

    public void onSwitchTheme(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "onSwitchTheme isDay:" + z + ", mIsDay:" + this.mIsDay);
        if (this.mIsDay == z) {
            return;
        }
        this.mIsDay = z;
        for (LaneRenderServiceWrapper laneRenderServiceWrapper : this.mLaneRenderServiceWrapperHashMap.values()) {
            if (laneRenderServiceWrapper != null) {
                laneRenderServiceWrapper.updateStyle(this.mIsDay);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean openLFDoor(boolean z) {
        for (LaneRenderServiceWrapper laneRenderServiceWrapper : this.mLaneRenderServiceWrapperHashMap.values()) {
            if (laneRenderServiceWrapper != null) {
                laneRenderServiceWrapper.openLFDoor(z);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean openRFDoor(boolean z) {
        for (LaneRenderServiceWrapper laneRenderServiceWrapper : this.mLaneRenderServiceWrapperHashMap.values()) {
            if (laneRenderServiceWrapper != null) {
                laneRenderServiceWrapper.openRFDoor(z);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean openLBDoor(boolean z) {
        for (LaneRenderServiceWrapper laneRenderServiceWrapper : this.mLaneRenderServiceWrapperHashMap.values()) {
            if (laneRenderServiceWrapper != null) {
                laneRenderServiceWrapper.openLBDoor(z);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean openRBDoor(boolean z) {
        for (LaneRenderServiceWrapper laneRenderServiceWrapper : this.mLaneRenderServiceWrapperHashMap.values()) {
            if (laneRenderServiceWrapper != null) {
                laneRenderServiceWrapper.openRBDoor(z);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean openBonnet(boolean z) {
        for (LaneRenderServiceWrapper laneRenderServiceWrapper : this.mLaneRenderServiceWrapperHashMap.values()) {
            if (laneRenderServiceWrapper != null) {
                laneRenderServiceWrapper.openBonnet(z);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean openTrunk(boolean z) {
        for (LaneRenderServiceWrapper laneRenderServiceWrapper : this.mLaneRenderServiceWrapperHashMap.values()) {
            if (laneRenderServiceWrapper != null) {
                laneRenderServiceWrapper.openTrunk(z);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean openStopTr(boolean z) {
        for (LaneRenderServiceWrapper laneRenderServiceWrapper : this.mLaneRenderServiceWrapperHashMap.values()) {
            if (laneRenderServiceWrapper != null) {
                laneRenderServiceWrapper.openStopTr(z);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean openLeftTurnLamp(boolean z) {
        for (LaneRenderServiceWrapper laneRenderServiceWrapper : this.mLaneRenderServiceWrapperHashMap.values()) {
            if (laneRenderServiceWrapper != null) {
                laneRenderServiceWrapper.openLeftTurnLamp(z);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean openRightTurnLamp(boolean z) {
        for (LaneRenderServiceWrapper laneRenderServiceWrapper : this.mLaneRenderServiceWrapperHashMap.values()) {
            if (laneRenderServiceWrapper != null) {
                laneRenderServiceWrapper.openRightTurnLamp(z);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean openEmergencyLamp(boolean z) {
        for (LaneRenderServiceWrapper laneRenderServiceWrapper : this.mLaneRenderServiceWrapperHashMap.values()) {
            if (laneRenderServiceWrapper != null) {
                laneRenderServiceWrapper.openEmergencyLamp(z);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean setLDWWarning(int i, int i2, boolean z) {
        LaneRenderServiceWrapper laneRenderServiceWrapper = this.mLaneRenderServiceWrapperHashMap.get(Integer.valueOf(i));
        if (laneRenderServiceWrapper != null) {
            laneRenderServiceWrapper.setLDWWarning(i2, z, this.mIsDay);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean setSRObject(SRObjects sRObjects) {
        for (LaneRenderServiceWrapper laneRenderServiceWrapper : this.mLaneRenderServiceWrapperHashMap.values()) {
            if (laneRenderServiceWrapper != null) {
                laneRenderServiceWrapper.setSRObject(sRObjects);
            }
        }
        return true;
    }

    public boolean openSRRangeFilter(boolean z) {
        for (LaneRenderServiceWrapper laneRenderServiceWrapper : this.mLaneRenderServiceWrapperHashMap.values()) {
            if (laneRenderServiceWrapper != null) {
                laneRenderServiceWrapper.openSRRangeFilter(z);
            }
        }
        return true;
    }

    public boolean setSRRangeFilterParam(LaneSRRangeFilterParam laneSRRangeFilterParam) {
        for (LaneRenderServiceWrapper laneRenderServiceWrapper : this.mLaneRenderServiceWrapperHashMap.values()) {
            if (laneRenderServiceWrapper != null) {
                laneRenderServiceWrapper.setSRRangeFilterParam(laneSRRangeFilterParam);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean setDecision(Decision decision) {
        for (LaneRenderServiceWrapper laneRenderServiceWrapper : this.mLaneRenderServiceWrapperHashMap.values()) {
            if (laneRenderServiceWrapper != null) {
                laneRenderServiceWrapper.setDecision(decision);
            }
        }
        return true;
    }

    public boolean setDynamicViewMode(int i, boolean z) {
        LaneRenderServiceWrapper laneRenderServiceWrapper = this.mLaneRenderServiceWrapperHashMap.get(Integer.valueOf(i));
        if (laneRenderServiceWrapper != null) {
            laneRenderServiceWrapper.setDynamicViewMode(z);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean openLCC(boolean z) {
        for (LaneRenderServiceWrapper laneRenderServiceWrapper : this.mLaneRenderServiceWrapperHashMap.values()) {
            if (laneRenderServiceWrapper != null) {
                laneRenderServiceWrapper.openLCC(z);
            }
        }
        return true;
    }

    public boolean updateDynamicViewAngle(int i, boolean z) {
        LaneRenderServiceWrapper laneRenderServiceWrapper = this.mLaneRenderServiceWrapperHashMap.get(Integer.valueOf(i));
        if (laneRenderServiceWrapper != null) {
            laneRenderServiceWrapper.updateDynamicViewAngle(z);
            return true;
        }
        return true;
    }

    public void openFollowMode(int i, boolean z) {
        LaneRenderServiceWrapper laneRenderServiceWrapper = this.mLaneRenderServiceWrapperHashMap.get(Integer.valueOf(i));
        if (laneRenderServiceWrapper != null) {
            laneRenderServiceWrapper.openFollowMode(z);
        }
    }

    public void openNaviLineRender(int i, boolean z) {
        LaneRenderServiceWrapper laneRenderServiceWrapper = this.mLaneRenderServiceWrapperHashMap.get(Integer.valueOf(i));
        if (laneRenderServiceWrapper != null) {
            laneRenderServiceWrapper.openNaviLine(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setWarnInfo(int i, int i2) {
        L.Tag tag = TAG;
        L.i(tag, "setWarnInfo engineId:" + i + ", type:" + i2);
        WarningPartsStyle warningPartsStyle = new WarningPartsStyle();
        WarningPartsAnimation warningPartsAnimation = new WarningPartsAnimation();
        WarningPartsAnimationFade warningPartsAnimationFade = new WarningPartsAnimationFade();
        switch (i2) {
            case 1:
                warningPartsStyle.name = LaneDtoModelConstants.PARTS_WARNING_FRONT;
                warningPartsStyle.textureId = -1;
                warningPartsAnimation.name = LaneDtoModelConstants.PARTS_WARNING_FRONT;
                warningPartsAnimation.animationName = LaneDtoModelConstants.PARTS_WARNING_FRONT_OUT_ANIMATION;
                warningPartsAnimation.animationType = 0;
                warningPartsAnimation.repeatTimes = 1;
                warningPartsAnimationFade.name = LaneDtoModelConstants.PARTS_WARNING_FRONT;
                warningPartsAnimationFade.fadeType = 0;
                break;
            case 2:
                warningPartsStyle.name = LaneDtoModelConstants.PARTS_WARNING_FRONT;
                warningPartsStyle.textureId = this.mIsDay ? 142 : 143;
                warningPartsAnimation.name = LaneDtoModelConstants.PARTS_WARNING_FRONT;
                warningPartsAnimation.animationName = LaneDtoModelConstants.PARTS_WARNING_FRONT_OUT_ANIMATION;
                warningPartsAnimation.animationType = 1;
                warningPartsAnimation.repeatTimes = 1;
                warningPartsAnimationFade.name = LaneDtoModelConstants.PARTS_WARNING_FRONT;
                warningPartsAnimationFade.fadeType = 1;
                break;
            case 3:
            case 4:
                warningPartsStyle.name = LaneDtoModelConstants.PARTS_WARNING_FRONT;
                warningPartsStyle.textureId = this.mIsDay ? 140 : 141;
                warningPartsAnimation.name = LaneDtoModelConstants.PARTS_WARNING_FRONT;
                warningPartsAnimation.animationName = LaneDtoModelConstants.PARTS_WARNING_FRONT_OUT_ANIMATION;
                warningPartsAnimation.animationType = 1;
                warningPartsAnimation.repeatTimes = 1;
                warningPartsAnimationFade.name = LaneDtoModelConstants.PARTS_WARNING_FRONT;
                warningPartsAnimationFade.fadeType = 1;
                break;
            case 5:
                warningPartsStyle.name = LaneDtoModelConstants.PARTS_WARNING_BEHIND;
                warningPartsStyle.textureId = -1;
                warningPartsAnimation.name = LaneDtoModelConstants.PARTS_WARNING_BEHIND;
                warningPartsAnimation.animationName = LaneDtoModelConstants.PARTS_WARNING_BEHIND_OUT_ANIMATION;
                warningPartsAnimation.animationType = 0;
                warningPartsAnimation.repeatTimes = 1;
                warningPartsAnimationFade.name = LaneDtoModelConstants.PARTS_WARNING_BEHIND;
                warningPartsAnimationFade.fadeType = 0;
                break;
            case 6:
                warningPartsStyle.name = LaneDtoModelConstants.PARTS_WARNING_BEHIND;
                warningPartsStyle.textureId = this.mIsDay ? 144 : 145;
                warningPartsAnimation.name = LaneDtoModelConstants.PARTS_WARNING_BEHIND;
                warningPartsAnimation.animationName = LaneDtoModelConstants.PARTS_WARNING_BEHIND_OUT_ANIMATION;
                warningPartsAnimation.animationType = 1;
                warningPartsAnimation.repeatTimes = 1;
                warningPartsAnimationFade.name = LaneDtoModelConstants.PARTS_WARNING_BEHIND;
                warningPartsAnimationFade.fadeType = 1;
                break;
            case 7:
                warningPartsStyle.name = LaneDtoModelConstants.PARTS_WARNING_LEFT_BEHIND;
                warningPartsStyle.textureId = -1;
                warningPartsAnimation.name = LaneDtoModelConstants.PARTS_WARNING_LEFT_BEHIND;
                warningPartsAnimation.animationName = LaneDtoModelConstants.PARTS_WARNING_LEFT_BEHIND_OUT_ANIMATION;
                warningPartsAnimation.animationType = 0;
                warningPartsAnimation.repeatTimes = 1;
                warningPartsAnimationFade.name = LaneDtoModelConstants.PARTS_WARNING_LEFT_BEHIND;
                warningPartsAnimationFade.fadeType = 0;
                break;
            case 8:
                warningPartsStyle.name = LaneDtoModelConstants.PARTS_WARNING_LEFT_BEHIND;
                warningPartsStyle.textureId = this.mIsDay ? 146 : 147;
                warningPartsAnimation.name = LaneDtoModelConstants.PARTS_WARNING_LEFT_BEHIND;
                warningPartsAnimation.animationName = LaneDtoModelConstants.PARTS_WARNING_LEFT_BEHIND_OUT_ANIMATION;
                warningPartsAnimation.animationType = 1;
                warningPartsAnimation.repeatTimes = 1;
                warningPartsAnimationFade.name = LaneDtoModelConstants.PARTS_WARNING_LEFT_BEHIND;
                warningPartsAnimationFade.fadeType = 1;
                break;
            case 9:
                warningPartsStyle.name = LaneDtoModelConstants.PARTS_WARNING_LEFT_BEHIND;
                warningPartsStyle.textureId = this.mIsDay ? 148 : 149;
                warningPartsAnimation.name = LaneDtoModelConstants.PARTS_WARNING_LEFT_BEHIND;
                warningPartsAnimation.animationName = LaneDtoModelConstants.PARTS_WARNING_LEFT_BEHIND_OUT_ANIMATION;
                warningPartsAnimation.animationType = 1;
                warningPartsAnimation.repeatTimes = 1;
                warningPartsAnimationFade.name = LaneDtoModelConstants.PARTS_WARNING_LEFT_BEHIND;
                warningPartsAnimationFade.fadeType = 1;
                break;
            case 10:
                warningPartsStyle.name = LaneDtoModelConstants.PARTS_WARNING_RIGHT_BEHIND;
                warningPartsStyle.textureId = -1;
                warningPartsAnimation.name = LaneDtoModelConstants.PARTS_WARNING_RIGHT_BEHIND;
                warningPartsAnimation.animationName = LaneDtoModelConstants.PARTS_WARNING_RIGHT_BEHIND_OUT_ANIMATION;
                warningPartsAnimation.animationType = 0;
                warningPartsAnimation.repeatTimes = 1;
                warningPartsAnimationFade.name = LaneDtoModelConstants.PARTS_WARNING_RIGHT_BEHIND;
                warningPartsAnimationFade.fadeType = 0;
                break;
            case 11:
                warningPartsStyle.name = LaneDtoModelConstants.PARTS_WARNING_RIGHT_BEHIND;
                warningPartsStyle.textureId = this.mIsDay ? 150 : 151;
                warningPartsAnimation.name = LaneDtoModelConstants.PARTS_WARNING_RIGHT_BEHIND;
                warningPartsAnimation.animationName = LaneDtoModelConstants.PARTS_WARNING_RIGHT_BEHIND_OUT_ANIMATION;
                warningPartsAnimation.animationType = 1;
                warningPartsAnimation.repeatTimes = 1;
                warningPartsAnimationFade.name = LaneDtoModelConstants.PARTS_WARNING_RIGHT_BEHIND;
                warningPartsAnimationFade.fadeType = 1;
                break;
            case 12:
                warningPartsStyle.name = LaneDtoModelConstants.PARTS_WARNING_RIGHT_BEHIND;
                warningPartsStyle.textureId = this.mIsDay ? 152 : 153;
                warningPartsAnimation.name = LaneDtoModelConstants.PARTS_WARNING_RIGHT_BEHIND;
                warningPartsAnimation.animationName = LaneDtoModelConstants.PARTS_WARNING_RIGHT_BEHIND_OUT_ANIMATION;
                warningPartsAnimation.animationType = 1;
                warningPartsAnimation.repeatTimes = 1;
                warningPartsAnimationFade.name = LaneDtoModelConstants.PARTS_WARNING_RIGHT_BEHIND;
                warningPartsAnimationFade.fadeType = 1;
                break;
        }
        WarnInfos warnInfos = new WarnInfos();
        warnInfos.modelResID = 139;
        warnInfos.partsStyle.add(warningPartsStyle);
        warnInfos.partsAnimation.add(warningPartsAnimation);
        warnInfos.partsFade.add(warningPartsAnimationFade);
        LaneRenderServiceWrapper laneRenderServiceWrapper = this.mLaneRenderServiceWrapperHashMap.get(Integer.valueOf(i));
        if (laneRenderServiceWrapper != null) {
            laneRenderServiceWrapper.setWarnInfo(warnInfos);
        }
    }

    public void setLevelUp(int i) {
        float f;
        if (i == 0) {
            this.mCurrentLowSpeedLevel += 0.1f;
            f = this.mCurrentLowSpeedLevel;
        } else if (i != 1) {
            f = 0.0f;
        } else {
            float f2 = this.mCurrentHighSpeedLevel;
            if (f2 < this.mCurrentLowSpeedLevel) {
                this.mCurrentHighSpeedLevel = f2 + 0.1f;
            }
            f = this.mCurrentHighSpeedLevel;
        }
        for (LaneRenderServiceWrapper laneRenderServiceWrapper : this.mLaneRenderServiceWrapperHashMap.values()) {
            if (laneRenderServiceWrapper != null) {
                laneRenderServiceWrapper.setLaneDynamicLevel(i, f);
            }
        }
    }

    public void setLevelDown(int i) {
        float f = 0.0f;
        if (i == 0) {
            float f2 = this.mCurrentLowSpeedLevel;
            if (f2 > 0.0f && f2 > this.mCurrentHighSpeedLevel) {
                this.mCurrentLowSpeedLevel = f2 - 0.1f;
            }
            f = this.mCurrentLowSpeedLevel;
        } else if (i == 1) {
            float f3 = this.mCurrentHighSpeedLevel;
            if (f3 > 0.0f) {
                this.mCurrentHighSpeedLevel = f3 - 0.1f;
            }
            f = this.mCurrentHighSpeedLevel;
        }
        for (LaneRenderServiceWrapper laneRenderServiceWrapper : this.mLaneRenderServiceWrapperHashMap.values()) {
            if (laneRenderServiceWrapper != null) {
                laneRenderServiceWrapper.setLaneDynamicLevel(i, f);
            }
        }
    }

    private void attachToMapView(int i) {
        LaneMapViewParam laneMapViewParam = new LaneMapViewParam();
        laneMapViewParam.mapEngineId = i;
        if (1 == i) {
            laneMapViewParam.dayStyleName = MapModelConstants.MAP_STYLE_LANE_DAY;
            laneMapViewParam.nightStyleName = MapModelConstants.MAP_STYLE_LANE_NIGHT;
        } else if (3 == i) {
            laneMapViewParam.dayStyleName = MapModelConstants.MAP_STYLE_LANE_EXTEND_DAY;
            laneMapViewParam.nightStyleName = MapModelConstants.MAP_STYLE_LANE_EXTEND_NIGHT;
        }
        LaneRenderServiceWrapper laneRenderServiceWrapper = this.mLaneRenderServiceWrapperHashMap.get(Integer.valueOf(i));
        if (laneRenderServiceWrapper != null) {
            laneRenderServiceWrapper.attachToMapView(laneMapViewParam);
        }
    }

    private void initSRLevel(int i) {
        if (1 == i) {
            if (CarServiceManager.getInstance().getCarType() == 7) {
                this.mCurrentHighSpeedLevel = DEFAULT_HIGH_SPEED_LEVEL_E28_MAIN_SCREEN;
                this.mCurrentLowSpeedLevel = 19.6f;
            } else {
                this.mCurrentHighSpeedLevel = 19.6f;
                this.mCurrentLowSpeedLevel = DEFAULT_LOW_SPEED_LEVEL_D55_MAIN_SCREEN;
            }
        } else if (3 == i) {
            CarServiceManager.getInstance().getCarType();
            this.mCurrentHighSpeedLevel = DEFAULT_HIGH_SPEED_LEVEL_D55_SUB_SCREEN;
            this.mCurrentLowSpeedLevel = DEFAULT_LOW_SPEED_LEVEL_D55_SUB_SCREEN;
        }
        LaneRenderServiceWrapper laneRenderServiceWrapper = this.mLaneRenderServiceWrapperHashMap.get(Integer.valueOf(i));
        if (laneRenderServiceWrapper != null) {
            laneRenderServiceWrapper.setLaneDynamicLevel(1, this.mCurrentHighSpeedLevel);
            laneRenderServiceWrapper.setLaneDynamicLevel(0, this.mCurrentLowSpeedLevel);
        }
    }

    public void startRecord(boolean z) {
        LaneServicePlayRecordWrapper laneServicePlayRecordWrapper = this.mLaneServicePlayRecordWrapper;
        if (laneServicePlayRecordWrapper != null) {
            laneServicePlayRecordWrapper.startRecord(z);
        }
    }

    public void resetPlay(boolean z) {
        LaneServicePlayRecordWrapper laneServicePlayRecordWrapper = this.mLaneServicePlayRecordWrapper;
        if (laneServicePlayRecordWrapper != null) {
            this.mIsPlayAMapLaneData = z;
            laneServicePlayRecordWrapper.resetPlay(z);
        }
    }

    public void startPlay(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "startPlay play = " + z);
        }
        LaneServicePlayRecordWrapper laneServicePlayRecordWrapper = this.mLaneServicePlayRecordWrapper;
        if (laneServicePlayRecordWrapper != null) {
            this.mIsPlayAMapLaneData = z;
            laneServicePlayRecordWrapper.startPlay(z);
        }
    }

    public boolean isPlayAMapLaneData() {
        return this.mIsPlayAMapLaneData;
    }

    public void setPlayIndex(long j) {
        LaneServicePlayRecordWrapper laneServicePlayRecordWrapper = this.mLaneServicePlayRecordWrapper;
        if (laneServicePlayRecordWrapper != null) {
            laneServicePlayRecordWrapper.setPlayIndex(j);
        }
    }

    public void setPlayerListener(LaneServicePlayRecordWrapper.IPlayerListener iPlayerListener) {
        LaneServicePlayRecordWrapper laneServicePlayRecordWrapper = this.mLaneServicePlayRecordWrapper;
        if (laneServicePlayRecordWrapper != null) {
            laneServicePlayRecordWrapper.setPlayerListener(iPlayerListener);
        }
    }

    public void setPlaySpeed(long j) {
        LaneServicePlayRecordWrapper laneServicePlayRecordWrapper = this.mLaneServicePlayRecordWrapper;
        if (laneServicePlayRecordWrapper != null) {
            laneServicePlayRecordWrapper.setPlaySpeed((float) j);
        }
    }

    public float getCurrentHighSpeedLevel() {
        return this.mCurrentHighSpeedLevel;
    }

    public float getCurrentLowSpeedLevel() {
        return this.mCurrentLowSpeedLevel;
    }

    public float getCurrentAnchorOutLevel() {
        return this.mCurrentAnchorOutLevel;
    }

    public float getCurrentAnchorInLevel() {
        return this.mCurrentAnchorInLevel;
    }

    public void saveHappyEnding() {
        HappyEndingManager happyEndingManager = this.mHappyEndingManager;
        if (happyEndingManager != null) {
            happyEndingManager.saveCurrentCNGPTotalMileage();
        }
    }

    public void restoreHappyEnding() {
        HappyEndingManager happyEndingManager = this.mHappyEndingManager;
        if (happyEndingManager != null) {
            happyEndingManager.restoreCurrentCNGPTotalMileage();
        }
    }

    public void onNaviStop() {
        L.Tag tag = TAG;
        L.i(tag, "onNaviStop mHappyEndingManager : " + this.mHappyEndingManager);
        HappyEndingManager happyEndingManager = this.mHappyEndingManager;
        if (happyEndingManager != null) {
            happyEndingManager.onNaviStop();
        }
    }

    public void updateNaviInfo(XPNaviInfo xPNaviInfo) {
        HappyEndingManager happyEndingManager = this.mHappyEndingManager;
        if (happyEndingManager != null) {
            happyEndingManager.updateNaviInfo(xPNaviInfo);
        }
    }

    public void showHappyEnding(HappyEnding happyEnding) {
        HappyEndingManager happyEndingManager = this.mHappyEndingManager;
        if (happyEndingManager != null) {
            happyEndingManager.showHappyEnding(happyEnding);
        }
    }

    public void registerHappyEnding(IHappyEnding iHappyEnding) {
        HappyEndingManager happyEndingManager = this.mHappyEndingManager;
        if (happyEndingManager != null) {
            happyEndingManager.setIHappyEnding(iHappyEnding);
        }
    }

    public void pushAiMsg(HappyEnding happyEnding) {
        HappyEndingManager happyEndingManager = this.mHappyEndingManager;
        if (happyEndingManager != null) {
            happyEndingManager.pushAiMsg(happyEnding);
        }
    }

    public void setTotalMileage(int i) {
        HappyEndingManager happyEndingManager = this.mHappyEndingManager;
        if (happyEndingManager != null) {
            happyEndingManager.setCurrentCNGPTotalMileage(i);
        }
    }
}
