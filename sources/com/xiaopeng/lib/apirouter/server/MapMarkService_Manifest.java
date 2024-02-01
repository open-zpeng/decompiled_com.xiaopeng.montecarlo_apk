package com.xiaopeng.lib.apirouter.server;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class MapMarkService_Manifest {
    public static final String DESCRIPTOR = "com.xiaopeng.montecarlo.appengine.MapMarkService";
    public static final int TRANSACTION_clearMark = 1;
    public static final int TRANSACTION_drawMark = 0;
    public static final int TRANSACTION_drawMarks = 2;

    public static String toJsonManifest() {
        return "{\"authority\":\"com.xiaopeng.montecarlo.appengine.MapMarkService\",\"DESCRIPTOR\":\"com.xiaopeng.montecarlo.appengine.MapMarkService\",\"TRANSACTION\":[{\"path\":\"drawMark\",\"METHOD\":\"drawMark\",\"ID\":0,\"parameter\":[{\"alias\":\"type\",\"name\":\"type\"},{\"alias\":\"coordinateType\",\"name\":\"coordinateType\"},{\"alias\":\"lon\",\"name\":\"lon\"},{\"alias\":\"lat\",\"name\":\"lat\"},{\"alias\":\"z\",\"name\":\"z\"}]},{\"path\":\"clearMark\",\"METHOD\":\"clearMark\",\"ID\":1,\"parameter\":[{\"alias\":\"type\",\"name\":\"type\"}]},{\"path\":\"drawMarks\",\"METHOD\":\"drawMarks\",\"ID\":2,\"parameter\":[{\"alias\":\"type\",\"name\":\"type\"},{\"alias\":\"marks\",\"name\":\"marks\"}]}]}";
    }

    public static Set<String> getKey() {
        HashSet hashSet = new HashSet(2);
        hashSet.add("MapMarkService");
        return hashSet;
    }
}
