package com.autonavi.gbl.map.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.observer.ITextTextureObserver;
@IntfAuto(target = ITextTextureObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class ITextTextureObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ITextTextureObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ITextTextureObserverImpl_change_ownership(ITextTextureObserverImpl iTextTextureObserverImpl, long j, boolean z);

    private static native void ITextTextureObserverImpl_director_connect(ITextTextureObserverImpl iTextTextureObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native byte[] getCharBitmapNative(long j, ITextTextureObserverImpl iTextTextureObserverImpl, long j2, int i, int i2);

    private static native byte[] getCharsWidthsNative(long j, ITextTextureObserverImpl iTextTextureObserverImpl, long j2, short[] sArr, int i);

    public ITextTextureObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ITextTextureObserverImpl) && getUID(this) == getUID((ITextTextureObserverImpl) obj);
    }

    private static long getUID(ITextTextureObserverImpl iTextTextureObserverImpl) {
        long cPtr = getCPtr(iTextTextureObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ITextTextureObserverImpl iTextTextureObserverImpl) {
        if (iTextTextureObserverImpl == null) {
            return 0L;
        }
        return iTextTextureObserverImpl.swigCPtr;
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
        ITextTextureObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ITextTextureObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public byte[] getCharBitmap(long j, int i, int i2) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return getCharBitmapNative(j2, this, j, i, i2);
    }

    public byte[] getCharsWidths(long j, short[] sArr, int i) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return getCharsWidthsNative(j2, this, j, sArr, i);
    }

    public ITextTextureObserverImpl() {
        this(createNativeObj(), true);
        MapObserverJNI.swig_jni_init();
        ITextTextureObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
