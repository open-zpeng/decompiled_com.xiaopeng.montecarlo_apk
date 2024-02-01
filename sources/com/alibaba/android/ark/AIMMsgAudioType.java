package com.alibaba.android.ark;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public enum AIMMsgAudioType {
    AUDIO_TYPE_UNKNOWN(-1),
    AUDIO_TYPE_OPUS(0),
    AUDIO_TYPE_OGG(1),
    AUDIO_TYPE_AMR(2);
    
    private static final Map<Integer, AIMMsgAudioType> sValueToEnumMap = new HashMap();
    private final int value;

    static {
        Iterator it = EnumSet.allOf(AIMMsgAudioType.class).iterator();
        while (it.hasNext()) {
            AIMMsgAudioType aIMMsgAudioType = (AIMMsgAudioType) it.next();
            sValueToEnumMap.put(Integer.valueOf(aIMMsgAudioType.value), aIMMsgAudioType);
        }
    }

    public static AIMMsgAudioType forValue(int i) {
        return sValueToEnumMap.get(Integer.valueOf(i));
    }

    AIMMsgAudioType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
