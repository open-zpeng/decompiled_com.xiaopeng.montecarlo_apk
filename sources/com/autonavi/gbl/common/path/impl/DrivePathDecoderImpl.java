package com.autonavi.gbl.common.path.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.CalcRouteResultData;
import com.autonavi.gbl.common.path.DrivePathDecoder;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.util.model.BinaryStream;
import java.util.ArrayList;
@IntfAuto(target = DrivePathDecoder.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class DrivePathDecoderImpl {
    private static BindTable BIND_TABLE = new BindTable(DrivePathDecoderImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native int assembleGuideDataToPathNative(long j, BinaryStream binaryStream, ArrayList<PathInfo> arrayList);

    private static native int assembleOddDataToPathNative(long j, BinaryStream binaryStream, ArrayList<PathInfo> arrayList);

    private static native long createNativeObj();

    private static native int decodeMultiRouteDataNative(long j, CalcRouteResultData calcRouteResultData, ArrayList<PathInfo> arrayList);

    private static native int decodePBDrivePlanNative(long j, BinaryStream binaryStream, ArrayList<PathInfo> arrayList);

    private static native int decodeRouteDataNative(byte[] bArr, ArrayList<PathInfo> arrayList);

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

    public static ArrayList<PathInfo> decodeRouteData(byte[] bArr) {
        ArrayList<PathInfo> arrayList = new ArrayList<>();
        if (Integer.valueOf(decodeRouteData(bArr, arrayList)).intValue() == 0) {
            return arrayList;
        }
        return null;
    }

    private static int decodeRouteData(byte[] bArr, ArrayList<PathInfo> arrayList) {
        return decodeRouteDataNative(bArr, arrayList);
    }

    public static ArrayList<PathInfo> decodeMultiRouteData(CalcRouteResultData calcRouteResultData) {
        ArrayList<PathInfo> arrayList = new ArrayList<>();
        if (Integer.valueOf(decodeMultiRouteData(calcRouteResultData, arrayList)).intValue() == 0) {
            return arrayList;
        }
        return null;
    }

    private static int decodeMultiRouteData(CalcRouteResultData calcRouteResultData, ArrayList<PathInfo> arrayList) {
        return decodeMultiRouteDataNative(0L, calcRouteResultData, arrayList);
    }

    public static ArrayList<PathInfo> assembleGuideDataToPath(BinaryStream binaryStream) {
        ArrayList<PathInfo> arrayList = new ArrayList<>();
        if (Integer.valueOf(assembleGuideDataToPath(binaryStream, arrayList)).intValue() == 0) {
            return arrayList;
        }
        return null;
    }

    private static int assembleGuideDataToPath(BinaryStream binaryStream, ArrayList<PathInfo> arrayList) {
        return assembleGuideDataToPathNative(0L, binaryStream, arrayList);
    }

    public static ArrayList<PathInfo> assembleOddDataToPath(BinaryStream binaryStream) {
        ArrayList<PathInfo> arrayList = new ArrayList<>();
        if (Integer.valueOf(assembleOddDataToPath(binaryStream, arrayList)).intValue() == 0) {
            return arrayList;
        }
        return null;
    }

    private static int assembleOddDataToPath(BinaryStream binaryStream, ArrayList<PathInfo> arrayList) {
        return assembleOddDataToPathNative(0L, binaryStream, arrayList);
    }

    public static ArrayList<PathInfo> decodePBDrivePlan(BinaryStream binaryStream) {
        ArrayList<PathInfo> arrayList = new ArrayList<>();
        if (Integer.valueOf(decodePBDrivePlan(binaryStream, arrayList)).intValue() == 0) {
            return arrayList;
        }
        return null;
    }

    private static int decodePBDrivePlan(BinaryStream binaryStream, ArrayList<PathInfo> arrayList) {
        return decodePBDrivePlanNative(0L, binaryStream, arrayList);
    }

    public DrivePathDecoderImpl() {
        this(createNativeObj(), true);
    }
}
