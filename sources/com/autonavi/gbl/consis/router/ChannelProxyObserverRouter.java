package com.autonavi.gbl.consis.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.consis.observer.IChannelProxyObserver;
import com.autonavi.gbl.consis.observer.impl.IChannelProxyObserverImpl;
@IntfAuto(target = IChannelProxyObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class ChannelProxyObserverRouter extends IChannelProxyObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ChannelProxyObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(ChannelProxyObserverRouter.class);
    private TypeHelper mHelper;
    private IChannelProxyObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IChannelProxyObserver iChannelProxyObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IChannelProxyObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iChannelProxyObserver;
    }

    protected ChannelProxyObserverRouter(String str, IChannelProxyObserver iChannelProxyObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iChannelProxyObserver);
    }

    protected ChannelProxyObserverRouter(String str, IChannelProxyObserver iChannelProxyObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iChannelProxyObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.consis.observer.impl.IChannelProxyObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.consis.observer.impl.IChannelProxyObserverImpl
    public void onChannelProxyConnect(String str) {
        IChannelProxyObserver iChannelProxyObserver = this.mObserver;
        if (iChannelProxyObserver != null) {
            iChannelProxyObserver.onChannelProxyConnect(str);
        }
    }

    @Override // com.autonavi.gbl.consis.observer.impl.IChannelProxyObserverImpl
    public void onChannelProxyDisconnect(String str) {
        IChannelProxyObserver iChannelProxyObserver = this.mObserver;
        if (iChannelProxyObserver != null) {
            iChannelProxyObserver.onChannelProxyDisconnect(str);
        }
    }
}
