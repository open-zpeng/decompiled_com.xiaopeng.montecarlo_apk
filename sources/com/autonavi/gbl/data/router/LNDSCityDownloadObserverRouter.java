package com.autonavi.gbl.data.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.data.model.LNDSFileRecoverStatus;
import com.autonavi.gbl.data.model.OperationErrCode;
import com.autonavi.gbl.data.model.TaskStatusCode;
import com.autonavi.gbl.data.observer.ILNDSCityDownloadObserver;
import com.autonavi.gbl.data.observer.impl.ILNDSCityDownloadObserverImpl;
@IntfAuto(target = ILNDSCityDownloadObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class LNDSCityDownloadObserverRouter extends ILNDSCityDownloadObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(LNDSCityDownloadObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(LNDSCityDownloadObserverRouter.class);
    private TypeHelper mHelper;
    private ILNDSCityDownloadObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, ILNDSCityDownloadObserver iLNDSCityDownloadObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ILNDSCityDownloadObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iLNDSCityDownloadObserver;
    }

    protected LNDSCityDownloadObserverRouter(String str, ILNDSCityDownloadObserver iLNDSCityDownloadObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLNDSCityDownloadObserver);
    }

    protected LNDSCityDownloadObserverRouter(String str, ILNDSCityDownloadObserver iLNDSCityDownloadObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLNDSCityDownloadObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.router.LNDSCityDownloadObserverRouter.1
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
    @Override // com.autonavi.gbl.data.observer.impl.ILNDSCityDownloadObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.router.LNDSCityDownloadObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.data.observer.impl.ILNDSCityDownloadObserverImpl
    public void onDownloadVersion(int i, String str) {
        ILNDSCityDownloadObserver iLNDSCityDownloadObserver = this.mObserver;
        if (iLNDSCityDownloadObserver != null) {
            iLNDSCityDownloadObserver.onDownloadVersion(i, str);
        }
    }

    @Override // com.autonavi.gbl.data.observer.impl.ILNDSCityDownloadObserverImpl
    public void onDownloadStatus(int i, @TaskStatusCode.TaskStatusCode1 int i2) {
        ILNDSCityDownloadObserver iLNDSCityDownloadObserver = this.mObserver;
        if (iLNDSCityDownloadObserver != null) {
            iLNDSCityDownloadObserver.onDownloadStatus(i, i2);
        }
    }

    @Override // com.autonavi.gbl.data.observer.impl.ILNDSCityDownloadObserverImpl
    public void onDownloadError(int i, @OperationErrCode.OperationErrCode1 int i2) {
        ILNDSCityDownloadObserver iLNDSCityDownloadObserver = this.mObserver;
        if (iLNDSCityDownloadObserver != null) {
            iLNDSCityDownloadObserver.onDownloadError(i, i2);
        }
    }

    @Override // com.autonavi.gbl.data.observer.impl.ILNDSCityDownloadObserverImpl
    public void onDownloadProgress(int i, long j, float f) {
        ILNDSCityDownloadObserver iLNDSCityDownloadObserver = this.mObserver;
        if (iLNDSCityDownloadObserver != null) {
            iLNDSCityDownloadObserver.onDownloadProgress(i, j, f);
        }
    }

    @Override // com.autonavi.gbl.data.observer.impl.ILNDSCityDownloadObserverImpl
    public void onMergeProgress(int i, float f) {
        ILNDSCityDownloadObserver iLNDSCityDownloadObserver = this.mObserver;
        if (iLNDSCityDownloadObserver != null) {
            iLNDSCityDownloadObserver.onMergeProgress(i, f);
        }
    }

    @Override // com.autonavi.gbl.data.observer.impl.ILNDSCityDownloadObserverImpl
    public void onFileRecoverStatus(@LNDSFileRecoverStatus.LNDSFileRecoverStatus1 int i) {
        ILNDSCityDownloadObserver iLNDSCityDownloadObserver = this.mObserver;
        if (iLNDSCityDownloadObserver != null) {
            iLNDSCityDownloadObserver.onFileRecoverStatus(i);
        }
    }
}
