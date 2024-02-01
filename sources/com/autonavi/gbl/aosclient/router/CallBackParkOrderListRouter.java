package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GParkOrderListResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackParkOrderList;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackParkOrderListImpl;
@IntfAuto(target = ICallBackParkOrderList.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackParkOrderListRouter extends ICallBackParkOrderListImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackParkOrderListRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackParkOrderListRouter.class);
    private TypeHelper mHelper;
    private ICallBackParkOrderList mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackParkOrderList iCallBackParkOrderList) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackParkOrderListImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackParkOrderList;
    }

    protected CallBackParkOrderListRouter(String str, ICallBackParkOrderList iCallBackParkOrderList, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackParkOrderList);
    }

    protected CallBackParkOrderListRouter(String str, ICallBackParkOrderList iCallBackParkOrderList) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackParkOrderList);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackParkOrderListImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackParkOrderListImpl
    public void onRecvAck(GParkOrderListResponseParam gParkOrderListResponseParam) {
        ICallBackParkOrderList iCallBackParkOrderList = this.mObserver;
        if (iCallBackParkOrderList != null) {
            iCallBackParkOrderList.onRecvAck(gParkOrderListResponseParam);
        }
    }
}
