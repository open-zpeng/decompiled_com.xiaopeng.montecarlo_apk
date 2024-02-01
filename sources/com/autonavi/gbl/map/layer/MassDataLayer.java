package com.autonavi.gbl.map.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.impl.IMapViewImpl;
import com.autonavi.gbl.map.layer.impl.MassDataLayerImpl;
import com.autonavi.gbl.map.layer.model.MassDataCircleInfo;
import com.autonavi.gbl.map.layer.model.MassDataPointInfo;
import com.autonavi.gbl.map.layer.model.MassDataPolygonInfo;
import com.autonavi.gbl.map.layer.model.MassDataPolylineInfo;
import com.autonavi.gbl.map.layer.observer.IMassDataLayer;
import com.autonavi.gbl.map.router.MassDataLayerRouter;
import java.util.ArrayList;
import java.util.HashMap;
@IntfAuto(target = MassDataLayerRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class MassDataLayer extends BaseLayer implements IMassDataLayer {
    private static String PACKAGE = ReflexTool.PN(MassDataLayer.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private MassDataLayerImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected MassDataLayer(long j, boolean z) {
        this(new MassDataLayerRouter("MassDataLayer", (IMassDataLayer) null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IMassDataLayer.class}, new Object[]{this});
    }

    public MassDataLayer(String str, MapView mapView) {
        this(new MassDataLayerRouter("MassDataLayer", (IMassDataLayer) null, str, (IMapViewImpl) new TypeHelper(PACKAGE).transfer("com.autonavi.gbl.map.MapView", mapView)));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IMassDataLayer.class}, new Object[]{this});
    }

    public MassDataLayer(MassDataLayerImpl massDataLayerImpl) {
        super(massDataLayerImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(massDataLayerImpl);
    }

    private void $constructor(MassDataLayerImpl massDataLayerImpl) {
        if (massDataLayerImpl != null) {
            this.mService = massDataLayerImpl;
            this.mTargetId = String.format("MassDataLayer_%s_%d", String.valueOf(MassDataLayerImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.BaseLayer, com.autonavi.gbl.map.CollisionGroup
    public MassDataLayerImpl getService() {
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
        return MassDataLayerImpl.getClassTypeName();
    }

    public void setDisplayScaleCount(HashMap<Integer, Integer> hashMap) {
        MassDataLayerImpl massDataLayerImpl = this.mService;
        if (massDataLayerImpl != null) {
            massDataLayerImpl.$explicit_setDisplayScaleCount(hashMap);
        }
    }

    public void setDisplayScaleCount(int i, int i2) {
        MassDataLayerImpl massDataLayerImpl = this.mService;
        if (massDataLayerImpl != null) {
            massDataLayerImpl.$explicit_setDisplayScaleCount(i, i2);
        }
    }

    public void setLengthOfCenterChanged(long j) {
        MassDataLayerImpl massDataLayerImpl = this.mService;
        if (massDataLayerImpl != null) {
            massDataLayerImpl.$explicit_setLengthOfCenterChanged(j);
        }
    }

    public void setRollAngleOfCenterChanged(long j) {
        MassDataLayerImpl massDataLayerImpl = this.mService;
        if (massDataLayerImpl != null) {
            massDataLayerImpl.$explicit_setRollAngleOfCenterChanged(j);
        }
    }

    public void addPointData(ArrayList<MassDataPointInfo> arrayList) {
        MassDataLayerImpl massDataLayerImpl = this.mService;
        if (massDataLayerImpl != null) {
            massDataLayerImpl.$explicit_addPointData(arrayList);
        }
    }

    public void addPolylineData(ArrayList<MassDataPolylineInfo> arrayList) {
        MassDataLayerImpl massDataLayerImpl = this.mService;
        if (massDataLayerImpl != null) {
            massDataLayerImpl.$explicit_addPolylineData(arrayList);
        }
    }

    public void addPolygonData(ArrayList<MassDataPolygonInfo> arrayList) {
        MassDataLayerImpl massDataLayerImpl = this.mService;
        if (massDataLayerImpl != null) {
            massDataLayerImpl.$explicit_addPolygonData(arrayList);
        }
    }

    public void addCircleData(ArrayList<MassDataCircleInfo> arrayList) {
        MassDataLayerImpl massDataLayerImpl = this.mService;
        if (massDataLayerImpl != null) {
            massDataLayerImpl.$explicit_addCircleData(arrayList);
        }
    }

    public void removePointData(String[] strArr) {
        MassDataLayerImpl massDataLayerImpl = this.mService;
        if (massDataLayerImpl != null) {
            massDataLayerImpl.$explicit_removePointData(strArr);
        }
    }

    public void removePolylineData(String[] strArr) {
        MassDataLayerImpl massDataLayerImpl = this.mService;
        if (massDataLayerImpl != null) {
            massDataLayerImpl.$explicit_removePolylineData(strArr);
        }
    }

    public void removePolygonData(String[] strArr) {
        MassDataLayerImpl massDataLayerImpl = this.mService;
        if (massDataLayerImpl != null) {
            massDataLayerImpl.$explicit_removePolygonData(strArr);
        }
    }

    public void removeCircleData(String[] strArr) {
        MassDataLayerImpl massDataLayerImpl = this.mService;
        if (massDataLayerImpl != null) {
            massDataLayerImpl.$explicit_removeCircleData(strArr);
        }
    }

    public void removeAllPointData() {
        MassDataLayerImpl massDataLayerImpl = this.mService;
        if (massDataLayerImpl != null) {
            massDataLayerImpl.$explicit_removeAllPointData();
        }
    }

    public void removeAllPolylineData() {
        MassDataLayerImpl massDataLayerImpl = this.mService;
        if (massDataLayerImpl != null) {
            massDataLayerImpl.$explicit_removeAllPolylineData();
        }
    }

    public void removeAllPolygonData() {
        MassDataLayerImpl massDataLayerImpl = this.mService;
        if (massDataLayerImpl != null) {
            massDataLayerImpl.$explicit_removeAllPolygonData();
        }
    }

    public void removeAllCircleData() {
        MassDataLayerImpl massDataLayerImpl = this.mService;
        if (massDataLayerImpl != null) {
            massDataLayerImpl.$explicit_removeAllCircleData();
        }
    }

    public void removeAllData() {
        MassDataLayerImpl massDataLayerImpl = this.mService;
        if (massDataLayerImpl != null) {
            massDataLayerImpl.$explicit_removeAllData();
        }
    }

    @Override // com.autonavi.gbl.map.layer.BaseLayer, com.autonavi.gbl.map.CollisionGroup, com.autonavi.gbl.map.observer.ICollisionGroup, com.autonavi.gbl.map.observer.ICollisionEntity
    public void enableCollision(boolean z) {
        MassDataLayerImpl massDataLayerImpl = this.mService;
        if (massDataLayerImpl != null) {
            massDataLayerImpl.$explicit_enableCollision(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.BaseLayer, com.autonavi.gbl.map.layer.observer.IBaseLayer
    public RectDouble getBound() {
        MassDataLayerImpl massDataLayerImpl = this.mService;
        if (massDataLayerImpl != null) {
            return massDataLayerImpl.$explicit_getBound();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IMassDataLayer
    public long getPointDataCount() {
        MassDataLayerImpl massDataLayerImpl = this.mService;
        if (massDataLayerImpl != null) {
            return massDataLayerImpl.$explicit_getPointDataCount();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IMassDataLayer
    public long getPolylineDataCount() {
        MassDataLayerImpl massDataLayerImpl = this.mService;
        if (massDataLayerImpl != null) {
            return massDataLayerImpl.$explicit_getPolylineDataCount();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IMassDataLayer
    public long getPolygonDataCount() {
        MassDataLayerImpl massDataLayerImpl = this.mService;
        if (massDataLayerImpl != null) {
            return massDataLayerImpl.$explicit_getPolygonDataCount();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IMassDataLayer
    public long getCircleDataCount() {
        MassDataLayerImpl massDataLayerImpl = this.mService;
        if (massDataLayerImpl != null) {
            return massDataLayerImpl.$explicit_getCircleDataCount();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IMassDataLayer
    public long getAllDataCount() {
        MassDataLayerImpl massDataLayerImpl = this.mService;
        if (massDataLayerImpl != null) {
            return massDataLayerImpl.$explicit_getAllDataCount();
        }
        return 0L;
    }
}
