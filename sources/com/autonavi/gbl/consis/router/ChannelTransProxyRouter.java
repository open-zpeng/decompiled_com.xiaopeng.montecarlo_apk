package com.autonavi.gbl.consis.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.consis.observer.ChannelTransProxy;
import com.autonavi.gbl.consis.observer.IChannelTransProxy;
import com.autonavi.gbl.consis.observer.impl.IChannelTransProxyImpl;
@IntfAuto(target = ChannelTransProxy.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class ChannelTransProxyRouter extends IChannelTransProxyImpl {
    private static BindTable BIND_TABLE = new BindTable(ChannelTransProxyRouter.class);
    private static String PACKAGE = ReflexTool.PN(ChannelTransProxyRouter.class);
    private TypeHelper mHelper;
    private IChannelTransProxy mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IChannelTransProxy iChannelTransProxy) {
        if (iChannelTransProxy != null) {
            this.mObserver = iChannelTransProxy;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(ChannelTransProxy.class, iChannelTransProxy, this);
            }
        }
    }

    private void $constructor(String str, IChannelTransProxy iChannelTransProxy) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IChannelTransProxyImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iChannelTransProxy);
    }

    public ChannelTransProxyRouter(String str, IChannelTransProxy iChannelTransProxy, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iChannelTransProxy);
    }

    public ChannelTransProxyRouter(String str, IChannelTransProxy iChannelTransProxy) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iChannelTransProxy);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.consis.router.ChannelTransProxyRouter.1
        });
        objArr[1] = String.valueOf(this.mHelper != null);
        DebugTool.d("%s: mHelper=%s", objArr);
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.consis.observer.impl.IChannelTransProxyImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.consis.router.ChannelTransProxyRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.consis.observer.impl.IChannelTransProxyImpl
    public long writeData(long j, long j2) {
        IChannelTransProxy iChannelTransProxy = this.mObserver;
        if (iChannelTransProxy != null) {
            return iChannelTransProxy.writeData(j, j2);
        }
        return 0L;
    }
}
