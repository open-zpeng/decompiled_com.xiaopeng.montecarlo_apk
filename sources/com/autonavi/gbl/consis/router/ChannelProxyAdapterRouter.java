package com.autonavi.gbl.consis.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.consis.observer.ChannelProxyAdapter;
import com.autonavi.gbl.consis.observer.IChannelProxyAdapter;
import com.autonavi.gbl.consis.observer.impl.IChannelProxyAdapterImpl;
@IntfAuto(target = ChannelProxyAdapter.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class ChannelProxyAdapterRouter extends IChannelProxyAdapterImpl {
    private static BindTable BIND_TABLE = new BindTable(ChannelProxyAdapterRouter.class);
    private static String PACKAGE = ReflexTool.PN(ChannelProxyAdapterRouter.class);
    private TypeHelper mHelper;
    private IChannelProxyAdapter mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IChannelProxyAdapter iChannelProxyAdapter) {
        if (iChannelProxyAdapter != null) {
            this.mObserver = iChannelProxyAdapter;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(ChannelProxyAdapter.class, iChannelProxyAdapter, this);
            }
        }
    }

    private void $constructor(String str, IChannelProxyAdapter iChannelProxyAdapter) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IChannelProxyAdapterImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iChannelProxyAdapter);
    }

    public ChannelProxyAdapterRouter(String str, IChannelProxyAdapter iChannelProxyAdapter, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iChannelProxyAdapter);
    }

    public ChannelProxyAdapterRouter(String str, IChannelProxyAdapter iChannelProxyAdapter) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iChannelProxyAdapter);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.consis.observer.impl.IChannelProxyAdapterImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.consis.observer.impl.IChannelProxyAdapterImpl
    public long writeData(byte[] bArr) {
        IChannelProxyAdapter iChannelProxyAdapter = this.mObserver;
        if (iChannelProxyAdapter != null) {
            return iChannelProxyAdapter.writeData(bArr);
        }
        return 0L;
    }
}
