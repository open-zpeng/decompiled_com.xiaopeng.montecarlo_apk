package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTcOrderListResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcOrderList;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcOrderListImpl;
@IntfAuto(target = ICallBackWsTcOrderList.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTcOrderListRouter extends ICallBackWsTcOrderListImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTcOrderListRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTcOrderListRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTcOrderList mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTcOrderList iCallBackWsTcOrderList) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTcOrderListImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTcOrderList;
    }

    protected CallBackWsTcOrderListRouter(String str, ICallBackWsTcOrderList iCallBackWsTcOrderList, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTcOrderList);
    }

    protected CallBackWsTcOrderListRouter(String str, ICallBackWsTcOrderList iCallBackWsTcOrderList) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTcOrderList);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsTcOrderListRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcOrderListImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsTcOrderListRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcOrderListImpl
    public void onRecvAck(GWsTcOrderListResponseParam gWsTcOrderListResponseParam) {
        ICallBackWsTcOrderList iCallBackWsTcOrderList = this.mObserver;
        if (iCallBackWsTcOrderList != null) {
            iCallBackWsTcOrderList.onRecvAck(gWsTcOrderListResponseParam);
        }
    }
}
