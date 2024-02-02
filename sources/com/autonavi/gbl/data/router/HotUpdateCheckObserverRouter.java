package com.autonavi.gbl.data.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.data.model.AutoInitResponseData;
import com.autonavi.gbl.data.model.OperationErrCode;
import com.autonavi.gbl.data.observer.IHotUpdateCheckObserver;
import com.autonavi.gbl.data.observer.impl.IHotUpdateCheckObserverImpl;
@IntfAuto(target = IHotUpdateCheckObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class HotUpdateCheckObserverRouter extends IHotUpdateCheckObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(HotUpdateCheckObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(HotUpdateCheckObserverRouter.class);
    private TypeHelper mHelper;
    private IHotUpdateCheckObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IHotUpdateCheckObserver iHotUpdateCheckObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IHotUpdateCheckObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iHotUpdateCheckObserver;
    }

    protected HotUpdateCheckObserverRouter(String str, IHotUpdateCheckObserver iHotUpdateCheckObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iHotUpdateCheckObserver);
    }

    protected HotUpdateCheckObserverRouter(String str, IHotUpdateCheckObserver iHotUpdateCheckObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iHotUpdateCheckObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.router.HotUpdateCheckObserverRouter.1
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
    @Override // com.autonavi.gbl.data.observer.impl.IHotUpdateCheckObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.router.HotUpdateCheckObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.data.observer.impl.IHotUpdateCheckObserverImpl
    public void onInitNotify(@OperationErrCode.OperationErrCode1 int i, AutoInitResponseData autoInitResponseData) {
        IHotUpdateCheckObserver iHotUpdateCheckObserver = this.mObserver;
        if (iHotUpdateCheckObserver != null) {
            iHotUpdateCheckObserver.onInitNotify(i, autoInitResponseData);
        }
    }
}
