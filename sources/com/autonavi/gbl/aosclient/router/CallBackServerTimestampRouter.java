package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GServerTimestampResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackServerTimestamp;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackServerTimestampImpl;
@IntfAuto(target = ICallBackServerTimestamp.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackServerTimestampRouter extends ICallBackServerTimestampImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackServerTimestampRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackServerTimestampRouter.class);
    private TypeHelper mHelper;
    private ICallBackServerTimestamp mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackServerTimestamp iCallBackServerTimestamp) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackServerTimestampImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackServerTimestamp;
    }

    protected CallBackServerTimestampRouter(String str, ICallBackServerTimestamp iCallBackServerTimestamp, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackServerTimestamp);
    }

    protected CallBackServerTimestampRouter(String str, ICallBackServerTimestamp iCallBackServerTimestamp) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackServerTimestamp);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackServerTimestampImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackServerTimestampImpl
    public void onRecvAck(GServerTimestampResponseParam gServerTimestampResponseParam) {
        ICallBackServerTimestamp iCallBackServerTimestamp = this.mObserver;
        if (iCallBackServerTimestamp != null) {
            iCallBackServerTimestamp.onRecvAck(gServerTimestampResponseParam);
        }
    }
}
