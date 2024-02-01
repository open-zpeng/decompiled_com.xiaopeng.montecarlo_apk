package com.alibaba.android.ark;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public enum AIMConnectionType {
    CONNECTION_TYPE_ACCS(0),
    CONNECTION_TYPE_BIFROST(1),
    CONNECTION_TYPE_DINGTALK_FILE(2);
    
    private static final Map<Integer, AIMConnectionType> sValueToEnumMap = new HashMap();
    private final int value;

    static {
        Iterator it = EnumSet.allOf(AIMConnectionType.class).iterator();
        while (it.hasNext()) {
            AIMConnectionType aIMConnectionType = (AIMConnectionType) it.next();
            sValueToEnumMap.put(Integer.valueOf(aIMConnectionType.value), aIMConnectionType);
        }
    }

    public static AIMConnectionType forValue(int i) {
        return sValueToEnumMap.get(Integer.valueOf(i));
    }

    AIMConnectionType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
