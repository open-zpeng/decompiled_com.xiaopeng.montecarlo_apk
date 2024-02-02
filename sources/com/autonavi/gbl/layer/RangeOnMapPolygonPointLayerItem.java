package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.RangeOnMapPolygonPointLayerItemImpl;
import com.autonavi.gbl.layer.observer.IRangeOnMapPolygonPointLayerItem;
import com.autonavi.gbl.layer.router.RangeOnMapPolygonPointLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = RangeOnMapPolygonPointLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class RangeOnMapPolygonPointLayerItem extends PointLayerItem implements IRangeOnMapPolygonPointLayerItem {
    private static String PACKAGE = ReflexTool.PN(RangeOnMapPolygonPointLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private RangeOnMapPolygonPointLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected RangeOnMapPolygonPointLayerItem(long j, boolean z) {
        this(new RangeOnMapPolygonPointLayerItemRouter("RangeOnMapPolygonPointLayerItem", (IRangeOnMapPolygonPointLayerItem) null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRangeOnMapPolygonPointLayerItem.class}, new Object[]{this});
    }

    public RangeOnMapPolygonPointLayerItem(float f, String[] strArr) {
        this(new RangeOnMapPolygonPointLayerItemRouter("RangeOnMapPolygonPointLayerItem", (IRangeOnMapPolygonPointLayerItem) null, f, strArr));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRangeOnMapPolygonPointLayerItem.class}, new Object[]{this});
    }

    public RangeOnMapPolygonPointLayerItem(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl) {
        super(rangeOnMapPolygonPointLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(rangeOnMapPolygonPointLayerItemImpl);
    }

    private void $constructor(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl) {
        if (rangeOnMapPolygonPointLayerItemImpl != null) {
            this.mService = rangeOnMapPolygonPointLayerItemImpl;
            this.mTargetId = String.format("RangeOnMapPolygonPointLayerItem_%s_%d", String.valueOf(RangeOnMapPolygonPointLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public RangeOnMapPolygonPointLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.RangeOnMapPolygonPointLayerItem.1
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
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.RangeOnMapPolygonPointLayerItem.2
        }));
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public synchronized void delete() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.RangeOnMapPolygonPointLayerItem.3
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
        return RangeOnMapPolygonPointLayerItemImpl.getClassTypeName();
    }

    public void setMEnergy(float f) {
        RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl = this.mService;
        if (rangeOnMapPolygonPointLayerItemImpl != null) {
            rangeOnMapPolygonPointLayerItemImpl.$explicit_setMEnergy(f);
        }
    }

    public void setMRetainEnergy(String str) {
        RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl = this.mService;
        if (rangeOnMapPolygonPointLayerItemImpl != null) {
            rangeOnMapPolygonPointLayerItemImpl.$explicit_setMRetainEnergy(str);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IRangeOnMapPolygonPointLayerItem
    public float getMEnergy() {
        RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl = this.mService;
        if (rangeOnMapPolygonPointLayerItemImpl != null) {
            return rangeOnMapPolygonPointLayerItemImpl.$explicit_getMEnergy();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.layer.observer.IRangeOnMapPolygonPointLayerItem
    public String getMRetainEnergy() {
        RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl = this.mService;
        if (rangeOnMapPolygonPointLayerItemImpl != null) {
            return rangeOnMapPolygonPointLayerItemImpl.$explicit_getMRetainEnergy();
        }
        return null;
    }
}
