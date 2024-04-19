package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.card.impl.ICardServiceImpl;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.layer.BizControlService;
import com.autonavi.gbl.layer.model.BizMode;
import com.autonavi.gbl.layer.model.InnerStyleParam;
import com.autonavi.gbl.layer.model.MapPostureControlParam;
import com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl;
import com.autonavi.gbl.map.impl.MapViewImpl;
import com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl;
import com.autonavi.gbl.map.model.EGLDeviceID;
import com.autonavi.gbl.map.model.MapEngineID;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.servicemanager.model.BusBusinessType;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.util.ArrayList;
@IntfAuto(target = BizControlService.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IBizControlService implements IService {
    private static BindTable BIND_TABLE = new BindTable(IBizControlService.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void destroyNativeObj(long j);

    private static native void enableAllVirtualBusesNative(long j, IBizControlService iBizControlService, int i, boolean z);

    private static native void enableVirtualBusNative(long j, IBizControlService iBizControlService, int i, int i2, boolean z);

    private static native long getBizAGroupControlNative(long j, IBizControlService iBizControlService, long j2, MapViewImpl mapViewImpl);

    private static native long getBizAreaControlNative(long j, IBizControlService iBizControlService, long j2, MapViewImpl mapViewImpl);

    private static native long getBizCarControlNative(long j, IBizControlService iBizControlService, long j2, MapViewImpl mapViewImpl);

    private static native long getBizCustomControlNative(long j, IBizControlService iBizControlService, long j2, MapViewImpl mapViewImpl);

    private static native long getBizFlyLineControlNative(long j, IBizControlService iBizControlService, long j2, MapViewImpl mapViewImpl);

    private static native long getBizGuideEagleEyeControlNative(long j, IBizControlService iBizControlService, int i);

    private static native long getBizGuideRouteControlNative(long j, IBizControlService iBizControlService, long j2, MapViewImpl mapViewImpl);

    private static native long getBizLabelControlNative(long j, IBizControlService iBizControlService, long j2, MapViewImpl mapViewImpl);

    private static native long getBizLaneControlNative(long j, IBizControlService iBizControlService, long j2, MapViewImpl mapViewImpl);

    private static native long getBizRoadCrossControlNative(long j, IBizControlService iBizControlService, long j2, MapViewImpl mapViewImpl);

    private static native long getBizRoadFacilityControlNative(long j, IBizControlService iBizControlService, long j2, MapViewImpl mapViewImpl);

    private static native long getBizSearchControlNative(long j, IBizControlService iBizControlService, long j2, MapViewImpl mapViewImpl);

    private static native long getBizUserControlNative(long j, IBizControlService iBizControlService, long j2, MapViewImpl mapViewImpl);

    private static native boolean getVisibleNative(long j, IBizControlService iBizControlService, long j2, MapViewImpl mapViewImpl, int i);

    private static native boolean initCollisionConfigNative(long j, IBizControlService iBizControlService, long j2, MapViewImpl mapViewImpl, String str);

    private static native boolean initInnerStyleNative(long j, IBizControlService iBizControlService, long j2, MapViewImpl mapViewImpl, long j3, ICardServiceImpl iCardServiceImpl, long j4, IPrepareLayerParamImpl iPrepareLayerParamImpl, long j5, InnerStyleParam innerStyleParam);

    private static native boolean initNative(long j, IBizControlService iBizControlService, int i, String str);

    private static native boolean isInit1Native(long j, IBizControlService iBizControlService, int i);

    private static native int isInitNative(long j, IBizControlService iBizControlService);

    private static native boolean isVirtualBusEnableNative(long j, IBizControlService iBizControlService, int i, int i2);

    private static native void lockMapPostureNative(long j, IBizControlService iBizControlService, int i, long j2, MapPostureControlParam mapPostureControlParam);

    private static native void restoreVisibleNative(long j, IBizControlService iBizControlService, long j2, MapViewImpl mapViewImpl);

    private static native void saveVisibleNative(long j, IBizControlService iBizControlService, long j2, MapViewImpl mapViewImpl);

    private static native boolean setBizModeNative(long j, IBizControlService iBizControlService, int i, int i2);

    private static native void setStyleNative(long j, IBizControlService iBizControlService, int i, long j2, IPrepareLayerStyleImpl iPrepareLayerStyleImpl);

    private static native void setUICollisionRectsNative(long j, IBizControlService iBizControlService, long j2, MapViewImpl mapViewImpl, ArrayList<RectDouble> arrayList);

    private static native void setVisibleNative(long j, IBizControlService iBizControlService, long j2, MapViewImpl mapViewImpl, boolean z, ArrayList<Integer> arrayList);

    private static native void unInit1Native(long j, IBizControlService iBizControlService, int i);

    private static native void unInitNative(long j, IBizControlService iBizControlService);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected IBizControlService(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IBizControlService) && getUID(this) == getUID((IBizControlService) obj);
    }

    private static long getUID(IBizControlService iBizControlService) {
        long cPtr = getCPtr(iBizControlService);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IBizControlService iBizControlService) {
        if (iBizControlService == null) {
            return 0L;
        }
        return iBizControlService.swigCPtr;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        return this.swigCPtr;
    }

    protected synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean init(@MapEngineID.MapEngineID1 int i, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initNative(j, this, i, str);
    }

    public void unInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        unInitNative(j, this);
    }

    public void unInit(@MapEngineID.MapEngineID1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        unInit1Native(j, this, i);
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isInitNative(j, this);
    }

    public boolean isInit(@MapEngineID.MapEngineID1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isInit1Native(j, this, i);
    }

    public boolean initInnerStyle(MapViewImpl mapViewImpl, ICardServiceImpl iCardServiceImpl, IPrepareLayerParamImpl iPrepareLayerParamImpl, InnerStyleParam innerStyleParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initInnerStyleNative(j, this, MapViewImpl.getCPtr(mapViewImpl), mapViewImpl, ICardServiceImpl.getCPtr(iCardServiceImpl), iCardServiceImpl, IPrepareLayerParamImpl.getCPtr(iPrepareLayerParamImpl), iPrepareLayerParamImpl, 0L, innerStyleParam);
    }

    public void setStyle(@MapEngineID.MapEngineID1 int i, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setStyleNative(j, this, i, IPrepareLayerStyleImpl.getCPtr(iPrepareLayerStyleImpl), iPrepareLayerStyleImpl);
    }

    public void lockMapPosture(@MapEngineID.MapEngineID1 int i, MapPostureControlParam mapPostureControlParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        lockMapPostureNative(j, this, i, 0L, mapPostureControlParam);
    }

    public void setVisible(MapViewImpl mapViewImpl, boolean z, ArrayList<Integer> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setVisibleNative(j, this, MapViewImpl.getCPtr(mapViewImpl), mapViewImpl, z, arrayList);
    }

    public boolean getVisible(MapViewImpl mapViewImpl, int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getVisibleNative(j, this, MapViewImpl.getCPtr(mapViewImpl), mapViewImpl, i);
    }

    public void saveVisible(MapViewImpl mapViewImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        saveVisibleNative(j, this, MapViewImpl.getCPtr(mapViewImpl), mapViewImpl);
    }

    public void restoreVisible(MapViewImpl mapViewImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        restoreVisibleNative(j, this, MapViewImpl.getCPtr(mapViewImpl), mapViewImpl);
    }

    public boolean initCollisionConfig(MapViewImpl mapViewImpl, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initCollisionConfigNative(j, this, MapViewImpl.getCPtr(mapViewImpl), mapViewImpl, str);
    }

    public void setUICollisionRects(MapViewImpl mapViewImpl, ArrayList<RectDouble> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setUICollisionRectsNative(j, this, MapViewImpl.getCPtr(mapViewImpl), mapViewImpl, arrayList);
    }

    public void enableVirtualBus(@MapEngineID.MapEngineID1 int i, @BusBusinessType.BusBusinessType1 int i2, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        enableVirtualBusNative(j, this, i, i2, z);
    }

    public void enableAllVirtualBuses(@MapEngineID.MapEngineID1 int i, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        enableAllVirtualBusesNative(j, this, i, z);
    }

    public boolean isVirtualBusEnable(@MapEngineID.MapEngineID1 int i, @BusBusinessType.BusBusinessType1 int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isVirtualBusEnableNative(j, this, i, i2);
    }

    public boolean setBizMode(@MapEngineID.MapEngineID1 int i, @BizMode.BizMode1 int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setBizModeNative(j, this, i, i2);
    }

    public IBizRoadFacilityControl getBizRoadFacilityControl(MapViewImpl mapViewImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizRoadFacilityControlNative = getBizRoadFacilityControlNative(j, this, MapViewImpl.getCPtr(mapViewImpl), mapViewImpl);
        if (bizRoadFacilityControlNative == 0) {
            return null;
        }
        return new IBizRoadFacilityControl(bizRoadFacilityControlNative, false);
    }

    public IBizLabelControl getBizLabelControl(MapViewImpl mapViewImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizLabelControlNative = getBizLabelControlNative(j, this, MapViewImpl.getCPtr(mapViewImpl), mapViewImpl);
        if (bizLabelControlNative == 0) {
            return null;
        }
        return new IBizLabelControl(bizLabelControlNative, false);
    }

    public IBizRoadCrossControl getBizRoadCrossControl(MapViewImpl mapViewImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizRoadCrossControlNative = getBizRoadCrossControlNative(j, this, MapViewImpl.getCPtr(mapViewImpl), mapViewImpl);
        if (bizRoadCrossControlNative == 0) {
            return null;
        }
        return new IBizRoadCrossControl(bizRoadCrossControlNative, false);
    }

    public IBizUserControl getBizUserControl(MapViewImpl mapViewImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizUserControlNative = getBizUserControlNative(j, this, MapViewImpl.getCPtr(mapViewImpl), mapViewImpl);
        if (bizUserControlNative == 0) {
            return null;
        }
        return new IBizUserControl(bizUserControlNative, false);
    }

    public IBizGuideRouteControl getBizGuideRouteControl(MapViewImpl mapViewImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizGuideRouteControlNative = getBizGuideRouteControlNative(j, this, MapViewImpl.getCPtr(mapViewImpl), mapViewImpl);
        if (bizGuideRouteControlNative == 0) {
            return null;
        }
        return new IBizGuideRouteControl(bizGuideRouteControlNative, false);
    }

    public IBizCarControl getBizCarControl(MapViewImpl mapViewImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizCarControlNative = getBizCarControlNative(j, this, MapViewImpl.getCPtr(mapViewImpl), mapViewImpl);
        if (bizCarControlNative == 0) {
            return null;
        }
        return new IBizCarControl(bizCarControlNative, false);
    }

    public IBizFlyLineControlImpl getBizFlyLineControl(MapViewImpl mapViewImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizFlyLineControlNative = getBizFlyLineControlNative(j, this, MapViewImpl.getCPtr(mapViewImpl), mapViewImpl);
        if (bizFlyLineControlNative == 0) {
            return null;
        }
        return new IBizFlyLineControlImpl(bizFlyLineControlNative, false);
    }

    public IBizAGroupControl getBizAGroupControl(MapViewImpl mapViewImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizAGroupControlNative = getBizAGroupControlNative(j, this, MapViewImpl.getCPtr(mapViewImpl), mapViewImpl);
        if (bizAGroupControlNative == 0) {
            return null;
        }
        return new IBizAGroupControl(bizAGroupControlNative, false);
    }

    public IBizAreaControl getBizAreaControl(MapViewImpl mapViewImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizAreaControlNative = getBizAreaControlNative(j, this, MapViewImpl.getCPtr(mapViewImpl), mapViewImpl);
        if (bizAreaControlNative == 0) {
            return null;
        }
        return new IBizAreaControl(bizAreaControlNative, false);
    }

    public IBizSearchControl getBizSearchControl(MapViewImpl mapViewImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizSearchControlNative = getBizSearchControlNative(j, this, MapViewImpl.getCPtr(mapViewImpl), mapViewImpl);
        if (bizSearchControlNative == 0) {
            return null;
        }
        return new IBizSearchControl(bizSearchControlNative, false);
    }

    public IBizGuideEagleEyeControl getBizGuideEagleEyeControl(@EGLDeviceID.EGLDeviceID1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizGuideEagleEyeControlNative = getBizGuideEagleEyeControlNative(j, this, i);
        if (bizGuideEagleEyeControlNative == 0) {
            return null;
        }
        return new IBizGuideEagleEyeControl(bizGuideEagleEyeControlNative, false);
    }

    public IBizLaneControlImpl getBizLaneControl(MapViewImpl mapViewImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizLaneControlNative = getBizLaneControlNative(j, this, MapViewImpl.getCPtr(mapViewImpl), mapViewImpl);
        if (bizLaneControlNative == 0) {
            return null;
        }
        return new IBizLaneControlImpl(bizLaneControlNative, false);
    }

    public IBizCustomControl getBizCustomControl(MapViewImpl mapViewImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizCustomControlNative = getBizCustomControlNative(j, this, MapViewImpl.getCPtr(mapViewImpl), mapViewImpl);
        if (bizCustomControlNative == 0) {
            return null;
        }
        return new IBizCustomControl(bizCustomControlNative, false);
    }
}
