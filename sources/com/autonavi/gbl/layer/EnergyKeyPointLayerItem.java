package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.EnergyKeyPointLayerItemImpl;
import com.autonavi.gbl.layer.observer.IEnergyKeyPointLayerItem;
import com.autonavi.gbl.layer.router.EnergyKeyPointLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = EnergyKeyPointLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class EnergyKeyPointLayerItem extends PointLayerItem implements IEnergyKeyPointLayerItem {
    private static String PACKAGE = ReflexTool.PN(EnergyKeyPointLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private EnergyKeyPointLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected EnergyKeyPointLayerItem(long j, boolean z) {
        this(new EnergyKeyPointLayerItemRouter("EnergyKeyPointLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IEnergyKeyPointLayerItem.class}, new Object[]{this});
    }

    public EnergyKeyPointLayerItem(float f) {
        this(new EnergyKeyPointLayerItemRouter("EnergyKeyPointLayerItem", null, f));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IEnergyKeyPointLayerItem.class}, new Object[]{this});
    }

    public EnergyKeyPointLayerItem(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl) {
        super(energyKeyPointLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(energyKeyPointLayerItemImpl);
    }

    private void $constructor(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl) {
        if (energyKeyPointLayerItemImpl != null) {
            this.mService = energyKeyPointLayerItemImpl;
            this.mTargetId = String.format("EnergyKeyPointLayerItem_%s_%d", String.valueOf(EnergyKeyPointLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public EnergyKeyPointLayerItemImpl getService() {
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
        return EnergyKeyPointLayerItemImpl.getClassTypeName();
    }

    public void setMKeyPercent(float f) {
        EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl = this.mService;
        if (energyKeyPointLayerItemImpl != null) {
            energyKeyPointLayerItemImpl.$explicit_setMKeyPercent(f);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IEnergyKeyPointLayerItem
    public float getMKeyPercent() {
        EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl = this.mService;
        if (energyKeyPointLayerItemImpl != null) {
            return energyKeyPointLayerItemImpl.$explicit_getMKeyPercent();
        }
        return 0.0f;
    }
}
