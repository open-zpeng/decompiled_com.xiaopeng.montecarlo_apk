package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.path.model.RestAreaInfo;
import com.autonavi.gbl.layer.impl.RouteRestAreaLayerItemImpl;
import com.autonavi.gbl.layer.observer.IRouteRestAreaLayerItem;
import com.autonavi.gbl.layer.router.RouteRestAreaLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = RouteRestAreaLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class RouteRestAreaLayerItem extends PointLayerItem implements IRouteRestAreaLayerItem {
    private static String PACKAGE = ReflexTool.PN(RouteRestAreaLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private RouteRestAreaLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected RouteRestAreaLayerItem(long j, boolean z) {
        this(new RouteRestAreaLayerItemRouter("RouteRestAreaLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRouteRestAreaLayerItem.class}, new Object[]{this});
    }

    public RouteRestAreaLayerItem(RestAreaInfo restAreaInfo) {
        this(new RouteRestAreaLayerItemRouter("RouteRestAreaLayerItem", null, restAreaInfo));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRouteRestAreaLayerItem.class}, new Object[]{this});
    }

    public RouteRestAreaLayerItem(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl) {
        super(routeRestAreaLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(routeRestAreaLayerItemImpl);
    }

    private void $constructor(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl) {
        if (routeRestAreaLayerItemImpl != null) {
            this.mService = routeRestAreaLayerItemImpl;
            this.mTargetId = String.format("RouteRestAreaLayerItem_%s_%d", String.valueOf(RouteRestAreaLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public RouteRestAreaLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
        super.unbind();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void clean() {
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public synchronized void delete() {
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mService != null) {
            if (this.mTypeHelper != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                TypeHelper.unbindAllTarget(ReflexTool.PN(this.mService.getClass()), this.mService);
            }
            this.mService = null;
        }
        unbind();
    }

    public static String getClassTypeName() {
        return RouteRestAreaLayerItemImpl.getClassTypeName();
    }

    public void setMRestAreaInfo(RestAreaInfo restAreaInfo) {
        RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl = this.mService;
        if (routeRestAreaLayerItemImpl != null) {
            routeRestAreaLayerItemImpl.$explicit_setMRestAreaInfo(restAreaInfo);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IRouteRestAreaLayerItem
    public RestAreaInfo getMRestAreaInfo() {
        RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl = this.mService;
        if (routeRestAreaLayerItemImpl != null) {
            return routeRestAreaLayerItemImpl.$explicit_getMRestAreaInfo();
        }
        return null;
    }
}
