package com.autonavi.gbl.consis.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.option.impl.IRouteOptionImpl;
import com.autonavi.gbl.consis.ChannelSerializeControl;
@IntfAuto(target = ChannelSerializeControl.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ChannelSerializeControlImpl {
    private static BindTable BIND_TABLE = new BindTable(ChannelSerializeControlImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void readFromParcelNative(long j, ChannelParcelImpl channelParcelImpl, long j2, IRouteOptionImpl iRouteOptionImpl);

    private static native void writeToParcelNative(long j, ChannelParcelImpl channelParcelImpl, long j2, IRouteOptionImpl iRouteOptionImpl);

    public ChannelSerializeControlImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ChannelSerializeControlImpl) && getUID(this) == getUID((ChannelSerializeControlImpl) obj);
    }

    private static long getUID(ChannelSerializeControlImpl channelSerializeControlImpl) {
        long cPtr = getCPtr(channelSerializeControlImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ChannelSerializeControlImpl channelSerializeControlImpl) {
        if (channelSerializeControlImpl == null) {
            return 0L;
        }
        return channelSerializeControlImpl.swigCPtr;
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

    public static void writeToParcel(ChannelParcelImpl channelParcelImpl, IRouteOptionImpl iRouteOptionImpl) {
        writeToParcelNative(ChannelParcelImpl.getCPtr(channelParcelImpl), channelParcelImpl, IRouteOptionImpl.getCPtr(iRouteOptionImpl), iRouteOptionImpl);
    }

    public static void readFromParcel(ChannelParcelImpl channelParcelImpl, IRouteOptionImpl iRouteOptionImpl) {
        readFromParcelNative(ChannelParcelImpl.getCPtr(channelParcelImpl), channelParcelImpl, IRouteOptionImpl.getCPtr(iRouteOptionImpl), iRouteOptionImpl);
    }

    public ChannelSerializeControlImpl() {
        this(createNativeObj(), true);
    }
}
