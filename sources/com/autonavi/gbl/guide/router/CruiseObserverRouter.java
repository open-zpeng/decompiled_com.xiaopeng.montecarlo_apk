package com.autonavi.gbl.guide.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.guide.model.CruiseCongestionInfo;
import com.autonavi.gbl.guide.model.CruiseEventInfo;
import com.autonavi.gbl.guide.model.CruiseFacilityInfo;
import com.autonavi.gbl.guide.model.CruiseInfo;
import com.autonavi.gbl.guide.model.CruiseTimeAndDist;
import com.autonavi.gbl.guide.model.LaneInfo;
import com.autonavi.gbl.guide.model.SocolEventInfo;
import com.autonavi.gbl.guide.observer.ICruiseObserver;
import com.autonavi.gbl.guide.observer.impl.ICruiseObserverImpl;
import java.util.ArrayList;
@IntfAuto(target = ICruiseObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CruiseObserverRouter extends ICruiseObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(CruiseObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(CruiseObserverRouter.class);
    private TypeHelper mHelper;
    private ICruiseObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, ICruiseObserver iCruiseObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICruiseObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCruiseObserver;
    }

    protected CruiseObserverRouter(String str, ICruiseObserver iCruiseObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCruiseObserver);
    }

    protected CruiseObserverRouter(String str, ICruiseObserver iCruiseObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCruiseObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.guide.router.CruiseObserverRouter.1
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
    @Override // com.autonavi.gbl.guide.observer.impl.ICruiseObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.guide.router.CruiseObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.guide.observer.impl.ICruiseObserverImpl
    public void onUpdateCruiseFacility(ArrayList<CruiseFacilityInfo> arrayList) {
        ICruiseObserver iCruiseObserver = this.mObserver;
        if (iCruiseObserver != null) {
            iCruiseObserver.onUpdateCruiseFacility(arrayList);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.ICruiseObserverImpl
    public void onUpdateElecCameraInfo(ArrayList<CruiseFacilityInfo> arrayList) {
        ICruiseObserver iCruiseObserver = this.mObserver;
        if (iCruiseObserver != null) {
            iCruiseObserver.onUpdateElecCameraInfo(arrayList);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.ICruiseObserverImpl
    public void onUpdateCruiseInfo(CruiseInfo cruiseInfo) {
        ICruiseObserver iCruiseObserver = this.mObserver;
        if (iCruiseObserver != null) {
            iCruiseObserver.onUpdateCruiseInfo(cruiseInfo);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.ICruiseObserverImpl
    public void onUpdateCruiseTimeAndDist(CruiseTimeAndDist cruiseTimeAndDist) {
        ICruiseObserver iCruiseObserver = this.mObserver;
        if (iCruiseObserver != null) {
            iCruiseObserver.onUpdateCruiseTimeAndDist(cruiseTimeAndDist);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.ICruiseObserverImpl
    public void onUpdateCruiseCongestionInfo(CruiseCongestionInfo cruiseCongestionInfo) {
        ICruiseObserver iCruiseObserver = this.mObserver;
        if (iCruiseObserver != null) {
            iCruiseObserver.onUpdateCruiseCongestionInfo(cruiseCongestionInfo);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.ICruiseObserverImpl
    public void onShowCruiseLaneInfo(LaneInfo laneInfo) {
        ICruiseObserver iCruiseObserver = this.mObserver;
        if (iCruiseObserver != null) {
            iCruiseObserver.onShowCruiseLaneInfo(laneInfo);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.ICruiseObserverImpl
    public void onHideCruiseLaneInfo() {
        ICruiseObserver iCruiseObserver = this.mObserver;
        if (iCruiseObserver != null) {
            iCruiseObserver.onHideCruiseLaneInfo();
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.ICruiseObserverImpl
    public void onUpdateCruiseEvent(CruiseEventInfo cruiseEventInfo) {
        ICruiseObserver iCruiseObserver = this.mObserver;
        if (iCruiseObserver != null) {
            iCruiseObserver.onUpdateCruiseEvent(cruiseEventInfo);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.ICruiseObserverImpl
    public void onUpdateCruiseSocolEvent(SocolEventInfo socolEventInfo) {
        ICruiseObserver iCruiseObserver = this.mObserver;
        if (iCruiseObserver != null) {
            iCruiseObserver.onUpdateCruiseSocolEvent(socolEventInfo);
        }
    }
}
