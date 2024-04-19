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
import com.autonavi.gbl.multi.observer.CBLSceneMap;
import com.autonavi.gbl.multi.observer.DisplaySceneConfigBase;
import com.autonavi.gbl.multi.observer.ICBLSceneMap;
import com.autonavi.gbl.multi.observer.impl.CBLSceneMapImpl;
import com.autonavi.gbl.multi.observer.impl.DisplaySceneConfigBaseImpl;
import java.lang.reflect.Method;
@IntfAuto(target = CBLSceneMap.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class CBLSceneMapRouter extends CBLSceneMapImpl {
    private static BindTable BIND_TABLE = new BindTable(CBLSceneMapRouter.class);
    private static String PACKAGE = ReflexTool.PN(CBLSceneMapRouter.class);
    private TypeHelper mHelper;
    private ICBLSceneMap mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ICBLSceneMap iCBLSceneMap) {
        if (iCBLSceneMap != null) {
            this.mObserver = iCBLSceneMap;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(CBLSceneMap.class, iCBLSceneMap, this);
            }
        }
    }

    private void $constructor(String str, ICBLSceneMap iCBLSceneMap) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(CBLSceneMapImpl.getCPtr((CBLSceneMapImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iCBLSceneMap);
    }

    public CBLSceneMapRouter(String str, ICBLSceneMap iCBLSceneMap, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCBLSceneMap);
    }

    public CBLSceneMapRouter(String str, ICBLSceneMap iCBLSceneMap) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCBLSceneMap);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.CBLSceneMapRouter.1
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
    @Override // com.autonavi.gbl.multi.observer.impl.CBLSceneMapImpl, com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.CBLSceneMapRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.CBLSceneMapImpl, com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onSceneInit(CKldIntent cKldIntent) {
        ICBLSceneMap iCBLSceneMap = this.mObserver;
        if (iCBLSceneMap != null) {
            return iCBLSceneMap.onSceneInit(cKldIntent);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.CBLSceneMapImpl, com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onSceneEntered(String str, CKldIntent cKldIntent) {
        ICBLSceneMap iCBLSceneMap = this.mObserver;
        if (iCBLSceneMap != null) {
            return iCBLSceneMap.onSceneEntered(str, cKldIntent);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.CBLSceneMapImpl, com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onSceneExit() {
        ICBLSceneMap iCBLSceneMap = this.mObserver;
        if (iCBLSceneMap != null) {
            return iCBLSceneMap.onSceneExit();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.CBLSceneMapImpl, com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onSceneResume(boolean z) {
        ICBLSceneMap iCBLSceneMap = this.mObserver;
        if (iCBLSceneMap != null) {
            return iCBLSceneMap.onSceneResume(z);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.CBLSceneMapImpl, com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onScenePause() {
        ICBLSceneMap iCBLSceneMap = this.mObserver;
        if (iCBLSceneMap != null) {
            return iCBLSceneMap.onScenePause();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public void onNewIntent(CKldIntent cKldIntent) {
        ICBLSceneMap iCBLSceneMap = this.mObserver;
        if (iCBLSceneMap != null) {
            iCBLSceneMap.onNewIntent(cKldIntent);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onUpateSceneState(String str, SceneViewState sceneViewState) {
        ICBLSceneMap iCBLSceneMap = this.mObserver;
        if (iCBLSceneMap != null) {
            return iCBLSceneMap.onUpateSceneState(str, sceneViewState);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public CKldSceneContextImpl getContext() {
        ICBLSceneMap iCBLSceneMap = this.mObserver;
        if (iCBLSceneMap != null) {
            return iCBLSceneMap.getContext();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public String getSceneName() {
        ICBLSceneMap iCBLSceneMap = this.mObserver;
        if (iCBLSceneMap != null) {
            return iCBLSceneMap.getSceneName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public DisplaySceneConfigBaseImpl getSceneConf() {
        DisplaySceneConfigBase sceneConf;
        try {
            Method method = CBLSceneMapRouter.class.getMethod("getSceneConf", new Class[0]);
            ICBLSceneMap iCBLSceneMap = this.mObserver;
            if (iCBLSceneMap != null && (sceneConf = iCBLSceneMap.getSceneConf()) != null) {
                TypeHelper typeHelper = this.mHelper;
                r0 = typeHelper != null ? (DisplaySceneConfigBaseImpl) typeHelper.transfer(method, -1, (Object) sceneConf, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.CBLSceneMapRouter.3
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
        ICBLSceneMap iCBLSceneMap = this.mObserver;
        if (iCBLSceneMap != null) {
            return iCBLSceneMap.getUserData();
        }
        return null;
    }
}
