package com.autonavi.gbl.scene.dynamic;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.scene.BaseSceneModule;
import com.autonavi.gbl.scene.dynamic.impl.IDynamicLayerModuleImpl;
import com.autonavi.gbl.scene.model.ScreenParam;
import com.autonavi.gbl.scene.observer.IDisplayObserver;
import com.autonavi.gbl.scene.observer.IScreenParamAdapter;
import com.autonavi.gbl.scene.observer.impl.IDisplayObserverImpl;
import com.autonavi.gbl.scene.observer.impl.IScreenParamAdapterImpl;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = IDynamicLayerModuleImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class DynamicLayerModule extends BaseSceneModule {
    private static String PACKAGE = ReflexTool.PN(DynamicLayerModule.class);
    private IDynamicLayerModuleImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected DynamicLayerModule(long j, boolean z) {
        this(new IDynamicLayerModuleImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(DynamicLayerModule.class, this, this.mControl);
        }
    }

    public DynamicLayerModule(IDynamicLayerModuleImpl iDynamicLayerModuleImpl) {
        super(iDynamicLayerModuleImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iDynamicLayerModuleImpl);
    }

    private void $constructor(IDynamicLayerModuleImpl iDynamicLayerModuleImpl) {
        if (iDynamicLayerModuleImpl != null) {
            this.mControl = iDynamicLayerModuleImpl;
            this.mTargetId = String.format("DynamicLayerModule_%s_%d", String.valueOf(IDynamicLayerModuleImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.scene.BaseSceneModule
    public IDynamicLayerModuleImpl getControl() {
        return this.mControl;
    }

    public void setScreenParamAdapter(IScreenParamAdapter iScreenParamAdapter) {
        TypeHelper typeHelper;
        try {
            Method method = DynamicLayerModule.class.getMethod("setScreenParamAdapter", IScreenParamAdapter.class);
            IScreenParamAdapterImpl iScreenParamAdapterImpl = null;
            if (iScreenParamAdapter != null && (typeHelper = this.mTypeHelper) != null) {
                iScreenParamAdapterImpl = (IScreenParamAdapterImpl) typeHelper.transfer(method, 0, iScreenParamAdapter);
            }
            IDynamicLayerModuleImpl iDynamicLayerModuleImpl = this.mControl;
            if (iDynamicLayerModuleImpl != null) {
                iDynamicLayerModuleImpl.setScreenParamAdapter(iScreenParamAdapterImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public boolean updateScreenParam(ScreenParam screenParam) {
        IDynamicLayerModuleImpl iDynamicLayerModuleImpl = this.mControl;
        if (iDynamicLayerModuleImpl != null) {
            return iDynamicLayerModuleImpl.updateScreenParam(screenParam);
        }
        return false;
    }

    public boolean addDisplayObserver(IDisplayObserver iDisplayObserver) {
        TypeHelper typeHelper;
        try {
            Method method = DynamicLayerModule.class.getMethod("addDisplayObserver", IDisplayObserver.class);
            IDisplayObserverImpl iDisplayObserverImpl = null;
            if (iDisplayObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iDisplayObserverImpl = (IDisplayObserverImpl) typeHelper.transfer(method, 0, iDisplayObserver);
            }
            IDynamicLayerModuleImpl iDynamicLayerModuleImpl = this.mControl;
            if (iDynamicLayerModuleImpl != null) {
                return iDynamicLayerModuleImpl.addDisplayObserver(iDisplayObserverImpl);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeDisplayObserver(IDisplayObserver iDisplayObserver) {
        TypeHelper typeHelper;
        try {
            Method method = DynamicLayerModule.class.getMethod("removeDisplayObserver", IDisplayObserver.class);
            IDisplayObserverImpl iDisplayObserverImpl = null;
            if (iDisplayObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iDisplayObserverImpl = (IDisplayObserverImpl) typeHelper.transfer(method, 0, iDisplayObserver);
            }
            IDynamicLayerModuleImpl iDynamicLayerModuleImpl = this.mControl;
            if (iDynamicLayerModuleImpl != null) {
                boolean removeDisplayObserver = iDynamicLayerModuleImpl.removeDisplayObserver(iDisplayObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iDisplayObserver);
                }
                return removeDisplayObserver;
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
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
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.scene.observer.IDisplayObserver")).iterator();
            while (it.hasNext()) {
                removeDisplayObserver((IDisplayObserver) it.next());
            }
        }
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
