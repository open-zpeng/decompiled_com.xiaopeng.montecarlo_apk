package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsShieldImMsgCommentSetResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsShieldImMsgCommentSet;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsShieldImMsgCommentSetImpl;
@IntfAuto(target = ICallBackWsShieldImMsgCommentSet.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsShieldImMsgCommentSetRouter extends ICallBackWsShieldImMsgCommentSetImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsShieldImMsgCommentSetRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsShieldImMsgCommentSetRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsShieldImMsgCommentSet mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsShieldImMsgCommentSet iCallBackWsShieldImMsgCommentSet) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsShieldImMsgCommentSetImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsShieldImMsgCommentSet;
    }

    protected CallBackWsShieldImMsgCommentSetRouter(String str, ICallBackWsShieldImMsgCommentSet iCallBackWsShieldImMsgCommentSet, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsShieldImMsgCommentSet);
    }

    protected CallBackWsShieldImMsgCommentSetRouter(String str, ICallBackWsShieldImMsgCommentSet iCallBackWsShieldImMsgCommentSet) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsShieldImMsgCommentSet);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsShieldImMsgCommentSetImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsShieldImMsgCommentSetImpl
    public void onRecvAck(GWsShieldImMsgCommentSetResponseParam gWsShieldImMsgCommentSetResponseParam) {
        ICallBackWsShieldImMsgCommentSet iCallBackWsShieldImMsgCommentSet = this.mObserver;
        if (iCallBackWsShieldImMsgCommentSet != null) {
            iCallBackWsShieldImMsgCommentSet.onRecvAck(gWsShieldImMsgCommentSetResponseParam);
        }
    }
}
