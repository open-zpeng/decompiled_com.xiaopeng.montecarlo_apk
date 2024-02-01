package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.path.model.JamBubblesSegmentDeepInfo;
import com.autonavi.gbl.layer.impl.RouteJamBubblesLayerItemImpl;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.observer.IRouteJamBubblesLayerItem;
import com.autonavi.gbl.layer.router.RouteJamBubblesLayerItemRouter;
import com.autonavi.gbl.map.layer.QuadrantLayerItem;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(target = RouteJamBubblesLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class RouteJamBubblesLayerItem extends QuadrantLayerItem implements IRouteJamBubblesLayerItem {
    private static String PACKAGE = ReflexTool.PN(RouteJamBubblesLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private RouteJamBubblesLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected RouteJamBubblesLayerItem(long j, boolean z) {
        this(new RouteJamBubblesLayerItemRouter("RouteJamBubblesLayerItem", (IRouteJamBubblesLayerItem) null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRouteJamBubblesLayerItem.class}, new Object[]{this});
    }

    public RouteJamBubblesLayerItem(@QuadrantType.QuadrantType1 int i, long j) {
        this(new RouteJamBubblesLayerItemRouter("RouteJamBubblesLayerItem", (IRouteJamBubblesLayerItem) null, i, j));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRouteJamBubblesLayerItem.class}, new Object[]{this});
    }

    public RouteJamBubblesLayerItem(RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl) {
        super(routeJamBubblesLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(routeJamBubblesLayerItemImpl);
    }

    private void $constructor(RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl) {
        if (routeJamBubblesLayerItemImpl != null) {
            this.mService = routeJamBubblesLayerItemImpl;
            this.mTargetId = String.format("RouteJamBubblesLayerItem_%s_%d", String.valueOf(RouteJamBubblesLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public RouteJamBubblesLayerItemImpl getService() {
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
        return RouteJamBubblesLayerItemImpl.getClassTypeName();
    }

    public void setDirectionStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl = this.mService;
        if (routeJamBubblesLayerItemImpl != null) {
            routeJamBubblesLayerItemImpl.$explicit_setDirectionStyle(i);
        }
    }

    public void setDeepInfo(JamBubblesSegmentDeepInfo jamBubblesSegmentDeepInfo) {
        RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl = this.mService;
        if (routeJamBubblesLayerItemImpl != null) {
            routeJamBubblesLayerItemImpl.$explicit_setDeepInfo(jamBubblesSegmentDeepInfo);
        }
    }

    public void setTrend(JamBubblesSegmentDeepInfo jamBubblesSegmentDeepInfo) {
        RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl = this.mService;
        if (routeJamBubblesLayerItemImpl != null) {
            routeJamBubblesLayerItemImpl.$explicit_setTrend(jamBubblesSegmentDeepInfo);
        }
    }

    public void setCost(JamBubblesSegmentDeepInfo jamBubblesSegmentDeepInfo) {
        RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl = this.mService;
        if (routeJamBubblesLayerItemImpl != null) {
            routeJamBubblesLayerItemImpl.$explicit_setCost(jamBubblesSegmentDeepInfo);
        }
    }

    public void setDegree(JamBubblesSegmentDeepInfo jamBubblesSegmentDeepInfo) {
        RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl = this.mService;
        if (routeJamBubblesLayerItemImpl != null) {
            routeJamBubblesLayerItemImpl.$explicit_setDegree(jamBubblesSegmentDeepInfo);
        }
    }

    public void setPicPath(String str) {
        RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl = this.mService;
        if (routeJamBubblesLayerItemImpl != null) {
            routeJamBubblesLayerItemImpl.$explicit_setPicPath(str);
        }
    }

    public void setIsJamWord(boolean z) {
        RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl = this.mService;
        if (routeJamBubblesLayerItemImpl != null) {
            routeJamBubblesLayerItemImpl.$explicit_setIsJamWord(z);
        }
    }

    public void setPathId(long j) {
        RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl = this.mService;
        if (routeJamBubblesLayerItemImpl != null) {
            routeJamBubblesLayerItemImpl.$explicit_setPathId(j);
        }
    }

    public void setBubbleIndexId(long j) {
        RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl = this.mService;
        if (routeJamBubblesLayerItemImpl != null) {
            routeJamBubblesLayerItemImpl.$explicit_setBubbleIndexId(j);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IRouteJamBubblesLayerItem
    @BizDirectionStyle.BizDirectionStyle1
    public int getDirectionStyle() {
        RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl = this.mService;
        if (routeJamBubblesLayerItemImpl != null) {
            return routeJamBubblesLayerItemImpl.$explicit_getDirectionStyle();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.IRouteJamBubblesLayerItem
    public JamBubblesSegmentDeepInfo getDeepInfo() {
        RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl = this.mService;
        if (routeJamBubblesLayerItemImpl != null) {
            return routeJamBubblesLayerItemImpl.$explicit_getDeepInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.IRouteJamBubblesLayerItem
    public JamBubblesSegmentDeepInfo getTrend() {
        RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl = this.mService;
        if (routeJamBubblesLayerItemImpl != null) {
            return routeJamBubblesLayerItemImpl.$explicit_getTrend();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.IRouteJamBubblesLayerItem
    public JamBubblesSegmentDeepInfo getCost() {
        RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl = this.mService;
        if (routeJamBubblesLayerItemImpl != null) {
            return routeJamBubblesLayerItemImpl.$explicit_getCost();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.IRouteJamBubblesLayerItem
    public JamBubblesSegmentDeepInfo getDegree() {
        RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl = this.mService;
        if (routeJamBubblesLayerItemImpl != null) {
            return routeJamBubblesLayerItemImpl.$explicit_getDegree();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.IRouteJamBubblesLayerItem
    public String getPicPath() {
        RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl = this.mService;
        if (routeJamBubblesLayerItemImpl != null) {
            return routeJamBubblesLayerItemImpl.$explicit_getPicPath();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.IRouteJamBubblesLayerItem
    public boolean getIsJamWord() {
        RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl = this.mService;
        if (routeJamBubblesLayerItemImpl != null) {
            return routeJamBubblesLayerItemImpl.$explicit_getIsJamWord();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.IRouteJamBubblesLayerItem
    public long getPathId() {
        RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl = this.mService;
        if (routeJamBubblesLayerItemImpl != null) {
            return routeJamBubblesLayerItemImpl.$explicit_getPathId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.observer.IRouteJamBubblesLayerItem
    public long getBubbleIndexId() {
        RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl = this.mService;
        if (routeJamBubblesLayerItemImpl != null) {
            return routeJamBubblesLayerItemImpl.$explicit_getBubbleIndexId();
        }
        return 0L;
    }
}
