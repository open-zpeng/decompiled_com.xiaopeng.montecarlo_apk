package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.path.model.ForbiddenCloudControl;
import com.autonavi.gbl.layer.impl.RouteForbiddenLayerItemImpl;
import com.autonavi.gbl.layer.observer.IRouteForbiddenLayerItem;
import com.autonavi.gbl.layer.router.RouteForbiddenLayerItemRouter;
import com.autonavi.gbl.map.layer.PointLayerItem;
@IntfAuto(target = RouteForbiddenLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class RouteForbiddenLayerItem extends PointLayerItem implements IRouteForbiddenLayerItem {
    private static String PACKAGE = ReflexTool.PN(RouteForbiddenLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private RouteForbiddenLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected RouteForbiddenLayerItem(long j, boolean z) {
        this(new RouteForbiddenLayerItemRouter("RouteForbiddenLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRouteForbiddenLayerItem.class}, new Object[]{this});
    }

    public RouteForbiddenLayerItem(ForbiddenCloudControl forbiddenCloudControl) {
        this(new RouteForbiddenLayerItemRouter("RouteForbiddenLayerItem", null, forbiddenCloudControl));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRouteForbiddenLayerItem.class}, new Object[]{this});
    }

    public RouteForbiddenLayerItem(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl) {
        super(routeForbiddenLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(routeForbiddenLayerItemImpl);
    }

    private void $constructor(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl) {
        if (routeForbiddenLayerItemImpl != null) {
            this.mService = routeForbiddenLayerItemImpl;
            this.mTargetId = String.format("RouteForbiddenLayerItem_%s_%d", String.valueOf(RouteForbiddenLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public RouteForbiddenLayerItemImpl getService() {
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
        return RouteForbiddenLayerItemImpl.getClassTypeName();
    }

    public void setMForbiddenCloud(ForbiddenCloudControl forbiddenCloudControl) {
        RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl = this.mService;
        if (routeForbiddenLayerItemImpl != null) {
            routeForbiddenLayerItemImpl.$explicit_setMForbiddenCloud(forbiddenCloudControl);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IRouteForbiddenLayerItem
    public ForbiddenCloudControl getMForbiddenCloud() {
        RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl = this.mService;
        if (routeForbiddenLayerItemImpl != null) {
            return routeForbiddenLayerItemImpl.$explicit_getMForbiddenCloud();
        }
        return null;
    }
}
