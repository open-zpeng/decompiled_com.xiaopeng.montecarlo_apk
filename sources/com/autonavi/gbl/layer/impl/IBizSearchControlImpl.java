package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.BizSearchControl;
import com.autonavi.gbl.layer.model.BizLineBusinessInfo;
import com.autonavi.gbl.layer.model.BizPointBusinessInfo;
import com.autonavi.gbl.layer.model.BizPolygonBusinessInfo;
import com.autonavi.gbl.layer.model.BizSearchAlongWayPoint;
import com.autonavi.gbl.layer.model.BizSearchBeginEndPoint;
import com.autonavi.gbl.layer.model.BizSearchChargeStationInfo;
import com.autonavi.gbl.layer.model.BizSearchChildPoint;
import com.autonavi.gbl.layer.model.BizSearchExitEntrancePoint;
import com.autonavi.gbl.layer.model.BizSearchParentPoint;
import com.autonavi.gbl.layer.model.BizSearchType;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import java.util.ArrayList;
@IntfAuto(target = BizSearchControl.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IBizSearchControlImpl extends IBizControlImpl {
    private static BindTable BIND_TABLE = new BindTable(IBizSearchControlImpl.class);
    private transient long swigCPtr;

    private static native long IBizSearchControlImpl_SWIGUpcast(long j);

    private static native void destroyNativeObj(long j);

    private static native long getSearchLayerNative(long j, IBizSearchControlImpl iBizSearchControlImpl, int i);

    private static native boolean updateSearchAlongRoutePoiNative(long j, IBizSearchControlImpl iBizSearchControlImpl, ArrayList<BizSearchAlongWayPoint> arrayList);

    private static native boolean updateSearchAlongRoutePoiPopNative(long j, IBizSearchControlImpl iBizSearchControlImpl, ArrayList<BizSearchAlongWayPoint> arrayList);

    private static native boolean updateSearchBeginEndPoiNative(long j, IBizSearchControlImpl iBizSearchControlImpl, ArrayList<BizSearchBeginEndPoint> arrayList);

    private static native boolean updateSearchCentralPoiNative(long j, IBizSearchControlImpl iBizSearchControlImpl, ArrayList<BizPointBusinessInfo> arrayList);

    private static native boolean updateSearchChargeStationNative(long j, IBizSearchControlImpl iBizSearchControlImpl, ArrayList<BizSearchChargeStationInfo> arrayList);

    private static native boolean updateSearchChildPoiNative(long j, IBizSearchControlImpl iBizSearchControlImpl, ArrayList<BizSearchChildPoint> arrayList);

    private static native boolean updateSearchExitEntrancePoiNative(long j, IBizSearchControlImpl iBizSearchControlImpl, ArrayList<BizSearchExitEntrancePoint> arrayList);

    private static native void updateSearchLineNative(long j, IBizSearchControlImpl iBizSearchControlImpl, ArrayList<BizLineBusinessInfo> arrayList);

    private static native boolean updateSearchParentPoiNative(long j, IBizSearchControlImpl iBizSearchControlImpl, ArrayList<BizSearchParentPoint> arrayList);

    private static native boolean updateSearchParkPoiNative(long j, IBizSearchControlImpl iBizSearchControlImpl, ArrayList<BizPointBusinessInfo> arrayList);

    private static native boolean updateSearchPoiLabelNative(long j, IBizSearchControlImpl iBizSearchControlImpl, long j2, BizPointBusinessInfo bizPointBusinessInfo);

    private static native void updateSearchPolygon1Native(long j, IBizSearchControlImpl iBizSearchControlImpl, ArrayList<BizPolygonBusinessInfo> arrayList);

    private static native void updateSearchPolygonNative(long j, IBizSearchControlImpl iBizSearchControlImpl, long j2, BizPolygonBusinessInfo bizPolygonBusinessInfo);

    public IBizSearchControlImpl(long j, boolean z) {
        super(IBizSearchControlImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.layer.impl.IBizControlImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.layer.impl.IBizControlImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof IBizSearchControlImpl) {
            return getUID(this) == getUID((IBizSearchControlImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(IBizSearchControlImpl iBizSearchControlImpl) {
        long cPtr = getCPtr(iBizSearchControlImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IBizSearchControlImpl iBizSearchControlImpl) {
        if (iBizSearchControlImpl == null) {
            return 0L;
        }
        return iBizSearchControlImpl.swigCPtr;
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

    public void updateSearchLine(ArrayList<BizLineBusinessInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateSearchLineNative(j, this, arrayList);
    }

    public void updateSearchPolygon(BizPolygonBusinessInfo bizPolygonBusinessInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateSearchPolygonNative(j, this, 0L, bizPolygonBusinessInfo);
    }

    public void updateSearchPolygon(ArrayList<BizPolygonBusinessInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateSearchPolygon1Native(j, this, arrayList);
    }

    public boolean updateSearchParentPoi(ArrayList<BizSearchParentPoint> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return updateSearchParentPoiNative(j, this, arrayList);
    }

    public boolean updateSearchChildPoi(ArrayList<BizSearchChildPoint> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return updateSearchChildPoiNative(j, this, arrayList);
    }

    public boolean updateSearchCentralPoi(ArrayList<BizPointBusinessInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return updateSearchCentralPoiNative(j, this, arrayList);
    }

    public boolean updateSearchExitEntrancePoi(ArrayList<BizSearchExitEntrancePoint> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return updateSearchExitEntrancePoiNative(j, this, arrayList);
    }

    public boolean updateSearchBeginEndPoi(ArrayList<BizSearchBeginEndPoint> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return updateSearchBeginEndPoiNative(j, this, arrayList);
    }

    public boolean updateSearchAlongRoutePoi(ArrayList<BizSearchAlongWayPoint> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return updateSearchAlongRoutePoiNative(j, this, arrayList);
    }

    public boolean updateSearchAlongRoutePoiPop(ArrayList<BizSearchAlongWayPoint> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return updateSearchAlongRoutePoiPopNative(j, this, arrayList);
    }

    public boolean updateSearchParkPoi(ArrayList<BizPointBusinessInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return updateSearchParkPoiNative(j, this, arrayList);
    }

    public boolean updateSearchPoiLabel(BizPointBusinessInfo bizPointBusinessInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return updateSearchPoiLabelNative(j, this, 0L, bizPointBusinessInfo);
    }

    public boolean updateSearchChargeStation(ArrayList<BizSearchChargeStationInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return updateSearchChargeStationNative(j, this, arrayList);
    }

    public BaseLayerImpl getSearchLayer(@BizSearchType.BizSearchType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long searchLayerNative = getSearchLayerNative(j, this, i);
        if (searchLayerNative == 0) {
            return null;
        }
        return new BaseLayerImpl(searchLayerNative, false);
    }
}
