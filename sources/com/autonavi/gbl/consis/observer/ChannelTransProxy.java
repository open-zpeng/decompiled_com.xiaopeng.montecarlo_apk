package com.autonavi.gbl.consis.observer;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.consis.observer.impl.IChannelTransProxyImpl;
import com.autonavi.gbl.consis.router.ChannelTransProxyRouter;
@IntfAuto(target = ChannelTransProxyRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class ChannelTransProxy implements IChannelTransProxy {
    private static String PACKAGE = ReflexTool.PN(ChannelTransProxy.class);
    private boolean mHasDestroy;
    private IChannelTransProxyImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected ChannelTransProxy(long j, boolean z) {
        this(new ChannelTransProxyRouter("ChannelTransProxy", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IChannelTransProxy.class}, new Object[]{this});
    }

    public ChannelTransProxy() {
        this(new ChannelTransProxyRouter("ChannelTransProxy", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IChannelTransProxy.class}, new Object[]{this});
    }

    public ChannelTransProxy(IChannelTransProxyImpl iChannelTransProxyImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(iChannelTransProxyImpl);
    }

    private void $constructor(IChannelTransProxyImpl iChannelTransProxyImpl) {
        if (iChannelTransProxyImpl != null) {
            this.mService = iChannelTransProxyImpl;
            this.mTargetId = String.format("ChannelTransProxy_%s_%d", String.valueOf(IChannelTransProxyImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    public IChannelTransProxyImpl getService() {
        return this.mService;
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.consis.observer.ChannelTransProxy.1
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    protected void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.consis.observer.ChannelTransProxy.2
        }));
    }

    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    public synchronized void delete() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.consis.observer.ChannelTransProxy.3
        });
        objArr[1] = String.valueOf(this.mService != null);
        DebugTool.d("%s: mService=%s", objArr);
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

    @Override // com.autonavi.gbl.consis.observer.IChannelTransProxy
    public long writeData(long j, long j2) {
        IChannelTransProxyImpl iChannelTransProxyImpl = this.mService;
        if (iChannelTransProxyImpl != null) {
            return iChannelTransProxyImpl.$explicit_writeData(j, j2);
        }
        return 0L;
    }
}
