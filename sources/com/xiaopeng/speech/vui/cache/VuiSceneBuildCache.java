package com.xiaopeng.speech.vui.cache;

import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class VuiSceneBuildCache extends VuiSceneCache {
    public VuiSceneBuildCache() {
        this.mUploadedMap = new ConcurrentHashMap();
        this.mPre = "build_";
    }
}
