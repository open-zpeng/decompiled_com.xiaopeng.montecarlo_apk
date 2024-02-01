package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.path.model.SubCameraExtType;
import com.autonavi.gbl.guide.model.NaviSubCameraExt;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.layer.impl.LaneGuideCameraLayerItemImpl;
import com.autonavi.gbl.layer.observer.ILaneGuideCameraLayerItem;
import com.autonavi.gbl.layer.router.LaneGuideCameraLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
import java.util.ArrayList;
@IntfAuto(target = LaneGuideCameraLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class LaneGuideCameraLayerItem extends PointLayerItem implements ILaneGuideCameraLayerItem {
    private static String PACKAGE = ReflexTool.PN(LaneGuideCameraLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private LaneGuideCameraLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected LaneGuideCameraLayerItem(long j, boolean z) {
        this(new LaneGuideCameraLayerItemRouter("LaneGuideCameraLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILaneGuideCameraLayerItem.class}, new Object[]{this});
    }

    public LaneGuideCameraLayerItem() {
        this(new LaneGuideCameraLayerItemRouter("LaneGuideCameraLayerItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILaneGuideCameraLayerItem.class}, new Object[]{this});
    }

    public LaneGuideCameraLayerItem(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl) {
        super(laneGuideCameraLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(laneGuideCameraLayerItemImpl);
    }

    private void $constructor(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl) {
        if (laneGuideCameraLayerItemImpl != null) {
            this.mService = laneGuideCameraLayerItemImpl;
            this.mTargetId = String.format("LaneGuideCameraLayerItem_%s_%d", String.valueOf(LaneGuideCameraLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public LaneGuideCameraLayerItemImpl getService() {
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
        return LaneGuideCameraLayerItemImpl.getClassTypeName();
    }

    public void setMDirectionType(@BubbleDirectionType.BubbleDirectionType1 int i) {
        LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl = this.mService;
        if (laneGuideCameraLayerItemImpl != null) {
            laneGuideCameraLayerItemImpl.$explicit_setMDirectionType(i);
        }
    }

    public void setMCameraExtType(@SubCameraExtType.SubCameraExtType1 int i) {
        LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl = this.mService;
        if (laneGuideCameraLayerItemImpl != null) {
            laneGuideCameraLayerItemImpl.$explicit_setMCameraExtType(i);
        }
    }

    public void setMCameraSpeed(int i) {
        LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl = this.mService;
        if (laneGuideCameraLayerItemImpl != null) {
            laneGuideCameraLayerItemImpl.$explicit_setMCameraSpeed(i);
        }
    }

    public void setMDistance(int i) {
        LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl = this.mService;
        if (laneGuideCameraLayerItemImpl != null) {
            laneGuideCameraLayerItemImpl.$explicit_setMDistance(i);
        }
    }

    public void setMCameraId(long j) {
        LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl = this.mService;
        if (laneGuideCameraLayerItemImpl != null) {
            laneGuideCameraLayerItemImpl.$explicit_setMCameraId(j);
        }
    }

    public void setNeedShowPenalty(boolean z) {
        LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl = this.mService;
        if (laneGuideCameraLayerItemImpl != null) {
            laneGuideCameraLayerItemImpl.$explicit_setNeedShowPenalty(z);
        }
    }

    public void setNeedShowNewCamera(boolean z) {
        LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl = this.mService;
        if (laneGuideCameraLayerItemImpl != null) {
            laneGuideCameraLayerItemImpl.$explicit_setNeedShowNewCamera(z);
        }
    }

    public void setShowRed(boolean z) {
        LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl = this.mService;
        if (laneGuideCameraLayerItemImpl != null) {
            laneGuideCameraLayerItemImpl.$explicit_setShowRed(z);
        }
    }

    public void setAggregatedExts(ArrayList<NaviSubCameraExt> arrayList) {
        LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl = this.mService;
        if (laneGuideCameraLayerItemImpl != null) {
            laneGuideCameraLayerItemImpl.$explicit_setAggregatedExts(arrayList);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideCameraLayerItem
    @BubbleDirectionType.BubbleDirectionType1
    public int getMDirectionType() {
        LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl = this.mService;
        if (laneGuideCameraLayerItemImpl != null) {
            return laneGuideCameraLayerItemImpl.$explicit_getMDirectionType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideCameraLayerItem
    @SubCameraExtType.SubCameraExtType1
    public int getMCameraExtType() {
        LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl = this.mService;
        if (laneGuideCameraLayerItemImpl != null) {
            return laneGuideCameraLayerItemImpl.$explicit_getMCameraExtType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideCameraLayerItem
    public int getMCameraSpeed() {
        LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl = this.mService;
        if (laneGuideCameraLayerItemImpl != null) {
            return laneGuideCameraLayerItemImpl.$explicit_getMCameraSpeed();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideCameraLayerItem
    public int getMDistance() {
        LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl = this.mService;
        if (laneGuideCameraLayerItemImpl != null) {
            return laneGuideCameraLayerItemImpl.$explicit_getMDistance();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideCameraLayerItem
    public long getMCameraId() {
        LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl = this.mService;
        if (laneGuideCameraLayerItemImpl != null) {
            return laneGuideCameraLayerItemImpl.$explicit_getMCameraId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideCameraLayerItem
    public boolean getNeedShowPenalty() {
        LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl = this.mService;
        if (laneGuideCameraLayerItemImpl != null) {
            return laneGuideCameraLayerItemImpl.$explicit_getNeedShowPenalty();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideCameraLayerItem
    public boolean getNeedShowNewCamera() {
        LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl = this.mService;
        if (laneGuideCameraLayerItemImpl != null) {
            return laneGuideCameraLayerItemImpl.$explicit_getNeedShowNewCamera();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideCameraLayerItem
    public boolean getShowRed() {
        LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl = this.mService;
        if (laneGuideCameraLayerItemImpl != null) {
            return laneGuideCameraLayerItemImpl.$explicit_getShowRed();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.ILaneGuideCameraLayerItem
    public ArrayList<NaviSubCameraExt> getAggregatedExts() {
        LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl = this.mService;
        if (laneGuideCameraLayerItemImpl != null) {
            return laneGuideCameraLayerItemImpl.$explicit_getAggregatedExts();
        }
        return null;
    }
}
