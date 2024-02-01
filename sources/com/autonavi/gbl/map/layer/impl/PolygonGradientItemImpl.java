package com.autonavi.gbl.map.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.impl.IMapViewImpl;
import com.autonavi.gbl.map.layer.PolygonGradientItem;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerPriority;
import com.autonavi.gbl.map.layer.model.PolygonGradientPointInfo;
import java.util.ArrayList;
@IntfAuto(enableCRfx = true, protoOfCRfx = LayerItemCRfxProto.class, target = PolygonGradientItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class PolygonGradientItemImpl extends LayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(PolygonGradientItemImpl.class);
    private transient long swigCPtr;

    private static native long PolygonGradientItemImpl_SWIGUpcast(long j);

    private static native void PolygonGradientItemImpl_change_ownership(PolygonGradientItemImpl polygonGradientItemImpl, long j, boolean z);

    private static native void PolygonGradientItemImpl_director_connect(PolygonGradientItemImpl polygonGradientItemImpl, long j, boolean z, boolean z2);

    private static native void clearAllNative(long j, PolygonGradientItemImpl polygonGradientItemImpl);

    private static native void clearAllSwigExplicitPolygonGradientItemImplNative(long j, PolygonGradientItemImpl polygonGradientItemImpl);

    private static native long createNativeObj(long j, IMapViewImpl iMapViewImpl);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int getItemTypeNative(long j, PolygonGradientItemImpl polygonGradientItemImpl);

    private static native int getItemTypeSwigExplicitPolygonGradientItemImplNative(long j, PolygonGradientItemImpl polygonGradientItemImpl);

    private static native void setPointsNative(long j, PolygonGradientItemImpl polygonGradientItemImpl, ArrayList<PolygonGradientPointInfo> arrayList);

    private static native void setPointsSwigExplicitPolygonGradientItemImplNative(long j, PolygonGradientItemImpl polygonGradientItemImpl, ArrayList<PolygonGradientPointInfo> arrayList);

    private static native void setPriorityNative(long j, PolygonGradientItemImpl polygonGradientItemImpl, long j2, LayerPriority layerPriority);

    private static native void setPrioritySwigExplicitPolygonGradientItemImplNative(long j, PolygonGradientItemImpl polygonGradientItemImpl, long j2, LayerPriority layerPriority);

    private static native void setVisibleNative(long j, PolygonGradientItemImpl polygonGradientItemImpl, boolean z);

    private static native void setVisibleSwigExplicitPolygonGradientItemImplNative(long j, PolygonGradientItemImpl polygonGradientItemImpl, boolean z);

    private static native void startAlphaAnimationNative(long j, PolygonGradientItemImpl polygonGradientItemImpl, int i, double d, double d2);

    private static native void updateStyleNative(long j, PolygonGradientItemImpl polygonGradientItemImpl);

    private static native void updateStyleSwigExplicitPolygonGradientItemImplNative(long j, PolygonGradientItemImpl polygonGradientItemImpl);

    public PolygonGradientItemImpl(long j, boolean z) {
        super(PolygonGradientItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof PolygonGradientItemImpl) {
            return getUID(this) == getUID((PolygonGradientItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(PolygonGradientItemImpl polygonGradientItemImpl) {
        long cPtr = getCPtr(polygonGradientItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(PolygonGradientItemImpl polygonGradientItemImpl) {
        if (polygonGradientItemImpl == null) {
            return 0L;
        }
        return polygonGradientItemImpl.swigCPtr;
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
        PolygonGradientItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        PolygonGradientItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public PolygonGradientItemImpl(IMapViewImpl iMapViewImpl) {
        this(createNativeObj(IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl), true);
        MapLayerSvrJNI.swig_jni_init();
        PolygonGradientItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
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
            return getClass() == PolygonGradientItemImpl.class ? getItemTypeNative(this.swigCPtr, this) : getItemTypeSwigExplicitPolygonGradientItemImplNative(this.swigCPtr, this);
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
        if (getClass() == PolygonGradientItemImpl.class) {
            updateStyleNative(this.swigCPtr, this);
        } else {
            updateStyleSwigExplicitPolygonGradientItemImplNative(this.swigCPtr, this);
        }
    }

    public void setPoints(ArrayList<PolygonGradientPointInfo> arrayList) {
        $explicit_setPoints(arrayList);
    }

    public void $explicit_setPoints(ArrayList<PolygonGradientPointInfo> arrayList) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == PolygonGradientItemImpl.class) {
            setPointsNative(this.swigCPtr, this, arrayList);
        } else {
            setPointsSwigExplicitPolygonGradientItemImplNative(this.swigCPtr, this, arrayList);
        }
    }

    public void clearAll() {
        $explicit_clearAll();
    }

    public void $explicit_clearAll() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == PolygonGradientItemImpl.class) {
            clearAllNative(this.swigCPtr, this);
        } else {
            clearAllSwigExplicitPolygonGradientItemImplNative(this.swigCPtr, this);
        }
    }

    public void startAlphaAnimation(int i, double d, double d2) {
        $explicit_startAlphaAnimation(i, d, d2);
    }

    public void $explicit_startAlphaAnimation(int i, double d, double d2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        startAlphaAnimationNative(j, this, i, d, d2);
    }

    public void setPriority(LayerPriority layerPriority) {
        $explicit_setPriority(layerPriority);
    }

    public void $explicit_setPriority(LayerPriority layerPriority) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == PolygonGradientItemImpl.class) {
            setPriorityNative(this.swigCPtr, this, 0L, layerPriority);
        } else {
            setPrioritySwigExplicitPolygonGradientItemImplNative(this.swigCPtr, this, 0L, layerPriority);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void setVisible(boolean z) {
        $explicit_setVisible(z);
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void $explicit_setVisible(boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == PolygonGradientItemImpl.class) {
            setVisibleNative(this.swigCPtr, this, z);
        } else {
            setVisibleSwigExplicitPolygonGradientItemImplNative(this.swigCPtr, this, z);
        }
    }
}
