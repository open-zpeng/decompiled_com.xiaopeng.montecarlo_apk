package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.card.impl.ICardServiceImpl;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.layer.BizControlService;
import com.autonavi.gbl.layer.model.BizMode;
import com.autonavi.gbl.layer.model.DynamicControlType;
import com.autonavi.gbl.layer.model.InnerStyleParam;
import com.autonavi.gbl.layer.model.MapPostureControlParam;
import com.autonavi.gbl.layer.observer.impl.IPrepareLayerParamImpl;
import com.autonavi.gbl.map.impl.IMapViewImpl;
import com.autonavi.gbl.map.layer.model.UIRectRecord;
import com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl;
import com.autonavi.gbl.map.model.EGLDeviceID;
import com.autonavi.gbl.map.model.MapEngineID;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.servicemanager.model.BusBusinessType;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.util.ArrayList;
@IntfAuto(target = BizControlService.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IBizControlServiceImpl implements IService {
    private static BindTable BIND_TABLE = new BindTable(IBizControlServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void destroyNativeObj(long j);

    private static native void enableAllVirtualBusesNative(long j, IBizControlServiceImpl iBizControlServiceImpl, int i, boolean z);

    private static native void enableVirtualBusNative(long j, IBizControlServiceImpl iBizControlServiceImpl, int i, int i2, boolean z);

    private static native long getBizAGroupControlNative(long j, IBizControlServiceImpl iBizControlServiceImpl, long j2, IMapViewImpl iMapViewImpl);

    private static native long getBizAreaControlNative(long j, IBizControlServiceImpl iBizControlServiceImpl, long j2, IMapViewImpl iMapViewImpl);

    private static native long getBizCarControlNative(long j, IBizControlServiceImpl iBizControlServiceImpl, long j2, IMapViewImpl iMapViewImpl);

    private static native long getBizCustomControlNative(long j, IBizControlServiceImpl iBizControlServiceImpl, long j2, IMapViewImpl iMapViewImpl);

    private static native long getBizDynamicControl1Native(long j, IBizControlServiceImpl iBizControlServiceImpl, long j2, IMapViewImpl iMapViewImpl, int i);

    private static native long getBizDynamicControlNative(long j, IBizControlServiceImpl iBizControlServiceImpl, long j2, IMapViewImpl iMapViewImpl);

    private static native long getBizFlyLineControlNative(long j, IBizControlServiceImpl iBizControlServiceImpl, long j2, IMapViewImpl iMapViewImpl);

    private static native long getBizGuideEagleEyeControlNative(long j, IBizControlServiceImpl iBizControlServiceImpl, int i);

    private static native long getBizGuideRouteControlNative(long j, IBizControlServiceImpl iBizControlServiceImpl, long j2, IMapViewImpl iMapViewImpl);

    private static native long getBizLabelControlNative(long j, IBizControlServiceImpl iBizControlServiceImpl, long j2, IMapViewImpl iMapViewImpl);

    private static native long getBizLaneControlNative(long j, IBizControlServiceImpl iBizControlServiceImpl, long j2, IMapViewImpl iMapViewImpl);

    private static native String getBizNameByTypeNative(long j, IBizControlServiceImpl iBizControlServiceImpl, int i);

    private static native long getBizRoadCrossControlNative(long j, IBizControlServiceImpl iBizControlServiceImpl, long j2, IMapViewImpl iMapViewImpl);

    private static native long getBizRoadFacilityControlNative(long j, IBizControlServiceImpl iBizControlServiceImpl, long j2, IMapViewImpl iMapViewImpl);

    private static native long getBizSearchControlNative(long j, IBizControlServiceImpl iBizControlServiceImpl, long j2, IMapViewImpl iMapViewImpl);

    private static native long getBizUserControlNative(long j, IBizControlServiceImpl iBizControlServiceImpl, long j2, IMapViewImpl iMapViewImpl);

    private static native int getCollisionIntervalTimeNative(long j, IBizControlServiceImpl iBizControlServiceImpl, int i);

    private static native long getStyleNative(long j, IBizControlServiceImpl iBizControlServiceImpl, int i);

    private static native boolean getVisibleNative(long j, IBizControlServiceImpl iBizControlServiceImpl, long j2, IMapViewImpl iMapViewImpl, int i);

    private static native boolean initCollisionConfigNative(long j, IBizControlServiceImpl iBizControlServiceImpl, long j2, IMapViewImpl iMapViewImpl, String str);

    private static native boolean initInnerStyleNative(long j, IBizControlServiceImpl iBizControlServiceImpl, long j2, IMapViewImpl iMapViewImpl, long j3, ICardServiceImpl iCardServiceImpl, long j4, IPrepareLayerParamImpl iPrepareLayerParamImpl, long j5, InnerStyleParam innerStyleParam);

    private static native boolean initNative(long j, IBizControlServiceImpl iBizControlServiceImpl, int i, String str);

    private static native boolean isInit1Native(long j, IBizControlServiceImpl iBizControlServiceImpl, int i);

    private static native int isInitNative(long j, IBizControlServiceImpl iBizControlServiceImpl);

    private static native boolean isVirtualBusEnableNative(long j, IBizControlServiceImpl iBizControlServiceImpl, int i, int i2);

    private static native void lockMapPostureNative(long j, IBizControlServiceImpl iBizControlServiceImpl, int i, long j2, MapPostureControlParam mapPostureControlParam);

    private static native void restoreVisibleNative(long j, IBizControlServiceImpl iBizControlServiceImpl, long j2, IMapViewImpl iMapViewImpl);

    private static native void saveVisibleNative(long j, IBizControlServiceImpl iBizControlServiceImpl, long j2, IMapViewImpl iMapViewImpl);

    private static native boolean setBizModeNative(long j, IBizControlServiceImpl iBizControlServiceImpl, int i, int i2);

    private static native boolean setCollisionIntervalTimeNative(long j, IBizControlServiceImpl iBizControlServiceImpl, int i, int i2);

    private static native void setStyleNative(long j, IBizControlServiceImpl iBizControlServiceImpl, int i, long j2, IPrepareLayerStyleImpl iPrepareLayerStyleImpl);

    private static native void setUICollisionRectsNative(long j, IBizControlServiceImpl iBizControlServiceImpl, long j2, IMapViewImpl iMapViewImpl, ArrayList<RectDouble> arrayList);

    private static native void setUITypeCollisionRectNative(long j, IBizControlServiceImpl iBizControlServiceImpl, long j2, IMapViewImpl iMapViewImpl, ArrayList<UIRectRecord> arrayList);

    private static native void setVisibleNative(long j, IBizControlServiceImpl iBizControlServiceImpl, long j2, IMapViewImpl iMapViewImpl, boolean z, ArrayList<Integer> arrayList);

    private static native boolean switchStyleNative(long j, IBizControlServiceImpl iBizControlServiceImpl, long j2, IMapViewImpl iMapViewImpl, int i);

    private static native void unInit1Native(long j, IBizControlServiceImpl iBizControlServiceImpl, int i);

    private static native void unInitNative(long j, IBizControlServiceImpl iBizControlServiceImpl);

    private static native void updateAllStyleNative(long j, IBizControlServiceImpl iBizControlServiceImpl, long j2, IMapViewImpl iMapViewImpl);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected IBizControlServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IBizControlServiceImpl) && getUID(this) == getUID((IBizControlServiceImpl) obj);
    }

    private static long getUID(IBizControlServiceImpl iBizControlServiceImpl) {
        long cPtr = getCPtr(iBizControlServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IBizControlServiceImpl iBizControlServiceImpl) {
        if (iBizControlServiceImpl == null) {
            return 0L;
        }
        return iBizControlServiceImpl.swigCPtr;
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

    public boolean initInnerStyle(IMapViewImpl iMapViewImpl, ICardServiceImpl iCardServiceImpl, IPrepareLayerParamImpl iPrepareLayerParamImpl, InnerStyleParam innerStyleParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initInnerStyleNative(j, this, IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl, ICardServiceImpl.getCPtr(iCardServiceImpl), iCardServiceImpl, IPrepareLayerParamImpl.getCPtr(iPrepareLayerParamImpl), iPrepareLayerParamImpl, 0L, innerStyleParam);
    }

    public void setStyle(@MapEngineID.MapEngineID1 int i, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setStyleNative(j, this, i, IPrepareLayerStyleImpl.getCPtr(iPrepareLayerStyleImpl), iPrepareLayerStyleImpl);
    }

    public IPrepareLayerStyleImpl getStyle(@MapEngineID.MapEngineID1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long styleNative = getStyleNative(j, this, i);
        if (styleNative == 0) {
            return null;
        }
        return new IPrepareLayerStyleImpl(styleNative, false);
    }

    public void lockMapPosture(@MapEngineID.MapEngineID1 int i, MapPostureControlParam mapPostureControlParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        lockMapPostureNative(j, this, i, 0L, mapPostureControlParam);
    }

    public void setVisible(IMapViewImpl iMapViewImpl, boolean z, ArrayList<Integer> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setVisibleNative(j, this, IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl, z, arrayList);
    }

    public boolean getVisible(IMapViewImpl iMapViewImpl, int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getVisibleNative(j, this, IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl, i);
    }

    public void saveVisible(IMapViewImpl iMapViewImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        saveVisibleNative(j, this, IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl);
    }

    public void restoreVisible(IMapViewImpl iMapViewImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        restoreVisibleNative(j, this, IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl);
    }

    public boolean initCollisionConfig(IMapViewImpl iMapViewImpl, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initCollisionConfigNative(j, this, IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl, str);
    }

    public void setUICollisionRects(IMapViewImpl iMapViewImpl, ArrayList<RectDouble> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setUICollisionRectsNative(j, this, IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl, arrayList);
    }

    public void setUITypeCollisionRect(IMapViewImpl iMapViewImpl, ArrayList<UIRectRecord> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setUITypeCollisionRectNative(j, this, IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl, arrayList);
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

    public IBizRoadFacilityControlImpl getBizRoadFacilityControl(IMapViewImpl iMapViewImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizRoadFacilityControlNative = getBizRoadFacilityControlNative(j, this, IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl);
        if (bizRoadFacilityControlNative == 0) {
            return null;
        }
        return new IBizRoadFacilityControlImpl(bizRoadFacilityControlNative, false);
    }

    public IBizLabelControlImpl getBizLabelControl(IMapViewImpl iMapViewImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizLabelControlNative = getBizLabelControlNative(j, this, IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl);
        if (bizLabelControlNative == 0) {
            return null;
        }
        return new IBizLabelControlImpl(bizLabelControlNative, false);
    }

    public IBizRoadCrossControlImpl getBizRoadCrossControl(IMapViewImpl iMapViewImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizRoadCrossControlNative = getBizRoadCrossControlNative(j, this, IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl);
        if (bizRoadCrossControlNative == 0) {
            return null;
        }
        return new IBizRoadCrossControlImpl(bizRoadCrossControlNative, false);
    }

    public IBizUserControlImpl getBizUserControl(IMapViewImpl iMapViewImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizUserControlNative = getBizUserControlNative(j, this, IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl);
        if (bizUserControlNative == 0) {
            return null;
        }
        return new IBizUserControlImpl(bizUserControlNative, false);
    }

    public IBizGuideRouteControlImpl getBizGuideRouteControl(IMapViewImpl iMapViewImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizGuideRouteControlNative = getBizGuideRouteControlNative(j, this, IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl);
        if (bizGuideRouteControlNative == 0) {
            return null;
        }
        return new IBizGuideRouteControlImpl(bizGuideRouteControlNative, false);
    }

    public IBizCarControlImpl getBizCarControl(IMapViewImpl iMapViewImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizCarControlNative = getBizCarControlNative(j, this, IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl);
        if (bizCarControlNative == 0) {
            return null;
        }
        return new IBizCarControlImpl(bizCarControlNative, false);
    }

    public IBizFlyLineControlImpl getBizFlyLineControl(IMapViewImpl iMapViewImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizFlyLineControlNative = getBizFlyLineControlNative(j, this, IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl);
        if (bizFlyLineControlNative == 0) {
            return null;
        }
        return new IBizFlyLineControlImpl(bizFlyLineControlNative, false);
    }

    public IBizAGroupControlImpl getBizAGroupControl(IMapViewImpl iMapViewImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizAGroupControlNative = getBizAGroupControlNative(j, this, IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl);
        if (bizAGroupControlNative == 0) {
            return null;
        }
        return new IBizAGroupControlImpl(bizAGroupControlNative, false);
    }

    public IBizAreaControlImpl getBizAreaControl(IMapViewImpl iMapViewImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizAreaControlNative = getBizAreaControlNative(j, this, IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl);
        if (bizAreaControlNative == 0) {
            return null;
        }
        return new IBizAreaControlImpl(bizAreaControlNative, false);
    }

    public IBizSearchControlImpl getBizSearchControl(IMapViewImpl iMapViewImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizSearchControlNative = getBizSearchControlNative(j, this, IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl);
        if (bizSearchControlNative == 0) {
            return null;
        }
        return new IBizSearchControlImpl(bizSearchControlNative, false);
    }

    public IBizGuideEagleEyeControlImpl getBizGuideEagleEyeControl(@EGLDeviceID.EGLDeviceID1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizGuideEagleEyeControlNative = getBizGuideEagleEyeControlNative(j, this, i);
        if (bizGuideEagleEyeControlNative == 0) {
            return null;
        }
        return new IBizGuideEagleEyeControlImpl(bizGuideEagleEyeControlNative, false);
    }

    public IBizLaneControlImpl getBizLaneControl(IMapViewImpl iMapViewImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizLaneControlNative = getBizLaneControlNative(j, this, IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl);
        if (bizLaneControlNative == 0) {
            return null;
        }
        return new IBizLaneControlImpl(bizLaneControlNative, false);
    }

    public IBizCustomControlImpl getBizCustomControl(IMapViewImpl iMapViewImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizCustomControlNative = getBizCustomControlNative(j, this, IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl);
        if (bizCustomControlNative == 0) {
            return null;
        }
        return new IBizCustomControlImpl(bizCustomControlNative, false);
    }

    public IBizDynamicControlImpl getBizDynamicControl(IMapViewImpl iMapViewImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizDynamicControlNative = getBizDynamicControlNative(j, this, IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl);
        if (bizDynamicControlNative == 0) {
            return null;
        }
        return new IBizDynamicControlImpl(bizDynamicControlNative, false);
    }

    public IBizDynamicControlImpl getBizDynamicControl(IMapViewImpl iMapViewImpl, @DynamicControlType.DynamicControlType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long bizDynamicControl1Native = getBizDynamicControl1Native(j, this, IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl, i);
        if (bizDynamicControl1Native == 0) {
            return null;
        }
        return new IBizDynamicControlImpl(bizDynamicControl1Native, false);
    }

    public String getBizNameByType(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getBizNameByTypeNative(j, this, i);
    }

    public int getCollisionIntervalTime(@MapEngineID.MapEngineID1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getCollisionIntervalTimeNative(j, this, i);
    }

    public boolean setCollisionIntervalTime(@MapEngineID.MapEngineID1 int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setCollisionIntervalTimeNative(j, this, i, i2);
    }

    public boolean switchStyle(IMapViewImpl iMapViewImpl, int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return switchStyleNative(j, this, IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl, i);
    }

    public void updateAllStyle(IMapViewImpl iMapViewImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateAllStyleNative(j, this, IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl);
    }
}
