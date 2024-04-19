package com.autonavi.gbl.multi.impl;

import com.autonavi.gbl.common.model.CalcRouteResultData;
import com.autonavi.gbl.consis.impl.ChannelParcelImpl;
import com.autonavi.gbl.util.model.ErrorCode;
/* loaded from: classes2.dex */
public class TBTPathResult extends DispChannelMsg {
    private transient long swigCPtr;

    private static native long TBTPathResult_SWIGUpcast(long j);

    private static native long createNativeObj();

    private static native CalcRouteResultData dataGetNative(long j, TBTPathResult tBTPathResult);

    private static native void dataSetNative(long j, TBTPathResult tBTPathResult, long j2, CalcRouteResultData calcRouteResultData);

    private static native void destroyNativeObj(long j);

    private static native int readFromParcelNative(long j, TBTPathResult tBTPathResult, long j2, ChannelParcelImpl channelParcelImpl);

    private static native int writeToParcelNative(long j, TBTPathResult tBTPathResult, long j2, ChannelParcelImpl channelParcelImpl);

    public TBTPathResult(long j, boolean z) {
        super(TBTPathResult_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    public static long getCPtr(TBTPathResult tBTPathResult) {
        if (tBTPathResult == null) {
            return 0L;
        }
        return tBTPathResult.swigCPtr;
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

    public TBTPathResult() {
        this(createNativeObj(), true);
    }

    public void setData(CalcRouteResultData calcRouteResultData) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        dataSetNative(j, this, 0L, calcRouteResultData);
    }

    public CalcRouteResultData getData() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return dataGetNative(j, this);
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
