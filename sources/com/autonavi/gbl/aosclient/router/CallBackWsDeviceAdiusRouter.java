package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsDeviceAdiusResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsDeviceAdius;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsDeviceAdiusImpl;
@IntfAuto(target = ICallBackWsDeviceAdius.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsDeviceAdiusRouter extends ICallBackWsDeviceAdiusImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsDeviceAdiusRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsDeviceAdiusRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsDeviceAdius mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsDeviceAdius iCallBackWsDeviceAdius) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsDeviceAdiusImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsDeviceAdius;
    }

    protected CallBackWsDeviceAdiusRouter(String str, ICallBackWsDeviceAdius iCallBackWsDeviceAdius, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsDeviceAdius);
    }

    protected CallBackWsDeviceAdiusRouter(String str, ICallBackWsDeviceAdius iCallBackWsDeviceAdius) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsDeviceAdius);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsDeviceAdiusRouter.1
        });
        objArr[1] = String.valueOf(this.mHelper != null);
        DebugTool.d("%s: mHelper=%s", objArr);
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsDeviceAdiusImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsDeviceAdiusRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsDeviceAdiusImpl
    public void onRecvAck(GWsDeviceAdiusResponseParam gWsDeviceAdiusResponseParam) {
        ICallBackWsDeviceAdius iCallBackWsDeviceAdius = this.mObserver;
        if (iCallBackWsDeviceAdius != null) {
            iCallBackWsDeviceAdius.onRecvAck(gWsDeviceAdiusResponseParam);
        }
    }
}
