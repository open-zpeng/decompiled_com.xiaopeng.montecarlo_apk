package com.xiaopeng.montecarlo.navcore.location;

import android.content.Intent;
import android.location.Location;
import androidx.annotation.NonNull;
import com.autonavi.common.tool.FDManager;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/* loaded from: classes3.dex */
public class SimulatedLogLocationService {
    public static final String FILE_NAME = "SimulatedLocationLog.txt";
    private static final L.Tag TAG = new L.Tag("SimulatedLogLocationService");
    private final String mSaveFileDir;
    private final DebugLocationSimulateThread mSimulationThread;
    private volatile boolean mRunningFlag = false;
    @NonNull
    private Object mMutex = new Object();

    public SimulatedLogLocationService(@NonNull String str) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "SimulatedLogLocationService init" + str);
        }
        this.mSaveFileDir = str;
        this.mSimulationThread = new DebugLocationSimulateThread(this.mSaveFileDir + FILE_NAME);
    }

    public void startDebugLocationSimulate() {
        synchronized (this.mMutex) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "startDebugLocationSimulate" + this.mMutex + "____" + this.mRunningFlag);
            }
            if (!this.mRunningFlag) {
                this.mRunningFlag = true;
                WorkThreadUtil.getInstance().executeCachedTask(this.mSimulationThread);
                ContextUtils.getContext().sendBroadcast(new Intent("com.xiaopeng.montecarlo.LOCATION_SIMULATE_START"));
            }
        }
    }

    public void stopDebugLocationSimulate() {
        synchronized (this.mMutex) {
            if (this.mRunningFlag) {
                this.mRunningFlag = false;
                this.mSimulationThread.stopThread();
                ContextUtils.getContext().sendBroadcast(new Intent("com.xiaopeng.montecarlo.LOCATION_SIMULATE_STOP"));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.File] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00a8 -> B:41:0x00b7). Please submit an issue!!! */
    public void saveLocationToSdcard(@NonNull Location location) {
        FileWriter fileWriter;
        String str;
        FileWriter fileWriter2;
        if (RootUtil.isSdcardExist()) {
            FileWriter fileWriter3 = null;
            try {
                try {
                    try {
                        String str2 = this.mSaveFileDir;
                        File file = new File(str2);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        str = str2 + FILE_NAME;
                        fileWriter = new File(str);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
                fileWriter = 0;
            }
            try {
                if (fileWriter.exists()) {
                    fileWriter2 = new FileWriter(str, true);
                    String str3 = LocationUtils.locationToLogString(location) + FDManager.LINE_SEPERATOR;
                    if (L.ENABLE) {
                        L.d(TAG, ">>>> saveLocationToSdcard text = " + str3);
                    }
                    fileWriter2.write(str3);
                    fileWriter2.flush();
                } else {
                    fileWriter.createNewFile();
                    fileWriter2 = new FileWriter(str, false);
                    fileWriter2.write(LocationUtils.locationToLogString(location) + FDManager.LINE_SEPERATOR);
                    fileWriter2.flush();
                }
                fileWriter2.close();
            } catch (IOException e3) {
                e = e3;
                fileWriter3 = fileWriter;
                e.printStackTrace();
                if (fileWriter3 != null) {
                    fileWriter3.close();
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileWriter != 0) {
                    try {
                        fileWriter.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }
}
