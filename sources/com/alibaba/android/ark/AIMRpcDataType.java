package com.alibaba.android.ark;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public enum AIMRpcDataType {
    DT_MSGPACK(0),
    DT_JSON(1);
    
    private static final Map<Integer, AIMRpcDataType> sValueToEnumMap = new HashMap();
    private final int value;

    static {
        Iterator it = EnumSet.allOf(AIMRpcDataType.class).iterator();
        while (it.hasNext()) {
            AIMRpcDataType aIMRpcDataType = (AIMRpcDataType) it.next();
            sValueToEnumMap.put(Integer.valueOf(aIMRpcDataType.value), aIMRpcDataType);
        }
    }

    public static AIMRpcDataType forValue(int i) {
        return sValueToEnumMap.get(Integer.valueOf(i));
    }

    AIMRpcDataType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
