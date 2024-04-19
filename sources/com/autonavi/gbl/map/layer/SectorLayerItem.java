package com.autonavi.gbl.map.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.map.layer.impl.SectorLayerItemImpl;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.SectorAngles;
import com.autonavi.gbl.map.layer.observer.ISectorLayerItem;
import com.autonavi.gbl.map.router.SectorLayerItemRouter;
@IntfAuto(target = SectorLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class SectorLayerItem extends LayerItem implements ISectorLayerItem {
    private static String PACKAGE = ReflexTool.PN(SectorLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private SectorLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected SectorLayerItem(long j, boolean z) {
        this(new SectorLayerItemRouter("SectorLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ISectorLayerItem.class}, new Object[]{this});
    }

    public SectorLayerItem() {
        this(new SectorLayerItemRouter("SectorLayerItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ISectorLayerItem.class}, new Object[]{this});
    }

    public SectorLayerItem(SectorLayerItemImpl sectorLayerItemImpl) {
        super(sectorLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(sectorLayerItemImpl);
    }

    private void $constructor(SectorLayerItemImpl sectorLayerItemImpl) {
        if (sectorLayerItemImpl != null) {
            this.mService = sectorLayerItemImpl;
            this.mTargetId = String.format("SectorLayerItem_%s_%d", String.valueOf(SectorLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public SectorLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.SectorLayerItem.1
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
    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.SectorLayerItem.2
        }));
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public synchronized void delete() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.SectorLayerItem.3
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
        return SectorLayerItemImpl.getClassTypeName();
    }

    public void setPosition(Coord3DDouble coord3DDouble) {
        SectorLayerItemImpl sectorLayerItemImpl = this.mService;
        if (sectorLayerItemImpl != null) {
            sectorLayerItemImpl.$explicit_setPosition(coord3DDouble);
        }
    }

    public void setRadius(double d) {
        SectorLayerItemImpl sectorLayerItemImpl = this.mService;
        if (sectorLayerItemImpl != null) {
            sectorLayerItemImpl.$explicit_setRadius(d);
        }
    }

    public void setSectorAngles(SectorAngles sectorAngles) {
        SectorLayerItemImpl sectorLayerItemImpl = this.mService;
        if (sectorLayerItemImpl != null) {
            sectorLayerItemImpl.$explicit_setSectorAngles(sectorAngles);
        }
    }

    public void setColor(long j) {
        SectorLayerItemImpl sectorLayerItemImpl = this.mService;
        if (sectorLayerItemImpl != null) {
            sectorLayerItemImpl.$explicit_setColor(j);
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void updateStyle() {
        SectorLayerItemImpl sectorLayerItemImpl = this.mService;
        if (sectorLayerItemImpl != null) {
            sectorLayerItemImpl.$explicit_updateStyle();
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem, com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.layer.observer.IArrowLayerItem
    @LayerItemType.LayerItemType1
    public int getItemType() {
        SectorLayerItemImpl sectorLayerItemImpl = this.mService;
        if (sectorLayerItemImpl != null) {
            return sectorLayerItemImpl.$explicit_getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.observer.ISectorLayerItem
    public double getRadius() {
        SectorLayerItemImpl sectorLayerItemImpl = this.mService;
        if (sectorLayerItemImpl != null) {
            return sectorLayerItemImpl.$explicit_getRadius();
        }
        return 0.0d;
    }

    @Override // com.autonavi.gbl.map.layer.observer.ISectorLayerItem
    public SectorAngles getSectorAngles() {
        SectorAngles sectorAngles = new SectorAngles();
        getSectorAngles(sectorAngles);
        return sectorAngles;
    }

    private void getSectorAngles(SectorAngles sectorAngles) {
        SectorLayerItemImpl sectorLayerItemImpl = this.mService;
        if (sectorLayerItemImpl != null) {
            sectorLayerItemImpl.$explicit_getSectorAngles(sectorAngles);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.ISectorLayerItem
    public long getColor() {
        SectorLayerItemImpl sectorLayerItemImpl = this.mService;
        if (sectorLayerItemImpl != null) {
            return sectorLayerItemImpl.$explicit_getColor();
        }
        return 0L;
    }
}
