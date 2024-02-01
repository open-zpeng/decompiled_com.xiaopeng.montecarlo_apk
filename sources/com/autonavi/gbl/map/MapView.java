package com.autonavi.gbl.map;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.common.model.RectInt;
import com.autonavi.gbl.map.impl.IMapViewImpl;
import com.autonavi.gbl.map.impl.IOperatorAnimationImpl;
import com.autonavi.gbl.map.impl.IOperatorBusinessImpl;
import com.autonavi.gbl.map.impl.IOperatorCollisionImpl;
import com.autonavi.gbl.map.impl.IOperatorGestureImpl;
import com.autonavi.gbl.map.impl.IOperatorPostureImpl;
import com.autonavi.gbl.map.impl.IOperatorScaleImpl;
import com.autonavi.gbl.map.impl.IOperatorStyleImpl;
import com.autonavi.gbl.map.impl.IOperatorWeatherImpl;
import com.autonavi.gbl.map.layer.LayerMgr;
import com.autonavi.gbl.map.layer.impl.ILayerMgrImpl;
import com.autonavi.gbl.map.layer.model.Layer3DModel;
import com.autonavi.gbl.map.layer.model.LayerTexture;
import com.autonavi.gbl.map.model.EGLDeviceID;
import com.autonavi.gbl.map.model.MapControllerStatesType;
import com.autonavi.gbl.map.model.MapEngineID;
import com.autonavi.gbl.map.model.MapMessageType;
import com.autonavi.gbl.map.model.MapPositionParam;
import com.autonavi.gbl.map.model.MapViewPortParam;
import com.autonavi.gbl.map.model.MapViewStateType;
import com.autonavi.gbl.map.model.MapviewMode;
import com.autonavi.gbl.map.model.MapviewModeParam;
import com.autonavi.gbl.map.model.NaviMessageParam;
import com.autonavi.gbl.map.model.PointI;
import com.autonavi.gbl.map.model.PreviewParam;
import com.autonavi.gbl.map.model.ProjectionCenter;
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
import com.autonavi.gbl.map.observer.impl.IMapviewObserverImpl;
import com.autonavi.gbl.map.observer.impl.IReculateOverlayImpl;
import com.autonavi.gbl.map.observer.impl.ITextTextureObserverImpl;
import com.autonavi.gbl.map.observer.impl.MapRunnableImpl;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
@IntfAuto(target = IMapViewImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class MapView {
    private static String PACKAGE = ReflexTool.PN(MapView.class);
    private IMapViewImpl mControl;
    private boolean mHasDestroy;
    private Set mMemberSet;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected MapView(long j, boolean z) {
        this(new IMapViewImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(MapView.class, this, this.mControl);
        }
    }

    public MapView(IMapViewImpl iMapViewImpl) {
        this.mMemberSet = Collections.synchronizedSet(new HashSet());
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iMapViewImpl);
    }

    private void $constructor(IMapViewImpl iMapViewImpl) {
        if (iMapViewImpl != null) {
            this.mControl = iMapViewImpl;
            this.mTargetId = String.format("MapView_%s_%d", String.valueOf(IMapViewImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IMapViewImpl getControl() {
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
            MapRunnableImpl mapRunnableImpl = typeHelper != null ? (MapRunnableImpl) typeHelper.transfer(method, 0, iMapRunnable2) : null;
            IMapViewImpl iMapViewImpl = this.mControl;
            if (iMapViewImpl != null) {
                iMapViewImpl.queueEvent(mapRunnableImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public OperatorStyle getOperatorStyle() {
        Set set;
        TypeHelper typeHelper;
        OperatorStyle operatorStyle = null;
        try {
            Method method = MapView.class.getMethod("getOperatorStyle", new Class[0]);
            IMapViewImpl iMapViewImpl = this.mControl;
            if (iMapViewImpl != null) {
                IOperatorStyleImpl operatorStyle2 = iMapViewImpl.getOperatorStyle();
                if (operatorStyle2 != null && (typeHelper = this.mTypeHelper) != null) {
                    operatorStyle = (OperatorStyle) typeHelper.transfer(method, -1, (Object) operatorStyle2, true);
                }
                if (operatorStyle != null && (set = this.mMemberSet) != null) {
                    synchronized (set) {
                        this.mMemberSet.add(operatorStyle);
                    }
                }
            }
            return operatorStyle;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public LayerMgr getLayerMgr() {
        Set set;
        TypeHelper typeHelper;
        LayerMgr layerMgr = null;
        try {
            Method method = MapView.class.getMethod("getLayerMgr", new Class[0]);
            IMapViewImpl iMapViewImpl = this.mControl;
            if (iMapViewImpl != null) {
                ILayerMgrImpl layerMgr2 = iMapViewImpl.getLayerMgr();
                if (layerMgr2 != null && (typeHelper = this.mTypeHelper) != null) {
                    layerMgr = (LayerMgr) typeHelper.transfer(method, -1, (Object) layerMgr2, true);
                }
                if (layerMgr != null && (set = this.mMemberSet) != null) {
                    synchronized (set) {
                        this.mMemberSet.add(layerMgr);
                    }
                }
            }
            return layerMgr;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public OperatorBusiness getOperatorBusiness() {
        Set set;
        TypeHelper typeHelper;
        OperatorBusiness operatorBusiness = null;
        try {
            Method method = MapView.class.getMethod("getOperatorBusiness", new Class[0]);
            IMapViewImpl iMapViewImpl = this.mControl;
            if (iMapViewImpl != null) {
                IOperatorBusinessImpl operatorBusiness2 = iMapViewImpl.getOperatorBusiness();
                if (operatorBusiness2 != null && (typeHelper = this.mTypeHelper) != null) {
                    operatorBusiness = (OperatorBusiness) typeHelper.transfer(method, -1, (Object) operatorBusiness2, true);
                }
                if (operatorBusiness != null && (set = this.mMemberSet) != null) {
                    synchronized (set) {
                        this.mMemberSet.add(operatorBusiness);
                    }
                }
            }
            return operatorBusiness;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public OperatorPosture getOperatorPosture() {
        Set set;
        TypeHelper typeHelper;
        OperatorPosture operatorPosture = null;
        try {
            Method method = MapView.class.getMethod("getOperatorPosture", new Class[0]);
            IMapViewImpl iMapViewImpl = this.mControl;
            if (iMapViewImpl != null) {
                IOperatorPostureImpl operatorPosture2 = iMapViewImpl.getOperatorPosture();
                if (operatorPosture2 != null && (typeHelper = this.mTypeHelper) != null) {
                    operatorPosture = (OperatorPosture) typeHelper.transfer(method, -1, (Object) operatorPosture2, true);
                }
                if (operatorPosture != null && (set = this.mMemberSet) != null) {
                    synchronized (set) {
                        this.mMemberSet.add(operatorPosture);
                    }
                }
            }
            return operatorPosture;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public OperatorGesture getOperatorGesture() {
        Set set;
        TypeHelper typeHelper;
        OperatorGesture operatorGesture = null;
        try {
            Method method = MapView.class.getMethod("getOperatorGesture", new Class[0]);
            IMapViewImpl iMapViewImpl = this.mControl;
            if (iMapViewImpl != null) {
                IOperatorGestureImpl operatorGesture2 = iMapViewImpl.getOperatorGesture();
                if (operatorGesture2 != null && (typeHelper = this.mTypeHelper) != null) {
                    operatorGesture = (OperatorGesture) typeHelper.transfer(method, -1, (Object) operatorGesture2, true);
                }
                if (operatorGesture != null && (set = this.mMemberSet) != null) {
                    synchronized (set) {
                        this.mMemberSet.add(operatorGesture);
                    }
                }
            }
            return operatorGesture;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public OperatorAnimation getOperatorAnimation() {
        Set set;
        TypeHelper typeHelper;
        OperatorAnimation operatorAnimation = null;
        try {
            Method method = MapView.class.getMethod("getOperatorAnimation", new Class[0]);
            IMapViewImpl iMapViewImpl = this.mControl;
            if (iMapViewImpl != null) {
                IOperatorAnimationImpl operatorAnimation2 = iMapViewImpl.getOperatorAnimation();
                if (operatorAnimation2 != null && (typeHelper = this.mTypeHelper) != null) {
                    operatorAnimation = (OperatorAnimation) typeHelper.transfer(method, -1, (Object) operatorAnimation2, true);
                }
                if (operatorAnimation != null && (set = this.mMemberSet) != null) {
                    synchronized (set) {
                        this.mMemberSet.add(operatorAnimation);
                    }
                }
            }
            return operatorAnimation;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public OperatorCollision getOperatorCollision() {
        Set set;
        TypeHelper typeHelper;
        OperatorCollision operatorCollision = null;
        try {
            Method method = MapView.class.getMethod("getOperatorCollision", new Class[0]);
            IMapViewImpl iMapViewImpl = this.mControl;
            if (iMapViewImpl != null) {
                IOperatorCollisionImpl operatorCollision2 = iMapViewImpl.getOperatorCollision();
                if (operatorCollision2 != null && (typeHelper = this.mTypeHelper) != null) {
                    operatorCollision = (OperatorCollision) typeHelper.transfer(method, -1, (Object) operatorCollision2, true);
                }
                if (operatorCollision != null && (set = this.mMemberSet) != null) {
                    synchronized (set) {
                        this.mMemberSet.add(operatorCollision);
                    }
                }
            }
            return operatorCollision;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public OperatorScale getOperatorScale() {
        Set set;
        TypeHelper typeHelper;
        OperatorScale operatorScale = null;
        try {
            Method method = MapView.class.getMethod("getOperatorScale", new Class[0]);
            IMapViewImpl iMapViewImpl = this.mControl;
            if (iMapViewImpl != null) {
                IOperatorScaleImpl operatorScale2 = iMapViewImpl.getOperatorScale();
                if (operatorScale2 != null && (typeHelper = this.mTypeHelper) != null) {
                    operatorScale = (OperatorScale) typeHelper.transfer(method, -1, (Object) operatorScale2, true);
                }
                if (operatorScale != null && (set = this.mMemberSet) != null) {
                    synchronized (set) {
                        this.mMemberSet.add(operatorScale);
                    }
                }
            }
            return operatorScale;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public OperatorWeather getOperatorWeather() {
        Set set;
        TypeHelper typeHelper;
        OperatorWeather operatorWeather = null;
        try {
            Method method = MapView.class.getMethod("getOperatorWeather", new Class[0]);
            IMapViewImpl iMapViewImpl = this.mControl;
            if (iMapViewImpl != null) {
                IOperatorWeatherImpl operatorWeather2 = iMapViewImpl.getOperatorWeather();
                if (operatorWeather2 != null && (typeHelper = this.mTypeHelper) != null) {
                    operatorWeather = (OperatorWeather) typeHelper.transfer(method, -1, (Object) operatorWeather2, true);
                }
                if (operatorWeather != null && (set = this.mMemberSet) != null) {
                    synchronized (set) {
                        this.mMemberSet.add(operatorWeather);
                    }
                }
            }
            return operatorWeather;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public boolean addLayer3DModel(Layer3DModel layer3DModel) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.addLayer3DModel(layer3DModel);
        }
        return false;
    }

    public boolean updateLayer3DModel(Layer3DModel layer3DModel) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.updateLayer3DModel(layer3DModel);
        }
        return false;
    }

    public boolean destroyLayer3DModel(int i) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.destroyLayer3DModel(i);
        }
        return false;
    }

    public RectDouble get3DModelBoundRect(int i) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.get3DModelBoundRect(i);
        }
        return null;
    }

    public boolean addLayerTexture(LayerTexture layerTexture) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.addLayerTexture(layerTexture);
        }
        return false;
    }

    public boolean updateTexture(LayerTexture layerTexture) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.updateTexture(layerTexture);
        }
        return false;
    }

    public boolean destroyTexture(int i) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.destroyTexture(i);
        }
        return false;
    }

    public LayerTexture getLayerTexture(int i) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.getLayerTexture(i);
        }
        return null;
    }

    public long getCapacityTextureCount() {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.getCapacityTextureCount();
        }
        return 0L;
    }

    public long getUsedTextureCount() {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.getUsedTextureCount();
        }
        return 0L;
    }

    public RectInt getBoundRect(int i, int i2, int i3, float f) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.getBoundRect(i, i2, i3, f);
        }
        return null;
    }

    public void addMapviewObserver(IMapviewObserver iMapviewObserver) {
        TypeHelper typeHelper;
        try {
            Method method = MapView.class.getMethod("addMapviewObserver", IMapviewObserver.class);
            IMapviewObserverImpl iMapviewObserverImpl = null;
            if (iMapviewObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iMapviewObserverImpl = (IMapviewObserverImpl) typeHelper.transfer(method, 0, iMapviewObserver);
            }
            IMapViewImpl iMapViewImpl = this.mControl;
            if (iMapViewImpl != null) {
                iMapViewImpl.addMapviewObserver(iMapviewObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeMapviewObserver(IMapviewObserver iMapviewObserver) {
        TypeHelper typeHelper;
        try {
            Method method = MapView.class.getMethod("removeMapviewObserver", IMapviewObserver.class);
            IMapviewObserverImpl iMapviewObserverImpl = null;
            if (iMapviewObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iMapviewObserverImpl = (IMapviewObserverImpl) typeHelper.transfer(method, 0, iMapviewObserver);
            }
            IMapViewImpl iMapViewImpl = this.mControl;
            if (iMapViewImpl != null) {
                iMapViewImpl.removeMapviewObserver(iMapviewObserverImpl);
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
        TypeHelper typeHelper;
        try {
            Method method = MapView.class.getMethod("addMapEventObserver", IMapEventObserver.class);
            IMapEventObserverImpl iMapEventObserverImpl = null;
            if (iMapEventObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iMapEventObserverImpl = (IMapEventObserverImpl) typeHelper.transfer(method, 0, iMapEventObserver);
            }
            IMapViewImpl iMapViewImpl = this.mControl;
            if (iMapViewImpl != null) {
                return iMapViewImpl.addMapEventObserver(iMapEventObserverImpl);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeMapEventObserver(IMapEventObserver iMapEventObserver) {
        TypeHelper typeHelper;
        try {
            Method method = MapView.class.getMethod("removeMapEventObserver", IMapEventObserver.class);
            IMapEventObserverImpl iMapEventObserverImpl = null;
            if (iMapEventObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iMapEventObserverImpl = (IMapEventObserverImpl) typeHelper.transfer(method, 0, iMapEventObserver);
            }
            IMapViewImpl iMapViewImpl = this.mControl;
            if (iMapViewImpl != null) {
                boolean removeMapEventObserver = iMapViewImpl.removeMapEventObserver(iMapEventObserverImpl);
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
        TypeHelper typeHelper;
        try {
            Method method = MapView.class.getMethod("addGestureObserver", IMapGestureObserver.class);
            IMapGestureObserverImpl iMapGestureObserverImpl = null;
            if (iMapGestureObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iMapGestureObserverImpl = (IMapGestureObserverImpl) typeHelper.transfer(method, 0, iMapGestureObserver);
            }
            IMapViewImpl iMapViewImpl = this.mControl;
            if (iMapViewImpl != null) {
                iMapViewImpl.addGestureObserver(iMapGestureObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeGestureObserver(IMapGestureObserver iMapGestureObserver) {
        TypeHelper typeHelper;
        try {
            Method method = MapView.class.getMethod("removeGestureObserver", IMapGestureObserver.class);
            IMapGestureObserverImpl iMapGestureObserverImpl = null;
            if (iMapGestureObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iMapGestureObserverImpl = (IMapGestureObserverImpl) typeHelper.transfer(method, 0, iMapGestureObserver);
            }
            IMapViewImpl iMapViewImpl = this.mControl;
            if (iMapViewImpl != null) {
                iMapViewImpl.removeGestureObserver(iMapGestureObserverImpl);
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
        TypeHelper typeHelper;
        try {
            Method method = MapView.class.getMethod("setMapEngineObserver", IBLMapEngineObserver.class);
            IBLMapEngineObserverImpl iBLMapEngineObserverImpl = null;
            if (iBLMapEngineObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iBLMapEngineObserverImpl = (IBLMapEngineObserverImpl) typeHelper.transfer(method, 0, iBLMapEngineObserver);
            }
            IMapViewImpl iMapViewImpl = this.mControl;
            if (iMapViewImpl != null) {
                iMapViewImpl.setMapEngineObserver(iBLMapEngineObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeMapEngineObserver() {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            iMapViewImpl.removeMapEngineObserver();
        }
    }

    public void addReculateOverlayObserver(IReculateOverlay iReculateOverlay) {
        TypeHelper typeHelper;
        try {
            Method method = MapView.class.getMethod("addReculateOverlayObserver", IReculateOverlay.class);
            IReculateOverlayImpl iReculateOverlayImpl = null;
            if (iReculateOverlay != null && (typeHelper = this.mTypeHelper) != null) {
                iReculateOverlayImpl = (IReculateOverlayImpl) typeHelper.transfer(method, 0, iReculateOverlay);
            }
            IMapViewImpl iMapViewImpl = this.mControl;
            if (iMapViewImpl != null) {
                iMapViewImpl.addReculateOverlayObserver(iReculateOverlayImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeReculateOverlayObserver(IReculateOverlay iReculateOverlay) {
        TypeHelper typeHelper;
        try {
            Method method = MapView.class.getMethod("removeReculateOverlayObserver", IReculateOverlay.class);
            IReculateOverlayImpl iReculateOverlayImpl = null;
            if (iReculateOverlay != null && (typeHelper = this.mTypeHelper) != null) {
                iReculateOverlayImpl = (IReculateOverlayImpl) typeHelper.transfer(method, 0, iReculateOverlay);
            }
            IMapViewImpl iMapViewImpl = this.mControl;
            if (iMapViewImpl != null) {
                iMapViewImpl.removeReculateOverlayObserver(iReculateOverlayImpl);
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
        TypeHelper typeHelper;
        try {
            Method method = MapView.class.getMethod("setTextTextureObserver", ITextTextureObserver.class);
            TypeHelper typeHelper2 = this.mTypeHelper;
            if (typeHelper2 != null) {
                hashSet = (HashSet) typeHelper2.getBindSet(method, 0);
            } else {
                hashSet = new HashSet();
            }
            hashSet.remove(iTextTextureObserver);
            ITextTextureObserverImpl iTextTextureObserverImpl = null;
            if (iTextTextureObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iTextTextureObserverImpl = (ITextTextureObserverImpl) typeHelper.transfer(method, 0, iTextTextureObserver);
            }
            IMapViewImpl iMapViewImpl = this.mControl;
            if (iMapViewImpl != null) {
                iMapViewImpl.setTextTextureObserver(iTextTextureObserverImpl);
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
        TypeHelper typeHelper;
        try {
            Method method = MapView.class.getMethod("setMapFpsObserver", IMapFpsObserver.class);
            IMapFpsObserverImpl iMapFpsObserverImpl = null;
            if (iMapFpsObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iMapFpsObserverImpl = (IMapFpsObserverImpl) typeHelper.transfer(method, 0, iMapFpsObserver);
            }
            IMapViewImpl iMapViewImpl = this.mControl;
            if (iMapViewImpl != null) {
                iMapViewImpl.setMapFpsObserver(iMapFpsObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void setMapViewProxy(IBLMapViewProxy iBLMapViewProxy) {
        TypeHelper typeHelper;
        try {
            Method method = MapView.class.getMethod("setMapViewProxy", IBLMapViewProxy.class);
            IBLMapViewProxyImpl iBLMapViewProxyImpl = null;
            if (iBLMapViewProxy != null && (typeHelper = this.mTypeHelper) != null) {
                iBLMapViewProxyImpl = (IBLMapViewProxyImpl) typeHelper.transfer(method, 0, iBLMapViewProxy);
            }
            IMapViewImpl iMapViewImpl = this.mControl;
            if (iMapViewImpl != null) {
                iMapViewImpl.setMapViewProxy(iBLMapViewProxyImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public IBLMapViewProxy getMapViewProxy() {
        IBLMapViewProxyImpl mapViewProxy;
        TypeHelper typeHelper;
        try {
            Method method = MapView.class.getMethod("getMapViewProxy", new Class[0]);
            IMapViewImpl iMapViewImpl = this.mControl;
            if (iMapViewImpl == null || (mapViewProxy = iMapViewImpl.getMapViewProxy()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (IBLMapViewProxy) typeHelper.transfer(method, -1, (Object) mapViewProxy, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    @MapEngineID.MapEngineID1
    public int getEngineId() {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.getEngineId();
        }
        return Integer.MIN_VALUE;
    }

    public boolean isEagleEyeView() {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.isEagleEyeView();
        }
        return false;
    }

    @EGLDeviceID.EGLDeviceID1
    public int getDeviceId() {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.getDeviceId();
        }
        return Integer.MIN_VALUE;
    }

    public int getRCTCityDataVersion(int i) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.getRCTCityDataVersion(i);
        }
        return 0;
    }

    public float getRealRenderFPS() {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.getRealRenderFPS();
        }
        return 0.0f;
    }

    public long getUsedVideoMemory() {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.getUsedVideoMemory();
        }
        return 0L;
    }

    public boolean setMaxRenderDuration(long j) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.setMaxRenderDuration(j);
        }
        return false;
    }

    public void resetTickCount(int i) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            iMapViewImpl.resetTickCount(i);
        }
    }

    public void setMapNeedForceDrawLabel(int i) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            iMapViewImpl.setMapNeedForceDrawLabel(i);
        }
    }

    public void setMapNeedForceDrawLabel() {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            iMapViewImpl.setMapNeedForceDrawLabel();
        }
    }

    public void doRenderMap(boolean z) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            iMapViewImpl.doRenderMap(z);
        }
    }

    public void addNaviMessage(NaviMessageParam naviMessageParam) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            iMapViewImpl.addNaviMessage(naviMessageParam);
        }
    }

    public int getMapMessageCount(@MapMessageType.MapMessageType1 int i) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.getMapMessageCount(i);
        }
        return 0;
    }

    public void clearMessage(@MapMessageType.MapMessageType1 int i) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            iMapViewImpl.clearMessage(i);
        }
    }

    public boolean setMapViewStatesOperator(@MapViewStateType.MapViewStateType1 int i, int i2) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.setMapViewStatesOperator(i, i2);
        }
        return false;
    }

    public int getMapViewStatesOperator(@MapViewStateType.MapViewStateType1 int i) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.getMapViewStatesOperator(i);
        }
        return 0;
    }

    public boolean setControllerStatesOperator(@MapControllerStatesType.MapControllerStatesType1 int i, int i2, boolean z) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.setControllerStatesOperator(i, i2, z);
        }
        return false;
    }

    public int getControllerStatesOperator(@MapControllerStatesType.MapControllerStatesType1 int i) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.getControllerStatesOperator(i);
        }
        return 0;
    }

    public boolean showEarthView(boolean z, float f, float f2) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.showEarthView(z, f, f2);
        }
        return false;
    }

    public void setMapVisible(boolean z) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            iMapViewImpl.setMapVisible(z);
        }
    }

    public void setMapviewPort(MapViewPortParam mapViewPortParam) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            iMapViewImpl.setMapviewPort(mapViewPortParam);
        }
    }

    public void resetMapviewPort() {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            iMapViewImpl.resetMapviewPort();
        }
    }

    public MapViewPortParam getMapviewPort() {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.getMapviewPort();
        }
        return null;
    }

    public void setMapLeftTop(int i, int i2) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            iMapViewImpl.setMapLeftTop(i, i2);
        }
    }

    public PointI getMapLeftTop() {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.getMapLeftTop();
        }
        return null;
    }

    public void setMapProjectionCenter(float f, float f2) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            iMapViewImpl.setMapProjectionCenter(f, f2);
        }
    }

    public ProjectionCenter getMapProjectionCenter() {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.getMapProjectionCenter();
        }
        return null;
    }

    public void mapZoomIn(boolean z, boolean z2) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            iMapViewImpl.mapZoomIn(z, z2);
        }
    }

    public void mapZoomOut(boolean z, boolean z2) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            iMapViewImpl.mapZoomOut(z, z2);
        }
    }

    public void setCarPositionRatio(float f, float f2) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            iMapViewImpl.setCarPositionRatio(f, f2);
        }
    }

    public void setMapMode(MapviewModeParam mapviewModeParam, boolean z) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            iMapViewImpl.setMapMode(mapviewModeParam, z);
        }
    }

    @MapviewMode.MapviewMode1
    public int getMapMode() {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.getMapMode();
        }
        return Integer.MIN_VALUE;
    }

    public void goToPosition(MapPositionParam mapPositionParam, boolean z) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            iMapViewImpl.goToPosition(mapPositionParam, z);
        }
    }

    public void showPreview(PreviewParam previewParam, boolean z, int i, int i2) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            iMapViewImpl.showPreview(previewParam, z, i, i2);
        }
    }

    public void exitPreview(boolean z) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            iMapViewImpl.exitPreview(z);
        }
    }

    public ScreenShotInfo getScreenShotInfo(RectInt rectInt, IBLMapBusinessDataObserver iBLMapBusinessDataObserver) {
        HashSet hashSet;
        TypeHelper typeHelper;
        if (rectInt == null || iBLMapBusinessDataObserver == null) {
            return null;
        }
        try {
            Method method = MapView.class.getMethod("getScreenShotInfo", RectInt.class, IBLMapBusinessDataObserver.class);
            TypeHelper typeHelper2 = this.mTypeHelper;
            if (typeHelper2 != null) {
                hashSet = (HashSet) typeHelper2.getBindSet(method, 1);
            } else {
                hashSet = new HashSet();
            }
            hashSet.remove(iBLMapBusinessDataObserver);
            IBLMapBusinessDataObserverImpl iBLMapBusinessDataObserverImpl = (iBLMapBusinessDataObserver == null || (typeHelper = this.mTypeHelper) == null) ? null : (IBLMapBusinessDataObserverImpl) typeHelper.transfer(method, 1, iBLMapBusinessDataObserver);
            IMapViewImpl iMapViewImpl = this.mControl;
            if (iMapViewImpl != null) {
                ScreenShotInfo screenShotInfo = iMapViewImpl.getScreenShotInfo(rectInt, iBLMapBusinessDataObserverImpl);
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
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.doDataControl(i, i2, i3, i4);
        }
        return false;
    }

    public boolean testMapParamter(TestMapPara testMapPara) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.testMapParamter(testMapPara);
        }
        return false;
    }

    public void setMapFadeIn(int i) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            iMapViewImpl.setMapFadeIn(i);
        }
    }

    public void setMapFadeOut(int i) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            iMapViewImpl.setMapFadeOut(i);
        }
    }

    public boolean getMapFadeAnimOver() {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.getMapFadeAnimOver();
        }
        return false;
    }

    public float getMapFadeAnimAlpha() {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.getMapFadeAnimAlpha();
        }
        return 0.0f;
    }

    public void setLayerCollisionEnable(boolean z) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            iMapViewImpl.setLayerCollisionEnable(z);
        }
    }

    public boolean getLayerCollisionEnable() {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.getLayerCollisionEnable();
        }
        return false;
    }

    public boolean startMapPostureCache() {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.startMapPostureCache();
        }
        return false;
    }

    public boolean cancelMapPostureCache() {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.cancelMapPostureCache();
        }
        return false;
    }

    public boolean flushMapPostureCache(long j, boolean z, long j2) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.flushMapPostureCache(j, z, j2);
        }
        return false;
    }

    public void setZoomable(boolean z) {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            iMapViewImpl.setZoomable(z);
        }
    }

    public boolean getZoomable() {
        IMapViewImpl iMapViewImpl = this.mControl;
        if (iMapViewImpl != null) {
            return iMapViewImpl.getZoomable();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void unbind() {
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
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.map.observer.IMapviewObserver")).iterator();
            while (it.hasNext()) {
                removeMapviewObserver((IMapviewObserver) it.next());
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
            Iterator it3 = ((HashSet) typeHelper3.getBindSet("com.autonavi.gbl.map.observer.IMapGestureObserver")).iterator();
            while (it3.hasNext()) {
                removeGestureObserver((IMapGestureObserver) it3.next());
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
