package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsPpAccountDeactivateHelpResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpAccountDeactivateHelp;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpAccountDeactivateHelpImpl;
@IntfAuto(target = ICallBackWsPpAccountDeactivateHelp.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsPpAccountDeactivateHelpRouter extends ICallBackWsPpAccountDeactivateHelpImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsPpAccountDeactivateHelpRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsPpAccountDeactivateHelpRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsPpAccountDeactivateHelp mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsPpAccountDeactivateHelp iCallBackWsPpAccountDeactivateHelp) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsPpAccountDeactivateHelpImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsPpAccountDeactivateHelp;
    }

    protected CallBackWsPpAccountDeactivateHelpRouter(String str, ICallBackWsPpAccountDeactivateHelp iCallBackWsPpAccountDeactivateHelp, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsPpAccountDeactivateHelp);
    }

    protected CallBackWsPpAccountDeactivateHelpRouter(String str, ICallBackWsPpAccountDeactivateHelp iCallBackWsPpAccountDeactivateHelp) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsPpAccountDeactivateHelp);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsPpAccountDeactivateHelpRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpAccountDeactivateHelpImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsPpAccountDeactivateHelpRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpAccountDeactivateHelpImpl
    public void onRecvAck(GWsPpAccountDeactivateHelpResponseParam gWsPpAccountDeactivateHelpResponseParam) {
        ICallBackWsPpAccountDeactivateHelp iCallBackWsPpAccountDeactivateHelp = this.mObserver;
        if (iCallBackWsPpAccountDeactivateHelp != null) {
            iCallBackWsPpAccountDeactivateHelp.onRecvAck(gWsPpAccountDeactivateHelpResponseParam);
        }
    }
}
