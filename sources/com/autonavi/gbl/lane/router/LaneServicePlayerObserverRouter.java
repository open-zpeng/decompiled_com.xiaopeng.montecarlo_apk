package com.autonavi.gbl.lane.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
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
import com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl;
import com.autonavi.gbl.pos.model.LocSignData;
@IntfAuto(target = ILaneServicePlayerObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class LaneServicePlayerObserverRouter extends ILaneServicePlayerObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(LaneServicePlayerObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(LaneServicePlayerObserverRouter.class);
    private TypeHelper mHelper;
    private ILaneServicePlayerObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, ILaneServicePlayerObserver iLaneServicePlayerObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ILaneServicePlayerObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iLaneServicePlayerObserver;
    }

    protected LaneServicePlayerObserverRouter(String str, ILaneServicePlayerObserver iLaneServicePlayerObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneServicePlayerObserver);
    }

    protected LaneServicePlayerObserverRouter(String str, ILaneServicePlayerObserver iLaneServicePlayerObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneServicePlayerObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.router.LaneServicePlayerObserverRouter.1
        });
        objArr[1] = String.valueOf(this.mHelper != null);
        DebugTool.d("%s: mHelper=%s", objArr);
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.router.LaneServicePlayerObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onPlayProgress(long j, long j2, String str, long j3, long j4) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onPlayProgress(j, j2, str, j3, j4);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onLocSignData(LocSignData locSignData) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onLocSignData(locSignData);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onSRObject(SRObjects sRObjects) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onSRObject(sRObjects);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onCarHW(CarHWInfo carHWInfo) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onCarHW(carHWInfo);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onCarStyle(CarStyleInfo carStyleInfo) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onCarStyle(carStyleInfo);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onDecisionLineStyle(DecisionLineStyleInfo decisionLineStyleInfo) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onDecisionLineStyle(decisionLineStyleInfo);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onDecisionDirectionStyle(DecisionDirectionStyle decisionDirectionStyle) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onDecisionDirectionStyle(decisionDirectionStyle);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onDecision(Decision decision) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onDecision(decision);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onWarn(WarnInfos warnInfos) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onWarn(warnInfos);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onLDWLineStyle(LDWLineStyleInfo lDWLineStyleInfo) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onLDWLineStyle(lDWLineStyleInfo);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onLDW(LDWInfo lDWInfo) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onLDW(lDWInfo);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onOpenDynamicViewAngle(boolean z) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onOpenDynamicViewAngle(z);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onOpenLCC(boolean z) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onOpenLCC(z);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onOpenLNDSDataDownload(boolean z) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onOpenLNDSDataDownload(z);
        }
        return false;
    }
}
