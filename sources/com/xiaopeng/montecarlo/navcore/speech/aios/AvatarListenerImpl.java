package com.xiaopeng.montecarlo.navcore.speech.aios;

import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.speech.jarvisproto.DMListening;
import com.xiaopeng.speech.jarvisproto.DMRecognized;
import com.xiaopeng.speech.protocol.node.avatar.AvatarListener;
/* loaded from: classes2.dex */
public class AvatarListenerImpl implements AvatarListener {
    private static final L.Tag TAG = new L.Tag("NaviModel_AvatarListenerImpl");
    private NaviModel mNaviModel;

    @Override // com.xiaopeng.speech.protocol.node.avatar.AvatarListener
    public void onAvatarExpression(String str) {
    }

    @Override // com.xiaopeng.speech.protocol.node.avatar.AvatarListener
    public void onAvatarWakerupDisable(String str) {
    }

    @Override // com.xiaopeng.speech.protocol.node.avatar.AvatarListener
    public void onAvatarWakerupEnable(String str) {
    }

    @Override // com.xiaopeng.speech.protocol.node.avatar.AvatarListener
    public void onListening(DMListening dMListening) {
    }

    @Override // com.xiaopeng.speech.protocol.node.avatar.AvatarListener
    public void onWidgetCard(String str) {
    }

    @Override // com.xiaopeng.speech.protocol.node.avatar.AvatarListener
    public void onWidgetCustom(String str) {
    }

    @Override // com.xiaopeng.speech.protocol.node.avatar.AvatarListener
    public void onWidgetList(String str) {
    }

    @Override // com.xiaopeng.speech.protocol.node.avatar.AvatarListener
    public void onWidgetMedia(String str) {
    }

    @Override // com.xiaopeng.speech.protocol.node.avatar.AvatarListener
    public void onWidgetSearch(String str) {
    }

    @Override // com.xiaopeng.speech.protocol.node.avatar.AvatarListener
    public void onWidgetText(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AvatarListenerImpl(NaviModel naviModel) {
        this.mNaviModel = naviModel;
    }

    @Override // com.xiaopeng.speech.protocol.node.avatar.AvatarListener
    public void onSilence(DMRecognized dMRecognized) {
        if (L.ENABLE) {
            L.d(TAG, "onSilence");
        }
    }

    @Override // com.xiaopeng.speech.protocol.node.avatar.AvatarListener
    public void onSpeaking() {
        if (L.ENABLE) {
            L.d(TAG, "onSpeaking");
        }
    }

    @Override // com.xiaopeng.speech.protocol.node.avatar.AvatarListener
    public void onStandby() {
        if (L.ENABLE) {
            L.d(TAG, "onStandby");
        }
    }

    @Override // com.xiaopeng.speech.protocol.node.avatar.AvatarListener
    public void onUnderstanding() {
        if (L.ENABLE) {
            L.d(TAG, "onUnderstanding");
        }
    }
}
