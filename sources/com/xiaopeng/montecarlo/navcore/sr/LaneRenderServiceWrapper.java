package com.xiaopeng.montecarlo.navcore.sr;

import com.autonavi.gbl.lane.LaneRenderService;
import com.autonavi.gbl.lane.model.CarPartsAnimation;
import com.autonavi.gbl.lane.model.CarPartsStyle;
import com.autonavi.gbl.lane.model.CarStyleInfo;
import com.autonavi.gbl.lane.model.Decision;
import com.autonavi.gbl.lane.model.DecisionDirectionStyle;
import com.autonavi.gbl.lane.model.DecisionLineStyleInfo;
import com.autonavi.gbl.lane.model.LDWLineInfo;
import com.autonavi.gbl.lane.model.LDWLineStyle;
import com.autonavi.gbl.lane.model.LaneDtoModelConstants;
import com.autonavi.gbl.lane.model.LaneLineStyleInfo;
import com.autonavi.gbl.lane.model.LaneMapViewParam;
import com.autonavi.gbl.lane.model.LaneSRRangeFilterParam;
import com.autonavi.gbl.lane.model.SRObjects;
import com.autonavi.gbl.lane.model.WarnInfos;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class LaneRenderServiceWrapper {
    private static final L.Tag TAG = new L.Tag("LaneRenderServiceWrapper");
    private int mEngineId;
    private LaneRenderService mLaneRenderService;
    private int mOffSet = 0;
    CarStyleInfo mCarStyleInfo = new CarStyleInfo();

    /* JADX INFO: Access modifiers changed from: package-private */
    public LaneRenderServiceWrapper(int i, LaneRenderService laneRenderService) {
        this.mEngineId = -1;
        this.mEngineId = i;
        this.mLaneRenderService = laneRenderService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void attachToMapView(LaneMapViewParam laneMapViewParam) {
        L.i(TAG, L.formatWithEngine("attachToMapView", this.mEngineId));
        LaneRenderService laneRenderService = this.mLaneRenderService;
        if (laneRenderService == null) {
            L.w(TAG, L.formatWithEngine("attachToMapView mLaneRenderService is null", this.mEngineId));
        } else {
            laneRenderService.attachMapView(laneMapViewParam);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LaneRenderService unInit() {
        LaneRenderService laneRenderService = this.mLaneRenderService;
        if (laneRenderService != null) {
            laneRenderService.detachMapView();
            this.mLaneRenderService.unInit();
        }
        return this.mLaneRenderService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean setCarStyleInfo(int i, boolean z) {
        if (this.mLaneRenderService == null) {
            L.w(TAG, L.formatWithEngine("setCarStyleInfo mLaneRenderService is null", this.mEngineId));
            return false;
        }
        this.mOffSet = i;
        CarStyleInfo carStyleInfo = this.mCarStyleInfo;
        carStyleInfo.modelResID = this.mOffSet + 158;
        carStyleInfo.partsStyle.clear();
        CarPartsStyle carPartsStyle = new CarPartsStyle();
        carPartsStyle.name = LaneDtoModelConstants.PARTS_CAR_SELF_WHEEL_FRONT;
        carPartsStyle.textureId = (z ? 159 : 160) + this.mOffSet;
        this.mCarStyleInfo.partsStyle.add(carPartsStyle);
        CarPartsStyle carPartsStyle2 = new CarPartsStyle();
        carPartsStyle2.name = LaneDtoModelConstants.PARTS_CAR_SELF_WHEEL_BEHIND;
        carPartsStyle2.textureId = (z ? 159 : 160) + this.mOffSet;
        this.mCarStyleInfo.partsStyle.add(carPartsStyle2);
        CarPartsStyle carPartsStyle3 = new CarPartsStyle();
        carPartsStyle3.name = LaneDtoModelConstants.PARTS_CAR_SELF_DOOR_LEFT_FRONT;
        carPartsStyle3.textureId = (z ? 159 : 160) + this.mOffSet;
        this.mCarStyleInfo.partsStyle.add(carPartsStyle3);
        CarPartsStyle carPartsStyle4 = new CarPartsStyle();
        carPartsStyle4.name = LaneDtoModelConstants.PARTS_CAR_SELF_DOOR_RIGHT_FRONT;
        carPartsStyle4.textureId = (z ? 159 : 160) + this.mOffSet;
        this.mCarStyleInfo.partsStyle.add(carPartsStyle4);
        CarPartsStyle carPartsStyle5 = new CarPartsStyle();
        carPartsStyle5.name = LaneDtoModelConstants.PARTS_CAR_SELF_DOOR_LEFT_BEHIND;
        carPartsStyle5.textureId = (z ? 159 : 160) + this.mOffSet;
        this.mCarStyleInfo.partsStyle.add(carPartsStyle5);
        CarPartsStyle carPartsStyle6 = new CarPartsStyle();
        carPartsStyle6.name = LaneDtoModelConstants.PARTS_CAR_SELF_DOOR_RIGHT_BEHIND;
        carPartsStyle6.textureId = (z ? 159 : 160) + this.mOffSet;
        this.mCarStyleInfo.partsStyle.add(carPartsStyle6);
        CarPartsStyle carPartsStyle7 = new CarPartsStyle();
        carPartsStyle7.name = LaneDtoModelConstants.PARTS_CAR_SELF_DOOR_BONNET;
        carPartsStyle7.textureId = (z ? 159 : 160) + this.mOffSet;
        this.mCarStyleInfo.partsStyle.add(carPartsStyle7);
        CarPartsStyle carPartsStyle8 = new CarPartsStyle();
        carPartsStyle8.name = LaneDtoModelConstants.PARTS_CAR_SELF_DOOR_TRUNK;
        carPartsStyle8.textureId = (z ? 159 : 160) + this.mOffSet;
        this.mCarStyleInfo.partsStyle.add(carPartsStyle8);
        CarPartsStyle carPartsStyle9 = new CarPartsStyle();
        carPartsStyle9.name = LaneDtoModelConstants.PARTS_CAR_SELF_MAIN;
        carPartsStyle9.textureId = (z ? 159 : 160) + this.mOffSet;
        this.mCarStyleInfo.partsStyle.add(carPartsStyle9);
        CarPartsStyle carPartsStyle10 = new CarPartsStyle();
        carPartsStyle10.name = LaneDtoModelConstants.PARTS_CAR_SELF_SHADOW;
        carPartsStyle10.textureId = (z ? 161 : 162) + this.mOffSet;
        this.mCarStyleInfo.partsStyle.add(carPartsStyle10);
        boolean z2 = 1 == CarServiceManager.getInstance().getLeftTurnLampActiveStatus();
        boolean z3 = 1 == CarServiceManager.getInstance().getRightTurnLampActiveStatus();
        CarPartsStyle carPartsStyle11 = new CarPartsStyle();
        carPartsStyle11.name = LaneDtoModelConstants.PARTS_CAR_SELF_LAMP_LEFT;
        carPartsStyle11.textureId = (!z2 || z3) ? -1 : this.mOffSet + 163;
        this.mCarStyleInfo.partsStyle.add(carPartsStyle11);
        CarPartsStyle carPartsStyle12 = new CarPartsStyle();
        carPartsStyle12.name = LaneDtoModelConstants.PARTS_CAR_SELF_LAMP_RIGHT;
        carPartsStyle12.textureId = (!z3 || z2) ? -1 : this.mOffSet + 164;
        this.mCarStyleInfo.partsStyle.add(carPartsStyle12);
        CarPartsStyle carPartsStyle13 = new CarPartsStyle();
        carPartsStyle13.name = LaneDtoModelConstants.PARTS_CAR_SELF_LAMP_STOP;
        carPartsStyle13.textureId = 1 == CarServiceManager.getInstance().getBrakeLightState() ? this.mOffSet + 166 : -1;
        this.mCarStyleInfo.partsStyle.add(carPartsStyle13);
        CarPartsStyle carPartsStyle14 = new CarPartsStyle();
        carPartsStyle14.name = LaneDtoModelConstants.PARTS_CAR_SELF_LAMP_LOWER;
        carPartsStyle14.textureId = 1 == CarServiceManager.getInstance().getNearLampState() ? this.mOffSet + 167 : -1;
        this.mCarStyleInfo.partsStyle.add(carPartsStyle14);
        CarPartsStyle carPartsStyle15 = new CarPartsStyle();
        carPartsStyle15.name = LaneDtoModelConstants.PARTS_CAR_SELF_LAMP_HIGH;
        carPartsStyle15.textureId = 1 == CarServiceManager.getInstance().getFarLampState() ? this.mOffSet + 168 : -1;
        this.mCarStyleInfo.partsStyle.add(carPartsStyle15);
        CarPartsStyle carPartsStyle16 = new CarPartsStyle();
        carPartsStyle16.name = LaneDtoModelConstants.PARTS_CAR_SELF_LAMP_EMERGENCY;
        carPartsStyle16.textureId = (z3 && z2) ? this.mOffSet + 165 : -1;
        this.mCarStyleInfo.partsStyle.add(carPartsStyle16);
        CarPartsStyle carPartsStyle17 = new CarPartsStyle();
        carPartsStyle17.name = "CS_Stop_Tr";
        carPartsStyle17.textureId = 1 == CarServiceManager.getInstance().getBrakeLightState() ? this.mOffSet + 166 : -1;
        this.mCarStyleInfo.partsStyle.add(carPartsStyle17);
        L.Tag tag = TAG;
        L.i(tag, L.formatWithEngine("setCarStyleInfo left:" + CarServiceManager.getInstance().getLeftTurnLampActiveStatus() + ", right:" + CarServiceManager.getInstance().getRightTurnLampActiveStatus() + ", stop:" + CarServiceManager.getInstance().getBrakeLightState() + ", near:" + CarServiceManager.getInstance().getNearLampState() + ", far:" + CarServiceManager.getInstance().getFarLampState(), this.mEngineId));
        return this.mLaneRenderService.setCarStyleInfo(this.mCarStyleInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void openLFDoor(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, L.formatWithEngine("openLFDoor open:" + z, this.mEngineId));
        this.mCarStyleInfo.partsAnimation.clear();
        CarPartsAnimation carPartsAnimation = new CarPartsAnimation();
        carPartsAnimation.name = LaneDtoModelConstants.PARTS_CAR_SELF_DOOR_LEFT_FRONT;
        carPartsAnimation.animationName = z ? LaneDtoModelConstants.PARTS_CAR_SELF_DOOR_LEFT_FRONT_OPEN_ANIMATION : LaneDtoModelConstants.PARTS_CAR_SELF_DOOR_LEFT_FRONT_CLOSE_ANIMATION;
        carPartsAnimation.animationType = 1;
        carPartsAnimation.repeatTimes = 1;
        this.mCarStyleInfo.partsAnimation.add(carPartsAnimation);
        this.mLaneRenderService.setCarStyleInfo(this.mCarStyleInfo);
        this.mCarStyleInfo.partsAnimation.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void openRFDoor(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, L.formatWithEngine("openRFDoor open:" + z, this.mEngineId));
        this.mCarStyleInfo.partsAnimation.clear();
        CarPartsAnimation carPartsAnimation = new CarPartsAnimation();
        carPartsAnimation.name = LaneDtoModelConstants.PARTS_CAR_SELF_DOOR_RIGHT_FRONT;
        carPartsAnimation.animationName = z ? LaneDtoModelConstants.PARTS_CAR_SELF_DOOR_RIGHT_FRONT_OPEN_ANIMATION : LaneDtoModelConstants.PARTS_CAR_SELF_DOOR_RIGHT_FRONT_CLOSE_ANIMATION;
        carPartsAnimation.animationType = 1;
        carPartsAnimation.repeatTimes = 1;
        this.mCarStyleInfo.partsAnimation.add(carPartsAnimation);
        this.mLaneRenderService.setCarStyleInfo(this.mCarStyleInfo);
        this.mCarStyleInfo.partsAnimation.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void openLBDoor(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, L.formatWithEngine("openLBDoor open:" + z, this.mEngineId));
        this.mCarStyleInfo.partsAnimation.clear();
        CarPartsAnimation carPartsAnimation = new CarPartsAnimation();
        carPartsAnimation.name = LaneDtoModelConstants.PARTS_CAR_SELF_DOOR_LEFT_BEHIND;
        carPartsAnimation.animationName = z ? LaneDtoModelConstants.PARTS_CAR_SELF_DOOR_LEFT_BEHIND_OPEN_ANIMATION : LaneDtoModelConstants.PARTS_CAR_SELF_DOOR_LEFT_BEHIND_CLOSE_ANIMATION;
        carPartsAnimation.animationType = 1;
        carPartsAnimation.repeatTimes = 1;
        this.mCarStyleInfo.partsAnimation.add(carPartsAnimation);
        this.mLaneRenderService.setCarStyleInfo(this.mCarStyleInfo);
        this.mCarStyleInfo.partsAnimation.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void openRBDoor(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, L.formatWithEngine("openRBDoor open:" + z, this.mEngineId));
        this.mCarStyleInfo.partsAnimation.clear();
        CarPartsAnimation carPartsAnimation = new CarPartsAnimation();
        carPartsAnimation.name = LaneDtoModelConstants.PARTS_CAR_SELF_DOOR_RIGHT_BEHIND;
        carPartsAnimation.animationName = z ? LaneDtoModelConstants.PARTS_CAR_SELF_DOOR_RIGHT_BEHIND_OPEN_ANIMATION : LaneDtoModelConstants.PARTS_CAR_SELF_DOOR_RIGHT_BEHIND_CLOSE_ANIMATION;
        carPartsAnimation.animationType = 1;
        carPartsAnimation.repeatTimes = 1;
        this.mCarStyleInfo.partsAnimation.add(carPartsAnimation);
        this.mLaneRenderService.setCarStyleInfo(this.mCarStyleInfo);
        this.mCarStyleInfo.partsAnimation.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void openBonnet(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, L.formatWithEngine("openBonnet open:" + z, this.mEngineId));
        this.mCarStyleInfo.partsAnimation.clear();
        CarPartsAnimation carPartsAnimation = new CarPartsAnimation();
        carPartsAnimation.name = LaneDtoModelConstants.PARTS_CAR_SELF_DOOR_BONNET;
        carPartsAnimation.animationName = z ? LaneDtoModelConstants.PARTS_CAR_SELF_DOOR_BONNET_OPEN_ANIMATION : LaneDtoModelConstants.PARTS_CAR_SELF_DOOR_BONNET_CLOSE_ANIMATION;
        carPartsAnimation.animationType = 1;
        carPartsAnimation.repeatTimes = 1;
        this.mCarStyleInfo.partsAnimation.add(carPartsAnimation);
        this.mLaneRenderService.setCarStyleInfo(this.mCarStyleInfo);
        this.mCarStyleInfo.partsAnimation.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void openTrunk(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, L.formatWithEngine("openTrunk open:" + z, this.mEngineId));
        this.mCarStyleInfo.partsAnimation.clear();
        CarPartsAnimation carPartsAnimation = new CarPartsAnimation();
        carPartsAnimation.name = LaneDtoModelConstants.PARTS_CAR_SELF_DOOR_TRUNK;
        carPartsAnimation.animationName = z ? LaneDtoModelConstants.PARTS_CAR_SELF_DOOR_TRUNK_OPEN_ANIMATION : LaneDtoModelConstants.PARTS_CAR_SELF_DOOR_TRUNK_CLOSE_ANIMATION;
        carPartsAnimation.animationType = 1;
        carPartsAnimation.repeatTimes = 1;
        this.mCarStyleInfo.partsAnimation.add(carPartsAnimation);
        this.mLaneRenderService.setCarStyleInfo(this.mCarStyleInfo);
        this.mCarStyleInfo.partsAnimation.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void openStopTr(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, L.formatWithEngine("openStopTr open:" + z, this.mEngineId));
        this.mCarStyleInfo.partsAnimation.clear();
        CarPartsAnimation carPartsAnimation = new CarPartsAnimation();
        carPartsAnimation.name = "CS_Stop_Tr";
        carPartsAnimation.animationName = z ? "CS_Stop_Tr_Open" : "CS_Stop_Tr_Close";
        carPartsAnimation.animationType = 1;
        carPartsAnimation.repeatTimes = 1;
        this.mCarStyleInfo.partsAnimation.add(carPartsAnimation);
        this.mLaneRenderService.setCarStyleInfo(this.mCarStyleInfo);
        this.mCarStyleInfo.partsAnimation.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void openLeftTurnLamp(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, L.formatWithEngine("openLeftTurnLamp open:" + z, this.mEngineId));
        this.mCarStyleInfo.partsAnimation.clear();
        CarPartsAnimation carPartsAnimation = new CarPartsAnimation();
        carPartsAnimation.name = LaneDtoModelConstants.PARTS_CAR_SELF_LAMP_LEFT;
        carPartsAnimation.animationName = LaneDtoModelConstants.PARTS_CAR_SELF_LAMP_LEFT_ANIMATION;
        if (z) {
            carPartsAnimation.animationType = 1;
            carPartsAnimation.repeatTimes = -1;
        } else {
            carPartsAnimation.animationType = 0;
            carPartsAnimation.repeatTimes = 1;
        }
        this.mCarStyleInfo.partsAnimation.add(carPartsAnimation);
        this.mLaneRenderService.setCarStyleInfo(this.mCarStyleInfo);
        this.mCarStyleInfo.partsAnimation.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void openRightTurnLamp(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, L.formatWithEngine("openRightTurnLamp open:" + z, this.mEngineId));
        this.mCarStyleInfo.partsAnimation.clear();
        CarPartsAnimation carPartsAnimation = new CarPartsAnimation();
        carPartsAnimation.name = LaneDtoModelConstants.PARTS_CAR_SELF_LAMP_RIGHT;
        carPartsAnimation.animationName = LaneDtoModelConstants.PARTS_CAR_SELF_LAMP_RIGHT_ANIMATION;
        if (z) {
            carPartsAnimation.animationType = 1;
            carPartsAnimation.repeatTimes = -1;
        } else {
            carPartsAnimation.animationType = 0;
            carPartsAnimation.repeatTimes = 1;
        }
        this.mCarStyleInfo.partsAnimation.add(carPartsAnimation);
        this.mLaneRenderService.setCarStyleInfo(this.mCarStyleInfo);
        this.mCarStyleInfo.partsAnimation.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void openEmergencyLamp(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, L.formatWithEngine("openEmergencyLamp open:" + z, this.mEngineId));
        this.mCarStyleInfo.partsAnimation.clear();
        CarPartsAnimation carPartsAnimation = new CarPartsAnimation();
        carPartsAnimation.name = LaneDtoModelConstants.PARTS_CAR_SELF_LAMP_EMERGENCY;
        carPartsAnimation.animationName = LaneDtoModelConstants.PARTS_CAR_SELF_LAMP_EMERGENCY_ANIMATION;
        if (z) {
            carPartsAnimation.animationType = 1;
            carPartsAnimation.repeatTimes = -1;
        } else {
            carPartsAnimation.animationType = 0;
            carPartsAnimation.repeatTimes = 1;
        }
        this.mCarStyleInfo.partsAnimation.add(carPartsAnimation);
        this.mLaneRenderService.setCarStyleInfo(this.mCarStyleInfo);
        this.mCarStyleInfo.partsAnimation.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLDWWarning(int i, boolean z, boolean z2) {
        int i2;
        int i3;
        L.Tag tag = TAG;
        L.i(tag, L.formatWithEngine("setLDWWarning type:" + i + ", enable:" + z, this.mEngineId));
        if (this.mLaneRenderService == null) {
            L.w(TAG, L.formatWithEngine("setLDWWarning mLaneRenderService is null", this.mEngineId));
        }
        int i4 = -1;
        if (14 != i && 17 != i) {
            if (15 == i || 18 == i) {
                i2 = z2 ? 156 : 157;
            }
            i3 = Integer.MIN_VALUE;
            if (14 != i || 15 == i || 13 == i) {
                i3 = 0;
            } else if (17 == i || 18 == i || 16 == i) {
                i3 = 1;
            }
            LDWLineStyle lDWLineStyle = new LDWLineStyle();
            lDWLineStyle.lineStyle.lineWidth = 0.601344f;
            lDWLineStyle.lineStyle.fillResID = i4;
            lDWLineStyle.direction = i3;
            this.mLaneRenderService.setLDWLineStyle(lDWLineStyle);
            LDWLineInfo lDWLineInfo = new LDWLineInfo();
            lDWLineInfo.status = z ? 1 : 0;
            lDWLineInfo.direction = i3;
            lDWLineInfo.animationStatus = z ? 1 : 0;
            this.mLaneRenderService.setLDWLineInfo(lDWLineInfo);
        }
        i2 = z2 ? 154 : 155;
        i4 = i2;
        i3 = Integer.MIN_VALUE;
        if (14 != i) {
        }
        i3 = 0;
        LDWLineStyle lDWLineStyle2 = new LDWLineStyle();
        lDWLineStyle2.lineStyle.lineWidth = 0.601344f;
        lDWLineStyle2.lineStyle.fillResID = i4;
        lDWLineStyle2.direction = i3;
        this.mLaneRenderService.setLDWLineStyle(lDWLineStyle2);
        LDWLineInfo lDWLineInfo2 = new LDWLineInfo();
        lDWLineInfo2.status = z ? 1 : 0;
        lDWLineInfo2.direction = i3;
        lDWLineInfo2.animationStatus = z ? 1 : 0;
        this.mLaneRenderService.setLDWLineInfo(lDWLineInfo2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean openSRRangeFilter(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, L.formatWithEngine("openSRRangeFilter:" + z, this.mEngineId));
        LaneRenderService laneRenderService = this.mLaneRenderService;
        if (laneRenderService == null) {
            L.w(TAG, L.formatWithEngine("openSRRangeFilter mLaneRenderService is null", this.mEngineId));
            return false;
        }
        return laneRenderService.openSRRangeFilter(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean setSRRangeFilterParam(LaneSRRangeFilterParam laneSRRangeFilterParam) {
        if (this.mLaneRenderService == null || laneSRRangeFilterParam == null) {
            L.Tag tag = TAG;
            L.w(tag, L.formatWithEngine("setSRRangeFilterParam " + this.mLaneRenderService + " " + laneSRRangeFilterParam, this.mEngineId));
            return false;
        }
        StringBuilder sb = new StringBuilder();
        if (CollectionUtils.isNotEmpty(laneSRRangeFilterParam.exceptTypes)) {
            Iterator<Integer> it = laneSRRangeFilterParam.exceptTypes.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(LocationUtils.DR_RECORD_DATA_SPLIT_CHAR);
            }
        }
        L.Tag tag2 = TAG;
        L.i(tag2, "setSRRangeFilterParam " + sb.toString());
        return this.mLaneRenderService.setSRRangeFilterParam(laneSRRangeFilterParam);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean setDecision(Decision decision) {
        LaneRenderService laneRenderService = this.mLaneRenderService;
        if (laneRenderService == null) {
            L.w(TAG, L.formatWithEngine("setDecision mLaneRenderService is null", this.mEngineId));
            return false;
        } else if (decision == null) {
            if (L.ENABLE) {
                L.d(TAG, L.formatWithEngine("setDecision xpDecision is null", this.mEngineId));
            }
            return false;
        } else {
            return laneRenderService.setDecision(decision);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean setSRObject(SRObjects sRObjects) {
        LaneRenderService laneRenderService = this.mLaneRenderService;
        if (laneRenderService == null) {
            L.w(TAG, L.formatWithEngine("setSRObject mLaneRenderService is null", this.mEngineId));
            return false;
        } else if (sRObjects == null) {
            if (L.ENABLE) {
                L.d(TAG, L.formatWithEngine("setSRObject srObjects is null", this.mEngineId));
            }
            return false;
        } else {
            return laneRenderService.setSRObject(sRObjects);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean setWarnInfo(WarnInfos warnInfos) {
        L.i(TAG, L.formatWithEngine("setWarnInfo", this.mEngineId));
        LaneRenderService laneRenderService = this.mLaneRenderService;
        if (laneRenderService == null) {
            L.w(TAG, L.formatWithEngine("setWarnInfo mLaneRenderService is null", this.mEngineId));
            return false;
        }
        return laneRenderService.setWarnInfo(warnInfos);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean setLaneDynamicLevelSpeedThreshold(float f) {
        L.Tag tag = TAG;
        L.i(tag, L.formatWithEngine("setLaneDynamicLevelSpeedThreshold " + f, this.mEngineId));
        LaneRenderService laneRenderService = this.mLaneRenderService;
        if (laneRenderService == null) {
            L.w(TAG, L.formatWithEngine("setLaneDynamicLevelSpeedThreshold mLaneRenderService is null", this.mEngineId));
            return false;
        }
        return laneRenderService.setLaneDynamicLevelSpeedThreshold(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean setDynamicViewMode(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "setDynamicViewMode isUseCarSpeed:" + z);
        LaneRenderService laneRenderService = this.mLaneRenderService;
        if (laneRenderService == null) {
            L.w(TAG, L.formatWithEngine("setDynamicViewMode mLaneRenderService is null", this.mEngineId));
            return false;
        }
        return laneRenderService.setDynamicViewMode(z ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean enterLane(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, L.formatWithEngine("enterLane " + z, this.mEngineId));
        LaneRenderService laneRenderService = this.mLaneRenderService;
        if (laneRenderService == null) {
            L.w(TAG, L.formatWithEngine("enterLane mLaneRenderService is null", this.mEngineId));
            return false;
        }
        return laneRenderService.enterLane(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean openLCC(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, L.formatWithEngine("openLCC enable:" + z, this.mEngineId));
        LaneRenderService laneRenderService = this.mLaneRenderService;
        if (laneRenderService == null) {
            L.w(TAG, L.formatWithEngine("openLCC mLaneRenderService is null", this.mEngineId));
            return false;
        }
        return laneRenderService.openLCC(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean openNaviLineFishbone(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, L.formatWithEngine("openNaviLineFishbone enable:" + z, this.mEngineId));
        LaneRenderService laneRenderService = this.mLaneRenderService;
        if (laneRenderService == null) {
            L.w(TAG, L.formatWithEngine("openNaviLineFishbone mLaneRenderService is null", this.mEngineId));
            return false;
        }
        return laneRenderService.openNaviLineFishbone(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean openNaviLineOutline(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, L.formatWithEngine("openNaviLineOutline enable:" + z, this.mEngineId));
        LaneRenderService laneRenderService = this.mLaneRenderService;
        if (laneRenderService == null) {
            L.w(TAG, L.formatWithEngine("openNaviLineOutline mLaneRenderService is null", this.mEngineId));
            return false;
        }
        return laneRenderService.openNaviLineOutline(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean setNaviLineLength(float f) {
        L.Tag tag = TAG;
        L.i(tag, L.formatWithEngine("setNaviLineLength length:" + f, this.mEngineId));
        LaneRenderService laneRenderService = this.mLaneRenderService;
        if (laneRenderService == null) {
            L.w(TAG, L.formatWithEngine("setNaviLineLength mLaneRenderService is null", this.mEngineId));
            return false;
        }
        return laneRenderService.setNaviLineLength(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean updateDynamicViewAngle(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, L.formatWithEngine("updateDynamicViewAngle " + z, this.mEngineId));
        LaneRenderService laneRenderService = this.mLaneRenderService;
        if (laneRenderService == null) {
            L.d(TAG, L.formatWithEngine("updateDynamicViewAngle mLaneRenderService is null", this.mEngineId));
            return false;
        }
        return laneRenderService.openDynamicViewAngle(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void openFollowMode(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, L.formatWithEngine("openFollowMode " + z, this.mEngineId));
        LaneRenderService laneRenderService = this.mLaneRenderService;
        if (laneRenderService == null) {
            L.w(TAG, L.formatWithEngine("openFollowMode mLaneRenderService is null", this.mEngineId));
        } else {
            laneRenderService.openFollowMode(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean openNaviLine(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, L.formatWithEngine("openNaviLine " + z, this.mEngineId));
        LaneRenderService laneRenderService = this.mLaneRenderService;
        if (laneRenderService == null) {
            L.w(TAG, L.formatWithEngine("openNaviLine mLaneRenderService is null", this.mEngineId));
            return false;
        }
        return laneRenderService.openNaviLine(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean openShowRoadPolygon(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, L.formatWithEngine("openShowRoadPolygon " + z, this.mEngineId));
        LaneRenderService laneRenderService = this.mLaneRenderService;
        if (laneRenderService == null) {
            L.w(TAG, L.formatWithEngine("openShowRoadPolygon mLaneRenderService is null", this.mEngineId));
            return false;
        }
        return laneRenderService.openShowRoadPolygon(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLaneDynamicLevel(int i, float f) {
        L.Tag tag = TAG;
        L.i(tag, L.formatWithEngine("setLaneDynamicLevel type:" + i + ", level:" + f, this.mEngineId));
        if (this.mLaneRenderService == null) {
            L.w(TAG, L.formatWithEngine("setLaneDynamicLevel mLaneRenderService is null", this.mEngineId));
        }
        this.mLaneRenderService.setLaneDynamicLevel(i, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean setLaneLayerVisible(int i, boolean z) {
        L.Tag tag = TAG;
        L.i(tag, L.formatWithEngine("setLaneLayerVisible layerType:" + i + ", visible:" + z, this.mEngineId));
        LaneRenderService laneRenderService = this.mLaneRenderService;
        if (laneRenderService == null) {
            L.w(TAG, L.formatWithEngine("setLaneLayerVisible mLaneRenderService is null", this.mEngineId));
            return false;
        }
        return laneRenderService.setLaneLayerVisible(i, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateStyle(boolean z) {
        setCarStyleInfo(this.mOffSet, z);
        setDecisionLineStyle(z);
        setDecisionDirectionStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initSelfCarAnimation() {
        boolean z = 1 == CarServiceManager.getInstance().getLeftTurnLampActiveStatus();
        boolean z2 = 1 == CarServiceManager.getInstance().getRightTurnLampActiveStatus();
        if (z || z2) {
            openLeftTurnLamp(z && !z2);
            openRightTurnLamp(z2 && !z);
            openEmergencyLamp(z2 && z);
        }
        if (1 == CarServiceManager.getInstance().isBcmBonnetOpened()) {
            openBonnet(true);
        }
        if (2 == CarServiceManager.getInstance().getTrunk()) {
            openTrunk(true);
            openStopTr(true);
        }
        int[] doorsState = CarServiceManager.getInstance().getDoorsState();
        if (doorsState == null || 4 != doorsState.length) {
            return;
        }
        if (1 == doorsState[0]) {
            openLFDoor(true);
        }
        if (1 == doorsState[1]) {
            openRFDoor(true);
        }
        if (1 == doorsState[2]) {
            openLBDoor(true);
        }
        if (1 == doorsState[3]) {
            openRBDoor(true);
        }
    }

    private boolean setDecisionLineStyle(boolean z) {
        if (this.mLaneRenderService == null) {
            L.w(TAG, L.formatWithEngine("setDecisionLineStyle mLaneRenderService is null", this.mEngineId));
            return false;
        }
        DecisionLineStyleInfo decisionLineStyleInfo = new DecisionLineStyleInfo();
        LaneLineStyleInfo laneLineStyleInfo = new LaneLineStyleInfo();
        laneLineStyleInfo.lineWidth = 64.0f;
        laneLineStyleInfo.fillResID = z ? 1 : 2;
        decisionLineStyleInfo.warningStyle = laneLineStyleInfo;
        decisionLineStyleInfo.highLightResID = z ? 3 : 4;
        LaneLineStyleInfo laneLineStyleInfo2 = new LaneLineStyleInfo();
        laneLineStyleInfo2.lineWidth = 1.4f;
        laneLineStyleInfo2.fillResID = z ? 5 : 6;
        decisionLineStyleInfo.decisionStyle = laneLineStyleInfo2;
        LaneLineStyleInfo laneLineStyleInfo3 = new LaneLineStyleInfo();
        laneLineStyleInfo3.lineWidth = 30.0f;
        laneLineStyleInfo3.fillResID = -1;
        decisionLineStyleInfo.arrowStyle = laneLineStyleInfo3;
        LaneLineStyleInfo laneLineStyleInfo4 = new LaneLineStyleInfo();
        laneLineStyleInfo4.fillResID = z ? 11 : 12;
        laneLineStyleInfo4.lineWidth = 0.300672f;
        decisionLineStyleInfo.lccStyle = laneLineStyleInfo4;
        return this.mLaneRenderService.setDecisionLineStyle(decisionLineStyleInfo);
    }

    private boolean setDecisionDirectionStyle(boolean z) {
        if (this.mLaneRenderService == null) {
            L.w(TAG, L.formatWithEngine("setDecisionDirectionStyle mLaneRenderService is null", this.mEngineId));
            return false;
        }
        DecisionDirectionStyle decisionDirectionStyle = new DecisionDirectionStyle();
        decisionDirectionStyle.resID = z ? 9 : 10;
        return this.mLaneRenderService.setDecisionDirectionStyle(decisionDirectionStyle);
    }

    public boolean openStaticObjectStay(boolean z) {
        LaneRenderService laneRenderService = this.mLaneRenderService;
        if (laneRenderService == null) {
            L.w(TAG, L.formatWithEngine("openStaticObjectStay mLaneRenderService is null", this.mEngineId));
            return false;
        }
        return laneRenderService.openStaticObjectStay(z);
    }
}
