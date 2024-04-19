package com.xiaopeng.montecarlo.navcore.xptbt.bean;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.speech.speechwidget.SpeechWidget;
/* loaded from: classes3.dex */
public class AiMsgConfirmBean {
    public static final int AI_MSG_CALLBACK_SHOW_HAPPY_ENDING = 1;
    public static final int AI_MSG_CALLBACK_SWITCH_ROUTE = 13;
    public static final String AI_MSG_TAG = "for_map";
    @SerializedName(SpeechWidget.WIDGET_EXTRA)
    private String mExtra;
    @SerializedName("status")
    private boolean mStatus;
    @SerializedName("tag")
    private String mTag = "for_map";
    @SerializedName("type")
    private int mType;

    public void setTag(String str) {
        this.mTag = str;
    }

    public String getTag() {
        return this.mTag;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public int getType() {
        return this.mType;
    }

    public void setStatus(boolean z) {
        this.mStatus = z;
    }

    public boolean isStatus() {
        return this.mStatus;
    }

    public void setExtra(String str) {
        this.mExtra = str;
    }

    public String getExtra() {
        return this.mExtra;
    }
}
