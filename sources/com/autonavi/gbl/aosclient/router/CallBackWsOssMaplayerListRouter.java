package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsOssMaplayerListResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsOssMaplayerList;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsOssMaplayerListImpl;
@IntfAuto(target = ICallBackWsOssMaplayerList.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsOssMaplayerListRouter extends ICallBackWsOssMaplayerListImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsOssMaplayerListRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsOssMaplayerListRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsOssMaplayerList mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsOssMaplayerList iCallBackWsOssMaplayerList) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsOssMaplayerListImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsOssMaplayerList;
    }

    protected CallBackWsOssMaplayerListRouter(String str, ICallBackWsOssMaplayerList iCallBackWsOssMaplayerList, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsOssMaplayerList);
    }

    protected CallBackWsOssMaplayerListRouter(String str, ICallBackWsOssMaplayerList iCallBackWsOssMaplayerList) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsOssMaplayerList);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsOssMaplayerListRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsOssMaplayerListImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsOssMaplayerListRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsOssMaplayerListImpl
    public void onRecvAck(GWsOssMaplayerListResponseParam gWsOssMaplayerListResponseParam) {
        ICallBackWsOssMaplayerList iCallBackWsOssMaplayerList = this.mObserver;
        if (iCallBackWsOssMaplayerList != null) {
            iCallBackWsOssMaplayerList.onRecvAck(gWsOssMaplayerListResponseParam);
        }
    }
}
