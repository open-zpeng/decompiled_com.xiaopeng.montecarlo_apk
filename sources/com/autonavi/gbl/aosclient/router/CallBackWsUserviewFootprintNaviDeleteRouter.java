package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsUserviewFootprintNaviDeleteResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsUserviewFootprintNaviDelete;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsUserviewFootprintNaviDeleteImpl;
@IntfAuto(target = ICallBackWsUserviewFootprintNaviDelete.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsUserviewFootprintNaviDeleteRouter extends ICallBackWsUserviewFootprintNaviDeleteImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsUserviewFootprintNaviDeleteRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsUserviewFootprintNaviDeleteRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsUserviewFootprintNaviDelete mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsUserviewFootprintNaviDelete iCallBackWsUserviewFootprintNaviDelete) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsUserviewFootprintNaviDeleteImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsUserviewFootprintNaviDelete;
    }

    protected CallBackWsUserviewFootprintNaviDeleteRouter(String str, ICallBackWsUserviewFootprintNaviDelete iCallBackWsUserviewFootprintNaviDelete, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsUserviewFootprintNaviDelete);
    }

    protected CallBackWsUserviewFootprintNaviDeleteRouter(String str, ICallBackWsUserviewFootprintNaviDelete iCallBackWsUserviewFootprintNaviDelete) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsUserviewFootprintNaviDelete);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsUserviewFootprintNaviDeleteImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsUserviewFootprintNaviDeleteImpl
    public void onRecvAck(GWsUserviewFootprintNaviDeleteResponseParam gWsUserviewFootprintNaviDeleteResponseParam) {
        ICallBackWsUserviewFootprintNaviDelete iCallBackWsUserviewFootprintNaviDelete = this.mObserver;
        if (iCallBackWsUserviewFootprintNaviDelete != null) {
            iCallBackWsUserviewFootprintNaviDelete.onRecvAck(gWsUserviewFootprintNaviDeleteResponseParam);
        }
    }
}
