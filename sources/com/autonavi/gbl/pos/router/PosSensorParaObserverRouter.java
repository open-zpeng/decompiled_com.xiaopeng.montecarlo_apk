package com.autonavi.gbl.pos.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.pos.observer.IPosSensorParaObserver;
import com.autonavi.gbl.pos.observer.impl.IPosSensorParaObserverImpl;
@IntfAuto(target = IPosSensorParaObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class PosSensorParaObserverRouter extends IPosSensorParaObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(PosSensorParaObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(PosSensorParaObserverRouter.class);
    private TypeHelper mHelper;
    private IPosSensorParaObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IPosSensorParaObserver iPosSensorParaObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IPosSensorParaObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iPosSensorParaObserver;
    }

    protected PosSensorParaObserverRouter(String str, IPosSensorParaObserver iPosSensorParaObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPosSensorParaObserver);
    }

    protected PosSensorParaObserverRouter(String str, IPosSensorParaObserver iPosSensorParaObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPosSensorParaObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.pos.observer.impl.IPosSensorParaObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.pos.observer.impl.IPosSensorParaObserverImpl
    public void onSensorParaUpdate(String str) {
        IPosSensorParaObserver iPosSensorParaObserver = this.mObserver;
        if (iPosSensorParaObserver != null) {
            iPosSensorParaObserver.onSensorParaUpdate(str);
        }
    }
}
