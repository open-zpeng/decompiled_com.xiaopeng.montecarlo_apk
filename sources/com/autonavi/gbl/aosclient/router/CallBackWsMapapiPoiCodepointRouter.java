package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsMapapiPoiCodepointResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsMapapiPoiCodepoint;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiPoiCodepointImpl;
@IntfAuto(target = ICallBackWsMapapiPoiCodepoint.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsMapapiPoiCodepointRouter extends ICallBackWsMapapiPoiCodepointImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsMapapiPoiCodepointRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsMapapiPoiCodepointRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsMapapiPoiCodepoint mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsMapapiPoiCodepoint iCallBackWsMapapiPoiCodepoint) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsMapapiPoiCodepointImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsMapapiPoiCodepoint;
    }

    protected CallBackWsMapapiPoiCodepointRouter(String str, ICallBackWsMapapiPoiCodepoint iCallBackWsMapapiPoiCodepoint, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsMapapiPoiCodepoint);
    }

    protected CallBackWsMapapiPoiCodepointRouter(String str, ICallBackWsMapapiPoiCodepoint iCallBackWsMapapiPoiCodepoint) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsMapapiPoiCodepoint);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsMapapiPoiCodepointRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiPoiCodepointImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsMapapiPoiCodepointRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiPoiCodepointImpl
    public void onRecvAck(GWsMapapiPoiCodepointResponseParam gWsMapapiPoiCodepointResponseParam) {
        ICallBackWsMapapiPoiCodepoint iCallBackWsMapapiPoiCodepoint = this.mObserver;
        if (iCallBackWsMapapiPoiCodepoint != null) {
            iCallBackWsMapapiPoiCodepoint.onRecvAck(gWsMapapiPoiCodepointResponseParam);
        }
    }
}
