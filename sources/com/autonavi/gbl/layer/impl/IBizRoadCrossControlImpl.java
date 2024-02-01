package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.RectInt;
import com.autonavi.gbl.guide.model.CrossImageInfo;
import com.autonavi.gbl.guide.model.CrossType;
import com.autonavi.gbl.guide.model.NaviInfo;
import com.autonavi.gbl.layer.BizRoadCrossControl;
import com.autonavi.gbl.layer.model.BizRoadCrossType;
import com.autonavi.gbl.map.impl.MixtureSharedBaseImpl;
import com.autonavi.gbl.map.layer.model.LayerTexture;
import com.autonavi.gbl.map.layer.model.RealCity3DFilter;
import com.autonavi.gbl.map.layer.model.RealCityTmcParam;
import com.autonavi.gbl.map.layer.model.VectorCrossViewPostureEvent;
import com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl;
import java.util.ArrayList;
@IntfAuto(target = BizRoadCrossControl.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IBizRoadCrossControlImpl extends MixtureSharedBaseImpl {
    private static BindTable BIND_TABLE = new BindTable(IBizRoadCrossControlImpl.class);
    private transient long swigCPtr;

    private static native long IBizRoadCrossControlImpl_SWIGUpcast(long j);

    private static native void destroyNativeObj(long j);

    private static native long getStyleNative(long j, IBizRoadCrossControlImpl iBizRoadCrossControlImpl);

    private static native boolean getVisible1Native(long j, IBizRoadCrossControlImpl iBizRoadCrossControlImpl, int i);

    private static native boolean getVisibleNative(long j, IBizRoadCrossControlImpl iBizRoadCrossControlImpl);

    private static native void hideCrossNative(long j, IBizRoadCrossControlImpl iBizRoadCrossControlImpl, int i);

    private static native boolean matchBizControlNative(long j, IBizRoadCrossControlImpl iBizRoadCrossControlImpl, long j2);

    private static native void restoreVisibleNative(long j, IBizRoadCrossControlImpl iBizRoadCrossControlImpl);

    private static native void saveVisibleNative(long j, IBizRoadCrossControlImpl iBizRoadCrossControlImpl);

    private static native void set3DCrossCarModeNative(long j, IBizRoadCrossControlImpl iBizRoadCrossControlImpl, boolean z);

    private static native void setCrossImageInfoNative(long j, IBizRoadCrossControlImpl iBizRoadCrossControlImpl, long j2, CrossImageInfo crossImageInfo);

    private static native boolean setFlyTmcNative(long j, IBizRoadCrossControlImpl iBizRoadCrossControlImpl, byte[] bArr, ArrayList<RealCityTmcParam> arrayList);

    private static native void setRasterImageArrowColorNative(long j, IBizRoadCrossControlImpl iBizRoadCrossControlImpl, boolean z, int i);

    private static native boolean setRasterImageDataNative(long j, IBizRoadCrossControlImpl iBizRoadCrossControlImpl, long j2, LayerTexture layerTexture, long j3, LayerTexture layerTexture2);

    private static native boolean setRct3DFilterNative(long j, IBizRoadCrossControlImpl iBizRoadCrossControlImpl, long j2, RealCity3DFilter realCity3DFilter);

    private static native void setRctHeadAngleSyncNative(long j, IBizRoadCrossControlImpl iBizRoadCrossControlImpl, boolean z);

    private static native void setRoadCrossRectNative(long j, IBizRoadCrossControlImpl iBizRoadCrossControlImpl, int i, long j2, RectInt rectInt);

    private static native void setRtcBinaryDataNative(long j, IBizRoadCrossControlImpl iBizRoadCrossControlImpl, byte[] bArr);

    private static native void setStyleNative(long j, IBizRoadCrossControlImpl iBizRoadCrossControlImpl, long j2, IPrepareLayerStyleImpl iPrepareLayerStyleImpl);

    private static native void setViewPostureEventNative(long j, IBizRoadCrossControlImpl iBizRoadCrossControlImpl, int i, int i2);

    private static native void setVisible1Native(long j, IBizRoadCrossControlImpl iBizRoadCrossControlImpl, int i, boolean z);

    private static native void setVisibleNative(long j, IBizRoadCrossControlImpl iBizRoadCrossControlImpl, boolean z);

    private static native void showRtcArrow3DNative(long j, IBizRoadCrossControlImpl iBizRoadCrossControlImpl, boolean z);

    private static native void showRtcSkeletonNative(long j, IBizRoadCrossControlImpl iBizRoadCrossControlImpl, boolean z);

    private static native boolean updateCrossNative(long j, IBizRoadCrossControlImpl iBizRoadCrossControlImpl, byte[] bArr, int i);

    private static native void updateNaviInfoNative(long j, IBizRoadCrossControlImpl iBizRoadCrossControlImpl, long j2, NaviInfo naviInfo);

    private static native void updateStyleNative(long j, IBizRoadCrossControlImpl iBizRoadCrossControlImpl, int i);

    public IBizRoadCrossControlImpl(long j, boolean z) {
        super(IBizRoadCrossControlImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof IBizRoadCrossControlImpl) {
            return getUID(this) == getUID((IBizRoadCrossControlImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(IBizRoadCrossControlImpl iBizRoadCrossControlImpl) {
        long cPtr = getCPtr(iBizRoadCrossControlImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IBizRoadCrossControlImpl iBizRoadCrossControlImpl) {
        if (iBizRoadCrossControlImpl == null) {
            return 0L;
        }
        return iBizRoadCrossControlImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
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

    public IPrepareLayerStyleImpl getStyle() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long styleNative = getStyleNative(j, this);
        if (styleNative == 0) {
            return null;
        }
        return new IPrepareLayerStyleImpl(styleNative, false);
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

    public void setRoadCrossRect(@CrossType.CrossType1 int i, RectInt rectInt) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setRoadCrossRectNative(j, this, i, 0L, rectInt);
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

    public void setRctHeadAngleSync(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setRctHeadAngleSyncNative(j, this, z);
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

    public void setCrossImageInfo(CrossImageInfo crossImageInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setCrossImageInfoNative(j, this, 0L, crossImageInfo);
    }

    public void setVisible(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setVisibleNative(j, this, z);
    }

    public boolean getVisible() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getVisibleNative(j, this);
    }

    public void setVisible(@CrossType.CrossType1 int i, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setVisible1Native(j, this, i, z);
    }

    public boolean getVisible(@BizRoadCrossType.BizRoadCrossType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getVisible1Native(j, this, i);
    }

    public void saveVisible() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        saveVisibleNative(j, this);
    }

    public void restoreVisible() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        restoreVisibleNative(j, this);
    }

    public void setViewPostureEvent(@CrossType.CrossType1 int i, @VectorCrossViewPostureEvent.VectorCrossViewPostureEvent1 int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setViewPostureEventNative(j, this, i, i2);
    }

    public boolean setRct3DFilter(RealCity3DFilter realCity3DFilter) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setRct3DFilterNative(j, this, 0L, realCity3DFilter);
    }

    public void showRtcSkeleton(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        showRtcSkeletonNative(j, this, z);
    }

    public void showRtcArrow3D(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        showRtcArrow3DNative(j, this, z);
    }

    public void setRtcBinaryData(byte[] bArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setRtcBinaryDataNative(j, this, bArr);
    }
}
