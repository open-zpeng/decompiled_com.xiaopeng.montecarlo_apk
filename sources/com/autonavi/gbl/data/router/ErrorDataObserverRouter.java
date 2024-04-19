package com.autonavi.gbl.data.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.data.model.DataErrorType;
import com.autonavi.gbl.data.model.DataType;
import com.autonavi.gbl.data.model.DownLoadMode;
import com.autonavi.gbl.data.model.OperationErrCode;
import com.autonavi.gbl.data.observer.IErrorDataObserver;
import com.autonavi.gbl.data.observer.impl.IErrorDataObserverImpl;
@IntfAuto(target = IErrorDataObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class ErrorDataObserverRouter extends IErrorDataObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ErrorDataObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(ErrorDataObserverRouter.class);
    private TypeHelper mHelper;
    private IErrorDataObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IErrorDataObserver iErrorDataObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IErrorDataObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iErrorDataObserver;
    }

    protected ErrorDataObserverRouter(String str, IErrorDataObserver iErrorDataObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iErrorDataObserver);
    }

    protected ErrorDataObserverRouter(String str, IErrorDataObserver iErrorDataObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iErrorDataObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.router.ErrorDataObserverRouter.1
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
    @Override // com.autonavi.gbl.data.observer.impl.IErrorDataObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.router.ErrorDataObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.data.observer.impl.IErrorDataObserverImpl
    public void onErrorNotify(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, int i3, @DataErrorType.DataErrorType1 int i4, String str) {
        IErrorDataObserver iErrorDataObserver = this.mObserver;
        if (iErrorDataObserver != null) {
            iErrorDataObserver.onErrorNotify(i, i2, i3, i4, str);
        }
    }

    @Override // com.autonavi.gbl.data.observer.impl.IErrorDataObserverImpl
    public void onErrorNotifyH(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, int i3, @DataErrorType.DataErrorType1 int i4, String str) {
        IErrorDataObserver iErrorDataObserver = this.mObserver;
        if (iErrorDataObserver != null) {
            iErrorDataObserver.onErrorNotifyH(i, i2, i3, i4, str);
        }
    }

    @Override // com.autonavi.gbl.data.observer.impl.IErrorDataObserverImpl
    public void onDeleteErrorData(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, int i3, @OperationErrCode.OperationErrCode1 int i4) {
        IErrorDataObserver iErrorDataObserver = this.mObserver;
        if (iErrorDataObserver != null) {
            iErrorDataObserver.onDeleteErrorData(i, i2, i3, i4);
        }
    }
}
