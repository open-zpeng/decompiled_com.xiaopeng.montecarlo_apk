package com.alibaba.android.ark;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public enum AIMConvTypingMessageContent {
    CONV_TYPING_MESSAGE_TYPE_UNKNOWN(0),
    CONV_TYPING_MESSAGE_TYPE_TEXT(1),
    CONV_TYPING_MESSAGE_TYPE_AUDIO(2);
    
    private static final Map<Integer, AIMConvTypingMessageContent> sValueToEnumMap = new HashMap();
    private final int value;

    static {
        Iterator it = EnumSet.allOf(AIMConvTypingMessageContent.class).iterator();
        while (it.hasNext()) {
            AIMConvTypingMessageContent aIMConvTypingMessageContent = (AIMConvTypingMessageContent) it.next();
            sValueToEnumMap.put(Integer.valueOf(aIMConvTypingMessageContent.value), aIMConvTypingMessageContent);
        }
    }

    public static AIMConvTypingMessageContent forValue(int i) {
        return sValueToEnumMap.get(Integer.valueOf(i));
    }

    AIMConvTypingMessageContent(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
