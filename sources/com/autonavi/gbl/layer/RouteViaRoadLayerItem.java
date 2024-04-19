package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.path.model.ViaRoadInfo;
import com.autonavi.gbl.layer.impl.RouteViaRoadLayerItemImpl;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.observer.IRouteViaRoadLayerItem;
import com.autonavi.gbl.layer.router.RouteViaRoadLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = RouteViaRoadLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class RouteViaRoadLayerItem extends PointLayerItem implements IRouteViaRoadLayerItem {
    private static String PACKAGE = ReflexTool.PN(RouteViaRoadLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private RouteViaRoadLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected RouteViaRoadLayerItem(long j, boolean z) {
        this(new RouteViaRoadLayerItemRouter("RouteViaRoadLayerItem", (IRouteViaRoadLayerItem) null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRouteViaRoadLayerItem.class}, new Object[]{this});
    }

    public RouteViaRoadLayerItem(ViaRoadInfo viaRoadInfo, @BizDirectionStyle.BizDirectionStyle1 int i) {
        this(new RouteViaRoadLayerItemRouter("RouteViaRoadLayerItem", (IRouteViaRoadLayerItem) null, viaRoadInfo, i));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRouteViaRoadLayerItem.class}, new Object[]{this});
    }

    public RouteViaRoadLayerItem(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl) {
        super(routeViaRoadLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(routeViaRoadLayerItemImpl);
    }

    private void $constructor(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl) {
        if (routeViaRoadLayerItemImpl != null) {
            this.mService = routeViaRoadLayerItemImpl;
            this.mTargetId = String.format("RouteViaRoadLayerItem_%s_%d", String.valueOf(RouteViaRoadLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public RouteViaRoadLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.RouteViaRoadLayerItem.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.RouteViaRoadLayerItem.2
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
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.RouteViaRoadLayerItem.3
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
        return RouteViaRoadLayerItemImpl.getClassTypeName();
    }

    public void setMViaRoadInfo(ViaRoadInfo viaRoadInfo) {
        RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl = this.mService;
        if (routeViaRoadLayerItemImpl != null) {
            routeViaRoadLayerItemImpl.$explicit_setMViaRoadInfo(viaRoadInfo);
        }
    }

    public void setMDirectionStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl = this.mService;
        if (routeViaRoadLayerItemImpl != null) {
            routeViaRoadLayerItemImpl.$explicit_setMDirectionStyle(i);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IRouteViaRoadLayerItem
    public ViaRoadInfo getMViaRoadInfo() {
        RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl = this.mService;
        if (routeViaRoadLayerItemImpl != null) {
            return routeViaRoadLayerItemImpl.$explicit_getMViaRoadInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.IRouteViaRoadLayerItem
    @BizDirectionStyle.BizDirectionStyle1
    public int getMDirectionStyle() {
        RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl = this.mService;
        if (routeViaRoadLayerItemImpl != null) {
            return routeViaRoadLayerItemImpl.$explicit_getMDirectionStyle();
        }
        return Integer.MIN_VALUE;
    }
}
