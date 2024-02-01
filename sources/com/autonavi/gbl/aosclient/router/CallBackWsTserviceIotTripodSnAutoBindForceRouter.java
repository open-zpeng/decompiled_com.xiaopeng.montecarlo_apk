package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTserviceIotTripodSnAutoBindForceResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceIotTripodSnAutoBindForce;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceIotTripodSnAutoBindForceImpl;
@IntfAuto(target = ICallBackWsTserviceIotTripodSnAutoBindForce.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTserviceIotTripodSnAutoBindForceRouter extends ICallBackWsTserviceIotTripodSnAutoBindForceImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTserviceIotTripodSnAutoBindForceRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTserviceIotTripodSnAutoBindForceRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTserviceIotTripodSnAutoBindForce mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTserviceIotTripodSnAutoBindForce iCallBackWsTserviceIotTripodSnAutoBindForce) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTserviceIotTripodSnAutoBindForceImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTserviceIotTripodSnAutoBindForce;
    }

    protected CallBackWsTserviceIotTripodSnAutoBindForceRouter(String str, ICallBackWsTserviceIotTripodSnAutoBindForce iCallBackWsTserviceIotTripodSnAutoBindForce, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceIotTripodSnAutoBindForce);
    }

    protected CallBackWsTserviceIotTripodSnAutoBindForceRouter(String str, ICallBackWsTserviceIotTripodSnAutoBindForce iCallBackWsTserviceIotTripodSnAutoBindForce) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceIotTripodSnAutoBindForce);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceIotTripodSnAutoBindForceImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceIotTripodSnAutoBindForceImpl
    public void onRecvAck(GWsTserviceIotTripodSnAutoBindForceResponseParam gWsTserviceIotTripodSnAutoBindForceResponseParam) {
        ICallBackWsTserviceIotTripodSnAutoBindForce iCallBackWsTserviceIotTripodSnAutoBindForce = this.mObserver;
        if (iCallBackWsTserviceIotTripodSnAutoBindForce != null) {
            iCallBackWsTserviceIotTripodSnAutoBindForce.onRecvAck(gWsTserviceIotTripodSnAutoBindForceResponseParam);
        }
    }
}
