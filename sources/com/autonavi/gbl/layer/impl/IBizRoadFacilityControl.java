package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.guide.model.CruiseCongestionInfo;
import com.autonavi.gbl.guide.model.CruiseEventInfo;
import com.autonavi.gbl.guide.model.CruiseFacilityInfo;
import com.autonavi.gbl.guide.model.NaviCamera;
import com.autonavi.gbl.guide.model.NaviInfo;
import com.autonavi.gbl.guide.model.NaviIntervalCamera;
import com.autonavi.gbl.guide.model.NaviRoadFacility;
import com.autonavi.gbl.guide.model.SocolEventInfo;
import com.autonavi.gbl.guide.model.TrafficEventInfo;
import com.autonavi.gbl.guide.model.TrafficSignal;
import com.autonavi.gbl.layer.BizRoadFacilityControl;
import com.autonavi.gbl.layer.model.BizRoadFacilityType;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import java.util.ArrayList;
@IntfAuto(target = BizRoadFacilityControl.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IBizRoadFacilityControl extends IBizControl {
    private static BindTable BIND_TABLE = new BindTable(IBizRoadFacilityControl.class);
    private transient long swigCPtr;

    private static native long IBizRoadFacilityControl_SWIGUpcast(long j);

    private static native void destroyNativeObj(long j);

    private static native void enableCameraGrownNative(long j, IBizRoadFacilityControl iBizRoadFacilityControl, boolean z);

    private static native void enableDistanceRefreshNative(long j, IBizRoadFacilityControl iBizRoadFacilityControl, boolean z);

    private static native long getFacilityLayerNative(long j, IBizRoadFacilityControl iBizRoadFacilityControl, int i);

    private static native void initCruiseCongestionLayerOptionNative(long j, IBizRoadFacilityControl iBizRoadFacilityControl, long j2, CruiseCongestionLayerOption cruiseCongestionLayerOption);

    private static native int parseGuideCameraLayerPropertyNative(long j, IBizRoadFacilityControl iBizRoadFacilityControl, String str);

    private static native void updateCruiseCameraNative(long j, IBizRoadFacilityControl iBizRoadFacilityControl, ArrayList<CruiseFacilityInfo> arrayList);

    private static native void updateCruiseCongestionEventNative(long j, IBizRoadFacilityControl iBizRoadFacilityControl, ArrayList<SocolEventInfo> arrayList);

    private static native void updateCruiseCongestionNative(long j, IBizRoadFacilityControl iBizRoadFacilityControl, long j2, CruiseCongestionInfo cruiseCongestionInfo);

    private static native void updateCruiseEventNative(long j, IBizRoadFacilityControl iBizRoadFacilityControl, ArrayList<CruiseEventInfo> arrayList);

    private static native void updateCruiseFacilityNative(long j, IBizRoadFacilityControl iBizRoadFacilityControl, ArrayList<CruiseFacilityInfo> arrayList);

    private static native void updateGuideCameraNative(long j, IBizRoadFacilityControl iBizRoadFacilityControl, ArrayList<NaviCamera> arrayList);

    private static native void updateGuideIntervalCameraNative(long j, IBizRoadFacilityControl iBizRoadFacilityControl, ArrayList<NaviIntervalCamera> arrayList);

    private static native void updateGuideRoadFacilityNative(long j, IBizRoadFacilityControl iBizRoadFacilityControl, ArrayList<NaviRoadFacility> arrayList);

    private static native void updateGuideTrafficEventNative(long j, IBizRoadFacilityControl iBizRoadFacilityControl, ArrayList<TrafficEventInfo> arrayList, boolean z);

    private static native void updateNaviInfoNative(long j, IBizRoadFacilityControl iBizRoadFacilityControl, long j2, NaviInfo naviInfo);

    private static native void updateTrafficLightNative(long j, IBizRoadFacilityControl iBizRoadFacilityControl, ArrayList<TrafficSignal> arrayList);

    public IBizRoadFacilityControl(long j, boolean z) {
        super(IBizRoadFacilityControl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.layer.impl.IBizControl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.layer.impl.IBizControl
    public boolean equals(Object obj) {
        if (obj instanceof IBizRoadFacilityControl) {
            return getUID(this) == getUID((IBizRoadFacilityControl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(IBizRoadFacilityControl iBizRoadFacilityControl) {
        long cPtr = getCPtr(iBizRoadFacilityControl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IBizRoadFacilityControl iBizRoadFacilityControl) {
        if (iBizRoadFacilityControl == null) {
            return 0L;
        }
        return iBizRoadFacilityControl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.IBizControl
    public synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
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

    public void updateGuideCamera(ArrayList<NaviCamera> arrayList) {
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

    public void updateGuideIntervalCamera(ArrayList<NaviIntervalCamera> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateGuideIntervalCameraNative(j, this, arrayList);
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

    public void updateNaviInfo(NaviInfo naviInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateNaviInfoNative(j, this, 0L, naviInfo);
    }

    public void initCruiseCongestionLayerOption(CruiseCongestionLayerOption cruiseCongestionLayerOption) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        initCruiseCongestionLayerOptionNative(j, this, CruiseCongestionLayerOption.getCPtr(cruiseCongestionLayerOption), cruiseCongestionLayerOption);
    }

    public int parseGuideCameraLayerProperty(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return parseGuideCameraLayerPropertyNative(j, this, str);
    }

    public void updateCruiseCongestion(CruiseCongestionInfo cruiseCongestionInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateCruiseCongestionNative(j, this, 0L, cruiseCongestionInfo);
    }

    public void enableCameraGrown(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        enableCameraGrownNative(j, this, z);
    }
}
