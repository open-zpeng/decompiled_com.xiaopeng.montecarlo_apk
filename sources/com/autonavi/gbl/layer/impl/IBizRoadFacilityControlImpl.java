package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.guide.model.CruiseCongestionInfo;
import com.autonavi.gbl.guide.model.CruiseEventInfo;
import com.autonavi.gbl.guide.model.CruiseFacilityInfo;
import com.autonavi.gbl.guide.model.NaviCameraExt;
import com.autonavi.gbl.guide.model.NaviInfo;
import com.autonavi.gbl.guide.model.NaviRoadFacility;
import com.autonavi.gbl.guide.model.SocolEventInfo;
import com.autonavi.gbl.guide.model.TrafficEventInfo;
import com.autonavi.gbl.guide.model.TrafficLightCountdown;
import com.autonavi.gbl.guide.model.TrafficSignal;
import com.autonavi.gbl.layer.BizRoadFacilityControl;
import com.autonavi.gbl.layer.model.BizLocalTrafficEventInfo;
import com.autonavi.gbl.layer.model.BizRoadFacilityType;
import com.autonavi.gbl.layer.model.CruiseCongestionLayerOption;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import java.util.ArrayList;
@IntfAuto(target = BizRoadFacilityControl.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IBizRoadFacilityControlImpl extends IBizControlImpl {
    private static BindTable BIND_TABLE = new BindTable(IBizRoadFacilityControlImpl.class);
    private transient long swigCPtr;

    private static native long IBizRoadFacilityControlImpl_SWIGUpcast(long j);

    private static native void destroyNativeObj(long j);

    private static native void enableCameraArrowCollisionNative(long j, IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl, boolean z);

    private static native void enableCameraGrownNative(long j, IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl, boolean z);

    private static native void enableDistanceRefreshNative(long j, IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl, boolean z);

    private static native void enableTrafficSignalLightNative(long j, IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl, boolean z);

    private static native long getFacilityLayerNative(long j, IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl, int i);

    private static native void initCruiseCongestionLayerOptionNative(long j, IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl, long j2, CruiseCongestionLayerOption cruiseCongestionLayerOption);

    private static native int parseGuideCameraLayerPropertyNative(long j, IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl, String str);

    private static native void updateCruiseCameraNative(long j, IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl, ArrayList<CruiseFacilityInfo> arrayList);

    private static native void updateCruiseCongestionEventNative(long j, IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl, ArrayList<SocolEventInfo> arrayList);

    private static native void updateCruiseCongestionNative(long j, IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl, long j2, CruiseCongestionInfo cruiseCongestionInfo);

    private static native void updateCruiseEventNative(long j, IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl, ArrayList<CruiseEventInfo> arrayList);

    private static native void updateCruiseFacilityNative(long j, IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl, ArrayList<CruiseFacilityInfo> arrayList);

    private static native void updateGuideCameraNative(long j, IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl, ArrayList<NaviCameraExt> arrayList);

    private static native void updateGuideRoadFacilityNative(long j, IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl, ArrayList<NaviRoadFacility> arrayList);

    private static native void updateGuideTrafficEventNative(long j, IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl, ArrayList<TrafficEventInfo> arrayList, boolean z);

    private static native void updateLocalTrafficEventInfoNative(long j, IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl, ArrayList<BizLocalTrafficEventInfo> arrayList);

    private static native void updateNaviInfoNative(long j, IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl, long j2, NaviInfo naviInfo);

    private static native void updateTrafficLightCountdownNative(long j, IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl, ArrayList<TrafficLightCountdown> arrayList);

    private static native void updateTrafficLightNative(long j, IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl, ArrayList<TrafficSignal> arrayList);

    public IBizRoadFacilityControlImpl(long j, boolean z) {
        super(IBizRoadFacilityControlImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.layer.impl.IBizControlImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.layer.impl.IBizControlImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof IBizRoadFacilityControlImpl) {
            return getUID(this) == getUID((IBizRoadFacilityControlImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl) {
        long cPtr = getCPtr(iBizRoadFacilityControlImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IBizRoadFacilityControlImpl iBizRoadFacilityControlImpl) {
        if (iBizRoadFacilityControlImpl == null) {
            return 0L;
        }
        return iBizRoadFacilityControlImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.IBizControlImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public BaseLayerImpl getFacilityLayer(@BizRoadFacilityType.BizRoadFacilityType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long facilityLayerNative = getFacilityLayerNative(j, this, i);
        if (facilityLayerNative == 0) {
            return null;
        }
        return new BaseLayerImpl(facilityLayerNative, false);
    }

    public void updateCruiseFacility(ArrayList<CruiseFacilityInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateCruiseFacilityNative(j, this, arrayList);
    }

    public void updateCruiseCamera(ArrayList<CruiseFacilityInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateCruiseCameraNative(j, this, arrayList);
    }

    public void updateCruiseEvent(ArrayList<CruiseEventInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateCruiseEventNative(j, this, arrayList);
    }

    public void updateCruiseCongestionEvent(ArrayList<SocolEventInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateCruiseCongestionEventNative(j, this, arrayList);
    }

    public void updateGuideCamera(ArrayList<NaviCameraExt> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateGuideCameraNative(j, this, arrayList);
    }

    public void enableDistanceRefresh(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        enableDistanceRefreshNative(j, this, z);
    }

    public void updateGuideRoadFacility(ArrayList<NaviRoadFacility> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateGuideRoadFacilityNative(j, this, arrayList);
    }

    public void updateGuideTrafficEvent(ArrayList<TrafficEventInfo> arrayList, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateGuideTrafficEventNative(j, this, arrayList, z);
    }

    public void updateTrafficLight(ArrayList<TrafficSignal> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateTrafficLightNative(j, this, arrayList);
    }

    public void updateTrafficLightCountdown(ArrayList<TrafficLightCountdown> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateTrafficLightCountdownNative(j, this, arrayList);
    }

    public void updateNaviInfo(NaviInfo naviInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateNaviInfoNative(j, this, 0L, naviInfo);
    }

    public void updateLocalTrafficEventInfo(ArrayList<BizLocalTrafficEventInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateLocalTrafficEventInfoNative(j, this, arrayList);
    }

    public void initCruiseCongestionLayerOption(CruiseCongestionLayerOption cruiseCongestionLayerOption) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        initCruiseCongestionLayerOptionNative(j, this, 0L, cruiseCongestionLayerOption);
    }

    public int parseGuideCameraLayerProperty(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return parseGuideCameraLayerPropertyNative(j, this, str);
    }

    public void enableCameraArrowCollision(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        enableCameraArrowCollisionNative(j, this, z);
    }

    public void updateCruiseCongestion(CruiseCongestionInfo cruiseCongestionInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateCruiseCongestionNative(j, this, 0L, cruiseCongestionInfo);
    }

    public void enableTrafficSignalLight(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        enableTrafficSignalLightNative(j, this, z);
    }

    public void enableCameraGrown(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        enableCameraGrownNative(j, this, z);
    }
}
