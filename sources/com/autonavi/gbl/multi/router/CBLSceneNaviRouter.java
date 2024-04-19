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
import com.autonavi.gbl.multi.observer.CBLSceneNavi;
import com.autonavi.gbl.multi.observer.DisplaySceneConfigBase;
import com.autonavi.gbl.multi.observer.ICBLSceneNavi;
import com.autonavi.gbl.multi.observer.impl.CBLSceneNaviImpl;
import com.autonavi.gbl.multi.observer.impl.DisplaySceneConfigBaseImpl;
import java.lang.reflect.Method;
@IntfAuto(target = CBLSceneNavi.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class CBLSceneNaviRouter extends CBLSceneNaviImpl {
    private static BindTable BIND_TABLE = new BindTable(CBLSceneNaviRouter.class);
    private static String PACKAGE = ReflexTool.PN(CBLSceneNaviRouter.class);
    private TypeHelper mHelper;
    private ICBLSceneNavi mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ICBLSceneNavi iCBLSceneNavi) {
        if (iCBLSceneNavi != null) {
            this.mObserver = iCBLSceneNavi;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(CBLSceneNavi.class, iCBLSceneNavi, this);
            }
        }
    }

    private void $constructor(String str, ICBLSceneNavi iCBLSceneNavi) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(CBLSceneNaviImpl.getCPtr((CBLSceneNaviImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iCBLSceneNavi);
    }

    public CBLSceneNaviRouter(String str, ICBLSceneNavi iCBLSceneNavi, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCBLSceneNavi);
    }

    public CBLSceneNaviRouter(String str, ICBLSceneNavi iCBLSceneNavi) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCBLSceneNavi);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.CBLSceneNaviRouter.1
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
    @Override // com.autonavi.gbl.multi.observer.impl.CBLSceneNaviImpl, com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.CBLSceneNaviRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.CBLSceneNaviImpl, com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onSceneInit(CKldIntent cKldIntent) {
        ICBLSceneNavi iCBLSceneNavi = this.mObserver;
        if (iCBLSceneNavi != null) {
            return iCBLSceneNavi.onSceneInit(cKldIntent);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.CBLSceneNaviImpl, com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onSceneEntered(String str, CKldIntent cKldIntent) {
        ICBLSceneNavi iCBLSceneNavi = this.mObserver;
        if (iCBLSceneNavi != null) {
            return iCBLSceneNavi.onSceneEntered(str, cKldIntent);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.CBLSceneNaviImpl, com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onSceneExit() {
        ICBLSceneNavi iCBLSceneNavi = this.mObserver;
        if (iCBLSceneNavi != null) {
            return iCBLSceneNavi.onSceneExit();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.CBLSceneNaviImpl, com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onSceneResume(boolean z) {
        ICBLSceneNavi iCBLSceneNavi = this.mObserver;
        if (iCBLSceneNavi != null) {
            return iCBLSceneNavi.onSceneResume(z);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.CBLSceneNaviImpl, com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onScenePause() {
        ICBLSceneNavi iCBLSceneNavi = this.mObserver;
        if (iCBLSceneNavi != null) {
            return iCBLSceneNavi.onScenePause();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public void onNewIntent(CKldIntent cKldIntent) {
        ICBLSceneNavi iCBLSceneNavi = this.mObserver;
        if (iCBLSceneNavi != null) {
            iCBLSceneNavi.onNewIntent(cKldIntent);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onUpateSceneState(String str, SceneViewState sceneViewState) {
        ICBLSceneNavi iCBLSceneNavi = this.mObserver;
        if (iCBLSceneNavi != null) {
            return iCBLSceneNavi.onUpateSceneState(str, sceneViewState);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public CKldSceneContextImpl getContext() {
        ICBLSceneNavi iCBLSceneNavi = this.mObserver;
        if (iCBLSceneNavi != null) {
            return iCBLSceneNavi.getContext();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public String getSceneName() {
        ICBLSceneNavi iCBLSceneNavi = this.mObserver;
        if (iCBLSceneNavi != null) {
            return iCBLSceneNavi.getSceneName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public DisplaySceneConfigBaseImpl getSceneConf() {
        DisplaySceneConfigBase sceneConf;
        try {
            Method method = CBLSceneNaviRouter.class.getMethod("getSceneConf", new Class[0]);
            ICBLSceneNavi iCBLSceneNavi = this.mObserver;
            if (iCBLSceneNavi != null && (sceneConf = iCBLSceneNavi.getSceneConf()) != null) {
                TypeHelper typeHelper = this.mHelper;
                r0 = typeHelper != null ? (DisplaySceneConfigBaseImpl) typeHelper.transfer(method, -1, (Object) sceneConf, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.CBLSceneNaviRouter.3
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
        ICBLSceneNavi iCBLSceneNavi = this.mObserver;
        if (iCBLSceneNavi != null) {
            return iCBLSceneNavi.getUserData();
        }
        return null;
    }
}
