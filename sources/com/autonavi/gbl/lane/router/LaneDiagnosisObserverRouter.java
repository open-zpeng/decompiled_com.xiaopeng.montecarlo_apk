package com.autonavi.gbl.lane.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.lane.observer.ILaneDiagnosisObserver;
import com.autonavi.gbl.lane.observer.impl.ILaneDiagnosisObserverImpl;
@IntfAuto(target = ILaneDiagnosisObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class LaneDiagnosisObserverRouter extends ILaneDiagnosisObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(LaneDiagnosisObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(LaneDiagnosisObserverRouter.class);
    private TypeHelper mHelper;
    private ILaneDiagnosisObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, ILaneDiagnosisObserver iLaneDiagnosisObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ILaneDiagnosisObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iLaneDiagnosisObserver;
    }

    protected LaneDiagnosisObserverRouter(String str, ILaneDiagnosisObserver iLaneDiagnosisObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneDiagnosisObserver);
    }

    protected LaneDiagnosisObserverRouter(String str, ILaneDiagnosisObserver iLaneDiagnosisObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneDiagnosisObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.lane.observer.impl.ILaneDiagnosisObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneDiagnosisObserverImpl
    public void onUpdateDiagnosis(String str) {
        ILaneDiagnosisObserver iLaneDiagnosisObserver = this.mObserver;
        if (iLaneDiagnosisObserver != null) {
            iLaneDiagnosisObserver.onUpdateDiagnosis(str);
        }
    }
}
