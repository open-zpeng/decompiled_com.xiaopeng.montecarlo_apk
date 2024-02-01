package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsFencingGroupsQueryResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsFencingGroupsQuery;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsFencingGroupsQueryImpl;
@IntfAuto(target = ICallBackWsFencingGroupsQuery.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsFencingGroupsQueryRouter extends ICallBackWsFencingGroupsQueryImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsFencingGroupsQueryRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsFencingGroupsQueryRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsFencingGroupsQuery mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsFencingGroupsQuery iCallBackWsFencingGroupsQuery) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsFencingGroupsQueryImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsFencingGroupsQuery;
    }

    protected CallBackWsFencingGroupsQueryRouter(String str, ICallBackWsFencingGroupsQuery iCallBackWsFencingGroupsQuery, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsFencingGroupsQuery);
    }

    protected CallBackWsFencingGroupsQueryRouter(String str, ICallBackWsFencingGroupsQuery iCallBackWsFencingGroupsQuery) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsFencingGroupsQuery);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsFencingGroupsQueryImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsFencingGroupsQueryImpl
    public void onRecvAck(GWsFencingGroupsQueryResponseParam gWsFencingGroupsQueryResponseParam) {
        ICallBackWsFencingGroupsQuery iCallBackWsFencingGroupsQuery = this.mObserver;
        if (iCallBackWsFencingGroupsQuery != null) {
            iCallBackWsFencingGroupsQuery.onRecvAck(gWsFencingGroupsQueryResponseParam);
        }
    }
}
