package com.autonavi.gbl.data.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.data.model.DataType;
import com.autonavi.gbl.data.model.DownLoadMode;
import com.autonavi.gbl.data.model.OperationErrCode;
import com.autonavi.gbl.data.observer.IDataInitObserver;
import com.autonavi.gbl.data.observer.impl.IDataInitObserverImpl;
@IntfAuto(target = IDataInitObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class DataInitObserverRouter extends IDataInitObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(DataInitObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(DataInitObserverRouter.class);
    private TypeHelper mHelper;
    private IDataInitObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IDataInitObserver iDataInitObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IDataInitObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iDataInitObserver;
    }

    protected DataInitObserverRouter(String str, IDataInitObserver iDataInitObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iDataInitObserver);
    }

    protected DataInitObserverRouter(String str, IDataInitObserver iDataInitObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iDataInitObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.router.DataInitObserverRouter.1
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
    @Override // com.autonavi.gbl.data.observer.impl.IDataInitObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.router.DataInitObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.data.observer.impl.IDataInitObserverImpl
    public void onInit(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, @OperationErrCode.OperationErrCode1 int i3) {
        IDataInitObserver iDataInitObserver = this.mObserver;
        if (iDataInitObserver != null) {
            iDataInitObserver.onInit(i, i2, i3);
        }
    }
}
