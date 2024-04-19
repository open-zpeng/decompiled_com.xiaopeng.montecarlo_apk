package com.autonavi.gbl.multi.observer;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.multi.impl.CKldIntent;
import com.autonavi.gbl.multi.impl.CKldSceneContextImpl;
import com.autonavi.gbl.multi.model.SceneViewState;
import com.autonavi.gbl.multi.observer.impl.DisplaySceneConfigBaseImpl;
import com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl;
import com.autonavi.gbl.multi.router.KldSceneBaseRouter;
import java.lang.reflect.Method;
@IntfAuto(target = KldSceneBaseRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class KldSceneBase implements IKldSceneBase {
    private static String PACKAGE = ReflexTool.PN(KldSceneBase.class);
    private boolean mHasDestroy;
    private IKldSceneBaseImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected KldSceneBase(long j, boolean z) {
        this(new KldSceneBaseRouter("KldSceneBase", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IKldSceneBase.class}, new Object[]{this});
    }

    public KldSceneBase() {
        this(new KldSceneBaseRouter("KldSceneBase", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IKldSceneBase.class}, new Object[]{this});
    }

    public KldSceneBase(IKldSceneBaseImpl iKldSceneBaseImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(iKldSceneBaseImpl);
    }

    private void $constructor(IKldSceneBaseImpl iKldSceneBaseImpl) {
        if (iKldSceneBaseImpl != null) {
            this.mService = iKldSceneBaseImpl;
            this.mTargetId = String.format("KldSceneBase_%s_%d", String.valueOf(IKldSceneBaseImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    public IKldSceneBaseImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.KldSceneBase.1
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.KldSceneBase.2
        }));
    }

    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    public synchronized void delete() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.KldSceneBase.3
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

    public void restoreSceneState() {
        IKldSceneBaseImpl iKldSceneBaseImpl = this.mService;
        if (iKldSceneBaseImpl != null) {
            iKldSceneBaseImpl.$explicit_restoreSceneState();
        }
    }

    public boolean setMapCenterWhenRestore() {
        IKldSceneBaseImpl iKldSceneBaseImpl = this.mService;
        if (iKldSceneBaseImpl != null) {
            return iKldSceneBaseImpl.$explicit_setMapCenterWhenRestore();
        }
        return false;
    }

    public boolean setZoomerWhenRestore() {
        IKldSceneBaseImpl iKldSceneBaseImpl = this.mService;
        if (iKldSceneBaseImpl != null) {
            return iKldSceneBaseImpl.$explicit_setZoomerWhenRestore();
        }
        return false;
    }

    public boolean setMapModeWhenRestore() {
        IKldSceneBaseImpl iKldSceneBaseImpl = this.mService;
        if (iKldSceneBaseImpl != null) {
            return iKldSceneBaseImpl.$explicit_setMapModeWhenRestore();
        }
        return false;
    }

    public boolean setMapProjectionCenterWhenRestore() {
        IKldSceneBaseImpl iKldSceneBaseImpl = this.mService;
        if (iKldSceneBaseImpl != null) {
            return iKldSceneBaseImpl.$explicit_setMapProjectionCenterWhenRestore();
        }
        return false;
    }

    public int activateMapConfig() {
        IKldSceneBaseImpl iKldSceneBaseImpl = this.mService;
        if (iKldSceneBaseImpl != null) {
            return iKldSceneBaseImpl.$explicit_activateMapConfig();
        }
        return 0;
    }

    public int activateRenderConfig() {
        IKldSceneBaseImpl iKldSceneBaseImpl = this.mService;
        if (iKldSceneBaseImpl != null) {
            return iKldSceneBaseImpl.$explicit_activateRenderConfig();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.IKldSceneBase, com.autonavi.gbl.multi.observer.ICBLSceneMap
    public int onSceneInit(CKldIntent cKldIntent) {
        IKldSceneBaseImpl iKldSceneBaseImpl = this.mService;
        if (iKldSceneBaseImpl != null) {
            return iKldSceneBaseImpl.$explicit_onSceneInit(cKldIntent);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.IKldSceneBase, com.autonavi.gbl.multi.observer.ICBLSceneMap
    public int onSceneEntered(String str, CKldIntent cKldIntent) {
        IKldSceneBaseImpl iKldSceneBaseImpl = this.mService;
        if (iKldSceneBaseImpl != null) {
            return iKldSceneBaseImpl.$explicit_onSceneEntered(str, cKldIntent);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.IKldSceneBase, com.autonavi.gbl.multi.observer.ICBLSceneMap
    public int onSceneExit() {
        IKldSceneBaseImpl iKldSceneBaseImpl = this.mService;
        if (iKldSceneBaseImpl != null) {
            return iKldSceneBaseImpl.$explicit_onSceneExit();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.IKldSceneBase, com.autonavi.gbl.multi.observer.ICBLSceneMap
    public int onSceneResume(boolean z) {
        IKldSceneBaseImpl iKldSceneBaseImpl = this.mService;
        if (iKldSceneBaseImpl != null) {
            return iKldSceneBaseImpl.$explicit_onSceneResume(z);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.IKldSceneBase, com.autonavi.gbl.multi.observer.ICBLSceneMap
    public int onScenePause() {
        IKldSceneBaseImpl iKldSceneBaseImpl = this.mService;
        if (iKldSceneBaseImpl != null) {
            return iKldSceneBaseImpl.$explicit_onScenePause();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.IKldSceneBase
    public void onNewIntent(CKldIntent cKldIntent) {
        IKldSceneBaseImpl iKldSceneBaseImpl = this.mService;
        if (iKldSceneBaseImpl != null) {
            iKldSceneBaseImpl.$explicit_onNewIntent(cKldIntent);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.IKldSceneBase
    public int onUpateSceneState(String str, SceneViewState sceneViewState) {
        IKldSceneBaseImpl iKldSceneBaseImpl = this.mService;
        if (iKldSceneBaseImpl != null) {
            return iKldSceneBaseImpl.$explicit_onUpateSceneState(str, sceneViewState);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.IKldSceneBase
    public CKldSceneContextImpl getContext() {
        IKldSceneBaseImpl iKldSceneBaseImpl = this.mService;
        if (iKldSceneBaseImpl != null) {
            return iKldSceneBaseImpl.$explicit_getContext();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.IKldSceneBase
    public String getSceneName() {
        IKldSceneBaseImpl iKldSceneBaseImpl = this.mService;
        if (iKldSceneBaseImpl != null) {
            return iKldSceneBaseImpl.$explicit_getSceneName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.IKldSceneBase
    public DisplaySceneConfigBase getSceneConf() {
        DisplaySceneConfigBaseImpl $explicit_getSceneConf;
        try {
            Method method = KldSceneBase.class.getMethod("getSceneConf", new Class[0]);
            IKldSceneBaseImpl iKldSceneBaseImpl = this.mService;
            if (iKldSceneBaseImpl != null && ($explicit_getSceneConf = iKldSceneBaseImpl.$explicit_getSceneConf()) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (DisplaySceneConfigBase) typeHelper.transfer(method, -1, (Object) $explicit_getSceneConf, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.KldSceneBase.4
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    @Override // com.autonavi.gbl.multi.observer.IKldSceneBase
    public CKldIntent getUserData() {
        IKldSceneBaseImpl iKldSceneBaseImpl = this.mService;
        if (iKldSceneBaseImpl != null) {
            return iKldSceneBaseImpl.$explicit_getUserData();
        }
        return null;
    }
}
