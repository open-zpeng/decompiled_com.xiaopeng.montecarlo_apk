package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.path.model.AvoidJamCloudControl;
import com.autonavi.gbl.layer.impl.RouteJamPointLayerItemImpl;
import com.autonavi.gbl.layer.observer.IRouteJamPointLayerItem;
import com.autonavi.gbl.layer.router.RouteJamPointLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = RouteJamPointLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class RouteJamPointLayerItem extends PointLayerItem implements IRouteJamPointLayerItem {
    private static String PACKAGE = ReflexTool.PN(RouteJamPointLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private RouteJamPointLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected RouteJamPointLayerItem(long j, boolean z) {
        this(new RouteJamPointLayerItemRouter("RouteJamPointLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRouteJamPointLayerItem.class}, new Object[]{this});
    }

    public RouteJamPointLayerItem(AvoidJamCloudControl avoidJamCloudControl) {
        this(new RouteJamPointLayerItemRouter("RouteJamPointLayerItem", null, avoidJamCloudControl));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRouteJamPointLayerItem.class}, new Object[]{this});
    }

    public RouteJamPointLayerItem(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl) {
        super(routeJamPointLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(routeJamPointLayerItemImpl);
    }

    private void $constructor(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl) {
        if (routeJamPointLayerItemImpl != null) {
            this.mService = routeJamPointLayerItemImpl;
            this.mTargetId = String.format("RouteJamPointLayerItem_%s_%d", String.valueOf(RouteJamPointLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public RouteJamPointLayerItemImpl getService() {
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
        return RouteJamPointLayerItemImpl.getClassTypeName();
    }

    public void setMAvoidJamCloud(AvoidJamCloudControl avoidJamCloudControl) {
        RouteJamPointLayerItemImpl routeJamPointLayerItemImpl = this.mService;
        if (routeJamPointLayerItemImpl != null) {
            routeJamPointLayerItemImpl.$explicit_setMAvoidJamCloud(avoidJamCloudControl);
        }
    }

    public void setMbEnableCollision(boolean z) {
        RouteJamPointLayerItemImpl routeJamPointLayerItemImpl = this.mService;
        if (routeJamPointLayerItemImpl != null) {
            routeJamPointLayerItemImpl.$explicit_setMbEnableCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem, com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.observer.ICollisionItem, com.autonavi.gbl.layer.observer.ILaneGuideCongestionLayerItem
    public void onVisible(boolean z) {
        RouteJamPointLayerItemImpl routeJamPointLayerItemImpl = this.mService;
        if (routeJamPointLayerItemImpl != null) {
            routeJamPointLayerItemImpl.$explicit_onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IRouteJamPointLayerItem
    public AvoidJamCloudControl getMAvoidJamCloud() {
        RouteJamPointLayerItemImpl routeJamPointLayerItemImpl = this.mService;
        if (routeJamPointLayerItemImpl != null) {
            return routeJamPointLayerItemImpl.$explicit_getMAvoidJamCloud();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.IRouteJamPointLayerItem
    public boolean getMbEnableCollision() {
        RouteJamPointLayerItemImpl routeJamPointLayerItemImpl = this.mService;
        if (routeJamPointLayerItemImpl != null) {
            return routeJamPointLayerItemImpl.$explicit_getMbEnableCollision();
        }
        return false;
    }
}
