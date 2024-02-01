package com.xiaopeng.lib.apirouter.server;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class GuideInfoService_Manifest {
    public static final String DESCRIPTOR = "com.xiaopeng.montecarlo.appengine.GuideInfoService";
    public static final int TRANSACTION_getCongestionInfo = 1;
    public static final int TRANSACTION_getCurrentLocationInfo = 2;
    public static final int TRANSACTION_getHighWayInfo = 0;
    public static final int TRANSACTION_getTBTStatus = 3;

    public static String toJsonManifest() {
        return "{\"authority\":\"com.xiaopeng.montecarlo.appengine.GuideInfoService\",\"DESCRIPTOR\":\"com.xiaopeng.montecarlo.appengine.GuideInfoService\",\"TRANSACTION\":[{\"path\":\"getHighWayInfo\",\"METHOD\":\"getHighWayInfo\",\"ID\":0,\"parameter\":[]},{\"path\":\"getCongestionInfo\",\"METHOD\":\"getCongestionInfo\",\"ID\":1,\"parameter\":[]},{\"path\":\"getCurrentLocationInfo\",\"METHOD\":\"getCurrentLocationInfo\",\"ID\":2,\"parameter\":[]},{\"path\":\"getTBTStatus\",\"METHOD\":\"getTBTStatus\",\"ID\":3,\"parameter\":[]}]}";
    }

    public static Set<String> getKey() {
        HashSet hashSet = new HashSet(2);
        hashSet.add("GuideInfoService");
        return hashSet;
    }
}
