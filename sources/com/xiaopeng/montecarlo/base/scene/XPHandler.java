package com.xiaopeng.montecarlo.base.scene;

import android.os.Message;
/* loaded from: classes2.dex */
public class XPHandler {
    private IXPHandler mXPHandlerProxy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public XPHandler(IXPHandler iXPHandler) {
        this(iXPHandler, null);
    }

    XPHandler(IXPHandler iXPHandler, String str) {
        this.mXPHandlerProxy = iXPHandler;
    }

    public void setXPHandlerReceiver(IXPHandlerReceiver iXPHandlerReceiver) {
        this.mXPHandlerProxy.setXPHandlerReceiver(iXPHandlerReceiver);
    }

    public void sendMessage(Message message) {
        this.mXPHandlerProxy.sendMessage(message);
    }

    public void sendMessageDelay(Message message, long j) {
        this.mXPHandlerProxy.sendMessageDelay(message, j);
    }

    public Message obtainMessage(int i) {
        return this.mXPHandlerProxy.obtainMessage(i);
    }

    public Message obtainMessage(int i, Object obj) {
        return this.mXPHandlerProxy.obtainMessage(i, obj);
    }

    public Message obtainMessage(int i, int i2, int i3) {
        return this.mXPHandlerProxy.obtainMessage(i, i2, i3);
    }

    public Message obtainMessage(int i, int i2, int i3, Object obj) {
        return this.mXPHandlerProxy.obtainMessage(i, i2, i3, obj);
    }

    public void removeCallbacksAndMessages(Object obj) {
        this.mXPHandlerProxy.removeCallbacksAndMessages(obj);
    }

    public void removeCallbacks(Runnable runnable) {
        this.mXPHandlerProxy.removeCallbacks(runnable);
    }

    public boolean postAtTime(Runnable runnable, Object obj, long j) {
        return this.mXPHandlerProxy.postAtTime(runnable, obj, j);
    }

    public void quitThread() {
        this.mXPHandlerProxy.quitThread();
    }
}
