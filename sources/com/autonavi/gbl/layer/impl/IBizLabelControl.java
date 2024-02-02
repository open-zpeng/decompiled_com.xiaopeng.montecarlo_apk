package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.guide.model.CruiseCongestionInfo;
import com.autonavi.gbl.guide.model.LaneInfo;
import com.autonavi.gbl.guide.model.MixForkInfo;
import com.autonavi.gbl.guide.model.NaviInfo;
import com.autonavi.gbl.layer.BizLabelControl;
import com.autonavi.gbl.layer.model.BizLabelType;
import com.autonavi.gbl.layer.model.BizPointBusinessInfo;
import com.autonavi.gbl.layer.model.BizPopPointBusinessInfo;
import com.autonavi.gbl.layer.model.BizSearchAlongWayPoint;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import java.util.ArrayList;
@IntfAuto(target = BizLabelControl.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IBizLabelControl extends IBizControl {
    private static BindTable BIND_TABLE = new BindTable(IBizLabelControl.class);
    private transient long swigCPtr;

    private static native long IBizLabelControl_SWIGUpcast(long j);

    private static native void destroyNativeObj(long j);

    private static native void exitPreviewCruiseCongestionNative(long j, IBizLabelControl iBizLabelControl);

    private static native long getLabelLayerNative(long j, IBizLabelControl iBizLabelControl, int i);

    private static native void previewCruiseCongestionNative(long j, IBizLabelControl iBizLabelControl, long j2, CruiseCongestionInfo cruiseCongestionInfo, boolean z, boolean z2);

    private static native void updateCruiseCongestionNative(long j, IBizLabelControl iBizLabelControl, long j2, CruiseCongestionInfo cruiseCongestionInfo, int i, int i2, int i3);

    private static native void updateCruiseLaneNative(long j, IBizLabelControl iBizLabelControl, long j2, LaneInfo laneInfo);

    private static native void updateGpsPointsInfoNative(long j, IBizLabelControl iBizLabelControl, ArrayList<BizPointBusinessInfo> arrayList);

    private static native void updateGuideMixForkInfoNative(long j, IBizLabelControl iBizLabelControl, ArrayList<MixForkInfo> arrayList);

    private static native void updateNaviInfoNative(long j, IBizLabelControl iBizLabelControl, long j2, NaviInfo naviInfo);

    private static native void updatePopAddViaPointInfoNative(long j, IBizLabelControl iBizLabelControl, ArrayList<BizSearchAlongWayPoint> arrayList);

    private static native void updatePopEndAreaPointBoxInfoNative(long j, IBizLabelControl iBizLabelControl, ArrayList<BizPopPointBusinessInfo> arrayList);

    private static native void updatePopRemoveViaPointInfoNative(long j, IBizLabelControl iBizLabelControl, ArrayList<BizPopPointBusinessInfo> arrayList);

    private static native void updatePopSearchPointInfoNative(long j, IBizLabelControl iBizLabelControl, ArrayList<BizPopPointBusinessInfo> arrayList);

    private static native void updatePopTrafficEventInfoNative(long j, IBizLabelControl iBizLabelControl, ArrayList<BizPopPointBusinessInfo> arrayList);

    public IBizLabelControl(long j, boolean z) {
        super(IBizLabelControl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.layer.impl.IBizControl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.layer.impl.IBizControl
    public boolean equals(Object obj) {
        if (obj instanceof IBizLabelControl) {
            return getUID(this) == getUID((IBizLabelControl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(IBizLabelControl iBizLabelControl) {
        long cPtr = getCPtr(iBizLabelControl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IBizLabelControl iBizLabelControl) {
        if (iBizLabelControl == null) {
            return 0L;
        }
        return iBizLabelControl.swigCPtr;
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

    public void updateCruiseLane(LaneInfo laneInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateCruiseLaneNative(j, this, 0L, laneInfo);
    }

    public void updateCruiseCongestion(CruiseCongestionInfo cruiseCongestionInfo, int i, int i2, int i3) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateCruiseCongestionNative(j, this, 0L, cruiseCongestionInfo, i, i2, i3);
    }

    public void previewCruiseCongestion(CruiseCongestionInfo cruiseCongestionInfo, boolean z, boolean z2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        previewCruiseCongestionNative(j, this, 0L, cruiseCongestionInfo, z, z2);
    }

    public void exitPreviewCruiseCongestion() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        exitPreviewCruiseCongestionNative(j, this);
    }

    public void updateNaviInfo(NaviInfo naviInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateNaviInfoNative(j, this, 0L, naviInfo);
    }

    public void updateGuideMixForkInfo(ArrayList<MixForkInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateGuideMixForkInfoNative(j, this, arrayList);
    }

    public void updatePopAddViaPointInfo(ArrayList<BizSearchAlongWayPoint> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updatePopAddViaPointInfoNative(j, this, arrayList);
    }

    public void updatePopRemoveViaPointInfo(ArrayList<BizPopPointBusinessInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updatePopRemoveViaPointInfoNative(j, this, arrayList);
    }

    public void updatePopTrafficEventInfo(ArrayList<BizPopPointBusinessInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updatePopTrafficEventInfoNative(j, this, arrayList);
    }

    public void updatePopSearchPointInfo(ArrayList<BizPopPointBusinessInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updatePopSearchPointInfoNative(j, this, arrayList);
    }

    public void updatePopEndAreaPointBoxInfo(ArrayList<BizPopPointBusinessInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updatePopEndAreaPointBoxInfoNative(j, this, arrayList);
    }

    public void updateGpsPointsInfo(ArrayList<BizPointBusinessInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateGpsPointsInfoNative(j, this, arrayList);
    }

    public BaseLayerImpl getLabelLayer(@BizLabelType.BizLabelType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long labelLayerNative = getLabelLayerNative(j, this, i);
        if (labelLayerNative == 0) {
            return null;
        }
        return new BaseLayerImpl(labelLayerNative, false);
    }
}
