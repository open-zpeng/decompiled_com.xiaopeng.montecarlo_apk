package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.CustomPlaneLayerItemImpl;
import com.autonavi.gbl.layer.observer.ICustomPlaneLayerItem;
import com.autonavi.gbl.layer.router.CustomPlaneLayerItemRouter;
import com.autonavi.gbl.map.layer.RasterImageLayerItem;
@IntfAuto(target = CustomPlaneLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class CustomPlaneLayerItem extends RasterImageLayerItem implements ICustomPlaneLayerItem {
    private static String PACKAGE = ReflexTool.PN(CustomPlaneLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private CustomPlaneLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected CustomPlaneLayerItem(long j, boolean z) {
        this(new CustomPlaneLayerItemRouter("CustomPlaneLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICustomPlaneLayerItem.class}, new Object[]{this});
    }

    public CustomPlaneLayerItem() {
        this(new CustomPlaneLayerItemRouter("CustomPlaneLayerItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICustomPlaneLayerItem.class}, new Object[]{this});
    }

    public CustomPlaneLayerItem(CustomPlaneLayerItemImpl customPlaneLayerItemImpl) {
        super(customPlaneLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(customPlaneLayerItemImpl);
    }

    private void $constructor(CustomPlaneLayerItemImpl customPlaneLayerItemImpl) {
        if (customPlaneLayerItemImpl != null) {
            this.mService = customPlaneLayerItemImpl;
            this.mTargetId = String.format("CustomPlaneLayerItem_%s_%d", String.valueOf(CustomPlaneLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.RasterImageLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public CustomPlaneLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.RasterImageLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
        super.unbind();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.RasterImageLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void clean() {
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.RasterImageLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.RasterImageLayerItem, com.autonavi.gbl.map.layer.LayerItem
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
        CustomPlaneLayerItemImpl customPlaneLayerItemImpl = this.mService;
        if (customPlaneLayerItemImpl != null) {
            customPlaneLayerItemImpl.$explicit_setMType(i);
        }
    }

    public void setMValue(String str) {
        CustomPlaneLayerItemImpl customPlaneLayerItemImpl = this.mService;
        if (customPlaneLayerItemImpl != null) {
            customPlaneLayerItemImpl.$explicit_setMValue(str);
        }
    }

    public static String getClassTypeName() {
        return CustomPlaneLayerItemImpl.getClassTypeName();
    }

    @Override // com.autonavi.gbl.layer.observer.ICustomPlaneLayerItem
    public int getMType() {
        CustomPlaneLayerItemImpl customPlaneLayerItemImpl = this.mService;
        if (customPlaneLayerItemImpl != null) {
            return customPlaneLayerItemImpl.$explicit_getMType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.ICustomPlaneLayerItem
    public String getMValue() {
        CustomPlaneLayerItemImpl customPlaneLayerItemImpl = this.mService;
        if (customPlaneLayerItemImpl != null) {
            return customPlaneLayerItemImpl.$explicit_getMValue();
        }
        return null;
    }
}
