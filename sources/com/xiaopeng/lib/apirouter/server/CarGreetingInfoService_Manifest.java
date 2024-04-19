package com.xiaopeng.lib.apirouter.server;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class CarGreetingInfoService_Manifest {
    public static final String DESCRIPTOR = "com.xiaopeng.montecarlo.appengine.CarGreetingInfoService";
    public static final int TRANSACTION_clearRenderRoutes = 3;
    public static final int TRANSACTION_getAroundTrafficInfo = 1;
    public static final int TRANSACTION_onMoveSearchBar = 2;
    public static final int TRANSACTION_renderRoutes = 4;
    public static final int TRANSACTION_setActiveState = 0;

    public static String toJsonManifest() {
        return "{\"authority\":\"com.xiaopeng.montecarlo.appengine.CarGreetingInfoService\",\"DESCRIPTOR\":\"com.xiaopeng.montecarlo.appengine.CarGreetingInfoService\",\"TRANSACTION\":[{\"path\":\"setActiveState\",\"METHOD\":\"setActiveState\",\"ID\":0,\"parameter\":[{\"alias\":\"activeState\",\"name\":\"activeState\"}]},{\"path\":\"getAroundTrafficInfo\",\"METHOD\":\"getAroundTrafficInfo\",\"ID\":1,\"parameter\":[{\"alias\":\"ratioScale\",\"name\":\"ratioScale\"}]},{\"path\":\"onMoveSearchBar\",\"METHOD\":\"onMoveSearchBar\",\"ID\":2,\"parameter\":[{\"alias\":\"isDownMove\",\"name\":\"isDownMove\"}]},{\"path\":\"clearRenderRoutes\",\"METHOD\":\"clearRenderRoutes\",\"ID\":3,\"parameter\":[]},{\"path\":\"renderRoutes\",\"METHOD\":\"renderRoutes\",\"ID\":4,\"parameter\":[{\"alias\":\"endInfoData\",\"name\":\"endInfoData\"}]}]}";
    }

    public static Set<String> getKey() {
        HashSet hashSet = new HashSet(2);
        hashSet.add("CarGreetingInfoService");
        return hashSet;
    }
}
