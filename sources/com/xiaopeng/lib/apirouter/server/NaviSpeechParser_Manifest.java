package com.xiaopeng.lib.apirouter.server;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class NaviSpeechParser_Manifest {
    public static final String DESCRIPTOR = "com.xiaopeng.montecarlo.service.navi.parser.NaviSpeechParser";
    public static final int TRANSACTION_handleSpeechCmdFromApiRouter = 0;

    public static String toJsonManifest() {
        return "{\"authority\":\"com.xiaopeng.montecarlo.service.navi.parser.NaviSpeechParser\",\"DESCRIPTOR\":\"com.xiaopeng.montecarlo.service.navi.parser.NaviSpeechParser\",\"TRANSACTION\":[{\"path\":\"handleSpeechCmdFromApiRouter\",\"METHOD\":\"handleSpeechCmdFromApiRouter\",\"ID\":0,\"parameter\":[{\"alias\":\"content\",\"name\":\"content\"}]}]}";
    }

    public static Set<String> getKey() {
        HashSet hashSet = new HashSet(2);
        hashSet.add("NaviSpeechParser");
        return hashSet;
    }
}
