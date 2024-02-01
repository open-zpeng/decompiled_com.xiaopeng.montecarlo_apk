package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GQueryCarMsgResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackQueryCarMsg;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackQueryCarMsgImpl;
@IntfAuto(target = ICallBackQueryCarMsg.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackQueryCarMsgRouter extends ICallBackQueryCarMsgImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackQueryCarMsgRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackQueryCarMsgRouter.class);
    private TypeHelper mHelper;
    private ICallBackQueryCarMsg mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackQueryCarMsg iCallBackQueryCarMsg) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackQueryCarMsgImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackQueryCarMsg;
    }

    protected CallBackQueryCarMsgRouter(String str, ICallBackQueryCarMsg iCallBackQueryCarMsg, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackQueryCarMsg);
    }

    protected CallBackQueryCarMsgRouter(String str, ICallBackQueryCarMsg iCallBackQueryCarMsg) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackQueryCarMsg);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackQueryCarMsgImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackQueryCarMsgImpl
    public void onRecvAck(GQueryCarMsgResponseParam gQueryCarMsgResponseParam) {
        ICallBackQueryCarMsg iCallBackQueryCarMsg = this.mObserver;
        if (iCallBackQueryCarMsg != null) {
            iCallBackQueryCarMsg.onRecvAck(gQueryCarMsgResponseParam);
        }
    }
}
