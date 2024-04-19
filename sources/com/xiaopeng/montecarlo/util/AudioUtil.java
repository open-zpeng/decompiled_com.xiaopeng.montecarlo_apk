package com.xiaopeng.montecarlo.util;

import com.xiaopeng.montecarlo.root.util.AudioManagerWrapper;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class AudioUtil implements AudioManagerWrapper.VolumeChangedReceiver.IVolumeChangedListener {
    private static final L.Tag TAG = new L.Tag("AudioUtil");
    private static AudioUtil sAudioUtil = new AudioUtil();
    private final List<IAudioChangedListener> mListenerList = new CopyOnWriteArrayList();

    /* loaded from: classes3.dex */
    public interface IAudioChangedListener {
        void onAudioChanged(boolean z);
    }

    private AudioUtil() {
    }

    public static AudioUtil getInstance() {
        return sAudioUtil;
    }

    public void init() {
        AudioManagerWrapper.getInstance().init();
        AudioManagerWrapper.getInstance().addVolumeChangedListener(this);
    }

    public void release() {
        removeListeners();
        AudioManagerWrapper.getInstance().release();
    }

    @Override // com.xiaopeng.montecarlo.root.util.AudioManagerWrapper.VolumeChangedReceiver.IVolumeChangedListener
    public void onVolumeChanged(int i) {
        notifyAudioChanged(false);
    }

    public int getVolume() {
        return AudioManagerWrapper.getInstance().getVolume();
    }

    public void setVolume(int i) {
        AudioManagerWrapper.getInstance().setVolume(i);
        notifyAudioChanged(false);
    }

    public int getMaxVolume() {
        return AudioManagerWrapper.getInstance().getMaxVolume();
    }

    public boolean isMute() {
        return AudioManagerWrapper.getInstance().isMute();
    }

    public void setMute(boolean z) {
        setMute(z, false);
    }

    public void setMute(boolean z, boolean z2) {
        AudioManagerWrapper.getInstance().setMute(z, -1);
        notifyAudioChanged(z2);
    }

    public void addAudioChangedListener(IAudioChangedListener iAudioChangedListener) {
        CollectionUtils.listAdd(this.mListenerList, iAudioChangedListener);
    }

    public void removeAudioChangedListener(IAudioChangedListener iAudioChangedListener) {
        if (iAudioChangedListener != null) {
            this.mListenerList.remove(iAudioChangedListener);
        }
    }

    public void notifyAudioChanged(boolean z) {
        for (IAudioChangedListener iAudioChangedListener : this.mListenerList) {
            iAudioChangedListener.onAudioChanged(z);
        }
    }

    public void removeListeners() {
        if (CollectionUtils.isNotEmpty(this.mListenerList)) {
            this.mListenerList.clear();
        }
    }
}
