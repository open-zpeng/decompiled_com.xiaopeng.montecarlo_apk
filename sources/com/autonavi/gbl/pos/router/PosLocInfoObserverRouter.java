package com.autonavi.gbl.pos.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.pos.model.LocInfo;
import com.autonavi.gbl.pos.observer.IPosLocInfoObserver;
import com.autonavi.gbl.pos.observer.impl.IPosLocInfoObserverImpl;
@IntfAuto(target = IPosLocInfoObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class PosLocInfoObserverRouter extends IPosLocInfoObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(PosLocInfoObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(PosLocInfoObserverRouter.class);
    private TypeHelper mHelper;
    private IPosLocInfoObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IPosLocInfoObserver iPosLocInfoObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IPosLocInfoObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iPosLocInfoObserver;
    }

    protected PosLocInfoObserverRouter(String str, IPosLocInfoObserver iPosLocInfoObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPosLocInfoObserver);
    }

    protected PosLocInfoObserverRouter(String str, IPosLocInfoObserver iPosLocInfoObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPosLocInfoObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.pos.observer.impl.IPosLocInfoObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.pos.observer.impl.IPosLocInfoObserverImpl
    public void onLocInfoUpdate(LocInfo locInfo) {
        IPosLocInfoObserver iPosLocInfoObserver = this.mObserver;
        if (iPosLocInfoObserver != null) {
            iPosLocInfoObserver.onLocInfoUpdate(locInfo);
        }
    }
}
