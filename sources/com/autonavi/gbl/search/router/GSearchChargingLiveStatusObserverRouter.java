package com.autonavi.gbl.search.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.search.model.SearchChargingLiveStatusResult;
import com.autonavi.gbl.search.observer.IGSearchChargingLiveStatusObserver;
import com.autonavi.gbl.search.observer.impl.IGSearchChargingLiveStatusObserverImpl;
import com.autonavi.gbl.util.model.EGErr;
@IntfAuto(target = IGSearchChargingLiveStatusObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class GSearchChargingLiveStatusObserverRouter extends IGSearchChargingLiveStatusObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(GSearchChargingLiveStatusObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(GSearchChargingLiveStatusObserverRouter.class);
    private TypeHelper mHelper;
    private IGSearchChargingLiveStatusObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IGSearchChargingLiveStatusObserver iGSearchChargingLiveStatusObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IGSearchChargingLiveStatusObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iGSearchChargingLiveStatusObserver;
    }

    protected GSearchChargingLiveStatusObserverRouter(String str, IGSearchChargingLiveStatusObserver iGSearchChargingLiveStatusObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGSearchChargingLiveStatusObserver);
    }

    protected GSearchChargingLiveStatusObserverRouter(String str, IGSearchChargingLiveStatusObserver iGSearchChargingLiveStatusObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGSearchChargingLiveStatusObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.search.router.GSearchChargingLiveStatusObserverRouter.1
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
    @Override // com.autonavi.gbl.search.observer.impl.IGSearchChargingLiveStatusObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.search.router.GSearchChargingLiveStatusObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.search.observer.impl.IGSearchChargingLiveStatusObserverImpl
    public void onGetChargingLiveStatusResult(int i, @EGErr.EGErr1 int i2, SearchChargingLiveStatusResult searchChargingLiveStatusResult) {
        IGSearchChargingLiveStatusObserver iGSearchChargingLiveStatusObserver = this.mObserver;
        if (iGSearchChargingLiveStatusObserver != null) {
            iGSearchChargingLiveStatusObserver.onGetChargingLiveStatusResult(i, i2, searchChargingLiveStatusResult);
        }
    }
}
