package com.autonavi.gbl.map.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.PolygonLayerItem;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import java.util.ArrayList;
@IntfAuto(enableCRfx = true, protoOfCRfx = LayerItemCRfxProto.class, target = PolygonLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class PolygonLayerItemImpl extends LayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(PolygonLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long PolygonLayerItemImpl_SWIGUpcast(long j);

    private static native void PolygonLayerItemImpl_change_ownership(PolygonLayerItemImpl polygonLayerItemImpl, long j, boolean z);

    private static native void PolygonLayerItemImpl_director_connect(PolygonLayerItemImpl polygonLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native long getColorNative(long j, PolygonLayerItemImpl polygonLayerItemImpl);

    private static native long getColorSwigExplicitPolygonLayerItemImplNative(long j, PolygonLayerItemImpl polygonLayerItemImpl);

    private static native int getItemTypeNative(long j, PolygonLayerItemImpl polygonLayerItemImpl);

    private static native int getItemTypeSwigExplicitPolygonLayerItemImplNative(long j, PolygonLayerItemImpl polygonLayerItemImpl);

    private static native void setColorNative(long j, PolygonLayerItemImpl polygonLayerItemImpl, long j2);

    private static native void setColorSwigExplicitPolygonLayerItemImplNative(long j, PolygonLayerItemImpl polygonLayerItemImpl, long j2);

    private static native void setPointsNative(long j, PolygonLayerItemImpl polygonLayerItemImpl, ArrayList<Coord3DDouble> arrayList);

    private static native void setPointsSwigExplicitPolygonLayerItemImplNative(long j, PolygonLayerItemImpl polygonLayerItemImpl, ArrayList<Coord3DDouble> arrayList);

    private static native void updateStyleNative(long j, PolygonLayerItemImpl polygonLayerItemImpl);

    private static native void updateStyleSwigExplicitPolygonLayerItemImplNative(long j, PolygonLayerItemImpl polygonLayerItemImpl);

    public PolygonLayerItemImpl(long j, boolean z) {
        super(PolygonLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof PolygonLayerItemImpl) {
            return getUID(this) == getUID((PolygonLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(PolygonLayerItemImpl polygonLayerItemImpl) {
        long cPtr = getCPtr(polygonLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(PolygonLayerItemImpl polygonLayerItemImpl) {
        if (polygonLayerItemImpl == null) {
            return 0L;
        }
        return polygonLayerItemImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
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

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        PolygonLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        PolygonLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public PolygonLayerItemImpl() {
        this(createNativeObj(), true);
        MapLayerSvrJNI.swig_jni_init();
        PolygonLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        return $explicit_getItemType();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int $explicit_getItemType() {
        if (this.swigCPtr != 0) {
            return getClass() == PolygonLayerItemImpl.class ? getItemTypeNative(this.swigCPtr, this) : getItemTypeSwigExplicitPolygonLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public void setPoints(ArrayList<Coord3DDouble> arrayList) {
        $explicit_setPoints(arrayList);
    }

    public void $explicit_setPoints(ArrayList<Coord3DDouble> arrayList) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == PolygonLayerItemImpl.class) {
            setPointsNative(this.swigCPtr, this, arrayList);
        } else {
            setPointsSwigExplicitPolygonLayerItemImplNative(this.swigCPtr, this, arrayList);
        }
    }

    public void setColor(long j) {
        $explicit_setColor(j);
    }

    public void $explicit_setColor(long j) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == PolygonLayerItemImpl.class) {
            setColorNative(this.swigCPtr, this, j);
        } else {
            setColorSwigExplicitPolygonLayerItemImplNative(this.swigCPtr, this, j);
        }
    }

    public long getColor() {
        return $explicit_getColor();
    }

    public long $explicit_getColor() {
        if (this.swigCPtr != 0) {
            return getClass() == PolygonLayerItemImpl.class ? getColorNative(this.swigCPtr, this) : getColorSwigExplicitPolygonLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void updateStyle() {
        $explicit_updateStyle();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void $explicit_updateStyle() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == PolygonLayerItemImpl.class) {
            updateStyleNative(this.swigCPtr, this);
        } else {
            updateStyleSwigExplicitPolygonLayerItemImplNative(this.swigCPtr, this);
        }
    }
}
