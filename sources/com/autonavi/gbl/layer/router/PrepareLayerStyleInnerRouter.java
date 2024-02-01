package com.autonavi.gbl.layer.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
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
import com.autonavi.gbl.map.impl.IMapViewImpl;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.model.ItemStyleInfo;
import com.autonavi.gbl.map.layer.model.RouteLayerStyle;
import java.lang.reflect.Method;
@IntfAuto(target = PrepareLayerStyleInner.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
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

    public PrepareLayerStyleInnerRouter(String str, IPrepareLayerStyleInner iPrepareLayerStyleInner, IMapViewImpl iMapViewImpl, ICardServiceImpl iCardServiceImpl, IPrepareLayerParamImpl iPrepareLayerParamImpl, InnerStyleParam innerStyleParam) {
        super(iMapViewImpl, iCardServiceImpl, iPrepareLayerParamImpl, innerStyleParam);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPrepareLayerStyleInner);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerStyleInnerImpl, com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerStyleInnerImpl
    public void setParam(IPrepareLayerParamImpl iPrepareLayerParamImpl) {
        TypeHelper typeHelper;
        try {
            Method method = PrepareLayerStyleInnerRouter.class.getMethod("setParam", IPrepareLayerParamImpl.class);
            PrepareLayerParam prepareLayerParam = null;
            if (iPrepareLayerParamImpl != null && (typeHelper = this.mHelper) != null) {
                prepareLayerParam = (PrepareLayerParam) typeHelper.transfer(method, 0, iPrepareLayerParamImpl);
            }
            IPrepareLayerStyleInner iPrepareLayerStyleInner = this.mObserver;
            if (iPrepareLayerStyleInner != null) {
                iPrepareLayerStyleInner.setParam(prepareLayerParam);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerStyleInnerImpl, com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public int getMarkerId(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ItemStyleInfo itemStyleInfo) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = PrepareLayerStyleInnerRouter.class.getMethod("getMarkerId", BaseLayerImpl.class, LayerItemImpl.class, ItemStyleInfo.class);
            LayerItem layerItem = null;
            BaseLayer baseLayer = (baseLayerImpl == null || (typeHelper2 = this.mHelper) == null) ? null : (BaseLayer) typeHelper2.transfer(method, 0, baseLayerImpl);
            if (layerItemImpl != null && (typeHelper = this.mHelper) != null) {
                layerItem = (LayerItem) typeHelper.transfer(method, 1, layerItemImpl);
            }
            IPrepareLayerStyleInner iPrepareLayerStyleInner = this.mObserver;
            if (iPrepareLayerStyleInner != null) {
                return iPrepareLayerStyleInner.getMarkerId(baseLayer, layerItem, itemStyleInfo);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerStyleInnerImpl, com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public int get3DModelId(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, String str) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = PrepareLayerStyleInnerRouter.class.getMethod("get3DModelId", BaseLayerImpl.class, LayerItemImpl.class, String.class);
            LayerItem layerItem = null;
            BaseLayer baseLayer = (baseLayerImpl == null || (typeHelper2 = this.mHelper) == null) ? null : (BaseLayer) typeHelper2.transfer(method, 0, baseLayerImpl);
            if (layerItemImpl != null && (typeHelper = this.mHelper) != null) {
                layerItem = (LayerItem) typeHelper.transfer(method, 1, layerItemImpl);
            }
            IPrepareLayerStyleInner iPrepareLayerStyleInner = this.mObserver;
            if (iPrepareLayerStyleInner != null) {
                return iPrepareLayerStyleInner.get3DModelId(baseLayer, layerItem, str);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerStyleInnerImpl, com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public String getLayerStyle(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, boolean z) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = PrepareLayerStyleInnerRouter.class.getMethod("getLayerStyle", BaseLayerImpl.class, LayerItemImpl.class, Boolean.TYPE);
            BaseLayer baseLayer = (baseLayerImpl == null || (typeHelper2 = this.mHelper) == null) ? null : (BaseLayer) typeHelper2.transfer(method, 0, baseLayerImpl);
            LayerItem layerItem = (layerItemImpl == null || (typeHelper = this.mHelper) == null) ? null : (LayerItem) typeHelper.transfer(method, 1, layerItemImpl);
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
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = PrepareLayerStyleInnerRouter.class.getMethod("getRouteLayerStyle", BaseLayerImpl.class, LayerItemImpl.class, RouteLayerStyle.class);
            LayerItem layerItem = null;
            BaseLayer baseLayer = (baseLayerImpl == null || (typeHelper2 = this.mHelper) == null) ? null : (BaseLayer) typeHelper2.transfer(method, 0, baseLayerImpl);
            if (layerItemImpl != null && (typeHelper = this.mHelper) != null) {
                layerItem = (LayerItem) typeHelper.transfer(method, 1, layerItemImpl);
            }
            IPrepareLayerStyleInner iPrepareLayerStyleInner = this.mObserver;
            if (iPrepareLayerStyleInner != null) {
                return iPrepareLayerStyleInner.getRouteLayerStyle(baseLayer, layerItem, routeLayerStyle);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerStyleInnerImpl, com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public void clearLayerItems(BaseLayerImpl baseLayerImpl) {
        TypeHelper typeHelper;
        try {
            Method method = PrepareLayerStyleInnerRouter.class.getMethod("clearLayerItems", BaseLayerImpl.class);
            BaseLayer baseLayer = null;
            if (baseLayerImpl != null && (typeHelper = this.mHelper) != null) {
                baseLayer = (BaseLayer) typeHelper.transfer(method, 0, baseLayerImpl);
            }
            IPrepareLayerStyleInner iPrepareLayerStyleInner = this.mObserver;
            if (iPrepareLayerStyleInner != null) {
                iPrepareLayerStyleInner.clearLayerItems(baseLayer);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerStyleInnerImpl, com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public void clearLayerItem(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = PrepareLayerStyleInnerRouter.class.getMethod("clearLayerItem", BaseLayerImpl.class, LayerItemImpl.class);
            LayerItem layerItem = null;
            BaseLayer baseLayer = (baseLayerImpl == null || (typeHelper2 = this.mHelper) == null) ? null : (BaseLayer) typeHelper2.transfer(method, 0, baseLayerImpl);
            if (layerItemImpl != null && (typeHelper = this.mHelper) != null) {
                layerItem = (LayerItem) typeHelper.transfer(method, 1, layerItemImpl);
            }
            IPrepareLayerStyleInner iPrepareLayerStyleInner = this.mObserver;
            if (iPrepareLayerStyleInner != null) {
                iPrepareLayerStyleInner.clearLayerItem(baseLayer, layerItem);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerStyleInnerImpl, com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public void clearLayerStyle(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = PrepareLayerStyleInnerRouter.class.getMethod("clearLayerStyle", BaseLayerImpl.class, LayerItemImpl.class);
            LayerItem layerItem = null;
            BaseLayer baseLayer = (baseLayerImpl == null || (typeHelper2 = this.mHelper) == null) ? null : (BaseLayer) typeHelper2.transfer(method, 0, baseLayerImpl);
            if (layerItemImpl != null && (typeHelper = this.mHelper) != null) {
                layerItem = (LayerItem) typeHelper.transfer(method, 1, layerItemImpl);
            }
            IPrepareLayerStyleInner iPrepareLayerStyleInner = this.mObserver;
            if (iPrepareLayerStyleInner != null) {
                iPrepareLayerStyleInner.clearLayerStyle(baseLayer, layerItem);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
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
    public String getCommonInfo(String str) {
        IPrepareLayerStyleInner iPrepareLayerStyleInner = this.mObserver;
        if (iPrepareLayerStyleInner != null) {
            return iPrepareLayerStyleInner.getCommonInfo(str);
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerStyleInnerImpl, com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl
    public boolean switchStyle(int i) {
        IPrepareLayerStyleInner iPrepareLayerStyleInner = this.mObserver;
        if (iPrepareLayerStyleInner != null) {
            return iPrepareLayerStyleInner.switchStyle(i);
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.impl.PrepareLayerStyleInnerImpl
    public int getInnerMarkerId(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ItemStyleInfo itemStyleInfo) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = PrepareLayerStyleInnerRouter.class.getMethod("getInnerMarkerId", BaseLayerImpl.class, LayerItemImpl.class, ItemStyleInfo.class);
            LayerItem layerItem = null;
            BaseLayer baseLayer = (baseLayerImpl == null || (typeHelper2 = this.mHelper) == null) ? null : (BaseLayer) typeHelper2.transfer(method, 0, baseLayerImpl);
            if (layerItemImpl != null && (typeHelper = this.mHelper) != null) {
                layerItem = (LayerItem) typeHelper.transfer(method, 1, layerItemImpl);
            }
            IPrepareLayerStyleInner iPrepareLayerStyleInner = this.mObserver;
            if (iPrepareLayerStyleInner != null) {
                return iPrepareLayerStyleInner.getInnerMarkerId(baseLayer, layerItem, itemStyleInfo);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }
}
