package com.xiaopeng.lib.apirouter.server;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class MapStatusService_Manifest {
    public static final String DESCRIPTOR = "com.xiaopeng.montecarlo.appengine.MapStatusService";
    public static final int TRANSACTION_isMapFirstFrameDrew = 0;

    public static String toJsonManifest() {
        return "{\"authority\":\"com.xiaopeng.montecarlo.appengine.MapStatusService\",\"DESCRIPTOR\":\"com.xiaopeng.montecarlo.appengine.MapStatusService\",\"TRANSACTION\":[{\"path\":\"isMapFirstFrameDrew\",\"METHOD\":\"isMapFirstFrameDrew\",\"ID\":0,\"parameter\":[]}]}";
    }

    public static Set<String> getKey() {
        HashSet hashSet = new HashSet(2);
        hashSet.add("MapStatusService");
        return hashSet;
    }
}
