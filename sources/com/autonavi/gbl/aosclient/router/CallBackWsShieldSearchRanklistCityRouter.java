package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsShieldSearchRanklistCityResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsShieldSearchRanklistCity;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsShieldSearchRanklistCityImpl;
@IntfAuto(target = ICallBackWsShieldSearchRanklistCity.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsShieldSearchRanklistCityRouter extends ICallBackWsShieldSearchRanklistCityImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsShieldSearchRanklistCityRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsShieldSearchRanklistCityRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsShieldSearchRanklistCity mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsShieldSearchRanklistCity iCallBackWsShieldSearchRanklistCity) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsShieldSearchRanklistCityImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsShieldSearchRanklistCity;
    }

    protected CallBackWsShieldSearchRanklistCityRouter(String str, ICallBackWsShieldSearchRanklistCity iCallBackWsShieldSearchRanklistCity, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsShieldSearchRanklistCity);
    }

    protected CallBackWsShieldSearchRanklistCityRouter(String str, ICallBackWsShieldSearchRanklistCity iCallBackWsShieldSearchRanklistCity) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsShieldSearchRanklistCity);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsShieldSearchRanklistCityRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsShieldSearchRanklistCityImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsShieldSearchRanklistCityRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsShieldSearchRanklistCityImpl
    public void onRecvAck(GWsShieldSearchRanklistCityResponseParam gWsShieldSearchRanklistCityResponseParam) {
        ICallBackWsShieldSearchRanklistCity iCallBackWsShieldSearchRanklistCity = this.mObserver;
        if (iCallBackWsShieldSearchRanklistCity != null) {
            iCallBackWsShieldSearchRanklistCity.onRecvAck(gWsShieldSearchRanklistCityResponseParam);
        }
    }
}
