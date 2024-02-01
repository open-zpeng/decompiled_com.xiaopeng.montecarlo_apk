package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GHolidayListResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackHolidayList;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackHolidayListImpl;
@IntfAuto(target = ICallBackHolidayList.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackHolidayListRouter extends ICallBackHolidayListImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackHolidayListRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackHolidayListRouter.class);
    private TypeHelper mHelper;
    private ICallBackHolidayList mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackHolidayList iCallBackHolidayList) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackHolidayListImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackHolidayList;
    }

    protected CallBackHolidayListRouter(String str, ICallBackHolidayList iCallBackHolidayList, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackHolidayList);
    }

    protected CallBackHolidayListRouter(String str, ICallBackHolidayList iCallBackHolidayList) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackHolidayList);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackHolidayListImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackHolidayListImpl
    public void onRecvAck(GHolidayListResponseParam gHolidayListResponseParam) {
        ICallBackHolidayList iCallBackHolidayList = this.mObserver;
        if (iCallBackHolidayList != null) {
            iCallBackHolidayList.onRecvAck(gHolidayListResponseParam);
        }
    }
}
