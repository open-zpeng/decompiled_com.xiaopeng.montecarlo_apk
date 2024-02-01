package com.autonavi.gbl.map.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.map.layer.impl.LightBeamLayerItemImpl;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.observer.ILightBeamLayerItem;
import com.autonavi.gbl.map.router.LightBeamLayerItemRouter;
@IntfAuto(target = LightBeamLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class LightBeamLayerItem extends LayerItem implements ILightBeamLayerItem {
    private static String PACKAGE = ReflexTool.PN(LightBeamLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private LightBeamLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected LightBeamLayerItem(long j, boolean z) {
        this(new LightBeamLayerItemRouter("LightBeamLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILightBeamLayerItem.class}, new Object[]{this});
    }

    public LightBeamLayerItem() {
        this(new LightBeamLayerItemRouter("LightBeamLayerItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILightBeamLayerItem.class}, new Object[]{this});
    }

    public LightBeamLayerItem(LightBeamLayerItemImpl lightBeamLayerItemImpl) {
        super(lightBeamLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(lightBeamLayerItemImpl);
    }

    private void $constructor(LightBeamLayerItemImpl lightBeamLayerItemImpl) {
        if (lightBeamLayerItemImpl != null) {
            this.mService = lightBeamLayerItemImpl;
            this.mTargetId = String.format("LightBeamLayerItem_%s_%d", String.valueOf(LightBeamLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.LayerItem
    public LightBeamLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
        super.unbind();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void clean() {
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
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
        return LightBeamLayerItemImpl.getClassTypeName();
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void updateStyle() {
        LightBeamLayerItemImpl lightBeamLayerItemImpl = this.mService;
        if (lightBeamLayerItemImpl != null) {
            lightBeamLayerItemImpl.$explicit_updateStyle();
        }
    }

    public void setScale(float f, float f2) {
        LightBeamLayerItemImpl lightBeamLayerItemImpl = this.mService;
        if (lightBeamLayerItemImpl != null) {
            lightBeamLayerItemImpl.$explicit_setScale(f, f2);
        }
    }

    public void setPosition(Coord3DDouble coord3DDouble) {
        LightBeamLayerItemImpl lightBeamLayerItemImpl = this.mService;
        if (lightBeamLayerItemImpl != null) {
            lightBeamLayerItemImpl.$explicit_setPosition(coord3DDouble);
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem, com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.layer.observer.IArrowLayerItem
    @LayerItemType.LayerItemType1
    public int getItemType() {
        LightBeamLayerItemImpl lightBeamLayerItemImpl = this.mService;
        if (lightBeamLayerItemImpl != null) {
            return lightBeamLayerItemImpl.$explicit_getItemType();
        }
        return Integer.MIN_VALUE;
    }
}
