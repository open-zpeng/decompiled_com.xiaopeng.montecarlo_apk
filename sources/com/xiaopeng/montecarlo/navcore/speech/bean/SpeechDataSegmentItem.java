package com.xiaopeng.montecarlo.navcore.speech.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class SpeechDataSegmentItem implements Serializable {
    @SerializedName("name")
    private String mName;
    @SerializedName("pinyin")
    private String mPinyin;

    public String getPinyin() {
        return this.mPinyin;
    }

    public void setPinyin(String str) {
        this.mPinyin = str;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }
}
