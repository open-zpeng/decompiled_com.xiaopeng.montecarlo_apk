package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GReStrictedAreaResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackReStrictedArea;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackReStrictedAreaImpl;
@IntfAuto(target = ICallBackReStrictedArea.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackReStrictedAreaRouter extends ICallBackReStrictedAreaImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackReStrictedAreaRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackReStrictedAreaRouter.class);
    private TypeHelper mHelper;
    private ICallBackReStrictedArea mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackReStrictedArea iCallBackReStrictedArea) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackReStrictedAreaImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackReStrictedArea;
    }

    protected CallBackReStrictedAreaRouter(String str, ICallBackReStrictedArea iCallBackReStrictedArea, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackReStrictedArea);
    }

    protected CallBackReStrictedAreaRouter(String str, ICallBackReStrictedArea iCallBackReStrictedArea) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackReStrictedArea);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackReStrictedAreaImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackReStrictedAreaImpl
    public void onRecvAck(GReStrictedAreaResponseParam gReStrictedAreaResponseParam) {
        ICallBackReStrictedArea iCallBackReStrictedArea = this.mObserver;
        if (iCallBackReStrictedArea != null) {
            iCallBackReStrictedArea.onRecvAck(gReStrictedAreaResponseParam);
        }
    }
}
