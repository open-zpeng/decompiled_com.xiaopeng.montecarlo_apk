package com.autonavi.gbl.map;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.impl.MixtureSharedBaseImpl;
import com.autonavi.gbl.map.observer.IMixtureSharedBase;
import com.autonavi.gbl.map.router.MixtureSharedBaseRouter;
@IntfAuto(target = MixtureSharedBaseRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class MixtureSharedBase implements IMixtureSharedBase {
    private static String PACKAGE = ReflexTool.PN(MixtureSharedBase.class);
    private boolean mHasDestroy;
    private MixtureSharedBaseImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected MixtureSharedBase(long j, boolean z) {
        this(new MixtureSharedBaseRouter("MixtureSharedBase", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IMixtureSharedBase.class}, new Object[]{this});
    }

    protected MixtureSharedBase() {
        this(new MixtureSharedBaseRouter("MixtureSharedBase", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IMixtureSharedBase.class}, new Object[]{this});
    }

    public MixtureSharedBase(MixtureSharedBaseImpl mixtureSharedBaseImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(mixtureSharedBaseImpl);
    }

    private void $constructor(MixtureSharedBaseImpl mixtureSharedBaseImpl) {
        if (mixtureSharedBaseImpl != null) {
            this.mService = mixtureSharedBaseImpl;
            this.mTargetId = String.format("MixtureSharedBase_%s_%d", String.valueOf(MixtureSharedBaseImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected MixtureSharedBaseImpl getService() {
        return this.mService;
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    public synchronized void delete() {
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mService != null) {
            if (this.mTypeHelper != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                TypeHelper.unbindAllTarget(ReflexTool.PN(this.mService.getClass()), this.mService);
            }
            ReflexTool.invokeDeclMethodSafe(this.mService, RequestParameters.SUBRESOURCE_DELETE, null, null);
            this.mService = null;
        }
        unbind();
    }
}
