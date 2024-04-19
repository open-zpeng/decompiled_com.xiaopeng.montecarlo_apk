package com.autonavi.gbl.map.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.impl.MapViewImpl;
import com.autonavi.gbl.map.layer.SkeletonLayerItem;
import com.autonavi.gbl.map.layer.model.ActionLastDesc;
import com.autonavi.gbl.map.layer.model.ActionPlayDesc;
import com.autonavi.gbl.map.model.Point3F;
import java.util.ArrayList;
@IntfAuto(enableCRfx = true, protoOfCRfx = LayerItemCRfxProto.class, target = SkeletonLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class SkeletonLayerItemImpl extends LayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(SkeletonLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long SkeletonLayerItemImpl_SWIGUpcast(long j);

    private static native void SkeletonLayerItemImpl_change_ownership(SkeletonLayerItemImpl skeletonLayerItemImpl, long j, boolean z);

    private static native void SkeletonLayerItemImpl_director_connect(SkeletonLayerItemImpl skeletonLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(long j, MapViewImpl mapViewImpl);

    private static native void destroyNativeObj(long j);

    private static native void getActionListNative(long j, SkeletonLayerItemImpl skeletonLayerItemImpl, ArrayList<ActionLastDesc> arrayList);

    private static native void getActionListSwigExplicitSkeletonLayerItemImplNative(long j, SkeletonLayerItemImpl skeletonLayerItemImpl, ArrayList<ActionLastDesc> arrayList);

    private static native String getCurrentActionNative(long j, SkeletonLayerItemImpl skeletonLayerItemImpl);

    private static native String getCurrentActionSwigExplicitSkeletonLayerItemImplNative(long j, SkeletonLayerItemImpl skeletonLayerItemImpl);

    private static native void getPosition3DNative(long j, SkeletonLayerItemImpl skeletonLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void getPosition3DSwigExplicitSkeletonLayerItemImplNative(long j, SkeletonLayerItemImpl skeletonLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void getPositionNative(long j, SkeletonLayerItemImpl skeletonLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void getPositionSwigExplicitSkeletonLayerItemImplNative(long j, SkeletonLayerItemImpl skeletonLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void getRotateAnglesNative(long j, SkeletonLayerItemImpl skeletonLayerItemImpl, float[] fArr, float[] fArr2, float[] fArr3);

    private static native void getRotateAnglesSwigExplicitSkeletonLayerItemImplNative(long j, SkeletonLayerItemImpl skeletonLayerItemImpl, float[] fArr, float[] fArr2, float[] fArr3);

    private static native float getScaleRationNative(long j, SkeletonLayerItemImpl skeletonLayerItemImpl);

    private static native float getScaleRationSwigExplicitSkeletonLayerItemImplNative(long j, SkeletonLayerItemImpl skeletonLayerItemImpl);

    private static native void getScreenBoundNative(long j, SkeletonLayerItemImpl skeletonLayerItemImpl, long j2, RectDouble rectDouble);

    private static native void getScreenBoundSwigExplicitSkeletonLayerItemImplNative(long j, SkeletonLayerItemImpl skeletonLayerItemImpl, long j2, RectDouble rectDouble);

    private static native void onPaintNative(long j, SkeletonLayerItemImpl skeletonLayerItemImpl);

    private static native void onPaintSwigExplicitSkeletonLayerItemImplNative(long j, SkeletonLayerItemImpl skeletonLayerItemImpl);

    private static native boolean setActionPlayListNative(long j, SkeletonLayerItemImpl skeletonLayerItemImpl, ArrayList<ActionPlayDesc> arrayList);

    private static native boolean setActionPlayListSwigExplicitSkeletonLayerItemImplNative(long j, SkeletonLayerItemImpl skeletonLayerItemImpl, ArrayList<ActionPlayDesc> arrayList);

    private static native void setBinaryDataNative(long j, SkeletonLayerItemImpl skeletonLayerItemImpl, byte[] bArr);

    private static native void setBinaryDataSwigExplicitSkeletonLayerItemImplNative(long j, SkeletonLayerItemImpl skeletonLayerItemImpl, byte[] bArr);

    private static native void setPosition3DNative(long j, SkeletonLayerItemImpl skeletonLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void setPosition3DSwigExplicitSkeletonLayerItemImplNative(long j, SkeletonLayerItemImpl skeletonLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void setPositionNative(long j, SkeletonLayerItemImpl skeletonLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void setPositionSwigExplicitSkeletonLayerItemImplNative(long j, SkeletonLayerItemImpl skeletonLayerItemImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void setRotateAnglesNative(long j, SkeletonLayerItemImpl skeletonLayerItemImpl, float f, float f2, float f3);

    private static native void setRotateAnglesSwigExplicitSkeletonLayerItemImplNative(long j, SkeletonLayerItemImpl skeletonLayerItemImpl, float f, float f2, float f3);

    private static native void setRotateWithMapNative(long j, SkeletonLayerItemImpl skeletonLayerItemImpl, boolean z);

    private static native void setRotateWithMapSwigExplicitSkeletonLayerItemImplNative(long j, SkeletonLayerItemImpl skeletonLayerItemImpl, boolean z);

    private static native void setScaleRationNative(long j, SkeletonLayerItemImpl skeletonLayerItemImpl, float f);

    private static native void setScaleRationSwigExplicitSkeletonLayerItemImplNative(long j, SkeletonLayerItemImpl skeletonLayerItemImpl, float f);

    private static native void setScaleWithMapNative(long j, SkeletonLayerItemImpl skeletonLayerItemImpl, boolean z);

    private static native void setScaleWithMapSwigExplicitSkeletonLayerItemImplNative(long j, SkeletonLayerItemImpl skeletonLayerItemImpl, boolean z);

    public SkeletonLayerItemImpl(long j, boolean z) {
        super(SkeletonLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean equals(Object obj) {
        if (obj instanceof SkeletonLayerItemImpl) {
            return getUID(this) == getUID((SkeletonLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(SkeletonLayerItemImpl skeletonLayerItemImpl) {
        long cPtr = getCPtr(skeletonLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(SkeletonLayerItemImpl skeletonLayerItemImpl) {
        if (skeletonLayerItemImpl == null) {
            return 0L;
        }
        return skeletonLayerItemImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        SkeletonLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        SkeletonLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public SkeletonLayerItemImpl(MapViewImpl mapViewImpl) {
        this(createNativeObj(MapViewImpl.getCPtr(mapViewImpl), mapViewImpl), true);
        MapLayerSvrJNI.swig_jni_init();
        SkeletonLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public void setPosition(Coord3DDouble coord3DDouble) {
        $explicit_setPosition(coord3DDouble);
    }

    public void $explicit_setPosition(Coord3DDouble coord3DDouble) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == SkeletonLayerItemImpl.class) {
            setPositionNative(this.swigCPtr, this, 0L, coord3DDouble);
        } else {
            setPositionSwigExplicitSkeletonLayerItemImplNative(this.swigCPtr, this, 0L, coord3DDouble);
        }
    }

    public void setPosition3D(Coord3DDouble coord3DDouble) {
        $explicit_setPosition3D(coord3DDouble);
    }

    public void $explicit_setPosition3D(Coord3DDouble coord3DDouble) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == SkeletonLayerItemImpl.class) {
            setPosition3DNative(this.swigCPtr, this, 0L, coord3DDouble);
        } else {
            setPosition3DSwigExplicitSkeletonLayerItemImplNative(this.swigCPtr, this, 0L, coord3DDouble);
        }
    }

    public void getPosition(Coord3DDouble coord3DDouble) {
        $explicit_getPosition(coord3DDouble);
    }

    public void $explicit_getPosition(Coord3DDouble coord3DDouble) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == SkeletonLayerItemImpl.class) {
            getPositionNative(this.swigCPtr, this, 0L, coord3DDouble);
        } else {
            getPositionSwigExplicitSkeletonLayerItemImplNative(this.swigCPtr, this, 0L, coord3DDouble);
        }
    }

    public void getPosition3D(Coord3DDouble coord3DDouble) {
        $explicit_getPosition3D(coord3DDouble);
    }

    public void $explicit_getPosition3D(Coord3DDouble coord3DDouble) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == SkeletonLayerItemImpl.class) {
            getPosition3DNative(this.swigCPtr, this, 0L, coord3DDouble);
        } else {
            getPosition3DSwigExplicitSkeletonLayerItemImplNative(this.swigCPtr, this, 0L, coord3DDouble);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void onPaint() {
        $explicit_onPaint();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void $explicit_onPaint() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == SkeletonLayerItemImpl.class) {
            onPaintNative(this.swigCPtr, this);
        } else {
            onPaintSwigExplicitSkeletonLayerItemImplNative(this.swigCPtr, this);
        }
    }

    public void setBinaryData(byte[] bArr) {
        $explicit_setBinaryData(bArr);
    }

    public void $explicit_setBinaryData(byte[] bArr) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == SkeletonLayerItemImpl.class) {
            setBinaryDataNative(this.swigCPtr, this, bArr);
        } else {
            setBinaryDataSwigExplicitSkeletonLayerItemImplNative(this.swigCPtr, this, bArr);
        }
    }

    public void getActionList(ArrayList<ActionLastDesc> arrayList) {
        $explicit_getActionList(arrayList);
    }

    public void $explicit_getActionList(ArrayList<ActionLastDesc> arrayList) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == SkeletonLayerItemImpl.class) {
            getActionListNative(this.swigCPtr, this, arrayList);
        } else {
            getActionListSwigExplicitSkeletonLayerItemImplNative(this.swigCPtr, this, arrayList);
        }
    }

    public boolean setActionPlayList(ArrayList<ActionPlayDesc> arrayList) {
        return $explicit_setActionPlayList(arrayList);
    }

    public boolean $explicit_setActionPlayList(ArrayList<ActionPlayDesc> arrayList) {
        if (this.swigCPtr != 0) {
            return getClass() == SkeletonLayerItemImpl.class ? setActionPlayListNative(this.swigCPtr, this, arrayList) : setActionPlayListSwigExplicitSkeletonLayerItemImplNative(this.swigCPtr, this, arrayList);
        }
        throw new NullPointerException();
    }

    public String getCurrentAction() {
        return $explicit_getCurrentAction();
    }

    public String $explicit_getCurrentAction() {
        if (this.swigCPtr != 0) {
            return getClass() == SkeletonLayerItemImpl.class ? getCurrentActionNative(this.swigCPtr, this) : getCurrentActionSwigExplicitSkeletonLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public void setRotateAngles(float f, float f2, float f3) {
        $explicit_setRotateAngles(f, f2, f3);
    }

    public void $explicit_setRotateAngles(float f, float f2, float f3) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == SkeletonLayerItemImpl.class) {
            setRotateAnglesNative(this.swigCPtr, this, f, f2, f3);
        } else {
            setRotateAnglesSwigExplicitSkeletonLayerItemImplNative(this.swigCPtr, this, f, f2, f3);
        }
    }

    public void setScaleRation(float f) {
        $explicit_setScaleRation(f);
    }

    public void $explicit_setScaleRation(float f) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == SkeletonLayerItemImpl.class) {
            setScaleRationNative(this.swigCPtr, this, f);
        } else {
            setScaleRationSwigExplicitSkeletonLayerItemImplNative(this.swigCPtr, this, f);
        }
    }

    public float getScaleRation() {
        return $explicit_getScaleRation();
    }

    public float $explicit_getScaleRation() {
        if (this.swigCPtr != 0) {
            return getClass() == SkeletonLayerItemImpl.class ? getScaleRationNative(this.swigCPtr, this) : getScaleRationSwigExplicitSkeletonLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public void getScreenBound(RectDouble rectDouble) {
        $explicit_getScreenBound(rectDouble);
    }

    public void $explicit_getScreenBound(RectDouble rectDouble) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == SkeletonLayerItemImpl.class) {
            getScreenBoundNative(this.swigCPtr, this, 0L, rectDouble);
        } else {
            getScreenBoundSwigExplicitSkeletonLayerItemImplNative(this.swigCPtr, this, 0L, rectDouble);
        }
    }

    public void setRotateWithMap(boolean z) {
        $explicit_setRotateWithMap(z);
    }

    public void $explicit_setRotateWithMap(boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == SkeletonLayerItemImpl.class) {
            setRotateWithMapNative(this.swigCPtr, this, z);
        } else {
            setRotateWithMapSwigExplicitSkeletonLayerItemImplNative(this.swigCPtr, this, z);
        }
    }

    public void setScaleWithMap(boolean z) {
        $explicit_setScaleWithMap(z);
    }

    public void $explicit_setScaleWithMap(boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == SkeletonLayerItemImpl.class) {
            setScaleWithMapNative(this.swigCPtr, this, z);
        } else {
            setScaleWithMapSwigExplicitSkeletonLayerItemImplNative(this.swigCPtr, this, z);
        }
    }

    public Point3F getRotateAngles() {
        return $explicit_getRotateAngles();
    }

    public Point3F $explicit_getRotateAngles() {
        Point3F point3F = new Point3F();
        float[] fArr = new float[1];
        float[] fArr2 = new float[1];
        float[] fArr3 = new float[1];
        getRotateAngles(fArr, fArr2, fArr3);
        point3F.x = fArr[0];
        point3F.y = fArr2[0];
        point3F.z = fArr3[0];
        return point3F;
    }

    private void getRotateAngles(float[] fArr, float[] fArr2, float[] fArr3) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == SkeletonLayerItemImpl.class) {
            getRotateAnglesNative(this.swigCPtr, this, fArr, fArr2, fArr3);
        } else {
            getRotateAnglesSwigExplicitSkeletonLayerItemImplNative(this.swigCPtr, this, fArr, fArr2, fArr3);
        }
    }
}
