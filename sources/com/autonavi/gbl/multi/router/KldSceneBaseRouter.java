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
import com.autonavi.gbl.multi.observer.DisplaySceneConfigBase;
import com.autonavi.gbl.multi.observer.IKldSceneBase;
import com.autonavi.gbl.multi.observer.KldSceneBase;
import com.autonavi.gbl.multi.observer.impl.DisplaySceneConfigBaseImpl;
import com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl;
import java.lang.reflect.Method;
@IntfAuto(target = KldSceneBase.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class KldSceneBaseRouter extends IKldSceneBaseImpl {
    private static BindTable BIND_TABLE = new BindTable(KldSceneBaseRouter.class);
    private static String PACKAGE = ReflexTool.PN(KldSceneBaseRouter.class);
    private TypeHelper mHelper;
    private IKldSceneBase mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IKldSceneBase iKldSceneBase) {
        if (iKldSceneBase != null) {
            this.mObserver = iKldSceneBase;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(KldSceneBase.class, iKldSceneBase, this);
            }
        }
    }

    private void $constructor(String str, IKldSceneBase iKldSceneBase) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IKldSceneBaseImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iKldSceneBase);
    }

    public KldSceneBaseRouter(String str, IKldSceneBase iKldSceneBase, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iKldSceneBase);
    }

    public KldSceneBaseRouter(String str, IKldSceneBase iKldSceneBase) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iKldSceneBase);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.KldSceneBaseRouter.1
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
    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.KldSceneBaseRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onSceneInit(CKldIntent cKldIntent) {
        IKldSceneBase iKldSceneBase = this.mObserver;
        if (iKldSceneBase != null) {
            return iKldSceneBase.onSceneInit(cKldIntent);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onSceneEntered(String str, CKldIntent cKldIntent) {
        IKldSceneBase iKldSceneBase = this.mObserver;
        if (iKldSceneBase != null) {
            return iKldSceneBase.onSceneEntered(str, cKldIntent);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onSceneExit() {
        IKldSceneBase iKldSceneBase = this.mObserver;
        if (iKldSceneBase != null) {
            return iKldSceneBase.onSceneExit();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onSceneResume(boolean z) {
        IKldSceneBase iKldSceneBase = this.mObserver;
        if (iKldSceneBase != null) {
            return iKldSceneBase.onSceneResume(z);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onScenePause() {
        IKldSceneBase iKldSceneBase = this.mObserver;
        if (iKldSceneBase != null) {
            return iKldSceneBase.onScenePause();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public void onNewIntent(CKldIntent cKldIntent) {
        IKldSceneBase iKldSceneBase = this.mObserver;
        if (iKldSceneBase != null) {
            iKldSceneBase.onNewIntent(cKldIntent);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onUpateSceneState(String str, SceneViewState sceneViewState) {
        IKldSceneBase iKldSceneBase = this.mObserver;
        if (iKldSceneBase != null) {
            return iKldSceneBase.onUpateSceneState(str, sceneViewState);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public CKldSceneContextImpl getContext() {
        IKldSceneBase iKldSceneBase = this.mObserver;
        if (iKldSceneBase != null) {
            return iKldSceneBase.getContext();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public String getSceneName() {
        IKldSceneBase iKldSceneBase = this.mObserver;
        if (iKldSceneBase != null) {
            return iKldSceneBase.getSceneName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public DisplaySceneConfigBaseImpl getSceneConf() {
        DisplaySceneConfigBase sceneConf;
        try {
            Method method = KldSceneBaseRouter.class.getMethod("getSceneConf", new Class[0]);
            IKldSceneBase iKldSceneBase = this.mObserver;
            if (iKldSceneBase != null && (sceneConf = iKldSceneBase.getSceneConf()) != null) {
                TypeHelper typeHelper = this.mHelper;
                r0 = typeHelper != null ? (DisplaySceneConfigBaseImpl) typeHelper.transfer(method, -1, (Object) sceneConf, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.KldSceneBaseRouter.3
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
        IKldSceneBase iKldSceneBase = this.mObserver;
        if (iKldSceneBase != null) {
            return iKldSceneBase.getUserData();
        }
        return null;
    }
}
