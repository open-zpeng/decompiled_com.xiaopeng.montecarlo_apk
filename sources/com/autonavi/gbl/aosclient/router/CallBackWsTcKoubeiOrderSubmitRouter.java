package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTcKoubeiOrderSubmitResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcKoubeiOrderSubmit;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcKoubeiOrderSubmitImpl;
@IntfAuto(target = ICallBackWsTcKoubeiOrderSubmit.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTcKoubeiOrderSubmitRouter extends ICallBackWsTcKoubeiOrderSubmitImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTcKoubeiOrderSubmitRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTcKoubeiOrderSubmitRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTcKoubeiOrderSubmit mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTcKoubeiOrderSubmit iCallBackWsTcKoubeiOrderSubmit) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTcKoubeiOrderSubmitImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTcKoubeiOrderSubmit;
    }

    protected CallBackWsTcKoubeiOrderSubmitRouter(String str, ICallBackWsTcKoubeiOrderSubmit iCallBackWsTcKoubeiOrderSubmit, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTcKoubeiOrderSubmit);
    }

    protected CallBackWsTcKoubeiOrderSubmitRouter(String str, ICallBackWsTcKoubeiOrderSubmit iCallBackWsTcKoubeiOrderSubmit) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTcKoubeiOrderSubmit);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcKoubeiOrderSubmitImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcKoubeiOrderSubmitImpl
    public void onRecvAck(GWsTcKoubeiOrderSubmitResponseParam gWsTcKoubeiOrderSubmitResponseParam) {
        ICallBackWsTcKoubeiOrderSubmit iCallBackWsTcKoubeiOrderSubmit = this.mObserver;
        if (iCallBackWsTcKoubeiOrderSubmit != null) {
            iCallBackWsTcKoubeiOrderSubmit.onRecvAck(gWsTcKoubeiOrderSubmitResponseParam);
        }
    }
}
