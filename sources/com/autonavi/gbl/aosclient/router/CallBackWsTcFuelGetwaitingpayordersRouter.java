package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTcFuelGetwaitingpayordersResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcFuelGetwaitingpayorders;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcFuelGetwaitingpayordersImpl;
@IntfAuto(target = ICallBackWsTcFuelGetwaitingpayorders.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTcFuelGetwaitingpayordersRouter extends ICallBackWsTcFuelGetwaitingpayordersImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTcFuelGetwaitingpayordersRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTcFuelGetwaitingpayordersRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTcFuelGetwaitingpayorders mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTcFuelGetwaitingpayorders iCallBackWsTcFuelGetwaitingpayorders) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTcFuelGetwaitingpayordersImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTcFuelGetwaitingpayorders;
    }

    protected CallBackWsTcFuelGetwaitingpayordersRouter(String str, ICallBackWsTcFuelGetwaitingpayorders iCallBackWsTcFuelGetwaitingpayorders, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTcFuelGetwaitingpayorders);
    }

    protected CallBackWsTcFuelGetwaitingpayordersRouter(String str, ICallBackWsTcFuelGetwaitingpayorders iCallBackWsTcFuelGetwaitingpayorders) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTcFuelGetwaitingpayorders);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcFuelGetwaitingpayordersImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcFuelGetwaitingpayordersImpl
    public void onRecvAck(GWsTcFuelGetwaitingpayordersResponseParam gWsTcFuelGetwaitingpayordersResponseParam) {
        ICallBackWsTcFuelGetwaitingpayorders iCallBackWsTcFuelGetwaitingpayorders = this.mObserver;
        if (iCallBackWsTcFuelGetwaitingpayorders != null) {
            iCallBackWsTcFuelGetwaitingpayorders.onRecvAck(gWsTcFuelGetwaitingpayordersResponseParam);
        }
    }
}
