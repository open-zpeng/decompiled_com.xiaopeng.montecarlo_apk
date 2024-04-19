package com.xiaopeng.montecarlo.stat;

import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.datalog.DataLogHelper;
import com.xiaopeng.montecarlo.navcore.speech.stat.ISpeechStat;
import com.xiaopeng.montecarlo.navcore.speech.stat.SpeechStatProxy;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public class SpeechStatUtil {
    private static final L.Tag TAG = new L.Tag("SpeechStatUtil");
    private MainContext mMainContext;
    private ISpeechStat mSpeechStat = new ISpeechStat() { // from class: com.xiaopeng.montecarlo.stat.SpeechStatUtil.1
        @Override // com.xiaopeng.montecarlo.navcore.speech.stat.ISpeechStat
        public void sendStatDataForSpeech(int i, int i2) {
            SpeechStatUtil speechStatUtil = SpeechStatUtil.this;
            speechStatUtil.handleSendStatDataForSpeech(speechStatUtil.mMainContext, i, i2);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSendStatDataForSpeech(MainContext mainContext, int i, int i2) {
        if (mainContext == null) {
            L.i(TAG, "getInstance().sendStatDataForSpeech, mainContext is null");
        } else {
            DataLogUtil.sendStatData(DataLogHelper.getPageTypeByCurScene(mainContext), BtnType.VUI_SPEECH, Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    private void sendStatDataForSpeech(int i, int i2) {
        this.mSpeechStat.sendStatDataForSpeech(i, i2);
    }

    public void init(MainContext mainContext) {
        this.mMainContext = mainContext;
        SpeechStatProxy.getInstance().init(this.mSpeechStat);
    }

    public void deinit() {
        this.mMainContext = null;
        SpeechStatProxy.getInstance().deinit();
    }
}
