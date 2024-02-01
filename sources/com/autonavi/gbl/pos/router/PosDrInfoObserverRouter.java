package com.autonavi.gbl.pos.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.pos.model.DrInfo;
import com.autonavi.gbl.pos.observer.IPosDrInfoObserver;
import com.autonavi.gbl.pos.observer.impl.IPosDrInfoObserverImpl;
@IntfAuto(target = IPosDrInfoObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class PosDrInfoObserverRouter extends IPosDrInfoObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(PosDrInfoObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(PosDrInfoObserverRouter.class);
    private TypeHelper mHelper;
    private IPosDrInfoObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IPosDrInfoObserver iPosDrInfoObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IPosDrInfoObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iPosDrInfoObserver;
    }

    protected PosDrInfoObserverRouter(String str, IPosDrInfoObserver iPosDrInfoObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPosDrInfoObserver);
    }

    protected PosDrInfoObserverRouter(String str, IPosDrInfoObserver iPosDrInfoObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPosDrInfoObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.pos.observer.impl.IPosDrInfoObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.pos.observer.impl.IPosDrInfoObserverImpl
    public void onDrInfoUpdate(DrInfo drInfo) {
        IPosDrInfoObserver iPosDrInfoObserver = this.mObserver;
        if (iPosDrInfoObserver != null) {
            iPosDrInfoObserver.onDrInfoUpdate(drInfo);
        }
    }
}
