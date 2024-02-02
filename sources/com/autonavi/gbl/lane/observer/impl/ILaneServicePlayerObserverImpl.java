package com.autonavi.gbl.lane.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.lane.model.CarHWInfo;
import com.autonavi.gbl.lane.model.CarStyleInfo;
import com.autonavi.gbl.lane.model.Decision;
import com.autonavi.gbl.lane.model.DecisionDirectionStyle;
import com.autonavi.gbl.lane.model.DecisionLineStyleInfo;
import com.autonavi.gbl.lane.model.LDWInfo;
import com.autonavi.gbl.lane.model.LDWLineStyleInfo;
import com.autonavi.gbl.lane.model.SRObjects;
import com.autonavi.gbl.lane.model.WarnInfos;
import com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver;
import com.autonavi.gbl.pos.model.LocSignData;
@IntfAuto(target = ILaneServicePlayerObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ILaneServicePlayerObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ILaneServicePlayerObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ILaneServicePlayerObserverImpl_change_ownership(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, long j, boolean z);

    private static native void ILaneServicePlayerObserverImpl_director_connect(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native boolean onCarHWNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, long j2, CarHWInfo carHWInfo);

    private static native boolean onCarStyleNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, long j2, CarStyleInfo carStyleInfo);

    private static native boolean onDecisionDirectionStyleNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, long j2, DecisionDirectionStyle decisionDirectionStyle);

    private static native boolean onDecisionLineStyleNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, long j2, DecisionLineStyleInfo decisionLineStyleInfo);

    private static native boolean onDecisionNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, long j2, Decision decision);

    private static native boolean onLDWLineStyleNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, long j2, LDWLineStyleInfo lDWLineStyleInfo);

    private static native boolean onLDWNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, long j2, LDWInfo lDWInfo);

    private static native boolean onLocSignDataNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, long j2, LocSignData locSignData);

    private static native boolean onOpenDynamicViewAngleNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, boolean z);

    private static native boolean onOpenLCCNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, boolean z);

    private static native boolean onOpenLNDSDataDownloadNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, boolean z);

    private static native boolean onPlayProgressNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, long j2, long j3, String str, long j4, long j5);

    private static native boolean onSRObjectNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, long j2, SRObjects sRObjects);

    private static native boolean onWarnNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, long j2, WarnInfos warnInfos);

    public ILaneServicePlayerObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ILaneServicePlayerObserverImpl) && getUID(this) == getUID((ILaneServicePlayerObserverImpl) obj);
    }

    private static long getUID(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl) {
        long cPtr = getCPtr(iLaneServicePlayerObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl) {
        if (iLaneServicePlayerObserverImpl == null) {
            return 0L;
        }
        return iLaneServicePlayerObserverImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        ILaneServicePlayerObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ILaneServicePlayerObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public boolean onPlayProgress(long j, long j2, String str, long j3, long j4) {
        long j5 = this.swigCPtr;
        if (j5 == 0) {
            throw new NullPointerException();
        }
        return onPlayProgressNative(j5, this, j, j2, str, j3, j4);
    }

    public boolean onLocSignData(LocSignData locSignData) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onLocSignDataNative(j, this, 0L, locSignData);
    }

    public boolean onSRObject(SRObjects sRObjects) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onSRObjectNative(j, this, 0L, sRObjects);
    }

    public boolean onCarHW(CarHWInfo carHWInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onCarHWNative(j, this, 0L, carHWInfo);
    }

    public boolean onCarStyle(CarStyleInfo carStyleInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onCarStyleNative(j, this, 0L, carStyleInfo);
    }

    public boolean onDecisionLineStyle(DecisionLineStyleInfo decisionLineStyleInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onDecisionLineStyleNative(j, this, 0L, decisionLineStyleInfo);
    }

    public boolean onDecisionDirectionStyle(DecisionDirectionStyle decisionDirectionStyle) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onDecisionDirectionStyleNative(j, this, 0L, decisionDirectionStyle);
    }

    public boolean onDecision(Decision decision) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onDecisionNative(j, this, 0L, decision);
    }

    public boolean onWarn(WarnInfos warnInfos) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onWarnNative(j, this, 0L, warnInfos);
    }

    public boolean onLDWLineStyle(LDWLineStyleInfo lDWLineStyleInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onLDWLineStyleNative(j, this, 0L, lDWLineStyleInfo);
    }

    public boolean onLDW(LDWInfo lDWInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onLDWNative(j, this, 0L, lDWInfo);
    }

    public boolean onOpenDynamicViewAngle(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onOpenDynamicViewAngleNative(j, this, z);
    }

    public boolean onOpenLCC(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onOpenLCCNative(j, this, z);
    }

    public boolean onOpenLNDSDataDownload(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onOpenLNDSDataDownloadNative(j, this, z);
    }

    public ILaneServicePlayerObserverImpl() {
        this(createNativeObj(), true);
        LaneServicePlayerObserverJNI.swig_jni_init();
        ILaneServicePlayerObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
