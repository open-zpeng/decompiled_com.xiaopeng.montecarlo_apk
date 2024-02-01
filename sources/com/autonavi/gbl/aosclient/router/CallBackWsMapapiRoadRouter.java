package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsMapapiRoadResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsMapapiRoad;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiRoadImpl;
@IntfAuto(target = ICallBackWsMapapiRoad.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsMapapiRoadRouter extends ICallBackWsMapapiRoadImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsMapapiRoadRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsMapapiRoadRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsMapapiRoad mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsMapapiRoad iCallBackWsMapapiRoad) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsMapapiRoadImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsMapapiRoad;
    }

    protected CallBackWsMapapiRoadRouter(String str, ICallBackWsMapapiRoad iCallBackWsMapapiRoad, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsMapapiRoad);
    }

    protected CallBackWsMapapiRoadRouter(String str, ICallBackWsMapapiRoad iCallBackWsMapapiRoad) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsMapapiRoad);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiRoadImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsMapapiRoadImpl
    public void onRecvAck(GWsMapapiRoadResponseParam gWsMapapiRoadResponseParam) {
        ICallBackWsMapapiRoad iCallBackWsMapapiRoad = this.mObserver;
        if (iCallBackWsMapapiRoad != null) {
            iCallBackWsMapapiRoad.onRecvAck(gWsMapapiRoadResponseParam);
        }
    }
}
