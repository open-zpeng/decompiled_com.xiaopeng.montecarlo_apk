package com.autonavi.gbl.card.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.card.observer.IFileContentLoader;
import com.autonavi.gbl.util.model.BinaryStream;
@IntfAuto(target = IFileContentLoader.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IFileContentLoaderImpl {
    private static BindTable BIND_TABLE = new BindTable(IFileContentLoaderImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IFileContentLoaderImpl_change_ownership(IFileContentLoaderImpl iFileContentLoaderImpl, long j, boolean z);

    private static native void IFileContentLoaderImpl_director_connect(IFileContentLoaderImpl iFileContentLoaderImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native boolean loadFileContentNative(long j, IFileContentLoaderImpl iFileContentLoaderImpl, String str, long j2, BinaryStream binaryStream, String[] strArr);

    public IFileContentLoaderImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IFileContentLoaderImpl) && getUID(this) == getUID((IFileContentLoaderImpl) obj);
    }

    private static long getUID(IFileContentLoaderImpl iFileContentLoaderImpl) {
        long cPtr = getCPtr(iFileContentLoaderImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IFileContentLoaderImpl iFileContentLoaderImpl) {
        if (iFileContentLoaderImpl == null) {
            return 0L;
        }
        return iFileContentLoaderImpl.swigCPtr;
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
        IFileContentLoaderImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IFileContentLoaderImpl_change_ownership(this, this.swigCPtr, true);
    }

    public boolean loadFileContent(String str, BinaryStream binaryStream, String[] strArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return loadFileContentNative(j, this, str, 0L, binaryStream, strArr);
    }

    public IFileContentLoaderImpl() {
        this(createNativeObj(), true);
        CardModelObserverJNI.swig_jni_init();
        IFileContentLoaderImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
