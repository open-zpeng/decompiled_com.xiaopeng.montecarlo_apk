package com.xiaopeng.montecarlo;

import android.app.Application;
import android.content.Context;
import com.xiaopeng.montecarlo.navcore.speech.aios.NaviModel;
import com.xiaopeng.montecarlo.navcore.tts.ISpeech;
import com.xiaopeng.montecarlo.navcore.tts.ISpeechCallback;
import com.xiaopeng.montecarlo.navcore.tts.TTSProxy;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.XUIServiceManager;
import com.xiaopeng.montecarlo.root.carservice.ICarService;
import com.xiaopeng.montecarlo.root.carservice.XpCarService;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.config.Configuration;
/* loaded from: classes.dex */
class BenchApplicationInitializer extends AbstractApplicationInitializer {
    private ISpeech mSpeech = new ISpeech() { // from class: com.xiaopeng.montecarlo.BenchApplicationInitializer.1
        private SpeechTtsUtil mTtsUtil = new SpeechTtsUtil();

        @Override // com.xiaopeng.montecarlo.navcore.tts.ISpeech
        public void init(Context context) {
            this.mTtsUtil.init(context);
        }

        @Override // com.xiaopeng.montecarlo.navcore.tts.ISpeech
        public String getSpeaker() {
            return this.mTtsUtil.getSpeaker();
        }

        @Override // com.xiaopeng.montecarlo.navcore.tts.ISpeech
        public void setSpeaker(String str) {
            this.mTtsUtil.setSpeaker(str);
        }

        @Override // com.xiaopeng.montecarlo.navcore.tts.ISpeech
        public float getSpeed() {
            return this.mTtsUtil.getSpeed();
        }

        @Override // com.xiaopeng.montecarlo.navcore.tts.ISpeech
        public void setSpeed(float f) {
            this.mTtsUtil.setSpeed(f);
        }

        @Override // com.xiaopeng.montecarlo.navcore.tts.ISpeech
        public int getVolume() {
            return this.mTtsUtil.getVolume();
        }

        @Override // com.xiaopeng.montecarlo.navcore.tts.ISpeech
        public void setVolume(int i) {
            this.mTtsUtil.setVolume(i);
        }

        @Override // com.xiaopeng.montecarlo.navcore.tts.ISpeech
        public String speak(String str, ISpeechCallback iSpeechCallback) {
            return this.mTtsUtil.speak(str, iSpeechCallback);
        }

        @Override // com.xiaopeng.montecarlo.navcore.tts.ISpeech
        public String speakByImportant(String str, ISpeechCallback iSpeechCallback) {
            return this.mTtsUtil.speakByImportant(str, iSpeechCallback);
        }

        @Override // com.xiaopeng.montecarlo.navcore.tts.ISpeech
        public String speakByUrgent(String str, ISpeechCallback iSpeechCallback) {
            return this.mTtsUtil.speakByUrgent(str, iSpeechCallback);
        }

        @Override // com.xiaopeng.montecarlo.navcore.tts.ISpeech
        public void shutUp(String str) {
            this.mTtsUtil.shutup(str);
        }

        @Override // com.xiaopeng.montecarlo.navcore.tts.ISpeech
        public void pause() {
            this.mTtsUtil.pause();
        }

        @Override // com.xiaopeng.montecarlo.navcore.tts.ISpeech
        public void resume() {
            this.mTtsUtil.resume();
        }

        @Override // com.xiaopeng.montecarlo.navcore.tts.ISpeech
        public void release(String str) {
            this.mTtsUtil.release(str);
        }

        @Override // com.xiaopeng.montecarlo.navcore.tts.ISpeech
        public void removeCallback(String str) {
            this.mTtsUtil.removeCallback(str);
        }
    };

    BenchApplicationInitializer() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.AbstractApplicationInitializer
    public ICarService getCarService() {
        return new XpCarService();
    }

    @Override // com.xiaopeng.montecarlo.AbstractApplicationInitializer
    public void initXUIService(Application application) {
        XUIServiceManager.getInstance().init(application);
    }

    @Override // com.xiaopeng.montecarlo.AbstractApplicationInitializer
    protected void initStoragePath() {
        RootUtil.NAVI_PATH = Configuration.Path.PATH_NAVI;
        RootUtil.EXT_SD_CARD_DEV = Configuration.Path.PATH_DEV;
        RootUtil.initStoragePath(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.xiaopeng.montecarlo.AbstractApplicationInitializer
    public void initTTS() {
        TTSProxy.getInstance().setSpeech(this.mSpeech);
        TTSProxy.getInstance().init(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.xiaopeng.montecarlo.AbstractApplicationInitializer
    public boolean initTBT() {
        boolean z = !NavCoreUtil.isGpsDebugMode();
        if (!z) {
            NavCoreUtil.setGpsDebugMode(false);
        }
        return TBTManager.getInstance().init(this.mContext, z);
    }

    @Override // com.xiaopeng.montecarlo.AbstractApplicationInitializer
    void deInitSelf() {
        TTSProxy.getInstance().release(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.xiaopeng.montecarlo.AbstractApplicationInitializer
    public void initSpeech() {
        NaviModel.getInstance().subscribe();
    }

    @Override // com.xiaopeng.montecarlo.AbstractApplicationInitializer
    void deInitSpeech() {
        NaviModel.getInstance().unsubscribe();
    }
}
