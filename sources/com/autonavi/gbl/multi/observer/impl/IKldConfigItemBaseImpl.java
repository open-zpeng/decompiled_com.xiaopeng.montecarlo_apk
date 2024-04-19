package com.autonavi.gbl.multi.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.multi.adapter.MultiObjectManager;
import com.autonavi.gbl.multi.impl.IKldDisplayImpl;
import com.autonavi.gbl.multi.observer.KldConfigItemBase;
@IntfAuto(target = KldConfigItemBase.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IKldConfigItemBaseImpl {
    private static BindTable BIND_TABLE = new BindTable(IKldConfigItemBaseImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IKldConfigItemBaseImpl_change_ownership(IKldConfigItemBaseImpl iKldConfigItemBaseImpl, long j, boolean z);

    private static native void IKldConfigItemBaseImpl_director_connect(IKldConfigItemBaseImpl iKldConfigItemBaseImpl, long j, boolean z, boolean z2);

    private static native int applyConfigNative(long j, IKldConfigItemBaseImpl iKldConfigItemBaseImpl, long j2, IKldDisplayImpl iKldDisplayImpl);

    private static native long createNativeObj();

    private static native long createNativeObj1(long j, IKldConfigItemBaseImpl iKldConfigItemBaseImpl);

    private static native void destroyNativeObj(long j);

    private static native void getConfigName1Native(long j, IKldConfigItemBaseImpl iKldConfigItemBaseImpl, String[] strArr);

    private static native String getConfigNameNative(long j, IKldConfigItemBaseImpl iKldConfigItemBaseImpl);

    private static native void getTypeName1Native(long j, IKldConfigItemBaseImpl iKldConfigItemBaseImpl, String[] strArr);

    private static native String getTypeNameNative(long j, IKldConfigItemBaseImpl iKldConfigItemBaseImpl);

    private static native int parseConfigStringNative(long j, IKldConfigItemBaseImpl iKldConfigItemBaseImpl, String str);

    private static native void setConfigNameNative(long j, IKldConfigItemBaseImpl iKldConfigItemBaseImpl, String str);

    private static native void setTypeNameNative(long j, IKldConfigItemBaseImpl iKldConfigItemBaseImpl, String str);

    public IKldConfigItemBaseImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IKldConfigItemBaseImpl) && getUID(this) == getUID((IKldConfigItemBaseImpl) obj);
    }

    private static long getUID(IKldConfigItemBaseImpl iKldConfigItemBaseImpl) {
        long cPtr = getCPtr(iKldConfigItemBaseImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IKldConfigItemBaseImpl iKldConfigItemBaseImpl) {
        if (iKldConfigItemBaseImpl == null) {
            return 0L;
        }
        return iKldConfigItemBaseImpl.swigCPtr;
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
        IKldConfigItemBaseImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IKldConfigItemBaseImpl_change_ownership(this, this.swigCPtr, true);
    }

    public IKldConfigItemBaseImpl() {
        this(createNativeObj(), true);
        MultiObserverJNI.swig_jni_init();
        IKldConfigItemBaseImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public IKldConfigItemBaseImpl(IKldConfigItemBaseImpl iKldConfigItemBaseImpl) {
        this(createNativeObj1(getCPtr(iKldConfigItemBaseImpl), iKldConfigItemBaseImpl), true);
        MultiObserverJNI.swig_jni_init();
        IKldConfigItemBaseImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public void setTypeName(String str) {
        $explicit_setTypeName(str);
    }

    public void $explicit_setTypeName(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setTypeNameNative(j, this, str);
    }

    public String getTypeName() {
        return $explicit_getTypeName();
    }

    public String $explicit_getTypeName() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getTypeNameNative(j, this);
    }

    public void getTypeName(String[] strArr) {
        $explicit_getTypeName(strArr);
    }

    public void $explicit_getTypeName(String[] strArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getTypeName1Native(j, this, strArr);
    }

    public void setConfigName(String str) {
        $explicit_setConfigName(str);
    }

    public void $explicit_setConfigName(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setConfigNameNative(j, this, str);
    }

    public String getConfigName() {
        return $explicit_getConfigName();
    }

    public String $explicit_getConfigName() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getConfigNameNative(j, this);
    }

    public void getConfigName(String[] strArr) {
        $explicit_getConfigName(strArr);
    }

    public void $explicit_getConfigName(String[] strArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getConfigName1Native(j, this, strArr);
    }

    public int parseConfigString(String str) {
        return $explicit_parseConfigString(str);
    }

    public void putConfigObject(String str, String str2) {
        MultiObjectManager.getInstance().putConfigObject(str2, this);
    }

    public void removeConfigObject(String str, String str2) {
        MultiObjectManager.getInstance().removeConfigObject(str2);
    }

    public int $explicit_parseConfigString(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return parseConfigStringNative(j, this, str);
    }

    public int applyConfig(IKldDisplayImpl iKldDisplayImpl) {
        return $explicit_applyConfig(iKldDisplayImpl);
    }

    public int $explicit_applyConfig(IKldDisplayImpl iKldDisplayImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return applyConfigNative(j, this, IKldDisplayImpl.getCPtr(iKldDisplayImpl), iKldDisplayImpl);
    }
}
