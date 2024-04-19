package com.xiaopeng.lib.apirouter.server;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class RouteByPhoneService_Manifest {
    public static final String DESCRIPTOR = "com.xiaopeng.montecarlo.appengine.RouteByPhoneService";
    public static final int TRANSACTION_route = 0;

    public static String toJsonManifest() {
        return "{\"authority\":\"com.xiaopeng.montecarlo.appengine.RouteByPhoneService\",\"DESCRIPTOR\":\"com.xiaopeng.montecarlo.appengine.RouteByPhoneService\",\"TRANSACTION\":[{\"path\":\"route\",\"METHOD\":\"route\",\"ID\":0,\"parameter\":[]}]}";
    }

    public static Set<String> getKey() {
        HashSet hashSet = new HashSet(2);
        hashSet.add("RouteByPhoneService");
        return hashSet;
    }
}
