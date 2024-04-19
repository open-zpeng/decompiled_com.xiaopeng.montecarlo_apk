package com.autonavi.gbl.common.path.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.model.CalcRouteResultData;
import com.autonavi.gbl.common.model.RouteErrorcode;
import com.autonavi.gbl.common.path.DrivePathDecoder;
import com.autonavi.gbl.common.path.option.impl.PathInfoImpl;
import java.util.ArrayList;
@IntfAuto(target = DrivePathDecoder.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class DrivePathDecoderImpl {
    private static BindTable BIND_TABLE = new BindTable(DrivePathDecoderImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long createNativeObj();

    private static native int decodeMultiRouteDataNative(long j, CalcRouteResultData calcRouteResultData, ArrayList<PathInfoImpl> arrayList);

    private static native int decodeRouteDataNative(byte[] bArr, ArrayList<PathInfoImpl> arrayList);

    private static native void destroyNativeObj(long j);

    public DrivePathDecoderImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof DrivePathDecoderImpl) && getUID(this) == getUID((DrivePathDecoderImpl) obj);
    }

    private static long getUID(DrivePathDecoderImpl drivePathDecoderImpl) {
        long cPtr = getCPtr(drivePathDecoderImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(DrivePathDecoderImpl drivePathDecoderImpl) {
        if (drivePathDecoderImpl == null) {
            return 0L;
        }
        return drivePathDecoderImpl.swigCPtr;
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

    public static ArrayList<PathInfoImpl> decodeRouteData(byte[] bArr) {
        ArrayList<PathInfoImpl> arrayList = new ArrayList<>();
        if (decodeRouteData(bArr, arrayList) == 1) {
            return arrayList;
        }
        return null;
    }

    public static ArrayList<PathInfoImpl> decodeMultiRouteData(CalcRouteResultData calcRouteResultData) {
        ArrayList<PathInfoImpl> arrayList = new ArrayList<>();
        if (decodeMultiRouteData(calcRouteResultData, arrayList) == 1) {
            return arrayList;
        }
        return null;
    }

    @RouteErrorcode.RouteErrorcode1
    private static int decodeRouteData(byte[] bArr, ArrayList<PathInfoImpl> arrayList) {
        return decodeRouteDataNative(bArr, arrayList);
    }

    @RouteErrorcode.RouteErrorcode1
    private static int decodeMultiRouteData(CalcRouteResultData calcRouteResultData, ArrayList<PathInfoImpl> arrayList) {
        return decodeMultiRouteDataNative(0L, calcRouteResultData, arrayList);
    }

    public DrivePathDecoderImpl() {
        this(createNativeObj(), true);
    }
}
