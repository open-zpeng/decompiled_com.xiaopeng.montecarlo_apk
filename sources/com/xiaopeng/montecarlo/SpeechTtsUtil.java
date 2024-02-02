package com.xiaopeng.montecarlo;

import android.content.Context;
import com.xiaopeng.montecarlo.navcore.tts.ISpeechCallback;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.SpeechRecognizerHelper;
import com.xiaopeng.speech.SpeechClient;
import java.util.UUID;
/* loaded from: classes2.dex */
class SpeechTtsUtil {
    private static final String NAVI_NAME_1 = "导航";
    private static final String NAVI_NAME_2 = "地图";
    public static final int STREAM_TTS = 9;
    private static final L.Tag TAG = new L.Tag("SpeechTtsUtil");

    /* JADX INFO: Access modifiers changed from: protected */
    public String getSpeaker() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getSpeed() {
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getVolume() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void removeCallback(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSpeaker(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSpeed(float f) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setVolume(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init(Context context) {
        L.i(TAG, "init");
        SpeechClient.instance().init(context);
        SpeechClient.instance().setAppName(NAVI_NAME_1, NAVI_NAME_2);
        SpeechRecognizerHelper.instance().init(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String speak(String str, ISpeechCallback iSpeechCallback) {
        String speak = speak(str, 1, 3, iSpeechCallback);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "speak text:" + str + ",callback:" + iSpeechCallback + ",ttsId:" + speak);
        }
        return speak;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String speakByImportant(String str, ISpeechCallback iSpeechCallback) {
        String speak = speak(str, 2, 3, iSpeechCallback);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "speakByImportant text:" + str + ",callback:" + iSpeechCallback + ",ttsId:" + speak);
        }
        return speak;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String speakByUrgent(String str, ISpeechCallback iSpeechCallback) {
        String speak = speak(str, 3, 3, iSpeechCallback);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "speakByUrgent text:" + str + ",callback:" + iSpeechCallback + ",ttsId:" + speak);
        }
        return speak;
    }

    protected String speak(String str, int i, int i2, ISpeechCallback iSpeechCallback) {
        String speak = SpeechRecognizerHelper.instance().speak(UUID.randomUUID().toString() + System.currentTimeMillis(), str, i, i2, 9, iSpeechCallback);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "speak text:" + str + ",priority:" + i + ",audioFocus:" + i2 + ",callback:" + iSpeechCallback + ",ttsId:" + speak);
        }
        return speak;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void shutup(String str) {
        L.Tag tag = TAG;
        L.i(tag, "shutUp ttsId:" + str);
        SpeechRecognizerHelper.instance().shutup();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void release(String str) {
        L.Tag tag = TAG;
        L.i(tag, "release ttsId:" + str);
        SpeechRecognizerHelper.instance().release();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pause() {
        L.i(TAG, "pause");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resume() {
        L.i(TAG, "resume");
    }
}
