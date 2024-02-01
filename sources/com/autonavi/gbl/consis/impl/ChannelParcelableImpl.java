package com.autonavi.gbl.consis.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.consis.ChannelParcelable;
import com.autonavi.gbl.consis.model.ChannelMessageType;
@IntfAuto(target = ChannelParcelable.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ChannelParcelableImpl {
    private static BindTable BIND_TABLE = new BindTable(ChannelParcelableImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void destroyNativeObj(long j);

    private static native int msgTypeGetNative(long j, ChannelParcelableImpl channelParcelableImpl);

    private static native void msgTypeSetNative(long j, ChannelParcelableImpl channelParcelableImpl, int i);

    private static native int readFromParcelNative(long j, ChannelParcelableImpl channelParcelableImpl, long j2, ChannelParcelImpl channelParcelImpl);

    private static native int subTypeGetNative(long j, ChannelParcelableImpl channelParcelableImpl);

    private static native void subTypeSetNative(long j, ChannelParcelableImpl channelParcelableImpl, int i);

    private static native int writeToParcelNative(long j, ChannelParcelableImpl channelParcelableImpl, long j2, ChannelParcelImpl channelParcelImpl);

    public ChannelParcelableImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ChannelParcelableImpl) && getUID(this) == getUID((ChannelParcelableImpl) obj);
    }

    private static long getUID(ChannelParcelableImpl channelParcelableImpl) {
        long cPtr = getCPtr(channelParcelableImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ChannelParcelableImpl channelParcelableImpl) {
        if (channelParcelableImpl == null) {
            return 0L;
        }
        return channelParcelableImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    public boolean isCMemOwn() {
        return this.swigCMemOwn;
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setMsgType(@ChannelMessageType.ChannelMessageType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        msgTypeSetNative(j, this, i);
    }

    @ChannelMessageType.ChannelMessageType1
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

    public int writeToParcel(ChannelParcelImpl channelParcelImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return writeToParcelNative(j, this, ChannelParcelImpl.getCPtr(channelParcelImpl), channelParcelImpl);
    }

    public int readFromParcel(ChannelParcelImpl channelParcelImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return readFromParcelNative(j, this, ChannelParcelImpl.getCPtr(channelParcelImpl), channelParcelImpl);
    }
}
