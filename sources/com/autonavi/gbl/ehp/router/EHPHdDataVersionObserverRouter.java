package com.autonavi.gbl.ehp.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.ehp.observer.IEHPHdDataVersionObserver;
import com.autonavi.gbl.ehp.observer.impl.IEHPHdDataVersionObserverImpl;
@IntfAuto(target = IEHPHdDataVersionObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class EHPHdDataVersionObserverRouter extends IEHPHdDataVersionObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(EHPHdDataVersionObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(EHPHdDataVersionObserverRouter.class);
    private TypeHelper mHelper;
    private IEHPHdDataVersionObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IEHPHdDataVersionObserver iEHPHdDataVersionObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IEHPHdDataVersionObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iEHPHdDataVersionObserver;
    }

    protected EHPHdDataVersionObserverRouter(String str, IEHPHdDataVersionObserver iEHPHdDataVersionObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iEHPHdDataVersionObserver);
    }

    protected EHPHdDataVersionObserverRouter(String str, IEHPHdDataVersionObserver iEHPHdDataVersionObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iEHPHdDataVersionObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.ehp.observer.impl.IEHPHdDataVersionObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.ehp.observer.impl.IEHPHdDataVersionObserverImpl
    public void onHdDataVersion(String str) {
        IEHPHdDataVersionObserver iEHPHdDataVersionObserver = this.mObserver;
        if (iEHPHdDataVersionObserver != null) {
            iEHPHdDataVersionObserver.onHdDataVersion(str);
        }
    }
}
