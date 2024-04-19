package com.autonavi.gbl.pos.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.pos.model.LocParallelRoadInfo;
import com.autonavi.gbl.pos.observer.IPosParallelRoadObserver;
import com.autonavi.gbl.pos.observer.impl.IPosParallelRoadObserverImpl;
@IntfAuto(target = IPosParallelRoadObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class PosParallelRoadObserverRouter extends IPosParallelRoadObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(PosParallelRoadObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(PosParallelRoadObserverRouter.class);
    private TypeHelper mHelper;
    private IPosParallelRoadObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IPosParallelRoadObserver iPosParallelRoadObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IPosParallelRoadObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iPosParallelRoadObserver;
    }

    protected PosParallelRoadObserverRouter(String str, IPosParallelRoadObserver iPosParallelRoadObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPosParallelRoadObserver);
    }

    protected PosParallelRoadObserverRouter(String str, IPosParallelRoadObserver iPosParallelRoadObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPosParallelRoadObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.router.PosParallelRoadObserverRouter.1
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
    @Override // com.autonavi.gbl.pos.observer.impl.IPosParallelRoadObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.router.PosParallelRoadObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.pos.observer.impl.IPosParallelRoadObserverImpl
    public void onParallelRoadUpdate(LocParallelRoadInfo locParallelRoadInfo) {
        IPosParallelRoadObserver iPosParallelRoadObserver = this.mObserver;
        if (iPosParallelRoadObserver != null) {
            iPosParallelRoadObserver.onParallelRoadUpdate(locParallelRoadInfo);
        }
    }
}
