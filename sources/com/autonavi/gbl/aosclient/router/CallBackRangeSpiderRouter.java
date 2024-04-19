package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GRangeSpiderResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackRangeSpider;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackRangeSpiderImpl;
@IntfAuto(target = ICallBackRangeSpider.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackRangeSpiderRouter extends ICallBackRangeSpiderImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackRangeSpiderRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackRangeSpiderRouter.class);
    private TypeHelper mHelper;
    private ICallBackRangeSpider mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackRangeSpider iCallBackRangeSpider) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackRangeSpiderImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackRangeSpider;
    }

    protected CallBackRangeSpiderRouter(String str, ICallBackRangeSpider iCallBackRangeSpider, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackRangeSpider);
    }

    protected CallBackRangeSpiderRouter(String str, ICallBackRangeSpider iCallBackRangeSpider) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackRangeSpider);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackRangeSpiderRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackRangeSpiderImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackRangeSpiderRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackRangeSpiderImpl
    public void onRecvAck(GRangeSpiderResponseParam gRangeSpiderResponseParam) {
        ICallBackRangeSpider iCallBackRangeSpider = this.mObserver;
        if (iCallBackRangeSpider != null) {
            iCallBackRangeSpider.onRecvAck(gRangeSpiderResponseParam);
        }
    }
}
