package com.autonavi.gbl.consis.observer;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.consis.observer.impl.IChannelProxyAdapterImpl;
import com.autonavi.gbl.consis.router.ChannelProxyAdapterRouter;
@IntfAuto(target = ChannelProxyAdapterRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class ChannelProxyAdapter implements IChannelProxyAdapter {
    private static String PACKAGE = ReflexTool.PN(ChannelProxyAdapter.class);
    private boolean mHasDestroy;
    private IChannelProxyAdapterImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected ChannelProxyAdapter(long j, boolean z) {
        this(new ChannelProxyAdapterRouter("ChannelProxyAdapter", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IChannelProxyAdapter.class}, new Object[]{this});
    }

    public ChannelProxyAdapter() {
        this(new ChannelProxyAdapterRouter("ChannelProxyAdapter", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IChannelProxyAdapter.class}, new Object[]{this});
    }

    public ChannelProxyAdapter(IChannelProxyAdapterImpl iChannelProxyAdapterImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(iChannelProxyAdapterImpl);
    }

    private void $constructor(IChannelProxyAdapterImpl iChannelProxyAdapterImpl) {
        if (iChannelProxyAdapterImpl != null) {
            this.mService = iChannelProxyAdapterImpl;
            this.mTargetId = String.format("ChannelProxyAdapter_%s_%d", String.valueOf(IChannelProxyAdapterImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IChannelProxyAdapterImpl getService() {
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

    @Override // com.autonavi.gbl.consis.observer.IChannelProxyAdapter
    public long writeData(byte[] bArr) {
        IChannelProxyAdapterImpl iChannelProxyAdapterImpl = this.mService;
        if (iChannelProxyAdapterImpl == null || iChannelProxyAdapterImpl.isCMemOwn()) {
            return 0L;
        }
        return this.mService.$explicit_writeData(bArr);
    }
}
