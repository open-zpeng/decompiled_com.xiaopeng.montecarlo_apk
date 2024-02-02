package com.autonavi.common.tool;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes.dex */
public class CrashLogRecorder {
    static List<String> mCustomData = new ArrayList();
    private static final TreeMap<String, String> sKeyValue = new TreeMap<>();

    public static void recordLog(String str) {
    }

    public static List<String> getCustomData() {
        return mCustomData;
    }

    public static void recordKeyValue(String str, int i) {
        recordKeyValue(str, Integer.toString(i));
    }

    public static void recordKeyValue(String str, boolean z) {
        recordKeyValue(str, z ? "1" : "0");
    }

    public static void recordKeyValue(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        if (CrashLog.isInited()) {
            if (str2 == null) {
                str2 = "<null>";
            } else if (str2.equals("")) {
                str2 = "<empty>";
            }
            if (CrashLog.debugMode()) {
                Log.d(dumpcrash.LIB_DUMPCRASH, "record: key=" + str + "; value=" + str2);
            }
            synchronized (sKeyValue) {
                sKeyValue.put(str, str2);
            }
            dumpcrash.recordKeyValue(str, str2);
        }
    }

    public static String dumpForJava() {
        StringBuilder sb = new StringBuilder();
        synchronized (sKeyValue) {
            sb.append("===[START] KeyValue Size:");
            sb.append(sKeyValue.size());
            sb.append(", Log Buffer Index:0===\n\n");
            sb.append("[KeyValue]\n");
            for (Map.Entry<String, String> entry : sKeyValue.entrySet()) {
                sb.append(entry.getKey());
                sb.append(": ");
                sb.append(entry.getValue());
                sb.append(FDManager.LINE_SEPERATOR);
            }
            sb.append("\n===[END] KeyValue & Log===\n");
        }
        return sb.toString();
    }

    @Deprecated
    public static void addCustomData(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        mCustomData.add(str);
    }
}
