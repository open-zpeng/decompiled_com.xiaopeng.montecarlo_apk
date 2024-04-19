package com.autonavi.gbl.multi.observer;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.multi.impl.CKldIntent;
import com.autonavi.gbl.multi.observer.impl.CBLSceneNaviImpl;
import com.autonavi.gbl.multi.router.CBLSceneNaviRouter;
@IntfAuto(target = CBLSceneNaviRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class CBLSceneNavi extends KldSceneBase implements ICBLSceneNavi {
    private static String PACKAGE = ReflexTool.PN(CBLSceneNavi.class);
    private boolean mHasDestroy;
    private CBLSceneNaviImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected CBLSceneNavi(long j, boolean z) {
        this(new CBLSceneNaviRouter("CBLSceneNavi", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICBLSceneNavi.class}, new Object[]{this});
    }

    public CBLSceneNavi() {
        this(new CBLSceneNaviRouter("CBLSceneNavi", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICBLSceneNavi.class}, new Object[]{this});
    }

    public CBLSceneNavi(CBLSceneNaviImpl cBLSceneNaviImpl) {
        super(cBLSceneNaviImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(cBLSceneNaviImpl);
    }

    private void $constructor(CBLSceneNaviImpl cBLSceneNaviImpl) {
        if (cBLSceneNaviImpl != null) {
            this.mService = cBLSceneNaviImpl;
            this.mTargetId = String.format("CBLSceneNavi_%s_%d", String.valueOf(CBLSceneNaviImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.KldSceneBase
    public CBLSceneNaviImpl getService() {
        return this.mService;
    }

    @Override // com.autonavi.gbl.multi.observer.KldSceneBase
    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.CBLSceneNavi.1
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

    @Override // com.autonavi.gbl.multi.observer.KldSceneBase
    protected void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.CBLSceneNavi.2
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
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.CBLSceneNavi.3
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

    @Override // com.autonavi.gbl.multi.observer.KldSceneBase
    public boolean setMapCenterWhenRestore() {
        CBLSceneNaviImpl cBLSceneNaviImpl = this.mService;
        if (cBLSceneNaviImpl != null) {
            return cBLSceneNaviImpl.$explicit_setMapCenterWhenRestore();
        }
        return false;
    }

    public int open() {
        CBLSceneNaviImpl cBLSceneNaviImpl = this.mService;
        if (cBLSceneNaviImpl != null) {
            return cBLSceneNaviImpl.$explicit_open();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.KldSceneBase, com.autonavi.gbl.multi.observer.IKldSceneBase, com.autonavi.gbl.multi.observer.ICBLSceneMap
    public int onSceneInit(CKldIntent cKldIntent) {
        CBLSceneNaviImpl cBLSceneNaviImpl = this.mService;
        if (cBLSceneNaviImpl != null) {
            return cBLSceneNaviImpl.$explicit_onSceneInit(cKldIntent);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.KldSceneBase, com.autonavi.gbl.multi.observer.IKldSceneBase, com.autonavi.gbl.multi.observer.ICBLSceneMap
    public int onSceneEntered(String str, CKldIntent cKldIntent) {
        CBLSceneNaviImpl cBLSceneNaviImpl = this.mService;
        if (cBLSceneNaviImpl != null) {
            return cBLSceneNaviImpl.$explicit_onSceneEntered(str, cKldIntent);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.KldSceneBase, com.autonavi.gbl.multi.observer.IKldSceneBase, com.autonavi.gbl.multi.observer.ICBLSceneMap
    public int onSceneExit() {
        CBLSceneNaviImpl cBLSceneNaviImpl = this.mService;
        if (cBLSceneNaviImpl != null) {
            return cBLSceneNaviImpl.$explicit_onSceneExit();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.KldSceneBase, com.autonavi.gbl.multi.observer.IKldSceneBase, com.autonavi.gbl.multi.observer.ICBLSceneMap
    public int onSceneResume(boolean z) {
        CBLSceneNaviImpl cBLSceneNaviImpl = this.mService;
        if (cBLSceneNaviImpl != null) {
            return cBLSceneNaviImpl.$explicit_onSceneResume(z);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.KldSceneBase, com.autonavi.gbl.multi.observer.IKldSceneBase, com.autonavi.gbl.multi.observer.ICBLSceneMap
    public int onScenePause() {
        CBLSceneNaviImpl cBLSceneNaviImpl = this.mService;
        if (cBLSceneNaviImpl != null) {
            return cBLSceneNaviImpl.$explicit_onScenePause();
        }
        return 0;
    }
}
