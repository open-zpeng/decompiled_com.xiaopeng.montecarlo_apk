package com.xiaopeng.montecarlo.navcore.sr;

import com.autonavi.gbl.lane.model.Decision;
import com.autonavi.gbl.lane.model.RelativePos;
import com.autonavi.gbl.lane.model.SRObject;
import com.autonavi.gbl.lane.model.SRObjects;
import com.autonavi.gbl.pos.model.GPSDatetime;
import com.autonavi.gbl.pos.model.LineGeometry;
import com.autonavi.gbl.pos.model.LocAllFusionPos;
import com.autonavi.gbl.pos.model.LocDrPos;
import com.autonavi.gbl.pos.model.LocLane;
import com.autonavi.gbl.pos.model.LocVision;
import com.autonavi.gbl.pos.model.PosCoordLocal;
import com.autonavi.gbl.pos.model.PosRotation;
import com.xiaopeng.montecarlo.navcore.bean.sr.SRInfo;
import com.xiaopeng.montecarlo.navcore.bean.sr.XPLocPulse;
import com.xiaopeng.montecarlo.navcore.event.SRDebugEvent;
import com.xiaopeng.montecarlo.navcore.xptbt.SrCarServiceManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.root.util.ioutil.FileUtil;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.EventBus;
import xpilot.sr.proto.DynamicEnvironmentOuterClass;
import xpilot.sr.proto.LocalPose;
import xpilot.sr.proto.Overall;
import xpilot.sr.proto.Posrtkimu;
import xpilot.sr.proto.Primitives;
import xpilot.sr.proto.StaticEnvironmentOuterClass;
/* loaded from: classes3.dex */
public class SRNaviDataHelper implements SrCarServiceManager.IXPSrCarStateListener {
    private static final int DEFAULT_SIGNAL_INTERVAL = 20;
    private static final long FLASH_PERIOD = 400;
    private static final long FLASH_TOTLE_TIME = 2000;
    static final int FRAME_COUNT = 20;
    private static final String SR_DATA_EXTENSION = ".json";
    private static final String SR_DATA_FOLDER = "/sdcard/montecarlo/SR/SR_Data";
    private static final String SR_DATA_RAW_FOLDER = "/sdcard/montecarlo/SR/SR_Data_Raw";
    private static final L.Tag TAG = new L.Tag("SRNaviDataHelper");
    private SRNaviManager mManager;
    LocVision mLocVision = new LocVision();
    LocDrPos mLocDrPos = new LocDrPos();
    LocAllFusionPos mLocAllFusionPos = new LocAllFusionPos();
    Decision mDecision = new Decision();
    SRObjects mSRObjects = new SRObjects();
    private volatile SRInfo mSRInfo = new SRInfo();
    private SRInfo mSRInfoTemp = new SRInfo();
    private long mRecentFrameAveTime = 0;
    private long mRecentFrameTotalTime = 0;
    private long mRecentFrameCount = 0;
    private long mFrameStartTime = 0;
    private int mSrDisplaySt = 2;
    private Calendar mCalendar = Calendar.getInstance();
    private boolean mFirstEnterSR = true;
    private boolean mFlash = false;
    private int mFlashId = 0;
    private int mFlashColor = 0;
    private long mFlashTotalTime = 0;
    private Timer mFlashTimer = null;
    private TimerTask mFlashTimerTask = null;

    public SRNaviDataHelper(SRNaviManager sRNaviManager) {
        this.mManager = sRNaviManager;
    }

    public SRInfo getSRInfo() {
        return this.mSRInfo;
    }

    public void resetSRInfo() {
        this.mSrDisplaySt = 2;
        this.mSRInfo.reset();
        this.mSRInfoTemp.reset();
    }

    public void start() {
        SrCarServiceManager.getInstance().addCarStateListener(this);
    }

    public void stop() {
        SrCarServiceManager.getInstance().removeCarStateListener(this);
    }

