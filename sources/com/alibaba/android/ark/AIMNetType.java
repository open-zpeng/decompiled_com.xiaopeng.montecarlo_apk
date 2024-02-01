package com.alibaba.android.ark;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public enum AIMNetType {
    NT_NOT_REACHABLE(0),
    NT_WIFI(1),
    NT_WIRE(2),
    NT_2G(3),
    NT_3G(4),
    NT_4G(5),
    NT_5G(6),
    NT_OTHER(100);
    
    private static final Map<Integer, AIMNetType> sValueToEnumMap = new HashMap();
    private final int value;

    static {
        Iterator it = EnumSet.allOf(AIMNetType.class).iterator();
        while (it.hasNext()) {
            AIMNetType aIMNetType = (AIMNetType) it.next();
            sValueToEnumMap.put(Integer.valueOf(aIMNetType.value), aIMNetType);
        }
    }

    public static AIMNetType forValue(int i) {
        return sValueToEnumMap.get(Integer.valueOf(i));
    }

    AIMNetType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
