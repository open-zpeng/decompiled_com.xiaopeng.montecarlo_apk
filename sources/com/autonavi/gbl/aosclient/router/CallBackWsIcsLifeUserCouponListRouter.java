package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsIcsLifeUserCouponListResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsIcsLifeUserCouponList;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsIcsLifeUserCouponListImpl;
@IntfAuto(target = ICallBackWsIcsLifeUserCouponList.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsIcsLifeUserCouponListRouter extends ICallBackWsIcsLifeUserCouponListImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsIcsLifeUserCouponListRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsIcsLifeUserCouponListRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsIcsLifeUserCouponList mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsIcsLifeUserCouponList iCallBackWsIcsLifeUserCouponList) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsIcsLifeUserCouponListImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsIcsLifeUserCouponList;
    }

    protected CallBackWsIcsLifeUserCouponListRouter(String str, ICallBackWsIcsLifeUserCouponList iCallBackWsIcsLifeUserCouponList, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsIcsLifeUserCouponList);
    }

    protected CallBackWsIcsLifeUserCouponListRouter(String str, ICallBackWsIcsLifeUserCouponList iCallBackWsIcsLifeUserCouponList) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsIcsLifeUserCouponList);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsIcsLifeUserCouponListImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsIcsLifeUserCouponListImpl
    public void onRecvAck(GWsIcsLifeUserCouponListResponseParam gWsIcsLifeUserCouponListResponseParam) {
        ICallBackWsIcsLifeUserCouponList iCallBackWsIcsLifeUserCouponList = this.mObserver;
        if (iCallBackWsIcsLifeUserCouponList != null) {
            iCallBackWsIcsLifeUserCouponList.onRecvAck(gWsIcsLifeUserCouponListResponseParam);
        }
    }
}
