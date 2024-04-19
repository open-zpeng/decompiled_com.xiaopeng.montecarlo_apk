package com.autonavi.gbl.multi.impl;

import com.autonavi.gbl.consis.impl.ChannelParcelImpl;
import com.autonavi.gbl.util.model.ErrorCode;
/* loaded from: classes2.dex */
public class FloatParamParcel extends DispChannelMsg {
    private transient long swigCPtr;

    private static native long FloatParamParcel_SWIGUpcast(long j);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native float floatParamGetNative(long j, FloatParamParcel floatParamParcel);

    private static native void floatParamSetNative(long j, FloatParamParcel floatParamParcel, float f);

    private static native int readFromParcelNative(long j, FloatParamParcel floatParamParcel, long j2, ChannelParcelImpl channelParcelImpl);

    private static native int writeToParcelNative(long j, FloatParamParcel floatParamParcel, long j2, ChannelParcelImpl channelParcelImpl);

    public FloatParamParcel(long j, boolean z) {
        super(FloatParamParcel_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    public static long getCPtr(FloatParamParcel floatParamParcel) {
        if (floatParamParcel == null) {
            return 0L;
        }
        return floatParamParcel.swigCPtr;
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

    public void setFloatParam(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        floatParamSetNative(j, this, f);
    }

    public float getFloatParam() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return floatParamGetNative(j, this);
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

    public FloatParamParcel() {
        this(createNativeObj(), true);
    }
}