    public void routeSr2RdXpuDataV1(Overall.overall overallVar, boolean z, long j, long j2) {
        try {
            try {
                this.mRecentFrameCount++;
                long currentTimeMillis = System.currentTimeMillis();
                if (analysisOverallData(overallVar)) {
                    if (z) {
                        analysisPosInfo(overallVar);
                        analysisDriveMode();
                    } else {
                        printProtoTime(overallVar, j, j2);
                        analysisSRSpdViewMode();
                        analysisSRLCViewMode();
                        analysisNgpLaneChangeStatus();
                        analysisDriveMode();
                        analysisSRLCCLight();
                        analysisVehSpeed();
                        analysisXPULimitSpdDisp();
                        analysisXPUCruiseSpdDisp();
                        analysisXPUCDUNGPOpeButtonSt();
                        analysisSRDisplayState();
                        analysisXPUCDUNGPLCTips1AndQuitODD();
                        analysisXPUCDUNGPInfoTips1();
                        analysisPosInfo(overallVar);
                        analysisDecisionInfo(overallVar);
                        analysisSRObjectInfo(overallVar);
                    }
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                this.mRecentFrameTotalTime += currentTimeMillis2 - currentTimeMillis;
                if (this.mRecentFrameCount % 20 == 0) {
                    int round = Math.round(20.0f / (((float) (currentTimeMillis2 - this.mFrameStartTime)) / 1000.0f));
                    this.mFrameStartTime = currentTimeMillis2;
                    this.mRecentFrameAveTime = this.mRecentFrameTotalTime / 20;
                    this.mRecentFrameTotalTime = 0L;
                    L.i(TAG, "frame info: data " + round + " hz; one frame time: " + this.mRecentFrameAveTime);
                    this.mManager.outBLRenderFPS();
                    if (SRNaviManager.getInstance().getIsShowSRData()) {
                        SRDebugEvent sRDebugEvent = new SRDebugEvent(7);
                        sRDebugEvent.mTipsType = round;
                        sRDebugEvent.mTipsType1 = (int) this.mRecentFrameAveTime;
                        EventBus.getDefault().post(sRDebugEvent);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            dataRelease(overallVar);
        }
    }

    private boolean analysisOverallData(Overall.overall overallVar) {
        boolean z = false;
        if (overallVar == null) {
            L.w(TAG, "analysisOverallData overall is null");
            return false;
        }
        if (L.ENABLE) {
            L.i(TAG, "stateManagement.getSrDisplaySt() = " + overallVar.getSrDisplaySt());
        }
        this.mSRInfoTemp.setSRDisplayState(overallVar.getSrDisplaySt());
        LocalPose.LocalPoseInfo localPose = overallVar.getLocalPose();
        if (localPose != null && overallVar.hasLocalPose()) {
            this.mSRInfoTemp.setSRSpdViewMode(localPose.getXPUSRView());
            XPLocPulse xPLocPulse = new XPLocPulse();
            xPLocPulse.setValue(localPose.getVehSpeed() * 3.6f);
            this.mSRInfoTemp.setXPLocPulse(xPLocPulse);
        }
        Primitives.StateManagement smInfo = overallVar.getSmInfo();
        if (smInfo != null && overallVar.hasSmInfo()) {
            this.mSRInfoTemp.setSRLcViewMode(smInfo.getXPUSRLCView());
            int rdmodulecom15State = smInfo.getRdmodulecom15State();
            this.mSRInfoTemp.setNGPLaneChangedStatus(rdmodulecom15State);
            int rdmodulecom16State = smInfo.getRdmodulecom16State();
            if (4 == rdmodulecom16State) {
                rdmodulecom16State = 3;
            } else if (6 == rdmodulecom16State) {
                rdmodulecom16State = 5;
            }
            this.mSRInfoTemp.setDriveMode(rdmodulecom16State);
            if ((this.mSRInfo.getDriveMode() != rdmodulecom16State && 5 == rdmodulecom16State) || 6 == rdmodulecom16State) {
                this.mSRInfoTemp.setDriveModeChangeToNgp(true);
            } else {
                this.mSRInfoTemp.setDriveModeChangeToNgp(false);
            }
            boolean z2 = 3 == rdmodulecom16State || 4 == rdmodulecom16State;
            boolean z3 = 1 == rdmodulecom15State || 2 == rdmodulecom15State;
            if (z2 && !z3) {
                z = true;
            }
            this.mSRInfoTemp.setLCCLight(z);
            this.mSRInfoTemp.setLimitSpeed((int) smInfo.getRdmodulecomCruisevehSpdSt());
            this.mSRInfoTemp.setCruiseSpeed(smInfo.getRdmodulecomCruiseVehSpd());
            this.mSRInfoTemp.setNGPOpeButtonStatus(smInfo.getRdmodulecom14State());
            this.mSRInfoTemp.setNGPLCTips1Status(smInfo.getRdmodulecom10State());
            this.mSRInfoTemp.setQuitNGPODDStatus(smInfo.getRdmodulecom11State());
            this.mSRInfoTemp.setNGPInfoTips1Status(smInfo.getRdmodulecom9State());
        }
        return true;
    }

    private void printProtoTime(Overall.overall overallVar, long j, long j2) {
        StaticEnvironmentOuterClass.StaticEnvironment staticInfo;
        if (L.ENABLE && overallVar != null && overallVar.hasStaticInfo() && (staticInfo = overallVar.getStaticInfo()) != null && staticInfo.hasTimestamp()) {
            long nsecs = staticInfo.getTimestamp().getNsecs() / 1000000;
            if (j != 0 && j2 != 0) {
                L.Tag tag = TAG;
                L.d(tag, "printProtoTime protoTime:" + nsecs + ",srDataTime:" + j + ",appDataTime:" + j2);
                return;
            }
            L.Tag tag2 = TAG;
            L.d(tag2, "printProtoTime protoTime:" + nsecs);
        }
    }

    private void dataRelease(Overall.overall overallVar) {
        if (overallVar != null) {
            overallVar.toBuilder().clear();
        }
    }

    private void analysisVehSpeed() {
        float value = this.mSRInfo.getXPLocPulse() != null ? this.mSRInfo.getXPLocPulse().getValue() : 0.0f;
        if (this.mSRInfoTemp.getXPLocPulse() != null) {
            float value2 = this.mSRInfoTemp.getXPLocPulse().getValue();
            boolean z = Float.compare(value2, value) != 0;
            if (L.ENABLE && z) {
                L.Tag tag = TAG;
                L.d(tag, "analysisVehSpeed isNeedSync:" + z + ",currentSpeed:" + value + ",speed:" + value2);
            }
            if (z) {
                XPLocPulse xPLocPulse = this.mSRInfo.getXPLocPulse();
                if (xPLocPulse == null) {
                    xPLocPulse = new XPLocPulse();
                }
                xPLocPulse.setValue(value2);
                this.mSRInfo.setXPLocPulse(xPLocPulse);
                SRNaviManager sRNaviManager = this.mManager;
                if (sRNaviManager != null) {
                    sRNaviManager.srVehSpeedChanged(value2);
                }
            }
        }
    }

    private void analysisPosInfo(Overall.overall overallVar) {
        if (overallVar == null) {
            L.w(TAG, "analysisPosInfo overall is null");
            return;
        }
        formatLocVision(overallVar);
        formatPosRTKImuResultExternal(overallVar);
        formatPosFusionResultExternal(overallVar);
    }

    private void outputSRRawInfoToFile(final String str) {
        WorkThreadUtil.getInstance().executeIOTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.sr.SRNaviDataHelper.1
            @Override // java.lang.Runnable
            public void run() {
                FileUtil.createFileWithByte(SRNaviDataHelper.SR_DATA_RAW_FOLDER, String.format("%s%s", new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.CHINA).format(new Date()), SRNaviDataHelper.SR_DATA_EXTENSION), str.getBytes());
            }
        });
    }

    private void outputBLSRInfoToFile(final String str) {
        WorkThreadUtil.getInstance().executeIOTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.sr.SRNaviDataHelper.2
            @Override // java.lang.Runnable
            public void run() {
                FileUtil.createFileWithByte(SRNaviDataHelper.SR_DATA_FOLDER, String.format("%s%s", new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.CHINA).format(new Date()), SRNaviDataHelper.SR_DATA_EXTENSION), str.getBytes());
            }
        });
    }

    private void formatPosFusionResultExternal(Overall.overall overallVar) {
        if (overallVar == null) {
            L.w(TAG, "formatPosFusionResultExternal overall is null");
            return;
        }
        Posrtkimu.Gaode_Info gaodeInfo = overallVar.getGaodeInfo();
        if (!overallVar.hasGaodeInfo() || gaodeInfo == null) {
            return;
        }
        Posrtkimu.PosFusionResultExternal brief9 = gaodeInfo.getBrief9();
        if (!gaodeInfo.hasBrief9() || brief9 == null) {
            return;
        }
        this.mLocAllFusionPos.tickTime = BigInteger.valueOf(brief9.getTicktime() / 1000000);
        this.mLocAllFusionPos.status = brief9.getStatus();
        this.mLocAllFusionPos.NS = (byte) brief9.getNs();
        this.mLocAllFusionPos.EW = (byte) brief9.getEw();
        Primitives.Vector3D posEnu = brief9.getPosEnu();
        if (posEnu != null && brief9.hasPosEnu()) {
            this.mLocAllFusionPos.posEnu.x = posEnu.getX();
            this.mLocAllFusionPos.posEnu.y = posEnu.getY();
            this.mLocAllFusionPos.posEnu.z = posEnu.getZ();
        }
        Primitives.Vector3D refPosEcef = brief9.getRefPosEcef();
        if (refPosEcef != null && brief9.hasRefPosEcef()) {
            this.mLocAllFusionPos.refPosEcef.x = refPosEcef.getX();
            this.mLocAllFusionPos.refPosEcef.y = refPosEcef.getY();
            this.mLocAllFusionPos.refPosEcef.z = refPosEcef.getZ();
        }
        this.mLocAllFusionPos.speed = brief9.getSpeed() * 3.6f;
        float degrees = (float) Math.toDegrees(brief9.getCourse());
        if (degrees < 0.0f) {
            degrees += 360.0f;
        }
        LocAllFusionPos locAllFusionPos = this.mLocAllFusionPos;
        locAllFusionPos.course = degrees;
        locAllFusionPos.alt = brief9.getAlt();
        this.mLocAllFusionPos.posAcc = brief9.getPosAcc();
        this.mLocAllFusionPos.courseAcc = (float) Math.toDegrees(brief9.getCourseAcc());
        LocAllFusionPos locAllFusionPos2 = this.mLocAllFusionPos;
        locAllFusionPos2.altAcc = -1.0f;
        locAllFusionPos2.speedAcc = brief9.getSpeedAcc() * 3.6f;
        this.mLocAllFusionPos.dateTime = formatTime(overallVar, brief9.getDatetime() / 1000000);
        this.mLocAllFusionPos.fusionType = (byte) brief9.getFusiontype();
        this.mLocAllFusionPos.isEnuLocalPos = (short) 1;
        Primitives.Quaternion refPosEcefq = brief9.getRefPosEcefq();
        if (refPosEcefq != null && brief9.hasRefPosEcefq()) {
            LocAllFusionPos locAllFusionPos3 = this.mLocAllFusionPos;
            locAllFusionPos3.isUseRotation = true;
            locAllFusionPos3.rotation.qx = refPosEcefq.getQx();
            this.mLocAllFusionPos.rotation.qy = refPosEcefq.getQy();
            this.mLocAllFusionPos.rotation.qz = refPosEcefq.getQz();
            this.mLocAllFusionPos.rotation.qw = refPosEcefq.getQw();
        }
        this.mManager.setAllFusionPos(this.mLocAllFusionPos);
        this.mSRInfo.setPosFusionResultExternal(this.mLocAllFusionPos);
    }

    private void analysisDecisionInfo(Overall.overall overallVar) {
        int i;
        if (overallVar == null) {
            L.w(TAG, "analysisDecisionInfo overall is null");
            return;
        }
        if (overallVar.getUseLastMp() == 0) {
            this.mDecision.coords.clear();
            Primitives.MotionPlanning mpInfo = overallVar.getMpInfo();
            List<Primitives.Trajectory> trajectList = mpInfo != null ? mpInfo.getTrajectList() : null;
            if (CollectionUtils.isNotEmpty(trajectList)) {
                if (this.mSRInfo.getPosFusionResultExternal() != null) {
                    PosCoordLocal posCoordLocal = this.mSRInfo.getPosFusionResultExternal().refPosEcef;
                    if (posCoordLocal != null) {
                        this.mDecision.localRefPos.x = posCoordLocal.x;
                        this.mDecision.localRefPos.y = posCoordLocal.y;
                        this.mDecision.localRefPos.z = posCoordLocal.z;
                    }
                    PosCoordLocal posCoordLocal2 = this.mSRInfo.getPosFusionResultExternal().posEnu;
                    r4 = posCoordLocal2 != null ? posCoordLocal2.z : 0.0d;
                    PosRotation posRotation = this.mSRInfo.getPosFusionResultExternal().rotation;
                    if (posRotation != null) {
                        this.mDecision.isUseRotation = this.mSRInfo.getPosFusionResultExternal().isUseRotation;
                        this.mDecision.rotation.qx = posRotation.qx;
                        this.mDecision.rotation.qy = posRotation.qy;
                        this.mDecision.rotation.qz = posRotation.qz;
                        this.mDecision.rotation.qw = posRotation.qw;
                    }
                }
                int driveMode = this.mSRInfo.getDriveMode();
                if (5 == driveMode || 6 == driveMode) {
                    for (Primitives.Trajectory trajectory : trajectList) {
                        if (trajectory != null) {
                            this.mDecision.coords.add(new RelativePos(trajectory.getX(), trajectory.getY(), r4));
                        }
                    }
                }
            }
            DynamicEnvironmentOuterClass.BPoutput bpInfo = overallVar.getBpInfo();
            if (bpInfo != null) {
                i = bpInfo.getBpToSm16();
                if (i != this.mSRInfo.getLaneChangedType()) {
                    this.mSRInfo.setLaneChangedType(i);
                    L.i(TAG, "lane change type:" + i);
                }
            } else {
                i = 1;
            }
            int i2 = 3;
            int i3 = 99;
            if (1 == i) {
                if (1 == this.mSRInfo.getNGPLaneChangedStatus()) {
                    i3 = 1;
                    i2 = 2;
                } else if (2 == this.mSRInfo.getNGPLaneChangedStatus()) {
                    i2 = 2;
                    i3 = 2;
                }
            }
            Decision decision = this.mDecision;
            decision.direction = i3;
            decision.changeStatus = i2;
        }
        LaneServiceManager.getInstance().setDecision(this.mDecision);
    }

    private void analysisSRObjectInfo(Overall.overall overallVar) {
        boolean z;
        List<Float> localPoseList;
        DynamicEnvironmentOuterClass.SfObject sfSnapshot;
        if (overallVar == null) {
            L.w(TAG, "analysisSRObjectInfo overall is null");
            return;
        }
        if (overallVar.getUseLastSfbp() == 0) {
            DynamicEnvironmentOuterClass.DynamicEnvironment dynamicInfo = overallVar.getDynamicInfo();
            if (dynamicInfo == null) {
                return;
            }
            this.mSRObjects.objects.clear();
            SRObjects sRObjects = this.mSRObjects;
            sRObjects.isUseSpeedSmooth = true;
            sRObjects.isUseAbsoluteHeading = true;
            List<DynamicEnvironmentOuterClass.SfbpDynamicObject> sfbpObjectList = dynamicInfo.getSfbpObjectList();
            HashMap hashMap = new HashMap();
            if (CollectionUtils.isNotEmpty(sfbpObjectList)) {
                z = false;
                for (DynamicEnvironmentOuterClass.SfbpDynamicObject sfbpDynamicObject : sfbpObjectList) {
                    if (sfbpDynamicObject != null && (sfSnapshot = sfbpDynamicObject.getSfSnapshot()) != null && sfSnapshot.getLocalPoseList() != null && sfSnapshot.getLocalPoseList().size() >= 3) {
                        SRObject sRObject = new SRObject();
                        sRObject.objectID = sfSnapshot.getId();
                        switch (sfSnapshot.getType().getNumber()) {
                            case 0:
                            case 3:
                                sRObject.srType = 3;
                                break;
                            case 1:
                                sRObject.srType = 1;
                                break;
                            case 2:
                                sRObject.srType = 2;
                                break;
                            case 4:
                                sRObject.srType = 4;
                                break;
                            case 5:
                                sRObject.srType = 5;
                                break;
                            case 6:
                                sRObject.srType = 6;
                                break;
                            case 7:
                                sRObject.srType = 7;
                                break;
                            case 8:
                                sRObject.srType = 8;
                                break;
                            case 9:
                                sRObject.srType = 9;
                                break;
                            case 10:
                                sRObject.srType = 10;
                                break;
                            case 11:
                                sRObject.srType = 11;
                                break;
                            case 12:
                                sRObject.srType = 21;
                                break;
                            default:
                                sRObject.srType = 0;
                                break;
                        }
                        sRObject.pos.x = sfSnapshot.getLocalPoseList().get(0).floatValue();
                        sRObject.pos.y = sfSnapshot.getLocalPoseList().get(1).floatValue();
                        if (dynamicInfo.getEgoMotion() != null) {
                            sRObject.heading = 1.5707964f - sfSnapshot.getLocalPoseList().get(2).floatValue();
                        }
                        int handlerSRColor = handlerSRColor(sfSnapshot);
                        if (handlerSRColor == 0) {
                            sRObject.isHighlight = false;
                        } else {
                            sRObject.isHighlight = true;
                        }
                        hashMap.put(Integer.valueOf(sfSnapshot.getId()), sfSnapshot);
                        sRObject.modelResID = LaneServiceManager.getInstance().getModelResId(sRObject.srType);
                        LaneServiceManager.getInstance().fillPartsStyle(handlerSRColor, sRObject);
                        if (CollectionUtils.isNotEmpty(sfSnapshot.getLocalVelocityList())) {
                            sRObject.speed = sfSnapshot.getLocalVelocityList().get(0).floatValue();
                        }
                        this.mSRObjects.objects.add(sRObject);
                        if (5 == sfSnapshot.getXPUCDUVeh1StatusD()) {
                            z = true;
                        }
                    }
                }
            } else {
                z = false;
            }
            this.mSRInfo.setHaveFlashSignal(z);
            List<DynamicEnvironmentOuterClass.SfbpStaticObject> sfbpStaObjectList = dynamicInfo.getSfbpStaObjectList();
            if (CollectionUtils.isNotEmpty(sfbpStaObjectList)) {
                for (DynamicEnvironmentOuterClass.SfbpStaticObject sfbpStaticObject : sfbpStaObjectList) {
                    if (sfbpStaticObject != null && (localPoseList = sfbpStaticObject.getLocalPoseList()) != null && localPoseList.size() >= 3) {
                        SRObject sRObject2 = new SRObject();
                        sRObject2.objectID = 0;
                        int number = sfbpStaticObject.getType().getNumber();
                        if (1 == number) {
                            sRObject2.srType = 82;
                        } else if (2 == number) {
                            sRObject2.srType = 80;
                        } else if (3 == number) {
                            sRObject2.srType = 81;
                        } else {
                            sRObject2.srType = 0;
                        }
                        sRObject2.pos.x = localPoseList.get(0).floatValue();
                        sRObject2.pos.y = localPoseList.get(1).floatValue();
                        if (dynamicInfo.getEgoMotion() != null) {
                            sRObject2.heading = localPoseList.get(2).floatValue() - dynamicInfo.getEgoMotion().getEgoYaw();
                        }
                        sRObject2.modelResID = LaneServiceManager.getInstance().getModelResId(sRObject2.srType);
                        this.mSRObjects.objects.add(sRObject2);
                    }
                }
            }
            if (this.mSRInfo.getPosFusionResultExternal() != null) {
                PosCoordLocal posCoordLocal = this.mSRInfo.getPosFusionResultExternal().refPosEcef;
                if (posCoordLocal != null) {
                    this.mSRObjects.localRefPos.x = posCoordLocal.x;
                    this.mSRObjects.localRefPos.y = posCoordLocal.y;
                    this.mSRObjects.localRefPos.z = posCoordLocal.z;
                }
                PosCoordLocal posCoordLocal2 = this.mSRInfo.getPosFusionResultExternal().posEnu;
                if (posCoordLocal2 != null) {
                    this.mSRObjects.carPos.x = posCoordLocal2.x;
                    this.mSRObjects.carPos.y = posCoordLocal2.y;
                    this.mSRObjects.carPos.z = posCoordLocal2.z;
                }
                PosRotation posRotation = this.mSRInfo.getPosFusionResultExternal().rotation;
                if (posRotation != null) {
                    this.mSRObjects.isUseRotation = this.mSRInfo.getPosFusionResultExternal().isUseRotation;
                    this.mSRObjects.rotation.qx = posRotation.qx;
                    this.mSRObjects.rotation.qy = posRotation.qy;
                    this.mSRObjects.rotation.qz = posRotation.qz;
                    this.mSRObjects.rotation.qw = posRotation.qw;
                }
            }
        }
        LaneServiceManager.getInstance().setSRObject(this.mSRObjects);
    }

    private GPSDatetime formatTime(Overall.overall overallVar) {
        return formatTime(overallVar, 0L);
    }

    private int handlerSRColor(DynamicEnvironmentOuterClass.SfObject sfObject) {
        if (sfObject == null) {
            return 0;
        }
        int xPUCDUVeh1StatusD = sfObject.getXPUCDUVeh1StatusD();
        xPUCDUVeh1StatusD = (5 == xPUCDUVeh1StatusD || 3 == xPUCDUVeh1StatusD) ? 4 : 4;
        if (1 == this.mSRInfo.getDriveMode()) {
            return 0;
        }
        return xPUCDUVeh1StatusD;
    }

    private GPSDatetime formatTime(Overall.overall overallVar, long j) {
        if (this.mCalendar == null) {
            this.mCalendar = Calendar.getInstance();
        }
        GPSDatetime gPSDatetime = new GPSDatetime();
        if (0 != j) {
            this.mCalendar.setTimeInMillis(j);
        }
        gPSDatetime.year = this.mCalendar.get(1);
        gPSDatetime.month = this.mCalendar.get(2) + 1;
        gPSDatetime.day = this.mCalendar.get(5);
        gPSDatetime.hour = this.mCalendar.get(11);
        gPSDatetime.minute = this.mCalendar.get(12);
        gPSDatetime.second = this.mCalendar.get(13);
        return gPSDatetime;
    }

    private void formatPosRTKImuResultExternal(Overall.overall overallVar) {
        Primitives.Wgs worldPose;
        if (overallVar == null) {
            L.w(TAG, "formatPosRTKImuResultExternal overall is null");
            return;
        }
        Posrtkimu.Gaode_Info gaodeInfo = overallVar.getGaodeInfo();
        if (!overallVar.hasGaodeInfo() || gaodeInfo == null) {
            return;
        }
        Posrtkimu.PosRTKImuResultExternal brief8 = gaodeInfo.getBrief8();
        if (!gaodeInfo.hasBrief8() || brief8 == null) {
            return;
        }
        this.mLocDrPos.tickTime = BigInteger.valueOf(brief8.getTicktime() / 1000000);
        this.mLocDrPos.gpsStatus = brief8.getStatus();
        this.mLocDrPos.NS = (byte) brief8.getNs();
        this.mLocDrPos.EW = (byte) brief8.getEw();
        Primitives.GlobalPoseInfo pos = brief8.getPos();
        if (pos != null && brief8.hasPos() && (worldPose = pos.getWorldPose()) != null && pos.hasWorldPose()) {
            this.mLocDrPos.stPosRaw.lon = worldPose.getLng();
            this.mLocDrPos.stPosRaw.lat = worldPose.getLat();
        }
        this.mLocDrPos.speed = brief8.getSpeed() * 3.6f;
        float degrees = (float) Math.toDegrees(brief8.getCourse());
        if (degrees < 0.0f) {
            degrees += 360.0f;
        }
        LocDrPos locDrPos = this.mLocDrPos;
        locDrPos.course = degrees;
        locDrPos.alt = brief8.getAlt();
        this.mLocDrPos.posAcc = brief8.getPosacc();
        this.mLocDrPos.courseAcc = (float) Math.toDegrees(brief8.getCourseacc());
        LocDrPos locDrPos2 = this.mLocDrPos;
        locDrPos2.altAcc = -1.0f;
        locDrPos2.speedAcc = brief8.getSpeedacc() * 3.6f;
        this.mLocDrPos.satNum = (int) brief8.getSatnum();
        this.mLocDrPos.hdop = brief8.getHdop();
        this.mLocDrPos.vdop = brief8.getVdop();
        this.mLocDrPos.pdop = brief8.getPdop();
        this.mLocDrPos.dateTime = formatTime(overallVar, brief8.getDatetime() / 1000000);
        LocDrPos locDrPos3 = this.mLocDrPos;
        locDrPos3.isEncrypted = (short) 0;
        this.mManager.setDrPos(locDrPos3);
    }

    private void formatLocVision(Overall.overall overallVar) {
        if (overallVar == null) {
            L.w(TAG, "formatLocVision overall is null");
            return;
        }
        Primitives.MapFusionLanesForScu mfLaneInfo = overallVar.getMfLaneInfo();
        if (mfLaneInfo == null || !overallVar.hasMfLaneInfo()) {
            return;
        }
        LocVision locVision = this.mLocVision;
        locVision.leftLaneCnt = 0;
        locVision.leftLanes.clear();
        LocVision locVision2 = this.mLocVision;
        locVision2.rightLaneCnt = 0;
        locVision2.rightLanes.clear();
        Primitives.laneinfo_list xpuLaneinfo = mfLaneInfo.getXpuLaneinfo();
        if (xpuLaneinfo != null && mfLaneInfo.hasXpuLaneinfo()) {
            if (xpuLaneinfo.hasLe1() && xpuLaneinfo.getLe1() != null) {
                this.mLocVision.leftLanes.add(formatXpuLaneToBLLane(xpuLaneinfo.getLe1()));
            }
            if (xpuLaneinfo.hasLe2() && xpuLaneinfo.getLe2() != null) {
                this.mLocVision.leftLanes.add(formatXpuLaneToBLLane(xpuLaneinfo.getLe2()));
            }
            if (xpuLaneinfo.hasLe3() && xpuLaneinfo.getLe3() != null) {
                this.mLocVision.leftLanes.add(formatXpuLaneToBLLane(xpuLaneinfo.getLe3()));
            }
            if (xpuLaneinfo.hasRi1() && xpuLaneinfo.getRi1() != null) {
                this.mLocVision.rightLanes.add(formatXpuLaneToBLLane(xpuLaneinfo.getRi1()));
            }
            if (xpuLaneinfo.hasRi2() && xpuLaneinfo.getRi2() != null) {
                this.mLocVision.rightLanes.add(formatXpuLaneToBLLane(xpuLaneinfo.getRi2()));
            }
            if (xpuLaneinfo.hasRi3() && xpuLaneinfo.getRi3() != null) {
                this.mLocVision.rightLanes.add(formatXpuLaneToBLLane(xpuLaneinfo.getRi3()));
            }
            LocVision locVision3 = this.mLocVision;
            locVision3.leftLaneCnt = (short) locVision3.leftLanes.size();
            LocVision locVision4 = this.mLocVision;
            locVision4.rightLaneCnt = (short) locVision4.rightLanes.size();
            this.mLocVision.ticktime = mfLaneInfo.getTimestamp().getNsecs() / 1000000;
        }
        this.mManager.setLocVision(this.mLocVision);
    }

    private LocLane formatXpuLaneToBLLane(Primitives.lanelineinfo_xpu2scu lanelineinfo_xpu2scuVar) {
        if (lanelineinfo_xpu2scuVar == null) {
            return null;
        }
        LocLane locLane = new LocLane();
        int lanetype = lanelineinfo_xpu2scuVar.getLanetype();
        if (lanetype == 0) {
            locLane.type = 1;
        } else if (lanetype == 1) {
            locLane.type = 2;
        } else if (lanetype == 2) {
            locLane.type = 5;
        } else if (lanetype == 3) {
            locLane.type = 7;
        } else if (lanetype == 4) {
            locLane.type = 8;
        } else if (lanetype == 5) {
            locLane.type = 4;
        } else if (lanetype == 10) {
            locLane.type = 6;
        } else if (lanetype == 11) {
            locLane.type = 3;
        } else {
            locLane.type = 0;
        }
        LineGeometry lineGeometry = new LineGeometry();
        lineGeometry.c0 = lanelineinfo_xpu2scuVar.getLanedistyC0();
        lineGeometry.c1 = lanelineinfo_xpu2scuVar.getLaneyawangleC1();
        lineGeometry.c2 = lanelineinfo_xpu2scuVar.getLanecurveC2();
        lineGeometry.c3 = lanelineinfo_xpu2scuVar.getLanecurvechangeC3();
        lineGeometry.width = lanelineinfo_xpu2scuVar.getLanewidth();
        lineGeometry.qualityGeometry = lanelineinfo_xpu2scuVar.getLaneexistprob();
        locLane.qualityType = lanelineinfo_xpu2scuVar.getLanetypeprob();
        lineGeometry.viewRangeStart = lanelineinfo_xpu2scuVar.getLanestartdx();
        lineGeometry.viewRangeEnd = lanelineinfo_xpu2scuVar.getLaneenddx();
        locLane.color = lanelineinfo_xpu2scuVar.getLanecolorValue();
        locLane.geometry = lineGeometry;
        return locLane;
    }

    private void analysisDriveMode() {
        int driveMode = this.mSRInfo.getDriveMode();
        int driveMode2 = this.mSRInfoTemp.getDriveMode();
        boolean z = driveMode != driveMode2;
        if (z) {
            L.Tag tag = TAG;
            L.i(tag, "analysisDriveMode isNeedSync:" + z + ",currentMode:" + driveMode + ",mode:" + driveMode2);
        }
        if (z) {
            if (SRNaviManager.getInstance().getIsShowSRData()) {
                SRDebugEvent sRDebugEvent = new SRDebugEvent(6);
                sRDebugEvent.mTipsType = driveMode2;
                EventBus.getDefault().post(sRDebugEvent);
            }
            this.mSRInfo.setDriveMode(driveMode2);
            LaneServiceManager.getInstance().setDriveMode(driveMode2);
            SRNaviManager sRNaviManager = this.mManager;
            if (sRNaviManager != null) {
                sRNaviManager.onDriveModeChange(driveMode2);
            }
        }
    }

    private void analysisSRLCCLight() {
        boolean isLCCLight = this.mSRInfo.isLCCLight();
        boolean isLCCLight2 = this.mSRInfoTemp.isLCCLight();
        if (isLCCLight == isLCCLight2 || this.mManager == null) {
            return;
        }
        LaneServiceManager.getInstance().openLCC(isLCCLight2);
        this.mSRInfo.setLCCLight(isLCCLight2);
    }

    private void analysisSRLCViewMode() {
        int sRLcViewMode = this.mSRInfo.getSRLcViewMode();
        int sRLcViewMode2 = this.mSRInfoTemp.getSRLcViewMode();
        boolean z = true;
        if (sRLcViewMode == sRLcViewMode2 || (sRLcViewMode2 != 0 && 1 != sRLcViewMode2 && 2 != sRLcViewMode2)) {
            z = false;
        }
        if (L.ENABLE && z) {
            L.Tag tag = TAG;
            L.d(tag, "analysisSRLCViewMode isNeedSync:" + z + ",currentMode:" + sRLcViewMode + ",mode:" + sRLcViewMode2);
        }
        if (z) {
            this.mSRInfo.setSRLcViewMode(sRLcViewMode2);
            SRNaviManager sRNaviManager = this.mManager;
            if (sRNaviManager != null) {
                sRNaviManager.srLCViewChanged(sRLcViewMode2);
            }
        }
    }

    private void analysisNgpLaneChangeStatus() {
        int nGPLaneChangedStatus = this.mSRInfo.getNGPLaneChangedStatus();
        int nGPLaneChangedStatus2 = this.mSRInfoTemp.getNGPLaneChangedStatus();
        boolean z = nGPLaneChangedStatus != nGPLaneChangedStatus2;
        if (z) {
            L.Tag tag = TAG;
            L.i(tag, "analysisNgpLaneChangeStatus isNeedSync:" + z + ",currentMode:" + nGPLaneChangedStatus + ",mode:" + nGPLaneChangedStatus2);
        }
        if (z) {
            if (SRNaviManager.getInstance().getIsShowSRData()) {
                SRDebugEvent sRDebugEvent = new SRDebugEvent(4);
                sRDebugEvent.mTipsType = nGPLaneChangedStatus2;
                EventBus.getDefault().post(sRDebugEvent);
            }
            this.mSRInfo.setNGPLaneChangedStatus(nGPLaneChangedStatus2);
            SRNaviManager sRNaviManager = this.mManager;
            if (sRNaviManager != null) {
                sRNaviManager.srNgpLaneChanged(nGPLaneChangedStatus2);
            }
        }
    }

    private void analysisSRSpdViewMode() {
        int sRSpdViewMode = this.mSRInfo.getSRSpdViewMode();
        int sRSpdViewMode2 = this.mSRInfoTemp.getSRSpdViewMode();
        boolean z = sRSpdViewMode != sRSpdViewMode2;
        if (L.ENABLE && z) {
            L.Tag tag = TAG;
            L.d(tag, "analysisSRSpdViewMode isNeedSync:" + z + ",currentMode:" + sRSpdViewMode + ",mode:" + sRSpdViewMode2);
        }
        if (z) {
            this.mSRInfo.setSRSpdViewMode(sRSpdViewMode2);
            SRNaviManager sRNaviManager = this.mManager;
            if (sRNaviManager != null) {
                sRNaviManager.srSpdViewChanged(sRSpdViewMode2);
            }
        }
    }

    private void analysisSRDisplayState() {
        int sRDisplayState = this.mSRInfo.getSRDisplayState();
        int sRDisplayState2 = this.mSRInfoTemp.getSRDisplayState();
        if (3 == sRDisplayState2) {
            sRDisplayState2 = this.mSrDisplaySt;
        } else {
            this.mSrDisplaySt = sRDisplayState2;
        }
        boolean z = sRDisplayState != this.mSrDisplaySt;
        if (this.mSRInfoTemp.isDriveModeChangeToNgp()) {
            z = true;
        }
        if (!this.mManager.isLaneModeEnable()) {
            z = false;
        }
        if (z) {
            L.i(TAG, "analysisSRDisplayState currentState:" + sRDisplayState + ",state:" + sRDisplayState2 + ", isHdmapMode:" + this.mManager.isLaneModeEnable());
            if (SRNaviManager.getInstance().getIsShowSRData()) {
                SRDebugEvent sRDebugEvent = new SRDebugEvent(3);
                sRDebugEvent.mTipsType = sRDisplayState2;
                EventBus.getDefault().post(sRDebugEvent);
            }
            this.mSRInfo.setSRDisplayState(sRDisplayState2);
            if (4 == sRDisplayState2) {
                this.mManager.srDisplayStChangedTo4();
                return;
            }
            SRNaviManager sRNaviManager = this.mManager;
            if (sRNaviManager != null) {
                sRNaviManager.srDisplayStChanged(sRDisplayState2);
            }
        }
    }

    public void setSRDisplayState(int i) {
        this.mSRInfo.setSRDisplayState(i);
    }

    private void analysisXPULimitSpdDisp() {
        int limitSpeed = this.mSRInfo.getLimitSpeed();
        int limitSpeed2 = this.mSRInfoTemp.getLimitSpeed();
        boolean z = limitSpeed != limitSpeed2;
        if (L.ENABLE && z) {
            L.Tag tag = TAG;
            L.d(tag, "analysisXPULimitSpdDisp isNeedSync:" + z + ",limitSpeed:" + limitSpeed + ",speed:" + limitSpeed2);
        }
        if (z) {
            this.mSRInfo.setLimitSpeed(limitSpeed2);
            SRNaviManager sRNaviManager = this.mManager;
            if (sRNaviManager != null) {
                sRNaviManager.onLimitSpeed(limitSpeed2);
            }
        }
    }

    private void analysisXPUCruiseSpdDisp() {
        int cruiseSpeed = this.mSRInfo.getCruiseSpeed();
        int cruiseSpeed2 = this.mSRInfoTemp.getCruiseSpeed();
        boolean z = cruiseSpeed != cruiseSpeed2;
        if (L.ENABLE && z) {
            L.Tag tag = TAG;
            L.d(tag, "analysisXPUCruiseSpdDisp isNeedSync:" + z + ",cruiseSpeed:" + cruiseSpeed + ",speed:" + cruiseSpeed2);
        }
        if (z) {
            this.mSRInfo.setCruiseSpeed(cruiseSpeed2);
            SRNaviManager sRNaviManager = this.mManager;
            if (sRNaviManager != null) {
                sRNaviManager.onCruiseSpeed(cruiseSpeed2);
            }
        }
    }

    private void analysisXPUCDUNGPOpeButtonSt() {
        int nGPOpeButtonStatus = this.mSRInfo.getNGPOpeButtonStatus();
        int nGPOpeButtonStatus2 = this.mSRInfoTemp.getNGPOpeButtonStatus();
        boolean z = nGPOpeButtonStatus != nGPOpeButtonStatus2;
        if (L.ENABLE && z) {
            L.Tag tag = TAG;
            L.d(tag, "analysisXPUCDUNGPOpeButtonSt isNeedSync:" + z + ",currentStatus:" + nGPOpeButtonStatus + ",status:" + nGPOpeButtonStatus2);
        }
        if (z) {
            if (SRNaviManager.getInstance().getIsShowSRData()) {
                SRDebugEvent sRDebugEvent = new SRDebugEvent(2);
                sRDebugEvent.mTipsType = nGPOpeButtonStatus2;
                EventBus.getDefault().post(sRDebugEvent);
            }
            this.mSRInfo.setNGPOpeButtonStatus(nGPOpeButtonStatus2);
            SRNaviManager sRNaviManager = this.mManager;
            if (sRNaviManager != null) {
                sRNaviManager.setScuNgpOpeButtonStatus(0);
                this.mManager.onScuNgpOpeButton(nGPOpeButtonStatus2);
            }
        }
    }

    private void analysisXPUCDUNGPLCTips1AndQuitODD() {
        int nGPLCTips1Status = this.mSRInfo.getNGPLCTips1Status();
        int quitNGPODDStatus = this.mSRInfo.getQuitNGPODDStatus();
        int nGPLCTips1Status2 = this.mSRInfoTemp.getNGPLCTips1Status();
        int quitNGPODDStatus2 = this.mSRInfoTemp.getQuitNGPODDStatus();
        boolean z = (nGPLCTips1Status == nGPLCTips1Status2 && quitNGPODDStatus == quitNGPODDStatus2) ? false : true;
        if (L.ENABLE && z) {
            L.Tag tag = TAG;
            L.d(tag, "analysisXPUCDUNGPLCTips1AndQuitODD isNeedSync:" + z + ",currentLcTipsStatus:" + nGPLCTips1Status + ",lcTipsStatus:" + nGPLCTips1Status2 + ",currentOddStatus:" + quitNGPODDStatus + ",oddStatus:" + quitNGPODDStatus2);
        }
        if (z) {
            if (SRNaviManager.getInstance().getIsShowSRData()) {
                SRDebugEvent sRDebugEvent = new SRDebugEvent(1);
                sRDebugEvent.mTipsType = nGPLCTips1Status2;
                sRDebugEvent.mTipsType1 = quitNGPODDStatus2;
                EventBus.getDefault().post(sRDebugEvent);
            }
            this.mSRInfo.setNGPLCTips1Status(nGPLCTips1Status2);
            this.mSRInfo.setQuitNGPODDStatus(quitNGPODDStatus2);
            SRNaviManager sRNaviManager = this.mManager;
            if (sRNaviManager != null) {
                sRNaviManager.onScuNgpLcTips1AndNgpOddStatus(nGPLCTips1Status2, quitNGPODDStatus2);
            }
        }
    }

    private void analysisXPUCDUNGPLCTips1TTS(Overall.overall overallVar) {
        if (overallVar == null) {
            L.w(TAG, "analysisXPUCDUNGPLCTips1TTS overall is null");
            return;
        }
        Primitives.StateManagement smInfo = overallVar.getSmInfo();
        int nGPLCTips1TTSStatus = this.mSRInfo.getNGPLCTips1TTSStatus();
        if (smInfo != null) {
            int rdmodulecom13State = smInfo.getRdmodulecom13State();
            boolean z = nGPLCTips1TTSStatus != rdmodulecom13State;
            if (L.ENABLE && z) {
                L.Tag tag = TAG;
                L.d(tag, "analysisXPUCDUNGPLCTips1TTS isNeedSync:" + z + ",currentStatus:" + nGPLCTips1TTSStatus + ",status:" + rdmodulecom13State);
            }
            if (z) {
                if (SRNaviManager.getInstance().getIsShowSRData()) {
                    SRDebugEvent sRDebugEvent = new SRDebugEvent(5);
                    sRDebugEvent.mTipsType = rdmodulecom13State;
                    EventBus.getDefault().post(sRDebugEvent);
                }
                this.mSRInfo.setNGPLCTips1TTSStatus(rdmodulecom13State);
                SRNaviManager sRNaviManager = this.mManager;
                if (sRNaviManager != null) {
                    sRNaviManager.onScuNgpLcTips1TTS(rdmodulecom13State);
                }
            }
        }
    }

    private void analysisXPUCDUNGPInfoTips1() {
        int nGPInfoTips1Status = this.mSRInfo.getNGPInfoTips1Status();
        int nGPInfoTips1Status2 = this.mSRInfoTemp.getNGPInfoTips1Status();
        boolean z = nGPInfoTips1Status != nGPInfoTips1Status2;
        if (L.ENABLE && z) {
            L.Tag tag = TAG;
            L.d(tag, "analysisXPUCDUNGPInfoTips1 isNeedSync:" + z + ",currentStatus:" + nGPInfoTips1Status + ",status:" + nGPInfoTips1Status2);
        }
        if (z) {
            if (SRNaviManager.getInstance().getIsShowSRData()) {
                SRDebugEvent sRDebugEvent = new SRDebugEvent(0);
                sRDebugEvent.mTipsType = nGPInfoTips1Status2;
                EventBus.getDefault().post(sRDebugEvent);
            }
            this.mSRInfo.setNGPInfoTips1Status(nGPInfoTips1Status2);
            SRNaviManager sRNaviManager = this.mManager;
            if (sRNaviManager != null) {
                sRNaviManager.onScuNgpInfoTips1(nGPInfoTips1Status2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getVehSpeed() {
        XPLocPulse xPLocPulse = this.mSRInfo.getXPLocPulse();
        if (xPLocPulse != null) {
            return xPLocPulse.getValue();
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getSRDisplayState() {
        return this.mSRInfo.getSRDisplayState();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getSRSpdViewMode() {
        return this.mSRInfo.getSRSpdViewMode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getSRLcViewMode() {
        return this.mSRInfo.getSRLcViewMode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getDriveMode() {
        return this.mSRInfo.getDriveMode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getLimitSpeed() {
        return this.mSRInfo.getLimitSpeed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getCruiseSpeed() {
        return this.mSRInfo.getCruiseSpeed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getQuitNGPODDStatus() {
        return this.mSRInfo.getQuitNGPODDStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getNGPLCTips1TTSStatus() {
        return this.mSRInfo.getNGPLCTips1TTSStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getNGPOpeButtonStatus() {
        return this.mSRInfo.getNGPOpeButtonStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getNGPLCTips1Status() {
        return this.mSRInfo.getNGPLCTips1Status();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getNGPInfoTips1Status() {
        return this.mSRInfo.getNGPInfoTips1Status();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getNGPLaneChangedStatus() {
        return this.mSRInfo.getNGPLaneChangedStatus();
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.SrCarServiceManager.IXPSrCarStateListener
    public void onSrRdPeriodDataComing(byte[] bArr, long j) {
        SRNaviManager sRNaviManager = this.mManager;
        if (sRNaviManager != null) {
            sRNaviManager.onSrRdPeriodDataComing(bArr, j);
        }
    }
}
