package com.autonavi.gbl.util.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.util.BlQrcodeGen;
import com.autonavi.gbl.util.model.QrCodeStream;
@IntfAuto(target = BlQrcodeGen.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class BlQrcodeGenImpl {
    private static BindTable BIND_TABLE = new BindTable(BlQrcodeGenImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native boolean stringToQrcodeNative(String str, long j, QrCodeStream qrCodeStream);

    public BlQrcodeGenImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof BlQrcodeGenImpl) && getUID(this) == getUID((BlQrcodeGenImpl) obj);
    }

    private static long getUID(BlQrcodeGenImpl blQrcodeGenImpl) {
        long cPtr = getCPtr(blQrcodeGenImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(BlQrcodeGenImpl blQrcodeGenImpl) {
        if (blQrcodeGenImpl == null) {
            return 0L;
        }
        return blQrcodeGenImpl.swigCPtr;
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

    public BlQrcodeGenImpl() {
        this(createNativeObj(), true);
    }

    public static QrCodeStream stringToQrcode(String str) {
        QrCodeStream qrCodeStream = new QrCodeStream();
        if (Boolean.valueOf(stringToQrcode(str, qrCodeStream)).booleanValue()) {
            return qrCodeStream;
        }
        return null;
    }

    private static boolean stringToQrcode(String str, QrCodeStream qrCodeStream) {
        return stringToQrcodeNative(str, 0L, qrCodeStream);
    }
}
