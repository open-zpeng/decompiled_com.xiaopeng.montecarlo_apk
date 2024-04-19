package com.autonavi.gbl.multi.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.multi.impl.CKldIntent;
import com.autonavi.gbl.multi.impl.CKldSceneContextImpl;
import com.autonavi.gbl.multi.model.SceneErrorCode;
import com.autonavi.gbl.multi.observer.IKldSceneObserver;
import com.autonavi.gbl.multi.observer.impl.IKldSceneObserverImpl;
@IntfAuto(target = IKldSceneObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class KldSceneObserverRouter extends IKldSceneObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(KldSceneObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(KldSceneObserverRouter.class);
    private TypeHelper mHelper;
    private IKldSceneObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IKldSceneObserver iKldSceneObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IKldSceneObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iKldSceneObserver;
    }

    protected KldSceneObserverRouter(String str, IKldSceneObserver iKldSceneObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iKldSceneObserver);
    }

    protected KldSceneObserverRouter(String str, IKldSceneObserver iKldSceneObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iKldSceneObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.KldSceneObserverRouter.1
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
    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.KldSceneObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneObserverImpl
    public int onSceneError(CKldSceneContextImpl cKldSceneContextImpl, String str, CKldIntent cKldIntent, @SceneErrorCode.SceneErrorCode1 int i) {
        IKldSceneObserver iKldSceneObserver = this.mObserver;
        if (iKldSceneObserver != null) {
            return iKldSceneObserver.onSceneError(cKldSceneContextImpl, str, cKldIntent, i);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneObserverImpl
    public int beforeInit(CKldSceneContextImpl cKldSceneContextImpl, String str) {
        IKldSceneObserver iKldSceneObserver = this.mObserver;
        if (iKldSceneObserver != null) {
            return iKldSceneObserver.beforeInit(cKldSceneContextImpl, str);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneObserverImpl
    public int onInitDone(CKldSceneContextImpl cKldSceneContextImpl, String str) {
        IKldSceneObserver iKldSceneObserver = this.mObserver;
        if (iKldSceneObserver != null) {
            return iKldSceneObserver.onInitDone(cKldSceneContextImpl, str);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneObserverImpl
    public int onSceneEntered(CKldSceneContextImpl cKldSceneContextImpl, String str) {
        IKldSceneObserver iKldSceneObserver = this.mObserver;
        if (iKldSceneObserver != null) {
            return iKldSceneObserver.onSceneEntered(cKldSceneContextImpl, str);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneObserverImpl
    public int beforeExit(CKldSceneContextImpl cKldSceneContextImpl, String str) {
        IKldSceneObserver iKldSceneObserver = this.mObserver;
        if (iKldSceneObserver != null) {
            return iKldSceneObserver.beforeExit(cKldSceneContextImpl, str);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneObserverImpl
    public int onSceneExited(CKldSceneContextImpl cKldSceneContextImpl, String str) {
        IKldSceneObserver iKldSceneObserver = this.mObserver;
        if (iKldSceneObserver != null) {
            return iKldSceneObserver.onSceneExited(cKldSceneContextImpl, str);
        }
        return 0;
    }
}
