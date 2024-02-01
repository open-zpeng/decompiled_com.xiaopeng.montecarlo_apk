package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.CustomLineLayerItemImpl;
import com.autonavi.gbl.layer.observer.ICustomLineLayerItem;
import com.autonavi.gbl.layer.router.CustomLineLayerItemRouter;
import com.autonavi.gbl.map.layer.LineLayerItem;
@IntfAuto(target = CustomLineLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class CustomLineLayerItem extends LineLayerItem implements ICustomLineLayerItem {
    private static String PACKAGE = ReflexTool.PN(CustomLineLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private CustomLineLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected CustomLineLayerItem(long j, boolean z) {
        this(new CustomLineLayerItemRouter("CustomLineLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICustomLineLayerItem.class}, new Object[]{this});
    }

    public CustomLineLayerItem() {
        this(new CustomLineLayerItemRouter("CustomLineLayerItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICustomLineLayerItem.class}, new Object[]{this});
    }

    public CustomLineLayerItem(CustomLineLayerItemImpl customLineLayerItemImpl) {
        super(customLineLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(customLineLayerItemImpl);
    }

    private void $constructor(CustomLineLayerItemImpl customLineLayerItemImpl) {
        if (customLineLayerItemImpl != null) {
            this.mService = customLineLayerItemImpl;
            this.mTargetId = String.format("CustomLineLayerItem_%s_%d", String.valueOf(CustomLineLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.LineLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public CustomLineLayerItemImpl getService() {
        return this.mService;
    }

    @Override // com.autonavi.gbl.map.layer.LineLayerItem, com.autonavi.gbl.map.layer.LayerItem
    protected void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
        super.unbind();
    }

    @Override // com.autonavi.gbl.map.layer.LineLayerItem, com.autonavi.gbl.map.layer.LayerItem
    protected void clean() {
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

    public void setMType(int i) {
        CustomLineLayerItemImpl customLineLayerItemImpl = this.mService;
        if (customLineLayerItemImpl != null) {
            customLineLayerItemImpl.$explicit_setMType(i);
        }
    }

    public void setMValue(String str) {
        CustomLineLayerItemImpl customLineLayerItemImpl = this.mService;
        if (customLineLayerItemImpl != null) {
            customLineLayerItemImpl.$explicit_setMValue(str);
        }
    }

    public static String getClassTypeName() {
        return CustomLineLayerItemImpl.getClassTypeName();
    }

    @Override // com.autonavi.gbl.layer.observer.ICustomLineLayerItem
    public int getMType() {
        CustomLineLayerItemImpl customLineLayerItemImpl = this.mService;
        if (customLineLayerItemImpl != null) {
            return customLineLayerItemImpl.$explicit_getMType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.ICustomLineLayerItem
    public String getMValue() {
        CustomLineLayerItemImpl customLineLayerItemImpl = this.mService;
        if (customLineLayerItemImpl != null) {
            return customLineLayerItemImpl.$explicit_getMValue();
        }
        return null;
    }
}
