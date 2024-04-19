package com.autonavi.gbl.route.model.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.aosclient.model.RouteDisplayPoints;
import com.autonavi.gbl.aosclient.model.RoutePathProjectPoints;
import com.autonavi.gbl.aosclient.model.RoutepathrestorationPathsInfo;
import com.autonavi.gbl.aosclient.model.RoutepathrestorationPointInfo;
import com.autonavi.gbl.route.model.RouteRestorationOption;
import java.util.ArrayList;
@IntfAuto(target = RouteRestorationOption.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IRouteRestorationOptionImpl {
    private static BindTable BIND_TABLE = new BindTable(IRouteRestorationOptionImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long createNative();

    private static native void destroyNative(long j, IRouteRestorationOptionImpl iRouteRestorationOptionImpl);

    private static native void destroyNativeObj(long j);

    private static native void setCarAxisNative(long j, IRouteRestorationOptionImpl iRouteRestorationOptionImpl, int i);

    private static native void setCarHeightNative(long j, IRouteRestorationOptionImpl iRouteRestorationOptionImpl, double d);

    private static native void setCarLoadNative(long j, IRouteRestorationOptionImpl iRouteRestorationOptionImpl, double d);

    private static native void setCarPlateNative(long j, IRouteRestorationOptionImpl iRouteRestorationOptionImpl, String str);

    private static native void setCarSizeNative(long j, IRouteRestorationOptionImpl iRouteRestorationOptionImpl, int i);

    private static native void setCarTypeNative(long j, IRouteRestorationOptionImpl iRouteRestorationOptionImpl, int i);

    private static native void setCarWeightNative(long j, IRouteRestorationOptionImpl iRouteRestorationOptionImpl, double d);

    private static native void setCarWidthNative(long j, IRouteRestorationOptionImpl iRouteRestorationOptionImpl, double d);

    private static native void setContentOptionNative(long j, IRouteRestorationOptionImpl iRouteRestorationOptionImpl, String str);

    private static native void setEndNameNative(long j, IRouteRestorationOptionImpl iRouteRestorationOptionImpl, String str);

    private static native void setEndPointsNative(long j, IRouteRestorationOptionImpl iRouteRestorationOptionImpl, ArrayList<RoutepathrestorationPointInfo> arrayList);

    private static native void setPathsNative(long j, IRouteRestorationOptionImpl iRouteRestorationOptionImpl, ArrayList<RoutepathrestorationPathsInfo> arrayList);

    private static native void setRouteVerNative(long j, IRouteRestorationOptionImpl iRouteRestorationOptionImpl, String str);

    private static native void setSdkVerNative(long j, IRouteRestorationOptionImpl iRouteRestorationOptionImpl, String str);

    private static native void setStartPointsNative(long j, IRouteRestorationOptionImpl iRouteRestorationOptionImpl, ArrayList<RoutepathrestorationPointInfo> arrayList);

    private static native void setViaPointsNative(long j, IRouteRestorationOptionImpl iRouteRestorationOptionImpl, ArrayList<RouteDisplayPoints> arrayList, ArrayList<RoutePathProjectPoints> arrayList2);

    public IRouteRestorationOptionImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IRouteRestorationOptionImpl) && getUID(this) == getUID((IRouteRestorationOptionImpl) obj);
    }

    private static long getUID(IRouteRestorationOptionImpl iRouteRestorationOptionImpl) {
        long cPtr = getCPtr(iRouteRestorationOptionImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IRouteRestorationOptionImpl iRouteRestorationOptionImpl) {
        if (iRouteRestorationOptionImpl == null) {
            return 0L;
        }
        return iRouteRestorationOptionImpl.swigCPtr;
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

    public static IRouteRestorationOptionImpl create() {
        long createNative = createNative();
        if (createNative == 0) {
            return null;
        }
        return new IRouteRestorationOptionImpl(createNative, false);
    }

    public static void destroy(IRouteRestorationOptionImpl iRouteRestorationOptionImpl) {
        destroyNative(getCPtr(iRouteRestorationOptionImpl), iRouteRestorationOptionImpl);
    }

    public void setPaths(ArrayList<RoutepathrestorationPathsInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setPathsNative(j, this, arrayList);
    }

    public void setStartPoints(ArrayList<RoutepathrestorationPointInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setStartPointsNative(j, this, arrayList);
    }

    public void setViaPoints(ArrayList<RouteDisplayPoints> arrayList, ArrayList<RoutePathProjectPoints> arrayList2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setViaPointsNative(j, this, arrayList, arrayList2);
    }

    public void setEndPoints(ArrayList<RoutepathrestorationPointInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setEndPointsNative(j, this, arrayList);
    }

    public void setEndName(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setEndNameNative(j, this, str);
    }

    public void setContentOption(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setContentOptionNative(j, this, str);
    }

    public void setRouteVer(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setRouteVerNative(j, this, str);
    }

    public void setSdkVer(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setSdkVerNative(j, this, str);
    }

    public void setCarType(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setCarTypeNative(j, this, i);
    }

    public void setCarSize(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setCarSizeNative(j, this, i);
    }

    public void setCarHeight(double d) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setCarHeightNative(j, this, d);
    }

    public void setCarWidth(double d) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setCarWidthNative(j, this, d);
    }

    public void setCarLoad(double d) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setCarLoadNative(j, this, d);
    }

    public void setCarWeight(double d) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setCarWeightNative(j, this, d);
    }

    public void setCarAxis(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setCarAxisNative(j, this, i);
    }

    public void setCarPlate(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setCarPlateNative(j, this, str);
    }
}
