package com.xiaopeng.lib.apirouter.server;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class AccountDataService_Manifest {
    public static final String DESCRIPTOR = "com.xiaopeng.montecarlo.appengine.AccountDataService";
    public static final int TRANSACTION_getAccountId = 0;
    public static final int TRANSACTION_getAccountOpenId = 1;
    public static final int TRANSACTION_getAccountSid = 2;
    public static final int TRANSACTION_getDataVersion = 3;

    public static String toJsonManifest() {
        return "{\"authority\":\"com.xiaopeng.montecarlo.appengine.AccountDataService\",\"DESCRIPTOR\":\"com.xiaopeng.montecarlo.appengine.AccountDataService\",\"TRANSACTION\":[{\"path\":\"getAccountId\",\"METHOD\":\"getAccountId\",\"ID\":0,\"parameter\":[]},{\"path\":\"getAccountOpenId\",\"METHOD\":\"getAccountOpenId\",\"ID\":1,\"parameter\":[]},{\"path\":\"getAccountSid\",\"METHOD\":\"getAccountSid\",\"ID\":2,\"parameter\":[]},{\"path\":\"getDataVersion\",\"METHOD\":\"getDataVersion\",\"ID\":3,\"parameter\":[{\"alias\":\"dataType\",\"name\":\"dataType\"}]}]}";
    }

    public static Set<String> getKey() {
        HashSet hashSet = new HashSet(2);
        hashSet.add("AccountDataService");
        return hashSet;
    }
}
