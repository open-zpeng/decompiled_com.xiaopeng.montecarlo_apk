package com.autonavi.gbl.pos.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.pos.observer.IPosSwitchParallelRoadObserver;
import com.autonavi.gbl.pos.observer.impl.IPosSwitchParallelRoadObserverImpl;
@IntfAuto(target = IPosSwitchParallelRoadObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class PosSwitchParallelRoadObserverRouter extends IPosSwitchParallelRoadObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(PosSwitchParallelRoadObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(PosSwitchParallelRoadObserverRouter.class);
    private TypeHelper mHelper;
    private IPosSwitchParallelRoadObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IPosSwitchParallelRoadObserver iPosSwitchParallelRoadObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IPosSwitchParallelRoadObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iPosSwitchParallelRoadObserver;
    }

    protected PosSwitchParallelRoadObserverRouter(String str, IPosSwitchParallelRoadObserver iPosSwitchParallelRoadObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPosSwitchParallelRoadObserver);
    }

    protected PosSwitchParallelRoadObserverRouter(String str, IPosSwitchParallelRoadObserver iPosSwitchParallelRoadObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPosSwitchParallelRoadObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.pos.observer.impl.IPosSwitchParallelRoadObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.pos.observer.impl.IPosSwitchParallelRoadObserverImpl
    public void onSwitchParallelRoadFinished() {
        IPosSwitchParallelRoadObserver iPosSwitchParallelRoadObserver = this.mObserver;
        if (iPosSwitchParallelRoadObserver != null) {
            iPosSwitchParallelRoadObserver.onSwitchParallelRoadFinished();
        }
    }
}
