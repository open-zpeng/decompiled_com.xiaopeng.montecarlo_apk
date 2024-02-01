package com.autonavi.gbl.guide.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.guide.observer.IContinueGuideInfoObserver;
import com.autonavi.gbl.guide.observer.impl.IContinueGuideInfoObserverImpl;
@IntfAuto(target = IContinueGuideInfoObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class ContinueGuideInfoObserverRouter extends IContinueGuideInfoObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ContinueGuideInfoObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(ContinueGuideInfoObserverRouter.class);
    private TypeHelper mHelper;
    private IContinueGuideInfoObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IContinueGuideInfoObserver iContinueGuideInfoObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IContinueGuideInfoObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iContinueGuideInfoObserver;
    }

    protected ContinueGuideInfoObserverRouter(String str, IContinueGuideInfoObserver iContinueGuideInfoObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iContinueGuideInfoObserver);
    }

    protected ContinueGuideInfoObserverRouter(String str, IContinueGuideInfoObserver iContinueGuideInfoObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iContinueGuideInfoObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.guide.observer.impl.IContinueGuideInfoObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.guide.observer.impl.IContinueGuideInfoObserverImpl
    public void continueGuideStartNotify() {
        IContinueGuideInfoObserver iContinueGuideInfoObserver = this.mObserver;
        if (iContinueGuideInfoObserver != null) {
            iContinueGuideInfoObserver.continueGuideStartNotify();
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.IContinueGuideInfoObserverImpl
    public void exitContinueGuideNotify() {
        IContinueGuideInfoObserver iContinueGuideInfoObserver = this.mObserver;
        if (iContinueGuideInfoObserver != null) {
            iContinueGuideInfoObserver.exitContinueGuideNotify();
        }
    }
}
