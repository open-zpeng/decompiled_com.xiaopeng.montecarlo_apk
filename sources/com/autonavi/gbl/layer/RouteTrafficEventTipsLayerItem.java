package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.RouteTrafficEventTipsLayerItemImpl;
import com.autonavi.gbl.layer.model.RouteTrafficEventTipsPoint;
import com.autonavi.gbl.layer.observer.IRouteTrafficEventTipsLayerItem;
import com.autonavi.gbl.layer.router.RouteTrafficEventTipsLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = RouteTrafficEventTipsLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class RouteTrafficEventTipsLayerItem extends PointLayerItem implements IRouteTrafficEventTipsLayerItem {
    private static String PACKAGE = ReflexTool.PN(RouteTrafficEventTipsLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private RouteTrafficEventTipsLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected RouteTrafficEventTipsLayerItem(long j, boolean z) {
        this(new RouteTrafficEventTipsLayerItemRouter("RouteTrafficEventTipsLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRouteTrafficEventTipsLayerItem.class}, new Object[]{this});
    }

    public RouteTrafficEventTipsLayerItem(RouteTrafficEventTipsPoint routeTrafficEventTipsPoint) {
        this(new RouteTrafficEventTipsLayerItemRouter("RouteTrafficEventTipsLayerItem", null, routeTrafficEventTipsPoint));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRouteTrafficEventTipsLayerItem.class}, new Object[]{this});
    }

    public RouteTrafficEventTipsLayerItem(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl) {
        super(routeTrafficEventTipsLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(routeTrafficEventTipsLayerItemImpl);
    }

    private void $constructor(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl) {
        if (routeTrafficEventTipsLayerItemImpl != null) {
            this.mService = routeTrafficEventTipsLayerItemImpl;
            this.mTargetId = String.format("RouteTrafficEventTipsLayerItem_%s_%d", String.valueOf(RouteTrafficEventTipsLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public RouteTrafficEventTipsLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.RouteTrafficEventTipsLayerItem.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.RouteTrafficEventTipsLayerItem.2
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
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.RouteTrafficEventTipsLayerItem.3
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
        return RouteTrafficEventTipsLayerItemImpl.getClassTypeName();
    }

    public void setMTrafficEventTipsInfo(RouteTrafficEventTipsPoint routeTrafficEventTipsPoint) {
        RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl = this.mService;
        if (routeTrafficEventTipsLayerItemImpl != null) {
            routeTrafficEventTipsLayerItemImpl.$explicit_setMTrafficEventTipsInfo(routeTrafficEventTipsPoint);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IRouteTrafficEventTipsLayerItem
    public RouteTrafficEventTipsPoint getMTrafficEventTipsInfo() {
        RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl = this.mService;
        if (routeTrafficEventTipsLayerItemImpl != null) {
            return routeTrafficEventTipsLayerItemImpl.$explicit_getMTrafficEventTipsInfo();
        }
        return null;
    }
}
