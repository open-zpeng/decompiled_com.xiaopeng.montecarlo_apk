package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.GuideMixForkLayerItemImpl;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.observer.IGuideMixForkLayerItem;
import com.autonavi.gbl.layer.router.GuideMixForkLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = GuideMixForkLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class GuideMixForkLayerItem extends PointLayerItem implements IGuideMixForkLayerItem {
    private static String PACKAGE = ReflexTool.PN(GuideMixForkLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private GuideMixForkLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected GuideMixForkLayerItem(long j, boolean z) {
        this(new GuideMixForkLayerItemRouter("GuideMixForkLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IGuideMixForkLayerItem.class}, new Object[]{this});
    }

    public GuideMixForkLayerItem(@BizDirectionStyle.BizDirectionStyle1 int i, int i2, int i3) {
        this(new GuideMixForkLayerItemRouter("GuideMixForkLayerItem", null, i, i2, i3));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IGuideMixForkLayerItem.class}, new Object[]{this});
    }

    public GuideMixForkLayerItem(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl) {
        super(guideMixForkLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(guideMixForkLayerItemImpl);
    }

    private void $constructor(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl) {
        if (guideMixForkLayerItemImpl != null) {
            this.mService = guideMixForkLayerItemImpl;
            this.mTargetId = String.format("GuideMixForkLayerItem_%s_%d", String.valueOf(GuideMixForkLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public GuideMixForkLayerItemImpl getService() {
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
        return GuideMixForkLayerItemImpl.getClassTypeName();
    }

    public void setMDirectionStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        GuideMixForkLayerItemImpl guideMixForkLayerItemImpl = this.mService;
        if (guideMixForkLayerItemImpl != null) {
            guideMixForkLayerItemImpl.$explicit_setMDirectionStyle(i);
        }
    }

    public void setMDistance(int i) {
        GuideMixForkLayerItemImpl guideMixForkLayerItemImpl = this.mService;
        if (guideMixForkLayerItemImpl != null) {
            guideMixForkLayerItemImpl.$explicit_setMDistance(i);
        }
    }

    public void setMRoadClass(int i) {
        GuideMixForkLayerItemImpl guideMixForkLayerItemImpl = this.mService;
        if (guideMixForkLayerItemImpl != null) {
            guideMixForkLayerItemImpl.$explicit_setMRoadClass(i);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideMixForkLayerItem
    @BizDirectionStyle.BizDirectionStyle1
    public int getMDirectionStyle() {
        GuideMixForkLayerItemImpl guideMixForkLayerItemImpl = this.mService;
        if (guideMixForkLayerItemImpl != null) {
            return guideMixForkLayerItemImpl.$explicit_getMDirectionStyle();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideMixForkLayerItem
    public int getMDistance() {
        GuideMixForkLayerItemImpl guideMixForkLayerItemImpl = this.mService;
        if (guideMixForkLayerItemImpl != null) {
            return guideMixForkLayerItemImpl.$explicit_getMDistance();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideMixForkLayerItem
    public int getMRoadClass() {
        GuideMixForkLayerItemImpl guideMixForkLayerItemImpl = this.mService;
        if (guideMixForkLayerItemImpl != null) {
            return guideMixForkLayerItemImpl.$explicit_getMRoadClass();
        }
        return 0;
    }
}
