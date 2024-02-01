package com.alibaba.android.ark;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public enum AIMConvType {
    CONV_TYPE_UNKNOW(-1),
    CONV_TYPE_SINGLE(1),
    CONV_TYPE_GROUP(2);
    
    private static final Map<Integer, AIMConvType> sValueToEnumMap = new HashMap();
    private final int value;

    static {
        Iterator it = EnumSet.allOf(AIMConvType.class).iterator();
        while (it.hasNext()) {
            AIMConvType aIMConvType = (AIMConvType) it.next();
            sValueToEnumMap.put(Integer.valueOf(aIMConvType.value), aIMConvType);
        }
    }

    public static AIMConvType forValue(int i) {
        return sValueToEnumMap.get(Integer.valueOf(i));
    }

    AIMConvType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
