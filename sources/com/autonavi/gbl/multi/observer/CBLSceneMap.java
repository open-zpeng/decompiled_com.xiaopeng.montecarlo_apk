package com.autonavi.gbl.multi.observer;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.multi.impl.CKldIntent;
import com.autonavi.gbl.multi.observer.impl.CBLSceneMapImpl;
import com.autonavi.gbl.multi.router.CBLSceneMapRouter;
@IntfAuto(target = CBLSceneMapRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class CBLSceneMap extends KldSceneBase implements ICBLSceneMap {
    private static String PACKAGE = ReflexTool.PN(CBLSceneMap.class);
    private boolean mHasDestroy;
    private CBLSceneMapImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected CBLSceneMap(long j, boolean z) {
        this(new CBLSceneMapRouter("CBLSceneMap", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICBLSceneMap.class}, new Object[]{this});
    }

    public CBLSceneMap() {
        this(new CBLSceneMapRouter("CBLSceneMap", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICBLSceneMap.class}, new Object[]{this});
    }

    public CBLSceneMap(CBLSceneMapImpl cBLSceneMapImpl) {
        super(cBLSceneMapImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(cBLSceneMapImpl);
    }

    private void $constructor(CBLSceneMapImpl cBLSceneMapImpl) {
        if (cBLSceneMapImpl != null) {
            this.mService = cBLSceneMapImpl;
            this.mTargetId = String.format("CBLSceneMap_%s_%d", String.valueOf(CBLSceneMapImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.KldSceneBase
    public CBLSceneMapImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.multi.observer.KldSceneBase
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.CBLSceneMap.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.CBLSceneMap.2
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
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.CBLSceneMap.3
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
        CBLSceneMapImpl cBLSceneMapImpl = this.mService;
        if (cBLSceneMapImpl != null) {
            return cBLSceneMapImpl.$explicit_open();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.KldSceneBase, com.autonavi.gbl.multi.observer.IKldSceneBase, com.autonavi.gbl.multi.observer.ICBLSceneMap
    public int onSceneInit(CKldIntent cKldIntent) {
        CBLSceneMapImpl cBLSceneMapImpl = this.mService;
        if (cBLSceneMapImpl != null) {
            return cBLSceneMapImpl.$explicit_onSceneInit(cKldIntent);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.KldSceneBase, com.autonavi.gbl.multi.observer.IKldSceneBase, com.autonavi.gbl.multi.observer.ICBLSceneMap
    public int onSceneEntered(String str, CKldIntent cKldIntent) {
        CBLSceneMapImpl cBLSceneMapImpl = this.mService;
        if (cBLSceneMapImpl != null) {
            return cBLSceneMapImpl.$explicit_onSceneEntered(str, cKldIntent);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.KldSceneBase, com.autonavi.gbl.multi.observer.IKldSceneBase, com.autonavi.gbl.multi.observer.ICBLSceneMap
    public int onSceneExit() {
        CBLSceneMapImpl cBLSceneMapImpl = this.mService;
        if (cBLSceneMapImpl != null) {
            return cBLSceneMapImpl.$explicit_onSceneExit();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.KldSceneBase, com.autonavi.gbl.multi.observer.IKldSceneBase, com.autonavi.gbl.multi.observer.ICBLSceneMap
    public int onSceneResume(boolean z) {
        CBLSceneMapImpl cBLSceneMapImpl = this.mService;
        if (cBLSceneMapImpl != null) {
            return cBLSceneMapImpl.$explicit_onSceneResume(z);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.KldSceneBase, com.autonavi.gbl.multi.observer.IKldSceneBase, com.autonavi.gbl.multi.observer.ICBLSceneMap
    public int onScenePause() {
        CBLSceneMapImpl cBLSceneMapImpl = this.mService;
        if (cBLSceneMapImpl != null) {
            return cBLSceneMapImpl.$explicit_onScenePause();
        }
        return 0;
    }
}
