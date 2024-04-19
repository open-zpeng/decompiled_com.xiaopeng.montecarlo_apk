package com.autonavi.gbl.multi.impl;

import com.autonavi.gbl.consis.impl.ChannelParcelImpl;
import com.autonavi.gbl.map.layer.model.OpenLayerID;
import com.autonavi.gbl.util.model.ErrorCode;
/* loaded from: classes2.dex */
public class OpenLayerIdParcel extends DispChannelMsg {
    private transient long swigCPtr;

    private static native long OpenLayerIdParcel_SWIGUpcast(long j);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native String jsonContentGetNative(long j, OpenLayerIdParcel openLayerIdParcel);

    private static native void jsonContentSetNative(long j, OpenLayerIdParcel openLayerIdParcel, String str);

    private static native int openlayerIdGetNative(long j, OpenLayerIdParcel openLayerIdParcel);

    private static native void openlayerIdSetNative(long j, OpenLayerIdParcel openLayerIdParcel, int i);

    private static native int readFromParcelNative(long j, OpenLayerIdParcel openLayerIdParcel, long j2, ChannelParcelImpl channelParcelImpl);

    private static native boolean showGetNative(long j, OpenLayerIdParcel openLayerIdParcel);

    private static native void showSetNative(long j, OpenLayerIdParcel openLayerIdParcel, boolean z);

    private static native int writeToParcelNative(long j, OpenLayerIdParcel openLayerIdParcel, long j2, ChannelParcelImpl channelParcelImpl);

    public OpenLayerIdParcel(long j, boolean z) {
        super(OpenLayerIdParcel_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    public static long getCPtr(OpenLayerIdParcel openLayerIdParcel) {
        if (openLayerIdParcel == null) {
            return 0L;
        }
        return openLayerIdParcel.swigCPtr;
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

    public void setOpenlayerId(@OpenLayerID.OpenLayerID1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        openlayerIdSetNative(j, this, i);
    }

    @OpenLayerID.OpenLayerID1
    public int getOpenlayerId() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return openlayerIdGetNative(j, this);
    }

    public void setJsonContent(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        jsonContentSetNative(j, this, str);
    }

    public String getJsonContent() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return jsonContentGetNative(j, this);
    }

    public void setShow(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        showSetNative(j, this, z);
    }

    public boolean getShow() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return showGetNative(j, this);
    }

    public OpenLayerIdParcel() {
        this(createNativeObj(), true);
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
