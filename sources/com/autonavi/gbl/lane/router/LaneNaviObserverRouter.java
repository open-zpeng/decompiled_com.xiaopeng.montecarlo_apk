package com.autonavi.gbl.lane.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.lane.model.LaneNaviCamera;
import com.autonavi.gbl.lane.model.LaneNaviCongestionInfo;
import com.autonavi.gbl.lane.model.LanePathTrafficEventInfo;
import com.autonavi.gbl.lane.model.TravelPoint;
import com.autonavi.gbl.lane.model.TurnBubbleInfo;
import com.autonavi.gbl.lane.observer.ILaneNaviObserver;
import com.autonavi.gbl.lane.observer.impl.ILaneNaviObserverImpl;
import java.util.ArrayList;
@IntfAuto(target = ILaneNaviObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class LaneNaviObserverRouter extends ILaneNaviObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(LaneNaviObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(LaneNaviObserverRouter.class);
    private TypeHelper mHelper;
    private ILaneNaviObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, ILaneNaviObserver iLaneNaviObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ILaneNaviObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iLaneNaviObserver;
    }

    protected LaneNaviObserverRouter(String str, ILaneNaviObserver iLaneNaviObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneNaviObserver);
    }

    protected LaneNaviObserverRouter(String str, ILaneNaviObserver iLaneNaviObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneNaviObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.router.LaneNaviObserverRouter.1
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
    @Override // com.autonavi.gbl.lane.observer.impl.ILaneNaviObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.router.LaneNaviObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneNaviObserverImpl
    public void onShowNaviCamera(ArrayList<LaneNaviCamera> arrayList, int i) {
        ILaneNaviObserver iLaneNaviObserver = this.mObserver;
        if (iLaneNaviObserver != null) {
            iLaneNaviObserver.onShowNaviCamera(arrayList, i);
        }
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneNaviObserverImpl
    public void onUpdateTMCCongestionInfo(LaneNaviCongestionInfo laneNaviCongestionInfo, int i) {
        ILaneNaviObserver iLaneNaviObserver = this.mObserver;
        if (iLaneNaviObserver != null) {
            iLaneNaviObserver.onUpdateTMCCongestionInfo(laneNaviCongestionInfo, i);
        }
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneNaviObserverImpl
    public void onUpdateTREvent(LanePathTrafficEventInfo lanePathTrafficEventInfo, int i) {
        ILaneNaviObserver iLaneNaviObserver = this.mObserver;
        if (iLaneNaviObserver != null) {
            iLaneNaviObserver.onUpdateTREvent(lanePathTrafficEventInfo, i);
        }
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneNaviObserverImpl
    public void onUpdateTurnBubbleInfo(TurnBubbleInfo turnBubbleInfo) {
        ILaneNaviObserver iLaneNaviObserver = this.mObserver;
        if (iLaneNaviObserver != null) {
            iLaneNaviObserver.onUpdateTurnBubbleInfo(turnBubbleInfo);
        }
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneNaviObserverImpl
    public void onUpdateTravelPointInfo(ArrayList<TravelPoint> arrayList, int i) {
        ILaneNaviObserver iLaneNaviObserver = this.mObserver;
        if (iLaneNaviObserver != null) {
            iLaneNaviObserver.onUpdateTravelPointInfo(arrayList, i);
        }
    }
}
