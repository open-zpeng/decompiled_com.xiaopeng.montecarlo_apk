package com.autonavi.gbl.consis.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.consis.observer.IChannelObserver;
import com.autonavi.gbl.consis.observer.impl.IChannelObserverImpl;
@IntfAuto(target = IChannelObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class ChannelObserverRouter extends IChannelObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ChannelObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(ChannelObserverRouter.class);
    private TypeHelper mHelper;
    private IChannelObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IChannelObserver iChannelObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IChannelObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iChannelObserver;
    }

    protected ChannelObserverRouter(String str, IChannelObserver iChannelObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iChannelObserver);
    }

    protected ChannelObserverRouter(String str, IChannelObserver iChannelObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iChannelObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.consis.observer.impl.IChannelObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.consis.observer.impl.IChannelObserverImpl
    public void onChannelCreate(String str, String str2) {
        IChannelObserver iChannelObserver = this.mObserver;
        if (iChannelObserver != null) {
            iChannelObserver.onChannelCreate(str, str2);
        }
    }

    @Override // com.autonavi.gbl.consis.observer.impl.IChannelObserverImpl
    public void onChannelDestroy(String str, String str2) {
        IChannelObserver iChannelObserver = this.mObserver;
        if (iChannelObserver != null) {
            iChannelObserver.onChannelDestroy(str, str2);
        }
    }
}
