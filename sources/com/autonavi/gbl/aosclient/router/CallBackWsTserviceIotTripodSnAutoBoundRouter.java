package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTserviceIotTripodSnAutoBoundResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceIotTripodSnAutoBound;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceIotTripodSnAutoBoundImpl;
@IntfAuto(target = ICallBackWsTserviceIotTripodSnAutoBound.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTserviceIotTripodSnAutoBoundRouter extends ICallBackWsTserviceIotTripodSnAutoBoundImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTserviceIotTripodSnAutoBoundRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTserviceIotTripodSnAutoBoundRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTserviceIotTripodSnAutoBound mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTserviceIotTripodSnAutoBound iCallBackWsTserviceIotTripodSnAutoBound) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTserviceIotTripodSnAutoBoundImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTserviceIotTripodSnAutoBound;
    }

    protected CallBackWsTserviceIotTripodSnAutoBoundRouter(String str, ICallBackWsTserviceIotTripodSnAutoBound iCallBackWsTserviceIotTripodSnAutoBound, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceIotTripodSnAutoBound);
    }

    protected CallBackWsTserviceIotTripodSnAutoBoundRouter(String str, ICallBackWsTserviceIotTripodSnAutoBound iCallBackWsTserviceIotTripodSnAutoBound) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceIotTripodSnAutoBound);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceIotTripodSnAutoBoundImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceIotTripodSnAutoBoundImpl
    public void onRecvAck(GWsTserviceIotTripodSnAutoBoundResponseParam gWsTserviceIotTripodSnAutoBoundResponseParam) {
        ICallBackWsTserviceIotTripodSnAutoBound iCallBackWsTserviceIotTripodSnAutoBound = this.mObserver;
        if (iCallBackWsTserviceIotTripodSnAutoBound != null) {
            iCallBackWsTserviceIotTripodSnAutoBound.onRecvAck(gWsTserviceIotTripodSnAutoBoundResponseParam);
        }
    }
}
