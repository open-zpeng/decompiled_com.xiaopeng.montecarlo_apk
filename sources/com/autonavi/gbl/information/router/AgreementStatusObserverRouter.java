package com.autonavi.gbl.information.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.information.trade.model.AgreementStatusResult;
import com.autonavi.gbl.information.trade.observer.IAgreementStatusObserver;
import com.autonavi.gbl.information.trade.observer.impl.IAgreementStatusObserverImpl;
@IntfAuto(target = IAgreementStatusObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class AgreementStatusObserverRouter extends IAgreementStatusObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(AgreementStatusObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(AgreementStatusObserverRouter.class);
    private TypeHelper mHelper;
    private IAgreementStatusObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IAgreementStatusObserver iAgreementStatusObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IAgreementStatusObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iAgreementStatusObserver;
    }

    protected AgreementStatusObserverRouter(String str, IAgreementStatusObserver iAgreementStatusObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iAgreementStatusObserver);
    }

    protected AgreementStatusObserverRouter(String str, IAgreementStatusObserver iAgreementStatusObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iAgreementStatusObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.information.trade.observer.impl.IAgreementStatusObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.information.trade.observer.impl.IAgreementStatusObserverImpl
    public void onResult(AgreementStatusResult agreementStatusResult) {
        IAgreementStatusObserver iAgreementStatusObserver = this.mObserver;
        if (iAgreementStatusObserver != null) {
            iAgreementStatusObserver.onResult(agreementStatusResult);
        }
    }
}
