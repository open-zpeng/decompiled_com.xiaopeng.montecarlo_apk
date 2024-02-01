package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.MixtureSharedBase;
import com.autonavi.gbl.map.impl.MixtureSharedBaseImpl;
import com.autonavi.gbl.map.observer.IMixtureSharedBase;
@IntfAuto(target = MixtureSharedBase.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class MixtureSharedBaseRouter extends MixtureSharedBaseImpl {
    private static BindTable BIND_TABLE = new BindTable(MixtureSharedBaseRouter.class);
    private static String PACKAGE = ReflexTool.PN(MixtureSharedBaseRouter.class);
    private TypeHelper mHelper;
    private IMixtureSharedBase mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IMixtureSharedBase iMixtureSharedBase) {
        if (iMixtureSharedBase != null) {
            this.mObserver = iMixtureSharedBase;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(MixtureSharedBase.class, iMixtureSharedBase, this);
            }
        }
    }

    private void $constructor(String str, IMixtureSharedBase iMixtureSharedBase) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(MixtureSharedBaseImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iMixtureSharedBase);
    }

    public MixtureSharedBaseRouter(String str, IMixtureSharedBase iMixtureSharedBase, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMixtureSharedBase);
    }

    public MixtureSharedBaseRouter(String str, IMixtureSharedBase iMixtureSharedBase) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMixtureSharedBase);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }
}
