package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsNtg6SdsFilesResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsNtg6SdsFiles;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsNtg6SdsFilesImpl;
@IntfAuto(target = ICallBackWsNtg6SdsFiles.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsNtg6SdsFilesRouter extends ICallBackWsNtg6SdsFilesImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsNtg6SdsFilesRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsNtg6SdsFilesRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsNtg6SdsFiles mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsNtg6SdsFiles iCallBackWsNtg6SdsFiles) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsNtg6SdsFilesImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsNtg6SdsFiles;
    }

    protected CallBackWsNtg6SdsFilesRouter(String str, ICallBackWsNtg6SdsFiles iCallBackWsNtg6SdsFiles, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsNtg6SdsFiles);
    }

    protected CallBackWsNtg6SdsFilesRouter(String str, ICallBackWsNtg6SdsFiles iCallBackWsNtg6SdsFiles) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsNtg6SdsFiles);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsNtg6SdsFilesRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsNtg6SdsFilesImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsNtg6SdsFilesRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsNtg6SdsFilesImpl
    public void onRecvAck(GWsNtg6SdsFilesResponseParam gWsNtg6SdsFilesResponseParam) {
        ICallBackWsNtg6SdsFiles iCallBackWsNtg6SdsFiles = this.mObserver;
        if (iCallBackWsNtg6SdsFiles != null) {
            iCallBackWsNtg6SdsFiles.onRecvAck(gWsNtg6SdsFilesResponseParam);
        }
    }
}
