package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTcOrderApiMergeListResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcOrderApiMergeList;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcOrderApiMergeListImpl;
@IntfAuto(target = ICallBackWsTcOrderApiMergeList.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTcOrderApiMergeListRouter extends ICallBackWsTcOrderApiMergeListImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTcOrderApiMergeListRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTcOrderApiMergeListRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTcOrderApiMergeList mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTcOrderApiMergeList iCallBackWsTcOrderApiMergeList) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTcOrderApiMergeListImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTcOrderApiMergeList;
    }

    protected CallBackWsTcOrderApiMergeListRouter(String str, ICallBackWsTcOrderApiMergeList iCallBackWsTcOrderApiMergeList, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTcOrderApiMergeList);
    }

    protected CallBackWsTcOrderApiMergeListRouter(String str, ICallBackWsTcOrderApiMergeList iCallBackWsTcOrderApiMergeList) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTcOrderApiMergeList);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcOrderApiMergeListImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcOrderApiMergeListImpl
    public void onRecvAck(GWsTcOrderApiMergeListResponseParam gWsTcOrderApiMergeListResponseParam) {
        ICallBackWsTcOrderApiMergeList iCallBackWsTcOrderApiMergeList = this.mObserver;
        if (iCallBackWsTcOrderApiMergeList != null) {
            iCallBackWsTcOrderApiMergeList.onRecvAck(gWsTcOrderApiMergeListResponseParam);
        }
    }
}
