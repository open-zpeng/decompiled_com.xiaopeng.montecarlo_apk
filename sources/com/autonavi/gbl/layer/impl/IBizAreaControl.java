package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.model.RectInt;
import com.autonavi.gbl.layer.BizAreaControl;
import com.autonavi.gbl.layer.model.BizAreaType;
import com.autonavi.gbl.layer.model.BizCircleBusinessInfo;
import com.autonavi.gbl.layer.model.BizRouteEndAreaInfo;
import com.autonavi.gbl.layer.model.BizRouteRestrictInfo;
import com.autonavi.gbl.layer.model.RangeOnMapPolygonInfo;
import com.autonavi.gbl.layer.model.RouteEndAreaType;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.model.PolygonGradientPointInfo;
import java.util.ArrayList;
@IntfAuto(target = BizAreaControl.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IBizAreaControl extends IBizControl {
    private static BindTable BIND_TABLE = new BindTable(IBizAreaControl.class);
    private transient long swigCPtr;

    private static native long IBizAreaControl_SWIGUpcast(long j);

    private static native void clearRangeOnMapLayerNative(long j, IBizAreaControl iBizAreaControl);

    private static native void clearRouteEndAreaNative(long j, IBizAreaControl iBizAreaControl, int i);

    private static native void destroyNativeObj(long j);

    private static native long getAreaLayerNative(long j, IBizAreaControl iBizAreaControl, int i);

    private static native void setIndoorMaskingSwitchNative(long j, IBizAreaControl iBizAreaControl, boolean z);

    private static native void updateRangeOnMapCircleNative(long j, IBizAreaControl iBizAreaControl, long j2, BizCircleBusinessInfo bizCircleBusinessInfo);

    private static native void updateRangeOnMapGradientNative(long j, IBizAreaControl iBizAreaControl, ArrayList<PolygonGradientPointInfo> arrayList, boolean z);

    private static native void updateRangeOnMapPolygonNative(long j, IBizAreaControl iBizAreaControl, ArrayList<RangeOnMapPolygonInfo> arrayList);

    private static native void updateRouteEndAreaNative(long j, IBizAreaControl iBizAreaControl, long j2, BizRouteEndAreaInfo bizRouteEndAreaInfo, long j3, RectInt rectInt);

    private static native void updateRouteEndAreaPreviewRectNative(long j, IBizAreaControl iBizAreaControl, long j2, RectInt rectInt);

    private static native void updateRouteRestrictNative(long j, IBizAreaControl iBizAreaControl, long j2, BizRouteRestrictInfo bizRouteRestrictInfo);

    public IBizAreaControl(long j, boolean z) {
        super(IBizAreaControl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.layer.impl.IBizControl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.layer.impl.IBizControl
    public boolean equals(Object obj) {
        if (obj instanceof IBizAreaControl) {
            return getUID(this) == getUID((IBizAreaControl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(IBizAreaControl iBizAreaControl) {
        long cPtr = getCPtr(iBizAreaControl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IBizAreaControl iBizAreaControl) {
        if (iBizAreaControl == null) {
            return 0L;
        }
        return iBizAreaControl.swigCPtr;
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

    public void updateRangeOnMapPolygon(ArrayList<RangeOnMapPolygonInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateRangeOnMapPolygonNative(j, this, arrayList);
    }

    public void updateRangeOnMapCircle(BizCircleBusinessInfo bizCircleBusinessInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateRangeOnMapCircleNative(j, this, 0L, bizCircleBusinessInfo);
    }

    public void updateRangeOnMapGradient(ArrayList<PolygonGradientPointInfo> arrayList, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateRangeOnMapGradientNative(j, this, arrayList, z);
    }

    public void clearRangeOnMapLayer() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        clearRangeOnMapLayerNative(j, this);
    }

    public void updateRouteRestrict(BizRouteRestrictInfo bizRouteRestrictInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateRouteRestrictNative(j, this, 0L, bizRouteRestrictInfo);
    }

    public void updateRouteEndArea(BizRouteEndAreaInfo bizRouteEndAreaInfo, RectInt rectInt) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateRouteEndAreaNative(j, this, 0L, bizRouteEndAreaInfo, 0L, rectInt);
    }

    public void updateRouteEndAreaPreviewRect(RectInt rectInt) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateRouteEndAreaPreviewRectNative(j, this, 0L, rectInt);
    }

    public void clearRouteEndArea(@RouteEndAreaType.RouteEndAreaType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        clearRouteEndAreaNative(j, this, i);
    }

    public void setIndoorMaskingSwitch(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setIndoorMaskingSwitchNative(j, this, z);
    }

    public BaseLayerImpl getAreaLayer(@BizAreaType.BizAreaType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long areaLayerNative = getAreaLayerNative(j, this, i);
        if (areaLayerNative == 0) {
            return null;
        }
        return new BaseLayerImpl(areaLayerNative, false);
    }
}
