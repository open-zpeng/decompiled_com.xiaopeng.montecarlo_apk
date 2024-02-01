package com.xiaopeng.speech.protocol.node.music;

import com.xiaopeng.speech.SpeechClient;
import com.xiaopeng.speech.SpeechNode;
import com.xiaopeng.speech.annotation.SpeechAnnotation;
import com.xiaopeng.speech.common.util.LogUtils;
import com.xiaopeng.speech.protocol.SpeechUtils;
import com.xiaopeng.speech.protocol.event.MusicEvent;
import com.xiaopeng.speech.protocol.node.context.AbsContextListener;
import com.xiaopeng.speech.protocol.node.context.ContextNode;
import com.xiaopeng.speech.protocol.node.music.bean.CollectHistoryMusic;
import com.xiaopeng.speech.protocol.node.music.bean.SearchMusic;
import com.xiaopeng.speech.speechwidget.SpeechWidget;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class MusicNode extends SpeechNode<MusicListener> {
    private static final String TAG = "MusicNode";

    public MusicNode() {
        SpeechUtils.subscribe(ContextNode.class, new AbsContextListener() { // from class: com.xiaopeng.speech.protocol.node.music.MusicNode.1
            @Override // com.xiaopeng.speech.protocol.node.context.AbsContextListener, com.xiaopeng.speech.protocol.node.context.ContextListener
            public void onWidgetText(String str) {
                JSONObject optJSONObject;
                super.onWidgetText(str);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (!"music_list_play".equals(jSONObject.optString("function")) || (optJSONObject = jSONObject.optJSONObject(SpeechWidget.WIDGET_EXTRA)) == null) {
                        return;
                    }
                    MusicNode.this.onMusicListPlay("command://music.list.play", optJSONObject.optString("param"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation(event = "command://music.control.play")
    public void onPlay(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((MusicListener) obj).onPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation(event = "command://music.control.loop.single")
    public void onPlayLoopSingle(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((MusicListener) obj).onPlayMode("single");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation(event = "command://music.control.loop.all")
    public void onPlayLoopAll(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((MusicListener) obj).onPlayMode("order");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation(event = "command://music.control.random")
    public void onPlayLoopRandom(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((MusicListener) obj).onPlayMode("random");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation(event = "native://music.search")
    public void onSearch(String str, String str2) {
        SearchMusic fromJson = SearchMusic.fromJson(str2);
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((MusicListener) obj).onSearch(str, fromJson);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation(event = "command://music.control.pause")
    public void onPause(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((MusicListener) obj).onPause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation(event = "command://music.control.resume")
    public void onResume(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((MusicListener) obj).onResume();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation(event = "command://music.control.prev")
    public void onPrev(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((MusicListener) obj).onPrev();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation(event = "command://music.control.next")
    public void onNext(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((MusicListener) obj).onNext();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation(event = "command://music.control.stop")
    public void onStop(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((MusicListener) obj).onStop();
            }
        }
    }

    protected void onExit(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((MusicListener) obj).onExit();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation(event = "command://music.control.bluetooth.play.random")
    public void onPlayBlueTooth(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((MusicListener) obj).onPlayBluetooth();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation(event = "native://music.playmode.support")
    public void onSupportPlayModeChange(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((MusicListener) obj).onSupportPlayModeChange(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation(event = "command://music.audiobook.play")
    public void onAudioBookPlay(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((MusicListener) obj).onAudioBookPlay(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation(event = "command://music.list.play")
    public void onMusicListPlay(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (SpeechUtils.isJson(str2)) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (jSONObject.has("from") && "dui_xp".equals(jSONObject.optString("from"))) {
                    LogUtils.i(TAG, "is from dui_xp");
                    return;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        for (Object obj : collectCallbacks) {
            ((MusicListener) obj).onMusicListPlay(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation(event = "command://music.1212.novel.play")
    public void onTwelveNovelPlay(String str, String str2) {
        String str3;
        try {
            str3 = new JSONObject(str2).optString("param");
        } catch (JSONException e) {
            e.printStackTrace();
            str3 = null;
        }
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((MusicListener) obj).onTwelveNovelPlay(str3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation(event = "command://music.control.collect")
    public void onControlCollect(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((MusicListener) obj).onControlCollect();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation(event = "command://music.audiobook.subscribe")
    public void onAudioBookSubscribe(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((MusicListener) obj).onAudioBookSubscribe();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation(event = "command://music.soundeffect.stereo")
    public void onSoundEffectStereo(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((MusicListener) obj).onSoundEffectStereo();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation(event = "command://music.soundeffect.live")
    public void onSoundEffectLive(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((MusicListener) obj).onSoundEffectLive();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation(event = "command://music.soundeffect.vocal")
    public void onSoundEffectVocal(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((MusicListener) obj).onSoundEffectVocal();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation(event = "command://music.soundeffect.superbass")
    public void onSoundEffectSuperbass(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((MusicListener) obj).onSoundEffectSuperbass();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation(event = "command://music.control.collect.cancel")
    public void onDelCollect(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((MusicListener) obj).onDelCollect();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation(event = "command://music.control.collect.play")
    public void onPlayCollect(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        CollectHistoryMusic fromJson = CollectHistoryMusic.fromJson(str2);
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((MusicListener) obj).onPlayCollect(fromJson);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation(event = "command://music.control.sim")
    public void onPlaySimilar(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((MusicListener) obj).onPlaySimilar();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation(event = "command://music.control.sim.cancel")
    public void onCancelPlaySimilar(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((MusicListener) obj).onCancelPlaySimilar();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation(event = "command://music.control.playlist.history.play")
    public void onPlayHistoryList(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        CollectHistoryMusic fromJson = CollectHistoryMusic.fromJson(str2);
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((MusicListener) obj).onPlayHistoryList(fromJson);
            }
        }
    }

    public void startMusicSearch() {
        SpeechClient.instance().getWakeupEngine().startDialogFrom("music");
    }

    @SpeechAnnotation(event = "command://music.forward")
    public void onMusicForward(String str, String str2) {
        try {
            Object[] collectCallbacks = this.mListenerList.collectCallbacks();
            int optInt = new JSONObject(str2).optInt("value");
            if (collectCallbacks != null) {
                for (Object obj : collectCallbacks) {
                    ((MusicListener) obj).onMusicForward(optInt);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @SpeechAnnotation(event = "command://music.backward")
    public void onMusicBackward(String str, String str2) {
        try {
            Object[] collectCallbacks = this.mListenerList.collectCallbacks();
            int optInt = new JSONObject(str2).optInt("value");
            if (collectCallbacks != null) {
                for (Object obj : collectCallbacks) {
                    ((MusicListener) obj).onMusicBackward(optInt);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @SpeechAnnotation(event = "command://music.settime")
    public void onMusicSettime(String str, String str2) {
        try {
            Object[] collectCallbacks = this.mListenerList.collectCallbacks();
            int optInt = new JSONObject(str2).optInt("value");
            if (collectCallbacks != null) {
                for (Object obj : collectCallbacks) {
                    ((MusicListener) obj).onMusicSettime(optInt);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @SpeechAnnotation(event = "command://music.speed.up")
    public void onMusicSpeedUp(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((MusicListener) obj).onMusicSpeedUp();
            }
        }
    }

    @SpeechAnnotation(event = "command://music.speed.down")
    public void onMusicSpeedDown(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((MusicListener) obj).onMusicSpeedDown();
            }
        }
    }

    @SpeechAnnotation(event = "command://music.speed.set")
    public void onMusicSpeedSet(String str, String str2) {
        try {
            Object[] collectCallbacks = this.mListenerList.collectCallbacks();
            float floatValue = BigDecimal.valueOf(new JSONObject(str2).optDouble("value")).floatValue();
            if (collectCallbacks != null) {
                for (Object obj : collectCallbacks) {
                    ((MusicListener) obj).onMusicSpeedSet(floatValue);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @SpeechAnnotation(event = "command://music.news.play")
    public void onMusicNewsPlay(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((MusicListener) obj).onMusicNewsPlay();
            }
        }
    }

    @SpeechAnnotation(event = "command://music.dailyrec.play")
    public void onMusicDailyrecPlay(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((MusicListener) obj).onMusicDailyrecPlay();
            }
        }
    }

    @SpeechAnnotation(event = "command://music.control.play.usb")
    public void onPlayUsb(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((MusicListener) obj).onPlayUsb();
            }
        }
    }

    @SpeechAnnotation(event = MusicEvent.PLAY_SPOTIFY)
    public void onPlaySpotify(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((MusicListener) obj).onPlaySpotify();
            }
        }
    }

    @SpeechAnnotation(event = MusicEvent.PLAY_LOOP_CLOSE)
    public void onPlayLoopClose(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((MusicListener) obj).onPlayLoopClose();
            }
        }
    }

    @SpeechAnnotation(event = MusicEvent.PLAY_RANDOM_CLOSE)
    public void onPlayRandomClose(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((MusicListener) obj).onPlayRandomClose();
            }
        }
    }
}
