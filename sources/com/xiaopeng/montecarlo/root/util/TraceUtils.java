package com.xiaopeng.montecarlo.root.util;

import com.xiaopeng.montecarlo.root.util.L;
import java.util.HashMap;
import java.util.Stack;
/* loaded from: classes2.dex */
public class TraceUtils {
    public static final boolean DEBUG_BY_LOG = false;
    private static final boolean NEED_TRACE = false;
    private static final L.Tag TAG = new L.Tag("Trace");
    private static HashMap<String, Long> sThreadStartTimeMap = new HashMap<>();
    private static HashMap<String, Stack<String>> sThreadMethodNameMap = new HashMap<>();
    private static HashMap<String, Stack<Long>> sThreadEndTimeMap = new HashMap<>();

    public static void alwaysTraceBegin(String str) {
    }

    public static void alwaysTraceEnd() {
    }
}
