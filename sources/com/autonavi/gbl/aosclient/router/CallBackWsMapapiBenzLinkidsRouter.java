package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsMapapiBenzLinkidsResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsMapapiBenzLinkids;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiBenzLinkidsImpl;
@IntfAuto(target = ICallBackWsMapapiBenzLinkids.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsMapapiBenzLinkidsRouter extends ICallBackWsMapapiBenzLinkidsImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsMapapiBenzLinkidsRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsMapapiBenzLinkidsRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsMapapiBenzLinkids mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsMapapiBenzLinkids iCallBackWsMapapiBenzLinkids) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsMapapiBenzLinkidsImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsMapapiBenzLinkids;
    }

    protected CallBackWsMapapiBenzLinkidsRouter(String str, ICallBackWsMapapiBenzLinkids iCallBackWsMapapiBenzLinkids, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsMapapiBenzLinkids);
    }

    protected CallBackWsMapapiBenzLinkidsRouter(String str, ICallBackWsMapapiBenzLinkids iCallBackWsMapapiBenzLinkids) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsMapapiBenzLinkids);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsMapapiBenzLinkidsRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiBenzLinkidsImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsMapapiBenzLinkidsRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiBenzLinkidsImpl
    public void onRecvAck(GWsMapapiBenzLinkidsResponseParam gWsMapapiBenzLinkidsResponseParam) {
        ICallBackWsMapapiBenzLinkids iCallBackWsMapapiBenzLinkids = this.mObserver;
        if (iCallBackWsMapapiBenzLinkids != null) {
            iCallBackWsMapapiBenzLinkids.onRecvAck(gWsMapapiBenzLinkidsResponseParam);
        }
    }
}
