package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsUserviewFootprintSummaryResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsUserviewFootprintSummary;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsUserviewFootprintSummaryImpl;
@IntfAuto(target = ICallBackWsUserviewFootprintSummary.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsUserviewFootprintSummaryRouter extends ICallBackWsUserviewFootprintSummaryImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsUserviewFootprintSummaryRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsUserviewFootprintSummaryRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsUserviewFootprintSummary mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsUserviewFootprintSummary iCallBackWsUserviewFootprintSummary) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsUserviewFootprintSummaryImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsUserviewFootprintSummary;
    }

    protected CallBackWsUserviewFootprintSummaryRouter(String str, ICallBackWsUserviewFootprintSummary iCallBackWsUserviewFootprintSummary, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsUserviewFootprintSummary);
    }

    protected CallBackWsUserviewFootprintSummaryRouter(String str, ICallBackWsUserviewFootprintSummary iCallBackWsUserviewFootprintSummary) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsUserviewFootprintSummary);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsUserviewFootprintSummaryImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsUserviewFootprintSummaryImpl
    public void onRecvAck(GWsUserviewFootprintSummaryResponseParam gWsUserviewFootprintSummaryResponseParam) {
        ICallBackWsUserviewFootprintSummary iCallBackWsUserviewFootprintSummary = this.mObserver;
        if (iCallBackWsUserviewFootprintSummary != null) {
            iCallBackWsUserviewFootprintSummary.onRecvAck(gWsUserviewFootprintSummaryResponseParam);
        }
    }
}
