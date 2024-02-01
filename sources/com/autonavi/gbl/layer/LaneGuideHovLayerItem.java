package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.layer.impl.LaneGuideHovLayerItemImpl;
import com.autonavi.gbl.layer.observer.ILaneGuideHovLayerItem;
import com.autonavi.gbl.layer.router.LaneGuideHovLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = LaneGuideHovLayerItemRouter.class, type = BuildType.JOBIMPL)
@Deprecated
/* loaded from: classes.dex */
public class LaneGuideHovLayerItem extends PointLayerItem implements ILaneGuideHovLayerItem {
    private static String PACKAGE = ReflexTool.PN(LaneGuideHovLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private LaneGuideHovLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected LaneGuideHovLayerItem(long j, boolean z) {
        this(new LaneGuideHovLayerItemRouter("LaneGuideHovLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILaneGuideHovLayerItem.class}, new Object[]{this});
    }

    public LaneGuideHovLayerItem() {
        this(new LaneGuideHovLayerItemRouter("LaneGuideHovLayerItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILaneGuideHovLayerItem.class}, new Object[]{this});
    }

    public LaneGuideHovLayerItem(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl) {
        super(laneGuideHovLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(laneGuideHovLayerItemImpl);
    }

    private void $constructor(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl) {
        if (laneGuideHovLayerItemImpl != null) {
            this.mService = laneGuideHovLayerItemImpl;
            this.mTargetId = String.format("LaneGuideHovLayerItem_%s_%d", String.valueOf(LaneGuideHovLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public LaneGuideHovLayerItemImpl getService() {
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
        return LaneGuideHovLayerItemImpl.getClassTypeName();
    }

    public void setBubbleSide(@BubbleDirectionType.BubbleDirectionType1 int i) {
        LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl = this.mService;
        if (laneGuideHovLayerItemImpl != null) {
            laneGuideHovLayerItemImpl.$explicit_setBubbleSide(i);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideHovLayerItem
    @BubbleDirectionType.BubbleDirectionType1
    public int getBubbleSide() {
        LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl = this.mService;
        if (laneGuideHovLayerItemImpl != null) {
            return laneGuideHovLayerItemImpl.$explicit_getBubbleSide();
        }
        return Integer.MIN_VALUE;
    }
}
