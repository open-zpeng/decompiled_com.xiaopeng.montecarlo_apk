package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsMapapiPoiVoicesearchResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsMapapiPoiVoicesearch;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiPoiVoicesearchImpl;
@IntfAuto(target = ICallBackWsMapapiPoiVoicesearch.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsMapapiPoiVoicesearchRouter extends ICallBackWsMapapiPoiVoicesearchImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsMapapiPoiVoicesearchRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsMapapiPoiVoicesearchRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsMapapiPoiVoicesearch mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsMapapiPoiVoicesearch iCallBackWsMapapiPoiVoicesearch) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsMapapiPoiVoicesearchImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsMapapiPoiVoicesearch;
    }

    protected CallBackWsMapapiPoiVoicesearchRouter(String str, ICallBackWsMapapiPoiVoicesearch iCallBackWsMapapiPoiVoicesearch, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsMapapiPoiVoicesearch);
    }

    protected CallBackWsMapapiPoiVoicesearchRouter(String str, ICallBackWsMapapiPoiVoicesearch iCallBackWsMapapiPoiVoicesearch) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsMapapiPoiVoicesearch);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiPoiVoicesearchImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiPoiVoicesearchImpl
    public void onRecvAck(GWsMapapiPoiVoicesearchResponseParam gWsMapapiPoiVoicesearchResponseParam) {
        ICallBackWsMapapiPoiVoicesearch iCallBackWsMapapiPoiVoicesearch = this.mObserver;
        if (iCallBackWsMapapiPoiVoicesearch != null) {
            iCallBackWsMapapiPoiVoicesearch.onRecvAck(gWsMapapiPoiVoicesearchResponseParam);
        }
    }
}
