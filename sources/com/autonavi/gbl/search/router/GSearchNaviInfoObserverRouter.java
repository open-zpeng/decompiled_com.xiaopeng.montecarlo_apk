package com.autonavi.gbl.search.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.search.model.SearchNaviInfoResult;
import com.autonavi.gbl.search.observer.IGSearchNaviInfoObserver;
import com.autonavi.gbl.search.observer.impl.IGSearchNaviInfoObserverImpl;
import com.autonavi.gbl.util.model.EGErr;
@IntfAuto(target = IGSearchNaviInfoObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class GSearchNaviInfoObserverRouter extends IGSearchNaviInfoObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(GSearchNaviInfoObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(GSearchNaviInfoObserverRouter.class);
    private TypeHelper mHelper;
    private IGSearchNaviInfoObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IGSearchNaviInfoObserver iGSearchNaviInfoObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IGSearchNaviInfoObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iGSearchNaviInfoObserver;
    }

    protected GSearchNaviInfoObserverRouter(String str, IGSearchNaviInfoObserver iGSearchNaviInfoObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGSearchNaviInfoObserver);
    }

    protected GSearchNaviInfoObserverRouter(String str, IGSearchNaviInfoObserver iGSearchNaviInfoObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGSearchNaviInfoObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.search.router.GSearchNaviInfoObserverRouter.1
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
    @Override // com.autonavi.gbl.search.observer.impl.IGSearchNaviInfoObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.search.router.GSearchNaviInfoObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.search.observer.impl.IGSearchNaviInfoObserverImpl
    public void onGetNaviInfoResult(int i, @EGErr.EGErr1 int i2, SearchNaviInfoResult searchNaviInfoResult) {
        IGSearchNaviInfoObserver iGSearchNaviInfoObserver = this.mObserver;
        if (iGSearchNaviInfoObserver != null) {
            iGSearchNaviInfoObserver.onGetNaviInfoResult(i, i2, searchNaviInfoResult);
        }
    }
}
