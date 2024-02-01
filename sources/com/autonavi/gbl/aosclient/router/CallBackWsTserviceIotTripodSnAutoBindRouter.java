package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTserviceIotTripodSnAutoBindResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceIotTripodSnAutoBind;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceIotTripodSnAutoBindImpl;
@IntfAuto(target = ICallBackWsTserviceIotTripodSnAutoBind.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTserviceIotTripodSnAutoBindRouter extends ICallBackWsTserviceIotTripodSnAutoBindImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTserviceIotTripodSnAutoBindRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTserviceIotTripodSnAutoBindRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTserviceIotTripodSnAutoBind mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTserviceIotTripodSnAutoBind iCallBackWsTserviceIotTripodSnAutoBind) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTserviceIotTripodSnAutoBindImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTserviceIotTripodSnAutoBind;
    }

    protected CallBackWsTserviceIotTripodSnAutoBindRouter(String str, ICallBackWsTserviceIotTripodSnAutoBind iCallBackWsTserviceIotTripodSnAutoBind, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceIotTripodSnAutoBind);
    }

    protected CallBackWsTserviceIotTripodSnAutoBindRouter(String str, ICallBackWsTserviceIotTripodSnAutoBind iCallBackWsTserviceIotTripodSnAutoBind) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceIotTripodSnAutoBind);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceIotTripodSnAutoBindImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceIotTripodSnAutoBindImpl
    public void onRecvAck(GWsTserviceIotTripodSnAutoBindResponseParam gWsTserviceIotTripodSnAutoBindResponseParam) {
        ICallBackWsTserviceIotTripodSnAutoBind iCallBackWsTserviceIotTripodSnAutoBind = this.mObserver;
        if (iCallBackWsTserviceIotTripodSnAutoBind != null) {
            iCallBackWsTserviceIotTripodSnAutoBind.onRecvAck(gWsTserviceIotTripodSnAutoBindResponseParam);
        }
    }
}
