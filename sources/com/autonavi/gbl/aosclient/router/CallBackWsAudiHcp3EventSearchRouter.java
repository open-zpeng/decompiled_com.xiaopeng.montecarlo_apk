package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsAudiHcp3EventSearchResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsAudiHcp3EventSearch;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAudiHcp3EventSearchImpl;
@IntfAuto(target = ICallBackWsAudiHcp3EventSearch.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsAudiHcp3EventSearchRouter extends ICallBackWsAudiHcp3EventSearchImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsAudiHcp3EventSearchRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsAudiHcp3EventSearchRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsAudiHcp3EventSearch mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsAudiHcp3EventSearch iCallBackWsAudiHcp3EventSearch) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsAudiHcp3EventSearchImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsAudiHcp3EventSearch;
    }

    protected CallBackWsAudiHcp3EventSearchRouter(String str, ICallBackWsAudiHcp3EventSearch iCallBackWsAudiHcp3EventSearch, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsAudiHcp3EventSearch);
    }

    protected CallBackWsAudiHcp3EventSearchRouter(String str, ICallBackWsAudiHcp3EventSearch iCallBackWsAudiHcp3EventSearch) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsAudiHcp3EventSearch);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsAudiHcp3EventSearchRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAudiHcp3EventSearchImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsAudiHcp3EventSearchRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAudiHcp3EventSearchImpl
    public void onRecvAck(GWsAudiHcp3EventSearchResponseParam gWsAudiHcp3EventSearchResponseParam) {
        ICallBackWsAudiHcp3EventSearch iCallBackWsAudiHcp3EventSearch = this.mObserver;
        if (iCallBackWsAudiHcp3EventSearch != null) {
            iCallBackWsAudiHcp3EventSearch.onRecvAck(gWsAudiHcp3EventSearchResponseParam);
        }
    }
}
