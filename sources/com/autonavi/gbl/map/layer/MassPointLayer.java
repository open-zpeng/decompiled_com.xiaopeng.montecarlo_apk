package com.autonavi.gbl.map.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.impl.IMapViewImpl;
import com.autonavi.gbl.map.layer.impl.MassPointLayerImpl;
import com.autonavi.gbl.map.layer.observer.IMassPointLayer;
import com.autonavi.gbl.map.router.MassPointLayerRouter;
@IntfAuto(target = MassPointLayerRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class MassPointLayer extends BaseLayer implements IMassPointLayer {
    private static String PACKAGE = ReflexTool.PN(MassPointLayer.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private MassPointLayerImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected MassPointLayer(long j, boolean z) {
        this(new MassPointLayerRouter("MassPointLayer", (IMassPointLayer) null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IMassPointLayer.class}, new Object[]{this});
    }

    public MassPointLayer(String str, MapView mapView) {
        this(new MassPointLayerRouter("MassPointLayer", (IMassPointLayer) null, str, (IMapViewImpl) new TypeHelper(PACKAGE).transfer("com.autonavi.gbl.map.MapView", mapView)));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IMassPointLayer.class}, new Object[]{this});
    }

    public MassPointLayer(MassPointLayerImpl massPointLayerImpl) {
        super(massPointLayerImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(massPointLayerImpl);
    }

    private void $constructor(MassPointLayerImpl massPointLayerImpl) {
        if (massPointLayerImpl != null) {
            this.mService = massPointLayerImpl;
            this.mTargetId = String.format("MassPointLayer_%s_%d", String.valueOf(MassPointLayerImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.BaseLayer, com.autonavi.gbl.map.CollisionGroup
    public MassPointLayerImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.BaseLayer, com.autonavi.gbl.map.CollisionGroup
    public void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
        super.unbind();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.BaseLayer, com.autonavi.gbl.map.CollisionGroup
    public void clean() {
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.BaseLayer, com.autonavi.gbl.map.CollisionGroup
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.BaseLayer, com.autonavi.gbl.map.CollisionGroup
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
        return MassPointLayerImpl.getClassTypeName();
    }

    public void enableLengthOfCenterChanged(long j) {
        MassPointLayerImpl massPointLayerImpl = this.mService;
        if (massPointLayerImpl != null) {
            massPointLayerImpl.$explicit_enableLengthOfCenterChanged(j);
        }
    }

    public void enableAngleOfCenterChanged(long j) {
        MassPointLayerImpl massPointLayerImpl = this.mService;
        if (massPointLayerImpl != null) {
            massPointLayerImpl.$explicit_enableAngleOfCenterChanged(j);
        }
    }

    public void enableMoveOfCenterChanged(boolean z) {
        MassPointLayerImpl massPointLayerImpl = this.mService;
        if (massPointLayerImpl != null) {
            massPointLayerImpl.$explicit_enableMoveOfCenterChanged(z);
        }
    }

    public void recalculateAllItemsCollision() {
        MassPointLayerImpl massPointLayerImpl = this.mService;
        if (massPointLayerImpl != null) {
            massPointLayerImpl.$explicit_recalculateAllItemsCollision();
        }
    }
}
