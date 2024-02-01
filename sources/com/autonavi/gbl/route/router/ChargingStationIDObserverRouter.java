package com.autonavi.gbl.route.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.route.model.ChargingStationID;
import com.autonavi.gbl.route.observer.IChargingStationIDObserver;
import com.autonavi.gbl.route.observer.impl.IChargingStationIDObserverImpl;
import java.util.ArrayList;
@IntfAuto(target = IChargingStationIDObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class ChargingStationIDObserverRouter extends IChargingStationIDObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ChargingStationIDObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(ChargingStationIDObserverRouter.class);
    private TypeHelper mHelper;
    private IChargingStationIDObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IChargingStationIDObserver iChargingStationIDObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IChargingStationIDObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iChargingStationIDObserver;
    }

    protected ChargingStationIDObserverRouter(String str, IChargingStationIDObserver iChargingStationIDObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iChargingStationIDObserver);
    }

    protected ChargingStationIDObserverRouter(String str, IChargingStationIDObserver iChargingStationIDObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iChargingStationIDObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.route.observer.impl.IChargingStationIDObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.route.observer.impl.IChargingStationIDObserverImpl
    public void onChargingStationIDUpdated(ArrayList<ChargingStationID> arrayList) {
        IChargingStationIDObserver iChargingStationIDObserver = this.mObserver;
        if (iChargingStationIDObserver != null) {
            iChargingStationIDObserver.onChargingStationIDUpdated(arrayList);
        }
    }
}
