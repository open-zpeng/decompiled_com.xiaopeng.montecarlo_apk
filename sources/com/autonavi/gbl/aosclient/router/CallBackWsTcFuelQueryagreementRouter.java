package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTcFuelQueryagreementResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcFuelQueryagreement;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcFuelQueryagreementImpl;
@IntfAuto(target = ICallBackWsTcFuelQueryagreement.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTcFuelQueryagreementRouter extends ICallBackWsTcFuelQueryagreementImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTcFuelQueryagreementRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTcFuelQueryagreementRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTcFuelQueryagreement mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTcFuelQueryagreement iCallBackWsTcFuelQueryagreement) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTcFuelQueryagreementImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTcFuelQueryagreement;
    }

    protected CallBackWsTcFuelQueryagreementRouter(String str, ICallBackWsTcFuelQueryagreement iCallBackWsTcFuelQueryagreement, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTcFuelQueryagreement);
    }

    protected CallBackWsTcFuelQueryagreementRouter(String str, ICallBackWsTcFuelQueryagreement iCallBackWsTcFuelQueryagreement) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTcFuelQueryagreement);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcFuelQueryagreementImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcFuelQueryagreementImpl
    public void onRecvAck(GWsTcFuelQueryagreementResponseParam gWsTcFuelQueryagreementResponseParam) {
        ICallBackWsTcFuelQueryagreement iCallBackWsTcFuelQueryagreement = this.mObserver;
        if (iCallBackWsTcFuelQueryagreement != null) {
            iCallBackWsTcFuelQueryagreement.onRecvAck(gWsTcFuelQueryagreementResponseParam);
        }
    }
}
