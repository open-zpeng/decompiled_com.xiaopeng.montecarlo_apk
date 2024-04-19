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
import com.autonavi.gbl.map.layer.impl.RouteLayerItemImpl;
import com.autonavi.gbl.map.layer.model.AnimationStyleParam;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.MapRouteHighLightType;
import com.autonavi.gbl.map.layer.model.MapRoutePolylineDrawType;
import com.autonavi.gbl.map.layer.model.RouteLayerDrawParam;
import com.autonavi.gbl.map.layer.model.RouteLayerParam;
import com.autonavi.gbl.map.layer.model.RouteLayerPassedColor;
import com.autonavi.gbl.map.layer.model.RouteLayerScene;
import com.autonavi.gbl.map.layer.observer.ILayerItemAnimationObserver;
import com.autonavi.gbl.map.layer.observer.IRouteLayerItem;
import com.autonavi.gbl.map.layer.observer.impl.ILayerItemAnimationObserverImpl;
import com.autonavi.gbl.map.router.RouteLayerItemRouter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
@IntfAuto(target = RouteLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class RouteLayerItem extends LayerItem implements IRouteLayerItem {
    private static String PACKAGE = ReflexTool.PN(RouteLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private RouteLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected RouteLayerItem(long j, boolean z) {
        this(new RouteLayerItemRouter("RouteLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRouteLayerItem.class}, new Object[]{this});
    }

    public RouteLayerItem(MapView mapView) {
        this(new RouteLayerItemRouter("RouteLayerItem", null, (MapViewImpl) new TypeHelper(PACKAGE).transfer("com.autonavi.gbl.map.MapView", mapView)));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRouteLayerItem.class}, new Object[]{this});
    }

    public RouteLayerItem(RouteLayerItemImpl routeLayerItemImpl) {
        super(routeLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(routeLayerItemImpl);
    }

    private void $constructor(RouteLayerItemImpl routeLayerItemImpl) {
        if (routeLayerItemImpl != null) {
            this.mService = routeLayerItemImpl;
            this.mTargetId = String.format("RouteLayerItem_%s_%d", String.valueOf(RouteLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public RouteLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.RouteLayerItem.1
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
    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.RouteLayerItem.2
        }));
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public synchronized void delete() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.RouteLayerItem.3
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
        return RouteLayerItemImpl.getClassTypeName();
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void updateStyle() {
        RouteLayerItemImpl routeLayerItemImpl = this.mService;
        if (routeLayerItemImpl != null) {
            routeLayerItemImpl.$explicit_updateStyle();
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void setDisplayScale(LayerScale layerScale) {
        RouteLayerItemImpl routeLayerItemImpl = this.mService;
        if (routeLayerItemImpl != null) {
            routeLayerItemImpl.$explicit_setDisplayScale(layerScale);
        }
    }

    public void setCar2DPosition(long j, float f) {
        RouteLayerItemImpl routeLayerItemImpl = this.mService;
        if (routeLayerItemImpl != null) {
            routeLayerItemImpl.$explicit_setCar2DPosition(j, f);
        }
    }

    public void setCar3DPosition(long j, float f) {
        RouteLayerItemImpl routeLayerItemImpl = this.mService;
        if (routeLayerItemImpl != null) {
            routeLayerItemImpl.$explicit_setCar3DPosition(j, f);
        }
    }

    public void addRouteName() {
        RouteLayerItemImpl routeLayerItemImpl = this.mService;
        if (routeLayerItemImpl != null) {
            routeLayerItemImpl.$explicit_addRouteName();
        }
    }

    public void removeRouteName() {
        RouteLayerItemImpl routeLayerItemImpl = this.mService;
        if (routeLayerItemImpl != null) {
            routeLayerItemImpl.$explicit_removeRouteName();
        }
    }

    public void setLineWidthScale(float f) {
        RouteLayerItemImpl routeLayerItemImpl = this.mService;
        if (routeLayerItemImpl != null) {
            routeLayerItemImpl.$explicit_setLineWidthScale(f);
        }
    }

    public void setRouteItemParam(RouteLayerParam routeLayerParam) {
        RouteLayerItemImpl routeLayerItemImpl = this.mService;
        if (routeLayerItemImpl != null) {
            routeLayerItemImpl.$explicit_setRouteItemParam(routeLayerParam);
        }
    }

    public void setRouteItemParams(ArrayList<RouteLayerParam> arrayList) {
        RouteLayerItemImpl routeLayerItemImpl = this.mService;
        if (routeLayerItemImpl != null) {
            routeLayerItemImpl.$explicit_setRouteItemParams(arrayList);
        }
    }

    public void setPassedColor(RouteLayerPassedColor routeLayerPassedColor) {
        RouteLayerItemImpl routeLayerItemImpl = this.mService;
        if (routeLayerItemImpl != null) {
            routeLayerItemImpl.$explicit_setPassedColor(routeLayerPassedColor);
        }
    }

    public void setRouteDrawParam(RouteLayerDrawParam routeLayerDrawParam) {
        RouteLayerItemImpl routeLayerItemImpl = this.mService;
        if (routeLayerItemImpl != null) {
            routeLayerItemImpl.$explicit_setRouteDrawParam(routeLayerDrawParam);
        }
    }

    public void addRouteItem(@RouteLayerScene.RouteLayerScene1 int i, int i2, byte[] bArr, short s) {
        RouteLayerItemImpl routeLayerItemImpl = this.mService;
        if (routeLayerItemImpl != null) {
            routeLayerItemImpl.$explicit_addRouteItem(i, i2, bArr, s);
        }
    }

    public void removeRouteItem() {
        RouteLayerItemImpl routeLayerItemImpl = this.mService;
        if (routeLayerItemImpl != null) {
            routeLayerItemImpl.$explicit_removeRouteItem();
        }
    }

    public void setHighlightType(@MapRouteHighLightType.MapRouteHighLightType1 int i) {
        RouteLayerItemImpl routeLayerItemImpl = this.mService;
        if (routeLayerItemImpl != null) {
            routeLayerItemImpl.$explicit_setHighlightType(i);
        }
    }

    public void setSelectStatus(boolean z) {
        RouteLayerItemImpl routeLayerItemImpl = this.mService;
        if (routeLayerItemImpl != null) {
            routeLayerItemImpl.$explicit_setSelectStatus(z);
        }
    }

    public void setShowNaviRouteNameCountMap(HashMap<Integer, Integer> hashMap) {
        RouteLayerItemImpl routeLayerItemImpl = this.mService;
        if (routeLayerItemImpl != null) {
            routeLayerItemImpl.$explicit_setShowNaviRouteNameCountMap(hashMap);
        }
    }

    public boolean setDrawType(@MapRoutePolylineDrawType.MapRoutePolylineDrawType1 int i) {
        RouteLayerItemImpl routeLayerItemImpl = this.mService;
        if (routeLayerItemImpl != null) {
            return routeLayerItemImpl.$explicit_setDrawType(i);
        }
        return false;
    }

    public boolean setGrownAnimation(int i, long j) {
        RouteLayerItemImpl routeLayerItemImpl = this.mService;
        if (routeLayerItemImpl != null) {
            return routeLayerItemImpl.$explicit_setGrownAnimation(i, j);
        }
        return false;
    }

    public boolean setGrownAnimation(int i) {
        RouteLayerItemImpl routeLayerItemImpl = this.mService;
        if (routeLayerItemImpl != null) {
            return routeLayerItemImpl.$explicit_setGrownAnimation(i);
        }
        return false;
    }

    public boolean setGrownAnimation(boolean z, int i, long j) {
        RouteLayerItemImpl routeLayerItemImpl = this.mService;
        if (routeLayerItemImpl != null) {
            return routeLayerItemImpl.$explicit_setGrownAnimation(z, i, j);
        }
        return false;
    }

    public boolean setGrownAnimation(boolean z, int i) {
        RouteLayerItemImpl routeLayerItemImpl = this.mService;
        if (routeLayerItemImpl != null) {
            return routeLayerItemImpl.$explicit_setGrownAnimation(z, i);
        }
        return false;
    }

    public boolean addGrownAnimationObserver(ILayerItemAnimationObserver iLayerItemAnimationObserver) {
        try {
            Method method = RouteLayerItem.class.getMethod("addGrownAnimationObserver", ILayerItemAnimationObserver.class);
            if (iLayerItemAnimationObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (ILayerItemAnimationObserverImpl) typeHelper.transfer(method, 0, iLayerItemAnimationObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.RouteLayerItem.4
                    }));
                }
            }
            RouteLayerItemImpl routeLayerItemImpl = this.mService;
            if (routeLayerItemImpl != null) {
                return routeLayerItemImpl.$explicit_addGrownAnimationObserver(r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeGrownAnimationObserver(ILayerItemAnimationObserver iLayerItemAnimationObserver) {
        try {
            Method method = RouteLayerItem.class.getMethod("removeGrownAnimationObserver", ILayerItemAnimationObserver.class);
            if (iLayerItemAnimationObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (ILayerItemAnimationObserverImpl) typeHelper.transfer(method, 0, iLayerItemAnimationObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.RouteLayerItem.5
                    }));
                }
            }
            RouteLayerItemImpl routeLayerItemImpl = this.mService;
            if (routeLayerItemImpl != null) {
                return routeLayerItemImpl.$explicit_removeGrownAnimationObserver(r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public void setFilterZoomLevel(float f, float f2) {
        RouteLayerItemImpl routeLayerItemImpl = this.mService;
        if (routeLayerItemImpl != null) {
            routeLayerItemImpl.$explicit_setFilterZoomLevel(f, f2);
        }
    }

    public void addOddItem(ArrayList<LineLayerItem> arrayList) {
        try {
            Method method = RouteLayerItem.class.getMethod("addOddItem", ArrayList.class);
            if (arrayList != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (ArrayList) typeHelper.transfer(method, 0, (ArrayList) arrayList) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $lineItems == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.RouteLayerItem.6
                    }));
                }
            }
            RouteLayerItemImpl routeLayerItemImpl = this.mService;
            if (routeLayerItemImpl != null) {
                routeLayerItemImpl.$explicit_addOddItem(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void setOddAnimation(boolean z, AnimationStyleParam animationStyleParam) {
        RouteLayerItemImpl routeLayerItemImpl = this.mService;
        if (routeLayerItemImpl != null) {
            routeLayerItemImpl.$explicit_setOddAnimation(z, animationStyleParam);
        }
    }

    public void setParkFloor(int i) {
        RouteLayerItemImpl routeLayerItemImpl = this.mService;
        if (routeLayerItemImpl != null) {
            routeLayerItemImpl.$explicit_setParkFloor(i);
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem, com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.layer.observer.IArrowLayerItem
    @LayerItemType.LayerItemType1
    public int getItemType() {
        RouteLayerItemImpl routeLayerItemImpl = this.mService;
        if (routeLayerItemImpl != null) {
            return routeLayerItemImpl.$explicit_getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem, com.autonavi.gbl.map.layer.observer.ILayerItem
    public LayerScale getDisplayScale() {
        LayerScale layerScale = new LayerScale();
        getDisplayScale(layerScale);
        return layerScale;
    }

    private void getDisplayScale(LayerScale layerScale) {
        RouteLayerItemImpl routeLayerItemImpl = this.mService;
        if (routeLayerItemImpl != null) {
            routeLayerItemImpl.$explicit_getDisplayScale(layerScale);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.IRouteLayerItem
    public RouteLayerDrawParam getRouteDrawParam() {
        RouteLayerDrawParam routeLayerDrawParam = new RouteLayerDrawParam();
        getRouteDrawParam(routeLayerDrawParam);
        return routeLayerDrawParam;
    }

    private void getRouteDrawParam(RouteLayerDrawParam routeLayerDrawParam) {
        RouteLayerItemImpl routeLayerItemImpl = this.mService;
        if (routeLayerItemImpl != null) {
            routeLayerItemImpl.$explicit_getRouteDrawParam(routeLayerDrawParam);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.IRouteLayerItem
    public boolean isPathIntersectRect(RectDouble rectDouble) {
        RouteLayerItemImpl routeLayerItemImpl = this.mService;
        if (routeLayerItemImpl != null) {
            return routeLayerItemImpl.$explicit_isPathIntersectRect(rectDouble);
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.layer.observer.IRouteLayerItem
    public boolean getSelectStatus() {
        RouteLayerItemImpl routeLayerItemImpl = this.mService;
        if (routeLayerItemImpl != null) {
            return routeLayerItemImpl.$explicit_getSelectStatus();
        }
        return false;
    }
}
