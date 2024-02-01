package com.xiaopeng.montecarlo.appengine;

import com.xiaopeng.lib.apirouter.server.IServicePublisher;
import com.xiaopeng.lib.apirouter.server.Publish;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.VoiceFullScenesUtil;
import com.xiaopeng.speech.vui.VuiEngine;
/* loaded from: classes.dex */
public class FullScenesObserver implements IServicePublisher {
    private static final L.Tag TAG = new L.Tag("FullScenesObserver");

    @Publish
    public void onEvent(String str, String str2, String str3) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("onEvent event:" + str + ",data:" + str2 + ",sceneId:" + str3));
        }
        VoiceFullScenesUtil.dispatchVuiEvent(str, str2);
    }

    @Publish
    public String getElementState(String str, String str2) {
        String elementState = VuiEngine.getInstance(ContextUtils.getContext()).getElementState(str, str2);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("getElementState sceneId:" + str + ",elementId:" + str2 + ",result:" + elementState));
        }
        return elementState;
    }
}
