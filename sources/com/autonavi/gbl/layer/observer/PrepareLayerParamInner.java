package com.autonavi.gbl.layer.observer;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
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
/* loaded from: classes2.dex */
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.observer.PrepareLayerParam
    public PrepareLayerParamInnerImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.observer.PrepareLayerParam
    public void unbind() {
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
        super.clean();
    }

    @Override // com.autonavi.gbl.layer.observer.PrepareLayerParam
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.layer.observer.PrepareLayerParam
    public synchronized void delete() {
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

    @Override // com.autonavi.gbl.layer.observer.PrepareLayerParam, com.autonavi.gbl.layer.observer.IPrepareLayerParam
    public boolean getNewStaticMarkerId(BaseLayer baseLayer, LayerItem layerItem, ItemStyleInfo itemStyleInfo, String[] strArr) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = PrepareLayerParamInner.class.getMethod("getNewStaticMarkerId", BaseLayer.class, LayerItem.class, ItemStyleInfo.class, String[].class);
            LayerItemImpl layerItemImpl = null;
            BaseLayerImpl baseLayerImpl = (baseLayer == null || (typeHelper2 = this.mTypeHelper) == null) ? null : (BaseLayerImpl) typeHelper2.transfer(method, 0, baseLayer);
            if (layerItem != null && (typeHelper = this.mTypeHelper) != null) {
                layerItemImpl = (LayerItemImpl) typeHelper.transfer(method, 1, layerItem);
            }
            PrepareLayerParamInnerImpl prepareLayerParamInnerImpl = this.mService;
            if (prepareLayerParamInnerImpl != null) {
                return prepareLayerParamInnerImpl.$explicit_getNewStaticMarkerId(baseLayerImpl, layerItemImpl, itemStyleInfo, strArr);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.autonavi.gbl.layer.observer.PrepareLayerParam, com.autonavi.gbl.layer.observer.IPrepareLayerParam
    public int get3DModelId(BaseLayer baseLayer, LayerItem layerItem, String str) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = PrepareLayerParamInner.class.getMethod("get3DModelId", BaseLayer.class, LayerItem.class, String.class);
            LayerItemImpl layerItemImpl = null;
            BaseLayerImpl baseLayerImpl = (baseLayer == null || (typeHelper2 = this.mTypeHelper) == null) ? null : (BaseLayerImpl) typeHelper2.transfer(method, 0, baseLayer);
            if (layerItem != null && (typeHelper = this.mTypeHelper) != null) {
                layerItemImpl = (LayerItemImpl) typeHelper.transfer(method, 1, layerItem);
            }
            PrepareLayerParamInnerImpl prepareLayerParamInnerImpl = this.mService;
            if (prepareLayerParamInnerImpl != null) {
                return prepareLayerParamInnerImpl.$explicit_get3DModelId(baseLayerImpl, layerItemImpl, str);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    @Override // com.autonavi.gbl.layer.observer.PrepareLayerParam, com.autonavi.gbl.layer.observer.IPrepareLayerParamInner
    public boolean updateCardContent(BaseLayer baseLayer, LayerItem layerItem, ItemStyleInfo itemStyleInfo, CustomTextureParam customTextureParam) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = PrepareLayerParamInner.class.getMethod("updateCardContent", BaseLayer.class, LayerItem.class, ItemStyleInfo.class, CustomTextureParam.class);
            LayerItemImpl layerItemImpl = null;
            BaseLayerImpl baseLayerImpl = (baseLayer == null || (typeHelper2 = this.mTypeHelper) == null) ? null : (BaseLayerImpl) typeHelper2.transfer(method, 0, baseLayer);
            if (layerItem != null && (typeHelper = this.mTypeHelper) != null) {
                layerItemImpl = (LayerItemImpl) typeHelper.transfer(method, 1, layerItem);
            }
            PrepareLayerParamInnerImpl prepareLayerParamInnerImpl = this.mService;
            if (prepareLayerParamInnerImpl != null) {
                return prepareLayerParamInnerImpl.$explicit_updateCardContent(baseLayerImpl, layerItemImpl, itemStyleInfo, customTextureParam);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.autonavi.gbl.layer.observer.PrepareLayerParam, com.autonavi.gbl.layer.observer.IPrepareLayerParam
    public boolean getPrepareLayerParam(LayerItem layerItem, PrepareLayerMarkerParam prepareLayerMarkerParam) {
        TypeHelper typeHelper;
        try {
            Method method = PrepareLayerParamInner.class.getMethod("getPrepareLayerParam", LayerItem.class, PrepareLayerMarkerParam.class);
            LayerItemImpl layerItemImpl = null;
            if (layerItem != null && (typeHelper = this.mTypeHelper) != null) {
                layerItemImpl = (LayerItemImpl) typeHelper.transfer(method, 0, layerItem);
            }
            PrepareLayerParamInnerImpl prepareLayerParamInnerImpl = this.mService;
            if (prepareLayerParamInnerImpl != null) {
                return prepareLayerParamInnerImpl.$explicit_getPrepareLayerParam(layerItemImpl, prepareLayerMarkerParam);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }
}
