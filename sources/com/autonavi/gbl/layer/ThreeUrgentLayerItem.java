package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.ThreeUrgentLayerItemImpl;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.model.ThreeUrgentType;
import com.autonavi.gbl.layer.observer.IThreeUrgentLayerItem;
import com.autonavi.gbl.layer.router.ThreeUrgentLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = ThreeUrgentLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class ThreeUrgentLayerItem extends PointLayerItem implements IThreeUrgentLayerItem {
    private static String PACKAGE = ReflexTool.PN(ThreeUrgentLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private ThreeUrgentLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected ThreeUrgentLayerItem(long j, boolean z) {
        this(new ThreeUrgentLayerItemRouter("ThreeUrgentLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IThreeUrgentLayerItem.class}, new Object[]{this});
    }

    public ThreeUrgentLayerItem(@ThreeUrgentType.ThreeUrgentType1 int i) {
        this(new ThreeUrgentLayerItemRouter("ThreeUrgentLayerItem", null, i));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IThreeUrgentLayerItem.class}, new Object[]{this});
    }

    public ThreeUrgentLayerItem(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl) {
        super(threeUrgentLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(threeUrgentLayerItemImpl);
    }

    private void $constructor(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl) {
        if (threeUrgentLayerItemImpl != null) {
            this.mService = threeUrgentLayerItemImpl;
            this.mTargetId = String.format("ThreeUrgentLayerItem_%s_%d", String.valueOf(ThreeUrgentLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public ThreeUrgentLayerItemImpl getService() {
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
        return ThreeUrgentLayerItemImpl.getClassTypeName();
    }

    public void setMType(@ThreeUrgentType.ThreeUrgentType1 int i) {
        ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl = this.mService;
        if (threeUrgentLayerItemImpl != null) {
            threeUrgentLayerItemImpl.$explicit_setMType(i);
        }
    }

    public void setMBigBubbleStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl = this.mService;
        if (threeUrgentLayerItemImpl != null) {
            threeUrgentLayerItemImpl.$explicit_setMBigBubbleStyle(i);
        }
    }

    public void setMbIsMaxOverSpeedPoint(boolean z) {
        ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl = this.mService;
        if (threeUrgentLayerItemImpl != null) {
            threeUrgentLayerItemImpl.$explicit_setMbIsMaxOverSpeedPoint(z);
        }
    }

    public void setMPassingSpeed(int i) {
        ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl = this.mService;
        if (threeUrgentLayerItemImpl != null) {
            threeUrgentLayerItemImpl.$explicit_setMPassingSpeed(i);
        }
    }

    public void setMElectronicEyeSpeed(int i) {
        ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl = this.mService;
        if (threeUrgentLayerItemImpl != null) {
            threeUrgentLayerItemImpl.$explicit_setMElectronicEyeSpeed(i);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IThreeUrgentLayerItem
    @ThreeUrgentType.ThreeUrgentType1
    public int getMType() {
        ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl = this.mService;
        if (threeUrgentLayerItemImpl != null) {
            return threeUrgentLayerItemImpl.$explicit_getMType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.IThreeUrgentLayerItem
    @BizDirectionStyle.BizDirectionStyle1
    public int getMBigBubbleStyle() {
        ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl = this.mService;
        if (threeUrgentLayerItemImpl != null) {
            return threeUrgentLayerItemImpl.$explicit_getMBigBubbleStyle();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.IThreeUrgentLayerItem
    public boolean getMbIsMaxOverSpeedPoint() {
        ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl = this.mService;
        if (threeUrgentLayerItemImpl != null) {
            return threeUrgentLayerItemImpl.$explicit_getMbIsMaxOverSpeedPoint();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.IThreeUrgentLayerItem
    public int getMPassingSpeed() {
        ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl = this.mService;
        if (threeUrgentLayerItemImpl != null) {
            return threeUrgentLayerItemImpl.$explicit_getMPassingSpeed();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.IThreeUrgentLayerItem
    public int getMElectronicEyeSpeed() {
        ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl = this.mService;
        if (threeUrgentLayerItemImpl != null) {
            return threeUrgentLayerItemImpl.$explicit_getMElectronicEyeSpeed();
        }
        return 0;
    }
}
