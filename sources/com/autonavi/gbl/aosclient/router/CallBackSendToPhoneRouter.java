package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GSendToPhoneResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackSendToPhone;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackSendToPhoneImpl;
@IntfAuto(target = ICallBackSendToPhone.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackSendToPhoneRouter extends ICallBackSendToPhoneImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackSendToPhoneRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackSendToPhoneRouter.class);
    private TypeHelper mHelper;
    private ICallBackSendToPhone mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackSendToPhone iCallBackSendToPhone) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackSendToPhoneImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackSendToPhone;
    }

    protected CallBackSendToPhoneRouter(String str, ICallBackSendToPhone iCallBackSendToPhone, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackSendToPhone);
    }

    protected CallBackSendToPhoneRouter(String str, ICallBackSendToPhone iCallBackSendToPhone) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackSendToPhone);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackSendToPhoneRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackSendToPhoneImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackSendToPhoneRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackSendToPhoneImpl
    public void onRecvAck(GSendToPhoneResponseParam gSendToPhoneResponseParam) {
        ICallBackSendToPhone iCallBackSendToPhone = this.mObserver;
        if (iCallBackSendToPhone != null) {
            iCallBackSendToPhone.onRecvAck(gSendToPhoneResponseParam);
        }
    }
}
