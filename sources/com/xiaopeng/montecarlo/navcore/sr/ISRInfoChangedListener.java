package com.xiaopeng.montecarlo.navcore.sr;
/* loaded from: classes2.dex */
public interface ISRInfoChangedListener {
    default void onDriveModeChanged(int i) {
    }

    default void onLaneViewDisplayChanged(int i) {
    }

    default void onScuCruiseSpeed(int i) {
    }

    default void onScuLimitSpeed(int i) {
    }

    default void onScuNgpInfoTips1(int i) {
    }

    default void onScuNgpLaneChanged(int i) {
    }

    default void onScuNgpLcTips1AndNgpOddStatus(int i, int i2) {
    }

    default void onScuNgpLcTips1TTS(int i) {
    }

    default void onScuNgpOpeButton(int i) {
    }

    default void onScuNgpTipsWindow(int i) {
    }

    default void onXpuSRDisplayStChanged(int i) {
    }

    default void onXpuSRLCViewChanged(int i) {
    }

    default void onXpuSRSpdViewChanged(int i) {
    }

    default void onXpuVehSpeedChanged(float f) {
    }

    default void outBLRenderFPS() {
    }
}
