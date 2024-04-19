package com.xiaopeng.lib.apirouter.server;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class LicensePlateService_Manifest {
    public static final String DESCRIPTOR = "com.xiaopeng.montecarlo.appengine.LicensePlateService";
    public static final int TRANSACTION_getLicensePlate = 0;

    public static String toJsonManifest() {
        return "{\"authority\":\"com.xiaopeng.montecarlo.appengine.LicensePlateService\",\"DESCRIPTOR\":\"com.xiaopeng.montecarlo.appengine.LicensePlateService\",\"TRANSACTION\":[{\"path\":\"getLicensePlate\",\"METHOD\":\"getLicensePlate\",\"ID\":0,\"parameter\":[]}]}";
    }

    public static Set<String> getKey() {
        HashSet hashSet = new HashSet(2);
        hashSet.add("LicensePlateService");
        return hashSet;
    }
}
