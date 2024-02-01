package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.FlyLineTypePointLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = FlyLineTypePointLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class FlyLineTypePointLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(FlyLineTypePointLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long FlyLineTypePointLayerItemImpl_SWIGUpcast(long j);

    private static native void FlyLineTypePointLayerItemImpl_change_ownership(FlyLineTypePointLayerItemImpl flyLineTypePointLayerItemImpl, long j, boolean z);

    private static native void FlyLineTypePointLayerItemImpl_director_connect(FlyLineTypePointLayerItemImpl flyLineTypePointLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int mainkeyGetNative(long j, FlyLineTypePointLayerItemImpl flyLineTypePointLayerItemImpl);

    private static native void mainkeySetNative(long j, FlyLineTypePointLayerItemImpl flyLineTypePointLayerItemImpl, int i);

    private static native String nameGetNative(long j, FlyLineTypePointLayerItemImpl flyLineTypePointLayerItemImpl);

    private static native void nameSetNative(long j, FlyLineTypePointLayerItemImpl flyLineTypePointLayerItemImpl, String str);

    private static native int subkeyGetNative(long j, FlyLineTypePointLayerItemImpl flyLineTypePointLayerItemImpl);

    private static native void subkeySetNative(long j, FlyLineTypePointLayerItemImpl flyLineTypePointLayerItemImpl, int i);

    private static native float textFontScaleGetNative(long j, FlyLineTypePointLayerItemImpl flyLineTypePointLayerItemImpl);

    private static native void textFontScaleSetNative(long j, FlyLineTypePointLayerItemImpl flyLineTypePointLayerItemImpl, float f);

    public FlyLineTypePointLayerItemImpl(long j, boolean z) {
        super(FlyLineTypePointLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof FlyLineTypePointLayerItemImpl) {
            return getUID(this) == getUID((FlyLineTypePointLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(FlyLineTypePointLayerItemImpl flyLineTypePointLayerItemImpl) {
        long cPtr = getCPtr(flyLineTypePointLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(FlyLineTypePointLayerItemImpl flyLineTypePointLayerItemImpl) {
        if (flyLineTypePointLayerItemImpl == null) {
            return 0L;
        }
        return flyLineTypePointLayerItemImpl.swigCPtr;
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
        FlyLineTypePointLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        FlyLineTypePointLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public FlyLineTypePointLayerItemImpl() {
        this(createNativeObj(), true);
        LayerSvrJNI.swig_jni_init();
        FlyLineTypePointLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setName(String str) {
        $explicit_setName(str);
    }

    public void $explicit_setName(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        nameSetNative(j, this, str);
    }

    public String getName() {
        return $explicit_getName();
    }

    public String $explicit_getName() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return nameGetNative(j, this);
    }

    public void setMainkey(int i) {
        $explicit_setMainkey(i);
    }

    public void $explicit_setMainkey(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mainkeySetNative(j, this, i);
    }

    public int getMainkey() {
        return $explicit_getMainkey();
    }

    public int $explicit_getMainkey() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mainkeyGetNative(j, this);
    }

    public void setSubkey(int i) {
        $explicit_setSubkey(i);
    }

    public void $explicit_setSubkey(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        subkeySetNative(j, this, i);
    }

    public int getSubkey() {
        return $explicit_getSubkey();
    }

    public int $explicit_getSubkey() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return subkeyGetNative(j, this);
    }

    public void setTextFontScale(float f) {
        $explicit_setTextFontScale(f);
    }

    public void $explicit_setTextFontScale(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        textFontScaleSetNative(j, this, f);
    }

    public float getTextFontScale() {
        return $explicit_getTextFontScale();
    }

    public float $explicit_getTextFontScale() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return textFontScaleGetNative(j, this);
    }
}
