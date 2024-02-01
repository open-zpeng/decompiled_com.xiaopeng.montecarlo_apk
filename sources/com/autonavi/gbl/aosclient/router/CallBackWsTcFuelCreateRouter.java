package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTcFuelCreateResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcFuelCreate;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcFuelCreateImpl;
@IntfAuto(target = ICallBackWsTcFuelCreate.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTcFuelCreateRouter extends ICallBackWsTcFuelCreateImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTcFuelCreateRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTcFuelCreateRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTcFuelCreate mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTcFuelCreate iCallBackWsTcFuelCreate) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTcFuelCreateImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTcFuelCreate;
    }

    protected CallBackWsTcFuelCreateRouter(String str, ICallBackWsTcFuelCreate iCallBackWsTcFuelCreate, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTcFuelCreate);
    }

    protected CallBackWsTcFuelCreateRouter(String str, ICallBackWsTcFuelCreate iCallBackWsTcFuelCreate) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTcFuelCreate);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcFuelCreateImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcFuelCreateImpl
    public void onRecvAck(GWsTcFuelCreateResponseParam gWsTcFuelCreateResponseParam) {
        ICallBackWsTcFuelCreate iCallBackWsTcFuelCreate = this.mObserver;
        if (iCallBackWsTcFuelCreate != null) {
            iCallBackWsTcFuelCreate.onRecvAck(gWsTcFuelCreateResponseParam);
        }
    }
}
