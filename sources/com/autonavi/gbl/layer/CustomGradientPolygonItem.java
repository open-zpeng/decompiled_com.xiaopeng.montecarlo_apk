package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.CustomGradientPolygonItemImpl;
import com.autonavi.gbl.layer.observer.ICustomGradientPolygonItem;
import com.autonavi.gbl.layer.router.CustomGradientPolygonItemRouter;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.impl.IMapViewImpl;
import com.autonavi.gbl.map.layer.PolygonGradientItem;
@IntfAuto(target = CustomGradientPolygonItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class CustomGradientPolygonItem extends PolygonGradientItem implements ICustomGradientPolygonItem {
    private static String PACKAGE = ReflexTool.PN(CustomGradientPolygonItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private CustomGradientPolygonItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected CustomGradientPolygonItem(long j, boolean z) {
        this(new CustomGradientPolygonItemRouter("CustomGradientPolygonItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICustomGradientPolygonItem.class}, new Object[]{this});
    }

    public CustomGradientPolygonItem(MapView mapView) {
        this(new CustomGradientPolygonItemRouter("CustomGradientPolygonItem", null, (IMapViewImpl) new TypeHelper(PACKAGE).transfer("com.autonavi.gbl.map.MapView", mapView)));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ICustomGradientPolygonItem.class}, new Object[]{this});
    }

    public CustomGradientPolygonItem(CustomGradientPolygonItemImpl customGradientPolygonItemImpl) {
        super(customGradientPolygonItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(customGradientPolygonItemImpl);
    }

    private void $constructor(CustomGradientPolygonItemImpl customGradientPolygonItemImpl) {
        if (customGradientPolygonItemImpl != null) {
            this.mService = customGradientPolygonItemImpl;
            this.mTargetId = String.format("CustomGradientPolygonItem_%s_%d", String.valueOf(CustomGradientPolygonItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PolygonGradientItem, com.autonavi.gbl.map.layer.LayerItem
    public CustomGradientPolygonItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PolygonGradientItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
        super.unbind();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PolygonGradientItem, com.autonavi.gbl.map.layer.LayerItem
    public void clean() {
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.PolygonGradientItem, com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.PolygonGradientItem, com.autonavi.gbl.map.layer.LayerItem
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
        CustomGradientPolygonItemImpl customGradientPolygonItemImpl = this.mService;
        if (customGradientPolygonItemImpl != null) {
            customGradientPolygonItemImpl.$explicit_setMType(i);
        }
    }

    public void setMValue(String str) {
        CustomGradientPolygonItemImpl customGradientPolygonItemImpl = this.mService;
        if (customGradientPolygonItemImpl != null) {
            customGradientPolygonItemImpl.$explicit_setMValue(str);
        }
    }

    public static String getClassTypeName() {
        return CustomGradientPolygonItemImpl.getClassTypeName();
    }

    @Override // com.autonavi.gbl.layer.observer.ICustomGradientPolygonItem
    public int getMType() {
        CustomGradientPolygonItemImpl customGradientPolygonItemImpl = this.mService;
        if (customGradientPolygonItemImpl != null) {
            return customGradientPolygonItemImpl.$explicit_getMType();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.ICustomGradientPolygonItem
    public String getMValue() {
        CustomGradientPolygonItemImpl customGradientPolygonItemImpl = this.mService;
        if (customGradientPolygonItemImpl != null) {
            return customGradientPolygonItemImpl.$explicit_getMValue();
        }
        return null;
    }
}
