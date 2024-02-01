package com.alibaba.android.ark;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public enum AIMMsgImageCompressType {
    IMAGE_COMPRESS_TYPE_UNKNOWN(-1),
    IMAGE_COMPRESS_TYPE_COMPRESS(0),
    IMAGE_COMPRESS_TYPE_ORIGINAL(1);
    
    private static final Map<Integer, AIMMsgImageCompressType> sValueToEnumMap = new HashMap();
    private final int value;

    static {
        Iterator it = EnumSet.allOf(AIMMsgImageCompressType.class).iterator();
        while (it.hasNext()) {
            AIMMsgImageCompressType aIMMsgImageCompressType = (AIMMsgImageCompressType) it.next();
            sValueToEnumMap.put(Integer.valueOf(aIMMsgImageCompressType.value), aIMMsgImageCompressType);
        }
    }

    public static AIMMsgImageCompressType forValue(int i) {
        return sValueToEnumMap.get(Integer.valueOf(i));
    }

    AIMMsgImageCompressType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
