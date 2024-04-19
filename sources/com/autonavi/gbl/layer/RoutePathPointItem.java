package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.RoutePathPointItemImpl;
import com.autonavi.gbl.layer.model.BizRouteMapMode;
import com.autonavi.gbl.layer.observer.IRoutePathPointItem;
import com.autonavi.gbl.layer.router.RoutePathPointItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
import com.autonavi.gbl.map.layer.model.PathPointType;
import com.autonavi.gbl.map.layer.model.RouteLayerScene;
@IntfAuto(target = RoutePathPointItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class RoutePathPointItem extends PointLayerItem implements IRoutePathPointItem {
    private static String PACKAGE = ReflexTool.PN(RoutePathPointItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private RoutePathPointItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected RoutePathPointItem(long j, boolean z) {
        this(new RoutePathPointItemRouter("RoutePathPointItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRoutePathPointItem.class}, new Object[]{this});
    }

    public RoutePathPointItem() {
        this(new RoutePathPointItemRouter("RoutePathPointItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRoutePathPointItem.class}, new Object[]{this});
    }

    public RoutePathPointItem(RoutePathPointItemImpl routePathPointItemImpl) {
        super(routePathPointItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(routePathPointItemImpl);
    }

    private void $constructor(RoutePathPointItemImpl routePathPointItemImpl) {
        if (routePathPointItemImpl != null) {
            this.mService = routePathPointItemImpl;
            this.mTargetId = String.format("RoutePathPointItem_%s_%d", String.valueOf(RoutePathPointItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public RoutePathPointItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.RoutePathPointItem.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.RoutePathPointItem.2
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
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.RoutePathPointItem.3
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
        return RoutePathPointItemImpl.getClassTypeName();
    }

    public void setMIsNavi(boolean z) {
        RoutePathPointItemImpl routePathPointItemImpl = this.mService;
        if (routePathPointItemImpl != null) {
            routePathPointItemImpl.$explicit_setMIsNavi(z);
        }
    }

    public void setIsInEndFloor(boolean z) {
        RoutePathPointItemImpl routePathPointItemImpl = this.mService;
        if (routePathPointItemImpl != null) {
            routePathPointItemImpl.$explicit_setIsInEndFloor(z);
        }
    }

    public void setMMode(@BizRouteMapMode.BizRouteMapMode1 int i) {
        RoutePathPointItemImpl routePathPointItemImpl = this.mService;
        if (routePathPointItemImpl != null) {
            routePathPointItemImpl.$explicit_setMMode(i);
        }
    }

    public void setMScene(@RouteLayerScene.RouteLayerScene1 int i) {
        RoutePathPointItemImpl routePathPointItemImpl = this.mService;
        if (routePathPointItemImpl != null) {
            routePathPointItemImpl.$explicit_setMScene(i);
        }
    }

    public void setMType(@PathPointType.PathPointType1 int i) {
        RoutePathPointItemImpl routePathPointItemImpl = this.mService;
        if (routePathPointItemImpl != null) {
            routePathPointItemImpl.$explicit_setMType(i);
        }
    }

    public void setMLeftEnergy(int i) {
        RoutePathPointItemImpl routePathPointItemImpl = this.mService;
        if (routePathPointItemImpl != null) {
            routePathPointItemImpl.$explicit_setMLeftEnergy(i);
        }
    }

    public void setMTotalCount(int i) {
        RoutePathPointItemImpl routePathPointItemImpl = this.mService;
        if (routePathPointItemImpl != null) {
            routePathPointItemImpl.$explicit_setMTotalCount(i);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IRoutePathPointItem
    public boolean getMIsNavi() {
        RoutePathPointItemImpl routePathPointItemImpl = this.mService;
        if (routePathPointItemImpl != null) {
            return routePathPointItemImpl.$explicit_getMIsNavi();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.IRoutePathPointItem
    public boolean getIsInEndFloor() {
        RoutePathPointItemImpl routePathPointItemImpl = this.mService;
        if (routePathPointItemImpl != null) {
            return routePathPointItemImpl.$explicit_getIsInEndFloor();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.IRoutePathPointItem
    @BizRouteMapMode.BizRouteMapMode1
    public int getMMode() {
        RoutePathPointItemImpl routePathPointItemImpl = this.mService;
        if (routePathPointItemImpl != null) {
            return routePathPointItemImpl.$explicit_getMMode();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.IRoutePathPointItem
    @RouteLayerScene.RouteLayerScene1
    public int getMScene() {
        RoutePathPointItemImpl routePathPointItemImpl = this.mService;
        if (routePathPointItemImpl != null) {
            return routePathPointItemImpl.$explicit_getMScene();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.IRoutePathPointItem
    @PathPointType.PathPointType1
    public int getMType() {
        RoutePathPointItemImpl routePathPointItemImpl = this.mService;
        if (routePathPointItemImpl != null) {
            return routePathPointItemImpl.$explicit_getMType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.IRoutePathPointItem
    public int getMLeftEnergy() {
        RoutePathPointItemImpl routePathPointItemImpl = this.mService;
        if (routePathPointItemImpl != null) {
            return routePathPointItemImpl.$explicit_getMLeftEnergy();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.IRoutePathPointItem
    public int getMTotalCount() {
        RoutePathPointItemImpl routePathPointItemImpl = this.mService;
        if (routePathPointItemImpl != null) {
            return routePathPointItemImpl.$explicit_getMTotalCount();
        }
        return 0;
    }
}
