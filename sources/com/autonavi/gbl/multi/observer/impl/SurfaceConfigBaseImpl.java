package com.autonavi.gbl.multi.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.multi.impl.IKldDisplayImpl;
import com.autonavi.gbl.multi.model.RectSizeType;
import com.autonavi.gbl.multi.observer.SurfaceConfigBase;
@IntfAuto(target = SurfaceConfigBase.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class SurfaceConfigBaseImpl extends IKldConfigItemBaseImpl {
    private static BindTable BIND_TABLE = new BindTable(SurfaceConfigBaseImpl.class);
    private transient long swigCPtr;

    private static native long SurfaceConfigBaseImpl_SWIGUpcast(long j);

    private static native void SurfaceConfigBaseImpl_change_ownership(SurfaceConfigBaseImpl surfaceConfigBaseImpl, long j, boolean z);

    private static native void SurfaceConfigBaseImpl_director_connect(SurfaceConfigBaseImpl surfaceConfigBaseImpl, long j, boolean z, boolean z2);

    private static native int applyConfigNative(long j, SurfaceConfigBaseImpl surfaceConfigBaseImpl, long j2, IKldDisplayImpl iKldDisplayImpl);

    private static native int applyConfigSwigExplicitSurfaceConfigBaseImplNative(long j, SurfaceConfigBaseImpl surfaceConfigBaseImpl, long j2, IKldDisplayImpl iKldDisplayImpl);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native boolean isSeparateRenderGetNative(long j, SurfaceConfigBaseImpl surfaceConfigBaseImpl);

    private static native void isSeparateRenderSetNative(long j, SurfaceConfigBaseImpl surfaceConfigBaseImpl, boolean z);

    private static native boolean isSurfaceVisiableGetNative(long j, SurfaceConfigBaseImpl surfaceConfigBaseImpl);

    private static native void isSurfaceVisiableSetNative(long j, SurfaceConfigBaseImpl surfaceConfigBaseImpl, boolean z);

    private static native int parseConfigStringNative(long j, SurfaceConfigBaseImpl surfaceConfigBaseImpl, String str);

    private static native int parseConfigStringSwigExplicitSurfaceConfigBaseImplNative(long j, SurfaceConfigBaseImpl surfaceConfigBaseImpl, String str);

    private static native RectSizeType surfaceSizeGetNative(long j, SurfaceConfigBaseImpl surfaceConfigBaseImpl);

    private static native void surfaceSizeSetNative(long j, SurfaceConfigBaseImpl surfaceConfigBaseImpl, long j2, RectSizeType rectSizeType);

    private static native int windowIdGetNative(long j, SurfaceConfigBaseImpl surfaceConfigBaseImpl);

    private static native void windowIdSetNative(long j, SurfaceConfigBaseImpl surfaceConfigBaseImpl, int i);

    public SurfaceConfigBaseImpl(long j, boolean z) {
        super(SurfaceConfigBaseImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof SurfaceConfigBaseImpl) {
            return getUID(this) == getUID((SurfaceConfigBaseImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(SurfaceConfigBaseImpl surfaceConfigBaseImpl) {
        long cPtr = getCPtr(surfaceConfigBaseImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(SurfaceConfigBaseImpl surfaceConfigBaseImpl) {
        if (surfaceConfigBaseImpl == null) {
            return 0L;
        }
        return surfaceConfigBaseImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
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

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        SurfaceConfigBaseImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        SurfaceConfigBaseImpl_change_ownership(this, this.swigCPtr, true);
    }

    public SurfaceConfigBaseImpl() {
        this(createNativeObj(), true);
        MultiObserverJNI.swig_jni_init();
        SurfaceConfigBaseImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public int parseConfigString(String str) {
        return $explicit_parseConfigString(str);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public int $explicit_parseConfigString(String str) {
        if (this.swigCPtr != 0) {
            return getClass() == SurfaceConfigBaseImpl.class ? parseConfigStringNative(this.swigCPtr, this, str) : parseConfigStringSwigExplicitSurfaceConfigBaseImplNative(this.swigCPtr, this, str);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public int applyConfig(IKldDisplayImpl iKldDisplayImpl) {
        return $explicit_applyConfig(iKldDisplayImpl);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public int $explicit_applyConfig(IKldDisplayImpl iKldDisplayImpl) {
        if (this.swigCPtr != 0) {
            return getClass() == SurfaceConfigBaseImpl.class ? applyConfigNative(this.swigCPtr, this, IKldDisplayImpl.getCPtr(iKldDisplayImpl), iKldDisplayImpl) : applyConfigSwigExplicitSurfaceConfigBaseImplNative(this.swigCPtr, this, IKldDisplayImpl.getCPtr(iKldDisplayImpl), iKldDisplayImpl);
        }
        throw new NullPointerException();
    }

    public void setSurfaceSize(RectSizeType rectSizeType) {
        $explicit_setSurfaceSize(rectSizeType);
    }

    public void $explicit_setSurfaceSize(RectSizeType rectSizeType) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        surfaceSizeSetNative(j, this, 0L, rectSizeType);
    }

    public RectSizeType getSurfaceSize() {
        return $explicit_getSurfaceSize();
    }

    public RectSizeType $explicit_getSurfaceSize() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return surfaceSizeGetNative(j, this);
    }

    public void setIsSurfaceVisiable(boolean z) {
        $explicit_setIsSurfaceVisiable(z);
    }

    public void $explicit_setIsSurfaceVisiable(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        isSurfaceVisiableSetNative(j, this, z);
    }

    public boolean getIsSurfaceVisiable() {
        return $explicit_getIsSurfaceVisiable();
    }

    public boolean $explicit_getIsSurfaceVisiable() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isSurfaceVisiableGetNative(j, this);
    }

    public void setIsSeparateRender(boolean z) {
        $explicit_setIsSeparateRender(z);
    }

    public void $explicit_setIsSeparateRender(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        isSeparateRenderSetNative(j, this, z);
    }

    public boolean getIsSeparateRender() {
        return $explicit_getIsSeparateRender();
    }

    public boolean $explicit_getIsSeparateRender() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isSeparateRenderGetNative(j, this);
    }

    public void setWindowId(int i) {
        $explicit_setWindowId(i);
    }

    public void $explicit_setWindowId(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        windowIdSetNative(j, this, i);
    }

    public int getWindowId() {
        return $explicit_getWindowId();
    }

    public int $explicit_getWindowId() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return windowIdGetNative(j, this);
    }
}
