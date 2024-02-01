package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsDynamicInfoCongestionGroupChatUserAddV3ResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsDynamicInfoCongestionGroupChatUserAddV3;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl;
@IntfAuto(target = ICallBackWsDynamicInfoCongestionGroupChatUserAddV3.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsDynamicInfoCongestionGroupChatUserAddV3Router extends ICallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsDynamicInfoCongestionGroupChatUserAddV3Router.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsDynamicInfoCongestionGroupChatUserAddV3Router.class);
    private TypeHelper mHelper;
    private ICallBackWsDynamicInfoCongestionGroupChatUserAddV3 mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsDynamicInfoCongestionGroupChatUserAddV3 iCallBackWsDynamicInfoCongestionGroupChatUserAddV3) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsDynamicInfoCongestionGroupChatUserAddV3;
    }

    protected CallBackWsDynamicInfoCongestionGroupChatUserAddV3Router(String str, ICallBackWsDynamicInfoCongestionGroupChatUserAddV3 iCallBackWsDynamicInfoCongestionGroupChatUserAddV3, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsDynamicInfoCongestionGroupChatUserAddV3);
    }

    protected CallBackWsDynamicInfoCongestionGroupChatUserAddV3Router(String str, ICallBackWsDynamicInfoCongestionGroupChatUserAddV3 iCallBackWsDynamicInfoCongestionGroupChatUserAddV3) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsDynamicInfoCongestionGroupChatUserAddV3);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl
    public void onRecvAck(GWsDynamicInfoCongestionGroupChatUserAddV3ResponseParam gWsDynamicInfoCongestionGroupChatUserAddV3ResponseParam) {
        ICallBackWsDynamicInfoCongestionGroupChatUserAddV3 iCallBackWsDynamicInfoCongestionGroupChatUserAddV3 = this.mObserver;
        if (iCallBackWsDynamicInfoCongestionGroupChatUserAddV3 != null) {
            iCallBackWsDynamicInfoCongestionGroupChatUserAddV3.onRecvAck(gWsDynamicInfoCongestionGroupChatUserAddV3ResponseParam);
        }
    }
}
