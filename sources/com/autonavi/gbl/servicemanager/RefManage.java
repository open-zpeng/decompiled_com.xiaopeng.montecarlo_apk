package com.autonavi.gbl.servicemanager;

import com.autonavi.auto.bl.puglin.annotations.JniNativeMethod;
import com.autonavi.gbl.servicemanager.RefInfo;
import java.io.File;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class RefManage {
    private static final int SLEEP_TIME = 1000;
    private static final Map<Reference<Object>, RefInfo> MAPS = new ConcurrentHashMap();
    private static final ReferenceQueue<Object> REFERENCE_QUEUE = new ReferenceQueue<>();
    private static int ptrCnt = 1;
    private static int huntCnt = 1;
    private static int unregisterCnt = 1;
    private static boolean isEnableVmRegister = true;
    private static volatile boolean started = false;
    private static final Thread CLEAN_UP_THREAD = new Thread(new Runnable() { // from class: com.autonavi.gbl.servicemanager.RefManage.1
        @Override // java.lang.Runnable
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Reference remove = RefManage.REFERENCE_QUEUE.remove();
                    if (remove != null) {
                        RefManage.removeRef(remove);
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
    });

    @JniNativeMethod(parameters = {"ptr"})
    private static native void freePtrNative(long j);

    private RefManage() {
    }

    private static void loadVmFlag() {
        if (true == new File("/sdcard/disablevm.txt").exists()) {
            isEnableVmRegister = false;
        }
    }

    public static Object register(Object obj, long j, long j2, int i, RefInfo.Callback callback) {
        if (obj == null) {
            return null;
        }
        init();
        PhantomReference phantomReference = new PhantomReference(obj, REFERENCE_QUEUE);
        MAPS.put(phantomReference, new RefInfo(callback, j, i, j2, isEnableVmRegister));
        return phantomReference;
    }

    public static void unregister(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return;
        }
        MAPS.remove(obj2);
    }

    public static void removeRef(Object obj) {
        RefInfo remove = MAPS.remove(obj);
        if (remove != null) {
            remove.delete();
        }
    }

    private static void freePtr(Long l) {
        if (l != null) {
            long longValue = l.longValue();
            if (longValue != 0) {
                freePtrNative(longValue);
            }
        }
    }

    private static void init() {
        if (started) {
            return;
        }
        synchronized (CLEAN_UP_THREAD) {
            if (!started) {
                CLEAN_UP_THREAD.setName("CleanUpThread");
                CLEAN_UP_THREAD.setDaemon(true);
                CLEAN_UP_THREAD.start();
                started = true;
                loadVmFlag();
            }
        }
    }

    public static void testFree() {
        freePtrNative(0L);
    }
}
