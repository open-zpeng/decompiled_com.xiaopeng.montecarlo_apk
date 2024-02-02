package com.autonavi.gbl.pos.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.pos.model.LocSignData;
import com.autonavi.gbl.pos.replay.model.PosReplayStatus;
import com.autonavi.gbl.pos.replay.observer.IPosReplayObserver;
import com.autonavi.gbl.pos.replay.observer.impl.IPosReplayObserverImpl;
@IntfAuto(target = IPosReplayObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class PosReplayObserverRouter extends IPosReplayObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(PosReplayObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(PosReplayObserverRouter.class);
    private TypeHelper mHelper;
    private IPosReplayObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IPosReplayObserver iPosReplayObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IPosReplayObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iPosReplayObserver;
    }

    protected PosReplayObserverRouter(String str, IPosReplayObserver iPosReplayObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPosReplayObserver);
    }

    protected PosReplayObserverRouter(String str, IPosReplayObserver iPosReplayObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPosReplayObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.router.PosReplayObserverRouter.1
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
    @Override // com.autonavi.gbl.pos.replay.observer.impl.IPosReplayObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.router.PosReplayObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.pos.replay.observer.impl.IPosReplayObserverImpl
    public void onLocSignDataUpdate(LocSignData locSignData) {
        IPosReplayObserver iPosReplayObserver = this.mObserver;
        if (iPosReplayObserver != null) {
            iPosReplayObserver.onLocSignDataUpdate(locSignData);
        }
    }

    @Override // com.autonavi.gbl.pos.replay.observer.impl.IPosReplayObserverImpl
    public void onGpsReplayStatusUpdate(@PosReplayStatus.PosReplayStatus1 int i) {
        IPosReplayObserver iPosReplayObserver = this.mObserver;
        if (iPosReplayObserver != null) {
            iPosReplayObserver.onGpsReplayStatusUpdate(i);
        }
    }
}
