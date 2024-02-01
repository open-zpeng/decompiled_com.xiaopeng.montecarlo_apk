package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTcCommonAgreementSignResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcCommonAgreementSign;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcCommonAgreementSignImpl;
@IntfAuto(target = ICallBackWsTcCommonAgreementSign.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTcCommonAgreementSignRouter extends ICallBackWsTcCommonAgreementSignImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTcCommonAgreementSignRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTcCommonAgreementSignRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTcCommonAgreementSign mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTcCommonAgreementSign iCallBackWsTcCommonAgreementSign) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTcCommonAgreementSignImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTcCommonAgreementSign;
    }

    protected CallBackWsTcCommonAgreementSignRouter(String str, ICallBackWsTcCommonAgreementSign iCallBackWsTcCommonAgreementSign, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTcCommonAgreementSign);
    }

    protected CallBackWsTcCommonAgreementSignRouter(String str, ICallBackWsTcCommonAgreementSign iCallBackWsTcCommonAgreementSign) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTcCommonAgreementSign);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcCommonAgreementSignImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcCommonAgreementSignImpl
    public void onRecvAck(GWsTcCommonAgreementSignResponseParam gWsTcCommonAgreementSignResponseParam) {
        ICallBackWsTcCommonAgreementSign iCallBackWsTcCommonAgreementSign = this.mObserver;
        if (iCallBackWsTcCommonAgreementSign != null) {
            iCallBackWsTcCommonAgreementSign.onRecvAck(gWsTcCommonAgreementSignResponseParam);
        }
    }
}
