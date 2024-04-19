package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.layer.impl.LaneGuideTurnLayerItemImpl;
import com.autonavi.gbl.layer.observer.ILaneGuideTurnLayerItem;
import com.autonavi.gbl.layer.router.LaneGuideTurnLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = LaneGuideTurnLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class LaneGuideTurnLayerItem extends PointLayerItem implements ILaneGuideTurnLayerItem {
    private static String PACKAGE = ReflexTool.PN(LaneGuideTurnLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private LaneGuideTurnLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected LaneGuideTurnLayerItem(long j, boolean z) {
        this(new LaneGuideTurnLayerItemRouter("LaneGuideTurnLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILaneGuideTurnLayerItem.class}, new Object[]{this});
    }

    public LaneGuideTurnLayerItem() {
        this(new LaneGuideTurnLayerItemRouter("LaneGuideTurnLayerItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILaneGuideTurnLayerItem.class}, new Object[]{this});
    }

    public LaneGuideTurnLayerItem(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl) {
        super(laneGuideTurnLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(laneGuideTurnLayerItemImpl);
    }

    private void $constructor(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl) {
        if (laneGuideTurnLayerItemImpl != null) {
            this.mService = laneGuideTurnLayerItemImpl;
            this.mTargetId = String.format("LaneGuideTurnLayerItem_%s_%d", String.valueOf(LaneGuideTurnLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public LaneGuideTurnLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.LaneGuideTurnLayerItem.1
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
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.LaneGuideTurnLayerItem.2
        }));
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public synchronized void delete() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.LaneGuideTurnLayerItem.3
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
        return LaneGuideTurnLayerItemImpl.getClassTypeName();
    }

    public void setMPathID(long j) {
        LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl = this.mService;
        if (laneGuideTurnLayerItemImpl != null) {
            laneGuideTurnLayerItemImpl.$explicit_setMPathID(j);
        }
    }

    public void setMSegmentID(int i) {
        LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl = this.mService;
        if (laneGuideTurnLayerItemImpl != null) {
            laneGuideTurnLayerItemImpl.$explicit_setMSegmentID(i);
        }
    }

    public void setMMainAction(short s) {
        LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl = this.mService;
        if (laneGuideTurnLayerItemImpl != null) {
            laneGuideTurnLayerItemImpl.$explicit_setMMainAction(s);
        }
    }

    public void setMRemainDist(long j) {
        LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl = this.mService;
        if (laneGuideTurnLayerItemImpl != null) {
            laneGuideTurnLayerItemImpl.$explicit_setMRemainDist(j);
        }
    }

    public void setMDirectionType(@BubbleDirectionType.BubbleDirectionType1 int i) {
        LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl = this.mService;
        if (laneGuideTurnLayerItemImpl != null) {
            laneGuideTurnLayerItemImpl.$explicit_setMDirectionType(i);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideTurnLayerItem
    public long getMPathID() {
        LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl = this.mService;
        if (laneGuideTurnLayerItemImpl != null) {
            return laneGuideTurnLayerItemImpl.$explicit_getMPathID();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideTurnLayerItem
    public int getMSegmentID() {
        LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl = this.mService;
        if (laneGuideTurnLayerItemImpl != null) {
            return laneGuideTurnLayerItemImpl.$explicit_getMSegmentID();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideTurnLayerItem
    public short getMMainAction() {
        LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl = this.mService;
        if (laneGuideTurnLayerItemImpl != null) {
            return laneGuideTurnLayerItemImpl.$explicit_getMMainAction();
        }
        return (short) 0;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideTurnLayerItem
    public long getMRemainDist() {
        LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl = this.mService;
        if (laneGuideTurnLayerItemImpl != null) {
            return laneGuideTurnLayerItemImpl.$explicit_getMRemainDist();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideTurnLayerItem
    @BubbleDirectionType.BubbleDirectionType1
    public int getMDirectionType() {
        LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl = this.mService;
        if (laneGuideTurnLayerItemImpl != null) {
            return laneGuideTurnLayerItemImpl.$explicit_getMDirectionType();
        }
        return Integer.MIN_VALUE;
    }
}
