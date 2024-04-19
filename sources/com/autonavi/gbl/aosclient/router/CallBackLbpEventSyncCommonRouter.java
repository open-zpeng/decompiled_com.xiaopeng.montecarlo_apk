package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GLbpEventSyncCommonResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackLbpEventSyncCommon;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackLbpEventSyncCommonImpl;
@IntfAuto(target = ICallBackLbpEventSyncCommon.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackLbpEventSyncCommonRouter extends ICallBackLbpEventSyncCommonImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackLbpEventSyncCommonRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackLbpEventSyncCommonRouter.class);
    private TypeHelper mHelper;
    private ICallBackLbpEventSyncCommon mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackLbpEventSyncCommon iCallBackLbpEventSyncCommon) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackLbpEventSyncCommonImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackLbpEventSyncCommon;
    }

    protected CallBackLbpEventSyncCommonRouter(String str, ICallBackLbpEventSyncCommon iCallBackLbpEventSyncCommon, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackLbpEventSyncCommon);
    }

    protected CallBackLbpEventSyncCommonRouter(String str, ICallBackLbpEventSyncCommon iCallBackLbpEventSyncCommon) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackLbpEventSyncCommon);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackLbpEventSyncCommonRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackLbpEventSyncCommonImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackLbpEventSyncCommonRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackLbpEventSyncCommonImpl
    public void onRecvAck(GLbpEventSyncCommonResponseParam gLbpEventSyncCommonResponseParam) {
        ICallBackLbpEventSyncCommon iCallBackLbpEventSyncCommon = this.mObserver;
        if (iCallBackLbpEventSyncCommon != null) {
            iCallBackLbpEventSyncCommon.onRecvAck(gLbpEventSyncCommonResponseParam);
        }
    }
}
