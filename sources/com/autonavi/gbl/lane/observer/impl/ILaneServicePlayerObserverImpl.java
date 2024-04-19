package com.autonavi.gbl.lane.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.path.option.impl.IRouteOptionImpl;
import com.autonavi.gbl.lane.model.AutopilotData;
import com.autonavi.gbl.lane.model.CarHWInfo;
import com.autonavi.gbl.lane.model.CarStyleInfo;
import com.autonavi.gbl.lane.model.Decision;
import com.autonavi.gbl.lane.model.DecisionDirectionStyle;
import com.autonavi.gbl.lane.model.DecisionLineStyleInfo;
import com.autonavi.gbl.lane.model.ELKLineInfo;
import com.autonavi.gbl.lane.model.ELKLineStyle;
import com.autonavi.gbl.lane.model.LDWLineInfo;
import com.autonavi.gbl.lane.model.LDWLineStyle;
import com.autonavi.gbl.lane.model.LKALineInfo;
import com.autonavi.gbl.lane.model.LKALineStyle;
import com.autonavi.gbl.lane.model.LaneRenderScreen;
import com.autonavi.gbl.lane.model.LaneSRRangeFilterParam;
import com.autonavi.gbl.lane.model.LaneSideLineInfo;
import com.autonavi.gbl.lane.model.LaneSideLineStyle;
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

    private static native boolean onAutopilotDataNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, long j2, AutopilotData autopilotData);

    private static native boolean onCarHWNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, CarHWInfo carHWInfo);

    private static native boolean onCarStyleNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, CarStyleInfo carStyleInfo);

    private static native boolean onDecisionDirectionStyleNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, DecisionDirectionStyle decisionDirectionStyle);

    private static native boolean onDecisionLineStyleNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, DecisionLineStyleInfo decisionLineStyleInfo);

    private static native boolean onDecisionNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, Decision decision);

    private static native boolean onELKLineInfoNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, ELKLineInfo eLKLineInfo);

    private static native boolean onELKLineStyleNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, ELKLineStyle eLKLineStyle);

    private static native boolean onLDWLineInfoNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, LDWLineInfo lDWLineInfo);

    private static native boolean onLDWLineStyleNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, LDWLineStyle lDWLineStyle);

    private static native boolean onLKALineInfoNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, LKALineInfo lKALineInfo);

    private static native boolean onLKALineStyleNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, LKALineStyle lKALineStyle);

    private static native boolean onLaneChangeFocusingNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, boolean z);

    private static native boolean onLaneChangeFocusingSwigExplicitILaneServicePlayerObserverImplNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, boolean z);

    private static native boolean onLaneSideLineInfoNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, LaneSideLineInfo laneSideLineInfo);

    private static native boolean onLaneSideStyleNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, LaneSideLineStyle laneSideLineStyle);

    private static native boolean onLocSignDataNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, long j2, LocSignData locSignData);

    private static native boolean onOpenDynamicViewAngleNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, boolean z);

    private static native boolean onOpenLCCNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, boolean z);

    private static native boolean onOpenLNDSDataDownloadNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, boolean z);

    private static native boolean onPlayProgressNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, long j2, long j3, String str, long j4, long j5);

    private static native boolean onRequestRouteNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, long j2, IRouteOptionImpl iRouteOptionImpl);

    private static native boolean onRequestRouteSwigExplicitILaneServicePlayerObserverImplNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, long j2, IRouteOptionImpl iRouteOptionImpl);

    private static native boolean onSRObjectNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, SRObjects sRObjects);

    private static native boolean onSRRangeFilterParamNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, LaneSRRangeFilterParam laneSRRangeFilterParam);

    private static native boolean onSRRangeFilterParamSwigExplicitILaneServicePlayerObserverImplNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, LaneSRRangeFilterParam laneSRRangeFilterParam);

    private static native boolean onShowNaviLineFishboneNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, boolean z);

    private static native boolean onShowNaviLineFishboneSwigExplicitILaneServicePlayerObserverImplNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, boolean z);

    private static native boolean onShowNaviLineNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, boolean z);

    private static native boolean onShowNaviLineOutlineNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, boolean z);

    private static native boolean onShowNaviLineOutlineSwigExplicitILaneServicePlayerObserverImplNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, boolean z);

    private static native boolean onShowNaviLineSwigExplicitILaneServicePlayerObserverImplNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, boolean z);

    private static native boolean onWarnNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, WarnInfos warnInfos);

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

    public boolean onSRObject(@LaneRenderScreen.LaneRenderScreen1 int i, SRObjects sRObjects) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onSRObjectNative(j, this, i, 0L, sRObjects);
    }

    public boolean onCarHW(@LaneRenderScreen.LaneRenderScreen1 int i, CarHWInfo carHWInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onCarHWNative(j, this, i, 0L, carHWInfo);
    }

    public boolean onCarStyle(@LaneRenderScreen.LaneRenderScreen1 int i, CarStyleInfo carStyleInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onCarStyleNative(j, this, i, 0L, carStyleInfo);
    }

    public boolean onDecisionLineStyle(@LaneRenderScreen.LaneRenderScreen1 int i, DecisionLineStyleInfo decisionLineStyleInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onDecisionLineStyleNative(j, this, i, 0L, decisionLineStyleInfo);
    }

    public boolean onDecisionDirectionStyle(@LaneRenderScreen.LaneRenderScreen1 int i, DecisionDirectionStyle decisionDirectionStyle) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onDecisionDirectionStyleNative(j, this, i, 0L, decisionDirectionStyle);
    }

    public boolean onDecision(@LaneRenderScreen.LaneRenderScreen1 int i, Decision decision) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onDecisionNative(j, this, i, 0L, decision);
    }

    public boolean onWarn(@LaneRenderScreen.LaneRenderScreen1 int i, WarnInfos warnInfos) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onWarnNative(j, this, i, 0L, warnInfos);
    }

    public boolean onOpenDynamicViewAngle(@LaneRenderScreen.LaneRenderScreen1 int i, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onOpenDynamicViewAngleNative(j, this, i, z);
    }

    public boolean onOpenLCC(@LaneRenderScreen.LaneRenderScreen1 int i, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onOpenLCCNative(j, this, i, z);
    }

    public boolean onOpenLNDSDataDownload(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onOpenLNDSDataDownloadNative(j, this, z);
    }

    public boolean onLaneSideStyle(@LaneRenderScreen.LaneRenderScreen1 int i, LaneSideLineStyle laneSideLineStyle) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onLaneSideStyleNative(j, this, i, 0L, laneSideLineStyle);
    }

    public boolean onLaneSideLineInfo(@LaneRenderScreen.LaneRenderScreen1 int i, LaneSideLineInfo laneSideLineInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onLaneSideLineInfoNative(j, this, i, 0L, laneSideLineInfo);
    }

    public boolean onLKALineStyle(@LaneRenderScreen.LaneRenderScreen1 int i, LKALineStyle lKALineStyle) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onLKALineStyleNative(j, this, i, 0L, lKALineStyle);
    }

    public boolean onLKALineInfo(@LaneRenderScreen.LaneRenderScreen1 int i, LKALineInfo lKALineInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onLKALineInfoNative(j, this, i, 0L, lKALineInfo);
    }

    public boolean onLDWLineStyle(@LaneRenderScreen.LaneRenderScreen1 int i, LDWLineStyle lDWLineStyle) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onLDWLineStyleNative(j, this, i, 0L, lDWLineStyle);
    }

    public boolean onLDWLineInfo(@LaneRenderScreen.LaneRenderScreen1 int i, LDWLineInfo lDWLineInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onLDWLineInfoNative(j, this, i, 0L, lDWLineInfo);
    }

    public boolean onELKLineStyle(@LaneRenderScreen.LaneRenderScreen1 int i, ELKLineStyle eLKLineStyle) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onELKLineStyleNative(j, this, i, 0L, eLKLineStyle);
    }

    public boolean onELKLineInfo(@LaneRenderScreen.LaneRenderScreen1 int i, ELKLineInfo eLKLineInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onELKLineInfoNative(j, this, i, 0L, eLKLineInfo);
    }

    public boolean onAutopilotData(AutopilotData autopilotData) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onAutopilotDataNative(j, this, 0L, autopilotData);
    }

    public boolean onRequestRoute(IRouteOptionImpl iRouteOptionImpl) {
        if (this.swigCPtr != 0) {
            return getClass() == ILaneServicePlayerObserverImpl.class ? onRequestRouteNative(this.swigCPtr, this, IRouteOptionImpl.getCPtr(iRouteOptionImpl), iRouteOptionImpl) : onRequestRouteSwigExplicitILaneServicePlayerObserverImplNative(this.swigCPtr, this, IRouteOptionImpl.getCPtr(iRouteOptionImpl), iRouteOptionImpl);
        }
        throw new NullPointerException();
    }

    public boolean onShowNaviLine(@LaneRenderScreen.LaneRenderScreen1 int i, boolean z) {
        if (this.swigCPtr != 0) {
            return getClass() == ILaneServicePlayerObserverImpl.class ? onShowNaviLineNative(this.swigCPtr, this, i, z) : onShowNaviLineSwigExplicitILaneServicePlayerObserverImplNative(this.swigCPtr, this, i, z);
        }
        throw new NullPointerException();
    }

    public boolean onShowNaviLineFishbone(@LaneRenderScreen.LaneRenderScreen1 int i, boolean z) {
        if (this.swigCPtr != 0) {
            return getClass() == ILaneServicePlayerObserverImpl.class ? onShowNaviLineFishboneNative(this.swigCPtr, this, i, z) : onShowNaviLineFishboneSwigExplicitILaneServicePlayerObserverImplNative(this.swigCPtr, this, i, z);
        }
        throw new NullPointerException();
    }

    public boolean onShowNaviLineOutline(@LaneRenderScreen.LaneRenderScreen1 int i, boolean z) {
        if (this.swigCPtr != 0) {
            return getClass() == ILaneServicePlayerObserverImpl.class ? onShowNaviLineOutlineNative(this.swigCPtr, this, i, z) : onShowNaviLineOutlineSwigExplicitILaneServicePlayerObserverImplNative(this.swigCPtr, this, i, z);
        }
        throw new NullPointerException();
    }

    public boolean onLaneChangeFocusing(@LaneRenderScreen.LaneRenderScreen1 int i, boolean z) {
        if (this.swigCPtr != 0) {
            return getClass() == ILaneServicePlayerObserverImpl.class ? onLaneChangeFocusingNative(this.swigCPtr, this, i, z) : onLaneChangeFocusingSwigExplicitILaneServicePlayerObserverImplNative(this.swigCPtr, this, i, z);
        }
        throw new NullPointerException();
    }

    public boolean onSRRangeFilterParam(@LaneRenderScreen.LaneRenderScreen1 int i, LaneSRRangeFilterParam laneSRRangeFilterParam) {
        if (this.swigCPtr != 0) {
            return getClass() == ILaneServicePlayerObserverImpl.class ? onSRRangeFilterParamNative(this.swigCPtr, this, i, 0L, laneSRRangeFilterParam) : onSRRangeFilterParamSwigExplicitILaneServicePlayerObserverImplNative(this.swigCPtr, this, i, 0L, laneSRRangeFilterParam);
        }
        throw new NullPointerException();
    }

    public ILaneServicePlayerObserverImpl() {
        this(createNativeObj(), true);
        LaneObserverJNI.swig_jni_init();
        ILaneServicePlayerObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
