package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsEventSearchResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsEventSearch;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsEventSearchImpl;
@IntfAuto(target = ICallBackWsEventSearch.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsEventSearchRouter extends ICallBackWsEventSearchImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsEventSearchRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsEventSearchRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsEventSearch mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsEventSearch iCallBackWsEventSearch) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsEventSearchImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsEventSearch;
    }

    protected CallBackWsEventSearchRouter(String str, ICallBackWsEventSearch iCallBackWsEventSearch, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsEventSearch);
    }

    protected CallBackWsEventSearchRouter(String str, ICallBackWsEventSearch iCallBackWsEventSearch) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsEventSearch);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsEventSearchImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsEventSearchImpl
    public void onRecvAck(GWsEventSearchResponseParam gWsEventSearchResponseParam) {
        ICallBackWsEventSearch iCallBackWsEventSearch = this.mObserver;
        if (iCallBackWsEventSearch != null) {
            iCallBackWsEventSearch.onRecvAck(gWsEventSearchResponseParam);
        }
    }
}
