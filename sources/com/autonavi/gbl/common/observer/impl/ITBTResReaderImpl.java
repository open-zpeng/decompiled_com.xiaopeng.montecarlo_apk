package com.autonavi.gbl.common.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.model.TBTResReaderType;
import com.autonavi.gbl.common.observer.ITBTResReader;
@IntfAuto(target = ITBTResReader.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ITBTResReaderImpl {
    private static BindTable BIND_TABLE = new BindTable(ITBTResReaderImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ITBTResReaderImpl_change_ownership(ITBTResReaderImpl iTBTResReaderImpl, long j, boolean z);

    private static native void ITBTResReaderImpl_director_connect(ITBTResReaderImpl iTBTResReaderImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native byte[] readDataNative(long j, ITBTResReaderImpl iTBTResReaderImpl, int i, int i2);

    private static native void releaseNative(long j, ITBTResReaderImpl iTBTResReaderImpl, byte[] bArr);

    public ITBTResReaderImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ITBTResReaderImpl) && getUID(this) == getUID((ITBTResReaderImpl) obj);
    }

    private static long getUID(ITBTResReaderImpl iTBTResReaderImpl) {
        long cPtr = getCPtr(iTBTResReaderImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ITBTResReaderImpl iTBTResReaderImpl) {
        if (iTBTResReaderImpl == null) {
            return 0L;
        }
        return iTBTResReaderImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
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
        ITBTResReaderImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ITBTResReaderImpl_change_ownership(this, this.swigCPtr, true);
    }

    public byte[] readData(@TBTResReaderType.TBTResReaderType1 int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return readDataNative(j, this, i, i2);
    }

    public void release(byte[] bArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        releaseNative(j, this, bArr);
    }

    public ITBTResReaderImpl() {
        this(createNativeObj(), true);
        BLCommonObserverJNI.swig_jni_init();
        ITBTResReaderImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
