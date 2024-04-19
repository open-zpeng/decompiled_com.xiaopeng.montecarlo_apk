package com.autonavi.gbl.guide.model.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.path.option.impl.IPOIForRequestImpl;
import com.autonavi.gbl.common.path.option.impl.PathInfoImpl;
import com.autonavi.gbl.guide.model.NaviPath;
import com.autonavi.gbl.guide.model.SceneFlagType;
import java.util.ArrayList;
@IntfAuto(target = NaviPath.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class NaviPathImpl {
    private static BindTable BIND_TABLE = new BindTable(NaviPathImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native long pointGetNative(long j, NaviPathImpl naviPathImpl);

    private static native void pointSetNative(long j, NaviPathImpl naviPathImpl, long j2, IPOIForRequestImpl iPOIForRequestImpl);

    private static native int sceneGetNative(long j, NaviPathImpl naviPathImpl);

    private static native void sceneSetNative(long j, NaviPathImpl naviPathImpl, int i);

    private static native int strategyGetNative(long j, NaviPathImpl naviPathImpl);

    private static native void strategySetNative(long j, NaviPathImpl naviPathImpl, int i);

    private static native int typeGetNative(long j, NaviPathImpl naviPathImpl);

    private static native void typeSetNative(long j, NaviPathImpl naviPathImpl, int i);

    private static native long[] vecPathsGetNative(long j, NaviPathImpl naviPathImpl);

    private static native void vecPathsSetNative(long j, NaviPathImpl naviPathImpl, long[] jArr);

    public NaviPathImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof NaviPathImpl) && getUID(this) == getUID((NaviPathImpl) obj);
    }

    private static long getUID(NaviPathImpl naviPathImpl) {
        long cPtr = getCPtr(naviPathImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(NaviPathImpl naviPathImpl) {
        if (naviPathImpl == null) {
            return 0L;
        }
        return naviPathImpl.swigCPtr;
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

    public void setVecPaths(ArrayList<PathInfoImpl> arrayList) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        long[] jArr = null;
        if (arrayList != null) {
            int size = arrayList.size();
            long[] jArr2 = new long[size];
            for (int i = 0; i < size; i++) {
                jArr2[i] = PathInfoImpl.getCPtr(arrayList.get(i));
            }
            jArr = jArr2;
        }
        vecPathsSetNative(this.swigCPtr, this, jArr);
    }

    public ArrayList<PathInfoImpl> getVecPaths() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        ArrayList<PathInfoImpl> arrayList = null;
        long[] vecPathsGetNative = vecPathsGetNative(j, this);
        if (vecPathsGetNative != null) {
            arrayList = new ArrayList<>();
            for (long j2 : vecPathsGetNative) {
                arrayList.add(new PathInfoImpl(j2, false));
            }
        }
        return arrayList;
    }

    public void setType(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        typeSetNative(j, this, i);
    }

    public int getType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return typeGetNative(j, this);
    }

    public void setPoint(IPOIForRequestImpl iPOIForRequestImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        pointSetNative(j, this, IPOIForRequestImpl.getCPtr(iPOIForRequestImpl), iPOIForRequestImpl);
    }

    public IPOIForRequestImpl getPoint() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long pointGetNative = pointGetNative(j, this);
        if (pointGetNative == 0) {
            return null;
        }
        return new IPOIForRequestImpl(pointGetNative, false);
    }

    public void setStrategy(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        strategySetNative(j, this, i);
    }

    public int getStrategy() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return strategyGetNative(j, this);
    }

    public void setScene(@SceneFlagType.SceneFlagType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        sceneSetNative(j, this, i);
    }

    @SceneFlagType.SceneFlagType1
    public int getScene() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sceneGetNative(j, this);
    }

    public NaviPathImpl() {
        this(createNativeObj(), true);
    }
}
