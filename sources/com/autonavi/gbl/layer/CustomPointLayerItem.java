package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.CustomPointLayerItemImpl;
import com.autonavi.gbl.layer.observer.ICustomPointLayerItem;
import com.autonavi.gbl.layer.router.CustomPointLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = CustomPointLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class CustomPointLayerItem extends PointLayerItem implements ICustomPointLayerItem {
    private static String PACKAGE = ReflexTool.PN(CustomPointLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private CustomPointLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected CustomPointLayerItem(long j, boolean z) {
        this(new CustomPointLayerItemRouter("CustomPointLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICustomPointLayerItem.class}, new Object[]{this});
    }

    public CustomPointLayerItem() {
        this(new CustomPointLayerItemRouter("CustomPointLayerItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICustomPointLayerItem.class}, new Object[]{this});
    }

    public CustomPointLayerItem(CustomPointLayerItemImpl customPointLayerItemImpl) {
        super(customPointLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(customPointLayerItemImpl);
    }

    private void $constructor(CustomPointLayerItemImpl customPointLayerItemImpl) {
        if (customPointLayerItemImpl != null) {
            this.mService = customPointLayerItemImpl;
            this.mTargetId = String.format("CustomPointLayerItem_%s_%d", String.valueOf(CustomPointLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public CustomPointLayerItemImpl getService() {
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

    public void setMType(int i) {
        CustomPointLayerItemImpl customPointLayerItemImpl = this.mService;
        if (customPointLayerItemImpl != null) {
            customPointLayerItemImpl.$explicit_setMType(i);
        }
    }

    public void setMValue(String str) {
        CustomPointLayerItemImpl customPointLayerItemImpl = this.mService;
        if (customPointLayerItemImpl != null) {
            customPointLayerItemImpl.$explicit_setMValue(str);
        }
    }

    public static String getClassTypeName() {
        return CustomPointLayerItemImpl.getClassTypeName();
    }

    @Override // com.autonavi.gbl.layer.observer.ICustomPointLayerItem
    public int getMType() {
        CustomPointLayerItemImpl customPointLayerItemImpl = this.mService;
        if (customPointLayerItemImpl != null) {
            return customPointLayerItemImpl.$explicit_getMType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.ICustomPointLayerItem
    public String getMValue() {
        CustomPointLayerItemImpl customPointLayerItemImpl = this.mService;
        if (customPointLayerItemImpl != null) {
            return customPointLayerItemImpl.$explicit_getMValue();
        }
        return null;
    }
}
