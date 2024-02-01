package com.alibaba.android.ark;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public enum AIMErrDomain {
    AIM_ERR_DOMAIN_CLIENT(0),
    AIM_ERR_DOMAIN_SERVER(1),
    AIM_ERR_EXTERNAL(2);
    
    private static final Map<Integer, AIMErrDomain> sValueToEnumMap = new HashMap();
    private final int value;

    static {
        Iterator it = EnumSet.allOf(AIMErrDomain.class).iterator();
        while (it.hasNext()) {
            AIMErrDomain aIMErrDomain = (AIMErrDomain) it.next();
            sValueToEnumMap.put(Integer.valueOf(aIMErrDomain.value), aIMErrDomain);
        }
    }

    public static AIMErrDomain forValue(int i) {
        return sValueToEnumMap.get(Integer.valueOf(i));
    }

    AIMErrDomain(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
