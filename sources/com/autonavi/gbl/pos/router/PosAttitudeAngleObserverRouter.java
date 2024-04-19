package com.autonavi.gbl.pos.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.pos.model.RawAttitudeAngle;
import com.autonavi.gbl.pos.observer.IPosAttitudeAngleObserver;
import com.autonavi.gbl.pos.observer.impl.IPosAttitudeAngleObserverImpl;
@IntfAuto(target = IPosAttitudeAngleObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class PosAttitudeAngleObserverRouter extends IPosAttitudeAngleObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(PosAttitudeAngleObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(PosAttitudeAngleObserverRouter.class);
    private TypeHelper mHelper;
    private IPosAttitudeAngleObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IPosAttitudeAngleObserver iPosAttitudeAngleObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IPosAttitudeAngleObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iPosAttitudeAngleObserver;
    }

    protected PosAttitudeAngleObserverRouter(String str, IPosAttitudeAngleObserver iPosAttitudeAngleObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPosAttitudeAngleObserver);
    }

    protected PosAttitudeAngleObserverRouter(String str, IPosAttitudeAngleObserver iPosAttitudeAngleObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPosAttitudeAngleObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.router.PosAttitudeAngleObserverRouter.1
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
    @Override // com.autonavi.gbl.pos.observer.impl.IPosAttitudeAngleObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.router.PosAttitudeAngleObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.pos.observer.impl.IPosAttitudeAngleObserverImpl
    public void onAttitudeAngleUpdate(RawAttitudeAngle rawAttitudeAngle) {
        IPosAttitudeAngleObserver iPosAttitudeAngleObserver = this.mObserver;
        if (iPosAttitudeAngleObserver != null) {
            iPosAttitudeAngleObserver.onAttitudeAngleUpdate(rawAttitudeAngle);
        }
    }
}
