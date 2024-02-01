package com.alibaba.android.ark;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public enum AIMSyncProtocolType {
    RELIABLE(0),
    UNRELIABLE(1);
    
    private static final Map<Integer, AIMSyncProtocolType> sValueToEnumMap = new HashMap();
    private final int value;

    static {
        Iterator it = EnumSet.allOf(AIMSyncProtocolType.class).iterator();
        while (it.hasNext()) {
            AIMSyncProtocolType aIMSyncProtocolType = (AIMSyncProtocolType) it.next();
            sValueToEnumMap.put(Integer.valueOf(aIMSyncProtocolType.value), aIMSyncProtocolType);
        }
    }

    public static AIMSyncProtocolType forValue(int i) {
        return sValueToEnumMap.get(Integer.valueOf(i));
    }

    AIMSyncProtocolType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
