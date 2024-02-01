package com.autonavi.gbl.util.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.util.model.KeyValue;
import com.autonavi.gbl.util.model.NetworkStatus;
import com.autonavi.gbl.util.observer.IPlatformInterface;
import java.util.ArrayList;
@IntfAuto(target = IPlatformInterface.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IPlatformInterfaceImpl {
    private static BindTable BIND_TABLE = new BindTable(IPlatformInterfaceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IPlatformInterfaceImpl_change_ownership(IPlatformInterfaceImpl iPlatformInterfaceImpl, long j, boolean z);

    private static native void IPlatformInterfaceImpl_director_connect(IPlatformInterfaceImpl iPlatformInterfaceImpl, long j, boolean z, boolean z2);

    private static native String amapDecodeNative(long j, IPlatformInterfaceImpl iPlatformInterfaceImpl, byte[] bArr);

    private static native String amapEncodeBinaryNative(long j, IPlatformInterfaceImpl iPlatformInterfaceImpl, byte[] bArr);

    private static native String amapEncodeNative(long j, IPlatformInterfaceImpl iPlatformInterfaceImpl, byte[] bArr);

    private static native void copyAssetFileNative(long j, IPlatformInterfaceImpl iPlatformInterfaceImpl, String str, String str2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native boolean getAosNetworkParamNative(long j, IPlatformInterfaceImpl iPlatformInterfaceImpl, ArrayList<KeyValue> arrayList);

    private static native boolean getAosSignNative(long j, IPlatformInterfaceImpl iPlatformInterfaceImpl, String str, String[] strArr);

    private static native ArrayList<KeyValue> getCdnNetworkParamNative(long j, IPlatformInterfaceImpl iPlatformInterfaceImpl);

    private static native int getDensityDpiNative(long j, IPlatformInterfaceImpl iPlatformInterfaceImpl, int i);

    private static native float getDensityNative(long j, IPlatformInterfaceImpl iPlatformInterfaceImpl, int i);

    private static native int getNetStatusNative(long j, IPlatformInterfaceImpl iPlatformInterfaceImpl);

    public IPlatformInterfaceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IPlatformInterfaceImpl) && getUID(this) == getUID((IPlatformInterfaceImpl) obj);
    }

    private static long getUID(IPlatformInterfaceImpl iPlatformInterfaceImpl) {
        long cPtr = getCPtr(iPlatformInterfaceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IPlatformInterfaceImpl iPlatformInterfaceImpl) {
        if (iPlatformInterfaceImpl == null) {
            return 0L;
        }
        return iPlatformInterfaceImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    public boolean isCMemOwn() {
        return this.swigCMemOwn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        IPlatformInterfaceImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IPlatformInterfaceImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void copyAssetFile(String str, String str2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        copyAssetFileNative(j, this, str, str2);
    }

    public float getDensity(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getDensityNative(j, this, i);
    }

    public int getDensityDpi(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getDensityDpiNative(j, this, i);
    }

    @NetworkStatus.NetworkStatus1
    public int getNetStatus() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getNetStatusNative(j, this);
    }

    public ArrayList<KeyValue> getCdnNetworkParam() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getCdnNetworkParamNative(j, this);
    }

    public boolean getAosNetworkParam(ArrayList<KeyValue> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAosNetworkParamNative(j, this, arrayList);
    }

    public String amapEncode(byte[] bArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return amapEncodeNative(j, this, bArr);
    }

    public String amapEncodeBinary(byte[] bArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return amapEncodeBinaryNative(j, this, bArr);
    }

    public String amapDecode(byte[] bArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return amapDecodeNative(j, this, bArr);
    }

    public boolean getAosSign(String str, String[] strArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAosSignNative(j, this, str, strArr);
    }

    public IPlatformInterfaceImpl() {
        this(createNativeObj(), true);
        UtilModelObserverJNI.swig_jni_init();
        IPlatformInterfaceImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
