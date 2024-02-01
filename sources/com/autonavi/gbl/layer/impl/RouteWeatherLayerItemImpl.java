package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.RouteWeatherLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
import com.autonavi.gbl.route.model.WeatherLabelItem;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = RouteWeatherLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class RouteWeatherLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RouteWeatherLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long RouteWeatherLayerItemImpl_SWIGUpcast(long j);

    private static native void RouteWeatherLayerItemImpl_change_ownership(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, long j, boolean z);

    private static native void RouteWeatherLayerItemImpl_director_connect(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(long j, WeatherLabelItem weatherLabelItem);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native WeatherLabelItem mWeatherInfoGetNative(long j, RouteWeatherLayerItemImpl routeWeatherLayerItemImpl);

    private static native void mWeatherInfoSetNative(long j, RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, long j2, WeatherLabelItem weatherLabelItem);

    public RouteWeatherLayerItemImpl(long j, boolean z) {
        super(RouteWeatherLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof RouteWeatherLayerItemImpl) {
            return getUID(this) == getUID((RouteWeatherLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl) {
        long cPtr = getCPtr(routeWeatherLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl) {
        if (routeWeatherLayerItemImpl == null) {
            return 0L;
        }
        return routeWeatherLayerItemImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
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

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        RouteWeatherLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        RouteWeatherLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public RouteWeatherLayerItemImpl(WeatherLabelItem weatherLabelItem) {
        this(createNativeObj(0L, weatherLabelItem), true);
        LayerSvrJNI.swig_jni_init();
        RouteWeatherLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setMWeatherInfo(WeatherLabelItem weatherLabelItem) {
        $explicit_setMWeatherInfo(weatherLabelItem);
    }

    public void $explicit_setMWeatherInfo(WeatherLabelItem weatherLabelItem) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mWeatherInfoSetNative(j, this, 0L, weatherLabelItem);
    }

    public WeatherLabelItem getMWeatherInfo() {
        return $explicit_getMWeatherInfo();
    }

    public WeatherLabelItem $explicit_getMWeatherInfo() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mWeatherInfoGetNative(j, this);
    }
}
