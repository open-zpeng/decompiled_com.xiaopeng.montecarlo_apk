package com.alibaba.android.ark;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public enum AIMMsgRecallType {
    RECALL_TYPE_UNKNOWN(-1),
    RECALL_TYPE_SENDER(0),
    RECALL_TYPE_GROUP_OWNER(1),
    RECALL_TYPE_SYSTEM(2),
    RECALL_TYPE_SECURITY(3),
    RECALL_TYPE_ADMIN(4),
    RECALL_TYPE_CUSTOM(101);
    
    private static final Map<Integer, AIMMsgRecallType> sValueToEnumMap = new HashMap();
    private final int value;

    static {
        Iterator it = EnumSet.allOf(AIMMsgRecallType.class).iterator();
        while (it.hasNext()) {
            AIMMsgRecallType aIMMsgRecallType = (AIMMsgRecallType) it.next();
            sValueToEnumMap.put(Integer.valueOf(aIMMsgRecallType.value), aIMMsgRecallType);
        }
    }

    public static AIMMsgRecallType forValue(int i) {
        return sValueToEnumMap.get(Integer.valueOf(i));
    }

    AIMMsgRecallType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
