package com.autonavi.gbl.scene.navi.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.option.impl.IRouteOptionImpl;
import com.autonavi.gbl.scene.impl.IBaseSceneModuleImpl;
import com.autonavi.gbl.scene.navi.NaviModule;
import com.autonavi.gbl.search.model.SearchPoiBase;
import com.autonavi.gbl.user.msgpush.model.AimRoutePushMsg;
@IntfAuto(target = NaviModule.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class INaviModuleImpl extends IBaseSceneModuleImpl {
    private static BindTable BIND_TABLE = new BindTable(INaviModuleImpl.class);
    private transient long swigCPtr;

    private static native long INaviModuleImpl_SWIGUpcast(long j);

    private static native void destroyNativeObj(long j);

    private static native int initNative(long j, INaviModuleImpl iNaviModuleImpl);

    private static native long requestRouteRestorationNative(long j, INaviModuleImpl iNaviModuleImpl, long j2, AimRoutePushMsg aimRoutePushMsg);

    private static native long requestRouteToSearchPoiNative(long j, INaviModuleImpl iNaviModuleImpl, long j2, SearchPoiBase searchPoiBase, long j3, IRouteOptionImpl iRouteOptionImpl);

    public INaviModuleImpl(long j, boolean z) {
        super(INaviModuleImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.scene.impl.IBaseSceneModuleImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.scene.impl.IBaseSceneModuleImpl
    public boolean equals(Object obj) {
        if (obj instanceof INaviModuleImpl) {
            return getUID(this) == getUID((INaviModuleImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(INaviModuleImpl iNaviModuleImpl) {
        long cPtr = getCPtr(iNaviModuleImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(INaviModuleImpl iNaviModuleImpl) {
        if (iNaviModuleImpl == null) {
            return 0L;
        }
        return iNaviModuleImpl.swigCPtr;
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

    public int init() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initNative(j, this);
    }

    public long requestRouteRestoration(AimRoutePushMsg aimRoutePushMsg) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return requestRouteRestorationNative(j, this, 0L, aimRoutePushMsg);
    }

    public long requestRouteToSearchPoi(SearchPoiBase searchPoiBase, IRouteOptionImpl iRouteOptionImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return requestRouteToSearchPoiNative(j, this, 0L, searchPoiBase, IRouteOptionImpl.getCPtr(iRouteOptionImpl), iRouteOptionImpl);
    }
}
