package com.alibaba.android.ark;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public enum AIMFileAuthType {
    NO_AUTH(1),
    STRICT_AUTH(2);
    
    private static final Map<Integer, AIMFileAuthType> sValueToEnumMap = new HashMap();
    private final int value;

    static {
        Iterator it = EnumSet.allOf(AIMFileAuthType.class).iterator();
        while (it.hasNext()) {
            AIMFileAuthType aIMFileAuthType = (AIMFileAuthType) it.next();
            sValueToEnumMap.put(Integer.valueOf(aIMFileAuthType.value), aIMFileAuthType);
        }
    }

    public static AIMFileAuthType forValue(int i) {
        return sValueToEnumMap.get(Integer.valueOf(i));
    }

    AIMFileAuthType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
