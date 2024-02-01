package com.autonavi.gbl.layer.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.card.model.CustomTextureParam;
import com.autonavi.gbl.layer.model.PrepareLayerMarkerParam;
import com.autonavi.gbl.layer.observer.IPrepareLayerParamInner;
import com.autonavi.gbl.layer.observer.PrepareLayerParamInner;
import com.autonavi.gbl.layer.observer.impl.PrepareLayerParamInnerImpl;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.model.ItemStyleInfo;
import com.autonavi.gbl.map.model.MapEngineID;
import java.lang.reflect.Method;
@IntfAuto(target = PrepareLayerParamInner.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class PrepareLayerParamInnerRouter extends PrepareLayerParamInnerImpl {
    private static BindTable BIND_TABLE = new BindTable(PrepareLayerParamInnerRouter.class);
    private static String PACKAGE = ReflexTool.PN(PrepareLayerParamInnerRouter.class);
    private TypeHelper mHelper;
    private IPrepareLayerParamInner mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IPrepareLayerParamInner iPrepareLayerParamInner) {
        if (iPrepareLayerParamInner != null) {
            this.mObserver = iPrepareLayerParamInner;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(PrepareLayerParamInner.class, iPrepareLayerParamInner, this);
            }
        }
    }

    private void $constructor(String str, IPrepareLayerParamInner iPrepareLayerParamInner) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(PrepareLayerParamInnerImpl.getCPtr((PrepareLayerParamInnerImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iPrepareLayerParamInner);
    }

    public PrepareLayerParamInnerRouter(String str, IPrepareLayerParamInner iPrepareLayerParamInner, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPrepareLayerParamInner);
    }

    public PrepareLayerParamInnerRouter(String str, IPrepareLayerParamInner iPrepareLayerParamInner, @MapEngineID.MapEngineID1 int i) {
        super(i);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPrepareLayerParamInner);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerParamInnerImpl, com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerParamInnerImpl, com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean isRouteCacheStyleEnabled() {
        IPrepareLayerParamInner iPrepareLayerParamInner = this.mObserver;
        if (iPrepareLayerParamInner != null) {
            return iPrepareLayerParamInner.isRouteCacheStyleEnabled();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerParamInnerImpl, com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean isRouteStyleNightMode() {
        IPrepareLayerParamInner iPrepareLayerParamInner = this.mObserver;
        if (iPrepareLayerParamInner != null) {
            return iPrepareLayerParamInner.isRouteStyleNightMode();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerParamInnerImpl, com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean isStaticMarker(String str) {
        IPrepareLayerParamInner iPrepareLayerParamInner = this.mObserver;
        if (iPrepareLayerParamInner != null) {
            return iPrepareLayerParamInner.isStaticMarker(str);
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerParamInnerImpl, com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean isDynamicMarker(String str) {
        IPrepareLayerParamInner iPrepareLayerParamInner = this.mObserver;
        if (iPrepareLayerParamInner != null) {
            return iPrepareLayerParamInner.isDynamicMarker(str);
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerParamInnerImpl, com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public float getPointMarkerScaleFactor() {
        IPrepareLayerParamInner iPrepareLayerParamInner = this.mObserver;
        if (iPrepareLayerParamInner != null) {
            return iPrepareLayerParamInner.getPointMarkerScaleFactor();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerParamInnerImpl, com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean isNightMode() {
        IPrepareLayerParamInner iPrepareLayerParamInner = this.mObserver;
        if (iPrepareLayerParamInner != null) {
            return iPrepareLayerParamInner.isNightMode();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerParamInnerImpl, com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean isEnglish() {
        IPrepareLayerParamInner iPrepareLayerParamInner = this.mObserver;
        if (iPrepareLayerParamInner != null) {
            return iPrepareLayerParamInner.isEnglish();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerParamInnerImpl, com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public float getRouteWidthScaleFactor(int i) {
        IPrepareLayerParamInner iPrepareLayerParamInner = this.mObserver;
        if (iPrepareLayerParamInner != null) {
            return iPrepareLayerParamInner.getRouteWidthScaleFactor(i);
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerParamInnerImpl, com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean isInForeground() {
        IPrepareLayerParamInner iPrepareLayerParamInner = this.mObserver;
        if (iPrepareLayerParamInner != null) {
            return iPrepareLayerParamInner.isInForeground();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerParamInnerImpl, com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean getNewStaticMarkerId(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ItemStyleInfo itemStyleInfo, String[] strArr) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = PrepareLayerParamInnerRouter.class.getMethod("getNewStaticMarkerId", BaseLayerImpl.class, LayerItemImpl.class, ItemStyleInfo.class, String[].class);
            LayerItem layerItem = null;
            BaseLayer baseLayer = (baseLayerImpl == null || (typeHelper2 = this.mHelper) == null) ? null : (BaseLayer) typeHelper2.transfer(method, 0, baseLayerImpl);
            if (layerItemImpl != null && (typeHelper = this.mHelper) != null) {
                layerItem = (LayerItem) typeHelper.transfer(method, 1, layerItemImpl);
            }
            IPrepareLayerParamInner iPrepareLayerParamInner = this.mObserver;
            if (iPrepareLayerParamInner != null) {
                return iPrepareLayerParamInner.getNewStaticMarkerId(baseLayer, layerItem, itemStyleInfo, strArr);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerParamInnerImpl, com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public int get3DModelId(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, String str) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = PrepareLayerParamInnerRouter.class.getMethod("get3DModelId", BaseLayerImpl.class, LayerItemImpl.class, String.class);
            LayerItem layerItem = null;
            BaseLayer baseLayer = (baseLayerImpl == null || (typeHelper2 = this.mHelper) == null) ? null : (BaseLayer) typeHelper2.transfer(method, 0, baseLayerImpl);
            if (layerItemImpl != null && (typeHelper = this.mHelper) != null) {
                layerItem = (LayerItem) typeHelper.transfer(method, 1, layerItemImpl);
            }
            IPrepareLayerParamInner iPrepareLayerParamInner = this.mObserver;
            if (iPrepareLayerParamInner != null) {
                return iPrepareLayerParamInner.get3DModelId(baseLayer, layerItem, str);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerParamInnerImpl, com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean updateCardContent(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ItemStyleInfo itemStyleInfo, CustomTextureParam customTextureParam) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = PrepareLayerParamInnerRouter.class.getMethod("updateCardContent", BaseLayerImpl.class, LayerItemImpl.class, ItemStyleInfo.class, CustomTextureParam.class);
            LayerItem layerItem = null;
            BaseLayer baseLayer = (baseLayerImpl == null || (typeHelper2 = this.mHelper) == null) ? null : (BaseLayer) typeHelper2.transfer(method, 0, baseLayerImpl);
            if (layerItemImpl != null && (typeHelper = this.mHelper) != null) {
                layerItem = (LayerItem) typeHelper.transfer(method, 1, layerItemImpl);
            }
            IPrepareLayerParamInner iPrepareLayerParamInner = this.mObserver;
            if (iPrepareLayerParamInner != null) {
                return iPrepareLayerParamInner.updateCardContent(baseLayer, layerItem, itemStyleInfo, customTextureParam);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerParamInnerImpl, com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean getPrepareLayerParam(LayerItemImpl layerItemImpl, PrepareLayerMarkerParam prepareLayerMarkerParam) {
        TypeHelper typeHelper;
        try {
            Method method = PrepareLayerParamInnerRouter.class.getMethod("getPrepareLayerParam", LayerItemImpl.class, PrepareLayerMarkerParam.class);
            LayerItem layerItem = null;
            if (layerItemImpl != null && (typeHelper = this.mHelper) != null) {
                layerItem = (LayerItem) typeHelper.transfer(method, 0, layerItemImpl);
            }
            IPrepareLayerParamInner iPrepareLayerParamInner = this.mObserver;
            if (iPrepareLayerParamInner != null) {
                return iPrepareLayerParamInner.getPrepareLayerParam(layerItem, prepareLayerMarkerParam);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }
}
