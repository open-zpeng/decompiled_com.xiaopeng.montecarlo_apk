package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsDynamicInfoEventPraiseStampStatusQueryResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsDynamicInfoEventPraiseStampStatusQuery;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsDynamicInfoEventPraiseStampStatusQueryImpl;
@IntfAuto(target = ICallBackWsDynamicInfoEventPraiseStampStatusQuery.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsDynamicInfoEventPraiseStampStatusQueryRouter extends ICallBackWsDynamicInfoEventPraiseStampStatusQueryImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsDynamicInfoEventPraiseStampStatusQueryRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsDynamicInfoEventPraiseStampStatusQueryRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsDynamicInfoEventPraiseStampStatusQuery mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsDynamicInfoEventPraiseStampStatusQuery iCallBackWsDynamicInfoEventPraiseStampStatusQuery) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsDynamicInfoEventPraiseStampStatusQueryImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsDynamicInfoEventPraiseStampStatusQuery;
    }

    protected CallBackWsDynamicInfoEventPraiseStampStatusQueryRouter(String str, ICallBackWsDynamicInfoEventPraiseStampStatusQuery iCallBackWsDynamicInfoEventPraiseStampStatusQuery, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsDynamicInfoEventPraiseStampStatusQuery);
    }

    protected CallBackWsDynamicInfoEventPraiseStampStatusQueryRouter(String str, ICallBackWsDynamicInfoEventPraiseStampStatusQuery iCallBackWsDynamicInfoEventPraiseStampStatusQuery) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsDynamicInfoEventPraiseStampStatusQuery);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsDynamicInfoEventPraiseStampStatusQueryImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsDynamicInfoEventPraiseStampStatusQueryImpl
    public void onRecvAck(GWsDynamicInfoEventPraiseStampStatusQueryResponseParam gWsDynamicInfoEventPraiseStampStatusQueryResponseParam) {
        ICallBackWsDynamicInfoEventPraiseStampStatusQuery iCallBackWsDynamicInfoEventPraiseStampStatusQuery = this.mObserver;
        if (iCallBackWsDynamicInfoEventPraiseStampStatusQuery != null) {
            iCallBackWsDynamicInfoEventPraiseStampStatusQuery.onRecvAck(gWsDynamicInfoEventPraiseStampStatusQueryResponseParam);
        }
    }
}
