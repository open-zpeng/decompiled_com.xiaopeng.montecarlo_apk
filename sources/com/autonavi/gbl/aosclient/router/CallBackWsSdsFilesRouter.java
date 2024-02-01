package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsSdsFilesResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsSdsFiles;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsSdsFilesImpl;
@IntfAuto(target = ICallBackWsSdsFiles.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsSdsFilesRouter extends ICallBackWsSdsFilesImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsSdsFilesRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsSdsFilesRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsSdsFiles mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsSdsFiles iCallBackWsSdsFiles) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsSdsFilesImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsSdsFiles;
    }

    protected CallBackWsSdsFilesRouter(String str, ICallBackWsSdsFiles iCallBackWsSdsFiles, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsSdsFiles);
    }

    protected CallBackWsSdsFilesRouter(String str, ICallBackWsSdsFiles iCallBackWsSdsFiles) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsSdsFiles);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsSdsFilesImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsSdsFilesImpl
    public void onRecvAck(GWsSdsFilesResponseParam gWsSdsFilesResponseParam) {
        ICallBackWsSdsFiles iCallBackWsSdsFiles = this.mObserver;
        if (iCallBackWsSdsFiles != null) {
            iCallBackWsSdsFiles.onRecvAck(gWsSdsFilesResponseParam);
        }
    }
}
