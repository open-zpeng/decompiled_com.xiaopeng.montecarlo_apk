package com.autonavi.gbl.lane.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.lane.model.AnchorScaleTime;
import com.autonavi.gbl.lane.model.LaneNaviStatus;
import com.autonavi.gbl.lane.model.LanePositionStatus;
import com.autonavi.gbl.lane.observer.ILaneObserver;
import com.autonavi.gbl.lane.observer.impl.ILaneObserverImpl;
@IntfAuto(target = ILaneObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class LaneObserverRouter extends ILaneObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(LaneObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(LaneObserverRouter.class);
    private TypeHelper mHelper;
    private ILaneObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, ILaneObserver iLaneObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ILaneObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iLaneObserver;
    }

    protected LaneObserverRouter(String str, ILaneObserver iLaneObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneObserver);
    }

    protected LaneObserverRouter(String str, ILaneObserver iLaneObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.router.LaneObserverRouter.1
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
    @Override // com.autonavi.gbl.lane.observer.impl.ILaneObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.router.LaneObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneObserverImpl
    public void onAnchorScaleChange(@AnchorScaleTime.AnchorScaleTime1 int i) {
        ILaneObserver iLaneObserver = this.mObserver;
        if (iLaneObserver != null) {
            iLaneObserver.onAnchorScaleChange(i);
        }
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneObserverImpl
    public void onLanePositionStatus(@LanePositionStatus.LanePositionStatus1 int i) {
        ILaneObserver iLaneObserver = this.mObserver;
        if (iLaneObserver != null) {
            iLaneObserver.onLanePositionStatus(i);
        }
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneObserverImpl
    public void onLaneNaviStatus(@LaneNaviStatus.LaneNaviStatus1 int i) {
        ILaneObserver iLaneObserver = this.mObserver;
        if (iLaneObserver != null) {
            iLaneObserver.onLaneNaviStatus(i);
        }
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneObserverImpl
    public void onLaneNaviEnterPointDistance(float f) {
        ILaneObserver iLaneObserver = this.mObserver;
        if (iLaneObserver != null) {
            iLaneObserver.onLaneNaviEnterPointDistance(f);
        }
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneObserverImpl
    public void onLaneLndsDataDistance(float f) {
        ILaneObserver iLaneObserver = this.mObserver;
        if (iLaneObserver != null) {
            iLaneObserver.onLaneLndsDataDistance(f);
        }
    }
}
