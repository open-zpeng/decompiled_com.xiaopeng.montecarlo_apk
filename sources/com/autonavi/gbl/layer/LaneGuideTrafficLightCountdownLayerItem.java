package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.layer.impl.LaneGuideTrafficLightCountdownLayerItemImpl;
import com.autonavi.gbl.layer.model.TrafficLightCountDownStatus;
import com.autonavi.gbl.layer.observer.ILaneGuideTrafficLightCountdownLayerItem;
import com.autonavi.gbl.layer.router.LaneGuideTrafficLightCountdownLayerItemRouter;
import com.autonavi.gbl.map.layer.QuadrantLayerItem;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(target = LaneGuideTrafficLightCountdownLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class LaneGuideTrafficLightCountdownLayerItem extends QuadrantLayerItem implements ILaneGuideTrafficLightCountdownLayerItem {
    private static String PACKAGE = ReflexTool.PN(LaneGuideTrafficLightCountdownLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private LaneGuideTrafficLightCountdownLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected LaneGuideTrafficLightCountdownLayerItem(long j, boolean z) {
        this(new LaneGuideTrafficLightCountdownLayerItemRouter("LaneGuideTrafficLightCountdownLayerItem", (ILaneGuideTrafficLightCountdownLayerItem) null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILaneGuideTrafficLightCountdownLayerItem.class}, new Object[]{this});
    }

    public LaneGuideTrafficLightCountdownLayerItem(@QuadrantType.QuadrantType1 int i, long j) {
        this(new LaneGuideTrafficLightCountdownLayerItemRouter("LaneGuideTrafficLightCountdownLayerItem", (ILaneGuideTrafficLightCountdownLayerItem) null, i, j));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILaneGuideTrafficLightCountdownLayerItem.class}, new Object[]{this});
    }

    public LaneGuideTrafficLightCountdownLayerItem(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        super(laneGuideTrafficLightCountdownLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(laneGuideTrafficLightCountdownLayerItemImpl);
    }

    private void $constructor(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        if (laneGuideTrafficLightCountdownLayerItemImpl != null) {
            this.mService = laneGuideTrafficLightCountdownLayerItemImpl;
            this.mTargetId = String.format("LaneGuideTrafficLightCountdownLayerItem_%s_%d", String.valueOf(LaneGuideTrafficLightCountdownLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public LaneGuideTrafficLightCountdownLayerItemImpl getService() {
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
        return LaneGuideTrafficLightCountdownLayerItemImpl.getClassTypeName();
    }

    public void setDirectionType(@BubbleDirectionType.BubbleDirectionType1 int i) {
        LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl = this.mService;
        if (laneGuideTrafficLightCountdownLayerItemImpl != null) {
            laneGuideTrafficLightCountdownLayerItemImpl.$explicit_setDirectionType(i);
        }
    }

    public void setLightBodyAlpha(float f) {
        LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl = this.mService;
        if (laneGuideTrafficLightCountdownLayerItemImpl != null) {
            laneGuideTrafficLightCountdownLayerItemImpl.$explicit_setLightBodyAlpha(f);
        }
    }

    public void setLightDirectionAlpha(float f) {
        LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl = this.mService;
        if (laneGuideTrafficLightCountdownLayerItemImpl != null) {
            laneGuideTrafficLightCountdownLayerItemImpl.$explicit_setLightDirectionAlpha(f);
        }
    }

    public void setLightAnimationBeginTimeMS(long j) {
        LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl = this.mService;
        if (laneGuideTrafficLightCountdownLayerItemImpl != null) {
            laneGuideTrafficLightCountdownLayerItemImpl.$explicit_setLightAnimationBeginTimeMS(j);
        }
    }

    public void setLightStatus(@TrafficLightCountDownStatus.TrafficLightCountDownStatus1 int i) {
        LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl = this.mService;
        if (laneGuideTrafficLightCountdownLayerItemImpl != null) {
            laneGuideTrafficLightCountdownLayerItemImpl.$explicit_setLightStatus(i);
        }
    }

    public void setLightDirection(String str) {
        LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl = this.mService;
        if (laneGuideTrafficLightCountdownLayerItemImpl != null) {
            laneGuideTrafficLightCountdownLayerItemImpl.$explicit_setLightDirection(str);
        }
    }

    public void setRemainSeconds(int i) {
        LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl = this.mService;
        if (laneGuideTrafficLightCountdownLayerItemImpl != null) {
            laneGuideTrafficLightCountdownLayerItemImpl.$explicit_setRemainSeconds(i);
        }
    }

    public void setWaitRound(int i) {
        LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl = this.mService;
        if (laneGuideTrafficLightCountdownLayerItemImpl != null) {
            laneGuideTrafficLightCountdownLayerItemImpl.$explicit_setWaitRound(i);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideTrafficLightCountdownLayerItem
    @BubbleDirectionType.BubbleDirectionType1
    public int getDirectionType() {
        LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl = this.mService;
        if (laneGuideTrafficLightCountdownLayerItemImpl != null) {
            return laneGuideTrafficLightCountdownLayerItemImpl.$explicit_getDirectionType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideTrafficLightCountdownLayerItem
    public float getLightBodyAlpha() {
        LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl = this.mService;
        if (laneGuideTrafficLightCountdownLayerItemImpl != null) {
            return laneGuideTrafficLightCountdownLayerItemImpl.$explicit_getLightBodyAlpha();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideTrafficLightCountdownLayerItem
    public float getLightDirectionAlpha() {
        LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl = this.mService;
        if (laneGuideTrafficLightCountdownLayerItemImpl != null) {
            return laneGuideTrafficLightCountdownLayerItemImpl.$explicit_getLightDirectionAlpha();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideTrafficLightCountdownLayerItem
    public long getLightAnimationBeginTimeMS() {
        LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl = this.mService;
        if (laneGuideTrafficLightCountdownLayerItemImpl != null) {
            return laneGuideTrafficLightCountdownLayerItemImpl.$explicit_getLightAnimationBeginTimeMS();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideTrafficLightCountdownLayerItem
    @TrafficLightCountDownStatus.TrafficLightCountDownStatus1
    public int getLightStatus() {
        LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl = this.mService;
        if (laneGuideTrafficLightCountdownLayerItemImpl != null) {
            return laneGuideTrafficLightCountdownLayerItemImpl.$explicit_getLightStatus();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideTrafficLightCountdownLayerItem
    public String getLightDirection() {
        LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl = this.mService;
        if (laneGuideTrafficLightCountdownLayerItemImpl != null) {
            return laneGuideTrafficLightCountdownLayerItemImpl.$explicit_getLightDirection();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideTrafficLightCountdownLayerItem
    public int getRemainSeconds() {
        LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl = this.mService;
        if (laneGuideTrafficLightCountdownLayerItemImpl != null) {
            return laneGuideTrafficLightCountdownLayerItemImpl.$explicit_getRemainSeconds();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideTrafficLightCountdownLayerItem
    public int getWaitRound() {
        LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl = this.mService;
        if (laneGuideTrafficLightCountdownLayerItemImpl != null) {
            return laneGuideTrafficLightCountdownLayerItemImpl.$explicit_getWaitRound();
        }
        return 0;
    }
}
