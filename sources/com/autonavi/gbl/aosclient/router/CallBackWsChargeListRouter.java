package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsChargeListResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsChargeList;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsChargeListImpl;
@IntfAuto(target = ICallBackWsChargeList.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsChargeListRouter extends ICallBackWsChargeListImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsChargeListRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsChargeListRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsChargeList mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsChargeList iCallBackWsChargeList) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsChargeListImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsChargeList;
    }

    protected CallBackWsChargeListRouter(String str, ICallBackWsChargeList iCallBackWsChargeList, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsChargeList);
    }

    protected CallBackWsChargeListRouter(String str, ICallBackWsChargeList iCallBackWsChargeList) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsChargeList);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsChargeListImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsChargeListImpl
    public void onRecvAck(GWsChargeListResponseParam gWsChargeListResponseParam) {
        ICallBackWsChargeList iCallBackWsChargeList = this.mObserver;
        if (iCallBackWsChargeList != null) {
            iCallBackWsChargeList.onRecvAck(gWsChargeListResponseParam);
        }
    }
}
