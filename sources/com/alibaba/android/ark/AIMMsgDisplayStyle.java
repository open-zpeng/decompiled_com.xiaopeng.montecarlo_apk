package com.alibaba.android.ark;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public enum AIMMsgDisplayStyle {
    DISPLAY_STYLE_UNKNOWN(0),
    DISPLAY_STYLE_USER(1),
    DISPLAY_STYLE_SYSTEM(2);
    
    private static final Map<Integer, AIMMsgDisplayStyle> sValueToEnumMap = new HashMap();
    private final int value;

    static {
        Iterator it = EnumSet.allOf(AIMMsgDisplayStyle.class).iterator();
        while (it.hasNext()) {
            AIMMsgDisplayStyle aIMMsgDisplayStyle = (AIMMsgDisplayStyle) it.next();
            sValueToEnumMap.put(Integer.valueOf(aIMMsgDisplayStyle.value), aIMMsgDisplayStyle);
        }
    }

    public static AIMMsgDisplayStyle forValue(int i) {
        return sValueToEnumMap.get(Integer.valueOf(i));
    }

    AIMMsgDisplayStyle(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
