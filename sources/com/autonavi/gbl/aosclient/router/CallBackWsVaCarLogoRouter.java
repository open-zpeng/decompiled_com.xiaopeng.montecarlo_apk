package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsVaCarLogoResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsVaCarLogo;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsVaCarLogoImpl;
@IntfAuto(target = ICallBackWsVaCarLogo.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsVaCarLogoRouter extends ICallBackWsVaCarLogoImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsVaCarLogoRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsVaCarLogoRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsVaCarLogo mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsVaCarLogo iCallBackWsVaCarLogo) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsVaCarLogoImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsVaCarLogo;
    }

    protected CallBackWsVaCarLogoRouter(String str, ICallBackWsVaCarLogo iCallBackWsVaCarLogo, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsVaCarLogo);
    }

    protected CallBackWsVaCarLogoRouter(String str, ICallBackWsVaCarLogo iCallBackWsVaCarLogo) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsVaCarLogo);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsVaCarLogoRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsVaCarLogoImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsVaCarLogoRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsVaCarLogoImpl
    public void onRecvAck(GWsVaCarLogoResponseParam gWsVaCarLogoResponseParam) {
        ICallBackWsVaCarLogo iCallBackWsVaCarLogo = this.mObserver;
        if (iCallBackWsVaCarLogo != null) {
            iCallBackWsVaCarLogo.onRecvAck(gWsVaCarLogoResponseParam);
        }
    }
}
