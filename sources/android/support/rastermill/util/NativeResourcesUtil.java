package android.support.rastermill.util;

import android.support.rastermill.LogUtil;
import android.util.Log;
import com.autonavi.common.tool.FDManager;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.root.util.config.DebugConfiguration;
import java.util.HashMap;
/* loaded from: classes.dex */
public class NativeResourcesUtil {
    public static boolean sEnable;
    private static HashMap<Long, Info> mNativeStates = new HashMap<>();
    private static HashMap<Long, Info> mNativeFrameSequences = new HashMap<>();
    private static HashMap<Long, String> mFrameSequenceKeys = new HashMap<>();

    public static void setEnable(boolean z) {
        sEnable = z;
    }

    public static void putFrameSequenceKey(final long j, final String str) {
        if (sEnable) {
            ThreadUtils.postWorker(new Runnable() { // from class: android.support.rastermill.util.NativeResourcesUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    NativeResourcesUtil.mFrameSequenceKeys.put(Long.valueOf(j), str);
                }
            });
        }
    }

    public static void addNativeState(final long j, final long j2, final int i, final int i2, final int i3) {
        if (sEnable) {
            ThreadUtils.postWorker(new Runnable() { // from class: android.support.rastermill.util.NativeResourcesUtil.2
                @Override // java.lang.Runnable
                public void run() {
                    NativeResourcesUtil.mNativeStates.put(Long.valueOf(j2), new Info(j, j2, i, i2, i3));
                }
            });
        }
    }

    public static void removeNativeState(final long j) {
        if (sEnable) {
            ThreadUtils.postWorker(new Runnable() { // from class: android.support.rastermill.util.NativeResourcesUtil.3
                @Override // java.lang.Runnable
                public void run() {
                    NativeResourcesUtil.mNativeStates.remove(Long.valueOf(j));
                }
            });
        }
    }

    public static void addNativeFrameSequence(final long j, final int i, final int i2, final int i3) {
        if (sEnable) {
            ThreadUtils.postWorker(new Runnable() { // from class: android.support.rastermill.util.NativeResourcesUtil.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap = NativeResourcesUtil.mNativeFrameSequences;
                    Long valueOf = Long.valueOf(j);
                    long j2 = j;
                    hashMap.put(valueOf, new Info(j2, j2, i, i2, i3));
                }
            });
        }
    }

    public static void removeNativeFrameSequence(final long j) {
        if (sEnable) {
            ThreadUtils.postWorker(new Runnable() { // from class: android.support.rastermill.util.NativeResourcesUtil.5
                @Override // java.lang.Runnable
                public void run() {
                    NativeResourcesUtil.mNativeFrameSequences.remove(Long.valueOf(j));
                    NativeResourcesUtil.mFrameSequenceKeys.remove(Long.valueOf(j));
                }
            });
        }
    }

    public static void log() {
        if (sEnable) {
            ThreadUtils.postWorker(new Runnable() { // from class: android.support.rastermill.util.NativeResourcesUtil.6
                @Override // java.lang.Runnable
                public void run() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(FDManager.LINE_SEPERATOR);
                    sb.append("######NativeResourcesUtil######\n");
                    sb.append("mFrameSequenceKeys:");
                    sb.append(NativeResourcesUtil.mFrameSequenceKeys.size());
                    sb.append(FDManager.LINE_SEPERATOR);
                    if (NativeResourcesUtil.mFrameSequenceKeys.size() > 0) {
                        NativeResourcesUtil.getFrameSequenceKeyLog(sb, NativeResourcesUtil.mFrameSequenceKeys);
                    }
                    sb.append("----\nmNativeFrameSequences:");
                    sb.append(NativeResourcesUtil.mNativeFrameSequences.size());
                    sb.append(FDManager.LINE_SEPERATOR);
                    if (NativeResourcesUtil.mNativeFrameSequences.size() > 0) {
                        NativeResourcesUtil.getNativeInfoLog(sb, NativeResourcesUtil.mNativeFrameSequences);
                    }
                    sb.append("----\nmNativeStates:");
                    sb.append(NativeResourcesUtil.mNativeStates.size());
                    sb.append(FDManager.LINE_SEPERATOR);
                    if (NativeResourcesUtil.mNativeStates.size() > 0) {
                        NativeResourcesUtil.getNativeInfoLog(sb, NativeResourcesUtil.mNativeStates);
                    }
                    sb.append("------NativeResourcesUtil------\n");
                    Log.e(LogUtil.TAG, sb.toString());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void getFrameSequenceKeyLog(StringBuilder sb, HashMap<Long, String> hashMap) {
        for (Long l : hashMap.keySet()) {
            sb.append(hashMap.get(l));
            sb.append(FDManager.LINE_SEPERATOR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void getNativeInfoLog(StringBuilder sb, HashMap<Long, Info> hashMap) {
        int valueOf;
        sb.append("----\nkey:size\n");
        HashMap hashMap2 = new HashMap();
        for (Long l : hashMap.keySet()) {
            Info info = hashMap.get(l);
            String sizeKey = info.getSizeKey();
            Integer num = (Integer) hashMap2.get(sizeKey);
            if (num == null) {
                valueOf = 1;
            } else {
                valueOf = Integer.valueOf(num.intValue() + 1);
            }
            sb.append(mFrameSequenceKeys.get(Long.valueOf(info.nativeFrameSequence)));
            sb.append(LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR);
            sb.append(sizeKey);
            sb.append(FDManager.LINE_SEPERATOR);
            hashMap2.put(sizeKey, valueOf);
        }
        sb.append("----\nsize:count\n");
        for (String str : hashMap2.keySet()) {
            sb.append(str);
            sb.append(LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR);
            sb.append(hashMap2.get(str));
            sb.append(FDManager.LINE_SEPERATOR);
        }
    }

    /* loaded from: classes.dex */
    public static class Info {
        public int frameCount;
        public int height;
        public long nativeFrameSequence;
        public long nativePtr;
        public int width;

        public Info(long j, long j2, int i, int i2, int i3) {
            this.nativeFrameSequence = j;
            this.nativePtr = j2;
            this.width = i;
            this.height = i2;
            this.frameCount = i3;
        }

        public String getSizeKey() {
            return this.width + DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT + this.height + DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT + this.frameCount;
        }
    }
}
