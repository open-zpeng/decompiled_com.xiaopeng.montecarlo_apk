package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GUserDeviceResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackUserDevice;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackUserDeviceImpl;
@IntfAuto(target = ICallBackUserDevice.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackUserDeviceRouter extends ICallBackUserDeviceImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackUserDeviceRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackUserDeviceRouter.class);
    private TypeHelper mHelper;
    private ICallBackUserDevice mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackUserDevice iCallBackUserDevice) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackUserDeviceImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackUserDevice;
    }

    protected CallBackUserDeviceRouter(String str, ICallBackUserDevice iCallBackUserDevice, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackUserDevice);
    }

    protected CallBackUserDeviceRouter(String str, ICallBackUserDevice iCallBackUserDevice) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackUserDevice);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackUserDeviceImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackUserDeviceImpl
    public void onRecvAck(GUserDeviceResponseParam gUserDeviceResponseParam) {
        ICallBackUserDevice iCallBackUserDevice = this.mObserver;
        if (iCallBackUserDevice != null) {
            iCallBackUserDevice.onRecvAck(gUserDeviceResponseParam);
        }
    }
}
