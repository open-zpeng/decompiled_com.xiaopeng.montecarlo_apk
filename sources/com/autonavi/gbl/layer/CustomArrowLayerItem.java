package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.CustomArrowLayerItemImpl;
import com.autonavi.gbl.layer.observer.ICustomArrowLayerItem;
import com.autonavi.gbl.layer.router.CustomArrowLayerItemRouter;
import com.autonavi.gbl.map.layer.ArrowLayerItem;
@IntfAuto(target = CustomArrowLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class CustomArrowLayerItem extends ArrowLayerItem implements ICustomArrowLayerItem {
    private static String PACKAGE = ReflexTool.PN(CustomArrowLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private CustomArrowLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected CustomArrowLayerItem(long j, boolean z) {
        this(new CustomArrowLayerItemRouter("CustomArrowLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICustomArrowLayerItem.class}, new Object[]{this});
    }

    public CustomArrowLayerItem() {
        this(new CustomArrowLayerItemRouter("CustomArrowLayerItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICustomArrowLayerItem.class}, new Object[]{this});
    }

    public CustomArrowLayerItem(CustomArrowLayerItemImpl customArrowLayerItemImpl) {
        super(customArrowLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(customArrowLayerItemImpl);
    }

    private void $constructor(CustomArrowLayerItemImpl customArrowLayerItemImpl) {
        if (customArrowLayerItemImpl != null) {
            this.mService = customArrowLayerItemImpl;
            this.mTargetId = String.format("CustomArrowLayerItem_%s_%d", String.valueOf(CustomArrowLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.ArrowLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public CustomArrowLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.ArrowLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
        super.unbind();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.ArrowLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void clean() {
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.ArrowLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.ArrowLayerItem, com.autonavi.gbl.map.layer.LayerItem
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
        CustomArrowLayerItemImpl customArrowLayerItemImpl = this.mService;
        if (customArrowLayerItemImpl != null) {
            customArrowLayerItemImpl.$explicit_setMType(i);
        }
    }

    public void setMValue(String str) {
        CustomArrowLayerItemImpl customArrowLayerItemImpl = this.mService;
        if (customArrowLayerItemImpl != null) {
            customArrowLayerItemImpl.$explicit_setMValue(str);
        }
    }

    public static String getClassTypeName() {
        return CustomArrowLayerItemImpl.getClassTypeName();
    }

    @Override // com.autonavi.gbl.layer.observer.ICustomArrowLayerItem
    public int getMType() {
        CustomArrowLayerItemImpl customArrowLayerItemImpl = this.mService;
        if (customArrowLayerItemImpl != null) {
            return customArrowLayerItemImpl.$explicit_getMType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.ICustomArrowLayerItem
    public String getMValue() {
        CustomArrowLayerItemImpl customArrowLayerItemImpl = this.mService;
        if (customArrowLayerItemImpl != null) {
            return customArrowLayerItemImpl.$explicit_getMValue();
        }
        return null;
    }
}
