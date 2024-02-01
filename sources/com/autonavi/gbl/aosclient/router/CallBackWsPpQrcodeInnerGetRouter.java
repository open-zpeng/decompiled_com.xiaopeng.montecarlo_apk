package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsPpQrcodeInnerGetResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpQrcodeInnerGet;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpQrcodeInnerGetImpl;
@IntfAuto(target = ICallBackWsPpQrcodeInnerGet.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsPpQrcodeInnerGetRouter extends ICallBackWsPpQrcodeInnerGetImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsPpQrcodeInnerGetRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsPpQrcodeInnerGetRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsPpQrcodeInnerGet mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsPpQrcodeInnerGet iCallBackWsPpQrcodeInnerGet) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsPpQrcodeInnerGetImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsPpQrcodeInnerGet;
    }

    protected CallBackWsPpQrcodeInnerGetRouter(String str, ICallBackWsPpQrcodeInnerGet iCallBackWsPpQrcodeInnerGet, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsPpQrcodeInnerGet);
    }

    protected CallBackWsPpQrcodeInnerGetRouter(String str, ICallBackWsPpQrcodeInnerGet iCallBackWsPpQrcodeInnerGet) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsPpQrcodeInnerGet);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpQrcodeInnerGetImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpQrcodeInnerGetImpl
    public void onRecvAck(GWsPpQrcodeInnerGetResponseParam gWsPpQrcodeInnerGetResponseParam) {
        ICallBackWsPpQrcodeInnerGet iCallBackWsPpQrcodeInnerGet = this.mObserver;
        if (iCallBackWsPpQrcodeInnerGet != null) {
            iCallBackWsPpQrcodeInnerGet.onRecvAck(gWsPpQrcodeInnerGetResponseParam);
        }
    }
}
