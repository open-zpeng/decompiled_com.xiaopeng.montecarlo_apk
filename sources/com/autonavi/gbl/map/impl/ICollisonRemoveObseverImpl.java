package com.autonavi.gbl.map.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.map.observer.ICollisonRemoveObsever;
import java.util.ArrayList;
@IntfAuto(target = ICollisonRemoveObsever.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICollisonRemoveObseverImpl {
    private static BindTable BIND_TABLE = new BindTable(ICollisonRemoveObseverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICollisonRemoveObseverImpl_change_ownership(ICollisonRemoveObseverImpl iCollisonRemoveObseverImpl, long j, boolean z);

    private static native void ICollisonRemoveObseverImpl_director_connect(ICollisonRemoveObseverImpl iCollisonRemoveObseverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecoverCollisonItemNative(long j, ICollisonRemoveObseverImpl iCollisonRemoveObseverImpl, long j2, ICollisionItemImpl iCollisionItemImpl);

    private static native void removeCollisionItemsNative(long j, ICollisonRemoveObseverImpl iCollisonRemoveObseverImpl, long[] jArr);

    public ICollisonRemoveObseverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICollisonRemoveObseverImpl) && getUID(this) == getUID((ICollisonRemoveObseverImpl) obj);
    }

    private static long getUID(ICollisonRemoveObseverImpl iCollisonRemoveObseverImpl) {
        long cPtr = getCPtr(iCollisonRemoveObseverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICollisonRemoveObseverImpl iCollisonRemoveObseverImpl) {
        if (iCollisonRemoveObseverImpl == null) {
            return 0L;
        }
        return iCollisonRemoveObseverImpl.swigCPtr;
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
        ICollisonRemoveObseverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICollisonRemoveObseverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void removeCollisionItems(ArrayList<ICollisionItemImpl> arrayList) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        long[] jArr = null;
        if (arrayList != null) {
            int size = arrayList.size();
            long[] jArr2 = new long[size];
            for (int i = 0; i < size; i++) {
                jArr2[i] = ICollisionItemImpl.getCPtr(arrayList.get(i));
            }
            jArr = jArr2;
        }
        removeCollisionItemsNative(this.swigCPtr, this, jArr);
    }

    public void onRecoverCollisonItem(ICollisionItemImpl iCollisionItemImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecoverCollisonItemNative(j, this, ICollisionItemImpl.getCPtr(iCollisionItemImpl), iCollisionItemImpl);
    }

    public ICollisonRemoveObseverImpl() {
        this(createNativeObj(), true);
        MapSvrJNI.swig_jni_init();
        ICollisonRemoveObseverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
