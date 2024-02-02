package com.autonavi.gbl.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.card.CardService;
import com.autonavi.gbl.card.impl.ICardServiceImpl;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.layer.impl.IBizAGroupControl;
import com.autonavi.gbl.layer.impl.IBizAreaControl;
import com.autonavi.gbl.layer.impl.IBizCarControl;
import com.autonavi.gbl.layer.impl.IBizControlService;
import com.autonavi.gbl.layer.impl.IBizCustomControl;
import com.autonavi.gbl.layer.impl.IBizFlyLineControlImpl;
import com.autonavi.gbl.layer.impl.IBizGuideEagleEyeControl;
import com.autonavi.gbl.layer.impl.IBizGuideRouteControl;
import com.autonavi.gbl.layer.impl.IBizLabelControl;
import com.autonavi.gbl.layer.impl.IBizRoadCrossControl;
import com.autonavi.gbl.layer.impl.IBizRoadFacilityControl;
import com.autonavi.gbl.layer.impl.IBizSearchControl;
import com.autonavi.gbl.layer.impl.IBizUserControl;
import com.autonavi.gbl.layer.model.BizMode;
import com.autonavi.gbl.layer.model.InnerStyleParam;
import com.autonavi.gbl.layer.model.MapPostureControlParam;
import com.autonavi.gbl.layer.observer.PrepareLayerParam;
import com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.impl.MapViewImpl;
import com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle;
import com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl;
import com.autonavi.gbl.map.model.EGLDeviceID;
import com.autonavi.gbl.map.model.MapEngineID;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.servicemanager.model.BusBusinessType;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = IBizControlService.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BizControlService implements IService {
    private static String PACKAGE = ReflexTool.PN(BizControlService.class);
    private IBizControlService mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected BizControlService(long j, boolean z) {
        this((IBizControlService) ReflexTool.invokeDeclConstructorSafe(IBizControlService.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizControlService.class, this, this.mControl);
        }
    }

    public BizControlService(IBizControlService iBizControlService) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iBizControlService);
    }

    private void $constructor(IBizControlService iBizControlService) {
        if (iBizControlService != null) {
            this.mControl = iBizControlService;
            this.mTargetId = String.format("BizControlService_%s_%d", String.valueOf(IBizControlService.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IBizControlService getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        IBizControlService iBizControlService = this.mControl;
        if (iBizControlService != null) {
            return iBizControlService.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        IBizControlService iBizControlService = this.mControl;
        if (iBizControlService != null) {
            return iBizControlService.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        IBizControlService iBizControlService = this.mControl;
        if (iBizControlService != null) {
            iBizControlService.onCreate();
        }
    }

    public boolean init(@MapEngineID.MapEngineID1 int i, String str) {
        IBizControlService iBizControlService = this.mControl;
        if (iBizControlService != null) {
            return iBizControlService.init(i, str);
        }
        return false;
    }

    public void unInit() {
        IBizControlService iBizControlService = this.mControl;
        if (iBizControlService != null) {
            iBizControlService.unInit();
        }
    }

    public void unInit(@MapEngineID.MapEngineID1 int i) {
        IBizControlService iBizControlService = this.mControl;
        if (iBizControlService != null) {
            iBizControlService.unInit(i);
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        IBizControlService iBizControlService = this.mControl;
        if (iBizControlService != null) {
            return iBizControlService.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public boolean isInit(@MapEngineID.MapEngineID1 int i) {
        IBizControlService iBizControlService = this.mControl;
        if (iBizControlService != null) {
            return iBizControlService.isInit(i);
        }
        return false;
    }

    public boolean initInnerStyle(MapView mapView, CardService cardService, PrepareLayerParam prepareLayerParam, InnerStyleParam innerStyleParam) {
        MapViewImpl mapViewImpl;
        ICardServiceImpl iCardServiceImpl;
        try {
            Method method = BizControlService.class.getMethod("initInnerStyle", MapView.class, CardService.class, PrepareLayerParam.class, InnerStyleParam.class);
            if (mapView != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                mapViewImpl = typeHelper != null ? (MapViewImpl) typeHelper.transfer(method, 0, mapView) : null;
                if (mapViewImpl == null) {
                    DebugTool.e("%s: $mapView == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControlService.1
                    }));
                    return false;
                }
            } else {
                mapViewImpl = null;
            }
            if (cardService != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                iCardServiceImpl = typeHelper2 != null ? (ICardServiceImpl) typeHelper2.transfer(method, 1, cardService) : null;
                if (iCardServiceImpl == null) {
                    DebugTool.e("%s: $cardService == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControlService.2
                    }));
                    return false;
                }
            } else {
                iCardServiceImpl = null;
            }
            if (prepareLayerParam != null) {
                TypeHelper typeHelper3 = this.mTypeHelper;
                r2 = typeHelper3 != null ? (IPrepareLayerParamImpl) typeHelper3.transfer(method, 2, prepareLayerParam) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $customParam == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControlService.3
                    }));
                    return false;
                }
            }
            IBizControlService iBizControlService = this.mControl;
            if (iBizControlService != null) {
                return iBizControlService.initInnerStyle(mapViewImpl, iCardServiceImpl, r2, innerStyleParam);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public void setStyle(@MapEngineID.MapEngineID1 int i, IPrepareLayerStyle iPrepareLayerStyle) {
        try {
            Method method = BizControlService.class.getMethod("setStyle", Integer.TYPE, IPrepareLayerStyle.class);
            if (iPrepareLayerStyle != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IPrepareLayerStyleImpl) typeHelper.transfer(method, 1, iPrepareLayerStyle) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $style == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControlService.4
                    }));
                }
            }
            IBizControlService iBizControlService = this.mControl;
            if (iBizControlService != null) {
                iBizControlService.setStyle(i, r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void lockMapPosture(@MapEngineID.MapEngineID1 int i, MapPostureControlParam mapPostureControlParam) {
        IBizControlService iBizControlService = this.mControl;
        if (iBizControlService != null) {
            iBizControlService.lockMapPosture(i, mapPostureControlParam);
        }
    }

    public void setVisible(@MapEngineID.MapEngineID1 int i, boolean z) {
        IBizControlService iBizControlService = this.mControl;
        if (iBizControlService != null) {
            iBizControlService.setVisible(i, z);
        }
    }

    public boolean initCollisionConfig(MapView mapView, String str) {
        try {
            Method method = BizControlService.class.getMethod("initCollisionConfig", MapView.class, String.class);
            if (mapView != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (MapViewImpl) typeHelper.transfer(method, 0, mapView) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $mapView == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControlService.5
                    }));
                    return false;
                }
            }
            IBizControlService iBizControlService = this.mControl;
            if (iBizControlService != null) {
                return iBizControlService.initCollisionConfig(r2, str);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public void setUICollisionRects(MapView mapView, ArrayList<RectDouble> arrayList) {
        try {
            Method method = BizControlService.class.getMethod("setUICollisionRects", MapView.class, ArrayList.class);
            if (mapView != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (MapViewImpl) typeHelper.transfer(method, 0, mapView) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pMapView == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControlService.6
                    }));
                }
            }
            IBizControlService iBizControlService = this.mControl;
            if (iBizControlService != null) {
                iBizControlService.setUICollisionRects(r1, arrayList);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void enableVirtualBus(@MapEngineID.MapEngineID1 int i, @BusBusinessType.BusBusinessType1 int i2, boolean z) {
        IBizControlService iBizControlService = this.mControl;
        if (iBizControlService != null) {
            iBizControlService.enableVirtualBus(i, i2, z);
        }
    }

    public void enableAllVirtualBuses(@MapEngineID.MapEngineID1 int i, boolean z) {
        IBizControlService iBizControlService = this.mControl;
        if (iBizControlService != null) {
            iBizControlService.enableAllVirtualBuses(i, z);
        }
    }

    public boolean isVirtualBusEnable(@MapEngineID.MapEngineID1 int i, @BusBusinessType.BusBusinessType1 int i2) {
        IBizControlService iBizControlService = this.mControl;
        if (iBizControlService != null) {
            return iBizControlService.isVirtualBusEnable(i, i2);
        }
        return false;
    }

    public boolean setBizMode(@MapEngineID.MapEngineID1 int i, @BizMode.BizMode1 int i2) {
        IBizControlService iBizControlService = this.mControl;
        if (iBizControlService != null) {
            return iBizControlService.setBizMode(i, i2);
        }
        return false;
    }

    public BizRoadFacilityControl getBizRoadFacilityControl(MapView mapView) {
        MapViewImpl mapViewImpl;
        IBizRoadFacilityControl bizRoadFacilityControl;
        try {
            Method method = BizControlService.class.getMethod("getBizRoadFacilityControl", MapView.class);
            if (mapView != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                mapViewImpl = typeHelper != null ? (MapViewImpl) typeHelper.transfer(method, 0, mapView) : null;
                if (mapViewImpl == null) {
                    DebugTool.e("%s: $pMapView == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControlService.7
                    }));
                    return null;
                }
            } else {
                mapViewImpl = null;
            }
            IBizControlService iBizControlService = this.mControl;
            if (iBizControlService != null && (bizRoadFacilityControl = iBizControlService.getBizRoadFacilityControl(mapViewImpl)) != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r0 = typeHelper2 != null ? (BizRoadFacilityControl) typeHelper2.transfer(method, -1, (Object) bizRoadFacilityControl, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControlService.8
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizLabelControl getBizLabelControl(MapView mapView) {
        MapViewImpl mapViewImpl;
        IBizLabelControl bizLabelControl;
        try {
            Method method = BizControlService.class.getMethod("getBizLabelControl", MapView.class);
            if (mapView != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                mapViewImpl = typeHelper != null ? (MapViewImpl) typeHelper.transfer(method, 0, mapView) : null;
                if (mapViewImpl == null) {
                    DebugTool.e("%s: $pMapView == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControlService.9
                    }));
                    return null;
                }
            } else {
                mapViewImpl = null;
            }
            IBizControlService iBizControlService = this.mControl;
            if (iBizControlService != null && (bizLabelControl = iBizControlService.getBizLabelControl(mapViewImpl)) != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r0 = typeHelper2 != null ? (BizLabelControl) typeHelper2.transfer(method, -1, (Object) bizLabelControl, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControlService.10
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizRoadCrossControl getBizRoadCrossControl(MapView mapView) {
        MapViewImpl mapViewImpl;
        IBizRoadCrossControl bizRoadCrossControl;
        try {
            Method method = BizControlService.class.getMethod("getBizRoadCrossControl", MapView.class);
            if (mapView != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                mapViewImpl = typeHelper != null ? (MapViewImpl) typeHelper.transfer(method, 0, mapView) : null;
                if (mapViewImpl == null) {
                    DebugTool.e("%s: $pMapView == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControlService.11
                    }));
                    return null;
                }
            } else {
                mapViewImpl = null;
            }
            IBizControlService iBizControlService = this.mControl;
            if (iBizControlService != null && (bizRoadCrossControl = iBizControlService.getBizRoadCrossControl(mapViewImpl)) != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r0 = typeHelper2 != null ? (BizRoadCrossControl) typeHelper2.transfer(method, -1, (Object) bizRoadCrossControl, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControlService.12
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizUserControl getBizUserControl(MapView mapView) {
        MapViewImpl mapViewImpl;
        IBizUserControl bizUserControl;
        try {
            Method method = BizControlService.class.getMethod("getBizUserControl", MapView.class);
            if (mapView != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                mapViewImpl = typeHelper != null ? (MapViewImpl) typeHelper.transfer(method, 0, mapView) : null;
                if (mapViewImpl == null) {
                    DebugTool.e("%s: $pMapView == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControlService.13
                    }));
                    return null;
                }
            } else {
                mapViewImpl = null;
            }
            IBizControlService iBizControlService = this.mControl;
            if (iBizControlService != null && (bizUserControl = iBizControlService.getBizUserControl(mapViewImpl)) != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r0 = typeHelper2 != null ? (BizUserControl) typeHelper2.transfer(method, -1, (Object) bizUserControl, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControlService.14
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizGuideRouteControl getBizGuideRouteControl(MapView mapView) {
        MapViewImpl mapViewImpl;
        IBizGuideRouteControl bizGuideRouteControl;
        try {
            Method method = BizControlService.class.getMethod("getBizGuideRouteControl", MapView.class);
            if (mapView != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                mapViewImpl = typeHelper != null ? (MapViewImpl) typeHelper.transfer(method, 0, mapView) : null;
                if (mapViewImpl == null) {
                    DebugTool.e("%s: $pMapView == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControlService.15
                    }));
                    return null;
                }
            } else {
                mapViewImpl = null;
            }
            IBizControlService iBizControlService = this.mControl;
            if (iBizControlService != null && (bizGuideRouteControl = iBizControlService.getBizGuideRouteControl(mapViewImpl)) != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r0 = typeHelper2 != null ? (BizGuideRouteControl) typeHelper2.transfer(method, -1, (Object) bizGuideRouteControl, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControlService.16
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizCarControl getBizCarControl(MapView mapView) {
        MapViewImpl mapViewImpl;
        IBizCarControl bizCarControl;
        try {
            Method method = BizControlService.class.getMethod("getBizCarControl", MapView.class);
            if (mapView != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                mapViewImpl = typeHelper != null ? (MapViewImpl) typeHelper.transfer(method, 0, mapView) : null;
                if (mapViewImpl == null) {
                    DebugTool.e("%s: $pMapView == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControlService.17
                    }));
                    return null;
                }
            } else {
                mapViewImpl = null;
            }
            IBizControlService iBizControlService = this.mControl;
            if (iBizControlService != null && (bizCarControl = iBizControlService.getBizCarControl(mapViewImpl)) != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r0 = typeHelper2 != null ? (BizCarControl) typeHelper2.transfer(method, -1, (Object) bizCarControl, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControlService.18
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizFlyLineControl getBizFlyLineControl(MapView mapView) {
        MapViewImpl mapViewImpl;
        IBizFlyLineControlImpl bizFlyLineControl;
        try {
            Method method = BizControlService.class.getMethod("getBizFlyLineControl", MapView.class);
            if (mapView != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                mapViewImpl = typeHelper != null ? (MapViewImpl) typeHelper.transfer(method, 0, mapView) : null;
                if (mapViewImpl == null) {
                    DebugTool.e("%s: $pMapView == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControlService.19
                    }));
                    return null;
                }
            } else {
                mapViewImpl = null;
            }
            IBizControlService iBizControlService = this.mControl;
            if (iBizControlService != null && (bizFlyLineControl = iBizControlService.getBizFlyLineControl(mapViewImpl)) != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r0 = typeHelper2 != null ? (BizFlyLineControl) typeHelper2.transfer(method, -1, (Object) bizFlyLineControl, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControlService.20
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizAGroupControl getBizAGroupControl(MapView mapView) {
        MapViewImpl mapViewImpl;
        IBizAGroupControl bizAGroupControl;
        try {
            Method method = BizControlService.class.getMethod("getBizAGroupControl", MapView.class);
            if (mapView != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                mapViewImpl = typeHelper != null ? (MapViewImpl) typeHelper.transfer(method, 0, mapView) : null;
                if (mapViewImpl == null) {
                    DebugTool.e("%s: $pMapView == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControlService.21
                    }));
                    return null;
                }
            } else {
                mapViewImpl = null;
            }
            IBizControlService iBizControlService = this.mControl;
            if (iBizControlService != null && (bizAGroupControl = iBizControlService.getBizAGroupControl(mapViewImpl)) != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r0 = typeHelper2 != null ? (BizAGroupControl) typeHelper2.transfer(method, -1, (Object) bizAGroupControl, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControlService.22
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizAreaControl getBizAreaControl(MapView mapView) {
        MapViewImpl mapViewImpl;
        IBizAreaControl bizAreaControl;
        try {
            Method method = BizControlService.class.getMethod("getBizAreaControl", MapView.class);
            if (mapView != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                mapViewImpl = typeHelper != null ? (MapViewImpl) typeHelper.transfer(method, 0, mapView) : null;
                if (mapViewImpl == null) {
                    DebugTool.e("%s: $pMapView == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControlService.23
                    }));
                    return null;
                }
            } else {
                mapViewImpl = null;
            }
            IBizControlService iBizControlService = this.mControl;
            if (iBizControlService != null && (bizAreaControl = iBizControlService.getBizAreaControl(mapViewImpl)) != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r0 = typeHelper2 != null ? (BizAreaControl) typeHelper2.transfer(method, -1, (Object) bizAreaControl, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControlService.24
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizSearchControl getBizSearchControl(MapView mapView) {
        MapViewImpl mapViewImpl;
        IBizSearchControl bizSearchControl;
        try {
            Method method = BizControlService.class.getMethod("getBizSearchControl", MapView.class);
            if (mapView != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                mapViewImpl = typeHelper != null ? (MapViewImpl) typeHelper.transfer(method, 0, mapView) : null;
                if (mapViewImpl == null) {
                    DebugTool.e("%s: $pMapView == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControlService.25
                    }));
                    return null;
                }
            } else {
                mapViewImpl = null;
            }
            IBizControlService iBizControlService = this.mControl;
            if (iBizControlService != null && (bizSearchControl = iBizControlService.getBizSearchControl(mapViewImpl)) != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r0 = typeHelper2 != null ? (BizSearchControl) typeHelper2.transfer(method, -1, (Object) bizSearchControl, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControlService.26
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizGuideEagleEyeControl getBizGuideEagleEyeControl(@EGLDeviceID.EGLDeviceID1 int i) {
        IBizGuideEagleEyeControl bizGuideEagleEyeControl;
        try {
            Method method = BizControlService.class.getMethod("getBizGuideEagleEyeControl", Integer.TYPE);
            IBizControlService iBizControlService = this.mControl;
            if (iBizControlService != null && (bizGuideEagleEyeControl = iBizControlService.getBizGuideEagleEyeControl(i)) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (BizGuideEagleEyeControl) typeHelper.transfer(method, -1, (Object) bizGuideEagleEyeControl, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControlService.27
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizCustomControl getBizCustomControl(MapView mapView) {
        MapViewImpl mapViewImpl;
        IBizCustomControl bizCustomControl;
        try {
            Method method = BizControlService.class.getMethod("getBizCustomControl", MapView.class);
            if (mapView != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                mapViewImpl = typeHelper != null ? (MapViewImpl) typeHelper.transfer(method, 0, mapView) : null;
                if (mapViewImpl == null) {
                    DebugTool.e("%s: $pMapView == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControlService.28
                    }));
                    return null;
                }
            } else {
                mapViewImpl = null;
            }
            IBizControlService iBizControlService = this.mControl;
            if (iBizControlService != null && (bizCustomControl = iBizControlService.getBizCustomControl(mapViewImpl)) != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r0 = typeHelper2 != null ? (BizCustomControl) typeHelper2.transfer(method, -1, (Object) bizCustomControl, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControlService.29
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControlService.30
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    protected void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControlService.31
        }));
    }

    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.layer.BizControlService.32
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
        unbind();
    }
}
