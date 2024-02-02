package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsAutoCollectResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsAutoCollect;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAutoCollectImpl;
@IntfAuto(target = ICallBackWsAutoCollect.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsAutoCollectRouter extends ICallBackWsAutoCollectImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsAutoCollectRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsAutoCollectRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsAutoCollect mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsAutoCollect iCallBackWsAutoCollect) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsAutoCollectImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsAutoCollect;
    }

    protected CallBackWsAutoCollectRouter(String str, ICallBackWsAutoCollect iCallBackWsAutoCollect, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsAutoCollect);
    }

    protected CallBackWsAutoCollectRouter(String str, ICallBackWsAutoCollect iCallBackWsAutoCollect) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsAutoCollect);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsAutoCollectRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAutoCollectImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsAutoCollectRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsAutoCollectImpl
    public void onRecvAck(GWsAutoCollectResponseParam gWsAutoCollectResponseParam) {
        ICallBackWsAutoCollect iCallBackWsAutoCollect = this.mObserver;
        if (iCallBackWsAutoCollect != null) {
            iCallBackWsAutoCollect.onRecvAck(gWsAutoCollectResponseParam);
        }
    }
}
