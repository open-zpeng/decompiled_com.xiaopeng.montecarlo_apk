package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.LaneRoutePathPointItemImpl;
import com.autonavi.gbl.layer.model.BizRouteMapMode;
import com.autonavi.gbl.layer.observer.ILaneRoutePathPointItem;
import com.autonavi.gbl.layer.router.LaneRoutePathPointItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
import com.autonavi.gbl.map.layer.model.PathPointType;
import com.autonavi.gbl.map.layer.model.RouteLayerScene;
@IntfAuto(target = LaneRoutePathPointItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class LaneRoutePathPointItem extends PointLayerItem implements ILaneRoutePathPointItem {
    private static String PACKAGE = ReflexTool.PN(LaneRoutePathPointItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private LaneRoutePathPointItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected LaneRoutePathPointItem(long j, boolean z) {
        this(new LaneRoutePathPointItemRouter("LaneRoutePathPointItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILaneRoutePathPointItem.class}, new Object[]{this});
    }

    public LaneRoutePathPointItem() {
        this(new LaneRoutePathPointItemRouter("LaneRoutePathPointItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILaneRoutePathPointItem.class}, new Object[]{this});
    }

    public LaneRoutePathPointItem(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl) {
        super(laneRoutePathPointItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(laneRoutePathPointItemImpl);
    }

    private void $constructor(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl) {
        if (laneRoutePathPointItemImpl != null) {
            this.mService = laneRoutePathPointItemImpl;
            this.mTargetId = String.format("LaneRoutePathPointItem_%s_%d", String.valueOf(LaneRoutePathPointItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public LaneRoutePathPointItemImpl getService() {
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
        return LaneRoutePathPointItemImpl.getClassTypeName();
    }

    public void setMIsNavi(boolean z) {
        LaneRoutePathPointItemImpl laneRoutePathPointItemImpl = this.mService;
        if (laneRoutePathPointItemImpl != null) {
            laneRoutePathPointItemImpl.$explicit_setMIsNavi(z);
        }
    }

    public void setMMode(@BizRouteMapMode.BizRouteMapMode1 int i) {
        LaneRoutePathPointItemImpl laneRoutePathPointItemImpl = this.mService;
        if (laneRoutePathPointItemImpl != null) {
            laneRoutePathPointItemImpl.$explicit_setMMode(i);
        }
    }

    public void setMScene(@RouteLayerScene.RouteLayerScene1 int i) {
        LaneRoutePathPointItemImpl laneRoutePathPointItemImpl = this.mService;
        if (laneRoutePathPointItemImpl != null) {
            laneRoutePathPointItemImpl.$explicit_setMScene(i);
        }
    }

    public void setMType(@PathPointType.PathPointType1 int i) {
        LaneRoutePathPointItemImpl laneRoutePathPointItemImpl = this.mService;
        if (laneRoutePathPointItemImpl != null) {
            laneRoutePathPointItemImpl.$explicit_setMType(i);
        }
    }

    public void setMLeftEnergy(int i) {
        LaneRoutePathPointItemImpl laneRoutePathPointItemImpl = this.mService;
        if (laneRoutePathPointItemImpl != null) {
            laneRoutePathPointItemImpl.$explicit_setMLeftEnergy(i);
        }
    }

    public void setMTotalCount(int i) {
        LaneRoutePathPointItemImpl laneRoutePathPointItemImpl = this.mService;
        if (laneRoutePathPointItemImpl != null) {
            laneRoutePathPointItemImpl.$explicit_setMTotalCount(i);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneRoutePathPointItem
    public boolean getMIsNavi() {
        LaneRoutePathPointItemImpl laneRoutePathPointItemImpl = this.mService;
        if (laneRoutePathPointItemImpl != null) {
            return laneRoutePathPointItemImpl.$explicit_getMIsNavi();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneRoutePathPointItem
    @BizRouteMapMode.BizRouteMapMode1
    public int getMMode() {
        LaneRoutePathPointItemImpl laneRoutePathPointItemImpl = this.mService;
        if (laneRoutePathPointItemImpl != null) {
            return laneRoutePathPointItemImpl.$explicit_getMMode();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneRoutePathPointItem
    @RouteLayerScene.RouteLayerScene1
    public int getMScene() {
        LaneRoutePathPointItemImpl laneRoutePathPointItemImpl = this.mService;
        if (laneRoutePathPointItemImpl != null) {
            return laneRoutePathPointItemImpl.$explicit_getMScene();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneRoutePathPointItem
    @PathPointType.PathPointType1
    public int getMType() {
        LaneRoutePathPointItemImpl laneRoutePathPointItemImpl = this.mService;
        if (laneRoutePathPointItemImpl != null) {
            return laneRoutePathPointItemImpl.$explicit_getMType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneRoutePathPointItem
    public int getMLeftEnergy() {
        LaneRoutePathPointItemImpl laneRoutePathPointItemImpl = this.mService;
        if (laneRoutePathPointItemImpl != null) {
            return laneRoutePathPointItemImpl.$explicit_getMLeftEnergy();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneRoutePathPointItem
    public int getMTotalCount() {
        LaneRoutePathPointItemImpl laneRoutePathPointItemImpl = this.mService;
        if (laneRoutePathPointItemImpl != null) {
            return laneRoutePathPointItemImpl.$explicit_getMTotalCount();
        }
        return 0;
    }
}
