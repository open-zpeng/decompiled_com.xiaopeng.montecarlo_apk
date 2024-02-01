package com.autonavi.gbl.util.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.util.observer.IJniExceptionObserver;
import com.autonavi.gbl.util.observer.impl.IJniExceptionObserverImpl;
@IntfAuto(target = IJniExceptionObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class JniExceptionObserverRouter extends IJniExceptionObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(JniExceptionObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(JniExceptionObserverRouter.class);
    private TypeHelper mHelper;
    private IJniExceptionObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IJniExceptionObserver iJniExceptionObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IJniExceptionObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iJniExceptionObserver;
    }

    protected JniExceptionObserverRouter(String str, IJniExceptionObserver iJniExceptionObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iJniExceptionObserver);
    }

    protected JniExceptionObserverRouter(String str, IJniExceptionObserver iJniExceptionObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iJniExceptionObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.util.observer.impl.IJniExceptionObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.util.observer.impl.IJniExceptionObserverImpl
    public void onException(String str) {
        IJniExceptionObserver iJniExceptionObserver = this.mObserver;
        if (iJniExceptionObserver != null) {
            iJniExceptionObserver.onException(str);
        }
    }
}
