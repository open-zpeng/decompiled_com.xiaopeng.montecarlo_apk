package com.xiaopeng.montecarlo.navcore.speech.stat;

import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public class SpeechStatProxy {
    public static final int STAT_SPEECH_FAILED = 3;
    public static final int STAT_SPEECH_NOT_PERFORMED = 0;
    public static final int STAT_SPEECH_NO_RESULT = 1;
    public static final int STAT_SPEECH_SUCCESS = 2;
    private static final L.Tag TAG = new L.Tag("SpeechStatProxy");
    private static SpeechStatProxy sInstance = new SpeechStatProxy();
    private ISpeechStat mSpeechStat;

    public static SpeechStatProxy getInstance() {
        return sInstance;
    }

    public void init(ISpeechStat iSpeechStat) {
        this.mSpeechStat = iSpeechStat;
    }

    public void deinit() {
        this.mSpeechStat = null;
    }

    public void sendStatDataForSpeech(int i, int i2) {
        ISpeechStat iSpeechStat = this.mSpeechStat;
        if (iSpeechStat != null) {
            iSpeechStat.sendStatDataForSpeech(i, i2);
        } else {
            L.i(TAG, "sendStatDataForSpeech, mSpeechStat is null");
        }
    }
}
