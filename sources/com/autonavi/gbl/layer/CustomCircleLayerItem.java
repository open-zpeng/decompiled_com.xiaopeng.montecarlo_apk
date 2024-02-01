package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.CustomCircleLayerItemImpl;
import com.autonavi.gbl.layer.observer.ICustomCircleLayerItem;
import com.autonavi.gbl.layer.router.CustomCircleLayerItemRouter;
import com.autonavi.gbl.map.layer.SectorLayerItem;
@IntfAuto(target = CustomCircleLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class CustomCircleLayerItem extends SectorLayerItem implements ICustomCircleLayerItem {
    private static String PACKAGE = ReflexTool.PN(CustomCircleLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private CustomCircleLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected CustomCircleLayerItem(long j, boolean z) {
        this(new CustomCircleLayerItemRouter("CustomCircleLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICustomCircleLayerItem.class}, new Object[]{this});
    }

    public CustomCircleLayerItem() {
        this(new CustomCircleLayerItemRouter("CustomCircleLayerItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICustomCircleLayerItem.class}, new Object[]{this});
    }

    public CustomCircleLayerItem(CustomCircleLayerItemImpl customCircleLayerItemImpl) {
        super(customCircleLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(customCircleLayerItemImpl);
    }

    private void $constructor(CustomCircleLayerItemImpl customCircleLayerItemImpl) {
        if (customCircleLayerItemImpl != null) {
            this.mService = customCircleLayerItemImpl;
            this.mTargetId = String.format("CustomCircleLayerItem_%s_%d", String.valueOf(CustomCircleLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.SectorLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public CustomCircleLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.SectorLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
        super.unbind();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.SectorLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void clean() {
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.SectorLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.SectorLayerItem, com.autonavi.gbl.map.layer.LayerItem
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

    public void setMType(int i) {
        CustomCircleLayerItemImpl customCircleLayerItemImpl = this.mService;
        if (customCircleLayerItemImpl != null) {
            customCircleLayerItemImpl.$explicit_setMType(i);
        }
    }

    public void setMValue(String str) {
        CustomCircleLayerItemImpl customCircleLayerItemImpl = this.mService;
        if (customCircleLayerItemImpl != null) {
            customCircleLayerItemImpl.$explicit_setMValue(str);
        }
    }

    public static String getClassTypeName() {
        return CustomCircleLayerItemImpl.getClassTypeName();
    }

    @Override // com.autonavi.gbl.layer.observer.ICustomCircleLayerItem
    public int getMType() {
        CustomCircleLayerItemImpl customCircleLayerItemImpl = this.mService;
        if (customCircleLayerItemImpl != null) {
            return customCircleLayerItemImpl.$explicit_getMType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.ICustomCircleLayerItem
    public String getMValue() {
        CustomCircleLayerItemImpl customCircleLayerItemImpl = this.mService;
        if (customCircleLayerItemImpl != null) {
            return customCircleLayerItemImpl.$explicit_getMValue();
        }
        return null;
    }
}
