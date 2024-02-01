package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsMapapiAutoSwitchResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsMapapiAutoSwitch;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiAutoSwitchImpl;
@IntfAuto(target = ICallBackWsMapapiAutoSwitch.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsMapapiAutoSwitchRouter extends ICallBackWsMapapiAutoSwitchImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsMapapiAutoSwitchRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsMapapiAutoSwitchRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsMapapiAutoSwitch mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsMapapiAutoSwitch iCallBackWsMapapiAutoSwitch) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsMapapiAutoSwitchImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsMapapiAutoSwitch;
    }

    protected CallBackWsMapapiAutoSwitchRouter(String str, ICallBackWsMapapiAutoSwitch iCallBackWsMapapiAutoSwitch, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsMapapiAutoSwitch);
    }

    protected CallBackWsMapapiAutoSwitchRouter(String str, ICallBackWsMapapiAutoSwitch iCallBackWsMapapiAutoSwitch) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsMapapiAutoSwitch);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiAutoSwitchImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiAutoSwitchImpl
    public void onRecvAck(GWsMapapiAutoSwitchResponseParam gWsMapapiAutoSwitchResponseParam) {
        ICallBackWsMapapiAutoSwitch iCallBackWsMapapiAutoSwitch = this.mObserver;
        if (iCallBackWsMapapiAutoSwitch != null) {
            iCallBackWsMapapiAutoSwitch.onRecvAck(gWsMapapiAutoSwitchResponseParam);
        }
    }
}
