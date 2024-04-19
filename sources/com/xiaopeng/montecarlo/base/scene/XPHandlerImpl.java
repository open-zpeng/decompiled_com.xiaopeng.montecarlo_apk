package com.xiaopeng.montecarlo.base.scene;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes2.dex */
public final class XPHandlerImpl implements IXPHandler {
    private Handler.Callback mCallback;
    private final Handler mHandler;
    private HandlerThread mHandlerThread;
    private IXPHandlerReceiver mXPHandlerReceiver;

    /* JADX INFO: Access modifiers changed from: package-private */
    public XPHandlerImpl() {
        this.mCallback = new Handler.Callback() { // from class: com.xiaopeng.montecarlo.base.scene.XPHandlerImpl.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (XPHandlerImpl.this.mXPHandlerReceiver != null) {
                    XPHandlerImpl.this.mXPHandlerReceiver.handleMessage(message.what, message.arg1, message.arg2, message.obj, message.getData());
                    return true;
                }
                return true;
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper(), this.mCallback);
        this.mHandlerThread = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XPHandlerImpl(String str) {
        this.mCallback = new Handler.Callback() { // from class: com.xiaopeng.montecarlo.base.scene.XPHandlerImpl.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (XPHandlerImpl.this.mXPHandlerReceiver != null) {
                    XPHandlerImpl.this.mXPHandlerReceiver.handleMessage(message.what, message.arg1, message.arg2, message.obj, message.getData());
                    return true;
                }
                return true;
            }
        };
        this.mHandlerThread = new HandlerThread(str);
        this.mHandlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper(), this.mCallback);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IXPHandler
    public void setXPHandlerReceiver(IXPHandlerReceiver iXPHandlerReceiver) {
        this.mXPHandlerReceiver = iXPHandlerReceiver;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IXPHandler
    public void sendMessage(Message message) {
        this.mHandler.sendMessage(message);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IXPHandler
    public void sendMessageDelay(Message message, long j) {
        this.mHandler.sendMessageDelayed(message, j);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IXPHandler
    public Message obtainMessage(int i) {
        return this.mHandler.obtainMessage(i);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IXPHandler
    public Message obtainMessage(int i, Object obj) {
        return this.mHandler.obtainMessage(i, obj);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IXPHandler
    public Message obtainMessage(int i, int i2, int i3) {
        return this.mHandler.obtainMessage(i, i2, i3);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IXPHandler
    public Message obtainMessage(int i, int i2, int i3, Object obj) {
        return this.mHandler.obtainMessage(i, i2, i3, obj);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IXPHandler
    public void removeCallbacksAndMessages(Object obj) {
        this.mHandler.removeCallbacksAndMessages(obj);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IXPHandler
    public void removeCallbacks(Runnable runnable) {
        this.mHandler.removeCallbacks(runnable);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IXPHandler
    public boolean postAtTime(Runnable runnable, Object obj, long j) {
        return this.mHandler.postAtTime(runnable, obj, j);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IXPHandler
    public void quitThread() {
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread != null) {
            handlerThread.quit();
            this.mHandlerThread = null;
        }
    }
}
