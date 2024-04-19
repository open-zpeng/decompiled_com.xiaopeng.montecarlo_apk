package com.xiaopeng.montecarlo.navcore.tts;

import android.content.Context;
/* loaded from: classes3.dex */
public interface ISpeech {
    String getSpeaker();

    float getSpeed();

    int getVolume();

    void init(Context context);

    void pause();

    void release(String str);

    void removeCallback(String str);

    void resume();

    void setSpeaker(String str);

    void setSpeed(float f);

    void setVolume(int i);

    void shutUp(String str);

    String speak(String str, ISpeechCallback iSpeechCallback);

    String speakByImportant(String str, ISpeechCallback iSpeechCallback);

    String speakByUrgent(String str, ISpeechCallback iSpeechCallback);
}
