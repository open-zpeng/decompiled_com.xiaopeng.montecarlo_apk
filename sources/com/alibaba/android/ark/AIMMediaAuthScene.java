package com.alibaba.android.ark;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public enum AIMMediaAuthScene {
    MAC_UNKNOWN(0),
    MAC_GROUP_AVATOR(1),
    MAC_MSG(2);
    
    private static final Map<Integer, AIMMediaAuthScene> sValueToEnumMap = new HashMap();
    private final int value;

    static {
        Iterator it = EnumSet.allOf(AIMMediaAuthScene.class).iterator();
        while (it.hasNext()) {
            AIMMediaAuthScene aIMMediaAuthScene = (AIMMediaAuthScene) it.next();
            sValueToEnumMap.put(Integer.valueOf(aIMMediaAuthScene.value), aIMMediaAuthScene);
        }
    }

    public static AIMMediaAuthScene forValue(int i) {
        return sValueToEnumMap.get(Integer.valueOf(i));
    }

    AIMMediaAuthScene(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
