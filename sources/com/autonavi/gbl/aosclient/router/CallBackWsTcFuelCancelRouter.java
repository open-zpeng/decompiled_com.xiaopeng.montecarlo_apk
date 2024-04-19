package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTcFuelCancelResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcFuelCancel;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcFuelCancelImpl;
@IntfAuto(target = ICallBackWsTcFuelCancel.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTcFuelCancelRouter extends ICallBackWsTcFuelCancelImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTcFuelCancelRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTcFuelCancelRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTcFuelCancel mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTcFuelCancel iCallBackWsTcFuelCancel) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTcFuelCancelImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTcFuelCancel;
    }

    protected CallBackWsTcFuelCancelRouter(String str, ICallBackWsTcFuelCancel iCallBackWsTcFuelCancel, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTcFuelCancel);
    }

    protected CallBackWsTcFuelCancelRouter(String str, ICallBackWsTcFuelCancel iCallBackWsTcFuelCancel) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTcFuelCancel);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsTcFuelCancelRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcFuelCancelImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsTcFuelCancelRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcFuelCancelImpl
    public void onRecvAck(GWsTcFuelCancelResponseParam gWsTcFuelCancelResponseParam) {
        ICallBackWsTcFuelCancel iCallBackWsTcFuelCancel = this.mObserver;
        if (iCallBackWsTcFuelCancel != null) {
            iCallBackWsTcFuelCancel.onRecvAck(gWsTcFuelCancelResponseParam);
        }
    }
}
