package com.alibaba.android.ark;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public enum AIMGroupMemberRole {
    GROUP_MEMBER_ROLE_UNKNOW(0),
    GROUP_MEMBER_ROLE_OWNER(1),
    GROUP_MEMBER_ROLE_ADMIN(2),
    GROUP_MEMBER_ROLE_NORMAL(3);
    
    private static final Map<Integer, AIMGroupMemberRole> sValueToEnumMap = new HashMap();
    private final int value;

    static {
        Iterator it = EnumSet.allOf(AIMGroupMemberRole.class).iterator();
        while (it.hasNext()) {
            AIMGroupMemberRole aIMGroupMemberRole = (AIMGroupMemberRole) it.next();
            sValueToEnumMap.put(Integer.valueOf(aIMGroupMemberRole.value), aIMGroupMemberRole);
        }
    }

    public static AIMGroupMemberRole forValue(int i) {
        return sValueToEnumMap.get(Integer.valueOf(i));
    }

    AIMGroupMemberRole(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
