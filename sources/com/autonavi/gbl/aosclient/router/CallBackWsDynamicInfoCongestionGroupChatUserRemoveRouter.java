package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsDynamicInfoCongestionGroupChatUserRemoveResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsDynamicInfoCongestionGroupChatUserRemove;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl;
@IntfAuto(target = ICallBackWsDynamicInfoCongestionGroupChatUserRemove.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsDynamicInfoCongestionGroupChatUserRemoveRouter extends ICallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsDynamicInfoCongestionGroupChatUserRemoveRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsDynamicInfoCongestionGroupChatUserRemoveRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsDynamicInfoCongestionGroupChatUserRemove mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsDynamicInfoCongestionGroupChatUserRemove iCallBackWsDynamicInfoCongestionGroupChatUserRemove) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsDynamicInfoCongestionGroupChatUserRemove;
    }

    protected CallBackWsDynamicInfoCongestionGroupChatUserRemoveRouter(String str, ICallBackWsDynamicInfoCongestionGroupChatUserRemove iCallBackWsDynamicInfoCongestionGroupChatUserRemove, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsDynamicInfoCongestionGroupChatUserRemove);
    }

    protected CallBackWsDynamicInfoCongestionGroupChatUserRemoveRouter(String str, ICallBackWsDynamicInfoCongestionGroupChatUserRemove iCallBackWsDynamicInfoCongestionGroupChatUserRemove) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsDynamicInfoCongestionGroupChatUserRemove);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl
    public void onRecvAck(GWsDynamicInfoCongestionGroupChatUserRemoveResponseParam gWsDynamicInfoCongestionGroupChatUserRemoveResponseParam) {
        ICallBackWsDynamicInfoCongestionGroupChatUserRemove iCallBackWsDynamicInfoCongestionGroupChatUserRemove = this.mObserver;
        if (iCallBackWsDynamicInfoCongestionGroupChatUserRemove != null) {
            iCallBackWsDynamicInfoCongestionGroupChatUserRemove.onRecvAck(gWsDynamicInfoCongestionGroupChatUserRemoveResponseParam);
        }
    }
}
