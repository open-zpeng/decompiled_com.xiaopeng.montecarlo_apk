package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.BizUserControl;
import com.autonavi.gbl.layer.model.BizPointBusinessInfo;
import com.autonavi.gbl.layer.model.BizUserFavoritePoint;
import com.autonavi.gbl.layer.model.BizUserType;
import com.autonavi.gbl.layer.model.ColorSpeedPair;
import com.autonavi.gbl.layer.model.RainbowLinePoint;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.user.usertrack.model.GpsTrackDepthInfo;
import java.util.ArrayList;
@IntfAuto(target = BizUserControl.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IBizUserControlImpl extends IBizControlImpl {
    private static BindTable BIND_TABLE = new BindTable(IBizUserControlImpl.class);
    private transient long swigCPtr;

    private static native long IBizUserControlImpl_SWIGUpcast(long j);

    private static native void destroyNativeObj(long j);

    private static native long getUserLayerNative(long j, IBizUserControlImpl iBizUserControlImpl, int i);

    private static native boolean setFavoriteScaleNative(long j, IBizUserControlImpl iBizUserControlImpl, int i, float[] fArr);

    private static native void updateFavoriteMainNative(long j, IBizUserControlImpl iBizUserControlImpl, ArrayList<BizUserFavoritePoint> arrayList);

    private static native void updateFavoritePoiNative(long j, IBizUserControlImpl iBizUserControlImpl, long j2, BizUserFavoritePoint bizUserFavoritePoint);

    private static native void updateGpsTrackNative(long j, IBizUserControlImpl iBizUserControlImpl, long j2, GpsTrackDepthInfo gpsTrackDepthInfo);

    private static native int updateRainbowLineNative(long j, IBizUserControlImpl iBizUserControlImpl, ArrayList<ColorSpeedPair> arrayList, ArrayList<RainbowLinePoint> arrayList2);

    private static native void updateSendToCarNative(long j, IBizUserControlImpl iBizUserControlImpl, long j2, BizPointBusinessInfo bizPointBusinessInfo, int i, int i2);

    public IBizUserControlImpl(long j, boolean z) {
        super(IBizUserControlImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.layer.impl.IBizControlImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.layer.impl.IBizControlImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof IBizUserControlImpl) {
            return getUID(this) == getUID((IBizUserControlImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(IBizUserControlImpl iBizUserControlImpl) {
        long cPtr = getCPtr(iBizUserControlImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IBizUserControlImpl iBizUserControlImpl) {
        if (iBizUserControlImpl == null) {
            return 0L;
        }
        return iBizUserControlImpl.swigCPtr;
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

    public void updateGpsTrack(GpsTrackDepthInfo gpsTrackDepthInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateGpsTrackNative(j, this, 0L, gpsTrackDepthInfo);
    }

    public void updateSendToCar(BizPointBusinessInfo bizPointBusinessInfo, int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateSendToCarNative(j, this, 0L, bizPointBusinessInfo, i, i2);
    }

    public void updateFavoriteMain(ArrayList<BizUserFavoritePoint> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateFavoriteMainNative(j, this, arrayList);
    }

    public void updateFavoritePoi(BizUserFavoritePoint bizUserFavoritePoint) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateFavoritePoiNative(j, this, 0L, bizUserFavoritePoint);
    }

    public BaseLayerImpl getUserLayer(@BizUserType.BizUserType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long userLayerNative = getUserLayerNative(j, this, i);
        if (userLayerNative == 0) {
            return null;
        }
        return new BaseLayerImpl(userLayerNative, false);
    }

    public int updateRainbowLine(ArrayList<ColorSpeedPair> arrayList, ArrayList<RainbowLinePoint> arrayList2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return updateRainbowLineNative(j, this, arrayList, arrayList2);
    }

    public boolean setFavoriteScale(@BizUserType.BizUserType1 int i, float[] fArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setFavoriteScaleNative(j, this, i, fArr);
    }
}
