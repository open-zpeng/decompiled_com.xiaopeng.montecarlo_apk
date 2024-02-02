package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsVaCarLogoExchangeResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsVaCarLogoExchange;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsVaCarLogoExchangeImpl;
@IntfAuto(target = ICallBackWsVaCarLogoExchange.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsVaCarLogoExchangeRouter extends ICallBackWsVaCarLogoExchangeImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsVaCarLogoExchangeRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsVaCarLogoExchangeRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsVaCarLogoExchange mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsVaCarLogoExchange iCallBackWsVaCarLogoExchange) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsVaCarLogoExchangeImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsVaCarLogoExchange;
    }

    protected CallBackWsVaCarLogoExchangeRouter(String str, ICallBackWsVaCarLogoExchange iCallBackWsVaCarLogoExchange, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsVaCarLogoExchange);
    }

    protected CallBackWsVaCarLogoExchangeRouter(String str, ICallBackWsVaCarLogoExchange iCallBackWsVaCarLogoExchange) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsVaCarLogoExchange);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsVaCarLogoExchangeRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsVaCarLogoExchangeImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsVaCarLogoExchangeRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsVaCarLogoExchangeImpl
    public void onRecvAck(GWsVaCarLogoExchangeResponseParam gWsVaCarLogoExchangeResponseParam) {
        ICallBackWsVaCarLogoExchange iCallBackWsVaCarLogoExchange = this.mObserver;
        if (iCallBackWsVaCarLogoExchange != null) {
            iCallBackWsVaCarLogoExchange.onRecvAck(gWsVaCarLogoExchangeResponseParam);
        }
    }
}
