package com.autonavi.gbl.layer.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
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
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PrepareLayerParamInnerRouter.1
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
    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerParamInnerImpl, com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PrepareLayerParamInnerRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerParamInnerImpl, com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean updateCardContent(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ItemStyleInfo itemStyleInfo, CustomTextureParam customTextureParam) {
        BaseLayer baseLayer;
        try {
            Method method = PrepareLayerParamInnerRouter.class.getMethod("updateCardContent", BaseLayerImpl.class, LayerItemImpl.class, ItemStyleInfo.class, CustomTextureParam.class);
            if (baseLayerImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                baseLayer = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, 0, baseLayerImpl) : null;
                if (baseLayer == null) {
                    DebugTool.e("%s: $layer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PrepareLayerParamInnerRouter.3
                    }));
                }
            } else {
                baseLayer = null;
            }
            if (layerItemImpl != null) {
                TypeHelper typeHelper2 = this.mHelper;
                r2 = typeHelper2 != null ? (LayerItem) typeHelper2.transfer(method, 1, layerItemImpl) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PrepareLayerParamInnerRouter.4
                    }));
                }
            }
            IPrepareLayerParamInner iPrepareLayerParamInner = this.mObserver;
            if (iPrepareLayerParamInner != null) {
                return iPrepareLayerParamInner.updateCardContent(baseLayer, r2, itemStyleInfo, customTextureParam);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerParamInnerImpl, com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public boolean getPrepareLayerParam(LayerItemImpl layerItemImpl, PrepareLayerMarkerParam prepareLayerMarkerParam) {
        try {
            Method method = PrepareLayerParamInnerRouter.class.getMethod("getPrepareLayerParam", LayerItemImpl.class, PrepareLayerMarkerParam.class);
            if (layerItemImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r2 = typeHelper != null ? (LayerItem) typeHelper.transfer(method, 0, layerItemImpl) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PrepareLayerParamInnerRouter.5
                    }));
                }
            }
            IPrepareLayerParamInner iPrepareLayerParamInner = this.mObserver;
            if (iPrepareLayerParamInner != null) {
                return iPrepareLayerParamInner.getPrepareLayerParam(r2, prepareLayerMarkerParam);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
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
    public boolean getNewStaticMarkerId(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ItemStyleInfo itemStyleInfo, String[] strArr) {
        BaseLayer baseLayer;
        try {
            Method method = PrepareLayerParamInnerRouter.class.getMethod("getNewStaticMarkerId", BaseLayerImpl.class, LayerItemImpl.class, ItemStyleInfo.class, String[].class);
            if (baseLayerImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                baseLayer = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, 0, baseLayerImpl) : null;
                if (baseLayer == null) {
                    DebugTool.e("%s: $layer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PrepareLayerParamInnerRouter.6
                    }));
                }
            } else {
                baseLayer = null;
            }
            if (layerItemImpl != null) {
                TypeHelper typeHelper2 = this.mHelper;
                r2 = typeHelper2 != null ? (LayerItem) typeHelper2.transfer(method, 1, layerItemImpl) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PrepareLayerParamInnerRouter.7
                    }));
                }
            }
            IPrepareLayerParamInner iPrepareLayerParamInner = this.mObserver;
            if (iPrepareLayerParamInner != null) {
                return iPrepareLayerParamInner.getNewStaticMarkerId(baseLayer, r2, itemStyleInfo, strArr);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerParamInnerImpl, com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl
    public int get3DModelId(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, String str) {
        BaseLayer baseLayer;
        try {
            Method method = PrepareLayerParamInnerRouter.class.getMethod("get3DModelId", BaseLayerImpl.class, LayerItemImpl.class, String.class);
            if (baseLayerImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                baseLayer = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, 0, baseLayerImpl) : null;
                if (baseLayer == null) {
                    DebugTool.e("%s: $layer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PrepareLayerParamInnerRouter.8
                    }));
                }
            } else {
                baseLayer = null;
            }
            if (layerItemImpl != null) {
                TypeHelper typeHelper2 = this.mHelper;
                r2 = typeHelper2 != null ? (LayerItem) typeHelper2.transfer(method, 1, layerItemImpl) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PrepareLayerParamInnerRouter.9
                    }));
                }
            }
            IPrepareLayerParamInner iPrepareLayerParamInner = this.mObserver;
            if (iPrepareLayerParamInner != null) {
                return iPrepareLayerParamInner.get3DModelId(baseLayer, r2, str);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
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
}
