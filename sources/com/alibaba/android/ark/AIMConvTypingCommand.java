package com.alibaba.android.ark;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public enum AIMConvTypingCommand {
    CONV_TYPING_COMMAND_UNKNOWN(-1),
    CONV_TYPING_COMMAND_TYPING(0),
    CONV_TYPING_COMMAND_CANCEL(1);
    
    private static final Map<Integer, AIMConvTypingCommand> sValueToEnumMap = new HashMap();
    private final int value;

    static {
        Iterator it = EnumSet.allOf(AIMConvTypingCommand.class).iterator();
        while (it.hasNext()) {
            AIMConvTypingCommand aIMConvTypingCommand = (AIMConvTypingCommand) it.next();
            sValueToEnumMap.put(Integer.valueOf(aIMConvTypingCommand.value), aIMConvTypingCommand);
        }
    }

    public static AIMConvTypingCommand forValue(int i) {
        return sValueToEnumMap.get(Integer.valueOf(i));
    }

    AIMConvTypingCommand(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
