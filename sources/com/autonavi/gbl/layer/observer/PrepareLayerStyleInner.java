package com.autonavi.gbl.layer.observer;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.card.CardService;
import com.autonavi.gbl.card.impl.ICardServiceImpl;
import com.autonavi.gbl.layer.model.InnerStyleParam;
import com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl;
import com.autonavi.gbl.layer.observer.impl.PrepareLayerStyleInnerImpl;
import com.autonavi.gbl.layer.router.PrepareLayerStyleInnerRouter;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.impl.IMapViewImpl;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.model.ItemStyleInfo;
import com.autonavi.gbl.map.layer.model.RouteLayerStyle;
import java.lang.reflect.Method;
@IntfAuto(target = PrepareLayerStyleInnerRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class PrepareLayerStyleInner implements IPrepareLayerStyleInner {
    private static String PACKAGE = ReflexTool.PN(PrepareLayerStyleInner.class);
    private boolean mHasDestroy;
    private PrepareLayerStyleInnerImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected PrepareLayerStyleInner(long j, boolean z) {
        this(new PrepareLayerStyleInnerRouter("PrepareLayerStyleInner", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IPrepareLayerStyleInner.class}, new Object[]{this});
    }

    public PrepareLayerStyleInner(MapView mapView, CardService cardService, PrepareLayerParam prepareLayerParam, InnerStyleParam innerStyleParam) {
        this(new PrepareLayerStyleInnerRouter("PrepareLayerStyleInner", null, (IMapViewImpl) new TypeHelper(PACKAGE).transfer("com.autonavi.gbl.map.MapView", mapView), (ICardServiceImpl) new TypeHelper(PACKAGE).transfer("com.autonavi.gbl.card.CardService", cardService), (IPrepareLayerParamImpl) new TypeHelper(PACKAGE).transfer("com.autonavi.gbl.layer.observer.PrepareLayerParam", prepareLayerParam), innerStyleParam));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IPrepareLayerStyleInner.class}, new Object[]{this});
    }

    public PrepareLayerStyleInner(PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(prepareLayerStyleInnerImpl);
    }

    private void $constructor(PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl) {
        if (prepareLayerStyleInnerImpl != null) {
            this.mService = prepareLayerStyleInnerImpl;
            this.mTargetId = String.format("PrepareLayerStyleInner_%s_%d", String.valueOf(PrepareLayerStyleInnerImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected PrepareLayerStyleInnerImpl getService() {
        return this.mService;
    }

    protected void unbind() {
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

    @Override // com.autonavi.gbl.layer.observer.IPrepareLayerStyleInner
    public void setParam(PrepareLayerParam prepareLayerParam) {
        TypeHelper typeHelper;
        try {
            Method method = PrepareLayerStyleInner.class.getMethod("setParam", PrepareLayerParam.class);
            IPrepareLayerParamImpl iPrepareLayerParamImpl = null;
            if (prepareLayerParam != null && (typeHelper = this.mTypeHelper) != null) {
                iPrepareLayerParamImpl = (IPrepareLayerParamImpl) typeHelper.transfer(method, 0, prepareLayerParam);
            }
            PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl = this.mService;
            if (prepareLayerStyleInnerImpl != null) {
                prepareLayerStyleInnerImpl.$explicit_setParam(iPrepareLayerParamImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IPrepareLayerStyleInner, com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    public int getMarkerId(BaseLayer baseLayer, LayerItem layerItem, ItemStyleInfo itemStyleInfo) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = PrepareLayerStyleInner.class.getMethod("getMarkerId", BaseLayer.class, LayerItem.class, ItemStyleInfo.class);
            LayerItemImpl layerItemImpl = null;
            BaseLayerImpl baseLayerImpl = (baseLayer == null || (typeHelper2 = this.mTypeHelper) == null) ? null : (BaseLayerImpl) typeHelper2.transfer(method, 0, baseLayer);
            if (layerItem != null && (typeHelper = this.mTypeHelper) != null) {
                layerItemImpl = (LayerItemImpl) typeHelper.transfer(method, 1, layerItem);
            }
            PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl = this.mService;
            if (prepareLayerStyleInnerImpl != null) {
                return prepareLayerStyleInnerImpl.$explicit_getMarkerId(baseLayerImpl, layerItemImpl, itemStyleInfo);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IPrepareLayerStyleInner, com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    public int get3DModelId(BaseLayer baseLayer, LayerItem layerItem, String str) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = PrepareLayerStyleInner.class.getMethod("get3DModelId", BaseLayer.class, LayerItem.class, String.class);
            LayerItemImpl layerItemImpl = null;
            BaseLayerImpl baseLayerImpl = (baseLayer == null || (typeHelper2 = this.mTypeHelper) == null) ? null : (BaseLayerImpl) typeHelper2.transfer(method, 0, baseLayer);
            if (layerItem != null && (typeHelper = this.mTypeHelper) != null) {
                layerItemImpl = (LayerItemImpl) typeHelper.transfer(method, 1, layerItem);
            }
            PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl = this.mService;
            if (prepareLayerStyleInnerImpl != null) {
                return prepareLayerStyleInnerImpl.$explicit_get3DModelId(baseLayerImpl, layerItemImpl, str);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IPrepareLayerStyleInner, com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    public String getLayerStyle(BaseLayer baseLayer, LayerItem layerItem, boolean z) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = PrepareLayerStyleInner.class.getMethod("getLayerStyle", BaseLayer.class, LayerItem.class, Boolean.TYPE);
            BaseLayerImpl baseLayerImpl = (baseLayer == null || (typeHelper2 = this.mTypeHelper) == null) ? null : (BaseLayerImpl) typeHelper2.transfer(method, 0, baseLayer);
            LayerItemImpl layerItemImpl = (layerItem == null || (typeHelper = this.mTypeHelper) == null) ? null : (LayerItemImpl) typeHelper.transfer(method, 1, layerItem);
            PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl = this.mService;
            if (prepareLayerStyleInnerImpl != null) {
                return prepareLayerStyleInnerImpl.$explicit_getLayerStyle(baseLayerImpl, layerItemImpl, z);
            }
            return null;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IPrepareLayerStyleInner, com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    public boolean getRouteLayerStyle(BaseLayer baseLayer, LayerItem layerItem, RouteLayerStyle routeLayerStyle) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = PrepareLayerStyleInner.class.getMethod("getRouteLayerStyle", BaseLayer.class, LayerItem.class, RouteLayerStyle.class);
            LayerItemImpl layerItemImpl = null;
            BaseLayerImpl baseLayerImpl = (baseLayer == null || (typeHelper2 = this.mTypeHelper) == null) ? null : (BaseLayerImpl) typeHelper2.transfer(method, 0, baseLayer);
            if (layerItem != null && (typeHelper = this.mTypeHelper) != null) {
                layerItemImpl = (LayerItemImpl) typeHelper.transfer(method, 1, layerItem);
            }
            PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl = this.mService;
            if (prepareLayerStyleInnerImpl != null) {
                return prepareLayerStyleInnerImpl.$explicit_getRouteLayerStyle(baseLayerImpl, layerItemImpl, routeLayerStyle);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IPrepareLayerStyleInner, com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    public void clearLayerItems(BaseLayer baseLayer) {
        TypeHelper typeHelper;
        try {
            Method method = PrepareLayerStyleInner.class.getMethod("clearLayerItems", BaseLayer.class);
            BaseLayerImpl baseLayerImpl = null;
            if (baseLayer != null && (typeHelper = this.mTypeHelper) != null) {
                baseLayerImpl = (BaseLayerImpl) typeHelper.transfer(method, 0, baseLayer);
            }
            PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl = this.mService;
            if (prepareLayerStyleInnerImpl != null) {
                prepareLayerStyleInnerImpl.$explicit_clearLayerItems(baseLayerImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IPrepareLayerStyleInner, com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    public void clearLayerItem(BaseLayer baseLayer, LayerItem layerItem) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = PrepareLayerStyleInner.class.getMethod("clearLayerItem", BaseLayer.class, LayerItem.class);
            LayerItemImpl layerItemImpl = null;
            BaseLayerImpl baseLayerImpl = (baseLayer == null || (typeHelper2 = this.mTypeHelper) == null) ? null : (BaseLayerImpl) typeHelper2.transfer(method, 0, baseLayer);
            if (layerItem != null && (typeHelper = this.mTypeHelper) != null) {
                layerItemImpl = (LayerItemImpl) typeHelper.transfer(method, 1, layerItem);
            }
            PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl = this.mService;
            if (prepareLayerStyleInnerImpl != null) {
                prepareLayerStyleInnerImpl.$explicit_clearLayerItem(baseLayerImpl, layerItemImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IPrepareLayerStyleInner, com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    public void clearLayerStyle(BaseLayer baseLayer, LayerItem layerItem) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = PrepareLayerStyleInner.class.getMethod("clearLayerStyle", BaseLayer.class, LayerItem.class);
            LayerItemImpl layerItemImpl = null;
            BaseLayerImpl baseLayerImpl = (baseLayer == null || (typeHelper2 = this.mTypeHelper) == null) ? null : (BaseLayerImpl) typeHelper2.transfer(method, 0, baseLayer);
            if (layerItem != null && (typeHelper = this.mTypeHelper) != null) {
                layerItemImpl = (LayerItemImpl) typeHelper.transfer(method, 1, layerItem);
            }
            PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl = this.mService;
            if (prepareLayerStyleInnerImpl != null) {
                prepareLayerStyleInnerImpl.$explicit_clearLayerStyle(baseLayerImpl, layerItemImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IPrepareLayerStyleInner, com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    public boolean isRouteCacheStyleEnabled() {
        PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl = this.mService;
        if (prepareLayerStyleInnerImpl != null) {
            return prepareLayerStyleInnerImpl.$explicit_isRouteCacheStyleEnabled();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.IPrepareLayerStyleInner, com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    public boolean isRouteStyleNightMode() {
        PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl = this.mService;
        if (prepareLayerStyleInnerImpl != null) {
            return prepareLayerStyleInnerImpl.$explicit_isRouteStyleNightMode();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.IPrepareLayerStyleInner, com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    public String getCommonInfo(String str) {
        PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl = this.mService;
        if (prepareLayerStyleInnerImpl != null) {
            return prepareLayerStyleInnerImpl.$explicit_getCommonInfo(str);
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.IPrepareLayerStyleInner, com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    public boolean switchStyle(int i) {
        PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl = this.mService;
        if (prepareLayerStyleInnerImpl != null) {
            return prepareLayerStyleInnerImpl.$explicit_switchStyle(i);
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.IPrepareLayerStyleInner
    public int getInnerMarkerId(BaseLayer baseLayer, LayerItem layerItem, ItemStyleInfo itemStyleInfo) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = PrepareLayerStyleInner.class.getMethod("getInnerMarkerId", BaseLayer.class, LayerItem.class, ItemStyleInfo.class);
            LayerItemImpl layerItemImpl = null;
            BaseLayerImpl baseLayerImpl = (baseLayer == null || (typeHelper2 = this.mTypeHelper) == null) ? null : (BaseLayerImpl) typeHelper2.transfer(method, 0, baseLayer);
            if (layerItem != null && (typeHelper = this.mTypeHelper) != null) {
                layerItemImpl = (LayerItemImpl) typeHelper.transfer(method, 1, layerItem);
            }
            PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl = this.mService;
            if (prepareLayerStyleInnerImpl != null) {
                return prepareLayerStyleInnerImpl.$explicit_getInnerMarkerId(baseLayerImpl, layerItemImpl, itemStyleInfo);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }
}
