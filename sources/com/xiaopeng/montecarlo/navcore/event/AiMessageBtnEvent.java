package com.xiaopeng.montecarlo.navcore.event;
/* loaded from: classes3.dex */
public final class AiMessageBtnEvent {
    private String mBtnContent;
    private int mSender = 0;
    private int mScene = AiMessageEvent.SCENE_DEFAULT;

    public int getSender() {
        return this.mSender;
    }

    public void setSender(int i) {
        this.mSender = i;
    }

    public String getBtnContent() {
        return this.mBtnContent;
    }

    public void setBtnContent(String str) {
        this.mBtnContent = str;
    }

    public int getScene() {
        return this.mScene;
    }

    public void setScene(int i) {
        this.mScene = i;
    }
}
