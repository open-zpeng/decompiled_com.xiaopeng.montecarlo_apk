package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsFeedbackReviewGetResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsFeedbackReviewGet;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsFeedbackReviewGetImpl;
@IntfAuto(target = ICallBackWsFeedbackReviewGet.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsFeedbackReviewGetRouter extends ICallBackWsFeedbackReviewGetImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsFeedbackReviewGetRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsFeedbackReviewGetRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsFeedbackReviewGet mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsFeedbackReviewGet iCallBackWsFeedbackReviewGet) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsFeedbackReviewGetImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsFeedbackReviewGet;
    }

    protected CallBackWsFeedbackReviewGetRouter(String str, ICallBackWsFeedbackReviewGet iCallBackWsFeedbackReviewGet, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsFeedbackReviewGet);
    }

    protected CallBackWsFeedbackReviewGetRouter(String str, ICallBackWsFeedbackReviewGet iCallBackWsFeedbackReviewGet) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsFeedbackReviewGet);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsFeedbackReviewGetImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsFeedbackReviewGetImpl
    public void onRecvAck(GWsFeedbackReviewGetResponseParam gWsFeedbackReviewGetResponseParam) {
        ICallBackWsFeedbackReviewGet iCallBackWsFeedbackReviewGet = this.mObserver;
        if (iCallBackWsFeedbackReviewGet != null) {
            iCallBackWsFeedbackReviewGet.onRecvAck(gWsFeedbackReviewGetResponseParam);
        }
    }
}
