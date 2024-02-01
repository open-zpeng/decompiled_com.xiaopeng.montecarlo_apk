package com.alibaba.android.ark;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public enum AIMGroupType {
    GROUP_TYPE_UNKNOW(-1),
    GROUP_TYPE_NORMAL(1),
    GROUP_TYPE_GIG(2);
    
    private static final Map<Integer, AIMGroupType> sValueToEnumMap = new HashMap();
    private final int value;

    static {
        Iterator it = EnumSet.allOf(AIMGroupType.class).iterator();
        while (it.hasNext()) {
            AIMGroupType aIMGroupType = (AIMGroupType) it.next();
            sValueToEnumMap.put(Integer.valueOf(aIMGroupType.value), aIMGroupType);
        }
    }

    public static AIMGroupType forValue(int i) {
        return sValueToEnumMap.get(Integer.valueOf(i));
    }

    AIMGroupType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
