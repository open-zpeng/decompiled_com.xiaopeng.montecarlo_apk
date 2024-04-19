package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsNavigationDynamicFatigueResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsNavigationDynamicFatigue;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsNavigationDynamicFatigueImpl;
@IntfAuto(target = ICallBackWsNavigationDynamicFatigue.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsNavigationDynamicFatigueRouter extends ICallBackWsNavigationDynamicFatigueImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsNavigationDynamicFatigueRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsNavigationDynamicFatigueRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsNavigationDynamicFatigue mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsNavigationDynamicFatigue iCallBackWsNavigationDynamicFatigue) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsNavigationDynamicFatigueImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsNavigationDynamicFatigue;
    }

    protected CallBackWsNavigationDynamicFatigueRouter(String str, ICallBackWsNavigationDynamicFatigue iCallBackWsNavigationDynamicFatigue, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsNavigationDynamicFatigue);
    }

    protected CallBackWsNavigationDynamicFatigueRouter(String str, ICallBackWsNavigationDynamicFatigue iCallBackWsNavigationDynamicFatigue) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsNavigationDynamicFatigue);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsNavigationDynamicFatigueRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsNavigationDynamicFatigueImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsNavigationDynamicFatigueRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsNavigationDynamicFatigueImpl
    public void onRecvAck(GWsNavigationDynamicFatigueResponseParam gWsNavigationDynamicFatigueResponseParam) {
        ICallBackWsNavigationDynamicFatigue iCallBackWsNavigationDynamicFatigue = this.mObserver;
        if (iCallBackWsNavigationDynamicFatigue != null) {
            iCallBackWsNavigationDynamicFatigue.onRecvAck(gWsNavigationDynamicFatigueResponseParam);
        }
    }
}
