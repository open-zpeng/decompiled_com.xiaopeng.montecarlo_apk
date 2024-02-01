package com.autonavi.gbl.map.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.impl.IMapViewImpl;
import com.autonavi.gbl.map.layer.impl.QuadrantLayerImpl;
import com.autonavi.gbl.map.layer.model.QuadrantLayerShownType;
import com.autonavi.gbl.map.layer.observer.IQuadrantLayer;
import com.autonavi.gbl.map.router.QuadrantLayerRouter;
@IntfAuto(target = QuadrantLayerRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class QuadrantLayer extends BaseLayer implements IQuadrantLayer {
    private static String PACKAGE = ReflexTool.PN(QuadrantLayer.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private QuadrantLayerImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected QuadrantLayer(long j, boolean z) {
        this(new QuadrantLayerRouter("QuadrantLayer", (IQuadrantLayer) null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IQuadrantLayer.class}, new Object[]{this});
    }

    public QuadrantLayer(String str, MapView mapView) {
        this(new QuadrantLayerRouter("QuadrantLayer", (IQuadrantLayer) null, str, (IMapViewImpl) new TypeHelper(PACKAGE).transfer("com.autonavi.gbl.map.MapView", mapView)));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IQuadrantLayer.class}, new Object[]{this});
    }

    public QuadrantLayer(QuadrantLayerImpl quadrantLayerImpl) {
        super(quadrantLayerImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(quadrantLayerImpl);
    }

    private void $constructor(QuadrantLayerImpl quadrantLayerImpl) {
        if (quadrantLayerImpl != null) {
            this.mService = quadrantLayerImpl;
            this.mTargetId = String.format("QuadrantLayer_%s_%d", String.valueOf(QuadrantLayerImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.BaseLayer, com.autonavi.gbl.map.CollisionGroup
    public QuadrantLayerImpl getService() {
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
        return QuadrantLayerImpl.getClassTypeName();
    }

    public void setQuadrantShownType(@QuadrantLayerShownType.QuadrantLayerShownType1 int i) {
        QuadrantLayerImpl quadrantLayerImpl = this.mService;
        if (quadrantLayerImpl != null) {
            quadrantLayerImpl.$explicit_setQuadrantShownType(i);
        }
    }

    public void updatePreviewRect(RectDouble rectDouble) {
        QuadrantLayerImpl quadrantLayerImpl = this.mService;
        if (quadrantLayerImpl != null) {
            quadrantLayerImpl.$explicit_updatePreviewRect(rectDouble);
        }
    }
}
