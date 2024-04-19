package com.autonavi.gbl.multi.impl;

import com.autonavi.gbl.consis.impl.ChannelParcelImpl;
import com.autonavi.gbl.map.model.MapStyleParam;
import com.autonavi.gbl.util.model.ErrorCode;
/* loaded from: classes2.dex */
public class MapDayNightModeParcel extends DispChannelMsg {
    private transient long swigCPtr;

    private static native long MapDayNightModeParcel_SWIGUpcast(long j);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native int readFromParcelNative(long j, MapDayNightModeParcel mapDayNightModeParcel, long j2, ChannelParcelImpl channelParcelImpl);

    private static native MapStyleParam styleParamGetNative(long j, MapDayNightModeParcel mapDayNightModeParcel);

    private static native void styleParamSetNative(long j, MapDayNightModeParcel mapDayNightModeParcel, long j2, MapStyleParam mapStyleParam);

    private static native int writeToParcelNative(long j, MapDayNightModeParcel mapDayNightModeParcel, long j2, ChannelParcelImpl channelParcelImpl);

    public MapDayNightModeParcel(long j, boolean z) {
        super(MapDayNightModeParcel_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    public static long getCPtr(MapDayNightModeParcel mapDayNightModeParcel) {
        if (mapDayNightModeParcel == null) {
            return 0L;
        }
        return mapDayNightModeParcel.swigCPtr;
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

    public MapDayNightModeParcel() {
        this(createNativeObj(), true);
    }

    public void setStyleParam(MapStyleParam mapStyleParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        styleParamSetNative(j, this, 0L, mapStyleParam);
    }

    public MapStyleParam getStyleParam() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return styleParamGetNative(j, this);
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
