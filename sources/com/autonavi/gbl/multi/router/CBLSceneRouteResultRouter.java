package com.autonavi.gbl.multi.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.multi.impl.CKldIntent;
import com.autonavi.gbl.multi.impl.CKldSceneContextImpl;
import com.autonavi.gbl.multi.model.SceneViewState;
import com.autonavi.gbl.multi.observer.CBLSceneRouteResult;
import com.autonavi.gbl.multi.observer.DisplaySceneConfigBase;
import com.autonavi.gbl.multi.observer.ICBLSceneRouteResult;
import com.autonavi.gbl.multi.observer.impl.CBLSceneRouteResultImpl;
import com.autonavi.gbl.multi.observer.impl.DisplaySceneConfigBaseImpl;
import java.lang.reflect.Method;
@IntfAuto(target = CBLSceneRouteResult.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class CBLSceneRouteResultRouter extends CBLSceneRouteResultImpl {
    private static BindTable BIND_TABLE = new BindTable(CBLSceneRouteResultRouter.class);
    private static String PACKAGE = ReflexTool.PN(CBLSceneRouteResultRouter.class);
    private TypeHelper mHelper;
    private ICBLSceneRouteResult mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ICBLSceneRouteResult iCBLSceneRouteResult) {
        if (iCBLSceneRouteResult != null) {
            this.mObserver = iCBLSceneRouteResult;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(CBLSceneRouteResult.class, iCBLSceneRouteResult, this);
            }
        }
    }

    private void $constructor(String str, ICBLSceneRouteResult iCBLSceneRouteResult) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(CBLSceneRouteResultImpl.getCPtr((CBLSceneRouteResultImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iCBLSceneRouteResult);
    }

    public CBLSceneRouteResultRouter(String str, ICBLSceneRouteResult iCBLSceneRouteResult, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCBLSceneRouteResult);
    }

    public CBLSceneRouteResultRouter(String str, ICBLSceneRouteResult iCBLSceneRouteResult) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCBLSceneRouteResult);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.CBLSceneRouteResultRouter.1
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
    @Override // com.autonavi.gbl.multi.observer.impl.CBLSceneRouteResultImpl, com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.CBLSceneRouteResultRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.CBLSceneRouteResultImpl, com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onSceneInit(CKldIntent cKldIntent) {
        ICBLSceneRouteResult iCBLSceneRouteResult = this.mObserver;
        if (iCBLSceneRouteResult != null) {
            return iCBLSceneRouteResult.onSceneInit(cKldIntent);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.CBLSceneRouteResultImpl, com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onSceneEntered(String str, CKldIntent cKldIntent) {
        ICBLSceneRouteResult iCBLSceneRouteResult = this.mObserver;
        if (iCBLSceneRouteResult != null) {
            return iCBLSceneRouteResult.onSceneEntered(str, cKldIntent);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.CBLSceneRouteResultImpl, com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onSceneExit() {
        ICBLSceneRouteResult iCBLSceneRouteResult = this.mObserver;
        if (iCBLSceneRouteResult != null) {
            return iCBLSceneRouteResult.onSceneExit();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.CBLSceneRouteResultImpl, com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onSceneResume(boolean z) {
        ICBLSceneRouteResult iCBLSceneRouteResult = this.mObserver;
        if (iCBLSceneRouteResult != null) {
            return iCBLSceneRouteResult.onSceneResume(z);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.CBLSceneRouteResultImpl, com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onScenePause() {
        ICBLSceneRouteResult iCBLSceneRouteResult = this.mObserver;
        if (iCBLSceneRouteResult != null) {
            return iCBLSceneRouteResult.onScenePause();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public void onNewIntent(CKldIntent cKldIntent) {
        ICBLSceneRouteResult iCBLSceneRouteResult = this.mObserver;
        if (iCBLSceneRouteResult != null) {
            iCBLSceneRouteResult.onNewIntent(cKldIntent);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onUpateSceneState(String str, SceneViewState sceneViewState) {
        ICBLSceneRouteResult iCBLSceneRouteResult = this.mObserver;
        if (iCBLSceneRouteResult != null) {
            return iCBLSceneRouteResult.onUpateSceneState(str, sceneViewState);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public CKldSceneContextImpl getContext() {
        ICBLSceneRouteResult iCBLSceneRouteResult = this.mObserver;
        if (iCBLSceneRouteResult != null) {
            return iCBLSceneRouteResult.getContext();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public String getSceneName() {
        ICBLSceneRouteResult iCBLSceneRouteResult = this.mObserver;
        if (iCBLSceneRouteResult != null) {
            return iCBLSceneRouteResult.getSceneName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public DisplaySceneConfigBaseImpl getSceneConf() {
        DisplaySceneConfigBase sceneConf;
        try {
            Method method = CBLSceneRouteResultRouter.class.getMethod("getSceneConf", new Class[0]);
            ICBLSceneRouteResult iCBLSceneRouteResult = this.mObserver;
            if (iCBLSceneRouteResult != null && (sceneConf = iCBLSceneRouteResult.getSceneConf()) != null) {
                TypeHelper typeHelper = this.mHelper;
                r0 = typeHelper != null ? (DisplaySceneConfigBaseImpl) typeHelper.transfer(method, -1, (Object) sceneConf, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.CBLSceneRouteResultRouter.3
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public CKldIntent getUserData() {
        ICBLSceneRouteResult iCBLSceneRouteResult = this.mObserver;
        if (iCBLSceneRouteResult != null) {
            return iCBLSceneRouteResult.getUserData();
        }
        return null;
    }
}
