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
import com.autonavi.gbl.multi.observer.CBLSceneOpening;
import com.autonavi.gbl.multi.observer.DisplaySceneConfigBase;
import com.autonavi.gbl.multi.observer.ICBLSceneOpening;
import com.autonavi.gbl.multi.observer.impl.CBLSceneOpeningImpl;
import com.autonavi.gbl.multi.observer.impl.DisplaySceneConfigBaseImpl;
import java.lang.reflect.Method;
@IntfAuto(target = CBLSceneOpening.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class CBLSceneOpeningRouter extends CBLSceneOpeningImpl {
    private static BindTable BIND_TABLE = new BindTable(CBLSceneOpeningRouter.class);
    private static String PACKAGE = ReflexTool.PN(CBLSceneOpeningRouter.class);
    private TypeHelper mHelper;
    private ICBLSceneOpening mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ICBLSceneOpening iCBLSceneOpening) {
        if (iCBLSceneOpening != null) {
            this.mObserver = iCBLSceneOpening;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(CBLSceneOpening.class, iCBLSceneOpening, this);
            }
        }
    }

    private void $constructor(String str, ICBLSceneOpening iCBLSceneOpening) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(CBLSceneOpeningImpl.getCPtr((CBLSceneOpeningImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iCBLSceneOpening);
    }

    public CBLSceneOpeningRouter(String str, ICBLSceneOpening iCBLSceneOpening, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCBLSceneOpening);
    }

    public CBLSceneOpeningRouter(String str, ICBLSceneOpening iCBLSceneOpening) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCBLSceneOpening);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.CBLSceneOpeningRouter.1
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
    @Override // com.autonavi.gbl.multi.observer.impl.CBLSceneOpeningImpl, com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.CBLSceneOpeningRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.CBLSceneOpeningImpl, com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onSceneInit(CKldIntent cKldIntent) {
        ICBLSceneOpening iCBLSceneOpening = this.mObserver;
        if (iCBLSceneOpening != null) {
            return iCBLSceneOpening.onSceneInit(cKldIntent);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.CBLSceneOpeningImpl, com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onSceneEntered(String str, CKldIntent cKldIntent) {
        ICBLSceneOpening iCBLSceneOpening = this.mObserver;
        if (iCBLSceneOpening != null) {
            return iCBLSceneOpening.onSceneEntered(str, cKldIntent);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.CBLSceneOpeningImpl, com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onSceneExit() {
        ICBLSceneOpening iCBLSceneOpening = this.mObserver;
        if (iCBLSceneOpening != null) {
            return iCBLSceneOpening.onSceneExit();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.CBLSceneOpeningImpl, com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onSceneResume(boolean z) {
        ICBLSceneOpening iCBLSceneOpening = this.mObserver;
        if (iCBLSceneOpening != null) {
            return iCBLSceneOpening.onSceneResume(z);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.CBLSceneOpeningImpl, com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onScenePause() {
        ICBLSceneOpening iCBLSceneOpening = this.mObserver;
        if (iCBLSceneOpening != null) {
            return iCBLSceneOpening.onScenePause();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public void onNewIntent(CKldIntent cKldIntent) {
        ICBLSceneOpening iCBLSceneOpening = this.mObserver;
        if (iCBLSceneOpening != null) {
            iCBLSceneOpening.onNewIntent(cKldIntent);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onUpateSceneState(String str, SceneViewState sceneViewState) {
        ICBLSceneOpening iCBLSceneOpening = this.mObserver;
        if (iCBLSceneOpening != null) {
            return iCBLSceneOpening.onUpateSceneState(str, sceneViewState);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public CKldSceneContextImpl getContext() {
        ICBLSceneOpening iCBLSceneOpening = this.mObserver;
        if (iCBLSceneOpening != null) {
            return iCBLSceneOpening.getContext();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public String getSceneName() {
        ICBLSceneOpening iCBLSceneOpening = this.mObserver;
        if (iCBLSceneOpening != null) {
            return iCBLSceneOpening.getSceneName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public DisplaySceneConfigBaseImpl getSceneConf() {
        DisplaySceneConfigBase sceneConf;
        try {
            Method method = CBLSceneOpeningRouter.class.getMethod("getSceneConf", new Class[0]);
            ICBLSceneOpening iCBLSceneOpening = this.mObserver;
            if (iCBLSceneOpening != null && (sceneConf = iCBLSceneOpening.getSceneConf()) != null) {
                TypeHelper typeHelper = this.mHelper;
                r0 = typeHelper != null ? (DisplaySceneConfigBaseImpl) typeHelper.transfer(method, -1, (Object) sceneConf, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.CBLSceneOpeningRouter.3
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
        ICBLSceneOpening iCBLSceneOpening = this.mObserver;
        if (iCBLSceneOpening != null) {
            return iCBLSceneOpening.getUserData();
        }
        return null;
    }
}
