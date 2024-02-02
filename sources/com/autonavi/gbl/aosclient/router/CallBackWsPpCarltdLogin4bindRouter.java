package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GWsPpCarltdLogin4bindResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpCarltdLogin4bind;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpCarltdLogin4bindImpl;
@IntfAuto(target = ICallBackWsPpCarltdLogin4bind.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackWsPpCarltdLogin4bindRouter extends ICallBackWsPpCarltdLogin4bindImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackWsPpCarltdLogin4bindRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackWsPpCarltdLogin4bindRouter.class);
    private TypeHelper mHelper;
    private ICallBackWsPpCarltdLogin4bind mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackWsPpCarltdLogin4bind iCallBackWsPpCarltdLogin4bind) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackWsPpCarltdLogin4bindImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackWsPpCarltdLogin4bind;
    }

    protected CallBackWsPpCarltdLogin4bindRouter(String str, ICallBackWsPpCarltdLogin4bind iCallBackWsPpCarltdLogin4bind, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsPpCarltdLogin4bind);
    }

    protected CallBackWsPpCarltdLogin4bindRouter(String str, ICallBackWsPpCarltdLogin4bind iCallBackWsPpCarltdLogin4bind) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackWsPpCarltdLogin4bind);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsPpCarltdLogin4bindRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpCarltdLogin4bindImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackWsPpCarltdLogin4bindRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackWsPpCarltdLogin4bindImpl
    public void onRecvAck(GWsPpCarltdLogin4bindResponseParam gWsPpCarltdLogin4bindResponseParam) {
        ICallBackWsPpCarltdLogin4bind iCallBackWsPpCarltdLogin4bind = this.mObserver;
        if (iCallBackWsPpCarltdLogin4bind != null) {
            iCallBackWsPpCarltdLogin4bind.onRecvAck(gWsPpCarltdLogin4bindResponseParam);
        }
    }
}
