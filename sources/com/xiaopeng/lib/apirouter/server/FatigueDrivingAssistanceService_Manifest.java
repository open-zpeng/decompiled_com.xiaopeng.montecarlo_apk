package com.xiaopeng.lib.apirouter.server;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class FatigueDrivingAssistanceService_Manifest {
    public static final String DESCRIPTOR = "com.xiaopeng.montecarlo.appengine.FatigueDrivingAssistanceService";
    public static final int TRANSACTION_getMessage = 0;

    public static String toJsonManifest() {
        return "{\"authority\":\"com.xiaopeng.montecarlo.appengine.FatigueDrivingAssistanceService\",\"DESCRIPTOR\":\"com.xiaopeng.montecarlo.appengine.FatigueDrivingAssistanceService\",\"TRANSACTION\":[{\"path\":\"getMessage\",\"METHOD\":\"getMessage\",\"ID\":0,\"parameter\":[{\"alias\":\"param\",\"name\":\"param\"}]}]}";
    }

    public static Set<String> getKey() {
        HashSet hashSet = new HashSet(2);
        hashSet.add("FatigueDrivingAssistanceService");
        return hashSet;
    }
}
