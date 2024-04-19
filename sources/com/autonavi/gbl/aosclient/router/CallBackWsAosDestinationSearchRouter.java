package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsAosDestinationSearchResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsAosDestinationSearch;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAosDestinationSearchImpl;
@IntfAuto(target = ICallBackWsAosDestinationSearch.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsAosDestinationSearchRouter extends ICallBackWsAosDestinationSearchImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsAosDestinationSearchRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsAosDestinationSearchRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsAosDestinationSearch mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsAosDestinationSearch iCallBackWsAosDestinationSearch) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsAosDestinationSearchImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsAosDestinationSearch;
    }

    protected CallBackWsAosDestinationSearchRouter(String str, ICallBackWsAosDestinationSearch iCallBackWsAosDestinationSearch, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsAosDestinationSearch);
    }

    protected CallBackWsAosDestinationSearchRouter(String str, ICallBackWsAosDestinationSearch iCallBackWsAosDestinationSearch) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsAosDestinationSearch);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsAosDestinationSearchRouter.1
        });
        objArr[1] = String.valueOf(this.mHelper != null);
        DebugTool.d("%s: mHelper=%s", objArr);
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAosDestinationSearchImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsAosDestinationSearchRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAosDestinationSearchImpl
    public void onRecvAck(GWsAosDestinationSearchResponseParam gWsAosDestinationSearchResponseParam) {
        ICallBackWsAosDestinationSearch iCallBackWsAosDestinationSearch = this.mObserver;
        if (iCallBackWsAosDestinationSearch != null) {
            iCallBackWsAosDestinationSearch.onRecvAck(gWsAosDestinationSearchResponseParam);
        }
    }
}
