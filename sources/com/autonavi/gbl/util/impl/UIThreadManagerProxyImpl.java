package com.autonavi.gbl.util.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.util.UIThreadManagerProxy;
import java.util.HashMap;
@IntfAuto(target = UIThreadManagerProxy.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class UIThreadManagerProxyImpl {
    private static BindTable BIND_TABLE = new BindTable(UIThreadManagerProxyImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native boolean getAllUIThreadNative(HashMap<Integer, UITaskThreadInfoImpl> hashMap);

    private static native boolean getUIThreadByMinIDNative(long j, UITaskThreadInfoImpl uITaskThreadInfoImpl);

    private static native boolean getUIThreadNative(int i, long j, UITaskThreadInfoImpl uITaskThreadInfoImpl);

    private static native boolean removeUIThreadNative(int i);

    private static native boolean setUIThreadNative(int i, long j, UITaskThreadInfoImpl uITaskThreadInfoImpl);

    public UIThreadManagerProxyImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof UIThreadManagerProxyImpl) && getUID(this) == getUID((UIThreadManagerProxyImpl) obj);
    }

    private static long getUID(UIThreadManagerProxyImpl uIThreadManagerProxyImpl) {
        long cPtr = getCPtr(uIThreadManagerProxyImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(UIThreadManagerProxyImpl uIThreadManagerProxyImpl) {
        if (uIThreadManagerProxyImpl == null) {
            return 0L;
        }
        return uIThreadManagerProxyImpl.swigCPtr;
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

    public static boolean setUIThread(int i, UITaskThreadInfoImpl uITaskThreadInfoImpl) {
        return setUIThreadNative(i, UITaskThreadInfoImpl.getCPtr(uITaskThreadInfoImpl), uITaskThreadInfoImpl);
    }

    public static boolean removeUIThread(int i) {
        return removeUIThreadNative(i);
    }

    public static UITaskThreadInfoImpl getUIThread(int i) {
        UITaskThreadInfoImpl uITaskThreadInfoImpl = new UITaskThreadInfoImpl();
        if (Boolean.valueOf(getUIThread(i, uITaskThreadInfoImpl)).booleanValue()) {
            return uITaskThreadInfoImpl;
        }
        return null;
    }

    private static boolean getUIThread(int i, UITaskThreadInfoImpl uITaskThreadInfoImpl) {
        return getUIThreadNative(i, UITaskThreadInfoImpl.getCPtr(uITaskThreadInfoImpl), uITaskThreadInfoImpl);
    }

    public static HashMap<Integer, UITaskThreadInfoImpl> getAllUIThread() {
        HashMap<Integer, UITaskThreadInfoImpl> hashMap = new HashMap<>();
        if (Boolean.valueOf(getAllUIThread(hashMap)).booleanValue()) {
            return hashMap;
        }
        return null;
    }

    private static boolean getAllUIThread(HashMap<Integer, UITaskThreadInfoImpl> hashMap) {
        return getAllUIThreadNative(hashMap);
    }

    public static UITaskThreadInfoImpl getUIThreadByMinID() {
        UITaskThreadInfoImpl uITaskThreadInfoImpl = new UITaskThreadInfoImpl();
        if (Boolean.valueOf(getUIThreadByMinID(uITaskThreadInfoImpl)).booleanValue()) {
            return uITaskThreadInfoImpl;
        }
        return null;
    }

    private static boolean getUIThreadByMinID(UITaskThreadInfoImpl uITaskThreadInfoImpl) {
        return getUIThreadByMinIDNative(UITaskThreadInfoImpl.getCPtr(uITaskThreadInfoImpl), uITaskThreadInfoImpl);
    }

    public UIThreadManagerProxyImpl() {
        this(createNativeObj(), true);
    }
}
