package com.autonavi.gbl.scene;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.scene.impl.IBaseSceneModuleImpl;
import com.autonavi.gbl.scene.model.ModuleInitStatus;
import com.autonavi.gbl.scene.model.SceneModuleID;
@IntfAuto(target = IBaseSceneModuleImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class BaseSceneModule {
    private static String PACKAGE = ReflexTool.PN(BaseSceneModule.class);
    private IBaseSceneModuleImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    /* JADX INFO: Access modifiers changed from: protected */
    public void clean() {
    }

    protected BaseSceneModule(long j, boolean z) {
        this(new IBaseSceneModuleImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BaseSceneModule.class, this, this.mControl);
        }
    }

    public BaseSceneModule(IBaseSceneModuleImpl iBaseSceneModuleImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iBaseSceneModuleImpl);
    }

    private void $constructor(IBaseSceneModuleImpl iBaseSceneModuleImpl) {
        if (iBaseSceneModuleImpl != null) {
            this.mControl = iBaseSceneModuleImpl;
            this.mTargetId = String.format("BaseSceneModule_%s_%d", String.valueOf(IBaseSceneModuleImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IBaseSceneModuleImpl getControl() {
        return this.mControl;
    }

    public void unInit() {
        IBaseSceneModuleImpl iBaseSceneModuleImpl = this.mControl;
        if (iBaseSceneModuleImpl != null) {
            iBaseSceneModuleImpl.unInit();
        }
    }

    @ModuleInitStatus.ModuleInitStatus1
    public int isInit() {
        IBaseSceneModuleImpl iBaseSceneModuleImpl = this.mControl;
        if (iBaseSceneModuleImpl != null) {
            return iBaseSceneModuleImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public void open(boolean z) {
        IBaseSceneModuleImpl iBaseSceneModuleImpl = this.mControl;
        if (iBaseSceneModuleImpl != null) {
            iBaseSceneModuleImpl.open(z);
        }
    }

    @SceneModuleID.SceneModuleID1
    public int getModuleID() {
        IBaseSceneModuleImpl iBaseSceneModuleImpl = this.mControl;
        if (iBaseSceneModuleImpl != null) {
            return iBaseSceneModuleImpl.getModuleID();
        }
        return Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    protected synchronized void delete() {
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            this.mControl = null;
        }
        unbind();
    }
}
