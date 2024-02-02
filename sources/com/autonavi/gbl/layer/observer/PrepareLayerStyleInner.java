package com.autonavi.gbl.layer.observer;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
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
import com.autonavi.gbl.map.impl.MapViewImpl;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.model.ItemStyleInfo;
import com.autonavi.gbl.map.layer.model.RouteLayerStyle;
import java.lang.reflect.Method;
@IntfAuto(target = PrepareLayerStyleInnerRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class PrepareLayerStyleInner implements IPrepareLayerStyleInner {
    private static String PACKAGE = ReflexTool.PN(PrepareLayerStyleInner.class);
    private boolean mHasDestroy;
    private PrepareLayerStyleInnerImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected PrepareLayerStyleInner(long j, boolean z) {
        this(new PrepareLayerStyleInnerRouter("PrepareLayerStyleInner", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IPrepareLayerStyleInner.class}, new Object[]{this});
    }

    public PrepareLayerStyleInner(MapView mapView, CardService cardService, PrepareLayerParam prepareLayerParam, InnerStyleParam innerStyleParam) {
        this(new PrepareLayerStyleInnerRouter("PrepareLayerStyleInner", null, (MapViewImpl) new TypeHelper(PACKAGE).transfer("com.autonavi.gbl.map.MapView", mapView), (ICardServiceImpl) new TypeHelper(PACKAGE).transfer("com.autonavi.gbl.card.CardService", cardService), (IPrepareLayerParamImpl) new TypeHelper(PACKAGE).transfer("com.autonavi.gbl.layer.observer.PrepareLayerParam", prepareLayerParam), innerStyleParam));
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

    public PrepareLayerStyleInnerImpl getService() {
        return this.mService;
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.observer.PrepareLayerStyleInner.1
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    protected void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.observer.PrepareLayerStyleInner.2
        }));
    }

    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    public synchronized void delete() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.observer.PrepareLayerStyleInner.3
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

    @Override // com.autonavi.gbl.layer.observer.IPrepareLayerStyleInner
    public void setParam(PrepareLayerParam prepareLayerParam) {
        try {
            Method method = PrepareLayerStyleInner.class.getMethod("setParam", PrepareLayerParam.class);
            if (prepareLayerParam != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IPrepareLayerParamImpl) typeHelper.transfer(method, 0, prepareLayerParam) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $customParam == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.observer.PrepareLayerStyleInner.4
                    }));
                }
            }
            PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl = this.mService;
            if (prepareLayerStyleInnerImpl != null) {
                prepareLayerStyleInnerImpl.$explicit_setParam(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IPrepareLayerStyleInner, com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    public int getMarkerId(BaseLayer baseLayer, LayerItem layerItem, ItemStyleInfo itemStyleInfo) {
        BaseLayerImpl baseLayerImpl;
        try {
            Method method = PrepareLayerStyleInner.class.getMethod("getMarkerId", BaseLayer.class, LayerItem.class, ItemStyleInfo.class);
            if (baseLayer != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                baseLayerImpl = typeHelper != null ? (BaseLayerImpl) typeHelper.transfer(method, 0, baseLayer) : null;
                if (baseLayerImpl == null) {
                    DebugTool.e("%s: $layer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.observer.PrepareLayerStyleInner.5
                    }));
                }
            } else {
                baseLayerImpl = null;
            }
            if (layerItem != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r2 = typeHelper2 != null ? (LayerItemImpl) typeHelper2.transfer(method, 1, layerItem) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.observer.PrepareLayerStyleInner.6
                    }));
                }
            }
            PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl = this.mService;
            if (prepareLayerStyleInnerImpl != null) {
                return prepareLayerStyleInnerImpl.$explicit_getMarkerId(baseLayerImpl, r2, itemStyleInfo);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IPrepareLayerStyleInner, com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    public int get3DModelId(BaseLayer baseLayer, LayerItem layerItem, String str) {
        BaseLayerImpl baseLayerImpl;
        try {
            Method method = PrepareLayerStyleInner.class.getMethod("get3DModelId", BaseLayer.class, LayerItem.class, String.class);
            if (baseLayer != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                baseLayerImpl = typeHelper != null ? (BaseLayerImpl) typeHelper.transfer(method, 0, baseLayer) : null;
                if (baseLayerImpl == null) {
                    DebugTool.e("%s: $layer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.observer.PrepareLayerStyleInner.7
                    }));
                }
            } else {
                baseLayerImpl = null;
            }
            if (layerItem != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r2 = typeHelper2 != null ? (LayerItemImpl) typeHelper2.transfer(method, 1, layerItem) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.observer.PrepareLayerStyleInner.8
                    }));
                }
            }
            PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl = this.mService;
            if (prepareLayerStyleInnerImpl != null) {
                return prepareLayerStyleInnerImpl.$explicit_get3DModelId(baseLayerImpl, r2, str);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IPrepareLayerStyleInner, com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    public String getLayerStyle(BaseLayer baseLayer, LayerItem layerItem, boolean z) {
        BaseLayerImpl baseLayerImpl;
        LayerItemImpl layerItemImpl;
        try {
            Method method = PrepareLayerStyleInner.class.getMethod("getLayerStyle", BaseLayer.class, LayerItem.class, Boolean.TYPE);
            if (baseLayer != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                baseLayerImpl = typeHelper != null ? (BaseLayerImpl) typeHelper.transfer(method, 0, baseLayer) : null;
                if (baseLayerImpl == null) {
                    DebugTool.e("%s: $layer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.observer.PrepareLayerStyleInner.9
                    }));
                }
            } else {
                baseLayerImpl = null;
            }
            if (layerItem != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                layerItemImpl = typeHelper2 != null ? (LayerItemImpl) typeHelper2.transfer(method, 1, layerItem) : null;
                if (layerItemImpl == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.observer.PrepareLayerStyleInner.10
                    }));
                }
            } else {
                layerItemImpl = null;
            }
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
        BaseLayerImpl baseLayerImpl;
        try {
            Method method = PrepareLayerStyleInner.class.getMethod("getRouteLayerStyle", BaseLayer.class, LayerItem.class, RouteLayerStyle.class);
            if (baseLayer != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                baseLayerImpl = typeHelper != null ? (BaseLayerImpl) typeHelper.transfer(method, 0, baseLayer) : null;
                if (baseLayerImpl == null) {
                    DebugTool.e("%s: $layer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.observer.PrepareLayerStyleInner.11
                    }));
                }
            } else {
                baseLayerImpl = null;
            }
            if (layerItem != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r2 = typeHelper2 != null ? (LayerItemImpl) typeHelper2.transfer(method, 1, layerItem) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.observer.PrepareLayerStyleInner.12
                    }));
                }
            }
            PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl = this.mService;
            if (prepareLayerStyleInnerImpl != null) {
                return prepareLayerStyleInnerImpl.$explicit_getRouteLayerStyle(baseLayerImpl, r2, routeLayerStyle);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
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
    public void clearLayerItems(BaseLayer baseLayer) {
        try {
            Method method = PrepareLayerStyleInner.class.getMethod("clearLayerItems", BaseLayer.class);
            if (baseLayer != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (BaseLayerImpl) typeHelper.transfer(method, 0, baseLayer) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $layer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.observer.PrepareLayerStyleInner.13
                    }));
                }
            }
            PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl = this.mService;
            if (prepareLayerStyleInnerImpl != null) {
                prepareLayerStyleInnerImpl.$explicit_clearLayerItems(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IPrepareLayerStyleInner, com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    public void clearLayerItem(BaseLayer baseLayer, LayerItem layerItem) {
        BaseLayerImpl baseLayerImpl;
        try {
            Method method = PrepareLayerStyleInner.class.getMethod("clearLayerItem", BaseLayer.class, LayerItem.class);
            if (baseLayer != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                baseLayerImpl = typeHelper != null ? (BaseLayerImpl) typeHelper.transfer(method, 0, baseLayer) : null;
                if (baseLayerImpl == null) {
                    DebugTool.e("%s: $layer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.observer.PrepareLayerStyleInner.14
                    }));
                }
            } else {
                baseLayerImpl = null;
            }
            if (layerItem != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r1 = typeHelper2 != null ? (LayerItemImpl) typeHelper2.transfer(method, 1, layerItem) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.observer.PrepareLayerStyleInner.15
                    }));
                }
            }
            PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl = this.mService;
            if (prepareLayerStyleInnerImpl != null) {
                prepareLayerStyleInnerImpl.$explicit_clearLayerItem(baseLayerImpl, r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IPrepareLayerStyleInner, com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    public void clearLayerStyle(BaseLayer baseLayer, LayerItem layerItem) {
        BaseLayerImpl baseLayerImpl;
        try {
            Method method = PrepareLayerStyleInner.class.getMethod("clearLayerStyle", BaseLayer.class, LayerItem.class);
            if (baseLayer != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                baseLayerImpl = typeHelper != null ? (BaseLayerImpl) typeHelper.transfer(method, 0, baseLayer) : null;
                if (baseLayerImpl == null) {
                    DebugTool.e("%s: $pLayer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.observer.PrepareLayerStyleInner.16
                    }));
                }
            } else {
                baseLayerImpl = null;
            }
            if (layerItem != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r1 = typeHelper2 != null ? (LayerItemImpl) typeHelper2.transfer(method, 1, layerItem) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pItem == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.observer.PrepareLayerStyleInner.17
                    }));
                }
            }
            PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl = this.mService;
            if (prepareLayerStyleInnerImpl != null) {
                prepareLayerStyleInnerImpl.$explicit_clearLayerStyle(baseLayerImpl, r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }
}
