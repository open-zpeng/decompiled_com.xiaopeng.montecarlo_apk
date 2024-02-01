package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.GuideTrafficSignalLightLayerItemImpl;
import com.autonavi.gbl.layer.model.TrafficLightCountDownStatus;
import com.autonavi.gbl.layer.observer.IGuideTrafficSignalLightLayerItem;
import com.autonavi.gbl.layer.router.GuideTrafficSignalLightLayerItemRouter;
import com.autonavi.gbl.map.layer.QuadrantLayerItem;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(target = GuideTrafficSignalLightLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class GuideTrafficSignalLightLayerItem extends QuadrantLayerItem implements IGuideTrafficSignalLightLayerItem {
    private static String PACKAGE = ReflexTool.PN(GuideTrafficSignalLightLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private GuideTrafficSignalLightLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected GuideTrafficSignalLightLayerItem(long j, boolean z) {
        this(new GuideTrafficSignalLightLayerItemRouter("GuideTrafficSignalLightLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IGuideTrafficSignalLightLayerItem.class}, new Object[]{this});
    }

    public GuideTrafficSignalLightLayerItem(@QuadrantType.QuadrantType1 int i) {
        this(new GuideTrafficSignalLightLayerItemRouter("GuideTrafficSignalLightLayerItem", null, i));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IGuideTrafficSignalLightLayerItem.class}, new Object[]{this});
    }

    public GuideTrafficSignalLightLayerItem(GuideTrafficSignalLightLayerItemImpl guideTrafficSignalLightLayerItemImpl) {
        super(guideTrafficSignalLightLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(guideTrafficSignalLightLayerItemImpl);
    }

    private void $constructor(GuideTrafficSignalLightLayerItemImpl guideTrafficSignalLightLayerItemImpl) {
        if (guideTrafficSignalLightLayerItemImpl != null) {
            this.mService = guideTrafficSignalLightLayerItemImpl;
            this.mTargetId = String.format("GuideTrafficSignalLightLayerItem_%s_%d", String.valueOf(GuideTrafficSignalLightLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public GuideTrafficSignalLightLayerItemImpl getService() {
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
        return GuideTrafficSignalLightLayerItemImpl.getClassTypeName();
    }

    public void setWaitRoundCount(long j) {
        GuideTrafficSignalLightLayerItemImpl guideTrafficSignalLightLayerItemImpl = this.mService;
        if (guideTrafficSignalLightLayerItemImpl != null) {
            guideTrafficSignalLightLayerItemImpl.$explicit_setWaitRoundCount(j);
        }
    }

    public void setCrossManeuverID(int i) {
        GuideTrafficSignalLightLayerItemImpl guideTrafficSignalLightLayerItemImpl = this.mService;
        if (guideTrafficSignalLightLayerItemImpl != null) {
            guideTrafficSignalLightLayerItemImpl.$explicit_setCrossManeuverID(i);
        }
    }

    public void setTrafficLightStatus(@TrafficLightCountDownStatus.TrafficLightCountDownStatus1 int i) {
        GuideTrafficSignalLightLayerItemImpl guideTrafficSignalLightLayerItemImpl = this.mService;
        if (guideTrafficSignalLightLayerItemImpl != null) {
            guideTrafficSignalLightLayerItemImpl.$explicit_setTrafficLightStatus(i);
        }
    }

    public void setLightCountDown(int i) {
        GuideTrafficSignalLightLayerItemImpl guideTrafficSignalLightLayerItemImpl = this.mService;
        if (guideTrafficSignalLightLayerItemImpl != null) {
            guideTrafficSignalLightLayerItemImpl.$explicit_setLightCountDown(i);
        }
    }

    public void setLightAlpha(float f) {
        GuideTrafficSignalLightLayerItemImpl guideTrafficSignalLightLayerItemImpl = this.mService;
        if (guideTrafficSignalLightLayerItemImpl != null) {
            guideTrafficSignalLightLayerItemImpl.$explicit_setLightAlpha(f);
        }
    }

    public void setArrowDirectionAlpha(float f) {
        GuideTrafficSignalLightLayerItemImpl guideTrafficSignalLightLayerItemImpl = this.mService;
        if (guideTrafficSignalLightLayerItemImpl != null) {
            guideTrafficSignalLightLayerItemImpl.$explicit_setArrowDirectionAlpha(f);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideTrafficSignalLightLayerItem
    public long getWaitRoundCount() {
        GuideTrafficSignalLightLayerItemImpl guideTrafficSignalLightLayerItemImpl = this.mService;
        if (guideTrafficSignalLightLayerItemImpl != null) {
            return guideTrafficSignalLightLayerItemImpl.$explicit_getWaitRoundCount();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideTrafficSignalLightLayerItem
    public int getCrossManeuverID() {
        GuideTrafficSignalLightLayerItemImpl guideTrafficSignalLightLayerItemImpl = this.mService;
        if (guideTrafficSignalLightLayerItemImpl != null) {
            return guideTrafficSignalLightLayerItemImpl.$explicit_getCrossManeuverID();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideTrafficSignalLightLayerItem
    @TrafficLightCountDownStatus.TrafficLightCountDownStatus1
    public int getTrafficLightStatus() {
        GuideTrafficSignalLightLayerItemImpl guideTrafficSignalLightLayerItemImpl = this.mService;
        if (guideTrafficSignalLightLayerItemImpl != null) {
            return guideTrafficSignalLightLayerItemImpl.$explicit_getTrafficLightStatus();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideTrafficSignalLightLayerItem
    public int getLightCountDown() {
        GuideTrafficSignalLightLayerItemImpl guideTrafficSignalLightLayerItemImpl = this.mService;
        if (guideTrafficSignalLightLayerItemImpl != null) {
            return guideTrafficSignalLightLayerItemImpl.$explicit_getLightCountDown();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideTrafficSignalLightLayerItem
    public float getLightAlpha() {
        GuideTrafficSignalLightLayerItemImpl guideTrafficSignalLightLayerItemImpl = this.mService;
        if (guideTrafficSignalLightLayerItemImpl != null) {
            return guideTrafficSignalLightLayerItemImpl.$explicit_getLightAlpha();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideTrafficSignalLightLayerItem
    public float getArrowDirectionAlpha() {
        GuideTrafficSignalLightLayerItemImpl guideTrafficSignalLightLayerItemImpl = this.mService;
        if (guideTrafficSignalLightLayerItemImpl != null) {
            return guideTrafficSignalLightLayerItemImpl.$explicit_getArrowDirectionAlpha();
        }
        return 0.0f;
    }
}
