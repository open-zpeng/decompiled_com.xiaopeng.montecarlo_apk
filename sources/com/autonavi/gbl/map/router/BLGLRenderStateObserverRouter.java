package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.observer.IBLGLRenderStateObserver;
import com.autonavi.gbl.map.observer.impl.IBLGLRenderStateObserverImpl;
@IntfAuto(target = IBLGLRenderStateObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class BLGLRenderStateObserverRouter extends IBLGLRenderStateObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(BLGLRenderStateObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(BLGLRenderStateObserverRouter.class);
    private TypeHelper mHelper;
    private IBLGLRenderStateObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IBLGLRenderStateObserver iBLGLRenderStateObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IBLGLRenderStateObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iBLGLRenderStateObserver;
    }

    protected BLGLRenderStateObserverRouter(String str, IBLGLRenderStateObserver iBLGLRenderStateObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iBLGLRenderStateObserver);
    }

    protected BLGLRenderStateObserverRouter(String str, IBLGLRenderStateObserver iBLGLRenderStateObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iBLGLRenderStateObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.BLGLRenderStateObserverRouter.1
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
    @Override // com.autonavi.gbl.map.observer.impl.IBLGLRenderStateObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.BLGLRenderStateObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.observer.impl.IBLGLRenderStateObserverImpl
    public void onMapGLRender(long j, int i) {
        IBLGLRenderStateObserver iBLGLRenderStateObserver = this.mObserver;
        if (iBLGLRenderStateObserver != null) {
            iBLGLRenderStateObserver.onMapGLRender(j, i);
        }
    }
}
