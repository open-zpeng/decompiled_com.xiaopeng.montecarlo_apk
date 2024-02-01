package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.LaneGuideTrafficLightIconLayerItemImpl;
import com.autonavi.gbl.layer.observer.ILaneGuideTrafficLightIconLayerItem;
import com.autonavi.gbl.layer.router.LaneGuideTrafficLightIconLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = LaneGuideTrafficLightIconLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class LaneGuideTrafficLightIconLayerItem extends PointLayerItem implements ILaneGuideTrafficLightIconLayerItem {
    private static String PACKAGE = ReflexTool.PN(LaneGuideTrafficLightIconLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private LaneGuideTrafficLightIconLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected LaneGuideTrafficLightIconLayerItem(long j, boolean z) {
        this(new LaneGuideTrafficLightIconLayerItemRouter("LaneGuideTrafficLightIconLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILaneGuideTrafficLightIconLayerItem.class}, new Object[]{this});
    }

    public LaneGuideTrafficLightIconLayerItem() {
        this(new LaneGuideTrafficLightIconLayerItemRouter("LaneGuideTrafficLightIconLayerItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILaneGuideTrafficLightIconLayerItem.class}, new Object[]{this});
    }

    public LaneGuideTrafficLightIconLayerItem(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl) {
        super(laneGuideTrafficLightIconLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(laneGuideTrafficLightIconLayerItemImpl);
    }

    private void $constructor(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl) {
        if (laneGuideTrafficLightIconLayerItemImpl != null) {
            this.mService = laneGuideTrafficLightIconLayerItemImpl;
            this.mTargetId = String.format("LaneGuideTrafficLightIconLayerItem_%s_%d", String.valueOf(LaneGuideTrafficLightIconLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public LaneGuideTrafficLightIconLayerItemImpl getService() {
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
        return LaneGuideTrafficLightIconLayerItemImpl.getClassTypeName();
    }
}
