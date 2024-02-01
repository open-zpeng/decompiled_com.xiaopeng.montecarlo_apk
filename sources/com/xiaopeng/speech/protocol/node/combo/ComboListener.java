package com.xiaopeng.speech.protocol.node.combo;

import com.xiaopeng.speech.INodeListener;
/* loaded from: classes3.dex */
public interface ComboListener extends INodeListener {
    default void enterUserMode(String str) {
    }

    default void enterUserModeWithExtra(String str, String str2) {
    }

    default void exitUserModel(String str) {
    }

    void onDataModeBioTts();

    void onDataModeFridgeTts();

    void onDataModeInvisibleTts();

    void onDataModeMeditationTts();

    void onDataModeVentilateTts();

    void onDataModeWaitTts();

    void onFastCloseModeInvisible();

    void onModeBio();

    void onModeBioOff();

    void onModeFridge();

    void onModeFridgeOff();

    void onModeInvisible();

    void onModeInvisibleOff();

    void onModeVentilate();

    void onModeVentilateOff();

    void onModeWait();

    void onModeWaitOff();
}
