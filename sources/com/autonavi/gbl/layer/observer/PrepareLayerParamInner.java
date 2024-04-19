package com.autonavi.gbl.layer.observer;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.card.model.CustomTextureParam;
import com.autonavi.gbl.layer.model.PrepareLayerMarkerParam;
import com.autonavi.gbl.layer.observer.impl.PrepareLayerParamInnerImpl;
import com.autonavi.gbl.layer.router.PrepareLayerParamInnerRouter;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.model.ItemStyleInfo;
import com.autonavi.gbl.map.model.MapEngineID;
import java.lang.reflect.Method;
@IntfAuto(target = PrepareLayerParamInnerRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class PrepareLayerParamInner extends PrepareLayerParam implements IPrepareLayerParamInner {
    private static String PACKAGE = ReflexTool.PN(PrepareLayerParamInner.class);
    private boolean mHasDestroy;
    private PrepareLayerParamInnerImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected PrepareLayerParamInner(long j, boolean z) {
        this(new PrepareLayerParamInnerRouter("PrepareLayerParamInner", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IPrepareLayerParamInner.class}, new Object[]{this});
    }

    public PrepareLayerParamInner(@MapEngineID.MapEngineID1 int i) {
        this(new PrepareLayerParamInnerRouter("PrepareLayerParamInner", null, i));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IPrepareLayerParamInner.class}, new Object[]{this});
    }

    public PrepareLayerParamInner(PrepareLayerParamInnerImpl prepareLayerParamInnerImpl) {
        super(prepareLayerParamInnerImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(prepareLayerParamInnerImpl);
    }

    private void $constructor(PrepareLayerParamInnerImpl prepareLayerParamInnerImpl) {
        if (prepareLayerParamInnerImpl != null) {
            this.mService = prepareLayerParamInnerImpl;
            this.mTargetId = String.format("PrepareLayerParamInner_%s_%d", String.valueOf(PrepareLayerParamInnerImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.PrepareLayerParam
    public PrepareLayerParamInnerImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.observer.PrepareLayerParam
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.observer.PrepareLayerParamInner.1
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
    @Override // com.autonavi.gbl.layer.observer.PrepareLayerParam
    public void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.observer.PrepareLayerParamInner.2
        }));
        super.clean();
    }

    @Override // com.autonavi.gbl.layer.observer.PrepareLayerParam
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.layer.observer.PrepareLayerParam
    public synchronized void delete() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.observer.PrepareLayerParamInner.3
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
            ReflexTool.invokeDeclMethodSafe(this.mService, RequestParameters.SUBRESOURCE_DELETE, null, null);
            this.mService = null;
        }
        unbind();
    }

    public boolean updateMarkerInfo(BaseLayer baseLayer, LayerItem layerItem, long j, CustomTextureParam customTextureParam) {
        BaseLayerImpl baseLayerImpl;
        try {
            Method method = PrepareLayerParamInner.class.getMethod("updateMarkerInfo", BaseLayer.class, LayerItem.class, Long.TYPE, CustomTextureParam.class);
            if (baseLayer != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                BaseLayerImpl baseLayerImpl2 = typeHelper != null ? (BaseLayerImpl) typeHelper.transfer(method, 0, baseLayer) : null;
                if (baseLayerImpl2 == null) {
                    DebugTool.e("%s: $layer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.observer.PrepareLayerParamInner.4
                    }));
                }
                baseLayerImpl = baseLayerImpl2;
            } else {
                baseLayerImpl = null;
            }
            if (layerItem != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r5 = typeHelper2 != null ? (LayerItemImpl) typeHelper2.transfer(method, 1, layerItem) : null;
                if (r5 == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.observer.PrepareLayerParamInner.5
                    }));
                }
            }
            LayerItemImpl layerItemImpl = r5;
            PrepareLayerParamInnerImpl prepareLayerParamInnerImpl = this.mService;
            if (prepareLayerParamInnerImpl != null) {
                return prepareLayerParamInnerImpl.$explicit_updateMarkerInfo(baseLayerImpl, layerItemImpl, j, customTextureParam);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.autonavi.gbl.layer.observer.PrepareLayerParam, com.autonavi.gbl.layer.observer.IPrepareLayerParamInner
    public boolean updateCardContent(BaseLayer baseLayer, LayerItem layerItem, ItemStyleInfo itemStyleInfo, CustomTextureParam customTextureParam) {
        BaseLayerImpl baseLayerImpl;
        try {
            Method method = PrepareLayerParamInner.class.getMethod("updateCardContent", BaseLayer.class, LayerItem.class, ItemStyleInfo.class, CustomTextureParam.class);
            if (baseLayer != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                baseLayerImpl = typeHelper != null ? (BaseLayerImpl) typeHelper.transfer(method, 0, baseLayer) : null;
                if (baseLayerImpl == null) {
                    DebugTool.e("%s: $layer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.observer.PrepareLayerParamInner.6
                    }));
                }
            } else {
                baseLayerImpl = null;
            }
            if (layerItem != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r2 = typeHelper2 != null ? (LayerItemImpl) typeHelper2.transfer(method, 1, layerItem) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.observer.PrepareLayerParamInner.7
                    }));
                }
            }
            PrepareLayerParamInnerImpl prepareLayerParamInnerImpl = this.mService;
            if (prepareLayerParamInnerImpl != null) {
                return prepareLayerParamInnerImpl.$explicit_updateCardContent(baseLayerImpl, r2, itemStyleInfo, customTextureParam);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.autonavi.gbl.layer.observer.PrepareLayerParam, com.autonavi.gbl.layer.observer.IPrepareLayerParam
    public boolean getPrepareLayerParam(LayerItem layerItem, PrepareLayerMarkerParam prepareLayerMarkerParam) {
        try {
            Method method = PrepareLayerParamInner.class.getMethod("getPrepareLayerParam", LayerItem.class, PrepareLayerMarkerParam.class);
            if (layerItem != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (LayerItemImpl) typeHelper.transfer(method, 0, layerItem) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.observer.PrepareLayerParamInner.8
                    }));
                }
            }
            PrepareLayerParamInnerImpl prepareLayerParamInnerImpl = this.mService;
            if (prepareLayerParamInnerImpl != null) {
                return prepareLayerParamInnerImpl.$explicit_getPrepareLayerParam(r2, prepareLayerMarkerParam);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.autonavi.gbl.layer.observer.PrepareLayerParam, com.autonavi.gbl.layer.observer.IPrepareLayerParamInner
    public boolean isRouteCacheStyleEnabled() {
        PrepareLayerParamInnerImpl prepareLayerParamInnerImpl = this.mService;
        if (prepareLayerParamInnerImpl != null) {
            return prepareLayerParamInnerImpl.$explicit_isRouteCacheStyleEnabled();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.PrepareLayerParam, com.autonavi.gbl.layer.observer.IPrepareLayerParamInner
    public boolean isRouteStyleNightMode() {
        PrepareLayerParamInnerImpl prepareLayerParamInnerImpl = this.mService;
        if (prepareLayerParamInnerImpl != null) {
            return prepareLayerParamInnerImpl.$explicit_isRouteStyleNightMode();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.PrepareLayerParam, com.autonavi.gbl.layer.observer.IPrepareLayerParamInner
    public boolean isStaticMarker(String str) {
        PrepareLayerParamInnerImpl prepareLayerParamInnerImpl = this.mService;
        if (prepareLayerParamInnerImpl != null) {
            return prepareLayerParamInnerImpl.$explicit_isStaticMarker(str);
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.PrepareLayerParam, com.autonavi.gbl.layer.observer.IPrepareLayerParamInner
    public boolean isDynamicMarker(String str) {
        PrepareLayerParamInnerImpl prepareLayerParamInnerImpl = this.mService;
        if (prepareLayerParamInnerImpl != null) {
            return prepareLayerParamInnerImpl.$explicit_isDynamicMarker(str);
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.PrepareLayerParam, com.autonavi.gbl.layer.observer.IPrepareLayerParam
    public boolean getNewStaticMarkerId(BaseLayer baseLayer, LayerItem layerItem, ItemStyleInfo itemStyleInfo, String[] strArr) {
        BaseLayerImpl baseLayerImpl;
        try {
            Method method = PrepareLayerParamInner.class.getMethod("getNewStaticMarkerId", BaseLayer.class, LayerItem.class, ItemStyleInfo.class, String[].class);
            if (baseLayer != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                baseLayerImpl = typeHelper != null ? (BaseLayerImpl) typeHelper.transfer(method, 0, baseLayer) : null;
                if (baseLayerImpl == null) {
                    DebugTool.e("%s: $layer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.observer.PrepareLayerParamInner.9
                    }));
                }
            } else {
                baseLayerImpl = null;
            }
            if (layerItem != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r2 = typeHelper2 != null ? (LayerItemImpl) typeHelper2.transfer(method, 1, layerItem) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.observer.PrepareLayerParamInner.10
                    }));
                }
            }
            PrepareLayerParamInnerImpl prepareLayerParamInnerImpl = this.mService;
            if (prepareLayerParamInnerImpl != null) {
                return prepareLayerParamInnerImpl.$explicit_getNewStaticMarkerId(baseLayerImpl, r2, itemStyleInfo, strArr);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.autonavi.gbl.layer.observer.PrepareLayerParam, com.autonavi.gbl.layer.observer.IPrepareLayerParam
    public int get3DModelId(BaseLayer baseLayer, LayerItem layerItem, String str) {
        BaseLayerImpl baseLayerImpl;
        try {
            Method method = PrepareLayerParamInner.class.getMethod("get3DModelId", BaseLayer.class, LayerItem.class, String.class);
            if (baseLayer != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                baseLayerImpl = typeHelper != null ? (BaseLayerImpl) typeHelper.transfer(method, 0, baseLayer) : null;
                if (baseLayerImpl == null) {
                    DebugTool.e("%s: $layer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.observer.PrepareLayerParamInner.11
                    }));
                }
            } else {
                baseLayerImpl = null;
            }
            if (layerItem != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r2 = typeHelper2 != null ? (LayerItemImpl) typeHelper2.transfer(method, 1, layerItem) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.observer.PrepareLayerParamInner.12
                    }));
                }
            }
            PrepareLayerParamInnerImpl prepareLayerParamInnerImpl = this.mService;
            if (prepareLayerParamInnerImpl != null) {
                return prepareLayerParamInnerImpl.$explicit_get3DModelId(baseLayerImpl, r2, str);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    @Override // com.autonavi.gbl.layer.observer.PrepareLayerParam, com.autonavi.gbl.layer.observer.IPrepareLayerParam
    public float getPointMarkerScaleFactor() {
        PrepareLayerParamInnerImpl prepareLayerParamInnerImpl = this.mService;
        if (prepareLayerParamInnerImpl != null) {
            return prepareLayerParamInnerImpl.$explicit_getPointMarkerScaleFactor();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.layer.observer.PrepareLayerParam, com.autonavi.gbl.layer.observer.IPrepareLayerParamInner
    public boolean isNightMode() {
        PrepareLayerParamInnerImpl prepareLayerParamInnerImpl = this.mService;
        if (prepareLayerParamInnerImpl != null) {
            return prepareLayerParamInnerImpl.$explicit_isNightMode();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.PrepareLayerParam, com.autonavi.gbl.layer.observer.IPrepareLayerParamInner
    public boolean isEnglish() {
        PrepareLayerParamInnerImpl prepareLayerParamInnerImpl = this.mService;
        if (prepareLayerParamInnerImpl != null) {
            return prepareLayerParamInnerImpl.$explicit_isEnglish();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.PrepareLayerParam, com.autonavi.gbl.layer.observer.IPrepareLayerParam
    public float getRouteWidthScaleFactor(int i) {
        PrepareLayerParamInnerImpl prepareLayerParamInnerImpl = this.mService;
        if (prepareLayerParamInnerImpl != null) {
            return prepareLayerParamInnerImpl.$explicit_getRouteWidthScaleFactor(i);
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.layer.observer.PrepareLayerParam, com.autonavi.gbl.layer.observer.IPrepareLayerParamInner
    public boolean isInForeground() {
        PrepareLayerParamInnerImpl prepareLayerParamInnerImpl = this.mService;
        if (prepareLayerParamInnerImpl != null) {
            return prepareLayerParamInnerImpl.$explicit_isInForeground();
        }
        return false;
    }
}
