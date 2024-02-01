package com.alibaba.android.ark;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public enum AIMConvStatus {
    CONV_STATUS_UNKNOW(-1),
    CONV_STATUS_HIDE(0),
    CONV_STATUS_NORMAL(1),
    CONV_STATUS_OFFLINE(2),
    CONV_STATUS_KICKED(3),
    CONV_STATUS_DISMISSED(4);
    
    private static final Map<Integer, AIMConvStatus> sValueToEnumMap = new HashMap();
    private final int value;

    static {
        Iterator it = EnumSet.allOf(AIMConvStatus.class).iterator();
        while (it.hasNext()) {
            AIMConvStatus aIMConvStatus = (AIMConvStatus) it.next();
            sValueToEnumMap.put(Integer.valueOf(aIMConvStatus.value), aIMConvStatus);
        }
    }

    public static AIMConvStatus forValue(int i) {
        return sValueToEnumMap.get(Integer.valueOf(i));
    }

    AIMConvStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
