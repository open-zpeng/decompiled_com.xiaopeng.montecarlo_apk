package com.autonavi.gbl.multi.impl;

import com.autonavi.gbl.consis.impl.ChannelParcelImpl;
import com.autonavi.gbl.util.model.ErrorCode;
/* loaded from: classes2.dex */
public class MapZoomLevelParcel extends DispChannelMsg {
    private transient long swigCPtr;

    private static native long MapZoomLevelParcel_SWIGUpcast(long j);

    private static native boolean animationGetNative(long j, MapZoomLevelParcel mapZoomLevelParcel);

    private static native void animationSetNative(long j, MapZoomLevelParcel mapZoomLevelParcel, boolean z);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native float mapZoomLevelGetNative(long j, MapZoomLevelParcel mapZoomLevelParcel);

    private static native void mapZoomLevelSetNative(long j, MapZoomLevelParcel mapZoomLevelParcel, float f);

    private static native int readFromParcelNative(long j, MapZoomLevelParcel mapZoomLevelParcel, long j2, ChannelParcelImpl channelParcelImpl);

    private static native boolean syncGetNative(long j, MapZoomLevelParcel mapZoomLevelParcel);

    private static native void syncSetNative(long j, MapZoomLevelParcel mapZoomLevelParcel, boolean z);

    private static native int writeToParcelNative(long j, MapZoomLevelParcel mapZoomLevelParcel, long j2, ChannelParcelImpl channelParcelImpl);

    public MapZoomLevelParcel(long j, boolean z) {
        super(MapZoomLevelParcel_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    public static long getCPtr(MapZoomLevelParcel mapZoomLevelParcel) {
        if (mapZoomLevelParcel == null) {
            return 0L;
        }
        return mapZoomLevelParcel.swigCPtr;
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

    public MapZoomLevelParcel() {
        this(createNativeObj(), true);
    }

    public void setMapZoomLevel(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mapZoomLevelSetNative(j, this, f);
    }

    public float getMapZoomLevel() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mapZoomLevelGetNative(j, this);
    }

    public void setAnimation(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        animationSetNative(j, this, z);
    }

    public boolean getAnimation() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return animationGetNative(j, this);
    }

    public void setSync(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        syncSetNative(j, this, z);
    }

    public boolean getSync() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return syncGetNative(j, this);
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
