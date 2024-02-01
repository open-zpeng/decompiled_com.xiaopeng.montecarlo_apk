package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.lane.model.LaneNotRecommendedType;
import com.autonavi.gbl.layer.impl.LaneGuideNotRecommendedLayerItemImpl;
import com.autonavi.gbl.layer.observer.ILaneGuideNotRecommendedLayerItem;
import com.autonavi.gbl.layer.router.LaneGuideNotRecommendedLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = LaneGuideNotRecommendedLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class LaneGuideNotRecommendedLayerItem extends PointLayerItem implements ILaneGuideNotRecommendedLayerItem {
    private static String PACKAGE = ReflexTool.PN(LaneGuideNotRecommendedLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private LaneGuideNotRecommendedLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected LaneGuideNotRecommendedLayerItem(long j, boolean z) {
        this(new LaneGuideNotRecommendedLayerItemRouter("LaneGuideNotRecommendedLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILaneGuideNotRecommendedLayerItem.class}, new Object[]{this});
    }

    public LaneGuideNotRecommendedLayerItem() {
        this(new LaneGuideNotRecommendedLayerItemRouter("LaneGuideNotRecommendedLayerItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILaneGuideNotRecommendedLayerItem.class}, new Object[]{this});
    }

    public LaneGuideNotRecommendedLayerItem(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl) {
        super(laneGuideNotRecommendedLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(laneGuideNotRecommendedLayerItemImpl);
    }

    private void $constructor(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl) {
        if (laneGuideNotRecommendedLayerItemImpl != null) {
            this.mService = laneGuideNotRecommendedLayerItemImpl;
            this.mTargetId = String.format("LaneGuideNotRecommendedLayerItem_%s_%d", String.valueOf(LaneGuideNotRecommendedLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public LaneGuideNotRecommendedLayerItemImpl getService() {
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
        return LaneGuideNotRecommendedLayerItemImpl.getClassTypeName();
    }

    public void setSceneType(@LaneNotRecommendedType.LaneNotRecommendedType1 int i) {
        LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl = this.mService;
        if (laneGuideNotRecommendedLayerItemImpl != null) {
            laneGuideNotRecommendedLayerItemImpl.$explicit_setSceneType(i);
        }
    }

    public void setBubbleSide(@BubbleDirectionType.BubbleDirectionType1 int i) {
        LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl = this.mService;
        if (laneGuideNotRecommendedLayerItemImpl != null) {
            laneGuideNotRecommendedLayerItemImpl.$explicit_setBubbleSide(i);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideNotRecommendedLayerItem
    @LaneNotRecommendedType.LaneNotRecommendedType1
    public int getSceneType() {
        LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl = this.mService;
        if (laneGuideNotRecommendedLayerItemImpl != null) {
            return laneGuideNotRecommendedLayerItemImpl.$explicit_getSceneType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideNotRecommendedLayerItem
    @BubbleDirectionType.BubbleDirectionType1
    public int getBubbleSide() {
        LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl = this.mService;
        if (laneGuideNotRecommendedLayerItemImpl != null) {
            return laneGuideNotRecommendedLayerItemImpl.$explicit_getBubbleSide();
        }
        return Integer.MIN_VALUE;
    }
}
