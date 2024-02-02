package com.xiaopeng.montecarlo.base.scene;
/* loaded from: classes2.dex */
public final class XPBroadcast {
    private final IXPBroadcast mXPBroadcastProxy;

    public XPBroadcast(IXPBroadcast iXPBroadcast) {
        this.mXPBroadcastProxy = iXPBroadcast;
    }

    public void register() {
        this.mXPBroadcastProxy.register();
    }

    public void unregister() {
        this.mXPBroadcastProxy.unregister();
    }

    public void setReceiver(IXPBroadcastReceiver iXPBroadcastReceiver) {
        this.mXPBroadcastProxy.setReceiver(iXPBroadcastReceiver);
    }
}
