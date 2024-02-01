package com.autonavi.gbl.activation.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.activation.model.AuthenticationGoodsInfo;
import com.autonavi.gbl.activation.model.AuthenticationResult;
import com.autonavi.gbl.activation.observer.IAuthenticationObserver;
import com.autonavi.gbl.activation.observer.impl.IAuthenticationObserverImpl;
import java.util.ArrayList;
@IntfAuto(target = IAuthenticationObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class AuthenticationObserverRouter extends IAuthenticationObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(AuthenticationObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(AuthenticationObserverRouter.class);
    private TypeHelper mHelper;
    private IAuthenticationObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IAuthenticationObserver iAuthenticationObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IAuthenticationObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iAuthenticationObserver;
    }

    protected AuthenticationObserverRouter(String str, IAuthenticationObserver iAuthenticationObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iAuthenticationObserver);
    }

    protected AuthenticationObserverRouter(String str, IAuthenticationObserver iAuthenticationObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iAuthenticationObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.activation.observer.impl.IAuthenticationObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.activation.observer.impl.IAuthenticationObserverImpl
    public void onStatusUpdated(int i, ArrayList<AuthenticationGoodsInfo> arrayList) {
        IAuthenticationObserver iAuthenticationObserver = this.mObserver;
        if (iAuthenticationObserver != null) {
            iAuthenticationObserver.onStatusUpdated(i, arrayList);
        }
    }

    @Override // com.autonavi.gbl.activation.observer.impl.IAuthenticationObserverImpl
    public void onError(AuthenticationResult authenticationResult) {
        IAuthenticationObserver iAuthenticationObserver = this.mObserver;
        if (iAuthenticationObserver != null) {
            iAuthenticationObserver.onError(authenticationResult);
        }
    }
}
