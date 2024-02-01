package com.autonavi.gbl.map.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
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
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public int getMarkerId(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ItemStyleInfo itemStyleInfo) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = PrepareLayerStyleRouter.class.getMethod("getMarkerId", BaseLayerImpl.class, LayerItemImpl.class, ItemStyleInfo.class);
            LayerItem layerItem = null;
            BaseLayer baseLayer = (baseLayerImpl == null || (typeHelper2 = this.mHelper) == null) ? null : (BaseLayer) typeHelper2.transfer(method, 0, baseLayerImpl);
            if (layerItemImpl != null && (typeHelper = this.mHelper) != null) {
                layerItem = (LayerItem) typeHelper.transfer(method, 1, layerItemImpl);
            }
            IPrepareLayerStyle iPrepareLayerStyle = this.mObserver;
            if (iPrepareLayerStyle != null) {
                return iPrepareLayerStyle.getMarkerId(baseLayer, layerItem, itemStyleInfo);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public int get3DModelId(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, String str) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = PrepareLayerStyleRouter.class.getMethod("get3DModelId", BaseLayerImpl.class, LayerItemImpl.class, String.class);
            LayerItem layerItem = null;
            BaseLayer baseLayer = (baseLayerImpl == null || (typeHelper2 = this.mHelper) == null) ? null : (BaseLayer) typeHelper2.transfer(method, 0, baseLayerImpl);
            if (layerItemImpl != null && (typeHelper = this.mHelper) != null) {
                layerItem = (LayerItem) typeHelper.transfer(method, 1, layerItemImpl);
            }
            IPrepareLayerStyle iPrepareLayerStyle = this.mObserver;
            if (iPrepareLayerStyle != null) {
                return iPrepareLayerStyle.get3DModelId(baseLayer, layerItem, str);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public String getLayerStyle(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, boolean z) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = PrepareLayerStyleRouter.class.getMethod("getLayerStyle", BaseLayerImpl.class, LayerItemImpl.class, Boolean.TYPE);
            BaseLayer baseLayer = (baseLayerImpl == null || (typeHelper2 = this.mHelper) == null) ? null : (BaseLayer) typeHelper2.transfer(method, 0, baseLayerImpl);
            LayerItem layerItem = (layerItemImpl == null || (typeHelper = this.mHelper) == null) ? null : (LayerItem) typeHelper.transfer(method, 1, layerItemImpl);
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
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = PrepareLayerStyleRouter.class.getMethod("getRouteLayerStyle", BaseLayerImpl.class, LayerItemImpl.class, RouteLayerStyle.class);
            LayerItem layerItem = null;
            BaseLayer baseLayer = (baseLayerImpl == null || (typeHelper2 = this.mHelper) == null) ? null : (BaseLayer) typeHelper2.transfer(method, 0, baseLayerImpl);
            if (layerItemImpl != null && (typeHelper = this.mHelper) != null) {
                layerItem = (LayerItem) typeHelper.transfer(method, 1, layerItemImpl);
            }
            IPrepareLayerStyle iPrepareLayerStyle = this.mObserver;
            if (iPrepareLayerStyle != null) {
                return iPrepareLayerStyle.getRouteLayerStyle(baseLayer, layerItem, routeLayerStyle);
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
        TypeHelper typeHelper;
        try {
            Method method = PrepareLayerStyleRouter.class.getMethod("clearLayerItems", BaseLayerImpl.class);
            BaseLayer baseLayer = null;
            if (baseLayerImpl != null && (typeHelper = this.mHelper) != null) {
                baseLayer = (BaseLayer) typeHelper.transfer(method, 0, baseLayerImpl);
            }
            IPrepareLayerStyle iPrepareLayerStyle = this.mObserver;
            if (iPrepareLayerStyle != null) {
                iPrepareLayerStyle.clearLayerItems(baseLayer);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public void clearLayerItem(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = PrepareLayerStyleRouter.class.getMethod("clearLayerItem", BaseLayerImpl.class, LayerItemImpl.class);
            LayerItem layerItem = null;
            BaseLayer baseLayer = (baseLayerImpl == null || (typeHelper2 = this.mHelper) == null) ? null : (BaseLayer) typeHelper2.transfer(method, 0, baseLayerImpl);
            if (layerItemImpl != null && (typeHelper = this.mHelper) != null) {
                layerItem = (LayerItem) typeHelper.transfer(method, 1, layerItemImpl);
            }
            IPrepareLayerStyle iPrepareLayerStyle = this.mObserver;
            if (iPrepareLayerStyle != null) {
                iPrepareLayerStyle.clearLayerItem(baseLayer, layerItem);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public void clearLayerStyle(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = PrepareLayerStyleRouter.class.getMethod("clearLayerStyle", BaseLayerImpl.class, LayerItemImpl.class);
            LayerItem layerItem = null;
            BaseLayer baseLayer = (baseLayerImpl == null || (typeHelper2 = this.mHelper) == null) ? null : (BaseLayer) typeHelper2.transfer(method, 0, baseLayerImpl);
            if (layerItemImpl != null && (typeHelper = this.mHelper) != null) {
                layerItem = (LayerItem) typeHelper.transfer(method, 1, layerItemImpl);
            }
            IPrepareLayerStyle iPrepareLayerStyle = this.mObserver;
            if (iPrepareLayerStyle != null) {
                iPrepareLayerStyle.clearLayerStyle(baseLayer, layerItem);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public String getCommonInfo(String str) {
        IPrepareLayerStyle iPrepareLayerStyle = this.mObserver;
        if (iPrepareLayerStyle != null) {
            return iPrepareLayerStyle.getCommonInfo(str);
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public boolean switchStyle(int i) {
        IPrepareLayerStyle iPrepareLayerStyle = this.mObserver;
        if (iPrepareLayerStyle != null) {
            return iPrepareLayerStyle.switchStyle(i);
        }
        return false;
    }
}
