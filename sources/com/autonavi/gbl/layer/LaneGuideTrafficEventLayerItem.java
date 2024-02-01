package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.layer.impl.LaneGuideTrafficEventLayerItemImpl;
import com.autonavi.gbl.layer.observer.ILaneGuideTrafficEventLayerItem;
import com.autonavi.gbl.layer.router.LaneGuideTrafficEventLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = LaneGuideTrafficEventLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class LaneGuideTrafficEventLayerItem extends PointLayerItem implements ILaneGuideTrafficEventLayerItem {
    private static String PACKAGE = ReflexTool.PN(LaneGuideTrafficEventLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private LaneGuideTrafficEventLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected LaneGuideTrafficEventLayerItem(long j, boolean z) {
        this(new LaneGuideTrafficEventLayerItemRouter("LaneGuideTrafficEventLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILaneGuideTrafficEventLayerItem.class}, new Object[]{this});
    }

    public LaneGuideTrafficEventLayerItem() {
        this(new LaneGuideTrafficEventLayerItemRouter("LaneGuideTrafficEventLayerItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILaneGuideTrafficEventLayerItem.class}, new Object[]{this});
    }

    public LaneGuideTrafficEventLayerItem(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        super(laneGuideTrafficEventLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(laneGuideTrafficEventLayerItemImpl);
    }

    private void $constructor(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        if (laneGuideTrafficEventLayerItemImpl != null) {
            this.mService = laneGuideTrafficEventLayerItemImpl;
            this.mTargetId = String.format("LaneGuideTrafficEventLayerItem_%s_%d", String.valueOf(LaneGuideTrafficEventLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public LaneGuideTrafficEventLayerItemImpl getService() {
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
        return LaneGuideTrafficEventLayerItemImpl.getClassTypeName();
    }

    public void setMIndex(int i) {
        LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl = this.mService;
        if (laneGuideTrafficEventLayerItemImpl != null) {
            laneGuideTrafficEventLayerItemImpl.$explicit_setMIndex(i);
        }
    }

    public void setMDirectionType(@BubbleDirectionType.BubbleDirectionType1 int i) {
        LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl = this.mService;
        if (laneGuideTrafficEventLayerItemImpl != null) {
            laneGuideTrafficEventLayerItemImpl.$explicit_setMDirectionType(i);
        }
    }

    public void setMLayerTag(int i) {
        LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl = this.mService;
        if (laneGuideTrafficEventLayerItemImpl != null) {
            laneGuideTrafficEventLayerItemImpl.$explicit_setMLayerTag(i);
        }
    }

    public void setMLane(String str) {
        LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl = this.mService;
        if (laneGuideTrafficEventLayerItemImpl != null) {
            laneGuideTrafficEventLayerItemImpl.$explicit_setMLane(str);
        }
    }

    public void setMLayer(int i) {
        LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl = this.mService;
        if (laneGuideTrafficEventLayerItemImpl != null) {
            laneGuideTrafficEventLayerItemImpl.$explicit_setMLayer(i);
        }
    }

    public void setPathId(long j) {
        LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl = this.mService;
        if (laneGuideTrafficEventLayerItemImpl != null) {
            laneGuideTrafficEventLayerItemImpl.$explicit_setPathId(j);
        }
    }

    public void setMId(int i) {
        LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl = this.mService;
        if (laneGuideTrafficEventLayerItemImpl != null) {
            laneGuideTrafficEventLayerItemImpl.$explicit_setMId(i);
        }
    }

    public void setLength(int i) {
        LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl = this.mService;
        if (laneGuideTrafficEventLayerItemImpl != null) {
            laneGuideTrafficEventLayerItemImpl.$explicit_setLength(i);
        }
    }

    public void setLaneDetail(String str) {
        LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl = this.mService;
        if (laneGuideTrafficEventLayerItemImpl != null) {
            laneGuideTrafficEventLayerItemImpl.$explicit_setLaneDetail(str);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideTrafficEventLayerItem
    public int getMIndex() {
        LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl = this.mService;
        if (laneGuideTrafficEventLayerItemImpl != null) {
            return laneGuideTrafficEventLayerItemImpl.$explicit_getMIndex();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideTrafficEventLayerItem
    @BubbleDirectionType.BubbleDirectionType1
    public int getMDirectionType() {
        LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl = this.mService;
        if (laneGuideTrafficEventLayerItemImpl != null) {
            return laneGuideTrafficEventLayerItemImpl.$explicit_getMDirectionType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideTrafficEventLayerItem
    public int getMLayerTag() {
        LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl = this.mService;
        if (laneGuideTrafficEventLayerItemImpl != null) {
            return laneGuideTrafficEventLayerItemImpl.$explicit_getMLayerTag();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideTrafficEventLayerItem
    public String getMLane() {
        LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl = this.mService;
        if (laneGuideTrafficEventLayerItemImpl != null) {
            return laneGuideTrafficEventLayerItemImpl.$explicit_getMLane();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideTrafficEventLayerItem
    public int getMLayer() {
        LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl = this.mService;
        if (laneGuideTrafficEventLayerItemImpl != null) {
            return laneGuideTrafficEventLayerItemImpl.$explicit_getMLayer();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideTrafficEventLayerItem
    public long getPathId() {
        LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl = this.mService;
        if (laneGuideTrafficEventLayerItemImpl != null) {
            return laneGuideTrafficEventLayerItemImpl.$explicit_getPathId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideTrafficEventLayerItem
    public int getMId() {
        LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl = this.mService;
        if (laneGuideTrafficEventLayerItemImpl != null) {
            return laneGuideTrafficEventLayerItemImpl.$explicit_getMId();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideTrafficEventLayerItem
    public int getLength() {
        LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl = this.mService;
        if (laneGuideTrafficEventLayerItemImpl != null) {
            return laneGuideTrafficEventLayerItemImpl.$explicit_getLength();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideTrafficEventLayerItem
    public String getLaneDetail() {
        LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl = this.mService;
        if (laneGuideTrafficEventLayerItemImpl != null) {
            return laneGuideTrafficEventLayerItemImpl.$explicit_getLaneDetail();
        }
        return null;
    }
}
