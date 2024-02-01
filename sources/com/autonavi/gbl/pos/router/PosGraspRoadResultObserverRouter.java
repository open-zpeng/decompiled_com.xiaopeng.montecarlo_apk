package com.autonavi.gbl.pos.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.pos.model.GraspRoadResult;
import com.autonavi.gbl.pos.observer.IPosGraspRoadResultObserver;
import com.autonavi.gbl.pos.observer.impl.IPosGraspRoadResultObserverImpl;
@IntfAuto(target = IPosGraspRoadResultObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class PosGraspRoadResultObserverRouter extends IPosGraspRoadResultObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(PosGraspRoadResultObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(PosGraspRoadResultObserverRouter.class);
    private TypeHelper mHelper;
    private IPosGraspRoadResultObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IPosGraspRoadResultObserver iPosGraspRoadResultObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IPosGraspRoadResultObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iPosGraspRoadResultObserver;
    }

    protected PosGraspRoadResultObserverRouter(String str, IPosGraspRoadResultObserver iPosGraspRoadResultObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPosGraspRoadResultObserver);
    }

    protected PosGraspRoadResultObserverRouter(String str, IPosGraspRoadResultObserver iPosGraspRoadResultObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPosGraspRoadResultObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.pos.observer.impl.IPosGraspRoadResultObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.pos.observer.impl.IPosGraspRoadResultObserverImpl
    public void onGraspRoadResult(GraspRoadResult graspRoadResult) {
        IPosGraspRoadResultObserver iPosGraspRoadResultObserver = this.mObserver;
        if (iPosGraspRoadResultObserver != null) {
            iPosGraspRoadResultObserver.onGraspRoadResult(graspRoadResult);
        }
    }
}
