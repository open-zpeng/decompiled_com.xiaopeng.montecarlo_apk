package com.autonavi.gbl.multi.observer;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.multi.impl.CKldIntent;
import com.autonavi.gbl.multi.observer.impl.CBLScenePreviewImpl;
import com.autonavi.gbl.multi.router.CBLScenePreviewRouter;
@IntfAuto(target = CBLScenePreviewRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class CBLScenePreview extends KldSceneBase implements ICBLScenePreview {
    private static String PACKAGE = ReflexTool.PN(CBLScenePreview.class);
    private boolean mHasDestroy;
    private CBLScenePreviewImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected CBLScenePreview(long j, boolean z) {
        this(new CBLScenePreviewRouter("CBLScenePreview", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICBLScenePreview.class}, new Object[]{this});
    }

    public CBLScenePreview() {
        this(new CBLScenePreviewRouter("CBLScenePreview", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICBLScenePreview.class}, new Object[]{this});
    }

    public CBLScenePreview(CBLScenePreviewImpl cBLScenePreviewImpl) {
        super(cBLScenePreviewImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(cBLScenePreviewImpl);
    }

    private void $constructor(CBLScenePreviewImpl cBLScenePreviewImpl) {
        if (cBLScenePreviewImpl != null) {
            this.mService = cBLScenePreviewImpl;
            this.mTargetId = String.format("CBLScenePreview_%s_%d", String.valueOf(CBLScenePreviewImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.KldSceneBase
    public CBLScenePreviewImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.multi.observer.KldSceneBase
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.CBLScenePreview.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.CBLScenePreview.2
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
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.CBLScenePreview.3
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
        CBLScenePreviewImpl cBLScenePreviewImpl = this.mService;
        if (cBLScenePreviewImpl != null) {
            return cBLScenePreviewImpl.$explicit_open();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.KldSceneBase, com.autonavi.gbl.multi.observer.IKldSceneBase, com.autonavi.gbl.multi.observer.ICBLSceneMap
    public int onSceneInit(CKldIntent cKldIntent) {
        CBLScenePreviewImpl cBLScenePreviewImpl = this.mService;
        if (cBLScenePreviewImpl != null) {
            return cBLScenePreviewImpl.$explicit_onSceneInit(cKldIntent);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.KldSceneBase, com.autonavi.gbl.multi.observer.IKldSceneBase, com.autonavi.gbl.multi.observer.ICBLSceneMap
    public int onSceneEntered(String str, CKldIntent cKldIntent) {
        CBLScenePreviewImpl cBLScenePreviewImpl = this.mService;
        if (cBLScenePreviewImpl != null) {
            return cBLScenePreviewImpl.$explicit_onSceneEntered(str, cKldIntent);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.KldSceneBase, com.autonavi.gbl.multi.observer.IKldSceneBase, com.autonavi.gbl.multi.observer.ICBLSceneMap
    public int onSceneExit() {
        CBLScenePreviewImpl cBLScenePreviewImpl = this.mService;
        if (cBLScenePreviewImpl != null) {
            return cBLScenePreviewImpl.$explicit_onSceneExit();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.KldSceneBase, com.autonavi.gbl.multi.observer.IKldSceneBase, com.autonavi.gbl.multi.observer.ICBLSceneMap
    public int onSceneResume(boolean z) {
        CBLScenePreviewImpl cBLScenePreviewImpl = this.mService;
        if (cBLScenePreviewImpl != null) {
            return cBLScenePreviewImpl.$explicit_onSceneResume(z);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.KldSceneBase, com.autonavi.gbl.multi.observer.IKldSceneBase, com.autonavi.gbl.multi.observer.ICBLSceneMap
    public int onScenePause() {
        CBLScenePreviewImpl cBLScenePreviewImpl = this.mService;
        if (cBLScenePreviewImpl != null) {
            return cBLScenePreviewImpl.$explicit_onScenePause();
        }
        return 0;
    }
}
