package com.autonavi.gbl.multi.impl;

import com.autonavi.gbl.consis.impl.ChannelParcelImpl;
import com.autonavi.gbl.util.model.ErrorCode;
/* loaded from: classes2.dex */
public class IntParamParcel extends DispChannelMsg {
    private transient long swigCPtr;

    private static native long IntParamParcel_SWIGUpcast(long j);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native int iValueGetNative(long j, IntParamParcel intParamParcel);

    private static native void iValueSetNative(long j, IntParamParcel intParamParcel, int i);

    private static native int readFromParcelNative(long j, IntParamParcel intParamParcel, long j2, ChannelParcelImpl channelParcelImpl);

    private static native int writeToParcelNative(long j, IntParamParcel intParamParcel, long j2, ChannelParcelImpl channelParcelImpl);

    public IntParamParcel(long j, boolean z) {
        super(IntParamParcel_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    public static long getCPtr(IntParamParcel intParamParcel) {
        if (intParamParcel == null) {
            return 0L;
        }
        return intParamParcel.swigCPtr;
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

    public void setIValue(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        iValueSetNative(j, this, i);
    }

    public int getIValue() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return iValueGetNative(j, this);
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

    public IntParamParcel() {
        this(createNativeObj(), true);
    }
}
