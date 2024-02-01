package com.xiaopeng.montecarlo.base.scene;
/* loaded from: classes.dex */
public interface IXPBroadcast {
    void register();

    void setReceiver(IXPBroadcastReceiver iXPBroadcastReceiver);

    void unregister();
}
