package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.RouteIndoorParkLayerItemImpl;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.observer.IRouteIndoorParkLayerItem;
import com.autonavi.gbl.layer.router.RouteIndoorParkLayerItemRouter;
import com.autonavi.gbl.map.layer.QuadrantLayerItem;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(target = RouteIndoorParkLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class RouteIndoorParkLayerItem extends QuadrantLayerItem implements IRouteIndoorParkLayerItem {
    private static String PACKAGE = ReflexTool.PN(RouteIndoorParkLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private RouteIndoorParkLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected RouteIndoorParkLayerItem(long j, boolean z) {
        this(new RouteIndoorParkLayerItemRouter("RouteIndoorParkLayerItem", (IRouteIndoorParkLayerItem) null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRouteIndoorParkLayerItem.class}, new Object[]{this});
    }

    public RouteIndoorParkLayerItem(@QuadrantType.QuadrantType1 int i, long j) {
        this(new RouteIndoorParkLayerItemRouter("RouteIndoorParkLayerItem", (IRouteIndoorParkLayerItem) null, i, j));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRouteIndoorParkLayerItem.class}, new Object[]{this});
    }

    public RouteIndoorParkLayerItem(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        super(routeIndoorParkLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(routeIndoorParkLayerItemImpl);
    }

    private void $constructor(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        if (routeIndoorParkLayerItemImpl != null) {
            this.mService = routeIndoorParkLayerItemImpl;
            this.mTargetId = String.format("RouteIndoorParkLayerItem_%s_%d", String.valueOf(RouteIndoorParkLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public RouteIndoorParkLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.RouteIndoorParkLayerItem.1
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
    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.RouteIndoorParkLayerItem.2
        }));
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public synchronized void delete() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.RouteIndoorParkLayerItem.3
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
        return RouteIndoorParkLayerItemImpl.getClassTypeName();
    }

    public void setToFloorNumber(int i) {
        RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl = this.mService;
        if (routeIndoorParkLayerItemImpl != null) {
            routeIndoorParkLayerItemImpl.$explicit_setToFloorNumber(i);
        }
    }

    public void setCurFloorNumber(int i) {
        RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl = this.mService;
        if (routeIndoorParkLayerItemImpl != null) {
            routeIndoorParkLayerItemImpl.$explicit_setCurFloorNumber(i);
        }
    }

    public void setIsUpstairs(boolean z) {
        RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl = this.mService;
        if (routeIndoorParkLayerItemImpl != null) {
            routeIndoorParkLayerItemImpl.$explicit_setIsUpstairs(z);
        }
    }

    public void setBoardStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl = this.mService;
        if (routeIndoorParkLayerItemImpl != null) {
            routeIndoorParkLayerItemImpl.$explicit_setBoardStyle(i);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IRouteIndoorParkLayerItem
    public int getToFloorNumber() {
        RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl = this.mService;
        if (routeIndoorParkLayerItemImpl != null) {
            return routeIndoorParkLayerItemImpl.$explicit_getToFloorNumber();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.IRouteIndoorParkLayerItem
    public int getCurFloorNumber() {
        RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl = this.mService;
        if (routeIndoorParkLayerItemImpl != null) {
            return routeIndoorParkLayerItemImpl.$explicit_getCurFloorNumber();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.IRouteIndoorParkLayerItem
    public boolean getIsUpstairs() {
        RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl = this.mService;
        if (routeIndoorParkLayerItemImpl != null) {
            return routeIndoorParkLayerItemImpl.$explicit_getIsUpstairs();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.IRouteIndoorParkLayerItem
    @BizDirectionStyle.BizDirectionStyle1
    public int getBoardStyle() {
        RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl = this.mService;
        if (routeIndoorParkLayerItemImpl != null) {
            return routeIndoorParkLayerItemImpl.$explicit_getBoardStyle();
        }
        return Integer.MIN_VALUE;
    }
}
