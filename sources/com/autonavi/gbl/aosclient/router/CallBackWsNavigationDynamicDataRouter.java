package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsNavigationDynamicDataResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsNavigationDynamicData;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsNavigationDynamicDataImpl;
@IntfAuto(target = ICallBackWsNavigationDynamicData.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsNavigationDynamicDataRouter extends ICallBackWsNavigationDynamicDataImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsNavigationDynamicDataRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsNavigationDynamicDataRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsNavigationDynamicData mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsNavigationDynamicData iCallBackWsNavigationDynamicData) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsNavigationDynamicDataImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsNavigationDynamicData;
    }

    protected CallBackWsNavigationDynamicDataRouter(String str, ICallBackWsNavigationDynamicData iCallBackWsNavigationDynamicData, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsNavigationDynamicData);
    }

    protected CallBackWsNavigationDynamicDataRouter(String str, ICallBackWsNavigationDynamicData iCallBackWsNavigationDynamicData) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsNavigationDynamicData);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsNavigationDynamicDataRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsNavigationDynamicDataImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsNavigationDynamicDataRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsNavigationDynamicDataImpl
    public void onRecvAck(GWsNavigationDynamicDataResponseParam gWsNavigationDynamicDataResponseParam) {
        ICallBackWsNavigationDynamicData iCallBackWsNavigationDynamicData = this.mObserver;
        if (iCallBackWsNavigationDynamicData != null) {
            iCallBackWsNavigationDynamicData.onRecvAck(gWsNavigationDynamicDataResponseParam);
        }
    }
}
