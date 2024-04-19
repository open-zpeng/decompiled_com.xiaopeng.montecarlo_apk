package com.autonavi.gbl.multi.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.map.model.MapViewPortParam;
import com.autonavi.gbl.multi.impl.IKldDisplayImpl;
import com.autonavi.gbl.multi.model.LeftTop;
import com.autonavi.gbl.multi.model.ZoomScale;
import com.autonavi.gbl.multi.observer.RenderConfigBase;
@IntfAuto(target = RenderConfigBase.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class RenderConfigBaseImpl extends IKldConfigItemBaseImpl {
    private static BindTable BIND_TABLE = new BindTable(RenderConfigBaseImpl.class);
    private transient long swigCPtr;

    private static native long RenderConfigBaseImpl_SWIGUpcast(long j);

    private static native void RenderConfigBaseImpl_change_ownership(RenderConfigBaseImpl renderConfigBaseImpl, long j, boolean z);

    private static native void RenderConfigBaseImpl_director_connect(RenderConfigBaseImpl renderConfigBaseImpl, long j, boolean z, boolean z2);

    private static native int activateConfigItemNative(long j, RenderConfigBaseImpl renderConfigBaseImpl, String str, long j2, IKldDisplayImpl iKldDisplayImpl);

    private static native int applyConfigNative(long j, RenderConfigBaseImpl renderConfigBaseImpl, long j2, IKldDisplayImpl iKldDisplayImpl);

    private static native int applyConfigSwigExplicitRenderConfigBaseImplNative(long j, RenderConfigBaseImpl renderConfigBaseImpl, long j2, IKldDisplayImpl iKldDisplayImpl);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native int fpsGetNative(long j, RenderConfigBaseImpl renderConfigBaseImpl);

    private static native void fpsSetNative(long j, RenderConfigBaseImpl renderConfigBaseImpl, int i);

    private static native boolean isMapVisiableGetNative(long j, RenderConfigBaseImpl renderConfigBaseImpl);

    private static native void isMapVisiableSetNative(long j, RenderConfigBaseImpl renderConfigBaseImpl, boolean z);

    private static native float mapTextScaleGetNative(long j, RenderConfigBaseImpl renderConfigBaseImpl);

    private static native void mapTextScaleSetNative(long j, RenderConfigBaseImpl renderConfigBaseImpl, float f);

    private static native MapViewPortParam mapViewPortGetNative(long j, RenderConfigBaseImpl renderConfigBaseImpl);

    private static native void mapViewPortSetNative(long j, RenderConfigBaseImpl renderConfigBaseImpl, long j2, MapViewPortParam mapViewPortParam);

    private static native int parseConfigStringNative(long j, RenderConfigBaseImpl renderConfigBaseImpl, String str);

    private static native int parseConfigStringSwigExplicitRenderConfigBaseImplNative(long j, RenderConfigBaseImpl renderConfigBaseImpl, String str);

    private static native LeftTop projectCenterGetNative(long j, RenderConfigBaseImpl renderConfigBaseImpl);

    private static native void projectCenterSetNative(long j, RenderConfigBaseImpl renderConfigBaseImpl, long j2, LeftTop leftTop);

    private static native void setConfigNameNative(long j, RenderConfigBaseImpl renderConfigBaseImpl, String str);

    private static native ZoomScale zoomScaleGetNative(long j, RenderConfigBaseImpl renderConfigBaseImpl);

    private static native void zoomScaleSetNative(long j, RenderConfigBaseImpl renderConfigBaseImpl, long j2, ZoomScale zoomScale);

    public RenderConfigBaseImpl(long j, boolean z) {
        super(RenderConfigBaseImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof RenderConfigBaseImpl) {
            return getUID(this) == getUID((RenderConfigBaseImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(RenderConfigBaseImpl renderConfigBaseImpl) {
        long cPtr = getCPtr(renderConfigBaseImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(RenderConfigBaseImpl renderConfigBaseImpl) {
        if (renderConfigBaseImpl == null) {
            return 0L;
        }
        return renderConfigBaseImpl.swigCPtr;
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
        RenderConfigBaseImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        RenderConfigBaseImpl_change_ownership(this, this.swigCPtr, true);
    }

    public RenderConfigBaseImpl() {
        this(createNativeObj(), true);
        MultiObserverJNI.swig_jni_init();
        RenderConfigBaseImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public int parseConfigString(String str) {
        return $explicit_parseConfigString(str);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public int $explicit_parseConfigString(String str) {
        if (this.swigCPtr != 0) {
            return getClass() == RenderConfigBaseImpl.class ? parseConfigStringNative(this.swigCPtr, this, str) : parseConfigStringSwigExplicitRenderConfigBaseImplNative(this.swigCPtr, this, str);
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
            return getClass() == RenderConfigBaseImpl.class ? applyConfigNative(this.swigCPtr, this, IKldDisplayImpl.getCPtr(iKldDisplayImpl), iKldDisplayImpl) : applyConfigSwigExplicitRenderConfigBaseImplNative(this.swigCPtr, this, IKldDisplayImpl.getCPtr(iKldDisplayImpl), iKldDisplayImpl);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public void setConfigName(String str) {
        $explicit_setConfigName(str);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public void $explicit_setConfigName(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setConfigNameNative(j, this, str);
    }

    public int activateConfigItem(String str, IKldDisplayImpl iKldDisplayImpl) {
        return $explicit_activateConfigItem(str, iKldDisplayImpl);
    }

    public int $explicit_activateConfigItem(String str, IKldDisplayImpl iKldDisplayImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return activateConfigItemNative(j, this, str, IKldDisplayImpl.getCPtr(iKldDisplayImpl), iKldDisplayImpl);
    }

    public void setIsMapVisiable(boolean z) {
        $explicit_setIsMapVisiable(z);
    }

    public void $explicit_setIsMapVisiable(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        isMapVisiableSetNative(j, this, z);
    }

    public boolean getIsMapVisiable() {
        return $explicit_getIsMapVisiable();
    }

    public boolean $explicit_getIsMapVisiable() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isMapVisiableGetNative(j, this);
    }

    public void setZoomScale(ZoomScale zoomScale) {
        $explicit_setZoomScale(zoomScale);
    }

    public void $explicit_setZoomScale(ZoomScale zoomScale) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        zoomScaleSetNative(j, this, 0L, zoomScale);
    }

    public ZoomScale getZoomScale() {
        return $explicit_getZoomScale();
    }

    public ZoomScale $explicit_getZoomScale() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return zoomScaleGetNative(j, this);
    }

    public void setMapTextScale(float f) {
        $explicit_setMapTextScale(f);
    }

    public void $explicit_setMapTextScale(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mapTextScaleSetNative(j, this, f);
    }

    public float getMapTextScale() {
        return $explicit_getMapTextScale();
    }

    public float $explicit_getMapTextScale() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mapTextScaleGetNative(j, this);
    }

    public void setFps(int i) {
        $explicit_setFps(i);
    }

    public void $explicit_setFps(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        fpsSetNative(j, this, i);
    }

    public int getFps() {
        return $explicit_getFps();
    }

    public int $explicit_getFps() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return fpsGetNative(j, this);
    }

    public void setProjectCenter(LeftTop leftTop) {
        $explicit_setProjectCenter(leftTop);
    }

    public void $explicit_setProjectCenter(LeftTop leftTop) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        projectCenterSetNative(j, this, 0L, leftTop);
    }

    public LeftTop getProjectCenter() {
        return $explicit_getProjectCenter();
    }

    public LeftTop $explicit_getProjectCenter() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return projectCenterGetNative(j, this);
    }

    public void setMapViewPort(MapViewPortParam mapViewPortParam) {
        $explicit_setMapViewPort(mapViewPortParam);
    }

    public void $explicit_setMapViewPort(MapViewPortParam mapViewPortParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mapViewPortSetNative(j, this, 0L, mapViewPortParam);
    }

    public MapViewPortParam getMapViewPort() {
        return $explicit_getMapViewPort();
    }

    public MapViewPortParam $explicit_getMapViewPort() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mapViewPortGetNative(j, this);
    }
}
