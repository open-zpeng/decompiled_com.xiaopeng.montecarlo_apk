package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.path.model.RoadClass;
import com.autonavi.gbl.layer.impl.LocalTrafficEventLineLayerItemImpl;
import com.autonavi.gbl.layer.model.LocalTrafficEventType;
import com.autonavi.gbl.layer.observer.ILocalTrafficEventLineLayerItem;
import com.autonavi.gbl.layer.router.LocalTrafficEventLineLayerItemRouter;
import com.autonavi.gbl.map.layer.LineLayerItem;
@IntfAuto(target = LocalTrafficEventLineLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class LocalTrafficEventLineLayerItem extends LineLayerItem implements ILocalTrafficEventLineLayerItem {
    private static String PACKAGE = ReflexTool.PN(LocalTrafficEventLineLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private LocalTrafficEventLineLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected LocalTrafficEventLineLayerItem(long j, boolean z) {
        this(new LocalTrafficEventLineLayerItemRouter("LocalTrafficEventLineLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILocalTrafficEventLineLayerItem.class}, new Object[]{this});
    }

    public LocalTrafficEventLineLayerItem(@LocalTrafficEventType.LocalTrafficEventType1 int i, String str, @RoadClass.RoadClass1 int i2) {
        this(new LocalTrafficEventLineLayerItemRouter("LocalTrafficEventLineLayerItem", null, i, str, i2));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILocalTrafficEventLineLayerItem.class}, new Object[]{this});
    }

    public LocalTrafficEventLineLayerItem(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl) {
        super(localTrafficEventLineLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(localTrafficEventLineLayerItemImpl);
    }

    private void $constructor(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl) {
        if (localTrafficEventLineLayerItemImpl != null) {
            this.mService = localTrafficEventLineLayerItemImpl;
            this.mTargetId = String.format("LocalTrafficEventLineLayerItem_%s_%d", String.valueOf(LocalTrafficEventLineLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.LineLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public LocalTrafficEventLineLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.LineLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
        super.unbind();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.LineLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void clean() {
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.LineLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.LineLayerItem, com.autonavi.gbl.map.layer.LayerItem
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
        return LocalTrafficEventLineLayerItemImpl.getClassTypeName();
    }

    public void setEventType(@LocalTrafficEventType.LocalTrafficEventType1 int i) {
        LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl = this.mService;
        if (localTrafficEventLineLayerItemImpl != null) {
            localTrafficEventLineLayerItemImpl.$explicit_setEventType(i);
        }
    }

    public void setEventID(String str) {
        LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl = this.mService;
        if (localTrafficEventLineLayerItemImpl != null) {
            localTrafficEventLineLayerItemImpl.$explicit_setEventID(str);
        }
    }

    public void setRoadClass(@RoadClass.RoadClass1 int i) {
        LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl = this.mService;
        if (localTrafficEventLineLayerItemImpl != null) {
            localTrafficEventLineLayerItemImpl.$explicit_setRoadClass(i);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.ILocalTrafficEventLineLayerItem
    @LocalTrafficEventType.LocalTrafficEventType1
    public int getEventType() {
        LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl = this.mService;
        if (localTrafficEventLineLayerItemImpl != null) {
            return localTrafficEventLineLayerItemImpl.$explicit_getEventType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.ILocalTrafficEventLineLayerItem
    public String getEventID() {
        LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl = this.mService;
        if (localTrafficEventLineLayerItemImpl != null) {
            return localTrafficEventLineLayerItemImpl.$explicit_getEventID();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.ILocalTrafficEventLineLayerItem
    @RoadClass.RoadClass1
    public int getRoadClass() {
        LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl = this.mService;
        if (localTrafficEventLineLayerItemImpl != null) {
            return localTrafficEventLineLayerItemImpl.$explicit_getRoadClass();
        }
        return Integer.MIN_VALUE;
    }
}
