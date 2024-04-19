package com.xiaopeng.lib.apirouter.server;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class ChargeStationService_Manifest {
    public static final String DESCRIPTOR = "com.xiaopeng.montecarlo.appengine.ChargeStationService";
    public static final int TRANSACTION_searchCharge = 0;

    public static String toJsonManifest() {
        return "{\"authority\":\"com.xiaopeng.montecarlo.appengine.ChargeStationService\",\"DESCRIPTOR\":\"com.xiaopeng.montecarlo.appengine.ChargeStationService\",\"TRANSACTION\":[{\"path\":\"searchCharge\",\"METHOD\":\"searchCharge\",\"ID\":0,\"parameter\":[]}]}";
    }

    public static Set<String> getKey() {
        HashSet hashSet = new HashSet(2);
        hashSet.add("ChargeStationService");
        return hashSet;
    }
}
