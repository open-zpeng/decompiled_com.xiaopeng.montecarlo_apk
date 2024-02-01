package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.layer.impl.LaneGuideOddInfoItemImpl;
import com.autonavi.gbl.layer.model.LaneODDPointType;
import com.autonavi.gbl.layer.observer.ILaneGuideOddInfoItem;
import com.autonavi.gbl.layer.router.LaneGuideOddInfoItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = LaneGuideOddInfoItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class LaneGuideOddInfoItem extends PointLayerItem implements ILaneGuideOddInfoItem {
    private static String PACKAGE = ReflexTool.PN(LaneGuideOddInfoItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private LaneGuideOddInfoItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected LaneGuideOddInfoItem(long j, boolean z) {
        this(new LaneGuideOddInfoItemRouter("LaneGuideOddInfoItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILaneGuideOddInfoItem.class}, new Object[]{this});
    }

    public LaneGuideOddInfoItem() {
        this(new LaneGuideOddInfoItemRouter("LaneGuideOddInfoItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILaneGuideOddInfoItem.class}, new Object[]{this});
    }

    public LaneGuideOddInfoItem(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl) {
        super(laneGuideOddInfoItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(laneGuideOddInfoItemImpl);
    }

    private void $constructor(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl) {
        if (laneGuideOddInfoItemImpl != null) {
            this.mService = laneGuideOddInfoItemImpl;
            this.mTargetId = String.format("LaneGuideOddInfoItem_%s_%d", String.valueOf(LaneGuideOddInfoItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public LaneGuideOddInfoItemImpl getService() {
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
        return LaneGuideOddInfoItemImpl.getClassTypeName();
    }

    public void setDirectionType(@BubbleDirectionType.BubbleDirectionType1 int i) {
        LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl = this.mService;
        if (laneGuideOddInfoItemImpl != null) {
            laneGuideOddInfoItemImpl.$explicit_setDirectionType(i);
        }
    }

    public void setType(@LaneODDPointType.LaneODDPointType1 int i) {
        LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl = this.mService;
        if (laneGuideOddInfoItemImpl != null) {
            laneGuideOddInfoItemImpl.$explicit_setType(i);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideOddInfoItem
    @BubbleDirectionType.BubbleDirectionType1
    public int getDirectionType() {
        LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl = this.mService;
        if (laneGuideOddInfoItemImpl != null) {
            return laneGuideOddInfoItemImpl.$explicit_getDirectionType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideOddInfoItem
    @LaneODDPointType.LaneODDPointType1
    public int getType() {
        LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl = this.mService;
        if (laneGuideOddInfoItemImpl != null) {
            return laneGuideOddInfoItemImpl.$explicit_getType();
        }
        return Integer.MIN_VALUE;
    }
}
