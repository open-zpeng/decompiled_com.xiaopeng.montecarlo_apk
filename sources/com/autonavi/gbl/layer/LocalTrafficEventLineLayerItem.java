package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
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
        this(new LocalTrafficEventLineLayerItemRouter("LocalTrafficEventLineLayerItem", (ILocalTrafficEventLineLayerItem) null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILocalTrafficEventLineLayerItem.class}, new Object[]{this});
    }

    public LocalTrafficEventLineLayerItem(@LocalTrafficEventType.LocalTrafficEventType1 int i, String str) {
        this(new LocalTrafficEventLineLayerItemRouter("LocalTrafficEventLineLayerItem", (ILocalTrafficEventLineLayerItem) null, i, str));
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

    @Override // com.autonavi.gbl.map.layer.LineLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public LocalTrafficEventLineLayerItemImpl getService() {
        return this.mService;
    }

    @Override // com.autonavi.gbl.map.layer.LineLayerItem, com.autonavi.gbl.map.layer.LayerItem
    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.LocalTrafficEventLineLayerItem.1
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

    @Override // com.autonavi.gbl.map.layer.LineLayerItem, com.autonavi.gbl.map.layer.LayerItem
    protected void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.LocalTrafficEventLineLayerItem.2
        }));
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.LineLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.LineLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public synchronized void delete() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.LocalTrafficEventLineLayerItem.3
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
}
