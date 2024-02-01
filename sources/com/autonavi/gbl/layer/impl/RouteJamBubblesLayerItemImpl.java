package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.model.JamBubblesSegmentDeepInfo;
import com.autonavi.gbl.layer.RouteJamBubblesLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = RouteJamBubblesLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class RouteJamBubblesLayerItemImpl extends QuadrantLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RouteJamBubblesLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long RouteJamBubblesLayerItemImpl_SWIGUpcast(long j);

    private static native void RouteJamBubblesLayerItemImpl_change_ownership(RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl, long j, boolean z);

    private static native void RouteJamBubblesLayerItemImpl_director_connect(RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl, long j, boolean z, boolean z2);

    private static native long bubbleIndexIdGetNative(long j, RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl);

    private static native void bubbleIndexIdSetNative(long j, RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl, long j2);

    private static native JamBubblesSegmentDeepInfo costGetNative(long j, RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl);

    private static native void costSetNative(long j, RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl, long j2, JamBubblesSegmentDeepInfo jamBubblesSegmentDeepInfo);

    private static native long createNativeObj(int i, long j);

    private static native JamBubblesSegmentDeepInfo deepInfoGetNative(long j, RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl);

    private static native void deepInfoSetNative(long j, RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl, long j2, JamBubblesSegmentDeepInfo jamBubblesSegmentDeepInfo);

    private static native JamBubblesSegmentDeepInfo degreeGetNative(long j, RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl);

    private static native void degreeSetNative(long j, RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl, long j2, JamBubblesSegmentDeepInfo jamBubblesSegmentDeepInfo);

    private static native void destroyNativeObj(long j);

    private static native int directionStyleGetNative(long j, RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl);

    private static native void directionStyleSetNative(long j, RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl, int i);

    private static native String getClassTypeNameNative();

    private static native boolean isJamWordGetNative(long j, RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl);

    private static native void isJamWordSetNative(long j, RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl, boolean z);

    private static native long pathIdGetNative(long j, RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl);

    private static native void pathIdSetNative(long j, RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl, long j2);

    private static native String picPathGetNative(long j, RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl);

    private static native void picPathSetNative(long j, RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl, String str);

    private static native JamBubblesSegmentDeepInfo trendGetNative(long j, RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl);

    private static native void trendSetNative(long j, RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl, long j2, JamBubblesSegmentDeepInfo jamBubblesSegmentDeepInfo);

    public RouteJamBubblesLayerItemImpl(long j, boolean z) {
        super(RouteJamBubblesLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof RouteJamBubblesLayerItemImpl) {
            return getUID(this) == getUID((RouteJamBubblesLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl) {
        long cPtr = getCPtr(routeJamBubblesLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(RouteJamBubblesLayerItemImpl routeJamBubblesLayerItemImpl) {
        if (routeJamBubblesLayerItemImpl == null) {
            return 0L;
        }
        return routeJamBubblesLayerItemImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        RouteJamBubblesLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        RouteJamBubblesLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public RouteJamBubblesLayerItemImpl(@QuadrantType.QuadrantType1 int i, long j) {
        this(createNativeObj(i, j), true);
        LayerSvrJNI.swig_jni_init();
        RouteJamBubblesLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setDirectionStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        $explicit_setDirectionStyle(i);
    }

    public void $explicit_setDirectionStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        directionStyleSetNative(j, this, i);
    }

    @BizDirectionStyle.BizDirectionStyle1
    public int getDirectionStyle() {
        return $explicit_getDirectionStyle();
    }

    @BizDirectionStyle.BizDirectionStyle1
    public int $explicit_getDirectionStyle() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return directionStyleGetNative(j, this);
    }

    public void setDeepInfo(JamBubblesSegmentDeepInfo jamBubblesSegmentDeepInfo) {
        $explicit_setDeepInfo(jamBubblesSegmentDeepInfo);
    }

    public void $explicit_setDeepInfo(JamBubblesSegmentDeepInfo jamBubblesSegmentDeepInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        deepInfoSetNative(j, this, 0L, jamBubblesSegmentDeepInfo);
    }

    public JamBubblesSegmentDeepInfo getDeepInfo() {
        return $explicit_getDeepInfo();
    }

    public JamBubblesSegmentDeepInfo $explicit_getDeepInfo() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return deepInfoGetNative(j, this);
    }

    public void setTrend(JamBubblesSegmentDeepInfo jamBubblesSegmentDeepInfo) {
        $explicit_setTrend(jamBubblesSegmentDeepInfo);
    }

    public void $explicit_setTrend(JamBubblesSegmentDeepInfo jamBubblesSegmentDeepInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        trendSetNative(j, this, 0L, jamBubblesSegmentDeepInfo);
    }

    public JamBubblesSegmentDeepInfo getTrend() {
        return $explicit_getTrend();
    }

    public JamBubblesSegmentDeepInfo $explicit_getTrend() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return trendGetNative(j, this);
    }

    public void setCost(JamBubblesSegmentDeepInfo jamBubblesSegmentDeepInfo) {
        $explicit_setCost(jamBubblesSegmentDeepInfo);
    }

    public void $explicit_setCost(JamBubblesSegmentDeepInfo jamBubblesSegmentDeepInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        costSetNative(j, this, 0L, jamBubblesSegmentDeepInfo);
    }

    public JamBubblesSegmentDeepInfo getCost() {
        return $explicit_getCost();
    }

    public JamBubblesSegmentDeepInfo $explicit_getCost() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return costGetNative(j, this);
    }

    public void setDegree(JamBubblesSegmentDeepInfo jamBubblesSegmentDeepInfo) {
        $explicit_setDegree(jamBubblesSegmentDeepInfo);
    }

    public void $explicit_setDegree(JamBubblesSegmentDeepInfo jamBubblesSegmentDeepInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        degreeSetNative(j, this, 0L, jamBubblesSegmentDeepInfo);
    }

    public JamBubblesSegmentDeepInfo getDegree() {
        return $explicit_getDegree();
    }

    public JamBubblesSegmentDeepInfo $explicit_getDegree() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return degreeGetNative(j, this);
    }

    public void setPicPath(String str) {
        $explicit_setPicPath(str);
    }

    public void $explicit_setPicPath(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        picPathSetNative(j, this, str);
    }

    public String getPicPath() {
        return $explicit_getPicPath();
    }

    public String $explicit_getPicPath() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return picPathGetNative(j, this);
    }

    public void setIsJamWord(boolean z) {
        $explicit_setIsJamWord(z);
    }

    public void $explicit_setIsJamWord(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        isJamWordSetNative(j, this, z);
    }

    public boolean getIsJamWord() {
        return $explicit_getIsJamWord();
    }

    public boolean $explicit_getIsJamWord() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isJamWordGetNative(j, this);
    }

    public void setPathId(long j) {
        $explicit_setPathId(j);
    }

    public void $explicit_setPathId(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        pathIdSetNative(j2, this, j);
    }

    public long getPathId() {
        return $explicit_getPathId();
    }

    public long $explicit_getPathId() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return pathIdGetNative(j, this);
    }

    public void setBubbleIndexId(long j) {
        $explicit_setBubbleIndexId(j);
    }

    public void $explicit_setBubbleIndexId(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        bubbleIndexIdSetNative(j2, this, j);
    }

    public long getBubbleIndexId() {
        return $explicit_getBubbleIndexId();
    }

    public long $explicit_getBubbleIndexId() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return bubbleIndexIdGetNative(j, this);
    }
}
