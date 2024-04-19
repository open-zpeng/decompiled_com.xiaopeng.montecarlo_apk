package com.autonavi.gbl.pos.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.pos.model.NgmDiff;
import com.autonavi.gbl.pos.observer.INgmInfoObserver;
import com.autonavi.gbl.pos.observer.impl.INgmInfoObserverImpl;
@IntfAuto(target = INgmInfoObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class NgmInfoObserverRouter extends INgmInfoObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(NgmInfoObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(NgmInfoObserverRouter.class);
    private TypeHelper mHelper;
    private INgmInfoObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, INgmInfoObserver iNgmInfoObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(INgmInfoObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iNgmInfoObserver;
    }

    protected NgmInfoObserverRouter(String str, INgmInfoObserver iNgmInfoObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iNgmInfoObserver);
    }

    protected NgmInfoObserverRouter(String str, INgmInfoObserver iNgmInfoObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iNgmInfoObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.router.NgmInfoObserverRouter.1
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
    @Override // com.autonavi.gbl.pos.observer.impl.INgmInfoObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.router.NgmInfoObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.pos.observer.impl.INgmInfoObserverImpl
    public void onNgmInfoUpdate(NgmDiff ngmDiff) {
        INgmInfoObserver iNgmInfoObserver = this.mObserver;
        if (iNgmInfoObserver != null) {
            iNgmInfoObserver.onNgmInfoUpdate(ngmDiff);
        }
    }
}
