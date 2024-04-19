package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.GuideFamiliarRouteLayerItemImpl;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.observer.IGuideFamiliarRouteLayerItem;
import com.autonavi.gbl.layer.router.GuideFamiliarRouteLayerItemRouter;
import com.autonavi.gbl.map.layer.QuadrantLayerItem;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(target = GuideFamiliarRouteLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class GuideFamiliarRouteLayerItem extends QuadrantLayerItem implements IGuideFamiliarRouteLayerItem {
    private static String PACKAGE = ReflexTool.PN(GuideFamiliarRouteLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private GuideFamiliarRouteLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected GuideFamiliarRouteLayerItem(long j, boolean z) {
        this(new GuideFamiliarRouteLayerItemRouter("GuideFamiliarRouteLayerItem", (IGuideFamiliarRouteLayerItem) null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IGuideFamiliarRouteLayerItem.class}, new Object[]{this});
    }

    public GuideFamiliarRouteLayerItem(@QuadrantType.QuadrantType1 int i, long j) {
        this(new GuideFamiliarRouteLayerItemRouter("GuideFamiliarRouteLayerItem", (IGuideFamiliarRouteLayerItem) null, i, j));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IGuideFamiliarRouteLayerItem.class}, new Object[]{this});
    }

    public GuideFamiliarRouteLayerItem(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        super(guideFamiliarRouteLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(guideFamiliarRouteLayerItemImpl);
    }

    private void $constructor(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        if (guideFamiliarRouteLayerItemImpl != null) {
            this.mService = guideFamiliarRouteLayerItemImpl;
            this.mTargetId = String.format("GuideFamiliarRouteLayerItem_%s_%d", String.valueOf(GuideFamiliarRouteLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public GuideFamiliarRouteLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.GuideFamiliarRouteLayerItem.1
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
    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.GuideFamiliarRouteLayerItem.2
        }));
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public synchronized void delete() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.GuideFamiliarRouteLayerItem.3
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
        return GuideFamiliarRouteLayerItemImpl.getClassTypeName();
    }

    public void setPathId(long j) {
        GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl = this.mService;
        if (guideFamiliarRouteLayerItemImpl != null) {
            guideFamiliarRouteLayerItemImpl.$explicit_setPathId(j);
        }
    }

    public void setBoardStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl = this.mService;
        if (guideFamiliarRouteLayerItemImpl != null) {
            guideFamiliarRouteLayerItemImpl.$explicit_setBoardStyle(i);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideFamiliarRouteLayerItem
    public long getPathId() {
        GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl = this.mService;
        if (guideFamiliarRouteLayerItemImpl != null) {
            return guideFamiliarRouteLayerItemImpl.$explicit_getPathId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideFamiliarRouteLayerItem
    @BizDirectionStyle.BizDirectionStyle1
    public int getBoardStyle() {
        GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl = this.mService;
        if (guideFamiliarRouteLayerItemImpl != null) {
            return guideFamiliarRouteLayerItemImpl.$explicit_getBoardStyle();
        }
        return Integer.MIN_VALUE;
    }
}
