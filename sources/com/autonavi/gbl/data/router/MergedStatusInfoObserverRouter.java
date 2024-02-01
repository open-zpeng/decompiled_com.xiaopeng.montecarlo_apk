package com.autonavi.gbl.data.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.data.model.MergedStatusInfo;
import com.autonavi.gbl.data.observer.IMergedStatusInfoObserver;
import com.autonavi.gbl.data.observer.impl.IMergedStatusInfoObserverImpl;
@IntfAuto(target = IMergedStatusInfoObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class MergedStatusInfoObserverRouter extends IMergedStatusInfoObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(MergedStatusInfoObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(MergedStatusInfoObserverRouter.class);
    private TypeHelper mHelper;
    private IMergedStatusInfoObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IMergedStatusInfoObserver iMergedStatusInfoObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IMergedStatusInfoObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iMergedStatusInfoObserver;
    }

    protected MergedStatusInfoObserverRouter(String str, IMergedStatusInfoObserver iMergedStatusInfoObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMergedStatusInfoObserver);
    }

    protected MergedStatusInfoObserverRouter(String str, IMergedStatusInfoObserver iMergedStatusInfoObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMergedStatusInfoObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.data.observer.impl.IMergedStatusInfoObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.data.observer.impl.IMergedStatusInfoObserverImpl
    public void onMergedStatusInfo(MergedStatusInfo mergedStatusInfo) {
        IMergedStatusInfoObserver iMergedStatusInfoObserver = this.mObserver;
        if (iMergedStatusInfoObserver != null) {
            iMergedStatusInfoObserver.onMergedStatusInfo(mergedStatusInfo);
        }
    }
}
