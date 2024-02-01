package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.BLResponseBase;
import com.autonavi.gbl.aosclient.observer.IBLAosCallBack;
import com.autonavi.gbl.aosclient.observer.impl.IBLAosCallBackImpl;
@IntfAuto(target = IBLAosCallBack.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class BLAosCallBackRouter extends IBLAosCallBackImpl {
    private static BindTable BIND_TABLE = new BindTable(BLAosCallBackRouter.class);
    private static String PACKAGE = ReflexTool.PN(BLAosCallBackRouter.class);
    private TypeHelper mHelper;
    private IBLAosCallBack mObserver;
    private String mTargetId;

    private void $constructor(String str, IBLAosCallBack iBLAosCallBack) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IBLAosCallBackImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iBLAosCallBack;
    }

    protected BLAosCallBackRouter(String str, IBLAosCallBack iBLAosCallBack, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iBLAosCallBack);
    }

    protected BLAosCallBackRouter(String str, IBLAosCallBack iBLAosCallBack) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iBLAosCallBack);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.IBLAosCallBackImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.IBLAosCallBackImpl
    public void onRecvResponse(BLResponseBase bLResponseBase) {
        IBLAosCallBack iBLAosCallBack = this.mObserver;
        if (iBLAosCallBack != null) {
            iBLAosCallBack.onRecvResponse(bLResponseBase);
        }
    }
}
