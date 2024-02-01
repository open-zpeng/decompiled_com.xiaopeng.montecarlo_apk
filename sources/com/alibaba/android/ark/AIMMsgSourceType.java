package com.alibaba.android.ark;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public enum AIMMsgSourceType {
    SOURCE_TYPE_UNKNOWN(-1),
    SOURCE_TYPE_SEND(0),
    SOURCE_TYPE_PULL_ONLINE(1),
    SOURCE_TYPE_RECV_ONLINE(2),
    SOURCE_TYPE_RECV_OFFLINE(3);
    
    private static final Map<Integer, AIMMsgSourceType> sValueToEnumMap = new HashMap();
    private final int value;

    static {
        Iterator it = EnumSet.allOf(AIMMsgSourceType.class).iterator();
        while (it.hasNext()) {
            AIMMsgSourceType aIMMsgSourceType = (AIMMsgSourceType) it.next();
            sValueToEnumMap.put(Integer.valueOf(aIMMsgSourceType.value), aIMMsgSourceType);
        }
    }

    public static AIMMsgSourceType forValue(int i) {
        return sValueToEnumMap.get(Integer.valueOf(i));
    }

    AIMMsgSourceType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
