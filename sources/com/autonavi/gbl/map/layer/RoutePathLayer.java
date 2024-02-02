package com.autonavi.gbl.map.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.impl.MapViewImpl;
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
/* loaded from: classes.dex */
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
        this(new RoutePathLayerRouter("RoutePathLayer", null, str, str2, (MapViewImpl) new TypeHelper(PACKAGE).transfer("com.autonavi.gbl.map.MapView", mapView)));
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

    @Override // com.autonavi.gbl.map.layer.BaseLayer, com.autonavi.gbl.map.CollisionGroup
    public RoutePathLayerImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.BaseLayer, com.autonavi.gbl.map.CollisionGroup
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.RoutePathLayer.1
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
    @Override // com.autonavi.gbl.map.layer.BaseLayer, com.autonavi.gbl.map.CollisionGroup
    public void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.RoutePathLayer.2
        }));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.map.layer.observer.ILayerClickObserver")).iterator();
            while (it.hasNext()) {
                removeClickObserver((ILayerClickObserver) it.next());
            }
        }
        TypeHelper typeHelper2 = this.mTypeHelper;
        if (typeHelper2 != null) {
            Iterator it2 = ((HashSet) typeHelper2.getBindSet("com.autonavi.gbl.map.layer.observer.ILayerFocusChangeObserver")).iterator();
            while (it2.hasNext()) {
                removeFocusChangeObserver((ILayerFocusChangeObserver) it2.next());
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
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.RoutePathLayer.3
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
        try {
            Method method = RoutePathLayer.class.getMethod("setStyle", IPrepareLayerStyle.class);
            TypeHelper typeHelper = this.mTypeHelper;
            if (typeHelper != null) {
                hashSet = (HashSet) typeHelper.getBindSet(method, 0);
            } else {
                hashSet = new HashSet();
            }
            hashSet.remove(iPrepareLayerStyle);
            if (iPrepareLayerStyle != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r3 = typeHelper2 != null ? (IPrepareLayerStyleImpl) typeHelper2.transfer(method, 0, iPrepareLayerStyle) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pStyle == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.RoutePathLayer.4
                    }));
                }
            }
            RoutePathLayerImpl routePathLayerImpl = this.mService;
            if (routePathLayerImpl != null) {
                routePathLayerImpl.$explicit_setStyle(r3);
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
        try {
            Method method = RoutePathLayer.class.getMethod("addGrownAnimationObserver", ILayerItemAnimationObserver.class);
            if (iLayerItemAnimationObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (ILayerItemAnimationObserverImpl) typeHelper.transfer(method, 0, iLayerItemAnimationObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.RoutePathLayer.5
                    }));
                }
            }
            RoutePathLayerImpl routePathLayerImpl = this.mService;
            if (routePathLayerImpl != null) {
                return routePathLayerImpl.$explicit_addGrownAnimationObserver(r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeGrownAnimationObserver(ILayerItemAnimationObserver iLayerItemAnimationObserver) {
        try {
            Method method = RoutePathLayer.class.getMethod("removeGrownAnimationObserver", ILayerItemAnimationObserver.class);
            if (iLayerItemAnimationObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (ILayerItemAnimationObserverImpl) typeHelper.transfer(method, 0, iLayerItemAnimationObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.RoutePathLayer.6
                    }));
                }
            }
            RoutePathLayerImpl routePathLayerImpl = this.mService;
            if (routePathLayerImpl != null) {
                return routePathLayerImpl.$explicit_removeGrownAnimationObserver(r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.autonavi.gbl.map.layer.BaseLayer
    public void addClickObserver(ILayerClickObserver iLayerClickObserver) {
        try {
            Method method = RoutePathLayer.class.getMethod("addClickObserver", ILayerClickObserver.class);
            if (iLayerClickObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (ILayerClickObserverImpl) typeHelper.transfer(method, 0, iLayerClickObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.RoutePathLayer.7
                    }));
                }
            }
            RoutePathLayerImpl routePathLayerImpl = this.mService;
            if (routePathLayerImpl != null) {
                routePathLayerImpl.$explicit_addClickObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.map.layer.BaseLayer
    public void removeClickObserver(ILayerClickObserver iLayerClickObserver) {
        try {
            Method method = RoutePathLayer.class.getMethod("removeClickObserver", ILayerClickObserver.class);
            if (iLayerClickObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (ILayerClickObserverImpl) typeHelper.transfer(method, 0, iLayerClickObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.RoutePathLayer.8
                    }));
                }
            }
            RoutePathLayerImpl routePathLayerImpl = this.mService;
            if (routePathLayerImpl != null) {
                routePathLayerImpl.$explicit_removeClickObserver(r1);
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
        try {
            Method method = RoutePathLayer.class.getMethod("addFocusChangeObserver", ILayerFocusChangeObserver.class);
            if (iLayerFocusChangeObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (ILayerFocusChangeObserverImpl) typeHelper.transfer(method, 0, iLayerFocusChangeObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.RoutePathLayer.9
                    }));
                }
            }
            RoutePathLayerImpl routePathLayerImpl = this.mService;
            if (routePathLayerImpl != null) {
                routePathLayerImpl.$explicit_addFocusChangeObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.map.layer.BaseLayer
    public void removeFocusChangeObserver(ILayerFocusChangeObserver iLayerFocusChangeObserver) {
        try {
            Method method = RoutePathLayer.class.getMethod("removeFocusChangeObserver", ILayerFocusChangeObserver.class);
            if (iLayerFocusChangeObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (ILayerFocusChangeObserverImpl) typeHelper.transfer(method, 0, iLayerFocusChangeObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.RoutePathLayer.10
                    }));
                }
            }
            RoutePathLayerImpl routePathLayerImpl = this.mService;
            if (routePathLayerImpl != null) {
                routePathLayerImpl.$explicit_removeFocusChangeObserver(r1);
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
        try {
            Method method = RoutePathLayer.class.getMethod("addOddItem", ArrayList.class);
            if (arrayList != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (ArrayList) typeHelper.transfer(method, 0, (ArrayList) arrayList) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $lineItems == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.RoutePathLayer.11
                    }));
                }
            }
            RoutePathLayerImpl routePathLayerImpl = this.mService;
            if (routePathLayerImpl != null) {
                routePathLayerImpl.$explicit_addOddItem(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
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
    public boolean getClickable() {
        RoutePathLayerImpl routePathLayerImpl = this.mService;
        if (routePathLayerImpl != null) {
            return routePathLayerImpl.$explicit_getClickable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.BaseLayer, com.autonavi.gbl.map.layer.observer.IBaseLayer
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
}
