package com.autonavi.gbl.layer.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.card.impl.ICardServiceImpl;
import com.autonavi.gbl.layer.model.InnerStyleParam;
import com.autonavi.gbl.layer.observer.IPrepareLayerStyleInner;
import com.autonavi.gbl.layer.observer.PrepareLayerParam;
import com.autonavi.gbl.layer.observer.PrepareLayerStyleInner;
import com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl;
import com.autonavi.gbl.layer.observer.impl.PrepareLayerStyleInnerImpl;
import com.autonavi.gbl.map.impl.MapViewImpl;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.model.ItemStyleInfo;
import com.autonavi.gbl.map.layer.model.RouteLayerStyle;
import java.lang.reflect.Method;
@IntfAuto(target = PrepareLayerStyleInner.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class PrepareLayerStyleInnerRouter extends PrepareLayerStyleInnerImpl {
    private static BindTable BIND_TABLE = new BindTable(PrepareLayerStyleInnerRouter.class);
    private static String PACKAGE = ReflexTool.PN(PrepareLayerStyleInnerRouter.class);
    private TypeHelper mHelper;
    private IPrepareLayerStyleInner mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IPrepareLayerStyleInner iPrepareLayerStyleInner) {
        if (iPrepareLayerStyleInner != null) {
            this.mObserver = iPrepareLayerStyleInner;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(PrepareLayerStyleInner.class, iPrepareLayerStyleInner, this);
            }
        }
    }

    private void $constructor(String str, IPrepareLayerStyleInner iPrepareLayerStyleInner) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(PrepareLayerStyleInnerImpl.getCPtr((PrepareLayerStyleInnerImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iPrepareLayerStyleInner);
    }

    public PrepareLayerStyleInnerRouter(String str, IPrepareLayerStyleInner iPrepareLayerStyleInner, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPrepareLayerStyleInner);
    }

    public PrepareLayerStyleInnerRouter(String str, IPrepareLayerStyleInner iPrepareLayerStyleInner, MapViewImpl mapViewImpl, ICardServiceImpl iCardServiceImpl, IPrepareLayerParamImpl iPrepareLayerParamImpl, InnerStyleParam innerStyleParam) {
        super(mapViewImpl, iCardServiceImpl, iPrepareLayerParamImpl, innerStyleParam);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPrepareLayerStyleInner);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PrepareLayerStyleInnerRouter.1
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
    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerStyleInnerImpl, com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PrepareLayerStyleInnerRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerStyleInnerImpl
    public void setParam(IPrepareLayerParamImpl iPrepareLayerParamImpl) {
        try {
            Method method = PrepareLayerStyleInnerRouter.class.getMethod("setParam", IPrepareLayerParamImpl.class);
            if (iPrepareLayerParamImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r1 = typeHelper != null ? (PrepareLayerParam) typeHelper.transfer(method, 0, iPrepareLayerParamImpl) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $customParam == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PrepareLayerStyleInnerRouter.3
                    }));
                }
            }
            IPrepareLayerStyleInner iPrepareLayerStyleInner = this.mObserver;
            if (iPrepareLayerStyleInner != null) {
                iPrepareLayerStyleInner.setParam(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerStyleInnerImpl, com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public int getMarkerId(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ItemStyleInfo itemStyleInfo) {
        BaseLayer baseLayer;
        try {
            Method method = PrepareLayerStyleInnerRouter.class.getMethod("getMarkerId", BaseLayerImpl.class, LayerItemImpl.class, ItemStyleInfo.class);
            if (baseLayerImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                baseLayer = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, 0, baseLayerImpl) : null;
                if (baseLayer == null) {
                    DebugTool.e("%s: $layer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PrepareLayerStyleInnerRouter.4
                    }));
                }
            } else {
                baseLayer = null;
            }
            if (layerItemImpl != null) {
                TypeHelper typeHelper2 = this.mHelper;
                r2 = typeHelper2 != null ? (LayerItem) typeHelper2.transfer(method, 1, layerItemImpl) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PrepareLayerStyleInnerRouter.5
                    }));
                }
            }
            IPrepareLayerStyleInner iPrepareLayerStyleInner = this.mObserver;
            if (iPrepareLayerStyleInner != null) {
                return iPrepareLayerStyleInner.getMarkerId(baseLayer, r2, itemStyleInfo);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerStyleInnerImpl, com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public int get3DModelId(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, String str) {
        BaseLayer baseLayer;
        try {
            Method method = PrepareLayerStyleInnerRouter.class.getMethod("get3DModelId", BaseLayerImpl.class, LayerItemImpl.class, String.class);
            if (baseLayerImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                baseLayer = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, 0, baseLayerImpl) : null;
                if (baseLayer == null) {
                    DebugTool.e("%s: $layer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PrepareLayerStyleInnerRouter.6
                    }));
                }
            } else {
                baseLayer = null;
            }
            if (layerItemImpl != null) {
                TypeHelper typeHelper2 = this.mHelper;
                r2 = typeHelper2 != null ? (LayerItem) typeHelper2.transfer(method, 1, layerItemImpl) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PrepareLayerStyleInnerRouter.7
                    }));
                }
            }
            IPrepareLayerStyleInner iPrepareLayerStyleInner = this.mObserver;
            if (iPrepareLayerStyleInner != null) {
                return iPrepareLayerStyleInner.get3DModelId(baseLayer, r2, str);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerStyleInnerImpl, com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public String getLayerStyle(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, boolean z) {
        BaseLayer baseLayer;
        LayerItem layerItem;
        try {
            Method method = PrepareLayerStyleInnerRouter.class.getMethod("getLayerStyle", BaseLayerImpl.class, LayerItemImpl.class, Boolean.TYPE);
            if (baseLayerImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                baseLayer = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, 0, baseLayerImpl) : null;
                if (baseLayer == null) {
                    DebugTool.e("%s: $layer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PrepareLayerStyleInnerRouter.8
                    }));
                }
            } else {
                baseLayer = null;
            }
            if (layerItemImpl != null) {
                TypeHelper typeHelper2 = this.mHelper;
                layerItem = typeHelper2 != null ? (LayerItem) typeHelper2.transfer(method, 1, layerItemImpl) : null;
                if (layerItem == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PrepareLayerStyleInnerRouter.9
                    }));
                }
            } else {
                layerItem = null;
            }
            IPrepareLayerStyleInner iPrepareLayerStyleInner = this.mObserver;
            if (iPrepareLayerStyleInner != null) {
                return iPrepareLayerStyleInner.getLayerStyle(baseLayer, layerItem, z);
            }
            return null;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerStyleInnerImpl, com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public boolean getRouteLayerStyle(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, RouteLayerStyle routeLayerStyle) {
        BaseLayer baseLayer;
        try {
            Method method = PrepareLayerStyleInnerRouter.class.getMethod("getRouteLayerStyle", BaseLayerImpl.class, LayerItemImpl.class, RouteLayerStyle.class);
            if (baseLayerImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                baseLayer = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, 0, baseLayerImpl) : null;
                if (baseLayer == null) {
                    DebugTool.e("%s: $layer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PrepareLayerStyleInnerRouter.10
                    }));
                }
            } else {
                baseLayer = null;
            }
            if (layerItemImpl != null) {
                TypeHelper typeHelper2 = this.mHelper;
                r2 = typeHelper2 != null ? (LayerItem) typeHelper2.transfer(method, 1, layerItemImpl) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PrepareLayerStyleInnerRouter.11
                    }));
                }
            }
            IPrepareLayerStyleInner iPrepareLayerStyleInner = this.mObserver;
            if (iPrepareLayerStyleInner != null) {
                return iPrepareLayerStyleInner.getRouteLayerStyle(baseLayer, r2, routeLayerStyle);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerStyleInnerImpl, com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public boolean isRouteCacheStyleEnabled() {
        IPrepareLayerStyleInner iPrepareLayerStyleInner = this.mObserver;
        if (iPrepareLayerStyleInner != null) {
            return iPrepareLayerStyleInner.isRouteCacheStyleEnabled();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerStyleInnerImpl, com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public boolean isRouteStyleNightMode() {
        IPrepareLayerStyleInner iPrepareLayerStyleInner = this.mObserver;
        if (iPrepareLayerStyleInner != null) {
            return iPrepareLayerStyleInner.isRouteStyleNightMode();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerStyleInnerImpl, com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public void clearLayerItems(BaseLayerImpl baseLayerImpl) {
        try {
            Method method = PrepareLayerStyleInnerRouter.class.getMethod("clearLayerItems", BaseLayerImpl.class);
            if (baseLayerImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r1 = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, 0, baseLayerImpl) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $layer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PrepareLayerStyleInnerRouter.12
                    }));
                }
            }
            IPrepareLayerStyleInner iPrepareLayerStyleInner = this.mObserver;
            if (iPrepareLayerStyleInner != null) {
                iPrepareLayerStyleInner.clearLayerItems(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerStyleInnerImpl, com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public void clearLayerItem(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl) {
        BaseLayer baseLayer;
        try {
            Method method = PrepareLayerStyleInnerRouter.class.getMethod("clearLayerItem", BaseLayerImpl.class, LayerItemImpl.class);
            if (baseLayerImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                baseLayer = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, 0, baseLayerImpl) : null;
                if (baseLayer == null) {
                    DebugTool.e("%s: $layer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PrepareLayerStyleInnerRouter.13
                    }));
                }
            } else {
                baseLayer = null;
            }
            if (layerItemImpl != null) {
                TypeHelper typeHelper2 = this.mHelper;
                r1 = typeHelper2 != null ? (LayerItem) typeHelper2.transfer(method, 1, layerItemImpl) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PrepareLayerStyleInnerRouter.14
                    }));
                }
            }
            IPrepareLayerStyleInner iPrepareLayerStyleInner = this.mObserver;
            if (iPrepareLayerStyleInner != null) {
                iPrepareLayerStyleInner.clearLayerItem(baseLayer, r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerStyleInnerImpl, com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public void clearLayerStyle(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl) {
        BaseLayer baseLayer;
        try {
            Method method = PrepareLayerStyleInnerRouter.class.getMethod("clearLayerStyle", BaseLayerImpl.class, LayerItemImpl.class);
            if (baseLayerImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                baseLayer = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, 0, baseLayerImpl) : null;
                if (baseLayer == null) {
                    DebugTool.e("%s: $pLayer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PrepareLayerStyleInnerRouter.15
                    }));
                }
            } else {
                baseLayer = null;
            }
            if (layerItemImpl != null) {
                TypeHelper typeHelper2 = this.mHelper;
                r1 = typeHelper2 != null ? (LayerItem) typeHelper2.transfer(method, 1, layerItemImpl) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pItem == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.router.PrepareLayerStyleInnerRouter.16
                    }));
                }
            }
            IPrepareLayerStyleInner iPrepareLayerStyleInner = this.mObserver;
            if (iPrepareLayerStyleInner != null) {
                iPrepareLayerStyleInner.clearLayerStyle(baseLayer, r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }
}
