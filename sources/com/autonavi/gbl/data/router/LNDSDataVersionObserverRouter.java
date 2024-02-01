package com.autonavi.gbl.data.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.data.model.LndsNetWorkError;
import com.autonavi.gbl.data.observer.ILNDSDataVersionObserver;
import com.autonavi.gbl.data.observer.impl.ILNDSDataVersionObserverImpl;
import java.math.BigInteger;
@IntfAuto(target = ILNDSDataVersionObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class LNDSDataVersionObserverRouter extends ILNDSDataVersionObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(LNDSDataVersionObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(LNDSDataVersionObserverRouter.class);
    private TypeHelper mHelper;
    private ILNDSDataVersionObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, ILNDSDataVersionObserver iLNDSDataVersionObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ILNDSDataVersionObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iLNDSDataVersionObserver;
    }

    protected LNDSDataVersionObserverRouter(String str, ILNDSDataVersionObserver iLNDSDataVersionObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLNDSDataVersionObserver);
    }

    protected LNDSDataVersionObserverRouter(String str, ILNDSDataVersionObserver iLNDSDataVersionObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLNDSDataVersionObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.data.observer.impl.ILNDSDataVersionObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.data.observer.impl.ILNDSDataVersionObserverImpl
    public void onLNDSDataVersion(BigInteger bigInteger, @LndsNetWorkError.LndsNetWorkError1 int i, String str) {
        ILNDSDataVersionObserver iLNDSDataVersionObserver = this.mObserver;
        if (iLNDSDataVersionObserver != null) {
            iLNDSDataVersionObserver.onLNDSDataVersion(bigInteger, i, str);
        }
    }
}
