package com.xiaopeng.montecarlo.root.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes2.dex */
public class UiHandlerUtil extends Handler {
    private static final UiHandlerUtil sInstance = new UiHandlerUtil(Looper.getMainLooper());

    private UiHandlerUtil(Looper looper) {
        super(looper);
    }

    @NonNull
    public static UiHandlerUtil getInstance() {
        return sInstance;
    }

    @Override // android.os.Handler
    public boolean sendMessageAtTime(@Nullable Message message, long j) {
        if (message != null && message.getCallback() != null) {
            Message obtain = Message.obtain(message.getTarget(), new UiHandlerRunnable(message.getCallback()));
            obtain.what = message.what;
            obtain.arg1 = message.arg1;
            obtain.arg2 = message.arg2;
            obtain.obj = message.obj;
            obtain.replyTo = message.replyTo;
            obtain.setData(message.getData());
            return super.sendMessageAtTime(obtain, j);
        }
        return super.sendMessageAtTime(message, j);
    }

    public void runOnUiThread(Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            post(runnable);
        } else {
            runnable.run();
        }
    }

    /* loaded from: classes2.dex */
    static class UiHandlerRunnable implements Runnable {
        private static final L.Tag TAG = new L.Tag("UiHandlerRunnable");
        private Runnable mRunnable;
        private long mStartTime;
        private String mTag;

        UiHandlerRunnable(Runnable runnable) {
            this.mTag = "unknown";
            if (L.isLoggable()) {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                int length = stackTrace.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTrace[i];
                    String fileName = stackTraceElement.getFileName();
                    String className = stackTraceElement.getClassName();
                    if (!TextUtils.isEmpty(fileName) && !TextUtils.isEmpty(className) && !"UiHandlerUtil.java".equals(fileName) && className.startsWith("com.xiaopeng")) {
                        this.mTag = fileName + ":line:" + stackTraceElement.getLineNumber();
                        break;
                    }
                    i++;
                }
                this.mStartTime = System.currentTimeMillis();
            }
            this.mRunnable = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mRunnable != null) {
                TraceUtils.alwaysTraceBegin("UiHandlerRunnable:" + this.mTag);
                long currentTimeMillis = System.currentTimeMillis();
                this.mRunnable.run();
                if (L.isLoggable()) {
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    long j = currentTimeMillis - this.mStartTime;
                    if (currentTimeMillis2 > 200 || j > 200) {
                        L.Tag tag = TAG;
                        L.w(tag, this.mTag + "  wait before execute Time:" + j + "  runTime:" + currentTimeMillis2);
                    }
                }
                TraceUtils.alwaysTraceEnd();
            }
        }
    }
}
