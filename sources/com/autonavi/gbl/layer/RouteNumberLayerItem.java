package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.RouteNumberLayerItemImpl;
import com.autonavi.gbl.layer.observer.IRouteNumberLayerItem;
import com.autonavi.gbl.layer.router.RouteNumberLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = RouteNumberLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class RouteNumberLayerItem extends PointLayerItem implements IRouteNumberLayerItem {
    private static String PACKAGE = ReflexTool.PN(RouteNumberLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private RouteNumberLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected RouteNumberLayerItem(long j, boolean z) {
        this(new RouteNumberLayerItemRouter("RouteNumberLayerItem", (IRouteNumberLayerItem) null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRouteNumberLayerItem.class}, new Object[]{this});
    }

    public RouteNumberLayerItem(boolean z, int i) {
        this(new RouteNumberLayerItemRouter("RouteNumberLayerItem", (IRouteNumberLayerItem) null, z, i));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRouteNumberLayerItem.class}, new Object[]{this});
    }

    public RouteNumberLayerItem(RouteNumberLayerItemImpl routeNumberLayerItemImpl) {
        super(routeNumberLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(routeNumberLayerItemImpl);
    }

    private void $constructor(RouteNumberLayerItemImpl routeNumberLayerItemImpl) {
        if (routeNumberLayerItemImpl != null) {
            this.mService = routeNumberLayerItemImpl;
            this.mTargetId = String.format("RouteNumberLayerItem_%s_%d", String.valueOf(RouteNumberLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public RouteNumberLayerItemImpl getService() {
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
        return RouteNumberLayerItemImpl.getClassTypeName();
    }

    public void setIsSelectedPath(boolean z) {
        RouteNumberLayerItemImpl routeNumberLayerItemImpl = this.mService;
        if (routeNumberLayerItemImpl != null) {
            routeNumberLayerItemImpl.$explicit_setIsSelectedPath(z);
        }
    }

    public void setRouteNumberId(int i) {
        RouteNumberLayerItemImpl routeNumberLayerItemImpl = this.mService;
        if (routeNumberLayerItemImpl != null) {
            routeNumberLayerItemImpl.$explicit_setRouteNumberId(i);
        }
    }

    public void setPathID(long j) {
        RouteNumberLayerItemImpl routeNumberLayerItemImpl = this.mService;
        if (routeNumberLayerItemImpl != null) {
            routeNumberLayerItemImpl.$explicit_setPathID(j);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IRouteNumberLayerItem
    public boolean getIsSelectedPath() {
        RouteNumberLayerItemImpl routeNumberLayerItemImpl = this.mService;
        if (routeNumberLayerItemImpl != null) {
            return routeNumberLayerItemImpl.$explicit_getIsSelectedPath();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.IRouteNumberLayerItem
    public int getRouteNumberId() {
        RouteNumberLayerItemImpl routeNumberLayerItemImpl = this.mService;
        if (routeNumberLayerItemImpl != null) {
            return routeNumberLayerItemImpl.$explicit_getRouteNumberId();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.IRouteNumberLayerItem
    public long getPathID() {
        RouteNumberLayerItemImpl routeNumberLayerItemImpl = this.mService;
        if (routeNumberLayerItemImpl != null) {
            return routeNumberLayerItemImpl.$explicit_getPathID();
        }
        return 0L;
    }
}
