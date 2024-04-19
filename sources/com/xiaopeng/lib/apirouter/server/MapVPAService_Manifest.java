package com.xiaopeng.lib.apirouter.server;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class MapVPAService_Manifest {
    public static final String DESCRIPTOR = "com.xiaopeng.montecarlo.appengine.MapVPAService";
    public static final int TRANSACTION_update = 0;

    public static String toJsonManifest() {
        return "{\"authority\":\"com.xiaopeng.montecarlo.appengine.MapVPAService\",\"DESCRIPTOR\":\"com.xiaopeng.montecarlo.appengine.MapVPAService\",\"TRANSACTION\":[{\"path\":\"update\",\"METHOD\":\"update\",\"ID\":0,\"parameter\":[{\"alias\":\"version\",\"name\":\"version\"}]}]}";
    }

    public static Set<String> getKey() {
        HashSet hashSet = new HashSet(2);
        hashSet.add("MapVPAService");
        return hashSet;
    }
}
