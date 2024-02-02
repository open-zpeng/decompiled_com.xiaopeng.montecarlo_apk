package com.xiaopeng.montecarlo.navcore.xptbt.bean;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import com.xiaopeng.speech.speechwidget.SpeechWidget;
/* loaded from: classes2.dex */
public class AiMsgSelectBean {
    public static final int AI_MSG_CALLBACK_SELECT_PARK = 14;
    public static final int AI_MSG_CALLBACK_SELECT_ROUTE = 16;
    public static final String AI_MSG_TAG = "for_map";
    @SerializedName(SpeechWidget.WIDGET_EXTRA)
    private String mExtra;
    @SerializedName(CPSearchParam.PARAM_KEY_INDEX)
    private int mIndex;
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

    public void setIndex(int i) {
        this.mIndex = i;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setExtra(String str) {
        this.mExtra = str;
    }

    public String getExtra() {
        return this.mExtra;
    }
}
