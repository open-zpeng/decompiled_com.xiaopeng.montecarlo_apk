package com.alibaba.android.ark;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public enum AIMConnectionStatus {
    CS_UNCONNECTED(0),
    CS_CONNECTING(1),
    CS_CONNECTED(2),
    CS_AUTHING(3),
    CS_AUTHED(4);
    
    private static final Map<Integer, AIMConnectionStatus> sValueToEnumMap = new HashMap();
    private final int value;

    static {
        Iterator it = EnumSet.allOf(AIMConnectionStatus.class).iterator();
        while (it.hasNext()) {
            AIMConnectionStatus aIMConnectionStatus = (AIMConnectionStatus) it.next();
            sValueToEnumMap.put(Integer.valueOf(aIMConnectionStatus.value), aIMConnectionStatus);
        }
    }

    public static AIMConnectionStatus forValue(int i) {
        return sValueToEnumMap.get(Integer.valueOf(i));
    }

    AIMConnectionStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
