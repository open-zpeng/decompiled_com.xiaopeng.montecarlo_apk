package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.CustomPolygonLayerItemImpl;
import com.autonavi.gbl.layer.observer.ICustomPolygonLayerItem;
import com.autonavi.gbl.layer.router.CustomPolygonLayerItemRouter;
import com.autonavi.gbl.map.layer.PolygonLayerItem;
@IntfAuto(target = CustomPolygonLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class CustomPolygonLayerItem extends PolygonLayerItem implements ICustomPolygonLayerItem {
    private static String PACKAGE = ReflexTool.PN(CustomPolygonLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private CustomPolygonLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected CustomPolygonLayerItem(long j, boolean z) {
        this(new CustomPolygonLayerItemRouter("CustomPolygonLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICustomPolygonLayerItem.class}, new Object[]{this});
    }

    public CustomPolygonLayerItem() {
        this(new CustomPolygonLayerItemRouter("CustomPolygonLayerItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICustomPolygonLayerItem.class}, new Object[]{this});
    }

    public CustomPolygonLayerItem(CustomPolygonLayerItemImpl customPolygonLayerItemImpl) {
        super(customPolygonLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(customPolygonLayerItemImpl);
    }

    private void $constructor(CustomPolygonLayerItemImpl customPolygonLayerItemImpl) {
        if (customPolygonLayerItemImpl != null) {
            this.mService = customPolygonLayerItemImpl;
            this.mTargetId = String.format("CustomPolygonLayerItem_%s_%d", String.valueOf(CustomPolygonLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PolygonLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public CustomPolygonLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PolygonLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
        super.unbind();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PolygonLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void clean() {
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.PolygonLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.PolygonLayerItem, com.autonavi.gbl.map.layer.LayerItem
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
        CustomPolygonLayerItemImpl customPolygonLayerItemImpl = this.mService;
        if (customPolygonLayerItemImpl != null) {
            customPolygonLayerItemImpl.$explicit_setMType(i);
        }
    }

    public void setMValue(String str) {
        CustomPolygonLayerItemImpl customPolygonLayerItemImpl = this.mService;
        if (customPolygonLayerItemImpl != null) {
            customPolygonLayerItemImpl.$explicit_setMValue(str);
        }
    }

    public static String getClassTypeName() {
        return CustomPolygonLayerItemImpl.getClassTypeName();
    }

    @Override // com.autonavi.gbl.layer.observer.ICustomPolygonLayerItem
    public int getMType() {
        CustomPolygonLayerItemImpl customPolygonLayerItemImpl = this.mService;
        if (customPolygonLayerItemImpl != null) {
            return customPolygonLayerItemImpl.$explicit_getMType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.ICustomPolygonLayerItem
    public String getMValue() {
        CustomPolygonLayerItemImpl customPolygonLayerItemImpl = this.mService;
        if (customPolygonLayerItemImpl != null) {
            return customPolygonLayerItemImpl.$explicit_getMValue();
        }
        return null;
    }
}
