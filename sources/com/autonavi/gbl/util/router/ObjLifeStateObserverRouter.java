package com.autonavi.gbl.util.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.util.model.ObjLifeState;
import com.autonavi.gbl.util.observer.IObjLifeStateObserver;
import com.autonavi.gbl.util.observer.impl.IObjLifeStateObserverImpl;
@IntfAuto(target = IObjLifeStateObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class ObjLifeStateObserverRouter extends IObjLifeStateObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ObjLifeStateObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(ObjLifeStateObserverRouter.class);
    private TypeHelper mHelper;
    private IObjLifeStateObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IObjLifeStateObserver iObjLifeStateObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IObjLifeStateObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iObjLifeStateObserver;
    }

    protected ObjLifeStateObserverRouter(String str, IObjLifeStateObserver iObjLifeStateObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iObjLifeStateObserver);
    }

    protected ObjLifeStateObserverRouter(String str, IObjLifeStateObserver iObjLifeStateObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iObjLifeStateObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.router.ObjLifeStateObserverRouter.1
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
    @Override // com.autonavi.gbl.util.observer.impl.IObjLifeStateObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.router.ObjLifeStateObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.util.observer.impl.IObjLifeStateObserverImpl
    public void inProgress(@ObjLifeState.ObjLifeState1 int i, long j, String str) {
        IObjLifeStateObserver iObjLifeStateObserver = this.mObserver;
        if (iObjLifeStateObserver != null) {
            iObjLifeStateObserver.inProgress(i, j, str);
        }
    }
}
