package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsPpAutoWeixinStatusResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpAutoWeixinStatus;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpAutoWeixinStatusImpl;
@IntfAuto(target = ICallBackWsPpAutoWeixinStatus.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsPpAutoWeixinStatusRouter extends ICallBackWsPpAutoWeixinStatusImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsPpAutoWeixinStatusRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsPpAutoWeixinStatusRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsPpAutoWeixinStatus mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsPpAutoWeixinStatus iCallBackWsPpAutoWeixinStatus) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsPpAutoWeixinStatusImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsPpAutoWeixinStatus;
    }

    protected CallBackWsPpAutoWeixinStatusRouter(String str, ICallBackWsPpAutoWeixinStatus iCallBackWsPpAutoWeixinStatus, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsPpAutoWeixinStatus);
    }

    protected CallBackWsPpAutoWeixinStatusRouter(String str, ICallBackWsPpAutoWeixinStatus iCallBackWsPpAutoWeixinStatus) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsPpAutoWeixinStatus);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpAutoWeixinStatusImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpAutoWeixinStatusImpl
    public void onRecvAck(GWsPpAutoWeixinStatusResponseParam gWsPpAutoWeixinStatusResponseParam) {
        ICallBackWsPpAutoWeixinStatus iCallBackWsPpAutoWeixinStatus = this.mObserver;
        if (iCallBackWsPpAutoWeixinStatus != null) {
            iCallBackWsPpAutoWeixinStatus.onRecvAck(gWsPpAutoWeixinStatusResponseParam);
        }
    }
}
