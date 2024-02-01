package com.xiaopeng.lib.apirouter.server;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class CallThirdPartLoginService_Manifest {
    public static final String DESCRIPTOR = "com.xiaopeng.montecarlo.appengine.CallThirdPartLoginService";
    public static final int TRANSACTION_weChat = 0;

    public static String toJsonManifest() {
        return "{\"authority\":\"com.xiaopeng.montecarlo.appengine.CallThirdPartLoginService\",\"DESCRIPTOR\":\"com.xiaopeng.montecarlo.appengine.CallThirdPartLoginService\",\"TRANSACTION\":[{\"path\":\"weChat\",\"METHOD\":\"weChat\",\"ID\":0,\"parameter\":[]}]}";
    }

    public static Set<String> getKey() {
        HashSet hashSet = new HashSet(2);
        hashSet.add("CallThirdPartLoginService");
        return hashSet;
    }
}
