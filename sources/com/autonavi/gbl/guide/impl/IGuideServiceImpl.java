package com.autonavi.gbl.guide.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.model.ElecInfoConfig;
import com.autonavi.gbl.guide.GuideService;
import com.autonavi.gbl.guide.model.GuideControlKey;
import com.autonavi.gbl.guide.model.ManeuverConfig;
import com.autonavi.gbl.guide.model.NaviExtraInfoType;
import com.autonavi.gbl.guide.model.NaviType;
import com.autonavi.gbl.guide.model.guidecontrol.Param;
import com.autonavi.gbl.guide.model.impl.NaviPathImpl;
import com.autonavi.gbl.guide.observer.impl.ICruiseObserverImpl;
import com.autonavi.gbl.guide.observer.impl.IGuideOperateObserverImpl;
import com.autonavi.gbl.guide.observer.impl.INaviObserverImpl;
import com.autonavi.gbl.guide.observer.impl.ISoundPlayObserverImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ErrorCode;
import com.autonavi.gbl.util.model.ServiceInitStatus;
@IntfAuto(target = GuideService.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IGuideServiceImpl implements IService {
    private static BindTable BIND_TABLE = new BindTable(IGuideServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void addCruiseObserverNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2, ICruiseObserverImpl iCruiseObserverImpl);

    private static native boolean addGuideOperateObserverNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2, IGuideOperateObserverImpl iGuideOperateObserverImpl);

    private static native void addNaviObserverNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2, INaviObserverImpl iNaviObserverImpl);

    private static native void addSoundPlayObserverNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2, ISoundPlayObserverImpl iSoundPlayObserverImpl);

    private static native boolean controlNative(long j, IGuideServiceImpl iGuideServiceImpl, int i, String str);

    private static native void destroyNativeObj(long j);

    private static native String getEngineVersionNative();

    private static native String getVersionNative(long j, IGuideServiceImpl iGuideServiceImpl);

    private static native void ignoreTmcSugguestNaviPathNative(long j, IGuideServiceImpl iGuideServiceImpl);

    private static native int initNative(long j, IGuideServiceImpl iGuideServiceImpl);

    private static native int isInitNative(long j, IGuideServiceImpl iGuideServiceImpl);

    private static native void logSwitchNative(long j, IGuideServiceImpl iGuideServiceImpl, int i);

    private static native void notifyRerouteFailNative(long j, IGuideServiceImpl iGuideServiceImpl, int i);

    private static native long obtainExitDirectionInfoNative(long j, IGuideServiceImpl iGuideServiceImpl, boolean z);

    private static native long obtainManeuverIconDataNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2, ManeuverConfig maneuverConfig);

    private static native long obtainSAPAInfoNative(long j, IGuideServiceImpl iGuideServiceImpl, boolean z);

    private static native boolean pauseNaviNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2);

    private static native boolean playNaviManualNative(long j, IGuideServiceImpl iGuideServiceImpl);

    private static native boolean playTRManual1Native(long j, IGuideServiceImpl iGuideServiceImpl, int i);

    private static native boolean playTRManualNative(long j, IGuideServiceImpl iGuideServiceImpl, int i, int i2);

    private static native void removeCruiseObserverNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2, ICruiseObserverImpl iCruiseObserverImpl);

    private static native boolean removeGuideOperateObserverNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2, IGuideOperateObserverImpl iGuideOperateObserverImpl);

    private static native void removeNaviObserverNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2, INaviObserverImpl iNaviObserverImpl);

    private static native void removeSoundPlayObserverNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2, ISoundPlayObserverImpl iSoundPlayObserverImpl);

    private static native boolean resumeNaviNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2);

    private static native void selectMainPathIDNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2);

    private static native void setCustomizationInfoNative(long j, IGuideServiceImpl iGuideServiceImpl, String str);

    private static native void setElecInfoConfigNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2, ElecInfoConfig elecInfoConfig);

    private static native void setExtraInfoDataNative(long j, IGuideServiceImpl iGuideServiceImpl, int i, String str);

    private static native void setExtraInfoParamNative(long j, IGuideServiceImpl iGuideServiceImpl, int i, String str);

    private static native boolean setNaviPathNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2, NaviPathImpl naviPathImpl, long j3);

    private static native boolean setParamNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2, Param param);

    private static native boolean startNaviNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2, int i);

    private static native boolean stopNaviNative(long j, IGuideServiceImpl iGuideServiceImpl, long j2);

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
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
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

    @ErrorCode.ErrorCode1
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

    public boolean setNaviPath(NaviPathImpl naviPathImpl, long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return setNaviPathNative(j2, this, NaviPathImpl.getCPtr(naviPathImpl), naviPathImpl, j);
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

    public boolean stopNavi(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return stopNaviNative(j2, this, j);
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

    public long obtainManeuverIconData(ManeuverConfig maneuverConfig) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return obtainManeuverIconDataNative(j, this, 0L, maneuverConfig);
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

    public void setExtraInfoData(@NaviExtraInfoType.NaviExtraInfoType1 int i, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setExtraInfoDataNative(j, this, i, str);
    }

    public void setExtraInfoParam(@NaviExtraInfoType.NaviExtraInfoType1 int i, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setExtraInfoParamNative(j, this, i, str);
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

    public boolean addGuideOperateObserver(IGuideOperateObserverImpl iGuideOperateObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addGuideOperateObserverNative(j, this, IGuideOperateObserverImpl.getCPtr(iGuideOperateObserverImpl), iGuideOperateObserverImpl);
    }

    public boolean removeGuideOperateObserver(IGuideOperateObserverImpl iGuideOperateObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return removeGuideOperateObserverNative(j, this, IGuideOperateObserverImpl.getCPtr(iGuideOperateObserverImpl), iGuideOperateObserverImpl);
    }
}
