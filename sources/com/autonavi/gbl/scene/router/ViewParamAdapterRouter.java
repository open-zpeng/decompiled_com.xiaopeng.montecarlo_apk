package com.autonavi.gbl.scene.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.scene.model.PerceptSceneInfo;
import com.autonavi.gbl.scene.model.SceneModuleID;
import com.autonavi.gbl.scene.model.ScenePreviewParam;
import com.autonavi.gbl.scene.observer.IViewParamAdapter;
import com.autonavi.gbl.scene.observer.impl.IViewParamAdapterImpl;
@IntfAuto(target = IViewParamAdapter.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class ViewParamAdapterRouter extends IViewParamAdapterImpl {
    private static BindTable BIND_TABLE = new BindTable(ViewParamAdapterRouter.class);
    private static String PACKAGE = ReflexTool.PN(ViewParamAdapterRouter.class);
    private TypeHelper mHelper;
    private IViewParamAdapter mObserver;
    private String mTargetId;

    private void $constructor(String str, IViewParamAdapter iViewParamAdapter) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IViewParamAdapterImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iViewParamAdapter;
    }

    protected ViewParamAdapterRouter(String str, IViewParamAdapter iViewParamAdapter, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iViewParamAdapter);
    }

    protected ViewParamAdapterRouter(String str, IViewParamAdapter iViewParamAdapter) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iViewParamAdapter);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.scene.observer.impl.IViewParamAdapterImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.scene.observer.impl.IViewParamAdapterImpl
    public ScenePreviewParam getPreviewParam(@SceneModuleID.SceneModuleID1 int i, PerceptSceneInfo perceptSceneInfo) {
        IViewParamAdapter iViewParamAdapter = this.mObserver;
        if (iViewParamAdapter != null) {
            return iViewParamAdapter.getPreviewParam(i, perceptSceneInfo);
        }
        return null;
    }
}
