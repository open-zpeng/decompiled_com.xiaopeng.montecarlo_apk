package com.autonavi.gbl.data.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.data.model.LndsSourceDataType;
import com.autonavi.gbl.data.observer.ILndsDataDeleteObserver;
import com.autonavi.gbl.data.observer.impl.ILndsDataDeleteObserverImpl;
@IntfAuto(target = ILndsDataDeleteObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class LndsDataDeleteObserverRouter extends ILndsDataDeleteObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(LndsDataDeleteObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(LndsDataDeleteObserverRouter.class);
    private TypeHelper mHelper;
    private ILndsDataDeleteObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, ILndsDataDeleteObserver iLndsDataDeleteObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ILndsDataDeleteObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iLndsDataDeleteObserver;
    }

    protected LndsDataDeleteObserverRouter(String str, ILndsDataDeleteObserver iLndsDataDeleteObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLndsDataDeleteObserver);
    }

    protected LndsDataDeleteObserverRouter(String str, ILndsDataDeleteObserver iLndsDataDeleteObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLndsDataDeleteObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.router.LndsDataDeleteObserverRouter.1
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
    @Override // com.autonavi.gbl.data.observer.impl.ILndsDataDeleteObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.router.LndsDataDeleteObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.data.observer.impl.ILndsDataDeleteObserverImpl
    public void beforeDataDelete(int i, @LndsSourceDataType.LndsSourceDataType1 int i2) {
        ILndsDataDeleteObserver iLndsDataDeleteObserver = this.mObserver;
        if (iLndsDataDeleteObserver != null) {
            iLndsDataDeleteObserver.beforeDataDelete(i, i2);
        }
    }

    @Override // com.autonavi.gbl.data.observer.impl.ILndsDataDeleteObserverImpl
    public void afterDataDelete(int i, @LndsSourceDataType.LndsSourceDataType1 int i2) {
        ILndsDataDeleteObserver iLndsDataDeleteObserver = this.mObserver;
        if (iLndsDataDeleteObserver != null) {
            iLndsDataDeleteObserver.afterDataDelete(i, i2);
        }
    }
}
