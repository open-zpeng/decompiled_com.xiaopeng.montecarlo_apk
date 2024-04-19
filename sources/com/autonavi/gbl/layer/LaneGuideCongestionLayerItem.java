package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.guide.model.CongestExtend;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.layer.impl.LaneGuideCongestionLayerItemImpl;
import com.autonavi.gbl.layer.observer.ILaneGuideCongestionLayerItem;
import com.autonavi.gbl.layer.router.LaneGuideCongestionLayerItemRouter;
import com.autonavi.gbl.map.layer.QuadrantLayerItem;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(target = LaneGuideCongestionLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class LaneGuideCongestionLayerItem extends QuadrantLayerItem implements ILaneGuideCongestionLayerItem {
    private static String PACKAGE = ReflexTool.PN(LaneGuideCongestionLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private LaneGuideCongestionLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected LaneGuideCongestionLayerItem(long j, boolean z) {
        this(new LaneGuideCongestionLayerItemRouter("LaneGuideCongestionLayerItem", (ILaneGuideCongestionLayerItem) null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILaneGuideCongestionLayerItem.class}, new Object[]{this});
    }

    public LaneGuideCongestionLayerItem(@QuadrantType.QuadrantType1 int i, long j) {
        this(new LaneGuideCongestionLayerItemRouter("LaneGuideCongestionLayerItem", (ILaneGuideCongestionLayerItem) null, i, j));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILaneGuideCongestionLayerItem.class}, new Object[]{this});
    }

    public LaneGuideCongestionLayerItem(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        super(laneGuideCongestionLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(laneGuideCongestionLayerItemImpl);
    }

    private void $constructor(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        if (laneGuideCongestionLayerItemImpl != null) {
            this.mService = laneGuideCongestionLayerItemImpl;
            this.mTargetId = String.format("LaneGuideCongestionLayerItem_%s_%d", String.valueOf(LaneGuideCongestionLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public LaneGuideCongestionLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.LaneGuideCongestionLayerItem.1
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
    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.LaneGuideCongestionLayerItem.2
        }));
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public synchronized void delete() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.LaneGuideCongestionLayerItem.3
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
        return LaneGuideCongestionLayerItemImpl.getClassTypeName();
    }

    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.LayerItem, com.autonavi.gbl.map.observer.ICollisionItem
    public void resetOnVisible(boolean z) {
        LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl = this.mService;
        if (laneGuideCongestionLayerItemImpl != null) {
            laneGuideCongestionLayerItemImpl.$explicit_resetOnVisible(z);
        }
    }

    public void setMPathID(long j) {
        LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl = this.mService;
        if (laneGuideCongestionLayerItemImpl != null) {
            laneGuideCongestionLayerItemImpl.$explicit_setMPathID(j);
        }
    }

    public void setMTotalTimeOfSeconds(long j) {
        LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl = this.mService;
        if (laneGuideCongestionLayerItemImpl != null) {
            laneGuideCongestionLayerItemImpl.$explicit_setMTotalTimeOfSeconds(j);
        }
    }

    public void setMTotalRemainDist(long j) {
        LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl = this.mService;
        if (laneGuideCongestionLayerItemImpl != null) {
            laneGuideCongestionLayerItemImpl.$explicit_setMTotalRemainDist(j);
        }
    }

    public void setMCongestExtend(CongestExtend congestExtend) {
        LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl = this.mService;
        if (laneGuideCongestionLayerItemImpl != null) {
            laneGuideCongestionLayerItemImpl.$explicit_setMCongestExtend(congestExtend);
        }
    }

    public void setMDirectionType(@BubbleDirectionType.BubbleDirectionType1 int i) {
        LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl = this.mService;
        if (laneGuideCongestionLayerItemImpl != null) {
            laneGuideCongestionLayerItemImpl.$explicit_setMDirectionType(i);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideCongestionLayerItem
    public long getMPathID() {
        LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl = this.mService;
        if (laneGuideCongestionLayerItemImpl != null) {
            return laneGuideCongestionLayerItemImpl.$explicit_getMPathID();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideCongestionLayerItem
    public long getMTotalTimeOfSeconds() {
        LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl = this.mService;
        if (laneGuideCongestionLayerItemImpl != null) {
            return laneGuideCongestionLayerItemImpl.$explicit_getMTotalTimeOfSeconds();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideCongestionLayerItem
    public long getMTotalRemainDist() {
        LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl = this.mService;
        if (laneGuideCongestionLayerItemImpl != null) {
            return laneGuideCongestionLayerItemImpl.$explicit_getMTotalRemainDist();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideCongestionLayerItem
    public CongestExtend getMCongestExtend() {
        LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl = this.mService;
        if (laneGuideCongestionLayerItemImpl != null) {
            return laneGuideCongestionLayerItemImpl.$explicit_getMCongestExtend();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideCongestionLayerItem
    @BubbleDirectionType.BubbleDirectionType1
    public int getMDirectionType() {
        LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl = this.mService;
        if (laneGuideCongestionLayerItemImpl != null) {
            return laneGuideCongestionLayerItemImpl.$explicit_getMDirectionType();
        }
        return Integer.MIN_VALUE;
    }
}
