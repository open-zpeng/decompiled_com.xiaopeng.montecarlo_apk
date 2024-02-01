package com.autonavi.gbl.layer.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
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
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean getPrepareLayerParam(LayerItemImpl layerItemImpl, PrepareLayerMarkerParam prepareLayerMarkerParam) {
        TypeHelper typeHelper;
        try {
            Method method = PrepareLayerParamRouter.class.getMethod("getPrepareLayerParam", LayerItemImpl.class, PrepareLayerMarkerParam.class);
            LayerItem layerItem = null;
            if (layerItemImpl != null && (typeHelper = this.mHelper) != null) {
                layerItem = (LayerItem) typeHelper.transfer(method, 0, layerItemImpl);
            }
            IPrepareLayerParam iPrepareLayerParam = this.mObserver;
            if (iPrepareLayerParam != null) {
                return iPrepareLayerParam.getPrepareLayerParam(layerItem, prepareLayerMarkerParam);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean getNewStaticMarkerId(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ItemStyleInfo itemStyleInfo, String[] strArr) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = PrepareLayerParamRouter.class.getMethod("getNewStaticMarkerId", BaseLayerImpl.class, LayerItemImpl.class, ItemStyleInfo.class, String[].class);
            LayerItem layerItem = null;
            BaseLayer baseLayer = (baseLayerImpl == null || (typeHelper2 = this.mHelper) == null) ? null : (BaseLayer) typeHelper2.transfer(method, 0, baseLayerImpl);
            if (layerItemImpl != null && (typeHelper = this.mHelper) != null) {
                layerItem = (LayerItem) typeHelper.transfer(method, 1, layerItemImpl);
            }
            IPrepareLayerParam iPrepareLayerParam = this.mObserver;
            if (iPrepareLayerParam != null) {
                return iPrepareLayerParam.getNewStaticMarkerId(baseLayer, layerItem, itemStyleInfo, strArr);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public int get3DModelId(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, String str) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = PrepareLayerParamRouter.class.getMethod("get3DModelId", BaseLayerImpl.class, LayerItemImpl.class, String.class);
            LayerItem layerItem = null;
            BaseLayer baseLayer = (baseLayerImpl == null || (typeHelper2 = this.mHelper) == null) ? null : (BaseLayer) typeHelper2.transfer(method, 0, baseLayerImpl);
            if (layerItemImpl != null && (typeHelper = this.mHelper) != null) {
                layerItem = (LayerItem) typeHelper.transfer(method, 1, layerItemImpl);
            }
            IPrepareLayerParam iPrepareLayerParam = this.mObserver;
            if (iPrepareLayerParam != null) {
                return iPrepareLayerParam.get3DModelId(baseLayer, layerItem, str);
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
