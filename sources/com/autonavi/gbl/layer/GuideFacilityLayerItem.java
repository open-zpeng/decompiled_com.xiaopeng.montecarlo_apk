package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.path.model.FacilityType;
import com.autonavi.gbl.layer.impl.GuideFacilityLayerItemImpl;
import com.autonavi.gbl.layer.observer.IGuideFacilityLayerItem;
import com.autonavi.gbl.layer.router.GuideFacilityLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = GuideFacilityLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class GuideFacilityLayerItem extends PointLayerItem implements IGuideFacilityLayerItem {
    private static String PACKAGE = ReflexTool.PN(GuideFacilityLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private GuideFacilityLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected GuideFacilityLayerItem(long j, boolean z) {
        this(new GuideFacilityLayerItemRouter("GuideFacilityLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IGuideFacilityLayerItem.class}, new Object[]{this});
    }

    public GuideFacilityLayerItem() {
        this(new GuideFacilityLayerItemRouter("GuideFacilityLayerItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IGuideFacilityLayerItem.class}, new Object[]{this});
    }

    public GuideFacilityLayerItem(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl) {
        super(guideFacilityLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(guideFacilityLayerItemImpl);
    }

    private void $constructor(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl) {
        if (guideFacilityLayerItemImpl != null) {
            this.mService = guideFacilityLayerItemImpl;
            this.mTargetId = String.format("GuideFacilityLayerItem_%s_%d", String.valueOf(GuideFacilityLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public GuideFacilityLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.GuideFacilityLayerItem.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.GuideFacilityLayerItem.2
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
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.GuideFacilityLayerItem.3
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
        return GuideFacilityLayerItemImpl.getClassTypeName();
    }

    public void setMDistance(int i) {
        GuideFacilityLayerItemImpl guideFacilityLayerItemImpl = this.mService;
        if (guideFacilityLayerItemImpl != null) {
            guideFacilityLayerItemImpl.$explicit_setMDistance(i);
        }
    }

    public void setMType(@FacilityType.FacilityType1 int i) {
        GuideFacilityLayerItemImpl guideFacilityLayerItemImpl = this.mService;
        if (guideFacilityLayerItemImpl != null) {
            guideFacilityLayerItemImpl.$explicit_setMType(i);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideFacilityLayerItem
    public int getMDistance() {
        GuideFacilityLayerItemImpl guideFacilityLayerItemImpl = this.mService;
        if (guideFacilityLayerItemImpl != null) {
            return guideFacilityLayerItemImpl.$explicit_getMDistance();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideFacilityLayerItem
    @FacilityType.FacilityType1
    public int getMType() {
        GuideFacilityLayerItemImpl guideFacilityLayerItemImpl = this.mService;
        if (guideFacilityLayerItemImpl != null) {
            return guideFacilityLayerItemImpl.$explicit_getMType();
        }
        return Integer.MIN_VALUE;
    }
}
