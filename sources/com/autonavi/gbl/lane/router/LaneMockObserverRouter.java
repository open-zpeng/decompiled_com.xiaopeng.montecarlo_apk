package com.autonavi.gbl.lane.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.lane.observer.ILaneMockObserver;
import com.autonavi.gbl.lane.observer.impl.ILaneMockObserverImpl;
@IntfAuto(target = ILaneMockObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class LaneMockObserverRouter extends ILaneMockObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(LaneMockObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(LaneMockObserverRouter.class);
    private TypeHelper mHelper;
    private ILaneMockObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, ILaneMockObserver iLaneMockObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ILaneMockObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iLaneMockObserver;
    }

    protected LaneMockObserverRouter(String str, ILaneMockObserver iLaneMockObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneMockObserver);
    }

    protected LaneMockObserverRouter(String str, ILaneMockObserver iLaneMockObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneMockObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.lane.observer.impl.ILaneMockObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneMockObserverImpl
    public void onLaneMockFinish() {
        ILaneMockObserver iLaneMockObserver = this.mObserver;
        if (iLaneMockObserver != null) {
            iLaneMockObserver.onLaneMockFinish();
        }
    }
}
