package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.path.model.RoadClass;
import com.autonavi.gbl.layer.impl.LocalTrafficEventPointLayerItemImpl;
import com.autonavi.gbl.layer.model.LocalTrafficEventType;
import com.autonavi.gbl.layer.observer.ILocalTrafficEventPointLayerItem;
import com.autonavi.gbl.layer.router.LocalTrafficEventPointLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = LocalTrafficEventPointLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class LocalTrafficEventPointLayerItem extends PointLayerItem implements ILocalTrafficEventPointLayerItem {
    private static String PACKAGE = ReflexTool.PN(LocalTrafficEventPointLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private LocalTrafficEventPointLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected LocalTrafficEventPointLayerItem(long j, boolean z) {
        this(new LocalTrafficEventPointLayerItemRouter("LocalTrafficEventPointLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILocalTrafficEventPointLayerItem.class}, new Object[]{this});
    }

    public LocalTrafficEventPointLayerItem(@LocalTrafficEventType.LocalTrafficEventType1 int i, String str, @RoadClass.RoadClass1 int i2) {
        this(new LocalTrafficEventPointLayerItemRouter("LocalTrafficEventPointLayerItem", null, i, str, i2));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILocalTrafficEventPointLayerItem.class}, new Object[]{this});
    }

    public LocalTrafficEventPointLayerItem(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl) {
        super(localTrafficEventPointLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(localTrafficEventPointLayerItemImpl);
    }

    private void $constructor(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl) {
        if (localTrafficEventPointLayerItemImpl != null) {
            this.mService = localTrafficEventPointLayerItemImpl;
            this.mTargetId = String.format("LocalTrafficEventPointLayerItem_%s_%d", String.valueOf(LocalTrafficEventPointLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public LocalTrafficEventPointLayerItemImpl getService() {
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
        return LocalTrafficEventPointLayerItemImpl.getClassTypeName();
    }

    public void setEventType(@LocalTrafficEventType.LocalTrafficEventType1 int i) {
        LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl = this.mService;
        if (localTrafficEventPointLayerItemImpl != null) {
            localTrafficEventPointLayerItemImpl.$explicit_setEventType(i);
        }
    }

    public void setEventID(String str) {
        LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl = this.mService;
        if (localTrafficEventPointLayerItemImpl != null) {
            localTrafficEventPointLayerItemImpl.$explicit_setEventID(str);
        }
    }

    public void setRoadClass(@RoadClass.RoadClass1 int i) {
        LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl = this.mService;
        if (localTrafficEventPointLayerItemImpl != null) {
            localTrafficEventPointLayerItemImpl.$explicit_setRoadClass(i);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.ILocalTrafficEventPointLayerItem
    @LocalTrafficEventType.LocalTrafficEventType1
    public int getEventType() {
        LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl = this.mService;
        if (localTrafficEventPointLayerItemImpl != null) {
            return localTrafficEventPointLayerItemImpl.$explicit_getEventType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.ILocalTrafficEventPointLayerItem
    public String getEventID() {
        LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl = this.mService;
        if (localTrafficEventPointLayerItemImpl != null) {
            return localTrafficEventPointLayerItemImpl.$explicit_getEventID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.ILocalTrafficEventPointLayerItem
    @RoadClass.RoadClass1
    public int getRoadClass() {
        LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl = this.mService;
        if (localTrafficEventPointLayerItemImpl != null) {
            return localTrafficEventPointLayerItemImpl.$explicit_getRoadClass();
        }
        return Integer.MIN_VALUE;
    }
}
