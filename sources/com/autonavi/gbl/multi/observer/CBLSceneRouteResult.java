package com.autonavi.gbl.multi.observer;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.multi.impl.CKldIntent;
import com.autonavi.gbl.multi.observer.impl.CBLSceneRouteResultImpl;
import com.autonavi.gbl.multi.router.CBLSceneRouteResultRouter;
@IntfAuto(target = CBLSceneRouteResultRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class CBLSceneRouteResult extends KldSceneBase implements ICBLSceneRouteResult {
    private static String PACKAGE = ReflexTool.PN(CBLSceneRouteResult.class);
    private boolean mHasDestroy;
    private CBLSceneRouteResultImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected CBLSceneRouteResult(long j, boolean z) {
        this(new CBLSceneRouteResultRouter("CBLSceneRouteResult", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICBLSceneRouteResult.class}, new Object[]{this});
    }

    public CBLSceneRouteResult() {
        this(new CBLSceneRouteResultRouter("CBLSceneRouteResult", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICBLSceneRouteResult.class}, new Object[]{this});
    }

    public CBLSceneRouteResult(CBLSceneRouteResultImpl cBLSceneRouteResultImpl) {
        super(cBLSceneRouteResultImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(cBLSceneRouteResultImpl);
    }

    private void $constructor(CBLSceneRouteResultImpl cBLSceneRouteResultImpl) {
        if (cBLSceneRouteResultImpl != null) {
            this.mService = cBLSceneRouteResultImpl;
            this.mTargetId = String.format("CBLSceneRouteResult_%s_%d", String.valueOf(CBLSceneRouteResultImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.KldSceneBase
    public CBLSceneRouteResultImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.multi.observer.KldSceneBase
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.CBLSceneRouteResult.1
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
        super.unbind();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.multi.observer.KldSceneBase
    public void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.CBLSceneRouteResult.2
        }));
        super.clean();
    }

    @Override // com.autonavi.gbl.multi.observer.KldSceneBase
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.multi.observer.KldSceneBase
    public synchronized void delete() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.CBLSceneRouteResult.3
        });
        objArr[1] = String.valueOf(this.mService != null);
        DebugTool.d("%s: mService=%s", objArr);
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mService != null) {
            if (this.mTypeHelper != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                TypeHelper.unbindAllTarget(ReflexTool.PN(this.mService.getClass()), this.mService);
            }
            ReflexTool.invokeDeclMethodSafe(this.mService, RequestParameters.SUBRESOURCE_DELETE, null, null);
            this.mService = null;
        }
        unbind();
    }

    @Override // com.autonavi.gbl.multi.observer.KldSceneBase, com.autonavi.gbl.multi.observer.IKldSceneBase, com.autonavi.gbl.multi.observer.ICBLSceneMap
    public int onSceneInit(CKldIntent cKldIntent) {
        CBLSceneRouteResultImpl cBLSceneRouteResultImpl = this.mService;
        if (cBLSceneRouteResultImpl != null) {
            return cBLSceneRouteResultImpl.$explicit_onSceneInit(cKldIntent);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.KldSceneBase, com.autonavi.gbl.multi.observer.IKldSceneBase, com.autonavi.gbl.multi.observer.ICBLSceneMap
    public int onSceneEntered(String str, CKldIntent cKldIntent) {
        CBLSceneRouteResultImpl cBLSceneRouteResultImpl = this.mService;
        if (cBLSceneRouteResultImpl != null) {
            return cBLSceneRouteResultImpl.$explicit_onSceneEntered(str, cKldIntent);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.KldSceneBase, com.autonavi.gbl.multi.observer.IKldSceneBase, com.autonavi.gbl.multi.observer.ICBLSceneMap
    public int onSceneExit() {
        CBLSceneRouteResultImpl cBLSceneRouteResultImpl = this.mService;
        if (cBLSceneRouteResultImpl != null) {
            return cBLSceneRouteResultImpl.$explicit_onSceneExit();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.KldSceneBase, com.autonavi.gbl.multi.observer.IKldSceneBase, com.autonavi.gbl.multi.observer.ICBLSceneMap
    public int onSceneResume(boolean z) {
        CBLSceneRouteResultImpl cBLSceneRouteResultImpl = this.mService;
        if (cBLSceneRouteResultImpl != null) {
            return cBLSceneRouteResultImpl.$explicit_onSceneResume(z);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.KldSceneBase, com.autonavi.gbl.multi.observer.IKldSceneBase, com.autonavi.gbl.multi.observer.ICBLSceneMap
    public int onScenePause() {
        CBLSceneRouteResultImpl cBLSceneRouteResultImpl = this.mService;
        if (cBLSceneRouteResultImpl != null) {
            return cBLSceneRouteResultImpl.$explicit_onScenePause();
        }
        return 0;
    }
}
