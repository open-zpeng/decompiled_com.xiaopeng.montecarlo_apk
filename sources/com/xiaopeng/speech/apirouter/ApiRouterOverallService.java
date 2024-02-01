package com.xiaopeng.speech.apirouter;

import android.util.Log;
import com.xiaopeng.lib.apirouter.server.IServicePublisher;
import com.xiaopeng.lib.apirouter.server.Publish;
import com.xiaopeng.speech.XpSpeechEngine;
/* loaded from: classes3.dex */
public class ApiRouterOverallService implements IServicePublisher {
    @Publish
    public void onEvent(String str, String str2) {
        Log.d("ApiRouterOverallService", "消息接收 event== " + str + ",data:" + str2);
        XpSpeechEngine.dispatchOverallEvent(str, str2);
    }

    @Publish
    public void onQuery(String str, String str2, String str3) {
        Log.d("ApiRouterOverallService", "消息接收 event== " + str + ",data:" + str2);
        XpSpeechEngine.dispatchOverallQuery(str, str2, str3);
    }
}
