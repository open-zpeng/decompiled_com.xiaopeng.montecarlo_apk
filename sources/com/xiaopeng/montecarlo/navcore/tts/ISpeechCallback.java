package com.xiaopeng.montecarlo.navcore.tts;
/* loaded from: classes2.dex */
public interface ISpeechCallback {
    public static final int END_STATE_DONE = 0;
    public static final int END_STATE_STOP = 1;

    void onError(String str, String str2);

    void onReceived(byte[] bArr);

    void onSpeechFinish(String str, int i);

    void onSpeechStart(String str);
}
