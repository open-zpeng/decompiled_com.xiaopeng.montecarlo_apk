package com.xiaopeng.montecarlo.base.scene;

import android.os.Message;
/* loaded from: classes.dex */
public interface IXPHandler {
    Message obtainMessage(int i);

    Message obtainMessage(int i, int i2, int i3);

    Message obtainMessage(int i, int i2, int i3, Object obj);

    Message obtainMessage(int i, Object obj);

    boolean postAtTime(Runnable runnable, Object obj, long j);

    void quitThread();

    void removeCallbacks(Runnable runnable);

    void removeCallbacksAndMessages(Object obj);

    void sendMessage(Message message);

    void sendMessageDelay(Message message, long j);

    void setXPHandlerReceiver(IXPHandlerReceiver iXPHandlerReceiver);
}
