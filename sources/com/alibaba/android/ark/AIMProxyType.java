package com.alibaba.android.ark;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public enum AIMProxyType {
    PROXY_TYPE_UNKNOWN(0),
    PROXY_TYPE_HTTPTUNNEL(1),
    PROXY_TYPE_SOCKS5(2);
    
    private static final Map<Integer, AIMProxyType> sValueToEnumMap = new HashMap();
    private final int value;

    static {
        Iterator it = EnumSet.allOf(AIMProxyType.class).iterator();
        while (it.hasNext()) {
            AIMProxyType aIMProxyType = (AIMProxyType) it.next();
            sValueToEnumMap.put(Integer.valueOf(aIMProxyType.value), aIMProxyType);
        }
    }

    public static AIMProxyType forValue(int i) {
        return sValueToEnumMap.get(Integer.valueOf(i));
    }

    AIMProxyType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
