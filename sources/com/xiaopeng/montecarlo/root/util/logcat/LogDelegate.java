package com.xiaopeng.montecarlo.root.util.logcat;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
/* loaded from: classes3.dex */
public class LogDelegate implements Handler.Callback, ILogDelegate {
    private static final long INTERVAL = 300000;
    private static final int MSG_UPLOAD = 1;
    private final LogCollector mCollector;
    private long mCurrentTimeMillis;
    private final Handler mH;
    private final HandlerThread mHandlerThread;
    private String mVersion;

    public LogDelegate(String str, String str2) {
        this.mCollector = new LogCollector(str);
        this.mCollector.init();
        this.mVersion = str2;
        this.mHandlerThread = new HandlerThread("LogDelegate");
        this.mHandlerThread.start();
        this.mH = new Handler(this.mHandlerThread.getLooper(), this);
    }

    @Override // com.xiaopeng.montecarlo.root.util.logcat.ILogDelegate
    public void dispatchMessage(LogMessage logMessage) {
        if (logMessage != null) {
            Message obtainMessage = this.mH.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = logMessage;
            this.mH.sendMessage(obtainMessage);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            LogMessage logMessage = (LogMessage) message.obj;
            if (System.currentTimeMillis() - this.mCurrentTimeMillis > 300000) {
                this.mCollector.saveMessage(logMessage.getFormatMessage(this.mVersion));
            } else {
                this.mCollector.saveMessage(logMessage.getFormatMessage());
            }
            this.mCurrentTimeMillis = System.currentTimeMillis();
        }
        return true;
    }

    @Override // com.xiaopeng.montecarlo.root.util.logcat.ILogDelegate
    public void release() {
        this.mH.removeMessages(1);
        this.mHandlerThread.quitSafely();
        this.mCollector.release();
    }
}
