package com.autonavi.gbl.ehp.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.ehp.observer.IEHPOutputObserver;
import com.autonavi.gbl.ehp.observer.impl.IEHPOutputObserverImpl;
@IntfAuto(target = IEHPOutputObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class EHPOutputObserverRouter extends IEHPOutputObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(EHPOutputObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(EHPOutputObserverRouter.class);
    private TypeHelper mHelper;
    private IEHPOutputObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IEHPOutputObserver iEHPOutputObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IEHPOutputObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iEHPOutputObserver;
    }

    protected EHPOutputObserverRouter(String str, IEHPOutputObserver iEHPOutputObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iEHPOutputObserver);
    }

    protected EHPOutputObserverRouter(String str, IEHPOutputObserver iEHPOutputObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iEHPOutputObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.ehp.router.EHPOutputObserverRouter.1
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
    @Override // com.autonavi.gbl.ehp.observer.impl.IEHPOutputObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.ehp.router.EHPOutputObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.ehp.observer.impl.IEHPOutputObserverImpl
    public void output(String str, byte[] bArr) {
        IEHPOutputObserver iEHPOutputObserver = this.mObserver;
        if (iEHPOutputObserver != null) {
            iEHPOutputObserver.output(str, bArr);
        }
    }
}
