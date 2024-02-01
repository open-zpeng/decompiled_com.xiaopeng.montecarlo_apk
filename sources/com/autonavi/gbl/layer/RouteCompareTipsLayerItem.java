package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.RouteCompareTipsLayerItemImpl;
import com.autonavi.gbl.layer.observer.IRouteCompareTipsLayerItem;
import com.autonavi.gbl.layer.router.RouteCompareTipsLayerItemRouter;
import com.autonavi.gbl.map.layer.QuadrantLayerItem;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(target = RouteCompareTipsLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class RouteCompareTipsLayerItem extends QuadrantLayerItem implements IRouteCompareTipsLayerItem {
    private static String PACKAGE = ReflexTool.PN(RouteCompareTipsLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private RouteCompareTipsLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected RouteCompareTipsLayerItem(long j, boolean z) {
        this(new RouteCompareTipsLayerItemRouter("RouteCompareTipsLayerItem", (IRouteCompareTipsLayerItem) null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRouteCompareTipsLayerItem.class}, new Object[]{this});
    }

    public RouteCompareTipsLayerItem(@QuadrantType.QuadrantType1 int i, long j) {
        this(new RouteCompareTipsLayerItemRouter("RouteCompareTipsLayerItem", (IRouteCompareTipsLayerItem) null, i, j));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRouteCompareTipsLayerItem.class}, new Object[]{this});
    }

    public RouteCompareTipsLayerItem(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl) {
        super(routeCompareTipsLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(routeCompareTipsLayerItemImpl);
    }

    private void $constructor(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl) {
        if (routeCompareTipsLayerItemImpl != null) {
            this.mService = routeCompareTipsLayerItemImpl;
            this.mTargetId = String.format("RouteCompareTipsLayerItem_%s_%d", String.valueOf(RouteCompareTipsLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public RouteCompareTipsLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
        super.unbind();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void clean() {
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
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
        return RouteCompareTipsLayerItemImpl.getClassTypeName();
    }

    public void setMLabelContent(String str) {
        RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl = this.mService;
        if (routeCompareTipsLayerItemImpl != null) {
            routeCompareTipsLayerItemImpl.$explicit_setMLabelContent(str);
        }
    }

    public void setMTravelTimeDiff(int i) {
        RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl = this.mService;
        if (routeCompareTipsLayerItemImpl != null) {
            routeCompareTipsLayerItemImpl.$explicit_setMTravelTimeDiff(i);
        }
    }

    public void setMIsFaster(boolean z) {
        RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl = this.mService;
        if (routeCompareTipsLayerItemImpl != null) {
            routeCompareTipsLayerItemImpl.$explicit_setMIsFaster(z);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IRouteCompareTipsLayerItem
    public String getMLabelContent() {
        RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl = this.mService;
        if (routeCompareTipsLayerItemImpl != null) {
            return routeCompareTipsLayerItemImpl.$explicit_getMLabelContent();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.IRouteCompareTipsLayerItem
    public int getMTravelTimeDiff() {
        RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl = this.mService;
        if (routeCompareTipsLayerItemImpl != null) {
            return routeCompareTipsLayerItemImpl.$explicit_getMTravelTimeDiff();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.IRouteCompareTipsLayerItem
    public boolean getMIsFaster() {
        RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl = this.mService;
        if (routeCompareTipsLayerItemImpl != null) {
            return routeCompareTipsLayerItemImpl.$explicit_getMIsFaster();
        }
        return false;
    }
}
