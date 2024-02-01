package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GParkOrderCreateResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackParkOrderCreate;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackParkOrderCreateImpl;
@IntfAuto(target = ICallBackParkOrderCreate.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackParkOrderCreateRouter extends ICallBackParkOrderCreateImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackParkOrderCreateRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackParkOrderCreateRouter.class);
    private TypeHelper mHelper;
    private ICallBackParkOrderCreate mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackParkOrderCreate iCallBackParkOrderCreate) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackParkOrderCreateImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackParkOrderCreate;
    }

    protected CallBackParkOrderCreateRouter(String str, ICallBackParkOrderCreate iCallBackParkOrderCreate, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackParkOrderCreate);
    }

    protected CallBackParkOrderCreateRouter(String str, ICallBackParkOrderCreate iCallBackParkOrderCreate) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackParkOrderCreate);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackParkOrderCreateImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackParkOrderCreateImpl
    public void onRecvAck(GParkOrderCreateResponseParam gParkOrderCreateResponseParam) {
        ICallBackParkOrderCreate iCallBackParkOrderCreate = this.mObserver;
        if (iCallBackParkOrderCreate != null) {
            iCallBackParkOrderCreate.onRecvAck(gParkOrderCreateResponseParam);
        }
    }
}
