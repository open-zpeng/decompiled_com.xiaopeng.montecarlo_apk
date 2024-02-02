package com.autonavi.gbl.data.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.data.DataToolHotUpdate;
import com.autonavi.gbl.data.model.HotUpdateFileType;
@IntfAuto(target = DataToolHotUpdate.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class DataToolHotUpdateImpl {
    private static BindTable BIND_TABLE = new BindTable(DataToolHotUpdateImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void getLocalVersionNative(String str, int i, String[] strArr);

    private static native void getRemoteVersionNative(String str, int i, String[] strArr);

    private static native boolean setLocalVersionNative(String str, int i, String str2);

    public DataToolHotUpdateImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof DataToolHotUpdateImpl) && getUID(this) == getUID((DataToolHotUpdateImpl) obj);
    }

    private static long getUID(DataToolHotUpdateImpl dataToolHotUpdateImpl) {
        long cPtr = getCPtr(dataToolHotUpdateImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(DataToolHotUpdateImpl dataToolHotUpdateImpl) {
        if (dataToolHotUpdateImpl == null) {
            return 0L;
        }
        return dataToolHotUpdateImpl.swigCPtr;
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

    public static String getLocalVersion(String str, @HotUpdateFileType.HotUpdateFileType1 int i) {
        String[] strArr = new String[1];
        getLocalVersion(str, i, strArr);
        return strArr[0];
    }

    public static String getRemoteVersion(String str, @HotUpdateFileType.HotUpdateFileType1 int i) {
        String[] strArr = new String[1];
        getRemoteVersion(str, i, strArr);
        return strArr[0];
    }

    public static boolean setLocalVersion(String str, @HotUpdateFileType.HotUpdateFileType1 int i, String str2) {
        return setLocalVersionNative(str, i, str2);
    }

    private static void getLocalVersion(String str, @HotUpdateFileType.HotUpdateFileType1 int i, String[] strArr) {
        getLocalVersionNative(str, i, strArr);
    }

    private static void getRemoteVersion(String str, @HotUpdateFileType.HotUpdateFileType1 int i, String[] strArr) {
        getRemoteVersionNative(str, i, strArr);
    }

    public DataToolHotUpdateImpl() {
        this(createNativeObj(), true);
    }
}
