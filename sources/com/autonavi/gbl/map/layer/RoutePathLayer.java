package com.autonavi.gbl.map.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.impl.IMapViewImpl;
import com.autonavi.gbl.map.layer.impl.LineLayerItemImpl;
import com.autonavi.gbl.map.layer.impl.RoutePathLayerImpl;
import com.autonavi.gbl.map.layer.model.AnimationStyleParam;
import com.autonavi.gbl.map.layer.model.LayerPriority;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.MapRouteHighLightType;
import com.autonavi.gbl.map.layer.model.MapRoutePolylineDrawType;
import com.autonavi.gbl.map.layer.model.RouteLayerDrawParam;
import com.autonavi.gbl.map.layer.model.RouteLayerParam;
import com.autonavi.gbl.map.layer.model.RouteLayerPassedColor;
import com.autonavi.gbl.map.layer.model.RouteLayerScene;
import com.autonavi.gbl.map.layer.observer.ILayerClickObserver;
import com.autonavi.gbl.map.layer.observer.ILayerFocusChangeObserver;
import com.autonavi.gbl.map.layer.observer.ILayerItemAnimationObserver;
import com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle;
import com.autonavi.gbl.map.layer.observer.IRoutePathLayer;
import com.autonavi.gbl.map.layer.observer.impl.ILayerClickObserverImpl;
import com.autonavi.gbl.map.layer.observer.impl.ILayerFocusChangeObserverImpl;
import com.autonavi.gbl.map.layer.observer.impl.ILayerItemAnimationObserverImpl;
import com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl;
import com.autonavi.gbl.map.router.RoutePathLayerRouter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = RoutePathLayerRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class RoutePathLayer extends BaseLayer implements IRoutePathLayer {
    private static String PACKAGE = ReflexTool.PN(RoutePathLayer.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private RoutePathLayerImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected RoutePathLayer(long j, boolean z) {
        this(new RoutePathLayerRouter("RoutePathLayer", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRoutePathLayer.class}, new Object[]{this});
    }

    public RoutePathLayer(String str, String str2, MapView mapView) {
        this(new RoutePathLayerRouter("RoutePathLayer", null, str, str2, (IMapViewImpl) new TypeHelper(PACKAGE).transfer("com.autonavi.gbl.map.MapView", mapView)));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRoutePathLayer.class}, new Object[]{this});
    }

    public RoutePathLayer(RoutePathLayerImpl routePathLayerImpl) {
        super(routePathLayerImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(routePathLayerImpl);
    }

    private void $constructor(RoutePathLayerImpl routePathLayerImpl) {
        if (routePathLayerImpl != null) {
            this.mService = routePathLayerImpl;
            this.mTargetId = String.format("RoutePathLayer_%s_%d", String.valueOf(RoutePathLayerImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.BaseLayer, com.autonavi.gbl.map.CollisionGroup
    public RoutePathLayerImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.BaseLayer, com.autonavi.gbl.map.CollisionGroup
    public void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
        super.unbind();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.BaseLayer, com.autonavi.gbl.map.CollisionGroup
    public void clean() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.map.layer.observer.ILayerItemAnimationObserver")).iterator();
            while (it.hasNext()) {
                removeGrownAnimationObserver((ILayerItemAnimationObserver) it.next());
            }
        }
        TypeHelper typeHelper2 = this.mTypeHelper;
        if (typeHelper2 != null) {
            Iterator it2 = ((HashSet) typeHelper2.getBindSet("com.autonavi.gbl.map.layer.observer.ILayerClickObserver")).iterator();
            while (it2.hasNext()) {
                removeClickObserver((ILayerClickObserver) it2.next());
            }
        }
        TypeHelper typeHelper3 = this.mTypeHelper;
        if (typeHelper3 != null) {
            Iterator it3 = ((HashSet) typeHelper3.getBindSet("com.autonavi.gbl.map.layer.observer.ILayerFocusChangeObserver")).iterator();
            while (it3.hasNext()) {
                removeFocusChangeObserver((ILayerFocusChangeObserver) it3.next());
            }
        }
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.BaseLayer, com.autonavi.gbl.map.CollisionGroup
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.BaseLayer, com.autonavi.gbl.map.CollisionGroup
    public synchronized void delete() {
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mService != null) {
            if (this.mTypeHelper != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                TypeHelper.unbindAllTarget(ReflexTool.PN(this.mService.getClass()), this.mService);
            }
            this.mService = null;
        }
        unbind();
    }

    public static String getClassTypeName() {
        return RoutePathLayerImpl.getClassTypeName();
    }

    public void setBusinessType(int i) {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            routePathLayerImpl.$explicit_setBusinessType(i);
        }
    }

    @Override // com.autonavi.gbl.map.layer.BaseLayer
    public void setStyle(IPrepareLayerStyle iPrepareLayerStyle) {
        HashSet hashSet;
        TypeHelper typeHelper;
        try {
            Method method = RoutePathLayer.class.getMethod("setStyle", IPrepareLayerStyle.class);
            TypeHelper typeHelper2 = this.mTypeHelper;
            if (typeHelper2 != null) {
                hashSet = (HashSet) typeHelper2.getBindSet(method, 0);
            } else {
                hashSet = new HashSet();
            }
            hashSet.remove(iPrepareLayerStyle);
            IPrepareLayerStyleImpl iPrepareLayerStyleImpl = null;
            if (iPrepareLayerStyle != null && (typeHelper = this.mTypeHelper) != null) {
                iPrepareLayerStyleImpl = (IPrepareLayerStyleImpl) typeHelper.transfer(method, 0, iPrepareLayerStyle);
            }
            RoutePathLayerImpl routePathLayerImpl = this.mService;
            if (routePathLayerImpl != null) {
                routePathLayerImpl.$explicit_setStyle(iPrepareLayerStyleImpl);
                TypeHelper typeHelper3 = this.mTypeHelper;
                if (typeHelper3 != null) {
                    typeHelper3.unbindSet(method, 0, hashSet);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.map.layer.BaseLayer
    public void updateStyle() {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            routePathLayerImpl.$explicit_updateStyle();
        }
    }

    @Override // com.autonavi.gbl.map.layer.BaseLayer
    public void setVisible(boolean z) {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            routePathLayerImpl.$explicit_setVisible(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.BaseLayer
    public void saveVisible() {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            routePathLayerImpl.$explicit_saveVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.BaseLayer
    public void restoreVisible() {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            routePathLayerImpl.$explicit_restoreVisible();
        }
    }

    @Override // com.autonavi.gbl.map.layer.BaseLayer
    public void setClickable(boolean z) {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            routePathLayerImpl.$explicit_setClickable(z);
        }
    }

    @Override // com.autonavi.gbl.map.layer.BaseLayer
    public void setPriority(LayerPriority layerPriority) {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            routePathLayerImpl.$explicit_setPriority(layerPriority);
        }
    }

    @Override // com.autonavi.gbl.map.layer.BaseLayer
    public void setDisplayScale(LayerScale layerScale) {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            routePathLayerImpl.$explicit_setDisplayScale(layerScale);
        }
    }

    public void setPathID(long j) {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            routePathLayerImpl.$explicit_setPathID(j);
        }
    }

    public void setCar2DPosition(long j, float f) {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            routePathLayerImpl.$explicit_setCar2DPosition(j, f);
        }
    }

    public void setCar3DPosition(long j, float f) {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            routePathLayerImpl.$explicit_setCar3DPosition(j, f);
        }
    }

    public void addRouteName() {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            routePathLayerImpl.$explicit_addRouteName();
        }
    }

    public void removeRouteName() {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            routePathLayerImpl.$explicit_removeRouteName();
        }
    }

    public void setLineWidthScale(float f) {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            routePathLayerImpl.$explicit_setLineWidthScale(f);
        }
    }

    public void setRouteItemParam(RouteLayerParam routeLayerParam) {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            routePathLayerImpl.$explicit_setRouteItemParam(routeLayerParam);
        }
    }

    public void setRouteItemParams(ArrayList<RouteLayerParam> arrayList) {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            routePathLayerImpl.$explicit_setRouteItemParams(arrayList);
        }
    }

    public void setPassedColor(RouteLayerPassedColor routeLayerPassedColor) {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            routePathLayerImpl.$explicit_setPassedColor(routeLayerPassedColor);
        }
    }

    public void setRouteDrawParam(RouteLayerDrawParam routeLayerDrawParam) {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            routePathLayerImpl.$explicit_setRouteDrawParam(routeLayerDrawParam);
        }
    }

    public void addRouteItem(@RouteLayerScene.RouteLayerScene1 int i, int i2, byte[] bArr, short s) {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            routePathLayerImpl.$explicit_addRouteItem(i, i2, bArr, s);
        }
    }

    public void removeRouteItem() {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            routePathLayerImpl.$explicit_removeRouteItem();
        }
    }

    public void setHighlightType(@MapRouteHighLightType.MapRouteHighLightType1 int i) {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            routePathLayerImpl.$explicit_setHighlightType(i);
        }
    }

    public void setSelectStatus(boolean z) {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            routePathLayerImpl.$explicit_setSelectStatus(z);
        }
    }

    public void setShowNaviRouteNameCountMap(HashMap<Integer, Integer> hashMap) {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            routePathLayerImpl.$explicit_setShowNaviRouteNameCountMap(hashMap);
        }
    }

    public boolean setDrawType(@MapRoutePolylineDrawType.MapRoutePolylineDrawType1 int i) {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            return routePathLayerImpl.$explicit_setDrawType(i);
        }
        return false;
    }

    public boolean setGrownAnimation(int i, long j) {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            return routePathLayerImpl.$explicit_setGrownAnimation(i, j);
        }
        return false;
    }

    public boolean setGrownAnimation(int i) {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            return routePathLayerImpl.$explicit_setGrownAnimation(i);
        }
        return false;
    }

    public boolean setGrownAnimation(boolean z, int i, long j) {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            return routePathLayerImpl.$explicit_setGrownAnimation(z, i, j);
        }
        return false;
    }

    public boolean setGrownAnimation(boolean z, int i) {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            return routePathLayerImpl.$explicit_setGrownAnimation(z, i);
        }
        return false;
    }

    public boolean addGrownAnimationObserver(ILayerItemAnimationObserver iLayerItemAnimationObserver) {
        TypeHelper typeHelper;
        try {
            Method method = RoutePathLayer.class.getMethod("addGrownAnimationObserver", ILayerItemAnimationObserver.class);
            ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl = null;
            if (iLayerItemAnimationObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iLayerItemAnimationObserverImpl = (ILayerItemAnimationObserverImpl) typeHelper.transfer(method, 0, iLayerItemAnimationObserver);
            }
            RoutePathLayerImpl routePathLayerImpl = this.mService;
            if (routePathLayerImpl != null) {
                return routePathLayerImpl.$explicit_addGrownAnimationObserver(iLayerItemAnimationObserverImpl);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeGrownAnimationObserver(ILayerItemAnimationObserver iLayerItemAnimationObserver) {
        TypeHelper typeHelper;
        try {
            Method method = RoutePathLayer.class.getMethod("removeGrownAnimationObserver", ILayerItemAnimationObserver.class);
            ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl = null;
            if (iLayerItemAnimationObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iLayerItemAnimationObserverImpl = (ILayerItemAnimationObserverImpl) typeHelper.transfer(method, 0, iLayerItemAnimationObserver);
            }
            RoutePathLayerImpl routePathLayerImpl = this.mService;
            if (routePathLayerImpl != null) {
                boolean $explicit_removeGrownAnimationObserver = routePathLayerImpl.$explicit_removeGrownAnimationObserver(iLayerItemAnimationObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iLayerItemAnimationObserver);
                }
                return $explicit_removeGrownAnimationObserver;
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.autonavi.gbl.map.layer.BaseLayer
    public void addClickObserver(ILayerClickObserver iLayerClickObserver) {
        TypeHelper typeHelper;
        try {
            Method method = RoutePathLayer.class.getMethod("addClickObserver", ILayerClickObserver.class);
            ILayerClickObserverImpl iLayerClickObserverImpl = null;
            if (iLayerClickObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iLayerClickObserverImpl = (ILayerClickObserverImpl) typeHelper.transfer(method, 0, iLayerClickObserver);
            }
            RoutePathLayerImpl routePathLayerImpl = this.mService;
            if (routePathLayerImpl != null) {
                routePathLayerImpl.$explicit_addClickObserver(iLayerClickObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.map.layer.BaseLayer
    public void removeClickObserver(ILayerClickObserver iLayerClickObserver) {
        TypeHelper typeHelper;
        try {
            Method method = RoutePathLayer.class.getMethod("removeClickObserver", ILayerClickObserver.class);
            ILayerClickObserverImpl iLayerClickObserverImpl = null;
            if (iLayerClickObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iLayerClickObserverImpl = (ILayerClickObserverImpl) typeHelper.transfer(method, 0, iLayerClickObserver);
            }
            RoutePathLayerImpl routePathLayerImpl = this.mService;
            if (routePathLayerImpl != null) {
                routePathLayerImpl.$explicit_removeClickObserver(iLayerClickObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iLayerClickObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.map.layer.BaseLayer
    public void addFocusChangeObserver(ILayerFocusChangeObserver iLayerFocusChangeObserver) {
        TypeHelper typeHelper;
        try {
            Method method = RoutePathLayer.class.getMethod("addFocusChangeObserver", ILayerFocusChangeObserver.class);
            ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl = null;
            if (iLayerFocusChangeObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iLayerFocusChangeObserverImpl = (ILayerFocusChangeObserverImpl) typeHelper.transfer(method, 0, iLayerFocusChangeObserver);
            }
            RoutePathLayerImpl routePathLayerImpl = this.mService;
            if (routePathLayerImpl != null) {
                routePathLayerImpl.$explicit_addFocusChangeObserver(iLayerFocusChangeObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.map.layer.BaseLayer
    public void removeFocusChangeObserver(ILayerFocusChangeObserver iLayerFocusChangeObserver) {
        TypeHelper typeHelper;
        try {
            Method method = RoutePathLayer.class.getMethod("removeFocusChangeObserver", ILayerFocusChangeObserver.class);
            ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl = null;
            if (iLayerFocusChangeObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iLayerFocusChangeObserverImpl = (ILayerFocusChangeObserverImpl) typeHelper.transfer(method, 0, iLayerFocusChangeObserver);
            }
            RoutePathLayerImpl routePathLayerImpl = this.mService;
            if (routePathLayerImpl != null) {
                routePathLayerImpl.$explicit_removeFocusChangeObserver(iLayerFocusChangeObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iLayerFocusChangeObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void setFilterZoomLevel(float f, float f2) {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            routePathLayerImpl.$explicit_setFilterZoomLevel(f, f2);
        }
    }

    public void addOddItem(ArrayList<LineLayerItem> arrayList) {
        TypeHelper typeHelper;
        try {
            Method method = RoutePathLayer.class.getMethod("addOddItem", ArrayList.class);
            ArrayList<LineLayerItemImpl> arrayList2 = null;
            if (arrayList != null && (typeHelper = this.mTypeHelper) != null) {
                arrayList2 = (ArrayList) typeHelper.transfer(method, 0, (ArrayList) arrayList);
            }
            RoutePathLayerImpl routePathLayerImpl = this.mService;
            if (routePathLayerImpl != null) {
                routePathLayerImpl.$explicit_addOddItem(arrayList2);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void updateOddLineGrey(long j, long j2, float f) {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            routePathLayerImpl.$explicit_updateOddLineGrey(j, j2, f);
        }
    }

    public void setOddAnimation(boolean z, AnimationStyleParam animationStyleParam) {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            routePathLayerImpl.$explicit_setOddAnimation(z, animationStyleParam);
        }
    }

    public void setOddVisible(boolean z) {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            routePathLayerImpl.$explicit_setOddVisible(z);
        }
    }

    public void setOddDisplayScale(LayerScale layerScale) {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            routePathLayerImpl.$explicit_setOddDisplayScale(layerScale);
        }
    }

    public void setParkFloor(int i) {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            routePathLayerImpl.$explicit_setParkFloor(i);
        }
    }

    @Override // com.autonavi.gbl.map.layer.BaseLayer, com.autonavi.gbl.map.layer.observer.IBaseLayer
    public boolean getVisible() {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            return routePathLayerImpl.$explicit_getVisible();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.BaseLayer, com.autonavi.gbl.map.layer.observer.IBaseLayer
    public boolean getClickable() {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            return routePathLayerImpl.$explicit_getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.BaseLayer, com.autonavi.gbl.map.CollisionGroup, com.autonavi.gbl.map.observer.ICollisionGroup
    public LayerPriority getPriority() {
        LayerPriority layerPriority = new LayerPriority();
        getPriority(layerPriority);
        return layerPriority;
    }

    private void getPriority(LayerPriority layerPriority) {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            routePathLayerImpl.$explicit_getPriority(layerPriority);
        }
    }

    @Override // com.autonavi.gbl.map.layer.BaseLayer, com.autonavi.gbl.map.layer.observer.IBaseLayer
    public LayerScale getDisplayScale() {
        LayerScale layerScale = new LayerScale();
        getDisplayScale(layerScale);
        return layerScale;
    }

    private void getDisplayScale(LayerScale layerScale) {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            routePathLayerImpl.$explicit_getDisplayScale(layerScale);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.IRoutePathLayer
    public long getPathID() {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            return routePathLayerImpl.$explicit_getPathID();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IRoutePathLayer
    public RouteLayerDrawParam getRouteDrawParam() {
        RouteLayerDrawParam routeLayerDrawParam = new RouteLayerDrawParam();
        getRouteDrawParam(routeLayerDrawParam);
        return routeLayerDrawParam;
    }

    private void getRouteDrawParam(RouteLayerDrawParam routeLayerDrawParam) {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            routePathLayerImpl.$explicit_getRouteDrawParam(routeLayerDrawParam);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.IRoutePathLayer
    public boolean isPathIntersectRect(RectDouble rectDouble) {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            return routePathLayerImpl.$explicit_isPathIntersectRect(rectDouble);
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IRoutePathLayer
    public boolean getSelectStatus() {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            return routePathLayerImpl.$explicit_getSelectStatus();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IRoutePathLayer
    public boolean getOddVisible() {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            return routePathLayerImpl.$explicit_getOddVisible();
        }
        return false;
    }
}
