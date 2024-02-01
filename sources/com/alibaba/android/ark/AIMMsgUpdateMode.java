package com.alibaba.android.ark;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public enum AIMMsgUpdateMode {
    UPDATE_BIZ_TAG(0),
    UPDATE_BIZ_TEXT(1),
    UPDATE_ALL(2);
    
    private static final Map<Integer, AIMMsgUpdateMode> sValueToEnumMap = new HashMap();
    private final int value;

    static {
        Iterator it = EnumSet.allOf(AIMMsgUpdateMode.class).iterator();
        while (it.hasNext()) {
            AIMMsgUpdateMode aIMMsgUpdateMode = (AIMMsgUpdateMode) it.next();
            sValueToEnumMap.put(Integer.valueOf(aIMMsgUpdateMode.value), aIMMsgUpdateMode);
        }
    }

    public static AIMMsgUpdateMode forValue(int i) {
        return sValueToEnumMap.get(Integer.valueOf(i));
    }

    AIMMsgUpdateMode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
