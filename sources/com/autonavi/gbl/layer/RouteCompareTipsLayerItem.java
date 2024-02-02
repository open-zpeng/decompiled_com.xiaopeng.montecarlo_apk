package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.RouteCompareTipsLayerItemImpl;
import com.autonavi.gbl.layer.observer.IRouteCompareTipsLayerItem;
import com.autonavi.gbl.layer.router.RouteCompareTipsLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = RouteCompareTipsLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class RouteCompareTipsLayerItem extends PointLayerItem implements IRouteCompareTipsLayerItem {
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

    public RouteCompareTipsLayerItem(boolean z, String str) {
        this(new RouteCompareTipsLayerItemRouter("RouteCompareTipsLayerItem", (IRouteCompareTipsLayerItem) null, z, str));
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

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public RouteCompareTipsLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.RouteCompareTipsLayerItem.1
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.RouteCompareTipsLayerItem.2
        }));
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public synchronized void delete() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.RouteCompareTipsLayerItem.3
        });
        objArr[1] = String.valueOf(this.mService != null);
        DebugTool.d("%s: mService=%s", objArr);
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

    public void setMIsNewRoute(boolean z) {
        RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl = this.mService;
        if (routeCompareTipsLayerItemImpl != null) {
            routeCompareTipsLayerItemImpl.$explicit_setMIsNewRoute(z);
        }
    }

    public void setMTipName(String str) {
        RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl = this.mService;
        if (routeCompareTipsLayerItemImpl != null) {
            routeCompareTipsLayerItemImpl.$explicit_setMTipName(str);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IRouteCompareTipsLayerItem
    public boolean getMIsNewRoute() {
        RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl = this.mService;
        if (routeCompareTipsLayerItemImpl != null) {
            return routeCompareTipsLayerItemImpl.$explicit_getMIsNewRoute();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.IRouteCompareTipsLayerItem
    public String getMTipName() {
        RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl = this.mService;
        if (routeCompareTipsLayerItemImpl != null) {
            return routeCompareTipsLayerItemImpl.$explicit_getMTipName();
        }
        return null;
    }
}
