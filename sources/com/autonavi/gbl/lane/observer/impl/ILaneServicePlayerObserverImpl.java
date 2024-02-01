package com.autonavi.gbl.lane.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
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

    private static native boolean onAutopilotDataSwigExplicitILaneServicePlayerObserverImplNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, long j2, AutopilotData autopilotData);

    private static native boolean onCarHWNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, CarHWInfo carHWInfo);

    private static native boolean onCarHWSwigExplicitILaneServicePlayerObserverImplNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, CarHWInfo carHWInfo);

    private static native boolean onCarStyleNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, CarStyleInfo carStyleInfo);

    private static native boolean onCarStyleSwigExplicitILaneServicePlayerObserverImplNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, CarStyleInfo carStyleInfo);

    private static native boolean onDecisionDirectionStyleNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, DecisionDirectionStyle decisionDirectionStyle);

    private static native boolean onDecisionDirectionStyleSwigExplicitILaneServicePlayerObserverImplNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, DecisionDirectionStyle decisionDirectionStyle);

    private static native boolean onDecisionLineStyleNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, DecisionLineStyleInfo decisionLineStyleInfo);

    private static native boolean onDecisionLineStyleSwigExplicitILaneServicePlayerObserverImplNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, DecisionLineStyleInfo decisionLineStyleInfo);

    private static native boolean onDecisionNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, Decision decision);

    private static native boolean onDecisionSwigExplicitILaneServicePlayerObserverImplNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, Decision decision);

    private static native boolean onELKLineInfoNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, ELKLineInfo eLKLineInfo);

    private static native boolean onELKLineInfoSwigExplicitILaneServicePlayerObserverImplNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, ELKLineInfo eLKLineInfo);

    private static native boolean onELKLineStyleNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, ELKLineStyle eLKLineStyle);

    private static native boolean onELKLineStyleSwigExplicitILaneServicePlayerObserverImplNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, ELKLineStyle eLKLineStyle);

    private static native boolean onLDWLineInfoNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, LDWLineInfo lDWLineInfo);

    private static native boolean onLDWLineInfoSwigExplicitILaneServicePlayerObserverImplNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, LDWLineInfo lDWLineInfo);

    private static native boolean onLDWLineStyleNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, LDWLineStyle lDWLineStyle);

    private static native boolean onLDWLineStyleSwigExplicitILaneServicePlayerObserverImplNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, LDWLineStyle lDWLineStyle);

    private static native boolean onLKALineInfoNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, LKALineInfo lKALineInfo);

    private static native boolean onLKALineInfoSwigExplicitILaneServicePlayerObserverImplNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, LKALineInfo lKALineInfo);

    private static native boolean onLKALineStyleNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, LKALineStyle lKALineStyle);

    private static native boolean onLKALineStyleSwigExplicitILaneServicePlayerObserverImplNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, LKALineStyle lKALineStyle);

    private static native boolean onLaneChangeFocusingNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, boolean z);

    private static native boolean onLaneChangeFocusingSwigExplicitILaneServicePlayerObserverImplNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, boolean z);

    private static native boolean onLaneSideLineInfoNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, LaneSideLineInfo laneSideLineInfo);

    private static native boolean onLaneSideLineInfoSwigExplicitILaneServicePlayerObserverImplNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, LaneSideLineInfo laneSideLineInfo);

    private static native boolean onLaneSideStyleNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, LaneSideLineStyle laneSideLineStyle);

    private static native boolean onLaneSideStyleSwigExplicitILaneServicePlayerObserverImplNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, LaneSideLineStyle laneSideLineStyle);

    private static native boolean onLocSignDataNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, long j2, LocSignData locSignData);

    private static native boolean onLocSignDataSwigExplicitILaneServicePlayerObserverImplNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, long j2, LocSignData locSignData);

    private static native boolean onOpenDynamicViewAngleNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, boolean z);

    private static native boolean onOpenDynamicViewAngleSwigExplicitILaneServicePlayerObserverImplNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, boolean z);

    private static native boolean onOpenLCCNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, boolean z);

    private static native boolean onOpenLCCSwigExplicitILaneServicePlayerObserverImplNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, boolean z);

    private static native boolean onOpenLNDSDataDownloadNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, boolean z);

    private static native boolean onOpenLNDSDataDownloadSwigExplicitILaneServicePlayerObserverImplNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, boolean z);

    private static native boolean onPlayProgressNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, long j2, long j3, String str, long j4, long j5);

    private static native boolean onPlayProgressSwigExplicitILaneServicePlayerObserverImplNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, long j2, long j3, String str, long j4, long j5);

    private static native boolean onRequestRouteNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, long j2, IRouteOptionImpl iRouteOptionImpl);

    private static native boolean onRequestRouteSwigExplicitILaneServicePlayerObserverImplNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, long j2, IRouteOptionImpl iRouteOptionImpl);

    private static native boolean onSRObjectNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, SRObjects sRObjects);

    private static native boolean onSRObjectSwigExplicitILaneServicePlayerObserverImplNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, SRObjects sRObjects);

    private static native boolean onSRRangeFilterParamNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, LaneSRRangeFilterParam laneSRRangeFilterParam);

    private static native boolean onSRRangeFilterParamSwigExplicitILaneServicePlayerObserverImplNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, LaneSRRangeFilterParam laneSRRangeFilterParam);

    private static native boolean onShowNaviLineFishboneNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, boolean z);

    private static native boolean onShowNaviLineFishboneSwigExplicitILaneServicePlayerObserverImplNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, boolean z);

    private static native boolean onShowNaviLineNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, boolean z);

    private static native boolean onShowNaviLineOutlineNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, boolean z);

    private static native boolean onShowNaviLineOutlineSwigExplicitILaneServicePlayerObserverImplNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, boolean z);

    private static native boolean onShowNaviLineSwigExplicitILaneServicePlayerObserverImplNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, boolean z);

    private static native boolean onWarnNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, WarnInfos warnInfos);

    private static native boolean onWarnSwigExplicitILaneServicePlayerObserverImplNative(long j, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl, int i, long j2, WarnInfos warnInfos);

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

    public boolean isCMemOwn() {
        return this.swigCMemOwn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void delete() {
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
        if (this.swigCPtr != 0) {
            return getClass() == ILaneServicePlayerObserverImpl.class ? onPlayProgressNative(this.swigCPtr, this, j, j2, str, j3, j4) : onPlayProgressSwigExplicitILaneServicePlayerObserverImplNative(this.swigCPtr, this, j, j2, str, j3, j4);
        }
        throw new NullPointerException();
    }

    public boolean onLocSignData(LocSignData locSignData) {
        if (this.swigCPtr != 0) {
            return getClass() == ILaneServicePlayerObserverImpl.class ? onLocSignDataNative(this.swigCPtr, this, 0L, locSignData) : onLocSignDataSwigExplicitILaneServicePlayerObserverImplNative(this.swigCPtr, this, 0L, locSignData);
        }
        throw new NullPointerException();
    }

    public boolean onSRObject(@LaneRenderScreen.LaneRenderScreen1 int i, SRObjects sRObjects) {
        if (this.swigCPtr != 0) {
            return getClass() == ILaneServicePlayerObserverImpl.class ? onSRObjectNative(this.swigCPtr, this, i, 0L, sRObjects) : onSRObjectSwigExplicitILaneServicePlayerObserverImplNative(this.swigCPtr, this, i, 0L, sRObjects);
        }
        throw new NullPointerException();
    }

    public boolean onCarHW(@LaneRenderScreen.LaneRenderScreen1 int i, CarHWInfo carHWInfo) {
        if (this.swigCPtr != 0) {
            return getClass() == ILaneServicePlayerObserverImpl.class ? onCarHWNative(this.swigCPtr, this, i, 0L, carHWInfo) : onCarHWSwigExplicitILaneServicePlayerObserverImplNative(this.swigCPtr, this, i, 0L, carHWInfo);
        }
        throw new NullPointerException();
    }

    public boolean onCarStyle(@LaneRenderScreen.LaneRenderScreen1 int i, CarStyleInfo carStyleInfo) {
        if (this.swigCPtr != 0) {
            return getClass() == ILaneServicePlayerObserverImpl.class ? onCarStyleNative(this.swigCPtr, this, i, 0L, carStyleInfo) : onCarStyleSwigExplicitILaneServicePlayerObserverImplNative(this.swigCPtr, this, i, 0L, carStyleInfo);
        }
        throw new NullPointerException();
    }

    public boolean onDecisionLineStyle(@LaneRenderScreen.LaneRenderScreen1 int i, DecisionLineStyleInfo decisionLineStyleInfo) {
        if (this.swigCPtr != 0) {
            return getClass() == ILaneServicePlayerObserverImpl.class ? onDecisionLineStyleNative(this.swigCPtr, this, i, 0L, decisionLineStyleInfo) : onDecisionLineStyleSwigExplicitILaneServicePlayerObserverImplNative(this.swigCPtr, this, i, 0L, decisionLineStyleInfo);
        }
        throw new NullPointerException();
    }

    public boolean onDecisionDirectionStyle(@LaneRenderScreen.LaneRenderScreen1 int i, DecisionDirectionStyle decisionDirectionStyle) {
        if (this.swigCPtr != 0) {
            return getClass() == ILaneServicePlayerObserverImpl.class ? onDecisionDirectionStyleNative(this.swigCPtr, this, i, 0L, decisionDirectionStyle) : onDecisionDirectionStyleSwigExplicitILaneServicePlayerObserverImplNative(this.swigCPtr, this, i, 0L, decisionDirectionStyle);
        }
        throw new NullPointerException();
    }

    public boolean onDecision(@LaneRenderScreen.LaneRenderScreen1 int i, Decision decision) {
        if (this.swigCPtr != 0) {
            return getClass() == ILaneServicePlayerObserverImpl.class ? onDecisionNative(this.swigCPtr, this, i, 0L, decision) : onDecisionSwigExplicitILaneServicePlayerObserverImplNative(this.swigCPtr, this, i, 0L, decision);
        }
        throw new NullPointerException();
    }

    public boolean onWarn(@LaneRenderScreen.LaneRenderScreen1 int i, WarnInfos warnInfos) {
        if (this.swigCPtr != 0) {
            return getClass() == ILaneServicePlayerObserverImpl.class ? onWarnNative(this.swigCPtr, this, i, 0L, warnInfos) : onWarnSwigExplicitILaneServicePlayerObserverImplNative(this.swigCPtr, this, i, 0L, warnInfos);
        }
        throw new NullPointerException();
    }

    public boolean onOpenDynamicViewAngle(@LaneRenderScreen.LaneRenderScreen1 int i, boolean z) {
        if (this.swigCPtr != 0) {
            return getClass() == ILaneServicePlayerObserverImpl.class ? onOpenDynamicViewAngleNative(this.swigCPtr, this, i, z) : onOpenDynamicViewAngleSwigExplicitILaneServicePlayerObserverImplNative(this.swigCPtr, this, i, z);
        }
        throw new NullPointerException();
    }

    public boolean onOpenLCC(@LaneRenderScreen.LaneRenderScreen1 int i, boolean z) {
        if (this.swigCPtr != 0) {
            return getClass() == ILaneServicePlayerObserverImpl.class ? onOpenLCCNative(this.swigCPtr, this, i, z) : onOpenLCCSwigExplicitILaneServicePlayerObserverImplNative(this.swigCPtr, this, i, z);
        }
        throw new NullPointerException();
    }

    public boolean onOpenLNDSDataDownload(boolean z) {
        if (this.swigCPtr != 0) {
            return getClass() == ILaneServicePlayerObserverImpl.class ? onOpenLNDSDataDownloadNative(this.swigCPtr, this, z) : onOpenLNDSDataDownloadSwigExplicitILaneServicePlayerObserverImplNative(this.swigCPtr, this, z);
        }
        throw new NullPointerException();
    }

    public boolean onLaneSideStyle(@LaneRenderScreen.LaneRenderScreen1 int i, LaneSideLineStyle laneSideLineStyle) {
        if (this.swigCPtr != 0) {
            return getClass() == ILaneServicePlayerObserverImpl.class ? onLaneSideStyleNative(this.swigCPtr, this, i, 0L, laneSideLineStyle) : onLaneSideStyleSwigExplicitILaneServicePlayerObserverImplNative(this.swigCPtr, this, i, 0L, laneSideLineStyle);
        }
        throw new NullPointerException();
    }

    public boolean onLaneSideLineInfo(@LaneRenderScreen.LaneRenderScreen1 int i, LaneSideLineInfo laneSideLineInfo) {
        if (this.swigCPtr != 0) {
            return getClass() == ILaneServicePlayerObserverImpl.class ? onLaneSideLineInfoNative(this.swigCPtr, this, i, 0L, laneSideLineInfo) : onLaneSideLineInfoSwigExplicitILaneServicePlayerObserverImplNative(this.swigCPtr, this, i, 0L, laneSideLineInfo);
        }
        throw new NullPointerException();
    }

    public boolean onLKALineStyle(@LaneRenderScreen.LaneRenderScreen1 int i, LKALineStyle lKALineStyle) {
        if (this.swigCPtr != 0) {
            return getClass() == ILaneServicePlayerObserverImpl.class ? onLKALineStyleNative(this.swigCPtr, this, i, 0L, lKALineStyle) : onLKALineStyleSwigExplicitILaneServicePlayerObserverImplNative(this.swigCPtr, this, i, 0L, lKALineStyle);
        }
        throw new NullPointerException();
    }

    public boolean onLKALineInfo(@LaneRenderScreen.LaneRenderScreen1 int i, LKALineInfo lKALineInfo) {
        if (this.swigCPtr != 0) {
            return getClass() == ILaneServicePlayerObserverImpl.class ? onLKALineInfoNative(this.swigCPtr, this, i, 0L, lKALineInfo) : onLKALineInfoSwigExplicitILaneServicePlayerObserverImplNative(this.swigCPtr, this, i, 0L, lKALineInfo);
        }
        throw new NullPointerException();
    }

    public boolean onLDWLineStyle(@LaneRenderScreen.LaneRenderScreen1 int i, LDWLineStyle lDWLineStyle) {
        if (this.swigCPtr != 0) {
            return getClass() == ILaneServicePlayerObserverImpl.class ? onLDWLineStyleNative(this.swigCPtr, this, i, 0L, lDWLineStyle) : onLDWLineStyleSwigExplicitILaneServicePlayerObserverImplNative(this.swigCPtr, this, i, 0L, lDWLineStyle);
        }
        throw new NullPointerException();
    }

    public boolean onLDWLineInfo(@LaneRenderScreen.LaneRenderScreen1 int i, LDWLineInfo lDWLineInfo) {
        if (this.swigCPtr != 0) {
            return getClass() == ILaneServicePlayerObserverImpl.class ? onLDWLineInfoNative(this.swigCPtr, this, i, 0L, lDWLineInfo) : onLDWLineInfoSwigExplicitILaneServicePlayerObserverImplNative(this.swigCPtr, this, i, 0L, lDWLineInfo);
        }
        throw new NullPointerException();
    }

    public boolean onELKLineStyle(@LaneRenderScreen.LaneRenderScreen1 int i, ELKLineStyle eLKLineStyle) {
        if (this.swigCPtr != 0) {
            return getClass() == ILaneServicePlayerObserverImpl.class ? onELKLineStyleNative(this.swigCPtr, this, i, 0L, eLKLineStyle) : onELKLineStyleSwigExplicitILaneServicePlayerObserverImplNative(this.swigCPtr, this, i, 0L, eLKLineStyle);
        }
        throw new NullPointerException();
    }

    public boolean onELKLineInfo(@LaneRenderScreen.LaneRenderScreen1 int i, ELKLineInfo eLKLineInfo) {
        if (this.swigCPtr != 0) {
            return getClass() == ILaneServicePlayerObserverImpl.class ? onELKLineInfoNative(this.swigCPtr, this, i, 0L, eLKLineInfo) : onELKLineInfoSwigExplicitILaneServicePlayerObserverImplNative(this.swigCPtr, this, i, 0L, eLKLineInfo);
        }
        throw new NullPointerException();
    }

    public boolean onAutopilotData(AutopilotData autopilotData) {
        if (this.swigCPtr != 0) {
            return getClass() == ILaneServicePlayerObserverImpl.class ? onAutopilotDataNative(this.swigCPtr, this, 0L, autopilotData) : onAutopilotDataSwigExplicitILaneServicePlayerObserverImplNative(this.swigCPtr, this, 0L, autopilotData);
        }
        throw new NullPointerException();
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
