package com.autonavi.gbl.scene.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.scene.model.SceneModuleID;
import com.autonavi.gbl.scene.model.ScreenParam;
import com.autonavi.gbl.scene.observer.IScreenParamAdapter;
import com.autonavi.gbl.scene.observer.impl.IScreenParamAdapterImpl;
@IntfAuto(target = IScreenParamAdapter.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class ScreenParamAdapterRouter extends IScreenParamAdapterImpl {
    private static BindTable BIND_TABLE = new BindTable(ScreenParamAdapterRouter.class);
    private static String PACKAGE = ReflexTool.PN(ScreenParamAdapterRouter.class);
    private TypeHelper mHelper;
    private IScreenParamAdapter mObserver;
    private String mTargetId;

    private void $constructor(String str, IScreenParamAdapter iScreenParamAdapter) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IScreenParamAdapterImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iScreenParamAdapter;
    }

    protected ScreenParamAdapterRouter(String str, IScreenParamAdapter iScreenParamAdapter, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iScreenParamAdapter);
    }

    protected ScreenParamAdapterRouter(String str, IScreenParamAdapter iScreenParamAdapter) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iScreenParamAdapter);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.scene.observer.impl.IScreenParamAdapterImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.scene.observer.impl.IScreenParamAdapterImpl
    public ScreenParam getScreenParam(@SceneModuleID.SceneModuleID1 int i, long j) {
        IScreenParamAdapter iScreenParamAdapter = this.mObserver;
        if (iScreenParamAdapter != null) {
            return iScreenParamAdapter.getScreenParam(i, j);
        }
        return null;
    }
}
