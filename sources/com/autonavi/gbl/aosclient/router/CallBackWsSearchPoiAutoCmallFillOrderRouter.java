package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsSearchPoiAutoCmallFillOrderResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsSearchPoiAutoCmallFillOrder;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsSearchPoiAutoCmallFillOrderImpl;
@IntfAuto(target = ICallBackWsSearchPoiAutoCmallFillOrder.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsSearchPoiAutoCmallFillOrderRouter extends ICallBackWsSearchPoiAutoCmallFillOrderImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsSearchPoiAutoCmallFillOrderRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsSearchPoiAutoCmallFillOrderRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsSearchPoiAutoCmallFillOrder mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsSearchPoiAutoCmallFillOrder iCallBackWsSearchPoiAutoCmallFillOrder) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsSearchPoiAutoCmallFillOrderImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsSearchPoiAutoCmallFillOrder;
    }

    protected CallBackWsSearchPoiAutoCmallFillOrderRouter(String str, ICallBackWsSearchPoiAutoCmallFillOrder iCallBackWsSearchPoiAutoCmallFillOrder, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsSearchPoiAutoCmallFillOrder);
    }

    protected CallBackWsSearchPoiAutoCmallFillOrderRouter(String str, ICallBackWsSearchPoiAutoCmallFillOrder iCallBackWsSearchPoiAutoCmallFillOrder) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsSearchPoiAutoCmallFillOrder);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsSearchPoiAutoCmallFillOrderImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsSearchPoiAutoCmallFillOrderImpl
    public void onRecvAck(GWsSearchPoiAutoCmallFillOrderResponseParam gWsSearchPoiAutoCmallFillOrderResponseParam) {
        ICallBackWsSearchPoiAutoCmallFillOrder iCallBackWsSearchPoiAutoCmallFillOrder = this.mObserver;
        if (iCallBackWsSearchPoiAutoCmallFillOrder != null) {
            iCallBackWsSearchPoiAutoCmallFillOrder.onRecvAck(gWsSearchPoiAutoCmallFillOrderResponseParam);
        }
    }
}
