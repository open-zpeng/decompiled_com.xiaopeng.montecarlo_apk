package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsFencingFencesQueryResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsFencingFencesQuery;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsFencingFencesQueryImpl;
@IntfAuto(target = ICallBackWsFencingFencesQuery.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsFencingFencesQueryRouter extends ICallBackWsFencingFencesQueryImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsFencingFencesQueryRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsFencingFencesQueryRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsFencingFencesQuery mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsFencingFencesQuery iCallBackWsFencingFencesQuery) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsFencingFencesQueryImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsFencingFencesQuery;
    }

    protected CallBackWsFencingFencesQueryRouter(String str, ICallBackWsFencingFencesQuery iCallBackWsFencingFencesQuery, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsFencingFencesQuery);
    }

    protected CallBackWsFencingFencesQueryRouter(String str, ICallBackWsFencingFencesQuery iCallBackWsFencingFencesQuery) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsFencingFencesQuery);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsFencingFencesQueryImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsFencingFencesQueryImpl
    public void onRecvAck(GWsFencingFencesQueryResponseParam gWsFencingFencesQueryResponseParam) {
        ICallBackWsFencingFencesQuery iCallBackWsFencingFencesQuery = this.mObserver;
        if (iCallBackWsFencingFencesQuery != null) {
            iCallBackWsFencingFencesQuery.onRecvAck(gWsFencingFencesQueryResponseParam);
        }
    }
}
