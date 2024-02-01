package com.autonavi.gbl.ehp.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.ehp.observer.IGEhpAdasDataCallback;
import com.autonavi.gbl.ehp.observer.impl.IGEhpAdasDataCallbackImpl;
@IntfAuto(target = IGEhpAdasDataCallback.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class GEhpAdasDataCallbackRouter extends IGEhpAdasDataCallbackImpl {
    private static BindTable BIND_TABLE = new BindTable(GEhpAdasDataCallbackRouter.class);
    private static String PACKAGE = ReflexTool.PN(GEhpAdasDataCallbackRouter.class);
    private TypeHelper mHelper;
    private IGEhpAdasDataCallback mObserver;
    private String mTargetId;

    private void $constructor(String str, IGEhpAdasDataCallback iGEhpAdasDataCallback) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IGEhpAdasDataCallbackImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iGEhpAdasDataCallback;
    }

    protected GEhpAdasDataCallbackRouter(String str, IGEhpAdasDataCallback iGEhpAdasDataCallback, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGEhpAdasDataCallback);
    }

    protected GEhpAdasDataCallbackRouter(String str, IGEhpAdasDataCallback iGEhpAdasDataCallback) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGEhpAdasDataCallback);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.ehp.observer.impl.IGEhpAdasDataCallbackImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.ehp.observer.impl.IGEhpAdasDataCallbackImpl
    public void adasDataResponse(String str) {
        IGEhpAdasDataCallback iGEhpAdasDataCallback = this.mObserver;
        if (iGEhpAdasDataCallback != null) {
            iGEhpAdasDataCallback.adasDataResponse(str);
        }
    }
}
