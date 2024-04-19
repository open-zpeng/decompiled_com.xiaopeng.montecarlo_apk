package com.xiaopeng.montecarlo.navcore.sr;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.xiaopeng.montecarlo.navcore.sr.mock.BaseProtoSender;
import com.xiaopeng.montecarlo.navcore.sr.mock.NaviProtoSender;
import com.xiaopeng.montecarlo.navcore.sr.mock.ProtoFileReader;
import com.xiaopeng.montecarlo.navcore.sr.mock.XpuProtoSender;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import java.io.File;
import xpilot.sr.proto.Overall;
/* loaded from: classes3.dex */
public class ProtoSimulator implements Handler.Callback {
    private static final int MSG_PAUSE = 3;
    public static final int MSG_RESUME = 2;
    private static final int MSG_SEEK_TO = 4;
    private static final int MSG_START = 1;
    private static final L.Tag TAG = new L.Tag("ProtoSimulator");
    private Handler mHandler;
    private boolean mIsRunning;
    private ProgressListener mProgressListener;
    private final ProtoFileReader mProtoFileReader;
    private BaseProtoSender mProtoSender;
    private HandlerThread mProtoSimulatorThread;

    /* loaded from: classes3.dex */
    public interface ProgressListener {
        void onProgressChanged(int i);

        void onRelayTimeChange(long j);
    }

    private ProtoSimulator() {
        this.mIsRunning = false;
        this.mProtoFileReader = new ProtoFileReader();
    }

    public void startModify(boolean z) {
        BaseProtoSender baseProtoSender = this.mProtoSender;
        if (baseProtoSender != null) {
            baseProtoSender.startModify(z);
        }
    }

    public void modifyRd(int i, int i2) {
        BaseProtoSender baseProtoSender = this.mProtoSender;
        if (baseProtoSender != null) {
            baseProtoSender.modifyRd(i, i2);
        }
    }

    public void modifySm(int i, int i2) {
        BaseProtoSender baseProtoSender = this.mProtoSender;
        if (baseProtoSender != null) {
            baseProtoSender.modifySm(i, i2);
        }
    }

    public void modifyDisplaySt(int i) {
        BaseProtoSender baseProtoSender = this.mProtoSender;
        if (baseProtoSender != null) {
            baseProtoSender.modifyDisplaySt(i);
        }
    }

    /* loaded from: classes3.dex */
    private static class LazyHolder {
        private static final ProtoSimulator INSTANCE = new ProtoSimulator();

        private LazyHolder() {
        }
    }

    public static ProtoSimulator getInstance() {
        return LazyHolder.INSTANCE;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            readProtoData();
            return false;
        } else if (i == 2) {
            nextFrame();
            return false;
        } else if (i == 3) {
            pause();
            return false;
        } else if (i != 4) {
            return false;
        } else {
            seek(message);
            return false;
        }
    }

    public void setProgressListener(ProgressListener progressListener) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setProgressListener progressListener = " + progressListener);
        }
        this.mProgressListener = progressListener;
        BaseProtoSender baseProtoSender = this.mProtoSender;
        if (baseProtoSender != null) {
            baseProtoSender.setProgressListener(this.mProgressListener);
        }
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void startSimulator(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "startSimulator start = " + z);
        }
        if (z) {
            init();
        } else {
            release();
        }
    }

    public void play(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "play = " + z);
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            this.mIsRunning = z;
            if (z) {
                handler.sendEmptyMessage(2);
            } else {
                handler.sendEmptyMessage(3);
            }
        }
    }

    public void seekTo(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "seekTo = " + i);
        }
        if (this.mHandler != null) {
            Message obtain = Message.obtain();
            obtain.what = 4;
            obtain.arg1 = i;
            this.mHandler.sendMessage(obtain);
        }
    }

    private void init() {
        if (this.mProtoSimulatorThread == null) {
            this.mProtoSimulatorThread = new HandlerThread("ProtoSimulatorThread");
            this.mProtoSimulatorThread.start();
            this.mHandler = new Handler(this.mProtoSimulatorThread.getLooper(), this);
            this.mHandler.sendEmptyMessage(1);
        }
    }

    private void release() {
        if (this.mProtoSimulatorThread != null) {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeMessages(1);
                this.mHandler.removeMessages(4);
                this.mHandler.removeMessages(3);
                this.mHandler.removeMessages(2);
                this.mHandler.removeCallbacksAndMessages(null);
            }
            this.mProtoSimulatorThread.quitSafely();
            this.mIsRunning = false;
            this.mProtoSender = null;
            this.mHandler = null;
            this.mProtoSimulatorThread = null;
        }
    }

    private void readProtoData() {
        ProgressListener progressListener;
        this.mProtoSender = null;
        String str = RootUtil.SD_CARD_NAVI_PATH + File.separator + "proto";
        Overall.total_overall.Builder readProtoData = this.mProtoFileReader.readProtoData(str);
        if (readProtoData != null) {
            this.mProtoSender = new NaviProtoSender(readProtoData);
        } else {
            Overall.total_xpu_overall.Builder readXpuProtoData = this.mProtoFileReader.readXpuProtoData(str);
            if (readXpuProtoData != null) {
                this.mProtoSender = new XpuProtoSender(readXpuProtoData);
            }
        }
        BaseProtoSender baseProtoSender = this.mProtoSender;
        if (baseProtoSender == null || (progressListener = this.mProgressListener) == null) {
            return;
        }
        baseProtoSender.setProgressListener(progressListener);
    }

    private void nextFrame() {
        BaseProtoSender baseProtoSender = this.mProtoSender;
        if (baseProtoSender == null || !baseProtoSender.hasProtoData()) {
            return;
        }
        if (this.mProtoSender.sendNextFrame()) {
            ProgressListener progressListener = this.mProgressListener;
            if (progressListener != null) {
                progressListener.onProgressChanged(this.mProtoSender.getProtoSendProgress());
            }
            this.mProtoSender.scheduleNextFrame(this.mHandler);
            return;
        }
        L.e(TAG, "sendNextFrame fail! interrupt send!");
    }

    private void seek(Message message) {
        BaseProtoSender baseProtoSender = this.mProtoSender;
        if (baseProtoSender != null) {
            baseProtoSender.jumpToProgress(message.arg1);
        }
    }

    private void pause() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(2);
        }
    }
}
