package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.lane.model.ForbiddenTurnType;
import com.autonavi.gbl.lane.model.LaneRestrictedType;
import com.autonavi.gbl.lane.model.LimitTimeType;
import com.autonavi.gbl.layer.impl.LaneGuideRestrictedLayerItemImpl;
import com.autonavi.gbl.layer.observer.ILaneGuideRestrictedLayerItem;
import com.autonavi.gbl.layer.router.LaneGuideRestrictedLayerItemRouter;
import com.autonavi.gbl.map.layer.QuadrantLayerItem;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(target = LaneGuideRestrictedLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class LaneGuideRestrictedLayerItem extends QuadrantLayerItem implements ILaneGuideRestrictedLayerItem {
    private static String PACKAGE = ReflexTool.PN(LaneGuideRestrictedLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private LaneGuideRestrictedLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected LaneGuideRestrictedLayerItem(long j, boolean z) {
        this(new LaneGuideRestrictedLayerItemRouter("LaneGuideRestrictedLayerItem", (ILaneGuideRestrictedLayerItem) null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILaneGuideRestrictedLayerItem.class}, new Object[]{this});
    }

    public LaneGuideRestrictedLayerItem(@QuadrantType.QuadrantType1 int i, long j) {
        this(new LaneGuideRestrictedLayerItemRouter("LaneGuideRestrictedLayerItem", (ILaneGuideRestrictedLayerItem) null, i, j));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILaneGuideRestrictedLayerItem.class}, new Object[]{this});
    }

    public LaneGuideRestrictedLayerItem(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        super(laneGuideRestrictedLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(laneGuideRestrictedLayerItemImpl);
    }

    private void $constructor(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        if (laneGuideRestrictedLayerItemImpl != null) {
            this.mService = laneGuideRestrictedLayerItemImpl;
            this.mTargetId = String.format("LaneGuideRestrictedLayerItem_%s_%d", String.valueOf(LaneGuideRestrictedLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public LaneGuideRestrictedLayerItemImpl getService() {
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
        return LaneGuideRestrictedLayerItemImpl.getClassTypeName();
    }

    public void setSceneType(@LaneRestrictedType.LaneRestrictedType1 int i) {
        LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl = this.mService;
        if (laneGuideRestrictedLayerItemImpl != null) {
            laneGuideRestrictedLayerItemImpl.$explicit_setSceneType(i);
        }
    }

    public void setBubbleSide(@BubbleDirectionType.BubbleDirectionType1 int i) {
        LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl = this.mService;
        if (laneGuideRestrictedLayerItemImpl != null) {
            laneGuideRestrictedLayerItemImpl.$explicit_setBubbleSide(i);
        }
    }

    public void setForbiddenType(@ForbiddenTurnType.ForbiddenTurnType1 int i) {
        LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl = this.mService;
        if (laneGuideRestrictedLayerItemImpl != null) {
            laneGuideRestrictedLayerItemImpl.$explicit_setForbiddenType(i);
        }
    }

    public void setLimitType(@LimitTimeType.LimitTimeType1 int i) {
        LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl = this.mService;
        if (laneGuideRestrictedLayerItemImpl != null) {
            laneGuideRestrictedLayerItemImpl.$explicit_setLimitType(i);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideRestrictedLayerItem
    @LaneRestrictedType.LaneRestrictedType1
    public int getSceneType() {
        LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl = this.mService;
        if (laneGuideRestrictedLayerItemImpl != null) {
            return laneGuideRestrictedLayerItemImpl.$explicit_getSceneType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideRestrictedLayerItem
    @BubbleDirectionType.BubbleDirectionType1
    public int getBubbleSide() {
        LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl = this.mService;
        if (laneGuideRestrictedLayerItemImpl != null) {
            return laneGuideRestrictedLayerItemImpl.$explicit_getBubbleSide();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideRestrictedLayerItem
    @ForbiddenTurnType.ForbiddenTurnType1
    public int getForbiddenType() {
        LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl = this.mService;
        if (laneGuideRestrictedLayerItemImpl != null) {
            return laneGuideRestrictedLayerItemImpl.$explicit_getForbiddenType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideRestrictedLayerItem
    @LimitTimeType.LimitTimeType1
    public int getLimitType() {
        LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl = this.mService;
        if (laneGuideRestrictedLayerItemImpl != null) {
            return laneGuideRestrictedLayerItemImpl.$explicit_getLimitType();
        }
        return Integer.MIN_VALUE;
    }
}
