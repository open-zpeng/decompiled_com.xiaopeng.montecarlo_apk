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
import com.autonavi.gbl.multi.observer.CBLScenePreview;
import com.autonavi.gbl.multi.observer.DisplaySceneConfigBase;
import com.autonavi.gbl.multi.observer.ICBLScenePreview;
import com.autonavi.gbl.multi.observer.impl.CBLScenePreviewImpl;
import com.autonavi.gbl.multi.observer.impl.DisplaySceneConfigBaseImpl;
import java.lang.reflect.Method;
@IntfAuto(target = CBLScenePreview.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class CBLScenePreviewRouter extends CBLScenePreviewImpl {
    private static BindTable BIND_TABLE = new BindTable(CBLScenePreviewRouter.class);
    private static String PACKAGE = ReflexTool.PN(CBLScenePreviewRouter.class);
    private TypeHelper mHelper;
    private ICBLScenePreview mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ICBLScenePreview iCBLScenePreview) {
        if (iCBLScenePreview != null) {
            this.mObserver = iCBLScenePreview;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(CBLScenePreview.class, iCBLScenePreview, this);
            }
        }
    }

    private void $constructor(String str, ICBLScenePreview iCBLScenePreview) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(CBLScenePreviewImpl.getCPtr((CBLScenePreviewImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iCBLScenePreview);
    }

    public CBLScenePreviewRouter(String str, ICBLScenePreview iCBLScenePreview, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCBLScenePreview);
    }

    public CBLScenePreviewRouter(String str, ICBLScenePreview iCBLScenePreview) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCBLScenePreview);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.CBLScenePreviewRouter.1
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
    @Override // com.autonavi.gbl.multi.observer.impl.CBLScenePreviewImpl, com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.CBLScenePreviewRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.CBLScenePreviewImpl, com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onSceneInit(CKldIntent cKldIntent) {
        ICBLScenePreview iCBLScenePreview = this.mObserver;
        if (iCBLScenePreview != null) {
            return iCBLScenePreview.onSceneInit(cKldIntent);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.CBLScenePreviewImpl, com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onSceneEntered(String str, CKldIntent cKldIntent) {
        ICBLScenePreview iCBLScenePreview = this.mObserver;
        if (iCBLScenePreview != null) {
            return iCBLScenePreview.onSceneEntered(str, cKldIntent);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.CBLScenePreviewImpl, com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onSceneExit() {
        ICBLScenePreview iCBLScenePreview = this.mObserver;
        if (iCBLScenePreview != null) {
            return iCBLScenePreview.onSceneExit();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.CBLScenePreviewImpl, com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onSceneResume(boolean z) {
        ICBLScenePreview iCBLScenePreview = this.mObserver;
        if (iCBLScenePreview != null) {
            return iCBLScenePreview.onSceneResume(z);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.CBLScenePreviewImpl, com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onScenePause() {
        ICBLScenePreview iCBLScenePreview = this.mObserver;
        if (iCBLScenePreview != null) {
            return iCBLScenePreview.onScenePause();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public void onNewIntent(CKldIntent cKldIntent) {
        ICBLScenePreview iCBLScenePreview = this.mObserver;
        if (iCBLScenePreview != null) {
            iCBLScenePreview.onNewIntent(cKldIntent);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public int onUpateSceneState(String str, SceneViewState sceneViewState) {
        ICBLScenePreview iCBLScenePreview = this.mObserver;
        if (iCBLScenePreview != null) {
            return iCBLScenePreview.onUpateSceneState(str, sceneViewState);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public CKldSceneContextImpl getContext() {
        ICBLScenePreview iCBLScenePreview = this.mObserver;
        if (iCBLScenePreview != null) {
            return iCBLScenePreview.getContext();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public String getSceneName() {
        ICBLScenePreview iCBLScenePreview = this.mObserver;
        if (iCBLScenePreview != null) {
            return iCBLScenePreview.getSceneName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl
    public DisplaySceneConfigBaseImpl getSceneConf() {
        DisplaySceneConfigBase sceneConf;
        try {
            Method method = CBLScenePreviewRouter.class.getMethod("getSceneConf", new Class[0]);
            ICBLScenePreview iCBLScenePreview = this.mObserver;
            if (iCBLScenePreview != null && (sceneConf = iCBLScenePreview.getSceneConf()) != null) {
                TypeHelper typeHelper = this.mHelper;
                r0 = typeHelper != null ? (DisplaySceneConfigBaseImpl) typeHelper.transfer(method, -1, (Object) sceneConf, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.CBLScenePreviewRouter.3
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
        ICBLScenePreview iCBLScenePreview = this.mObserver;
        if (iCBLScenePreview != null) {
            return iCBLScenePreview.getUserData();
        }
        return null;
    }
}
