package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.layer.impl.LaneGuideBusLayerItemImpl;
import com.autonavi.gbl.layer.observer.ILaneGuideBusLayerItem;
import com.autonavi.gbl.layer.router.LaneGuideBusLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = LaneGuideBusLayerItemRouter.class, type = BuildType.JOBIMPL)
@Deprecated
/* loaded from: classes.dex */
public class LaneGuideBusLayerItem extends PointLayerItem implements ILaneGuideBusLayerItem {
    private static String PACKAGE = ReflexTool.PN(LaneGuideBusLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private LaneGuideBusLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected LaneGuideBusLayerItem(long j, boolean z) {
        this(new LaneGuideBusLayerItemRouter("LaneGuideBusLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILaneGuideBusLayerItem.class}, new Object[]{this});
    }

    public LaneGuideBusLayerItem() {
        this(new LaneGuideBusLayerItemRouter("LaneGuideBusLayerItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILaneGuideBusLayerItem.class}, new Object[]{this});
    }

    public LaneGuideBusLayerItem(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl) {
        super(laneGuideBusLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(laneGuideBusLayerItemImpl);
    }

    private void $constructor(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl) {
        if (laneGuideBusLayerItemImpl != null) {
            this.mService = laneGuideBusLayerItemImpl;
            this.mTargetId = String.format("LaneGuideBusLayerItem_%s_%d", String.valueOf(LaneGuideBusLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public LaneGuideBusLayerItemImpl getService() {
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
        return LaneGuideBusLayerItemImpl.getClassTypeName();
    }

    public void setBubbleSide(@BubbleDirectionType.BubbleDirectionType1 int i) {
        LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl = this.mService;
        if (laneGuideBusLayerItemImpl != null) {
            laneGuideBusLayerItemImpl.$explicit_setBubbleSide(i);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideBusLayerItem
    @BubbleDirectionType.BubbleDirectionType1
    public int getBubbleSide() {
        LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl = this.mService;
        if (laneGuideBusLayerItemImpl != null) {
            return laneGuideBusLayerItemImpl.$explicit_getBubbleSide();
        }
        return Integer.MIN_VALUE;
    }
}
