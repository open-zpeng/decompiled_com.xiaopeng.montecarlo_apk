package com.autonavi.gbl.pos.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.pos.model.LocSignData;
import com.autonavi.gbl.pos.observer.IPosSignInfoObserver;
import com.autonavi.gbl.pos.observer.impl.IPosSignInfoObserverImpl;
@IntfAuto(target = IPosSignInfoObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class PosSignInfoObserverRouter extends IPosSignInfoObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(PosSignInfoObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(PosSignInfoObserverRouter.class);
    private TypeHelper mHelper;
    private IPosSignInfoObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IPosSignInfoObserver iPosSignInfoObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IPosSignInfoObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iPosSignInfoObserver;
    }

    protected PosSignInfoObserverRouter(String str, IPosSignInfoObserver iPosSignInfoObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPosSignInfoObserver);
    }

    protected PosSignInfoObserverRouter(String str, IPosSignInfoObserver iPosSignInfoObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPosSignInfoObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.router.PosSignInfoObserverRouter.1
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
    @Override // com.autonavi.gbl.pos.observer.impl.IPosSignInfoObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.router.PosSignInfoObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.pos.observer.impl.IPosSignInfoObserverImpl
    public void onSignInfoUpdate(LocSignData locSignData) {
        IPosSignInfoObserver iPosSignInfoObserver = this.mObserver;
        if (iPosSignInfoObserver != null) {
            iPosSignInfoObserver.onSignInfoUpdate(locSignData);
        }
    }
}
