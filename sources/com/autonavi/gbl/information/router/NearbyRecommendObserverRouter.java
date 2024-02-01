package com.autonavi.gbl.information.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.information.nearby.model.NearbyRecommendResult;
import com.autonavi.gbl.information.nearby.observer.INearbyRecommendObserver;
import com.autonavi.gbl.information.nearby.observer.impl.INearbyRecommendObserverImpl;
@IntfAuto(target = INearbyRecommendObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class NearbyRecommendObserverRouter extends INearbyRecommendObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(NearbyRecommendObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(NearbyRecommendObserverRouter.class);
    private TypeHelper mHelper;
    private INearbyRecommendObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, INearbyRecommendObserver iNearbyRecommendObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(INearbyRecommendObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iNearbyRecommendObserver;
    }

    protected NearbyRecommendObserverRouter(String str, INearbyRecommendObserver iNearbyRecommendObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iNearbyRecommendObserver);
    }

    protected NearbyRecommendObserverRouter(String str, INearbyRecommendObserver iNearbyRecommendObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iNearbyRecommendObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.information.nearby.observer.impl.INearbyRecommendObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.information.nearby.observer.impl.INearbyRecommendObserverImpl
    public void onResult(int i, NearbyRecommendResult nearbyRecommendResult) {
        INearbyRecommendObserver iNearbyRecommendObserver = this.mObserver;
        if (iNearbyRecommendObserver != null) {
            iNearbyRecommendObserver.onResult(i, nearbyRecommendResult);
        }
    }
}
