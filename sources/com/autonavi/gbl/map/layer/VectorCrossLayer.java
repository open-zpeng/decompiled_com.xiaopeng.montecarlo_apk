package com.autonavi.gbl.map.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.impl.MapViewImpl;
import com.autonavi.gbl.map.layer.impl.VectorCrossLayerImpl;
import com.autonavi.gbl.map.layer.model.LayerPriority;
import com.autonavi.gbl.map.layer.model.VectorCrossViewPostureEvent;
import com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle;
import com.autonavi.gbl.map.layer.observer.IVectorCrossLayer;
import com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl;
import com.autonavi.gbl.map.router.VectorCrossLayerRouter;
import java.lang.reflect.Method;
import java.util.HashSet;
@IntfAuto(target = VectorCrossLayerRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class VectorCrossLayer extends BaseLayer implements IVectorCrossLayer {
    private static String PACKAGE = ReflexTool.PN(VectorCrossLayer.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private VectorCrossLayerImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected VectorCrossLayer(long j, boolean z) {
        this(new VectorCrossLayerRouter("VectorCrossLayer", (IVectorCrossLayer) null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IVectorCrossLayer.class}, new Object[]{this});
    }

    public VectorCrossLayer(String str, MapView mapView) {
        this(new VectorCrossLayerRouter("VectorCrossLayer", (IVectorCrossLayer) null, str, (MapViewImpl) new TypeHelper(PACKAGE).transfer("com.autonavi.gbl.map.MapView", mapView)));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IVectorCrossLayer.class}, new Object[]{this});
    }

    public VectorCrossLayer(VectorCrossLayerImpl vectorCrossLayerImpl) {
        super(vectorCrossLayerImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(vectorCrossLayerImpl);
    }

    private void $constructor(VectorCrossLayerImpl vectorCrossLayerImpl) {
        if (vectorCrossLayerImpl != null) {
            this.mService = vectorCrossLayerImpl;
            this.mTargetId = String.format("VectorCrossLayer_%s_%d", String.valueOf(VectorCrossLayerImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.BaseLayer, com.autonavi.gbl.map.CollisionGroup
    public VectorCrossLayerImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.BaseLayer, com.autonavi.gbl.map.CollisionGroup
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.VectorCrossLayer.1
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.VectorCrossLayer.2
        }));
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.BaseLayer, com.autonavi.gbl.map.CollisionGroup
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.BaseLayer, com.autonavi.gbl.map.CollisionGroup
    public synchronized void delete() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.VectorCrossLayer.3
        });
        objArr[1] = String.valueOf(this.mService != null);
        DebugTool.d("%s: mService=%s", objArr);
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
        return VectorCrossLayerImpl.getClassTypeName();
    }

    public void setBusinessType(int i) {
        VectorCrossLayerImpl vectorCrossLayerImpl = this.mService;
        if (vectorCrossLayerImpl != null) {
            vectorCrossLayerImpl.$explicit_setBusinessType(i);
        }
    }

    @Override // com.autonavi.gbl.map.layer.BaseLayer
    public void setStyle(IPrepareLayerStyle iPrepareLayerStyle) {
        HashSet hashSet;
        try {
            Method method = VectorCrossLayer.class.getMethod("setStyle", IPrepareLayerStyle.class);
            TypeHelper typeHelper = this.mTypeHelper;
            if (typeHelper != null) {
                hashSet = (HashSet) typeHelper.getBindSet(method, 0);
            } else {
                hashSet = new HashSet();
            }
            hashSet.remove(iPrepareLayerStyle);
            if (iPrepareLayerStyle != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r3 = typeHelper2 != null ? (IPrepareLayerStyleImpl) typeHelper2.transfer(method, 0, iPrepareLayerStyle) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pStyle == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.VectorCrossLayer.4
                    }));
                }
            }
            VectorCrossLayerImpl vectorCrossLayerImpl = this.mService;
            if (vectorCrossLayerImpl != null) {
                vectorCrossLayerImpl.$explicit_setStyle(r3);
                TypeHelper typeHelper3 = this.mTypeHelper;
                if (typeHelper3 != null) {
                    typeHelper3.unbindSet(method, 0, hashSet);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.map.layer.BaseLayer
    public void updateStyle() {
        VectorCrossLayerImpl vectorCrossLayerImpl = this.mService;
        if (vectorCrossLayerImpl != null) {
            vectorCrossLayerImpl.$explicit_updateStyle();
        }
    }

    public void setVectorCar(Coord3DDouble coord3DDouble, int i) {
        VectorCrossLayerImpl vectorCrossLayerImpl = this.mService;
        if (vectorCrossLayerImpl != null) {
            vectorCrossLayerImpl.$explicit_setVectorCar(coord3DDouble, i);
        }
    }

    public int showVectorCross(byte[] bArr) {
        VectorCrossLayerImpl vectorCrossLayerImpl = this.mService;
        if (vectorCrossLayerImpl != null) {
            return vectorCrossLayerImpl.$explicit_showVectorCross(bArr);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.map.layer.BaseLayer
    public void setPriority(LayerPriority layerPriority) {
        VectorCrossLayerImpl vectorCrossLayerImpl = this.mService;
        if (vectorCrossLayerImpl != null) {
            vectorCrossLayerImpl.$explicit_setPriority(layerPriority);
        }
    }

    @Override // com.autonavi.gbl.map.layer.BaseLayer
    public void setVisible(boolean z) {
        VectorCrossLayerImpl vectorCrossLayerImpl = this.mService;
        if (vectorCrossLayerImpl != null) {
            vectorCrossLayerImpl.$explicit_setVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.BaseLayer
    public void clearAllItems() {
        VectorCrossLayerImpl vectorCrossLayerImpl = this.mService;
        if (vectorCrossLayerImpl != null) {
            vectorCrossLayerImpl.$explicit_clearAllItems();
        }
    }

    public void setViewPostureEvent(@VectorCrossViewPostureEvent.VectorCrossViewPostureEvent1 int i) {
        VectorCrossLayerImpl vectorCrossLayerImpl = this.mService;
        if (vectorCrossLayerImpl != null) {
            vectorCrossLayerImpl.$explicit_setViewPostureEvent(i);
        }
    }
}
