package com.xiaopeng.montecarlo.aimessage.type;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.event.AiMessageEvent;
import com.xiaopeng.speech.protocol.bean.stats.SceneSwitchStatisticsBean;
/* loaded from: classes.dex */
public final class MapAiBtnContent {
    @SerializedName("content")
    private String mContent;
    @SerializedName("tag")
    private String mTag = "for_map";
    @SerializedName("sender")
    private int mSender = 0;
    @SerializedName(SceneSwitchStatisticsBean.NAME_SCENE)
    private int mScene = AiMessageEvent.SCENE_DEFAULT;

    public void setContent(String str) {
        this.mContent = str;
    }

    public String getContent() {
        return this.mContent;
    }

    public void setTag(String str) {
        this.mTag = str;
    }

    public String getTag() {
        return this.mTag;
    }

    public void setSender(int i) {
        this.mSender = i;
    }

    public int getSender() {
        return this.mSender;
    }

    public void setScene(int i) {
        this.mScene = i;
    }

    public int getScene() {
        return this.mScene;
    }

    public String toString() {
        return "MapAiBtnContent{mContent='" + this.mContent + "', mTag='" + this.mTag + "', mSender=" + this.mSender + '}';
    }
}
