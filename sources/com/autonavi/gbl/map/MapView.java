package com.autonavi.gbl.map;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.common.model.RectInt;
import com.autonavi.gbl.map.impl.MapViewImpl;
import com.autonavi.gbl.map.impl.OperatorAnimationImpl;
import com.autonavi.gbl.map.impl.OperatorBusinessImpl;
import com.autonavi.gbl.map.impl.OperatorCollisionImpl;
import com.autonavi.gbl.map.impl.OperatorGestureImpl;
import com.autonavi.gbl.map.impl.OperatorPostureImpl;
import com.autonavi.gbl.map.impl.OperatorScaleImpl;
import com.autonavi.gbl.map.impl.OperatorStyleImpl;
import com.autonavi.gbl.map.impl.OperatorWeatherImpl;
import com.autonavi.gbl.map.layer.LayerMgr;
import com.autonavi.gbl.map.layer.impl.LayerMgrImpl;
import com.autonavi.gbl.map.layer.model.Layer3DModel;
import com.autonavi.gbl.map.layer.model.LayerTexture;
import com.autonavi.gbl.map.model.EGLDeviceID;
import com.autonavi.gbl.map.model.MapControllerStatesType;
import com.autonavi.gbl.map.model.MapEngineID;
import com.autonavi.gbl.map.model.MapLeftTop;
import com.autonavi.gbl.map.model.MapMessageType;
import com.autonavi.gbl.map.model.MapPositionParam;
import com.autonavi.gbl.map.model.MapViewPortParam;
import com.autonavi.gbl.map.model.MapViewStateType;
import com.autonavi.gbl.map.model.MapviewMode;
import com.autonavi.gbl.map.model.MapviewModeParam;
import com.autonavi.gbl.map.model.NaviMessageParam;
import com.autonavi.gbl.map.model.PointF;
import com.autonavi.gbl.map.model.PreviewParam;
import com.autonavi.gbl.map.model.ScreenShotInfo;
import com.autonavi.gbl.map.model.TestMapPara;
import com.autonavi.gbl.map.observer.IBLMapBusinessDataObserver;
import com.autonavi.gbl.map.observer.IBLMapEngineObserver;
import com.autonavi.gbl.map.observer.IBLMapViewProxy;
import com.autonavi.gbl.map.observer.IMapEventObserver;
import com.autonavi.gbl.map.observer.IMapFpsObserver;
import com.autonavi.gbl.map.observer.IMapGestureObserver;
import com.autonavi.gbl.map.observer.IMapRunnable;
import com.autonavi.gbl.map.observer.IMapviewObserver;
import com.autonavi.gbl.map.observer.IReculateOverlay;
import com.autonavi.gbl.map.observer.ITextTextureObserver;
import com.autonavi.gbl.map.observer.impl.IBLMapBusinessDataObserverImpl;
import com.autonavi.gbl.map.observer.impl.IBLMapEngineObserverImpl;
import com.autonavi.gbl.map.observer.impl.IBLMapViewProxyImpl;
import com.autonavi.gbl.map.observer.impl.IMapEventObserverImpl;
import com.autonavi.gbl.map.observer.impl.IMapFpsObserverImpl;
import com.autonavi.gbl.map.observer.impl.IMapGestureObserverImpl;
import com.autonavi.gbl.map.observer.impl.IMapRunnableImpl;
import com.autonavi.gbl.map.observer.impl.IMapviewObserverImpl;
import com.autonavi.gbl.map.observer.impl.IReculateOverlayImpl;
import com.autonavi.gbl.map.observer.impl.ITextTextureObserverImpl;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
@IntfAuto(target = MapViewImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class MapView {
    private static String PACKAGE = ReflexTool.PN(MapView.class);
    private MapViewImpl mControl;
    private boolean mHasDestroy;
    private Set mMemberSet;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected MapView(long j, boolean z) {
        this(new MapViewImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(MapView.class, this, this.mControl);
        }
    }

    public MapView(MapViewImpl mapViewImpl) {
        this.mMemberSet = Collections.synchronizedSet(new HashSet());
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(mapViewImpl);
    }

    private void $constructor(MapViewImpl mapViewImpl) {
        if (mapViewImpl != null) {
            this.mControl = mapViewImpl;
            this.mTargetId = String.format("MapView_%s_%d", String.valueOf(MapViewImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected MapViewImpl getControl() {
        return this.mControl;
    }

    public void queueEvent(final IMapRunnable iMapRunnable) {
        IMapRunnable iMapRunnable2 = new IMapRunnable() { // from class: com.autonavi.gbl.map.MapView.1
            @Override // com.autonavi.gbl.map.observer.IMapRunnable
            public void run() {
                IMapRunnable iMapRunnable3 = iMapRunnable;
                if (iMapRunnable3 != null) {
                    iMapRunnable3.run();
                }
            }
        };
        try {
            Method method = MapView.class.getMethod("queueEvent", IMapRunnable.class);
            TypeHelper typeHelper = this.mTypeHelper;
            IMapRunnableImpl iMapRunnableImpl = typeHelper != null ? (IMapRunnableImpl) typeHelper.transfer(method, 0, iMapRunnable2) : null;
            if (iMapRunnableImpl == null) {
                DebugTool.e("%s: $runnable == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapView.2
                }));
            }
            MapViewImpl mapViewImpl = this.mControl;
            if (mapViewImpl != null) {
                mapViewImpl.queueEvent(iMapRunnableImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public OperatorStyle getOperatorStyle() {
        Set set;
        try {
            Method method = MapView.class.getMethod("getOperatorStyle", new Class[0]);
            MapViewImpl mapViewImpl = this.mControl;
            if (mapViewImpl != null) {
                OperatorStyleImpl operatorStyle = mapViewImpl.getOperatorStyle();
                if (operatorStyle != null) {
                    TypeHelper typeHelper = this.mTypeHelper;
                    r0 = typeHelper != null ? (OperatorStyle) typeHelper.transfer(method, -1, (Object) operatorStyle, true) : null;
                    if (r0 == null) {
                        DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapView.3
                        }));
                    }
                }
                if (r0 != null && (set = this.mMemberSet) != null) {
                    synchronized (set) {
                        this.mMemberSet.add(r0);
                    }
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public LayerMgr getLayerMgr() {
        Set set;
        try {
            Method method = MapView.class.getMethod("getLayerMgr", new Class[0]);
            MapViewImpl mapViewImpl = this.mControl;
            if (mapViewImpl != null) {
                LayerMgrImpl layerMgr = mapViewImpl.getLayerMgr();
                if (layerMgr != null) {
                    TypeHelper typeHelper = this.mTypeHelper;
                    r0 = typeHelper != null ? (LayerMgr) typeHelper.transfer(method, -1, (Object) layerMgr, true) : null;
                    if (r0 == null) {
                        DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapView.4
                        }));
                    }
                }
                if (r0 != null && (set = this.mMemberSet) != null) {
                    synchronized (set) {
                        this.mMemberSet.add(r0);
                    }
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public OperatorBusiness getOperatorBusiness() {
        Set set;
        try {
            Method method = MapView.class.getMethod("getOperatorBusiness", new Class[0]);
            MapViewImpl mapViewImpl = this.mControl;
            if (mapViewImpl != null) {
                OperatorBusinessImpl operatorBusiness = mapViewImpl.getOperatorBusiness();
                if (operatorBusiness != null) {
                    TypeHelper typeHelper = this.mTypeHelper;
                    r0 = typeHelper != null ? (OperatorBusiness) typeHelper.transfer(method, -1, (Object) operatorBusiness, true) : null;
                    if (r0 == null) {
                        DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapView.5
                        }));
                    }
                }
                if (r0 != null && (set = this.mMemberSet) != null) {
                    synchronized (set) {
                        this.mMemberSet.add(r0);
                    }
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public OperatorPosture getOperatorPosture() {
        Set set;
        try {
            Method method = MapView.class.getMethod("getOperatorPosture", new Class[0]);
            MapViewImpl mapViewImpl = this.mControl;
            if (mapViewImpl != null) {
                OperatorPostureImpl operatorPosture = mapViewImpl.getOperatorPosture();
                if (operatorPosture != null) {
                    TypeHelper typeHelper = this.mTypeHelper;
                    r0 = typeHelper != null ? (OperatorPosture) typeHelper.transfer(method, -1, (Object) operatorPosture, true) : null;
                    if (r0 == null) {
                        DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapView.6
                        }));
                    }
                }
                if (r0 != null && (set = this.mMemberSet) != null) {
                    synchronized (set) {
                        this.mMemberSet.add(r0);
                    }
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public OperatorGesture getOperatorGesture() {
        Set set;
        try {
            Method method = MapView.class.getMethod("getOperatorGesture", new Class[0]);
            MapViewImpl mapViewImpl = this.mControl;
            if (mapViewImpl != null) {
                OperatorGestureImpl operatorGesture = mapViewImpl.getOperatorGesture();
                if (operatorGesture != null) {
                    TypeHelper typeHelper = this.mTypeHelper;
                    r0 = typeHelper != null ? (OperatorGesture) typeHelper.transfer(method, -1, (Object) operatorGesture, true) : null;
                    if (r0 == null) {
                        DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapView.7
                        }));
                    }
                }
                if (r0 != null && (set = this.mMemberSet) != null) {
                    synchronized (set) {
                        this.mMemberSet.add(r0);
                    }
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public OperatorAnimation getOperatorAnimation() {
        Set set;
        try {
            Method method = MapView.class.getMethod("getOperatorAnimation", new Class[0]);
            MapViewImpl mapViewImpl = this.mControl;
            if (mapViewImpl != null) {
                OperatorAnimationImpl operatorAnimation = mapViewImpl.getOperatorAnimation();
                if (operatorAnimation != null) {
                    TypeHelper typeHelper = this.mTypeHelper;
                    r0 = typeHelper != null ? (OperatorAnimation) typeHelper.transfer(method, -1, (Object) operatorAnimation, true) : null;
                    if (r0 == null) {
                        DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapView.8
                        }));
                    }
                }
                if (r0 != null && (set = this.mMemberSet) != null) {
                    synchronized (set) {
                        this.mMemberSet.add(r0);
                    }
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public OperatorCollision getOperatorCollision() {
        Set set;
        try {
            Method method = MapView.class.getMethod("getOperatorCollision", new Class[0]);
            MapViewImpl mapViewImpl = this.mControl;
            if (mapViewImpl != null) {
                OperatorCollisionImpl operatorCollision = mapViewImpl.getOperatorCollision();
                if (operatorCollision != null) {
                    TypeHelper typeHelper = this.mTypeHelper;
                    r0 = typeHelper != null ? (OperatorCollision) typeHelper.transfer(method, -1, (Object) operatorCollision, true) : null;
                    if (r0 == null) {
                        DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapView.9
                        }));
                    }
                }
                if (r0 != null && (set = this.mMemberSet) != null) {
                    synchronized (set) {
                        this.mMemberSet.add(r0);
                    }
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public OperatorScale getOperatorScale() {
        Set set;
        try {
            Method method = MapView.class.getMethod("getOperatorScale", new Class[0]);
            MapViewImpl mapViewImpl = this.mControl;
            if (mapViewImpl != null) {
                OperatorScaleImpl operatorScale = mapViewImpl.getOperatorScale();
                if (operatorScale != null) {
                    TypeHelper typeHelper = this.mTypeHelper;
                    r0 = typeHelper != null ? (OperatorScale) typeHelper.transfer(method, -1, (Object) operatorScale, true) : null;
                    if (r0 == null) {
                        DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapView.10
                        }));
                    }
                }
                if (r0 != null && (set = this.mMemberSet) != null) {
                    synchronized (set) {
                        this.mMemberSet.add(r0);
                    }
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public OperatorWeather getOperatorWeather() {
        Set set;
        try {
            Method method = MapView.class.getMethod("getOperatorWeather", new Class[0]);
            MapViewImpl mapViewImpl = this.mControl;
            if (mapViewImpl != null) {
                OperatorWeatherImpl operatorWeather = mapViewImpl.getOperatorWeather();
                if (operatorWeather != null) {
                    TypeHelper typeHelper = this.mTypeHelper;
                    r0 = typeHelper != null ? (OperatorWeather) typeHelper.transfer(method, -1, (Object) operatorWeather, true) : null;
                    if (r0 == null) {
                        DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapView.11
                        }));
                    }
                }
                if (r0 != null && (set = this.mMemberSet) != null) {
                    synchronized (set) {
                        this.mMemberSet.add(r0);
                    }
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public boolean addLayer3DModel(Layer3DModel layer3DModel) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.addLayer3DModel(layer3DModel);
        }
        return false;
    }

    public boolean updateLayer3DModel(Layer3DModel layer3DModel) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.updateLayer3DModel(layer3DModel);
        }
        return false;
    }

    public boolean destroyLayer3DModel(int i) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.destroyLayer3DModel(i);
        }
        return false;
    }

    public RectDouble get3DModelBoundRect(int i) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.get3DModelBoundRect(i);
        }
        return null;
    }

    public boolean addLayerTexture(LayerTexture layerTexture) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.addLayerTexture(layerTexture);
        }
        return false;
    }

    public boolean updateTexture(LayerTexture layerTexture) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.updateTexture(layerTexture);
        }
        return false;
    }

    public boolean destroyTexture(int i) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.destroyTexture(i);
        }
        return false;
    }

    public LayerTexture getLayerTexture(int i) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.getLayerTexture(i);
        }
        return null;
    }

    public long getCapacityTextureCount() {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.getCapacityTextureCount();
        }
        return 0L;
    }

    public long getUsedTextureCount() {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.getUsedTextureCount();
        }
        return 0L;
    }

    public RectInt getBoundRect(int i, int i2, int i3, float f) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.getBoundRect(i, i2, i3, f);
        }
        return null;
    }

    public void addMapviewObserver(IMapviewObserver iMapviewObserver) {
        try {
            Method method = MapView.class.getMethod("addMapviewObserver", IMapviewObserver.class);
            if (iMapviewObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IMapviewObserverImpl) typeHelper.transfer(method, 0, iMapviewObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pIMapviewObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapView.12
                    }));
                }
            }
            MapViewImpl mapViewImpl = this.mControl;
            if (mapViewImpl != null) {
                mapViewImpl.addMapviewObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeMapviewObserver(IMapviewObserver iMapviewObserver) {
        try {
            Method method = MapView.class.getMethod("removeMapviewObserver", IMapviewObserver.class);
            if (iMapviewObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IMapviewObserverImpl) typeHelper.transfer(method, 0, iMapviewObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pIMapviewObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapView.13
                    }));
                }
            }
            MapViewImpl mapViewImpl = this.mControl;
            if (mapViewImpl != null) {
                mapViewImpl.removeMapviewObserver(r1);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iMapviewObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public boolean addMapEventObserver(IMapEventObserver iMapEventObserver) {
        try {
            Method method = MapView.class.getMethod("addMapEventObserver", IMapEventObserver.class);
            if (iMapEventObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IMapEventObserverImpl) typeHelper.transfer(method, 0, iMapEventObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapView.14
                    }));
                    return false;
                }
            }
            MapViewImpl mapViewImpl = this.mControl;
            if (mapViewImpl != null) {
                return mapViewImpl.addMapEventObserver(r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeMapEventObserver(IMapEventObserver iMapEventObserver) {
        try {
            Method method = MapView.class.getMethod("removeMapEventObserver", IMapEventObserver.class);
            if (iMapEventObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IMapEventObserverImpl) typeHelper.transfer(method, 0, iMapEventObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapView.15
                    }));
                    return false;
                }
            }
            MapViewImpl mapViewImpl = this.mControl;
            if (mapViewImpl != null) {
                boolean removeMapEventObserver = mapViewImpl.removeMapEventObserver(r2);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iMapEventObserver);
                }
                return removeMapEventObserver;
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public void addGestureObserver(IMapGestureObserver iMapGestureObserver) {
        try {
            Method method = MapView.class.getMethod("addGestureObserver", IMapGestureObserver.class);
            if (iMapGestureObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IMapGestureObserverImpl) typeHelper.transfer(method, 0, iMapGestureObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pIMapGestureObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapView.16
                    }));
                }
            }
            MapViewImpl mapViewImpl = this.mControl;
            if (mapViewImpl != null) {
                mapViewImpl.addGestureObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeGestureObserver(IMapGestureObserver iMapGestureObserver) {
        try {
            Method method = MapView.class.getMethod("removeGestureObserver", IMapGestureObserver.class);
            if (iMapGestureObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IMapGestureObserverImpl) typeHelper.transfer(method, 0, iMapGestureObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pIMapGestureObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapView.17
                    }));
                }
            }
            MapViewImpl mapViewImpl = this.mControl;
            if (mapViewImpl != null) {
                mapViewImpl.removeGestureObserver(r1);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iMapGestureObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void setMapEngineObserver(IBLMapEngineObserver iBLMapEngineObserver) {
        try {
            Method method = MapView.class.getMethod("setMapEngineObserver", IBLMapEngineObserver.class);
            if (iBLMapEngineObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IBLMapEngineObserverImpl) typeHelper.transfer(method, 0, iBLMapEngineObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pIMapEngineObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapView.18
                    }));
                }
            }
            MapViewImpl mapViewImpl = this.mControl;
            if (mapViewImpl != null) {
                mapViewImpl.setMapEngineObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeMapEngineObserver() {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            mapViewImpl.removeMapEngineObserver();
        }
    }

    public void addReculateOverlayObserver(IReculateOverlay iReculateOverlay) {
        try {
            Method method = MapView.class.getMethod("addReculateOverlayObserver", IReculateOverlay.class);
            if (iReculateOverlay != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IReculateOverlayImpl) typeHelper.transfer(method, 0, iReculateOverlay) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pIReculateOverlay == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapView.19
                    }));
                }
            }
            MapViewImpl mapViewImpl = this.mControl;
            if (mapViewImpl != null) {
                mapViewImpl.addReculateOverlayObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeReculateOverlayObserver(IReculateOverlay iReculateOverlay) {
        try {
            Method method = MapView.class.getMethod("removeReculateOverlayObserver", IReculateOverlay.class);
            if (iReculateOverlay != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IReculateOverlayImpl) typeHelper.transfer(method, 0, iReculateOverlay) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pIReculateOverlay == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapView.20
                    }));
                }
            }
            MapViewImpl mapViewImpl = this.mControl;
            if (mapViewImpl != null) {
                mapViewImpl.removeReculateOverlayObserver(r1);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iReculateOverlay);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void setTextTextureObserver(ITextTextureObserver iTextTextureObserver) {
        HashSet hashSet;
        try {
            Method method = MapView.class.getMethod("setTextTextureObserver", ITextTextureObserver.class);
            TypeHelper typeHelper = this.mTypeHelper;
            if (typeHelper != null) {
                hashSet = (HashSet) typeHelper.getBindSet(method, 0);
            } else {
                hashSet = new HashSet();
            }
            hashSet.remove(iTextTextureObserver);
            if (iTextTextureObserver != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r3 = typeHelper2 != null ? (ITextTextureObserverImpl) typeHelper2.transfer(method, 0, iTextTextureObserver) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $pITextTextureObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapView.21
                    }));
                }
            }
            MapViewImpl mapViewImpl = this.mControl;
            if (mapViewImpl != null) {
                mapViewImpl.setTextTextureObserver(r3);
                TypeHelper typeHelper3 = this.mTypeHelper;
                if (typeHelper3 != null) {
                    typeHelper3.unbindSet(method, 0, hashSet);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void setMapFpsObserver(IMapFpsObserver iMapFpsObserver) {
        try {
            Method method = MapView.class.getMethod("setMapFpsObserver", IMapFpsObserver.class);
            if (iMapFpsObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IMapFpsObserverImpl) typeHelper.transfer(method, 0, iMapFpsObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pIMapFpsObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapView.22
                    }));
                }
            }
            MapViewImpl mapViewImpl = this.mControl;
            if (mapViewImpl != null) {
                mapViewImpl.setMapFpsObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void setMapViewProxy(IBLMapViewProxy iBLMapViewProxy) {
        try {
            Method method = MapView.class.getMethod("setMapViewProxy", IBLMapViewProxy.class);
            if (iBLMapViewProxy != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IBLMapViewProxyImpl) typeHelper.transfer(method, 0, iBLMapViewProxy) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $mapviewProxy == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapView.23
                    }));
                }
            }
            MapViewImpl mapViewImpl = this.mControl;
            if (mapViewImpl != null) {
                mapViewImpl.setMapViewProxy(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public IBLMapViewProxy getMapViewProxy() {
        IBLMapViewProxyImpl mapViewProxy;
        try {
            Method method = MapView.class.getMethod("getMapViewProxy", new Class[0]);
            MapViewImpl mapViewImpl = this.mControl;
            if (mapViewImpl != null && (mapViewProxy = mapViewImpl.getMapViewProxy()) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (IBLMapViewProxy) typeHelper.transfer(method, -1, (Object) mapViewProxy, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapView.24
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    @MapEngineID.MapEngineID1
    public int getEngineId() {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.getEngineId();
        }
        return Integer.MIN_VALUE;
    }

    public boolean isEagleEyeView() {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.isEagleEyeView();
        }
        return false;
    }

    @EGLDeviceID.EGLDeviceID1
    public int getDeviceId() {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.getDeviceId();
        }
        return Integer.MIN_VALUE;
    }

    public int getRCTCityDataVersion(int i) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.getRCTCityDataVersion(i);
        }
        return 0;
    }

    public float getRealRenderFPS() {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.getRealRenderFPS();
        }
        return 0.0f;
    }

    public long getUsedVideoMemory() {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.getUsedVideoMemory();
        }
        return 0L;
    }

    public boolean setMaxRenderDuration(long j) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.setMaxRenderDuration(j);
        }
        return false;
    }

    public void resetTickCount(int i) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            mapViewImpl.resetTickCount(i);
        }
    }

    public void setMapNeedForceDrawLabel(int i) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            mapViewImpl.setMapNeedForceDrawLabel(i);
        }
    }

    public void setMapNeedForceDrawLabel() {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            mapViewImpl.setMapNeedForceDrawLabel();
        }
    }

    public void doRenderMap(boolean z) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            mapViewImpl.doRenderMap(z);
        }
    }

    public void addNaviMessage(NaviMessageParam naviMessageParam) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            mapViewImpl.addNaviMessage(naviMessageParam);
        }
    }

    public int getMapMessageCount(@MapMessageType.MapMessageType1 int i) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.getMapMessageCount(i);
        }
        return 0;
    }

    public void clearMessage(@MapMessageType.MapMessageType1 int i) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            mapViewImpl.clearMessage(i);
        }
    }

    public boolean showEarthView(boolean z, float f, float f2) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.showEarthView(z, f, f2);
        }
        return false;
    }

    public boolean setMapViewStatesOperator(@MapViewStateType.MapViewStateType1 int i, int i2) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.setMapViewStatesOperator(i, i2);
        }
        return false;
    }

    public int getMapViewStatesOperator(@MapViewStateType.MapViewStateType1 int i) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.getMapViewStatesOperator(i);
        }
        return 0;
    }

    public boolean setControllerStatesOperator(@MapControllerStatesType.MapControllerStatesType1 int i, int i2, boolean z) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.setControllerStatesOperator(i, i2, z);
        }
        return false;
    }

    public int getControllerStatesOperator(@MapControllerStatesType.MapControllerStatesType1 int i) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.getControllerStatesOperator(i);
        }
        return 0;
    }

    public void setMapVisible(boolean z) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            mapViewImpl.setMapVisible(z);
        }
    }

    public void setMapviewPort(MapViewPortParam mapViewPortParam) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            mapViewImpl.setMapviewPort(mapViewPortParam);
        }
    }

    public void resetMapviewPort() {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            mapViewImpl.resetMapviewPort();
        }
    }

    public MapViewPortParam getMapviewPort() {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.getMapviewPort();
        }
        return null;
    }

    public void setMapLeftTop(int i, int i2) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            mapViewImpl.setMapLeftTop(i, i2);
        }
    }

    public MapLeftTop getMapLeftTop() {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.getMapLeftTop();
        }
        return null;
    }

    public void setMapProjectionCenter(float f, float f2) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            mapViewImpl.setMapProjectionCenter(f, f2);
        }
    }

    public PointF getMapProjectionCenter() {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.getMapProjectionCenter();
        }
        return null;
    }

    public void mapZoomIn(boolean z, boolean z2) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            mapViewImpl.mapZoomIn(z, z2);
        }
    }

    public void mapZoomOut(boolean z, boolean z2) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            mapViewImpl.mapZoomOut(z, z2);
        }
    }

    public void setCarPositionRatio(float f, float f2) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            mapViewImpl.setCarPositionRatio(f, f2);
        }
    }

    public void setMapMode(MapviewModeParam mapviewModeParam, boolean z) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            mapViewImpl.setMapMode(mapviewModeParam, z);
        }
    }

    @MapviewMode.MapviewMode1
    public int getMapMode() {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.getMapMode();
        }
        return Integer.MIN_VALUE;
    }

    public void goToPosition(MapPositionParam mapPositionParam, boolean z) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            mapViewImpl.goToPosition(mapPositionParam, z);
        }
    }

    public void showPreview(PreviewParam previewParam, boolean z, int i, int i2) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            mapViewImpl.showPreview(previewParam, z, i, i2);
        }
    }

    public void exitPreview(boolean z) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            mapViewImpl.exitPreview(z);
        }
    }

    public ScreenShotInfo getScreenShotInfo(RectInt rectInt, IBLMapBusinessDataObserver iBLMapBusinessDataObserver) {
        HashSet hashSet;
        IBLMapBusinessDataObserverImpl iBLMapBusinessDataObserverImpl;
        if (rectInt == null || iBLMapBusinessDataObserver == null) {
            return null;
        }
        try {
            Method method = MapView.class.getMethod("getScreenShotInfo", RectInt.class, IBLMapBusinessDataObserver.class);
            TypeHelper typeHelper = this.mTypeHelper;
            if (typeHelper != null) {
                hashSet = (HashSet) typeHelper.getBindSet(method, 1);
            } else {
                hashSet = new HashSet();
            }
            hashSet.remove(iBLMapBusinessDataObserver);
            if (iBLMapBusinessDataObserver != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                iBLMapBusinessDataObserverImpl = typeHelper2 != null ? (IBLMapBusinessDataObserverImpl) typeHelper2.transfer(method, 1, iBLMapBusinessDataObserver) : null;
                if (iBLMapBusinessDataObserverImpl == null) {
                    DebugTool.e("%s: $observer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapView.25
                    }));
                    return null;
                }
            } else {
                iBLMapBusinessDataObserverImpl = null;
            }
            MapViewImpl mapViewImpl = this.mControl;
            if (mapViewImpl != null) {
                ScreenShotInfo screenShotInfo = mapViewImpl.getScreenShotInfo(rectInt, iBLMapBusinessDataObserverImpl);
                TypeHelper typeHelper3 = this.mTypeHelper;
                if (typeHelper3 != null) {
                    typeHelper3.unbindSet(method, 1, hashSet);
                }
                return screenShotInfo;
            }
            return null;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public boolean doDataControl(int i, int i2, int i3, int i4) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.doDataControl(i, i2, i3, i4);
        }
        return false;
    }

    public boolean testMapParamter(TestMapPara testMapPara) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.testMapParamter(testMapPara);
        }
        return false;
    }

    public void setMapFadeIn(int i) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            mapViewImpl.setMapFadeIn(i);
        }
    }

    public void setMapFadeOut(int i) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            mapViewImpl.setMapFadeOut(i);
        }
    }

    public boolean getMapFadeAnimOver() {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.getMapFadeAnimOver();
        }
        return false;
    }

    public float getMapFadeAnimAlpha() {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.getMapFadeAnimAlpha();
        }
        return 0.0f;
    }

    public void setLayerCollisionEnable(boolean z) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            mapViewImpl.setLayerCollisionEnable(z);
        }
    }

    public boolean getLayerCollisionEnable() {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.getLayerCollisionEnable();
        }
        return false;
    }

    public boolean startMapPostureCache() {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.startMapPostureCache();
        }
        return false;
    }

    public boolean cancelMapPostureCache() {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.cancelMapPostureCache();
        }
        return false;
    }

    public boolean flushMapPostureCache(long j, boolean z, long j2) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.flushMapPostureCache(j, z, j2);
        }
        return false;
    }

    public void setZoomable(boolean z) {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            mapViewImpl.setZoomable(z);
        }
    }

    public boolean getZoomable() {
        MapViewImpl mapViewImpl = this.mControl;
        if (mapViewImpl != null) {
            return mapViewImpl.getZoomable();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapView.26
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
        if (this.mTypeHelper != null) {
            Set set = this.mMemberSet;
            if (set != null) {
                synchronized (set) {
                    for (Object obj : this.mMemberSet) {
                        ReflexTool.invokeDeclMethodSafe(obj, "unbind", null, null);
                    }
                }
            }
            this.mTypeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    public void onDestroy() {
        this.mHasDestroy = true;
        Set set = this.mMemberSet;
        if (set != null) {
            synchronized (set) {
                for (Object obj : this.mMemberSet) {
                    ReflexTool.invokeDeclMethodSafe(obj, "onDestroy", null, null);
                }
            }
        }
        clean();
    }

    protected void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapView.27
        }));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.map.observer.IMapGestureObserver")).iterator();
            while (it.hasNext()) {
                removeGestureObserver((IMapGestureObserver) it.next());
            }
        }
        TypeHelper typeHelper2 = this.mTypeHelper;
        if (typeHelper2 != null) {
            Iterator it2 = ((HashSet) typeHelper2.getBindSet("com.autonavi.gbl.map.observer.IMapEventObserver")).iterator();
            while (it2.hasNext()) {
                removeMapEventObserver((IMapEventObserver) it2.next());
            }
        }
        TypeHelper typeHelper3 = this.mTypeHelper;
        if (typeHelper3 != null) {
            Iterator it3 = ((HashSet) typeHelper3.getBindSet("com.autonavi.gbl.map.observer.IMapviewObserver")).iterator();
            while (it3.hasNext()) {
                removeMapviewObserver((IMapviewObserver) it3.next());
            }
        }
        TypeHelper typeHelper4 = this.mTypeHelper;
        if (typeHelper4 != null) {
            Iterator it4 = ((HashSet) typeHelper4.getBindSet("com.autonavi.gbl.map.observer.IReculateOverlay")).iterator();
            while (it4.hasNext()) {
                removeReculateOverlayObserver((IReculateOverlay) it4.next());
            }
        }
    }

    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapView.28
        }));
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            this.mControl = null;
        }
    }
}
