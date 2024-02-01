package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.GpsTrackPointLayerItemImpl;
import com.autonavi.gbl.layer.model.BizGpsPointType;
import com.autonavi.gbl.layer.observer.IGpsTrackPointLayerItem;
import com.autonavi.gbl.layer.router.GpsTrackPointLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = GpsTrackPointLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class GpsTrackPointLayerItem extends PointLayerItem implements IGpsTrackPointLayerItem {
    private static String PACKAGE = ReflexTool.PN(GpsTrackPointLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private GpsTrackPointLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected GpsTrackPointLayerItem(long j, boolean z) {
        this(new GpsTrackPointLayerItemRouter("GpsTrackPointLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IGpsTrackPointLayerItem.class}, new Object[]{this});
    }

    public GpsTrackPointLayerItem() {
        this(new GpsTrackPointLayerItemRouter("GpsTrackPointLayerItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IGpsTrackPointLayerItem.class}, new Object[]{this});
    }

    public GpsTrackPointLayerItem(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl) {
        super(gpsTrackPointLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(gpsTrackPointLayerItemImpl);
    }

    private void $constructor(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl) {
        if (gpsTrackPointLayerItemImpl != null) {
            this.mService = gpsTrackPointLayerItemImpl;
            this.mTargetId = String.format("GpsTrackPointLayerItem_%s_%d", String.valueOf(GpsTrackPointLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public GpsTrackPointLayerItemImpl getService() {
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

    public void setMGpsPointType(@BizGpsPointType.BizGpsPointType1 int i) {
        GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl = this.mService;
        if (gpsTrackPointLayerItemImpl != null) {
            gpsTrackPointLayerItemImpl.$explicit_setMGpsPointType(i);
        }
    }

    public static String getClassTypeName() {
        return GpsTrackPointLayerItemImpl.getClassTypeName();
    }

    @Override // com.autonavi.gbl.layer.observer.IGpsTrackPointLayerItem
    @BizGpsPointType.BizGpsPointType1
    public int getMGpsPointType() {
        GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl = this.mService;
        if (gpsTrackPointLayerItemImpl != null) {
            return gpsTrackPointLayerItemImpl.$explicit_getMGpsPointType();
        }
        return Integer.MIN_VALUE;
    }
}
