package com.autonavi.gbl.layer.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.model.PrepareLayerMarkerParam;
import com.autonavi.gbl.layer.observer.IPrepareLayerParam;
import com.autonavi.gbl.layer.observer.PrepareLayerParam;
import com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.model.ItemStyleInfo;
import com.autonavi.gbl.map.model.MapEngineID;
import java.lang.reflect.Method;
@IntfAuto(target = PrepareLayerParam.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class PrepareLayerParamRouter extends IPrepareLayerParamImpl {
    private static BindTable BIND_TABLE = new BindTable(PrepareLayerParamRouter.class);
    private static String PACKAGE = ReflexTool.PN(PrepareLayerParamRouter.class);
    private TypeHelper mHelper;
    private IPrepareLayerParam mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IPrepareLayerParam iPrepareLayerParam) {
        if (iPrepareLayerParam != null) {
            this.mObserver = iPrepareLayerParam;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(PrepareLayerParam.class, iPrepareLayerParam, this);
            }
        }
    }

    private void $constructor(String str, IPrepareLayerParam iPrepareLayerParam) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IPrepareLayerParamImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iPrepareLayerParam);
    }

    public PrepareLayerParamRouter(String str, IPrepareLayerParam iPrepareLayerParam, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPrepareLayerParam);
    }

    public PrepareLayerParamRouter(String str, IPrepareLayerParam iPrepareLayerParam, @MapEngineID.MapEngineID1 int i) {
        super(i);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPrepareLayerParam);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PrepareLayerParamRouter.1
        });
        objArr[1] = String.valueOf(this.mHelper != null);
        DebugTool.d("%s: mHelper=%s", objArr);
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PrepareLayerParamRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean getPrepareLayerParam(LayerItemImpl layerItemImpl, PrepareLayerMarkerParam prepareLayerMarkerParam) {
        try {
            Method method = PrepareLayerParamRouter.class.getMethod("getPrepareLayerParam", LayerItemImpl.class, PrepareLayerMarkerParam.class);
            if (layerItemImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r2 = typeHelper != null ? (LayerItem) typeHelper.transfer(method, 0, layerItemImpl) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PrepareLayerParamRouter.3
                    }));
                }
            }
            IPrepareLayerParam iPrepareLayerParam = this.mObserver;
            if (iPrepareLayerParam != null) {
                return iPrepareLayerParam.getPrepareLayerParam(r2, prepareLayerMarkerParam);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean getNewStaticMarkerId(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ItemStyleInfo itemStyleInfo, String[] strArr) {
        BaseLayer baseLayer;
        try {
            Method method = PrepareLayerParamRouter.class.getMethod("getNewStaticMarkerId", BaseLayerImpl.class, LayerItemImpl.class, ItemStyleInfo.class, String[].class);
            if (baseLayerImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                baseLayer = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, 0, baseLayerImpl) : null;
                if (baseLayer == null) {
                    DebugTool.e("%s: $layer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PrepareLayerParamRouter.4
                    }));
                }
            } else {
                baseLayer = null;
            }
            if (layerItemImpl != null) {
                TypeHelper typeHelper2 = this.mHelper;
                r2 = typeHelper2 != null ? (LayerItem) typeHelper2.transfer(method, 1, layerItemImpl) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PrepareLayerParamRouter.5
                    }));
                }
            }
            IPrepareLayerParam iPrepareLayerParam = this.mObserver;
            if (iPrepareLayerParam != null) {
                return iPrepareLayerParam.getNewStaticMarkerId(baseLayer, r2, itemStyleInfo, strArr);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public int get3DModelId(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, String str) {
        BaseLayer baseLayer;
        try {
            Method method = PrepareLayerParamRouter.class.getMethod("get3DModelId", BaseLayerImpl.class, LayerItemImpl.class, String.class);
            if (baseLayerImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                baseLayer = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, 0, baseLayerImpl) : null;
                if (baseLayer == null) {
                    DebugTool.e("%s: $layer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PrepareLayerParamRouter.6
                    }));
                }
            } else {
                baseLayer = null;
            }
            if (layerItemImpl != null) {
                TypeHelper typeHelper2 = this.mHelper;
                r2 = typeHelper2 != null ? (LayerItem) typeHelper2.transfer(method, 1, layerItemImpl) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PrepareLayerParamRouter.7
                    }));
                }
            }
            IPrepareLayerParam iPrepareLayerParam = this.mObserver;
            if (iPrepareLayerParam != null) {
                return iPrepareLayerParam.get3DModelId(baseLayer, r2, str);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public float getPointMarkerScaleFactor() {
        IPrepareLayerParam iPrepareLayerParam = this.mObserver;
        if (iPrepareLayerParam != null) {
            return iPrepareLayerParam.getPointMarkerScaleFactor();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public float getRouteWidthScaleFactor(int i) {
        IPrepareLayerParam iPrepareLayerParam = this.mObserver;
        if (iPrepareLayerParam != null) {
            return iPrepareLayerParam.getRouteWidthScaleFactor(i);
        }
        return 0.0f;
    }
}
