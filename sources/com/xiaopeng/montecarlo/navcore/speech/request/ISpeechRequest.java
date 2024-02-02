package com.xiaopeng.montecarlo.navcore.speech.request;
/* loaded from: classes2.dex */
public interface ISpeechRequest {
    void postRequest(int i);

    void postRequest(int i, String str);

    void postRequest(int i, String str, boolean z);

    void postRequest(int i, boolean z);

    void postRequest(SpeechRequest speechRequest, boolean z);

    Object postRequestForResult(int i);

    Object postRequestForResult(int i, String str);
}
