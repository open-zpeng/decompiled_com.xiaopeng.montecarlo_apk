package com.alibaba.android.ark;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public enum AIMLogLevel {
    AIM_LOG_LEVEL_DEBUG(0),
    AIM_LOG_LEVEL_INFO(1),
    AIM_LOG_LEVEL_WARNING(2),
    AIM_LOG_LEVEL_ERROR(3),
    AIM_LOG_LEVEL_FATAL(4);
    
    private static final Map<Integer, AIMLogLevel> sValueToEnumMap = new HashMap();
    private final int value;

    static {
        Iterator it = EnumSet.allOf(AIMLogLevel.class).iterator();
        while (it.hasNext()) {
            AIMLogLevel aIMLogLevel = (AIMLogLevel) it.next();
            sValueToEnumMap.put(Integer.valueOf(aIMLogLevel.value), aIMLogLevel);
        }
    }

    public static AIMLogLevel forValue(int i) {
        return sValueToEnumMap.get(Integer.valueOf(i));
    }

    AIMLogLevel(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
