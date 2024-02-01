package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTserviceIotTripodEventResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceIotTripodEvent;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceIotTripodEventImpl;
@IntfAuto(target = ICallBackWsTserviceIotTripodEvent.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTserviceIotTripodEventRouter extends ICallBackWsTserviceIotTripodEventImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTserviceIotTripodEventRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTserviceIotTripodEventRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTserviceIotTripodEvent mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTserviceIotTripodEvent iCallBackWsTserviceIotTripodEvent) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTserviceIotTripodEventImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTserviceIotTripodEvent;
    }

    protected CallBackWsTserviceIotTripodEventRouter(String str, ICallBackWsTserviceIotTripodEvent iCallBackWsTserviceIotTripodEvent, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceIotTripodEvent);
    }

    protected CallBackWsTserviceIotTripodEventRouter(String str, ICallBackWsTserviceIotTripodEvent iCallBackWsTserviceIotTripodEvent) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceIotTripodEvent);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceIotTripodEventImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceIotTripodEventImpl
    public void onRecvAck(GWsTserviceIotTripodEventResponseParam gWsTserviceIotTripodEventResponseParam) {
        ICallBackWsTserviceIotTripodEvent iCallBackWsTserviceIotTripodEvent = this.mObserver;
        if (iCallBackWsTserviceIotTripodEvent != null) {
            iCallBackWsTserviceIotTripodEvent.onRecvAck(gWsTserviceIotTripodEventResponseParam);
        }
    }
}
