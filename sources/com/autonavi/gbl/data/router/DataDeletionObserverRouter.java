package com.autonavi.gbl.data.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.data.model.DataType;
import com.autonavi.gbl.data.model.DownLoadMode;
import com.autonavi.gbl.data.observer.IDataDeletionObserver;
import com.autonavi.gbl.data.observer.impl.IDataDeletionObserverImpl;
@IntfAuto(target = IDataDeletionObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class DataDeletionObserverRouter extends IDataDeletionObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(DataDeletionObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(DataDeletionObserverRouter.class);
    private TypeHelper mHelper;
    private IDataDeletionObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IDataDeletionObserver iDataDeletionObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IDataDeletionObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iDataDeletionObserver;
    }

    protected DataDeletionObserverRouter(String str, IDataDeletionObserver iDataDeletionObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iDataDeletionObserver);
    }

    protected DataDeletionObserverRouter(String str, IDataDeletionObserver iDataDeletionObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iDataDeletionObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.data.observer.impl.IDataDeletionObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.data.observer.impl.IDataDeletionObserverImpl
    public void onBeforeDataDeletion(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, int i3) {
        IDataDeletionObserver iDataDeletionObserver = this.mObserver;
        if (iDataDeletionObserver != null) {
            iDataDeletionObserver.onBeforeDataDeletion(i, i2, i3);
        }
    }

    @Override // com.autonavi.gbl.data.observer.impl.IDataDeletionObserverImpl
    public void onAfterDataDeletion(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, int i3) {
        IDataDeletionObserver iDataDeletionObserver = this.mObserver;
        if (iDataDeletionObserver != null) {
            iDataDeletionObserver.onAfterDataDeletion(i, i2, i3);
        }
    }
}
