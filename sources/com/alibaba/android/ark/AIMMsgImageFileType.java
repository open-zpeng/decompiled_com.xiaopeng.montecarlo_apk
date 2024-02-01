package com.alibaba.android.ark;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public enum AIMMsgImageFileType {
    IMAGE_FILE_TYPE_UNKNOWN(-1),
    IMAGE_FILE_TYPE_WEBP(1),
    IMAGE_FILE_TYPE_PNG(2),
    IMAGE_FILE_TYPE_JPG(3),
    IMAGE_FILE_TYPE_GIF(4);
    
    private static final Map<Integer, AIMMsgImageFileType> sValueToEnumMap = new HashMap();
    private final int value;

    static {
        Iterator it = EnumSet.allOf(AIMMsgImageFileType.class).iterator();
        while (it.hasNext()) {
            AIMMsgImageFileType aIMMsgImageFileType = (AIMMsgImageFileType) it.next();
            sValueToEnumMap.put(Integer.valueOf(aIMMsgImageFileType.value), aIMMsgImageFileType);
        }
    }

    public static AIMMsgImageFileType forValue(int i) {
        return sValueToEnumMap.get(Integer.valueOf(i));
    }

    AIMMsgImageFileType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
