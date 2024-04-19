package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GTrafficRestrictResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackTrafficRestrict;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackTrafficRestrictImpl;
@IntfAuto(target = ICallBackTrafficRestrict.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackTrafficRestrictRouter extends ICallBackTrafficRestrictImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackTrafficRestrictRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackTrafficRestrictRouter.class);
    private TypeHelper mHelper;
    private ICallBackTrafficRestrict mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackTrafficRestrict iCallBackTrafficRestrict) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackTrafficRestrictImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackTrafficRestrict;
    }

    protected CallBackTrafficRestrictRouter(String str, ICallBackTrafficRestrict iCallBackTrafficRestrict, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackTrafficRestrict);
    }

    protected CallBackTrafficRestrictRouter(String str, ICallBackTrafficRestrict iCallBackTrafficRestrict) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackTrafficRestrict);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackTrafficRestrictRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackTrafficRestrictImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackTrafficRestrictRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackTrafficRestrictImpl
    public void onRecvAck(GTrafficRestrictResponseParam gTrafficRestrictResponseParam) {
        ICallBackTrafficRestrict iCallBackTrafficRestrict = this.mObserver;
        if (iCallBackTrafficRestrict != null) {
            iCallBackTrafficRestrict.onRecvAck(gTrafficRestrictResponseParam);
        }
    }
}
