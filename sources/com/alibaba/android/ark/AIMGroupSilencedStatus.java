package com.alibaba.android.ark;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public enum AIMGroupSilencedStatus {
    GROUP_SILENCE_STATUS_NORMAL(0),
    GROUP_SILENCE_STATUS_IN_WHITELIST(1),
    GROUP_SILENCE_STATUS_IN_BLACKLIST(2);
    
    private static final Map<Integer, AIMGroupSilencedStatus> sValueToEnumMap = new HashMap();
    private final int value;

    static {
        Iterator it = EnumSet.allOf(AIMGroupSilencedStatus.class).iterator();
        while (it.hasNext()) {
            AIMGroupSilencedStatus aIMGroupSilencedStatus = (AIMGroupSilencedStatus) it.next();
            sValueToEnumMap.put(Integer.valueOf(aIMGroupSilencedStatus.value), aIMGroupSilencedStatus);
        }
    }

    public static AIMGroupSilencedStatus forValue(int i) {
        return sValueToEnumMap.get(Integer.valueOf(i));
    }

    AIMGroupSilencedStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
