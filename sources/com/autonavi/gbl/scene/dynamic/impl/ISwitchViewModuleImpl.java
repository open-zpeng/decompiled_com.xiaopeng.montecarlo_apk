package com.autonavi.gbl.scene.dynamic.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.scene.dynamic.SwitchViewModule;
import com.autonavi.gbl.scene.impl.IBaseSceneModuleImpl;
import com.autonavi.gbl.scene.observer.impl.IViewParamAdapterImpl;
@IntfAuto(target = SwitchViewModule.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class ISwitchViewModuleImpl extends IBaseSceneModuleImpl {
    private static BindTable BIND_TABLE = new BindTable(ISwitchViewModuleImpl.class);
    private transient long swigCPtr;

    private static native long ISwitchViewModuleImpl_SWIGUpcast(long j);

    private static native void destroyNativeObj(long j);

    private static native void setIViewParamAdapterNative(long j, ISwitchViewModuleImpl iSwitchViewModuleImpl, long j2, IViewParamAdapterImpl iViewParamAdapterImpl);

    public ISwitchViewModuleImpl(long j, boolean z) {
        super(ISwitchViewModuleImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.scene.impl.IBaseSceneModuleImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.scene.impl.IBaseSceneModuleImpl
    public boolean equals(Object obj) {
        if (obj instanceof ISwitchViewModuleImpl) {
            return getUID(this) == getUID((ISwitchViewModuleImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(ISwitchViewModuleImpl iSwitchViewModuleImpl) {
        long cPtr = getCPtr(iSwitchViewModuleImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ISwitchViewModuleImpl iSwitchViewModuleImpl) {
        if (iSwitchViewModuleImpl == null) {
            return 0L;
        }
        return iSwitchViewModuleImpl.swigCPtr;
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

    public void setIViewParamAdapter(IViewParamAdapterImpl iViewParamAdapterImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setIViewParamAdapterNative(j, this, IViewParamAdapterImpl.getCPtr(iViewParamAdapterImpl), iViewParamAdapterImpl);
    }
}
