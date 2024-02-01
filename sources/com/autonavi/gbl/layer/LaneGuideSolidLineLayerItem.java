package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.layer.impl.LaneGuideSolidLineLayerItemImpl;
import com.autonavi.gbl.layer.observer.ILaneGuideSolidLineLayerItem;
import com.autonavi.gbl.layer.router.LaneGuideSolidLineLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = LaneGuideSolidLineLayerItemRouter.class, type = BuildType.JOBIMPL)
@Deprecated
/* loaded from: classes.dex */
public class LaneGuideSolidLineLayerItem extends PointLayerItem implements ILaneGuideSolidLineLayerItem {
    private static String PACKAGE = ReflexTool.PN(LaneGuideSolidLineLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private LaneGuideSolidLineLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected LaneGuideSolidLineLayerItem(long j, boolean z) {
        this(new LaneGuideSolidLineLayerItemRouter("LaneGuideSolidLineLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILaneGuideSolidLineLayerItem.class}, new Object[]{this});
    }

    public LaneGuideSolidLineLayerItem() {
        this(new LaneGuideSolidLineLayerItemRouter("LaneGuideSolidLineLayerItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILaneGuideSolidLineLayerItem.class}, new Object[]{this});
    }

    public LaneGuideSolidLineLayerItem(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl) {
        super(laneGuideSolidLineLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(laneGuideSolidLineLayerItemImpl);
    }

    private void $constructor(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl) {
        if (laneGuideSolidLineLayerItemImpl != null) {
            this.mService = laneGuideSolidLineLayerItemImpl;
            this.mTargetId = String.format("LaneGuideSolidLineLayerItem_%s_%d", String.valueOf(LaneGuideSolidLineLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public LaneGuideSolidLineLayerItemImpl getService() {
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
        return LaneGuideSolidLineLayerItemImpl.getClassTypeName();
    }

    public void setBubbleSide(@BubbleDirectionType.BubbleDirectionType1 int i) {
        LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl = this.mService;
        if (laneGuideSolidLineLayerItemImpl != null) {
            laneGuideSolidLineLayerItemImpl.$explicit_setBubbleSide(i);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideSolidLineLayerItem
    @BubbleDirectionType.BubbleDirectionType1
    public int getBubbleSide() {
        LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl = this.mService;
        if (laneGuideSolidLineLayerItemImpl != null) {
            return laneGuideSolidLineLayerItemImpl.$explicit_getBubbleSide();
        }
        return Integer.MIN_VALUE;
    }
}
