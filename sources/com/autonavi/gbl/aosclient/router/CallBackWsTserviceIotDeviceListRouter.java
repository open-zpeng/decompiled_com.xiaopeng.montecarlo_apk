package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsTserviceIotDeviceListResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceIotDeviceList;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceIotDeviceListImpl;
@IntfAuto(target = ICallBackWsTserviceIotDeviceList.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsTserviceIotDeviceListRouter extends ICallBackWsTserviceIotDeviceListImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsTserviceIotDeviceListRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsTserviceIotDeviceListRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsTserviceIotDeviceList mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsTserviceIotDeviceList iCallBackWsTserviceIotDeviceList) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsTserviceIotDeviceListImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsTserviceIotDeviceList;
    }

    protected CallBackWsTserviceIotDeviceListRouter(String str, ICallBackWsTserviceIotDeviceList iCallBackWsTserviceIotDeviceList, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceIotDeviceList);
    }

    protected CallBackWsTserviceIotDeviceListRouter(String str, ICallBackWsTserviceIotDeviceList iCallBackWsTserviceIotDeviceList) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsTserviceIotDeviceList);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceIotDeviceListImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsTserviceIotDeviceListImpl
    public void onRecvAck(GWsTserviceIotDeviceListResponseParam gWsTserviceIotDeviceListResponseParam) {
        ICallBackWsTserviceIotDeviceList iCallBackWsTserviceIotDeviceList = this.mObserver;
        if (iCallBackWsTserviceIotDeviceList != null) {
            iCallBackWsTserviceIotDeviceList.onRecvAck(gWsTserviceIotDeviceListResponseParam);
        }
    }
}
