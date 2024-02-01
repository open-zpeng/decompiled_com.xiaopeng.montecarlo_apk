package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsUserviewFootprintSwitchResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsUserviewFootprintSwitch;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsUserviewFootprintSwitchImpl;
@IntfAuto(target = ICallBackWsUserviewFootprintSwitch.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsUserviewFootprintSwitchRouter extends ICallBackWsUserviewFootprintSwitchImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsUserviewFootprintSwitchRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsUserviewFootprintSwitchRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsUserviewFootprintSwitch mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsUserviewFootprintSwitch iCallBackWsUserviewFootprintSwitch) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsUserviewFootprintSwitchImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsUserviewFootprintSwitch;
    }

    protected CallBackWsUserviewFootprintSwitchRouter(String str, ICallBackWsUserviewFootprintSwitch iCallBackWsUserviewFootprintSwitch, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsUserviewFootprintSwitch);
    }

    protected CallBackWsUserviewFootprintSwitchRouter(String str, ICallBackWsUserviewFootprintSwitch iCallBackWsUserviewFootprintSwitch) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsUserviewFootprintSwitch);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsUserviewFootprintSwitchImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsUserviewFootprintSwitchImpl
    public void onRecvAck(GWsUserviewFootprintSwitchResponseParam gWsUserviewFootprintSwitchResponseParam) {
        ICallBackWsUserviewFootprintSwitch iCallBackWsUserviewFootprintSwitch = this.mObserver;
        if (iCallBackWsUserviewFootprintSwitch != null) {
            iCallBackWsUserviewFootprintSwitch.onRecvAck(gWsUserviewFootprintSwitchResponseParam);
        }
    }
}
