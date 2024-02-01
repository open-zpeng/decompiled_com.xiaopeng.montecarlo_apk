package com.autonavi.gbl.data.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.data.observer.ILNDSGlobalFileUpdateObserver;
import com.autonavi.gbl.data.observer.impl.ILNDSGlobalFileUpdateObserverImpl;
import java.math.BigInteger;
@IntfAuto(target = ILNDSGlobalFileUpdateObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class LNDSGlobalFileUpdateObserverRouter extends ILNDSGlobalFileUpdateObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(LNDSGlobalFileUpdateObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(LNDSGlobalFileUpdateObserverRouter.class);
    private TypeHelper mHelper;
    private ILNDSGlobalFileUpdateObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, ILNDSGlobalFileUpdateObserver iLNDSGlobalFileUpdateObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ILNDSGlobalFileUpdateObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iLNDSGlobalFileUpdateObserver;
    }

    protected LNDSGlobalFileUpdateObserverRouter(String str, ILNDSGlobalFileUpdateObserver iLNDSGlobalFileUpdateObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLNDSGlobalFileUpdateObserver);
    }

    protected LNDSGlobalFileUpdateObserverRouter(String str, ILNDSGlobalFileUpdateObserver iLNDSGlobalFileUpdateObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLNDSGlobalFileUpdateObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.data.observer.impl.ILNDSGlobalFileUpdateObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.data.observer.impl.ILNDSGlobalFileUpdateObserverImpl
    public void onGlobalFileUpdate(BigInteger bigInteger, int i) {
        ILNDSGlobalFileUpdateObserver iLNDSGlobalFileUpdateObserver = this.mObserver;
        if (iLNDSGlobalFileUpdateObserver != null) {
            iLNDSGlobalFileUpdateObserver.onGlobalFileUpdate(bigInteger, i);
        }
    }

    @Override // com.autonavi.gbl.data.observer.impl.ILNDSGlobalFileUpdateObserverImpl
    public void onGlobalFileVersion(BigInteger bigInteger, String str) {
        ILNDSGlobalFileUpdateObserver iLNDSGlobalFileUpdateObserver = this.mObserver;
        if (iLNDSGlobalFileUpdateObserver != null) {
            iLNDSGlobalFileUpdateObserver.onGlobalFileVersion(bigInteger, str);
        }
    }

    @Override // com.autonavi.gbl.data.observer.impl.ILNDSGlobalFileUpdateObserverImpl
    public void onTileGlobalFileUpdate(BigInteger bigInteger, int i) {
        ILNDSGlobalFileUpdateObserver iLNDSGlobalFileUpdateObserver = this.mObserver;
        if (iLNDSGlobalFileUpdateObserver != null) {
            iLNDSGlobalFileUpdateObserver.onTileGlobalFileUpdate(bigInteger, i);
        }
    }
}
