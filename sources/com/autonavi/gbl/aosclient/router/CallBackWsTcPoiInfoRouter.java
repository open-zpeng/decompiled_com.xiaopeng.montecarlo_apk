package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTcPoiInfoResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcPoiInfo;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcPoiInfoImpl;
@IntfAuto(target = ICallBackWsTcPoiInfo.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTcPoiInfoRouter extends ICallBackWsTcPoiInfoImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTcPoiInfoRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTcPoiInfoRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTcPoiInfo mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTcPoiInfo iCallBackWsTcPoiInfo) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTcPoiInfoImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTcPoiInfo;
    }

    protected CallBackWsTcPoiInfoRouter(String str, ICallBackWsTcPoiInfo iCallBackWsTcPoiInfo, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTcPoiInfo);
    }

    protected CallBackWsTcPoiInfoRouter(String str, ICallBackWsTcPoiInfo iCallBackWsTcPoiInfo) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTcPoiInfo);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcPoiInfoImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTcPoiInfoImpl
    public void onRecvAck(GWsTcPoiInfoResponseParam gWsTcPoiInfoResponseParam) {
        ICallBackWsTcPoiInfo iCallBackWsTcPoiInfo = this.mObserver;
        if (iCallBackWsTcPoiInfo != null) {
            iCallBackWsTcPoiInfo.onRecvAck(gWsTcPoiInfoResponseParam);
        }
    }
}
