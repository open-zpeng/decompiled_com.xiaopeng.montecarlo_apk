package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GTrafficEventDetailResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackTrafficEventDetail;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackTrafficEventDetailImpl;
@IntfAuto(target = ICallBackTrafficEventDetail.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackTrafficEventDetailRouter extends ICallBackTrafficEventDetailImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackTrafficEventDetailRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackTrafficEventDetailRouter.class);
    private TypeHelper mHelper;
    private ICallBackTrafficEventDetail mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackTrafficEventDetail iCallBackTrafficEventDetail) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackTrafficEventDetailImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackTrafficEventDetail;
    }

    protected CallBackTrafficEventDetailRouter(String str, ICallBackTrafficEventDetail iCallBackTrafficEventDetail, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackTrafficEventDetail);
    }

    protected CallBackTrafficEventDetailRouter(String str, ICallBackTrafficEventDetail iCallBackTrafficEventDetail) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackTrafficEventDetail);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackTrafficEventDetailImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackTrafficEventDetailImpl
    public void onRecvAck(GTrafficEventDetailResponseParam gTrafficEventDetailResponseParam) {
        ICallBackTrafficEventDetail iCallBackTrafficEventDetail = this.mObserver;
        if (iCallBackTrafficEventDetail != null) {
            iCallBackTrafficEventDetail.onRecvAck(gTrafficEventDetailResponseParam);
        }
    }
}
