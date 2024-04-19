package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.path.model.CameraType;
import com.autonavi.gbl.layer.impl.GuideIntervalCameraLayerItemImpl;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.observer.IGuideIntervalCameraLayerItem;
import com.autonavi.gbl.layer.router.GuideIntervalCameraLayerItemRouter;
import com.autonavi.gbl.map.layer.QuadrantLayerItem;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(target = GuideIntervalCameraLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class GuideIntervalCameraLayerItem extends QuadrantLayerItem implements IGuideIntervalCameraLayerItem {
    private static String PACKAGE = ReflexTool.PN(GuideIntervalCameraLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private GuideIntervalCameraLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected GuideIntervalCameraLayerItem(long j, boolean z) {
        this(new GuideIntervalCameraLayerItemRouter("GuideIntervalCameraLayerItem", (IGuideIntervalCameraLayerItem) null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IGuideIntervalCameraLayerItem.class}, new Object[]{this});
    }

    public GuideIntervalCameraLayerItem(@CameraType.CameraType1 int i, int i2) {
        this(new GuideIntervalCameraLayerItemRouter("GuideIntervalCameraLayerItem", (IGuideIntervalCameraLayerItem) null, i, i2));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IGuideIntervalCameraLayerItem.class}, new Object[]{this});
    }

    public GuideIntervalCameraLayerItem(@QuadrantType.QuadrantType1 int i, long j, @CameraType.CameraType1 int i2, int i3) {
        this(new GuideIntervalCameraLayerItemRouter("GuideIntervalCameraLayerItem", null, i, j, i2, i3));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IGuideIntervalCameraLayerItem.class}, new Object[]{this});
    }

    public GuideIntervalCameraLayerItem(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        super(guideIntervalCameraLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(guideIntervalCameraLayerItemImpl);
    }

    private void $constructor(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        if (guideIntervalCameraLayerItemImpl != null) {
            this.mService = guideIntervalCameraLayerItemImpl;
            this.mTargetId = String.format("GuideIntervalCameraLayerItem_%s_%d", String.valueOf(GuideIntervalCameraLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public GuideIntervalCameraLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.GuideIntervalCameraLayerItem.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.GuideIntervalCameraLayerItem.2
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
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.GuideIntervalCameraLayerItem.3
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
        return GuideIntervalCameraLayerItemImpl.getClassTypeName();
    }

    public void setMCameraType(@CameraType.CameraType1 int i) {
        GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl = this.mService;
        if (guideIntervalCameraLayerItemImpl != null) {
            guideIntervalCameraLayerItemImpl.$explicit_setMCameraType(i);
        }
    }

    public void setMSpeed(int i) {
        GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl = this.mService;
        if (guideIntervalCameraLayerItemImpl != null) {
            guideIntervalCameraLayerItemImpl.$explicit_setMSpeed(i);
        }
    }

    public void setMDirectionStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl = this.mService;
        if (guideIntervalCameraLayerItemImpl != null) {
            guideIntervalCameraLayerItemImpl.$explicit_setMDirectionStyle(i);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideIntervalCameraLayerItem
    @CameraType.CameraType1
    public int getMCameraType() {
        GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl = this.mService;
        if (guideIntervalCameraLayerItemImpl != null) {
            return guideIntervalCameraLayerItemImpl.$explicit_getMCameraType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideIntervalCameraLayerItem
    public int getMSpeed() {
        GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl = this.mService;
        if (guideIntervalCameraLayerItemImpl != null) {
            return guideIntervalCameraLayerItemImpl.$explicit_getMSpeed();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideIntervalCameraLayerItem
    @BizDirectionStyle.BizDirectionStyle1
    public int getMDirectionStyle() {
        GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl = this.mService;
        if (guideIntervalCameraLayerItemImpl != null) {
            return guideIntervalCameraLayerItemImpl.$explicit_getMDirectionStyle();
        }
        return Integer.MIN_VALUE;
    }
}
