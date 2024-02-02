package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GAddressPredictResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackAddressPredict;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackAddressPredictImpl;
@IntfAuto(target = ICallBackAddressPredict.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackAddressPredictRouter extends ICallBackAddressPredictImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackAddressPredictRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackAddressPredictRouter.class);
    private TypeHelper mHelper;
    private ICallBackAddressPredict mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackAddressPredict iCallBackAddressPredict) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackAddressPredictImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackAddressPredict;
    }

    protected CallBackAddressPredictRouter(String str, ICallBackAddressPredict iCallBackAddressPredict, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackAddressPredict);
    }

    protected CallBackAddressPredictRouter(String str, ICallBackAddressPredict iCallBackAddressPredict) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackAddressPredict);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackAddressPredictRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackAddressPredictImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackAddressPredictRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackAddressPredictImpl
    public void onRecvAck(GAddressPredictResponseParam gAddressPredictResponseParam) {
        ICallBackAddressPredict iCallBackAddressPredict = this.mObserver;
        if (iCallBackAddressPredict != null) {
            iCallBackAddressPredict.onRecvAck(gAddressPredictResponseParam);
        }
    }
}
