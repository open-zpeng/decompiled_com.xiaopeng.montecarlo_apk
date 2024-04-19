package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsMapapiConfOfflineResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsMapapiConfOffline;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiConfOfflineImpl;
@IntfAuto(target = ICallBackWsMapapiConfOffline.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsMapapiConfOfflineRouter extends ICallBackWsMapapiConfOfflineImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsMapapiConfOfflineRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsMapapiConfOfflineRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsMapapiConfOffline mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsMapapiConfOffline iCallBackWsMapapiConfOffline) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsMapapiConfOfflineImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsMapapiConfOffline;
    }

    protected CallBackWsMapapiConfOfflineRouter(String str, ICallBackWsMapapiConfOffline iCallBackWsMapapiConfOffline, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsMapapiConfOffline);
    }

    protected CallBackWsMapapiConfOfflineRouter(String str, ICallBackWsMapapiConfOffline iCallBackWsMapapiConfOffline) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsMapapiConfOffline);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsMapapiConfOfflineRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiConfOfflineImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsMapapiConfOfflineRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiConfOfflineImpl
    public void onRecvAck(GWsMapapiConfOfflineResponseParam gWsMapapiConfOfflineResponseParam) {
        ICallBackWsMapapiConfOffline iCallBackWsMapapiConfOffline = this.mObserver;
        if (iCallBackWsMapapiConfOffline != null) {
            iCallBackWsMapapiConfOffline.onRecvAck(gWsMapapiConfOfflineResponseParam);
        }
    }
}
