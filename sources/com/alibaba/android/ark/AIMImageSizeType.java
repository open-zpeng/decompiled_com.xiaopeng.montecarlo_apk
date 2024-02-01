package com.alibaba.android.ark;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public enum AIMImageSizeType {
    IST_DEFAULT(-1),
    IST_ORIGIN(0),
    IST_FUZZY(1),
    IST_THUMB(2),
    IST_BIG(3),
    IST_120X120(100),
    IST_200X200(101),
    IST_1200X1200(102),
    IST_250X10000(103),
    IST_480X480(104),
    IST_640X640(105);
    
    private static final Map<Integer, AIMImageSizeType> sValueToEnumMap = new HashMap();
    private final int value;

    static {
        Iterator it = EnumSet.allOf(AIMImageSizeType.class).iterator();
        while (it.hasNext()) {
            AIMImageSizeType aIMImageSizeType = (AIMImageSizeType) it.next();
            sValueToEnumMap.put(Integer.valueOf(aIMImageSizeType.value), aIMImageSizeType);
        }
    }

    public static AIMImageSizeType forValue(int i) {
        return sValueToEnumMap.get(Integer.valueOf(i));
    }

    AIMImageSizeType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
