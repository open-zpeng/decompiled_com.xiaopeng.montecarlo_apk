package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.ViaETALayerItemImpl;
import com.autonavi.gbl.layer.model.ViaETADirection;
import com.autonavi.gbl.layer.observer.IViaETALayerItem;
import com.autonavi.gbl.layer.router.ViaETALayerItemRouter;
import com.autonavi.gbl.map.layer.QuadrantLayerItem;
import com.autonavi.gbl.map.layer.model.QuadrantType;
import com.autonavi.gbl.map.layer.model.ViaETAPathPointType;
@IntfAuto(target = ViaETALayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class ViaETALayerItem extends QuadrantLayerItem implements IViaETALayerItem {
    private static String PACKAGE = ReflexTool.PN(ViaETALayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private ViaETALayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected ViaETALayerItem(long j, boolean z) {
        this(new ViaETALayerItemRouter("ViaETALayerItem", (IViaETALayerItem) null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IViaETALayerItem.class}, new Object[]{this});
    }

    public ViaETALayerItem(@QuadrantType.QuadrantType1 int i, long j) {
        this(new ViaETALayerItemRouter("ViaETALayerItem", (IViaETALayerItem) null, i, j));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IViaETALayerItem.class}, new Object[]{this});
    }

    public ViaETALayerItem(@QuadrantType.QuadrantType1 int i) {
        this(new ViaETALayerItemRouter("ViaETALayerItem", null, i));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IViaETALayerItem.class}, new Object[]{this});
    }

    public ViaETALayerItem(ViaETALayerItemImpl viaETALayerItemImpl) {
        super(viaETALayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(viaETALayerItemImpl);
    }

    private void $constructor(ViaETALayerItemImpl viaETALayerItemImpl) {
        if (viaETALayerItemImpl != null) {
            this.mService = viaETALayerItemImpl;
            this.mTargetId = String.format("ViaETALayerItem_%s_%d", String.valueOf(ViaETALayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public ViaETALayerItemImpl getService() {
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
        return ViaETALayerItemImpl.getClassTypeName();
    }

    public void setViaIndex(int i) {
        ViaETALayerItemImpl viaETALayerItemImpl = this.mService;
        if (viaETALayerItemImpl != null) {
            viaETALayerItemImpl.$explicit_setViaIndex(i);
        }
    }

    public void setEType(@ViaETAPathPointType.ViaETAPathPointType1 int i) {
        ViaETALayerItemImpl viaETALayerItemImpl = this.mService;
        if (viaETALayerItemImpl != null) {
            viaETALayerItemImpl.$explicit_setEType(i);
        }
    }

    public void setChargePercent(short s) {
        ViaETALayerItemImpl viaETALayerItemImpl = this.mService;
        if (viaETALayerItemImpl != null) {
            viaETALayerItemImpl.$explicit_setChargePercent(s);
        }
    }

    public void setChargeTime(int i) {
        ViaETALayerItemImpl viaETALayerItemImpl = this.mService;
        if (viaETALayerItemImpl != null) {
            viaETALayerItemImpl.$explicit_setChargeTime(i);
        }
    }

    public void setMTravelTime(long j) {
        ViaETALayerItemImpl viaETALayerItemImpl = this.mService;
        if (viaETALayerItemImpl != null) {
            viaETALayerItemImpl.$explicit_setMTravelTime(j);
        }
    }

    public void setMLeftEnergy(int i) {
        ViaETALayerItemImpl viaETALayerItemImpl = this.mService;
        if (viaETALayerItemImpl != null) {
            viaETALayerItemImpl.$explicit_setMLeftEnergy(i);
        }
    }

    public void setLeftEnergyPercent(double d) {
        ViaETALayerItemImpl viaETALayerItemImpl = this.mService;
        if (viaETALayerItemImpl != null) {
            viaETALayerItemImpl.$explicit_setLeftEnergyPercent(d);
        }
    }

    public void setMDirection(@ViaETADirection.ViaETADirection1 int i) {
        ViaETALayerItemImpl viaETALayerItemImpl = this.mService;
        if (viaETALayerItemImpl != null) {
            viaETALayerItemImpl.$explicit_setMDirection(i);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IViaETALayerItem
    public int getViaIndex() {
        ViaETALayerItemImpl viaETALayerItemImpl = this.mService;
        if (viaETALayerItemImpl != null) {
            return viaETALayerItemImpl.$explicit_getViaIndex();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.IViaETALayerItem
    @ViaETAPathPointType.ViaETAPathPointType1
    public int getEType() {
        ViaETALayerItemImpl viaETALayerItemImpl = this.mService;
        if (viaETALayerItemImpl != null) {
            return viaETALayerItemImpl.$explicit_getEType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.IViaETALayerItem
    public short getChargePercent() {
        ViaETALayerItemImpl viaETALayerItemImpl = this.mService;
        if (viaETALayerItemImpl != null) {
            return viaETALayerItemImpl.$explicit_getChargePercent();
        }
        return (short) 0;
    }

    @Override // com.autonavi.gbl.layer.observer.IViaETALayerItem
    public int getChargeTime() {
        ViaETALayerItemImpl viaETALayerItemImpl = this.mService;
        if (viaETALayerItemImpl != null) {
            return viaETALayerItemImpl.$explicit_getChargeTime();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.IViaETALayerItem
    public long getMTravelTime() {
        ViaETALayerItemImpl viaETALayerItemImpl = this.mService;
        if (viaETALayerItemImpl != null) {
            return viaETALayerItemImpl.$explicit_getMTravelTime();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.observer.IViaETALayerItem
    public int getMLeftEnergy() {
        ViaETALayerItemImpl viaETALayerItemImpl = this.mService;
        if (viaETALayerItemImpl != null) {
            return viaETALayerItemImpl.$explicit_getMLeftEnergy();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.IViaETALayerItem
    public double getLeftEnergyPercent() {
        ViaETALayerItemImpl viaETALayerItemImpl = this.mService;
        if (viaETALayerItemImpl != null) {
            return viaETALayerItemImpl.$explicit_getLeftEnergyPercent();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.layer.observer.IViaETALayerItem
    @ViaETADirection.ViaETADirection1
    public int getMDirection() {
        ViaETALayerItemImpl viaETALayerItemImpl = this.mService;
        if (viaETALayerItemImpl != null) {
            return viaETALayerItemImpl.$explicit_getMDirection();
        }
        return Integer.MIN_VALUE;
    }
}
