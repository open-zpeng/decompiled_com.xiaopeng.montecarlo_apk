package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.model.RoadClass;
import com.autonavi.gbl.layer.LocalTrafficEventLineLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.layer.model.LocalTrafficEventType;
import com.autonavi.gbl.map.layer.impl.LineLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = LocalTrafficEventLineLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class LocalTrafficEventLineLayerItemImpl extends LineLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(LocalTrafficEventLineLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long LocalTrafficEventLineLayerItemImpl_SWIGUpcast(long j);

    private static native void LocalTrafficEventLineLayerItemImpl_change_ownership(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl, long j, boolean z);

    private static native void LocalTrafficEventLineLayerItemImpl_director_connect(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(int i, String str, int i2);

    private static native void destroyNativeObj(long j);

    private static native String eventIDGetNative(long j, LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl);

    private static native void eventIDSetNative(long j, LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl, String str);

    private static native int eventTypeGetNative(long j, LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl);

    private static native void eventTypeSetNative(long j, LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl, int i);

    private static native String getClassTypeNameNative();

    private static native int roadClassGetNative(long j, LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl);

    private static native void roadClassSetNative(long j, LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl, int i);

    public LocalTrafficEventLineLayerItemImpl(long j, boolean z) {
        super(LocalTrafficEventLineLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LineLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LineLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof LocalTrafficEventLineLayerItemImpl) {
            return getUID(this) == getUID((LocalTrafficEventLineLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl) {
        long cPtr = getCPtr(localTrafficEventLineLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl) {
        if (localTrafficEventLineLayerItemImpl == null) {
            return 0L;
        }
        return localTrafficEventLineLayerItemImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.LineLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
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

    @Override // com.autonavi.gbl.map.layer.impl.LineLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LineLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        LocalTrafficEventLineLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.LineLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        LocalTrafficEventLineLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public LocalTrafficEventLineLayerItemImpl(@LocalTrafficEventType.LocalTrafficEventType1 int i, String str, @RoadClass.RoadClass1 int i2) {
        this(createNativeObj(i, str, i2), true);
        LayerSvrJNI.swig_jni_init();
        LocalTrafficEventLineLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setEventType(@LocalTrafficEventType.LocalTrafficEventType1 int i) {
        $explicit_setEventType(i);
    }

    public void $explicit_setEventType(@LocalTrafficEventType.LocalTrafficEventType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        eventTypeSetNative(j, this, i);
    }

    @LocalTrafficEventType.LocalTrafficEventType1
    public int getEventType() {
        return $explicit_getEventType();
    }

    @LocalTrafficEventType.LocalTrafficEventType1
    public int $explicit_getEventType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return eventTypeGetNative(j, this);
    }

    public void setEventID(String str) {
        $explicit_setEventID(str);
    }

    public void $explicit_setEventID(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        eventIDSetNative(j, this, str);
    }

    public String getEventID() {
        return $explicit_getEventID();
    }

    public String $explicit_getEventID() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return eventIDGetNative(j, this);
    }

    public void setRoadClass(@RoadClass.RoadClass1 int i) {
        $explicit_setRoadClass(i);
    }

    public void $explicit_setRoadClass(@RoadClass.RoadClass1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        roadClassSetNative(j, this, i);
    }

    @RoadClass.RoadClass1
    public int getRoadClass() {
        return $explicit_getRoadClass();
    }

    @RoadClass.RoadClass1
    public int $explicit_getRoadClass() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return roadClassGetNative(j, this);
    }
}
