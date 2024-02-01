package com.autonavi.gbl.map.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.LineLayerItem;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LineLayerItemStyle;
import java.util.ArrayList;
@IntfAuto(enableCRfx = true, protoOfCRfx = LayerItemCRfxProto.class, target = LineLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class LineLayerItemImpl extends LayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(LineLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long LineLayerItemImpl_SWIGUpcast(long j);

    private static native void LineLayerItemImpl_change_ownership(LineLayerItemImpl lineLayerItemImpl, long j, boolean z);

    private static native void LineLayerItemImpl_director_connect(LineLayerItemImpl lineLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int getItemTypeNative(long j, LineLayerItemImpl lineLayerItemImpl);

    private static native int getItemTypeSwigExplicitLineLayerItemImplNative(long j, LineLayerItemImpl lineLayerItemImpl);

    private static native long getPointsCountNative(long j, LineLayerItemImpl lineLayerItemImpl);

    private static native long getPointsCountSwigExplicitLineLayerItemImplNative(long j, LineLayerItemImpl lineLayerItemImpl);

    private static native void getStyleNative(long j, LineLayerItemImpl lineLayerItemImpl, long j2, LineLayerItemStyle lineLayerItemStyle);

    private static native void getStyleSwigExplicitLineLayerItemImplNative(long j, LineLayerItemImpl lineLayerItemImpl, long j2, LineLayerItemStyle lineLayerItemStyle);

    private static native void setColorNative(long j, LineLayerItemImpl lineLayerItemImpl, long j2, long j3);

    private static native void setColorSwigExplicitLineLayerItemImplNative(long j, LineLayerItemImpl lineLayerItemImpl, long j2, long j3);

    private static native void setOddCarPosition1Native(long j, LineLayerItemImpl lineLayerItemImpl, long j2, float f, long j3);

    private static native void setOddCarPosition2Native(long j, LineLayerItemImpl lineLayerItemImpl, long j2, float f);

    private static native void setOddCarPositionNative(long j, LineLayerItemImpl lineLayerItemImpl, long j2, float f, long j3, float f2);

    private static native void setPassedColorNative(long j, LineLayerItemImpl lineLayerItemImpl, long j2, long j3);

    private static native void setPassedColorSwigExplicitLineLayerItemImplNative(long j, LineLayerItemImpl lineLayerItemImpl, long j2, long j3);

    private static native void setPointsNative(long j, LineLayerItemImpl lineLayerItemImpl, ArrayList<Coord3DDouble> arrayList);

    private static native void setPointsSwigExplicitLineLayerItemImplNative(long j, LineLayerItemImpl lineLayerItemImpl, ArrayList<Coord3DDouble> arrayList);

    private static native void setWidthNative(long j, LineLayerItemImpl lineLayerItemImpl, int i, int i2);

    private static native void setWidthSwigExplicitLineLayerItemImplNative(long j, LineLayerItemImpl lineLayerItemImpl, int i, int i2);

    private static native void updateStyle1Native(long j, LineLayerItemImpl lineLayerItemImpl, long j2, LayerItemImpl layerItemImpl);

    private static native void updateStyleNative(long j, LineLayerItemImpl lineLayerItemImpl);

    private static native void updateStyleSwigExplicitLineLayerItemImpl1Native(long j, LineLayerItemImpl lineLayerItemImpl, long j2, LayerItemImpl layerItemImpl);

    private static native void updateStyleSwigExplicitLineLayerItemImplNative(long j, LineLayerItemImpl lineLayerItemImpl);

    public LineLayerItemImpl(long j, boolean z) {
        super(LineLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof LineLayerItemImpl) {
            return getUID(this) == getUID((LineLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(LineLayerItemImpl lineLayerItemImpl) {
        long cPtr = getCPtr(lineLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(LineLayerItemImpl lineLayerItemImpl) {
        if (lineLayerItemImpl == null) {
            return 0L;
        }
        return lineLayerItemImpl.swigCPtr;
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
        LineLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        LineLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public LineLayerItemImpl() {
        this(createNativeObj(), true);
        MapLayerSvrJNI.swig_jni_init();
        LineLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
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
            return getClass() == LineLayerItemImpl.class ? getItemTypeNative(this.swigCPtr, this) : getItemTypeSwigExplicitLineLayerItemImplNative(this.swigCPtr, this);
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
        if (getClass() == LineLayerItemImpl.class) {
            setPointsNative(this.swigCPtr, this, arrayList);
        } else {
            setPointsSwigExplicitLineLayerItemImplNative(this.swigCPtr, this, arrayList);
        }
    }

    public void setColor(long j, long j2) {
        $explicit_setColor(j, j2);
    }

    public void $explicit_setColor(long j, long j2) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == LineLayerItemImpl.class) {
            setColorNative(this.swigCPtr, this, j, j2);
        } else {
            setColorSwigExplicitLineLayerItemImplNative(this.swigCPtr, this, j, j2);
        }
    }

    public void setPassedColor(long j, long j2) {
        $explicit_setPassedColor(j, j2);
    }

    public void $explicit_setPassedColor(long j, long j2) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == LineLayerItemImpl.class) {
            setPassedColorNative(this.swigCPtr, this, j, j2);
        } else {
            setPassedColorSwigExplicitLineLayerItemImplNative(this.swigCPtr, this, j, j2);
        }
    }

    public void setWidth(int i, int i2) {
        $explicit_setWidth(i, i2);
    }

    public void $explicit_setWidth(int i, int i2) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == LineLayerItemImpl.class) {
            setWidthNative(this.swigCPtr, this, i, i2);
        } else {
            setWidthSwigExplicitLineLayerItemImplNative(this.swigCPtr, this, i, i2);
        }
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
        if (getClass() == LineLayerItemImpl.class) {
            updateStyleNative(this.swigCPtr, this);
        } else {
            updateStyleSwigExplicitLineLayerItemImplNative(this.swigCPtr, this);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void updateStyle(LayerItemImpl layerItemImpl) {
        $explicit_updateStyle(layerItemImpl);
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void $explicit_updateStyle(LayerItemImpl layerItemImpl) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == LineLayerItemImpl.class) {
            updateStyle1Native(this.swigCPtr, this, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl);
        } else {
            updateStyleSwigExplicitLineLayerItemImpl1Native(this.swigCPtr, this, LayerItemImpl.getCPtr(layerItemImpl), layerItemImpl);
        }
    }

    public void getStyle(LineLayerItemStyle lineLayerItemStyle) {
        $explicit_getStyle(lineLayerItemStyle);
    }

    public void $explicit_getStyle(LineLayerItemStyle lineLayerItemStyle) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == LineLayerItemImpl.class) {
            getStyleNative(this.swigCPtr, this, 0L, lineLayerItemStyle);
        } else {
            getStyleSwigExplicitLineLayerItemImplNative(this.swigCPtr, this, 0L, lineLayerItemStyle);
        }
    }

    public void setOddCarPosition(long j, float f, long j2, float f2) {
        $explicit_setOddCarPosition(j, f, j2, f2);
    }

    public void $explicit_setOddCarPosition(long j, float f, long j2, float f2) {
        long j3 = this.swigCPtr;
        if (j3 == 0) {
            throw new NullPointerException();
        }
        setOddCarPositionNative(j3, this, j, f, j2, f2);
    }

    public void setOddCarPosition(long j, float f, long j2) {
        $explicit_setOddCarPosition(j, f, j2);
    }

    public void $explicit_setOddCarPosition(long j, float f, long j2) {
        long j3 = this.swigCPtr;
        if (j3 == 0) {
            throw new NullPointerException();
        }
        setOddCarPosition1Native(j3, this, j, f, j2);
    }

    public void setOddCarPosition(long j, float f) {
        $explicit_setOddCarPosition(j, f);
    }

    public void $explicit_setOddCarPosition(long j, float f) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        setOddCarPosition2Native(j2, this, j, f);
    }

    public long getPointsCount() {
        return $explicit_getPointsCount();
    }

    public long $explicit_getPointsCount() {
        if (this.swigCPtr != 0) {
            return getClass() == LineLayerItemImpl.class ? getPointsCountNative(this.swigCPtr, this) : getPointsCountSwigExplicitLineLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }
}
