package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsMapapiGeoCodeResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsMapapiGeoCode;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiGeoCodeImpl;
@IntfAuto(target = ICallBackWsMapapiGeoCode.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsMapapiGeoCodeRouter extends ICallBackWsMapapiGeoCodeImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsMapapiGeoCodeRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsMapapiGeoCodeRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsMapapiGeoCode mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsMapapiGeoCode iCallBackWsMapapiGeoCode) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsMapapiGeoCodeImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsMapapiGeoCode;
    }

    protected CallBackWsMapapiGeoCodeRouter(String str, ICallBackWsMapapiGeoCode iCallBackWsMapapiGeoCode, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsMapapiGeoCode);
    }

    protected CallBackWsMapapiGeoCodeRouter(String str, ICallBackWsMapapiGeoCode iCallBackWsMapapiGeoCode) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsMapapiGeoCode);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiGeoCodeImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiGeoCodeImpl
    public void onRecvAck(GWsMapapiGeoCodeResponseParam gWsMapapiGeoCodeResponseParam) {
        ICallBackWsMapapiGeoCode iCallBackWsMapapiGeoCode = this.mObserver;
        if (iCallBackWsMapapiGeoCode != null) {
            iCallBackWsMapapiGeoCode.onRecvAck(gWsMapapiGeoCodeResponseParam);
        }
    }
}
