package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.path.model.AvoidJamCloudControl;
import com.autonavi.gbl.layer.impl.RouteJamLineLayerItemImpl;
import com.autonavi.gbl.layer.observer.IRouteJamLineLayerItem;
import com.autonavi.gbl.layer.router.RouteJamLineLayerItemRouter;
import com.autonavi.gbl.map.layer.LineLayerItem;
@IntfAuto(target = RouteJamLineLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class RouteJamLineLayerItem extends LineLayerItem implements IRouteJamLineLayerItem {
    private static String PACKAGE = ReflexTool.PN(RouteJamLineLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private RouteJamLineLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected RouteJamLineLayerItem(long j, boolean z) {
        this(new RouteJamLineLayerItemRouter("RouteJamLineLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRouteJamLineLayerItem.class}, new Object[]{this});
    }

    public RouteJamLineLayerItem(AvoidJamCloudControl avoidJamCloudControl) {
        this(new RouteJamLineLayerItemRouter("RouteJamLineLayerItem", null, avoidJamCloudControl));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRouteJamLineLayerItem.class}, new Object[]{this});
    }

    public RouteJamLineLayerItem(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl) {
        super(routeJamLineLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(routeJamLineLayerItemImpl);
    }

    private void $constructor(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl) {
        if (routeJamLineLayerItemImpl != null) {
            this.mService = routeJamLineLayerItemImpl;
            this.mTargetId = String.format("RouteJamLineLayerItem_%s_%d", String.valueOf(RouteJamLineLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.LineLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public RouteJamLineLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.LineLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
        super.unbind();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.LineLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void clean() {
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.LineLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.LineLayerItem, com.autonavi.gbl.map.layer.LayerItem
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
        return RouteJamLineLayerItemImpl.getClassTypeName();
    }

    public void setMAvoidJamCloud(AvoidJamCloudControl avoidJamCloudControl) {
        RouteJamLineLayerItemImpl routeJamLineLayerItemImpl = this.mService;
        if (routeJamLineLayerItemImpl != null) {
            routeJamLineLayerItemImpl.$explicit_setMAvoidJamCloud(avoidJamCloudControl);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IRouteJamLineLayerItem
    public AvoidJamCloudControl getMAvoidJamCloud() {
        RouteJamLineLayerItemImpl routeJamLineLayerItemImpl = this.mService;
        if (routeJamLineLayerItemImpl != null) {
            return routeJamLineLayerItemImpl.$explicit_getMAvoidJamCloud();
        }
        return null;
    }
}
