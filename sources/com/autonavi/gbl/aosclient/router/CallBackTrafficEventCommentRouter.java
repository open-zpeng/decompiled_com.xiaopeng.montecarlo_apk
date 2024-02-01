package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GTrafficEventCommentResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackTrafficEventComment;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackTrafficEventCommentImpl;
@IntfAuto(target = ICallBackTrafficEventComment.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackTrafficEventCommentRouter extends ICallBackTrafficEventCommentImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackTrafficEventCommentRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackTrafficEventCommentRouter.class);
    private TypeHelper mHelper;
    private ICallBackTrafficEventComment mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackTrafficEventComment iCallBackTrafficEventComment) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackTrafficEventCommentImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackTrafficEventComment;
    }

    protected CallBackTrafficEventCommentRouter(String str, ICallBackTrafficEventComment iCallBackTrafficEventComment, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackTrafficEventComment);
    }

    protected CallBackTrafficEventCommentRouter(String str, ICallBackTrafficEventComment iCallBackTrafficEventComment) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackTrafficEventComment);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackTrafficEventCommentImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackTrafficEventCommentImpl
    public void onRecvAck(GTrafficEventCommentResponseParam gTrafficEventCommentResponseParam) {
        ICallBackTrafficEventComment iCallBackTrafficEventComment = this.mObserver;
        if (iCallBackTrafficEventComment != null) {
            iCallBackTrafficEventComment.onRecvAck(gTrafficEventCommentResponseParam);
        }
    }
}
