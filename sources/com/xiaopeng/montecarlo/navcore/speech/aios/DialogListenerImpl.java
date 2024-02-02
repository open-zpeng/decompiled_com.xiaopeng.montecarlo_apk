package com.xiaopeng.montecarlo.navcore.speech.aios;

import com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.speech.SpeechClient;
import com.xiaopeng.speech.protocol.node.dialog.AbsDialogListener;
import com.xiaopeng.speech.protocol.node.dialog.bean.DialogEndReason;
import com.xiaopeng.speech.protocol.node.dialog.bean.WakeupReason;
/* loaded from: classes2.dex */
public class DialogListenerImpl extends AbsDialogListener {
    private static final L.Tag TAG = new L.Tag("NaviModel_DialogListenerImpl");
    private NaviModel mNaviModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogListenerImpl(NaviModel naviModel) {
        this.mNaviModel = naviModel;
    }

    @Override // com.xiaopeng.speech.protocol.node.dialog.AbsDialogListener, com.xiaopeng.speech.protocol.node.dialog.DialogListener
    public void onVadBegin() {
        super.onVadBegin();
        if (L.ENABLE) {
            L.d(TAG, "onVadBegin");
        }
    }

    @Override // com.xiaopeng.speech.protocol.node.dialog.AbsDialogListener, com.xiaopeng.speech.protocol.node.dialog.DialogListener
    public void onVadEnd() {
        super.onVadEnd();
        if (L.ENABLE) {
            L.d(TAG, "onVadEnd");
        }
    }

    @Override // com.xiaopeng.speech.protocol.node.dialog.AbsDialogListener, com.xiaopeng.speech.protocol.node.dialog.DialogListener
    public void onDialogStart(WakeupReason wakeupReason) {
        super.onDialogStart(wakeupReason);
        if (this.mNaviModel.canHandleVoiceCommand(null, false)) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "onDialogStart wakeupReason:" + wakeupReason);
            }
            VoiceFusionUtil.getInstance().onDialogStart();
        }
    }

    @Override // com.xiaopeng.speech.protocol.node.dialog.AbsDialogListener, com.xiaopeng.speech.protocol.node.dialog.DialogListener
    public void onDialogEnd(DialogEndReason dialogEndReason) {
        String str;
        super.onDialogEnd(dialogEndReason);
        if (dialogEndReason != null) {
            str = dialogEndReason.event;
            L.i(TAG, "onDialogEnd reason:" + dialogEndReason.reason + ",event:" + str);
        } else {
            L.i(TAG, "onDialogEnd");
            str = null;
        }
        if (this.mNaviModel.canHandleVoiceCommand(null, false) && !this.mNaviModel.isDialogEndFilter(str)) {
            VoiceFusionUtil.getInstance().onDialogEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isShowSpeechDialog() {
        return SpeechClient.instance().getSpeechState().isDMStarted();
    }
}
