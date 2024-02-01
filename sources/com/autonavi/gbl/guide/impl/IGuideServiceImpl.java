package com.autonavi.gbl.guide.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.CalcRouteResultData;
import com.autonavi.gbl.common.model.ElecInfoConfig;
import com.autonavi.gbl.guide.GuideService;
import com.autonavi.gbl.guide.model.CleanContinueGuide;
import com.autonavi.gbl.guide.model.GuideControlKey;
import com.autonavi.gbl.guide.model.ManeuverConfig;
import com.autonavi.gbl.guide.model.NaviType;
import com.autonavi.gbl.guide.model.QueryLanesInfo;
import com.autonavi.gbl.guide.model.guidecontrol.Param;
import com.autonavi.gbl.guide.model.guidecontrol.Type;
import com.autonavi.gbl.guide.model.impl.ContinueGuidePathImpl;
import com.autonavi.gbl.guide.model.impl.NaviPathImpl;
import com.autonavi.gbl.guide.observer.impl.IContinueGuideInfoObserverImpl;
import com.autonavi.gbl.guide.observer.impl.ICruiseObserverImpl;
import com.autonavi.gbl.guide.observer.impl.INaviObserverImpl;
import com.autonavi.gbl.guide.observer.impl.ISoundPlayObserverImpl;
import com.autonavi.gbl.route.model.RouteRestorationResultData;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
@IntfAuto(target = GuideService.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IGuideServiceImpl implements IService {
    private static BindTable BIND_TABLE = new BindTable(IGuideServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native boolean addContinueGuideInfoObserverNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2, IContinueGuideInfoObserverImpl iContinueGuideInfoObserverImpl);

    private static native void addCruiseObserverNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2, ICruiseObserverImpl iCruiseObserverImpl);

    private static native void addNaviObserverNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2, INaviObserverImpl iNaviObserverImpl);

    private static native void addSoundPlayObserverNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2, ISoundPlayObserverImpl iSoundPlayObserverImpl);

    private static native int cleanContinueGuideInfoNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2, CleanContinueGuide cleanContinueGuide);

    private static native boolean controlNative(long j, IGuideServiceImpl iGuideServiceImpl, int i, String str);

    private static native void destroyNativeObj(long j);

    private static native int getContinueGuideNaviPathNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2, NaviPathImpl naviPathImpl);

    private static native int getContinueGuidePathNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2, ContinueGuidePathImpl continueGuidePathImpl);

    private static native String getEngineVersionNative();

    private static native Param getParamNative(long j, IGuideServiceImpl iGuideServiceImpl, int i);

    private static native String getVersionNative(long j, IGuideServiceImpl iGuideServiceImpl);

    private static native void ignoreTmcSugguestNaviPathNative(long j, IGuideServiceImpl iGuideServiceImpl);

    private static native int initNative(long j, IGuideServiceImpl iGuideServiceImpl);

    private static native int isInitNative(long j, IGuideServiceImpl iGuideServiceImpl);

    private static native void logSwitchNative(long j, IGuideServiceImpl iGuideServiceImpl, int i);

    private static native void notifyRerouteFailNative(long j, IGuideServiceImpl iGuideServiceImpl, int i);

    private static native long obtainAdvancedManeuverIconDataNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2, ManeuverConfig maneuverConfig);

    private static native long obtainExitDirectionInfoNative(long j, IGuideServiceImpl iGuideServiceImpl, boolean z);

    private static native long obtainManeuverIconDataNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2, ManeuverConfig maneuverConfig);

    private static native long obtainSAPAInfoNative(long j, IGuideServiceImpl iGuideServiceImpl, boolean z);

    private static native boolean pauseNaviNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2);

    private static native boolean playNaviManualNative(long j, IGuideServiceImpl iGuideServiceImpl);

    private static native boolean playTRManual1Native(long j, IGuideServiceImpl iGuideServiceImpl, int i);

    private static native boolean playTRManualExtNative(long j, IGuideServiceImpl iGuideServiceImpl, int i);

    private static native boolean playTRManualNative(long j, IGuideServiceImpl iGuideServiceImpl, int i, int i2);

    private static native int queryAppointLanesInfoNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2, QueryLanesInfo queryLanesInfo);

    private static native boolean removeContinueGuideInfoObserverNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2, IContinueGuideInfoObserverImpl iContinueGuideInfoObserverImpl);

    private static native void removeCruiseObserverNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2, ICruiseObserverImpl iCruiseObserverImpl);

    private static native void removeNaviObserverNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2, INaviObserverImpl iNaviObserverImpl);

    private static native void removeSoundPlayObserverNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2, ISoundPlayObserverImpl iSoundPlayObserverImpl);

    private static native boolean resumeNaviNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2);

    private static native void selectMainPathIDNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2);

    private static native void setCustomizationInfoNative(long j, IGuideServiceImpl iGuideServiceImpl, String str);

    private static native void setElecInfoConfigNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2, ElecInfoConfig elecInfoConfig);

    private static native boolean setNaviPathNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2, NaviPathImpl naviPathImpl);

    private static native boolean setParamNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2, Param param);

    private static native int setPathDataNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2, CalcRouteResultData calcRouteResultData, long j3, RouteRestorationResultData routeRestorationResultData, long j4);

    private static native boolean startNaviNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2, int i);

    private static native boolean stopNavi1Native(long j, IGuideServiceImpl iGuideServiceImpl, long j2);

    private static native boolean stopNaviNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2, boolean z);

    private static native void unInitNative(long j, IGuideServiceImpl iGuideServiceImpl);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected IGuideServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IGuideServiceImpl) && getUID(this) == getUID((IGuideServiceImpl) obj);
    }

    private static long getUID(IGuideServiceImpl iGuideServiceImpl) {
        long cPtr = getCPtr(iGuideServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IGuideServiceImpl iGuideServiceImpl) {
        if (iGuideServiceImpl == null) {
            return 0L;
        }
        return iGuideServiceImpl.swigCPtr;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        return this.swigCPtr;
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public static String getEngineVersion() {
        return getEngineVersionNative();
    }

    public int init() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initNative(j, this);
    }

    public void unInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        unInitNative(j, this);
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isInitNative(j, this);
    }

    public void logSwitch(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        logSwitchNative(j, this, i);
    }

    public String getVersion() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getVersionNative(j, this);
    }

    public boolean control(@GuideControlKey.GuideControlKey1 int i, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return controlNative(j, this, i, str);
    }

    public boolean setParam(Param param) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setParamNative(j, this, 0L, param);
    }

    public Param getParam(@Type.Type1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getParamNative(j, this, i);
    }

    public boolean setNaviPath(NaviPathImpl naviPathImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setNaviPathNative(j, this, NaviPathImpl.getCPtr(naviPathImpl), naviPathImpl);
    }

    public void setElecInfoConfig(ElecInfoConfig elecInfoConfig) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setElecInfoConfigNative(j, this, 0L, elecInfoConfig);
    }

    public void notifyRerouteFail(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notifyRerouteFailNative(j, this, i);
    }

    public void selectMainPathID(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        selectMainPathIDNative(j2, this, j);
    }

    public void ignoreTmcSugguestNaviPath() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        ignoreTmcSugguestNaviPathNative(j, this);
    }

    public boolean startNavi(long j, @NaviType.NaviType1 int i) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return startNaviNative(j2, this, j, i);
    }

    public boolean stopNavi(long j, boolean z) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return stopNaviNative(j2, this, j, z);
    }

    public boolean stopNavi(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return stopNavi1Native(j2, this, j);
    }

    public boolean pauseNavi(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return pauseNaviNative(j2, this, j);
    }

    public boolean resumeNavi(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return resumeNaviNative(j2, this, j);
    }

    public boolean playNaviManual() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return playNaviManualNative(j, this);
    }

    public boolean playTRManual(int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return playTRManualNative(j, this, i, i2);
    }

    public boolean playTRManual(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return playTRManual1Native(j, this, i);
    }

    public boolean playTRManualExt(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return playTRManualExtNative(j, this, i);
    }

    public long obtainManeuverIconData(ManeuverConfig maneuverConfig) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return obtainManeuverIconDataNative(j, this, 0L, maneuverConfig);
    }

    public long obtainAdvancedManeuverIconData(ManeuverConfig maneuverConfig) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return obtainAdvancedManeuverIconDataNative(j, this, 0L, maneuverConfig);
    }

    public long obtainExitDirectionInfo(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return obtainExitDirectionInfoNative(j, this, z);
    }

    public long obtainSAPAInfo(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return obtainSAPAInfoNative(j, this, z);
    }

    public void setCustomizationInfo(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setCustomizationInfoNative(j, this, str);
    }

    public int queryAppointLanesInfo(QueryLanesInfo queryLanesInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return queryAppointLanesInfoNative(j, this, 0L, queryLanesInfo);
    }

    public int setPathData(CalcRouteResultData calcRouteResultData, RouteRestorationResultData routeRestorationResultData, long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return setPathDataNative(j2, this, 0L, calcRouteResultData, 0L, routeRestorationResultData, j);
    }

    public int cleanContinueGuideInfo(CleanContinueGuide cleanContinueGuide) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return cleanContinueGuideInfoNative(j, this, 0L, cleanContinueGuide);
    }

    public ContinueGuidePathImpl getContinueGuidePath() {
        ContinueGuidePathImpl continueGuidePathImpl = new ContinueGuidePathImpl();
        if (Integer.valueOf(getContinueGuidePath(continueGuidePathImpl)).intValue() == 0) {
            return continueGuidePathImpl;
        }
        return null;
    }

    private int getContinueGuidePath(ContinueGuidePathImpl continueGuidePathImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getContinueGuidePathNative(j, this, ContinueGuidePathImpl.getCPtr(continueGuidePathImpl), continueGuidePathImpl);
    }

    public NaviPathImpl getContinueGuideNaviPath() {
        NaviPathImpl naviPathImpl = new NaviPathImpl();
        if (Integer.valueOf(getContinueGuideNaviPath(naviPathImpl)).intValue() == 0) {
            return naviPathImpl;
        }
        return null;
    }

    private int getContinueGuideNaviPath(NaviPathImpl naviPathImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getContinueGuideNaviPathNative(j, this, NaviPathImpl.getCPtr(naviPathImpl), naviPathImpl);
    }

    public void addCruiseObserver(ICruiseObserverImpl iCruiseObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addCruiseObserverNative(j, this, ICruiseObserverImpl.getCPtr(iCruiseObserverImpl), iCruiseObserverImpl);
    }

    public void removeCruiseObserver(ICruiseObserverImpl iCruiseObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeCruiseObserverNative(j, this, ICruiseObserverImpl.getCPtr(iCruiseObserverImpl), iCruiseObserverImpl);
    }

    public void addNaviObserver(INaviObserverImpl iNaviObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addNaviObserverNative(j, this, INaviObserverImpl.getCPtr(iNaviObserverImpl), iNaviObserverImpl);
    }

    public void removeNaviObserver(INaviObserverImpl iNaviObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeNaviObserverNative(j, this, INaviObserverImpl.getCPtr(iNaviObserverImpl), iNaviObserverImpl);
    }

    public void addSoundPlayObserver(ISoundPlayObserverImpl iSoundPlayObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addSoundPlayObserverNative(j, this, ISoundPlayObserverImpl.getCPtr(iSoundPlayObserverImpl), iSoundPlayObserverImpl);
    }

    public void removeSoundPlayObserver(ISoundPlayObserverImpl iSoundPlayObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeSoundPlayObserverNative(j, this, ISoundPlayObserverImpl.getCPtr(iSoundPlayObserverImpl), iSoundPlayObserverImpl);
    }

    public boolean addContinueGuideInfoObserver(IContinueGuideInfoObserverImpl iContinueGuideInfoObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addContinueGuideInfoObserverNative(j, this, IContinueGuideInfoObserverImpl.getCPtr(iContinueGuideInfoObserverImpl), iContinueGuideInfoObserverImpl);
    }

    public boolean removeContinueGuideInfoObserver(IContinueGuideInfoObserverImpl iContinueGuideInfoObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return removeContinueGuideInfoObserverNative(j, this, IContinueGuideInfoObserverImpl.getCPtr(iContinueGuideInfoObserverImpl), iContinueGuideInfoObserverImpl);
    }
}
