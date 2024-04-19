package com.autonavi.gbl.consis.impl;

import com.autonavi.gbl.consis.model.CHANNEL_MSG_TYPE;
import com.autonavi.gbl.util.model.ErrorCode;
/* loaded from: classes.dex */
public class ChannelParcelable {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void destroyNativeObj(long j);

    private static native int msgTypeGetNative(long j, ChannelParcelable channelParcelable);

    private static native void msgTypeSetNative(long j, ChannelParcelable channelParcelable, int i);

    private static native int readFromParcelNative(long j, ChannelParcelable channelParcelable, long j2, ChannelParcelImpl channelParcelImpl);

    private static native int subTypeGetNative(long j, ChannelParcelable channelParcelable);

    private static native void subTypeSetNative(long j, ChannelParcelable channelParcelable, int i);

    private static native int writeToParcelNative(long j, ChannelParcelable channelParcelable, long j2, ChannelParcelImpl channelParcelImpl);

    public ChannelParcelable(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ChannelParcelable channelParcelable) {
        if (channelParcelable == null) {
            return 0L;
        }
        return channelParcelable.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setMsgType(@CHANNEL_MSG_TYPE.CHANNEL_MSG_TYPE1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        msgTypeSetNative(j, this, i);
    }

    @CHANNEL_MSG_TYPE.CHANNEL_MSG_TYPE1
    public int getMsgType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return msgTypeGetNative(j, this);
    }

    public void setSubType(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        subTypeSetNative(j, this, i);
    }

    public int getSubType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return subTypeGetNative(j, this);
    }

    @ErrorCode.ErrorCode1
    public int writeToParcel(ChannelParcelImpl channelParcelImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return writeToParcelNative(j, this, ChannelParcelImpl.getCPtr(channelParcelImpl), channelParcelImpl);
    }

    @ErrorCode.ErrorCode1
    public int readFromParcel(ChannelParcelImpl channelParcelImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return readFromParcelNative(j, this, ChannelParcelImpl.getCPtr(channelParcelImpl), channelParcelImpl);
    }
}
