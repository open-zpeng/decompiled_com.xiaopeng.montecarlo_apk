package com.xiaopeng.montecarlo.util;

import android.content.Context;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import com.xiaopeng.montecarlo.navcore.tts.ISpeechCallback;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class SpeechRecognizerHelper {
    public static final String KEY_PARAM_PRIORITY = "priority";
    public static final String KEY_PARAM_TTS_MODE = "ttsMode";
    public static final int PRIORITY_DEFAULT = 1;
    public static final int PRIORITY_IMPORTANT = 2;
    public static final int PRIORITY_NORMAL = 1;
    public static final int PRIORITY_URGENT = 3;
    private static final L.Tag TAG = new L.Tag("SpeechRecognizerHelper");
    public static final int TTS_MODE_AUTO = 0;
    public static final int TTS_MODE_CLOUD = 2;
    public static final int TTS_MODE_LOCAL = 1;
    public static final String TTS_SPEAK_ERROR = "ERROR";
    public static final String TTS_SPEAK_SUCCESS = "SUCCESS";
    private static final String XP_UTTERANCE_ID = "xp-navi";
    private final ConcurrentHashMap<String, ISpeechCallback> mCallbacks = new ConcurrentHashMap<>();
    private TextToSpeech mTextToSpeech;

    SpeechRecognizerHelper() {
    }

    /* loaded from: classes3.dex */
    private static class Holder {
        private static final SpeechRecognizerHelper Instance = new SpeechRecognizerHelper();

        private Holder() {
        }
    }

    public static SpeechRecognizerHelper instance() {
        return Holder.Instance;
    }

    /* renamed from: com.xiaopeng.montecarlo.util.SpeechRecognizerHelper$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements TextToSpeech.OnInitListener {
        AnonymousClass1() {
        }

        @Override // android.speech.tts.TextToSpeech.OnInitListener
        public void onInit(final int i) {
            WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.util.SpeechRecognizerHelper.1.1
                @Override // java.lang.Runnable
                public void run() {
                    L.Tag tag = SpeechRecognizerHelper.TAG;
                    L.i(tag, "TextToSpeech onInit status = " + i);
                    if (i != 0 || SpeechRecognizerHelper.this.mTextToSpeech == null) {
                        return;
                    }
                    int language = SpeechRecognizerHelper.this.mTextToSpeech.setLanguage(Locale.CHINESE);
                    L.Tag tag2 = SpeechRecognizerHelper.TAG;
                    L.i(tag2, "setLanguage CHINESE " + language);
                    SpeechRecognizerHelper.this.mTextToSpeech.setOnUtteranceProgressListener(new UtteranceProgressListener() { // from class: com.xiaopeng.montecarlo.util.SpeechRecognizerHelper.1.1.1
                        @Override // android.speech.tts.UtteranceProgressListener
                        public void onStart(String str) {
                            if (L.ENABLE) {
                                L.Tag tag3 = SpeechRecognizerHelper.TAG;
                                L.d(tag3, "onStart " + str);
                            }
                            ISpeechCallback iSpeechCallback = (ISpeechCallback) SpeechRecognizerHelper.this.mCallbacks.get(str);
                            if (iSpeechCallback != null) {
                                iSpeechCallback.onSpeechStart(str);
                            }
                        }

                        @Override // android.speech.tts.UtteranceProgressListener
                        public void onDone(String str) {
                            if (L.ENABLE) {
                                L.Tag tag3 = SpeechRecognizerHelper.TAG;
                                L.d(tag3, "onDone " + str);
                            }
                            ISpeechCallback iSpeechCallback = (ISpeechCallback) SpeechRecognizerHelper.this.mCallbacks.remove(str);
                            if (iSpeechCallback != null) {
                                iSpeechCallback.onSpeechFinish(str, 0);
                            }
                        }

                        @Override // android.speech.tts.UtteranceProgressListener
                        public void onError(String str) {
                            if (L.ENABLE) {
                                L.Tag tag3 = SpeechRecognizerHelper.TAG;
                                L.d(tag3, "onError " + str);
                            }
                            ISpeechCallback iSpeechCallback = (ISpeechCallback) SpeechRecognizerHelper.this.mCallbacks.remove(str);
                            if (iSpeechCallback != null) {
                                iSpeechCallback.onError(str, "onError");
                            }
                        }

                        @Override // android.speech.tts.UtteranceProgressListener
                        public void onStop(String str, boolean z) {
                            if (L.ENABLE) {
                                L.Tag tag3 = SpeechRecognizerHelper.TAG;
                                L.d(tag3, "onStop " + str);
                            }
                            ISpeechCallback iSpeechCallback = (ISpeechCallback) SpeechRecognizerHelper.this.mCallbacks.remove(str);
                            if (iSpeechCallback != null) {
                                iSpeechCallback.onSpeechFinish(str, 1);
                            }
                        }
                    });
                }
            });
        }
    }

    public void init(Context context) {
        this.mTextToSpeech = new TextToSpeech(context, new AnonymousClass1());
    }

    public String speak(String str, String str2, int i, int i2, int i3, ISpeechCallback iSpeechCallback) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "speak text=" + str2);
        }
        if (this.mTextToSpeech != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("streamType", i3);
            bundle.putInt("priority", i);
            bundle.putInt(KEY_PARAM_TTS_MODE, 1);
            if (iSpeechCallback != null) {
                this.mCallbacks.put(str, iSpeechCallback);
            }
            return this.mTextToSpeech.speak(str2, 1, bundle, str) == 0 ? TTS_SPEAK_SUCCESS : TTS_SPEAK_ERROR;
        }
        return TTS_SPEAK_ERROR;
    }

    public void shutup() {
        if (L.ENABLE) {
            L.d(TAG, "shutup");
        }
        TextToSpeech textToSpeech = this.mTextToSpeech;
        if (textToSpeech != null) {
            textToSpeech.stop();
        }
    }

    public void release() {
        if (L.ENABLE) {
            L.d(TAG, "release");
        }
        TextToSpeech textToSpeech = this.mTextToSpeech;
        if (textToSpeech != null) {
            textToSpeech.shutdown();
        }
    }
}
