package com.autonavi.gbl.multi.impl;

import com.autonavi.gbl.consis.impl.ChannelParcelImpl;
import com.autonavi.gbl.map.model.MapviewModeParam;
import com.autonavi.gbl.util.model.ErrorCode;
/* loaded from: classes2.dex */
public class MapViewModeParamParcel extends DispChannelMsg {
    private transient long swigCPtr;

    private static native long MapViewModeParamParcel_SWIGUpcast(long j);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native MapviewModeParam modeParamGetNative(long j, MapViewModeParamParcel mapViewModeParamParcel);

    private static native void modeParamSetNative(long j, MapViewModeParamParcel mapViewModeParamParcel, long j2, MapviewModeParam mapviewModeParam);

    private static native int readFromParcelNative(long j, MapViewModeParamParcel mapViewModeParamParcel, long j2, ChannelParcelImpl channelParcelImpl);

    private static native int writeToParcelNative(long j, MapViewModeParamParcel mapViewModeParamParcel, long j2, ChannelParcelImpl channelParcelImpl);

    public MapViewModeParamParcel(long j, boolean z) {
        super(MapViewModeParamParcel_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    public static long getCPtr(MapViewModeParamParcel mapViewModeParamParcel) {
        if (mapViewModeParamParcel == null) {
            return 0L;
        }
        return mapViewModeParamParcel.swigCPtr;
    }

    @Override // com.autonavi.gbl.multi.impl.DispChannelMsg, com.autonavi.gbl.multi.impl.RenderChannelParcelable, com.autonavi.gbl.consis.impl.ChannelParcelable
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

    public MapViewModeParamParcel() {
        this(createNativeObj(), true);
    }

    public void setModeParam(MapviewModeParam mapviewModeParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        modeParamSetNative(j, this, 0L, mapviewModeParam);
    }

    public MapviewModeParam getModeParam() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return modeParamGetNative(j, this);
    }

    @Override // com.autonavi.gbl.multi.impl.DispChannelMsg, com.autonavi.gbl.consis.impl.ChannelParcelable
    @ErrorCode.ErrorCode1
    public int writeToParcel(ChannelParcelImpl channelParcelImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return writeToParcelNative(j, this, ChannelParcelImpl.getCPtr(channelParcelImpl), channelParcelImpl);
    }

    @Override // com.autonavi.gbl.multi.impl.DispChannelMsg, com.autonavi.gbl.consis.impl.ChannelParcelable
    @ErrorCode.ErrorCode1
    public int readFromParcel(ChannelParcelImpl channelParcelImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return readFromParcelNative(j, this, ChannelParcelImpl.getCPtr(channelParcelImpl), channelParcelImpl);
    }
}
