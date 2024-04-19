package com.autonavi.gbl.multi.impl;

import com.autonavi.gbl.consis.impl.Parcel;
/* loaded from: classes2.dex */
public class KldIntentInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native String keyGetNative(long j, KldIntentInfo kldIntentInfo);

    private static native void keySetNative(long j, KldIntentInfo kldIntentInfo, String str);

    private static native long parcelGetNative(long j, KldIntentInfo kldIntentInfo);

    private static native void parcelSetNative(long j, KldIntentInfo kldIntentInfo, long j2, Parcel parcel);

    public KldIntentInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(KldIntentInfo kldIntentInfo) {
        if (kldIntentInfo == null) {
            return 0L;
        }
        return kldIntentInfo.swigCPtr;
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

    public void setKey(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        keySetNative(j, this, str);
    }

    public String getKey() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return keyGetNative(j, this);
    }

    public void setParcel(Parcel parcel) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        parcelSetNative(j, this, Parcel.getCPtr(parcel), parcel);
    }

    public Parcel getParcel() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long parcelGetNative = parcelGetNative(j, this);
        if (parcelGetNative == 0) {
            return null;
        }
        return new Parcel(parcelGetNative, false);
    }

    public KldIntentInfo() {
        this(createNativeObj(), true);
    }
}
