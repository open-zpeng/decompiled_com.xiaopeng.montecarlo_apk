package com.autonavi.gbl.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.card.CardService;
import com.autonavi.gbl.card.impl.ICardServiceImpl;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.layer.impl.IBizAGroupControlImpl;
import com.autonavi.gbl.layer.impl.IBizAreaControlImpl;
import com.autonavi.gbl.layer.impl.IBizCarControlImpl;
import com.autonavi.gbl.layer.impl.IBizControlServiceImpl;
import com.autonavi.gbl.layer.impl.IBizCustomControlImpl;
import com.autonavi.gbl.layer.impl.IBizDynamicControlImpl;
import com.autonavi.gbl.layer.impl.IBizFlyLineControlImpl;
import com.autonavi.gbl.layer.impl.IBizGuideEagleEyeControlImpl;
import com.autonavi.gbl.layer.impl.IBizGuideRouteControlImpl;
import com.autonavi.gbl.layer.impl.IBizLabelControlImpl;
import com.autonavi.gbl.layer.impl.IBizLaneControlImpl;
import com.autonavi.gbl.layer.impl.IBizRoadCrossControlImpl;
import com.autonavi.gbl.layer.impl.IBizRoadFacilityControlImpl;
import com.autonavi.gbl.layer.impl.IBizSearchControlImpl;
import com.autonavi.gbl.layer.impl.IBizUserControlImpl;
import com.autonavi.gbl.layer.model.BizMode;
import com.autonavi.gbl.layer.model.DynamicControlType;
import com.autonavi.gbl.layer.model.InnerStyleParam;
import com.autonavi.gbl.layer.model.MapPostureControlParam;
import com.autonavi.gbl.layer.observer.PrepareLayerParam;
import com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.impl.IMapViewImpl;
import com.autonavi.gbl.map.layer.model.UIRectRecord;
import com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle;
import com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl;
import com.autonavi.gbl.map.model.EGLDeviceID;
import com.autonavi.gbl.map.model.MapEngineID;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.servicemanager.model.BusBusinessType;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = IBizControlServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BizControlService implements IService {
    private static String PACKAGE = ReflexTool.PN(BizControlService.class);
    private IBizControlServiceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected BizControlService(long j, boolean z) {
        this((IBizControlServiceImpl) ReflexTool.invokeDeclConstructorSafe(IBizControlServiceImpl.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizControlService.class, this, this.mControl);
        }
    }

    public BizControlService(IBizControlServiceImpl iBizControlServiceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iBizControlServiceImpl);
    }

    private void $constructor(IBizControlServiceImpl iBizControlServiceImpl) {
        if (iBizControlServiceImpl != null) {
            this.mControl = iBizControlServiceImpl;
            this.mTargetId = String.format("BizControlService_%s_%d", String.valueOf(IBizControlServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IBizControlServiceImpl getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
        if (iBizControlServiceImpl != null) {
            return iBizControlServiceImpl.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
        if (iBizControlServiceImpl != null) {
            return iBizControlServiceImpl.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
        if (iBizControlServiceImpl != null) {
            iBizControlServiceImpl.onCreate();
        }
    }

    public boolean init(@MapEngineID.MapEngineID1 int i, String str) {
        IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
        if (iBizControlServiceImpl != null) {
            return iBizControlServiceImpl.init(i, str);
        }
        return false;
    }

    public void unInit() {
        IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
        if (iBizControlServiceImpl != null) {
            iBizControlServiceImpl.unInit();
        }
    }

    public void unInit(@MapEngineID.MapEngineID1 int i) {
        IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
        if (iBizControlServiceImpl != null) {
            iBizControlServiceImpl.unInit(i);
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
        if (iBizControlServiceImpl != null) {
            return iBizControlServiceImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public boolean isInit(@MapEngineID.MapEngineID1 int i) {
        IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
        if (iBizControlServiceImpl != null) {
            return iBizControlServiceImpl.isInit(i);
        }
        return false;
    }

    public boolean initInnerStyle(MapView mapView, CardService cardService, PrepareLayerParam prepareLayerParam, InnerStyleParam innerStyleParam) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        TypeHelper typeHelper3;
        try {
            Method method = BizControlService.class.getMethod("initInnerStyle", MapView.class, CardService.class, PrepareLayerParam.class, InnerStyleParam.class);
            IPrepareLayerParamImpl iPrepareLayerParamImpl = null;
            IMapViewImpl iMapViewImpl = (mapView == null || (typeHelper3 = this.mTypeHelper) == null) ? null : (IMapViewImpl) typeHelper3.transfer(method, 0, mapView);
            ICardServiceImpl iCardServiceImpl = (cardService == null || (typeHelper2 = this.mTypeHelper) == null) ? null : (ICardServiceImpl) typeHelper2.transfer(method, 1, cardService);
            if (prepareLayerParam != null && (typeHelper = this.mTypeHelper) != null) {
                iPrepareLayerParamImpl = (IPrepareLayerParamImpl) typeHelper.transfer(method, 2, prepareLayerParam);
            }
            IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
            if (iBizControlServiceImpl != null) {
                return iBizControlServiceImpl.initInnerStyle(iMapViewImpl, iCardServiceImpl, iPrepareLayerParamImpl, innerStyleParam);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public void setStyle(@MapEngineID.MapEngineID1 int i, IPrepareLayerStyle iPrepareLayerStyle) {
        TypeHelper typeHelper;
        try {
            Method method = BizControlService.class.getMethod("setStyle", Integer.TYPE, IPrepareLayerStyle.class);
            IPrepareLayerStyleImpl iPrepareLayerStyleImpl = null;
            if (iPrepareLayerStyle != null && (typeHelper = this.mTypeHelper) != null) {
                iPrepareLayerStyleImpl = (IPrepareLayerStyleImpl) typeHelper.transfer(method, 1, iPrepareLayerStyle);
            }
            IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
            if (iBizControlServiceImpl != null) {
                iBizControlServiceImpl.setStyle(i, iPrepareLayerStyleImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public IPrepareLayerStyle getStyle(@MapEngineID.MapEngineID1 int i) {
        IPrepareLayerStyleImpl style;
        TypeHelper typeHelper;
        try {
            Method method = BizControlService.class.getMethod("getStyle", Integer.TYPE);
            IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
            if (iBizControlServiceImpl == null || (style = iBizControlServiceImpl.getStyle(i)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (IPrepareLayerStyle) typeHelper.transfer(method, -1, (Object) style, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void lockMapPosture(@MapEngineID.MapEngineID1 int i, MapPostureControlParam mapPostureControlParam) {
        IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
        if (iBizControlServiceImpl != null) {
            iBizControlServiceImpl.lockMapPosture(i, mapPostureControlParam);
        }
    }

    public void setVisible(MapView mapView, boolean z, ArrayList<Integer> arrayList) {
        TypeHelper typeHelper;
        try {
            Method method = BizControlService.class.getMethod("setVisible", MapView.class, Boolean.TYPE, ArrayList.class);
            IMapViewImpl iMapViewImpl = null;
            if (mapView != null && (typeHelper = this.mTypeHelper) != null) {
                iMapViewImpl = (IMapViewImpl) typeHelper.transfer(method, 0, mapView);
            }
            IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
            if (iBizControlServiceImpl != null) {
                iBizControlServiceImpl.setVisible(iMapViewImpl, z, arrayList);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public boolean getVisible(MapView mapView, int i) {
        TypeHelper typeHelper;
        try {
            Method method = BizControlService.class.getMethod("getVisible", MapView.class, Integer.TYPE);
            IMapViewImpl iMapViewImpl = null;
            if (mapView != null && (typeHelper = this.mTypeHelper) != null) {
                iMapViewImpl = (IMapViewImpl) typeHelper.transfer(method, 0, mapView);
            }
            IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
            if (iBizControlServiceImpl != null) {
                return iBizControlServiceImpl.getVisible(iMapViewImpl, i);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public void saveVisible(MapView mapView) {
        TypeHelper typeHelper;
        try {
            Method method = BizControlService.class.getMethod("saveVisible", MapView.class);
            IMapViewImpl iMapViewImpl = null;
            if (mapView != null && (typeHelper = this.mTypeHelper) != null) {
                iMapViewImpl = (IMapViewImpl) typeHelper.transfer(method, 0, mapView);
            }
            IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
            if (iBizControlServiceImpl != null) {
                iBizControlServiceImpl.saveVisible(iMapViewImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void restoreVisible(MapView mapView) {
        TypeHelper typeHelper;
        try {
            Method method = BizControlService.class.getMethod("restoreVisible", MapView.class);
            IMapViewImpl iMapViewImpl = null;
            if (mapView != null && (typeHelper = this.mTypeHelper) != null) {
                iMapViewImpl = (IMapViewImpl) typeHelper.transfer(method, 0, mapView);
            }
            IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
            if (iBizControlServiceImpl != null) {
                iBizControlServiceImpl.restoreVisible(iMapViewImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public boolean initCollisionConfig(MapView mapView, String str) {
        TypeHelper typeHelper;
        try {
            Method method = BizControlService.class.getMethod("initCollisionConfig", MapView.class, String.class);
            IMapViewImpl iMapViewImpl = null;
            if (mapView != null && (typeHelper = this.mTypeHelper) != null) {
                iMapViewImpl = (IMapViewImpl) typeHelper.transfer(method, 0, mapView);
            }
            IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
            if (iBizControlServiceImpl != null) {
                return iBizControlServiceImpl.initCollisionConfig(iMapViewImpl, str);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public void setUICollisionRects(MapView mapView, ArrayList<RectDouble> arrayList) {
        TypeHelper typeHelper;
        try {
            Method method = BizControlService.class.getMethod("setUICollisionRects", MapView.class, ArrayList.class);
            IMapViewImpl iMapViewImpl = null;
            if (mapView != null && (typeHelper = this.mTypeHelper) != null) {
                iMapViewImpl = (IMapViewImpl) typeHelper.transfer(method, 0, mapView);
            }
            IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
            if (iBizControlServiceImpl != null) {
                iBizControlServiceImpl.setUICollisionRects(iMapViewImpl, arrayList);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void setUITypeCollisionRect(MapView mapView, ArrayList<UIRectRecord> arrayList) {
        TypeHelper typeHelper;
        try {
            Method method = BizControlService.class.getMethod("setUITypeCollisionRect", MapView.class, ArrayList.class);
            IMapViewImpl iMapViewImpl = null;
            if (mapView != null && (typeHelper = this.mTypeHelper) != null) {
                iMapViewImpl = (IMapViewImpl) typeHelper.transfer(method, 0, mapView);
            }
            IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
            if (iBizControlServiceImpl != null) {
                iBizControlServiceImpl.setUITypeCollisionRect(iMapViewImpl, arrayList);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void enableVirtualBus(@MapEngineID.MapEngineID1 int i, @BusBusinessType.BusBusinessType1 int i2, boolean z) {
        IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
        if (iBizControlServiceImpl != null) {
            iBizControlServiceImpl.enableVirtualBus(i, i2, z);
        }
    }

    public void enableAllVirtualBuses(@MapEngineID.MapEngineID1 int i, boolean z) {
        IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
        if (iBizControlServiceImpl != null) {
            iBizControlServiceImpl.enableAllVirtualBuses(i, z);
        }
    }

    public boolean isVirtualBusEnable(@MapEngineID.MapEngineID1 int i, @BusBusinessType.BusBusinessType1 int i2) {
        IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
        if (iBizControlServiceImpl != null) {
            return iBizControlServiceImpl.isVirtualBusEnable(i, i2);
        }
        return false;
    }

    public boolean setBizMode(@MapEngineID.MapEngineID1 int i, @BizMode.BizMode1 int i2) {
        IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
        if (iBizControlServiceImpl != null) {
            return iBizControlServiceImpl.setBizMode(i, i2);
        }
        return false;
    }

    public BizRoadFacilityControl getBizRoadFacilityControl(MapView mapView) {
        IBizRoadFacilityControlImpl bizRoadFacilityControl;
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = BizControlService.class.getMethod("getBizRoadFacilityControl", MapView.class);
            IMapViewImpl iMapViewImpl = (mapView == null || (typeHelper2 = this.mTypeHelper) == null) ? null : (IMapViewImpl) typeHelper2.transfer(method, 0, mapView);
            IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
            if (iBizControlServiceImpl == null || (bizRoadFacilityControl = iBizControlServiceImpl.getBizRoadFacilityControl(iMapViewImpl)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (BizRoadFacilityControl) typeHelper.transfer(method, -1, (Object) bizRoadFacilityControl, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizLabelControl getBizLabelControl(MapView mapView) {
        IBizLabelControlImpl bizLabelControl;
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = BizControlService.class.getMethod("getBizLabelControl", MapView.class);
            IMapViewImpl iMapViewImpl = (mapView == null || (typeHelper2 = this.mTypeHelper) == null) ? null : (IMapViewImpl) typeHelper2.transfer(method, 0, mapView);
            IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
            if (iBizControlServiceImpl == null || (bizLabelControl = iBizControlServiceImpl.getBizLabelControl(iMapViewImpl)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (BizLabelControl) typeHelper.transfer(method, -1, (Object) bizLabelControl, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizRoadCrossControl getBizRoadCrossControl(MapView mapView) {
        IBizRoadCrossControlImpl bizRoadCrossControl;
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = BizControlService.class.getMethod("getBizRoadCrossControl", MapView.class);
            IMapViewImpl iMapViewImpl = (mapView == null || (typeHelper2 = this.mTypeHelper) == null) ? null : (IMapViewImpl) typeHelper2.transfer(method, 0, mapView);
            IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
            if (iBizControlServiceImpl == null || (bizRoadCrossControl = iBizControlServiceImpl.getBizRoadCrossControl(iMapViewImpl)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (BizRoadCrossControl) typeHelper.transfer(method, -1, (Object) bizRoadCrossControl, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizUserControl getBizUserControl(MapView mapView) {
        IBizUserControlImpl bizUserControl;
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = BizControlService.class.getMethod("getBizUserControl", MapView.class);
            IMapViewImpl iMapViewImpl = (mapView == null || (typeHelper2 = this.mTypeHelper) == null) ? null : (IMapViewImpl) typeHelper2.transfer(method, 0, mapView);
            IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
            if (iBizControlServiceImpl == null || (bizUserControl = iBizControlServiceImpl.getBizUserControl(iMapViewImpl)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (BizUserControl) typeHelper.transfer(method, -1, (Object) bizUserControl, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizGuideRouteControl getBizGuideRouteControl(MapView mapView) {
        IBizGuideRouteControlImpl bizGuideRouteControl;
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = BizControlService.class.getMethod("getBizGuideRouteControl", MapView.class);
            IMapViewImpl iMapViewImpl = (mapView == null || (typeHelper2 = this.mTypeHelper) == null) ? null : (IMapViewImpl) typeHelper2.transfer(method, 0, mapView);
            IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
            if (iBizControlServiceImpl == null || (bizGuideRouteControl = iBizControlServiceImpl.getBizGuideRouteControl(iMapViewImpl)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (BizGuideRouteControl) typeHelper.transfer(method, -1, (Object) bizGuideRouteControl, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizCarControl getBizCarControl(MapView mapView) {
        IBizCarControlImpl bizCarControl;
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = BizControlService.class.getMethod("getBizCarControl", MapView.class);
            IMapViewImpl iMapViewImpl = (mapView == null || (typeHelper2 = this.mTypeHelper) == null) ? null : (IMapViewImpl) typeHelper2.transfer(method, 0, mapView);
            IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
            if (iBizControlServiceImpl == null || (bizCarControl = iBizControlServiceImpl.getBizCarControl(iMapViewImpl)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (BizCarControl) typeHelper.transfer(method, -1, (Object) bizCarControl, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizFlyLineControl getBizFlyLineControl(MapView mapView) {
        IBizFlyLineControlImpl bizFlyLineControl;
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = BizControlService.class.getMethod("getBizFlyLineControl", MapView.class);
            IMapViewImpl iMapViewImpl = (mapView == null || (typeHelper2 = this.mTypeHelper) == null) ? null : (IMapViewImpl) typeHelper2.transfer(method, 0, mapView);
            IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
            if (iBizControlServiceImpl == null || (bizFlyLineControl = iBizControlServiceImpl.getBizFlyLineControl(iMapViewImpl)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (BizFlyLineControl) typeHelper.transfer(method, -1, (Object) bizFlyLineControl, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizAGroupControl getBizAGroupControl(MapView mapView) {
        IBizAGroupControlImpl bizAGroupControl;
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = BizControlService.class.getMethod("getBizAGroupControl", MapView.class);
            IMapViewImpl iMapViewImpl = (mapView == null || (typeHelper2 = this.mTypeHelper) == null) ? null : (IMapViewImpl) typeHelper2.transfer(method, 0, mapView);
            IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
            if (iBizControlServiceImpl == null || (bizAGroupControl = iBizControlServiceImpl.getBizAGroupControl(iMapViewImpl)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (BizAGroupControl) typeHelper.transfer(method, -1, (Object) bizAGroupControl, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizAreaControl getBizAreaControl(MapView mapView) {
        IBizAreaControlImpl bizAreaControl;
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = BizControlService.class.getMethod("getBizAreaControl", MapView.class);
            IMapViewImpl iMapViewImpl = (mapView == null || (typeHelper2 = this.mTypeHelper) == null) ? null : (IMapViewImpl) typeHelper2.transfer(method, 0, mapView);
            IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
            if (iBizControlServiceImpl == null || (bizAreaControl = iBizControlServiceImpl.getBizAreaControl(iMapViewImpl)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (BizAreaControl) typeHelper.transfer(method, -1, (Object) bizAreaControl, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizSearchControl getBizSearchControl(MapView mapView) {
        IBizSearchControlImpl bizSearchControl;
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = BizControlService.class.getMethod("getBizSearchControl", MapView.class);
            IMapViewImpl iMapViewImpl = (mapView == null || (typeHelper2 = this.mTypeHelper) == null) ? null : (IMapViewImpl) typeHelper2.transfer(method, 0, mapView);
            IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
            if (iBizControlServiceImpl == null || (bizSearchControl = iBizControlServiceImpl.getBizSearchControl(iMapViewImpl)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (BizSearchControl) typeHelper.transfer(method, -1, (Object) bizSearchControl, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizGuideEagleEyeControl getBizGuideEagleEyeControl(@EGLDeviceID.EGLDeviceID1 int i) {
        IBizGuideEagleEyeControlImpl bizGuideEagleEyeControl;
        TypeHelper typeHelper;
        try {
            Method method = BizControlService.class.getMethod("getBizGuideEagleEyeControl", Integer.TYPE);
            IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
            if (iBizControlServiceImpl == null || (bizGuideEagleEyeControl = iBizControlServiceImpl.getBizGuideEagleEyeControl(i)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (BizGuideEagleEyeControl) typeHelper.transfer(method, -1, (Object) bizGuideEagleEyeControl, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizLaneControl getBizLaneControl(MapView mapView) {
        IBizLaneControlImpl bizLaneControl;
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = BizControlService.class.getMethod("getBizLaneControl", MapView.class);
            IMapViewImpl iMapViewImpl = (mapView == null || (typeHelper2 = this.mTypeHelper) == null) ? null : (IMapViewImpl) typeHelper2.transfer(method, 0, mapView);
            IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
            if (iBizControlServiceImpl == null || (bizLaneControl = iBizControlServiceImpl.getBizLaneControl(iMapViewImpl)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (BizLaneControl) typeHelper.transfer(method, -1, (Object) bizLaneControl, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizCustomControl getBizCustomControl(MapView mapView) {
        IBizCustomControlImpl bizCustomControl;
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = BizControlService.class.getMethod("getBizCustomControl", MapView.class);
            IMapViewImpl iMapViewImpl = (mapView == null || (typeHelper2 = this.mTypeHelper) == null) ? null : (IMapViewImpl) typeHelper2.transfer(method, 0, mapView);
            IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
            if (iBizControlServiceImpl == null || (bizCustomControl = iBizControlServiceImpl.getBizCustomControl(iMapViewImpl)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (BizCustomControl) typeHelper.transfer(method, -1, (Object) bizCustomControl, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizDynamicControl getBizDynamicControl(MapView mapView) {
        IBizDynamicControlImpl bizDynamicControl;
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = BizControlService.class.getMethod("getBizDynamicControl", MapView.class);
            IMapViewImpl iMapViewImpl = (mapView == null || (typeHelper2 = this.mTypeHelper) == null) ? null : (IMapViewImpl) typeHelper2.transfer(method, 0, mapView);
            IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
            if (iBizControlServiceImpl == null || (bizDynamicControl = iBizControlServiceImpl.getBizDynamicControl(iMapViewImpl)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (BizDynamicControl) typeHelper.transfer(method, -1, (Object) bizDynamicControl, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizDynamicControl getBizDynamicControl(MapView mapView, @DynamicControlType.DynamicControlType1 int i) {
        IBizDynamicControlImpl bizDynamicControl;
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = BizControlService.class.getMethod("getBizDynamicControl", MapView.class, Integer.TYPE);
            IMapViewImpl iMapViewImpl = (mapView == null || (typeHelper2 = this.mTypeHelper) == null) ? null : (IMapViewImpl) typeHelper2.transfer(method, 0, mapView);
            IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
            if (iBizControlServiceImpl == null || (bizDynamicControl = iBizControlServiceImpl.getBizDynamicControl(iMapViewImpl, i)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (BizDynamicControl) typeHelper.transfer(method, -1, (Object) bizDynamicControl, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public String getBizNameByType(int i) {
        IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
        if (iBizControlServiceImpl != null) {
            return iBizControlServiceImpl.getBizNameByType(i);
        }
        return null;
    }

    public int getCollisionIntervalTime(@MapEngineID.MapEngineID1 int i) {
        IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
        if (iBizControlServiceImpl != null) {
            return iBizControlServiceImpl.getCollisionIntervalTime(i);
        }
        return 0;
    }

    public boolean setCollisionIntervalTime(@MapEngineID.MapEngineID1 int i, int i2) {
        IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
        if (iBizControlServiceImpl != null) {
            return iBizControlServiceImpl.setCollisionIntervalTime(i, i2);
        }
        return false;
    }

    public boolean switchStyle(MapView mapView, int i) {
        TypeHelper typeHelper;
        try {
            Method method = BizControlService.class.getMethod("switchStyle", MapView.class, Integer.TYPE);
            IMapViewImpl iMapViewImpl = null;
            if (mapView != null && (typeHelper = this.mTypeHelper) != null) {
                iMapViewImpl = (IMapViewImpl) typeHelper.transfer(method, 0, mapView);
            }
            IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
            if (iBizControlServiceImpl != null) {
                return iBizControlServiceImpl.switchStyle(iMapViewImpl, i);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public void updateAllStyle(MapView mapView) {
        TypeHelper typeHelper;
        try {
            Method method = BizControlService.class.getMethod("updateAllStyle", MapView.class);
            IMapViewImpl iMapViewImpl = null;
            if (mapView != null && (typeHelper = this.mTypeHelper) != null) {
                iMapViewImpl = (IMapViewImpl) typeHelper.transfer(method, 0, mapView);
            }
            IBizControlServiceImpl iBizControlServiceImpl = this.mControl;
            if (iBizControlServiceImpl != null) {
                iBizControlServiceImpl.updateAllStyle(iMapViewImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    protected void unbind() {
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
        unbind();
    }
}
