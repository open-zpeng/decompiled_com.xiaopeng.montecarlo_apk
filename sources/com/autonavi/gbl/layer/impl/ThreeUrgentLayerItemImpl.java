package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.ThreeUrgentLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.model.ThreeUrgentType;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = ThreeUrgentLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class ThreeUrgentLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(ThreeUrgentLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long ThreeUrgentLayerItemImpl_SWIGUpcast(long j);

    private static native void ThreeUrgentLayerItemImpl_change_ownership(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, long j, boolean z);

    private static native void ThreeUrgentLayerItemImpl_director_connect(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(int i);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int mBigBubbleStyleGetNative(long j, ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl);

    private static native void mBigBubbleStyleSetNative(long j, ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, int i);

    private static native int mElectronicEyeSpeedGetNative(long j, ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl);

    private static native void mElectronicEyeSpeedSetNative(long j, ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, int i);

    private static native int mPassingSpeedGetNative(long j, ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl);

    private static native void mPassingSpeedSetNative(long j, ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, int i);

    private static native int mTypeGetNative(long j, ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl);

    private static native void mTypeSetNative(long j, ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, int i);

    private static native boolean mbIsMaxOverSpeedPointGetNative(long j, ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl);

    private static native void mbIsMaxOverSpeedPointSetNative(long j, ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, boolean z);

    public ThreeUrgentLayerItemImpl(long j, boolean z) {
        super(ThreeUrgentLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof ThreeUrgentLayerItemImpl) {
            return getUID(this) == getUID((ThreeUrgentLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl) {
        long cPtr = getCPtr(threeUrgentLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl) {
        if (threeUrgentLayerItemImpl == null) {
            return 0L;
        }
        return threeUrgentLayerItemImpl.swigCPtr;
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
        ThreeUrgentLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ThreeUrgentLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public ThreeUrgentLayerItemImpl(@ThreeUrgentType.ThreeUrgentType1 int i) {
        this(createNativeObj(i), true);
        LayerSvrJNI.swig_jni_init();
        ThreeUrgentLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setMType(@ThreeUrgentType.ThreeUrgentType1 int i) {
        $explicit_setMType(i);
    }

    public void $explicit_setMType(@ThreeUrgentType.ThreeUrgentType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mTypeSetNative(j, this, i);
    }

    @ThreeUrgentType.ThreeUrgentType1
    public int getMType() {
        return $explicit_getMType();
    }

    @ThreeUrgentType.ThreeUrgentType1
    public int $explicit_getMType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mTypeGetNative(j, this);
    }

    public void setMBigBubbleStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        $explicit_setMBigBubbleStyle(i);
    }

    public void $explicit_setMBigBubbleStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mBigBubbleStyleSetNative(j, this, i);
    }

    @BizDirectionStyle.BizDirectionStyle1
    public int getMBigBubbleStyle() {
        return $explicit_getMBigBubbleStyle();
    }

    @BizDirectionStyle.BizDirectionStyle1
    public int $explicit_getMBigBubbleStyle() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mBigBubbleStyleGetNative(j, this);
    }

    public void setMbIsMaxOverSpeedPoint(boolean z) {
        $explicit_setMbIsMaxOverSpeedPoint(z);
    }

    public void $explicit_setMbIsMaxOverSpeedPoint(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mbIsMaxOverSpeedPointSetNative(j, this, z);
    }

    public boolean getMbIsMaxOverSpeedPoint() {
        return $explicit_getMbIsMaxOverSpeedPoint();
    }

    public boolean $explicit_getMbIsMaxOverSpeedPoint() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mbIsMaxOverSpeedPointGetNative(j, this);
    }

    public void setMPassingSpeed(int i) {
        $explicit_setMPassingSpeed(i);
    }

    public void $explicit_setMPassingSpeed(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mPassingSpeedSetNative(j, this, i);
    }

    public int getMPassingSpeed() {
        return $explicit_getMPassingSpeed();
    }

    public int $explicit_getMPassingSpeed() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mPassingSpeedGetNative(j, this);
    }

    public void setMElectronicEyeSpeed(int i) {
        $explicit_setMElectronicEyeSpeed(i);
    }

    public void $explicit_setMElectronicEyeSpeed(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mElectronicEyeSpeedSetNative(j, this, i);
    }

    public int getMElectronicEyeSpeed() {
        return $explicit_getMElectronicEyeSpeed();
    }

    public int $explicit_getMElectronicEyeSpeed() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mElectronicEyeSpeedGetNative(j, this);
    }
}
