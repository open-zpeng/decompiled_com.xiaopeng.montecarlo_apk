package com.xiaopeng.lib.apirouter.server;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class SearchService_Manifest {
    public static final String DESCRIPTOR = "com.xiaopeng.montecarlo.appengine.SearchService";
    public static final int TRANSACTION_searchByBL = 0;

    public static String toJsonManifest() {
        return "{\"authority\":\"com.xiaopeng.montecarlo.appengine.SearchService\",\"DESCRIPTOR\":\"com.xiaopeng.montecarlo.appengine.SearchService\",\"TRANSACTION\":[{\"path\":\"searchByBL\",\"METHOD\":\"searchByBL\",\"ID\":0,\"parameter\":[{\"alias\":\"requestJson\",\"name\":\"requestJson\"},{\"alias\":\"callbackUri\",\"name\":\"callbackUri\"}]}]}";
    }

    public static Set<String> getKey() {
        HashSet hashSet = new HashSet(2);
        hashSet.add("SearchService");
        return hashSet;
    }
}
