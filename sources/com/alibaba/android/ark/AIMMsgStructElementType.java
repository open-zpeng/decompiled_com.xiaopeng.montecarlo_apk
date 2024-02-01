package com.alibaba.android.ark;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public enum AIMMsgStructElementType {
    ELEMENT_TYPE_UNKNOWN(0),
    ELEMENT_TYPE_TEXT(1),
    ELEMENT_TYPE_UID(2),
    ELEMENT_TYPE_AT(3);
    
    private static final Map<Integer, AIMMsgStructElementType> sValueToEnumMap = new HashMap();
    private final int value;

    static {
        Iterator it = EnumSet.allOf(AIMMsgStructElementType.class).iterator();
        while (it.hasNext()) {
            AIMMsgStructElementType aIMMsgStructElementType = (AIMMsgStructElementType) it.next();
            sValueToEnumMap.put(Integer.valueOf(aIMMsgStructElementType.value), aIMMsgStructElementType);
        }
    }

    public static AIMMsgStructElementType forValue(int i) {
        return sValueToEnumMap.get(Integer.valueOf(i));
    }

    AIMMsgStructElementType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
