package com.alibaba.android.ark;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public enum AIMMsgOrientation {
    ORIENTATION_UNKNOWN(-1),
    ORIENTATION_NORMAL(1),
    ORIENTATION_FLIP_HORIZONTAL(2),
    ORIENTATION_ROTATE_180(3),
    ORIENTATION_FLIP_VERTICAL(4),
    ORIENTATION_TRANSPOSE(5),
    ORIENTATION_ROTATE_90(6),
    ORIENTATION_TRANSVERSE(7),
    ORIENTATION_ROTATE_270(8);
    
    private static final Map<Integer, AIMMsgOrientation> sValueToEnumMap = new HashMap();
    private final int value;

    static {
        Iterator it = EnumSet.allOf(AIMMsgOrientation.class).iterator();
        while (it.hasNext()) {
            AIMMsgOrientation aIMMsgOrientation = (AIMMsgOrientation) it.next();
            sValueToEnumMap.put(Integer.valueOf(aIMMsgOrientation.value), aIMMsgOrientation);
        }
    }

    public static AIMMsgOrientation forValue(int i) {
        return sValueToEnumMap.get(Integer.valueOf(i));
    }

    AIMMsgOrientation(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
