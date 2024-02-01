package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWorkdayListResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWorkdayList;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWorkdayListImpl;
@IntfAuto(target = ICallBackWorkdayList.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWorkdayListRouter extends ICallBackWorkdayListImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWorkdayListRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWorkdayListRouter.class);
    private TypeHelper mHelper;
    private ICallBackWorkdayList mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWorkdayList iCallBackWorkdayList) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWorkdayListImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWorkdayList;
    }

    protected CallBackWorkdayListRouter(String str, ICallBackWorkdayList iCallBackWorkdayList, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWorkdayList);
    }

    protected CallBackWorkdayListRouter(String str, ICallBackWorkdayList iCallBackWorkdayList) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWorkdayList);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWorkdayListImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWorkdayListImpl
    public void onRecvAck(GWorkdayListResponseParam gWorkdayListResponseParam) {
        ICallBackWorkdayList iCallBackWorkdayList = this.mObserver;
        if (iCallBackWorkdayList != null) {
            iCallBackWorkdayList.onRecvAck(gWorkdayListResponseParam);
        }
    }
}
