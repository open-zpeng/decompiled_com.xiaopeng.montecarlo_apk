package com.alibaba.android.ark;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public enum AIMMediaHostType {
    MEDIA_HOST_TYPE_CDN(0),
    MEDIA_HOST_TYPE_AUTH(1);
    
    private static final Map<Integer, AIMMediaHostType> sValueToEnumMap = new HashMap();
    private final int value;

    static {
        Iterator it = EnumSet.allOf(AIMMediaHostType.class).iterator();
        while (it.hasNext()) {
            AIMMediaHostType aIMMediaHostType = (AIMMediaHostType) it.next();
            sValueToEnumMap.put(Integer.valueOf(aIMMediaHostType.value), aIMMediaHostType);
        }
    }

    public static AIMMediaHostType forValue(int i) {
        return sValueToEnumMap.get(Integer.valueOf(i));
    }

    AIMMediaHostType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
