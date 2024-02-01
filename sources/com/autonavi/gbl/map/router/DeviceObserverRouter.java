package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.model.EGLColorBits;
import com.autonavi.gbl.map.model.EGLDeviceID;
import com.autonavi.gbl.map.model.EGLDeviceRenderStatus;
import com.autonavi.gbl.map.observer.IDeviceObserver;
import com.autonavi.gbl.map.observer.impl.IDeviceObserverImpl;
@IntfAuto(target = IDeviceObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class DeviceObserverRouter extends IDeviceObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(DeviceObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(DeviceObserverRouter.class);
    private TypeHelper mHelper;
    private IDeviceObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IDeviceObserver iDeviceObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IDeviceObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iDeviceObserver;
    }

    protected DeviceObserverRouter(String str, IDeviceObserver iDeviceObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iDeviceObserver);
    }

    protected DeviceObserverRouter(String str, IDeviceObserver iDeviceObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iDeviceObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.observer.impl.IDeviceObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.observer.impl.IDeviceObserverImpl
    public void onDeviceCreated(int i) {
        IDeviceObserver iDeviceObserver = this.mObserver;
        if (iDeviceObserver != null) {
            iDeviceObserver.onDeviceCreated(i);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IDeviceObserverImpl
    public void onDeviceDestroyed(int i) {
        IDeviceObserver iDeviceObserver = this.mObserver;
        if (iDeviceObserver != null) {
            iDeviceObserver.onDeviceDestroyed(i);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IDeviceObserverImpl
    public void onSurfaceCreated(int i, int i2, int i3, @EGLColorBits.EGLColorBits1 int i4) {
        IDeviceObserver iDeviceObserver = this.mObserver;
        if (iDeviceObserver != null) {
            iDeviceObserver.onSurfaceCreated(i, i2, i3, i4);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IDeviceObserverImpl
    public void onSurfaceDestroyed(int i, int i2, int i3, @EGLColorBits.EGLColorBits1 int i4) {
        IDeviceObserver iDeviceObserver = this.mObserver;
        if (iDeviceObserver != null) {
            iDeviceObserver.onSurfaceDestroyed(i, i2, i3, i4);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IDeviceObserverImpl
    public void onSurfaceChanged(int i, int i2, int i3, @EGLColorBits.EGLColorBits1 int i4) {
        IDeviceObserver iDeviceObserver = this.mObserver;
        if (iDeviceObserver != null) {
            iDeviceObserver.onSurfaceChanged(i, i2, i3, i4);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IDeviceObserverImpl
    public void onDeviceRender(int i, @EGLDeviceRenderStatus.EGLDeviceRenderStatus1 int i2) {
        IDeviceObserver iDeviceObserver = this.mObserver;
        if (iDeviceObserver != null) {
            iDeviceObserver.onDeviceRender(i, i2);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IDeviceObserverImpl
    public void onEGLDoRender(@EGLDeviceID.EGLDeviceID1 int i) {
        IDeviceObserver iDeviceObserver = this.mObserver;
        if (iDeviceObserver != null) {
            iDeviceObserver.onEGLDoRender(i);
        }
    }
}
