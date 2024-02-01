package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsVaCarLogoSelectResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsVaCarLogoSelect;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsVaCarLogoSelectImpl;
@IntfAuto(target = ICallBackWsVaCarLogoSelect.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsVaCarLogoSelectRouter extends ICallBackWsVaCarLogoSelectImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsVaCarLogoSelectRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsVaCarLogoSelectRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsVaCarLogoSelect mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsVaCarLogoSelect iCallBackWsVaCarLogoSelect) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsVaCarLogoSelectImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsVaCarLogoSelect;
    }

    protected CallBackWsVaCarLogoSelectRouter(String str, ICallBackWsVaCarLogoSelect iCallBackWsVaCarLogoSelect, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsVaCarLogoSelect);
    }

    protected CallBackWsVaCarLogoSelectRouter(String str, ICallBackWsVaCarLogoSelect iCallBackWsVaCarLogoSelect) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsVaCarLogoSelect);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsVaCarLogoSelectImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsVaCarLogoSelectImpl
    public void onRecvAck(GWsVaCarLogoSelectResponseParam gWsVaCarLogoSelectResponseParam) {
        ICallBackWsVaCarLogoSelect iCallBackWsVaCarLogoSelect = this.mObserver;
        if (iCallBackWsVaCarLogoSelect != null) {
            iCallBackWsVaCarLogoSelect.onRecvAck(gWsVaCarLogoSelectResponseParam);
        }
    }
}
