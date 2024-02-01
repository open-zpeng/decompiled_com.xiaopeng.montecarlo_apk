package com.autonavi.gbl.scene.navi;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.path.option.RouteOption;
import com.autonavi.gbl.common.path.option.impl.IRouteOptionImpl;
import com.autonavi.gbl.scene.BaseSceneModule;
import com.autonavi.gbl.scene.navi.impl.INaviModuleImpl;
import com.autonavi.gbl.search.model.SearchPoiBase;
import com.autonavi.gbl.user.msgpush.model.AimRoutePushMsg;
import java.lang.reflect.Method;
@IntfAuto(target = INaviModuleImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class NaviModule extends BaseSceneModule {
    private static String PACKAGE = ReflexTool.PN(NaviModule.class);
    private INaviModuleImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected NaviModule(long j, boolean z) {
        this(new INaviModuleImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(NaviModule.class, this, this.mControl);
        }
    }

    public NaviModule(INaviModuleImpl iNaviModuleImpl) {
        super(iNaviModuleImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iNaviModuleImpl);
    }

    private void $constructor(INaviModuleImpl iNaviModuleImpl) {
        if (iNaviModuleImpl != null) {
            this.mControl = iNaviModuleImpl;
            this.mTargetId = String.format("NaviModule_%s_%d", String.valueOf(INaviModuleImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.scene.BaseSceneModule
    public INaviModuleImpl getControl() {
        return this.mControl;
    }

    public int init() {
        INaviModuleImpl iNaviModuleImpl = this.mControl;
        if (iNaviModuleImpl != null) {
            return iNaviModuleImpl.init();
        }
        return Integer.MIN_VALUE;
    }

    public long requestRouteRestoration(AimRoutePushMsg aimRoutePushMsg) {
        INaviModuleImpl iNaviModuleImpl = this.mControl;
        if (iNaviModuleImpl != null) {
            return iNaviModuleImpl.requestRouteRestoration(aimRoutePushMsg);
        }
        return 0L;
    }

    public long requestRouteToSearchPoi(SearchPoiBase searchPoiBase, RouteOption routeOption) {
        TypeHelper typeHelper;
        try {
            Method method = NaviModule.class.getMethod("requestRouteToSearchPoi", SearchPoiBase.class, RouteOption.class);
            IRouteOptionImpl iRouteOptionImpl = null;
            if (routeOption != null && (typeHelper = this.mTypeHelper) != null) {
                iRouteOptionImpl = (IRouteOptionImpl) typeHelper.transfer(method, 1, routeOption);
            }
            INaviModuleImpl iNaviModuleImpl = this.mControl;
            if (iNaviModuleImpl != null) {
                return iNaviModuleImpl.requestRouteToSearchPoi(searchPoiBase, iRouteOptionImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
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
