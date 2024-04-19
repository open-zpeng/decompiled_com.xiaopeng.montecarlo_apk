package com.dingtalk.mars.comm;

import android.content.Context;
import android.os.PowerManager;
import com.dingtalk.bifrost.Bifrost;
import com.dingtalk.bifrost.BifrostEnvUtils;
import com.dingtalk.mobile.common.transport.utils.BifrostLogCatUtil;
/* loaded from: classes2.dex */
public class WakerLock {
    private static final String TAG = "bifrost.WakerLock";
    private PowerManager.WakeLock wakeLock;

    public WakerLock(Context context) {
        this.wakeLock = null;
        if (context == null) {
            try {
                context = BifrostEnvUtils.getContext();
            } catch (Throwable th) {
                BifrostLogCatUtil.error(TAG, "WakerLock error", th);
                return;
            }
        }
        this.wakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, TAG);
        this.wakeLock.setReferenceCounted(false);
    }

    protected void finalize() throws Throwable {
        unLock();
    }

    public void lock(long j) {
        PowerManager.WakeLock wakeLock;
        if (Bifrost.getSwchmng().enableBifrostUseWakeLock() && (wakeLock = this.wakeLock) != null) {
            wakeLock.acquire(j);
        }
    }

    public void lock() {
        PowerManager.WakeLock wakeLock;
        if (Bifrost.getSwchmng().enableBifrostUseWakeLock() && (wakeLock = this.wakeLock) != null) {
            wakeLock.acquire();
        }
    }

    public void unLock() {
        PowerManager.WakeLock wakeLock = this.wakeLock;
        if (wakeLock != null && wakeLock.isHeld()) {
            this.wakeLock.release();
        }
    }

    public boolean isLocking() {
        PowerManager.WakeLock wakeLock = this.wakeLock;
        if (wakeLock == null) {
            return false;
        }
        return wakeLock.isHeld();
    }
}
