package com.autonavi.gbl.servicemanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.autonavi.auto.bl.puglin.annotations.JniCallbackMethod;
import com.autonavi.auto.bl.puglin.annotations.JniField;
import com.autonavi.auto.bl.puglin.annotations.JniNativeMethod;
/* loaded from: classes2.dex */
public class BizTaskThread implements IRunTaskThread {
    private Handler mHandler;
    @JniField
    private int mId;

    /* JADX INFO: Access modifiers changed from: private */
    @JniNativeMethod(parameters = {"taskPtr"})
    public native void runBizTask(int i, long j);

    public BizTaskThread(int i, Looper looper) {
        this.mHandler = null;
        this.mId = i;
        this.mHandler = new Handler(looper) { // from class: com.autonavi.gbl.servicemanager.BizTaskThread.1
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
                if (l != null) {
                    BizTaskThread bizTaskThread = BizTaskThread.this;
                    bizTaskThread.runBizTask(bizTaskThread.mId, l.longValue());
                }
            }
        };
    }

    @Override // com.autonavi.gbl.servicemanager.IRunTaskThread
    @JniCallbackMethod(parameters = {"taskPrt", "delayMillis"})
    public void onPost(long j, long j2) {
        Handler handler = this.mHandler;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.obj = Long.valueOf(j);
            this.mHandler.sendMessageDelayed(obtainMessage, 0L);
        }
    }

    public void onClear() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }
}
