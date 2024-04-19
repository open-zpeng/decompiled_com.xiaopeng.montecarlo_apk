package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsHcp3ChargeListResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsHcp3ChargeList;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsHcp3ChargeListImpl;
@IntfAuto(target = ICallBackWsHcp3ChargeList.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsHcp3ChargeListRouter extends ICallBackWsHcp3ChargeListImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsHcp3ChargeListRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsHcp3ChargeListRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsHcp3ChargeList mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsHcp3ChargeList iCallBackWsHcp3ChargeList) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsHcp3ChargeListImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsHcp3ChargeList;
    }

    protected CallBackWsHcp3ChargeListRouter(String str, ICallBackWsHcp3ChargeList iCallBackWsHcp3ChargeList, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsHcp3ChargeList);
    }

    protected CallBackWsHcp3ChargeListRouter(String str, ICallBackWsHcp3ChargeList iCallBackWsHcp3ChargeList) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsHcp3ChargeList);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsHcp3ChargeListRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsHcp3ChargeListImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsHcp3ChargeListRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsHcp3ChargeListImpl
    public void onRecvAck(GWsHcp3ChargeListResponseParam gWsHcp3ChargeListResponseParam) {
        ICallBackWsHcp3ChargeList iCallBackWsHcp3ChargeList = this.mObserver;
        if (iCallBackWsHcp3ChargeList != null) {
            iCallBackWsHcp3ChargeList.onRecvAck(gWsHcp3ChargeListResponseParam);
        }
    }
}
