package com.alibaba.android.ark;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public enum AIMMsgContentType {
    CONTENT_TYPE_UNKNOW(-1),
    CONTENT_TYPE_TEXT(1),
    CONTENT_TYPE_IMAGE(2),
    CONTENT_TYPE_AUDIO(3),
    CONTENT_TYPE_VIDEO(4),
    CONTENT_TYPE_GEO(5),
    CONTENT_TYPE_STRUCT(6),
    CONTENT_TYPE_LINK(7),
    CONTENT_TYPE_AT(8),
    CONTENT_TYPE_CUSTOM(101);
    
    private static final Map<Integer, AIMMsgContentType> sValueToEnumMap = new HashMap();
    private final int value;

    static {
        Iterator it = EnumSet.allOf(AIMMsgContentType.class).iterator();
        while (it.hasNext()) {
            AIMMsgContentType aIMMsgContentType = (AIMMsgContentType) it.next();
            sValueToEnumMap.put(Integer.valueOf(aIMMsgContentType.value), aIMMsgContentType);
        }
    }

    public static AIMMsgContentType forValue(int i) {
        return sValueToEnumMap.get(Integer.valueOf(i));
    }

    AIMMsgContentType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
