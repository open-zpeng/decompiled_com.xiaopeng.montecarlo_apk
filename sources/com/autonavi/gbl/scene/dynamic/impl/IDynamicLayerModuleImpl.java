package com.autonavi.gbl.scene.dynamic.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.scene.dynamic.DynamicLayerModule;
import com.autonavi.gbl.scene.impl.IBaseSceneModuleImpl;
import com.autonavi.gbl.scene.model.ScreenParam;
import com.autonavi.gbl.scene.observer.impl.IDisplayObserverImpl;
import com.autonavi.gbl.scene.observer.impl.IScreenParamAdapterImpl;
@IntfAuto(target = DynamicLayerModule.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IDynamicLayerModuleImpl extends IBaseSceneModuleImpl {
    private static BindTable BIND_TABLE = new BindTable(IDynamicLayerModuleImpl.class);
    private transient long swigCPtr;

    private static native long IDynamicLayerModuleImpl_SWIGUpcast(long j);

    private static native boolean addDisplayObserverNative(long j, IDynamicLayerModuleImpl iDynamicLayerModuleImpl, long j2, IDisplayObserverImpl iDisplayObserverImpl);

    private static native void destroyNativeObj(long j);

    private static native boolean removeDisplayObserverNative(long j, IDynamicLayerModuleImpl iDynamicLayerModuleImpl, long j2, IDisplayObserverImpl iDisplayObserverImpl);

    private static native void setScreenParamAdapterNative(long j, IDynamicLayerModuleImpl iDynamicLayerModuleImpl, long j2, IScreenParamAdapterImpl iScreenParamAdapterImpl);

    private static native boolean updateScreenParamNative(long j, IDynamicLayerModuleImpl iDynamicLayerModuleImpl, long j2, ScreenParam screenParam);

    public IDynamicLayerModuleImpl(long j, boolean z) {
        super(IDynamicLayerModuleImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.scene.impl.IBaseSceneModuleImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.scene.impl.IBaseSceneModuleImpl
    public boolean equals(Object obj) {
        if (obj instanceof IDynamicLayerModuleImpl) {
            return getUID(this) == getUID((IDynamicLayerModuleImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(IDynamicLayerModuleImpl iDynamicLayerModuleImpl) {
        long cPtr = getCPtr(iDynamicLayerModuleImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IDynamicLayerModuleImpl iDynamicLayerModuleImpl) {
        if (iDynamicLayerModuleImpl == null) {
            return 0L;
        }
        return iDynamicLayerModuleImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.scene.impl.IBaseSceneModuleImpl
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

    public void setScreenParamAdapter(IScreenParamAdapterImpl iScreenParamAdapterImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setScreenParamAdapterNative(j, this, IScreenParamAdapterImpl.getCPtr(iScreenParamAdapterImpl), iScreenParamAdapterImpl);
    }

    public boolean updateScreenParam(ScreenParam screenParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return updateScreenParamNative(j, this, 0L, screenParam);
    }

    public boolean addDisplayObserver(IDisplayObserverImpl iDisplayObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addDisplayObserverNative(j, this, IDisplayObserverImpl.getCPtr(iDisplayObserverImpl), iDisplayObserverImpl);
    }

    public boolean removeDisplayObserver(IDisplayObserverImpl iDisplayObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return removeDisplayObserverNative(j, this, IDisplayObserverImpl.getCPtr(iDisplayObserverImpl), iDisplayObserverImpl);
    }
}
