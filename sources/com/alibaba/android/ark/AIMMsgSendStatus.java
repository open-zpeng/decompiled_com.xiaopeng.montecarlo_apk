package com.alibaba.android.ark;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public enum AIMMsgSendStatus {
    SEND_STATUS_UNKNOWN(-1),
    SEND_STATUS_SENT_SUCCESS(0),
    SEND_STATUS_SENDING(1),
    SEND_STATUS_SEND_FAIL(2);
    
    private static final Map<Integer, AIMMsgSendStatus> sValueToEnumMap = new HashMap();
    private final int value;

    static {
        Iterator it = EnumSet.allOf(AIMMsgSendStatus.class).iterator();
        while (it.hasNext()) {
            AIMMsgSendStatus aIMMsgSendStatus = (AIMMsgSendStatus) it.next();
            sValueToEnumMap.put(Integer.valueOf(aIMMsgSendStatus.value), aIMMsgSendStatus);
        }
    }

    public static AIMMsgSendStatus forValue(int i) {
        return sValueToEnumMap.get(Integer.valueOf(i));
    }

    AIMMsgSendStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
