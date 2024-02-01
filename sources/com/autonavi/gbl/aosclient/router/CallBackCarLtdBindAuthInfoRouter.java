package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GCarLtdBindAuthInfoResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackCarLtdBindAuthInfo;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackCarLtdBindAuthInfoImpl;
@IntfAuto(target = ICallBackCarLtdBindAuthInfo.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackCarLtdBindAuthInfoRouter extends ICallBackCarLtdBindAuthInfoImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackCarLtdBindAuthInfoRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackCarLtdBindAuthInfoRouter.class);
    private TypeHelper mHelper;
    private ICallBackCarLtdBindAuthInfo mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackCarLtdBindAuthInfo iCallBackCarLtdBindAuthInfo) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackCarLtdBindAuthInfoImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackCarLtdBindAuthInfo;
    }

    protected CallBackCarLtdBindAuthInfoRouter(String str, ICallBackCarLtdBindAuthInfo iCallBackCarLtdBindAuthInfo, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackCarLtdBindAuthInfo);
    }

    protected CallBackCarLtdBindAuthInfoRouter(String str, ICallBackCarLtdBindAuthInfo iCallBackCarLtdBindAuthInfo) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackCarLtdBindAuthInfo);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackCarLtdBindAuthInfoImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackCarLtdBindAuthInfoImpl
    public void onRecvAck(GCarLtdBindAuthInfoResponseParam gCarLtdBindAuthInfoResponseParam) {
        ICallBackCarLtdBindAuthInfo iCallBackCarLtdBindAuthInfo = this.mObserver;
        if (iCallBackCarLtdBindAuthInfo != null) {
            iCallBackCarLtdBindAuthInfo.onRecvAck(gCarLtdBindAuthInfoResponseParam);
        }
    }
}
