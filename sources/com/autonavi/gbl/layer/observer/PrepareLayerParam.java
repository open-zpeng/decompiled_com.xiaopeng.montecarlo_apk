package com.autonavi.gbl.layer.observer;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.card.model.CustomTextureParam;
import com.autonavi.gbl.layer.model.PrepareLayerMarkerParam;
import com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl;
import com.autonavi.gbl.layer.router.PrepareLayerParamRouter;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.model.ItemStyleInfo;
import com.autonavi.gbl.map.model.MapEngineID;
import java.lang.reflect.Method;
@IntfAuto(target = PrepareLayerParamRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class PrepareLayerParam implements IPrepareLayerParam {
    private static String PACKAGE = ReflexTool.PN(PrepareLayerParam.class);
    private boolean mHasDestroy;
    private IPrepareLayerParamImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    /* JADX INFO: Access modifiers changed from: protected */
    public void clean() {
    }

    protected PrepareLayerParam(long j, boolean z) {
        this(new PrepareLayerParamRouter("PrepareLayerParam", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IPrepareLayerParam.class}, new Object[]{this});
    }

    public PrepareLayerParam(@MapEngineID.MapEngineID1 int i) {
        this(new PrepareLayerParamRouter("PrepareLayerParam", null, i));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IPrepareLayerParam.class}, new Object[]{this});
    }

    public PrepareLayerParam(IPrepareLayerParamImpl iPrepareLayerParamImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(iPrepareLayerParamImpl);
    }

    private void $constructor(IPrepareLayerParamImpl iPrepareLayerParamImpl) {
        if (iPrepareLayerParamImpl != null) {
            this.mService = iPrepareLayerParamImpl;
            this.mTargetId = String.format("PrepareLayerParam_%s_%d", String.valueOf(IPrepareLayerParamImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IPrepareLayerParamImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

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

    public boolean updateCardContent(BaseLayer baseLayer, LayerItem layerItem, ItemStyleInfo itemStyleInfo, CustomTextureParam customTextureParam) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = PrepareLayerParam.class.getMethod("updateCardContent", BaseLayer.class, LayerItem.class, ItemStyleInfo.class, CustomTextureParam.class);
            LayerItemImpl layerItemImpl = null;
            BaseLayerImpl baseLayerImpl = (baseLayer == null || (typeHelper2 = this.mTypeHelper) == null) ? null : (BaseLayerImpl) typeHelper2.transfer(method, 0, baseLayer);
            if (layerItem != null && (typeHelper = this.mTypeHelper) != null) {
                layerItemImpl = (LayerItemImpl) typeHelper.transfer(method, 1, layerItem);
            }
            IPrepareLayerParamImpl iPrepareLayerParamImpl = this.mService;
            if (iPrepareLayerParamImpl != null) {
                return iPrepareLayerParamImpl.$explicit_updateCardContent(baseLayerImpl, layerItemImpl, itemStyleInfo, customTextureParam);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean isRouteCacheStyleEnabled() {
        IPrepareLayerParamImpl iPrepareLayerParamImpl = this.mService;
        if (iPrepareLayerParamImpl != null) {
            return iPrepareLayerParamImpl.$explicit_isRouteCacheStyleEnabled();
        }
        return false;
    }

    public boolean isRouteStyleNightMode() {
        IPrepareLayerParamImpl iPrepareLayerParamImpl = this.mService;
        if (iPrepareLayerParamImpl != null) {
            return iPrepareLayerParamImpl.$explicit_isRouteStyleNightMode();
        }
        return false;
    }

    public boolean isStaticMarker(String str) {
        IPrepareLayerParamImpl iPrepareLayerParamImpl = this.mService;
        if (iPrepareLayerParamImpl != null) {
            return iPrepareLayerParamImpl.$explicit_isStaticMarker(str);
        }
        return false;
    }

    public boolean isDynamicMarker(String str) {
        IPrepareLayerParamImpl iPrepareLayerParamImpl = this.mService;
        if (iPrepareLayerParamImpl != null) {
            return iPrepareLayerParamImpl.$explicit_isDynamicMarker(str);
        }
        return false;
    }

    public boolean isNightMode() {
        IPrepareLayerParamImpl iPrepareLayerParamImpl = this.mService;
        if (iPrepareLayerParamImpl != null) {
            return iPrepareLayerParamImpl.$explicit_isNightMode();
        }
        return false;
    }

    public boolean isEnglish() {
        IPrepareLayerParamImpl iPrepareLayerParamImpl = this.mService;
        if (iPrepareLayerParamImpl != null) {
            return iPrepareLayerParamImpl.$explicit_isEnglish();
        }
        return false;
    }

    public boolean isInForeground() {
        IPrepareLayerParamImpl iPrepareLayerParamImpl = this.mService;
        if (iPrepareLayerParamImpl != null) {
            return iPrepareLayerParamImpl.$explicit_isInForeground();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.IPrepareLayerParam
    public boolean getPrepareLayerParam(LayerItem layerItem, PrepareLayerMarkerParam prepareLayerMarkerParam) {
        TypeHelper typeHelper;
        try {
            Method method = PrepareLayerParam.class.getMethod("getPrepareLayerParam", LayerItem.class, PrepareLayerMarkerParam.class);
            LayerItemImpl layerItemImpl = null;
            if (layerItem != null && (typeHelper = this.mTypeHelper) != null) {
                layerItemImpl = (LayerItemImpl) typeHelper.transfer(method, 0, layerItem);
            }
            IPrepareLayerParamImpl iPrepareLayerParamImpl = this.mService;
            if (iPrepareLayerParamImpl != null) {
                return iPrepareLayerParamImpl.$explicit_getPrepareLayerParam(layerItemImpl, prepareLayerMarkerParam);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IPrepareLayerParam
    public boolean getNewStaticMarkerId(BaseLayer baseLayer, LayerItem layerItem, ItemStyleInfo itemStyleInfo, String[] strArr) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = PrepareLayerParam.class.getMethod("getNewStaticMarkerId", BaseLayer.class, LayerItem.class, ItemStyleInfo.class, String[].class);
            LayerItemImpl layerItemImpl = null;
            BaseLayerImpl baseLayerImpl = (baseLayer == null || (typeHelper2 = this.mTypeHelper) == null) ? null : (BaseLayerImpl) typeHelper2.transfer(method, 0, baseLayer);
            if (layerItem != null && (typeHelper = this.mTypeHelper) != null) {
                layerItemImpl = (LayerItemImpl) typeHelper.transfer(method, 1, layerItem);
            }
            IPrepareLayerParamImpl iPrepareLayerParamImpl = this.mService;
            if (iPrepareLayerParamImpl != null) {
                return iPrepareLayerParamImpl.$explicit_getNewStaticMarkerId(baseLayerImpl, layerItemImpl, itemStyleInfo, strArr);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IPrepareLayerParam
    public int get3DModelId(BaseLayer baseLayer, LayerItem layerItem, String str) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = PrepareLayerParam.class.getMethod("get3DModelId", BaseLayer.class, LayerItem.class, String.class);
            LayerItemImpl layerItemImpl = null;
            BaseLayerImpl baseLayerImpl = (baseLayer == null || (typeHelper2 = this.mTypeHelper) == null) ? null : (BaseLayerImpl) typeHelper2.transfer(method, 0, baseLayer);
            if (layerItem != null && (typeHelper = this.mTypeHelper) != null) {
                layerItemImpl = (LayerItemImpl) typeHelper.transfer(method, 1, layerItem);
            }
            IPrepareLayerParamImpl iPrepareLayerParamImpl = this.mService;
            if (iPrepareLayerParamImpl != null) {
                return iPrepareLayerParamImpl.$explicit_get3DModelId(baseLayerImpl, layerItemImpl, str);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IPrepareLayerParam
    public float getPointMarkerScaleFactor() {
        IPrepareLayerParamImpl iPrepareLayerParamImpl = this.mService;
        if (iPrepareLayerParamImpl == null || iPrepareLayerParamImpl.isCMemOwn()) {
            return 0.0f;
        }
        return this.mService.$explicit_getPointMarkerScaleFactor();
    }

    @Override // com.autonavi.gbl.layer.observer.IPrepareLayerParam
    public float getRouteWidthScaleFactor(int i) {
        IPrepareLayerParamImpl iPrepareLayerParamImpl = this.mService;
        if (iPrepareLayerParamImpl == null || iPrepareLayerParamImpl.isCMemOwn()) {
            return 0.0f;
        }
        return this.mService.$explicit_getRouteWidthScaleFactor(i);
    }
}
