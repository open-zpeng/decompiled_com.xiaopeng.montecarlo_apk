package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsPpCarltdAuthCancelResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpCarltdAuthCancel;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpCarltdAuthCancelImpl;
@IntfAuto(target = ICallBackWsPpCarltdAuthCancel.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsPpCarltdAuthCancelRouter extends ICallBackWsPpCarltdAuthCancelImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsPpCarltdAuthCancelRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsPpCarltdAuthCancelRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsPpCarltdAuthCancel mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsPpCarltdAuthCancel iCallBackWsPpCarltdAuthCancel) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsPpCarltdAuthCancelImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsPpCarltdAuthCancel;
    }

    protected CallBackWsPpCarltdAuthCancelRouter(String str, ICallBackWsPpCarltdAuthCancel iCallBackWsPpCarltdAuthCancel, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsPpCarltdAuthCancel);
    }

    protected CallBackWsPpCarltdAuthCancelRouter(String str, ICallBackWsPpCarltdAuthCancel iCallBackWsPpCarltdAuthCancel) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsPpCarltdAuthCancel);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpCarltdAuthCancelImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpCarltdAuthCancelImpl
    public void onRecvAck(GWsPpCarltdAuthCancelResponseParam gWsPpCarltdAuthCancelResponseParam) {
        ICallBackWsPpCarltdAuthCancel iCallBackWsPpCarltdAuthCancel = this.mObserver;
        if (iCallBackWsPpCarltdAuthCancel != null) {
            iCallBackWsPpCarltdAuthCancel.onRecvAck(gWsPpCarltdAuthCancelResponseParam);
        }
    }
}
