package com.autonavi.gbl.guide.model.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.guide.model.ContinueGuidePath;
import java.util.ArrayList;
@IntfAuto(target = ContinueGuidePath.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ContinueGuidePathImpl {
    private static BindTable BIND_TABLE = new BindTable(ContinueGuidePathImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native long mainPathIdGetNative(long j, ContinueGuidePathImpl continueGuidePathImpl);

    private static native void mainPathIdSetNative(long j, ContinueGuidePathImpl continueGuidePathImpl, long j2);

    private static native long[] pathInfoListGetNative(long j, ContinueGuidePathImpl continueGuidePathImpl);

    private static native void pathInfoListSetNative(long j, ContinueGuidePathImpl continueGuidePathImpl, long[] jArr);

    public ContinueGuidePathImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ContinueGuidePathImpl) && getUID(this) == getUID((ContinueGuidePathImpl) obj);
    }

    private static long getUID(ContinueGuidePathImpl continueGuidePathImpl) {
        long cPtr = getCPtr(continueGuidePathImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ContinueGuidePathImpl continueGuidePathImpl) {
        if (continueGuidePathImpl == null) {
            return 0L;
        }
        return continueGuidePathImpl.swigCPtr;
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

    public void setMainPathId(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        mainPathIdSetNative(j2, this, j);
    }

    public long getMainPathId() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mainPathIdGetNative(j, this);
    }

    public void setPathInfoList(ArrayList<PathInfo> arrayList) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        long[] jArr = null;
        if (arrayList != null) {
            int size = arrayList.size();
            long[] jArr2 = new long[size];
            for (int i = 0; i < size; i++) {
                jArr2[i] = PathInfo.getCPtr(arrayList.get(i));
            }
            jArr = jArr2;
        }
        pathInfoListSetNative(this.swigCPtr, this, jArr);
    }

    public ArrayList<PathInfo> getPathInfoList() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        ArrayList<PathInfo> arrayList = null;
        long[] pathInfoListGetNative = pathInfoListGetNative(j, this);
        if (pathInfoListGetNative != null) {
            arrayList = new ArrayList<>();
            for (long j2 : pathInfoListGetNative) {
                arrayList.add(new PathInfo(j2, false));
            }
        }
        return arrayList;
    }

    public ContinueGuidePathImpl() {
        this(createNativeObj(), true);
    }
}
