package com.xiaopeng.montecarlo.navcore.speech.bean;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.speech.speechwidget.SpeechWidget;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class SpeechDataExtra implements Serializable {
    @SerializedName("extraType")
    private String mExtraType;
    @SerializedName(SpeechWidget.WIDGET_TITLE)
    private String mTitle;

    public String getExtraType() {
        return this.mExtraType;
    }

    public void setExtraType(String str) {
        this.mExtraType = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }
}
