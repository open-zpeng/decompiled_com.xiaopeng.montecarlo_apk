package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.guide.model.TrafficLight;
import com.autonavi.gbl.layer.impl.GuideTrafficLightLayerItemImpl;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.observer.IGuideTrafficLightLayerItem;
import com.autonavi.gbl.layer.router.GuideTrafficLightLayerItemRouter;
import com.autonavi.gbl.map.layer.QuadrantLayerItemImpl;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(target = GuideTrafficLightLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class GuideTrafficLightLayerItem extends QuadrantLayerItemImpl implements IGuideTrafficLightLayerItem {
    private static String PACKAGE = ReflexTool.PN(GuideTrafficLightLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private GuideTrafficLightLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected GuideTrafficLightLayerItem(long j, boolean z) {
        this(new GuideTrafficLightLayerItemRouter("GuideTrafficLightLayerItem", (IGuideTrafficLightLayerItem) null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IGuideTrafficLightLayerItem.class}, new Object[]{this});
    }

    public GuideTrafficLightLayerItem(@TrafficLight.TrafficLight1 int i, int i2, @BizDirectionStyle.BizDirectionStyle1 int i3) {
        this(new GuideTrafficLightLayerItemRouter("GuideTrafficLightLayerItem", null, i, i2, i3));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IGuideTrafficLightLayerItem.class}, new Object[]{this});
    }

    public GuideTrafficLightLayerItem(@TrafficLight.TrafficLight1 int i, int i2) {
        this(new GuideTrafficLightLayerItemRouter("GuideTrafficLightLayerItem", (IGuideTrafficLightLayerItem) null, i, i2));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IGuideTrafficLightLayerItem.class}, new Object[]{this});
    }

    public GuideTrafficLightLayerItem(@QuadrantType.QuadrantType1 int i, long j, @TrafficLight.TrafficLight1 int i2, int i3) {
        this(new GuideTrafficLightLayerItemRouter("GuideTrafficLightLayerItem", null, i, j, i2, i3));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IGuideTrafficLightLayerItem.class}, new Object[]{this});
    }

    public GuideTrafficLightLayerItem(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        super(guideTrafficLightLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(guideTrafficLightLayerItemImpl);
    }

    private void $constructor(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        if (guideTrafficLightLayerItemImpl != null) {
            this.mService = guideTrafficLightLayerItemImpl;
            this.mTargetId = String.format("GuideTrafficLightLayerItem_%s_%d", String.valueOf(GuideTrafficLightLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public GuideTrafficLightLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.GuideTrafficLightLayerItem.1
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
    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.GuideTrafficLightLayerItem.2
        }));
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public synchronized void delete() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.GuideTrafficLightLayerItem.3
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
        return GuideTrafficLightLayerItemImpl.getClassTypeName();
    }

    public void setMDirectionStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl = this.mService;
        if (guideTrafficLightLayerItemImpl != null) {
            guideTrafficLightLayerItemImpl.$explicit_setMDirectionStyle(i);
        }
    }

    public void setMLightStatus(@TrafficLight.TrafficLight1 int i) {
        GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl = this.mService;
        if (guideTrafficLightLayerItemImpl != null) {
            guideTrafficLightLayerItemImpl.$explicit_setMLightStatus(i);
        }
    }

    public void setMLightCountDown(int i) {
        GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl = this.mService;
        if (guideTrafficLightLayerItemImpl != null) {
            guideTrafficLightLayerItemImpl.$explicit_setMLightCountDown(i);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideTrafficLightLayerItem
    @BizDirectionStyle.BizDirectionStyle1
    public int getMDirectionStyle() {
        GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl = this.mService;
        if (guideTrafficLightLayerItemImpl != null) {
            return guideTrafficLightLayerItemImpl.$explicit_getMDirectionStyle();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideTrafficLightLayerItem
    @TrafficLight.TrafficLight1
    public int getMLightStatus() {
        GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl = this.mService;
        if (guideTrafficLightLayerItemImpl != null) {
            return guideTrafficLightLayerItemImpl.$explicit_getMLightStatus();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideTrafficLightLayerItem
    public int getMLightCountDown() {
        GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl = this.mService;
        if (guideTrafficLightLayerItemImpl != null) {
            return guideTrafficLightLayerItemImpl.$explicit_getMLightCountDown();
        }
        return 0;
    }
}
