package com.autonavi.gbl.scene.dynamic;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.scene.BaseSceneModule;
import com.autonavi.gbl.scene.dynamic.impl.IDynamicTipsModuleImpl;
import com.autonavi.gbl.scene.model.ScreenParam;
import com.autonavi.gbl.scene.observer.IDisplayObserver;
import com.autonavi.gbl.scene.observer.IScreenParamAdapter;
import com.autonavi.gbl.scene.observer.impl.IDisplayObserverImpl;
import com.autonavi.gbl.scene.observer.impl.IScreenParamAdapterImpl;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = IDynamicTipsModuleImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class DynamicTipsModule extends BaseSceneModule {
    private static String PACKAGE = ReflexTool.PN(DynamicTipsModule.class);
    private IDynamicTipsModuleImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected DynamicTipsModule(long j, boolean z) {
        this(new IDynamicTipsModuleImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(DynamicTipsModule.class, this, this.mControl);
        }
    }

    public DynamicTipsModule(IDynamicTipsModuleImpl iDynamicTipsModuleImpl) {
        super(iDynamicTipsModuleImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iDynamicTipsModuleImpl);
    }

    private void $constructor(IDynamicTipsModuleImpl iDynamicTipsModuleImpl) {
        if (iDynamicTipsModuleImpl != null) {
            this.mControl = iDynamicTipsModuleImpl;
            this.mTargetId = String.format("DynamicTipsModule_%s_%d", String.valueOf(IDynamicTipsModuleImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.scene.BaseSceneModule
    public IDynamicTipsModuleImpl getControl() {
        return this.mControl;
    }

    public void setScreenParamAdapter(IScreenParamAdapter iScreenParamAdapter) {
        TypeHelper typeHelper;
        try {
            Method method = DynamicTipsModule.class.getMethod("setScreenParamAdapter", IScreenParamAdapter.class);
            IScreenParamAdapterImpl iScreenParamAdapterImpl = null;
            if (iScreenParamAdapter != null && (typeHelper = this.mTypeHelper) != null) {
                iScreenParamAdapterImpl = (IScreenParamAdapterImpl) typeHelper.transfer(method, 0, iScreenParamAdapter);
            }
            IDynamicTipsModuleImpl iDynamicTipsModuleImpl = this.mControl;
            if (iDynamicTipsModuleImpl != null) {
                iDynamicTipsModuleImpl.setScreenParamAdapter(iScreenParamAdapterImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public boolean updateScreenParam(ScreenParam screenParam) {
        IDynamicTipsModuleImpl iDynamicTipsModuleImpl = this.mControl;
        if (iDynamicTipsModuleImpl != null) {
            return iDynamicTipsModuleImpl.updateScreenParam(screenParam);
        }
        return false;
    }

    public boolean addDisplayObserver(IDisplayObserver iDisplayObserver) {
        TypeHelper typeHelper;
        try {
            Method method = DynamicTipsModule.class.getMethod("addDisplayObserver", IDisplayObserver.class);
            IDisplayObserverImpl iDisplayObserverImpl = null;
            if (iDisplayObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iDisplayObserverImpl = (IDisplayObserverImpl) typeHelper.transfer(method, 0, iDisplayObserver);
            }
            IDynamicTipsModuleImpl iDynamicTipsModuleImpl = this.mControl;
            if (iDynamicTipsModuleImpl != null) {
                return iDynamicTipsModuleImpl.addDisplayObserver(iDisplayObserverImpl);
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
            Method method = DynamicTipsModule.class.getMethod("removeDisplayObserver", IDisplayObserver.class);
            IDisplayObserverImpl iDisplayObserverImpl = null;
            if (iDisplayObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iDisplayObserverImpl = (IDisplayObserverImpl) typeHelper.transfer(method, 0, iDisplayObserver);
            }
            IDynamicTipsModuleImpl iDynamicTipsModuleImpl = this.mControl;
            if (iDynamicTipsModuleImpl != null) {
                boolean removeDisplayObserver = iDynamicTipsModuleImpl.removeDisplayObserver(iDisplayObserverImpl);
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
