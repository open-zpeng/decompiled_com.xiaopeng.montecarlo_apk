package com.autonavi.gbl.data.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.data.model.LNDSNearCityInfo;
import com.autonavi.gbl.data.model.LNDS_NETWORK_ERROR;
import com.autonavi.gbl.data.observer.ILNDSNearCityListObserver;
import com.autonavi.gbl.data.observer.impl.ILNDSNearCityListObserverImpl;
import java.math.BigInteger;
import java.util.ArrayList;
@IntfAuto(target = ILNDSNearCityListObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class LNDSNearCityListObserverRouter extends ILNDSNearCityListObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(LNDSNearCityListObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(LNDSNearCityListObserverRouter.class);
    private TypeHelper mHelper;
    private ILNDSNearCityListObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, ILNDSNearCityListObserver iLNDSNearCityListObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ILNDSNearCityListObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iLNDSNearCityListObserver;
    }

    protected LNDSNearCityListObserverRouter(String str, ILNDSNearCityListObserver iLNDSNearCityListObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLNDSNearCityListObserver);
    }

    protected LNDSNearCityListObserverRouter(String str, ILNDSNearCityListObserver iLNDSNearCityListObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLNDSNearCityListObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.router.LNDSNearCityListObserverRouter.1
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
    @Override // com.autonavi.gbl.data.observer.impl.ILNDSNearCityListObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.router.LNDSNearCityListObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.data.observer.impl.ILNDSNearCityListObserverImpl
    public boolean onNearCityRequestSuccess(BigInteger bigInteger, ArrayList<LNDSNearCityInfo> arrayList) {
        ILNDSNearCityListObserver iLNDSNearCityListObserver = this.mObserver;
        if (iLNDSNearCityListObserver != null) {
            return iLNDSNearCityListObserver.onNearCityRequestSuccess(bigInteger, arrayList);
        }
        return false;
    }

    @Override // com.autonavi.gbl.data.observer.impl.ILNDSNearCityListObserverImpl
    public boolean onNearCityRequestError(BigInteger bigInteger, @LNDS_NETWORK_ERROR.LNDS_NETWORK_ERROR1 int i) {
        ILNDSNearCityListObserver iLNDSNearCityListObserver = this.mObserver;
        if (iLNDSNearCityListObserver != null) {
            return iLNDSNearCityListObserver.onNearCityRequestError(bigInteger, i);
        }
        return false;
    }
}
