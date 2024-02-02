package com.xiaopeng.lib.apirouter.server;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class AosService_Manifest {
    public static final String DESCRIPTOR = "com.xiaopeng.montecarlo.appengine.AosService";
    public static final int TRANSACTION_requestQueryPersentWeather = 0;

    public static String toJsonManifest() {
        return "{\"authority\":\"com.xiaopeng.montecarlo.appengine.AosService\",\"DESCRIPTOR\":\"com.xiaopeng.montecarlo.appengine.AosService\",\"TRANSACTION\":[{\"path\":\"requestQueryPersentWeather\",\"METHOD\":\"requestQueryPersentWeather\",\"ID\":0,\"parameter\":[{\"alias\":\"adcode\",\"name\":\"adcode\"}]}]}";
    }

    public static Set<String> getKey() {
        HashSet hashSet = new HashSet(2);
        hashSet.add("AosService");
        return hashSet;
    }
}
