package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.lane.model.LaneChangeGuidanceType;
import com.autonavi.gbl.layer.impl.LaneGuideChangeLayerItemImpl;
import com.autonavi.gbl.layer.observer.ILaneGuideChangeLayerItem;
import com.autonavi.gbl.layer.router.LaneGuideChangeLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = LaneGuideChangeLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class LaneGuideChangeLayerItem extends PointLayerItem implements ILaneGuideChangeLayerItem {
    private static String PACKAGE = ReflexTool.PN(LaneGuideChangeLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private LaneGuideChangeLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected LaneGuideChangeLayerItem(long j, boolean z) {
        this(new LaneGuideChangeLayerItemRouter("LaneGuideChangeLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILaneGuideChangeLayerItem.class}, new Object[]{this});
    }

    public LaneGuideChangeLayerItem() {
        this(new LaneGuideChangeLayerItemRouter("LaneGuideChangeLayerItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILaneGuideChangeLayerItem.class}, new Object[]{this});
    }

    public LaneGuideChangeLayerItem(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl) {
        super(laneGuideChangeLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(laneGuideChangeLayerItemImpl);
    }

    private void $constructor(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl) {
        if (laneGuideChangeLayerItemImpl != null) {
            this.mService = laneGuideChangeLayerItemImpl;
            this.mTargetId = String.format("LaneGuideChangeLayerItem_%s_%d", String.valueOf(LaneGuideChangeLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public LaneGuideChangeLayerItemImpl getService() {
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
        return LaneGuideChangeLayerItemImpl.getClassTypeName();
    }

    public void setSceneType(@LaneChangeGuidanceType.LaneChangeGuidanceType1 int i) {
        LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl = this.mService;
        if (laneGuideChangeLayerItemImpl != null) {
            laneGuideChangeLayerItemImpl.$explicit_setSceneType(i);
        }
    }

    public void setBubbleSide(@BubbleDirectionType.BubbleDirectionType1 int i) {
        LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl = this.mService;
        if (laneGuideChangeLayerItemImpl != null) {
            laneGuideChangeLayerItemImpl.$explicit_setBubbleSide(i);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideChangeLayerItem
    @LaneChangeGuidanceType.LaneChangeGuidanceType1
    public int getSceneType() {
        LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl = this.mService;
        if (laneGuideChangeLayerItemImpl != null) {
            return laneGuideChangeLayerItemImpl.$explicit_getSceneType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideChangeLayerItem
    @BubbleDirectionType.BubbleDirectionType1
    public int getBubbleSide() {
        LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl = this.mService;
        if (laneGuideChangeLayerItemImpl != null) {
            return laneGuideChangeLayerItemImpl.$explicit_getBubbleSide();
        }
        return Integer.MIN_VALUE;
    }
}
