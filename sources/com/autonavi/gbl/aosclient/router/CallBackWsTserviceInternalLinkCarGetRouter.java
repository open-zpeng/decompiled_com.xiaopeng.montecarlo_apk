package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTserviceInternalLinkCarGetResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceInternalLinkCarGet;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceInternalLinkCarGetImpl;
@IntfAuto(target = ICallBackWsTserviceInternalLinkCarGet.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTserviceInternalLinkCarGetRouter extends ICallBackWsTserviceInternalLinkCarGetImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTserviceInternalLinkCarGetRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTserviceInternalLinkCarGetRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTserviceInternalLinkCarGet mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTserviceInternalLinkCarGet iCallBackWsTserviceInternalLinkCarGet) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTserviceInternalLinkCarGetImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTserviceInternalLinkCarGet;
    }

    protected CallBackWsTserviceInternalLinkCarGetRouter(String str, ICallBackWsTserviceInternalLinkCarGet iCallBackWsTserviceInternalLinkCarGet, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceInternalLinkCarGet);
    }

    protected CallBackWsTserviceInternalLinkCarGetRouter(String str, ICallBackWsTserviceInternalLinkCarGet iCallBackWsTserviceInternalLinkCarGet) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceInternalLinkCarGet);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsTserviceInternalLinkCarGetRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceInternalLinkCarGetImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsTserviceInternalLinkCarGetRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceInternalLinkCarGetImpl
    public void onRecvAck(GWsTserviceInternalLinkCarGetResponseParam gWsTserviceInternalLinkCarGetResponseParam) {
        ICallBackWsTserviceInternalLinkCarGet iCallBackWsTserviceInternalLinkCarGet = this.mObserver;
        if (iCallBackWsTserviceInternalLinkCarGet != null) {
            iCallBackWsTserviceInternalLinkCarGet.onRecvAck(gWsTserviceInternalLinkCarGetResponseParam);
        }
    }
}
