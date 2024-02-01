package com.autonavi.gbl.map.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.ArrowLayerItem;
import com.autonavi.gbl.map.layer.model.ArrowAnimationPlayState;
import com.autonavi.gbl.map.layer.model.ArrowLayerItemStyle;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.observer.impl.ILayerItemAnimationObserverImpl;
import java.util.ArrayList;
@IntfAuto(enableCRfx = true, protoOfCRfx = LayerItemCRfxProto.class, target = ArrowLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class ArrowLayerItemImpl extends LayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(ArrowLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long ArrowLayerItemImpl_SWIGUpcast(long j);

    private static native void ArrowLayerItemImpl_change_ownership(ArrowLayerItemImpl arrowLayerItemImpl, long j, boolean z);

    private static native void ArrowLayerItemImpl_director_connect(ArrowLayerItemImpl arrowLayerItemImpl, long j, boolean z, boolean z2);

    private static native boolean addGrownAnimationObserverNative(long j, ArrowLayerItemImpl arrowLayerItemImpl, long j2, ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl);

    private static native boolean addGrownAnimationObserverSwigExplicitArrowLayerItemImplNative(long j, ArrowLayerItemImpl arrowLayerItemImpl, long j2, ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native int getAnimationPlayStateNative(long j, ArrowLayerItemImpl arrowLayerItemImpl);

    private static native int getAnimationPlayStateSwigExplicitArrowLayerItemImplNative(long j, ArrowLayerItemImpl arrowLayerItemImpl);

    private static native String getClassTypeNameNative();

    private static native int getItemTypeNative(long j, ArrowLayerItemImpl arrowLayerItemImpl);

    private static native int getItemTypeSwigExplicitArrowLayerItemImplNative(long j, ArrowLayerItemImpl arrowLayerItemImpl);

    private static native void getStyleNative(long j, ArrowLayerItemImpl arrowLayerItemImpl, long j2, ArrowLayerItemStyle arrowLayerItemStyle);

    private static native void getStyleSwigExplicitArrowLayerItemImplNative(long j, ArrowLayerItemImpl arrowLayerItemImpl, long j2, ArrowLayerItemStyle arrowLayerItemStyle);

    private static native boolean isIntersectCircleNative(long j, ArrowLayerItemImpl arrowLayerItemImpl, double d, double d2, int i);

    private static native boolean isIntersectCircleSwigExplicitArrowLayerItemImplNative(long j, ArrowLayerItemImpl arrowLayerItemImpl, double d, double d2, int i);

    private static native boolean isIntersectRectNative(long j, ArrowLayerItemImpl arrowLayerItemImpl, long j2, RectDouble rectDouble);

    private static native boolean isIntersectRectSwigExplicitArrowLayerItemImplNative(long j, ArrowLayerItemImpl arrowLayerItemImpl, long j2, RectDouble rectDouble);

    private static native boolean removeGrownAnimationObserverNative(long j, ArrowLayerItemImpl arrowLayerItemImpl, long j2, ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl);

    private static native boolean removeGrownAnimationObserverSwigExplicitArrowLayerItemImplNative(long j, ArrowLayerItemImpl arrowLayerItemImpl, long j2, ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl);

    private static native void setAnimationPlayStateNative(long j, ArrowLayerItemImpl arrowLayerItemImpl, int i);

    private static native void setAnimationPlayStateSwigExplicitArrowLayerItemImplNative(long j, ArrowLayerItemImpl arrowLayerItemImpl, int i);

    private static native void setGrownAnimation1Native(long j, ArrowLayerItemImpl arrowLayerItemImpl, int i, int i2);

    private static native void setGrownAnimationNative(long j, ArrowLayerItemImpl arrowLayerItemImpl, int i, int i2, long j2);

    private static native void setGrownAnimationSwigExplicitArrowLayerItemImpl1Native(long j, ArrowLayerItemImpl arrowLayerItemImpl, int i, int i2);

    private static native void setGrownAnimationSwigExplicitArrowLayerItemImplNative(long j, ArrowLayerItemImpl arrowLayerItemImpl, int i, int i2, long j2);

    private static native void setPoints3DNative(long j, ArrowLayerItemImpl arrowLayerItemImpl, ArrayList<Coord3DDouble> arrayList);

    private static native void setPoints3DSwigExplicitArrowLayerItemImplNative(long j, ArrowLayerItemImpl arrowLayerItemImpl, ArrayList<Coord3DDouble> arrayList);

    private static native void setPointsNative(long j, ArrowLayerItemImpl arrowLayerItemImpl, ArrayList<Coord3DDouble> arrayList);

    private static native void setPointsSwigExplicitArrowLayerItemImplNative(long j, ArrowLayerItemImpl arrowLayerItemImpl, ArrayList<Coord3DDouble> arrayList);

    private static native void updateStyleNative(long j, ArrowLayerItemImpl arrowLayerItemImpl);

    private static native void updateStyleSwigExplicitArrowLayerItemImplNative(long j, ArrowLayerItemImpl arrowLayerItemImpl);

    public ArrowLayerItemImpl(long j, boolean z) {
        super(ArrowLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof ArrowLayerItemImpl) {
            return getUID(this) == getUID((ArrowLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(ArrowLayerItemImpl arrowLayerItemImpl) {
        long cPtr = getCPtr(arrowLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ArrowLayerItemImpl arrowLayerItemImpl) {
        if (arrowLayerItemImpl == null) {
            return 0L;
        }
        return arrowLayerItemImpl.swigCPtr;
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
        ArrowLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ArrowLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public ArrowLayerItemImpl() {
        this(createNativeObj(), true);
        MapLayerSvrJNI.swig_jni_init();
        ArrowLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
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
            return getClass() == ArrowLayerItemImpl.class ? getItemTypeNative(this.swigCPtr, this) : getItemTypeSwigExplicitArrowLayerItemImplNative(this.swigCPtr, this);
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
        if (getClass() == ArrowLayerItemImpl.class) {
            setPointsNative(this.swigCPtr, this, arrayList);
        } else {
            setPointsSwigExplicitArrowLayerItemImplNative(this.swigCPtr, this, arrayList);
        }
    }

    public void setPoints3D(ArrayList<Coord3DDouble> arrayList) {
        $explicit_setPoints3D(arrayList);
    }

    public void $explicit_setPoints3D(ArrayList<Coord3DDouble> arrayList) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == ArrowLayerItemImpl.class) {
            setPoints3DNative(this.swigCPtr, this, arrayList);
        } else {
            setPoints3DSwigExplicitArrowLayerItemImplNative(this.swigCPtr, this, arrayList);
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
        if (getClass() == ArrowLayerItemImpl.class) {
            updateStyleNative(this.swigCPtr, this);
        } else {
            updateStyleSwigExplicitArrowLayerItemImplNative(this.swigCPtr, this);
        }
    }

    public void getStyle(ArrowLayerItemStyle arrowLayerItemStyle) {
        $explicit_getStyle(arrowLayerItemStyle);
    }

    public void $explicit_getStyle(ArrowLayerItemStyle arrowLayerItemStyle) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == ArrowLayerItemImpl.class) {
            getStyleNative(this.swigCPtr, this, 0L, arrowLayerItemStyle);
        } else {
            getStyleSwigExplicitArrowLayerItemImplNative(this.swigCPtr, this, 0L, arrowLayerItemStyle);
        }
    }

    public void setAnimationPlayState(@ArrowAnimationPlayState.ArrowAnimationPlayState1 int i) {
        $explicit_setAnimationPlayState(i);
    }

    public void $explicit_setAnimationPlayState(@ArrowAnimationPlayState.ArrowAnimationPlayState1 int i) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == ArrowLayerItemImpl.class) {
            setAnimationPlayStateNative(this.swigCPtr, this, i);
        } else {
            setAnimationPlayStateSwigExplicitArrowLayerItemImplNative(this.swigCPtr, this, i);
        }
    }

    @ArrowAnimationPlayState.ArrowAnimationPlayState1
    public int getAnimationPlayState() {
        return $explicit_getAnimationPlayState();
    }

    @ArrowAnimationPlayState.ArrowAnimationPlayState1
    public int $explicit_getAnimationPlayState() {
        if (this.swigCPtr != 0) {
            return getClass() == ArrowLayerItemImpl.class ? getAnimationPlayStateNative(this.swigCPtr, this) : getAnimationPlayStateSwigExplicitArrowLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public void setGrownAnimation(int i, int i2, long j) {
        $explicit_setGrownAnimation(i, i2, j);
    }

    public void $explicit_setGrownAnimation(int i, int i2, long j) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == ArrowLayerItemImpl.class) {
            setGrownAnimationNative(this.swigCPtr, this, i, i2, j);
        } else {
            setGrownAnimationSwigExplicitArrowLayerItemImplNative(this.swigCPtr, this, i, i2, j);
        }
    }

    public void setGrownAnimation(int i, int i2) {
        $explicit_setGrownAnimation(i, i2);
    }

    public void $explicit_setGrownAnimation(int i, int i2) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == ArrowLayerItemImpl.class) {
            setGrownAnimation1Native(this.swigCPtr, this, i, i2);
        } else {
            setGrownAnimationSwigExplicitArrowLayerItemImpl1Native(this.swigCPtr, this, i, i2);
        }
    }

    public boolean addGrownAnimationObserver(ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl) {
        return $explicit_addGrownAnimationObserver(iLayerItemAnimationObserverImpl);
    }

    public boolean $explicit_addGrownAnimationObserver(ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl) {
        if (this.swigCPtr != 0) {
            return getClass() == ArrowLayerItemImpl.class ? addGrownAnimationObserverNative(this.swigCPtr, this, ILayerItemAnimationObserverImpl.getCPtr(iLayerItemAnimationObserverImpl), iLayerItemAnimationObserverImpl) : addGrownAnimationObserverSwigExplicitArrowLayerItemImplNative(this.swigCPtr, this, ILayerItemAnimationObserverImpl.getCPtr(iLayerItemAnimationObserverImpl), iLayerItemAnimationObserverImpl);
        }
        throw new NullPointerException();
    }

    public boolean removeGrownAnimationObserver(ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl) {
        return $explicit_removeGrownAnimationObserver(iLayerItemAnimationObserverImpl);
    }

    public boolean $explicit_removeGrownAnimationObserver(ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl) {
        if (this.swigCPtr != 0) {
            return getClass() == ArrowLayerItemImpl.class ? removeGrownAnimationObserverNative(this.swigCPtr, this, ILayerItemAnimationObserverImpl.getCPtr(iLayerItemAnimationObserverImpl), iLayerItemAnimationObserverImpl) : removeGrownAnimationObserverSwigExplicitArrowLayerItemImplNative(this.swigCPtr, this, ILayerItemAnimationObserverImpl.getCPtr(iLayerItemAnimationObserverImpl), iLayerItemAnimationObserverImpl);
        }
        throw new NullPointerException();
    }

    public boolean isIntersectCircle(double d, double d2, int i) {
        return $explicit_isIntersectCircle(d, d2, i);
    }

    public boolean $explicit_isIntersectCircle(double d, double d2, int i) {
        if (this.swigCPtr != 0) {
            return getClass() == ArrowLayerItemImpl.class ? isIntersectCircleNative(this.swigCPtr, this, d, d2, i) : isIntersectCircleSwigExplicitArrowLayerItemImplNative(this.swigCPtr, this, d, d2, i);
        }
        throw new NullPointerException();
    }

    public boolean isIntersectRect(RectDouble rectDouble) {
        return $explicit_isIntersectRect(rectDouble);
    }

    public boolean $explicit_isIntersectRect(RectDouble rectDouble) {
        if (this.swigCPtr != 0) {
            return getClass() == ArrowLayerItemImpl.class ? isIntersectRectNative(this.swigCPtr, this, 0L, rectDouble) : isIntersectRectSwigExplicitArrowLayerItemImplNative(this.swigCPtr, this, 0L, rectDouble);
        }
        throw new NullPointerException();
    }
}
