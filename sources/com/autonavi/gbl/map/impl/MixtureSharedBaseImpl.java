package com.autonavi.gbl.map.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.MixtureSharedBase;
@IntfAuto(target = MixtureSharedBase.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class MixtureSharedBaseImpl {
    private static BindTable BIND_TABLE = new BindTable(MixtureSharedBaseImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void MixtureSharedBaseImpl_change_ownership(MixtureSharedBaseImpl mixtureSharedBaseImpl, long j, boolean z);

    private static native void MixtureSharedBaseImpl_director_connect(MixtureSharedBaseImpl mixtureSharedBaseImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    public MixtureSharedBaseImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof MixtureSharedBaseImpl) && getUID(this) == getUID((MixtureSharedBaseImpl) obj);
    }

    private static long getUID(MixtureSharedBaseImpl mixtureSharedBaseImpl) {
        long cPtr = getCPtr(mixtureSharedBaseImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(MixtureSharedBaseImpl mixtureSharedBaseImpl) {
        if (mixtureSharedBaseImpl == null) {
            return 0L;
        }
        return mixtureSharedBaseImpl.swigCPtr;
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
        MixtureSharedBaseImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        MixtureSharedBaseImpl_change_ownership(this, this.swigCPtr, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MixtureSharedBaseImpl() {
        this(createNativeObj(), true);
        MapSvrJNI.swig_jni_init();
        MixtureSharedBaseImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
