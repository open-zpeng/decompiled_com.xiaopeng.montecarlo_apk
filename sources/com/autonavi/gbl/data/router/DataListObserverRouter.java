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
import com.autonavi.gbl.data.observer.IDataListObserver;
import com.autonavi.gbl.data.observer.impl.IDataListObserverImpl;
@IntfAuto(target = IDataListObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class DataListObserverRouter extends IDataListObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(DataListObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(DataListObserverRouter.class);
    private TypeHelper mHelper;
    private IDataListObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IDataListObserver iDataListObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IDataListObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iDataListObserver;
    }

    protected DataListObserverRouter(String str, IDataListObserver iDataListObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iDataListObserver);
    }

    protected DataListObserverRouter(String str, IDataListObserver iDataListObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iDataListObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.router.DataListObserverRouter.1
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
    @Override // com.autonavi.gbl.data.observer.impl.IDataListObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.router.DataListObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.data.observer.impl.IDataListObserverImpl
    public void onRequestDataListCheck(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, @OperationErrCode.OperationErrCode1 int i3) {
        IDataListObserver iDataListObserver = this.mObserver;
        if (iDataListObserver != null) {
            iDataListObserver.onRequestDataListCheck(i, i2, i3);
        }
    }
}
