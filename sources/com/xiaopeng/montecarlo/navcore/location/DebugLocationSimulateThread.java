package com.xiaopeng.montecarlo.navcore.location;

import android.location.Location;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class DebugLocationSimulateThread implements Runnable {
    public static final int SEND_LOCATION_CHANGED_SPEED = 1000;
    private static final L.Tag TAG = new L.Tag("DebugLocationSimulateThread");
    private volatile boolean mRunningFlag = true;
    private final String mSimulatedLogFilePath;

    public DebugLocationSimulateThread(String str) {
        this.mSimulatedLogFilePath = str;
    }

    public void stopThread() {
        this.mRunningFlag = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x00e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.List<android.location.Location> parseToLocation() {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.navcore.location.DebugLocationSimulateThread.parseToLocation():java.util.List");
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mRunningFlag = true;
        List<Location> parseToLocation = parseToLocation();
        if (parseToLocation != null) {
            int size = parseToLocation.size();
            int i = 0;
            while (i < size && this.mRunningFlag) {
                int i2 = i + 1;
                final Location location = parseToLocation.get(i);
                UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.location.DebugLocationSimulateThread.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LocationServiceManager.getInstance().updateLocation(location);
                    }
                });
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i = i2;
            }
            LocationServiceManager.getInstance().stopXPLocationState(2);
        }
    }
}
