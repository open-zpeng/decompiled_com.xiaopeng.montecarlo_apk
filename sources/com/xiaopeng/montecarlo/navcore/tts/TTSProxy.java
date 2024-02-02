package com.xiaopeng.montecarlo.navcore.tts;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.root.util.AudioManagerWrapper;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes2.dex */
public class TTSProxy {
    private static final L.Tag TAG = new L.Tag("TTSProxy");
    private boolean mIsTtsEnable;
    private ISpeech mSpeech;

    private TTSProxy() {
        this.mIsTtsEnable = false;
    }

    @NonNull
    public static TTSProxy getInstance() {
        return SingletonHolder.sInstance;
    }

    public void setSpeech(ISpeech iSpeech) {
        this.mSpeech = iSpeech;
    }

    public boolean isTtsEnabled() {
        return !AudioManagerWrapper.getInstance().isMute() && this.mIsTtsEnable;
    }

    public void setTtsEnable(boolean z) {
        this.mIsTtsEnable = z;
        if (this.mIsTtsEnable) {
            return;
        }
        shutUp(null);
    }

    public void init(Context context) {
        ISpeech iSpeech = this.mSpeech;
        if (iSpeech == null) {
            throw new SpeechImplementationNotSettingException();
        }
        iSpeech.init(context);
    }

    public String getSpeaker() {
        ISpeech iSpeech = this.mSpeech;
        if (iSpeech == null) {
            throw new SpeechImplementationNotSettingException();
        }
        return iSpeech.getSpeaker();
    }

    public void setSpeaker(String str) {
        ISpeech iSpeech = this.mSpeech;
        if (iSpeech == null) {
            throw new SpeechImplementationNotSettingException();
        }
        iSpeech.setSpeaker(str);
    }

    public float getSpeed() {
        ISpeech iSpeech = this.mSpeech;
        if (iSpeech == null) {
            throw new SpeechImplementationNotSettingException();
        }
        return iSpeech.getSpeed();
    }

    public void setSpeed(float f) {
        ISpeech iSpeech = this.mSpeech;
        if (iSpeech == null) {
            throw new SpeechImplementationNotSettingException();
        }
        iSpeech.setSpeed(f);
    }

    public int getVolume() {
        ISpeech iSpeech = this.mSpeech;
        if (iSpeech == null) {
            throw new SpeechImplementationNotSettingException();
        }
        return iSpeech.getVolume();
    }

    public void setVolume(int i) {
        ISpeech iSpeech = this.mSpeech;
        if (iSpeech == null) {
            throw new SpeechImplementationNotSettingException();
        }
        iSpeech.setVolume(i);
    }

    @Nullable
    public String speak(String str, ISpeechCallback iSpeechCallback) {
        if (this.mSpeech == null) {
            throw new SpeechImplementationNotSettingException();
        }
        if (isTtsEnabled()) {
            return this.mSpeech.speak(str, iSpeechCallback);
        }
        return null;
    }

    @Nullable
    public String speakByImportant(String str, ISpeechCallback iSpeechCallback) {
        if (this.mSpeech == null) {
            throw new SpeechImplementationNotSettingException();
        }
        if (isTtsEnabled()) {
            return this.mSpeech.speakByImportant(str, iSpeechCallback);
        }
        return null;
    }

    public String speakByUrgent(String str, ISpeechCallback iSpeechCallback) {
        ISpeech iSpeech = this.mSpeech;
        if (iSpeech == null) {
            throw new SpeechImplementationNotSettingException();
        }
        return iSpeech.speakByUrgent(str, iSpeechCallback);
    }

    public void shutUp(String str) {
        ISpeech iSpeech = this.mSpeech;
        if (iSpeech == null) {
            throw new SpeechImplementationNotSettingException();
        }
        iSpeech.shutUp(str);
    }

    public void pause() {
        ISpeech iSpeech = this.mSpeech;
        if (iSpeech == null) {
            throw new SpeechImplementationNotSettingException();
        }
        iSpeech.pause();
    }

    public void resume() {
        ISpeech iSpeech = this.mSpeech;
        if (iSpeech == null) {
            throw new SpeechImplementationNotSettingException();
        }
        iSpeech.resume();
    }

    public void release(String str) {
        ISpeech iSpeech = this.mSpeech;
        if (iSpeech == null) {
            throw new SpeechImplementationNotSettingException();
        }
        iSpeech.release(str);
    }

    public void removeCallback(String str) {
        ISpeech iSpeech = this.mSpeech;
        if (iSpeech == null) {
            throw new SpeechImplementationNotSettingException();
        }
        iSpeech.removeCallback(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class SingletonHolder {
        @NonNull
        private static TTSProxy sInstance = new TTSProxy();

        private SingletonHolder() {
        }
    }

    /* loaded from: classes2.dex */
    public class SpeechImplementationNotSettingException extends RuntimeException {
        public SpeechImplementationNotSettingException() {
            super("speech implementatin not setting!!!");
        }
    }
}
