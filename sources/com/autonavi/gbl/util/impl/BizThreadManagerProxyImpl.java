package com.autonavi.gbl.util.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.util.BizThreadManagerProxy;
import java.util.HashMap;
@IntfAuto(target = BizThreadManagerProxy.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class BizThreadManagerProxyImpl {
    private static BindTable BIND_TABLE = new BindTable(BizThreadManagerProxyImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native boolean getAllBizThreadNative(HashMap<Integer, BizTaskThreadInfoImpl> hashMap);

    private static native boolean getBizThreadByMinIDNative(long j, BizTaskThreadInfoImpl bizTaskThreadInfoImpl);

    private static native boolean getBizThreadNative(int i, long j, BizTaskThreadInfoImpl bizTaskThreadInfoImpl);

    private static native boolean removeBizThreadNative(int i);

    private static native boolean setBizThreadNative(int i, long j, BizTaskThreadInfoImpl bizTaskThreadInfoImpl);

    public BizThreadManagerProxyImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof BizThreadManagerProxyImpl) && getUID(this) == getUID((BizThreadManagerProxyImpl) obj);
    }

    private static long getUID(BizThreadManagerProxyImpl bizThreadManagerProxyImpl) {
        long cPtr = getCPtr(bizThreadManagerProxyImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(BizThreadManagerProxyImpl bizThreadManagerProxyImpl) {
        if (bizThreadManagerProxyImpl == null) {
            return 0L;
        }
        return bizThreadManagerProxyImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    protected synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public static BizTaskThreadInfoImpl getBizThread(int i) {
        BizTaskThreadInfoImpl bizTaskThreadInfoImpl = new BizTaskThreadInfoImpl();
        if (getBizThread(i, bizTaskThreadInfoImpl)) {
            return bizTaskThreadInfoImpl;
        }
        return null;
    }

    public static HashMap<Integer, BizTaskThreadInfoImpl> getAllBizThread() {
        HashMap<Integer, BizTaskThreadInfoImpl> hashMap = new HashMap<>();
        if (getAllBizThread(hashMap)) {
            return hashMap;
        }
        return null;
    }

    public static BizTaskThreadInfoImpl getBizThreadByMinID() {
        BizTaskThreadInfoImpl bizTaskThreadInfoImpl = new BizTaskThreadInfoImpl();
        if (getBizThreadByMinID(bizTaskThreadInfoImpl)) {
            return bizTaskThreadInfoImpl;
        }
        return null;
    }

    public static boolean setBizThread(int i, BizTaskThreadInfoImpl bizTaskThreadInfoImpl) {
        return setBizThreadNative(i, BizTaskThreadInfoImpl.getCPtr(bizTaskThreadInfoImpl), bizTaskThreadInfoImpl);
    }

    public static boolean removeBizThread(int i) {
        return removeBizThreadNative(i);
    }

    private static boolean getBizThread(int i, BizTaskThreadInfoImpl bizTaskThreadInfoImpl) {
        return getBizThreadNative(i, BizTaskThreadInfoImpl.getCPtr(bizTaskThreadInfoImpl), bizTaskThreadInfoImpl);
    }

    private static boolean getAllBizThread(HashMap<Integer, BizTaskThreadInfoImpl> hashMap) {
        return getAllBizThreadNative(hashMap);
    }

    private static boolean getBizThreadByMinID(BizTaskThreadInfoImpl bizTaskThreadInfoImpl) {
        return getBizThreadByMinIDNative(BizTaskThreadInfoImpl.getCPtr(bizTaskThreadInfoImpl), bizTaskThreadInfoImpl);
    }

    public BizThreadManagerProxyImpl() {
        this(createNativeObj(), true);
    }
}
