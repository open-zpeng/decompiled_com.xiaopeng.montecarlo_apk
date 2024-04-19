package com.autonavi.gbl.data.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.data.model.HotUpdateFileType;
import com.autonavi.gbl.data.model.OperationErrCode;
import com.autonavi.gbl.data.observer.IHotUpdateFileObserver;
import com.autonavi.gbl.data.observer.impl.IHotUpdateFileObserverImpl;
@IntfAuto(target = IHotUpdateFileObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class HotUpdateFileObserverRouter extends IHotUpdateFileObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(HotUpdateFileObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(HotUpdateFileObserverRouter.class);
    private TypeHelper mHelper;
    private IHotUpdateFileObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IHotUpdateFileObserver iHotUpdateFileObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IHotUpdateFileObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iHotUpdateFileObserver;
    }

    protected HotUpdateFileObserverRouter(String str, IHotUpdateFileObserver iHotUpdateFileObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iHotUpdateFileObserver);
    }

    protected HotUpdateFileObserverRouter(String str, IHotUpdateFileObserver iHotUpdateFileObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iHotUpdateFileObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.router.HotUpdateFileObserverRouter.1
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
    @Override // com.autonavi.gbl.data.observer.impl.IHotUpdateFileObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.router.HotUpdateFileObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.data.observer.impl.IHotUpdateFileObserverImpl
    public void onHotUpdateFile(@HotUpdateFileType.HotUpdateFileType1 int i, @OperationErrCode.OperationErrCode1 int i2, String str) {
        IHotUpdateFileObserver iHotUpdateFileObserver = this.mObserver;
        if (iHotUpdateFileObserver != null) {
            iHotUpdateFileObserver.onHotUpdateFile(i, i2, str);
        }
    }
}
