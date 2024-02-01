package com.alibaba.android.ark;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public enum AIMAuthTokenExpiredReason {
    UNKNOWN(0),
    NO_LOCAL_TOKEN(1),
    LOCAL_TOKEN_EXPIRED(2),
    UID_TOKEN_NOT_MATCH(3),
    EMPTY_REFRESH_TOKEN(4),
    REFRESH_TOKEN_FAILED(5),
    REFRESH_TOKEN_EXPIRED(6);
    
    private static final Map<Integer, AIMAuthTokenExpiredReason> sValueToEnumMap = new HashMap();
    private final int value;

    static {
        Iterator it = EnumSet.allOf(AIMAuthTokenExpiredReason.class).iterator();
        while (it.hasNext()) {
            AIMAuthTokenExpiredReason aIMAuthTokenExpiredReason = (AIMAuthTokenExpiredReason) it.next();
            sValueToEnumMap.put(Integer.valueOf(aIMAuthTokenExpiredReason.value), aIMAuthTokenExpiredReason);
        }
    }

    public static AIMAuthTokenExpiredReason forValue(int i) {
        return sValueToEnumMap.get(Integer.valueOf(i));
    }

    AIMAuthTokenExpiredReason(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
