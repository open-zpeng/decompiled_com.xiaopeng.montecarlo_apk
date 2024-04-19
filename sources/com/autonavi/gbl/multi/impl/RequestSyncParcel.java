package com.autonavi.gbl.multi.impl;

import com.autonavi.gbl.consis.impl.ChannelParcelImpl;
import com.autonavi.gbl.util.model.ErrorCode;
/* loaded from: classes2.dex */
public class RequestSyncParcel extends DispChannelMsg {
    private transient long swigCPtr;

    private static native long RequestSyncParcel_SWIGUpcast(long j);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native int readFromParcelNative(long j, RequestSyncParcel requestSyncParcel, long j2, ChannelParcelImpl channelParcelImpl);

    private static native int requestTypeGetNative(long j, RequestSyncParcel requestSyncParcel);

    private static native void requestTypeSetNative(long j, RequestSyncParcel requestSyncParcel, int i);

    private static native int targetDispTypeGetNative(long j, RequestSyncParcel requestSyncParcel);

    private static native void targetDispTypeSetNative(long j, RequestSyncParcel requestSyncParcel, int i);

    private static native int writeToParcelNative(long j, RequestSyncParcel requestSyncParcel, long j2, ChannelParcelImpl channelParcelImpl);

    public RequestSyncParcel(long j, boolean z) {
        super(RequestSyncParcel_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    public static long getCPtr(RequestSyncParcel requestSyncParcel) {
        if (requestSyncParcel == null) {
            return 0L;
        }
        return requestSyncParcel.swigCPtr;
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

    public void setRequestType(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        requestTypeSetNative(j, this, i);
    }

    public int getRequestType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return requestTypeGetNative(j, this);
    }

    public void setTargetDispType(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        targetDispTypeSetNative(j, this, i);
    }

    public int getTargetDispType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return targetDispTypeGetNative(j, this);
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

    public RequestSyncParcel() {
        this(createNativeObj(), true);
    }
}
