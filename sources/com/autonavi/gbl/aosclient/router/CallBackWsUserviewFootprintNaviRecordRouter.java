package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsUserviewFootprintNaviRecordResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsUserviewFootprintNaviRecord;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsUserviewFootprintNaviRecordImpl;
@IntfAuto(target = ICallBackWsUserviewFootprintNaviRecord.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsUserviewFootprintNaviRecordRouter extends ICallBackWsUserviewFootprintNaviRecordImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsUserviewFootprintNaviRecordRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsUserviewFootprintNaviRecordRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsUserviewFootprintNaviRecord mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsUserviewFootprintNaviRecord iCallBackWsUserviewFootprintNaviRecord) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsUserviewFootprintNaviRecordImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsUserviewFootprintNaviRecord;
    }

    protected CallBackWsUserviewFootprintNaviRecordRouter(String str, ICallBackWsUserviewFootprintNaviRecord iCallBackWsUserviewFootprintNaviRecord, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsUserviewFootprintNaviRecord);
    }

    protected CallBackWsUserviewFootprintNaviRecordRouter(String str, ICallBackWsUserviewFootprintNaviRecord iCallBackWsUserviewFootprintNaviRecord) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsUserviewFootprintNaviRecord);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsUserviewFootprintNaviRecordRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsUserviewFootprintNaviRecordImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsUserviewFootprintNaviRecordRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsUserviewFootprintNaviRecordImpl
    public void onRecvAck(GWsUserviewFootprintNaviRecordResponseParam gWsUserviewFootprintNaviRecordResponseParam) {
        ICallBackWsUserviewFootprintNaviRecord iCallBackWsUserviewFootprintNaviRecord = this.mObserver;
        if (iCallBackWsUserviewFootprintNaviRecord != null) {
            iCallBackWsUserviewFootprintNaviRecord.onRecvAck(gWsUserviewFootprintNaviRecordResponseParam);
        }
    }
}
