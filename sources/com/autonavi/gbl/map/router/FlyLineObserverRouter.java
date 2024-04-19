package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.map.layer.observer.IFlyLineObserver;
import com.autonavi.gbl.map.layer.observer.impl.IFlyLineObserverImpl;
@IntfAuto(target = IFlyLineObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class FlyLineObserverRouter extends IFlyLineObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(FlyLineObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(FlyLineObserverRouter.class);
    private TypeHelper mHelper;
    private IFlyLineObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IFlyLineObserver iFlyLineObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IFlyLineObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iFlyLineObserver;
    }

    protected FlyLineObserverRouter(String str, IFlyLineObserver iFlyLineObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iFlyLineObserver);
    }

    protected FlyLineObserverRouter(String str, IFlyLineObserver iFlyLineObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iFlyLineObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.FlyLineObserverRouter.1
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
    @Override // com.autonavi.gbl.map.layer.observer.impl.IFlyLineObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.FlyLineObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.IFlyLineObserverImpl
    public void onFlyLineClick(Coord3DDouble coord3DDouble) {
        IFlyLineObserver iFlyLineObserver = this.mObserver;
        if (iFlyLineObserver != null) {
            iFlyLineObserver.onFlyLineClick(coord3DDouble);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.IFlyLineObserverImpl
    public void onStartChange(Coord3DDouble coord3DDouble) {
        IFlyLineObserver iFlyLineObserver = this.mObserver;
        if (iFlyLineObserver != null) {
            iFlyLineObserver.onStartChange(coord3DDouble);
        }
    }

    @Override // com.autonavi.gbl.map.layer.observer.impl.IFlyLineObserverImpl
    public void onEndChange(Coord3DDouble coord3DDouble) {
        IFlyLineObserver iFlyLineObserver = this.mObserver;
        if (iFlyLineObserver != null) {
            iFlyLineObserver.onEndChange(coord3DDouble);
        }
    }
}
