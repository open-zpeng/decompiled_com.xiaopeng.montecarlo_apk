package com.xiaopeng.speech.apirouter;

import android.util.Log;
import com.xiaopeng.lib.apirouter.server.IServicePublisher;
import com.xiaopeng.lib.apirouter.server.Publish;
import com.xiaopeng.speech.XpSpeechEngine;
/* loaded from: classes3.dex */
public class ApiRouterSceneService implements IServicePublisher {
    @Publish
    public void onEvent(String str, String str2) {
        Log.i("ApiRouterSceneService", "消息接收 event== " + str + ",data:" + str2);
        XpSpeechEngine.dispatchVuiEvent(str, str2);
    }

    @Publish
    public String getElementState(String str, String str2) {
        return XpSpeechEngine.getElementState(str, str2);
    }
}
