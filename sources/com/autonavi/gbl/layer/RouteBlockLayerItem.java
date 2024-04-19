package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.path.model.EventCloudControl;
import com.autonavi.gbl.layer.impl.RouteBlockLayerItemImpl;
import com.autonavi.gbl.layer.observer.IRouteBlockLayerItem;
import com.autonavi.gbl.layer.router.RouteBlockLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = RouteBlockLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class RouteBlockLayerItem extends PointLayerItem implements IRouteBlockLayerItem {
    private static String PACKAGE = ReflexTool.PN(RouteBlockLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private RouteBlockLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected RouteBlockLayerItem(long j, boolean z) {
        this(new RouteBlockLayerItemRouter("RouteBlockLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRouteBlockLayerItem.class}, new Object[]{this});
    }

    public RouteBlockLayerItem(EventCloudControl eventCloudControl) {
        this(new RouteBlockLayerItemRouter("RouteBlockLayerItem", null, eventCloudControl));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRouteBlockLayerItem.class}, new Object[]{this});
    }

    public RouteBlockLayerItem(RouteBlockLayerItemImpl routeBlockLayerItemImpl) {
        super(routeBlockLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(routeBlockLayerItemImpl);
    }

    private void $constructor(RouteBlockLayerItemImpl routeBlockLayerItemImpl) {
        if (routeBlockLayerItemImpl != null) {
            this.mService = routeBlockLayerItemImpl;
            this.mTargetId = String.format("RouteBlockLayerItem_%s_%d", String.valueOf(RouteBlockLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public RouteBlockLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.RouteBlockLayerItem.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.RouteBlockLayerItem.2
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
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.RouteBlockLayerItem.3
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
        return RouteBlockLayerItemImpl.getClassTypeName();
    }

    public void setMEventCloud(EventCloudControl eventCloudControl) {
        RouteBlockLayerItemImpl routeBlockLayerItemImpl = this.mService;
        if (routeBlockLayerItemImpl != null) {
            routeBlockLayerItemImpl.$explicit_setMEventCloud(eventCloudControl);
        }
    }

    public void setMbEnableCollision(boolean z) {
        RouteBlockLayerItemImpl routeBlockLayerItemImpl = this.mService;
        if (routeBlockLayerItemImpl != null) {
            routeBlockLayerItemImpl.$explicit_setMbEnableCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem, com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.observer.ICollisionItem, com.autonavi.gbl.layer.observer.IRouteBlockLayerItem
    public void onVisible(boolean z) {
        RouteBlockLayerItemImpl routeBlockLayerItemImpl = this.mService;
        if (routeBlockLayerItemImpl != null) {
            routeBlockLayerItemImpl.$explicit_onVisible(z);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IRouteBlockLayerItem
    public EventCloudControl getMEventCloud() {
        RouteBlockLayerItemImpl routeBlockLayerItemImpl = this.mService;
        if (routeBlockLayerItemImpl != null) {
            return routeBlockLayerItemImpl.$explicit_getMEventCloud();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.IRouteBlockLayerItem
    public boolean getMbEnableCollision() {
        RouteBlockLayerItemImpl routeBlockLayerItemImpl = this.mService;
        if (routeBlockLayerItemImpl != null) {
            return routeBlockLayerItemImpl.$explicit_getMbEnableCollision();
        }
        return false;
    }
}
