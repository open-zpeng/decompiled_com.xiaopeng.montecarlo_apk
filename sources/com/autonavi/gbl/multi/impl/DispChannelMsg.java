package com.autonavi.gbl.multi.impl;

import com.autonavi.gbl.consis.impl.ChannelParcelImpl;
import com.autonavi.gbl.multi.model.DisplayType;
import com.autonavi.gbl.util.model.ErrorCode;
/* loaded from: classes2.dex */
public class DispChannelMsg extends RenderChannelParcelable {
    private transient long swigCPtr;

    private static native long DispChannelMsg_SWIGUpcast(long j);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native int displayTypeGetNative(long j, DispChannelMsg dispChannelMsg);

    private static native void displayTypeSetNative(long j, DispChannelMsg dispChannelMsg, int i);

    private static native int readFromParcelNative(long j, DispChannelMsg dispChannelMsg, long j2, ChannelParcelImpl channelParcelImpl);

    private static native int writeToParcelNative(long j, DispChannelMsg dispChannelMsg, long j2, ChannelParcelImpl channelParcelImpl);

    public DispChannelMsg(long j, boolean z) {
        super(DispChannelMsg_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    public static long getCPtr(DispChannelMsg dispChannelMsg) {
        if (dispChannelMsg == null) {
            return 0L;
        }
        return dispChannelMsg.swigCPtr;
    }

    @Override // com.autonavi.gbl.multi.impl.RenderChannelParcelable, com.autonavi.gbl.consis.impl.ChannelParcelable
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

    public DispChannelMsg() {
        this(createNativeObj(), true);
    }

    public void setDisplayType(@DisplayType.DisplayType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        displayTypeSetNative(j, this, i);
    }

    @DisplayType.DisplayType1
    public int getDisplayType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return displayTypeGetNative(j, this);
    }

    @Override // com.autonavi.gbl.consis.impl.ChannelParcelable
    @ErrorCode.ErrorCode1
    public int writeToParcel(ChannelParcelImpl channelParcelImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return writeToParcelNative(j, this, ChannelParcelImpl.getCPtr(channelParcelImpl), channelParcelImpl);
    }

    @Override // com.autonavi.gbl.consis.impl.ChannelParcelable
    @ErrorCode.ErrorCode1
    public int readFromParcel(ChannelParcelImpl channelParcelImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return readFromParcelNative(j, this, ChannelParcelImpl.getCPtr(channelParcelImpl), channelParcelImpl);
    }
}
