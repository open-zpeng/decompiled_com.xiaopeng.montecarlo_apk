package com.xiaopeng.montecarlo.navcore.speech.bean;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.speech.speechwidget.SpeechWidget;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class SpeechDataContentItem implements Serializable {
    @SerializedName("duiWidget")
    private String mDuiWidget;
    @SerializedName(SpeechWidget.WIDGET_EXTRA)
    private SpeechDataContentItemExtra mExta;
    @SerializedName(SpeechWidget.WIDGET_SUBTITLE)
    private String mSubTitle;
    @SerializedName(SpeechWidget.WIDGET_TITLE)
    private String mTitle;
    @SerializedName("type")
    private String mType;

    public String getSubTitle() {
        return this.mSubTitle;
    }

    public void setSubTitle(String str) {
        this.mSubTitle = str;
    }

    public String getDuiWidget() {
        return this.mDuiWidget;
    }

    public void setDuiWidget(String str) {
        this.mDuiWidget = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public SpeechDataContentItemExtra getExta() {
        return this.mExta;
    }

    public void setExta(SpeechDataContentItemExtra speechDataContentItemExtra) {
        this.mExta = speechDataContentItemExtra;
    }
}
