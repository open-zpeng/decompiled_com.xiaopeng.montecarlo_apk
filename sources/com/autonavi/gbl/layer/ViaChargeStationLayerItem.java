package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.ViaChargeStationLayerItemImpl;
import com.autonavi.gbl.layer.observer.IViaChargeStationLayerItem;
import com.autonavi.gbl.layer.router.ViaChargeStationLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = ViaChargeStationLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class ViaChargeStationLayerItem extends PointLayerItem implements IViaChargeStationLayerItem {
    private static String PACKAGE = ReflexTool.PN(ViaChargeStationLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private ViaChargeStationLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected ViaChargeStationLayerItem(long j, boolean z) {
        this(new ViaChargeStationLayerItemRouter("ViaChargeStationLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IViaChargeStationLayerItem.class}, new Object[]{this});
    }

    public ViaChargeStationLayerItem(boolean z) {
        this(new ViaChargeStationLayerItemRouter("ViaChargeStationLayerItem", null, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IViaChargeStationLayerItem.class}, new Object[]{this});
    }

    public ViaChargeStationLayerItem(ViaChargeStationLayerItemImpl viaChargeStationLayerItemImpl) {
        super(viaChargeStationLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(viaChargeStationLayerItemImpl);
    }

    private void $constructor(ViaChargeStationLayerItemImpl viaChargeStationLayerItemImpl) {
        if (viaChargeStationLayerItemImpl != null) {
            this.mService = viaChargeStationLayerItemImpl;
            this.mTargetId = String.format("ViaChargeStationLayerItem_%s_%d", String.valueOf(ViaChargeStationLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public ViaChargeStationLayerItemImpl getService() {
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
        return ViaChargeStationLayerItemImpl.getClassTypeName();
    }

    public void setIsEagleEye(boolean z) {
        ViaChargeStationLayerItemImpl viaChargeStationLayerItemImpl = this.mService;
        if (viaChargeStationLayerItemImpl != null) {
            viaChargeStationLayerItemImpl.$explicit_setIsEagleEye(z);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IViaChargeStationLayerItem
    public boolean getIsEagleEye() {
        ViaChargeStationLayerItemImpl viaChargeStationLayerItemImpl = this.mService;
        if (viaChargeStationLayerItemImpl != null) {
            return viaChargeStationLayerItemImpl.$explicit_getIsEagleEye();
        }
        return false;
    }
}
