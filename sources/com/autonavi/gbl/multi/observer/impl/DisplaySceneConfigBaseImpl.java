package com.autonavi.gbl.multi.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.multi.impl.IKldDisplayImpl;
import com.autonavi.gbl.multi.observer.DisplaySceneConfigBase;
@IntfAuto(target = DisplaySceneConfigBase.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class DisplaySceneConfigBaseImpl extends IKldConfigItemBaseImpl {
    private static BindTable BIND_TABLE = new BindTable(DisplaySceneConfigBaseImpl.class);
    private transient long swigCPtr;

    private static native long DisplaySceneConfigBaseImpl_SWIGUpcast(long j);

    private static native void DisplaySceneConfigBaseImpl_change_ownership(DisplaySceneConfigBaseImpl displaySceneConfigBaseImpl, long j, boolean z);

    private static native void DisplaySceneConfigBaseImpl_director_connect(DisplaySceneConfigBaseImpl displaySceneConfigBaseImpl, long j, boolean z, boolean z2);

    private static native int applyConfigNative(long j, DisplaySceneConfigBaseImpl displaySceneConfigBaseImpl, long j2, IKldDisplayImpl iKldDisplayImpl);

    private static native int applyConfigSwigExplicitDisplaySceneConfigBaseImplNative(long j, DisplaySceneConfigBaseImpl displaySceneConfigBaseImpl, long j2, IKldDisplayImpl iKldDisplayImpl);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native String mapConfigNameGetNative(long j, DisplaySceneConfigBaseImpl displaySceneConfigBaseImpl);

    private static native void mapConfigNameSetNative(long j, DisplaySceneConfigBaseImpl displaySceneConfigBaseImpl, String str);

    private static native int parseConfigStringNative(long j, DisplaySceneConfigBaseImpl displaySceneConfigBaseImpl, String str);

    private static native int parseConfigStringSwigExplicitDisplaySceneConfigBaseImplNative(long j, DisplaySceneConfigBaseImpl displaySceneConfigBaseImpl, String str);

    private static native String renderConfigNameGetNative(long j, DisplaySceneConfigBaseImpl displaySceneConfigBaseImpl);

    private static native void renderConfigNameSetNative(long j, DisplaySceneConfigBaseImpl displaySceneConfigBaseImpl, String str);

    public DisplaySceneConfigBaseImpl(long j, boolean z) {
        super(DisplaySceneConfigBaseImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof DisplaySceneConfigBaseImpl) {
            return getUID(this) == getUID((DisplaySceneConfigBaseImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(DisplaySceneConfigBaseImpl displaySceneConfigBaseImpl) {
        long cPtr = getCPtr(displaySceneConfigBaseImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(DisplaySceneConfigBaseImpl displaySceneConfigBaseImpl) {
        if (displaySceneConfigBaseImpl == null) {
            return 0L;
        }
        return displaySceneConfigBaseImpl.swigCPtr;
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
        DisplaySceneConfigBaseImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        DisplaySceneConfigBaseImpl_change_ownership(this, this.swigCPtr, true);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public int parseConfigString(String str) {
        return $explicit_parseConfigString(str);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public int $explicit_parseConfigString(String str) {
        if (this.swigCPtr != 0) {
            return getClass() == DisplaySceneConfigBaseImpl.class ? parseConfigStringNative(this.swigCPtr, this, str) : parseConfigStringSwigExplicitDisplaySceneConfigBaseImplNative(this.swigCPtr, this, str);
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
            return getClass() == DisplaySceneConfigBaseImpl.class ? applyConfigNative(this.swigCPtr, this, IKldDisplayImpl.getCPtr(iKldDisplayImpl), iKldDisplayImpl) : applyConfigSwigExplicitDisplaySceneConfigBaseImplNative(this.swigCPtr, this, IKldDisplayImpl.getCPtr(iKldDisplayImpl), iKldDisplayImpl);
        }
        throw new NullPointerException();
    }

    public void setRenderConfigName(String str) {
        $explicit_setRenderConfigName(str);
    }

    public void $explicit_setRenderConfigName(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        renderConfigNameSetNative(j, this, str);
    }

    public String getRenderConfigName() {
        return $explicit_getRenderConfigName();
    }

    public String $explicit_getRenderConfigName() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return renderConfigNameGetNative(j, this);
    }

    public void setMapConfigName(String str) {
        $explicit_setMapConfigName(str);
    }

    public void $explicit_setMapConfigName(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mapConfigNameSetNative(j, this, str);
    }

    public String getMapConfigName() {
        return $explicit_getMapConfigName();
    }

    public String $explicit_getMapConfigName() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mapConfigNameGetNative(j, this);
    }

    public DisplaySceneConfigBaseImpl() {
        this(createNativeObj(), true);
        MultiObserverJNI.swig_jni_init();
        DisplaySceneConfigBaseImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
