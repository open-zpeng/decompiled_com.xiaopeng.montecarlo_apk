package com.autonavi.gbl.multi.observer;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.multi.impl.CKldIntent;
import com.autonavi.gbl.multi.observer.impl.CBLSceneOpeningImpl;
import com.autonavi.gbl.multi.router.CBLSceneOpeningRouter;
@IntfAuto(target = CBLSceneOpeningRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class CBLSceneOpening extends KldSceneBase implements ICBLSceneOpening {
    private static String PACKAGE = ReflexTool.PN(CBLSceneOpening.class);
    private boolean mHasDestroy;
    private CBLSceneOpeningImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected CBLSceneOpening(long j, boolean z) {
        this(new CBLSceneOpeningRouter("CBLSceneOpening", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICBLSceneOpening.class}, new Object[]{this});
    }

    public CBLSceneOpening() {
        this(new CBLSceneOpeningRouter("CBLSceneOpening", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICBLSceneOpening.class}, new Object[]{this});
    }

    public CBLSceneOpening(CBLSceneOpeningImpl cBLSceneOpeningImpl) {
        super(cBLSceneOpeningImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(cBLSceneOpeningImpl);
    }

    private void $constructor(CBLSceneOpeningImpl cBLSceneOpeningImpl) {
        if (cBLSceneOpeningImpl != null) {
            this.mService = cBLSceneOpeningImpl;
            this.mTargetId = String.format("CBLSceneOpening_%s_%d", String.valueOf(CBLSceneOpeningImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.KldSceneBase
    public CBLSceneOpeningImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.multi.observer.KldSceneBase
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.CBLSceneOpening.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.CBLSceneOpening.2
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
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.CBLSceneOpening.3
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

    public int open() {
        CBLSceneOpeningImpl cBLSceneOpeningImpl = this.mService;
        if (cBLSceneOpeningImpl != null) {
            return cBLSceneOpeningImpl.$explicit_open();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.KldSceneBase, com.autonavi.gbl.multi.observer.IKldSceneBase, com.autonavi.gbl.multi.observer.ICBLSceneMap
    public int onSceneInit(CKldIntent cKldIntent) {
        CBLSceneOpeningImpl cBLSceneOpeningImpl = this.mService;
        if (cBLSceneOpeningImpl != null) {
            return cBLSceneOpeningImpl.$explicit_onSceneInit(cKldIntent);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.KldSceneBase, com.autonavi.gbl.multi.observer.IKldSceneBase, com.autonavi.gbl.multi.observer.ICBLSceneMap
    public int onSceneEntered(String str, CKldIntent cKldIntent) {
        CBLSceneOpeningImpl cBLSceneOpeningImpl = this.mService;
        if (cBLSceneOpeningImpl != null) {
            return cBLSceneOpeningImpl.$explicit_onSceneEntered(str, cKldIntent);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.KldSceneBase, com.autonavi.gbl.multi.observer.IKldSceneBase, com.autonavi.gbl.multi.observer.ICBLSceneMap
    public int onSceneExit() {
        CBLSceneOpeningImpl cBLSceneOpeningImpl = this.mService;
        if (cBLSceneOpeningImpl != null) {
            return cBLSceneOpeningImpl.$explicit_onSceneExit();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.KldSceneBase, com.autonavi.gbl.multi.observer.IKldSceneBase, com.autonavi.gbl.multi.observer.ICBLSceneMap
    public int onSceneResume(boolean z) {
        CBLSceneOpeningImpl cBLSceneOpeningImpl = this.mService;
        if (cBLSceneOpeningImpl != null) {
            return cBLSceneOpeningImpl.$explicit_onSceneResume(z);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.KldSceneBase, com.autonavi.gbl.multi.observer.IKldSceneBase, com.autonavi.gbl.multi.observer.ICBLSceneMap
    public int onScenePause() {
        CBLSceneOpeningImpl cBLSceneOpeningImpl = this.mService;
        if (cBLSceneOpeningImpl != null) {
            return cBLSceneOpeningImpl.$explicit_onScenePause();
        }
        return 0;
    }
}
