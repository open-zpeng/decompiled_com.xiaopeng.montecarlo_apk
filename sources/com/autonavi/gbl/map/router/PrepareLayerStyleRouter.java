package com.autonavi.gbl.map.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.model.ItemStyleInfo;
import com.autonavi.gbl.map.layer.model.RouteLayerStyle;
import com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle;
import com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl;
import java.lang.reflect.Method;
@IntfAuto(target = IPrepareLayerStyle.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class PrepareLayerStyleRouter extends IPrepareLayerStyleImpl {
    private static BindTable BIND_TABLE = new BindTable(PrepareLayerStyleRouter.class);
    private static String PACKAGE = ReflexTool.PN(PrepareLayerStyleRouter.class);
    private TypeHelper mHelper;
    private IPrepareLayerStyle mObserver;
    private String mTargetId;

    private void $constructor(String str, IPrepareLayerStyle iPrepareLayerStyle) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IPrepareLayerStyleImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iPrepareLayerStyle;
    }

    protected PrepareLayerStyleRouter(String str, IPrepareLayerStyle iPrepareLayerStyle, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPrepareLayerStyle);
    }

    protected PrepareLayerStyleRouter(String str, IPrepareLayerStyle iPrepareLayerStyle) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPrepareLayerStyle);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.PrepareLayerStyleRouter.1
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
    @Override // com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.PrepareLayerStyleRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public int getMarkerId(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ItemStyleInfo itemStyleInfo) {
        BaseLayer baseLayer;
        try {
            Method method = PrepareLayerStyleRouter.class.getMethod("getMarkerId", BaseLayerImpl.class, LayerItemImpl.class, ItemStyleInfo.class);
            if (baseLayerImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                baseLayer = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, 0, baseLayerImpl) : null;
                if (baseLayer == null) {
                    DebugTool.e("%s: $layer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.PrepareLayerStyleRouter.3
                    }));
                }
            } else {
                baseLayer = null;
            }
            if (layerItemImpl != null) {
                TypeHelper typeHelper2 = this.mHelper;
                r2 = typeHelper2 != null ? (LayerItem) typeHelper2.transfer(method, 1, layerItemImpl) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.PrepareLayerStyleRouter.4
                    }));
                }
            }
            IPrepareLayerStyle iPrepareLayerStyle = this.mObserver;
            if (iPrepareLayerStyle != null) {
                return iPrepareLayerStyle.getMarkerId(baseLayer, r2, itemStyleInfo);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public int get3DModelId(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, String str) {
        BaseLayer baseLayer;
        try {
            Method method = PrepareLayerStyleRouter.class.getMethod("get3DModelId", BaseLayerImpl.class, LayerItemImpl.class, String.class);
            if (baseLayerImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                baseLayer = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, 0, baseLayerImpl) : null;
                if (baseLayer == null) {
                    DebugTool.e("%s: $layer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.PrepareLayerStyleRouter.5
                    }));
                }
            } else {
                baseLayer = null;
            }
            if (layerItemImpl != null) {
                TypeHelper typeHelper2 = this.mHelper;
                r2 = typeHelper2 != null ? (LayerItem) typeHelper2.transfer(method, 1, layerItemImpl) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.PrepareLayerStyleRouter.6
                    }));
                }
            }
            IPrepareLayerStyle iPrepareLayerStyle = this.mObserver;
            if (iPrepareLayerStyle != null) {
                return iPrepareLayerStyle.get3DModelId(baseLayer, r2, str);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public String getLayerStyle(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, boolean z) {
        BaseLayer baseLayer;
        LayerItem layerItem;
        try {
            Method method = PrepareLayerStyleRouter.class.getMethod("getLayerStyle", BaseLayerImpl.class, LayerItemImpl.class, Boolean.TYPE);
            if (baseLayerImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                baseLayer = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, 0, baseLayerImpl) : null;
                if (baseLayer == null) {
                    DebugTool.e("%s: $layer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.PrepareLayerStyleRouter.7
                    }));
                }
            } else {
                baseLayer = null;
            }
            if (layerItemImpl != null) {
                TypeHelper typeHelper2 = this.mHelper;
                layerItem = typeHelper2 != null ? (LayerItem) typeHelper2.transfer(method, 1, layerItemImpl) : null;
                if (layerItem == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.PrepareLayerStyleRouter.8
                    }));
                }
            } else {
                layerItem = null;
            }
            IPrepareLayerStyle iPrepareLayerStyle = this.mObserver;
            if (iPrepareLayerStyle != null) {
                return iPrepareLayerStyle.getLayerStyle(baseLayer, layerItem, z);
            }
            return null;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public boolean getRouteLayerStyle(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, RouteLayerStyle routeLayerStyle) {
        BaseLayer baseLayer;
        try {
            Method method = PrepareLayerStyleRouter.class.getMethod("getRouteLayerStyle", BaseLayerImpl.class, LayerItemImpl.class, RouteLayerStyle.class);
            if (baseLayerImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                baseLayer = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, 0, baseLayerImpl) : null;
                if (baseLayer == null) {
                    DebugTool.e("%s: $layer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.PrepareLayerStyleRouter.9
                    }));
                }
            } else {
                baseLayer = null;
            }
            if (layerItemImpl != null) {
                TypeHelper typeHelper2 = this.mHelper;
                r2 = typeHelper2 != null ? (LayerItem) typeHelper2.transfer(method, 1, layerItemImpl) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.PrepareLayerStyleRouter.10
                    }));
                }
            }
            IPrepareLayerStyle iPrepareLayerStyle = this.mObserver;
            if (iPrepareLayerStyle != null) {
                return iPrepareLayerStyle.getRouteLayerStyle(baseLayer, r2, routeLayerStyle);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public boolean isRouteCacheStyleEnabled() {
        IPrepareLayerStyle iPrepareLayerStyle = this.mObserver;
        if (iPrepareLayerStyle != null) {
            return iPrepareLayerStyle.isRouteCacheStyleEnabled();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public boolean isRouteStyleNightMode() {
        IPrepareLayerStyle iPrepareLayerStyle = this.mObserver;
        if (iPrepareLayerStyle != null) {
            return iPrepareLayerStyle.isRouteStyleNightMode();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public void clearLayerItems(BaseLayerImpl baseLayerImpl) {
        try {
            Method method = PrepareLayerStyleRouter.class.getMethod("clearLayerItems", BaseLayerImpl.class);
            if (baseLayerImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r1 = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, 0, baseLayerImpl) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $layer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.PrepareLayerStyleRouter.11
                    }));
                }
            }
            IPrepareLayerStyle iPrepareLayerStyle = this.mObserver;
            if (iPrepareLayerStyle != null) {
                iPrepareLayerStyle.clearLayerItems(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public void clearLayerItem(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl) {
        BaseLayer baseLayer;
        try {
            Method method = PrepareLayerStyleRouter.class.getMethod("clearLayerItem", BaseLayerImpl.class, LayerItemImpl.class);
            if (baseLayerImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                baseLayer = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, 0, baseLayerImpl) : null;
                if (baseLayer == null) {
                    DebugTool.e("%s: $layer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.PrepareLayerStyleRouter.12
                    }));
                }
            } else {
                baseLayer = null;
            }
            if (layerItemImpl != null) {
                TypeHelper typeHelper2 = this.mHelper;
                r1 = typeHelper2 != null ? (LayerItem) typeHelper2.transfer(method, 1, layerItemImpl) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $item == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.PrepareLayerStyleRouter.13
                    }));
                }
            }
            IPrepareLayerStyle iPrepareLayerStyle = this.mObserver;
            if (iPrepareLayerStyle != null) {
                iPrepareLayerStyle.clearLayerItem(baseLayer, r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public void clearLayerStyle(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl) {
        BaseLayer baseLayer;
        try {
            Method method = PrepareLayerStyleRouter.class.getMethod("clearLayerStyle", BaseLayerImpl.class, LayerItemImpl.class);
            if (baseLayerImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                baseLayer = typeHelper != null ? (BaseLayer) typeHelper.transfer(method, 0, baseLayerImpl) : null;
                if (baseLayer == null) {
                    DebugTool.e("%s: $pLayer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.PrepareLayerStyleRouter.14
                    }));
                }
            } else {
                baseLayer = null;
            }
            if (layerItemImpl != null) {
                TypeHelper typeHelper2 = this.mHelper;
                r1 = typeHelper2 != null ? (LayerItem) typeHelper2.transfer(method, 1, layerItemImpl) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pItem == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.PrepareLayerStyleRouter.15
                    }));
                }
            }
            IPrepareLayerStyle iPrepareLayerStyle = this.mObserver;
            if (iPrepareLayerStyle != null) {
                iPrepareLayerStyle.clearLayerStyle(baseLayer, r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }
}
