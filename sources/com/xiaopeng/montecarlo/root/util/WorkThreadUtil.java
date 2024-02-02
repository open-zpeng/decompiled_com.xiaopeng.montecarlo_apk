package com.xiaopeng.montecarlo.root.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.xiaopeng.montecarlo.root.account.AccountSyncHandlerThread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class WorkThreadUtil {
    private static final WorkThreadUtil sInstance = new WorkThreadUtil();
    private final ExecutorService mCachedThreadPool = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), new XpThreadFactory("nav_cache", 5));
    private final ScheduledExecutorService mIoScheduledThreadPool = Executors.newSingleThreadScheduledExecutor(new XpThreadFactory("nav_io", 5));
    private final ScheduledExecutorService mBusinessScheduledThreadPool = Executors.newSingleThreadScheduledExecutor(new XpThreadFactory("nav_business", 5));
    private final ExecutorService mSpeechThreadPool = Executors.newSingleThreadExecutor(new XpThreadFactory("nav_tts", 5));
    private final ExecutorService mSRThreadPool = Executors.newSingleThreadExecutor(new XpThreadFactory("nav_sr_ngp", 10));
    private final AccountSyncHandlerThread mAccountSyncThread = new AccountSyncHandlerThread("AccountSyncThread");
    private final HandlerThread mCommonCarServiceThread = new HandlerThread("CommonCarServiceThread");
    private final HandlerThread mCarServiceThread = new HandlerThread("CarServiceThread");
    private final HandlerThread mSrCarServiceThread = new HandlerThread("SrCarServiceThread");
    private final HandlerThread mDataProcessThread = new HandlerThread("DataProcessThread");
    private final HandlerThread mSpeechAndAiThread = new HandlerThread("SpeechAndAiThread");
    private final HandlerThread mNavThread = new HandlerThread("NavThread");
    private final HandlerThread mDynamicLevelThread = new HandlerThread("DynamicLevelThread");
    private final HandlerThread mMiniMapThread = new HandlerThread("MiniMapThread");
    private final HandlerThread mLocationThread = new HandlerThread("LocationThread");
    private final HandlerThread mStatusThread = new HandlerThread("StatusThread");
    private final HandlerThread mSensorDataProcessThread = new HandlerThread("SensorDataProcessThread");
    private final HandlerThread mNmeaThread = new HandlerThread("NmeaThread");
    private final HandlerThread mGnssDataProcessThread = new HandlerThread("GnssDataProcessThread");
    private final HandlerThread mBizControlThread = new HandlerThread("BizControlThread", -4);
    private final HandlerThread mMiniBizControlThread = new HandlerThread("MiniBizControlThread", -4);
    private final HandlerThread mSetSaveLocStorageThread = new HandlerThread("SetSaveLocStorageThread");
    private final HandlerThread mSendDRLocationInfoToSystemThread = new HandlerThread("SendDRLocationInfoToSystemThread");
    private final HandlerThread mEHPServiceThread = new HandlerThread("EHPServiceThread");
    private final HandlerThread mUDPClientThread = new HandlerThread("UDPClientThread");
    private final HandlerThread mXPUServiceThread = new HandlerThread("XPUServiceThread");

    public boolean isCheckHandler(Handler handler) {
        return handler == null;
    }

    private WorkThreadUtil() {
        AccountSyncHandlerThread accountSyncHandlerThread = this.mAccountSyncThread;
        if (accountSyncHandlerThread != null) {
            accountSyncHandlerThread.start();
        }
        HandlerThread handlerThread = this.mCommonCarServiceThread;
        if (handlerThread != null) {
            handlerThread.start();
        }
        HandlerThread handlerThread2 = this.mCarServiceThread;
        if (handlerThread2 != null) {
            handlerThread2.start();
        }
        HandlerThread handlerThread3 = this.mSrCarServiceThread;
        if (handlerThread3 != null) {
            handlerThread3.start();
        }
        HandlerThread handlerThread4 = this.mDataProcessThread;
        if (handlerThread4 != null) {
            handlerThread4.start();
        }
        HandlerThread handlerThread5 = this.mSpeechAndAiThread;
        if (handlerThread5 != null) {
            handlerThread5.start();
        }
        HandlerThread handlerThread6 = this.mNavThread;
        if (handlerThread6 != null) {
            handlerThread6.start();
        }
        HandlerThread handlerThread7 = this.mDynamicLevelThread;
        if (handlerThread7 != null) {
            handlerThread7.start();
        }
        HandlerThread handlerThread8 = this.mMiniMapThread;
        if (handlerThread8 != null) {
            handlerThread8.start();
        }
        HandlerThread handlerThread9 = this.mLocationThread;
        if (handlerThread9 != null) {
            handlerThread9.start();
        }
        HandlerThread handlerThread10 = this.mStatusThread;
        if (handlerThread10 != null) {
            handlerThread10.start();
        }
        HandlerThread handlerThread11 = this.mSensorDataProcessThread;
        if (handlerThread11 != null) {
            handlerThread11.start();
        }
        HandlerThread handlerThread12 = this.mNmeaThread;
        if (handlerThread12 != null) {
            handlerThread12.start();
        }
        HandlerThread handlerThread13 = this.mGnssDataProcessThread;
        if (handlerThread13 != null) {
            handlerThread13.start();
        }
        HandlerThread handlerThread14 = this.mSetSaveLocStorageThread;
        if (handlerThread14 != null) {
            handlerThread14.start();
        }
        HandlerThread handlerThread15 = this.mSendDRLocationInfoToSystemThread;
        if (handlerThread15 != null) {
            handlerThread15.start();
        }
        HandlerThread handlerThread16 = this.mEHPServiceThread;
        if (handlerThread16 != null) {
            handlerThread16.start();
        }
        HandlerThread handlerThread17 = this.mUDPClientThread;
        if (handlerThread17 != null) {
            handlerThread17.start();
        }
        HandlerThread handlerThread18 = this.mBizControlThread;
        if (handlerThread18 != null) {
            handlerThread18.start();
        }
        HandlerThread handlerThread19 = this.mMiniBizControlThread;
        if (handlerThread19 != null) {
            handlerThread19.start();
        }
        HandlerThread handlerThread20 = this.mXPUServiceThread;
        if (handlerThread20 != null) {
            handlerThread20.start();
        }
    }

    public static WorkThreadUtil getInstance() {
        return sInstance;
    }

    public void release() {
        if (!this.mCachedThreadPool.isShutdown()) {
            this.mCachedThreadPool.shutdownNow();
        }
        if (!this.mIoScheduledThreadPool.isShutdown()) {
            this.mIoScheduledThreadPool.shutdownNow();
        }
        if (!this.mBusinessScheduledThreadPool.isShutdown()) {
            this.mBusinessScheduledThreadPool.shutdownNow();
        }
        if (!this.mSpeechThreadPool.isShutdown()) {
            this.mSpeechThreadPool.shutdownNow();
        }
        if (!this.mSRThreadPool.isShutdown()) {
            this.mSRThreadPool.shutdownNow();
        }
        this.mAccountSyncThread.quitSafely();
        this.mCommonCarServiceThread.quitSafely();
        this.mCarServiceThread.quitSafely();
        this.mSrCarServiceThread.quitSafely();
        this.mDataProcessThread.quitSafely();
        this.mSpeechAndAiThread.quitSafely();
        this.mNavThread.quitSafely();
        this.mDynamicLevelThread.quitSafely();
        this.mMiniMapThread.quitSafely();
        this.mLocationThread.quitSafely();
        this.mStatusThread.quitSafely();
        this.mSensorDataProcessThread.quitSafely();
        this.mNmeaThread.quitSafely();
        this.mGnssDataProcessThread.quitSafely();
        this.mSetSaveLocStorageThread.quitSafely();
        this.mSendDRLocationInfoToSystemThread.quitSafely();
        this.mEHPServiceThread.quitSafely();
        this.mUDPClientThread.quitSafely();
        this.mBizControlThread.quitSafely();
        this.mMiniBizControlThread.quitSafely();
        this.mXPUServiceThread.quitSafely();
    }

    public void executeCachedTask(Runnable runnable) {
        this.mCachedThreadPool.execute(runnable);
    }

    public ScheduledFuture<?> executeScheduledBusinessTask(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.mBusinessScheduledThreadPool.schedule(runnable, j, timeUnit);
    }

    public void executeBusinessTask(Runnable runnable) {
        this.mBusinessScheduledThreadPool.execute(runnable);
    }

    public ScheduledFuture<?> executeScheduledIoTask(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.mIoScheduledThreadPool.schedule(runnable, j, timeUnit);
    }

    public void executeIOTask(Runnable runnable) {
        this.mIoScheduledThreadPool.execute(runnable);
    }

    public void executeSpeechTask(Runnable runnable) {
        this.mSpeechThreadPool.execute(runnable);
    }

    public void executeSRTask(Runnable runnable) {
        this.mSRThreadPool.execute(runnable);
    }

    public ExecutorService getCachedThreadPool() {
        return this.mCachedThreadPool;
    }

    public AccountSyncHandlerThread getAccountSyncThread() {
        return this.mAccountSyncThread;
    }

    public void removeMessages(Handler handler, int i) {
        if (!isCheckHandler(handler) && handler.hasMessages(i)) {
            handler.removeMessages(i);
        }
    }

    public void removeCallbacksAndMessages(Handler handler) {
        if (isCheckHandler(handler)) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
    }

    public void runOnBizThread(Handler handler, int i, Runnable runnable, long j) {
        if (isCheckHandler(handler)) {
            return;
        }
        Message obtain = Message.obtain(handler, runnable);
        obtain.what = i;
        handler.sendMessageDelayed(obtain, j);
    }

    public Looper getCommonCarServiceThreadLooper() {
        return this.mCommonCarServiceThread.getLooper();
    }

    public Looper getCarServiceThreadLooper() {
        return this.mCarServiceThread.getLooper();
    }

    public Looper getSrCarServiceThreadLooper() {
        return this.mSrCarServiceThread.getLooper();
    }

    public Looper getDataProcessThreadLooper() {
        return this.mDataProcessThread.getLooper();
    }

    public Looper getSpeechAndAiThreadLooper() {
        return this.mSpeechAndAiThread.getLooper();
    }

    public Looper getNavThreadLooper() {
        return this.mNavThread.getLooper();
    }

    public Looper getDynamicLevelThreadLooper() {
        return this.mDynamicLevelThread.getLooper();
    }

    public Looper getMiniMapThreadLooper() {
        return this.mMiniMapThread.getLooper();
    }

    public Looper getLocationThreadLooper() {
        return this.mLocationThread.getLooper();
    }

    public Looper getBizControlLooper() {
        return this.mBizControlThread.getLooper();
    }

    public Looper getMiniBizControlLooper() {
        return this.mMiniBizControlThread.getLooper();
    }

    public Looper getStatusThreadLooper() {
        return this.mStatusThread.getLooper();
    }

    public Looper getSensorDataProcessThreadLooper() {
        return this.mSensorDataProcessThread.getLooper();
    }

    public Looper getNmeaThreadLooper() {
        return this.mNmeaThread.getLooper();
    }

    public Looper getGnssDataProcessThreadLooper() {
        return this.mGnssDataProcessThread.getLooper();
    }

    public Looper getSetSaveLocStorageThreadLooper() {
        return this.mSetSaveLocStorageThread.getLooper();
    }

    public Looper getSendDRLocationInfoToSystemThreadLooper() {
        return this.mSendDRLocationInfoToSystemThread.getLooper();
    }

    public Looper getEHPServiceThreadLooper() {
        return this.mEHPServiceThread.getLooper();
    }

    public Looper getUDPClientThreadLooper() {
        return this.mUDPClientThread.getLooper();
    }

    public Looper getXPUServiceThread() {
        return this.mXPUServiceThread.getLooper();
    }
}
