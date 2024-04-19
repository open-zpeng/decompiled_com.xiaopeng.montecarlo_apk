package com.xiaopeng.montecarlo.root.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.config.DebugConfiguration;
import com.xiaopeng.speech.speechwidget.ListWidget;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class AudioManagerWrapper {
    private static final String EXTRA_VOLUME_STREAM_TYPE = "android.media.EXTRA_VOLUME_STREAM_TYPE";
    private static final String EXTRA_VOLUME_STREAM_VALUE = "android.media.EXTRA_VOLUME_STREAM_VALUE";
    private static final String MEDIA_PATH = "/system/media/audio/xiaopeng/cdu/wav/CDU_volume_slider.wav";
    public static final String STREAM_MUTE_CHANGED_ACTION = "android.media.STREAM_MUTE_CHANGED_ACTION";
    public static final int STREAM_NAVI = 9;
    private static final String VOLUME_CHANGED_ACTION = "android.media.VOLUME_CHANGED_ACTION";
    public static final int VOLUME_VALUE_DEFAULT = 8;
    public static final int VOLUME_VALUE_INVALID = -1;
    private static final int VOLUME_VALUE_MAX = 30;
    private static VolumeChangedReceiver sVolumeChangedReceiver;
    private AudioManager mAudioManager;
    private int mMaxVolumeSys;
    private MediaPlayer mPlayer;
    private static final L.Tag TAG = new L.Tag("AudioManagerWrapper");
    private static AudioManagerWrapper sAudioManagerWrapper = new AudioManagerWrapper();
    private int mMaxVolumeNavi = 30;
    private boolean mMuteBySpeechCmd = false;

    private AudioManagerWrapper() {
    }

    public static AudioManagerWrapper getInstance() {
        return sAudioManagerWrapper;
    }

    public void init() {
        this.mAudioManager = (AudioManager) ContextUtils.getContext().getSystemService(ListWidget.EXTRA_TYPE_AUDIO);
        addVolumeChangeReceiver();
        this.mMaxVolumeSys = this.mAudioManager.getStreamMaxVolume(9);
        if (30 != this.mMaxVolumeSys) {
            L.e(TAG, "mMaxVolumeSys is not 30 while the convert table is 30 level");
        }
        resetMuteState();
    }

    public void release() {
        sVolumeChangedReceiver.removeListeners();
        ContextUtils.getContext().unregisterReceiver(sVolumeChangedReceiver);
        sVolumeChangedReceiver = null;
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.mPlayer = null;
        }
    }

    private void resetMuteState() {
        if (isMute() || !DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_NAVI_VOLUME_LAST_USER_MUTE, false)) {
            return;
        }
        L.e(TAG, "reset mute state after restart");
        setMute(true, -1);
        if (getVolume() != 0) {
            setVolume(0);
        }
    }

    private void addVolumeChangeReceiver() {
        sVolumeChangedReceiver = new VolumeChangedReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(VOLUME_CHANGED_ACTION);
        intentFilter.addAction(STREAM_MUTE_CHANGED_ACTION);
        if (!RootUtil.isUserVersion() && DebugConfiguration.Debug.DEBUG_RECEIVER) {
            intentFilter.addAction(DebugConfiguration.RegisterAction.VOLUME_CHANGED_TEST_ACTION);
        }
        ContextUtils.getContext().registerReceiver(sVolumeChangedReceiver, intentFilter);
    }

    public void addVolumeChangedListener(VolumeChangedReceiver.IVolumeChangedListener iVolumeChangedListener) {
        VolumeChangedReceiver volumeChangedReceiver = sVolumeChangedReceiver;
        if (volumeChangedReceiver != null) {
            volumeChangedReceiver.addVolumeChangedListener(iVolumeChangedListener);
        }
    }

    public void removeVolumeChangedListener(VolumeChangedReceiver.IVolumeChangedListener iVolumeChangedListener) {
        VolumeChangedReceiver volumeChangedReceiver = sVolumeChangedReceiver;
        if (volumeChangedReceiver != null) {
            volumeChangedReceiver.removeVolumeChangedListener(iVolumeChangedListener);
        }
    }

    public int getMaxVolume() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onVolumeChanged__getMaxVolume" + this.mMaxVolumeNavi);
        }
        return this.mMaxVolumeNavi;
    }

    public int getVolume() {
        int streamVolume = this.mAudioManager.getStreamVolume(9);
        if (streamVolume < 0 || streamVolume > this.mMaxVolumeSys) {
            return 8;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onVolumeChanged__getVolume" + streamVolume);
        }
        return streamVolume;
    }

    public void setVolume(int i) {
        if (i < 0) {
            i = 0;
        }
        int i2 = this.mMaxVolumeNavi;
        if (i > i2) {
            i = i2;
        }
        if (L.ENABLE) {
            L.d(TAG, "onVolumeChanged__setVolume" + i);
        }
        setMute(i == 0, i);
        setStreamVolume(i);
    }

    public int getLastVolumeUser() {
        return getVolume();
    }

    public boolean isMute() {
        boolean z = false;
        if (isAudioManagerInit() && (this.mAudioManager.isStreamMute(9) || this.mAudioManager.getStreamVolume(9) == 0)) {
            z = true;
        }
        L.i(TAG, "isMute: " + z);
        return z;
    }

    private boolean isAudioManagerInit() {
        if (this.mAudioManager == null) {
            L.i(TAG, "isAudioManagerInit mAudioManager is null");
            this.mAudioManager = (AudioManager) ContextUtils.getContext().getSystemService(ListWidget.EXTRA_TYPE_AUDIO);
        }
        return this.mAudioManager != null;
    }

    public void setMute(boolean z, int i) {
        boolean isMute = isMute();
        if ((z && isMute) || (!z && !isMute)) {
            L.Tag tag = TAG;
            L.i(tag, "set mute  : " + z + ", current is " + isMute);
            return;
        }
        L.Tag tag2 = TAG;
        L.i(tag2, "setMute: " + z + ", before mute vol: " + getVolume() + ", new volume:" + i);
        if (!z && getVolume() == 0) {
            if (i == -1) {
                i = 8;
            }
            setStreamVolume(i);
        } else if (this.mAudioManager != null) {
            if (Build.VERSION.SDK_INT < 23) {
                this.mAudioManager.setStreamMute(9, z);
            } else if (i != -1) {
                setStreamVolume(i);
            } else {
                this.mAudioManager.adjustStreamVolume(9, z ? -100 : 100, 0);
            }
        }
    }

    public void setStreamVolume(int i) {
        VolumeChangedReceiver volumeChangedReceiver = sVolumeChangedReceiver;
        if (volumeChangedReceiver != null) {
            volumeChangedReceiver.setVolByNavi();
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onVolumeChanged__setStreamVolume" + i);
        }
        if (isAudioManagerInit()) {
            this.mAudioManager.setStreamVolume(9, i, 8);
        }
    }

    public void playSettingVolumeFinishSound() {
        if (isAudioManagerInit()) {
            WorkThreadUtil.getInstance().executeIOTask(new Runnable() { // from class: com.xiaopeng.montecarlo.root.util.AudioManagerWrapper.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (AudioManagerWrapper.this.mPlayer == null) {
                            AudioManagerWrapper.this.mPlayer = new MediaPlayer();
                        }
                        AudioManagerWrapper.this.mPlayer.reset();
                        AudioAttributes.Builder builder = new AudioAttributes.Builder();
                        builder.setLegacyStreamType(9);
                        AudioManagerWrapper.this.mPlayer.setAudioAttributes(builder.build());
                        AudioManagerWrapper.this.mPlayer.setDataSource(AudioManagerWrapper.MEDIA_PATH);
                        AudioManagerWrapper.this.mPlayer.prepare();
                        AudioManagerWrapper.this.mPlayer.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public int convertSystemVolume(int i) {
        if (i > this.mMaxVolumeSys || i < 0) {
            return 8;
        }
        return i;
    }

    public boolean isMuteNaviIfNeed(boolean z, int i) {
        if (1 == i) {
            boolean isMute = isMute();
            if ((z && isMute) || (!z && !this.mMuteBySpeechCmd)) {
                L.Tag tag = TAG;
                L.i(tag, "ignore speech event by, mute: " + z + ", system: " + isMute + ", mMuteBySpeechCmd: " + this.mMuteBySpeechCmd);
                return false;
            }
            this.mMuteBySpeechCmd = z;
        } else {
            this.mMuteBySpeechCmd = false;
        }
        L.Tag tag2 = TAG;
        L.i(tag2, "send speech cmd, mMuteBySpeechCmd： " + this.mMuteBySpeechCmd);
        return true;
    }

    /* loaded from: classes3.dex */
    public static class VolumeChangedReceiver extends BroadcastReceiver {
        public final ArrayList<IVolumeChangedListener> mListenerList = new ArrayList<>();
        private boolean mSetVolByNavi;

        /* loaded from: classes3.dex */
        public interface IVolumeChangedListener {
            void onVolumeChanged(int i);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (AudioManagerWrapper.VOLUME_CHANGED_ACTION.equals(intent.getAction()) && intent.getIntExtra(AudioManagerWrapper.EXTRA_VOLUME_STREAM_TYPE, -1) == 9) {
                int intExtra = intent.getIntExtra(AudioManagerWrapper.EXTRA_VOLUME_STREAM_VALUE, -1);
                if (L.ENABLE) {
                    L.Tag tag = AudioManagerWrapper.TAG;
                    L.d(tag, "onReceive: VOLUME_CHANGED_ACTION " + intExtra);
                }
                if (this.mSetVolByNavi) {
                    L.i(AudioManagerWrapper.TAG, "ignore VOLUME_CHANGED_ACTION from navi!");
                    return;
                }
                if (Build.VERSION.SDK_INT < 23 && intExtra > 0) {
                    AudioManagerWrapper.getInstance().setMute(false, -1);
                }
                notifyVolumeChanged(AudioManagerWrapper.getInstance().convertSystemVolume(intExtra));
            } else if (AudioManagerWrapper.STREAM_MUTE_CHANGED_ACTION.equals(intent.getAction()) && intent.getIntExtra(AudioManagerWrapper.EXTRA_VOLUME_STREAM_TYPE, -1) == 9) {
                L.i(AudioManagerWrapper.TAG, "onReceive: android.media.STREAM_MUTE_CHANGED_ACTION");
                notifyVolumeChanged(-1);
                DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_NAVI_VOLUME_LAST_USER_MUTE, AudioManagerWrapper.getInstance().isMute());
            } else if (DebugConfiguration.RegisterAction.VOLUME_CHANGED_TEST_ACTION.equals(intent.getAction())) {
                AudioManagerWrapper.getInstance().setStreamVolume(intent.getIntExtra(AudioManagerWrapper.EXTRA_VOLUME_STREAM_VALUE, -1));
            }
        }

        public synchronized void addVolumeChangedListener(IVolumeChangedListener iVolumeChangedListener) {
            if (L.ENABLE) {
                L.Tag tag = AudioManagerWrapper.TAG;
                L.d(tag, "addVolumeChangedListener: " + iVolumeChangedListener);
            }
            CollectionUtils.listAdd(this.mListenerList, iVolumeChangedListener);
        }

        public synchronized void removeVolumeChangedListener(IVolumeChangedListener iVolumeChangedListener) {
            if (L.ENABLE) {
                L.Tag tag = AudioManagerWrapper.TAG;
                L.d(tag, "removeVolumeChangedListener listener:" + iVolumeChangedListener);
            }
            if (iVolumeChangedListener != null) {
                this.mListenerList.remove(iVolumeChangedListener);
            }
        }

        public void removeListeners() {
            synchronized (this.mListenerList) {
                if (CollectionUtils.isNotEmpty(this.mListenerList)) {
                    this.mListenerList.clear();
                }
            }
        }

        public void setVolByNavi() {
            if (this.mSetVolByNavi) {
                return;
            }
            this.mSetVolByNavi = true;
            UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.root.util.AudioManagerWrapper.VolumeChangedReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    VolumeChangedReceiver.this.mSetVolByNavi = false;
                }
            }, 500L);
        }

        private void notifyVolumeChanged(int i) {
            synchronized (this.mListenerList) {
                Iterator<IVolumeChangedListener> it = this.mListenerList.iterator();
                while (it.hasNext()) {
                    it.next().onVolumeChanged(i);
                }
            }
        }
    }
}
