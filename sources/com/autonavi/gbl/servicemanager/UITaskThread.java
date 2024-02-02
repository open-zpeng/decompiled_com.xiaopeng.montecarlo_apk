package com.autonavi.gbl.servicemanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.autonavi.auto.bl.puglin.annotations.JniCallbackMethod;
import com.autonavi.auto.bl.puglin.annotations.JniField;
import com.autonavi.auto.bl.puglin.annotations.JniNativeMethod;
/* loaded from: classes2.dex */
public class UITaskThread implements IUITaskThread {
    private Handler mainHandler = new Handler(Looper.getMainLooper()) { // from class: com.autonavi.gbl.servicemanager.UITaskThread.1
        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            if (message == null) {
                return;
            }
            super.dispatchMessage(message);
            Long l = new Long(0L);
            if (message != null && message.obj != null) {
                l = (Long) message.obj;
            }
            if (UITaskThread.this.ptr == 0 || l == null) {
                return;
            }
            UITaskThread.this.runTask(l.longValue());
        }
    };
    @JniField
    private long ptr;

    /* JADX INFO: Access modifiers changed from: private */
    @JniNativeMethod(parameters = {"taskPtr"})
    public native void runTask(long j);

    @Override // com.autonavi.gbl.servicemanager.IUITaskThread
    @JniCallbackMethod(parameters = {"taskPrt", "delayMillis"})
    public void onPost(long j, long j2) {
        Message obtainMessage = this.mainHandler.obtainMessage();
        obtainMessage.obj = Long.valueOf(j);
        this.mainHandler.sendMessageDelayed(obtainMessage, 0L);
    }

    public void onClear() {
        this.mainHandler.removeCallbacksAndMessages(null);
    }
}
