package com.autonavi.gbl.scene.dynamic;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.scene.BaseSceneModule;
import com.autonavi.gbl.scene.dynamic.impl.ISwitchViewModuleImpl;
import com.autonavi.gbl.scene.observer.IViewParamAdapter;
import com.autonavi.gbl.scene.observer.impl.IViewParamAdapterImpl;
import java.lang.reflect.Method;
@IntfAuto(target = ISwitchViewModuleImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class SwitchViewModule extends BaseSceneModule {
    private static String PACKAGE = ReflexTool.PN(SwitchViewModule.class);
    private ISwitchViewModuleImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected SwitchViewModule(long j, boolean z) {
        this(new ISwitchViewModuleImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(SwitchViewModule.class, this, this.mControl);
        }
    }

    public SwitchViewModule(ISwitchViewModuleImpl iSwitchViewModuleImpl) {
        super(iSwitchViewModuleImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iSwitchViewModuleImpl);
    }

    private void $constructor(ISwitchViewModuleImpl iSwitchViewModuleImpl) {
        if (iSwitchViewModuleImpl != null) {
            this.mControl = iSwitchViewModuleImpl;
            this.mTargetId = String.format("SwitchViewModule_%s_%d", String.valueOf(ISwitchViewModuleImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.scene.BaseSceneModule
    public ISwitchViewModuleImpl getControl() {
        return this.mControl;
    }

    public void setIViewParamAdapter(IViewParamAdapter iViewParamAdapter) {
        TypeHelper typeHelper;
        try {
            Method method = SwitchViewModule.class.getMethod("setIViewParamAdapter", IViewParamAdapter.class);
            IViewParamAdapterImpl iViewParamAdapterImpl = null;
            if (iViewParamAdapter != null && (typeHelper = this.mTypeHelper) != null) {
                iViewParamAdapterImpl = (IViewParamAdapterImpl) typeHelper.transfer(method, 0, iViewParamAdapter);
            }
            ISwitchViewModuleImpl iSwitchViewModuleImpl = this.mControl;
            if (iSwitchViewModuleImpl != null) {
                iSwitchViewModuleImpl.setIViewParamAdapter(iViewParamAdapterImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.scene.BaseSceneModule
    public void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
        super.unbind();
    }

    @Override // com.autonavi.gbl.scene.BaseSceneModule
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.scene.BaseSceneModule
    public void clean() {
        super.clean();
    }

    @Override // com.autonavi.gbl.scene.BaseSceneModule
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
