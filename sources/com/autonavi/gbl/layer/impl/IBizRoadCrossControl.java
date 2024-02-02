package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.guide.model.CrossType;
import com.autonavi.gbl.guide.model.NaviInfo;
import com.autonavi.gbl.layer.BizRoadCrossControl;
import com.autonavi.gbl.map.layer.model.LayerTexture;
import com.autonavi.gbl.map.layer.model.RealCityTmcParam;
import com.autonavi.gbl.map.layer.model.VectorCrossViewPostureEvent;
import com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl;
import java.util.ArrayList;
@IntfAuto(target = BizRoadCrossControl.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IBizRoadCrossControl {
    private static BindTable BIND_TABLE = new BindTable(IBizRoadCrossControl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void destroyNativeObj(long j);

    private static native void hideCrossNative(long j, IBizRoadCrossControl iBizRoadCrossControl, int i);

    private static native boolean matchBizControlNative(long j, IBizRoadCrossControl iBizRoadCrossControl, long j2);

    private static native void set3DCrossCarModeNative(long j, IBizRoadCrossControl iBizRoadCrossControl, boolean z);

    private static native boolean setFlyTmcNative(long j, IBizRoadCrossControl iBizRoadCrossControl, byte[] bArr, ArrayList<RealCityTmcParam> arrayList);

    private static native void setRasterImageArrowColorNative(long j, IBizRoadCrossControl iBizRoadCrossControl, boolean z, int i);

    private static native boolean setRasterImageDataNative(long j, IBizRoadCrossControl iBizRoadCrossControl, long j2, LayerTexture layerTexture, long j3, LayerTexture layerTexture2);

    private static native void setStyleNative(long j, IBizRoadCrossControl iBizRoadCrossControl, long j2, IPrepareLayerStyleImpl iPrepareLayerStyleImpl);

    private static native void setViewPostureEventNative(long j, IBizRoadCrossControl iBizRoadCrossControl, int i, int i2);

    private static native void setVisibleNative(long j, IBizRoadCrossControl iBizRoadCrossControl, int i, boolean z);

    private static native boolean updateCrossNative(long j, IBizRoadCrossControl iBizRoadCrossControl, byte[] bArr, int i);

    private static native void updateNaviInfoNative(long j, IBizRoadCrossControl iBizRoadCrossControl, long j2, NaviInfo naviInfo);

    private static native void updateStyleNative(long j, IBizRoadCrossControl iBizRoadCrossControl, int i);

    public IBizRoadCrossControl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IBizRoadCrossControl) && getUID(this) == getUID((IBizRoadCrossControl) obj);
    }

    private static long getUID(IBizRoadCrossControl iBizRoadCrossControl) {
        long cPtr = getCPtr(iBizRoadCrossControl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IBizRoadCrossControl iBizRoadCrossControl) {
        if (iBizRoadCrossControl == null) {
            return 0L;
        }
        return iBizRoadCrossControl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
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

    public boolean matchBizControl(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return matchBizControlNative(j2, this, j);
    }

    public void setStyle(IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setStyleNative(j, this, IPrepareLayerStyleImpl.getCPtr(iPrepareLayerStyleImpl), iPrepareLayerStyleImpl);
    }

    public void updateStyle(@CrossType.CrossType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateStyleNative(j, this, i);
    }

    public void setRasterImageArrowColor(boolean z, int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setRasterImageArrowColorNative(j, this, z, i);
    }

    public boolean setRasterImageData(LayerTexture layerTexture, LayerTexture layerTexture2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setRasterImageDataNative(j, this, 0L, layerTexture, 0L, layerTexture2);
    }

    public boolean updateCross(byte[] bArr, @CrossType.CrossType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return updateCrossNative(j, this, bArr, i);
    }

    public void hideCross(@CrossType.CrossType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        hideCrossNative(j, this, i);
    }

    public void set3DCrossCarMode(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        set3DCrossCarModeNative(j, this, z);
    }

    public boolean setFlyTmc(byte[] bArr, ArrayList<RealCityTmcParam> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setFlyTmcNative(j, this, bArr, arrayList);
    }

    public void updateNaviInfo(NaviInfo naviInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateNaviInfoNative(j, this, 0L, naviInfo);
    }

    public void setVisible(@CrossType.CrossType1 int i, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setVisibleNative(j, this, i, z);
    }

    public void setViewPostureEvent(@CrossType.CrossType1 int i, @VectorCrossViewPostureEvent.VectorCrossViewPostureEvent1 int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setViewPostureEventNative(j, this, i, i2);
    }
}
