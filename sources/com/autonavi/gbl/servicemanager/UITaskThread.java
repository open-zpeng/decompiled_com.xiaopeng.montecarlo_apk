package com.autonavi.gbl.servicemanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.autonavi.auto.bl.puglin.annotations.JniCallbackMethod;
import com.autonavi.auto.bl.puglin.annotations.JniField;
import com.autonavi.auto.bl.puglin.annotations.JniNativeMethod;
import com.autonavi.auto.util.LogUtils;
import com.xiaopeng.speech.vui.constants.VuiConstants;
/* loaded from: classes2.dex */
public class UITaskThread implements IUITaskThread {
    private Handler mHandler;
    private int mId;
    @JniField
    private long ptr;

    /* JADX INFO: Access modifiers changed from: private */
    @JniNativeMethod(parameters = {VuiConstants.ELEMENT_ID, "taskPtr"})
    public native void runTask(int i, long j);

    public UITaskThread(int i, Looper looper) {
        this.mHandler = null;
        this.mId = i;
        this.mHandler = new Handler(looper) { // from class: com.autonavi.gbl.servicemanager.UITaskThread.1
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
                LogUtils.d("UITaskThread dispatchMessage ptr = " + Long.toHexString(UITaskThread.this.ptr) + ", taskPrt = " + Long.toHexString(l.longValue()) + ", thread =" + Thread.currentThread().getId());
                if (UITaskThread.this.ptr == 0 || l == null) {
                    return;
                }
                LogUtils.d("UITaskThread runTask taskPrt = 0x" + Long.toHexString(l.longValue()));
                UITaskThread uITaskThread = UITaskThread.this;
                uITaskThread.runTask(uITaskThread.mId, l.longValue());
            }
        };
    }

    @Override // com.autonavi.gbl.servicemanager.IUITaskThread
    @JniCallbackMethod(parameters = {"taskPrt", "delayMillis"})
    public void onPost(long j, long j2) {
        LogUtils.d("UITaskThread onPost taskPrt = " + j + ", 0x " + Long.toHexString(j) + " delayMillis = " + j2 + ", thread =" + Thread.currentThread().getId());
        Handler handler = this.mHandler;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.obj = Long.valueOf(j);
            this.mHandler.sendMessageDelayed(obtainMessage, 0L);
            return;
        }
        LogUtils.e("onPost mHandler = null ");
    }

    public void onClear() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        } else {
            LogUtils.e("onClear mHandler = null ");
        }
    }
}
