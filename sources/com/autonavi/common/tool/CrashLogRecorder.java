package com.autonavi.common.tool;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes.dex */
public class CrashLogRecorder {
    static List<String> mCustomData = new ArrayList();
    private static final TreeMap<String, String> sKeyValue = new TreeMap<>();

    public static List<String> getCustomData() {
        return mCustomData;
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
