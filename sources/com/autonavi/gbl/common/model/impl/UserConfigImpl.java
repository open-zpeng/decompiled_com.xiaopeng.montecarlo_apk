package com.autonavi.gbl.common.model.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.model.UserConfig;
@IntfAuto(target = UserConfig.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class UserConfigImpl {
    private static BindTable BIND_TABLE = new BindTable(UserConfigImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native String deviceIDGetNative(long j, UserConfigImpl userConfigImpl);

    private static native void deviceIDSetNative(long j, UserConfigImpl userConfigImpl, String str);

    private static native String passwordGetNative(long j, UserConfigImpl userConfigImpl);

    private static native void passwordSetNative(long j, UserConfigImpl userConfigImpl, String str);

    private static native String userBatchGetNative(long j, UserConfigImpl userConfigImpl);

    private static native void userBatchSetNative(long j, UserConfigImpl userConfigImpl, String str);

    private static native String userCodeGetNative(long j, UserConfigImpl userConfigImpl);

    private static native void userCodeSetNative(long j, UserConfigImpl userConfigImpl, String str);

    public UserConfigImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof UserConfigImpl) && getUID(this) == getUID((UserConfigImpl) obj);
    }

    private static long getUID(UserConfigImpl userConfigImpl) {
        long cPtr = getCPtr(userConfigImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(UserConfigImpl userConfigImpl) {
        if (userConfigImpl == null) {
            return 0L;
        }
        return userConfigImpl.swigCPtr;
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

    public void setUserCode(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        userCodeSetNative(j, this, str);
    }

    public String getUserCode() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return userCodeGetNative(j, this);
    }

    public void setUserBatch(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        userBatchSetNative(j, this, str);
    }

    public String getUserBatch() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return userBatchGetNative(j, this);
    }

    public void setDeviceID(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        deviceIDSetNative(j, this, str);
    }

    public String getDeviceID() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return deviceIDGetNative(j, this);
    }

    public void setPassword(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        passwordSetNative(j, this, str);
    }

    public String getPassword() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return passwordGetNative(j, this);
    }

    public UserConfigImpl() {
        this(createNativeObj(), true);
    }
}
