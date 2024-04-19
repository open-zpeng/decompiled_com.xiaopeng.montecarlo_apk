package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.RouteIndoorParkEndLayerItemImpl;
import com.autonavi.gbl.layer.observer.IRouteIndoorParkEndLayerItem;
import com.autonavi.gbl.layer.router.RouteIndoorParkEndLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = RouteIndoorParkEndLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class RouteIndoorParkEndLayerItem extends PointLayerItem implements IRouteIndoorParkEndLayerItem {
    private static String PACKAGE = ReflexTool.PN(RouteIndoorParkEndLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private RouteIndoorParkEndLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected RouteIndoorParkEndLayerItem(long j, boolean z) {
        this(new RouteIndoorParkEndLayerItemRouter("RouteIndoorParkEndLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRouteIndoorParkEndLayerItem.class}, new Object[]{this});
    }

    public RouteIndoorParkEndLayerItem() {
        this(new RouteIndoorParkEndLayerItemRouter("RouteIndoorParkEndLayerItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRouteIndoorParkEndLayerItem.class}, new Object[]{this});
    }

    public RouteIndoorParkEndLayerItem(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl) {
        super(routeIndoorParkEndLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(routeIndoorParkEndLayerItemImpl);
    }

    private void $constructor(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl) {
        if (routeIndoorParkEndLayerItemImpl != null) {
            this.mService = routeIndoorParkEndLayerItemImpl;
            this.mTargetId = String.format("RouteIndoorParkEndLayerItem_%s_%d", String.valueOf(RouteIndoorParkEndLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public RouteIndoorParkEndLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.RouteIndoorParkEndLayerItem.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.RouteIndoorParkEndLayerItem.2
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
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.RouteIndoorParkEndLayerItem.3
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
        return RouteIndoorParkEndLayerItemImpl.getClassTypeName();
    }

    public void setFloorNumber(int i) {
        RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl = this.mService;
        if (routeIndoorParkEndLayerItemImpl != null) {
            routeIndoorParkEndLayerItemImpl.$explicit_setFloorNumber(i);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IRouteIndoorParkEndLayerItem
    public int getFloorNumber() {
        RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl = this.mService;
        if (routeIndoorParkEndLayerItemImpl != null) {
            return routeIndoorParkEndLayerItemImpl.$explicit_getFloorNumber();
        }
        return 0;
    }
}
