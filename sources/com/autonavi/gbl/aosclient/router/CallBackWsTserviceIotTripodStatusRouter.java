package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTserviceIotTripodStatusResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceIotTripodStatus;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceIotTripodStatusImpl;
@IntfAuto(target = ICallBackWsTserviceIotTripodStatus.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTserviceIotTripodStatusRouter extends ICallBackWsTserviceIotTripodStatusImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTserviceIotTripodStatusRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTserviceIotTripodStatusRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTserviceIotTripodStatus mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTserviceIotTripodStatus iCallBackWsTserviceIotTripodStatus) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTserviceIotTripodStatusImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTserviceIotTripodStatus;
    }

    protected CallBackWsTserviceIotTripodStatusRouter(String str, ICallBackWsTserviceIotTripodStatus iCallBackWsTserviceIotTripodStatus, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceIotTripodStatus);
    }

    protected CallBackWsTserviceIotTripodStatusRouter(String str, ICallBackWsTserviceIotTripodStatus iCallBackWsTserviceIotTripodStatus) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceIotTripodStatus);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsTserviceIotTripodStatusRouter.1
        });
        objArr[1] = String.valueOf(this.mHelper != null);
        DebugTool.d("%s: mHelper=%s", objArr);
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceIotTripodStatusImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsTserviceIotTripodStatusRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceIotTripodStatusImpl
    public void onRecvAck(GWsTserviceIotTripodStatusResponseParam gWsTserviceIotTripodStatusResponseParam) {
        ICallBackWsTserviceIotTripodStatus iCallBackWsTserviceIotTripodStatus = this.mObserver;
        if (iCallBackWsTserviceIotTripodStatus != null) {
            iCallBackWsTserviceIotTripodStatus.onRecvAck(gWsTserviceIotTripodStatusResponseParam);
        }
    }
}
