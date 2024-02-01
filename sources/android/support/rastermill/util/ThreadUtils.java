package android.support.rastermill.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes.dex */
public class ThreadUtils {
    private static Handler sWorkerHandler;
    protected static Handler sMainHandler = new Handler(Looper.getMainLooper());
    private static HandlerThread sWorkerThread = new HandlerThread("lib_anim_webpWorker");

    static {
        sWorkerThread.start();
        sWorkerHandler = new Handler(sWorkerThread.getLooper());
    }

    public static void postWorker(Runnable runnable) {
        if (runnable != null) {
            sWorkerHandler.post(runnable);
        }
    }

    public static void removeWorker(Runnable runnable) {
        if (runnable != null) {
            sWorkerHandler.removeCallbacks(runnable);
        }
    }

    public static void postMain(Runnable runnable) {
        if (runnable != null) {
            sMainHandler.post(runnable);
        }
    }

    public static void removeMain(Runnable runnable) {
        if (runnable != null) {
            sMainHandler.removeCallbacks(runnable);
        }
    }
}
