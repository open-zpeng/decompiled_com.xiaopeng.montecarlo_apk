package com.autonavi.gbl.data.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.data.model.DataType;
import com.autonavi.gbl.data.model.DownLoadMode;
import com.autonavi.gbl.data.model.OperationType;
import com.autonavi.gbl.data.model.TaskStatusCode;
import com.autonavi.gbl.data.observer.IDownloadObserver;
import com.autonavi.gbl.data.observer.impl.IDownloadObserverImpl;
import java.util.ArrayList;
@IntfAuto(target = IDownloadObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class DownloadObserverRouter extends IDownloadObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(DownloadObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(DownloadObserverRouter.class);
    private TypeHelper mHelper;
    private IDownloadObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IDownloadObserver iDownloadObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IDownloadObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iDownloadObserver;
    }

    protected DownloadObserverRouter(String str, IDownloadObserver iDownloadObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iDownloadObserver);
    }

    protected DownloadObserverRouter(String str, IDownloadObserver iDownloadObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iDownloadObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.data.observer.impl.IDownloadObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.data.observer.impl.IDownloadObserverImpl
    public void onOperated(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, @OperationType.OperationType1 int i3, ArrayList<Integer> arrayList) {
        IDownloadObserver iDownloadObserver = this.mObserver;
        if (iDownloadObserver != null) {
            iDownloadObserver.onOperated(i, i2, i3, arrayList);
        }
    }

    @Override // com.autonavi.gbl.data.observer.impl.IDownloadObserverImpl
    public void onDownLoadStatus(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, int i3, @TaskStatusCode.TaskStatusCode1 int i4, int i5) {
        IDownloadObserver iDownloadObserver = this.mObserver;
        if (iDownloadObserver != null) {
            iDownloadObserver.onDownLoadStatus(i, i2, i3, i4, i5);
        }
    }

    @Override // com.autonavi.gbl.data.observer.impl.IDownloadObserverImpl
    public void onPercent(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, int i3, int i4, float f) {
        IDownloadObserver iDownloadObserver = this.mObserver;
        if (iDownloadObserver != null) {
            iDownloadObserver.onPercent(i, i2, i3, i4, f);
        }
    }
}
