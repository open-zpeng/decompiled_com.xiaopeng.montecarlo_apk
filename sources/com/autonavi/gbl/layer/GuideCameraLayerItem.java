package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.path.model.SubCameraExtType;
import com.autonavi.gbl.guide.model.NaviSubCameraExt;
import com.autonavi.gbl.layer.impl.GuideCameraLayerItemImpl;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.model.BizGuideCameraInfo;
import com.autonavi.gbl.layer.observer.IGuideCameraLayerItem;
import com.autonavi.gbl.layer.router.GuideCameraLayerItemRouter;
import com.autonavi.gbl.map.layer.QuadrantLayerItem;
import com.autonavi.gbl.map.layer.model.QuadrantType;
import java.util.ArrayList;
@IntfAuto(target = GuideCameraLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class GuideCameraLayerItem extends QuadrantLayerItem implements IGuideCameraLayerItem {
    private static String PACKAGE = ReflexTool.PN(GuideCameraLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private GuideCameraLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected GuideCameraLayerItem(long j, boolean z) {
        this(new GuideCameraLayerItemRouter("GuideCameraLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IGuideCameraLayerItem.class}, new Object[]{this});
    }

    public GuideCameraLayerItem(BizGuideCameraInfo bizGuideCameraInfo, @BizDirectionStyle.BizDirectionStyle1 int i, int i2) {
        this(new GuideCameraLayerItemRouter("GuideCameraLayerItem", null, bizGuideCameraInfo, i, i2));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IGuideCameraLayerItem.class}, new Object[]{this});
    }

    public GuideCameraLayerItem(@QuadrantType.QuadrantType1 int i, long j, BizGuideCameraInfo bizGuideCameraInfo, @BizDirectionStyle.BizDirectionStyle1 int i2, int i3) {
        this(new GuideCameraLayerItemRouter("GuideCameraLayerItem", null, i, j, bizGuideCameraInfo, i2, i3));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IGuideCameraLayerItem.class}, new Object[]{this});
    }

    public GuideCameraLayerItem(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        super(guideCameraLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(guideCameraLayerItemImpl);
    }

    private void $constructor(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        if (guideCameraLayerItemImpl != null) {
            this.mService = guideCameraLayerItemImpl;
            this.mTargetId = String.format("GuideCameraLayerItem_%s_%d", String.valueOf(GuideCameraLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public GuideCameraLayerItemImpl getService() {
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
        return GuideCameraLayerItemImpl.getClassTypeName();
    }

    public void setMCameraExtType(@SubCameraExtType.SubCameraExtType1 int i) {
        GuideCameraLayerItemImpl guideCameraLayerItemImpl = this.mService;
        if (guideCameraLayerItemImpl != null) {
            guideCameraLayerItemImpl.$explicit_setMCameraExtType(i);
        }
    }

    public void setMDirectionStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        GuideCameraLayerItemImpl guideCameraLayerItemImpl = this.mService;
        if (guideCameraLayerItemImpl != null) {
            guideCameraLayerItemImpl.$explicit_setMDirectionStyle(i);
        }
    }

    public void setMCameraSpeed(int i) {
        GuideCameraLayerItemImpl guideCameraLayerItemImpl = this.mService;
        if (guideCameraLayerItemImpl != null) {
            guideCameraLayerItemImpl.$explicit_setMCameraSpeed(i);
        }
    }

    public void setMPosition(Coord3DDouble coord3DDouble) {
        GuideCameraLayerItemImpl guideCameraLayerItemImpl = this.mService;
        if (guideCameraLayerItemImpl != null) {
            guideCameraLayerItemImpl.$explicit_setMPosition(coord3DDouble);
        }
    }

    public void setMDistance(int i) {
        GuideCameraLayerItemImpl guideCameraLayerItemImpl = this.mService;
        if (guideCameraLayerItemImpl != null) {
            guideCameraLayerItemImpl.$explicit_setMDistance(i);
        }
    }

    public void setMNeedShowPenalty(boolean z) {
        GuideCameraLayerItemImpl guideCameraLayerItemImpl = this.mService;
        if (guideCameraLayerItemImpl != null) {
            guideCameraLayerItemImpl.$explicit_setMNeedShowPenalty(z);
        }
    }

    public void setMWantDirectionStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        GuideCameraLayerItemImpl guideCameraLayerItemImpl = this.mService;
        if (guideCameraLayerItemImpl != null) {
            guideCameraLayerItemImpl.$explicit_setMWantDirectionStyle(i);
        }
    }

    public void setMNeedShowNewCamera(boolean z) {
        GuideCameraLayerItemImpl guideCameraLayerItemImpl = this.mService;
        if (guideCameraLayerItemImpl != null) {
            guideCameraLayerItemImpl.$explicit_setMNeedShowNewCamera(z);
        }
    }

    public void setMCameraId(long j) {
        GuideCameraLayerItemImpl guideCameraLayerItemImpl = this.mService;
        if (guideCameraLayerItemImpl != null) {
            guideCameraLayerItemImpl.$explicit_setMCameraId(j);
        }
    }

    public void setMRunTimeShowPenalty(boolean z) {
        GuideCameraLayerItemImpl guideCameraLayerItemImpl = this.mService;
        if (guideCameraLayerItemImpl != null) {
            guideCameraLayerItemImpl.$explicit_setMRunTimeShowPenalty(z);
        }
    }

    public void setMRunTimeShowNewCamera(boolean z) {
        GuideCameraLayerItemImpl guideCameraLayerItemImpl = this.mService;
        if (guideCameraLayerItemImpl != null) {
            guideCameraLayerItemImpl.$explicit_setMRunTimeShowNewCamera(z);
        }
    }

    public void setMAggregatedExts(ArrayList<NaviSubCameraExt> arrayList) {
        GuideCameraLayerItemImpl guideCameraLayerItemImpl = this.mService;
        if (guideCameraLayerItemImpl != null) {
            guideCameraLayerItemImpl.$explicit_setMAggregatedExts(arrayList);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideCameraLayerItem
    @SubCameraExtType.SubCameraExtType1
    public int getMCameraExtType() {
        GuideCameraLayerItemImpl guideCameraLayerItemImpl = this.mService;
        if (guideCameraLayerItemImpl != null) {
            return guideCameraLayerItemImpl.$explicit_getMCameraExtType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideCameraLayerItem
    @BizDirectionStyle.BizDirectionStyle1
    public int getMDirectionStyle() {
        GuideCameraLayerItemImpl guideCameraLayerItemImpl = this.mService;
        if (guideCameraLayerItemImpl != null) {
            return guideCameraLayerItemImpl.$explicit_getMDirectionStyle();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideCameraLayerItem
    public int getMCameraSpeed() {
        GuideCameraLayerItemImpl guideCameraLayerItemImpl = this.mService;
        if (guideCameraLayerItemImpl != null) {
            return guideCameraLayerItemImpl.$explicit_getMCameraSpeed();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideCameraLayerItem
    public Coord3DDouble getMPosition() {
        GuideCameraLayerItemImpl guideCameraLayerItemImpl = this.mService;
        if (guideCameraLayerItemImpl != null) {
            return guideCameraLayerItemImpl.$explicit_getMPosition();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideCameraLayerItem
    public int getMDistance() {
        GuideCameraLayerItemImpl guideCameraLayerItemImpl = this.mService;
        if (guideCameraLayerItemImpl != null) {
            return guideCameraLayerItemImpl.$explicit_getMDistance();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideCameraLayerItem
    public boolean getMNeedShowPenalty() {
        GuideCameraLayerItemImpl guideCameraLayerItemImpl = this.mService;
        if (guideCameraLayerItemImpl != null) {
            return guideCameraLayerItemImpl.$explicit_getMNeedShowPenalty();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideCameraLayerItem
    @BizDirectionStyle.BizDirectionStyle1
    public int getMWantDirectionStyle() {
        GuideCameraLayerItemImpl guideCameraLayerItemImpl = this.mService;
        if (guideCameraLayerItemImpl != null) {
            return guideCameraLayerItemImpl.$explicit_getMWantDirectionStyle();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideCameraLayerItem
    public boolean getMNeedShowNewCamera() {
        GuideCameraLayerItemImpl guideCameraLayerItemImpl = this.mService;
        if (guideCameraLayerItemImpl != null) {
            return guideCameraLayerItemImpl.$explicit_getMNeedShowNewCamera();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideCameraLayerItem
    public long getMCameraId() {
        GuideCameraLayerItemImpl guideCameraLayerItemImpl = this.mService;
        if (guideCameraLayerItemImpl != null) {
            return guideCameraLayerItemImpl.$explicit_getMCameraId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideCameraLayerItem
    public boolean getMRunTimeShowPenalty() {
        GuideCameraLayerItemImpl guideCameraLayerItemImpl = this.mService;
        if (guideCameraLayerItemImpl != null) {
            return guideCameraLayerItemImpl.$explicit_getMRunTimeShowPenalty();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideCameraLayerItem
    public boolean getMRunTimeShowNewCamera() {
        GuideCameraLayerItemImpl guideCameraLayerItemImpl = this.mService;
        if (guideCameraLayerItemImpl != null) {
            return guideCameraLayerItemImpl.$explicit_getMRunTimeShowNewCamera();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideCameraLayerItem
    public ArrayList<NaviSubCameraExt> getMAggregatedExts() {
        GuideCameraLayerItemImpl guideCameraLayerItemImpl = this.mService;
        if (guideCameraLayerItemImpl != null) {
            return guideCameraLayerItemImpl.$explicit_getMAggregatedExts();
        }
        return null;
    }
}
