package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GCouponrecvlistResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackCouponrecvlist;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackCouponrecvlistImpl;
@IntfAuto(target = ICallBackCouponrecvlist.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackCouponrecvlistRouter extends ICallBackCouponrecvlistImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackCouponrecvlistRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackCouponrecvlistRouter.class);
    private TypeHelper mHelper;
    private ICallBackCouponrecvlist mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackCouponrecvlist iCallBackCouponrecvlist) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackCouponrecvlistImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackCouponrecvlist;
    }

    protected CallBackCouponrecvlistRouter(String str, ICallBackCouponrecvlist iCallBackCouponrecvlist, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackCouponrecvlist);
    }

    protected CallBackCouponrecvlistRouter(String str, ICallBackCouponrecvlist iCallBackCouponrecvlist) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackCouponrecvlist);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackCouponrecvlistRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackCouponrecvlistImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackCouponrecvlistRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackCouponrecvlistImpl
    public void onRecvAck(GCouponrecvlistResponseParam gCouponrecvlistResponseParam) {
        ICallBackCouponrecvlist iCallBackCouponrecvlist = this.mObserver;
        if (iCallBackCouponrecvlist != null) {
            iCallBackCouponrecvlist.onRecvAck(gCouponrecvlistResponseParam);
        }
    }
}
